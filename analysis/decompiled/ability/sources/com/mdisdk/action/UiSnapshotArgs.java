package com.mdisdk.action;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019JV\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/mdisdk/action/UiSnapshotArgs;", "", "packageName", "", "activityClass", "windowTitle", WindowStateInfo.KEY_DISPLAY_ID, "", "timeoutInMillis", "", "screenshot", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getPackageName", "()Ljava/lang/String;", "getActivityClass", "getWindowTitle", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimeoutInMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScreenshot", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/mdisdk/action/UiSnapshotArgs;", "equals", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiSnapshotArgs {
    private final String activityClass;
    private final Integer displayId;
    private final String packageName;
    private final Boolean screenshot;
    private final Long timeoutInMillis;
    private final String windowTitle;

    public UiSnapshotArgs(String str, String str2, String str3, Integer num, Long l, Boolean bool) {
        this.packageName = str;
        this.activityClass = str2;
        this.windowTitle = str3;
        this.displayId = num;
        this.timeoutInMillis = l;
        this.screenshot = bool;
    }

    public static /* synthetic */ UiSnapshotArgs copy$default(UiSnapshotArgs uiSnapshotArgs, String str, String str2, String str3, Integer num, Long l, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uiSnapshotArgs.packageName;
        }
        if ((i & 2) != 0) {
            str2 = uiSnapshotArgs.activityClass;
        }
        if ((i & 4) != 0) {
            str3 = uiSnapshotArgs.windowTitle;
        }
        if ((i & 8) != 0) {
            num = uiSnapshotArgs.displayId;
        }
        if ((i & 16) != 0) {
            l = uiSnapshotArgs.timeoutInMillis;
        }
        if ((i & 32) != 0) {
            bool = uiSnapshotArgs.screenshot;
        }
        Long l5 = l;
        Boolean bool2 = bool;
        return uiSnapshotArgs.copy(str, str2, str3, num, l5, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActivityClass() {
        return this.activityClass;
    }

    /* renamed from: component3, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getTimeoutInMillis() {
        return this.timeoutInMillis;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getScreenshot() {
        return this.screenshot;
    }

    public final UiSnapshotArgs copy(String packageName, String activityClass, String windowTitle, Integer displayId, Long timeoutInMillis, Boolean screenshot) {
        return new UiSnapshotArgs(packageName, activityClass, windowTitle, displayId, timeoutInMillis, screenshot);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiSnapshotArgs)) {
            return false;
        }
        UiSnapshotArgs uiSnapshotArgs = (UiSnapshotArgs) other;
        return k.b(this.packageName, uiSnapshotArgs.packageName) && k.b(this.activityClass, uiSnapshotArgs.activityClass) && k.b(this.windowTitle, uiSnapshotArgs.windowTitle) && k.b(this.displayId, uiSnapshotArgs.displayId) && k.b(this.timeoutInMillis, uiSnapshotArgs.timeoutInMillis) && k.b(this.screenshot, uiSnapshotArgs.screenshot);
    }

    public final String getActivityClass() {
        return this.activityClass;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Boolean getScreenshot() {
        return this.screenshot;
    }

    public final Long getTimeoutInMillis() {
        return this.timeoutInMillis;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        String str = this.packageName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.activityClass;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.windowTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.displayId;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.timeoutInMillis;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.screenshot;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "UiSnapshotArgs(packageName=" + this.packageName + ", activityClass=" + this.activityClass + ", windowTitle=" + this.windowTitle + ", displayId=" + this.displayId + ", timeoutInMillis=" + this.timeoutInMillis + ", screenshot=" + this.screenshot + ')';
    }
}
