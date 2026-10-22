package androidx.compose.ui.window;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "command", "Lkotlin/Function0;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class PopupLayout$snapshotStateObserver$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ PopupLayout this$0;

    public PopupLayout$snapshotStateObserver$1(PopupLayout r100) {
        this.this$0 = r100;
        super(1);
    }

    public static /* synthetic */ void a(Function0 r100) {
        invoke$lambda$0(r100);
    }

    private static final void invoke$lambda$0(Function0 r100) {
        r100.invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Function0<Unit> r100) {
        Handler r101 = this.this$0.getHandler();
        if (r101 == null) goto L5;
        Looper r102 = r101.getLooper();
    L7:
        if (r102 != Looper.myLooper()) goto L9;
        r100.invoke();
        return;
    L9:
        Handler r103 = this.this$0.getHandler();
        if (r103 == null) goto L14;
        r103.post(new b(r100));
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
