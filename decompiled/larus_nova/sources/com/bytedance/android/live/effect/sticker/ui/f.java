package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.x0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.d2;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sticker f68541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d2 f68542b;

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final void d() {
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final Sticker f() {
        return this.f68541a;
    }

    public f(Sticker r100, d2 r101) {
        this.f68541a = r100;
        this.f68542b = r101;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b
    public final void e(Sticker r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f68542b.f571816d.a(r100, r101);
    }
}
