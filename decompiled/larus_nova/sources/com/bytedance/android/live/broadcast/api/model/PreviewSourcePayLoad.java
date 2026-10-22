package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class PreviewSourcePayLoad {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f59018b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b1> f59019a;

    public static final class a {
    }

    static {
    }

    public PreviewSourcePayLoad() {
        this.f59019a = new LinkedHashMap();
    }

    public final String toString() {
        System.currentTimeMillis();
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((LinkedHashMap) this.f59019a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry r102 = (Map.Entry) r101.next();
        Iterator r103 = ((LinkedHashMap) ((b1) r102.getValue()).f59029b).entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        Map.Entry r104 = (Map.Entry) r103.next();
        r100.add(CollectionsKt.arrayListOf(new String[]{(String) r102.getKey(), (String) r104.getKey(), (String) r104.getValue()}));
        goto L7
    L10:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r100);
    }

    public final <T> void a(@PayLoadNameSpace String r100, final String r101, final T r102) {
        Intrinsics.checkNotNullParameter(r100, "nameSpace");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Function1<b1, Unit> r103 = new PreviewSourcePayLoad$putPayLoad$1(r102, r101);
        b1 r104 = (b1) ((LinkedHashMap) this.f59019a).get(r100);
        if (r104 == null) goto L6;
        r103.invoke2(r104);
        return;
    L6:
        b1 r105 = new b1();
        r103.invoke2(r105);
        this.f59019a.put(r100, r105);
    }
}
