package com.bytedance.als.ui.state;

import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class StateContainer<STATE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final STATE f38103a;

    public StateContainer(STATE r100) {
        this.f38103a = r100;
        new Handler(Looper.getMainLooper());
        new ArrayMap();
        Intrinsics.checkNotNullParameter(new StateContainer$stateLiveState$1(this), "getValueCallable");
        new ArrayList();
        new HashMap();
        new HashMap();
        new HashMap();
    }
}
