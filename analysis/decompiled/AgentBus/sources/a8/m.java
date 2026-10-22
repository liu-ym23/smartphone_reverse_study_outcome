package a8;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class m extends n {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f451e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Field field, boolean z4, int i2) {
        super(field, z4);
        this.f451e = i2;
    }

    @Override // a8.w
    public void a(Object[] objArr) {
        switch (this.f451e) {
            case 1:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                b(d7.n.h0(objArr));
                break;
            default:
                super.a(objArr);
                break;
        }
    }
}
