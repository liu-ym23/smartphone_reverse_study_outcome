package stepos.support.v7.app;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* loaded from: classes2.dex */
public final class Q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14332a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f14333b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14334c;

    public /* synthetic */ Q(Object obj, TextView textView, int i4) {
        this.f14332a = i4;
        this.f14334c = obj;
        this.f14333b = textView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i4 = this.f14332a;
        TextView textView = this.f14333b;
        switch (i4) {
            case 0:
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (textView.getLineCount() == 1) {
                    textView.setGravity(17);
                    break;
                }
                break;
            default:
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                textView.setGravity(textView.getLineCount() > 1 ? 8388611 : 17);
                break;
        }
    }
}
