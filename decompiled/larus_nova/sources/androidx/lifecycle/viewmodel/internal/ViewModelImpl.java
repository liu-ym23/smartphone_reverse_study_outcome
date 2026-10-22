package androidx.lifecycle.viewmodel.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B%\b\u0016\u0012\u001a\u0010\u0007\u001a\u000e\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\u000bB-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0007\u001a\u000e\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\n\u0010\u0019\u001a\u00060\tj\u0002`\nJ\u0012\u0010\u0017\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\tj\u0002`\nJ#\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\f\b\u0000\u0010\u001b*\u00060\tj\u0002`\n2\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\tj\u0002`\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "", "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "closeables", "", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "([Ljava/lang/AutoCloseable;)V", "(Lkotlinx/coroutines/CoroutineScope;[Ljava/lang/AutoCloseable;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "keyToCloseables", "", "", "", "isCleared", "", "clear", "", "addCloseable", "key", "closeable", "getCloseable", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "closeWithRuntimeException", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelImpl {
    private final Set<AutoCloseable> closeables;
    private volatile boolean isCleared;
    private final Map<String, AutoCloseable> keyToCloseables;
    private final SynchronizedObject lock;

    public final void clear() {
        if (this.isCleared == false) goto L5;
        return;
    L5:
        this.isCleared = true;
        SynchronizedObject r100 = this.lock;
        monitor-enter(r100);
        Iterator r101 = access$getKeyToCloseables$p(this).values().iterator();     // Catch: Throwable -> L18
    L9:
        if (r101.hasNext() == false) goto L11;
        access$closeWithRuntimeException(this, (AutoCloseable) r101.next());     // Catch: Throwable -> L18
        goto L9
    L11:
        Iterator r102 = access$getCloseables$p(this).iterator();     // Catch: Throwable -> L18
    L13:
        if (r102.hasNext() == false) goto L15;
        access$closeWithRuntimeException(this, (AutoCloseable) r102.next());     // Catch: Throwable -> L18
        goto L13
    L15:
        access$getCloseables$p(this).clear();     // Catch: Throwable -> L18
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public ViewModelImpl() {
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }

    public ViewModelImpl(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModelScope");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(r100));
    }

    public static final /* synthetic */ Set access$getCloseables$p(ViewModelImpl r100) {
        return r100.closeables;
    }

    public static final /* synthetic */ Map access$getKeyToCloseables$p(ViewModelImpl r100) {
        return r100.keyToCloseables;
    }

    private final void closeWithRuntimeException(AutoCloseable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final void addCloseable(AutoCloseable r100) {
        Intrinsics.checkNotNullParameter(r100, "closeable");
        if (this.isCleared == false) goto L6;
        closeWithRuntimeException(r100);
        return;
    L6:
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        access$getCloseables$p(this).add(r100);     // Catch: Throwable -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final <T extends AutoCloseable> T getCloseable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        T r102 = (T) access$getKeyToCloseables$p(this).get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public ViewModelImpl(AutoCloseable... r100) {
        Intrinsics.checkNotNullParameter(r100, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet r101 = new LinkedHashSet();
        this.closeables = r101;
        CollectionsKt.addAll(r101, r100);
    }

    public ViewModelImpl(CoroutineScope r100, AutoCloseable... r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModelScope");
        Intrinsics.checkNotNullParameter(r101, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet r102 = new LinkedHashSet();
        this.closeables = r102;
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(r100));
        CollectionsKt.addAll(r102, r101);
    }

    public static final /* synthetic */ void access$closeWithRuntimeException(ViewModelImpl r100, AutoCloseable r101) {
        r100.closeWithRuntimeException(r101);
    }

    public final void addCloseable(String r100, AutoCloseable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "closeable");
        if (this.isCleared == false) goto L6;
        closeWithRuntimeException(r101);
        return;
    L6:
        SynchronizedObject r102 = this.lock;
        monitor-enter(r102);
        AutoCloseable r103 = (AutoCloseable) access$getKeyToCloseables$p(this).put(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(r102);
        closeWithRuntimeException(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
