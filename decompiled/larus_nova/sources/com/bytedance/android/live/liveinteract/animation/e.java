package com.bytedance.android.live.liveinteract.animation;

import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface e {

    public static final class a {
        public static void a(EPointF r100, EPointF r101, EPointF r102) {
            Intrinsics.checkNotNullParameter(r100, "currentPoint");
            Intrinsics.checkNotNullParameter(r101, "startPoint");
            Intrinsics.checkNotNullParameter(r102, "endPoint");
        }

        public static void b(EPointF r100, EPointF r101, EPointF r102) {
            Intrinsics.checkNotNullParameter(r100, "currentPoint");
            Intrinsics.checkNotNullParameter(r101, "startPoint");
            Intrinsics.checkNotNullParameter(r102, "endPoint");
        }
    }

    void Bn(String r100);

    EPointF C7(int r100, int r101);

    boolean Ed(int r100);

    boolean K5(String r100, String r101);

    ArrayList Ka(int r100, float r101);

    EPointF Kl(int r100, int r101);

    void Mb(String r100, String r101, int r102);

    EPointF Mj(String r100);

    boolean Mk(EPointF r100, EPointF r101, EPointF r102);

    boolean Pf(int r100);

    EPointF Se(int r100, int r101, EPointF r102, EPointF r103);

    boolean W7(EPointF r100, EPointF r101);

    ArrayList dm(int r100);

    boolean ha(EPointF r100, EPointF r101, EPointF r102);

    q50.b jq();

    boolean lo(int r100);

    int ma(int r100, int r101);

    int qq(int r100);

    boolean si();

    FrameLayout vj();

    boolean wc(String r100);

    int zl(String r100);
}
