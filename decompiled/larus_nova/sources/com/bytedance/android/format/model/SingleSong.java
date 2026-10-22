package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003Jl\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/bytedance/android/format/model/SingleSong;", "Ljava/io/Serializable;", "songId", "", "title", "", "author", "duration", "", "coverUrl", "songUrl", "songUri", ITTVideoEngineEventSource.KEY_VOLUME, "", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V", "getAuthor", "()Ljava/lang/String;", "getCoverUrl", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSongId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSongUri", "getSongUrl", "getTitle", "getVolume", "()F", "setVolume", "(F)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)Lcom/bytedance/android/format/model/SingleSong;", "equals", "", "other", "", "hashCode", "toString", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleSong implements Serializable {

    @SerializedName("author")
    private final String author;

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("duration")
    private final Integer duration;

    @SerializedName("song_id")
    private final Long songId;

    @SerializedName("song_uri")
    private final String songUri;

    @SerializedName("song_url")
    private final String songUrl;

    @SerializedName("title")
    private final String title;

    @SerializedName(ITTVideoEngineEventSource.KEY_VOLUME)
    private float volume;

    public SingleSong() {
        this(null, null, null, null, null, null, null, 0.0f, 255, null);
    }

    public static /* synthetic */ SingleSong copy$default(SingleSong r100, Long r110, String r111, String r112, Integer r113, String r114, String r115, String r116, float r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Long r101 = r100.songId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.title;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.author;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = r100.duration;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.coverUrl;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.songUrl;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.songUri;
    L31:
        if ((r118 & 128) == 0) goto L33;
        float r108 = r100.volume;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Long component1() {
        return this.songId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.author;
    }

    public final Integer component4() {
        return this.duration;
    }

    public final String component5() {
        return this.coverUrl;
    }

    public final String component6() {
        return this.songUrl;
    }

    public final String component7() {
        return this.songUri;
    }

    public final float component8() {
        return this.volume;
    }

    public final SingleSong copy(Long r110, String r111, String r112, Integer r113, String r114, String r115, String r116, float r117) {
        return new SingleSong(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SingleSong) == false) goto L22;
        SingleSong r101 = (SingleSong) r100;
        if (Intrinsics.areEqual(this.songId, r101.songId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.author, r101.author) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.songUrl, r101.songUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.songUri, r101.songUri) == true) goto L20;
        return false;
    L20:
        if (Float.compare(this.volume, r101.volume) == 0) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Long r100 = this.songId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.author;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.duration;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.coverUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.songUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.songUri;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return ((r118 + r101) * 31) + Float.floatToIntBits(this.volume);
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "SingleSong(songId=" + this.songId + ", title=" + this.title + ", author=" + this.author + ", duration=" + this.duration + ", coverUrl=" + this.coverUrl + ", songUrl=" + this.songUrl + ", songUri=" + this.songUri + ", volume=" + this.volume + ")";
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Long getSongId() {
        return this.songId;
    }

    public final String getSongUri() {
        return this.songUri;
    }

    public final String getSongUrl() {
        return this.songUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final void setVolume(float r100) {
        this.volume = r100;
    }

    public SingleSong(Long r100, String r101, String r102, Integer r103, String r104, String r105, String r106, float r107) {
        this.songId = r100;
        this.title = r101;
        this.author = r102;
        this.duration = r103;
        this.coverUrl = r104;
        this.songUrl = r105;
        this.songUri = r106;
        this.volume = r107;
    }

    public /* synthetic */ SingleSong(Long r110, String r111, String r112, Integer r113, String r114, String r115, String r116, float r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        float r107 = 0.5f;
    L34:
        this(r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
