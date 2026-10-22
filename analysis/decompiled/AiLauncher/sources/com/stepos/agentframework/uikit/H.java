package com.stepos.agentframework.uikit;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u000f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/uikit/H;", "", "<init>", "()V", "", "source", "LYb/u;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)LYb/u;", "node", "", Const.INTENT_KEY_PKGNAME, "(LYb/u;)Z", Const.INTENT_KEY_APIKEY, "table", "", "e", "(LYb/u;)Ljava/util/List;", "c", "(Ljava/lang/String;)Z", "Lkotlin/text/Regex;", "tableDelimiter", "Lkotlin/text/Regex;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H {
    public static final H INSTANCE = new H();
    private static final Regex tableDelimiter = new Regex("\\|?\\s*:?-+:?\\s*(\\|\\s*:?-+:?\\s*)*\\|?");

    public final boolean a(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        return node instanceof Pb.a;
    }

    public final boolean b(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        return node instanceof Rb.a;
    }

    public final boolean c(String source) {
        kotlin.jvm.internal.p.i(source, "source");
        for (String str : La.H.E0(source)) {
            if (La.H.f0(str, '|', false, 2, null) && tableDelimiter.k(La.H.D1(str).toString())) {
                return true;
            }
        }
        return false;
    }

    public final Yb.u d(String source) {
        kotlin.jvm.internal.p.i(source, "source");
        Yb.u uVarC = Zb.d.a().i(C1173v.p(Rb.e.c(), Pb.b.c())).f().c(source);
        kotlin.jvm.internal.p.h(uVarC, "parse(...)");
        return uVarC;
    }

    public final List<List<Yb.u>> e(Yb.u table) {
        kotlin.jvm.internal.p.i(table, "table");
        List listC = C1172u.c();
        for (Yb.u uVarC = table.c(); uVarC != null; uVarC = uVarC.e()) {
            for (Yb.u uVarC2 = uVarC.c(); uVarC2 != null; uVarC2 = uVarC2.e()) {
                if (uVarC2 instanceof Rb.d) {
                    List listC2 = C1172u.c();
                    for (Yb.u uVarC3 = ((Rb.d) uVarC2).c(); uVarC3 != null; uVarC3 = uVarC3.e()) {
                        listC2.add(uVarC3);
                    }
                    listC.add(C1172u.a(listC2));
                }
            }
        }
        return C1172u.a(listC);
    }
}
