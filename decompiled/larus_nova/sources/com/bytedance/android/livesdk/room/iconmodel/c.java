package com.bytedance.android.livesdk.room.iconmodel;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements IconTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f157674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Long, Animator> f157675b;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public final View getView() {
        return this.f157674a;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public final Animator getEntryAnimation(long r100) {
        return this.f157675b.invoke(Long.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View r100, Function1<? super Long, ? extends Animator> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "animatorFun");
        this.f157674a = r100;
        this.f157675b = r101;
    }
}
