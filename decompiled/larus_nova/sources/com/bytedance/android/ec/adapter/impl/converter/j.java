package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends a<IExternalViewGroup, wd.f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f42786b = null;

    static {
        f42786b = new j();
    }

    public j() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final wd.f c(IExternalViewGroup r100) {
        IExternalViewGroup r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        return new se.a(r101);
    }
}
