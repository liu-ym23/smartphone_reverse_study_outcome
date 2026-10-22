package com.bytedanceos.common.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBar f10225a;

        public a(OFloatingTitleBar r10) {
            this.f10225a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            com.bytedanceos.common.e.f9820a.openDebug((Activity) this.f10225a.getContext());
        }
    }

    public static View a(OFloatingTitleBar r10, View.OnClickListener r11) {
        return r10.k(R$drawable.oui_ic_back_24_24, -1, r11);
    }

    public static ImageView b(OFloatingTitleBar r10, View.OnClickListener r11) {
        return (ImageView) ((OUIFrameLayout) r10.h(R$drawable.oui_icon_magic, -1, r11)).getChildAt(0);
    }

    public static View c(OFloatingTitleBar r10, View.OnClickListener r11) {
        return r10.h(R$drawable.oui_icon_search, -1, r11);
    }

    public static void d(OFloatingTitleBar r10) {
        r10.setVisibility(0);
    }

    public static View e(OFloatingTitleBar r10, int r11) {
        r10.x();
        return r10.f(r11, -1, new g9.a(new a(r10)));
    }

    public static TextView f(OFloatingTitleBar r10, String r11) {
        r10.setCenterTitle(r11);
        return (TextView) r10.findViewById(R$id.center_title);
    }

    public static boolean g(Activity r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        View r11 = r10.findViewById(R$id.cover_searchbar);
        if (r11 != null) goto L8;
        return false;
    L8:
        r11.setVisibility(0);
        View r12 = r10.findViewById(R$id.searchbar_edit_layout);
        if (r12 != null) goto L11;
        return false;
    L11:
        r12.setVisibility(0);
        OCTitleBar r13 = (OCTitleBar) r10.findViewById(R$id.toolbar);
        if (r13 == null) goto L16;
        r13.setVisibility(8);
        return true;
    L16:
        return true;
    }
}
