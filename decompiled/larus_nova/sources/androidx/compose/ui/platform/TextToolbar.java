package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jj\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0016JX\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u0003H&R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/TextToolbar;", "", "showMenu", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "hide", "status", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TextToolbar {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.TextToolbar$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$showMenu(TextToolbar r100, Rect r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105, Function0 r106) {
            r100.showMenu(r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ void access$showMenu$jd(TextToolbar r100, Rect r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105, Function0 r106) {
            $default$showMenu(r100, r101, r102, r103, r104, r105, r106);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showMenu$default(TextToolbar r100, Rect r101, Function0 r102, Function0 r110, Function0 r111, Function0 r112, int r113, Object r114) {
            if (r114 != null) goto L22;
            if ((r113 & 2) == 0) goto L6;
            Function0 r103 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            Function0 r104 = null;
        L12:
            if ((r113 & 8) == 0) goto L14;
            Function0 r105 = null;
        L16:
            if ((r113 & 16) == 0) goto L18;
            Function0 r106 = null;
        L19:
            r100.showMenu(r101, r103, r104, r105, r106);
            return;
        L18:
            r106 = r112;
            goto L19
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showMenu$default(TextToolbar r100, Rect r101, Function0 r102, Function0 r103, Function0 r110, Function0 r111, Function0 r112, int r113, Object r114) {
            if (r114 != null) goto L26;
            Function0 r104 = null;
            if ((r113 & 2) == 0) goto L6;
            Function0 r105 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            Function0 r106 = null;
        L12:
            if ((r113 & 8) == 0) goto L14;
            Function0 r107 = null;
        L16:
            if ((r113 & 16) == 0) goto L18;
            Function0 r108 = null;
        L20:
            if ((r113 & 32) != 0) goto L23;
            r104 = r112;
        L23:
            r100.showMenu(r101, r105, r106, r107, r108, r104);
            return;
        L18:
            r108 = r111;
            goto L20
        L14:
            r107 = r110;
            goto L16
        L10:
            r106 = r103;
            goto L12
        L6:
            r105 = r102;
            goto L8
        L26:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void showMenu(TextToolbar r100, Rect r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Unit> r106) {
            CC.access$showMenu$jd(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ void showMenu$default(TextToolbar r100, Rect r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105, int r106, Object r107) {
            CC.showMenu$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        public static /* synthetic */ void showMenu$default(TextToolbar r100, Rect r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105, Function0 r106, int r107, Object r108) {
            CC.showMenu$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }
    }

    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect r100, Function0<Unit> r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104);

    void showMenu(Rect r100, Function0<Unit> r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105);
}
