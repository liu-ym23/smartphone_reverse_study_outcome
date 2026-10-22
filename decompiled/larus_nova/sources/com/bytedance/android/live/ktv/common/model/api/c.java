package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/c;", "", "Lcom/bytedance/android/live/ktv/common/model/api/x0;", "tagList", "Lcom/bytedance/android/live/ktv/common/model/api/x0;", "b", "()Lcom/bytedance/android/live/ktv/common/model/api/x0;", "Lcom/bytedance/android/live/ktv/common/model/api/h0;", "midiSkinList", "Lcom/bytedance/android/live/ktv/common/model/api/h0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/ktv/common/model/api/h0;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements vh7.h {

    @SerializedName("midi_skin_list")
    protected h0 midiSkinList;

    @SerializedName("tag_list")
    protected x0 tagList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.midiSkinList, r101.midiSkinList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        x0 r100 = this.tagList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h0 r104 = this.midiSkinList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetDressPageListResponse(tagList=" + this.tagList + ", midiSkinList=" + this.midiSkinList + ")";
    }

    public c() {
        this.tagList = null;
        this.midiSkinList = null;
    }

    public final h0 a() {
        return this.midiSkinList;
    }

    public final x0 b() {
        return this.tagList;
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.tagList = new x0(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.midiSkinList = new h0(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.tagList != null) goto L16;
        this.tagList = null;
    L16:
        if (this.midiSkinList != null) goto L28;
        this.midiSkinList = null;
        return;
    }
}
