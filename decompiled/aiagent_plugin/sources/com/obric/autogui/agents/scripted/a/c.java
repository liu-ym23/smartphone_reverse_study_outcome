package com.obric.autogui.agents.scripted.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f26857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("data")
    private final l f26858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("implementName")
    private final String f26859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName(WsConstants.KEY_CONNECTION_ERROR)
    private final String f26860d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26857a, r6.f26857a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26858b, r6.f26858b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26859c, r6.f26859c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26860d, r6.f26860d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26857a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        l r4 = this.f26858b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26859c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f26860d;
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
        return "EngineResponse(type=" + this.f26857a + ", data=" + this.f26858b + ", implementName=" + this.f26859c + ", error=" + this.f26860d + ')';
    }

    public final String getType() {
        return this.f26857a;
    }

    public final l a() {
        return this.f26858b;
    }

    public final String b() {
        String r0 = this.f26859c;
        if (r0 != null) goto L6;
        return DownloadSettingKeys.BugFix.DEFAULT;
    L6:
        return r0;
    }

    public final String c() {
        l r0 = this.f26858b;
        boolean r1 = true;
        if (r0 == null) goto L16;
        String r2 = r0.d();
        if (r2 == null) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L16;
        return r2;
    L9:
        r5 = false;
    L16:
        String r6 = this.f26860d;
        if (r6 != null) goto L19;
        return null;
    L19:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L22;
        r1 = false;
    L22:
        if (r1 == true) goto L24;
        return null;
    L24:
        return r6;
    }
}
