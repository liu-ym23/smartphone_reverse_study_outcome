package com.stepos.policy.sdk.util;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7977a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7978b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Dialog f7979c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f7980d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7981e;

    public /* synthetic */ a(Dialog dialog, View view, int i10, View view2) {
        this.f7979c = dialog;
        this.f7978b = view;
        this.f7981e = i10;
        this.f7980d = view2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        switch (this.f7977a) {
            case 0:
                PolicyDialogScrollHelper.lambda$ensureCheckboxPackAboveButtons$2(this.f7979c, this.f7978b, this.f7981e, this.f7980d);
                break;
            default:
                View view = this.f7980d;
                int i10 = this.f7981e;
                PolicyDialogScrollHelper.lambda$scheduleScrollHeightLimit$1(this.f7978b, this.f7979c, view, i10);
                break;
        }
    }

    public /* synthetic */ a(View view, Dialog dialog, View view2, int i10) {
        this.f7978b = view;
        this.f7979c = dialog;
        this.f7980d = view2;
        this.f7981e = i10;
    }
}
