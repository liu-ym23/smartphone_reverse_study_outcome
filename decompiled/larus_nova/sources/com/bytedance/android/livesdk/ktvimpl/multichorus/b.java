package com.bytedance.android.livesdk.ktvimpl.multichorus;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f145927a;

    public b(Function0 r100) {
        this.f145927a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Function0 r102 = this.f145927a;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke();
    L5:
        r100.dismiss();
    }
}
