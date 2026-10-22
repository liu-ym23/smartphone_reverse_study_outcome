package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.b f137316a;

    public k(j.b r100) {
        this.f137316a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k82.a r101 = this.f137316a.f137314n.f137299a;
        if (r101 == null) goto L5;
        VSInputSectionType r102 = r101.q();
    L7:
        if (r102 != VSInputSectionType.EMOJI) goto L11;
        k82.a r103 = this.f137316a.f137314n.f137299a;
        if (r103 == null) goto L15;
        r103.A();
        return;
    L15:
        return;
    L11:
        k82.a r104 = this.f137316a.f137314n.f137299a;
        if (r104 == null) goto L17;
        r104.z();
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
