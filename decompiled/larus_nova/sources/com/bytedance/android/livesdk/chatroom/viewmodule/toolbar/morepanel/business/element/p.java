package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends SingleLineScrollElement {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ElementType f116576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f116577g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116576f;
    }

    public p(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116576f = ElementType.Toolbar;
        this.f116577g = UtilityKotlinExtentionsKt.i(20);
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
        if (r104 == null) goto L20;
        int r105 = r104.topMargin;
        int r106 = this.f116577g;
        if (r105 == r106) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r102 = r104;
    L17:
        if (r102 == null) goto L21;
        r102.topMargin = r106;
        return;
    L21:
        return;
    L14:
        r107 = false;
        goto L15
    L20:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
