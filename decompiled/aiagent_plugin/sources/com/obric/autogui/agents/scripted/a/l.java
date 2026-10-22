package com.obric.autogui.agents.scripted.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ScriptStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("finished")
    private final Boolean f26881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("action")
    private final a f26882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("resultContent")
    private final List<String> f26883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_CONNECTION_ERROR)
    private final String f26884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("errorStack")
    private final String f26885e;

    @SerializedName("shouldRecordBlock")
    private final Boolean f;

    @SerializedName("blockAbilityInSession")
    private final Boolean g;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26881a, r6.f26881a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26882b, r6.f26882b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26883c, r6.f26883c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26884d, r6.f26884d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26885e, r6.f26885e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.f26881a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        a r4 = this.f26882b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f26883c.hashCode()) * 31;
        String r7 = this.f26884d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f26885e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.g;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "ScriptStepResult(finished=" + this.f26881a + ", action=" + this.f26882b + ", resultContent=" + this.f26883c + ", error=" + this.f26884d + ", errorStack=" + this.f26885e + ", shouldRecordBlock=" + this.f + ", blockAbilityInSession=" + this.g + ')';
    }

    public final Boolean a() {
        return this.f26881a;
    }

    public final a b() {
        return this.f26882b;
    }

    public final List<String> c() {
        return this.f26883c;
    }

    public final String d() {
        return this.f26884d;
    }

    public final String e() {
        return this.f26885e;
    }

    public final Boolean f() {
        return this.f;
    }

    public final Boolean g() {
        return this.g;
    }
}
