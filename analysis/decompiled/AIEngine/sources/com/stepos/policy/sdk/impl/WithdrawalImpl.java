package com.stepos.policy.sdk.impl;

import android.content.Context;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import java.util.ArrayList;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface WithdrawalImpl {
    void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, l<? super DeleteInfoBean, n> lVar);

    void encryptMultiCustomDeleteInfoListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, l<? super DeleteInfoBean, n> lVar);

    void getCommonDeleteInfoListBySecure(Context context, String str, int i10, l<? super String, n> lVar);

    void getPrivateDeleteInfoListBySecure(Context context, String str, String str2, int i10, l<? super ArrayList<DeleteInfoBean>, n> lVar);
}
