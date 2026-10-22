package com.bytedance.android.livesdk.dslservice.slice.action;

import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.b;
import com.bytedance.android.livesdk.dslservice.util.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class EmptyActionHandler implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyActionHandler f122920a = null;

    public EmptyActionHandler() {
    }

    static {
        f122920a = new EmptyActionHandler();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.b
    public final void a(r r100) {
        Intrinsics.checkNotNullParameter(r100, "actionInfo");
        o r101 = o.f123008f;
        EmptyActionHandler$handleAction$1 r102 = EmptyActionHandler$handleAction$1.INSTANCE;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "initBlock");
        r101.e(2, r102);
    }
}
