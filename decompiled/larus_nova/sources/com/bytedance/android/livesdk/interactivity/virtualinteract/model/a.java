package com.bytedance.android.livesdk.interactivity.virtualinteract.model;

import am3.g;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.anchor.VirtualGameCreateActorResponse.Data")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/a;", "", "", "status", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "", "actorId", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setActorId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "e", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", "fail", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setFail", "(Ljava/lang/Boolean;)V", "", "failReason", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFailReason", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("actor_id")
    protected Long actorId;

    @SerializedName("fail_to_create")
    protected Boolean fail;

    @SerializedName("fail_reason")
    protected String failReason;

    @SerializedName("status")
    protected Integer status;

    @SerializedName("display_text")
    protected Text text;

    public a() {
    }

    public final Long a() {
        return this.actorId;
    }

    public final Boolean b() {
        return this.fail;
    }

    public final String c() {
        return this.failReason;
    }

    public final Integer d() {
        return this.status;
    }

    public final Text e() {
        return this.text;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.status = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.actorId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.text = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.fail = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.failReason = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
