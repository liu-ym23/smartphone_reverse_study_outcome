package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.View;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageItemAdapter f139958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f139959b;

    public a(ImageItemAdapter r100, int r101) {
        this.f139958a = r100;
        this.f139959b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function2<? super Integer, ? super String, Unit> r101 = this.f139958a.f139936b;
        if (r101 == null) goto L9;
        Integer r102 = Integer.valueOf(this.f139959b);
        String r103 = (String) CollectionsKt.getOrNull(this.f139958a.f139935a, this.f139959b);
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        Unit r104 = r101.invoke(r102, r103);
        return;
    }
}
