package com.stepos.ailauncher.amap.route;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/amap/route/z;", "", "<init>", "()V", "Landroid/view/View;", "view", "", "e", "(Landroid/view/View;)Z", Const.INTENT_KEY_UMID, "f", "", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)Ljava/lang/String;", "Landroid/graphics/Rect;", "out", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;Landroid/graphics/Rect;)Z", "", "MIN_VISIBLE_PX", "I", "MIN_CAPTURE_VISIBLE_HEIGHT_PX", "", "MIN_CAPTURE_VISIBLE_HEIGHT_RATIO", "F", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.amap.route.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2414z {
    public static final C2414z INSTANCE = new C2414z();
    private static final int MIN_CAPTURE_VISIBLE_HEIGHT_PX = 80;
    private static final float MIN_CAPTURE_VISIBLE_HEIGHT_RATIO = 0.35f;
    private static final int MIN_VISIBLE_PX = 8;

    public static final CharSequence c(ViewGroup viewGroup, int i10) {
        return viewGroup.getChildAt(i10).getClass().getSimpleName() + "[" + viewGroup.getChildAt(i10).getWidth() + "x" + viewGroup.getChildAt(i10).getHeight() + "]";
    }

    public final String b(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        if (view.isAttachedToWindow()) {
            view.getLocationInWindow(iArr);
        }
        final ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        String strA0 = viewGroup == null ? O6.l.DATE_SEPARATOR : Z8.F.A0(C5685n.s(0, viewGroup.getChildCount()), Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2414z.c(viewGroup, ((Integer) obj).intValue());
            }
        }, 30, null);
        return "shown=" + view.isShown() + " attached=" + view.isAttachedToWindow() + " winVis=" + view.getWindowVisibility() + " vis=" + view.getVisibility() + " size=" + view.getWidth() + "x" + view.getHeight() + " win=[" + iArr[0] + Const.STR_MART_COMMA + iArr[1] + "] globalVis=" + globalVisibleRect + " " + rect.width() + "x" + rect.height() + rect + " onScreen=" + e(view) + " captureReady=" + d(view) + " children=" + (viewGroup != null ? viewGroup.getChildCount() : 0) + "[" + strA0 + "]";
    }

    public final boolean d(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        Rect rect = new Rect();
        if (g(view, rect)) {
            return rect.height() >= Math.max(80, (int) (((float) view.getHeight()) * 0.35f)) && rect.width() >= 8;
        }
        return false;
    }

    public final boolean e(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        if (view.isAttachedToWindow() && view.getWindowVisibility() == 0 && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect) && rect.width() >= 8 && rect.height() >= 8) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        return g(view, new Rect());
    }

    public final boolean g(View view, Rect out) {
        return view.isAttachedToWindow() && view.getWindowVisibility() == 0 && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0 && view.getGlobalVisibleRect(out) && out.width() >= 8 && out.height() >= 8;
    }
}
