package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import android.view.View;
import com.bytedance.android.gamecp.business.gamedetail.base.model.GroupJoinStatus;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudiencePlayGroupWidget f54323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f54324b;

    public f(AudiencePlayGroupWidget r100, a r101) {
        this.f54323a = r100;
        this.f54324b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AudiencePlayGroupWidget r101 = this.f54323a;
        a r102 = this.f54324b;
        GroupJoinStatus r103 = r102.f54314h;
        String r104 = r102.f54308b;
        String r105 = r102.f54310d;
        if (r105 == null) goto L5;
        Long r106 = Long.valueOf(CastLongProtector.parseLong(r105));
    L6:
        r101.Wo(new k(r103, r104, r104, r106, this.f54324b.f54315i));
        return;
    L5:
        r106 = null;
        goto L6
    }
}
