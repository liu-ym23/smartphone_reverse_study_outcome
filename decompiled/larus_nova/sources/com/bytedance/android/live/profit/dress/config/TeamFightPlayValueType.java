package com.bytedance.android.live.profit.dress.config;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/TeamFightPlayValueType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "RedTeam", "BlueTeam", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TeamFightPlayValueType extends Enum<TeamFightPlayValueType> {
    public static final TeamFightPlayValueType BlueTeam = null;
    public static final a Companion = null;
    public static final TeamFightPlayValueType RedTeam = null;
    public static final TeamFightPlayValueType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamFightPlayValueType[] f87094a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.TeamFightPlayValueType$a] */
    static {
        TeamFightPlayValueType r100 = new TeamFightPlayValueType("Unknown", 0, 0);
        Unknown = r100;
        TeamFightPlayValueType r101 = new TeamFightPlayValueType("RedTeam", 1, 1);
        RedTeam = r101;
        TeamFightPlayValueType r102 = new TeamFightPlayValueType("BlueTeam", 2, 2);
        BlueTeam = r102;
        f87094a = new TeamFightPlayValueType[]{r100, r101, r102};
        Companion = new a();
    }

    public static TeamFightPlayValueType valueOf(String r100) {
        return (TeamFightPlayValueType) r27.a.a(TeamFightPlayValueType.class, r100);
    }

    public static TeamFightPlayValueType[] values() {
        return (TeamFightPlayValueType[]) f87094a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TeamFightPlayValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
