package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.provider.FontRequest;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static int getType(TypedArray r100, int r101) {
            return r100.getType(r101);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] r100) {
            this.mEntries = r100;
        }
    }

    public static final class FontFileResourceEntry {
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public FontFileResourceEntry(String r100, int r101, boolean r102, String r103, int r104, int r105) {
            this.mFileName = r100;
            this.mWeight = r101;
            this.mItalic = r102;
            this.mVariationSettings = r103;
            this.mTtcIndex = r104;
            this.mResourceId = r105;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        private final FontRequest mFallbackRequest;
        private final FontRequest mRequest;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public FontRequest getFallbackRequest() {
            return this.mFallbackRequest;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public FontRequest getRequest() {
            return this.mRequest;
        }

        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }

        public ProviderResourceEntry(FontRequest r100, int r101, int r102) {
            this(r100, null, r101, r102, null);
        }

        public ProviderResourceEntry(FontRequest r100, FontRequest r101, int r102, int r103, String r104) {
            this.mRequest = r100;
            this.mFallbackRequest = r101;
            this.mStrategy = r102;
            this.mTimeoutMs = r103;
            this.mSystemFontFamilyName = r104;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static void skip(XmlPullParser r100) throws XmlPullParserException, IOException {
        int r101 = 1;
    L3:
        if (r101 <= 0) goto L11;
        int r102 = r100.next();
        if (r102 != 2) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        if (r102 != 3) goto L3;
        r101 = r101 - 1;
        goto L3
    }

    private static List<byte[]> toByteArrayList(String[] r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(Base64.decode(r100[r103], 0));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    private static int getType(TypedArray r100, int r101) {
        return Api21Impl.getType(r100, r101);
    }

    public static FamilyResourceEntry parse(XmlPullParser r100, Resources r101) throws XmlPullParserException, IOException {
    L2:
        int r102 = r100.next();
        if (r102 == 2) goto L7;
        if (r102 != 1) goto L2;
    L7:
        if (r102 != 2) goto L11;
        return readFamilies(r100, r101);
    L11:
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources r100, int r101) {
        if (r101 == 0) goto L4;
        TypedArray r102 = r100.obtainTypedArray(r101);
    L23:
        th = move-exception;
        r102.recycle();
        throw th;
    L7:
        if (r102.length() != 0) goto L11;
        List<List<byte[]>> r103 = Collections.emptyList();     // Catch: Throwable -> L23
        r102.recycle();
        return r103;
    L11:
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L23
        if (getType(r102, 0) != 1) goto L20;
        int r105 = 0;
    L15:
        if (r105 >= r102.length()) goto L21;
        int r106 = r102.getResourceId(r105, 0);     // Catch: Throwable -> L23
        if (r106 == 0) goto L19;
        r104.add(toByteArrayList(r100.getStringArray(r106)));     // Catch: Throwable -> L23
    L19:
        r105 = r105 + 1;     // Catch: Throwable -> L23
    L21:
        r102.recycle();
        return r104;
    L20:
        r104.add(toByteArrayList(r100.getStringArray(r101)));     // Catch: Throwable -> L23
        goto L21
    L4:
        return Collections.emptyList();
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser r100, Resources r101) throws XmlPullParserException, IOException {
        r100.require(2, null, GXTemplateKey.STYLE_FONT_FAMILY);
        if (r100.getName().equals(GXTemplateKey.STYLE_FONT_FAMILY) == true) goto L5;
        skip(r100);
        return null;
    L5:
        return readFamily(r100, r101);
    }

    private static FamilyResourceEntry readFamily(XmlPullParser r110, Resources r111) throws XmlPullParserException, IOException {
        TypedArray r100 = r111.obtainAttributes(Xml.asAttributeSet(r110), new int[]{R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFallbackQuery, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery, R.attr.fontProviderSystemFontFamily});
        String r101 = r100.getString(0);
        String r102 = r100.getString(5);
        String r103 = r100.getString(6);
        String r104 = r100.getString(2);
        int r105 = r100.getResourceId(1, 0);
        int r112 = r100.getInteger(3, 1);
        int r113 = r100.getInteger(4, 500);
        String r114 = r100.getString(7);
        r100.recycle();
        FontRequest r106 = null;
        if (r101 == null) goto L14;
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
    L7:
        if (r110.next() == 3) goto L9;
        skip(r110);
        goto L7
    L9:
        List<List<byte[]>> r107 = readCerts(r111, r105);
        if (r104 == null) goto L12;
        r106 = new FontRequest(r101, r102, r104, r107);
    L12:
        FontRequest r115 = new FontRequest(r101, r102, r103, r107);
        return new ProviderResourceEntry(r115, r106, r112, r113, r114);
    L14:
        ArrayList r108 = new ArrayList();
    L16:
        if (r110.next() == 3) goto L25;
        if (r110.getEventType() != 2) goto L16;
        if (r110.getName().equals(LynxResourceModule.FONT_TYPE) == true) goto L22;
        skip(r110);
        goto L16
    L22:
        r108.add(readFont(r110, r111));
        goto L16
    L25:
        if (r108.isEmpty() == false) goto L28;
        return null;
    L28:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) r108.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r110, Resources r111) throws XmlPullParserException, IOException {
        TypedArray r112 = r111.obtainAttributes(Xml.asAttributeSet(r110), new int[]{android.R.attr.font, android.R.attr.fontWeight, android.R.attr.fontStyle, android.R.attr.ttcIndex, android.R.attr.fontVariationSettings, R.attr.font, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.fontWeight, R.attr.ttcIndex});
        int r100 = 8;
        if (r112.hasValue(8) == true) goto L6;
        r100 = 1;
    L6:
        int r101 = r112.getInt(r100, 400);
        int r102 = 6;
        if (r112.hasValue(6) == true) goto L11;
        r102 = 2;
    L11:
        if (1 != r112.getInt(r102, 0)) goto L13;
        boolean r103 = true;
    L14:
        int r104 = 9;
        if (r112.hasValue(9) == true) goto L18;
        r104 = 3;
    L18:
        int r105 = 7;
        if (r112.hasValue(7) == true) goto L22;
        r105 = 4;
    L22:
        String r106 = r112.getString(r105);
        int r107 = r112.getInt(r104, 0);
        int r108 = 5;
        if (r112.hasValue(5) == true) goto L26;
        r108 = 0;
    L26:
        int r109 = r112.getResourceId(r108, 0);
        String r113 = r112.getString(r108);
        r112.recycle();
    L28:
        if (r110.next() == 3) goto L31;
        skip(r110);
        goto L28
    L31:
        return new FontFileResourceEntry(r113, r101, r103, r106, r107, r109);
    L13:
        r103 = false;
        goto L14
    }
}
