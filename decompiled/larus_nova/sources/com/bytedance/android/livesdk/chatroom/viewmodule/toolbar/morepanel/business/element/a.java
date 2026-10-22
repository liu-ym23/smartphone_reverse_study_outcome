package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends SingleLineScrollElement {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ElementType f116550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f116551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f116552h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116550f;
    }

    public a(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116550f = ElementType.Basic;
        this.f116551g = UtilityKotlinExtentionsKt.i(40);
        this.f116552h = UtilityKotlinExtentionsKt.i(16);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "elementView");
        super.l(r100);
        View r101 = this.f116543a;
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r103 = null;
    L9:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r104 == null) goto L28;
        int r105 = r104.bottomMargin;
        int r106 = this.f116551g;
        boolean r107 = false;
        if (r105 == r106) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        ViewGroup.MarginLayoutParams r109 = r104;
    L18:
        if (r109 == null) goto L20;
        r109.bottomMargin = r106;
    L20:
        int r110 = r104.topMargin;
        int r111 = this.f116552h;
        if (r110 == r111) goto L23;
        r107 = true;
    L23:
        if (r107 == false) goto L25;
        r102 = r104;
    L25:
        if (r102 == null) goto L29;
        r102.topMargin = r111;
        return;
    L29:
        return;
    L17:
        r109 = null;
        goto L18
    L14:
        r108 = false;
        goto L15
    L28:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
