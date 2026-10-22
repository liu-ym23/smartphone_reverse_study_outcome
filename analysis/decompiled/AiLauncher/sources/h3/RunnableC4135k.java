package h3;

import n3.InterfaceC4938b;

/* renamed from: h3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4135k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final s f32914a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4938b f32915b;

    public RunnableC4135k(s sVar, InterfaceC4938b interfaceC4938b) {
        this.f32914a = sVar;
        this.f32915b = interfaceC4938b;
    }

    public static Runnable a(s sVar, InterfaceC4938b interfaceC4938b) {
        return new RunnableC4135k(sVar, interfaceC4938b);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32914a.a(this.f32915b);
    }
}
