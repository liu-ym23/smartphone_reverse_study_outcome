package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/format/model/o0;", "", "", "mediaType", "I", "getMediaType", "()I", "setMediaType", "(I)V", "", "mediaUrl", "Ljava/lang/String;", "getMediaUrl", "()Ljava/lang/String;", "setMediaUrl", "(Ljava/lang/String;)V", "", "width", "J", "getWidth", "()J", "setWidth", "(J)V", "height", "getHeight", "setHeight", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "vid", "getVid", "setVid", "songId", "getSongId", "setSongId", "", ITTVideoEngineEventSource.KEY_VOLUME, "Ljava/lang/Double;", "getVolume", "()Ljava/lang/Double;", "setVolume", "(Ljava/lang/Double;)V", "duration", "getDuration", "setDuration", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f51367d;

    @SerializedName("duration")
    private long duration;

    @SerializedName("height")
    private long height;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
    private int mediaType;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("song_id")
    private long songId;

    @SerializedName("title")
    private String title;

    @SerializedName("resource_id")
    private String vid;

    @SerializedName(ITTVideoEngineEventSource.KEY_VOLUME)
    private Double volume;

    @SerializedName("width")
    private long width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L34;
        o0 r101 = (o0) r100;
        if (this.mediaType == r101.mediaType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mediaUrl, r101.mediaUrl) == true) goto L10;
        return false;
    L10:
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L18;
        return false;
    L18:
        if (this.songId == r101.songId) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.volume, r101.volume) == true) goto L22;
        return false;
    L22:
        if (this.duration == r101.duration) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f51364a, r101.f51364a) == true) goto L26;
        return false;
    L26:
        if (this.f51365b == r101.f51365b) goto L28;
        return false;
    L28:
        if (this.f51366c == r101.f51366c) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f51367d, r101.f51367d) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(null, null) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [int] */
    /* JADX WARN: Type inference failed for: r3v19 */
    public final int hashCode() {
        int r100 = this.mediaType * 31;
        String r101 = this.mediaUrl;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        long r103 = this.width;
        int r104 = (((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.height;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.title;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.vid;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        long r113 = this.songId;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        Double r115 = this.volume;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        long r118 = this.duration;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        String r120 = this.f51364a;
        if (r120 == null) goto L21;
        int r121 = r120.hashCode();
    L22:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.f51365b;
        ?? r124 = 1;
        ?? r125 = r123;
        if (r123 == false) goto L25;
        r125 = 1;
    L25:
        int r126 = (r122 + r125) * 31;
        boolean r127 = this.f51366c;
        if (r127 == true) goto L29;
        r124 = r127;
    L29:
        int r128 = (r126 + r124) * 31;
        String r129 = this.f51367d;
        if (r129 == null) goto L32;
        int r130 = r129.hashCode();
    L34:
        return ((r128 + r130) * 31) + 0;
    L32:
        r130 = 0;
        goto L34
    L21:
        r121 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaItem(mediaType=" + this.mediaType + ", mediaUrl=" + this.mediaUrl + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", vid=" + this.vid + ", songId=" + this.songId + ", volume=" + this.volume + ", duration=" + this.duration + ", localUri=" + this.f51364a + ", hasSelected=" + this.f51365b + ", isLocalUri=" + this.f51366c + ", localPath=" + this.f51367d + ", mediaExtraInfo=null)";
    }

    public o0() {
        this.mediaType = 5;
        this.mediaUrl = null;
        this.width = 0;
        this.height = 0;
        this.title = null;
        this.vid = null;
        this.songId = 0;
        this.volume = null;
        this.duration = 0;
        this.f51364a = null;
        this.f51365b = false;
        this.f51366c = false;
        this.f51367d = null;
    }
}
