package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import androidx.lifecycle.ViewModelProvider;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final <T extends QViewModel> T a(QContext r100, Class<T> r101, ViewModelProvider.Factory r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$vm");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "factory");
        return (T) new ViewModelProvider(r100.a(), r102).get(r101);
    }
}
