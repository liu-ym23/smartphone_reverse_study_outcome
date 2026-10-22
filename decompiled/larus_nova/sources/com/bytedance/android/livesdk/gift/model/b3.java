package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/b3;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/a3;", "getStyleBeforeSelected", "()Lcom/bytedance/android/livesdk/gift/model/a3;", "setStyleBeforeSelected", "(Lcom/bytedance/android/livesdk/gift/model/a3;)V", "getStyleBeforeSelected$annotations", "()V", "styleBeforeSelected", "getStyleAfterSelected", "setStyleAfterSelected", "getStyleAfterSelected$annotations", "styleAfterSelected", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b3 extends vh7.c<b3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "style_after_selected")
    a3 getStyleAfterSelected();

    @FieldName(name = "style_before_selected")
    a3 getStyleBeforeSelected();

    @FieldName(name = "style_after_selected#setter")
    void setStyleAfterSelected(a3 r100);

    @FieldName(name = "style_before_selected#setter")
    void setStyleBeforeSelected(a3 r100);
}
