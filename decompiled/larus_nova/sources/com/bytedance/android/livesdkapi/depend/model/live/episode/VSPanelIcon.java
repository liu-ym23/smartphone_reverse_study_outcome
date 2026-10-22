package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSPanelIcon;", "Lpy/k;", "spLandscapeIcon", "Lpy/k;", "spVerticalIcon", "lvSwitchIcon", "lockScreenIcon", "landscapeMoreIcon", "verticalMoreIcon", "getVerticalMoreIcon", "()Lpy/k;", "setVerticalMoreIcon", "(Lpy/k;)V", "landscapeCommentIcon", "verticalCommentIcon", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSPanelIcon implements IVSPanelIcon, h {

    @SerializedName("landscape_comment_icon")
    public k landscapeCommentIcon;

    @SerializedName("landscape_more_icon")
    public k landscapeMoreIcon;

    @SerializedName("lock_screen_icon")
    public k lockScreenIcon;

    @SerializedName("landscape_vertical_switch_icon")
    public k lvSwitchIcon;

    @SerializedName("sp_landscape_icon")
    public k spLandscapeIcon;

    @SerializedName("sp_vertical_icon")
    public k spVerticalIcon;

    @SerializedName("vertical_comment_icon")
    public k verticalCommentIcon;

    @SerializedName("vertical_more_icon")
    protected k verticalMoreIcon;

    public VSPanelIcon() {
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public VSPanelIcon(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        if (r102 != 1) goto L8;
        this.spLandscapeIcon = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.spVerticalIcon = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.lvSwitchIcon = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.lockScreenIcon = f.a(r100, k.class);
        goto L3
    L13:
        switch(r102) {
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            default: goto L14;
        };
    L15:
        this.verticalCommentIcon = f.a(r100, k.class);
        goto L3
    L16:
        this.landscapeCommentIcon = f.a(r100, k.class);
        goto L3
    L17:
        this.verticalMoreIcon = f.a(r100, k.class);
        goto L3
    L18:
        this.landscapeMoreIcon = f.a(r100, k.class);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSPanelIcon
    public k getVerticalMoreIcon() {
        return this.verticalMoreIcon;
    }

    public void setVerticalMoreIcon(k r100) {
        this.verticalMoreIcon = r100;
    }
}
