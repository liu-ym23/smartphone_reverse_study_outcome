package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.od;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/a;", "", "Lcom/bytedance/android/livesdk/message/model/fd;", "videoInfo", "Lcom/bytedance/android/livesdk/message/model/fd;", "b", "()Lcom/bytedance/android/livesdk/message/model/fd;", "setVideoInfo", "(Lcom/bytedance/android/livesdk/message/model/fd;)V", "Lcom/bytedance/android/livesdk/message/model/od;", "verticalVideoInfo", "Lcom/bytedance/android/livesdk/message/model/od;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/od;", "setVerticalVideoInfo", "(Lcom/bytedance/android/livesdk/message/model/od;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements vh7.h {

    @SerializedName("vertical_video_info")
    protected od verticalVideoInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_INFO)
    protected fd videoInfo;

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.model.api.a$a, reason: collision with other inner class name */
    public static final class C1137a {
    }

    static {
    }

    public a() {
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.videoInfo = new fd(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.verticalVideoInfo = new od(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final od a() {
        return this.verticalVideoInfo;
    }

    public final fd b() {
        return this.videoInfo;
    }
}
