package com.android.ttcjpaysdk.base.mvp.mvp;

import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "", "()V", "listOfRequest", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "addRequest", "", "request", "cancelRequest", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class MvpModel {
    private final ArrayList<ICJPayRequest> listOfRequest;

    public final void cancelRequest() {
        Iterator<ICJPayRequest> r100 = this.listOfRequest.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();
        goto L4
    L6:
        this.listOfRequest.clear();
    }

    public MvpModel() {
        this.listOfRequest = new ArrayList();
    }

    public final void addRequest(ICJPayRequest r100) {
        if (r100 == null) goto L5;
        this.listOfRequest.add(r100);
        return;
    }
}
