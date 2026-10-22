package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final f f32902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("params")
    private final Map<String, Object> f32903b;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f32902a == r6.f32902a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32903b, r6.f32903b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        f r0 = this.f32902a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.f32903b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DeviceConditionDto(type=" + this.f32902a + ", params=" + this.f32903b + ')';
    }

    public e(f r3, Map<String, ? extends Object> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f32902a = r3;
        this.f32903b = r5;
    }

    public /* synthetic */ e(f r2, Map r3, int r4, d.h.b.h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final f getType() {
        return this.f32902a;
    }

    public final Map<String, Object> a() {
        return this.f32903b;
    }
}
