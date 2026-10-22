package com.bytedance.android.livesdkapi.eventbus;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.StickerInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/StickerInfo;", "", "()V", "effectID", "", "extra", "", "isRendering", "", NameKeys.LoadStrategy_Use, "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerInfo implements h {

    @SerializedName(MobConstants.EFFECT_ID)
    public long effectID;

    @SerializedName("extra")
    public String extra;

    @SerializedName("is_rendering")
    public boolean isRendering;

    @SerializedName(NameKeys.LoadStrategy_Use)
    public boolean use;

    public StickerInfo() {
        this.extra = "";
    }

    public StickerInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.effectID = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.use = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.isRendering = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.extra != null) goto L37;
        this.extra = "";
        return;
    }
}
