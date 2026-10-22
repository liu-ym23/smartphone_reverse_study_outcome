package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR6\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR*\u0010\u001c\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/a3;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/gift/model/x;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getFontStyle", "()Ljava/util/List;", "setFontStyle", "(Ljava/util/List;)V", "getFontStyle$annotations", "()V", "fontStyle", "", "getDirection", "setDirection", "getDirection$annotations", "direction", "getPosition", "setPosition", "getPosition$annotations", "position", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "getImage$annotations", "image", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a3 extends vh7.c<a3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "direction")
    List<Double> getDirection();

    @FieldName(name = "font_style")
    List<x> getFontStyle();

    @FieldName(name = "image")
    py.k getImage();

    @FieldName(name = "position")
    List<Double> getPosition();

    @FieldName(name = "direction#setter")
    void setDirection(List<Double> r100);

    @FieldName(name = "font_style#setter")
    void setFontStyle(List<? extends x> r100);

    @FieldName(name = "image#setter")
    void setImage(py.k r100);

    @FieldName(name = "position#setter")
    void setPosition(List<Double> r100);
}
