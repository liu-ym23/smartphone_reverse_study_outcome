package com.bytedance.android.livesdk.room.iconmodel;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements IExternalIconTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f157672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Long, Animator> f157673b;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public final View getView() {
        return this.f157672a;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public final Animator getEntryAnimation(long r100) {
        return this.f157673b.invoke(Long.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100, Function1<? super Long, ? extends Animator> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "animatorFun");
        this.f157672a = r100;
        this.f157673b = r101;
    }
}
