package com.stepos.motionkit.fx.backend;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3846a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f3846a = i;
        this.b = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3846a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return AgslRenderer.session$lambda$1((AgslRenderer) obj2, (Throwable) obj);
            case 1:
                return GlesRenderer.session$lambda$1((GlesRenderer) obj2, (Throwable) obj);
            default:
                return VulkanRenderer.session$lambda$0((VulkanRenderer) obj2, (Throwable) obj);
        }
    }
}
