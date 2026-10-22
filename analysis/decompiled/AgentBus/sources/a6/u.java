package a6;

import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final Set f380c = d7.n.x0(new String[]{"skills", "tools", "config", "files", "cronjobs", "channels", "gateway"});

    /* renamed from: a, reason: collision with root package name */
    public final o f381a;

    /* renamed from: b, reason: collision with root package name */
    public final k5.t f382b;

    public u(o oVar, k5.g gVar) {
        q7.k.e(gVar, "logger");
        this.f381a = oVar;
        this.f382b = gVar;
    }

    public static String b(Throwable th) {
        return th instanceof IllegalArgumentException ? "STEPCLAW_INVALID_FRAME" : th instanceof NoSuchElementException ? "STEPCLAW_NODE_NOT_FOUND" : "STEPCLAW_TRANSPORT_ERROR";
    }

    public static boolean c(String str) {
        if (str == null || ga.k.t0(str)) {
            return false;
        }
        return f380c.contains(ga.k.I0(str, '.'));
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    public final java.lang.Object a(c5.b r25, i7.c r26) {
        /*
            Method dump skipped, instructions count: 3280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.u.a(c5.b, i7.c):java.lang.Object");
    }
}
