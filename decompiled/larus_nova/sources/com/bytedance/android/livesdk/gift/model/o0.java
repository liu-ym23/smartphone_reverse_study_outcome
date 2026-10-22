package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\bg\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001_R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0014\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\fR\"\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\fR\u001e\u0010\u001d\u001a\u00060\u0018j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001e\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0007\u001a\u0004\b\"\u0010#R\u001a\u0010*\u001a\u00020&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0007\u001a\u0004\b'\u0010(R\"\u0010-\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0007\u001a\u0004\b+\u0010\fR\"\u00100\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0007\u001a\u0004\b.\u0010\fR\u001c\u00103\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b1\u0010#R\u001e\u00106\u001a\u00060\u0018j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0007\u001a\u0004\b4\u0010\u001bR\u001a\u0010;\u001a\u0002078&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b8\u00109R\u001c\u0010@\u001a\u0004\u0018\u00010<8&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0007\u001a\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010A8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\u0007\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010J\u001a\u00020&8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0007\u001a\u0004\bH\u0010(R\u001e\u0010M\u001a\u00060\u0018j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0007\u001a\u0004\bK\u0010\u001bR\u001a\u0010P\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0007\u001a\u0004\bN\u0010#R\u001e\u0010S\u001a\u00060\u0018j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\bR\u0010\u0007\u001a\u0004\bQ\u0010\u001bR\u001a\u0010V\u001a\u00020&8&X§\u0004¢\u0006\f\u0012\u0004\bU\u0010\u0007\u001a\u0004\bT\u0010(R\u001c\u0010Z\u001a\u0004\u0018\u00010&8&X§\u0004¢\u0006\f\u0012\u0004\bY\u0010\u0007\u001a\u0004\bW\u0010XR\u001c\u0010]\u001a\u0004\u0018\u00010&8&X§\u0004¢\u0006\f\u0012\u0004\b\\\u0010\u0007\u001a\u0004\b[\u0010X¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/o0;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getTrayDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getTrayDisplayText$annotations", "()V", "trayDisplayText", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTrayBaseImg", "()Lpy/k;", "getTrayBaseImg$annotations", "trayBaseImg", "getTrayBaseWebpImg", "getTrayBaseWebpImg$annotations", "trayBaseWebpImg", "getTrayHeadImg", "getTrayHeadImg$annotations", "trayHeadImg", "getTrayRightImg", "getTrayRightImg$annotations", "trayRightImg", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getTrayLevel", "()J", "getTrayLevel$annotations", "trayLevel", "getTrayDynamicImg", "getTrayDynamicImg$annotations", "trayDynamicImg", "", "getTraySchemaUrl", "()Ljava/lang/String;", "getTraySchemaUrl$annotations", "traySchemaUrl", "", "getTrayType", "()I", "getTrayType$annotations", "trayType", "getTrayBaseImgV2", "getTrayBaseImgV2$annotations", "trayBaseImgV2", "getTrayRightImgV2", "getTrayRightImgV2$annotations", "trayRightImgV2", "getToast", "getToast$annotations", "toast", "getDuration", "getDuration$annotations", "duration", "", "getUserHighLayer", "()Z", "getUserHighLayer$annotations", "userHighLayer", "Lcom/bytedance/android/livesdk/gift/model/w3;", "getTrayPreEffect", "()Lcom/bytedance/android/livesdk/gift/model/w3;", "getTrayPreEffect$annotations", "trayPreEffect", "Lcom/bytedance/android/livesdk/gift/model/u3;", "getTrayPostEffect", "()Lcom/bytedance/android/livesdk/gift/model/u3;", "setTrayPostEffect", "(Lcom/bytedance/android/livesdk/gift/model/u3;)V", "getTrayPostEffect$annotations", "trayPostEffect", "getTraySlideRate", "getTraySlideRate$annotations", "traySlideRate", "getBuffLevel", "getBuffLevel$annotations", "buffLevel", "getToolbarCardName", "getToolbarCardName$annotations", "toolbarCardName", "getOriginGiftId", "getOriginGiftId$annotations", "originGiftId", "getTrayGroupMode", "getTrayGroupMode$annotations", "trayGroupMode", "getExpensiveTrayGroupNum", "()Ljava/lang/Integer;", "getExpensiveTrayGroupNum$annotations", "expensiveTrayGroupNum", "getRegularTrayGroupNum", "getRegularTrayGroupNum$annotations", "regularTrayGroupNum", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o0 extends vh7.c<o0> {
    public static final a Companion = null;
    public static final int GROUP_MODEL_APPROXIMATE = 0;
    public static final int GROUP_MODEL_NOT_GROUP = 2;
    public static final int GROUP_MODEL_PRECISE = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126403a = null;

        public a() {
        }

        static {
            f126403a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f126403a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "buff_level")
    long getBuffLevel();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "expensive_tray_group_num")
    Integer getExpensiveTrayGroupNum();

    @FieldName(name = "origin_gift_id")
    long getOriginGiftId();

    @FieldName(name = "regular_tray_group_num")
    Integer getRegularTrayGroupNum();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "toolbar_card_name")
    String getToolbarCardName();

    @FieldName(name = "tray_base_img")
    py.k getTrayBaseImg();

    @FieldName(name = "tray_base_img_v2")
    py.k getTrayBaseImgV2();

    @FieldName(name = "tray_base_webp_img")
    py.k getTrayBaseWebpImg();

    @FieldName(name = "tray_display_text")
    a5 getTrayDisplayText();

    @FieldName(name = "tray_dynamic_img")
    py.k getTrayDynamicImg();

    @FieldName(name = "tray_group_mode")
    int getTrayGroupMode();

    @FieldName(name = "tray_head_img")
    py.k getTrayHeadImg();

    @FieldName(name = "tray_level")
    long getTrayLevel();

    @FieldName(name = "tray_post_effect")
    u3 getTrayPostEffect();

    @FieldName(name = "tray_pre_effect")
    w3 getTrayPreEffect();

    @FieldName(name = "tray_right_img")
    py.k getTrayRightImg();

    @FieldName(name = "tray_right_img_v2")
    py.k getTrayRightImgV2();

    @FieldName(name = "tray_schema_url")
    String getTraySchemaUrl();

    @FieldName(name = "tray_slide_rate")
    int getTraySlideRate();

    @FieldName(name = "tray_type")
    int getTrayType();

    @FieldName(name = "use_high_layer")
    boolean getUserHighLayer();

    @FieldName(name = "tray_post_effect#setter")
    void setTrayPostEffect(u3 r100);
}
