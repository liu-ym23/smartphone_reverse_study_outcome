package com.bytedanceos.appstore.buss.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.RepCreativeEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import com.bytedanceos.common.toolbox.e;
import h7.d;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSplashViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8927d;

    public AppSplashViewModel() {
        this.f8927d = kotlin.b.b(AppSplashViewModel$adLiveData$2.INSTANCE);
    }

    public static final /* synthetic */ boolean f(AppSplashViewModel r10, RepAdEntity r11) {
        return r10.g(r11);
    }

    public final boolean g(RepAdEntity r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isCreativeAvailable() == false) goto L19;
        RepCreativeEntity r11 = (RepCreativeEntity) r10.getCreative().get(0);
        if (r11 == null) goto L20;
        RepSplashMediaEntity r12 = (RepSplashMediaEntity) r11.getMedia();
        if (r12 != null) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r12.getPkg()) == false) goto L14;
    L22:
        return true;
    L14:
        if (TextUtils.isEmpty(r12.getDeeplink_url()) == false) goto L22;
        return !e.x0(r12.getPkg());
    L20:
        return false;
    L19:
        return false;
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8927d.getValue();
    }
}
