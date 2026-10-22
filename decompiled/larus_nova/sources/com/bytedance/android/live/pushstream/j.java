package com.bytedance.android.live.pushstream;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f89396a = null;

    static {
        f89396a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Integer) r100, "it");
        return ((IHostPlugin) jc1.k.n(IHostPlugin.class)).getNativeLibraryDir(NewPluginType.LiveResource.getPackageName());
    }
}
