package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RTChorusLogView f146572a;

    public f(RTChorusLogView r100) {
        this.f146572a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        RTChorusLogView.R5(this.f146572a);
    }
}
