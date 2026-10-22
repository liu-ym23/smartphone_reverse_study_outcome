package a8;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f453g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Field field, boolean z4, boolean z10, int i2) {
        super(field, z4, z10);
        this.f453g = i2;
    }

    @Override // a8.r, a8.w
    public void a(Object[] objArr) {
        switch (this.f453g) {
            case 1:
                q7.k.e(objArr, "args");
                super.a(objArr);
                b(d7.n.h0(objArr));
                break;
            default:
                super.a(objArr);
                break;
        }
    }
}
