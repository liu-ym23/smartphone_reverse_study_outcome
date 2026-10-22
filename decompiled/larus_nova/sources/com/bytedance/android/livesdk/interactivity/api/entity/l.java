package com.bytedance.android.livesdk.interactivity.api.entity;

import android.content.Context;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f133173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f133174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f133175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f133176d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f133174b, r101.f133174b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133175c, r101.f133175c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133176d, r101.f133176d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        t r100 = this.f133174b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Context r104 = this.f133175c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        r r107 = this.f133176d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPSOperatePanelEvent(clickMessage=" + this.f133174b + ", context=" + this.f133175c + ", callback=" + this.f133176d + ")";
    }

    public final Context getContext() {
        return this.f133175c;
    }

    public l(t r100, Context r101, r r102) {
        Intrinsics.checkNotNullParameter(r100, "clickMessage");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f133174b = r100;
        this.f133175c = r101;
        this.f133176d = r102;
        ALogger.d("PSOperatePanel", "create an OpenPSOperatePanelEvent");
    }
}
