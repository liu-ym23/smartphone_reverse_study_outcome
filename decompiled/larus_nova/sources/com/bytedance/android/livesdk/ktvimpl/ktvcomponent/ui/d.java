package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements fd0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f144461a;

    public d(Function0 r100) {
        this.f144461a = r100;
    }

    @Override // fd0.b
    public final void onStop() {
        Function0 r100 = this.f144461a;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }
}
