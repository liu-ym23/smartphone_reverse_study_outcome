package com.bytedance.android.btm.api.model;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.btm.api.BtmPage;
import com.bytedance.android.btm.api.BtmSDK;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J'\u0010\u000e\u001a\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\r\"\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u000e\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0007J\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0007J\u0014\u0010\u0014\u001a\u00020\u00002\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0007J\u001c\u0010\u001a\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0007J&\u0010\u001f\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\tH\u0007J\b\u0010!\u001a\u00020\u0000H\u0007J\b\u0010#\u001a\u00020\"H\u0007J\b\u0010$\u001a\u00020\tH\u0007J\b\u0010%\u001a\u00020\tH\u0007J\b\u0010'\u001a\u00020&H\u0007J\b\u0010(\u001a\u00020\u0015H\u0007R\u0014\u0010)\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "", "", "value", "setAddBtmChain", "", "setBtmChainLength", "setUseTopPageWhenNotFindPage", "setEnterPage", "", "key", "internalSetUnitParams", "setEnterPageTimes", "", "setTargetPagesBtm", "([Ljava/lang/String;)Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "", "pages", "Landroid/view/View;", "withView", "withBtmPage", "Lcom/bytedance/android/btm/api/model/PageFinder;", "withPageFinder", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "curPosition", "withViewPager", "Lcom/bytedance/android/btm/api/j;", "getFragmentListener", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "withGetFragmentListener", "btm", "copy", "Lcom/bytedance/android/btm/api/model/c;", "build", "createBtmId", "obtainEventBtmParams", "", "willJumpToNextPage", "getPageFinder", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/btm/api/model/c;", "enterPage", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BtmItemBuilder {
    private final c item;

    /* JADX WARN: Multi-variable type inference failed */
    public BtmItemBuilder() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final c build() {
        BtmSDK r100 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.inner.g r101 = r100.getService().getMonitor();
        boolean r102 = true;
        if (this.item.f42011a.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        r101.b(r103, AnonymousClass1.INSTANCE);
        com.bytedance.android.btm.api.inner.g r104 = r100.getService().getMonitor();
        if (this.item.f42015e.isEmpty() == false) goto L11;
        c r105 = this.item;
        if (r105.f42016f != null) goto L11;
        r105.getClass();
        r102 = false;
    L11:
        r104.b(r102, AnonymousClass2.INSTANCE);
        return this.item;
    L5:
        r103 = false;
        goto L6
    }

    public final BtmItemBuilder copy() {
        return copy(this.item.f42011a);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "obtainEventBtmParams || willJumpToNextPage", imports = {}))
    public final String createBtmId() {
        return BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final PageFinder getPageFinder() {
        return this.item.f42015e;
    }

    public final String obtainEventBtmParams() {
        c r100 = this.item;
        r100.f42012b = Boolean.FALSE;
        return BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final void willJumpToNextPage() {
        c r100 = this.item;
        r100.f42012b = Boolean.TRUE;
        BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final BtmItemBuilder copy(String r100) {
        BtmItemBuilder r101 = new BtmItemBuilder(r100, this.item.f42012b).setEnterPageTimes(this.item.f42013c);
        c r102 = this.item;
        ViewPager r103 = r102.f42016f;
        if (r103 == null) goto L5;
        r101.withViewPager(r103, r102.f42017g);
    L5:
        this.item.getClass();
        c r104 = r101.item;
        c r105 = this.item;
        r104.f42015e = r105.f42015e;
        r104.f42020j = r105.f42020j;
        r104.f42021k = r105.f42021k;
        return r101;
    }

    public final BtmItemBuilder setAddBtmChain(boolean r100) {
        this.item.f42018h = r100;
        return this;
    }

    public final BtmItemBuilder setBtmChainLength(int r100) {
        this.item.f42019i = r100;
        return this;
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "createJumpSourceBtmToken / createReportParams", imports = {}))
    public final BtmItemBuilder setEnterPage(boolean r100) {
        c r101 = this.item;
        r101.f42012b = Boolean.valueOf(r100);
        return this;
    }

    public final BtmItemBuilder setEnterPageTimes(int r100) {
        this.item.f42013c = r100;
        return this;
    }

    public final BtmItemBuilder setTargetPagesBtm(String... r100) {
        ((ArrayList) this.item.f42014d).clear();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
        ((ArrayList) this.item.f42014d).add(r103);
    L13:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L14:
        return this;
    }

    public final BtmItemBuilder setUseTopPageWhenNotFindPage(boolean r100) {
        this.item.f42021k = r100;
        return this;
    }

    public final BtmItemBuilder withBtmPage(@BtmPage final Object r100) {
        com.bytedance.android.btm.api.inner.g r101 = BtmSDK.INSTANCE.getService().getMonitor();
        if (cd.b.a(r100) == null) goto L5;
        boolean r102 = true;
    L6:
        r101.b(r102, new C97871(r100));
        this.item.f42015e.page = r100;
        return this;
    L5:
        r102 = false;
        goto L6
    }

    public final BtmItemBuilder withPageFinder(PageFinder r100) {
        if (r100 == null) goto L4;
        this.item.f42015e = r100;
    L4:
        return this;
    }

    public final BtmItemBuilder withView(View r100) {
        this.item.f42015e.view = r100;
        return this;
    }

    public final BtmItemBuilder setTargetPagesBtm(List<String> r100) {
        ((ArrayList) this.item.f42014d).clear();
        ArrayList r101 = (ArrayList) this.item.f42014d;
        r101.addAll(r100);
        return this;
    }

    public BtmItemBuilder(String r100, Boolean r101) {
        c r102 = new c();
        this.item = r102;
        r102.f42011a = r100;
        r102.f42012b = r101;
    }

    public final BtmItemBuilder internalSetUnitParams(String r100, Object r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        if (r101 == null) goto L12;
        this.item.f42020j.put(r100, r101);
    L12:
        return this;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public final BtmItemBuilder withViewPager(ViewPager r100, int r101) {
        c r102 = this.item;
        r102.f42016f = r100;
        r102.f42017g = r101;
        return this;
    }

    public final BtmItemBuilder withGetFragmentListener(com.bytedance.android.btm.api.j r100, int r101, FragmentManager r102) {
        this.item.getClass();
        this.item.f42017g = r101;
        return this;
    }

    public /* synthetic */ BtmItemBuilder(String r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ BtmItemBuilder withViewPager$default(BtmItemBuilder r100, ViewPager r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = -1;
    L6:
        return r100.withViewPager(r101, r102);
    }

    public static /* synthetic */ BtmItemBuilder withGetFragmentListener$default(BtmItemBuilder r100, com.bytedance.android.btm.api.j r101, int r102, FragmentManager r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = -1;
    L6:
        return r100.withGetFragmentListener(r101, r102, r103);
    }
}
