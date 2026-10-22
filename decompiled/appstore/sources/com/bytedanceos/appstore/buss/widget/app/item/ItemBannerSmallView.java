package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.fragment.TopicFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.ui.WebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.w0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\fR\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemBannerSmallView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "onAttachedToWindow", "()V", "b", "", "a", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "getRow", "setRow", "row", "", "c", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "d", "getJumpType", "setJumpType", "jumpType", "", "e", "Z", "isExpose", "()Z", "setExpose", "(Z)V", "f", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "getCurrentEntity", "()Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "setCurrentEntity", "currentEntity", "Lx7/w0;", "g", "Lx7/w0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerSmallView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonAppEntity f9109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0 f9110g;

    public /* synthetic */ ItemBannerSmallView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(CommonAppEntity r10, ItemBannerSmallView r11, View r12) {
        c(r10, r11, r12);
    }

    public static final void c(CommonAppEntity r10, ItemBannerSmallView r11, View r12) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        String r13 = r10.getName();
        String r14 = r10.getTopic_id();
        if ("2".equals(r10.getAppType()) == false) goto L7;
        if (r14 == null) goto L14;
        r11.f9107d = "type_topic";
        i7.a.e(r11, TopicFragment.a.b(TopicFragment.f8659n, r13, r14, false, 4, null));
    L14:
        Bundle r15 = new Bundle();
        r15.putString("banner_title", r13);
        r15.putString("banner_page_name", r11.f9106c);
        r15.putString("banner_jump_type", r11.f9107d);
        StringBuilder r16 = new StringBuilder();
        r16.append(r11.f9105b);
        r16.append('_');
        r16.append(r11.f9104a);
        r15.putString("banner_position", r16.toString());
        f9.b.b("click_banner", r15);
        return;
    L7:
        if ("1".equals(r10.getAppType()) == false) goto L10;
        r11.f9107d = "type_app";
        AppDetailFragment.a r17 = AppDetailFragment.f8472z;
        String r18 = r10.getPkg();
        kotlin.jvm.internal.q.f(r18, "getPkg(...)");
        i7.a.e(r11, AppDetailFragment.a.b(r17, r18, null, false, 0, r11.f9106c, 14, null));
        AdsReportManager.h().r(r10.getName(), r10.getClick());
        goto L14
    L10:
        if ("3".equals(r10.getAppType()) == false) goto L14;
        r11.f9107d = "type_webview";
        if (URLUtil.isNetworkUrl(r10.getWebUrl()) == false) goto L14;
        WebActivity.start(r11.getContext(), r10.getWebUrl(), null);
        goto L14
    }

    public final void b() {
        this.f9108e = true;
        CommonAppEntity r10 = this.f9109f;
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.getAppType();
    L7:
        if ("2".equals(r12) == false) goto L9;
        String r13 = "type_topic";
    L24:
        Bundle r14 = new Bundle();
        CommonAppEntity r15 = this.f9109f;
        if (r15 == null) goto L27;
        r11 = r15.getName();
    L27:
        r14.putString("banner_title", r11);
        r14.putString("banner_page_name", this.f9106c);
        r14.putString("banner_jump_type", r13);
        StringBuilder r16 = new StringBuilder();
        r16.append(this.f9105b);
        r16.append('_');
        r16.append(this.f9104a);
        r14.putString("banner_position", r16.toString());
        f9.b.b("exposure_banner", r14);
        return;
    L9:
        CommonAppEntity r17 = this.f9109f;
        if (r17 == null) goto L12;
        String r18 = r17.getAppType();
    L14:
        if ("1".equals(r18) == false) goto L16;
        r13 = "type_app";
        goto L24
    L16:
        CommonAppEntity r19 = this.f9109f;
        if (r19 == null) goto L19;
        String r20 = r19.getAppType();
    L21:
        if ("3".equals(r20) == false) goto L23;
        r13 = "type_webview";
        goto L24
    L23:
        r13 = null;
        goto L24
    L19:
        r20 = null;
        goto L21
    L12:
        r18 = null;
        goto L14
    L5:
        r12 = null;
        goto L7
    }

    @Nullable
    public final CommonAppEntity getCurrentEntity() {
        return this.f9109f;
    }

    @NotNull
    public final String getJumpType() {
        return this.f9107d;
    }

    @Nullable
    public final String getPageName() {
        return this.f9106c;
    }

    public final int getPosition() {
        return this.f9104a;
    }

    public final int getRow() {
        return this.f9105b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9108e == true) goto L6;
        b();
        return;
    }

    public final void setCurrentEntity(@Nullable CommonAppEntity r10) {
        this.f9109f = r10;
    }

    public final void setExpose(boolean r10) {
        this.f9108e = r10;
    }

    public final void setJumpType(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.f9107d = r10;
    }

    public final void setNewData(@Nullable final CommonAppEntity r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        this.f9109f = r10;
        setVisibility(0);
        ImageView r11 = this.f9110g.f25786b;
        kotlin.jvm.internal.q.f(r11, "ivBanner");
        ImageUtilKt.k(r11, r10.getIcon(), 0, 2, null);
        setOnClickListener(new a(r10, this));
        AdsReportManager.h().s(r10.getName(), r10.getImpression());
    }

    public final void setPageName(@Nullable String r10) {
        this.f9106c = r10;
    }

    public final void setPosition(int r10) {
        this.f9104a = r10;
    }

    public final void setRow(int r10) {
        this.f9105b = r10;
    }

    public ItemBannerSmallView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9106c = "";
        this.f9107d = "";
        w0 r12 = w0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9110g = r12;
    }
}
