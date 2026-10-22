package com.bytedance.android.anniex.lite.utils;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/lite/utils/AnnieXDialogObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXDialogObserver implements DefaultLifecycleObserver {
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
        throw null;
    }
}
