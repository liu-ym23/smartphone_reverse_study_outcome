package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IronListHeaderEntryLayout f148818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f148819b;

    @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.i.b
    public final ECLottieAnimationView b() {
        return this.f148818a.getCartEntryView();
    }

    public b(IronListHeaderEntryLayout r100, Map r101) {
        this.f148818a = r100;
        this.f148819b = r101;
    }
}
