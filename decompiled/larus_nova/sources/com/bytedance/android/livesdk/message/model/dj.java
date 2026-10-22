package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RcmdUser")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/dj;", "", "", "user", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUser", "(Ljava/lang/String;)V", "buttonBeforeText", "c", "setButtonBeforeText", "buttonAfterText", "b", "setButtonAfterText", faceverify.w.META_COLL_KEY_AUTH_INFO, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAuthInfo", "editScript", "d", "setEditScript", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dj implements vh7.h {

    @SerializedName("authentication_info")
    protected String authInfo;

    @SerializedName("text_after_action")
    protected String buttonAfterText;

    @SerializedName("text_before_action")
    protected String buttonBeforeText;

    @SerializedName("edit_script")
    protected String editScript;

    @SerializedName("user")
    protected String user;

    public static final class a {
    }

    static {
    }

    public dj() {
    }

    public dj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.user = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.buttonBeforeText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.buttonAfterText = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.authInfo = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.editScript = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final String toString() {
        return "RcmUser{user='" + this.user + "', buttonBeforeText='" + this.buttonBeforeText + "', buttonAfterText='" + this.buttonAfterText + "', authInfo='" + this.authInfo + "', editScript='" + this.editScript + "'}";
    }

    public final String a() {
        return this.authInfo;
    }

    public final String b() {
        return this.buttonAfterText;
    }

    public final String c() {
        return this.buttonBeforeText;
    }

    public final String d() {
        return this.editScript;
    }

    public final String e() {
        return this.user;
    }
}
