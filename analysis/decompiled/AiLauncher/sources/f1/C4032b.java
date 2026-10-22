package f1;

import La.D;
import Y8.t;
import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Li1/b;", "connection", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/DBUtil")
/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C4032b {
    public static final void a(InterfaceC4160b connection) {
        p.i(connection, "connection");
        List listC = C1172u.c();
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (interfaceC4162dQ1.n1()) {
            try {
                listC.add(interfaceC4162dQ1.X0(0));
            } finally {
            }
        }
        t tVar = t.f7040a;
        C4946a.a(interfaceC4162dQ1, null);
        for (String str : C1172u.a(listC)) {
            if (D.X(str, "room_fts_content_sync_", false, 2, null)) {
                C4159a.a(connection, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
