package b4;

import c5.s;
import java.util.List;
import kotlin.jvm.internal.p;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements k4.h {

    /* renamed from: a, reason: collision with root package name */
    public static final k f881a = new k();

    @Override // k4.h
    public final boolean f(k4.g contentType) {
        p.e(contentType, "contentType");
        if (!contentType.u(k4.d.f3601a)) {
            if (!((List) contentType.f89c).isEmpty()) {
                contentType = new k4.g(contentType.d, contentType.f3612e, s.f1092a);
            }
            String contentType2 = contentType.toString();
            p.e(contentType2, "contentType");
            if (!n.I1(contentType2, "application/", true) || !u.V0(contentType2, "+json", true)) {
                return false;
            }
        }
        return true;
    }
}
