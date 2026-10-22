package com.bytedance.android.live.broadcastgame.api.model;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z extends o2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f59384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f59385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x3 f59386c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L12;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f59384a, r101.f59384a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59385b, r101.f59385b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f59386c, r101.f59386c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Context r100 = this.f59384a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DataCenter r104 = this.f59385b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        x3 r107 = this.f59386c;
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
        return "LiveFeaturePanelBehaviorExtra(context=" + this.f59384a + ", dataCenter=" + this.f59385b + ", toolbarManager=" + this.f59386c + ")";
    }

    public final Context getContext() {
        return this.f59384a;
    }

    public z(Context r100, DataCenter r101, g3 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f59384a = r100;
        this.f59385b = r101;
        this.f59386c = r102;
    }
}
