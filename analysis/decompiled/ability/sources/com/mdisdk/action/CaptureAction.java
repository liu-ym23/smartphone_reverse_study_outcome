package com.mdisdk.action;

import H7.c;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0090@¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/mdisdk/action/CaptureAction;", "Lcom/mdisdk/action/Action;", "Lcom/mdisdk/action/CaptureData;", "", WindowStateInfo.KEY_DISPLAY_ID, "", "targetPackageName", "tag", AppAgent.CONSTRUCT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTargetPackageName", "()Ljava/lang/String;", "getTag", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptureAction extends Action<CaptureData> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_CAPTURE_FAILED = "capture_error_capture_failed";
    public static final String ERROR_EXCEPTION = "capture_error_exception";
    public static final String ERROR_NONE = "capture_success";
    public static final String ERROR_NULL_BITMAP = "capture_error_null_bitmap";
    public static final String ERROR_NULL_BUNDLE = "capture_error_null_bundle";
    public static final String ERROR_SECURE_WINDOW = "capture_error_secure_window";
    public static final String ERROR_UNKNOWN = "capture_error_unknown";
    public static final String ERROR_UNSUPPORTED = "capture_error_unsupported";
    private final Integer displayId;
    private final String tag;
    private final String targetPackageName;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/mdisdk/action/CaptureAction$Companion;", "", AppAgent.CONSTRUCT, "()V", "ERROR_NONE", "", "ERROR_UNKNOWN", "ERROR_SECURE_WINDOW", "ERROR_CAPTURE_FAILED", "ERROR_UNSUPPORTED", "ERROR_NULL_BUNDLE", "ERROR_NULL_BITMAP", "ERROR_EXCEPTION", "mapErrorCode", "frameworkResultCode", "", "getErrorDescription", "errorCode", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        public final String getErrorDescription(String errorCode) {
            k.f(errorCode, "errorCode");
            switch (errorCode.hashCode()) {
                case -2011167782:
                    if (errorCode.equals(CaptureAction.ERROR_UNKNOWN)) {
                        return "Unknown error";
                    }
                    break;
                case -1674311670:
                    if (errorCode.equals(CaptureAction.ERROR_NONE)) {
                        return "Screenshot success";
                    }
                    break;
                case -1671413129:
                    if (errorCode.equals(CaptureAction.ERROR_NULL_BITMAP)) {
                        return "Screenshot bitmap is null";
                    }
                    break;
                case -1660517942:
                    if (errorCode.equals(CaptureAction.ERROR_NULL_BUNDLE)) {
                        return "Screenshot API returned null bundle";
                    }
                    break;
                case -1174510264:
                    if (errorCode.equals(CaptureAction.ERROR_SECURE_WINDOW)) {
                        return "Target window has FLAG_SECURE set, screenshot is prohibited";
                    }
                    break;
                case 338854879:
                    if (errorCode.equals(CaptureAction.ERROR_EXCEPTION)) {
                        return "Exception occurred during screenshot";
                    }
                    break;
                case 1357525445:
                    if (errorCode.equals(CaptureAction.ERROR_UNSUPPORTED)) {
                        return "Screenshot operation not supported";
                    }
                    break;
                case 1429878214:
                    if (errorCode.equals(CaptureAction.ERROR_CAPTURE_FAILED)) {
                        return "Screenshot capture operation failed";
                    }
                    break;
            }
            return "Unknown error code: ".concat(errorCode);
        }

        public final String mapErrorCode(int frameworkResultCode) {
            return frameworkResultCode != 0 ? frameworkResultCode != 1 ? frameworkResultCode != 2 ? frameworkResultCode != 3 ? frameworkResultCode != 4 ? CaptureAction.ERROR_UNKNOWN : CaptureAction.ERROR_UNSUPPORTED : CaptureAction.ERROR_CAPTURE_FAILED : CaptureAction.ERROR_SECURE_WINDOW : CaptureAction.ERROR_UNKNOWN : CaptureAction.ERROR_NONE;
        }

        private Companion() {
        }
    }

    public CaptureAction() {
        this(null, null, null, 7, null);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, c<? super ActionResult<? extends CaptureData>> cVar) {
        try {
            Integer num = this.displayId;
            int iIntValue = num != null ? num.intValue() : taskContext.getTaskDisplayId();
            String str = this.targetPackageName;
            Bundle bundleTakeScreenshotWithScaleResult = FrameworkBridgeFactory.get().takeScreenshotWithScaleResult(iIntValue, (str == null || str.length() == 0) ? 1 : 0, this.targetPackageName, 1.0f);
            if (bundleTakeScreenshotWithScaleResult == null) {
                return new ActionResult.Failure(ERROR_NULL_BUNDLE, null, false, getTag(), getArgs(), 6, null);
            }
            int i = bundleTakeScreenshotWithScaleResult.getInt("android.view.screenshot.result_code");
            Bitmap bitmap = (Bitmap) bundleTakeScreenshotWithScaleResult.getParcelable("android.view.screenshot.result_bitmap");
            if (i == 0) {
                return bitmap != null ? new ActionResult.Success(new CaptureData(getTag(), bitmap, false, 0, null, 28, null), null, getTag(), getArgs(), 2, null) : new ActionResult.Failure(ERROR_NULL_BITMAP, null, false, getTag(), getArgs(), 6, null);
            }
            if (i == 2) {
                String tag = getTag();
                k.c(bitmap);
                return new ActionResult.Success(new CaptureData(tag, bitmap, true, i, INSTANCE.getErrorDescription(ERROR_SECURE_WINDOW)), null, getTag(), getArgs(), 2, null);
            }
            Companion companion = INSTANCE;
            String strMapErrorCode = companion.mapErrorCode(i);
            return new ActionResult.Failure(strMapErrorCode + ':' + companion.getErrorDescription(strMapErrorCode), null, false, getTag(), getArgs(), 6, null);
        } catch (Exception e) {
            return new ActionResult.Failure("capture_error_exception:" + e.getMessage(), e, false, getTag(), getArgs());
        }
    }

    public /* synthetic */ CaptureAction(Integer num, String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureAction(Integer num, String str, String tag) {
        super(tag, new Integer[]{num});
        k.f(tag, "tag");
        this.displayId = num;
        this.targetPackageName = str;
        this.tag = tag;
    }
}
