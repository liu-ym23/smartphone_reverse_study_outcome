package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.im.NotifyMessage.Content")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/l2;", "", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "needHighlight", "Z", "b", "()Z", "d", "(Z)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l2 implements vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("need_high_light")
    protected boolean needHighlight;

    public l2() {
    }

    public l2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.content = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.needHighlight = am3.h.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void d() {
        this.needHighlight = true;
    }

    public final String a() {
        return this.content;
    }

    public final boolean b() {
        return this.needHighlight;
    }

    public final void c(String r100) {
        this.content = r100;
    }
}
