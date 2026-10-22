package com.bytedance.android.livesdk.chatroom.replay.descriptor.schedule;

import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.i;
import kotlin.jvm.internal.Intrinsics;
import uq1.b;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends i<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f108300c;

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return null;
    }

    public a() {
        Intrinsics.checkNotNullParameter("Descriptor兜底", "description");
        this.f108300c = "Descriptor兜底";
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((b) r100, "layerContext");
        return false;
    }

    @Override // j70.d
    public final f C(h70.b r100) {
        Intrinsics.checkNotNullParameter((b) r100, "layerContext");
        return new f(this.f108300c, "ReplayFallBackDescriptor");
    }
}
