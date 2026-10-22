package h3;

import n3.InterfaceC4938b;

/* renamed from: h3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C4129e implements InterfaceC4938b {

    /* renamed from: a, reason: collision with root package name */
    public final String f32906a;

    public C4129e(String str) {
        this.f32906a = str;
    }

    public static InterfaceC4938b a(String str) {
        return new C4129e(str);
    }

    @Override // n3.InterfaceC4938b
    public Object get() {
        return C4130f.c(this.f32906a);
    }
}
