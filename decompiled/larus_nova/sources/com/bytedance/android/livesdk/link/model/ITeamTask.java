package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0006\u0017\u0018\u0019\u001a\u001b\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR:\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask;", "Lvh7/c;", "", "getTriggerUid", "()Ljava/lang/String;", "getTriggerUid$annotations", "()V", "triggerUid", "Lcom/bytedance/android/livesdk/link/model/q9;", "getTeamTaskConfig", "()Lcom/bytedance/android/livesdk/link/model/q9;", "getTeamTaskConfig$annotations", "teamTaskConfig", "", "Lcom/bytedance/android/livesdk/link/model/r9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTeamTaskInfoMap", "()Ljava/util/Map;", "getTeamTaskInfoMap$annotations", "teamTaskInfoMap", "getBattleId", "getBattleId$annotations", "battleId", "Period", "Result", "RewardTeamTaskType", "Role", "TargetTeamTaskType", "Type", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ITeamTask extends vh7.c<ITeamTask> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Period;", "", "PeriodUndefined", "PeriodTips", "PeriodNotice", "PeriodTask", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Period extends Enum<Period> {
        public static final Period PeriodNotice = null;
        public static final Period PeriodTask = null;
        public static final Period PeriodTips = null;
        public static final Period PeriodUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Period[] f147071a = null;

        static {
            Period r100 = new Period("PeriodUndefined", 0);
            PeriodUndefined = r100;
            Period r101 = new Period("PeriodTips", 1);
            PeriodTips = r101;
            Period r102 = new Period("PeriodNotice", 2);
            PeriodNotice = r102;
            Period r103 = new Period("PeriodTask", 3);
            PeriodTask = r103;
            f147071a = new Period[]{r100, r101, r102, r103};
        }

        public static Period valueOf(String r100) {
            return (Period) r27.a.a(Period.class, r100);
        }

        public static Period[] values() {
            return (Period[]) f147071a.clone();
        }

        public Period(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Result;", "", "ResultUndefined", "ResultSuccess", "ResultFailed", "ResultNotUpdate", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Result extends Enum<Result> {
        public static final Result ResultFailed = null;
        public static final Result ResultNotUpdate = null;
        public static final Result ResultSuccess = null;
        public static final Result ResultUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f147072a = null;

        static {
            Result r100 = new Result("ResultUndefined", 0);
            ResultUndefined = r100;
            Result r101 = new Result("ResultSuccess", 1);
            ResultSuccess = r101;
            Result r102 = new Result("ResultFailed", 2);
            ResultFailed = r102;
            Result r103 = new Result("ResultNotUpdate", 3);
            ResultNotUpdate = r103;
            f147072a = new Result[]{r100, r101, r102, r103};
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        public static Result[] values() {
            return (Result[]) f147072a.clone();
        }

        public Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$RewardTeamTaskType;", "", "RewardUndefined", "InstantKill", "BonusBattleScore", "MultipleBattleScore", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RewardTeamTaskType extends Enum<RewardTeamTaskType> {
        public static final RewardTeamTaskType BonusBattleScore = null;
        public static final RewardTeamTaskType InstantKill = null;
        public static final RewardTeamTaskType MultipleBattleScore = null;
        public static final RewardTeamTaskType RewardUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RewardTeamTaskType[] f147073a = null;

        static {
            RewardTeamTaskType r100 = new RewardTeamTaskType("RewardUndefined", 0);
            RewardUndefined = r100;
            RewardTeamTaskType r101 = new RewardTeamTaskType("InstantKill", 1);
            InstantKill = r101;
            RewardTeamTaskType r102 = new RewardTeamTaskType("BonusBattleScore", 2);
            BonusBattleScore = r102;
            RewardTeamTaskType r103 = new RewardTeamTaskType("MultipleBattleScore", 3);
            MultipleBattleScore = r103;
            f147073a = new RewardTeamTaskType[]{r100, r101, r102, r103};
        }

        public static RewardTeamTaskType valueOf(String r100) {
            return (RewardTeamTaskType) r27.a.a(RewardTeamTaskType.class, r100);
        }

        public static RewardTeamTaskType[] values() {
            return (RewardTeamTaskType[]) f147073a.clone();
        }

        public RewardTeamTaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Role;", "", "RoleUndefined", "RoleAttacker", "RoleDefender", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Role extends Enum<Role> {
        public static final Role RoleAttacker = null;
        public static final Role RoleDefender = null;
        public static final Role RoleUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Role[] f147074a = null;

        static {
            Role r100 = new Role("RoleUndefined", 0);
            RoleUndefined = r100;
            Role r101 = new Role("RoleAttacker", 1);
            RoleAttacker = r101;
            Role r102 = new Role("RoleDefender", 2);
            RoleDefender = r102;
            f147074a = new Role[]{r100, r101, r102};
        }

        public static Role valueOf(String r100) {
            return (Role) r27.a.a(Role.class, r100);
        }

        public static Role[] values() {
            return (Role[]) f147074a.clone();
        }

        public Role(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$TargetTeamTaskType;", "", "TargetUndefined", "UserCount", "FansUserCount", "BattleScoreCount", "BattleScoreRatio", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TargetTeamTaskType extends Enum<TargetTeamTaskType> {
        public static final TargetTeamTaskType BattleScoreCount = null;
        public static final TargetTeamTaskType BattleScoreRatio = null;
        public static final TargetTeamTaskType FansUserCount = null;
        public static final TargetTeamTaskType TargetUndefined = null;
        public static final TargetTeamTaskType UserCount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TargetTeamTaskType[] f147075a = null;

        static {
            TargetTeamTaskType r100 = new TargetTeamTaskType("TargetUndefined", 0);
            TargetUndefined = r100;
            TargetTeamTaskType r101 = new TargetTeamTaskType("UserCount", 1);
            UserCount = r101;
            TargetTeamTaskType r102 = new TargetTeamTaskType("FansUserCount", 2);
            FansUserCount = r102;
            TargetTeamTaskType r103 = new TargetTeamTaskType("BattleScoreCount", 3);
            BattleScoreCount = r103;
            TargetTeamTaskType r104 = new TargetTeamTaskType("BattleScoreRatio", 4);
            BattleScoreRatio = r104;
            f147075a = new TargetTeamTaskType[]{r100, r101, r102, r103, r104};
        }

        public static TargetTeamTaskType valueOf(String r100) {
            return (TargetTeamTaskType) r27.a.a(TargetTeamTaskType.class, r100);
        }

        public static TargetTeamTaskType[] values() {
            return (TargetTeamTaskType[]) f147075a.clone();
        }

        public TargetTeamTaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Type;", "", "TypeUndefined", "TypeUserCount", "TypeScoreCount", "TypeInstantKill", "TypeFansClubUserCount", "TypeSpecialGiftCount", "TypeTaskCard", "TypeSummitInstantKill", "TypeConfigurableTask", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> {
        public static final Type TypeConfigurableTask = null;
        public static final Type TypeFansClubUserCount = null;
        public static final Type TypeInstantKill = null;
        public static final Type TypeScoreCount = null;
        public static final Type TypeSpecialGiftCount = null;
        public static final Type TypeSummitInstantKill = null;
        public static final Type TypeTaskCard = null;
        public static final Type TypeUndefined = null;
        public static final Type TypeUserCount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f147076a = null;

        static {
            Type r100 = new Type("TypeUndefined", 0);
            TypeUndefined = r100;
            Type r101 = new Type("TypeUserCount", 1);
            TypeUserCount = r101;
            Type r102 = new Type("TypeScoreCount", 2);
            TypeScoreCount = r102;
            Type r103 = new Type("TypeInstantKill", 3);
            TypeInstantKill = r103;
            Type r104 = new Type("TypeFansClubUserCount", 4);
            TypeFansClubUserCount = r104;
            Type r105 = new Type("TypeSpecialGiftCount", 5);
            TypeSpecialGiftCount = r105;
            Type r106 = new Type("TypeTaskCard", 6);
            TypeTaskCard = r106;
            Type r107 = new Type("TypeSummitInstantKill", 7);
            TypeSummitInstantKill = r107;
            Type r108 = new Type("TypeConfigurableTask", 8);
            TypeConfigurableTask = r108;
            f147076a = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f147076a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_id")
    String getBattleId();

    @FieldName(name = "config")
    q9 getTeamTaskConfig();

    @FieldName(name = "info")
    Map<String, r9> getTeamTaskInfoMap();

    @FieldName(name = "trigger_open_id")
    String getTriggerUid();
}
