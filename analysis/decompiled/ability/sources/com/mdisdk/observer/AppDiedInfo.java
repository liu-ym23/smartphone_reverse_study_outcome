package com.mdisdk.observer;

import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/mdisdk/observer/AppDiedInfo;", "", "uid", "", "packageName", "", WindowStateInfo.KEY_DISPLAY_ID, "restarting", "", "timestamp", "", AppAgent.CONSTRUCT, "(ILjava/lang/String;IZJ)V", "getUid", "()I", "getPackageName", "()Ljava/lang/String;", "getDisplayId", "getRestarting", "()Z", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppDiedInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int displayId;
    private final String packageName;
    private final boolean restarting;
    private final long timestamp;
    private final int uid;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/mdisdk/observer/AppDiedInfo$Companion;", "", AppAgent.CONSTRUCT, "()V", TypedValues.TransitionType.S_FROM, "Lcom/mdisdk/observer/AppDiedInfo;", "uid", "", "packageName", "", WindowStateInfo.KEY_DISPLAY_ID, "restarting", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ AppDiedInfo from$default(Companion companion, int i, String str, int i6, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                i6 = -1;
            }
            return companion.from(i, str, i6, z10);
        }

        public final AppDiedInfo from(int uid, String packageName, int displayId, boolean restarting) {
            k.f(packageName, "packageName");
            return new AppDiedInfo(uid, packageName, displayId, restarting, 0L, 16, null);
        }

        private Companion() {
        }
    }

    public AppDiedInfo(int i, String packageName, int i6, boolean z10, long j5) {
        k.f(packageName, "packageName");
        this.uid = i;
        this.packageName = packageName;
        this.displayId = i6;
        this.restarting = z10;
        this.timestamp = j5;
    }

    public static /* synthetic */ AppDiedInfo copy$default(AppDiedInfo appDiedInfo, int i, String str, int i6, boolean z10, long j5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = appDiedInfo.uid;
        }
        if ((i10 & 2) != 0) {
            str = appDiedInfo.packageName;
        }
        if ((i10 & 4) != 0) {
            i6 = appDiedInfo.displayId;
        }
        if ((i10 & 8) != 0) {
            z10 = appDiedInfo.restarting;
        }
        if ((i10 & 16) != 0) {
            j5 = appDiedInfo.timestamp;
        }
        long j6 = j5;
        return appDiedInfo.copy(i, str, i6, z10, j6);
    }

    public static final AppDiedInfo from(int i, String str, int i6, boolean z10) {
        return INSTANCE.from(i, str, i6, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getUid() {
        return this.uid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRestarting() {
        return this.restarting;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final AppDiedInfo copy(int uid, String packageName, int displayId, boolean restarting, long timestamp) {
        k.f(packageName, "packageName");
        return new AppDiedInfo(uid, packageName, displayId, restarting, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppDiedInfo)) {
            return false;
        }
        AppDiedInfo appDiedInfo = (AppDiedInfo) other;
        return this.uid == appDiedInfo.uid && k.b(this.packageName, appDiedInfo.packageName) && this.displayId == appDiedInfo.displayId && this.restarting == appDiedInfo.restarting && this.timestamp == appDiedInfo.timestamp;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getRestarting() {
        return this.restarting;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + a.d(androidx.constraintlayout.core.dsl.a.a(this.displayId, B7.a.c(Integer.hashCode(this.uid) * 31, 31, this.packageName), 31), 31, this.restarting);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppDiedInfo(uid=");
        sb.append(this.uid);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", displayId=");
        sb.append(this.displayId);
        sb.append(", restarting=");
        sb.append(this.restarting);
        sb.append(", timestamp=");
        return B7.a.p(sb, this.timestamp, ')');
    }

    public /* synthetic */ AppDiedInfo(int i, String str, int i6, boolean z10, long j5, int i10, e eVar) {
        this(i, str, (i10 & 4) != 0 ? -1 : i6, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? System.currentTimeMillis() : j5);
    }
}
