package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.feature.api.FeatureType;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import py.j;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserEvent f69294a;

    public d(UserEvent r100) {
        this.f69294a = r100;
    }

    public final void a() {
        FeatureManager r100 = FeatureManager.f69275u;
        UserEvent r101 = this.f69294a;
        Long r102 = null;
        if (r101 == null) goto L5;
        IBaseUser.Status r103 = r101.getStatus();
    L7:
        if (r103 != IBaseUser.Status.Login) goto L9;
        int r104 = 0;
    L24:
        r100.i("user_login_status", Integer.valueOf(r104), FeatureType.MONITOR);
        IBaseUser r105 = this.f69294a.getUser();
        if (r105 == null) goto L36;
        JSONObject r106 = new JSONObject().putOpt("user_gender", Integer.valueOf(r105.getGender())).putOpt("user_city", r105.getCity()).putOpt("user_location_city", r105.getLocationCity());
        j r107 = r105.getFollowInfo();
        if (r107 == null) goto L30;
        Long r108 = Long.valueOf(r107.getFollowerCount());
    L31:
        JSONObject r109 = r106.putOpt("user_fans_count", r108);
        j r110 = r105.getFollowInfo();
        if (r110 == null) goto L34;
        r102 = Long.valueOf(r110.getFollowingCount());
    L34:
        JSONObject r111 = r109.putOpt("user_follow_count", r102).putOpt("user_age_range", Integer.valueOf(r105.getAgeRange())).putOpt("user_level", Integer.valueOf(r105.getLevel())).putOpt("user_pay_scores", Long.valueOf(r105.getPayScores())).putOpt("user_secret", Integer.valueOf(r105.getSecret()));
        FeatureManager.r("user_features", r111);
        FeatureManager.f69271q.f("user_features", r111);
        return;
    L30:
        r108 = null;
        goto L31
    L36:
        return;
    L9:
        UserEvent r112 = this.f69294a;
        if (r112 == null) goto L12;
        IBaseUser.Status r113 = r112.getStatus();
    L14:
        if (r113 != IBaseUser.Status.Logout) goto L16;
        r104 = 1;
        goto L24
    L16:
        UserEvent r114 = this.f69294a;
        if (r114 == null) goto L19;
        IBaseUser.Status r115 = r114.getStatus();
    L21:
        if (r115 != IBaseUser.Status.Update) goto L23;
        r104 = 2;
        goto L24
    L23:
        r104 = -1;
        goto L24
    L19:
        r115 = null;
        goto L21
    L12:
        r113 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
