package com.bytedance.android.ecom.arch.slice.template;

import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.expr.c;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class JsonTemplate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f51054c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f51055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcExprContext f51056b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean c(String r100) {
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
        L10:
            return false;
        L8:
            if (r100.charAt(0) != ':') goto L10;
            return true;
        L5:
            r101 = false;
            goto L6
        }

        @JvmStatic
        public static String e(String r100) {
            if (r100 == null) goto L6;
            return r100.substring(1);
        L6:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public static final boolean a(a r100, Object r101) {
            r100.getClass();
            if (r101 != null) goto L5;
            return false;
        L5:
            if ((r101 instanceof Map) == false) goto L8;
            boolean r102 = ((Map) r101).isEmpty();
        L14:
            return true ^ r102;
        L8:
            if ((r101 instanceof List) == false) goto L13;
            r102 = ((Collection) r101).isEmpty();
            goto L14
        L13:
            return true;
        }

        public static Map b(a r100, Map r101) {
            r100.getClass();
            KProperty[] r102 = SliceRender.f50107a;
            return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("data", r101)});
        }

        @JvmStatic
        public static boolean d(Object r100, int r101) {
            if (r100 != null) goto L5;
        L32:
            return false;
        L5:
            if (r101 < 2) goto L8;
            return false;
        L8:
            if ((r100 instanceof Map) == false) goto L25;
            Set r102 = ((Map) r100).entrySet();
            Iterator r103 = r102.iterator();
        L11:
            if (r103.hasNext() == false) goto L17;
            Object r104 = ((Map.Entry) r103.next()).getKey();
            if ((r104 instanceof String) == false) goto L11;
            JsonTemplate.f51054c.getClass();
            if (c((String) r104) == false) goto L11;
            return true;
        L17:
            Iterator r105 = r102.iterator();
        L19:
            if (r105.hasNext() == false) goto L23;
            Map.Entry r106 = (Map.Entry) r105.next();
            a r107 = JsonTemplate.f51054c;
            r107.getClass();
            if (d(r106.getValue(), r101 + 1) == false) goto L19;
            return true;
        L23:
            return false;
        L25:
            if ((r100 instanceof List) == false) goto L32;
            Iterator r108 = ((Iterable) r100).iterator();
        L28:
            if (r108.hasNext() == false) goto L32;
            Object r109 = r108.next();
            JsonTemplate.f51054c.getClass();
            if (d(r109, r101 + 1) == false) goto L28;
            return true;
        }
    }

    static {
        f51054c = new a();
    }

    public JsonTemplate(Object r100, SlcExprContext r101) {
        this.f51055a = r100;
        this.f51056b = r101;
    }

    public final Object a(Object r110, Map<String, ? extends Object> r111, int r112, int r113, Function1<? super c, Unit> r114) {
        if (1 > r112) goto L8;
        if (r113 < r112) goto L8;
        return r110;
    L8:
        if ((r110 instanceof Map) == false) goto L35;
        HashMap r100 = new HashMap();
        if (r110 == null) goto L33;
        Iterator r115 = ((Map) r110).entrySet().iterator();
    L13:
        if (r115.hasNext() == false) goto L31;
        Map.Entry r101 = (Map.Entry) r115.next();
        final String r102 = (String) r101.getKey();
        Object r103 = r101.getValue();
        a r104 = f51054c;
        r104.getClass();
        if (a.c(r102) == true) goto L17;
        Object r105 = a(r103, r111, r112, r113 + 1, r114);
        if (a.a(r104, r105) == false) goto L13;
        r100.put(r102, r105);
        goto L13
    L17:
        if ((r103 instanceof String) == false) goto L27;
        if (((CharSequence) r103).length() != 0) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == true) goto L27;
        SlcExprContext r107 = this.f51056b;
        Object r108 = r107.a((String) r103, r111, r114);
        if (a.a(r104, r108) == false) goto L13;
        r100.put(a.e(r102), r108);
        goto L13
    L21:
        r106 = false;
    L27:
        nq.a.c(null, new JsonTemplate$executeTemplate$1$1(r102), 1);
        goto L13
    L31:
        return r100;
    L33:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
    L35:
        if ((r110 instanceof List) == false) goto L41;
        ArrayList r109 = new ArrayList();
        Iterator r116 = ((Iterable) r110).iterator();
    L38:
        if (r116.hasNext() == false) goto L40;
        r109.add(a(r116.next(), r111, r112, r113 + 1, r114));
        goto L38
    L40:
        return r109;
    L41:
        return r110;
    }
}
