package com.bytedance.android.ec.model.response;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/response/f0;", "", "", "videoType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "", "trackMeta", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "floatTrackMeta", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class f0 {

    @SerializedName("float_track_meta")
    private final Map<String, Object> floatTrackMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final Map<String, Object> trackMeta;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    private final Integer videoType;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L12;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.videoType, r101.videoType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.floatTrackMeta, r101.floatTrackMeta) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.videoType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.trackMeta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.floatTrackMeta;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HeadVideoExtraInfo(videoType=" + this.videoType + ", trackMeta=" + this.trackMeta + ", floatTrackMeta=" + this.floatTrackMeta + ")";
    }

    public f0() {
        this.videoType = null;
        this.trackMeta = null;
        this.floatTrackMeta = null;
    }

    public final Map<String, Object> a() {
        return this.floatTrackMeta;
    }

    public final Map<String, Object> b() {
        return this.trackMeta;
    }

    public final Integer c() {
        return this.videoType;
    }
}
