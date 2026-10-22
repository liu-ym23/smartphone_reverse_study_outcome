package com.bytedanceos.appstore.buss.widget.app.item;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR`\u0010\u001b\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRZ\u0010 \u001a:\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR`\u0010$\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR`\u0010(\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\"\u00107\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\"\u0010;\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\"\u0010?\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010*\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010*\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemHorizontalView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "position", "", "e", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;I)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "b", "getAppOnLongClickListener", "setAppOnLongClickListener", "appOnLongClickListener", "c", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "d", "getDownloadBtnClickListener", "setDownloadBtnClickListener", "downloadBtnClickListener", "", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "f", "getShowAppSource", "setShowAppSource", "showAppSource", "g", "getItemCanClick", "setItemCanClick", "itemCanClick", "h", "getEditState", "setEditState", "editState", "i", "getSetLeftMargin", "setSetLeftMargin", "setLeftMargin", "", "j", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "k", "getOnlyShowRate", "setOnlyShowRate", "onlyShowRate", "Lx7/z0;", "l", "Lx7/z0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f9130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f9131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2 f9132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z0 f9140l;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemHorizontalView f9141a;

        public a(ItemHorizontalView r10) {
            this.f9141a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            kotlin.jvm.internal.q.g(r10, "v");
            if (ItemHorizontalView.d(this.f9141a).f25830l.getRight() <= ItemHorizontalView.d(this.f9141a).f25821c.getLeft()) goto L5;
            ItemHorizontalView.d(this.f9141a).f25830l.setVisibility(8);
        L6:
            this.f9141a.removeOnLayoutChangeListener(this);
            return;
        L5:
            ItemHorizontalView.d(this.f9141a).f25830l.setVisibility(0);
            goto L6
        }
    }

    public /* synthetic */ ItemHorizontalView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemHorizontalView r10, CommonAppEntity r11, View r12) {
        h(r10, r11, r12);
    }

    public static /* synthetic */ void b(ItemHorizontalView r10, CommonAppEntity r11, AppInfo r12, View r13) {
        g(r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean c(ItemHorizontalView r10, CommonAppEntity r11, View r12) {
        return i(r10, r11, r12);
    }

    public static final /* synthetic */ z0 d(ItemHorizontalView r10) {
        return r10.f9140l;
    }

    public static /* synthetic */ void f(ItemHorizontalView r10, CommonAppEntity r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = -1;
    L5:
        r10.e(r11, r12);
    }

    public static final void g(ItemHorizontalView r10, CommonAppEntity r11, AppInfo r12, View r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r12, "$appInfo");
        Function2 r14 = r10.f9132d;
        if (r14 == null) goto L5;
        r14.mo0invoke(r10, r11);
    L5:
        Context r15 = r10.getContext();
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type android.app.Activity");
        l8.a.a((Activity) r15, r13, r12, r10.f9138j);
        Bundle r16 = new Bundle();
        r16.putString("pkg_name", r12.appPackageName);
        if (TextUtils.isEmpty(r10.f9138j) == true) goto L8;
        r16.putString(NetKey.PAGE_SOURCE, r10.f9138j);
    L9:
        f9.b.b("click_install_pages_detail", r16);
        return;
    L8:
        r16.putString(NetKey.PAGE_SOURCE, "other_page");
        goto L9
    }

    public static final void h(ItemHorizontalView r10, CommonAppEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r10.f9136h == false) goto L9;
        r11.setCheckState(!r11.getCheckState());
        r10.f9140l.f25822d.setChecked(r11.getCheckState());
        Function2 r13 = r10.f9131c;
        if (r13 == null) goto L16;
        r13.mo0invoke(r10, r11);
        return;
    L16:
        return;
    L9:
        if (r10.f9135g == false) goto L17;
        Function2 r14 = r10.f9129a;
        if (r14 == null) goto L14;
        if (r14 == null) goto L14;
        r14.mo0invoke(r10, r11);
    L14:
        AppDetailFragment.a r15 = AppDetailFragment.f8472z;
        String r16 = r11.getPkg();
        kotlin.jvm.internal.q.f(r16, "getPkg(...)");
        String r17 = r11.getSource();
        kotlin.jvm.internal.q.f(r17, "getSource(...)");
        i7.a.e(r10, AppDetailFragment.a.b(r15, r16, r17, false, 0, r10.f9138j, 12, null));
        AdsReportManager.h().r(r11.getName(), r11.getClick());
        return;
    }

    public static final boolean i(ItemHorizontalView r10, CommonAppEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Function2 r13 = r10.f9130b;
        if (r13 == null) goto L7;
        r13.mo0invoke(r10, r11);
        return true;
    L7:
        return true;
    }

    public final void e(final CommonAppEntity r10, int r11) {
        if (r10 == null) goto L85;
        String r12 = r10.getName();
        if (r12 == null) goto L85;
        if (kotlin.text.o.r(r12) == true) goto L85;
        String r13 = r10.getPkg();
        if (r13 == null) goto L85;
        if (kotlin.text.o.r(r13) == true) goto L85;
        setVisibility(0);
        if (this.f9136h == false) goto L17;
        this.f9140l.f25822d.setChecked(r10.getCheckState());
        this.f9140l.f25822d.setVisibility(0);
    L19:
        if (r11 < 0) goto L21;
        this.f9140l.f25825g.setText(String.valueOf(r11 + 1));
        this.f9140l.f25825g.setVisibility(0);
    L22:
        ImageView r14 = this.f9140l.f25823e;
        kotlin.jvm.internal.q.f(r14, "ivIcon");
        Object r15 = r10.getLogo();
        if (r15 != null) goto L25;
        r15 = Integer.valueOf(R.drawable.default_app_icon_normal);
    L25:
        ImageUtilKt.g(r14, r15, R.dimen.dp_10, 0, 4, null);
        this.f9140l.f25831m.setText(r10.getName());
        String r16 = r10.getCategory();
        if (r16 != null) goto L28;
    L31:
        this.f9140l.f25828j.setVisibility(8);
    L33:
        if (this.f9134f == true) goto L35;
    L37:
        this.f9140l.f25820b.setVisibility(8);
    L38:
        List<Integer> r17 = r10.getLabel();
        if (r17 == null) goto L41;
        int r18 = r17.size();
    L42:
        if (r17 != null) goto L44;
    L54:
        this.f9140l.f25829k.setVisibility(8);
        this.f9140l.f25830l.setVisibility(8);
    L55:
        String r19 = r10.getRecmd_brief();
        if (r19 != null) goto L58;
    L64:
        int r110 = com.bytedanceos.common.toolbox.e.b0(BaseApplication.c(), r10.getScores(), false);
        float r20 = r10.getScores();
        if (this.f9133e == true) goto L74;
        if (r110 <= 0) goto L74;
        if (r20 <= 0.0f) goto L74;
        this.f9140l.f25824f.setImageResource(r110);
        this.f9140l.f25827i.setVisibility(4);
        this.f9140l.f25824f.setVisibility(0);
        if (this.f9139k == false) goto L77;
        this.f9140l.f25828j.setVisibility(8);
    L77:
        final AppInfo r111 = r10.convertAppInfo();
        kotlin.jvm.internal.q.f(r111, "convertAppInfo(...)");
        this.f9140l.f25821c.showAppSize();
        this.f9140l.f25821c.updateDownloadStatus(r111);
        this.f9140l.f25821c.setOnClickListener(new j(this, r10, r111));
        setOnClickListener(new k(this, r10));
        if (this.f9130b == null) goto L81;
        setOnLongClickListener(new l(this, r10));
    L81:
        if (this.f9137i == false) goto L83;
        ViewGroup.MarginLayoutParams r112 = new ViewGroup.MarginLayoutParams(-2, -2);
        r112.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
        setLayoutParams(r112);
    L83:
        AdsReportManager.h().s(r10.getName(), r10.getImpression());
        return;
    L74:
        if (this.f9139k == false) goto L76;
        this.f9140l.f25824f.setImageResource(r110);
        this.f9140l.f25827i.setVisibility(4);
        this.f9140l.f25824f.setVisibility(0);
        this.f9140l.f25828j.setVisibility(8);
        goto L77
    L76:
        this.f9140l.f25827i.setText(getContext().getString(R.string.no_comment));
        this.f9140l.f25827i.setVisibility(0);
        this.f9140l.f25824f.setVisibility(8);
        this.f9140l.f25828j.setVisibility(0);
        goto L77
    L58:
        if (kotlin.text.o.r(r19) == true) goto L64;
        if (this.f9139k == true) goto L64;
        this.f9140l.f25827i.setText(r19);
        this.f9140l.f25827i.setVisibility(0);
        this.f9140l.f25824f.setVisibility(8);
        this.f9140l.f25828j.setVisibility(0);
        goto L77
    L44:
        if (r17.isEmpty() == true) goto L54;
        if (this.f9139k == true) goto L54;
        if (r18 <= 1) goto L51;
        Integer r21 = r17.get(0);
        Integer r113 = r17.get(1);
        TextView r22 = this.f9140l.f25829k;
        kotlin.jvm.internal.q.d(r21);
        com.bytedanceos.common.toolbox.e.A1(r22, r21.intValue());
        TextView r23 = this.f9140l.f25830l;
        kotlin.jvm.internal.q.d(r113);
        com.bytedanceos.common.toolbox.e.A1(r23, r113.intValue());
        this.f9140l.f25829k.setVisibility(0);
        addOnLayoutChangeListener(new a(this));
        goto L55
    L51:
        if (r18 <= 0) goto L53;
        Integer r114 = r17.get(0);
        TextView r24 = this.f9140l.f25829k;
        kotlin.jvm.internal.q.d(r114);
        com.bytedanceos.common.toolbox.e.A1(r24, r114.intValue());
        this.f9140l.f25829k.setVisibility(0);
        this.f9140l.f25830l.setVisibility(8);
        goto L55
    L53:
        this.f9140l.f25829k.setVisibility(8);
        this.f9140l.f25830l.setVisibility(8);
        goto L55
    L41:
        r18 = 0;
        goto L42
    L35:
        if (r10.getSource().equals("yyb") == false) goto L37;
        this.f9140l.f25820b.setVisibility(0);
        goto L38
    L28:
        if (kotlin.text.o.r(r16) == true) goto L31;
        this.f9140l.f25828j.setText(r10.getCategory());
        this.f9140l.f25828j.setVisibility(0);
        goto L33
    L21:
        this.f9140l.f25825g.setVisibility(8);
        goto L22
    L17:
        r10.setCheckState(false);
        this.f9140l.f25822d.setVisibility(8);
    L85:
        setVisibility(8);
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getAppClickListener() {
        return this.f9129a;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getAppOnLongClickListener() {
        return this.f9130b;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getDownloadBtnClickListener() {
        return this.f9132d;
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getEditAppOnClickListener() {
        return this.f9131c;
    }

    public final boolean getEditState() {
        return this.f9136h;
    }

    public final boolean getItemCanClick() {
        return this.f9135g;
    }

    public final boolean getOnlyShowRate() {
        return this.f9139k;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9138j;
    }

    public final boolean getSetLeftMargin() {
        return this.f9137i;
    }

    public final boolean getShowAppSource() {
        return this.f9134f;
    }

    public final boolean getShowNoBrief() {
        return this.f9133e;
    }

    public final void setAppClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9129a = r10;
    }

    public final void setAppOnLongClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9130b = r10;
    }

    public final void setDownloadBtnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9132d = r10;
    }

    public final void setEditAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9131c = r10;
    }

    public final void setEditState(boolean r10) {
        this.f9136h = r10;
    }

    public final void setItemCanClick(boolean r10) {
        this.f9135g = r10;
    }

    public final void setOnlyShowRate(boolean r10) {
        this.f9139k = r10;
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9138j = r10;
    }

    public final void setSetLeftMargin(boolean r10) {
        this.f9137i = r10;
    }

    public final void setShowAppSource(boolean r10) {
        this.f9134f = r10;
    }

    public final void setShowNoBrief(boolean r10) {
        this.f9133e = r10;
    }

    public ItemHorizontalView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9135g = true;
        this.f9138j = "";
        z0 r12 = z0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9140l = r12;
    }
}
