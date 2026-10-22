package androidx.compose.ui.viewinterop;

import android.os.Handler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {
    public static final AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 INSTANCE = null;

    static {
        INSTANCE = new AndroidViewHolder$Companion$OnCommitAffectingUpdate$1();
    }

    public AndroidViewHolder$Companion$OnCommitAffectingUpdate$1() {
        super(1);
    }

    public static /* synthetic */ void a(Function0 r100) {
        invoke$lambda$0(r100);
    }

    private static final void invoke$lambda$0(Function0 r100) {
        r100.invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AndroidViewHolder r100) {
        Handler r101 = r100.getHandler();
        final Function0 r102 = AndroidViewHolder.access$getRunUpdate$p(r100);
        r101.post(new b(r102));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AndroidViewHolder r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
