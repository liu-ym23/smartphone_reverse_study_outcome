package r3;

import java.util.concurrent.Executor;
import n3.InterfaceC4938b;

/* renamed from: r3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5210d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4938b f38762a;

    public C5210d(InterfaceC4938b interfaceC4938b) {
        this.f38762a = interfaceC4938b;
    }

    public Executor a(Executor executor) {
        return executor != null ? executor : (Executor) this.f38762a.get();
    }
}
