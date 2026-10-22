package com.bytedance.android.ec.store.repository.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Map<String, Object>> f48460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Map<String, Object>> f48461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Map<String, Object>> f48462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Map<String, Object>> f48463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f48464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f48465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f48466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f48467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f48468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48469j;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 100;
    }

    public final Map<String, Object> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = this.f48460a.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L15;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        LinkedHashMap r107 = new LinkedHashMap();
        r107.putAll((Map) r105);
        Map<Integer, Map<String, Object>> r108 = this.f48461b;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        Map r110 = (Map) r109.get(Integer.valueOf(r104));
        if (r110 == null) goto L11;
        r107.putAll(r110);
    L11:
        Map<Integer, Map<String, Object>> r111 = this.f48462c;
        LinkedHashMap r112 = (LinkedHashMap) r111;
        Map r113 = (Map) r112.get(Integer.valueOf(r104));
        if (r113 == null) goto L14;
        r107.putAll(r113);
    L14:
        Map<Integer, Map<String, Object>> r114 = this.f48463d;
        LinkedHashMap r115 = (LinkedHashMap) r114;
        r101.put("slice_item_states", r115.get(Integer.valueOf(r104)));
        Unit r116 = Unit.INSTANCE;
        r102.add(r107);
        r104 = r106;
        goto L4
    L15:
        Unit r117 = Unit.INSTANCE;
        r101.put("products", r102);
        HashMap r118 = new HashMap();
        Map<String, Object> r119 = this.f48464e;
        if (r119 == null) goto L18;
        r118.putAll(r119);
    L18:
        r101.put("slice_item_extra", r118);
        HashMap r120 = new HashMap();
        Map<String, Object> r121 = this.f48466g;
        if (r121 == null) goto L21;
        r120.putAll(r121);
    L21:
        r101.put("slice_item_states", r120);
        HashMap r122 = new HashMap();
        Map<String, Object> r123 = this.f48465f;
        if (r123 == null) goto L24;
        r122.putAll(r123);
    L24:
        r101.put("slice_item_actions", r122);
        r100.put("data", r101);
        return r100;
    }

    public j() {
        this.f48460a = new ArrayList();
        this.f48461b = new LinkedHashMap();
        this.f48462c = new LinkedHashMap();
        this.f48463d = new LinkedHashMap();
        this.f48464e = new LinkedHashMap();
        this.f48465f = new LinkedHashMap();
        this.f48466g = new LinkedHashMap();
        this.f48468i = new ArrayList();
    }
}
