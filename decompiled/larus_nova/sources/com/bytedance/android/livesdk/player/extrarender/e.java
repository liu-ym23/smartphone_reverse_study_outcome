package com.bytedance.android.livesdk.player.extrarender;

import android.content.Context;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;

/* JADX INFO: loaded from: classes11.dex */
public interface e {
    void c(boolean r100);

    ExtraRenderDescView curExtraDescView();

    void e();

    void f(RenderDescInfo r100);

    void h(boolean r100);

    boolean j();

    ExtraRenderShadowInteractView k(Context r100, ILivePlayerExtraRenderController.ClickListener r101);

    void m();
}
