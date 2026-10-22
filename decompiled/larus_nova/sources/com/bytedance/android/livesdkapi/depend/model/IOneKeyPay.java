package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPay;", "Lvh7/c;", "", "getSupportOneKeyPay", "()Z", "setSupportOneKeyPay", "(Z)V", "getSupportOneKeyPay$annotations", "()V", "supportOneKeyPay", "", "getOneKeyPayMsg", "()Ljava/lang/String;", "setOneKeyPayMsg", "(Ljava/lang/String;)V", "getOneKeyPayMsg$annotations", "oneKeyPayMsg", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IOneKeyPay extends c<IOneKeyPay> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "one_key_pay_msg")
        public static /* synthetic */ void getOneKeyPayMsg$annotations() {
        }

        @FieldName(name = "support_one_key_pay")
        public static /* synthetic */ void getSupportOneKeyPay$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "one_key_pay_msg")
    String getOneKeyPayMsg();

    @FieldName(name = "support_one_key_pay")
    boolean getSupportOneKeyPay();

    @FieldName(name = "one_key_pay_msg#setter")
    void setOneKeyPayMsg(String r100);

    @FieldName(name = "support_one_key_pay#setter")
    void setSupportOneKeyPay(boolean r100);
}
