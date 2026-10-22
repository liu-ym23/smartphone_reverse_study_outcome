package com.bytedance.android.livesdk.link.model.api;

import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.h3;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
public interface IBaseBattleSetting {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/api/IBaseBattleSetting$BattleStatus;", "", "BattleStatus_Unknown", "BattleStatus_Playing", "BattleStatus_Punishing", "BattleStatus_Finished", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleStatus extends Enum<BattleStatus> {
        public static final BattleStatus BattleStatus_Finished = null;
        public static final BattleStatus BattleStatus_Playing = null;
        public static final BattleStatus BattleStatus_Punishing = null;
        public static final BattleStatus BattleStatus_Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BattleStatus[] f147081a = null;

        static {
            BattleStatus r100 = new BattleStatus("BattleStatus_Unknown", 0);
            BattleStatus_Unknown = r100;
            BattleStatus r101 = new BattleStatus("BattleStatus_Playing", 1);
            BattleStatus_Playing = r101;
            BattleStatus r102 = new BattleStatus("BattleStatus_Punishing", 2);
            BattleStatus_Punishing = r102;
            BattleStatus r103 = new BattleStatus("BattleStatus_Finished", 3);
            BattleStatus_Finished = r103;
            f147081a = new BattleStatus[]{r100, r101, r102, r103};
        }

        public static BattleStatus valueOf(String r100) {
            return (BattleStatus) a.a(BattleStatus.class, r100);
        }

        public static BattleStatus[] values() {
            return (BattleStatus[]) f147081a.clone();
        }

        public BattleStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    IBattleBarConfig getBarConfig();

    IBattleConfigSetting getBattleConfigSetting();

    long getBattleId();

    int getBattleType();

    boolean getDisplayLastResult();

    long getDuration();

    int getInviteType();

    String getLynxData();

    long getMatchType();

    int getMode();

    boolean getNeedCloseLinkmic();

    h3 getPunishConfig();

    long getPunishDuration();

    boolean getPunishOptimizeOn();

    long getPunishStartTimeMs();

    long getStartTimeMs();

    long getStatusDisplayDuration();

    long getStealTowerDuration();

    h3 getTitleConfig();

    long get_bloodDisplayDuration();

    void setPunishDuration(long r100);
}
