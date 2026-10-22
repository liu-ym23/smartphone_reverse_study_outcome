package com.bytedance.android.livesdk.interactivity.comment.highlight;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.ugm.api.webcast_replay_biz.StartScreenRecordResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "recordUrl", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "setRecordUrl", "(Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;)V", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/c;", "screenRecord", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/c;", "b", "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/c;", "setScreenRecord", "(Lcom/bytedance/android/livesdk/interactivity/comment/highlight/c;)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements h {

    @SerializedName("record_url")
    protected b recordUrl;

    @SerializedName("screen_record")
    protected c screenRecord;

    public d() {
    }

    public d(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.recordUrl = new b(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.screenRecord = new c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final b a() {
        return this.recordUrl;
    }

    public final c b() {
        return this.screenRecord;
    }
}
