package bh2;

import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements Observer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECBaseDialogFragment f19017a;

    public u(ECBaseDialogFragment r100) {
        this.f19017a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Void r101 = (Void) r100;
        this.f19017a.ea0();
    }
}
