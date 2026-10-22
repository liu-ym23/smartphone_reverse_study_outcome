package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.od;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueGetRevenueInteractDataParamModelSerializableObjectImpl;", "Lw20/od;", "", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueGetRevenueInteractDataParamModelSerializableObjectImpl implements od {

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueGetRevenueInteractDataParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueGetRevenueInteractDataParamModelSerializableObjectImpl.class);
        }
    }

    public RevenueGetRevenueInteractDataParamModelSerializableObjectImpl() {
        this.tags = d.a();
    }

    @Override // w20.od
    public final List<String> getTags() {
        return this.tags;
    }
}
