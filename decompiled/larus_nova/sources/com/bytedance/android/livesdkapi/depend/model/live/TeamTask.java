package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.TeamTask")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTask;", "", "()V", "teamTaskConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskConfig;", "getTeamTaskConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskConfig;", "setTeamTaskConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskConfig;)V", "teamTaskInfoMap", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskInfo;", "getTeamTaskInfoMap", "()Ljava/util/Map;", "setTeamTaskInfoMap", "(Ljava/util/Map;)V", "Period", "Role", "Type", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamTask implements h {

    @SerializedName("config")
    protected TeamTaskConfig teamTaskConfig;

    @SerializedName("info")
    protected Map<String, TeamTaskInfo> teamTaskInfoMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTask$Period;", "", "(Ljava/lang/String;I)V", "PeriodUndefined", "PeriodTips", "PeriodNotice", "PeriodTask", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Period extends Enum<Period> {
        private static final /* synthetic */ Period[] $VALUES = null;
        public static final Period PeriodNotice = null;
        public static final Period PeriodTask = null;
        public static final Period PeriodTips = null;
        public static final Period PeriodUndefined = null;

        static {
            Period r100 = new Period("PeriodUndefined", 0);
            PeriodUndefined = r100;
            Period r101 = new Period("PeriodTips", 1);
            PeriodTips = r101;
            Period r102 = new Period("PeriodNotice", 2);
            PeriodNotice = r102;
            Period r103 = new Period("PeriodTask", 3);
            PeriodTask = r103;
            $VALUES = new Period[]{r100, r101, r102, r103};
        }

        public static Period valueOf(String r100) {
            return (Period) a.a(Period.class, r100);
        }

        public static Period[] values() {
            return (Period[]) $VALUES.clone();
        }

        private Period(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTask$Role;", "", "(Ljava/lang/String;I)V", "RoleUndefined", "RoleAttacker", "RoleDefender", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Role extends Enum<Role> {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final Role RoleAttacker = null;
        public static final Role RoleDefender = null;
        public static final Role RoleUndefined = null;

        static {
            Role r100 = new Role("RoleUndefined", 0);
            RoleUndefined = r100;
            Role r101 = new Role("RoleAttacker", 1);
            RoleAttacker = r101;
            Role r102 = new Role("RoleDefender", 2);
            RoleDefender = r102;
            $VALUES = new Role[]{r100, r101, r102};
        }

        public static Role valueOf(String r100) {
            return (Role) a.a(Role.class, r100);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        private Role(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTask$Type;", "", "(Ljava/lang/String;I)V", "TypeUndefined", "TypeUserCount", "TypeScoreCount", "TypeInstantKill", "TypeFansClubUserCount", "TypeSpecialGiftCount", "TypeTaskCard", "TypeSummitInstantKill", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type TypeFansClubUserCount = null;
        public static final Type TypeInstantKill = null;
        public static final Type TypeScoreCount = null;
        public static final Type TypeSpecialGiftCount = null;
        public static final Type TypeSummitInstantKill = null;
        public static final Type TypeTaskCard = null;
        public static final Type TypeUndefined = null;
        public static final Type TypeUserCount = null;

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
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TeamTask() {
    }

    public TeamTask(g r110) {
        this.teamTaskInfoMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.teamTaskConfig = new TeamTaskConfig(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        String r103 = null;
        TeamTaskInfo r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = new TeamTaskInfo(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<String, TeamTaskInfo> r106 = this.teamTaskInfoMap;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
    }

    public final TeamTaskConfig getTeamTaskConfig() {
        return this.teamTaskConfig;
    }

    public final Map<String, TeamTaskInfo> getTeamTaskInfoMap() {
        return this.teamTaskInfoMap;
    }

    public final void setTeamTaskConfig(TeamTaskConfig r100) {
        this.teamTaskConfig = r100;
    }

    public final void setTeamTaskInfoMap(Map<String, TeamTaskInfo> r100) {
        this.teamTaskInfoMap = r100;
    }
}
