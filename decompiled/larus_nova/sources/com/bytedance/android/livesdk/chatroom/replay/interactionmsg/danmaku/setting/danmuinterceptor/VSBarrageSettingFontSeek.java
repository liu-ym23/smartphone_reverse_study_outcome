package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.ReplayBarrageSettingDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSettingFont;
import com.bytedance.live.datacontext.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/danmuinterceptor/VSBarrageSettingFontSeek;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/danmuinterceptor/AbsReplayDanmakuSettingSeekView;", "", "getTitle", "", "getStepCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSBarrageSettingFontSeek extends AbsReplayDanmakuSettingSeekView {
    public VSBarrageSettingFontSeek(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSBarrageSettingFontSeek(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public int getStepCount() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public String getTitle() {
        return "字号";
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final String R5(int r100) {
        if (r100 != 0) goto L4;
        ReplayBarrageSettingFont r101 = ReplayBarrageSettingFont.SMALL;
    L15:
        return r101.getDes();
    L4:
        if (r100 != 1) goto L6;
        r101 = ReplayBarrageSettingFont.MID;
        goto L15
    L6:
        if (r100 != 2) goto L8;
        r101 = ReplayBarrageSettingFont.BIG;
        goto L15
    L8:
        if (r100 == 3) goto L10;
        r101 = ReplayBarrageSettingFont.MID;
        goto L15
    L10:
        r101 = ReplayBarrageSettingFont.LARGE;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final int S5(ReplayBarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        return r100.getFontSize().getLevel();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final void T5(int r100) {
        ReplayBarrageSettingDataContext.a r101 = ReplayBarrageSettingDataContext.Companion;
        ReplayBarrageSettingDataContext r102 = r101.getContext();
        if (r102 == null) goto L7;
        n<ReplayBarrageSetting> r103 = r102.getBarrageSetting();
        if (r103 == null) goto L7;
        ReplayBarrageSetting r104 = r103.getValue();
    L8:
        if (r104 == null) goto L22;
        if (r100 != 0) goto L11;
        ReplayBarrageSettingFont r105 = ReplayBarrageSettingFont.SMALL;
    L21:
        r104.setFontSize(r105);
        goto L22
    L11:
        if (r100 != 1) goto L13;
        r105 = ReplayBarrageSettingFont.MID;
        goto L21
    L13:
        if (r100 != 2) goto L15;
        r105 = ReplayBarrageSettingFont.BIG;
        goto L21
    L15:
        if (r100 == 3) goto L17;
        r105 = ReplayBarrageSettingFont.MID;
        goto L21
    L17:
        r105 = ReplayBarrageSettingFont.LARGE;
    L22:
        ReplayBarrageSettingDataContext r106 = r101.getContext();
        if (r106 == null) goto L28;
        n<ReplayBarrageSetting> r107 = r106.getBarrageSetting();
        if (r107 == null) goto L29;
        r107.setValue(r104);
        return;
    L29:
        return;
    L28:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public VSBarrageSettingFontSeek(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ VSBarrageSettingFontSeek(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
