package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes6.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = null;

    /* JADX INFO: loaded from: classes17.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin != 0) goto L6;
            this.mRetryOrigin = SystemClock.uptimeMillis();
            return 0;
        L6:
            long r100 = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (r100 <= this.mTotalMs) goto L11;
            return -1;
        L11:
            return Math.min(Math.max(r100, 1000), this.mTotalMs - r100);
        }

        public ExponentialBackoffRetryPolicy(long r100) {
            this.mTotalMs = r100;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class FontProviderHelper {
        public FontProviderHelper() {
        }

        public Typeface buildTypeface(Context r100, FontsContractCompat.FontInfo r101) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(r100, null, new FontsContractCompat.FontInfo[]{r101});
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context r100, FontRequest r101) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(r100, null, r101);
        }

        public void unregisterObserver(Context r100, ContentObserver r101) {
            r100.getContentResolver().unregisterContentObserver(r101);
        }

        public void registerObserver(Context r100, Uri r101, ContentObserver r102) {
            r100.getContentResolver().registerContentObserver(r101, false, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock;
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        private void cleanUp() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            this.mCallback = null;     // Catch: Throwable -> L17
            ContentObserver r101 = this.mObserver;     // Catch: Throwable -> L17
            if (r101 == null) goto L8;
            this.mFontProviderHelper.unregisterObserver(this.mContext, r101);     // Catch: Throwable -> L17
            this.mObserver = null;     // Catch: Throwable -> L17
        L8:
            Handler r102 = this.mMainHandler;     // Catch: Throwable -> L17
            if (r102 == null) goto L11;
            r102.removeCallbacks(this.mMainHandlerLoadCallback);     // Catch: Throwable -> L17
        L11:
            this.mMainHandler = null;     // Catch: Throwable -> L17
            ThreadPoolExecutor r103 = this.mMyThreadPoolExecutor;     // Catch: Throwable -> L17
            if (r103 == null) goto L14;
            r103.shutdown();     // Catch: Throwable -> L17
        L14:
            this.mExecutor = null;     // Catch: Throwable -> L17
            this.mMyThreadPoolExecutor = null;     // Catch: Throwable -> L17
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontsContractCompat.FontFamilyResult r100 = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r100.getStatusCode() != 0) goto L14;
            FontsContractCompat.FontInfo[] r101 = r100.getFonts();
            if (r101 == null) goto L12;
            if (r101.length == 0) goto L12;
            return r101[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r100.getStatusCode() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        public void createMetadata() {
            Object r100 = this.mLock;
            monitor-enter(r100);
        L60:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L60
            return;
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L60
            FontsContractCompat.FontInfo r101 = retrieveFontInfo();     // Catch: Throwable -> L48
            int r102 = r101.getResultCode();     // Catch: Throwable -> L48
            if (r102 != 2) goto L25;
            Object r103 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r103);     // Catch: Throwable -> L48
            RetryPolicy r104 = this.mRetryPolicy;     // Catch: Throwable -> L22
            if (r104 == null) goto L20;
            long r105 = r104.getRetryDelay();     // Catch: Throwable -> L22
            if (r105 < 0) goto L20;
            scheduleRetry(r101.getUri(), r105);     // Catch: Throwable -> L22
            monitor-exit(r103);     // Catch: Throwable -> L22
            return;
        L20:
            monitor-exit(r103);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L25:
            if (r102 != 0) goto L47;
            TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);     // Catch: Throwable -> L43
            Typeface r106 = this.mFontProviderHelper.buildTypeface(this.mContext, r101);     // Catch: Throwable -> L43
            ByteBuffer r107 = TypefaceCompatUtil.mmap(this.mContext, null, r101.getUri());     // Catch: Throwable -> L43
            if (r107 == null) goto L42;
            if (r106 == null) goto L42;
            MetadataRepo r108 = MetadataRepo.create(r106, r107);     // Catch: Throwable -> L43
            TraceCompat.endSection();     // Catch: Throwable -> L48
            Object r109 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r109);     // Catch: Throwable -> L48
            EmojiCompat.MetadataRepoLoaderCallback r110 = this.mCallback;     // Catch: Throwable -> L38
            if (r110 == null) goto L35;
            r110.onLoaded(r108);     // Catch: Throwable -> L38
        L35:
            monitor-exit(r109);     // Catch: Throwable -> L38
            cleanUp();     // Catch: Throwable -> L48
            return;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L42:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            TraceCompat.endSection();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L47:
            throw new RuntimeException("fetchFonts result is not OK. (" + r102 + ")");     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            monitor-enter(this.mLock);
            EmojiCompat.MetadataRepoLoaderCallback r111 = this.mCallback;     // Catch: Throwable -> L57
            if (r111 == null) goto L54;
            r111.onFailed(th);     // Catch: Throwable -> L57
        L54:
            cleanUp();
            return;
        L57:
            th = move-exception;
            throw th;
        }

        public void loadInternal() {
            Object r100 = this.mLock;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L9;
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L9:
            if (this.mExecutor != null) goto L11;
            ThreadPoolExecutor r101 = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");     // Catch: Throwable -> L14
            this.mMyThreadPoolExecutor = r101;     // Catch: Throwable -> L14
            this.mExecutor = r101;     // Catch: Throwable -> L14
        L11:
            this.mExecutor.execute(new d(this));     // Catch: Throwable -> L14
            monitor-exit(r100);     // Catch: Throwable -> L14
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback r100) {
            Preconditions.checkNotNull(r100, "LoaderCallback cannot be null");
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mCallback = r100;     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            loadInternal();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void setExecutor(Executor r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mExecutor = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setRetryPolicy(RetryPolicy r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mRetryPolicy = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void scheduleRetry(Uri r100, long r101) {
            Object r102 = this.mLock;
            monitor-enter(r102);
            final Handler r103 = this.mMainHandler;     // Catch: Throwable -> L16
            if (r103 != null) goto L8;
            r103 = ConcurrencyHelpers.mainHandlerAsync();     // Catch: Throwable -> L16
            this.mMainHandler = r103;     // Catch: Throwable -> L16
        L8:
            if (this.mObserver != null) goto L11;
            ContentObserver r104 = new AnonymousClass1(this, r103);     // Catch: Throwable -> L16
            this.mObserver = r104;     // Catch: Throwable -> L16
            this.mFontProviderHelper.registerObserver(this.mContext, r100, r104);     // Catch: Throwable -> L16
        L11:
            if (this.mMainHandlerLoadCallback != null) goto L13;
            this.mMainHandlerLoadCallback = new e(this);     // Catch: Throwable -> L16
        L13:
            r103.postDelayed(this.mMainHandlerLoadCallback, r101);     // Catch: Throwable -> L16
            monitor-exit(r102);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public FontRequestMetadataLoader(Context r100, FontRequest r101, FontProviderHelper r102) {
            this.mLock = new Object();
            Preconditions.checkNotNull(r100, "Context cannot be null");
            Preconditions.checkNotNull(r101, "FontRequest cannot be null");
            this.mContext = r100.getApplicationContext();
            this.mRequest = r101;
            this.mFontProviderHelper = r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class RetryPolicy {
        public RetryPolicy() {
        }

        public abstract long getRetryDelay();
    }

    static {
        DEFAULT_FONTS_CONTRACT = new FontProviderHelper();
    }

    public FontRequestEmojiCompatConfig setHandler(Handler r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(r100));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor r100) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(r100);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy r100) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(r100);
        return this;
    }

    public FontRequestEmojiCompatConfig(Context r100, FontRequest r101) {
        super(new FontRequestMetadataLoader(r100, r101, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context r100, FontRequest r101, FontProviderHelper r102) {
        super(new FontRequestMetadataLoader(r100, r101, r102));
    }
}
