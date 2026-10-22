package com.bytedance.android.shopping.verify;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f187182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f187183b;

    public b(long r100, Function2 r101) {
        this.f187182a = r100;
        this.f187183b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        in.b r102 = new in.b();
        r102.f490570a = "confirm";
        r102.post(null, null);
        int r103 = AuthUtils.f187163a;
        AuthUtils.b(this.f187182a, null, 6);
        Function2 r104 = this.f187183b;
        Boolean r105 = Boolean.TRUE;
        r104.invoke(r105, r105);
    }
}
