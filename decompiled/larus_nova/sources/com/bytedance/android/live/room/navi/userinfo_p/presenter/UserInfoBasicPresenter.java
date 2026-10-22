package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.view.ViewGroup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoBasicPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoBasicPresenter extends BaseElementPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f100072f;

    public static final class a {
    }

    static {
    }

    public UserInfoBasicPresenter(m91.c r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfoWidgetAbility");
        Intrinsics.checkNotNullParameter(r101, "anchorInfoContainer");
        super(r100);
        this.f100072f = r101;
    }
}
