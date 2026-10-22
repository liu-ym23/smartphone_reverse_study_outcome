package com.bytedance.android.live.openplatform.impl.base.utils;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f84066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f84067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f84068c;

    public l(Ref.LongRef r100, long r101, Function0 r102) {
        this.f84066a = r100;
        this.f84067b = r101;
        this.f84068c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis() - this.f84066a.element;
        if (Math.abs(r101) < this.f84067b) goto L7;
        Function0 r102 = this.f84068c;
        if (r102 == null) goto L7;
        Unit r103 = (Unit) r102.invoke();
    L7:
        this.f84066a.element += r101;
    }
}
