package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.r0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXNavbarContentElement;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "", "annieXContainerId", "", "setAnnieXContainerId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXNavbarContentElement extends UIGroup<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f41076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f41077b;

    public static final class a {
    }

    static {
    }

    public AnnieXNavbarContentElement(LynxContext r100) {
        super(r100);
    }

    @LynxProp(name = "annieXContainerId")
    public final void setAnnieXContainerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXContainerId");
        if (Intrinsics.areEqual(this.f41076a, r100) == true) goto L10;
        this.f41076a = r100;
        if (r100 == null) goto L11;
        e2 r101 = e2.f268044b;
        AnnieXBaseViewModel r102 = e2.a.a().a(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPageViewModel");
        r0 r103 = (r0) r102;
        if (r103.h() == null) goto L12;
        FrameLayout r104 = this.f41077b;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup{ com.bytedance.salamander.anniex.AnnieXPlatformviewKt.AnnieXPlatformRootView }");
        Intrinsics.checkNotNullParameter(r104, "view");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100, Object r101) {
        if (r100 == null) goto L4;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f41077b = r102;
        return r102;
    L4:
        return null;
    }
}
