package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class m0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f94036a = null;

    static {
        f94036a = new m0();
    }

    public m0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "map");
        List r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r104.next())));
        goto L4
    L6:
        int r105 = com.bytedance.revenue.platform.api.core.b.f267506a;
        Object r106 = JSONObject.wrap(r103);
        if (r106 == null) goto L11;
        return (JSONArray) r106;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONArray /* = org.json.JSONArray */");
    }
}
