package com.bytedance.android.latch.internal;

import com.bytedance.locallife.cube.PrefetchTiming;
import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f58299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, MaybeSubject<JSONObject>> f58300b;

    public f() {
        this.f58300b = new ConcurrentHashMap();
    }

    public final MaybeSubject<JSONObject> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        MaybeSubject<JSONObject> r101 = this.f58300b.get(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        throw new IllegalArgumentException(("failed to find call with __callback_id: " + r100).toString());
    }

    public static JSONObject b(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callbackId");
        JSONObject r102 = r100.optJSONObject("__params");
        if (r102 == null) goto L6;
        return com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to("result", r102), TuplesKt.to("__callback_id", r101), TuplesKt.to("__type", PrefetchTiming.JSB)});
    L6:
        return new JSONObject();
    }
}
