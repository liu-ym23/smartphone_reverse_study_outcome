package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;", "Lvh7/c;", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getAmount$annotations", "()V", "amount", "getCurrency", "setCurrency", "getCurrency$annotations", "currency", "", "getUnitPosition", "()J", "setUnitPosition", "(J)V", "getUnitPosition$annotations", "unitPosition", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPayTypeList", "()Ljava/util/List;", "setPayTypeList", "(Ljava/util/List;)V", "getPayTypeList$annotations", "payTypeList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPaidLivePriceInfoV2 extends c<IPaidLivePriceInfoV2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "amount")
        public static /* synthetic */ void getAmount$annotations() {
        }

        @FieldName(name = "currency")
        public static /* synthetic */ void getCurrency$annotations() {
        }

        @FieldName(name = "pay_type")
        public static /* synthetic */ void getPayTypeList$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
        public static /* synthetic */ void getUnitPosition$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "amount")
    String getAmount();

    @FieldName(name = "currency")
    String getCurrency();

    @FieldName(name = "pay_type")
    List<Integer> getPayTypeList();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    long getUnitPosition();

    @FieldName(name = "amount#setter")
    void setAmount(String r100);

    @FieldName(name = "currency#setter")
    void setCurrency(String r100);

    @FieldName(name = "pay_type#setter")
    void setPayTypeList(List<Integer> r100);

    @FieldName(name = "pos#setter")
    void setUnitPosition(long r100);
}
