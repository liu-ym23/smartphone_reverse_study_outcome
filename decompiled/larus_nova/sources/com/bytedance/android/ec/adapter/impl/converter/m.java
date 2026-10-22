package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m extends a<IRoomEventHub, td.e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f42789b = null;

    static {
        f42789b = new m();
    }

    public m() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final td.e c(IRoomEventHub r100) {
        IRoomEventHub r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        return new re.e(r101);
    }
}
