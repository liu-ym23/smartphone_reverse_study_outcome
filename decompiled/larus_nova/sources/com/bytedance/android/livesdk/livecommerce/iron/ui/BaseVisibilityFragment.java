package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseVisibilityFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseVisibilityFragment extends Fragment implements View.OnAttachStateChangeListener, l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f148856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f148857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseVisibilityFragment f148858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<l> f148859g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        T90("onDetach");
        BaseVisibilityFragment r100 = this.f148858f;
        if (r100 == null) goto L5;
        r100.f148859g.remove(this);
    L5:
        super.onDetach();
        S90(false);
        this.f148858f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        T90("onPause");
        super.onPause();
        this.f148856d = false;
        S90(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        T90("onResume");
        super.onResume();
        this.f148856d = true;
        S90(true);
    }

    public BaseVisibilityFragment() {
        this.f148859g = new ArrayList();
    }

    public final void S90(boolean r100) {
        if (r100 != this.f148857e) goto L5;
        return;
    L5:
        BaseVisibilityFragment r101 = this.f148858f;
        if (r101 != null) goto L8;
        boolean r102 = this.f148856d;
    L11:
        boolean r103 = super.isVisible();
        boolean r104 = getUserVisibleHint();
        if (r102 == false) goto L16;
        if (r103 == false) goto L16;
        if (r104 == false) goto L16;
        boolean r105 = true;
    L17:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        T90(String.format("==> checkVisibility = %s  ( parent = %s, super = %s, hint = %s )", Arrays.copyOf(new Object[]{Boolean.valueOf(r105), Boolean.valueOf(r102), Boolean.valueOf(r103), Boolean.valueOf(r104)}, 4)));
        if (r105 == this.f148857e) goto L23;
        this.f148857e = r105;
        T90("==> onVisibilityChanged = " + r105);
        Iterator<l> r107 = this.f148859g.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        r107.next().qP(r105);
        goto L21
    L25:
        return;
    L23:
        return;
    L16:
        r105 = false;
        goto L17
    L8:
        if (r101 == null) goto L10;
        r102 = r101.f148857e;
        goto L11
    L10:
        r102 = false;
        goto L11
    }

    public final void T90(String r100) {
        toString();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        T90("onAttach");
        super.onAttach(r100);
        Fragment r101 = getParentFragment();
        if (r101 != null) goto L5;
    L7:
        S90(true);
        return;
    L5:
        if ((r101 instanceof BaseVisibilityFragment) == false) goto L7;
        BaseVisibilityFragment r102 = (BaseVisibilityFragment) r101;
        this.f148858f = r102;
        r102.f148859g.add(this);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        T90(WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        S90(r100);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        T90("onViewAttachedToWindow");
        S90(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        T90("onViewDetachedFromWindow");
        r100.removeOnAttachStateChangeListener(this);
        S90(false);
    }

    public void qP(boolean r100) {
        S90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        T90("setUserVisibleHint = " + r100);
        super.setUserVisibleHint(r100);
        S90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.addOnAttachStateChangeListener(this);
    }
}
