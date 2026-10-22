package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BehaviorSubject f128501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.scope.j f128502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataCenter f128503c;

    public t(BehaviorSubject r100, i12.e r101, DataCenter r102) {
        this.f128501a = r100;
        this.f128502b = r101;
        this.f128503c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r102, "data_link_state") == false) goto L10;
        this.f128501a.onNext(Integer.valueOf(v.a(this.f128502b, this.f128503c)));
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
