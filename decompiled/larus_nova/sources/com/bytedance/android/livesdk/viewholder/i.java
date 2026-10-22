package com.bytedance.android.livesdk.viewholder;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OGCFixedViewHolder f159296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.quickcomment.a f159297b;

    public i(OGCFixedViewHolder r100, com.bytedance.android.livesdk.interactivity.api.quickcomment.a r101) {
        this.f159296a = r100;
        this.f159297b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super com.bytedance.android.livesdk.interactivity.api.quickcomment.a, Unit> r101 = this.f159296a.f159277b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(this.f159297b);
        return;
    }
}
