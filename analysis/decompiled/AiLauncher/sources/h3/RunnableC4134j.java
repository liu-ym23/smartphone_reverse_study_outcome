package h3;

import n3.InterfaceC4938b;

/* renamed from: h3.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4134j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final v f32912a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4938b f32913b;

    public RunnableC4134j(v vVar, InterfaceC4938b interfaceC4938b) {
        this.f32912a = vVar;
        this.f32913b = interfaceC4938b;
    }

    public static Runnable a(v vVar, InterfaceC4938b interfaceC4938b) {
        return new RunnableC4134j(vVar, interfaceC4938b);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32912a.d(this.f32913b);
    }
}
