package com.bytedance.android.ec.store.sortbar;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f48624a;

    public e(r r100) {
        this.f48624a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        r r101 = this.f48624a;
        Function1<? super r, Unit> r102 = r101.f48485f;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101);
        return;
    }
}
