package com.android.ttcjpaysdk.bindcard.base.utils;

import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006J<\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/CJPaySortBankListUtil;", "", "()V", "getEmptyBankList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/QuickBindCardAdapterBean;", "Lkotlin/collections/ArrayList;", "groupNameList", "", "sortBankList", "list", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySortBankListUtil {
    public static final CJPaySortBankListUtil INSTANCE = null;

    static {
        INSTANCE = new CJPaySortBankListUtil();
    }

    private CJPaySortBankListUtil() {
    }

    public final ArrayList<QuickBindCardAdapterBean> getEmptyBankList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "groupNameList");
        ArrayList<QuickBindCardAdapterBean> r101 = new ArrayList();
        QuickBindCardAdapterBean r102 = new QuickBindCardAdapterBean();
        r102.isIndex = true;
        r102.bankInitials = "#";
        r100.add("#");
        r101.add(r102);
        char r103 = 'A';
    L4:
        if (r103 >= '[') goto L6;
        QuickBindCardAdapterBean r104 = new QuickBindCardAdapterBean();
        r104.isIndex = true;
        r104.bankInitials = String.valueOf(r103);
        r100.add(String.valueOf(r103));
        r101.add(r104);
        r103 = (char) (r103 + 1);
        goto L4
    L6:
        return r101;
    }

    public final ArrayList<QuickBindCardAdapterBean> sortBankList(List<? extends QuickBindCardAdapterBean> r110, ArrayList<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "list");
        Intrinsics.checkNotNullParameter(r111, "groupNameList");
        ArrayList<QuickBindCardAdapterBean> r100 = new ArrayList();
        ArrayList r101 = new ArrayList(27);
        int r102 = 0;
    L3:
        if (r102 >= 27) goto L5;
        r101.add(new ArrayList());
        r102 = r102 + 1;
        goto L3
    L5:
        Iterator<T> r112 = r110.iterator();
    L6:
        QuickBindCardAdapterBean r103 = null;
        if (r112.hasNext() == false) goto L20;
        QuickBindCardAdapterBean r104 = (QuickBindCardAdapterBean) r112.next();
        if (r104.bankPopularFlag == false) goto L11;
        ArrayList r105 = (ArrayList) ListProtector.get(r101, 0);
        QuickBindCardAdapterBean r106 = new QuickBindCardAdapterBean(r104);
        r106.bankInitials = "#";
        r105.add(r106);
    L11:
        int r107 = r101.size();
        int r108 = (r104.bankInitials.charAt(0) - 'A') + 1;
        if (r108 < 0) goto L15;
        if (r108 >= r107) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == false) goto L18;
        r103 = r104;
    L18:
        if (r103 == null) goto L6;
        ((ArrayList) ListProtector.get(r101, (r104.bankInitials.charAt(0) - 'A') + 1)).add(r104);
    L15:
        r109 = false;
        goto L16
    L20:
        Iterator r113 = r101.iterator();
    L22:
        if (r113.hasNext() == false) goto L26;
        ArrayList r114 = (ArrayList) r113.next();
        if (r114.size() <= 1) goto L22;
        CollectionsKt.sortWith(r114, new CJPaySortBankListUtil$sortBankList$lambda$6$$inlined$sortBy$1());
        goto L22
    L26:
        Iterator r115 = r101.iterator();
    L28:
        if (r115.hasNext() == false) goto L35;
        ArrayList r116 = (ArrayList) r115.next();
        if ((!r116.isEmpty()) == true) goto L33;
        r116 = null;
    L33:
        if (r116 == null) goto L28;
        QuickBindCardAdapterBean r117 = new QuickBindCardAdapterBean();
        r117.isIndex = true;
        String r118 = ((QuickBindCardAdapterBean) ListProtector.get(r116, 0)).bankInitials;
        r117.bankInitials = r118;
        r111.add(r118);
        r100.add(r117);
        r100.addAll(r116);
        goto L28
    L35:
        return r100;
    }
}
