package com.bytedance.android.livesdk.link.model;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR$\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010 R$\u0010$\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010 R$\u0010'\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010 ¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSettingExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkMicBattleSetting;", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFinished", "()J", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "getChannelId", RemoteMessageConst.Notification.CHANNEL_ID, "getDuration", "duration", "getStartTimeMs", "startTimeMs", "", "getTheme", "()Ljava/lang/String;", "theme", "getBattleId", "battleId", "getMatchType", "matchType", "value", "getPlayMode", "setPlayMode", "(J)V", Keys.API_EVENT_KEY_PLAY_MODE, "getTeamMode", "setTeamMode", "teamMode", "getActivityMode", "setActivityMode", "activityMode", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkMicBattleSetting;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBattleSettingExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting, ILinkMicBattleSetting> implements ILinkMicBattleSetting, com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting {
    private final /* synthetic */ com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getActivityMode() {
        return ((Number) get(11, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getBattleId() {
        return ((Number) get(7, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getChannelId() {
        return ((Number) get(1, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getDuration() {
        return ((Number) get(2, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getFinished() {
        return ((Number) get(6, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getMatchType() {
        return ((Number) get(8, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getPlayMode() {
        return ((Number) get(9, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getStartTimeMs() {
        return ((Number) get(4, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public long getTeamMode() {
        return ((Number) get(10, ILinkMicBattleSetting.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public String getTheme() {
        return (String) get(5, ILinkMicBattleSetting.class, "");
    }

    public ILinkMicBattleSettingExtensionImpl(com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public void setActivityMode(long r100) {
        set(11, "activity_mode", ILinkMicBattleSetting.class, Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public void setPlayMode(long r100) {
        set(9, FastStartLiveConfig.PLAY_MODE, ILinkMicBattleSetting.class, Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting
    public void setTeamMode(long r100) {
        set(10, "team_mode", ILinkMicBattleSetting.class, Long.valueOf(r100));
    }
}
