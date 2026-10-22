package com.stepos.agentframework.uikit;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/uikit/M;", "", "<init>", "()V", "", "markdown", "c", "(Ljava/lang/String;)Ljava/lang/String;", "LYb/u;", "node", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LYb/u;)V", "", Const.INTENT_KEY_APIKEY, "(LYb/u;)Z", "", "LOb/a;", "kotlin.jvm.PlatformType", "extensions", "Ljava/util/List;", "LZb/d;", "parser", "LZb/d;", "Ldc/d;", "renderer", "Ldc/d;", "Lkotlin/text/Regex;", "latexBlockRegex", "Lkotlin/text/Regex;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M {
    public static final M INSTANCE = new M();
    private static final List<Ob.a> extensions;
    private static final Regex latexBlockRegex;
    private static final Zb.d parser;
    private static final dc.d renderer;

    static {
        List<Ob.a> listP = C1173v.p(Rb.e.c(), Pb.b.c());
        extensions = listP;
        Zb.d dVarF = Zb.d.a().i(listP).f();
        kotlin.jvm.internal.p.h(dVarF, "build(...)");
        parser = dVarF;
        dc.d dVarC = dc.d.c().d(listP).f(false).c();
        kotlin.jvm.internal.p.h(dVarC, "build(...)");
        renderer = dVarC;
        latexBlockRegex = new Regex("\\$\\$[\\s\\S]*?\\$\\$");
    }

    public static final String c(String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        if (La.H.x0(markdown)) {
            return La.H.D1(markdown).toString();
        }
        try {
            Yb.u uVarC = parser.c(latexBlockRegex.l(markdown, ""));
            M m10 = INSTANCE;
            kotlin.jvm.internal.p.f(uVarC);
            m10.b(uVarC);
            String strD = renderer.d(uVarC);
            kotlin.jvm.internal.p.h(strD, "render(...)");
            return La.H.D1(strD).toString();
        } catch (Throwable unused) {
            return La.H.D1(markdown).toString();
        }
    }

    public final boolean a(Yb.u node) {
        return (node instanceof Yb.m) || (node instanceof Yb.A);
    }

    public final void b(Yb.u node) {
        Yb.u uVarC = node.c();
        while (uVarC != null) {
            Yb.u uVarE = uVarC.e();
            if (a(uVarC)) {
                uVarC.l();
            } else {
                b(uVarC);
            }
            uVarC = uVarE;
        }
    }
}
