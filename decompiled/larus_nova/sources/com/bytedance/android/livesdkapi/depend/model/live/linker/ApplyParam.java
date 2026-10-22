package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerResumeApplyContent.ApplyParam")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ApplyParam;", "", "()V", "applyType", "", "getApplyType", "()I", "setApplyType", "(I)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ApplyParam implements h {

    @SerializedName(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    protected int applyType;

    public ApplyParam() {
    }

    public final int getApplyType() {
        return this.applyType;
    }

    public ApplyParam(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.applyType = r100.i();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final void setApplyType(int r100) {
        this.applyType = r100;
    }
}
