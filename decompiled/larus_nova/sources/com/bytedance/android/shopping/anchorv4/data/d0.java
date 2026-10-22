package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackResponseDTO;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f166436a = null;

    static {
        f166436a = new d0();
    }

    public d0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GULFeedbackResponseDTO r101 = (GULFeedbackResponseDTO) r100;
        HashSet<String> r102 = l63.a.f507661a;
        Intrinsics.checkNotNullParameter(r101, "gulFeedbackData");
        l63.a.f507663c = r101;
    }
}
