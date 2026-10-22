package com.bytedanceos.appstore.buss.widget.app.item;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.y0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemGiftMyView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;)V", "Lx7/y0;", "a", "Lx7/y0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemGiftMyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f9121a;

    public /* synthetic */ ItemGiftMyView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(GiftMyEntity r10, ItemGiftMyView r11, View r12) {
        d(r10, r11, r12);
    }

    public static /* synthetic */ void b(ItemGiftMyView r10, GiftMyEntity r11, View r12) {
        c(r10, r11, r12);
    }

    public static final void c(ItemGiftMyView r10, GiftMyEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        i7.a.e(r10, AppDetailFragment.a.b(AppDetailFragment.f8472z, r11.getPackageName(), null, false, 0, "page_my_gift", 14, null));
        Bundle r13 = new Bundle();
        r13.putString("app_pkg", r11.getPackageName());
        r13.putString(NetKey.PAGE_SOURCE, "page_my_gift");
        f9.b.b("click_item_goodies_detail", r13);
    }

    public static final void d(GiftMyEntity r10, ItemGiftMyView r11, View r12) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        if (com.bytedanceos.common.toolbox.e.x0(r10.getPackageName()) == false) goto L5;
        com.bytedanceos.appstore.buss.widget.dialog.r r13 = com.bytedanceos.appstore.buss.widget.dialog.r.f9272a;
        Context r14 = r11.getContext();
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type android.app.Activity");
        r13.k((Activity) r14, r10);
    L6:
        Bundle r15 = new Bundle();
        r15.putString(NetKey.PAGE_SOURCE, "page_my_gift");
        f9.b.b("click_goodies_use_dialog", r15);
        return;
    L5:
        com.bytedanceos.appstore.buss.widget.dialog.r r16 = com.bytedanceos.appstore.buss.widget.dialog.r.f9272a;
        Context r17 = r11.getContext();
        kotlin.jvm.internal.q.e(r17, "null cannot be cast to non-null type android.app.Activity");
        r16.h((Activity) r17, r10);
        goto L6
    }

    public final void setNewData(@Nullable final GiftMyEntity r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        ImageView r11 = this.f9121a.f25811b;
        kotlin.jvm.internal.q.f(r11, "ivIcon");
        ImageUtilKt.k(r11, r10.getLogo(), 0, 2, null);
        this.f9121a.f25816g.setText(r10.getName());
        this.f9121a.f25814e.setText(r10.getCode());
        long r12 = 1000;
        this.f9121a.f25812c.setText(com.bytedanceos.common.toolbox.e.J(Long.parseLong(r10.getStartTime()) * r12, Long.parseLong(r10.getEndTime()) * r12));
        if (kotlin.jvm.internal.q.b(r10.getRestCount(), AdReportParam.ClickPosType.SKIP) == false) goto L8;
        this.f9121a.f25815f.setText(R.string.gift_btn_over);
        this.f9121a.f25815f.setEnabled(false);
        this.f9121a.f25815f.setAlpha(0.3f);
    L9:
        setOnClickListener(new e(this, r10));
        this.f9121a.f25815f.setOnClickListener(new f(r10, this));
        return;
    L8:
        this.f9121a.f25815f.setText(R.string.gift_btn_use);
        this.f9121a.f25815f.setEnabled(true);
        this.f9121a.f25815f.setAlpha(1.0f);
        goto L9
    }

    public ItemGiftMyView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        y0 r12 = y0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9121a = r12;
    }
}
