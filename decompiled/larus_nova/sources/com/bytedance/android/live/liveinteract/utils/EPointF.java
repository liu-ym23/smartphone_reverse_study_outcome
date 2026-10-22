package com.bytedance.android.live.liveinteract.utils;

import android.graphics.PointF;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/utils/EPointF;", "Landroid/graphics/PointF;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getType", "()I", "setType", "(I)V", "type", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EPointF extends PointF {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78623a;

    public static final class a {
    }

    static {
    }

    public EPointF() {
        this.f78623a = 0;
    }

    public final int getType() {
        return this.f78623a;
    }

    public EPointF(float r100, float r101) {
        super(r100, r101);
    }

    public EPointF(float r100, float r101, int r102) {
        super(r100, r101);
        this.f78623a = r102;
    }
}
