package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.baidu.platform.comapi.map.MapBundleKey;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f93510a = null;

    static {
        f93510a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r101.printStackTrace();
    }
}
