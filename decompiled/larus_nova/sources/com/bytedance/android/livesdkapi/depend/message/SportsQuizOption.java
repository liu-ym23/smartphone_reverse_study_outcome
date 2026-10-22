package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.SportsQuizOption")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/SportsQuizOption;", "", "()V", "betAmount", "", "betAmountStr", "", "optionDesc", "optionId", "rate", "", "rateStr", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SportsQuizOption implements h {

    @SerializedName("bet_amount")
    public long betAmount;

    @SerializedName("bet_amount_str")
    public String betAmountStr;

    @SerializedName("option_desc")
    public String optionDesc;

    @SerializedName("option_id")
    public long optionId;

    @SerializedName("rate")
    public double rate;

    @SerializedName("rate_str")
    public String rateStr;

    public SportsQuizOption() {
    }

    public SportsQuizOption(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.rateStr = am3.h.c(r100);
        goto L3
    L8:
        this.rate = Double.longBitsToDouble(r100.h());
        goto L3
    L9:
        this.betAmountStr = am3.h.c(r100);
        goto L3
    L10:
        this.betAmount = r100.j();
        goto L3
    L11:
        this.optionDesc = am3.h.c(r100);
        goto L3
    L12:
        this.optionId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
