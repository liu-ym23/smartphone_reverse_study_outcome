package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"load", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/ResourceFont;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontLoader_androidKt {
    public static final /* synthetic */ android.graphics.Typeface access$load(ResourceFont r100, Context r101) {
        return load(r100, r101);
    }

    private static final android.graphics.Typeface load(ResourceFont r100, Context r101) {
        android.graphics.Typeface r102 = ResourcesCompat.getFont(r101, r100.getResId());
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public static final /* synthetic */ Object access$loadAsync(ResourceFont r100, Context r101, Continuation r102) {
        return loadAsync(r100, r101, r102);
    }

    private static final Object loadAsync(final ResourceFont r100, Context r101, Continuation<? super android.graphics.Typeface> r102) {
        final j r103 = new j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        ResourcesCompat.getFont(r101, r100.getResId(), new AndroidFontLoader_androidKt$loadAsync$2$1(r103, r100), null);
        Object r104 = r103.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }
}
