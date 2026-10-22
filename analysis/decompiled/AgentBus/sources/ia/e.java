package ia;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4947b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final g0[] f4948a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public e(g0[] g0VarArr) {
        this.f4948a = g0VarArr;
        this.notCompletedCount$volatile = g0VarArr.length;
    }
}
