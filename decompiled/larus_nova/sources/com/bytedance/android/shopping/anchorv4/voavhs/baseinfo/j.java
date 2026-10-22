package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.widget.TextView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f167966a;

    public j(TextView r100) {
        this.f167966a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f167966a.setVisibility(8);
    }
}
