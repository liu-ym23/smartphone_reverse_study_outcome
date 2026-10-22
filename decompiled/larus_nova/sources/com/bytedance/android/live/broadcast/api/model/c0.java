package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.privilege.ScreenChatSetting")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/c0;", "", "", "allow", "Ljava/lang/Boolean;", "getAllow", "()Ljava/lang/Boolean;", "setAllow", "(Ljava/lang/Boolean;)V", "", "followType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setFollowType", "(Ljava/lang/Integer;)V", "fansclubType", "b", "setFansclubType", "activeType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setActiveType", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 implements vh7.h {

    @SerializedName("active_type")
    protected Integer activeType;

    @SerializedName("allow")
    protected Boolean allow;

    @SerializedName("fansclub_type")
    protected Integer fansclubType;

    @SerializedName("follow_type")
    protected Integer followType;

    public c0() {
        this.fansclubType = 1;
    }

    public final Integer a() {
        return this.activeType;
    }

    public final Integer b() {
        return this.fansclubType;
    }

    public final Integer c() {
        return this.followType;
    }

    public c0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        if (r102 != 1) goto L7;
        this.allow = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L7:
        if (r102 != 2) goto L9;
        this.followType = Integer.valueOf((int) r100.j());
        goto L3
    L9:
        if (r102 != 3) goto L11;
        this.fansclubType = Integer.valueOf((int) r100.j());
        goto L3
    L11:
        if (r102 != 4) goto L12;
        this.activeType = Integer.valueOf((int) r100.j());
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.fansclubType != null) goto L36;
        this.fansclubType = 1;
        return;
    }
}
