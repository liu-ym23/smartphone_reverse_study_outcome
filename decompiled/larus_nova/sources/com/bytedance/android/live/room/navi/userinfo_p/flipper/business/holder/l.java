package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f99981a;

    public l(k r100) {
        this.f99981a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        k r102 = this.f99981a;
        View r103 = r102.f99933f;
        if (r103 == null) goto L10;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(r104.width, r104.height);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r104;
        r105.topMargin = r106.topMargin;
        r105.bottomMargin = r106.bottomMargin;
        r105.rightMargin = r106.rightMargin;
        r105.leftMargin = r106.leftMargin;
        Unit r107 = Unit.INSTANCE;
        r102.f99980j = r105;
    L8:
        r104.height = s1.f(36.0f);
        UIUtils.updateLayoutMargin(r103, -3, 0, -3, 0);
        r103.setLayoutParams(r104);
        return;
    }
}
