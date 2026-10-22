package com.obric.appstore.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedanceos.common.core.ui.SettingsActivity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.ImageDetailActivity;
import com.obric.appstore.base.SimpleActivity;
import com.obric.appstore.buss.category.CategoryFragment;
import com.obric.appstore.buss.detail.brief.AppBriefFragment;
import com.obric.appstore.buss.detail.developer.DeveloperFragment;
import com.obric.appstore.buss.detail.permission.PermissionFragment;
import com.obric.appstore.buss.myapp.update.IgnoreUpdateFragment;
import com.obric.appstore.buss.myapp.update.SignNotMatchFragment;
import com.obric.appstore.buss.rank.RankContainerFragment;
import com.obric.appstore.buss.recommend.GameAppRecommendFragment;
import com.obric.appstore.network.entity.template.PageType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f11086a = null;

    static {
        f11086a = new n();
    }

    public n() {
    }

    public static /* synthetic */ void e(n r10, Context r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = com.bytedanceos.common.f.f9823a.c();
    L5:
        r10.d(r11, r12);
    }

    public static /* synthetic */ void m(n r10, Activity r11, String r12, int r13, Bundle r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = null;
    L11:
        r10.l(r11, r12, r13, r14);
    }

    public final Activity a(Activity r10) {
        if (r10.isDestroyed() == false) goto L5;
        return null;
    L5:
        if (r10.isFinishing() == false) goto L7;
        return null;
    L7:
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L12;
        return r10;
    L12:
        return null;
    }

    public final void b(Activity r10, AppInfo r11) {
        kotlin.jvm.internal.q.g(r11, "appInfo");
        if (r10 != null) goto L6;
        return;
    L6:
        if (a(r10) != null) goto L8;
        return;
    L8:
        Intent r12 = SimpleActivity.f10559e.a(r10, AppBriefFragment.class);
        r12.putExtra("__extra_app_info", r11);
        r10.startActivity(r12);
    }

    public final void c(Activity r10, AppInfo r11, int r12) {
        kotlin.jvm.internal.q.g(r11, "appInfo");
        if (r10 != null) goto L6;
        return;
    L6:
        if (a(r10) != null) goto L8;
        return;
    L8:
        if (r12 >= 0) goto L10;
        return;
    L10:
        Intent r13 = new Intent(r10, ImageDetailActivity.class);
        r13.addFlags(268435456);
        r13.setAction("android.intent.action.VIEW");
        ArrayList r14 = new ArrayList();
        if (TextUtils.isEmpty(r11.mAppVideoUrl) == false) goto L13;
    L15:
        r13.putExtra(ImageDetailActivity.EXTRA_IMAGE_INDEX, r12);
        List<String> r15 = r11.appScreenSnaps;
        kotlin.jvm.internal.q.f(r15, "appScreenSnaps");
        r14.addAll(r15);
        r13.putExtra(ImageDetailActivity.EXTRA_IMAGE_URLS, (String[]) r14.toArray(new String[0]));
        r10.startActivity(r13);
        return;
    L13:
        if (TextUtils.isEmpty(r11.mAppVideoImage) == true) goto L15;
        String r16 = r11.mAppVideoImage;
        kotlin.jvm.internal.q.f(r16, "mAppVideoImage");
        r14.add(r16);
        r13.putExtra(CommonConfirmDialog.ARGS_DIALOG_APP, r11);
        goto L15
    }

    public final void d(Context r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r12 = r10 instanceof Activity;
        if (r12 == true) goto L7;
    L9:
        Intent r13 = SimpleActivity.f10559e.a(r10, ra.c.class);
        r13.putExtra("__extra_tab_title", r11);
        if (r12 == true) goto L12;
        r13.setFlags(268435456);
    L12:
        r10.startActivity(r13);
        return;
    L7:
        if (a((Activity) r10) != null) goto L9;
    }

    public final void f(Activity r10, String r11, String r12, String r13) {
        kotlin.jvm.internal.q.g(r11, "firstCategoryTitle");
        kotlin.jvm.internal.q.g(r12, "firstCategoryId");
        kotlin.jvm.internal.q.g(r13, "secondCategoryId");
        if (r10 != null) goto L6;
        return;
    L6:
        if (a(r10) != null) goto L8;
        return;
    L8:
        Intent r14 = SimpleActivity.f10559e.a(r10, CategoryFragment.class);
        r14.putExtra("category_title", r11);
        r14.putExtra("category_first", r12);
        r14.putExtra("category_second", r13);
        r10.startActivity(r14);
    }

    public final void g(Activity r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r11, "developerId");
        kotlin.jvm.internal.q.g(r12, "developerName");
        if (r10 != null) goto L6;
        return;
    L6:
        if (a(r10) != null) goto L8;
        return;
    L8:
        Intent r13 = SimpleActivity.f10559e.a(r10, DeveloperFragment.class);
        r13.putExtra("developerId", r11);
        r13.putExtra("developerName", r12);
        r10.startActivity(r13);
    }

    public final void h(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        r10.startActivity(SimpleActivity.f10559e.a(r10, IgnoreUpdateFragment.class));
    }

    public final void i(Activity r10, AppInfo r11) {
        kotlin.jvm.internal.q.g(r11, "appInfo");
        if (r10 != null) goto L6;
        return;
    L6:
        if (a(r10) != null) goto L8;
        return;
    L8:
        Intent r12 = SimpleActivity.f10559e.a(r10, PermissionFragment.class);
        r12.putExtra("__extra_app_info", r11);
        r10.startActivity(r12);
    }

    public final void j(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        Intent r11 = SimpleActivity.f10559e.a(r10, GameAppRecommendFragment.class);
        r11.putExtra("page_type", PageType.APPS_PAGE.getValue());
        r10.startActivity(r11);
    }

    public final void k(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        Intent r11 = SimpleActivity.f10559e.a(r10, GameAppRecommendFragment.class);
        r11.putExtra("page_type", PageType.GAME_PAGE.getValue());
        r10.startActivity(r11);
    }

    public final void l(Activity r10, String r11, int r12, Bundle r13) {
        com.bytedanceos.common.toolbox.e.o1(r10, r11, r12, "", 0, 0, "search", null, r13);
    }

    public final void n(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        r10.startActivity(new Intent(r10, SettingsActivity.class));
    }

    public final void o(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        r10.startActivity(SimpleActivity.f10559e.a(r10, SignNotMatchFragment.class));
    }

    public final void p(Activity r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (a(r10) != null) goto L7;
        return;
    L7:
        r10.startActivity(SimpleActivity.f10559e.a(r10, RankContainerFragment.class));
    }
}
