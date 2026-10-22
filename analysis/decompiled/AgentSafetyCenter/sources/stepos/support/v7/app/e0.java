package stepos.support.v7.app;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class e0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12312c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ TextView f12313f;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f12312c) {
            case 0:
                TextView textView = this.f12313f;
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (textView.getLineCount() == 1) {
                    textView.setGravity(17);
                    break;
                }
                break;
            default:
                TextView textView2 = this.f12313f;
                textView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                textView2.setGravity(textView2.getLineCount() > 1 ? 8388611 : 17);
                break;
        }
    }
}
