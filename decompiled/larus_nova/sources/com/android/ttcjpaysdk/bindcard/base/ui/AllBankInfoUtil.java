package com.android.ttcjpaysdk.bindcard.base.ui;

import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBankInfoBean;
import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import com.android.ttcjpaysdk.bindcard.base.utils.DataConvertUtil;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u0006R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/AllBankInfoUtil;", "", "()V", "allBankInfo", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBankInfoBean;", "Lkotlin/collections/ArrayList;", "clearAllBankInfo", "", "getAllBankInfo", "Lcom/android/ttcjpaysdk/bindcard/base/bean/QuickBindCardAdapterBean;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AllBankInfoUtil {
    public static final AllBankInfoUtil INSTANCE = null;
    private static ArrayList<CJPayBankInfoBean> allBankInfo;

    static {
        INSTANCE = new AllBankInfoUtil();
    }

    private AllBankInfoUtil() {
    }

    public final void clearAllBankInfo() {
        allBankInfo = null;
    }

    public final ArrayList<QuickBindCardAdapterBean> getAllBankInfo() {
        ArrayList<CJPayBankInfoBean> r100 = allBankInfo;
        if (r100 == null) goto L7;
        ArrayList<QuickBindCardAdapterBean> r101 = new ArrayList();
        DataConvertUtil.INSTANCE.cjPayBankInfoBean2QuickBindCardAdapterBeanList(r100, r101);
        return r101;
    L7:
        return new ArrayList();
    }
}
