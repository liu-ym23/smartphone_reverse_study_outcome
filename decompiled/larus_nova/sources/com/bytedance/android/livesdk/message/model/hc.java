package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hc;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getVoiceLiveTheme", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setVoiceLiveTheme", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "getVoiceLiveTheme$annotations", "()V", "voiceLiveTheme", "", "getReviewPass", "()Ljava/lang/Integer;", "setReviewPass", "(Ljava/lang/Integer;)V", "getReviewPass$annotations", "reviewPass", "getBgType", "setBgType", "getBgType$annotations", "bgType", "", "getToastText", "()Ljava/lang/String;", "setToastText", "(Ljava/lang/String;)V", "getToastText$annotations", "toastText", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface hc extends vh7.c<hc> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_type")
    Integer getBgType();

    @FieldName(name = "ReviewPass")
    Integer getReviewPass();

    @FieldName(name = "show_text")
    String getToastText();

    @FieldName(name = "bg_list")
    IVoiceLiveTheme getVoiceLiveTheme();

    @FieldName(name = "bg_type#setter")
    void setBgType(Integer r100);

    @FieldName(name = "ReviewPass#setter")
    void setReviewPass(Integer r100);

    @FieldName(name = "show_text#setter")
    void setToastText(String r100);

    @FieldName(name = "bg_list#setter")
    void setVoiceLiveTheme(IVoiceLiveTheme r100);
}
