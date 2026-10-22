package kotlin;

import La.C0953c;
import La.H;
import Z8.F;
import android.util.Base64;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0015\u0010\b\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u0017\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000f"}, d2 = {"LK6/k;", "", "index", "", "e", "(LK6/k;I)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(LK6/k;)Ljava/lang/String;", "bizModule", "c", "bizCommand", Const.INTENT_KEY_PKGNAME, "aiModule", Const.INTENT_KEY_APIKEY, "aiCommand", "common_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0916l {
    public static final String a(C0915k c0915k) {
        p.i(c0915k, "<this>");
        return e(c0915k, 3);
    }

    public static final String b(C0915k c0915k) {
        p.i(c0915k, "<this>");
        return e(c0915k, 2);
    }

    public static final String c(C0915k c0915k) {
        p.i(c0915k, "<this>");
        String strE = e(c0915k, 1);
        return strE == null ? "" : strE;
    }

    public static final String d(C0915k c0915k) {
        p.i(c0915k, "<this>");
        String strE = e(c0915k, 0);
        return strE == null ? "" : strE;
    }

    public static final String e(C0915k c0915k, int i10) {
        try {
            byte[] bArrDecode = Base64.decode(c0915k.getAgentId(), 2);
            p.h(bArrDecode, "decode(...)");
            String str = (String) F.t0(H.b1(new String(bArrDecode, C0953c.UTF_8), new String[]{"|"}, false, 0, 6, null), i10);
            if (str != null) {
                if (str.length() > 0) {
                    return str;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
