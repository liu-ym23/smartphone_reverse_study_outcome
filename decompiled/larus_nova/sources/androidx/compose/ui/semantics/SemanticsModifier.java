package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsModifier;", "Landroidx/compose/ui/Modifier$Element;", "id", "", "getId$annotations", "()V", "getId", "()I", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SemanticsModifier extends Modifier.Element {

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsModifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getId(SemanticsModifier r100) {
            return -1;
        }

        public static /* synthetic */ int access$getId$jd(SemanticsModifier r100) {
            return $default$getId(r100);
        }

        public static /* synthetic */ boolean access$all$jd(SemanticsModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$all(r100, r101);
        }

        public static /* synthetic */ boolean access$any$jd(SemanticsModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$any(r100, r101);
        }

        public static /* synthetic */ Modifier access$then$jd(SemanticsModifier r100, Modifier r101) {
            return Modifier.CC.$default$then(r100, r101);
        }

        public static /* synthetic */ Object access$foldIn$jd(SemanticsModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldIn(r100, r101, r102);
        }

        public static /* synthetic */ Object access$foldOut$jd(SemanticsModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldOut(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "SemanticsModifier.id is now unused and has been set to a fixed value. Retrieve the id from LayoutInfo instead.", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public static /* synthetic */ void getId$annotations() {
        }

        public static int getId(SemanticsModifier r100) {
            return CC.access$getId$jd(r100);
        }

        public static boolean all(SemanticsModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$all$jd(r100, r101);
        }

        public static boolean any(SemanticsModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$any$jd(r100, r101);
        }

        public static Modifier then(SemanticsModifier r100, Modifier r101) {
            return CC.access$then$jd(r100, r101);
        }

        public static <R> R foldIn(SemanticsModifier r100, R r101, Function2<? super R, ? super Modifier.Element, ? extends R> r102) {
            return (R) CC.access$foldIn$jd(r100, r101, r102);
        }

        public static <R> R foldOut(SemanticsModifier r100, R r101, Function2<? super Modifier.Element, ? super R, ? extends R> r102) {
            return (R) CC.access$foldOut$jd(r100, r101, r102);
        }
    }

    int getId();

    SemanticsConfiguration getSemanticsConfiguration();
}
