package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f143564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f143565b;

    public m(Ref.BooleanRef r100, Function0 r101) {
        this.f143564a = r100;
        this.f143565b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        if (this.f143564a.element == true) goto L8;
        Function0 r101 = this.f143565b;
        if (r101 == null) goto L9;
        Unit r102 = (Unit) r101.invoke();
        return;
    L9:
        return;
    }
}
