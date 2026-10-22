package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.shopping.store.tabkit.model.x;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/BaseTabItemView;", "Landroid/widget/FrameLayout;", "", "update", "", "selected", "setSelected", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "setTab", "(Lcom/bytedance/android/shopping/store/tabkit/model/k;)V", "tab", "b", "Z", "isFullScreenState", "()Z", "setFullScreenState", "(Z)V", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "c", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "getTabBarStyleConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/p;", "setTabBarStyleConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/p;)V", "tabBarStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/w;", "getTabStyle", "()Lcom/bytedance/android/shopping/store/tabkit/model/w;", "tabStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/o;", "getTabBarStyle", "()Lcom/bytedance/android/shopping/store/tabkit/model/o;", "tabBarStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/x;", "getTabStyleConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/x;", "tabStyleConfig", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTabItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f186860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f186861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f186862c;

    public BaseTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public void a(boolean r100, boolean r101) {
    }

    public final x getTabStyleConfig() {
        if (this.f186861b == false) goto L7;
        k r100 = this.f186860a;
        if (r100 != null) goto L17;
        return null;
    L17:
        return r100.o();
    L7:
        k r101 = this.f186860a;
        if (r101 == null) goto L13;
        x r102 = r101.j();
        if (r102 == null) goto L13;
        return r102;
    L13:
        r100 = this.f186860a;
        if (r100 != null) goto L17;
        return null;
    }

    public final o getTabBarStyle() {
        if (isSelected() == false) goto L7;
        p r100 = this.f186862c;
        if (r100 != null) goto L17;
        return null;
    L17:
        return r100.i();
    L7:
        p r101 = this.f186862c;
        if (r101 == null) goto L13;
        o r102 = r101.g();
        if (r102 == null) goto L13;
        return r102;
    L13:
        r100 = this.f186862c;
        if (r100 != null) goto L17;
        return null;
    }

    public final w getTabStyle() {
        if (isSelected() == false) goto L7;
        x r100 = getTabStyleConfig();
        if (r100 != null) goto L17;
        return null;
    L17:
        return r100.c();
    L7:
        x r101 = getTabStyleConfig();
        if (r101 == null) goto L13;
        w r102 = r101.b();
        if (r102 == null) goto L13;
        return r102;
    L13:
        r100 = getTabStyleConfig();
        if (r100 != null) goto L17;
        return null;
    }

    public final void update() {
        a(isSelected(), false);
    }

    public final k getTab() {
        return this.f186860a;
    }

    public final p getTabBarStyleConfig() {
        return this.f186862c;
    }

    public final void setFullScreenState(boolean r100) {
        if (this.f186861b == r100) goto L6;
        this.f186861b = r100;
        update();
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        b(r100, false);
    }

    public final void setTab(k r100) {
        if ((!Intrinsics.areEqual(this.f186860a, r100)) == false) goto L6;
        this.f186860a = r100;
        update();
        return;
    }

    public final void setTabBarStyleConfig(p r100) {
        if ((!Intrinsics.areEqual(this.f186862c, r100)) == false) goto L6;
        this.f186862c = r100;
        update();
        return;
    }

    public final void b(boolean r100, boolean r101) {
        if (isSelected() == r100) goto L5;
        boolean r102 = true;
    L6:
        super.setSelected(r100);
        if (r102 == true) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        a(r100, r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public BaseTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186861b = true;
        setClipToPadding(false);
        setClipChildren(false);
    }

    public /* synthetic */ BaseTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
