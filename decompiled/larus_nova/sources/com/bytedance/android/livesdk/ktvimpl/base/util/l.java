package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f143562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f143563b;

    public l(Ref.BooleanRef r100, Function0 r101) {
        this.f143562a = r100;
        this.f143563b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f143562a.element = true;
        r100.dismiss();
        this.f143563b.invoke();
    }
}
