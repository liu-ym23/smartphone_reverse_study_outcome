package com.obric.autogui.common.api.platform.account;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionAccountApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionAccountApi {

    /* JADX INFO: compiled from: IAutoActionAccountApi.kt */
    public static final class LoggedOnCheckResult {
        private final LoggedOnType type;

        public static /* synthetic */ LoggedOnCheckResult copy$default(LoggedOnCheckResult r0, LoggedOnType r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            return r0.copy(r1);
        }

        public final LoggedOnType component1() {
            return this.type;
        }

        public final LoggedOnCheckResult copy(LoggedOnType r1) {
            o.e(r1, "type");
            return new LoggedOnCheckResult(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, LoggedOnCheckResult.class) == true) goto L8;
            return false;
        L8:
            LoggedOnCheckResult r6 = (LoggedOnCheckResult) ZeusTransformUtils.preCheckCast(r5, LoggedOnCheckResult.class, "com.obric.aiagent.plugin");
            if (this.type == r6.type) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "LoggedOnCheckResult(type=" + this.type + ')';
        }

        public LoggedOnCheckResult(LoggedOnType r2) {
            o.e(r2, "type");
            this.type = r2;
        }

        public final LoggedOnType getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: IAutoActionAccountApi.kt */
    public static final enum LoggedOnType extends Enum<LoggedOnType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ LoggedOnType[] $VALUES = null;
        public static final LoggedOnType DOUBAO_LOGGED_ON_STATE_NOT_SPECIFIED = null;
        public static final LoggedOnType DOUBAO_NOT_LOGGED_ON = null;
        public static final LoggedOnType LOGGED_ON = null;
        public static final LoggedOnType SYSTEM_LOGGED_ON_STATE_NOT_SPECIFIED = null;
        public static final LoggedOnType SYSTEM_NOT_LOGGED_ON = null;

        private static final /* synthetic */ LoggedOnType[] $values() {
            return new LoggedOnType[]{LOGGED_ON, DOUBAO_NOT_LOGGED_ON, DOUBAO_LOGGED_ON_STATE_NOT_SPECIFIED, SYSTEM_NOT_LOGGED_ON, SYSTEM_LOGGED_ON_STATE_NOT_SPECIFIED};
        }

        public static a<LoggedOnType> getEntries() {
            return $ENTRIES;
        }

        private LoggedOnType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            LOGGED_ON = new LoggedOnType("LOGGED_ON", 0);
            DOUBAO_NOT_LOGGED_ON = new LoggedOnType("DOUBAO_NOT_LOGGED_ON", 1);
            DOUBAO_LOGGED_ON_STATE_NOT_SPECIFIED = new LoggedOnType("DOUBAO_LOGGED_ON_STATE_NOT_SPECIFIED", 2);
            SYSTEM_NOT_LOGGED_ON = new LoggedOnType("SYSTEM_NOT_LOGGED_ON", 3);
            SYSTEM_LOGGED_ON_STATE_NOT_SPECIFIED = new LoggedOnType("SYSTEM_LOGGED_ON_STATE_NOT_SPECIFIED", 4);
            LoggedOnType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static LoggedOnType valueOf(String r2) {
            return (LoggedOnType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LoggedOnType.class, r2), LoggedOnType.class, "com.obric.aiagent.plugin");
        }

        public static LoggedOnType[] values() {
            return (LoggedOnType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LoggedOnType[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAutoActionAccountApi.kt */
    public static final class UserInfoAcquiringResult {
        public static final Companion Companion = null;
        public static final int RESULT_ACCOUNT_API_FAILED = 2;
        public static final int RESULT_LOGGED_IN = 0;
        public static final int RESULT_NOT_LOGGED_IN = 1;
        private final int type;
        private final LoggedInUserInfo userInfo;

        /* JADX INFO: compiled from: IAutoActionAccountApi.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ UserInfoAcquiringResult copy$default(UserInfoAcquiringResult r0, int r1, LoggedInUserInfo r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.userInfo;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.type;
        }

        public final LoggedInUserInfo component2() {
            return this.userInfo;
        }

        public final UserInfoAcquiringResult copy(int r1, LoggedInUserInfo r2) {
            return new UserInfoAcquiringResult(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, UserInfoAcquiringResult.class) == true) goto L8;
            return false;
        L8:
            UserInfoAcquiringResult r6 = (UserInfoAcquiringResult) ZeusTransformUtils.preCheckCast(r5, UserInfoAcquiringResult.class, "com.obric.aiagent.plugin");
            if (this.type == r6.type) goto L12;
            return false;
        L12:
            if (o.a(this.userInfo, r6.userInfo) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.type) * 31;
            LoggedInUserInfo r1 = this.userInfo;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "UserInfoAcquiringResult(type=" + this.type + ", userInfo=" + this.userInfo + ')';
        }

        public UserInfoAcquiringResult(int r1, LoggedInUserInfo r2) {
            this.type = r1;
            this.userInfo = r2;
        }

        public /* synthetic */ UserInfoAcquiringResult(int r1, LoggedInUserInfo r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final int getType() {
            return this.type;
        }

        public final LoggedInUserInfo getUserInfo() {
            return this.userInfo;
        }
    }

    UserInfoAcquiringResult acquireUserInfo();

    Object checkLoggedOn(Context r1, d<? super LoggedOnCheckResult> r2);
}
