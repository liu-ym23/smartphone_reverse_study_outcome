package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.message.a5;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/SuffixText;", "", "", "bizType", "J", "getBizType", "()J", "setBizType", "(J)V", "Lcom/bytedance/android/live/base/model/message/a5;", "text", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/lang/String;", "getTags", "()Ljava/lang/String;", "setTags", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SuffixText implements h {

    @SerializedName("biz_type")
    protected long bizType;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected String tags;

    @SerializedName("text")
    protected a5 text;

    public SuffixText() {
    }

    public final long getBizType() {
        return this.bizType;
    }

    public final String getTags() {
        return this.tags;
    }

    public final a5 getText() {
        return this.text;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public SuffixText(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.bizType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.text = f.a(r100, a5.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.tags = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setBizType(long r100) {
        this.bizType = r100;
    }

    public final void setTags(String r100) {
        this.tags = r100;
    }

    public final void setText(a5 r100) {
        this.text = r100;
    }
}
