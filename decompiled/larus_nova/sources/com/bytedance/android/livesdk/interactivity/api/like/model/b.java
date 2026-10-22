package com.bytedance.android.livesdk.interactivity.api.like.model;

import am3.g;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.DoubleLikeSyncData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/like/model/b;", "", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "detail", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "setDetail", "(Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "selfDisplayText", "Lcom/bytedance/android/livesdkapi/message/Text;", "c", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setSelfDisplayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "normalDisplayText", "b", "setNormalDisplayText", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("doubleLikeStatus")
    protected a detail;

    @SerializedName("normal_display_text")
    protected Text normalDisplayText;

    @SerializedName("self_display_text")
    protected Text selfDisplayText;

    public b() {
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.detail = new a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.selfDisplayText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.normalDisplayText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final a a() {
        return this.detail;
    }

    public final Text b() {
        return this.normalDisplayText;
    }

    public final Text c() {
        return this.selfDisplayText;
    }
}
