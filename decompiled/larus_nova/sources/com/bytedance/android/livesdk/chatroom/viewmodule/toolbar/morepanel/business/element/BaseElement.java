package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lp1.b;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseElement<ElementModel extends lp1.b<Object>> implements kp1.b<ElementModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f116543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<View, ViewGroup, Unit> f116544b;

    public View j(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    public abstract Integer k();

    public abstract void l(View r100);

    @Override // kp1.b
    public final View e() {
        return this.f116543a;
    }

    public BaseElement(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f116544b = new BaseElement$doOnAttachToParent$1(this);
    }

    @Override // kp1.b
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = this.f116543a;
        if (r101 == null) goto L5;
        this.f116544b.invoke(r101, r100);
    L19:
        if (r101 != null) goto L24;
        View r102 = j(r100);
        if (r102 == null) goto L25;
        this.f116544b.invoke(r102, r100);
        return r102;
    L25:
        return null;
    L24:
        return r101;
    L5:
        Integer r103 = k();
        if (r103 == null) goto L18;
        int r104 = r103.intValue();
        Function2<View, ViewGroup, Unit> r105 = this.f116544b;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Integer r106 = Integer.valueOf(r104);
        if (r106.intValue() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L18;
        r106.intValue();
        r101 = LayoutInflater.from(r100.getContext()).inflate(r104, r100, false);
        if (r105 == null) goto L19;
        Unit r108 = r105.invoke(r101, r100);
        goto L19
    L10:
        r107 = false;
    L18:
        r101 = null;
        goto L19
    }
}
