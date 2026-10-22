package com.bytedance.android.ecom.bcm.track.impl.entranceinfo;

import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ecom.bcm.track.api.p003const.AppendScene;
import com.bytedance.android.ecom.bcm.track.impl.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ecom.bcm.track.impl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<KClass<? extends Object>> f51080a;

    public a() {
        this.f51080a = SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(String.class)});
    }

    @Override // com.bytedance.android.ecom.bcm.track.impl.d
    public final void c(l r100, c r101, AppendScene r102) {
        if (r100 == null) goto L31;
        Map<String, Object> r103 = b.f41761a.getBcmPassThroughMap(r100);
        JSONObject r104 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r105 = r103.entrySet().iterator();
    L5:
        if (r105.hasNext() == false) goto L18;
        Map.Entry<String, Object> r106 = r105.next();
        String r107 = r106.getKey();
        Object r108 = r106.getValue();
        if (r108 != null) goto L9;
        boolean r109 = false;
    L10:
        if (r109 == false) goto L5;
        if ((r108 instanceof String) == true) goto L14;
        r104.putOpt(r107, r108);
        goto L5
    L14:
        if (((String) r108).length() > 256) goto L5;
        r104.putOpt(r107, r108);
        goto L5
    L9:
        r109 = this.f51080a.contains(Reflection.getOrCreateKotlinClass(r108.getClass()));
        goto L10
    L18:
        if (r104.length() <= 0) goto L32;
        r101.b("pass_through_data", r104);
        return;
    L32:
        return;
    }
}
