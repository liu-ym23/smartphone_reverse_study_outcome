package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class x0 extends a<IBaseUser> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153348c;

    public x0() {
        this.f153348c = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        J(r100, null);
    }

    public final void J(Map<String, String> r100, IBaseUser r101) {
        super.u(r100, r101);
        if (r101 != null) goto L5;
    L7:
        r100.put("user_id", this.f153348c);
        return;
    L5:
        if (TextUtils.isEmpty(r101.getIdString()) == true) goto L7;
        this.f153348c = r101.getIdString();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void u(Map r100, Object r101) {
        J(r100, (IBaseUser) r101);
    }
}
