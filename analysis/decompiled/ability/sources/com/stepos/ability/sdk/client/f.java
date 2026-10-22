package com.stepos.ability.sdk.client;

import android.os.Bundle;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f3251a;
    public final int b;
    public final Bundle c;

    public f(String taskId, Bundle bundle) {
        k.f(taskId, "taskId");
        this.f3251a = taskId;
        this.b = 2;
        this.c = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.b(this.f3251a, fVar.f3251a) && this.b == fVar.b && k.b(this.c, fVar.c);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, this.f3251a.hashCode() * 961, 29791);
        Bundle bundle = this.c;
        return iA + (bundle == null ? 0 : bundle.hashCode());
    }

    public final String toString() {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(this.b, "CommonConfig(taskId=", this.f3251a, ", taskUiInfo=null, priority=", ", parentTaskId=null, condition=null, extra=");
        sbT.append(this.c);
        sbT.append(")");
        return sbT.toString();
    }
}
