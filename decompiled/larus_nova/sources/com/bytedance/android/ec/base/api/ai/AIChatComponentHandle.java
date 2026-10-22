package com.bytedance.android.ec.base.api.ai;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.d;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatComponentHandle;", "", "Landroidx/fragment/app/Fragment;", "component1", "Lxe/d;", "component2", WidgetService.PARAM_FRAGMENT, "controller", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "Lxe/d;", "getController", "()Lxe/d;", "<init>", "(Landroidx/fragment/app/Fragment;Lxe/d;)V", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatComponentHandle {
    private final d controller;
    private final Fragment fragment;

    public static /* synthetic */ AIChatComponentHandle copy$default(AIChatComponentHandle r100, Fragment r101, d r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.fragment;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.controller;
    L9:
        return r100.copy(r101, r102);
    }

    public final Fragment component1() {
        return this.fragment;
    }

    public final d component2() {
        return this.controller;
    }

    public final AIChatComponentHandle copy(Fragment r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "controller");
        return new AIChatComponentHandle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIChatComponentHandle) == false) goto L10;
        AIChatComponentHandle r101 = (AIChatComponentHandle) r100;
        if (Intrinsics.areEqual(this.fragment, r101.fragment) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.controller, r101.controller) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Fragment r100 = this.fragment;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.controller;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatComponentHandle(fragment=" + this.fragment + ", controller=" + this.controller + ")";
    }

    public final d getController() {
        return this.controller;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public AIChatComponentHandle(Fragment r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "controller");
        this.fragment = r100;
        this.controller = r101;
    }
}
