package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/h;", "", "", "user_id", "J", "getUser_id", "()J", "desc_idx", "getDesc_idx", "", "user_open_id", "Ljava/lang/String;", "getUser_open_id", "()Ljava/lang/String;", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("desc_idx")
    protected long desc_idx;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("user_id")
    protected long user_id;

    @SerializedName("user_open_id")
    protected String user_open_id;

    public h() {
        this.extra = "";
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.user_id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.desc_idx = r100.j();
        goto L3
    L10:
        if (r102 != 100) goto L12;
        this.extra = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.user_open_id = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.extra != null) goto L37;
        this.extra = "";
        return;
    }
}
