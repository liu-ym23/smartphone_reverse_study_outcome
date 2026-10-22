package com.stepos.policy.sdk.impl;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\u000bH&JK\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\u000bH&J4\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u000bH&J_\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001625\u0010\n\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/impl/WithdrawalImpl;", "", "encryptCustomDeleteInfoListBySecure", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "customDeleteInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "Lkotlin/collections/ArrayList;", "callBackPolicyResult", "Lkotlin/Function1;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/ParameterName;", "name", "deleteInfoBean", "encryptMultiCustomDeleteInfoListBySecure", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "getCommonDeleteInfoListBySecure", "businessType", "", "deleteType", "", "getPrivateDeleteInfoListBySecure", "appId", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface WithdrawalImpl {
    void encryptCustomDeleteInfoListBySecure(@NotNull Context context, @NotNull ArrayList<CustomDeleteInfoBean> customDeleteInfoList, @NotNull Function1<? super DeleteInfoBean, Unit> callBackPolicyResult);

    void encryptMultiCustomDeleteInfoListBySecure(@NotNull Context context, @NotNull ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, @NotNull Function1<? super DeleteInfoBean, Unit> callBackPolicyResult);

    void getCommonDeleteInfoListBySecure(@NotNull Context context, @NotNull String businessType, int deleteType, @NotNull Function1<? super String, Unit> callBackPolicyResult);

    void getPrivateDeleteInfoListBySecure(@NotNull Context context, @NotNull String appId, @NotNull String businessType, int deleteType, @NotNull Function1<? super ArrayList<DeleteInfoBean>, Unit> callBackPolicyResult);
}
