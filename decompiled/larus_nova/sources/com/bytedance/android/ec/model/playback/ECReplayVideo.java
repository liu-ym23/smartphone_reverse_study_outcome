package com.bytedance.android.ec.model.playback;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.model.video.ECBaseVideo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "Lcom/bytedance/android/ec/model/video/ECBaseVideo;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "fragmentId", "getFragmentId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECReplayVideo extends ECBaseVideo {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("fragment_id")
    private final String fragmentId;

    @SerializedName("title")
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECReplayVideo() {
    }

    public final String getFragmentId() {
        return this.fragmentId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
