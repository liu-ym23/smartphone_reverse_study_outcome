package com.stepos.policy.sdk.impl;

import android.content.Context;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import java.util.ArrayList;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface WithdrawalImpl {
    void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, l lVar);

    void encryptMultiCustomDeleteInfoListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, l lVar);

    void getCommonDeleteInfoListBySecure(Context context, String str, int i, l lVar);

    void getPrivateDeleteInfoListBySecure(Context context, String str, String str2, int i, l lVar);
}
