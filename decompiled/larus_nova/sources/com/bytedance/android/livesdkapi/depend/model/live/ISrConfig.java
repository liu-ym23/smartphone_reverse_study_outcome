package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ISrConfig;", "Lvh7/c;", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "getEnabled$annotations", "()V", "enabled", "getAntiAlias", "setAntiAlias", "getAntiAlias$annotations", "antiAlias", "", "getStrength", "()I", "setStrength", "(I)V", "getStrength$annotations", TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ISrConfig extends c<ISrConfig> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "antialiasing")
        public static /* synthetic */ void getAntiAlias$annotations() {
        }

        @FieldName(name = "enable")
        public static /* synthetic */ void getEnabled$annotations() {
        }

        @FieldName(name = TextureRenderKeys.KEY_IS_STRENGTH_FLOAT)
        public static /* synthetic */ void getStrength$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "antialiasing")
    boolean getAntiAlias();

    @FieldName(name = "enable")
    boolean getEnabled();

    @FieldName(name = TextureRenderKeys.KEY_IS_STRENGTH_FLOAT)
    int getStrength();

    @FieldName(name = "antialiasing#setter")
    void setAntiAlias(boolean r100);

    @FieldName(name = "enable#setter")
    void setEnabled(boolean r100);

    @FieldName(name = "strength#setter")
    void setStrength(int r100);
}
