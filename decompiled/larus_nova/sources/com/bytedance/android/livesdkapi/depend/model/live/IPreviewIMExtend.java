package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewIMExtend;", "Lvh7/c;", "", "getImExtendType", "()I", "getImExtendType$annotations", "()V", "imExtendType", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "", "getMainTitle", "()Ljava/lang/String;", "getMainTitle$annotations", "mainTitle", "getSubTitle", "getSubTitle$annotations", "subTitle", "getExtra", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewIMExtend extends c<IPreviewIMExtend> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "im_extend_type")
        public static /* synthetic */ void getImExtendType$annotations() {
        }

        @FieldName(name = BdpAppEventConstant.PARAMS_MAIN_TITLE)
        public static /* synthetic */ void getMainTitle$annotations() {
        }

        @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
        public static /* synthetic */ void getSubTitle$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "im_extend_type")
    int getImExtendType();

    @FieldName(name = BdpAppEventConstant.PARAMS_MAIN_TITLE)
    String getMainTitle();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    String getSubTitle();
}
