package com.stepos.ability.commoninternal;

import android.util.Log;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import stepos.app.StepOSActivityManager;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stepos/ability/commoninternal/VirtualDisplayCgroupHelper;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "TIER_REALTIME", "", "TIER_IMPORTANT", "TIER_NORMAL", "TIER_BACKGROUND", "manager", "Lstepos/app/StepOSActivityManager;", "isEnabled", "", "applyTier", WindowStateInfo.KEY_DISPLAY_ID, "tier", "reset", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VirtualDisplayCgroupHelper {
    public static final VirtualDisplayCgroupHelper INSTANCE = new VirtualDisplayCgroupHelper();
    private static final String TAG = "VDCgroupHelper";
    public static final int TIER_BACKGROUND = 4;
    public static final int TIER_IMPORTANT = 2;
    public static final int TIER_NORMAL = 3;
    public static final int TIER_REALTIME = 1;

    private VirtualDisplayCgroupHelper() {
    }

    private final StepOSActivityManager manager() {
        try {
            return StepOSActivityManager.get();
        } catch (Throwable th) {
            a.w("manager() failed: ", th.getMessage(), TAG);
            return null;
        }
    }

    public final boolean applyTier(int displayId, int tier) {
        if (displayId <= 0) {
            Log.w(TAG, "applyTier skip: invalid displayId=" + displayId);
            return false;
        }
        try {
            StepOSActivityManager stepOSActivityManagerManager = manager();
            if (stepOSActivityManagerManager == null) {
                return false;
            }
            boolean virtualDisplayCgroupTier = stepOSActivityManagerManager.setVirtualDisplayCgroupTier(tier, displayId);
            int virtualDisplayCgroupTier2 = stepOSActivityManagerManager.getVirtualDisplayCgroupTier(displayId);
            Log.i(TAG, "applyTier display=" + displayId + " tier=" + tier + " ok=" + virtualDisplayCgroupTier + " readBack=" + virtualDisplayCgroupTier2);
            return virtualDisplayCgroupTier && virtualDisplayCgroupTier2 == tier;
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(displayId, "applyTier failed display=", tier, " tier=", ": ");
            sbS.append(message);
            Log.w(TAG, sbS.toString());
            return false;
        }
    }

    public final boolean isEnabled() {
        try {
            StepOSActivityManager stepOSActivityManagerManager = manager();
            if (stepOSActivityManagerManager != null) {
                return stepOSActivityManagerManager.isVirtualDisplayCgroupEnabled();
            }
            return false;
        } catch (Throwable th) {
            a.w("isEnabled failed: ", th.getMessage(), TAG);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean reset(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = "VDCgroupHelper"
            java.lang.String r1 = "reset display="
            r2 = 0
            if (r5 > 0) goto L8
            return r2
        L8:
            stepos.app.StepOSActivityManager r4 = r4.manager()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L16
            boolean r4 = r4.resetVirtualDisplayCgroupTier(r5)     // Catch: java.lang.Throwable -> L18
            r3 = 1
            if (r4 != r3) goto L16
            goto L1a
        L16:
            r3 = r2
            goto L1a
        L18:
            r4 = move-exception
            goto L32
        L1a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L18
            r4.append(r5)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = " ok="
            r4.append(r1)     // Catch: java.lang.Throwable -> L18
            r4.append(r3)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L18
            android.util.Log.i(r0, r4)     // Catch: java.lang.Throwable -> L18
            return r3
        L32:
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "reset failed display="
            r1.<init>(r3)
            r1.append(r5)
            java.lang.String r5 = ": "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            android.util.Log.w(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.commoninternal.VirtualDisplayCgroupHelper.reset(int):boolean");
    }
}
