package com.google.android.material.bottomsheet;

import android.R;
import android.content.res.TypedArray;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4717a;

    public e(h hVar) {
        this.f4717a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h hVar = this.f4717a;
        if (hVar.f4722m && hVar.isShowing()) {
            if (!hVar.f4724o) {
                TypedArray typedArrayObtainStyledAttributes = hVar.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                hVar.f4723n = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
                hVar.f4724o = true;
            }
            if (hVar.f4723n) {
                hVar.cancel();
            }
        }
    }
}
