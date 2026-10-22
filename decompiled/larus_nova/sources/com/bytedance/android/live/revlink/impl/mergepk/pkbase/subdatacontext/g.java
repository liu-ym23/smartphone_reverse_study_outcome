package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f92953a;

    public g(MediatorLiveData r100) {
        this.f92953a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L8;
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(((cf2.a) r103.next()).f23503d);
    L8:
        this.f92953a.setValue(r102);
    }
}
