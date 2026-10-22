package bh2;

import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class v implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECBaseDialogFragment f19018a;

    public v(ECBaseDialogFragment r100) {
        this.f19018a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ECBaseDialogFragment r101 = this.f19018a;
        r101.ga0((String) r100);
    }
}
