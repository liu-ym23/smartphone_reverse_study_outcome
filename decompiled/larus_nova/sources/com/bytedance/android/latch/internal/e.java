package com.bytedance.android.latch.internal;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LatchStateHolder.JsonPath f58296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LatchStateHolder f58297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f58298c;

    public e(LatchStateHolder.JsonPath r100, LatchStateHolder r101, JSONObject r102) {
        this.f58296a = r100;
        this.f58297b = r101;
        this.f58298c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        LatchStateHolder.JsonPath r102 = this.f58296a;
    L4:
        if (Intrinsics.areEqual(r102, LatchStateHolder.JsonPath.f58271c) == true) goto L10;
        r101 = com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to(r102.f58272a, r101)});
        r102 = r102.f58273b;
        if (r102 != null) goto L4;
        throw new IllegalArgumentException("Required value was null.".toString());
    L10:
        JSONObject r103 = com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to("data", r101)});
        BehaviorSubject<JSONObject> r104 = this.f58297b.f58265i;
        JSONObject r105 = r104.getValue();
        if (r105 == null) goto L17;
        JSONObject r106 = r105;
        com.bytedance.android.latch.internal.util.b.c(r106, r103);
        r104.onNext(r106);
        this.f58297b.f58267k.onNext(new Pair(JSONObjectProtectorUtils.getString(this.f58298c, "__callback_id"), r103));
        if (this.f58297b.f58266j.decrementAndGet() != 0) goto L21;
        this.f58297b.f58260d.invoke();
        return;
    L21:
        return;
    L17:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
