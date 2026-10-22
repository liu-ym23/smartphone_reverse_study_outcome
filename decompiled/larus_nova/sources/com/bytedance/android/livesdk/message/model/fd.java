package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/fd;", "", "", "vId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setVId", "(Ljava/lang/String;)V", "authToken", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAuthToken", "", "videoType", "I", "e", "()I", "setVideoType", "(I)V", "", "Lcom/bytedance/android/livesdk/message/model/ed;", "colorList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setColorList", "(Ljava/util/List;)V", "urls", "c", "setUrls", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class fd implements vh7.h {

    @SerializedName("play_auth_token")
    protected String authToken;

    @SerializedName("frame_color_data")
    protected List<ed> colorList;

    @SerializedName("video_url")
    protected List<String> urls;

    @SerializedName("vid")
    protected String vId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    protected int videoType;

    public fd() {
        this.videoType = MvVideoType.VIDEO_TYPE_NORMAL_MATERIAL.getValue();
    }

    public final String a() {
        return this.authToken;
    }

    public final List<ed> b() {
        return this.colorList;
    }

    public final List<String> c() {
        return this.urls;
    }

    public final String d() {
        return this.vId;
    }

    public final int e() {
        return this.videoType;
    }

    public fd(am3.g r100) {
        this.colorList = new ArrayList();
        this.urls = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L7;
        this.vId = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.authToken = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.videoType = r100.i();
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 == 4) goto L16;
        if (r103 != 5) goto L14;
        List r104 = this.urls;
        Object r105 = am3.h.c(r100);
    L17:
        r104.add(r105);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L16:
        r104 = this.colorList;
        r105 = new ed(r100);
        goto L17
    L21:
        r100.d(r101);
        if ((r102 & true) == true) goto L41;
        this.videoType = MvVideoType.VIDEO_TYPE_NORMAL_MATERIAL.getValue();
        return;
    }
}
