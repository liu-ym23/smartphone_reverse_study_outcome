package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/b1;", "", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "midiSkinInfo", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b1 implements vh7.h {

    @SerializedName("midi_skin_info")
    protected MidiSkinDressInfo midiSkinInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b1) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.midiSkinInfo, ((b1) r100).midiSkinInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        MidiSkinDressInfo r100 = this.midiSkinInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "WearMidiSkinResponse(midiSkinInfo=" + this.midiSkinInfo + ")";
    }

    public b1() {
        this.midiSkinInfo = null;
    }

    public final MidiSkinDressInfo a() {
        return this.midiSkinInfo;
    }

    public b1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.midiSkinInfo = new MidiSkinDressInfo(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.midiSkinInfo != null) goto L19;
        this.midiSkinInfo = null;
        return;
    }
}
