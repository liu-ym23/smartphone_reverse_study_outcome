package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/PersonalMvListVh;", "Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PersonalMvListVh extends SoloMvListVh {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f70777j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f70778k = 0;

    public static final class a {
    }

    static {
        f70777j = s1.f(82.0f);
        f70778k = s1.f(110.0f);
    }

    public PersonalMvListVh(View r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "adapterClickCb");
        super(r100, r101);
        ((ViewGroup) r100).addView(this.f70792d, new ViewGroup.LayoutParams(-1, -1));
    }
}
