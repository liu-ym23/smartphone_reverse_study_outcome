package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.LinkmicPlayModeStarWishConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\u0017R+\u0010$\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u0017¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ILinkmicPlayModeStarWishConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/l;", "", "", "effectScenes$delegate", "Ljava/lang/Object;", "getEffectScenes", "()Ljava/util/List;", "effectScenes", "", "globalValid$delegate", "getGlobalValid", "()Z", "globalValid", "", "allowListId$delegate", "getAllowListId", "()J", "allowListId", "", "startPlayModeBgImg$delegate", "getStartPlayModeBgImg", "()Ljava/lang/String;", "startPlayModeBgImg", "honorRanklistBgImg$delegate", "getHonorRanklistBgImg", "honorRanklistBgImg", "bannerBgImg$delegate", "getBannerBgImg", "bannerBgImg", "<set-?>", "bannerBgImgAudience$delegate", "getBannerBgImgAudience", "setBannerBgImgAudience", "(Ljava/lang/String;)V", "bannerBgImgAudience", "playModeDetailImg$delegate", "getPlayModeDetailImg", "playModeDetailImg", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicPlayModeStarWishConfigFlexImpl extends FlexModelBase<l> implements l, vh7.h {

    @SerializedName("allow_list_id")
    protected long _$$allowListId;

    @SerializedName("banner_bg_img")
    protected String _$$bannerBgImg;

    @SerializedName("banner_bg_img_audience")
    protected String _$$bannerBgImgAudience;

    @SerializedName("effect_scenes")
    protected List<Integer> _$$effectScenes;

    @SerializedName("global_valid")
    protected boolean _$$globalValid;

    @SerializedName("honor_ranklist_bg_img")
    protected String _$$honorRanklistBgImg;

    @SerializedName("play_mode_detail_img")
    protected String _$$playModeDetailImg;

    @SerializedName("start_play_mode_bg_img")
    protected String _$$startPlayModeBgImg;

    public ILinkmicPlayModeStarWishConfigFlexImpl() {
        super(l.class);
        this._$$effectScenes = $defaultValue_effectScenes$();
        this._$$globalValid = false;
        this._$$startPlayModeBgImg = "";
        this._$$honorRanklistBgImg = "";
        this._$$bannerBgImg = "";
        this._$$bannerBgImgAudience = "";
        this._$$playModeDetailImg = "";
    }

    public final List<Integer> $defaultValue_effectScenes$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final long getAllowListId() {
        return this._$$allowListId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final String getBannerBgImg() {
        return this._$$bannerBgImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final String getBannerBgImgAudience() {
        return this._$$bannerBgImgAudience;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final List<Integer> getEffectScenes() {
        return this._$$effectScenes;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final boolean getGlobalValid() {
        return this._$$globalValid;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final String getHonorRanklistBgImg() {
        return this._$$honorRanklistBgImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final String getPlayModeDetailImg() {
        return this._$$playModeDetailImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final String getStartPlayModeBgImg() {
        return this._$$startPlayModeBgImg;
    }

    public ILinkmicPlayModeStarWishConfigFlexImpl(am3.g r100) {
        super(l.class);
        this._$$effectScenes = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$effectScenes.add(Integer.valueOf(r100.i()));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$globalValid = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this._$$allowListId = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        switch(r103) {
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L12;
        };
    L13:
        this._$$bannerBgImgAudience = am3.h.c(r100);
        goto L3
    L14:
        this._$$playModeDetailImg = am3.h.c(r100);
        goto L3
    L15:
        this._$$bannerBgImg = am3.h.c(r100);
        goto L3
    L16:
        this._$$honorRanklistBgImg = am3.h.c(r100);
        goto L3
    L17:
        this._$$startPlayModeBgImg = am3.h.c(r100);
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$effectScenes.isEmpty() == false) goto L25;
        this._$$effectScenes = $defaultValue_effectScenes$();
    L25:
        if ((r102 & 1) != 0) goto L28;
        this._$$globalValid = false;
    L28:
        if (this._$$startPlayModeBgImg != null) goto L31;
        this._$$startPlayModeBgImg = "";
    L31:
        if (this._$$honorRanklistBgImg != null) goto L34;
        this._$$honorRanklistBgImg = "";
    L34:
        if (this._$$bannerBgImg != null) goto L37;
        this._$$bannerBgImg = "";
    L37:
        if (this._$$bannerBgImgAudience != null) goto L40;
        this._$$bannerBgImgAudience = "";
    L40:
        if (this._$$playModeDetailImg != null) goto L66;
        this._$$playModeDetailImg = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.dress.config.l
    public final void setBannerBgImgAudience(String r100) {
        this._$$bannerBgImgAudience = r100;
    }
}
