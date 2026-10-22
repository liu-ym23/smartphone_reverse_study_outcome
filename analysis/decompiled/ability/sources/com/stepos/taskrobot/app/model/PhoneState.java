package com.stepos.taskrobot.app.model;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/app/model/PhoneState;", "", "focusedElement", "Landroid/view/accessibility/AccessibilityNodeInfo;", "keyboardVisible", "", "packageName", "", "appName", AppAgent.CONSTRUCT, "(Landroid/view/accessibility/AccessibilityNodeInfo;ZLjava/lang/String;Ljava/lang/String;)V", "getFocusedElement", "()Landroid/view/accessibility/AccessibilityNodeInfo;", "getKeyboardVisible", "()Z", "getPackageName", "()Ljava/lang/String;", "getAppName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PhoneState {
    private final String appName;
    private final AccessibilityNodeInfo focusedElement;
    private final boolean keyboardVisible;
    private final String packageName;

    public PhoneState(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10, String str, String str2) {
        this.focusedElement = accessibilityNodeInfo;
        this.keyboardVisible = z10;
        this.packageName = str;
        this.appName = str2;
    }

    public static /* synthetic */ PhoneState copy$default(PhoneState phoneState, AccessibilityNodeInfo accessibilityNodeInfo, boolean z10, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            accessibilityNodeInfo = phoneState.focusedElement;
        }
        if ((i & 2) != 0) {
            z10 = phoneState.keyboardVisible;
        }
        if ((i & 4) != 0) {
            str = phoneState.packageName;
        }
        if ((i & 8) != 0) {
            str2 = phoneState.appName;
        }
        return phoneState.copy(accessibilityNodeInfo, z10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final AccessibilityNodeInfo getFocusedElement() {
        return this.focusedElement;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getKeyboardVisible() {
        return this.keyboardVisible;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    public final PhoneState copy(AccessibilityNodeInfo focusedElement, boolean keyboardVisible, String packageName, String appName) {
        return new PhoneState(focusedElement, keyboardVisible, packageName, appName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneState)) {
            return false;
        }
        PhoneState phoneState = (PhoneState) other;
        return k.b(this.focusedElement, phoneState.focusedElement) && this.keyboardVisible == phoneState.keyboardVisible && k.b(this.packageName, phoneState.packageName) && k.b(this.appName, phoneState.appName);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final AccessibilityNodeInfo getFocusedElement() {
        return this.focusedElement;
    }

    public final boolean getKeyboardVisible() {
        return this.keyboardVisible;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.focusedElement;
        int iD = a.d((accessibilityNodeInfo == null ? 0 : accessibilityNodeInfo.hashCode()) * 31, 31, this.keyboardVisible);
        String str = this.packageName;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.focusedElement;
        boolean z10 = this.keyboardVisible;
        String str = this.packageName;
        String str2 = this.appName;
        StringBuilder sb = new StringBuilder("PhoneState(focusedElement=");
        sb.append(accessibilityNodeInfo);
        sb.append(", keyboardVisible=");
        sb.append(z10);
        sb.append(", packageName=");
        return a.p(sb, str, ", appName=", str2, ")");
    }
}
