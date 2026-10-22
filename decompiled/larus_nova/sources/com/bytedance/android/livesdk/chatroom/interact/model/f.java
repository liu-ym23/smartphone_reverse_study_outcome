package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.PrecisionMatchSettings")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/f;", "", "", "acceptPrecisionMatch", "Z", "getAcceptPrecisionMatch", "()Z", "setAcceptPrecisionMatch", "(Z)V", "", "precisionMatchPreferGender", "I", "getPrecisionMatchPreferGender", "()I", "setPrecisionMatchPreferGender", "(I)V", "precisionMatchFrequency", "getPrecisionMatchFrequency", "setPrecisionMatchFrequency", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("accept_precision_match")
    protected boolean acceptPrecisionMatch;

    @SerializedName("precision_match_frequency")
    protected int precisionMatchFrequency;

    @SerializedName("precision_match_prefer_gender")
    protected int precisionMatchPreferGender;

    public f() {
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.acceptPrecisionMatch = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.precisionMatchPreferGender = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.precisionMatchFrequency = (int) r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
