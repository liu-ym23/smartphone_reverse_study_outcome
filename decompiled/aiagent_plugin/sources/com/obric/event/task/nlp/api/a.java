package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("selected")
    private final b f32890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("candidates")
    private final List<b> f32891b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32890a, r6.f32890a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32891b, r6.f32891b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        b r0 = this.f32890a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<b> r4 = this.f32891b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionCandidateDto(selected=" + this.f32890a + ", candidates=" + this.f32891b + ')';
    }

    public a(b r3, List<b> r4) {
        List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f32890a = r3;
        this.f32891b = r5;
    }

    public /* synthetic */ a(b r2, List r3, int r4, d.h.b.h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final b a() {
        return this.f32890a;
    }
}
