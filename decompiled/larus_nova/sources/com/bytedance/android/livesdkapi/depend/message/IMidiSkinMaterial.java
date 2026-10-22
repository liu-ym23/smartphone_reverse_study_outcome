package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IMidiSkinMaterial;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/message/IBuoyMaterial;", "getBuoy", "()Lcom/bytedance/android/livesdkapi/depend/message/IBuoyMaterial;", "getBuoy$annotations", "()V", "buoy", "Lcom/bytedance/android/livesdkapi/depend/message/IBackgroundMaterial;", "getBg", "()Lcom/bytedance/android/livesdkapi/depend/message/IBackgroundMaterial;", "getBg$annotations", "bg", "Lcom/bytedance/android/livesdkapi/depend/message/IFeedbackMaterial;", "getFeedback", "()Lcom/bytedance/android/livesdkapi/depend/message/IFeedbackMaterial;", "getFeedback$annotations", "feedback", "", "getLyricColorValue", "()Ljava/lang/String;", "getLyricColorValue$annotations", "lyricColorValue", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMidiSkinMaterial extends c<IMidiSkinMaterial> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bg")
        public static /* synthetic */ void getBg$annotations() {
        }

        @FieldName(name = "buoy")
        public static /* synthetic */ void getBuoy$annotations() {
        }

        @FieldName(name = "feedback")
        public static /* synthetic */ void getFeedback$annotations() {
        }

        @FieldName(name = "lyric_color_value")
        public static /* synthetic */ void getLyricColorValue$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bg")
    IBackgroundMaterial getBg();

    @FieldName(name = "buoy")
    IBuoyMaterial getBuoy();

    @FieldName(name = "feedback")
    IFeedbackMaterial getFeedback();

    @FieldName(name = "lyric_color_value")
    String getLyricColorValue();
}
