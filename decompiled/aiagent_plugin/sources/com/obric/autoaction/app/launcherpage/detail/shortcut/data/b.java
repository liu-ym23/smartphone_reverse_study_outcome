package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CreateTaskData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DBHelper.BATTERY_COL_SCENE)
    private final String f23529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("reply")
    private final String f23530b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23529a, r6.f23529a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23530b, r6.f23530b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f23529a.hashCode() * 31) + this.f23530b.hashCode();
    }

    public String toString() {
        return "CheckTaskResponseData(scene=" + this.f23529a + ", reply=" + this.f23530b + ')';
    }

    public final String a() {
        return this.f23529a;
    }

    public final String b() {
        return this.f23530b;
    }
}
