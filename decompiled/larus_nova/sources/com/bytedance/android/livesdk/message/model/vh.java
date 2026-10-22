package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OriginRoomInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vh;", "", "", "roomId", "J", "c", "()J", "setRoomId", "(J)V", "", "enableLink", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableLink", "(Z)V", "", "roomJumpUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setRoomJumpUrl", "(Ljava/lang/String;)V", "isAnchor", "e", "setAnchor", "linkText", "b", "setLinkText", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class vh implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f153701a;

    @SerializedName("enable_link")
    protected boolean enableLink;

    @SerializedName(IPerformanceManager.Params.is_anchor)
    protected boolean isAnchor;

    @SerializedName("link_text")
    protected String linkText;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("room_url")
    protected String roomJumpUrl;

    public vh() {
    }

    public final boolean a() {
        return this.enableLink;
    }

    public final String b() {
        return this.linkText;
    }

    public final long c() {
        return this.roomId;
    }

    public final String d() {
        return this.roomJumpUrl;
    }

    public final boolean e() {
        return this.isAnchor;
    }

    public vh(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.roomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.enableLink = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.roomJumpUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.isAnchor = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.linkText = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
