package com.bytedance.android.shopping.verify;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f187177a;

    public a(Function2 r100) {
        this.f187177a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        in.b r102 = new in.b();
        r102.f490570a = "cancel";
        r102.post(null, null);
        this.f187177a.invoke(Boolean.FALSE, Boolean.TRUE);
    }
}
