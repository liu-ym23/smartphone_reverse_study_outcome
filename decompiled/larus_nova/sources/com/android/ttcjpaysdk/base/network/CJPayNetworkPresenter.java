package com.android.ttcjpaysdk.base.network;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayNetworkPresenter {
    private static final int maxCount = 30;
    protected ArrayList<ICJPayRequest> requestList;

    public void cancelRequest() {
        ArrayList<ICJPayRequest> r100 = this.requestList;
        if (r100 == null) goto L17;
        Iterator<ICJPayRequest> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ICJPayRequest r102 = r101.next();
        if (r102 == null) goto L6;
        r102.cancel();
        goto L6
    L10:
        this.requestList.clear();
        return;
    }

    public CJPayNetworkPresenter() {
        this.requestList = new ArrayList();
    }

    public void addRequest(ICJPayRequest r100) {
        ArrayList<ICJPayRequest> r101 = this.requestList;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 30) goto L7;
        ((ICJPayRequest) ListProtector.get(this.requestList, 0)).cancel();
        ListProtector.remove(this.requestList, 0);
    L7:
        this.requestList.add(r100);
    }
}
