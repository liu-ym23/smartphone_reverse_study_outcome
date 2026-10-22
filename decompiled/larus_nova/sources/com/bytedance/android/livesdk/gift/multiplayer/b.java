package com.bytedance.android.livesdk.gift.multiplayer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final void a(View r100, float r101, float r102, DataSource.ScaleType r103) {
        Intrinsics.checkNotNullParameter(r100, "alphaView");
        if (r100.getParent() != null) goto L5;
        return;
    L5:
        if ((r100.getParent() instanceof FrameLayout) == false) goto L51;
        ViewParent r104 = r100.getParent();
        if (r104 == null) goto L49;
        FrameLayout r105 = (FrameLayout) r104;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L47;
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        int r108 = s1.y();
        int r109 = s1.w();
        float r110 = r102 / r101;
        if (r103 == null) goto L23;
        int r111 = a.f126456a[r103.ordinal()];
        if (r111 == 1) goto L28;
        if (r111 != 2) goto L18;
        r107.width = r108;
        r107.height = (int) (r108 * r110);
        r107.gravity = 48;
    L34:
        if (((wh6.a) vh6.c.b(wh6.a.class)).getCurrentActivity() != null) goto L36;
    L44:
        r105.setLayoutParams(r107);
        return;
    L36:
        if ((r105 instanceof EdgeTransparentView) == false) goto L44;
        if (PadConfigUtils.c() == false) goto L44;
        float r112 = r108;
        if (r108 <= r109) goto L42;
        float r113 = 0.3f;
    L43:
        float r114 = (int) (r112 * r113);
        float r115 = r114 * 0.12f;
        int r116 = (int) ((2 * r115) + r114);
        float r117 = r114 * r110;
        ((EdgeTransparentView) r105).a(15, r115);
        r107.width = r116;
        r107.height = (int) (r117 + (0.12f * r117));
        r107.gravity = 81;
        goto L44
    L42:
        r113 = 0.5f;
        goto L43
    L18:
        if (r111 != 3) goto L20;
        r107.width = r108;
        r107.height = (int) (r108 * r110);
        r107.gravity = 80;
        goto L34
    L20:
        if (r111 != 4) goto L22;
        r107.height = r109;
        r107.width = (int) (r109 / r110);
        r107.gravity = GravityCompat.START;
        goto L34
    L22:
        if (r111 != 5) goto L23;
        r107.height = r109;
        r107.width = (int) (r109 / r110);
        r107.gravity = GravityCompat.END;
        goto L34
    L28:
        float r118 = r109;
        float r119 = r108 * r110;
        if (r118 <= r119) goto L31;
        r107.width = r108;
        r107.height = (int) r119;
    L32:
        r107.gravity = 17;
        goto L34
    L31:
        r107.height = r109;
        r107.width = (int) (r118 / r110);
    L23:
        r107.width = -1;
        r107.height = -1;
        r107.gravity = 17;
        goto L34
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public static final void b(float r100, float r101, float r102, float r103, DataSource.ScaleType r104, IPlayerActionListener r110) {
        float r105 = r100 / r101;
        float r106 = r102 / r103;
        if (r104 == DataSource.ScaleType.ScaleAspectFill) goto L17;
        if (r104 == DataSource.ScaleType.TopFill) goto L17;
        if (r104 == DataSource.ScaleType.BottomFill) goto L17;
        if (r104 == DataSource.ScaleType.RightFill) goto L17;
        if (r104 == DataSource.ScaleType.LeftFill) goto L17;
        if (r105 > r106) goto L19;
    L18:
        float r107 = r100 / r106;
        float r108 = r100;
    L20:
        float r109 = 0.0f;
        if (r104 != null) goto L24;
    L55:
        r100 = r108;
        r101 = r107;
    L56:
        float r111 = 0.0f;
    L57:
        if (r110 == null) goto L60;
        r110.updateTextEffectPosition(r100, r101, r109, r111);
        return;
    L60:
        return;
    L24:
        switch(a.f126457b[r104.ordinal()]) {
            case 1: goto L56;
            case 2: goto L48;
            case 3: goto L45;
            case 4: goto L42;
            case 5: goto L39;
            case 6: goto L35;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            default: goto L55;
        };
    L26:
        float r112 = r106 * r101;
        r109 = r100 - r112;
        r100 = r112;
        goto L56
    L27:
        r100 = r101 * r106;
        goto L56
    L28:
        float r113 = r100 / r106;
        r111 = r101 - r113;
        r101 = r113;
        goto L57
    L29:
        r101 = r100 / r106;
        goto L56
    L31:
        if (r105 <= r106) goto L33;
        float r114 = r100 - r108;
    L53:
        float r115 = r114 / 2;
    L54:
        r109 = r115;
        goto L55
    L33:
        r111 = (r101 - r107) / 2;
    L51:
        r100 = r108;
        r101 = r107;
        goto L57
    L35:
        if (r105 > r106) goto L49;
        r115 = -(r108 - r100);
    L49:
        float r116 = (-(r107 - r101)) / 2;
    L50:
        r111 = r116;
        goto L51
    L39:
        if (r105 <= r106) goto L55;
    L42:
        if (r105 <= r106) goto L52;
        r116 = -(r107 - r101);
    L52:
        r114 = -(r108 - r100);
        goto L53
    L45:
        if (r105 <= r106) goto L52;
    L48:
        if (r105 <= r106) goto L52;
    L19:
        r108 = r101 * r106;
        r107 = r101;
    L17:
        if (r105 <= r106) goto L19;
        goto L18
    }
}
