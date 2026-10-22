package stepai.aios.accessibility;

import N9.j;
import android.accessibilityservice.InputMethod;
import android.graphics.Point;
import android.view.accessibility.AccessibilityNodeInfo;
import com.stepos.statsrpk.d;
import com.stepos.statsrpk.service.c;
import com.stepos.taskrobot.llmapi.stepfun.g;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultAccessibilityService f6017a;

    public a(DefaultAccessibilityService defaultAccessibilityService) {
        this.f6017a = defaultAccessibilityService;
    }

    public static AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, Point point) {
        j.F(androidx.compose.foundation.b.o(point.x, "Searching for editable node at coordinates: (", point.y, ", ", ")"), "AccessibilityActionExecutor");
        AccessibilityNodeInfo accessibilityNodeInfoB = b(accessibilityNodeInfo, new g(point, 12));
        if (accessibilityNodeInfoB == null) {
            j.J(androidx.compose.foundation.b.o(point.x, "No suitable editable node found at coordinates (", point.y, ", ", ")"), "AccessibilityActionExecutor");
        }
        return accessibilityNodeInfoB;
    }

    public static AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo, g gVar) {
        try {
            for (int childCount = accessibilityNodeInfo.getChildCount() - 1; -1 < childCount; childCount--) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
                if (child != null) {
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoB = b(child, gVar);
                        if (accessibilityNodeInfoB != null) {
                        }
                        if (!child.equals(accessibilityNodeInfo)) {
                            child.recycle();
                        }
                    } finally {
                        if (!child.equals(accessibilityNodeInfo)) {
                            child.recycle();
                        }
                    }
                }
            }
            if (((Boolean) gVar.invoke(accessibilityNodeInfo)).booleanValue()) {
                return accessibilityNodeInfo;
            }
            return null;
        } catch (Exception e) {
            c.n("Error in findNodeRecursive: ", e.getMessage(), "AccessibilityActionExecutor");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012a A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:13:0x0034, B:50:0x0121, B:52:0x012a, B:57:0x0142, B:53:0x0130, B:20:0x004d, B:39:0x00de, B:41:0x00ea, B:42:0x00ef, B:44:0x0101, B:46:0x0108, B:55:0x0137, B:56:0x013d, B:23:0x005b, B:26:0x0065, B:29:0x006d, B:31:0x00a6, B:33:0x00b1, B:36:0x00cf, B:59:0x0147), top: B:63:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0130 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:13:0x0034, B:50:0x0121, B:52:0x012a, B:57:0x0142, B:53:0x0130, B:20:0x004d, B:39:0x00de, B:41:0x00ea, B:42:0x00ef, B:44:0x0101, B:46:0x0108, B:55:0x0137, B:56:0x013d, B:23:0x005b, B:26:0x0065, B:29:0x006d, B:31:0x00a6, B:33:0x00b1, B:36:0x00cf, B:59:0x0147), top: B:63:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(android.view.accessibility.AccessibilityNodeInfo r14, java.lang.String r15, boolean r16, stepai.aios.accessibility.a r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.accessibility.a.e(android.view.accessibility.AccessibilityNodeInfo, java.lang.String, boolean, stepai.aios.accessibility.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            if (accessibilityNodeInfo.performAction(16)) {
                j.H("ACTION_CLICK successful", "AccessibilityActionExecutor");
                return true;
            }
            if (accessibilityNodeInfo.performAction(1)) {
                j.H("ACTION_FOCUS successful", "AccessibilityActionExecutor");
                return true;
            }
            if (accessibilityNodeInfo.performAction(2)) {
                j.H("ACTION_CLEAR_FOCUS successful", "AccessibilityActionExecutor");
                return true;
            }
            j.J("All confirmation methods failed", "AccessibilityActionExecutor");
            return false;
        } catch (Exception e) {
            c.n("Error during input confirmation: ", e.getMessage(), "AccessibilityActionExecutor");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0124 A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #1 {all -> 0x00f4, blocks: (B:43:0x00a1, B:45:0x00c7, B:48:0x00e3, B:50:0x00e9, B:60:0x00ff, B:62:0x0105, B:66:0x0119, B:70:0x0124, B:76:0x013d), top: B:83:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013d A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00f4, blocks: (B:43:0x00a1, B:45:0x00c7, B:48:0x00e3, B:50:0x00e9, B:60:0x00ff, B:62:0x0105, B:66:0x0119, B:70:0x0124, B:76:0x013d), top: B:83:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r15, android.graphics.Point r16, boolean r17, boolean r18, int r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.accessibility.a.c(java.lang.String, android.graphics.Point, boolean, boolean, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.view.accessibility.AccessibilityNodeInfo r17, java.lang.String r18, boolean r19, boolean r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.accessibility.a.d(android.view.accessibility.AccessibilityNodeInfo, java.lang.String, boolean, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean g(String str) {
        try {
            j.F("Attempting InputConnection method for text: " + d.M(str), "AccessibilityActionExecutor");
            InputMethod inputMethod = this.f6017a.getInputMethod();
            if (inputMethod == null) {
                j.J("InputMethod is null - no input method available", "AccessibilityActionExecutor");
                return false;
            }
            j.H("InputMethod available: ".concat(inputMethod.getClass().getSimpleName()), "AccessibilityActionExecutor");
            InputMethod.AccessibilityInputConnection currentInputConnection = inputMethod.getCurrentInputConnection();
            if (currentInputConnection == null) {
                j.J("InputConnection is null - input method may not be active", "AccessibilityActionExecutor");
                return false;
            }
            j.F("InputConnection available, committing text", "AccessibilityActionExecutor");
            currentInputConnection.commitText(str, 0, null);
            j.F("InputConnection text commit successful", "AccessibilityActionExecutor");
            return true;
        } catch (Exception e) {
            j.G("InputConnection failed: " + e.getMessage(), "AccessibilityActionExecutor");
            e.printStackTrace();
            return false;
        }
    }
}
