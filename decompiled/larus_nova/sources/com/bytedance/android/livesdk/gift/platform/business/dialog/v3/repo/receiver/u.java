package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BehaviorSubject f128504a;

    public u(BehaviorSubject r100) {
        this.f128504a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r102, "data_online_changed_list") == false) goto L15;
        BehaviorSubject r103 = this.f128504a;
        if (r101 == null) goto L12;
        List r104 = (List) r101.getData();
        if (r104 == null) goto L12;
    L13:
        r103.onNext(r104);
        return;
    L12:
        r104 = CollectionsKt.emptyList();
        goto L13
    L15:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
