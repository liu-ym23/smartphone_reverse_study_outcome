package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/AnimatedVisibilityScope;", "", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "animateEnterExit", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AnimatedVisibilityScope {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedVisibilityScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Modifier $default$animateEnterExit(final AnimatedVisibilityScope r100, Modifier r101, final EnterTransition r102, final ExitTransition r103, final String r104) {
            if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
            Function1<InspectorInfo, Unit> r105 = new AnimatedVisibilityScope$animateEnterExit$$inlined$debugInspectorInfo$1(r102, r103, r104);
        L7:
            return ComposedModifierKt.composed(r101, r105, new AnonymousClass2(r100, r102, r103, r104));
        L5:
            r105 = InspectableValueKt.getNoInspectorInfo();
            goto L7
        }

        public static /* synthetic */ Modifier access$animateEnterExit$jd(AnimatedVisibilityScope r100, Modifier r101, EnterTransition r102, ExitTransition r103, String r104) {
            return $default$animateEnterExit(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ Modifier animateEnterExit$default(AnimatedVisibilityScope r100, Modifier r101, EnterTransition r102, ExitTransition r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 1) == 0) goto L7;
            r102 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
        L7:
            if ((r105 & 2) == 0) goto L10;
            r103 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
        L10:
            if ((r105 & 4) == 0) goto L13;
            r104 = "animateEnterExit";
        L13:
            return r100.animateEnterExit(r101, r102, r103, r104);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateEnterExit");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Modifier animateEnterExit(AnimatedVisibilityScope r100, Modifier r101, EnterTransition r102, ExitTransition r103, String r104) {
            return CC.access$animateEnterExit$jd(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ Modifier animateEnterExit$default(AnimatedVisibilityScope r100, Modifier r101, EnterTransition r102, ExitTransition r103, String r104, int r105, Object r106) {
            return CC.animateEnterExit$default(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    Modifier animateEnterExit(Modifier r100, EnterTransition r101, ExitTransition r102, String r103);

    Transition<EnterExitState> getTransition();
}
