package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IBlockComponent;", "Lvh7/c;", "", "getComponentType", "()Ljava/lang/Integer;", "setComponentType", "(Ljava/lang/Integer;)V", "getComponentType$annotations", "()V", "componentType", "getReason", "setReason", "getReason$annotations", "reason", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBlockComponent extends c<IBlockComponent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "component_type")
        public static /* synthetic */ void getComponentType$annotations() {
        }

        @FieldName(name = "reason")
        public static /* synthetic */ void getReason$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "component_type")
    Integer getComponentType();

    @FieldName(name = "reason")
    Integer getReason();

    @FieldName(name = "component_type#setter")
    void setComponentType(Integer r100);

    @FieldName(name = "reason#setter")
    void setReason(Integer r100);
}
