package com.bytedance.android.ec.common.api.jump.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {
    private a parent;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.api.jump.model.a$a, reason: collision with other inner class name */
    public interface InterfaceC0780a {
        <T extends a> T a(KClass<T> r100);
    }

    public static final class b implements InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f42852a = null;

        public b() {
        }

        static {
            f42852a = new b();
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }
    }

    public a() {
    }

    public Map<String, String> chainParams() {
        return null;
    }

    public final JSONObject getAddToCartEntranceInfo() {
        JSONObject r100 = new JSONObject();
        a r101 = this;
    L3:
        if (r101 == null) goto L16;
        if ((r101 instanceof c) == false) goto L15;
        JSONObject r102 = ((c) r101).addToCartEntranceInfo();
        Iterator<String> r103 = r102.keys();
    L8:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (r100.has(r104) == true) goto L8;
        r100.put(r104, r102.opt(r104));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        ye.a.b(e);
    L15:
        r101 = r101.parent;
        goto L3
    L16:
        return r100;
    }

    public final Map<String, String> getChainParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        a r101 = this;
    L3:
        if (r101 == null) goto L14;
        Map<String, String> r102 = r101.chainParams();
        if (r102 == null) goto L12;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        if (r100.containsKey(r105) == true) goto L8;
        r100.put(r105, r106);
    L12:
        r101 = r101.parent;
        goto L3
    L14:
        if ((!r100.isEmpty()) == true) goto L25;
        return null;
    L25:
        return r100;
    }

    public final JSONObject getEntranceInfo() {
        JSONObject r100 = new JSONObject();
        a r101 = this;
    L3:
        if (r101 == null) goto L16;
        if ((r101 instanceof d) == false) goto L15;
        JSONObject r102 = ((d) r101).entranceInfo();
        Iterator<String> r103 = r102.keys();
    L8:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (r100.has(r104) == true) goto L8;
        r100.put(r104, r102.opt(r104));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        ye.a.b(e);
    L15:
        r101 = r101.parent;
        goto L3
    L16:
        return r100;
    }

    public final a getParent() {
        return this.parent;
    }

    public final <T extends a> T getParamsModel(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        T r101 = (T) this;
    L3:
        if (r101 == null) goto L8;
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(r101.getClass())) == true) goto L6;
        r101 = (T) r101.parent;
        goto L3
    L6:
        return r101;
    L8:
        return null;
    }

    public final <T extends a> T buildParams(KClass<T> r100, InterfaceC0780a r101) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Intrinsics.checkNotNullParameter(r101, "factory");
        T r102 = (T) r101.a(r100);
        r102.parent = this;
        return r102;
    }

    public static /* synthetic */ a buildParams$default(a r100, KClass r101, InterfaceC0780a r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = b.f42852a;
    L7:
        return r100.buildParams(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildParams");
    }
}
