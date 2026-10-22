package h3;

import n3.InterfaceC4937a;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public class v<T> implements InterfaceC4938b<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC4937a<Object> f32947c = t.b();

    /* renamed from: d, reason: collision with root package name */
    public static final InterfaceC4938b<Object> f32948d = u.a();

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC4937a<T> f32949a;

    /* renamed from: b, reason: collision with root package name */
    public volatile InterfaceC4938b<T> f32950b;

    public v(InterfaceC4937a<T> interfaceC4937a, InterfaceC4938b<T> interfaceC4938b) {
        this.f32949a = interfaceC4937a;
        this.f32950b = interfaceC4938b;
    }

    public static <T> v<T> a() {
        return new v<>(f32947c, f32948d);
    }

    public static /* synthetic */ void b(InterfaceC4938b interfaceC4938b) {
    }

    public static /* synthetic */ Object c() {
        return null;
    }

    public void d(InterfaceC4938b<T> interfaceC4938b) {
        InterfaceC4937a<T> interfaceC4937a;
        if (this.f32950b != f32948d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC4937a = this.f32949a;
            this.f32949a = null;
            this.f32950b = interfaceC4938b;
        }
        interfaceC4937a.a(interfaceC4938b);
    }

    @Override // n3.InterfaceC4938b
    public T get() {
        return this.f32950b.get();
    }
}
