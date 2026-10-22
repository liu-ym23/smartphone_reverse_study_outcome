package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/ViewRootForInspector;", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ViewRootForInspector {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewRootForInspector$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static AbstractComposeView $default$getSubCompositionView(ViewRootForInspector r100) {
            return null;
        }

        public static View $default$getViewRoot(ViewRootForInspector r100) {
            return null;
        }

        public static /* synthetic */ AbstractComposeView access$getSubCompositionView$jd(ViewRootForInspector r100) {
            return $default$getSubCompositionView(r100);
        }

        public static /* synthetic */ View access$getViewRoot$jd(ViewRootForInspector r100) {
            return $default$getViewRoot(r100);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static AbstractComposeView getSubCompositionView(ViewRootForInspector r100) {
            return CC.access$getSubCompositionView$jd(r100);
        }

        public static View getViewRoot(ViewRootForInspector r100) {
            return CC.access$getViewRoot$jd(r100);
        }
    }

    AbstractComposeView getSubCompositionView();

    View getViewRoot();
}
