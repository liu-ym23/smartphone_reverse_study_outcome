package com.mdisdk.observer;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import j9.m;
import j9.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bHÆ\u0003JW\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/mdisdk/observer/ForegroundAppInfo;", "", "packageName", "", "activityClassName", WindowStateInfo.KEY_DISPLAY_ID, "", "timestamp", "", "previousPackageName", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/util/Map;)V", "getPackageName", "()Ljava/lang/String;", "getActivityClassName", "getDisplayId", "()I", "getTimestamp", "()J", "getPreviousPackageName", "getExtras", "()Ljava/util/Map;", "isAppChanged", "", "isActivityChanged", "getShortActivityName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ForegroundAppInfo {
    public static final String EXTRA_IS_FOCUSED = "is_focused";
    public static final String EXTRA_TASK_ID = "task_id";
    public static final String EXTRA_WINDOW_MODE = "window_mode";
    private final String activityClassName;
    private final int displayId;
    private final Map<String, Object> extras;
    private final String packageName;
    private final String previousPackageName;
    private final long timestamp;

    public ForegroundAppInfo(String packageName, String str, int i, long j5, String str2, Map<String, ? extends Object> extras) {
        k.f(packageName, "packageName");
        k.f(extras, "extras");
        this.packageName = packageName;
        this.activityClassName = str;
        this.displayId = i;
        this.timestamp = j5;
        this.previousPackageName = str2;
        this.extras = extras;
    }

    public static /* synthetic */ ForegroundAppInfo copy$default(ForegroundAppInfo foregroundAppInfo, String str, String str2, int i, long j5, String str3, Map map, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = foregroundAppInfo.packageName;
        }
        if ((i6 & 2) != 0) {
            str2 = foregroundAppInfo.activityClassName;
        }
        if ((i6 & 4) != 0) {
            i = foregroundAppInfo.displayId;
        }
        if ((i6 & 8) != 0) {
            j5 = foregroundAppInfo.timestamp;
        }
        if ((i6 & 16) != 0) {
            str3 = foregroundAppInfo.previousPackageName;
        }
        if ((i6 & 32) != 0) {
            map = foregroundAppInfo.extras;
        }
        long j6 = j5;
        int i10 = i;
        return foregroundAppInfo.copy(str, str2, i10, j6, str3, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActivityClassName() {
        return this.activityClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPreviousPackageName() {
        return this.previousPackageName;
    }

    public final Map<String, Object> component6() {
        return this.extras;
    }

    public final ForegroundAppInfo copy(String packageName, String activityClassName, int displayId, long timestamp, String previousPackageName, Map<String, ? extends Object> extras) {
        k.f(packageName, "packageName");
        k.f(extras, "extras");
        return new ForegroundAppInfo(packageName, activityClassName, displayId, timestamp, previousPackageName, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForegroundAppInfo)) {
            return false;
        }
        ForegroundAppInfo foregroundAppInfo = (ForegroundAppInfo) other;
        return k.b(this.packageName, foregroundAppInfo.packageName) && k.b(this.activityClassName, foregroundAppInfo.activityClassName) && this.displayId == foregroundAppInfo.displayId && this.timestamp == foregroundAppInfo.timestamp && k.b(this.previousPackageName, foregroundAppInfo.previousPackageName) && k.b(this.extras, foregroundAppInfo.extras);
    }

    public final String getActivityClassName() {
        return this.activityClassName;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPreviousPackageName() {
        return this.previousPackageName;
    }

    public final String getShortActivityName() {
        String str = this.activityClassName;
        if (str != null) {
            return t.e0(str, this.packageName, false) ? m.y0(this.packageName, str) : m.I0('.', str, str);
        }
        return null;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        String str = this.activityClassName;
        int iC = a.c(androidx.constraintlayout.core.dsl.a.a(this.displayId, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31, this.timestamp);
        String str2 = this.previousPackageName;
        return this.extras.hashCode() + ((iC + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final boolean isActivityChanged() {
        return k.b(this.previousPackageName, this.packageName);
    }

    public final boolean isAppChanged() {
        String str = this.previousPackageName;
        return (str == null || k.b(str, this.packageName)) ? false : true;
    }

    public String toString() {
        return "ForegroundAppInfo(packageName=" + this.packageName + ", activityClassName=" + this.activityClassName + ", displayId=" + this.displayId + ", timestamp=" + this.timestamp + ", previousPackageName=" + this.previousPackageName + ", extras=" + this.extras + ')';
    }

    public /* synthetic */ ForegroundAppInfo(String str, String str2, int i, long j5, String str3, Map map, int i6, e eVar) {
        this(str, (i6 & 2) != 0 ? null : str2, i, (i6 & 8) != 0 ? System.currentTimeMillis() : j5, (i6 & 16) != 0 ? null : str3, (i6 & 32) != 0 ? kotlin.collections.a.M() : map);
    }
}
