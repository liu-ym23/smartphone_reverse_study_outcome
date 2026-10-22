package com.bytedance.android.livesdk.widget;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f161691a;

    public e(Function0 r100) {
        this.f161691a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        this.f161691a.invoke();
    }
}
