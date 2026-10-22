package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/GroupJoinStatus;", "", "", "status", "I", "getStatus", "()I", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NOT_APPLY", "APLLYING", "ALREADY_IN", "GROUP_IS_FULL", "APPLY_TO_JOIN", "JOIN_NOW", "VIEW_CONDITIONS", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GroupJoinStatus extends Enum<GroupJoinStatus> {
    public static final GroupJoinStatus ALREADY_IN = null;
    public static final GroupJoinStatus APLLYING = null;
    public static final GroupJoinStatus APPLY_TO_JOIN = null;
    public static final a Companion = null;
    public static final GroupJoinStatus GROUP_IS_FULL = null;
    public static final GroupJoinStatus JOIN_NOW = null;
    public static final GroupJoinStatus NOT_APPLY = null;
    public static final GroupJoinStatus VIEW_CONDITIONS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupJoinStatus[] f53479a = null;
    private final String des;
    private final int status;

    public static final class a {
        public a() {
        }
    }

    static {
        GroupJoinStatus r100 = new GroupJoinStatus("NOT_APPLY", 0, 0, "申请加入");
        NOT_APPLY = r100;
        GroupJoinStatus r101 = new GroupJoinStatus("APLLYING", 1, 1, "已申请");
        APLLYING = r101;
        GroupJoinStatus r102 = new GroupJoinStatus("ALREADY_IN", 2, 2, "已加入");
        ALREADY_IN = r102;
        GroupJoinStatus r103 = new GroupJoinStatus("GROUP_IS_FULL", 3, 3, "群已满");
        GROUP_IS_FULL = r103;
        GroupJoinStatus r104 = new GroupJoinStatus("APPLY_TO_JOIN", 4, 4, "申请加入");
        APPLY_TO_JOIN = r104;
        GroupJoinStatus r105 = new GroupJoinStatus("JOIN_NOW", 5, 5, "加入");
        JOIN_NOW = r105;
        GroupJoinStatus r106 = new GroupJoinStatus("VIEW_CONDITIONS", 6, 6, "查看条件");
        VIEW_CONDITIONS = r106;
        f53479a = new GroupJoinStatus[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static GroupJoinStatus valueOf(String r100) {
        return (GroupJoinStatus) r27.a.a(GroupJoinStatus.class, r100);
    }

    public static GroupJoinStatus[] values() {
        return (GroupJoinStatus[]) f53479a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getStatus() {
        return this.status;
    }

    public GroupJoinStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.status = r102;
        this.des = r103;
    }
}
