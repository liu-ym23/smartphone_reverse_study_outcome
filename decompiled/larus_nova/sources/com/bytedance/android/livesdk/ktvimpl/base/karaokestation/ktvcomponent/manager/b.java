package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentFirstLevelTabManager f142614a;

    public b(KtvComponentFirstLevelTabManager r100) {
        this.f142614a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        KtvComponentFirstLevelTabManager r102 = this.f142614a;
        int r103 = KtvComponentFirstLevelTabManager.f142608q;
        r102.B();
    }
}
