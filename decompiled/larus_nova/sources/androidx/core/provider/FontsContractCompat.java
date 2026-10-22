package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public class FontsContractCompat {
    public static final String PARCEL_FONT_RESULTS = "font_results";
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";

        public Columns() {
        }
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final List<FontInfo[]> mFonts;
        private final int mStatusCode;

        public FontInfo[] getFonts() {
            return (FontInfo[]) ListProtector.get(this.mFonts, 0);
        }

        public boolean hasFallback() {
            if (this.mFonts.size() > 1) goto L7;
            return false;
        L7:
            return true;
        }

        public List<FontInfo[]> getFontsWithFallbacks() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        public FontFamilyResult(int r100, FontInfo[] r101) {
            this.mStatusCode = r100;
            this.mFonts = Collections.singletonList(r101);
        }

        public static FontFamilyResult create(int r100, List<FontInfo[]> r101) {
            return new FontFamilyResult(r100, r101);
        }

        public FontFamilyResult(int r100, List<FontInfo[]> r101) {
            this.mStatusCode = r100;
            this.mFonts = r101;
        }

        public static FontFamilyResult create(int r100, FontInfo[] r101) {
            return new FontFamilyResult(r100, r101);
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        public int getResultCode() {
            return this.mResultCode;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public FontInfo(Uri r100, int r101, int r102, boolean r103, int r104) {
            this.mUri = (Uri) Preconditions.checkNotNull(r100);
            this.mTtcIndex = r101;
            this.mWeight = r102;
            this.mItalic = r103;
            this.mResultCode = r104;
        }

        public static FontInfo create(Uri r100, int r101, int r102, boolean r110, int r111) {
            return new FontInfo(r100, r101, r102, r110, r111);
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public FontRequestCallback() {
        }

        public void onTypefaceRequestFailed(int r100) {
        }

        public void onTypefaceRetrieved(Typeface r100) {
        }
    }

    private FontsContractCompat() {
    }

    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static Typeface buildTypeface(Context r100, CancellationSignal r101, FontInfo[] r102) {
        return TypefaceCompat.createFromFontInfo(r100, r101, r102, 0);
    }

    public static FontFamilyResult fetchFonts(Context r100, CancellationSignal r101, FontRequest r102) throws PackageManager.NameNotFoundException {
        Object[] r103 = {r102};
        ArrayList r104 = new ArrayList(1);
        Object r105 = r103[0];
        Objects.requireNonNull(r105);
        r104.add(r105);
        return FontProvider.getFontFamilyResult(r100, Collections.unmodifiableList(r104), r101);
    }

    public static ProviderInfo getProvider(PackageManager r100, FontRequest r101, Resources r102) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider(r100, r101, r102);
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context r100, FontInfo[] r101, CancellationSignal r102) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(r100, r101, r102);
    }

    public static void requestFont(Context r100, FontRequest r101, FontRequestCallback r102, Handler r103) {
        CallbackWrapper r104 = new CallbackWrapper(r102);
        Executor r105 = RequestExecutor.createHandlerExecutor(r103);
        Context r106 = r100.getApplicationContext();
        Object[] r107 = {r101};
        ArrayList r108 = new ArrayList(1);
        Object r109 = r107[0];
        Objects.requireNonNull(r109);
        r108.add(r109);
        FontRequestWorker.requestFontAsync(r106, Collections.unmodifiableList(r108), 0, r105, r104);
    }

    public static void requestFont(Context r100, FontRequest r101, int r102, Executor r103, Executor r104, FontRequestCallback r105) {
        CallbackWrapper r106 = new CallbackWrapper(r105, r104);
        Context r107 = r100.getApplicationContext();
        Object[] r108 = {r101};
        ArrayList r109 = new ArrayList(1);
        Object r110 = r108[0];
        Objects.requireNonNull(r110);
        r109.add(r110);
        FontRequestWorker.requestFontAsync(r107, Collections.unmodifiableList(r109), r102, r103, r106);
    }

    public static void requestFontWithFallbackChain(Context r100, List<FontRequest> r101, int r102, Executor r103, Executor r104, FontRequestCallback r105) {
        CallbackWrapper r106 = new CallbackWrapper(r105, r104);
        FontRequestWorker.requestFontAsync(r100.getApplicationContext(), r101, r102, r103, r106);
    }

    public static Typeface getFontSync(Context r100, FontRequest r101, ResourcesCompat.FontCallback r102, Handler r110, boolean r111, int r112, int r113) {
        TypefaceCompat.ResourcesCallbackAdapter r103 = new TypefaceCompat.ResourcesCallbackAdapter(r102);
        Handler r104 = ResourcesCompat.FontCallback.getHandler(r110);
        Object[] r114 = {r101};
        ArrayList r105 = new ArrayList(1);
        Object r106 = r114[0];
        Objects.requireNonNull(r106);
        r105.add(r106);
        return requestFont(r100, Collections.unmodifiableList(r105), r113, r111, r112, r104, r103);
    }

    public static Typeface requestFont(Context r100, List<FontRequest> r101, int r102, boolean r103, int r104, Handler r105, FontRequestCallback r106) {
        CallbackWrapper r107 = new CallbackWrapper(r106, RequestExecutor.createHandlerExecutor(r105));
        if (r103 == false) goto L11;
        if (r101.size() > 1) goto L9;
        return FontRequestWorker.requestFontSync(r100, (FontRequest) ListProtector.get(r101, 0), r107, r102, r104);
    L9:
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    L11:
        return FontRequestWorker.requestFontAsync(r100, r101, r102, null, r107);
    }

    public static Typeface requestFont(Context r100, FontRequest r101, int r110, boolean r111, int r112, Handler r113, FontRequestCallback r114) {
        Object[] r102 = {r101};
        ArrayList r103 = new ArrayList(1);
        Object r104 = r102[0];
        Objects.requireNonNull(r104);
        r103.add(r104);
        return requestFont(r100, Collections.unmodifiableList(r103), r110, r111, r112, r113, r114);
    }
}
