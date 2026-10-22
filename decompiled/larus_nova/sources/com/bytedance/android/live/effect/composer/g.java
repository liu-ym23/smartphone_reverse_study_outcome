package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.d0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f67947a = null;

    static {
        f67947a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        List<d0> r102 = com.bytedance.android.livesdk.log.a.f153274a;
        Intrinsics.checkNotNullParameter("loadStickerByEffectId", "message");
        Iterator r103 = ((ArrayList) com.bytedance.android.livesdk.log.a.f153274a).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if (((d0) r103.next()).a("ttlive_anchor_effect_LiveComposerManagerB") == true) goto L4;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L16;
        ALogger.w("ttlive_anchor_effect_LiveComposerManagerB", "loadStickerByEffectId", r101);
        return;
    L16:
        return;
    L8:
        r104 = false;
        goto L9
    }
}
