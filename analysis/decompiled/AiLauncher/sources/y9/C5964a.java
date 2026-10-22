package y9;

import A9.g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5744c;
import w9.InterfaceC5748g;
import w9.InterfaceC5749h;
import w9.InterfaceC5752k;
import z9.c1;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\",\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lw9/c;", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Lw9/c;)Z", "setAccessible", "(Lw9/c;Z)V", "isAccessible", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: y9.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5964a {
    public static final boolean a(InterfaceC5744c<?> interfaceC5744c) {
        g<?> gVarY;
        p.i(interfaceC5744c, "<this>");
        if (interfaceC5744c instanceof InterfaceC5749h) {
            InterfaceC5752k interfaceC5752k = (InterfaceC5752k) interfaceC5744c;
            Field fieldC = d.c(interfaceC5752k);
            if (fieldC != null ? fieldC.isAccessible() : true) {
                Method methodD = d.d(interfaceC5752k);
                if (methodD != null ? methodD.isAccessible() : true) {
                    Method methodF = d.f((InterfaceC5749h) interfaceC5744c);
                    if (methodF != null ? methodF.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (interfaceC5744c instanceof InterfaceC5752k) {
            InterfaceC5752k interfaceC5752k2 = (InterfaceC5752k) interfaceC5744c;
            Field fieldC2 = d.c(interfaceC5752k2);
            if (fieldC2 != null ? fieldC2.isAccessible() : true) {
                Method methodD2 = d.d(interfaceC5752k2);
                if (methodD2 != null ? methodD2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (interfaceC5744c instanceof InterfaceC5752k.b) {
            Field fieldC3 = d.c(((InterfaceC5752k.b) interfaceC5744c).l());
            if (fieldC3 != null ? fieldC3.isAccessible() : true) {
                Method methodE = d.e((InterfaceC5748g) interfaceC5744c);
                if (methodE != null ? methodE.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (interfaceC5744c instanceof InterfaceC5749h.a) {
            Field fieldC4 = d.c(((InterfaceC5749h.a) interfaceC5744c).l());
            if (fieldC4 != null ? fieldC4.isAccessible() : true) {
                Method methodE2 = d.e((InterfaceC5748g) interfaceC5744c);
                if (methodE2 != null ? methodE2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(interfaceC5744c instanceof InterfaceC5748g)) {
            throw new UnsupportedOperationException("Unknown callable: " + interfaceC5744c + " (" + interfaceC5744c.getClass() + ')');
        }
        InterfaceC5748g interfaceC5748g = (InterfaceC5748g) interfaceC5744c;
        Method methodE3 = d.e(interfaceC5748g);
        if (methodE3 != null ? methodE3.isAccessible() : true) {
            kotlin.reflect.jvm.internal.d<?> dVarB = c1.b(interfaceC5744c);
            Object member = (dVarB == null || (gVarY = dVarB.Y()) == null) ? null : gVarY.getMember();
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor constructorB = d.b(interfaceC5748g);
                if (constructorB != null ? constructorB.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }
}
