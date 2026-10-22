package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ShowExperienceInfo;", "", "()V", "playerProgressBarSkin", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/PlayerProgressBarSkin;", "vsCommentStyle", "", "vsCommentSwitcher", "", "xiGuaTvCastConfig", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowExperienceInfo implements h {

    @SerializedName("player_progress_bar_skin")
    public PlayerProgressBarSkin playerProgressBarSkin;

    @SerializedName("vs_comment_style")
    public int vsCommentStyle;

    @SerializedName("vs_comment_switcher")
    public boolean vsCommentSwitcher;

    @SerializedName("xigua_tv_cast_config")
    public int xiGuaTvCastConfig;

    public ShowExperienceInfo() {
    }

    public ShowExperienceInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.playerProgressBarSkin = new PlayerProgressBarSkin(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.xiGuaTvCastConfig = (int) r100.j();
        goto L3
    L10:
        if (r102 != 101) goto L12;
        this.vsCommentStyle = r100.i();
        goto L3
    L12:
        if (r102 != 102) goto L13;
        this.vsCommentSwitcher = am3.h.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
