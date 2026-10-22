package e5;

import c6.d;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentcache.core.ServiceContract;
import d7.h0;
import d7.n;
import ga.g;
import ga.h;
import ga.i;
import ga.j;
import ga.r;
import ib.c;
import ib.k;
import java.util.Set;
import m.x;
import n.f;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f3054a = n.x0(new String[]{"presence", "health", "tick"});

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f3055b = {'\"', ',', '}', ']', ')', '&', ' ', '\t', '\n'};

    /* renamed from: c, reason: collision with root package name */
    public static final i f3056c;

    /* renamed from: d, reason: collision with root package name */
    public static final i f3057d;

    /* renamed from: e, reason: collision with root package name */
    public static final i f3058e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f3059f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f3060g;

    /* renamed from: h, reason: collision with root package name */
    public static final i f3061h;

    /* renamed from: i, reason: collision with root package name */
    public static final i f3062i;

    /* renamed from: j, reason: collision with root package name */
    public static final i f3063j;

    /* renamed from: k, reason: collision with root package name */
    public static final i f3064k;

    /* renamed from: l, reason: collision with root package name */
    public static final Set f3065l;

    /* renamed from: m, reason: collision with root package name */
    public static final Set f3066m;

    /* renamed from: n, reason: collision with root package name */
    public static final Set f3067n;

    /* renamed from: o, reason: collision with root package name */
    public static final Set f3068o;

    /* renamed from: p, reason: collision with root package name */
    public static final Set f3069p;

    /* renamed from: q, reason: collision with root package name */
    public static final i f3070q;

    /* renamed from: r, reason: collision with root package name */
    public static final Set f3071r;

    /* renamed from: s, reason: collision with root package name */
    public static final i f3072s;

    static {
        j jVar = j.f4027g;
        f3056c = new i("(\"?)(device[_-]?id|imei|imsi|iccid)\\1\\s*([:=])\\s*(\"?)([^\"\\s,}&]+)\\4", jVar);
        f3057d = new i("(\"?)(user[_-]?id)\\1\\s*([:=])\\s*(\"?)([^\"\\s,}&]+)\\4", jVar);
        f3058e = new i("(\"?)(authtoken|authToken|deviceToken|token)\\1\\s*([:=])\\s*(\"?)([^\"\\s,}&]+)\\4", jVar);
        f3059f = new i("(\"device\"\\s*:\\s*\\{\\s*\"id\"\\s*:\\s*\")([^\"]+)");
        f3060g = new i("\\(([0-9a-fA-F]{16,64})\\)");
        f3061h = new i("(?<![0-9Xx])\\d{17}[0-9Xx](?![0-9Xx])");
        f3062i = new i("(?<![0-9])\\d{16,19}(?![0-9])");
        f3063j = new i("(?<![0-9])1[3-9]\\d{9}(?![0-9])");
        f3064k = new i("([A-Za-z0-9._%+\\-]+)@([A-Za-z0-9.\\-]+\\.[A-Za-z]{2,})");
        f3065l = n.x0(new String[]{"text", "delta", OAuthConstants.FACTOR_RESULT_MESSAGE, "content", "query", "input_text", "prompt", "answer", "reply", "thinking", "reasoning", "reasoning_content", "params", "arguments", "result", "structuredContent"});
        f3066m = n.x0(new String[]{"sessionId", "session_id", "sessionKey", "msgId", "msg_id", "channelMessageId", "callId", "call_id", "requestId", ServiceContract.RequiredKeys.TRACE_ID, "trace_id", "spanId", "frameId", "idempotencyKey", "agentId", "nodeId", "runId", "type", "seq", "index", "ok", "code", "isError", "errorCode", "stream", "phase", "role", "state", "done", "limit", "count", "timeoutMs", "method", "event", "id", "action"});
        f3067n = k.S("thinking");
        f3068o = n.x0(new String[]{"latitude", "longitude", "gcjLatitude", "gcjLongitude", "bdLatitude", "bdLongitude", "wgsLatitude", "wgsLongitude", "altitude", "accuracy", "bearing", "speed", "radius", "direction", "locType"});
        f3069p = n.x0(new String[]{"address", "detailedAddress", "detailAddress", "formattedAddress", "street", "streetName", "streetNumber", "road", "roadName", "aoi", "aoiName", "poi", "poiName", "building", "buildingName", "landmark"});
        f3070q = new i("[a-z][a-z_]{0,15}");
        f3071r = n.x0(new String[]{"_meta", "trace", "stepclaw", "client", "auth", "device"});
        f3072s = new i("(--params\\s+\\\\?')((?:[^'\\\\]|\\\\.)*?)(\\\\?')");
    }

    public static int a(int i2, String str) {
        while (true) {
            i2++;
            while (i2 < str.length()) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '\"') {
                    return i2 + 1;
                }
                if (cCharAt != '\\') {
                    break;
                }
                i2 += 2;
            }
            return str.length();
        }
    }

    public static String b(String str) {
        int i2;
        int iQ0;
        if (str == null || str.length() == 0) {
            return str == null ? "" : str;
        }
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!c.E(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        if (i10 < 0 || !(str.charAt(i10) == '{' || str.charAt(i10) == '[')) {
            return f.c(str.length(), "cipher len=");
        }
        int iR0 = ga.k.r0(str, "\"event\":\"", 0, false, 6);
        String strSubstring = null;
        if (iR0 >= 0 && iR0 <= 96 && (iQ0 = ga.k.q0(str, '\"', (i2 = iR0 + 9), 4)) > i2 && iQ0 - i2 <= 64) {
            strSubstring = str.substring(i2, iQ0);
            q7.k.d(strSubstring, "substring(...)");
        }
        if (strSubstring == null || !f3054a.contains(strSubstring)) {
            return d(str);
        }
        return "event=" + strSubstring + " len=" + str.length();
    }

    public static String c(String str) {
        if (str == null || str.length() == 0) {
            return str == null ? "" : str;
        }
        a aVarJ = j(str);
        String strG = g(aVarJ.f3052a);
        int i2 = aVarJ.f3053b;
        return a1.a.i(strG, i2 > 0 ? a1.a.f(i2, "…[+", " chars]") : "");
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return str == null ? "" : str;
        }
        a aVarJ = j(i(str, false));
        String strG = g(f3072s.d(aVarJ.f3052a, new d(11)));
        int i2 = aVarJ.f3053b;
        return a1.a.i(strG, i2 > 0 ? a1.a.f(i2, "…[+", " chars]") : "");
    }

    public static String e(String str) {
        return (str == null || str.length() == 0) ? "" : f(str);
    }

    public static String f(String str) {
        return str.length() <= 4 ? r.c0(str.length(), "*") : "****".concat(ga.k.M0(4, str));
    }

    public static String g(String str) {
        return f3064k.d(f3063j.d(f3062i.d(f3061h.d(f3060g.d(f3059f.d(f3057d.d(f3056c.d(f3058e.d(str, new d(2)), new d(3)), new d(4)), new d(5)), new d(6)), new d(7)), new d(8)), new d(9)), new d(10));
    }

    public static String h(g gVar, String str) {
        h hVar = (h) gVar;
        String str2 = (String) ((h0) hVar.a()).get(1);
        String str3 = (String) ((h0) hVar.a()).get(2);
        String str4 = (String) ((h0) hVar.a()).get(3);
        String str5 = (String) ((h0) hVar.a()).get(4);
        return a1.a.m(x.p(str2, str3, str2, str4, str5), str, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00ac A[EDGE_INSN: B:167:0x00ac->B:56:0x00ac BREAK  A[LOOP:3: B:51:0x009d->B:170:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String i(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.b.i(java.lang.String, boolean):java.lang.String");
    }

    public static a j(String str) {
        if (str.length() <= 4096) {
            return new a(str, 0, 1);
        }
        String strL0 = ga.k.L0(4096, str);
        int iO0 = ga.k.o0(strL0);
        q7.k.e(strL0, "<this>");
        char[] cArr = f3055b;
        q7.k.e(cArr, "chars");
        if (cArr.length == 1 && (strL0 instanceof String)) {
            iO0 = strL0.lastIndexOf(n.q0(cArr), iO0);
        } else {
            int iO02 = ga.k.o0(strL0);
            if (iO0 > iO02) {
                iO0 = iO02;
            }
            loop0: while (true) {
                if (-1 >= iO0) {
                    iO0 = -1;
                    break;
                }
                char cCharAt = strL0.charAt(iO0);
                for (char c10 : cArr) {
                    if (c.w(c10, cCharAt, false)) {
                        break loop0;
                    }
                }
                iO0--;
            }
        }
        int i2 = iO0 + 1;
        return new a(ga.k.L0(i2, strL0), str.length() - i2, 1);
    }
}
