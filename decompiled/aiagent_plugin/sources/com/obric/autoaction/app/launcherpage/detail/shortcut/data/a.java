package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CreateTaskData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(Params.PROMPT)
    private final String f23525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("model_name")
    private final String f23526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("instruction_type")
    private final String f23527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("device_id")
    private final String f23528d;

    public a() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23525a, r6.f23525a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23526b, r6.f23526b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f23527c, r6.f23527c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f23528d, r6.f23528d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f23525a.hashCode() * 31) + this.f23526b.hashCode()) * 31) + this.f23527c.hashCode()) * 31) + this.f23528d.hashCode();
    }

    public String toString() {
        return "CheckTaskRequestData(prompt=" + this.f23525a + ", modelName=" + this.f23526b + ", instructionType=" + this.f23527c + ", deviceId=" + this.f23528d + ')';
    }

    public a(String r2, String r3, String r4, String r5) {
        o.e(r2, Params.PROMPT);
        o.e(r3, "modelName");
        o.e(r4, "instructionType");
        o.e(r5, "deviceId");
        this.f23525a = r2;
        this.f23526b = r3;
        this.f23527c = r4;
        this.f23528d = r5;
    }

    public /* synthetic */ a(String r2, String r3, String r4, String r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
