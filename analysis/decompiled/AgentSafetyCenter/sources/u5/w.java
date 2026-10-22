package u5;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final long f14105a = o2.b.g(0, 0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final f6.e f14106b;

    static {
        f6.g gVar = f6.g.f3926c;
        f6.e eVar = new f6.e();
        VarHandle.storeStoreFence();
        f14106b = eVar;
    }

    public static final e6.i a(Object obj, k0.s sVar) {
        sVar.Y(1087186730);
        if (obj instanceof e6.i) {
            e6.i iVar = (e6.i) obj;
            sVar.q(false);
            return iVar;
        }
        Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
        sVar.Y(-1245195153);
        boolean zF = sVar.f(context) | sVar.f(obj);
        Object objM = sVar.M();
        if (zF || objM == k0.m.f6974a) {
            e6.h hVar = new e6.h(context);
            hVar.f3532c = obj;
            objM = hVar.a();
            sVar.i0(objM);
        }
        e6.i iVar2 = (e6.i) objM;
        sVar.q(false);
        sVar.q(false);
        return iVar2;
    }
}
