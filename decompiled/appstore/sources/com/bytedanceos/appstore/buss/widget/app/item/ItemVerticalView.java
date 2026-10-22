package com.bytedanceos.appstore.buss.widget.app.item;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.fragment.AppDetailFragment;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.h1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemVerticalView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "", "a", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Lx7/h1;", "b", "Lx7/h1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemVerticalView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h1 f9157b;

    public /* synthetic */ ItemVerticalView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemVerticalView r10, CommonAppEntity r11, View r12) {
        d(r10, r11, r12);
    }

    public static /* synthetic */ void b(ItemVerticalView r10, AppInfo r11, View r12) {
        c(r10, r11, r12);
    }

    public static final void c(ItemVerticalView r10, AppInfo r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$appInfo");
        Context r13 = r10.getContext();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type android.app.Activity");
        l8.a.a((Activity) r13, r12, r11, r10.f9156a);
        Bundle r14 = new Bundle();
        r14.putString(NetKey.PAGE_SOURCE, "other_page");
        r14.putString("pkg_name", r11.appPackageName);
        f9.b.b("click_install_pages_detail", r14);
    }

    public static final void d(ItemVerticalView r10, CommonAppEntity r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppDetailFragment.a r13 = AppDetailFragment.f8472z;
        String r14 = r11.getPkg();
        kotlin.jvm.internal.q.f(r14, "getPkg(...)");
        String r15 = r11.getSource();
        kotlin.jvm.internal.q.f(r15, "getSource(...)");
        i7.a.e(r10, AppDetailFragment.a.b(r13, r14, r15, false, 0, r10.f9156a, 12, null));
        AdsReportManager.h().r(r11.getName(), r11.getClick());
    }

    @Nullable
    public final String getPageSource() {
        return this.f9156a;
    }

    public final void setNewData(@Nullable final CommonAppEntity r10) {
        if (r10 == null) goto L15;
        String r11 = r10.getName();
        if (r11 == null) goto L15;
        if (kotlin.text.o.r(r11) == true) goto L15;
        String r12 = r10.getPkg();
        if (r12 == null) goto L15;
        if (kotlin.text.o.r(r12) == true) goto L15;
        setVisibility(0);
        this.f9157b.f25589d.setText(r10.getName());
        ImageView r13 = this.f9157b.f25588c;
        kotlin.jvm.internal.q.f(r13, "ivIcon");
        ImageUtilKt.g(r13, r10.getLogo(), R.dimen.dp_14, 0, 4, null);
        final AppInfo r14 = r10.convertAppInfo();
        kotlin.jvm.internal.q.f(r14, "convertAppInfo(...)");
        this.f9157b.f25587b.showAppSize();
        this.f9157b.f25587b.updateDownloadStatus(r14);
        this.f9157b.f25587b.setOnClickListener(new s(this, r14));
        setOnClickListener(new t(this, r10));
        AdsReportManager.h().s(r10.getName(), r10.getImpression());
        return;
    L15:
        setVisibility(8);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9156a = r10;
    }

    public ItemVerticalView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9156a = "";
        h1 r12 = h1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9157b = r12;
    }
}
