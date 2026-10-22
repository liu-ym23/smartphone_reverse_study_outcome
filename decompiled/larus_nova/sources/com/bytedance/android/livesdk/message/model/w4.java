package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.GameCardInfo")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/w4;", "", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w4 implements vh7.h {

    @SerializedName("app_id")
    protected String _$$appId;

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("display_status")
    protected Integer _$$displayStatus;

    @SerializedName("duration")
    protected Long _$$duration;

    @SerializedName("save_time")
    protected Long _$$saveTime;

    @SerializedName("status")
    protected Long _$$status;

    @SerializedName("open_url")
    protected String _$$url;

    public w4() {
        this._$$displayStatus = 1;
        this._$$status = 1L;
        this._$$url = "";
        this._$$content = "";
        this._$$appId = "";
        this._$$saveTime = 0L;
        this._$$duration = 10L;
    }

    public final String a() {
        return this._$$content;
    }

    public final Integer b() {
        return this._$$displayStatus;
    }

    public final Long c() {
        return this._$$duration;
    }

    public final Long d() {
        return this._$$status;
    }

    public w4(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this._$$duration = Long.valueOf(r100.j());
        goto L3
    L8:
        this._$$saveTime = Long.valueOf(r100.j());
        goto L3
    L9:
        this._$$appId = am3.h.c(r100);
        goto L3
    L10:
        this._$$content = am3.h.c(r100);
        goto L3
    L11:
        this._$$url = am3.h.c(r100);
        goto L3
    L12:
        this._$$status = Long.valueOf(r100.j());
        goto L3
    L13:
        this._$$displayStatus = Integer.valueOf(r100.i());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this._$$displayStatus != null) goto L18;
        this._$$displayStatus = 1;
    L18:
        if (this._$$status != null) goto L21;
        this._$$status = 1L;
    L21:
        if (this._$$url != null) goto L24;
        this._$$url = "";
    L24:
        if (this._$$content != null) goto L27;
        this._$$content = "";
    L27:
        if (this._$$appId != null) goto L30;
        this._$$appId = "";
    L30:
        if (this._$$saveTime != null) goto L33;
        this._$$saveTime = 0L;
    L33:
        if (this._$$duration != null) goto L54;
        this._$$duration = 10L;
        return;
    }
}
