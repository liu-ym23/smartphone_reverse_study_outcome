package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.GiftAllEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.x0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemGiftAllView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/GiftAllEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/GiftAllEntity;)V", "Lx7/x0;", "a", "Lx7/x0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemGiftAllView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f9120a;

    public /* synthetic */ ItemGiftAllView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemGiftAllView r10, GiftAllEntity r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(ItemGiftAllView r10, GiftAllEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        i7.a.e(r10, AppDetailFragment.a.b(AppDetailFragment.f8472z, r11.getPackageName(), null, false, 0, "page_all_gift", 14, null));
        Bundle r13 = new Bundle();
        r13.putString("app_pkg", r11.getPackageName());
        r13.putString(NetKey.PAGE_SOURCE, "page_all_gift");
        f9.b.b("click_item_goodies_detail", r13);
    }

    public final void setNewData(@Nullable final GiftAllEntity r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        ImageView r11 = this.f9120a.f25790b;
        kotlin.jvm.internal.q.f(r11, "ivIcon");
        ImageUtilKt.g(r11, r10.getLogo(), R.dimen.dp_12, 0, 4, null);
        this.f9120a.f25795g.setText(r10.getName());
        this.f9120a.f25793e.setText(r10.getCategory());
        this.f9120a.f25791c.setImageResource(com.bytedanceos.common.toolbox.e.b0(getContext(), Float.parseFloat(r10.getScores()), false));
        this.f9120a.f25794f.setText("礼包 " + r10.getCount() + " 款");
        setOnClickListener(new d(this, r10));
    }

    public ItemGiftAllView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        x0 r12 = x0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9120a = r12;
    }
}
