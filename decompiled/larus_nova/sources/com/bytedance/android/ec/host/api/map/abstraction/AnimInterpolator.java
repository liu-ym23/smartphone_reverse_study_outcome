package com.bytedance.android.ec.host.api.map.abstraction;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/host/api/map/abstraction/AnimInterpolator;", "", "LINEAR", "ACCELERATE", "DECELERATE", "ACCELERATE_DECELERATE", "BOUNCE", "OVERSHOOT", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimInterpolator extends Enum<AnimInterpolator> {
    public static final AnimInterpolator ACCELERATE = null;
    public static final AnimInterpolator ACCELERATE_DECELERATE = null;
    public static final AnimInterpolator BOUNCE = null;
    public static final AnimInterpolator DECELERATE = null;
    public static final AnimInterpolator LINEAR = null;
    public static final AnimInterpolator OVERSHOOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimInterpolator[] f46180a = null;

    static {
        AnimInterpolator r100 = new AnimInterpolator("LINEAR", 0);
        LINEAR = r100;
        AnimInterpolator r101 = new AnimInterpolator("ACCELERATE", 1);
        ACCELERATE = r101;
        AnimInterpolator r102 = new AnimInterpolator("DECELERATE", 2);
        DECELERATE = r102;
        AnimInterpolator r103 = new AnimInterpolator("ACCELERATE_DECELERATE", 3);
        ACCELERATE_DECELERATE = r103;
        AnimInterpolator r104 = new AnimInterpolator("BOUNCE", 4);
        BOUNCE = r104;
        AnimInterpolator r105 = new AnimInterpolator("OVERSHOOT", 5);
        OVERSHOOT = r105;
        f46180a = new AnimInterpolator[]{r100, r101, r102, r103, r104, r105};
    }

    public static AnimInterpolator valueOf(String r100) {
        return (AnimInterpolator) a.a(AnimInterpolator.class, r100);
    }

    public static AnimInterpolator[] values() {
        return (AnimInterpolator[]) f46180a.clone();
    }

    public AnimInterpolator(String r100, int r101) {
        super(r100, r101);
    }
}
