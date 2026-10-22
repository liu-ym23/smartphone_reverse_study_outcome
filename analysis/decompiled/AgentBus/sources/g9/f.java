package g9;

import i8.r0;
import v9.v;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final f f3934h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f3935i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f3936j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f3937k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3938g;

    static {
        int i2 = 1;
        f3934h = new f(i2, 0);
        f3935i = new f(i2, 1);
        f3936j = new f(i2, 2);
        f3937k = new f(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i2, int i10) {
        super(i2);
        this.f3938g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f3938g) {
            case 0:
                return "";
            case 1:
                v vVar = (v) obj;
                q7.k.e(vVar, "it");
                return vVar;
            case 2:
                q7.k.e((r0) obj, "it");
                return "...";
            default:
                v vVar2 = (v) obj;
                q7.k.e(vVar2, "it");
                return vVar2;
        }
    }
}
