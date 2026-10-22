package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f157719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f157720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IExternalButton f157721d;

    public f(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        super(r100);
        this.f157721d = r100;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        View r102 = this.f157719b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L6:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        this.f157721d.onViewWillDetach();
        ((ViewGroup) r102).removeAllViews();
        r102.post(new e(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f157719b = r100;
        this.f157720c = r101;
        this.f157721d.onLoad();
        View r102 = this.f157719b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L6:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r102).setClipChildren(false);
        View r103 = this.f157721d.getView();
        this.f157721d.onViewWillAttach(l.a(r102));
        ((ViewGroup) r102).addView(r103);
        r102.post(new d(this, r102));
        return;
    }
}
