package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0018\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010 \u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR*\u0010(\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lvh7/c;", "", "getRichTextType", "()I", "setRichTextType", "(I)V", "getRichTextType$annotations", "()V", "richTextType", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "getImg$annotations", "img", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getFontSize", "()Ljava/lang/Long;", "setFontSize", "(Ljava/lang/Long;)V", "getFontSize$annotations", "fontSize", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "getWeight", "setWeight", "getWeight$annotations", "weight", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n extends vh7.c<n> {

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
    Long getFontSize();

    @FieldName(name = "img")
    py.k getImg();

    @FieldName(name = "type")
    int getRichTextType();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "weight")
    Long getWeight();

    @FieldName(name = "font_color#setter")
    void setFontColor(String r100);

    @FieldName(name = "font_size#setter")
    void setFontSize(Long r100);

    @FieldName(name = "img#setter")
    void setImg(py.k r100);

    @FieldName(name = "type#setter")
    void setRichTextType(int r100);

    @FieldName(name = "text#setter")
    void setText(String r100);

    @FieldName(name = "weight#setter")
    void setWeight(Long r100);
}
