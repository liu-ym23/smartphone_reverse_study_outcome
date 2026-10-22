package com.bytedance.ai.ext.ext_sharedviewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SharedViewModelProvider;
import androidx.lifecycle.ViewModel;
import com.bytedance.ai.viewmodel.AISharedViewModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SharedViewModelExtKt {
    public static final AISharedViewModel b(LifecycleOwner r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "appGroupId");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        return (AISharedViewModel) a(new SharedViewModelProvider(new SharedViewModelExtKt$getAISharedViewModel$1$1(r101)), r101, r100.getLifecycle(), AISharedViewModel.class);
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final <T extends ViewModel> T a(SharedViewModelProvider r100, String r101, Lifecycle r102, Class<T> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "customKey");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r103, "modelClass");
        String r104 = r103.getCanonicalName();
        if (r104 == null) goto L7;
        return (T) r100.get(r102, ("androidx.lifecycle.ViewModelProvider.DefaultKey:" + r101) + ':' + r104, r103);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
