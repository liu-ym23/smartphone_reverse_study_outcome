package bz4;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BearLottieView f21876b;

    public a(View r100) {
        this.f21875a = r100;
        r100.setClickable(true);
        this.f21876b = (BearLottieView) r100.findViewById(R.id.doc_loading_lottie);
    }
}
