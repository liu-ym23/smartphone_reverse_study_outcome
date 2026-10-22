package h5;

import android.content.Context;
import com.stepos.openidsdk.IOAIDChangeListener;
import java.lang.invoke.VarHandle;
import n3.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements y4.b, IOAIDChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Context f5362a;

    @Override // y4.b
    public y4.c a(y4.a aVar) {
        Context context = this.f5362a;
        String str = aVar.f15894b;
        r0 r0Var = aVar.f15895c;
        r0Var.getClass();
        if (str == null || str.length() == 0) {
            g5.f.s("Must set a non-null database name to a configuration that uses the no backup directory.");
            return null;
        }
        z4.h hVar = new z4.h();
        hVar.f16402c = context;
        hVar.f16403f = str;
        hVar.f16404g = r0Var;
        hVar.f16405h = true;
        hVar.i = true;
        ab.e eVar = new ab.e(24);
        eVar.f393f = hVar;
        VarHandle.storeStoreFence();
        hVar.f16406j = new jb.k(eVar);
        VarHandle.storeStoreFence();
        return hVar;
    }

    @Override // com.stepos.openidsdk.IOAIDChangeListener
    public void onChanged() {
        kc.w.u(r8.a.f10477d, null, null, new i9.f(this.f5362a, 2, null), 3);
    }
}
