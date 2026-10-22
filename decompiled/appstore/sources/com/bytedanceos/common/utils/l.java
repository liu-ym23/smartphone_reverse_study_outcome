package com.bytedanceos.common.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.GiftPackInfo;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.bytedanceos.common.ui.adapter.GameGiftAdapter;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f10207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f10208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f10209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public APresenter f10210d;

    public l(Activity r10, ViewGroup r11, APresenter r12) {
        this.f10209c = r10;
        this.f10207a = r11;
        this.f10210d = r12;
    }

    public boolean a(ViewGroup r10) {
        ViewGroup r11 = this.f10208b;
        if (r11 != null) goto L5;
    L11:
        return false;
    L5:
        if (r11.isShown() == false) goto L11;
        if (r10 == null) goto L11;
        if (r10.isShown() == true) goto L11;
        c(this.f10208b, R$anim.slide_out_to_right, 8);
        c(r10, R$anim.slide_in_from_left, 0);
        return true;
    }

    public void b(boolean r10, APresenter.b r11) {
        if (r11 != null) goto L4;
    L34:
        e0.e(R$string.ERROR_SERVICE_OPERATION_WRONG);
        com.bytedanceos.common.toolbox.j.e("responseBody is null.");
        return;
    L4:
        if (TextUtils.isEmpty(r11.f9801b) == true) goto L34;
        if (r10 == true) goto L15;
        AppStoreCommonError r12 = n.a(BaseApplication.c(), null, r11.f9801b);
        if (r12 != null) goto L10;
    L12:
        e0.e(R$string.ERROR_SERVICE_OPERATION_WRONG);
    L13:
        com.bytedanceos.common.toolbox.j.e("get gift failed:" + r11.f9801b);
        return;
    L10:
        if (TextUtils.isEmpty(r12.getErrorMsg()) == true) goto L12;
        e0.g(r12.getErrorMsg());
        goto L13
    L15:
        Object r13 = r11.f9802c;
        if (r13 != null) goto L18;
    L32:
        com.bytedanceos.common.toolbox.j.e("params error");
        return;
    L18:
        if ((r13 instanceof GiftPackInfo) == false) goto L32;
        GiftPackInfo r14 = (GiftPackInfo) r13;
        AppInfo r15 = c9.a.p(r11.f9801b, this.f10209c, r14.mId);
        if (r15 != null) goto L24;
        e0.g(this.f10209c.getString(R$string.gift_over));
        com.bytedanceos.common.toolbox.j.e("params error" + r11.f9801b);
        return;
    L24:
        ConfirmDialog.newInstance(21, true, r15).show(this.f10209c.getFragmentManager(), "GET_GIFT_SUCCESS");
        r14.mCount--;
        r14.isReceived = true;
        r14.mGiftPackCode = r15.mGiftPackCode;
        r14.fileMd5 = r15.fileMd5;
        ViewGroup r16 = this.f10208b;
        if (r16 == null) goto L27;
        r16.isShown();
    L27:
        ListView r17 = (ListView) this.f10207a.findViewById(R$id.game_gift_pack_content);
        if (r17 == null) goto L30;
        ((GameGiftAdapter) r17.getAdapter()).addGiftPack(r14);
    L30:
        d9.a.e().i("0038", BaseApplication.c().b().b0(r15.appPackageName));
        EventBus.getDefault().post(r14);
    }

    public final void c(ViewGroup r10, int r11, int r12) {
        if (r10 != null) goto L10;
        return;
    L10:
        r10.clearAnimation();     // Catch: Exception -> L6
    L8:
        r10.setVisibility(r12);
        r10.startAnimation(AnimationUtils.loadAnimation(BaseApplication.c(), r11));
        return;
    L6:
        e = move-exception;
        e.getStackTrace();
        goto L8
    }

    public ViewGroup d(ViewGroup r10, GiftPackInfo r11) {
        return this.f10208b;
    }

    public void e(ViewGroup r10, List r11, View.OnClickListener r12) {
        r10.setVisibility(0);
        GameGiftAdapter r13 = new GameGiftAdapter(r12, 3);
        View r14 = this.f10207a.findViewById(R$id.game_gift_pack_more);
        if (r11.size() <= 5) goto L5;
        r13.setMaxLines(5);
        r14.setVisibility(0);
        r14.setOnClickListener(this);
    L6:
        ListView r15 = (ListView) this.f10207a.findViewById(R$id.game_gift_pack_content);
        r15.setFocusable(false);
        r13.setData(r11);
        r15.setAdapter(r13);
        return;
    L5:
        r14.setVisibility(8);
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }
}
