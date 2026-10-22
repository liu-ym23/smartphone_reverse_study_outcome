package k4;

import java.util.LinkedHashMap;
import java.util.List;
import org.bouncycastle.asn1.x509.DisplayText;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public static final y f3644c;
    public static final y d;

    /* renamed from: e, reason: collision with root package name */
    public static final y f3645e;

    /* renamed from: f, reason: collision with root package name */
    public static final y f3646f;

    /* renamed from: g, reason: collision with root package name */
    public static final y f3647g;

    /* renamed from: h, reason: collision with root package name */
    public static final y f3648h;

    /* renamed from: j, reason: collision with root package name */
    public static final y f3649j;

    /* renamed from: k, reason: collision with root package name */
    public static final LinkedHashMap f3650k;

    /* renamed from: a, reason: collision with root package name */
    public final int f3651a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3652b;

    static {
        y yVar = new y(100, "Continue");
        y yVar2 = new y(101, "Switching Protocols");
        y yVar3 = new y(102, "Processing");
        y yVar4 = new y(DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, "OK");
        y yVar5 = new y(201, "Created");
        y yVar6 = new y(202, "Accepted");
        y yVar7 = new y(203, "Non-Authoritative Information");
        y yVar8 = new y(204, "No Content");
        f3644c = yVar8;
        y yVar9 = new y(205, "Reset Content");
        y yVar10 = new y(206, "Partial Content");
        y yVar11 = new y(207, "Multi-Status");
        y yVar12 = new y(300, "Multiple Choices");
        y yVar13 = new y(301, "Moved Permanently");
        d = yVar13;
        y yVar14 = new y(302, "Found");
        f3645e = yVar14;
        y yVar15 = new y(303, "See Other");
        f3646f = yVar15;
        y yVar16 = new y(304, "Not Modified");
        f3647g = yVar16;
        y yVar17 = new y(305, "Use Proxy");
        y yVar18 = new y(306, "Switch Proxy");
        y yVar19 = new y(307, "Temporary Redirect");
        f3648h = yVar19;
        y yVar20 = new y(308, "Permanent Redirect");
        f3649j = yVar20;
        List listS = c5.l.S(new y[]{yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7, yVar8, yVar9, yVar10, yVar11, yVar12, yVar13, yVar14, yVar15, yVar16, yVar17, yVar18, yVar19, yVar20, new y(400, "Bad Request"), new y(401, "Unauthorized"), new y(402, "Payment Required"), new y(403, "Forbidden"), new y(404, "Not Found"), new y(405, "Method Not Allowed"), new y(406, "Not Acceptable"), new y(407, "Proxy Authentication Required"), new y(408, "Request Timeout"), new y(409, "Conflict"), new y(410, "Gone"), new y(411, "Length Required"), new y(412, "Precondition Failed"), new y(413, "Payload Too Large"), new y(414, "Request-URI Too Long"), new y(415, "Unsupported Media Type"), new y(416, "Requested Range Not Satisfiable"), new y(417, "Expectation Failed"), new y(422, "Unprocessable Entity"), new y(423, "Locked"), new y(424, "Failed Dependency"), new y(425, "Too Early"), new y(426, "Upgrade Required"), new y(429, "Too Many Requests"), new y(431, "Request Header Fields Too Large"), new y(500, "Internal Server Error"), new y(501, "Not Implemented"), new y(502, "Bad Gateway"), new y(503, "Service Unavailable"), new y(504, "Gateway Timeout"), new y(505, "HTTP Version Not Supported"), new y(506, "Variant Also Negotiates"), new y(507, "Insufficient Storage")});
        int iT = c5.z.T(c5.o.n0(listS, 10));
        if (iT < 16) {
            iT = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iT);
        for (Object obj : listS) {
            linkedHashMap.put(Integer.valueOf(((y) obj).f3651a), obj);
        }
        f3650k = linkedHashMap;
    }

    public y(int i8, String str) {
        this.f3651a = i8;
        this.f3652b = str;
    }

    public final int a() {
        return this.f3651a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        y other = (y) obj;
        kotlin.jvm.internal.p.e(other, "other");
        return this.f3651a - other.f3651a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y) && ((y) obj).f3651a == this.f3651a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3651a);
    }

    public final String toString() {
        return this.f3651a + ' ' + this.f3652b;
    }
}
