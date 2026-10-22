package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class in extends o0 implements vh7.c.a<gc>, gc {

    @SerializedName("bg_type")
    public int bgType;
    private transient FlexModelDelegate<gc> modelDefaultDelegate;

    @SerializedName("ReviewPass")
    public int reviewPassed;

    @SerializedName("show_text")
    public String toastText;

    @SerializedName("bg_list")
    public VoiceLiveTheme voiceLiveTheme;

    @Override // com.bytedance.android.livesdk.message.model.gc
    public /* bridge */ /* synthetic */ boolean isReviewPassed() {
        return IVoiceLiveThemeMessage$CC.$default$isReviewPassed(this);
    }

    public in() {
        this.modelDefaultDelegate = new FlexModelDelegate(gc.class, this);
        this.type = MessageType.VOICE_LIVE_THEME_MESSAGE;
    }

    @Override // com.bytedance.android.livesdk.message.model.gc
    public int getBgType() {
        return this.bgType;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<gc> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.gc
    public int getReviewPassed() {
        return this.reviewPassed;
    }

    @Override // com.bytedance.android.livesdk.message.model.gc
    public String getToastText() {
        return this.toastText;
    }

    @Override // com.bytedance.android.livesdk.message.model.gc
    public IVoiceLiveTheme getVoiceLiveTheme() {
        return this.voiceLiveTheme;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<gc>> R castTo(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<gc>> R castToOrNull(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.message.model.gc
    public void setBgType(int r100) {
        this.bgType = r100;
    }
}
