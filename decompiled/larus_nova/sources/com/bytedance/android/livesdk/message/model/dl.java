package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.ShelfTopTradeData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/dl;", "", "", "title", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "value", "b", "type", "getType", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dl implements vh7.h {

    @SerializedName("top_data_title")
    protected String title;

    @SerializedName("type")
    protected String type;

    @SerializedName("top_data_value")
    protected String value;

    public dl() {
    }

    public dl(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.value = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.type = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String a() {
        return this.title;
    }

    public final String b() {
        return this.value;
    }

    public final String getType() {
        return this.type;
    }
}
