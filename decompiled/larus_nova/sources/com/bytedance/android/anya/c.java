package com.bytedance.android.anya;

import android.view.View;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public STATE f41580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f41583k;

    public boolean r() {
        return false;
    }

    public final void p() {
        if (this.f41581i != 0) goto L5;
        return;
    L5:
        if (this.f41582j == true) goto L16;
        mb.c r100 = mb.a.f512756a;
        String r101 = "ensureContentLoaded pos=" + this.f41581i;
        mb.c r102 = mb.a.f512756a;
        if (r102 == null) goto L10;
        r102.logD("ttlive_anya_vp", r101);
    L10:
        this.f41582j = true;
        STATE r103 = this.f41580h;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stateInstance");
    L13:
        c(new k(r103, m().f(), true));
        return;
    }

    public c(View r100) {
        this.f41583k = r100;
        this.f41581i = -1;
    }

    public final void q(boolean r100) {
        if (r() == true) goto L5;
    L10:
        STATE r101 = this.f41580h;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stateInstance");
    L13:
        c(new k(r101, m().f(), r100));
        return;
    L5:
        if (this.f41581i == 0) goto L10;
        if (this.f41582j == true) goto L10;
    }
}
