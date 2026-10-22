package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseLazyFragment;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseVisibilityFragment;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/l;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseLazyFragment extends BaseVisibilityFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f148855h;

    public BaseLazyFragment() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.BaseVisibilityFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f148859g.add(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.BaseVisibilityFragment, com.bytedance.android.livesdk.livecommerce.iron.ui.l
    public final void qP(boolean r100) {
        if (this.f148855h == true) goto L7;
        if (r100 == false) goto L8;
        this.f148855h = true;
        return;
    L8:
        return;
    }
}
