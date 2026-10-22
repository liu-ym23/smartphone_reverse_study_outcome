package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.PushResInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/f;", "", "", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE, "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setOk", "(Ljava/lang/Boolean;)V", "", "msg", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("message")
    protected String msg;

    /* JADX INFO: renamed from: ok, reason: collision with root package name */
    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE)
    protected Boolean f104459ok;

    public f() {
        this.f104459ok = Boolean.FALSE;
        this.msg = "";
    }

    public final String a() {
        return this.msg;
    }

    public final Boolean b() {
        return this.f104459ok;
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.f104459ok = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.msg = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.f104459ok != null) goto L16;
        this.f104459ok = Boolean.FALSE;
    L16:
        if (this.msg != null) goto L28;
        this.msg = "";
        return;
    }
}
