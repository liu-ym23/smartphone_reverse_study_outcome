package com.bytedance.android.livesdk.room;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends ls2.b {
    public final ps2.a.C7232a A;
    public final List<Observer<KVData>> B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DataCenter f157610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Room f157611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f157612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f157613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f157614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f157615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f157616y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CompositeDisposable f157617z;

    public final void d() {
        Iterator<T> r100 = this.B.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Observer r101 = (Observer) r100.next();
        DataCenter r102 = this.f157610s;
        if (r102 == null) goto L4;
        r102.removeObserver(r101);
        goto L4
    L8:
        ((ArrayList) this.B).clear();
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        this.f157612u = r100;
        this.f157616y = r100;
        this.f157617z = new CompositeDisposable();
        this.A = new ps2.a.C7232a(0);
        this.B = new ArrayList();
    }

    public final void e(Observer<KVData> r100) {
        if (r100 == null) goto L7;
        DataCenter r101 = this.f157610s;
        if (r101 == null) goto L8;
        r101.removeObserver(r100);
        return;
    L8:
        return;
    }

    public final void f(String r100, Observer<KVData> r101) {
        if (r101 == null) goto L4;
        ((ArrayList) this.B).add(r101);
    L4:
        DataCenter r102 = this.f157610s;
        if (r102 == null) goto L8;
        r102.observeForever(r100, r101);
        return;
    }
}
