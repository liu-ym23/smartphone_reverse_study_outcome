package ub;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.time.DurationUnit;
import kotlin.time.a;
import tb.C5537d;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0000*\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0013\u0010\r\u001a\u00020\u0000*\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\f*\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\f*\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\fH\u0000¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u001b\u0010\u0015\u001a\u00020\u0000*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u0019\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltb/d;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/d;)Ljava/lang/String;", "", "", Const.INTENT_KEY_PKGNAME, "(J)I", "Ltb/d$b;", Const.INTENT_KEY_UMID, "(Ltb/d$b;)Ltb/d;", "c", "Ltb/d$a;", Const.INTENT_KEY_APIKEY, "(Ltb/d$a;)Ltb/d;", "e", "(Ltb/d$a;)Ltb/d$a;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ltb/u;", "headers", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/d$b;Ltb/u;)Ltb/d;", "characters", "startIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;I)I", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j {
    public static final C5537d a(C5537d.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        return new C5537d(aVar.getNoCache(), aVar.getNoStore(), aVar.getMaxAgeSeconds(), -1, false, false, false, aVar.getMaxStaleSeconds(), aVar.getMinFreshSeconds(), aVar.getOnlyIfCached(), aVar.getNoTransform(), aVar.getImmutable(), null);
    }

    public static final int b(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    public static final C5537d c(C5537d.Companion companion) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        C5537d.a aVarM = new C5537d.a().m();
        a.Companion companion2 = kotlin.time.a.INSTANCE;
        return aVarM.j(kotlin.time.b.s(Integer.MAX_VALUE, DurationUnit.SECONDS)).a();
    }

    public static final C5537d d(C5537d.Companion companion) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        return new C5537d.a().k().a();
    }

    public static final C5537d.a e(C5537d.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        aVar.n(true);
        return aVar;
    }

    public static final C5537d.a f(C5537d.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        aVar.o(true);
        return aVar;
    }

    public static final C5537d.a g(C5537d.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        aVar.p(true);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final tb.C5537d h(tb.C5537d.Companion r30, tb.u r31) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.j.h(tb.d$b, tb.u):tb.d");
    }

    public static final String i(C5537d c5537d) {
        kotlin.jvm.internal.p.i(c5537d, "<this>");
        String headerValue = c5537d.getHeaderValue();
        if (headerValue != null) {
            return headerValue;
        }
        StringBuilder sb2 = new StringBuilder();
        if (c5537d.getNoCache()) {
            sb2.append("no-cache, ");
        }
        if (c5537d.getNoStore()) {
            sb2.append("no-store, ");
        }
        if (c5537d.getMaxAgeSeconds() != -1) {
            sb2.append("max-age=");
            sb2.append(c5537d.getMaxAgeSeconds());
            sb2.append(", ");
        }
        if (c5537d.getSMaxAgeSeconds() != -1) {
            sb2.append("s-maxage=");
            sb2.append(c5537d.getSMaxAgeSeconds());
            sb2.append(", ");
        }
        if (c5537d.getIsPrivate()) {
            sb2.append("private, ");
        }
        if (c5537d.getIsPublic()) {
            sb2.append("public, ");
        }
        if (c5537d.getMustRevalidate()) {
            sb2.append("must-revalidate, ");
        }
        if (c5537d.getMaxStaleSeconds() != -1) {
            sb2.append("max-stale=");
            sb2.append(c5537d.getMaxStaleSeconds());
            sb2.append(", ");
        }
        if (c5537d.getMinFreshSeconds() != -1) {
            sb2.append("min-fresh=");
            sb2.append(c5537d.getMinFreshSeconds());
            sb2.append(", ");
        }
        if (c5537d.getOnlyIfCached()) {
            sb2.append("only-if-cached, ");
        }
        if (c5537d.getNoTransform()) {
            sb2.append("no-transform, ");
        }
        if (c5537d.getImmutable()) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        kotlin.jvm.internal.p.h(sb2.delete(sb2.length() - 2, sb2.length()), "delete(...)");
        String string = sb2.toString();
        c5537d.n(string);
        return string;
    }

    public static final int j(String str, String str2, int i10) {
        int length = str.length();
        while (i10 < length) {
            if (H.f0(str2, str.charAt(i10), false, 2, null)) {
                return i10;
            }
            i10++;
        }
        return str.length();
    }
}
