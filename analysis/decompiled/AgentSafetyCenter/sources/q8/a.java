package q8;

import com.stepos.agentsafetycenter.data.local.AppDatabase_Impl;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10106c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ AppDatabase_Impl f10107f;

    @Override // xb.a
    public final Object invoke() {
        int i = this.f10106c;
        AppDatabase_Impl appDatabase_Impl = this.f10107f;
        switch (i) {
            case 0:
                h hVar = new h();
                hVar.f10119a = appDatabase_Impl;
                hVar.f10120b = new g(0);
                VarHandle.storeStoreFence();
                return hVar;
            default:
                v vVar = new v();
                vVar.f10190a = appDatabase_Impl;
                vVar.f10191b = new g(1);
                VarHandle.storeStoreFence();
                return vVar;
        }
    }
}
