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
import android.widget.TextView;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.z0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eRZ\u0010\u001b\u001a:\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR`\u0010 \u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010+\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010/\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010#\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemHorizontalLargeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "position", "", "d", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;I)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "b", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "", "c", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "getItemCanClick", "setItemCanClick", "itemCanClick", "e", "getEditState", "setEditState", "editState", "", "f", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Lx7/z0;", "g", "Lx7/z0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalLargeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f9123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z0 f9128g;

    public /* synthetic */ ItemHorizontalLargeView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemHorizontalLargeView r10, CommonAppEntity r11, View r12) {
        f(r10, r11, r12);
    }

    public static /* synthetic */ boolean b(ItemHorizontalLargeView r10, CommonAppEntity r11, View r12) {
        return g(r10, r11, r12);
    }

    public static /* synthetic */ void c(AppInfo r10, ItemHorizontalLargeView r11, View r12) {
        e(r10, r11, r12);
    }

    public static final void e(AppInfo r10, ItemHorizontalLargeView r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "$appInfo");
        kotlin.jvm.internal.q.g(r11, "this$0");
        Bundle r13 = new Bundle();
        r13.putString(NetKey.PAGE_SOURCE, "other_page");
        r13.putString("pkg_name", r10.appPackageName);
        f9.b.b("click_install_pages_detail", r13);
        Context r14 = r11.getContext();
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type android.app.Activity");
        l8.a.a((Activity) r14, r12, r10, r11.f9127f);
    }

    public static final void f(ItemHorizontalLargeView r10, CommonAppEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r10.f9126e == false) goto L9;
        r11.setCheckState(!r11.getCheckState());
        r10.f9128g.f25822d.setChecked(r11.getCheckState());
        Function2 r13 = r10.f9123b;
        if (r13 == null) goto L12;
        r13.mo0invoke(r10, r11);
        return;
    L12:
        return;
    L9:
        if (r10.f9125d == false) goto L13;
        AppDetailFragment.a r14 = AppDetailFragment.f8472z;
        String r15 = r11.getPkg();
        kotlin.jvm.internal.q.f(r15, "getPkg(...)");
        String r16 = r11.getSource();
        kotlin.jvm.internal.q.f(r16, "getSource(...)");
        i7.a.e(r10, AppDetailFragment.a.b(r14, r15, r16, false, 0, r10.f9127f, 12, null));
        AdsReportManager.h().r(r11.getName(), r11.getClick());
        return;
    }

    public static final boolean g(ItemHorizontalLargeView r10, CommonAppEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Function2 r13 = r10.f9122a;
        if (r13 == null) goto L7;
        r13.mo0invoke(r10, r11);
        return true;
    L7:
        return true;
    }

    public final void d(final CommonAppEntity r10, int r11) {
        if (r10 == null) goto L56;
        String r12 = r10.getName();
        if (r12 == null) goto L56;
        if (kotlin.text.o.r(r12) == true) goto L56;
        String r13 = r10.getPkg();
        if (r13 == null) goto L56;
        if (kotlin.text.o.r(r13) == true) goto L56;
        setVisibility(0);
        if (this.f9126e == false) goto L17;
        this.f9128g.f25822d.setChecked(r10.getCheckState());
        this.f9128g.f25822d.setVisibility(0);
    L19:
        if (r11 < 0) goto L21;
        this.f9128g.f25825g.setText(String.valueOf(r11 + 1));
        this.f9128g.f25825g.setVisibility(0);
    L22:
        ImageView r14 = this.f9128g.f25823e;
        kotlin.jvm.internal.q.f(r14, "ivIcon");
        Object r15 = r10.getLogo();
        if (r15 != null) goto L25;
        r15 = Integer.valueOf(R.drawable.default_app_icon_normal);
    L25:
        ImageUtilKt.k(r14, r15, 0, 2, null);
        this.f9128g.f25831m.setText(r10.getName());
        this.f9128g.f25828j.setText(r10.getCategory());
        List<Integer> r16 = r10.getLabel();
        if (r16 == null) goto L28;
        int r17 = r16.size();
    L29:
        if (r16 != null) goto L31;
    L38:
        this.f9128g.f25829k.setVisibility(8);
        this.f9128g.f25830l.setVisibility(8);
    L39:
        String r18 = r10.getRecmd_brief();
        if (r18 != null) goto L42;
    L45:
        int r19 = com.bytedanceos.common.toolbox.e.b0(BaseApplication.c(), r10.getScores(), false);
        if (this.f9124c == true) goto L50;
        if (r19 <= 0) goto L50;
        this.f9128g.f25824f.setImageResource(r19);
        this.f9128g.f25827i.setVisibility(4);
        this.f9128g.f25824f.setVisibility(0);
    L51:
        final AppInfo r20 = r10.convertAppInfo();
        kotlin.jvm.internal.q.f(r20, "convertAppInfo(...)");
        this.f9128g.f25821c.showAppSize();
        this.f9128g.f25821c.updateDownloadStatus(r20);
        this.f9128g.f25821c.setOnClickListener(new g(r20, this));
        setOnClickListener(new h(this, r10));
        if (this.f9122a == null) goto L54;
        setOnLongClickListener(new i(this, r10));
    L54:
        AdsReportManager.h().s(r10.getName(), r10.getImpression());
        return;
    L50:
        this.f9128g.f25827i.setText(getContext().getString(R.string.no_comment));
        this.f9128g.f25827i.setVisibility(0);
        this.f9128g.f25824f.setVisibility(8);
        goto L51
    L42:
        if (kotlin.text.o.r(r18) == true) goto L45;
        this.f9128g.f25827i.setText(r18);
        this.f9128g.f25827i.setVisibility(0);
        this.f9128g.f25824f.setVisibility(8);
        goto L51
    L31:
        if (r16.isEmpty() == true) goto L38;
        if (r17 <= 1) goto L35;
        Integer r21 = r16.get(0);
        Integer r22 = r16.get(1);
        TextView r23 = this.f9128g.f25829k;
        kotlin.jvm.internal.q.d(r21);
        com.bytedanceos.common.toolbox.e.A1(r23, r21.intValue());
        TextView r24 = this.f9128g.f25830l;
        kotlin.jvm.internal.q.d(r22);
        com.bytedanceos.common.toolbox.e.A1(r24, r22.intValue());
        this.f9128g.f25829k.setVisibility(0);
        this.f9128g.f25830l.setVisibility(0);
        goto L39
    L35:
        if (r17 <= 0) goto L37;
        Integer r25 = r16.get(0);
        TextView r26 = this.f9128g.f25829k;
        kotlin.jvm.internal.q.d(r25);
        com.bytedanceos.common.toolbox.e.A1(r26, r25.intValue());
        this.f9128g.f25829k.setVisibility(0);
        this.f9128g.f25830l.setVisibility(8);
        goto L39
    L37:
        this.f9128g.f25829k.setVisibility(8);
        this.f9128g.f25830l.setVisibility(8);
        goto L39
    L28:
        r17 = 0;
        goto L29
    L21:
        this.f9128g.f25825g.setVisibility(8);
        goto L22
    L17:
        r10.setCheckState(false);
        this.f9128g.f25822d.setVisibility(8);
    L56:
        setVisibility(8);
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getAppOnLongClickListener() {
        return this.f9122a;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getEditAppOnClickListener() {
        return this.f9123b;
    }

    public final boolean getEditState() {
        return this.f9126e;
    }

    public final boolean getItemCanClick() {
        return this.f9125d;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9127f;
    }

    public final boolean getShowNoBrief() {
        return this.f9124c;
    }

    public final void setAppOnLongClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9122a = r10;
    }

    public final void setEditAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9123b = r10;
    }

    public final void setEditState(boolean r10) {
        this.f9126e = r10;
    }

    public final void setItemCanClick(boolean r10) {
        this.f9125d = r10;
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9127f = r10;
    }

    public final void setShowNoBrief(boolean r10) {
        this.f9124c = r10;
    }

    public ItemHorizontalLargeView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9125d = true;
        this.f9127f = "";
        z0 r12 = z0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9128g = r12;
        ViewGroup.LayoutParams r13 = r12.f25823e.getLayoutParams();
        r13.width = com.bytedanceos.appstore.buss.utilities.g.b(120);
        ViewGroup.LayoutParams r14 = r12.f25823e.getLayoutParams();
        r14.height = com.bytedanceos.appstore.buss.utilities.g.b(57);
    }
}
