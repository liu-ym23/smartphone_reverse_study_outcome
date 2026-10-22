package i1;

import android.database.SQLException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Li1/b;", "", "sql", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/b;Ljava/lang/String;)V", "", "errorCode", C3081a.ERROR_MSG, "", Const.INTENT_KEY_PKGNAME, "(ILjava/lang/String;)Ljava/lang/Void;", "sqlite"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: i1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4159a {
    public static final void a(InterfaceC4160b interfaceC4160b, String sql) {
        p.i(interfaceC4160b, "<this>");
        p.i(sql, "sql");
        InterfaceC4162d interfaceC4162dQ1 = interfaceC4160b.q1(sql);
        try {
            interfaceC4162dQ1.n1();
            C4946a.a(interfaceC4162dQ1, null);
        } finally {
        }
    }

    public static final Void b(int i10, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error code: " + i10);
        if (str != null) {
            sb2.append(", message: " + str);
        }
        throw new SQLException(sb2.toString());
    }
}
