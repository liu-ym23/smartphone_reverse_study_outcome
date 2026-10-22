package bh2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements Observer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f19011a;

    public m(Fragment r100) {
        this.f19011a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Void r101 = (Void) r100;
        FragmentActivity r102 = this.f19011a.getActivity();
        if (r102 == null) goto L6;
        r102.finish();
        return;
    }
}
