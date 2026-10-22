package com.bytedance.android.livesdk.chatroom.replay.paid.api;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/paid/api/b;", "", "", "ticketId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "status", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("status")
    protected int status;

    @SerializedName("ticket_id")
    protected String ticketId;

    public static final class a {
    }

    static {
    }

    public b() {
        this.ticketId = "";
        this.status = -1;
    }

    public final int a() {
        return this.status;
    }

    public final String b() {
        return this.ticketId;
    }

    public b(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.ticketId = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 17) goto L8;
        this.status = r100.i();
        r102 = r102 | true;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if (this.ticketId != null) goto L15;
        this.ticketId = "";
    L15:
        if ((r102 & true) == true) goto L27;
        this.status = -1;
        return;
    }
}
