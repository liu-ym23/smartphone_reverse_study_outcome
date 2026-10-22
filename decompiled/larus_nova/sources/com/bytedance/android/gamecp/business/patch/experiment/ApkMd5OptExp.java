package com.bytedance.android.gamecp.business.patch.experiment;

import com.bytedance.ies.abmock.annotations.ABKey;
import com.bytedance.ies.abmock.annotations.Owner;
import com.bytedance.ies.abmock.annotations.Title;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
@Owner("zhangxinjian.1228")
@Title("增量更新已安装apk的md5算法优化")
@ABKey("gamecp_apk_md5_calculate_optimize")
public final class ApkMd5OptExp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f56228a = null;

    public ApkMd5OptExp() {
    }

    static {
        new ApkMd5OptExp();
        f56228a = LazyKt.lazy(ApkMd5OptExp$value$2.INSTANCE);
    }
}
