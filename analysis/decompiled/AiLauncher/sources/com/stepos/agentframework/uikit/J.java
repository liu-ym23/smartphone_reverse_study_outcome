package com.stepos.agentframework.uikit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/uikit/J;", "", "<init>", "()V", "LYb/u;", "node", "", Const.INTENT_KEY_PKGNAME, "(LYb/u;)Z", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class J {
    public static final J INSTANCE = new J();

    public final boolean a(Yb.u node) {
        Yb.u uVarC = node.c();
        if (uVarC == null) {
            return false;
        }
        boolean z10 = false;
        do {
            if (uVarC instanceof Yb.o) {
                z10 = true;
            } else if (uVarC instanceof Yb.q) {
                if (!a(uVarC)) {
                    return false;
                }
                z10 = true;
            } else if (!(uVarC instanceof Yb.x) && !(uVarC instanceof Yb.k)) {
                if (uVarC instanceof Yb.z) {
                    String strM = ((Yb.z) uVarC).m();
                    kotlin.jvm.internal.p.h(strM, "getLiteral(...)");
                    if (!La.H.x0(strM)) {
                    }
                }
                return false;
            }
            uVarC = uVarC.e();
        } while (uVarC != null);
        return z10;
    }

    public final boolean b(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        if (node instanceof Yb.w) {
            return a(node);
        }
        return false;
    }
}
