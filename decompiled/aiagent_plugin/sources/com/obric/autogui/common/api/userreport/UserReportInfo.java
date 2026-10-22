package com.obric.autogui.common.api.userreport;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: UserReportInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UserReportInfo {
    private final List<String> extraPathsToUpload;
    private final String sessionId;
    private final String taskQuery;
    private final UserSpecifiedTaskStatus userSpecifiedTaskStatus;
    private final String userSuggestion;
    private final boolean userWantsUploadingJournal;

    /* JADX INFO: compiled from: UserReportInfo.kt */
    public static final enum UserSpecifiedTaskStatus extends Enum<UserSpecifiedTaskStatus> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ UserSpecifiedTaskStatus[] $VALUES = null;
        public static final UserSpecifiedTaskStatus TaskFailed = null;
        public static final UserSpecifiedTaskStatus TaskSucceeded = null;
        public static final UserSpecifiedTaskStatus TaskSucceededPartly = null;
        public static final UserSpecifiedTaskStatus Unspecified = null;

        private static final /* synthetic */ UserSpecifiedTaskStatus[] $values() {
            return new UserSpecifiedTaskStatus[]{TaskSucceeded, TaskSucceededPartly, TaskFailed, Unspecified};
        }

        public static a<UserSpecifiedTaskStatus> getEntries() {
            return $ENTRIES;
        }

        private UserSpecifiedTaskStatus(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TaskSucceeded = new UserSpecifiedTaskStatus("TaskSucceeded", 0);
            TaskSucceededPartly = new UserSpecifiedTaskStatus("TaskSucceededPartly", 1);
            TaskFailed = new UserSpecifiedTaskStatus("TaskFailed", 2);
            Unspecified = new UserSpecifiedTaskStatus("Unspecified", 3);
            UserSpecifiedTaskStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static UserSpecifiedTaskStatus valueOf(String r2) {
            return (UserSpecifiedTaskStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(UserSpecifiedTaskStatus.class, r2), UserSpecifiedTaskStatus.class, "com.obric.aiagent.plugin");
        }

        public static UserSpecifiedTaskStatus[] values() {
            return (UserSpecifiedTaskStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UserSpecifiedTaskStatus[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ UserReportInfo copy$default(UserReportInfo r7, String r8, String r9, UserSpecifiedTaskStatus r10, String r11, boolean r12, List r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.sessionId;
    L5:
        String r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.taskQuery;
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.userSpecifiedTaskStatus;
    L11:
        UserSpecifiedTaskStatus r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.userSuggestion;
    L14:
        String r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.userWantsUploadingJournal;
    L17:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L21;
        r16 = r7.extraPathsToUpload;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r16);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.taskQuery;
    }

    public final UserSpecifiedTaskStatus component3() {
        return this.userSpecifiedTaskStatus;
    }

    public final String component4() {
        return this.userSuggestion;
    }

    public final boolean component5() {
        return this.userWantsUploadingJournal;
    }

    public final List<String> component6() {
        return this.extraPathsToUpload;
    }

    public final UserReportInfo copy(String r8, String r9, UserSpecifiedTaskStatus r10, String r11, boolean r12, List<String> r13) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        o.e(r8, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r9, "taskQuery");
        o.e(r10, "userSpecifiedTaskStatus");
        o.e(r11, "userSuggestion");
        return new UserReportInfo(r8, r9, r10, r11, r12, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UserReportInfo.class) == true) goto L8;
        return false;
    L8:
        UserReportInfo r6 = (UserReportInfo) ZeusTransformUtils.preCheckCast(r5, UserReportInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r6.sessionId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.taskQuery, r6.taskQuery) == true) goto L15;
        return false;
    L15:
        if (this.userSpecifiedTaskStatus == r6.userSpecifiedTaskStatus) goto L18;
        return false;
    L18:
        if (o.a(this.userSuggestion, r6.userSuggestion) == true) goto L21;
        return false;
    L21:
        if (this.userWantsUploadingJournal == r6.userWantsUploadingJournal) goto L24;
        return false;
    L24:
        if (o.a(this.extraPathsToUpload, r6.extraPathsToUpload) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.sessionId.hashCode() * 31) + this.taskQuery.hashCode()) * 31) + this.userSpecifiedTaskStatus.hashCode()) * 31) + this.userSuggestion.hashCode()) * 31) + Boolean.hashCode(this.userWantsUploadingJournal)) * 31;
        List<String> r2 = this.extraPathsToUpload;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "UserReportInfo(sessionId=" + this.sessionId + ", taskQuery=" + this.taskQuery + ", userSpecifiedTaskStatus=" + this.userSpecifiedTaskStatus + ", userSuggestion=" + this.userSuggestion + ", userWantsUploadingJournal=" + this.userWantsUploadingJournal + ", extraPathsToUpload=" + this.extraPathsToUpload + ')';
    }

    public UserReportInfo(String r3, String r4, UserSpecifiedTaskStatus r5, String r6, boolean r7, List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r4, "taskQuery");
        o.e(r5, "userSpecifiedTaskStatus");
        o.e(r6, "userSuggestion");
        this.sessionId = r3;
        this.taskQuery = r4;
        this.userSpecifiedTaskStatus = r5;
        this.userSuggestion = r6;
        this.userWantsUploadingJournal = r7;
        this.extraPathsToUpload = r9;
    }

    public /* synthetic */ UserReportInfo(String r8, String r9, UserSpecifiedTaskStatus r10, String r11, boolean r12, List r13, int r14, h r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 32) == 0) goto L5;
        r16 = null;
    L5:
        this(r8, r9, r10, r11, r12, r16);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskQuery() {
        return this.taskQuery;
    }

    public final UserSpecifiedTaskStatus getUserSpecifiedTaskStatus() {
        return this.userSpecifiedTaskStatus;
    }

    public final String getUserSuggestion() {
        return this.userSuggestion;
    }

    public final boolean getUserWantsUploadingJournal() {
        return this.userWantsUploadingJournal;
    }

    public final List<String> getExtraPathsToUpload() {
        return this.extraPathsToUpload;
    }
}
