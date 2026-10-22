package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MVUrlStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag;", "", "", "videoId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "coverUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCoverUrl", "title", "c", com.alipay.sdk.m.x.d.f25925o, "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "Lcom/bytedance/android/livesdkapi/depend/message/MVUrlStruct;", "downloadAddr", "Lcom/bytedance/android/livesdkapi/depend/message/MVUrlStruct;", "b", "()Lcom/bytedance/android/livesdkapi/depend/message/MVUrlStruct;", "setDownloadAddr", "(Lcom/bytedance/android/livesdkapi/depend/message/MVUrlStruct;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ag implements vh7.h {

    @SerializedName("cover_url")
    protected String coverUrl;

    @SerializedName("download_addr")
    protected MVUrlStruct downloadAddr;

    @SerializedName("duration")
    protected int duration;

    @SerializedName("title")
    protected String title;

    @SerializedName("vid")
    protected String videoId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ag) == false) goto L16;
        ag r101 = (ag) r100;
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.downloadAddr, r101.downloadAddr) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.videoId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.coverUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.duration) * 31;
        MVUrlStruct r110 = this.downloadAddr;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MVBaseInfo(videoId=" + this.videoId + ", coverUrl=" + this.coverUrl + ", title=" + this.title + ", duration=" + this.duration + ", downloadAddr=" + this.downloadAddr + ")";
    }

    public ag() {
        this.videoId = "";
        this.coverUrl = null;
        this.title = "";
        this.duration = 0;
        this.downloadAddr = null;
    }

    public final String a() {
        return this.coverUrl;
    }

    public final MVUrlStruct b() {
        return this.downloadAddr;
    }

    public final String c() {
        return this.title;
    }

    public final String d() {
        return this.videoId;
    }

    public ag(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.videoId = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.coverUrl = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.title = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.duration = r100.i();
        r102 = r102 | true;
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.downloadAddr = new MVUrlStruct(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this.videoId != null) goto L24;
        this.videoId = "";
    L24:
        if (this.coverUrl != null) goto L27;
        this.coverUrl = null;
    L27:
        if (this.title != null) goto L30;
        this.title = "";
    L30:
        if ((r102 & true) == true) goto L33;
        this.duration = 0;
    L33:
        if (this.downloadAddr != null) goto L54;
        this.downloadAddr = null;
        return;
    }
}
