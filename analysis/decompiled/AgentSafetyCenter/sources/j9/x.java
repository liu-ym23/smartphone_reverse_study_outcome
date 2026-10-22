package j9;

import java.util.ArrayList;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6729c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ yb.u f6730f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f6731g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f6729c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                yb.u uVar = this.f6730f;
                c1 c1Var = this.f6731g;
                String str = (String) obj;
                if (!yb.k.a(str, uVar.f16098c)) {
                    uVar.f16098c = str;
                    ArrayList arrayList = b0.f6645n;
                    ((xb.l) c1Var.getValue()).invoke(str);
                    break;
                }
                break;
            default:
                yb.u uVar2 = this.f6730f;
                c1 c1Var2 = this.f6731g;
                String str2 = (String) obj;
                if (!yb.k.a(str2, uVar2.f16098c)) {
                    uVar2.f16098c = str2;
                    ArrayList arrayList2 = b0.f6645n;
                    ((xb.l) c1Var2.getValue()).invoke(str2);
                    break;
                }
                break;
        }
        return vVar;
    }
}
