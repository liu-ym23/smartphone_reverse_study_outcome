package com.bytedance.android.ec.sdk.plugin.fallback;

import android.content.Context;
import android.os.Bundle;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECEmptyOrderShowOffService implements dj.a {
    public ECEmptyOrderShowOffService() {
    }

    @Override // dj.a
    public final void b(Context r100, Bundle r101, int r102, Function2<? super Integer, Object, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "editConfigParams");
        Intrinsics.checkNotNullParameter(r103, "callBack");
    }

    @Override // dj.a
    public final void c(Context r100, Bundle r101, Function1<Object, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "editConfigParams");
        Intrinsics.checkNotNullParameter(r102, "callBack");
    }

    @Override // dj.a
    public final void d(Context r100, Bundle r101, Object r102, Function2<? super Boolean, ? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "publishExtra");
        Intrinsics.checkNotNullParameter(r103, "callBack");
    }

    @Override // dj.a
    public final Function0<Unit> a(Context r100, List<String> r101, String r102, Function2<? super String, ? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "images");
        Intrinsics.checkNotNullParameter(r102, "video");
        Intrinsics.checkNotNullParameter(r103, "synthesizeFinishCallback");
        r103.invoke(null, null);
        return ECEmptyOrderShowOffService$getSynthesizedOrderShowOffVideo$1.INSTANCE;
    }
}
