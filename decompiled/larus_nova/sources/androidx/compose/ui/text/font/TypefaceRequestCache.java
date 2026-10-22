package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.platform.SynchronizedObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\n2\u001e\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u000b0\u0010J(\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0010J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "<init>", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "runCached", "Landroidx/compose/runtime/State;", "typefaceRequest", "resolveTypeface", "Lkotlin/Function1;", "", "preWarmCache", "typefaceRequests", "", MonitorConstants.CONNECT_TYPE_GET, "get$ui_text", "size", "", "getSize$ui_text", "()I", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TypefaceRequestCache {
    public static final int $stable = 8;
    private final SynchronizedObject lock;
    private final LruCache<TypefaceRequest, TypefaceResult> resultCache;

    public static /* synthetic */ Unit a(TypefaceRequestCache r100, TypefaceRequest r101, TypefaceResult r102) {
        return runCached$lambda$3(r100, r101, r102);
    }

    public final int getSize$ui_text() {
        SynchronizedObject r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.resultCache.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public TypefaceRequestCache() {
        this.lock = new SynchronizedObject();
        this.resultCache = new LruCache(16);
    }

    public final SynchronizedObject getLock$ui_text() {
        return this.lock;
    }

    public final TypefaceResult get$ui_text(TypefaceRequest r100) {
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        TypefaceResult r102 = this.resultCache.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final void preWarmCache(List<TypefaceRequest> r100, Function1<? super TypefaceRequest, ? extends TypefaceResult> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L27;
        TypefaceRequest r104 = (TypefaceRequest) ListProtector.get(r100, r103);
        SynchronizedObject r105 = this.lock;
        monitor-enter(r105);
        TypefaceResult r106 = this.resultCache.get(r104);     // Catch: Throwable -> L24
        monitor-exit(r105);
        if (r106 != null) goto L23;
        TypefaceResult r107 = r101.invoke(r104);     // Catch: Exception -> L20
        if ((r107 instanceof TypefaceResult.Async) == true) goto L23;
        SynchronizedObject r108 = this.lock;
        monitor-enter(r108);
        TypefaceResult r109 = this.resultCache.put(r104, r107);     // Catch: Throwable -> L17
        monitor-exit(r108);
    L17:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        throw new IllegalStateException("Could not load font", e);
    L23:
        r103 = r103 + 1;
    L24:
        th = move-exception;
        throw th;
    }

    public final State<Object> runCached(final TypefaceRequest r100, Function1<? super Function1<? super TypefaceResult, Unit>, ? extends TypefaceResult> r101) {
        SynchronizedObject r102 = this.lock;
        monitor-enter(r102);
        TypefaceResult r103 = this.resultCache.get(r100);     // Catch: Throwable -> L29
        if (r103 != null) goto L7;
    L11:
        monitor-exit(r102);
        TypefaceResult r104 = r101.invoke(new h(this, r100));     // Catch: Exception -> L26
        SynchronizedObject r105 = this.lock;
        monitor-enter(r105);
    L23:
        th = move-exception;
        throw th;
    L16:
        if (this.resultCache.get(r100) == null) goto L18;
    L20:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r105);
        return r104;
    L18:
        if (r104.getCacheable() == false) goto L20;
        this.resultCache.put(r100, r104);     // Catch: Throwable -> L23
    L26:
        e = move-exception;
        throw new IllegalStateException("Could not load font", e);
    L7:
        if (r103.getCacheable() == false) goto L10;
        monitor-exit(r102);
        return r103;
    L10:
        TypefaceResult r107 = this.resultCache.remove(r100);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    private static final Unit runCached$lambda$3(TypefaceRequestCache r100, TypefaceRequest r101, TypefaceResult r102) {
        SynchronizedObject r103 = r100.lock;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r102.getCacheable() == false) goto L7;
        TypefaceResult r104 = r100.resultCache.put(r101, r102);     // Catch: Throwable -> L11
    L8:
        monitor-exit(r103);
        return Unit.INSTANCE;
    L7:
        TypefaceResult r105 = r100.resultCache.remove(r101);     // Catch: Throwable -> L11
        goto L8
    }
}
