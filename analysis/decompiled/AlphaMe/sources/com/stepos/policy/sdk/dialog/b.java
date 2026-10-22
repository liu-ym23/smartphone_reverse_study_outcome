package com.stepos.policy.sdk.dialog;

import K3.f;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12149a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12150b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12151c;

    public /* synthetic */ b(int i4, String str, Object obj) {
        this.f12149a = i4;
        this.f12151c = obj;
        this.f12150b = str;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        int i4 = this.f12149a;
        String str = this.f12150b;
        Object obj = this.f12151c;
        switch (i4) {
            case 0:
                ((PolicyPermissionViewHandlerImpl23) obj).lambda$addGroupItemIntl$1(str, compoundButton, z4);
                break;
            default:
                ((f) obj).f1083u.put(str, Boolean.valueOf(z4));
                break;
        }
    }
}
