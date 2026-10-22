package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.fragment.TopicFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.ui.WebActivity;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.v0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemBannerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "", "a", "Z", "getSetTopMargin", "()Z", "setSetTopMargin", "(Z)V", "setTopMargin", "b", "getSetBottomMargin", "setSetBottomMargin", "setBottomMargin", "", "c", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "d", "getRow", "setRow", "row", "", "e", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "f", "getJumpType", "setJumpType", "jumpType", "Lx7/v0;", "g", "Lx7/v0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v0 f9117g;

    public /* synthetic */ ItemBannerView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(CommonAppEntity r10, ItemBannerView r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(CommonAppEntity r10, ItemBannerView r11, View r12) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        String r13 = r10.getName();
        String r14 = r10.getTopic_id();
        if ("2".equals(r10.getAppType()) == false) goto L7;
        if (r14 == null) goto L14;
        r11.f9116f = "type_topic";
        i7.a.e(r11, TopicFragment.a.b(TopicFragment.f8659n, r13, r14, false, 4, null));
    L14:
        Bundle r15 = new Bundle();
        r15.putString("banner_title", r13);
        r15.putString("banner_page_name", r11.f9115e);
        r15.putString("banner_jump_type", r11.f9116f);
        StringBuilder r16 = new StringBuilder();
        r16.append(r11.f9114d);
        r16.append('_');
        r16.append(r11.f9113c);
        r15.putString("banner_position", r16.toString());
        f9.b.b("click_banner", r15);
        return;
    L7:
        if ("1".equals(r10.getAppType()) == false) goto L10;
        r11.f9116f = "type_app";
        AppDetailFragment.a r17 = AppDetailFragment.f8472z;
        String r18 = r10.getPkg();
        kotlin.jvm.internal.q.f(r18, "getPkg(...)");
        i7.a.e(r11, AppDetailFragment.a.b(r17, r18, null, false, 0, r11.f9115e, 14, null));
        AdsReportManager.h().r(r10.getName(), r10.getClick());
        goto L14
    L10:
        if ("3".equals(r10.getAppType()) == false) goto L14;
        if (URLUtil.isNetworkUrl(r10.getWebUrl()) == false) goto L14;
        r11.f9116f = "type_webview";
        WebActivity.start(r11.getContext(), r10.getWebUrl(), null);
        goto L14
    }

    @NotNull
    public final String getJumpType() {
        return this.f9116f;
    }

    @Nullable
    public final String getPageName() {
        return this.f9115e;
    }

    public final int getPosition() {
        return this.f9113c;
    }

    public final int getRow() {
        return this.f9114d;
    }

    public final boolean getSetBottomMargin() {
        return this.f9112b;
    }

    public final boolean getSetTopMargin() {
        return this.f9111a;
    }

    public final void setJumpType(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.f9116f = r10;
    }

    public final void setNewData(@Nullable final CommonAppEntity r10) {
        if (r10 == null) goto L23;
        String r11 = r10.getIcon();
        if (r11 == null) goto L23;
        if (r11.length() == 0) goto L23;
        setVisibility(0);
        ImageView r12 = this.f9117g.f25775b;
        kotlin.jvm.internal.q.f(r12, "ivBanner");
        ImageUtilKt.k(r12, r10.getIcon(), 0, 2, null);
        setOnClickListener(new b(r10, this));
        if (this.f9111a == false) goto L11;
    L14:
        ViewGroup.MarginLayoutParams r13 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (this.f9111a == false) goto L18;
        r13.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
    L18:
        if (this.f9112b == false) goto L20;
        r13.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
    L20:
        setLayoutParams(r13);
    L21:
        AdsReportManager.h().s(r10.getName(), r10.getImpression());
        return;
    L11:
        if (this.f9112b == true) goto L14;
        ViewGroup.MarginLayoutParams r14 = new ViewGroup.MarginLayoutParams(-2, -2);
        r14.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_0);
        r14.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dp_0);
        setLayoutParams(r14);
    L23:
        setVisibility(8);
    }

    public final void setPageName(@Nullable String r10) {
        this.f9115e = r10;
    }

    public final void setPosition(int r10) {
        this.f9113c = r10;
    }

    public final void setRow(int r10) {
        this.f9114d = r10;
    }

    public final void setSetBottomMargin(boolean r10) {
        this.f9112b = r10;
    }

    public final void setSetTopMargin(boolean r10) {
        this.f9111a = r10;
    }

    public ItemBannerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9115e = "";
        this.f9116f = "";
        v0 r12 = v0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9117g = r12;
    }
}
