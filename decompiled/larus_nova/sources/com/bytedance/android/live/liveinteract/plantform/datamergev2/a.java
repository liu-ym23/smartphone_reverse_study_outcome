package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements eh0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f76615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<eh0.c> f76616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<List<ch0.e>> f76617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f76618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f76619e;

    @Override // eh0.b
    public void i(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "seiTalkingData");
    }

    @Override // eh0.b
    public void n(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcTalkingData");
    }

    @Override // eh0.b
    public void p(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcLastTalkingTimeData");
    }

    @Override // eh0.b
    public final List<ch0.e> d() {
        List<ch0.e> r100 = this.f76617c.getValue();
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void detach() {
        Iterator<eh0.c> r100 = this.f76616b.iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        r100.next().detach();
        goto L4
    L7:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L9;
        q();
    L9:
        this.f76615a = false;
    }

    public void q() {
        this.f76617c.onNext(CollectionsKt.emptyList());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Boolean>> j() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Long>> l() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // eh0.b
    public BehaviorSubject<Map<String, Boolean>> o() {
        return BehaviorSubject.createDefault(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final d P1() {
        return this.f76619e;
    }

    @Override // eh0.b
    public final BehaviorSubject<List<ch0.e>> h() {
        return this.f76617c;
    }

    @Override // eh0.b
    public final void m(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "updateResult");
        gh0.a.b(null, "notifyUpdateResult", 5);
        if (r100.f76438a == false) goto L6;
        this.f76617c.onNext(r100.f76439b);
        return;
    }

    public a(LifecycleOwner r100, d r101) {
        this.f76618d = r100;
        this.f76619e = r101;
        this.f76616b = new CopyOnWriteArrayList();
        this.f76617c = BehaviorSubject.createDefault(CollectionsKt.emptyList());
    }
}
