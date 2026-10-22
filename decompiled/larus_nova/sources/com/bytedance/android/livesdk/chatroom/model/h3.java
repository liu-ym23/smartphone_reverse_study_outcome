package com.bytedance.android.livesdk.chatroom.model;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006R\"\u0010 \u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/h3;", "Lvh7/c;", "", "getAlgin", "()J", "setAlgin", "(J)V", "getAlgin$annotations", "()V", "algin", "getFontSize", "setFontSize", "getFontSize$annotations", "fontSize", "", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontFamily$annotations", "fontFamily", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "getScroll", "setScroll", "getScroll$annotations", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "getScrollSpeed", "setScrollSpeed", "getScrollSpeed$annotations", "scrollSpeed", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h3 extends vh7.c<h3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "align")
    long getAlgin();

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "font_family")
    String getFontFamily();

    @FieldName(name = "font_size")
    long getFontSize();

    @FieldName(name = GXViewKey.VIEW_TYPE_CONTAINER_SCROLL)
    long getScroll();

    @FieldName(name = "scroll_speed")
    long getScrollSpeed();

    @FieldName(name = "align#setter")
    void setAlgin(long r100);

    @FieldName(name = "font_color#setter")
    void setFontColor(String r100);

    @FieldName(name = "font_family#setter")
    void setFontFamily(String r100);

    @FieldName(name = "font_size#setter")
    void setFontSize(long r100);

    @FieldName(name = "scroll#setter")
    void setScroll(long r100);

    @FieldName(name = "scroll_speed#setter")
    void setScrollSpeed(long r100);
}
