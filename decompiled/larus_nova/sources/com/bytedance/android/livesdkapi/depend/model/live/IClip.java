package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "Lvh7/c;", "", "getX", "()F", "setX", "(F)V", "getX$annotations", "()V", "x", "getY", "setY", "getY$annotations", "y", "getW", "setW", "getW$annotations", "w", "getH", "setH", "getH$annotations", "h", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IClip extends c<IClip> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "h")
        public static /* synthetic */ void getH$annotations() {
        }

        @FieldName(name = "w")
        public static /* synthetic */ void getW$annotations() {
        }

        @FieldName(name = "x")
        public static /* synthetic */ void getX$annotations() {
        }

        @FieldName(name = "y")
        public static /* synthetic */ void getY$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "h")
    float getH();

    @FieldName(name = "w")
    float getW();

    @FieldName(name = "x")
    float getX();

    @FieldName(name = "y")
    float getY();

    @FieldName(name = "h#setter")
    void setH(float r100);

    @FieldName(name = "w#setter")
    void setW(float r100);

    @FieldName(name = "x#setter")
    void setX(float r100);

    @FieldName(name = "y#setter")
    void setY(float r100);
}
