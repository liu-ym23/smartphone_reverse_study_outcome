package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ScaleType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f32494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f32495c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f32496d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f32497e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    public static final a l = null;
    private static final /* synthetic */ d[] m = null;

    /* JADX INFO: compiled from: ScaleType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(m.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    private d(String r1, int r2, int r3) {
        super(r1, r2);
    }

    static {
        d r1 = new d("ScaleToFill", 0, 0);
        f32493a = r1;
        d r2 = new d("ScaleAspectFitCenter", 1, 1);
        f32494b = r2;
        d r3 = new d("ScaleAspectFill", 2, 2);
        f32495c = r3;
        d r4 = new d("TopFill", 3, 3);
        f32496d = r4;
        d r5 = new d("BottomFill", 4, 4);
        f32497e = r5;
        d r6 = new d("LeftFill", 5, 5);
        f = r6;
        d r7 = new d("RightFill", 6, 6);
        g = r7;
        d r8 = new d("TopFit", 7, 7);
        h = r8;
        d r9 = new d("BottomFit", 8, 8);
        i = r9;
        d r10 = new d("LeftFit", 9, 9);
        j = r10;
        d r11 = new d("RightFit", 10, 10);
        k = r11;
        m = new d[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        l = new a(null);
    }
}
