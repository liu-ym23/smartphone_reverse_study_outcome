package e6;

import androidx.emoji2.text.r;
import kotlin.jvm.internal.d0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final r f2386a = new r("NULL", 1);

    public static final Object a(f5.h hVar, Object obj, Object obj2, p pVar, f5.c frame) {
        Object objInvoke;
        Object objN = f6.a.n(hVar, obj2);
        try {
            n nVar = new n(frame, hVar);
            if (pVar == null) {
                objInvoke = b8.h.R(pVar, obj, nVar);
            } else {
                d0.a(2, pVar);
                objInvoke = pVar.invoke(obj, nVar);
            }
            f6.a.g(hVar, objN);
            if (objInvoke == g5.a.f2984a) {
                kotlin.jvm.internal.p.e(frame, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            f6.a.g(hVar, objN);
            throw th;
        }
    }
}
