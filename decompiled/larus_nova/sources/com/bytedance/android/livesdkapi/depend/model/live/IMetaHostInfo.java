package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IMetaHostInfo;", "Lvh7/c;", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "()V", "icon", "", "getTip", "()Ljava/lang/String;", "getTip$annotations", AppConstants.BUNDLE_TIP, "getColor", "getColor$annotations", "color", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IMetaHostInfo extends c<IMetaHostInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "color")
        public static /* synthetic */ void getColor$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = AppConstants.BUNDLE_TIP)
        public static /* synthetic */ void getTip$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "color")
    String getColor();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = AppConstants.BUNDLE_TIP)
    String getTip();
}
