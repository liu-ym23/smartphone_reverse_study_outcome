package com.bytedance.android.live.effect.sticker.chain;

import android.widget.CompoundButton;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f68163a;

    public c(Ref.BooleanRef r100) {
        this.f68163a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f68163a.element = r101;
    }
}
