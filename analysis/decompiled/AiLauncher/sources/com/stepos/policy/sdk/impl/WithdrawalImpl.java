package com.stepos.policy.sdk.impl;

import Y8.t;
import android.content.Context;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import java.util.ArrayList;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\fJW\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062&\u0010\n\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000ej\b\u0012\u0004\u0012\u00020\u0013`\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0015\u0010\u0016JC\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u000ej\b\u0012\u0004\u0012\u00020\u0017`\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/impl/WithdrawalImpl;", "", "Landroid/content/Context;", "context", "", "businessType", "", "deleteType", "Lkotlin/Function1;", "LY8/t;", "callBackPolicyResult", "getCommonDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/lang/String;ILp9/l;)V", "appId", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "getPrivateDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILp9/l;)V", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "customDeleteInfoList", "encryptCustomDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/util/ArrayList;Lp9/l;)V", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "encryptMultiCustomDeleteInfoListBySecure", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface WithdrawalImpl {
    void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> customDeleteInfoList, InterfaceC5074l<? super DeleteInfoBean, t> callBackPolicyResult);

    void encryptMultiCustomDeleteInfoListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, InterfaceC5074l<? super DeleteInfoBean, t> callBackPolicyResult);

    void getCommonDeleteInfoListBySecure(Context context, String businessType, int deleteType, InterfaceC5074l<? super String, t> callBackPolicyResult);

    void getPrivateDeleteInfoListBySecure(Context context, String appId, String businessType, int deleteType, InterfaceC5074l<? super ArrayList<DeleteInfoBean>, t> callBackPolicyResult);
}
