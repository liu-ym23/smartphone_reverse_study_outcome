package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import android.util.LongSparseArray;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<m> f123245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f123246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f123247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f123248d;

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f123248d = r100;
        this.f123245a = new LongSparseArray();
    }

    public final void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        int r101 = b.f123213a;
        b.d("Room(" + this.f123248d + ") NfaTimerManager Add Task: [" + r100.f123249a + ',' + r100.f123250b + "]}");
        this.f123245a.put(r100.f123250b, r100);
        Disposable r102 = this.f123247c;
        if (r102 != null) goto L5;
    L6:
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f123247c = AndroidSchedulers.mainThread().scheduleDirect(new n(r100.f123249a, r100.f123250b, r100.f123251c, this), r100.f123250b - System.nanoTime(), TimeUnit.NANOSECONDS);
        this.f123246b = r100.f123250b;
        return;
    L5:
        if (this.f123246b > r100.f123250b) goto L6;
    }

    public final void c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        int r101 = b.f123213a;
        b.d("Room(" + this.f123248d + ") NfaTimerManager Remove Task: [" + r100.f123249a + ',' + r100.f123250b + "}] waitingRunnableTime:" + this.f123246b);
        long r102 = r100.f123250b;
        if (r102 != this.f123246b) goto L8;
        Disposable r103 = this.f123247c;
        if (r103 == null) goto L7;
        r103.dispose();
    L7:
        a(r100.f123249a, this.f123246b);
        return;
    L8:
        this.f123245a.remove(r102);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.k
    public final void a(String r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "runnableName");
        int r100 = b.f123213a;
        StringBuilder r101 = new StringBuilder("Room(");
        r101.append(this.f123248d);
        r101.append(") NfaTimerManager onRunnableFinished: [");
        r101.append(r110);
        r101.append(',');
        r101.append(r111);
        r101.append(',');
        if (this.f123245a.indexOfKey(r111) < 0) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append("}]");
        b.d(r101.toString());
        if (this.f123245a.indexOfKey(r111) >= 0) goto L9;
        return;
    L9:
        this.f123245a.remove(r111);
        this.f123247c = null;
        this.f123246b = 0;
        if (this.f123245a.size() <= 0) goto L19;
        long r112 = this.f123245a.keyAt(0);
        long r113 = r112 - System.nanoTime();
        m r103 = this.f123245a.get(r112);
        if (r103 == null) goto L20;
        b.d("Room(" + this.f123248d + ") NfaTimerManager Next   Runnable: [" + r103.f123249a + ',' + r103.f123250b + ',' + r113 + "}]");
        n r104 = new n(r103.f123249a, r112, r103.f123251c, this);
        if (r113 <= 0) goto L16;
        Disposable r105 = AndroidSchedulers.mainThread().scheduleDirect(r104, r113, TimeUnit.NANOSECONDS);
    L17:
        this.f123247c = r105;
        this.f123246b = r112;
        return;
    L16:
        r105 = AndroidSchedulers.mainThread().scheduleDirect(r104);
        goto L17
    L20:
        return;
    L19:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
