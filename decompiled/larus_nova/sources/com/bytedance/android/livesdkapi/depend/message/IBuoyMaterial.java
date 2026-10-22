package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IBuoyMaterial;", "Lvh7/c;", "Lpy/k;", "getBuoyBall", "()Lpy/k;", "getBuoyBall$annotations", "()V", "buoyBall", "getBuoyTailing", "getBuoyTailing$annotations", "buoyTailing", "getUnivScatterDecoA", "getUnivScatterDecoA$annotations", "univScatterDecoA", "getUnivScatterDecoB", "getUnivScatterDecoB$annotations", "univScatterDecoB", "getUnivScatterDecoC", "getUnivScatterDecoC$annotations", "univScatterDecoC", "getAdvanScatterDecoA", "getAdvanScatterDecoA$annotations", "advanScatterDecoA", "getAdvanScatterDecoB", "getAdvanScatterDecoB$annotations", "advanScatterDecoB", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBuoyMaterial extends c<IBuoyMaterial> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "advan_scatter_deco_a")
        public static /* synthetic */ void getAdvanScatterDecoA$annotations() {
        }

        @FieldName(name = "advan_scatter_deco_b")
        public static /* synthetic */ void getAdvanScatterDecoB$annotations() {
        }

        @FieldName(name = "buoy_ball")
        public static /* synthetic */ void getBuoyBall$annotations() {
        }

        @FieldName(name = "buoy_tailing")
        public static /* synthetic */ void getBuoyTailing$annotations() {
        }

        @FieldName(name = "univ_scatter_deco_a")
        public static /* synthetic */ void getUnivScatterDecoA$annotations() {
        }

        @FieldName(name = "univ_scatter_deco_b")
        public static /* synthetic */ void getUnivScatterDecoB$annotations() {
        }

        @FieldName(name = "univ_scatter_deco_c")
        public static /* synthetic */ void getUnivScatterDecoC$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "advan_scatter_deco_a")
    k getAdvanScatterDecoA();

    @FieldName(name = "advan_scatter_deco_b")
    k getAdvanScatterDecoB();

    @FieldName(name = "buoy_ball")
    k getBuoyBall();

    @FieldName(name = "buoy_tailing")
    k getBuoyTailing();

    @FieldName(name = "univ_scatter_deco_a")
    k getUnivScatterDecoA();

    @FieldName(name = "univ_scatter_deco_b")
    k getUnivScatterDecoB();

    @FieldName(name = "univ_scatter_deco_c")
    k getUnivScatterDecoC();
}
