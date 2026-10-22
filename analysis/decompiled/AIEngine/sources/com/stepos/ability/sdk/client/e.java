package com.stepos.ability.sdk.client;

import android.os.Bundle;
import com.stepos.ability.bean.TaskUiInfo;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5585a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskUiInfo f5586b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5587c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f5588d;

    public e(String taskId, TaskUiInfo taskUiInfo, Bundle bundle) {
        g.f(taskId, "taskId");
        this.f5585a = taskId;
        this.f5586b = taskUiInfo;
        this.f5587c = 2;
        this.f5588d = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return g.b(this.f5585a, eVar.f5585a) && g.b(this.f5586b, eVar.f5586b) && this.f5587c == eVar.f5587c && g.b(this.f5588d, eVar.f5588d);
    }

    public final int hashCode() {
        int iHashCode = this.f5585a.hashCode() * 31;
        TaskUiInfo taskUiInfo = this.f5586b;
        int iD = ai.onnxruntime.a.d(this.f5587c, (iHashCode + (taskUiInfo == null ? 0 : taskUiInfo.hashCode())) * 31, 29791);
        Bundle bundle = this.f5588d;
        return iD + (bundle != null ? bundle.hashCode() : 0);
    }

    public final String toString() {
        return "CommonConfig(taskId=" + this.f5585a + ", taskUiInfo=" + this.f5586b + ", priority=" + this.f5587c + ", parentTaskId=null, condition=null, extra=" + this.f5588d + ")";
    }
}
