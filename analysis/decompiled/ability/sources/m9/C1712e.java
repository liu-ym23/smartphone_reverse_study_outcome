package m9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: m9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1712e {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C1712e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1686D[] f5327a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public C1712e(InterfaceC1686D[] interfaceC1686DArr) {
        this.f5327a = interfaceC1686DArr;
        this.notCompletedCount$volatile = interfaceC1686DArr.length;
    }
}
