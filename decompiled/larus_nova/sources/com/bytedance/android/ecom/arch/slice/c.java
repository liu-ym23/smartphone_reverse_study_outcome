package com.bytedance.android.ecom.arch.slice;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/c;", "", "", "id", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "slices", "Ljava/util/List;", "d", "()Ljava/util/List;", "setSlices", "(Ljava/util/List;)V", "", "threshold", FaceService.girlLabel, "e", "()F", "setThreshold", "(F)V", "trackName", "f", "setTrackName", "", "params", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f50052id;

    @SerializedName("track_params")
    private Map<String, ? extends Object> params;

    @SerializedName("slice_ids")
    private List<String> slices;

    @SerializedName("threshold")
    private float threshold;

    @SerializedName("track_event")
    private String trackName;

    public final boolean a() {
        String r100 = this.f50052id;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L28;
        String r102 = this.trackName;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L29;
        List<String> r104 = this.slices;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r104.isEmpty() == true) goto L24;
        r105 = false;
        goto L25
    L29:
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L28:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public c() {
        this.threshold = 0.1f;
    }

    public final String b() {
        return this.f50052id;
    }

    public final Map<String, Object> c() {
        return this.params;
    }

    public final List<String> d() {
        return this.slices;
    }

    public final float e() {
        return this.threshold;
    }

    public final String f() {
        return this.trackName;
    }
}
