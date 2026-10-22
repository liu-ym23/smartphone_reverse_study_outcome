package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IRenderDataInfoBase;", "", "payBizParams", "", "getPayBizParams$annotations", "()V", "getPayBizParams", "()Ljava/lang/String;", "setPayBizParams", "(Ljava/lang/String;)V", "renderData", "getRenderData$annotations", "getRenderData", "setRenderData", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRenderDataInfoBase {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "pay_biz_params")
        public static /* synthetic */ void getPayBizParams$annotations() {
        }

        @FieldName(name = "render_data")
        public static /* synthetic */ void getRenderData$annotations() {
        }
    }

    String getPayBizParams();

    String getRenderData();

    void setPayBizParams(String r100);

    void setRenderData(String r100);
}
