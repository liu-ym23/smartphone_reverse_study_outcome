package com.obric.agent.autoaction;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricSessionInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("is_timer_task")
    private final int f14242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("is_repeat_timer_task")
    private final int f14243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("widget_state_enum")
    private final int f14244c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f14242a == r6.f14242a) goto L12;
        return false;
    L12:
        if (this.f14243b == r6.f14243b) goto L15;
        return false;
    L15:
        if (this.f14244c == r6.f14244c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f14242a) * 31) + Integer.hashCode(this.f14243b)) * 31) + Integer.hashCode(this.f14244c);
    }

    public String toString() {
        return "ObricSessionInfo(isTimerTask=" + this.f14242a + ", isRepeatTimerTask=" + this.f14243b + ", state=" + this.f14244c + ')';
    }

    public final int a() {
        return this.f14244c;
    }
}
