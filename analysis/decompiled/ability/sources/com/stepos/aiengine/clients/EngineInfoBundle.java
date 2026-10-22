package com.stepos.aiengine.clients;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0011¨\u0006&"}, d2 = {"Lcom/stepos/aiengine/clients/EngineInfoBundle;", "", "", "packageName", "versionName", "", "versionCode", "", "apiVersion", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JI)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "()I", "copy", "(Ljava/lang/String;Ljava/lang/String;JI)Lcom/stepos/aiengine/clients/EngineInfoBundle;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getPackageName", "b", "getVersionName", "c", "J", "getVersionCode", "d", "I", "getApiVersion", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EngineInfoBundle {
    public static final int CURRENT_API_VERSION = 1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String packageName;

    /* renamed from: b, reason: from kotlin metadata */
    public final String versionName;

    /* renamed from: c, reason: from kotlin metadata */
    public final long versionCode;

    /* renamed from: d, reason: from kotlin metadata */
    public final int apiVersion;

    public EngineInfoBundle(String packageName, String versionName, long j5, int i) {
        k.f(packageName, "packageName");
        k.f(versionName, "versionName");
        this.packageName = packageName;
        this.versionName = versionName;
        this.versionCode = j5;
        this.apiVersion = i;
    }

    public static /* synthetic */ EngineInfoBundle copy$default(EngineInfoBundle engineInfoBundle, String str, String str2, long j5, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = engineInfoBundle.packageName;
        }
        if ((i6 & 2) != 0) {
            str2 = engineInfoBundle.versionName;
        }
        if ((i6 & 4) != 0) {
            j5 = engineInfoBundle.versionCode;
        }
        if ((i6 & 8) != 0) {
            i = engineInfoBundle.apiVersion;
        }
        int i10 = i;
        return engineInfoBundle.copy(str, str2, j5, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component3, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component4, reason: from getter */
    public final int getApiVersion() {
        return this.apiVersion;
    }

    public final EngineInfoBundle copy(String packageName, String versionName, long versionCode, int apiVersion) {
        k.f(packageName, "packageName");
        k.f(versionName, "versionName");
        return new EngineInfoBundle(packageName, versionName, versionCode, apiVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EngineInfoBundle)) {
            return false;
        }
        EngineInfoBundle engineInfoBundle = (EngineInfoBundle) other;
        return k.b(this.packageName, engineInfoBundle.packageName) && k.b(this.versionName, engineInfoBundle.versionName) && this.versionCode == engineInfoBundle.versionCode && this.apiVersion == engineInfoBundle.apiVersion;
    }

    public final int getApiVersion() {
        return this.apiVersion;
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
        return Integer.hashCode(this.apiVersion) + a.c(B7.a.c(this.packageName.hashCode() * 31, 31, this.versionName), 31, this.versionCode);
    }

    public String toString() {
        StringBuilder sbW = B7.a.w("EngineInfoBundle(packageName=", this.packageName, ", versionName=", this.versionName, ", versionCode=");
        sbW.append(this.versionCode);
        sbW.append(", apiVersion=");
        sbW.append(this.apiVersion);
        sbW.append(")");
        return sbW.toString();
    }
}
