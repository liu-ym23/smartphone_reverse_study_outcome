package com.stepos.policy.sdk.dialog;

import android.view.View;
import com.stepos.common.widget.Switch;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12147a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Switch f12148b;

    public /* synthetic */ a(Switch r12, int i4) {
        this.f12147a = i4;
        this.f12148b = r12;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f12147a;
        Switch r12 = this.f12148b;
        switch (i4) {
            case 0:
                r12.toggle();
                break;
            default:
                r12.toggle();
                break;
        }
    }
}
