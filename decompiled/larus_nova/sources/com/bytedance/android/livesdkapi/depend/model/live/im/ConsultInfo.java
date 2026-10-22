package com.bytedance.android.livesdkapi.depend.model.live.im;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.IndustryServiceInfo.ConsultInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nJ\b\u0010\u0016\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/im/ConsultInfo;", "", "()V", "_info", "", "get_info", "()Ljava/lang/String;", "set_info", "(Ljava/lang/String;)V", "_roles", "", "get_roles", "()I", "set_roles", "(I)V", "getInfo", "getRoles", "setInfo", "", "info", "setRoles", "roles", "toString", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConsultInfo implements h {
    public static final Companion Companion = null;
    public static final int ROLE_CLIENT_SERVICE = 2;
    public static final int ROLE_NORMAL_USER = 1;

    @SerializedName("biz_info")
    protected String _info;

    @SerializedName("consult_role")
    protected int _roles;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/im/ConsultInfo$Companion;", "", "()V", "ROLE_CLIENT_SERVICE", "", "ROLE_NORMAL_USER", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ConsultInfo() {
    }

    public String toString() {
        return "ConsultInfo{info='" + this._info + "', roles=" + this._roles + '}';
    }

    public final String getInfo() {
        return this._info;
    }

    public final int getRoles() {
        return this._roles;
    }

    public final String get_info() {
        return this._info;
    }

    public final int get_roles() {
        return this._roles;
    }

    public ConsultInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this._info = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._roles = r100.i();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setInfo(String r100) {
        this._info = r100;
    }

    public final void setRoles(int r100) {
        this._roles = r100;
    }

    public final void set_info(String r100) {
        this._info = r100;
    }

    public final void set_roles(int r100) {
        this._roles = r100;
    }
}
