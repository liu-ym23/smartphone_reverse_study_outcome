package com.obric.appstore.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.appstore.common.core.ui.view.AppItemViewStyle;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/obric/appstore/ui/adapter/HomeCardItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/d;", "Lza/f;", "", "pageSource", "<init>", "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "f", "(Landroid/view/ViewGroup;)Lsa/d;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "d", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/f;)V", "c", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HomeCardItemProvider extends BaseListItemProvider<sa.d, za.f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11013c;

    public HomeCardItemProvider(String r10) {
        q.g(r10, "pageSource");
        this.f11013c = r10;
    }

    public static /* synthetic */ void c(sa.d r10, View r11) {
        e(r10, r11);
    }

    public static final void e(sa.d r10, View r11) {
        q.g(r10, "$this_apply");
        r10.f24572b.performClick();
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return f(r10);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        d(r10, (za.f) r11);
    }

    public void d(BaseViewHolder r10, za.f r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        final sa.d r12 = (sa.d) b(r10);
        Activity r13 = null;
        if ((r11 instanceof za.c) == false) goto L5;
        za.c r14 = (za.c) r11;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        r12.f24573c.setLoadOriginalSize(true);
        NetworkImageView r15 = r12.f24573c;
        int r16 = R.drawable.oui_default_banner;
        r15.setDefaultImageResId(r16);
        r12.f24573c.setErrorImageResId(r16);
        r12.f24573c.setImageUrl(r14.e());
        AppInfo r17 = r14.d();
        if (r17 == null) goto L16;
        r12.f24572b.p(AppItemViewStyle.LARGE_IMAGE);
        r12.f24572b.showLine(false);
        Context r18 = getContext();
        if ((r18 instanceof Activity) == false) goto L13;
        r13 = (Activity) r18;
    L13:
        if (r13 == null) goto L15;
        r17.isBanner = true;
        ItemAppProvider.a r19 = ItemAppProvider.f11017k;
        ObricAppItemView r20 = r12.f24572b;
        q.f(r20, "bottomAppItem");
        r19.d(r13, r20, r17, this.f11013c);
    L15:
        r12.f24572b.setVisibility(0);
    L16:
        r12.f24573c.setOnClickListener(new a(r12));
        return;
    L5:
        r14 = null;
        goto L6
    }

    public sa.d f(ViewGroup r10) {
        q.g(r10, "parent");
        sa.d r11 = sa.d.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        r11.f24572b.setChangeAlphaWhenPress(false);
        return r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.HOME_CARD.ordinal();
    }
}
