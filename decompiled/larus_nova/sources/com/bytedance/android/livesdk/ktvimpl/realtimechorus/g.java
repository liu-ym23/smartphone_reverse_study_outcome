package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RTChorusLogView f146574a;

    public g(RTChorusLogView r100) {
        this.f146574a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        RTChorusLogView.R5(this.f146574a);
    }
}
