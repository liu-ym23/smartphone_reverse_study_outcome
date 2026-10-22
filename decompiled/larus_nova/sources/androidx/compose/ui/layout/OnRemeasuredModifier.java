package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/Modifier$Element;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface OnRemeasuredModifier extends Modifier.Element {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.OnRemeasuredModifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean access$all$jd(OnRemeasuredModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$all(r100, r101);
        }

        public static /* synthetic */ boolean access$any$jd(OnRemeasuredModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$any(r100, r101);
        }

        public static /* synthetic */ Modifier access$then$jd(OnRemeasuredModifier r100, Modifier r101) {
            return Modifier.CC.$default$then(r100, r101);
        }

        public static /* synthetic */ Object access$foldIn$jd(OnRemeasuredModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldIn(r100, r101, r102);
        }

        public static /* synthetic */ Object access$foldOut$jd(OnRemeasuredModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldOut(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean all(OnRemeasuredModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$all$jd(r100, r101);
        }

        public static boolean any(OnRemeasuredModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$any$jd(r100, r101);
        }

        public static Modifier then(OnRemeasuredModifier r100, Modifier r101) {
            return CC.access$then$jd(r100, r101);
        }

        public static <R> R foldIn(OnRemeasuredModifier r100, R r101, Function2<? super R, ? super Modifier.Element, ? extends R> r102) {
            return (R) CC.access$foldIn$jd(r100, r101, r102);
        }

        public static <R> R foldOut(OnRemeasuredModifier r100, R r101, Function2<? super Modifier.Element, ? super R, ? extends R> r102) {
            return (R) CC.access$foldOut$jd(r100, r101, r102);
        }
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    void m6317onRemeasuredozmzZPI(long r100);
}
