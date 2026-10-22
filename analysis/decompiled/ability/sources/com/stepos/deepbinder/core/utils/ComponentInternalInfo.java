package com.stepos.deepbinder.core.utils;

import B7.a;
import android.net.Uri;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/stepos/deepbinder/core/utils/ComponentInternalInfo;", "", "processName", "", "stateServiceClassName", "authority", "Landroid/net/Uri;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getProcessName", "()Ljava/lang/String;", "setProcessName", "(Ljava/lang/String;)V", "getStateServiceClassName", "setStateServiceClassName", "getAuthority", "()Landroid/net/Uri;", "setAuthority", "(Landroid/net/Uri;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ComponentInternalInfo {
    private Uri authority;
    private String processName;
    private String stateServiceClassName;

    public ComponentInternalInfo(String str, String str2, Uri uri) {
        this.processName = str;
        this.stateServiceClassName = str2;
        this.authority = uri;
    }

    public static /* synthetic */ ComponentInternalInfo copy$default(ComponentInternalInfo componentInternalInfo, String str, String str2, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = componentInternalInfo.processName;
        }
        if ((i & 2) != 0) {
            str2 = componentInternalInfo.stateServiceClassName;
        }
        if ((i & 4) != 0) {
            uri = componentInternalInfo.authority;
        }
        return componentInternalInfo.copy(str, str2, uri);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProcessName() {
        return this.processName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStateServiceClassName() {
        return this.stateServiceClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final Uri getAuthority() {
        return this.authority;
    }

    public final ComponentInternalInfo copy(String processName, String stateServiceClassName, Uri authority) {
        return new ComponentInternalInfo(processName, stateServiceClassName, authority);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentInternalInfo)) {
            return false;
        }
        ComponentInternalInfo componentInternalInfo = (ComponentInternalInfo) other;
        return k.b(this.processName, componentInternalInfo.processName) && k.b(this.stateServiceClassName, componentInternalInfo.stateServiceClassName) && k.b(this.authority, componentInternalInfo.authority);
    }

    public final Uri getAuthority() {
        return this.authority;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final String getStateServiceClassName() {
        return this.stateServiceClassName;
    }

    public int hashCode() {
        String str = this.processName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.stateServiceClassName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Uri uri = this.authority;
        return iHashCode2 + (uri != null ? uri.hashCode() : 0);
    }

    public final void setAuthority(Uri uri) {
        this.authority = uri;
    }

    public final void setProcessName(String str) {
        this.processName = str;
    }

    public final void setStateServiceClassName(String str) {
        this.stateServiceClassName = str;
    }

    public String toString() {
        String str = this.processName;
        String str2 = this.stateServiceClassName;
        Uri uri = this.authority;
        StringBuilder sbW = a.w("ComponentInternalInfo(processName=", str, ", stateServiceClassName=", str2, ", authority=");
        sbW.append(uri);
        sbW.append(")");
        return sbW.toString();
    }
}
