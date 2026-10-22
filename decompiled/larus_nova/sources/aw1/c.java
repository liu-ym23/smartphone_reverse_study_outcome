package aw1;

import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleListDrawFragment;
import com.bytedance.android.livesdk.viewmodel.i;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleListDrawFragment f16409a;

    public c(SingleListDrawFragment r100) {
        this.f16409a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        i r101 = (i) r100;
        if (r101 == null) goto L6;
        SingleListDrawFragment r102 = this.f16409a;
        long r103 = r101.f159328a;
        boolean r104 = r101.f159329b;
        int r105 = SingleListDrawFragment.H;
        r102.U90(r103, r104);
        return;
    }
}
