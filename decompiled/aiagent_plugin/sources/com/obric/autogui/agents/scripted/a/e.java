package com.obric.autogui.agents.scripted.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PreCheckParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f26861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("data")
    private final Boolean f26862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_CONNECTION_ERROR)
    private final String f26863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("name")
    private final String f26864d;

    public e() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26861a, r6.f26861a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26862b, r6.f26862b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26863c, r6.f26863c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26864d, r6.f26864d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26861a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.f26862b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26863c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f26864d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InitPreCheckResponse(type=" + this.f26861a + ", data=" + this.f26862b + ", error=" + this.f26863c + ", name=" + this.f26864d + ')';
    }

    public e(String r1, Boolean r2, String r3, String r4) {
        this.f26861a = r1;
        this.f26862b = r2;
        this.f26863c = r3;
        this.f26864d = r4;
    }

    public /* synthetic */ e(String r2, Boolean r3, String r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getType() {
        return this.f26861a;
    }

    public final Boolean a() {
        return this.f26862b;
    }

    public final String b() {
        return this.f26863c;
    }
}
