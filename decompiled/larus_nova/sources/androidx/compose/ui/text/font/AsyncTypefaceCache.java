package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\b\u0018JH\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u001e\u0010\u001a\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0086@¢\u0006\u0002\u0010\u001dJ+\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0086\bR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "", "<init>", "()V", "PermanentFailure", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "Ljava/lang/Object;", "resultCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "permanentCache", "Landroidx/collection/MutableScatterMap;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "put", "", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "result", "forever", "", MonitorConstants.CONNECT_TYPE_GET, "get-1ASDuI8", "runCached", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCachedBlocking", "Lkotlin/Function0;", "AsyncTypefaceResult", "Key", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AsyncTypefaceCache {
    public static final int $stable = 8;
    private final Object PermanentFailure;
    private final SynchronizedObject cacheLock;
    private final MutableScatterMap<Key, AsyncTypefaceResult> permanentCache;
    private final LruCache<Key, AsyncTypefaceResult> resultCache;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "isPermanentFailure", "", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "equals", "other", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class AsyncTypefaceResult {
        private final Object result;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m7066boximpl(Object r100) {
            return new AsyncTypefaceResult(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static Object m7067constructorimpl(Object r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7068equalsimpl(Object r100, Object r101) {
            if ((r101 instanceof AsyncTypefaceResult) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(r100, ((AsyncTypefaceResult) r101).m7073unboximpl()) == true) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7069equalsimpl0(Object r100, Object r101) {
            return Intrinsics.areEqual(r100, r101);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7070hashCodeimpl(Object r100) {
            if (r100 != null) goto L5;
            return 0;
        L5:
            return r100.hashCode();
        }

        /* JADX INFO: renamed from: isPermanentFailure-impl, reason: not valid java name */
        public static final boolean m7071isPermanentFailureimpl(Object r100) {
            if (r100 != null) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7072toStringimpl(Object r100) {
            return "AsyncTypefaceResult(result=" + r100 + ')';
        }

        public boolean equals(Object r100) {
            return m7068equalsimpl(this.result, r100);
        }

        public int hashCode() {
            return m7070hashCodeimpl(this.result);
        }

        public String toString() {
            return m7072toStringimpl(this.result);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ Object m7073unboximpl() {
            return this.result;
        }

        public final Object getResult() {
            return this.result;
        }

        private /* synthetic */ AsyncTypefaceResult(Object r100) {
            this.result = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "loaderKey", "<init>", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", "getFont", "()Landroidx/compose/ui/text/font/Font;", "getLoaderKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key {
        public static final int $stable = 8;
        private final Font font;
        private final Object loaderKey;

        public static /* synthetic */ Key copy$default(Key r100, Font r101, Object r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.font;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.loaderKey;
        L9:
            return r100.copy(r101, r102);
        }

        public final Font component1() {
            return this.font;
        }

        public final Object component2() {
            return this.loaderKey;
        }

        public final Key copy(Font r100, Object r101) {
            return new Key(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Key) == true) goto L8;
            return false;
        L8:
            Key r101 = (Key) r100;
            if (Intrinsics.areEqual(this.font, r101.font) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.loaderKey, r101.loaderKey) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.font.hashCode() * 31;
            Object r101 = this.loaderKey;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }

        public final Font getFont() {
            return this.font;
        }

        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public Key(Font r100, Object r101) {
            this.font = r100;
            this.loaderKey = r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AsyncTypefaceCache", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0}, l = {412}, m = "runCached", n = {"key", "forever"}, s = {"L$0", "Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AsyncTypefaceCache this$0;

        public AnonymousClass1(AsyncTypefaceCache r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runCached(null, null, false, null, this);
        }
    }

    public AsyncTypefaceCache() {
        this.PermanentFailure = AsyncTypefaceResult.m7067constructorimpl(null);
        this.resultCache = new LruCache(16);
        this.permanentCache = ScatterMapKt.mutableScatterMapOf();
        this.cacheLock = new SynchronizedObject();
    }

    public static final /* synthetic */ SynchronizedObject access$getCacheLock$p(AsyncTypefaceCache r100) {
        return r100.cacheLock;
    }

    public static final /* synthetic */ MutableScatterMap access$getPermanentCache$p(AsyncTypefaceCache r100) {
        return r100.permanentCache;
    }

    public static final /* synthetic */ LruCache access$getResultCache$p(AsyncTypefaceCache r100) {
        return r100.resultCache;
    }

    /* JADX INFO: renamed from: get-1ASDuI8, reason: not valid java name */
    public final AsyncTypefaceResult m7065get1ASDuI8(Font r100, PlatformFontLoader r101) {
        Key r102 = new Key(r100, r101.getCacheKey());
        SynchronizedObject r103 = this.cacheLock;
        monitor-enter(r103);
        AsyncTypefaceResult r104 = this.resultCache.get(r102);     // Catch: Throwable -> L9
        if (r104 != null) goto L7;
        r104 = this.permanentCache.get(r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);
        return r104;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object runCachedBlocking(Font r110, PlatformFontLoader r111, Function0<? extends Object> r112) {
        SynchronizedObject r100 = access$getCacheLock$p(this);
        monitor-enter(r100);
        Key r101 = new Key(r110, r111.getCacheKey());     // Catch: Throwable -> L19
        AsyncTypefaceResult r102 = (AsyncTypefaceResult) access$getResultCache$p(this).get(r101);     // Catch: Throwable -> L19
        if (r102 != null) goto L8;
        r102 = (AsyncTypefaceResult) access$getPermanentCache$p(this).get(r101);     // Catch: Throwable -> L19
    L8:
        if (r102 == null) goto L14;
        Object r113 = r102.m7073unboximpl();     // Catch: Throwable -> L19
        InlineMarker.finallyStart(2);
        monitor-exit(r100);
        InlineMarker.finallyEnd(2);
        return r113;
    L14:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L19
        InlineMarker.finallyStart(1);
        monitor-exit(r100);
        InlineMarker.finallyEnd(1);
        Object r114 = r112.invoke();
        put$default(this, r110, r111, r114, false, 8, null);
        return r114;
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void put(Font r100, PlatformFontLoader r101, Object r102, boolean r103) {
        Key r104 = new Key(r100, r101.getCacheKey());
        SynchronizedObject r105 = this.cacheLock;
        monitor-enter(r105);
        if (r102 != null) goto L8;
        this.permanentCache.set(r104, AsyncTypefaceResult.m7066boximpl(this.PermanentFailure));     // Catch: Throwable -> L6
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L6
    L11:
        monitor-exit(r105);
        return;
    L8:
        if (r103 == false) goto L10;
        this.permanentCache.set(r104, AsyncTypefaceResult.m7066boximpl(AsyncTypefaceResult.m7067constructorimpl(r102)));     // Catch: Throwable -> L6
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L6
        goto L11
    L10:
        this.resultCache.put(r104, AsyncTypefaceResult.m7066boximpl(AsyncTypefaceResult.m7067constructorimpl(r102)));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final Object runCached(Font r100, PlatformFontLoader r101, boolean r102, Function1<? super Continuation<Object>, ? extends Object> r103, Continuation<Object> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r104 = (AnonymousClass1) r110;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r111 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r102 = r104.Z$0;
        Key r108 = (Key) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L29:
        SynchronizedObject r109 = this.cacheLock;
        monitor-enter(r109);
        if (r111 != null) goto L35;
        this.permanentCache.set(r108, AsyncTypefaceResult.m7066boximpl(this.PermanentFailure));     // Catch: Throwable -> L33
    L38:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r109);
        return r111;
    L35:
        if (r102 == false) goto L37;
        this.permanentCache.set(r108, AsyncTypefaceResult.m7066boximpl(AsyncTypefaceResult.m7067constructorimpl(r111)));     // Catch: Throwable -> L33
        goto L38
    L37:
        this.resultCache.put(r108, AsyncTypefaceResult.m7066boximpl(AsyncTypefaceResult.m7067constructorimpl(r111)));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Key r113 = new Key(r100, r101.getCacheKey());
        SynchronizedObject r114 = this.cacheLock;
        monitor-enter(r114);
        AsyncTypefaceResult r115 = this.resultCache.get(r113);     // Catch: Throwable -> L43
        if (r115 != null) goto L19;
        r115 = this.permanentCache.get(r113);     // Catch: Throwable -> L43
    L19:
        if (r115 == null) goto L23;
        Object r116 = r115.m7073unboximpl();     // Catch: Throwable -> L43
        monitor-exit(r114);
        return r116;
    L23:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r114);
        r104.L$0 = r113;
        r104.Z$0 = r102;
        r104.label = 1;
        Object r118 = r103.invoke(r104);
        if (r118 != r106) goto L28;
        return r106;
    L28:
        r111 = r118;
        r108 = r113;
    L43:
        th = move-exception;
        throw th;
    L7:
        r104 = new AnonymousClass1(this, r110);
        goto L8
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache r100, Font r101, PlatformFontLoader r102, Object r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = false;
    L5:
        r100.put(r101, r102, r103, r104);
    }
}
