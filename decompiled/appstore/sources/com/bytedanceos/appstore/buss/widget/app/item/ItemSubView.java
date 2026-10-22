package com.bytedanceos.appstore.buss.widget.app.item;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.fragment.SubDetailFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.widget.dialog.v;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.e1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR`\u0010\u001d\u001a@\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemSubView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;)V", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "subJob", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "b", "Lkotlin/jvm/functions/Function2;", "getAppBtnOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppBtnOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appBtnOnClickListener", "", "c", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Lx7/e1;", "d", "Lx7/e1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSubView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f9151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f9152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1 f9154d;

    public /* synthetic */ ItemSubView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemSubView r10, AppSubEntity r11, View r12) {
        g(r10, r11, r12);
    }

    public static /* synthetic */ void b(AppSubEntity r10, ItemSubView r11, View r12) {
        f(r10, r11, r12);
    }

    public static final /* synthetic */ e1 c(ItemSubView r10) {
        return r10.f9154d;
    }

    public static final /* synthetic */ Job d(ItemSubView r10) {
        return r10.f9151a;
    }

    public static final /* synthetic */ void e(ItemSubView r10, Job r11) {
        r10.f9151a = r11;
    }

    public static final void f(final AppSubEntity r10, final ItemSubView r11, View r12) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        if (r10.getStatus() != 0) goto L8;
        r10.setStatus(1);
        r11.f9154d.f25552f.setSubcirbe(r10.isSubscribed());
        Job r13 = r11.f9151a;
        if (r13 == null) goto L7;
        Job.a.b(r13, null, 1, null);
    L7:
        r11.f9151a = kotlinx.coroutines.h.d(y0.f21772a, null, null, new ItemSubView$setNewData$1$1(r10, r11, null), 3, null);
        return;
    L8:
        v r14 = v.f9279a;
        Context r15 = r11.getContext();
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type android.app.Activity");
        r14.e((Activity) r15, new ItemSubView$setNewData$1$2(r10, r11));
    }

    public static final void g(ItemSubView r10, AppSubEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        i7.a.e(r10, SubDetailFragment.f8651m.a(r11.getId()));
        if (kotlin.jvm.internal.q.b(r10.f9153c, "page_game_subscribe") == false) goto L5;
        Bundle r13 = new Bundle();
        r13.putString(TrackerElement.GAME_NAME, r11.getName());
        r13.putString("game_category", r11.getCategory());
        r13.putString("game_online_time", r11.getOnline_time());
        r13.putString("game_position", r11.getItemPosition());
        f9.b.b("click_pages_reserved_detail", r13);
    L5:
        Bundle r14 = new Bundle();
        r14.putString(NetKey.PAGE_SOURCE, r10.f9153c);
        f9.b.b("exposure_pages_reserved_detail", r14);
    }

    @Nullable
    public final Function2<View, AppSubEntity, Unit> getAppBtnOnClickListener() {
        return this.f9152b;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9153c;
    }

    public final void setAppBtnOnClickListener(@Nullable Function2<? super View, ? super AppSubEntity, Unit> r10) {
        this.f9152b = r10;
    }

    public final void setNewData(@Nullable final AppSubEntity r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        String r11 = r10.getBanner();
        if (r11 != null) goto L8;
    L11:
        ViewGroup.LayoutParams r12 = this.f9154d.f25548b.getLayoutParams();
        r12.width = getResources().getDimensionPixelSize(R.dimen.tv_app_icon_size);
        ViewGroup.LayoutParams r13 = this.f9154d.f25548b.getLayoutParams();
        r13.height = getResources().getDimensionPixelSize(R.dimen.tv_app_icon_size);
    L12:
        ImageView r14 = this.f9154d.f25548b;
        kotlin.jvm.internal.q.f(r14, "ivIcon");
        String r15 = r10.getBanner();
        if (r15 != null) goto L15;
    L18:
        String r16 = r10.getLogo();
    L19:
        ImageUtilKt.k(r14, r16, 0, 2, null);
        this.f9154d.f25551e.setText(r10.getName());
        this.f9154d.f25550d.setText(r10.getCategory());
        this.f9154d.f25553g.setText(com.bytedanceos.common.toolbox.e.T(r10.getOnline_time()));
        this.f9154d.f25552f.setSubcirbe(r10.isSubscribed());
        this.f9154d.f25552f.setId(r10.getId());
        this.f9154d.f25552f.setOnClickListener(new p(r10, this));
        setOnClickListener(new q(this, r10));
        return;
    L15:
        if (kotlin.text.o.r(r15) == true) goto L18;
        r16 = r10.getBanner();
        goto L19
    L8:
        if (kotlin.text.o.r(r11) == true) goto L11;
        ViewGroup.LayoutParams r17 = this.f9154d.f25548b.getLayoutParams();
        r17.width = getResources().getDimensionPixelSize(R.dimen.tv_app_large_logo_width);
        ViewGroup.LayoutParams r18 = this.f9154d.f25548b.getLayoutParams();
        r18.height = getResources().getDimensionPixelSize(R.dimen.tv_app_large_logo_height);
        this.f9154d.f25548b.setAdjustViewBounds(true);
        this.f9154d.f25548b.setScaleType(ImageView.ScaleType.FIT_XY);
        goto L12
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9153c = r10;
    }

    public ItemSubView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        e1 r12 = e1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9154d = r12;
    }
}
