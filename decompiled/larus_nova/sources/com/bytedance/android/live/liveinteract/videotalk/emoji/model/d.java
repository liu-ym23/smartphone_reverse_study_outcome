package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d {
    public static final int TYPE_ICON_MOVE = 1;
    public static final int TYPE_MIC_SEAT = 4;
    public static final int TYPE_TRACK_EFFECT = 2;
    public static final int TYPE_TRANS_EFFECT = 3;
    public static final int TYPE_UNDEFINED = 0;

    @SerializedName("duration_ms")
    public long duration;

    @SerializedName("own_emoji_duration_ms")
    public long extraDuration;

    @IgnoreProtoFieldCheck
    @SerializedName("level")
    public int level;

    @IgnoreProtoFieldCheck
    @SerializedName("offset")
    public long offset;

    @IgnoreProtoFieldCheck
    @SerializedName("offset_start")
    public int offsetStart;

    @IgnoreProtoFieldCheck
    @SerializedName("reshape")
    public boolean reshape;

    @IgnoreProtoFieldCheck
    @SerializedName("reshape_start")
    public Long reshapeStart;

    @IgnoreProtoFieldCheck
    @SerializedName("scale_up")
    public long sizeScale;

    @IgnoreProtoFieldCheck
    @SerializedName("sound_url")
    public String soundUrl;

    @SerializedName("start")
    public long start;

    @IgnoreProtoFieldCheck
    @SerializedName("time_offset")
    public int timeOffset;

    @IgnoreProtoFieldCheck
    @SerializedName("type")
    public int type;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @IgnoreProtoFieldCheck
    @SerializedName("x")
    public int f79386x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @IgnoreProtoFieldCheck
    @SerializedName("y")
    public int f79387y;

    public abstract py.k dynamicImage();

    public abstract py.k extraDynamicImage();

    public abstract <T extends py.k> List<T> resources();

    public String toString() {
        return "InteractEmojiAnim{type=" + this.type + ", level=" + this.level + ", resources=" + resources() + ", dynamicImage=" + dynamicImage() + ", duration=" + this.duration + ", start=" + this.start + ", offset=" + this.offset + ", sizeScale=" + this.sizeScale + ", soundUrl=" + this.soundUrl + ", x=" + this.f79386x + ", y=" + this.f79387y + ", timeOffset=" + this.timeOffset + '}';
    }

    public d() {
        this.type = 0;
    }

    public boolean isExtraValid() {
        py.k r100 = extraDynamicImage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isValid() == false) goto L7;
        return true;
    }

    public boolean isValid() {
        py.k r100 = dynamicImage();
        List r101 = resources();
        if (r100 != null) goto L5;
    L6:
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.size() == 0) goto L10;
    L9:
        return true;
    L5:
        if (r100.isValid() == true) goto L9;
        goto L6
    }
}
