package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0018\bf\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003,-.R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010!\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\fR\u001a\u0010$\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0019R\u001a\u0010'\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\b\u001a\u0004\b%\u0010\u0006R\u001a\u0010*\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\b\u001a\u0004\b(\u0010\u0019¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleInviteMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/p0;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "()J", "getChannelId$annotations", "()V", RemoteMessageConst.Notification.CHANNEL_ID, "", "getInviteType", "()I", "getInviteType$annotations", "inviteType", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting$annotations", "battleConfigSetting", "getDurationTime", "getDurationTime$annotations", "durationTime", "", "getClientAttachedInfoStr", "()Ljava/lang/String;", "getClientAttachedInfoStr$annotations", "clientAttachedInfoStr", "getInviteTitle", "getInviteTitle$annotations", "inviteTitle", "getMultiPkMode", "getMultiPkMode$annotations", "multiPkMode", "getPrompts", "getPrompts$annotations", "prompts", "getBattleId", "getBattleId$annotations", "battleId", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "Companion", "BattleInviteType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MultiInviteType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkMicBattleInviteMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p0>, com.bytedance.android.livesdk.link.model.bridge.p0 {
    public static final a Companion = null;
    public static final int MULTI_PK_ACTIVITY = 5;
    public static final int MULTI_PK_AGAIN = 3;
    public static final int MULTI_PK_CHANGE_MODE = 6;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleInviteMessage$BattleInviteType;", "", "BattleInviteType_Unknown", "BattleInviteType_Again", "BattleInviteType_MultipleMatches3", "BattleInviteType_Multiple_Again", "BattleInviteType_Normal_Activity", "BattleInviteType_Multiple_Activity", "BattleInviteType_ChangeMultiPkMode", "BattleInviteType_OPENGAME", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleInviteType extends Enum<BattleInviteType> {
        public static final BattleInviteType BattleInviteType_Again = null;
        public static final BattleInviteType BattleInviteType_ChangeMultiPkMode = null;
        public static final BattleInviteType BattleInviteType_MultipleMatches3 = null;

        @Deprecated(message = "")
        public static final BattleInviteType BattleInviteType_Multiple_Activity = null;
        public static final BattleInviteType BattleInviteType_Multiple_Again = null;

        @Deprecated(message = "")
        public static final BattleInviteType BattleInviteType_Normal_Activity = null;
        public static final BattleInviteType BattleInviteType_OPENGAME = null;
        public static final BattleInviteType BattleInviteType_Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BattleInviteType[] f147042a = null;

        static {
            BattleInviteType r100 = new BattleInviteType("BattleInviteType_Unknown", 0);
            BattleInviteType_Unknown = r100;
            BattleInviteType r101 = new BattleInviteType("BattleInviteType_Again", 1);
            BattleInviteType_Again = r101;
            BattleInviteType r102 = new BattleInviteType("BattleInviteType_MultipleMatches3", 2);
            BattleInviteType_MultipleMatches3 = r102;
            BattleInviteType r103 = new BattleInviteType("BattleInviteType_Multiple_Again", 3);
            BattleInviteType_Multiple_Again = r103;
            BattleInviteType r104 = new BattleInviteType("BattleInviteType_Normal_Activity", 4);
            BattleInviteType_Normal_Activity = r104;
            BattleInviteType r105 = new BattleInviteType("BattleInviteType_Multiple_Activity", 5);
            BattleInviteType_Multiple_Activity = r105;
            BattleInviteType r106 = new BattleInviteType("BattleInviteType_ChangeMultiPkMode", 6);
            BattleInviteType_ChangeMultiPkMode = r106;
            BattleInviteType r107 = new BattleInviteType("BattleInviteType_OPENGAME", 7);
            BattleInviteType_OPENGAME = r107;
            f147042a = new BattleInviteType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static BattleInviteType valueOf(String r100) {
            return (BattleInviteType) r27.a.a(BattleInviteType.class, r100);
        }

        public static BattleInviteType[] values() {
            return (BattleInviteType[]) f147042a.clone();
        }

        public BattleInviteType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleInviteMessage$MultiInviteType;", "", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public @interface MultiInviteType {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147043a = null;

        public a() {
        }

        static {
            f147043a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147043a;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.p0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.p0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_config_setting")
    IBattleConfigSetting getBattleConfigSetting();

    @FieldName(name = "battle_id")
    long getBattleId();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfoStr();

    @Override // com.bytedance.android.livesdk.link.model.bridge.p0, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "duration_time")
    long getDurationTime();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_title")
    String getInviteTitle();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "multi_pk_mode")
    int getMultiPkMode();

    @FieldName(name = "multiple_again_prompts")
    String getPrompts();

    @Override // com.bytedance.android.livesdk.link.model.bridge.p0
    /* synthetic */ Long get_inviteUid();

    @Override // com.bytedance.android.livesdk.link.model.bridge.p0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
