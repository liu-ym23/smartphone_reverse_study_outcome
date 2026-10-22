package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.widget.ImageView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvControlAreaWidget f145877a;

    public z(KtvMvControlAreaWidget r100) {
        this.f145877a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L11;
        ImageView r101 = this.f145877a.f145619k;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L7:
        r101.setAlpha(1.0f);
        ImageView r102 = this.f145877a.f145619k;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L10:
        r102.setClickable(true);
        return;
    L11:
        ImageView r103 = this.f145877a.f145619k;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L14:
        r103.setAlpha(0.5f);
        ImageView r104 = this.f145877a.f145619k;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L17:
        r104.setClickable(false);
    }
}
