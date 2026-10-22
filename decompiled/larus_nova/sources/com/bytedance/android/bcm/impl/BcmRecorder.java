package com.bytedance.android.bcm.impl;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.impl.d;
import com.bytedance.android.btm.impl.event.BtmEventParamFiller;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BcmRecorder implements BtmEventParamFiller.a, d, com.bytedance.android.btm.impl.virtualnode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f41789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, BcmParams> f41790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, kc.c> f41791c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f41792d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BcmRecorder f41793e = null;

    public BcmRecorder() {
    }

    static {
        f41793e = new BcmRecorder();
        LinkedHashMap<String, kc.c> r100 = new BcmRecorder$contentMap$1();
        f41790b = new ConcurrentHashMap();
        f41791c = Collections.synchronizedMap(r100);
        f41792d = LazyKt.lazy(BcmRecorder$sharePreference$2.INSTANCE);
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        Map<String, kc.c> r101 = f41791c;     // Catch: Throwable -> L13
        monitor-enter(r101);     // Catch: Throwable -> L13
        r100.put("bcmMap", r101.toString());     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L13
        goto L12
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L12:
        return r100.toString();
    }

    public static kc.c e(String r100) {
        return f41791c.get(r100);
    }

    public static void f(String r100, kc.c r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        f41791c.put(r100, r101);
        return;
    L11:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.android.btm.impl.virtualnode.a
    public final void a(String r100, String r101) {
        kc.c r102 = e(r100);
        if (r102 == null) goto L20;
        int r103 = kc.c.f502365c;
        Map<String, ? extends BcmParams> r104 = r102.f502366a;
        Map<String, ? extends BcmParams> r105 = r102.f502367b;
        LinkedHashMap r106 = null;
        if (r104 == null) goto L10;
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends BcmParams>> r108 = r104.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L11;
        Map.Entry<String, ? extends BcmParams> r109 = r108.next();
        r107.put(r109.getKey(), new BcmParams().merge(r109.getValue()));
    L11:
        if (r105 == null) goto L16;
        r106 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends BcmParams>> r110 = r105.entrySet().iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        Map.Entry<String, ? extends BcmParams> r111 = r110.next();
        r106.put(r111.getKey(), new BcmParams().merge(r111.getValue()));
    L16:
        f(r101, new kc.c(r107, r106));
        return;
    L10:
        r107 = null;
        goto L11
    }

    @Override // com.bytedance.android.btm.impl.virtualnode.a
    public final void b(String r100, BcmParams r101) {
        if (r101 == null) goto L5;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("ecom_entrance", r101);
        f(r100, new kc.c(null, r102));
        return;
    }

    @Override // com.bytedance.android.btm.impl.d
    public final void d(String r100, com.bytedance.android.btm.api.model.c r101) {
        Object r102 = r101.f42020j.get("description");
        if ((r102 instanceof BcmParams) == true) goto L5;
        r102 = null;
    L5:
        BcmParams r103 = (BcmParams) r102;
        if (r103 == null) goto L9;
        f41790b.put(r100, r103);
        return;
    }

    @Override // com.bytedance.android.btm.impl.event.BtmEventParamFiller.a
    public final void c(String r100, String r101, JSONObject r102, Map<String, Object> r103) {
        if (r102 != null) goto L5;
    L6:
        BcmParams r104 = f41790b.get(r101);
        if (r104 == null) goto L13;
        JSONObject r105 = r104.toJSONObject();
        if (r105 == null) goto L14;
        r103.put("bcm_description", r105);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r102.has("bcm_description") != true) goto L6;
    }
}
