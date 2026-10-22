package com.android.ttcjpaysdk.integrated.sign.counter.activity;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.scene.IntegratedSignSceneHandler;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.scene.SignPreRouteSceneHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterSceneFactory;", "", "()V", "create", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterSceneHandler;", "args", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignCounterSceneFactory {
    public static final SignCounterSceneFactory INSTANCE = null;

    static {
        INSTANCE = new SignCounterSceneFactory();
    }

    private SignCounterSceneFactory() {
    }

    public final ISignCounterSceneHandler create(SignCounterLaunchArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        if (Intrinsics.areEqual(r100.getSceneType(), SignCounterLaunchArgs.SCENE_SIGN_PRE_ROUTE) == false) goto L6;
        return new SignPreRouteSceneHandler();
    L6:
        return new IntegratedSignSceneHandler();
    }
}
