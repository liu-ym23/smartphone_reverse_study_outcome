package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/p;", "", "", "imageId", "Ljava/lang/String;", "Lpy/k;", "image", "Lpy/k;", "text", "", "triggerWords", "Ljava/util/List;", "", "beginTime", "J", "endTime", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements vh7.h {

    @SerializedName("begin_time")
    public long beginTime;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("image")
    public py.k image;

    @SerializedName("image_id")
    public String imageId;

    @SerializedName("text")
    public String text;

    @SerializedName("trigger_words")
    public List<String> triggerWords;

    public static final class a {
    }

    static {
    }

    public p() {
        this.imageId = "";
        this.text = "";
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public p(am3.g r100) {
        this.triggerWords = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.imageId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.image = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.text = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.triggerWords.add(am3.h.c(r100));
        goto L3
    L14:
        if (r102 != 10) goto L16;
        this.beginTime = r100.j();
        goto L3
    L16:
        if (r102 != 11) goto L17;
        this.endTime = r100.j();
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.imageId != null) goto L28;
        this.imageId = "";
    L28:
        if (this.text != null) goto L52;
        this.text = "";
        return;
    }
}
