package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0018R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/I0;", "", "", "data", "", "type", "appName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "setData", "(Ljava/lang/String;)V", "I", Const.INTENT_KEY_PKGNAME, "setType", "(I)V", "getAppName", "setAppName", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.I0, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class RobotArguments {

    @SerializedName("app_name")
    private String appName;
    private String data;
    private int type;

    public RobotArguments(String data, int i10, String str) {
        kotlin.jvm.internal.p.i(data, "data");
        this.data = data;
        this.type = i10;
        this.appName = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotArguments)) {
            return false;
        }
        RobotArguments robotArguments = (RobotArguments) other;
        return kotlin.jvm.internal.p.d(this.data, robotArguments.data) && this.type == robotArguments.type && kotlin.jvm.internal.p.d(this.appName, robotArguments.appName);
    }

    public int hashCode() {
        int iHashCode = ((this.data.hashCode() * 31) + Integer.hashCode(this.type)) * 31;
        String str = this.appName;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RobotArguments(data=" + this.data + ", type=" + this.type + ", appName=" + this.appName + ")";
    }

    public /* synthetic */ RobotArguments(String str, int i10, String str2, int i11, kotlin.jvm.internal.i iVar) {
        this(str, i10, (i11 & 4) != 0 ? "" : str2);
    }
}
