package com.bytedance.android.bcm.impl.paramcheck.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f41875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41876b;

    public final a.C0771a b() {
        List<a> r100 = this.f41875a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if ((r103 instanceof a.C0771a) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return (a.C0771a) CollectionsKt.firstOrNull(r101);
    }

    public b() {
        this.f41875a = new ArrayList();
        this.f41876b = true;
    }

    public final void a(JSONObject r100) {
        List<a> r101 = this.f41875a;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof a.b) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(((a.b) r106.next()).f41874c);
        goto L10
    L12:
        r100.put("illegal_params", new JSONArray(r105));
        a.C0771a r107 = b();
        if (r107 == null) goto L22;
        r100.put("extra_rule", r107.f41871a);
        return;
    }
}
