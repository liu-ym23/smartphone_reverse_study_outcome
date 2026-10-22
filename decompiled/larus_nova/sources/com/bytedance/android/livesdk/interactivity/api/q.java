package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f133747a = null;

    public q() {
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l a() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> r101 = r100.getAudienceOperateManager();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.b b() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r101 = r100.getBarrageContext();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final EffectiveActivityEmojiGroup c() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r101 = r100.getActivityEmojiManager();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r102 = r101.getValue();
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.a();
    L11:
        return null;
    L10:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.emoji.e d() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> r101 = r100.getFusionEmojiManager();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final String e() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r101 = r100.getLowPcuGuideChatManager();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r102 = r101.getValue();
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.getCity();
    L11:
        return null;
    L10:
        return null;
    }

    @JvmStatic
    public static final i6 f() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r101 = r100.getLowPcuGuideChatManager();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r102 = r101.getValue();
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.getLowPcuGuideChatData();
    L11:
        return null;
    L10:
        return null;
    }

    public static final IntercomSyncDataModel h() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<IntercomSyncDataModel> r101 = r100.getIntercomSyncDataModel();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.l i() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r101 = r100.getPublicScreenContext();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final boolean k() {
        h r100 = i.b(null, 3);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r101 = r100.getLowPcuGuideChatManager();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.a();
    L9:
        return false;
    }

    static {
        f133747a = new q();
    }

    public static final h g() {
        Object r100 = com.bytedance.live.datacontext.d.d(h.class);
        if ((r100 instanceof h) == true) goto L6;
        r100 = null;
    L6:
        return (h) r100;
    }

    public static RiskAdviseSyncModel j(DataCenter r100) {
        h r101 = i.a(null, r100);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.j<RiskAdviseSyncModel> r102 = r101.getRiskAdviseSyncModel();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getValue();
    L8:
        return null;
    }
}
