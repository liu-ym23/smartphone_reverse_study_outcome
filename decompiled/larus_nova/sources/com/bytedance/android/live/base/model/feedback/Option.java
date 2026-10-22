package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard.Option")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/Option;", "", "()V", "key", "", com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE, "", "Ljava/lang/Boolean;", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "", "Ljava/lang/Long;", "text", "toastText", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Option implements h {

    @SerializedName("key")
    public String key;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE)
    public Boolean negative;

    @SerializedName("sub_question_id")
    public Long question;

    @SerializedName("text")
    public String text;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    public String toastText;

    public Option() {
    }

    public Option(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.key = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.text = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.question = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.negative = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.toastText = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
