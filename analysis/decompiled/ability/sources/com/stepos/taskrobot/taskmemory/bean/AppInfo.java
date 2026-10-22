package com.stepos.taskrobot.taskmemory.bean;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/AppInfo;", "", "packageName", "", "appName", "versionName", "versionCode", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getAppName", "getVersionName", "getVersionCode", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appName;
    private final String packageName;
    private final long versionCode;
    private final String versionName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/AppInfo$Companion;", "", AppAgent.CONSTRUCT, "()V", "getDefault", "Lcom/stepos/taskrobot/taskmemory/bean/AppInfo;", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AppInfo getDefault() {
            return new AppInfo("", "", "", 0L);
        }

        private Companion() {
        }
    }

    public AppInfo(String packageName, String appName, String versionName, long j5) {
        k.f(packageName, "packageName");
        k.f(appName, "appName");
        k.f(versionName, "versionName");
        this.packageName = packageName;
        this.appName = appName;
        this.versionName = versionName;
        this.versionCode = j5;
    }

    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, String str3, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appInfo.packageName;
        }
        if ((i & 2) != 0) {
            str2 = appInfo.appName;
        }
        if ((i & 4) != 0) {
            str3 = appInfo.versionName;
        }
        if ((i & 8) != 0) {
            j5 = appInfo.versionCode;
        }
        String str4 = str3;
        return appInfo.copy(str, str2, str4, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component4, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    public final AppInfo copy(String packageName, String appName, String versionName, long versionCode) {
        k.f(packageName, "packageName");
        k.f(appName, "appName");
        k.f(versionName, "versionName");
        return new AppInfo(packageName, appName, versionName, versionCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) other;
        return k.b(this.packageName, appInfo.packageName) && k.b(this.appName, appInfo.appName) && k.b(this.versionName, appInfo.versionName) && this.versionCode == appInfo.versionCode;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return Long.hashCode(this.versionCode) + a.c(a.c(this.packageName.hashCode() * 31, 31, this.appName), 31, this.versionName);
    }

    public String toString() {
        String str = this.packageName;
        String str2 = this.appName;
        String str3 = this.versionName;
        long j5 = this.versionCode;
        StringBuilder sbW = a.w("AppInfo(packageName=", str, ", appName=", str2, ", versionName=");
        a.y(j5, str3, ", versionCode=", sbW);
        sbW.append(")");
        return sbW.toString();
    }
}
