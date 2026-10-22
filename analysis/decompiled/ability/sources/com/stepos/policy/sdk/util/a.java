package com.stepos.policy.sdk.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.mdisdk.action.OpenAppAction;
import m9.C1724q;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3956a = 2;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ int e;

    public /* synthetic */ a(int i, OpenAppAction openAppAction, Context context, C1724q c1724q) {
        this.e = i;
        this.c = openAppAction;
        this.b = context;
        this.d = c1724q;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        switch (this.f3956a) {
            case 0:
                PolicyDialogScrollHelper.lambda$ensureCheckboxPackAboveButtons$2((Dialog) this.c, (View) this.b, this.e, (View) this.d);
                break;
            case 1:
                PolicyDialogScrollHelper.lambda$scheduleScrollHeightLimit$1((View) this.b, (Dialog) this.c, (View) this.d, this.e);
                break;
            default:
                OpenAppAction.perform$lambda$1(this.e, (OpenAppAction) this.c, (Context) this.b, (C1724q) this.d);
                break;
        }
    }

    public /* synthetic */ a(Dialog dialog, View view, int i, View view2) {
        this.c = dialog;
        this.b = view;
        this.e = i;
        this.d = view2;
    }

    public /* synthetic */ a(View view, Dialog dialog, View view2, int i) {
        this.b = view;
        this.c = dialog;
        this.d = view2;
        this.e = i;
    }
}
