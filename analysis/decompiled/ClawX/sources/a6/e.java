package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f151b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final l0[] f152a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public e(l0[] l0VarArr) {
        this.f152a = l0VarArr;
        this.notCompletedCount$volatile = l0VarArr.length;
    }
}
