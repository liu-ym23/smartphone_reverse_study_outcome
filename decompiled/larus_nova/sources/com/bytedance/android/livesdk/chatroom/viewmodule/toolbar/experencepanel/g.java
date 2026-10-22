package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f116285a;

    public g() {
        this.f116285a = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String a(g r100) {
        r100.getClass();
        if (((Boolean) o61.a.f522161h.f64752a).booleanValue() == false) goto L5;
        k61.a r101 = o61.a.f522155b;
        if (r101 == null) goto L28;
        boolean r102 = true;
        if (r101.f501947c != LivePerfBizType.Degrade) goto L13;
        boolean r103 = true;
    L14:
        if (r103 != true) goto L28;
        k61.a r104 = o61.a.f522155b;
        if (r104 == null) goto L25;
        LivePerfBizLevel r105 = r104.f501948d;
        if (r105 == null) goto L25;
        if (r105.compareTo(LivePerfBizLevel.P1) >= 0) goto L23;
        r102 = false;
    L23:
        if (r102 == false) goto L25;
    L26:
        if (r105 == null) goto L28;
        return "当前性能状态一般，已为你进行极致优化，重启APP将自动关闭极致流畅看播";
    L25:
        r105 = null;
        goto L26
    L13:
        r103 = false;
    L28:
        return "当前性能状态优秀，无需极致优化，重启APP将自动关闭极致流畅看播";
    L5:
        if (PlatformExpUtils.c().i() == false) goto L7;
        return "开启后将为你屏蔽礼物特效、进房特效等其他高功耗功能，可大幅提升看播流畅性";
    L7:
        return "开启后将为你屏蔽礼物特效、进房特效、全服广播等信息，可大幅提升看播流畅性";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String b(g r100) {
        r100.getClass();
        if (((Boolean) o61.a.f522159f.f64752a).booleanValue() == true) goto L6;
        return "开启后，将自动为你优化功耗&动画表现，降低性能负载，实现较流畅的看播";
    L6:
        return "当前性能状态一般，已为你进行优化，开关有效期为" + PlatformExpUtils.c().j() + 22825;
    }
}
