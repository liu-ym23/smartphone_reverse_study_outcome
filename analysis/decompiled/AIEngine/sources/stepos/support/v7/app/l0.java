package stepos.support.v7.app;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f12152a;

    public l0(TextView textView) {
        this.f12152a = textView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        TextView textView = this.f12152a;
        textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        textView.setGravity(textView.getLineCount() > 1 ? 8388611 : 17);
    }
}
