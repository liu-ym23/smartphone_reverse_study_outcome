package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/q2;", "", "", "chorusId", "Ljava/lang/Long;", "getChorusId", "()Ljava/lang/Long;", "Lcom/bytedance/android/livesdk/message/model/aj;", "chorusInfo", "Lcom/bytedance/android/livesdk/message/model/aj;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/aj;", "", "chorusIdStr", "Ljava/lang/String;", "getChorusIdStr", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "concertSong", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "getConcertSong", "()Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q2 implements vh7.h {

    @SerializedName("chorus_id")
    protected Long chorusId;

    @SerializedName("chorus_id_str")
    protected String chorusIdStr;

    @SerializedName("chorus_info")
    protected aj chorusInfo;

    @SerializedName("concert_song")
    protected ChorusConcertSong concertSong;

    public q2() {
    }

    public final aj a() {
        return this.chorusInfo;
    }

    public q2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.chorusId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.chorusInfo = new aj(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.concertSong = new ChorusConcertSong(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.chorusIdStr = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
