package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0018\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010 \u001a\u00060\u0019j\u0002`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR&\u0010(\u001a\u00060\u0019j\u0002`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001e¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IRichText;", "Lvh7/c;", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "getImg$annotations", "img", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getFontSize", "()J", "setFontSize", "(J)V", "getFontSize$annotations", "fontSize", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "getWeight", "setWeight", "getWeight$annotations", "weight", "RichTextType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRichText extends vh7.c<IRichText> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IRichText$RichTextType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "UnKnown", "Text", "Img", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RichTextType extends Enum<RichTextType> {
        public static final RichTextType Img = null;
        public static final RichTextType Text = null;
        public static final RichTextType UnKnown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RichTextType[] f126373a = null;
        private int value;

        static {
            RichTextType r100 = new RichTextType("UnKnown", 0, 0);
            UnKnown = r100;
            RichTextType r101 = new RichTextType("Text", 1, 1);
            Text = r101;
            RichTextType r102 = new RichTextType("Img", 2, 2);
            Img = r102;
            f126373a = new RichTextType[]{r100, r101, r102};
        }

        public static RichTextType valueOf(String r100) {
            return (RichTextType) r27.a.a(RichTextType.class, r100);
        }

        public static RichTextType[] values() {
            return (RichTextType[]) f126373a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public RichTextType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "font_size")
    long getFontSize();

    @FieldName(name = "img")
    py.k getImg();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "weight")
    long getWeight();

    @FieldName(name = "font_color#setter")
    void setFontColor(String r100);

    @FieldName(name = "font_size#setter")
    void setFontSize(long r100);

    @FieldName(name = "img#setter")
    void setImg(py.k r100);

    @FieldName(name = "text#setter")
    void setText(String r100);

    @FieldName(name = "type#setter")
    void setType(int r100);

    @FieldName(name = "weight#setter")
    void setWeight(long r100);
}
