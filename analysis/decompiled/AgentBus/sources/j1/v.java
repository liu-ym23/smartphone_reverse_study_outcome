package j1;

import android.view.View;

/* loaded from: classes.dex */
public final class v extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5338g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5339h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(int i2, int i10) {
        super(1);
        this.f5338g = i10;
        this.f5339h = i2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f5338g) {
            case 0:
                return Boolean.valueOf(((s0.q) obj).p0(this.f5339h));
            default:
                return Boolean.valueOf(((View) obj).getId() == this.f5339h);
        }
    }
}
