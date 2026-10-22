package com.stepos.policy.sdk.impl;

import V3.v;
import android.content.Context;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import i4.InterfaceC0772l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface WithdrawalImpl {
    void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, InterfaceC0772l<? super DeleteInfoBean, v> interfaceC0772l);

    void encryptMultiCustomDeleteInfoListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, InterfaceC0772l<? super DeleteInfoBean, v> interfaceC0772l);

    void getCommonDeleteInfoListBySecure(Context context, String str, int i5, InterfaceC0772l<? super String, v> interfaceC0772l);

    void getPrivateDeleteInfoListBySecure(Context context, String str, String str2, int i5, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l);
}
