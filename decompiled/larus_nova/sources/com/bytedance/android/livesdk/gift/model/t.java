package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/t;", "Lvh7/c;", "", "getPlaceholderKey", "()Ljava/lang/String;", "setPlaceholderKey", "(Ljava/lang/String;)V", "getPlaceholderKey$annotations", "()V", "placeholderKey", "getContent", "setContent", "getContent$annotations", "content", "", "getFontSize", "()Ljava/lang/Long;", "setFontSize", "(Ljava/lang/Long;)V", "getFontSize$annotations", "fontSize", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t extends vh7.c<t> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "font_size")
    Long getFontSize();

    @FieldName(name = "text_key")
    String getPlaceholderKey();

    @FieldName(name = "content#setter")
    void setContent(String r100);

    @FieldName(name = "font_color#setter")
    void setFontColor(String r100);

    @FieldName(name = "font_size#setter")
    void setFontSize(Long r100);

    @FieldName(name = "text_key#setter")
    void setPlaceholderKey(String r100);
}
