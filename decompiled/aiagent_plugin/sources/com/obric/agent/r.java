package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppIntentIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f15413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f15416d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15413a, r6.f15413a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15414b, r6.f15414b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15415c, r6.f15415c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15416d, r6.f15416d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f15413a.hashCode() * 31;
        String r1 = this.f15414b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f15415c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.f15416d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniUploadFeedbackPayload(tags=" + this.f15413a + ", type=" + this.f15414b + ", source=" + this.f15415c + ", amount=" + this.f15416d + ')';
    }

    public r(List<String> r3, String r4, String r5, Integer r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "tags");
        this.f15413a = r7;
        this.f15414b = r4;
        this.f15415c = r5;
        this.f15416d = r6;
    }

    public final List<String> a() {
        return this.f15413a;
    }

    public final String getType() {
        return this.f15414b;
    }

    public final String b() {
        return this.f15415c;
    }

    public final Integer c() {
        return this.f15416d;
    }
}
