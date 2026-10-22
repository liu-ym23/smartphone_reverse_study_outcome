package f1;

import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Li1/b;", "connection", "", Const.INTENT_KEY_APIKEY, "(Li1/b;)J", "", Const.INTENT_KEY_PKGNAME, "(Li1/b;)I", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4038h {
    public static final long a(InterfaceC4160b connection) throws Exception {
        p.i(connection, "connection");
        if (b(connection) == 0) {
            return -1L;
        }
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT last_insert_rowid()");
        try {
            interfaceC4162dQ1.n1();
            long j10 = interfaceC4162dQ1.getLong(0);
            C4946a.a(interfaceC4162dQ1, null);
            return j10;
        } finally {
        }
    }

    public static final int b(InterfaceC4160b connection) throws Exception {
        p.i(connection, "connection");
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT changes()");
        try {
            interfaceC4162dQ1.n1();
            int i10 = (int) interfaceC4162dQ1.getLong(0);
            C4946a.a(interfaceC4162dQ1, null);
            return i10;
        } finally {
        }
    }
}
