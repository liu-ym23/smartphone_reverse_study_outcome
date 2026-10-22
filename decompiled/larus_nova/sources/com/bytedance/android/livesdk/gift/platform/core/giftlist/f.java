package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<h1> f130597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GiftListFilterService f130598b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f130597a.clear();
    }

    public f(GiftListFilterService r100) {
        Intrinsics.checkNotNullParameter(r100, "listFilterService");
        this.f130598b = r100;
        this.f130597a = new ArrayList();
    }
}
