package com.obric.autogui.common.api.platform.security;

import android.app.Activity;
import android.content.Context;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionPermissionApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionPermissionApi {

    /* JADX INFO: compiled from: IAutoActionPermissionApi.kt */
    public static final class PermissionCheckResult {
        private final boolean isGranted;
        private final String reason;
        private final boolean success;

        public static /* synthetic */ PermissionCheckResult copy$default(PermissionCheckResult r0, boolean r1, boolean r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.success;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.isGranted;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.reason;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.success;
        }

        public final boolean component2() {
            return this.isGranted;
        }

        public final String component3() {
            return this.reason;
        }

        public final PermissionCheckResult copy(boolean r1, boolean r2, String r3) {
            return new PermissionCheckResult(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PermissionCheckResult.class) == true) goto L8;
            return false;
        L8:
            PermissionCheckResult r6 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r5, PermissionCheckResult.class, "com.obric.aiagent.plugin");
            if (this.success == r6.success) goto L12;
            return false;
        L12:
            if (this.isGranted == r6.isGranted) goto L15;
            return false;
        L15:
            if (o.a(this.reason, r6.reason) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.isGranted)) * 31;
            String r2 = this.reason;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "PermissionCheckResult(success=" + this.success + ", isGranted=" + this.isGranted + ", reason=" + this.reason + ')';
        }

        public PermissionCheckResult(boolean r1, boolean r2, String r3) {
            this.success = r1;
            this.isGranted = r2;
            this.reason = r3;
        }

        public /* synthetic */ PermissionCheckResult(boolean r1, boolean r2, String r3, int r4, h r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final boolean isGranted() {
            return this.isGranted;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: IAutoActionPermissionApi.kt */
    public static final enum PermissionDialogueResult extends Enum<PermissionDialogueResult> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ PermissionDialogueResult[] $VALUES = null;
        public static final PermissionDialogueResult BeforeShowingCheckFailed = null;
        public static final PermissionDialogueResult Error = null;
        public static final PermissionDialogueResult Granted = null;
        public static final PermissionDialogueResult Opened = null;

        private static final /* synthetic */ PermissionDialogueResult[] $values() {
            return new PermissionDialogueResult[]{Opened, Granted, BeforeShowingCheckFailed, Error};
        }

        public static a<PermissionDialogueResult> getEntries() {
            return $ENTRIES;
        }

        private PermissionDialogueResult(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Opened = new PermissionDialogueResult("Opened", 0);
            Granted = new PermissionDialogueResult("Granted", 1);
            BeforeShowingCheckFailed = new PermissionDialogueResult("BeforeShowingCheckFailed", 2);
            Error = new PermissionDialogueResult("Error", 3);
            PermissionDialogueResult[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static PermissionDialogueResult valueOf(String r2) {
            return (PermissionDialogueResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(PermissionDialogueResult.class, r2), PermissionDialogueResult.class, "com.obric.aiagent.plugin");
        }

        public static PermissionDialogueResult[] values() {
            return (PermissionDialogueResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PermissionDialogueResult[].class, "com.obric.aiagent.plugin");
        }
    }

    PermissionCheckResult checkPermission(Context r1, String r2);

    PermissionCheckResult checkPermission(Context r1, String r2, String r3);

    StartActivityResult openAllPermissionSettings(Context r1, String r2);

    PermissionDialogueResult showPermissionDialogue(Activity r1, String r2);
}
