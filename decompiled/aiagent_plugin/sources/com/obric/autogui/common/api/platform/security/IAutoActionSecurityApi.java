package com.obric.autogui.common.api.platform.security;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionSecurityApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionSecurityApi {

    /* JADX INFO: compiled from: IAutoActionSecurityApi.kt */
    public static final class PageOperationPolicy {
        private final String policyForModel;

        public static /* synthetic */ PageOperationPolicy copy$default(PageOperationPolicy r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.policyForModel;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.policyForModel;
        }

        public final PageOperationPolicy copy(String r1) {
            o.e(r1, "policyForModel");
            return new PageOperationPolicy(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PageOperationPolicy.class) == true) goto L8;
            return false;
        L8:
            PageOperationPolicy r6 = (PageOperationPolicy) ZeusTransformUtils.preCheckCast(r5, PageOperationPolicy.class, "com.obric.aiagent.plugin");
            if (o.a(this.policyForModel, r6.policyForModel) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.policyForModel.hashCode();
        }

        public String toString() {
            return "PageOperationPolicy(policyForModel=" + this.policyForModel + ')';
        }

        public PageOperationPolicy(String r2) {
            o.e(r2, "policyForModel");
            this.policyForModel = r2;
        }

        public final String getPolicyForModel() {
            return this.policyForModel;
        }
    }

    /* JADX INFO: compiled from: IAutoActionSecurityApi.kt */
    public static final class PermissionStrategy {
        private final String packageName;
        private final String permName;
        private final int permNameForUserResId;
        private final String reasonForPerm;
        private final SuggestedGrantStrategy suggestedGrantStrategy;

        public static /* synthetic */ PermissionStrategy copy$default(PermissionStrategy r3, String r4, String r5, int r6, SuggestedGrantStrategy r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.packageName;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.permName;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.permNameForUserResId;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.suggestedGrantStrategy;
        L14:
            SuggestedGrantStrategy r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.reasonForPerm;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.packageName;
        }

        public final String component2() {
            return this.permName;
        }

        public final int component3() {
            return this.permNameForUserResId;
        }

        public final SuggestedGrantStrategy component4() {
            return this.suggestedGrantStrategy;
        }

        public final String component5() {
            return this.reasonForPerm;
        }

        public final PermissionStrategy copy(String r7, String r8, int r9, SuggestedGrantStrategy r10, String r11) {
            o.e(r7, "packageName");
            o.e(r8, "permName");
            o.e(r10, "suggestedGrantStrategy");
            return new PermissionStrategy(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PermissionStrategy.class) == true) goto L8;
            return false;
        L8:
            PermissionStrategy r6 = (PermissionStrategy) ZeusTransformUtils.preCheckCast(r5, PermissionStrategy.class, "com.obric.aiagent.plugin");
            if (o.a(this.packageName, r6.packageName) == true) goto L12;
            return false;
        L12:
            if (o.a(this.permName, r6.permName) == true) goto L15;
            return false;
        L15:
            if (this.permNameForUserResId == r6.permNameForUserResId) goto L18;
            return false;
        L18:
            if (this.suggestedGrantStrategy == r6.suggestedGrantStrategy) goto L21;
            return false;
        L21:
            if (o.a(this.reasonForPerm, r6.reasonForPerm) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.packageName.hashCode() * 31) + this.permName.hashCode()) * 31) + Integer.hashCode(this.permNameForUserResId)) * 31) + this.suggestedGrantStrategy.hashCode()) * 31;
            String r2 = this.reasonForPerm;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "PermissionStrategy(packageName=" + this.packageName + ", permName=" + this.permName + ", permNameForUserResId=" + this.permNameForUserResId + ", suggestedGrantStrategy=" + this.suggestedGrantStrategy + ", reasonForPerm=" + this.reasonForPerm + ')';
        }

        public PermissionStrategy(String r2, String r3, int r4, SuggestedGrantStrategy r5, String r6) {
            o.e(r2, "packageName");
            o.e(r3, "permName");
            o.e(r5, "suggestedGrantStrategy");
            this.packageName = r2;
            this.permName = r3;
            this.permNameForUserResId = r4;
            this.suggestedGrantStrategy = r5;
            this.reasonForPerm = r6;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getPermName() {
            return this.permName;
        }

        public final int getPermNameForUserResId() {
            return this.permNameForUserResId;
        }

        public /* synthetic */ PermissionStrategy(String r7, String r8, int r9, SuggestedGrantStrategy r10, String r11, int r12, h r13) {
            if ((r12 & 4) == 0) goto L5;
            r9 = -1;
        L5:
            int r3 = r9;
            if ((r12 & 8) == 0) goto L8;
            r10 = SuggestedGrantStrategy.NONE;
        L8:
            SuggestedGrantStrategy r4 = r10;
            if ((r12 & 16) == 0) goto L11;
            r11 = null;
        L11:
            this(r7, r8, r3, r4, r11);
        }

        public final SuggestedGrantStrategy getSuggestedGrantStrategy() {
            return this.suggestedGrantStrategy;
        }

        public final String getReasonForPerm() {
            return this.reasonForPerm;
        }
    }

    /* JADX INFO: compiled from: IAutoActionSecurityApi.kt */
    public static final class SensitiveOperation {
        private final String operation;
        private final String operationForModel;
        private final String operationForUser;
        private final String packageName;
        private final boolean userOperateNeeded;

        public static /* synthetic */ SensitiveOperation copy$default(SensitiveOperation r3, String r4, String r5, String r6, String r7, boolean r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.packageName;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.operation;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.operationForUser;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.operationForModel;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.userOperateNeeded;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.packageName;
        }

        public final String component2() {
            return this.operation;
        }

        public final String component3() {
            return this.operationForUser;
        }

        public final String component4() {
            return this.operationForModel;
        }

        public final boolean component5() {
            return this.userOperateNeeded;
        }

        public final SensitiveOperation copy(String r7, String r8, String r9, String r10, boolean r11) {
            o.e(r7, "packageName");
            o.e(r8, "operation");
            o.e(r9, "operationForUser");
            o.e(r10, "operationForModel");
            return new SensitiveOperation(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, SensitiveOperation.class) == true) goto L8;
            return false;
        L8:
            SensitiveOperation r6 = (SensitiveOperation) ZeusTransformUtils.preCheckCast(r5, SensitiveOperation.class, "com.obric.aiagent.plugin");
            if (o.a(this.packageName, r6.packageName) == true) goto L12;
            return false;
        L12:
            if (o.a(this.operation, r6.operation) == true) goto L15;
            return false;
        L15:
            if (o.a(this.operationForUser, r6.operationForUser) == true) goto L18;
            return false;
        L18:
            if (o.a(this.operationForModel, r6.operationForModel) == true) goto L21;
            return false;
        L21:
            if (this.userOperateNeeded == r6.userOperateNeeded) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.packageName.hashCode() * 31) + this.operation.hashCode()) * 31) + this.operationForUser.hashCode()) * 31) + this.operationForModel.hashCode()) * 31) + Boolean.hashCode(this.userOperateNeeded);
        }

        public String toString() {
            return "SensitiveOperation(packageName=" + this.packageName + ", operation=" + this.operation + ", operationForUser=" + this.operationForUser + ", operationForModel=" + this.operationForModel + ", userOperateNeeded=" + this.userOperateNeeded + ')';
        }

        public SensitiveOperation(String r2, String r3, String r4, String r5, boolean r6) {
            o.e(r2, "packageName");
            o.e(r3, "operation");
            o.e(r4, "operationForUser");
            o.e(r5, "operationForModel");
            this.packageName = r2;
            this.operation = r3;
            this.operationForUser = r4;
            this.operationForModel = r5;
            this.userOperateNeeded = r6;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getOperation() {
            return this.operation;
        }

        public final String getOperationForUser() {
            return this.operationForUser;
        }

        public final String getOperationForModel() {
            return this.operationForModel;
        }

        public final boolean getUserOperateNeeded() {
            return this.userOperateNeeded;
        }
    }

    /* JADX INFO: compiled from: IAutoActionSecurityApi.kt */
    public static final enum SuggestedGrantStrategy extends Enum<SuggestedGrantStrategy> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ SuggestedGrantStrategy[] $VALUES = null;
        public static final SuggestedGrantStrategy ALWAYS = null;
        public static final SuggestedGrantStrategy DENY = null;
        public static final SuggestedGrantStrategy DURING_USE = null;
        public static final SuggestedGrantStrategy NONE = null;
        public static final SuggestedGrantStrategy NOT_SURE = null;
        public static final SuggestedGrantStrategy ONE_TIME = null;

        private static final /* synthetic */ SuggestedGrantStrategy[] $values() {
            return new SuggestedGrantStrategy[]{NONE, NOT_SURE, ALWAYS, DENY, ONE_TIME, DURING_USE};
        }

        public static a<SuggestedGrantStrategy> getEntries() {
            return $ENTRIES;
        }

        private SuggestedGrantStrategy(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NONE = new SuggestedGrantStrategy("NONE", 0);
            NOT_SURE = new SuggestedGrantStrategy("NOT_SURE", 1);
            ALWAYS = new SuggestedGrantStrategy("ALWAYS", 2);
            DENY = new SuggestedGrantStrategy("DENY", 3);
            ONE_TIME = new SuggestedGrantStrategy("ONE_TIME", 4);
            DURING_USE = new SuggestedGrantStrategy("DURING_USE", 5);
            SuggestedGrantStrategy[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static SuggestedGrantStrategy valueOf(String r2) {
            return (SuggestedGrantStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(SuggestedGrantStrategy.class, r2), SuggestedGrantStrategy.class, "com.obric.aiagent.plugin");
        }

        public static SuggestedGrantStrategy[] values() {
            return (SuggestedGrantStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SuggestedGrantStrategy[].class, "com.obric.aiagent.plugin");
        }
    }

    PageOperationPolicy acquirePageOperationPolicy(Context r1, ComponentName r2);

    PermissionStrategy acquirePermissionStrategy(DisplayedAppInfo r1);

    SensitiveOperation acquireSensitiveOperation(Context r1, ComponentName r2);

    e checkPrompt(String r1);

    boolean checkSensitiveWord(String r1);

    Object checkVirus(String r1, d<? super Boolean> r2);

    String makeAttestationString(String r1, String r2);
}
