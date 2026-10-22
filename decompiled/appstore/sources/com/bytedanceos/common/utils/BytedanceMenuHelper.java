package com.bytedanceos.common.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BytedanceMenuHelper {

    public static class OUIMenuItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OnMenuItemClickListener f10140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10144e;

        public interface OnMenuItemClickListener {
            boolean onMenuItemClick(OUIMenuItem r10);
        }

        public OUIMenuItem(int r10, int r11, int r12, int r13, OnMenuItemClickListener r14) {
            this.f10141b = r12;
            this.f10142c = r11;
            this.f10143d = r10;
            this.f10144e = r13;
            this.f10140a = r14;
        }

        public int a() {
            return this.f10141b;
        }

        public OnMenuItemClickListener b() {
            return this.f10140a;
        }

        public String c() {
            return BaseApplication.c().getString(this.f10144e);
        }
    }

    public static /* synthetic */ Unit a(OUIMenuItem r10, View r11, Integer r12) {
        return h(r10, r11, r12);
    }

    public static OPopoverEntranceMenuView b(Activity r11, List r12) {
        OPopoverEntranceMenuView.Builder r10 = new OPopoverEntranceMenuView.Builder(r11);
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L6;
        final OUIMenuItem r14 = (OUIMenuItem) r12.get(r13);
        r10.b(Integer.valueOf(r14.a()), null, null, r14.c(), null, null, false, null, new g(r14));
        r13 = r13 + 1;
        goto L4
    L6:
        r10.g(tc.f.i(SearchChipsView.GRAY));
        r10.e();
        return r10.d();
    }

    public static OPopover c(View r10, OUIMenuItem.OnMenuItemClickListener r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof Activity) == true) goto L6;
        return null;
    L6:
        Activity r13 = (Activity) r12;
        ArrayList r14 = new ArrayList();
        r14.add(new OUIMenuItem(0, R$id.action_agree_update, R$drawable.ic_menu_agree_update, R$string.menu_action_title_agree_update, r11));
        return new OPopover.a(r13).W(tc.f.i(SearchChipsView.WHITE_SEARCH_ICON)).U(false).V(b(r13, r14)).T(80).a();
    }

    public static OPopover d(View r10, OUIMenuItem.OnMenuItemClickListener r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof Activity) == true) goto L6;
        return null;
    L6:
        Activity r13 = (Activity) r12;
        ArrayList r14 = new ArrayList();
        r14.add(new OUIMenuItem(0, R$id.action_cancel_download, R$drawable.ic_menu_cancel_download, R$string.menu_action_title_cancel_download, r11));
        return new OPopover.a(r13).W(tc.f.i(160)).U(false).V(b(r13, r14)).T(80).a();
    }

    public static OPopover e(View r10, OUIMenuItem.OnMenuItemClickListener r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof Activity) == true) goto L6;
        return null;
    L6:
        Activity r13 = (Activity) r12;
        ArrayList r14 = new ArrayList();
        r14.add(new OUIMenuItem(0, R$id.action_delete, R$drawable.oui_icon_rubbishbin_red, R$string.menu_action_title_delete, r11));
        return new OPopover.a(r13).W(tc.f.i(SearchChipsView.WHITE_SEARCH_ICON)).U(false).V(b(r13, r14)).T(17).a();
    }

    public static OPopover f(View r10, OUIMenuItem.OnMenuItemClickListener r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof Activity) == true) goto L6;
        return null;
    L6:
        Activity r13 = (Activity) r12;
        ArrayList r14 = new ArrayList();
        r14.add(new OUIMenuItem(0, R$id.action_ignore_update, R$drawable.ic_menu_ignore_update, R$string.menu_action_title_ignore_update, r11));
        return new OPopover.a(r13).W(tc.f.i(160)).U(false).V(b(r13, r14)).T(80).a();
    }

    public static OPopover g(View r10, OUIMenuItem.OnMenuItemClickListener r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof Activity) == true) goto L6;
        return null;
    L6:
        Activity r13 = (Activity) r12;
        ArrayList r14 = new ArrayList();
        r14.add(new OUIMenuItem(0, R$id.action_remove_collect, R$drawable.ic_menu_remove_collect, R$string.menu_action_title_remove_collect, r11));
        return new OPopover.a(r13).W(tc.f.i(160)).U(false).V(b(r13, r14)).T(80).a();
    }

    public static /* synthetic */ Unit h(OUIMenuItem r10, View r11, Integer r12) {
        r10.b().onMenuItemClick(r10);
        return null;
    }
}
