package com.bytedance.android.live.profit.lottery;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class d3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f88060a;

    public d3(Ref.ObjectRef r100) {
        this.f88060a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((Function0) this.f88060a.element).invoke();
    }
}
