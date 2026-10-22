package com.bytedance.android.live.core.tetris.layer.core.data;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public class DataCenterV2 extends DataCenter {
    protected Map<Observer<KVData>, Set<String>> observerKeyMap;

    public DataCenterV2() {
        this.observerKeyMap = new HashMap();
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.observerKeyMap.clear();
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter removeObserver(Observer<KVData> r100) {
        Set<String> r101 = removeObserverKeySet(r100);
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        super.removeObserver(r102.next(), r100);
    L8:
        return this;
    }

    public Set<String> removeObserverKeySet(Observer<KVData> r100) {
        return this.observerKeyMap.remove(r100);
    }

    public static DataCenter create(ViewModelProvider r100, LifecycleOwner r101) {
        int r102 = a.f65642a;
        boolean r103 = true;
        if ((a.f65642a & 1) > 0) goto L6;
        r103 = false;
    L6:
        if (r103 == false) goto L8;
        DataCenter r104 = (DataCenter) r100.get(DataCenterV2.class);
    L9:
        r104.lifecycleOwner = r101;
        return r104;
    L8:
        r104 = (DataCenter) r100.get(DataCenter.class);
        goto L9
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter observe(String r100, Observer<KVData> r101) {
        DataCenter r102 = super.observe(r100, r101);
        updateKeySet(r100, r101);
        return r102;
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter observeForever(String r100, Observer<KVData> r101) {
        DataCenter r102 = super.observeForever(r100, r101);
        updateKeySet(r100, r101);
        return r102;
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter removeObserver(String r100, Observer<KVData> r101) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L12;
        Set<String> r102 = this.observerKeyMap.get(r101);
        if (r102 == null) goto L11;
        r102.remove(r100);
        if (r102.isEmpty() == false) goto L11;
        this.observerKeyMap.remove(r101);
    L11:
        return super.removeObserver(r100, r101);
    L12:
        return this;
    }

    public void updateKeySet(String r100, Observer<KVData> r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        Set<String> r102 = this.observerKeyMap.get(r101);
        if (r102 != null) goto L8;
        r102 = new HashSet();
    L8:
        r102.add(r100);
        this.observerKeyMap.put(r101, r102);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter observe(String r100, Observer<KVData> r101, boolean r102) {
        DataCenter r103 = super.observe(r100, r101, r102);
        updateKeySet(r100, r101);
        return r103;
    }

    @Override // com.bytedance.ies.sdk.widgets.DataCenter
    public DataCenter observeForever(String r100, Observer<KVData> r101, boolean r102) {
        DataCenter r103 = super.observeForever(r100, r101, r102);
        updateKeySet(r100, r101);
        return r103;
    }
}
