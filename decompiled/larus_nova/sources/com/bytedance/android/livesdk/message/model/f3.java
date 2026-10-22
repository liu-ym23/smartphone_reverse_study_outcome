package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CombinedMessageMeta")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f3;", "", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/message/a5;", "", "maxRows", "I", "b", "()I", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f3 implements vh7.h {

    @SerializedName("display_text")
    protected com.bytedance.android.live.base.model.message.a5 displayText;

    @SerializedName("max_rows")
    protected int maxRows;

    public f3() {
    }

    public final com.bytedance.android.live.base.model.message.a5 a() {
        return this.displayText;
    }

    public final int b() {
        return this.maxRows;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public f3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.displayText = vh7.f.a(r100, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.maxRows = (int) r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
