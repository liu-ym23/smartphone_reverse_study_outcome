package aia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.api.window.IWindowContextKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3864a = 0;

    static {
    }

    public static int a(View r100, View r101) {
        if (r100 == null) goto L5;
        int r102 = r100.getPaddingBottom();
    L6:
        if (r102 > 0) goto L24;
        if (r100 == null) goto L13;
        Context r103 = r100.getContext();
        if (r103 == null) goto L13;
        boolean r104 = true;
        if (IWindowContextKt.isWindowContext(r103) != true) goto L13;
    L14:
        if (r104 == false) goto L24;
        if (r101 == null) goto L25;
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L21:
        if (r106 != null) goto L23;
        return 0;
    L23:
        return r106.bottomMargin;
    L20:
        r106 = null;
        goto L21
    L25:
        return 0;
    L13:
        r104 = false;
    L24:
        return r102;
    L5:
        r102 = 0;
        goto L6
    }
}
