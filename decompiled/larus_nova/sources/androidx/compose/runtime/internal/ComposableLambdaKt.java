package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a%\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"SLOTS_PER_INT", "", "BITS_PER_SLOT", "bitsForSlot", "bits", "slot", "sameBits", "differentBits", "replacableWith", "", "Landroidx/compose/runtime/RecomposeScope;", "other", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "key", "tracked", "block", "", "lambdaKey", "composableLambdaInstance", "rememberComposableLambda", "(IZLjava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/internal/ComposableLambda;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;
    private static final Object lambdaKey = null;

    static {
        lambdaKey = new Object();
    }

    public static final int differentBits(int r100) {
        return bitsForSlot(2, r100);
    }

    public static final int sameBits(int r100) {
        return bitsForSlot(1, r100);
    }

    public static final int bitsForSlot(int r100, int r101) {
        return r100 << (((r101 % 10) * 3) + 1);
    }

    public static final boolean replacableWith(RecomposeScope r100, RecomposeScope r101) {
        if (r100 != null) goto L4;
    L15:
        return true;
    L4:
        if ((r100 instanceof RecomposeScopeImpl) == true) goto L6;
    L14:
        return false;
    L6:
        if ((r101 instanceof RecomposeScopeImpl) == false) goto L14;
        RecomposeScopeImpl r102 = (RecomposeScopeImpl) r100;
        if (r102.getValid() == false) goto L15;
        if (Intrinsics.areEqual(r100, r101) == true) goto L15;
        if (Intrinsics.areEqual(r102.getAnchor(), ((RecomposeScopeImpl) r101).getAnchor()) == false) goto L14;
        goto L14
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambdaInstance(int r100, boolean r101, Object r102) {
        return new ComposableLambdaImpl(r100, r101, r102);
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambda(Composer r100, int r101, boolean r102, Object r103) {
        r100.startMovableGroup(Integer.rotateLeft(r101, 1), lambdaKey);
        Object r104 = r100.rememberedValue();
        if (r104 != Composer.Companion.getEmpty()) goto L5;
        ComposableLambdaImpl r105 = new ComposableLambdaImpl(r101, r102, r103);
        r100.updateRememberedValue(r105);
    L6:
        r100.endMovableGroup();
        return r105;
    L5:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
        r105 = (ComposableLambdaImpl) r104;
        r105.update(r103);
        goto L6
    }

    @ComposeCompilerApi
    public static final ComposableLambda rememberComposableLambda(int r100, boolean r101, Object r102, Composer r103, int r104) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1573003438, r104, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:1371)");
    L5:
        Object r105 = r103.rememberedValue();
        if (r105 != Composer.Companion.getEmpty()) goto L8;
        r105 = new ComposableLambdaImpl(r100, r101, r102);
        r103.updateRememberedValue(r105);
    L8:
        ComposableLambdaImpl r106 = (ComposableLambdaImpl) r105;
        r106.update(r102);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r106;
    }
}
