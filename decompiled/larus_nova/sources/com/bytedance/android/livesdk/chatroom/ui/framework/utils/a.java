package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.utils.r2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo1.b f113029a;

    public a(fo1.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f113029a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.utils.e
    public final void report(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        com.bytedance.android.livesdk.room.b r102 = this.f113029a.f478070t;
        if (r102 == null) goto L7;
        AbilityCenter r103 = r102.f510513b;
        if (r103 == null) goto L7;
        q81.b r104 = (q81.b) r103.getAbility(q81.b.class);
    L8:
        if (r104 == null) goto L15;
        APMEvent.Level r105 = APMEvent.Level.I;
        if (r2.a(r101) == false) goto L12;
        String r106 = "interaction->" + r100 + ": " + r101;
    L13:
        r104.ai(com.bytedance.android.live.livepullstream.api.apm.a.a(r105, r106));
        return;
    L12:
        r106 = "interaction->".concat(r100);
        goto L13
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
