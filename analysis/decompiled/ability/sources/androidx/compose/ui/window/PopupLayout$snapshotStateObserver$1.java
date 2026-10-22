package androidx.compose.ui.window;

import C7.r;
import S7.k;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "command", "invoke", "(LS7/a;)V", "<anonymous>"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes2.dex */
public final class PopupLayout$snapshotStateObserver$1 extends Lambda implements k {
    final /* synthetic */ PopupLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupLayout$snapshotStateObserver$1(PopupLayout popupLayout) {
        super(1);
        this.this$0 = popupLayout;
    }

    @Override // S7.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((S7.a) obj);
        return r.f317a;
    }

    public final void invoke(final S7.a aVar) {
        Handler handler = this.this$0.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            aVar.invoke();
            return;
        }
        Handler handler2 = this.this$0.getHandler();
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: androidx.compose.ui.window.b
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.invoke();
                }
            });
        }
    }
}
