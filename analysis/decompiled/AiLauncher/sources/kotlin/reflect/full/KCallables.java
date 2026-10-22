package kotlin.reflect.full;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.reflect.KParameter;
import w9.InterfaceC5744c;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a6\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0087@¢\u0006\u0004\b\u0006\u0010\u0007\"(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u0006\u0012\u0002\b\u00030\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\"$\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\u000f\"(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u0006\u0012\u0002\b\u00030\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\n¨\u0006\u0015"}, d2 = {"R", "Lw9/c;", "", "Lkotlin/reflect/KParameter;", "", "args", Const.INTENT_KEY_APIKEY, "(Lw9/c;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "(Lw9/c;)Ljava/util/List;", "getContextParameters$annotations", "(Lw9/c;)V", "contextParameters", "c", "(Lw9/c;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter$annotations", "extensionReceiverParameter", Const.INTENT_KEY_UMID, "getValueParameters$annotations", "valueParameters", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KCallables {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object a(w9.InterfaceC5744c<? extends R> r4, java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, e9.InterfaceC4014c<? super R> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables$callSuspendBy$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = (kotlin.reflect.full.KCallables$callSuspendBy$1) r0
            int r1 = r0.f34865e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f34865e = r1
            goto L18
        L13:
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = new kotlin.reflect.full.KCallables$callSuspendBy$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f34864d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f34865e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f34863c
            kotlin.reflect.jvm.internal.d r4 = (kotlin.reflect.jvm.internal.d) r4
            java.lang.Object r4 = r0.f34862b
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.f34861a
            w9.c r4 = (w9.InterfaceC5744c) r4
            kotlin.C4849c.b(r6)
            goto L6d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4b
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L4b:
            boolean r6 = r4 instanceof w9.InterfaceC5748g
            if (r6 == 0) goto La8
            kotlin.reflect.jvm.internal.d r6 = z9.c1.b(r4)
            if (r6 == 0) goto L91
            r0.f34861a = r4
            r0.f34862b = r5
            r0.f34863c = r6
            r0.f34865e = r3
            java.lang.Object r6 = r6.R(r5, r0)
            java.lang.Object r5 = f9.C4063a.g()
            if (r6 != r5) goto L6a
            g9.f.c(r0)
        L6a:
            if (r6 != r1) goto L6d
            return r1
        L6d:
            w9.g r4 = (w9.InterfaceC5748g) r4
            w9.n r5 = r4.getReturnType()
            w9.e r5 = r5.c()
            java.lang.Class<Y8.t> r0 = Y8.t.class
            w9.d r0 = kotlin.jvm.internal.t.b(r0)
            boolean r5 = kotlin.jvm.internal.p.d(r5, r0)
            if (r5 == 0) goto L90
            w9.n r4 = r4.getReturnType()
            boolean r4 = r4.e()
            if (r4 != 0) goto L90
            Y8.t r4 = Y8.t.f7040a
            return r4
        L90:
            return r6
        L91:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r5 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "This callable does not support a default call: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        La8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspendBy on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.a(w9.c, java.util.Map, e9.c):java.lang.Object");
    }

    public static final List<KParameter> b(InterfaceC5744c<?> interfaceC5744c) {
        p.i(interfaceC5744c, "<this>");
        List<KParameter> parameters = interfaceC5744c.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.CONTEXT) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final KParameter c(InterfaceC5744c<?> interfaceC5744c) {
        p.i(interfaceC5744c, "<this>");
        Iterator<T> it = interfaceC5744c.getParameters().iterator();
        Object obj = null;
        boolean z10 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj2 = next;
                }
            } else if (z10) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    public static final List<KParameter> d(InterfaceC5744c<?> interfaceC5744c) {
        p.i(interfaceC5744c, "<this>");
        List<KParameter> parameters = interfaceC5744c.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
