package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f143566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f143567b;

    public n(Ref.BooleanRef r100, Function0 r101) {
        this.f143566a = r100;
        this.f143567b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f143566a.element = true;
        r100.dismiss();
        Function0 r102 = this.f143567b;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
