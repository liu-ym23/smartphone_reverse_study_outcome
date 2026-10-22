package com.bytedance.android.livesdk.dislike.adapter;

import android.view.View;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.j;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f122104a;

    public a(j r100) {
        this.f122104a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f122104a;
        if (r101 == null) goto L8;
        OptionAction r102 = r101.f122167b;
        if (r102 == null) goto L9;
        r102.b(r100);
        return;
    L9:
        return;
    }
}
