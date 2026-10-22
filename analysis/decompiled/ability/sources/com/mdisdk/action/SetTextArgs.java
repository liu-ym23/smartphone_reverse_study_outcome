package com.mdisdk.action;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J`\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/mdisdk/action/SetTextArgs;", "", "content", "", "x", "", "y", "windowTitle", "activityClassName", "packageName", WindowStateInfo.KEY_DISPLAY_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getX", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getY", "getWindowTitle", "getActivityClassName", "getPackageName", "getDisplayId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/mdisdk/action/SetTextArgs;", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SetTextArgs {
    private final String activityClassName;
    private final String content;
    private final Integer displayId;
    private final String packageName;
    private final String windowTitle;
    private final Integer x;
    private final Integer y;

    public SetTextArgs(String content, Integer num, Integer num2, String str, String str2, String str3, Integer num3) {
        k.f(content, "content");
        this.content = content;
        this.x = num;
        this.y = num2;
        this.windowTitle = str;
        this.activityClassName = str2;
        this.packageName = str3;
        this.displayId = num3;
    }

    public static /* synthetic */ SetTextArgs copy$default(SetTextArgs setTextArgs, String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setTextArgs.content;
        }
        if ((i & 2) != 0) {
            num = setTextArgs.x;
        }
        if ((i & 4) != 0) {
            num2 = setTextArgs.y;
        }
        if ((i & 8) != 0) {
            str2 = setTextArgs.windowTitle;
        }
        if ((i & 16) != 0) {
            str3 = setTextArgs.activityClassName;
        }
        if ((i & 32) != 0) {
            str4 = setTextArgs.packageName;
        }
        if ((i & 64) != 0) {
            num3 = setTextArgs.displayId;
        }
        String str5 = str4;
        Integer num4 = num3;
        String str6 = str3;
        Integer num5 = num2;
        return setTextArgs.copy(str, num, num5, str2, str6, str5, num4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getX() {
        return this.x;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getY() {
        return this.y;
    }

    /* renamed from: component4, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* renamed from: component5, reason: from getter */
    public final String getActivityClassName() {
        return this.activityClassName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final SetTextArgs copy(String content, Integer x10, Integer y, String windowTitle, String activityClassName, String packageName, Integer displayId) {
        k.f(content, "content");
        return new SetTextArgs(content, x10, y, windowTitle, activityClassName, packageName, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetTextArgs)) {
            return false;
        }
        SetTextArgs setTextArgs = (SetTextArgs) other;
        return k.b(this.content, setTextArgs.content) && k.b(this.x, setTextArgs.x) && k.b(this.y, setTextArgs.y) && k.b(this.windowTitle, setTextArgs.windowTitle) && k.b(this.activityClassName, setTextArgs.activityClassName) && k.b(this.packageName, setTextArgs.packageName) && k.b(this.displayId, setTextArgs.displayId);
    }

    public final String getActivityClassName() {
        return this.activityClassName;
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final Integer getX() {
        return this.x;
    }

    public final Integer getY() {
        return this.y;
    }

    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        Integer num = this.x;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.y;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.windowTitle;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.activityClassName;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packageName;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.displayId;
        return iHashCode6 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "SetTextArgs(content=" + this.content + ", x=" + this.x + ", y=" + this.y + ", windowTitle=" + this.windowTitle + ", activityClassName=" + this.activityClassName + ", packageName=" + this.packageName + ", displayId=" + this.displayId + ')';
    }
}
