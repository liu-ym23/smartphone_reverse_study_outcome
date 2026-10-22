package aq1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.VSRoomLandscapeResetPlayerViewWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends n<d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f15879c = null;

    public static final class a {
        public a() {
        }

        public static boolean a(DataCenter r100) {
            if (PadConfigUtils.c() == true) goto L17;
            IRoom r101 = null;
            u r102 = r.u(r100, null, 2);
            if (r102 == null) goto L8;
            r101 = r102.k2();
        L8:
            if (r101 == null) goto L17;
            if (r101.isVsLive() != true) goto L17;
            IRoomAuthStatus r103 = r101.getRoomAuthStatus();
            if (r103 == null) goto L17;
            if (r103.getVideoAmplificationType() != 1) goto L17;
            boolean r104 = true;
        L18:
            if (r104 == true) goto L21;
            return false;
        L21:
            if (gb2.a.c(r100, true) == true) goto L26;
            if (r100 == null) goto L26;
            if (h.c(r100) != true) goto L26;
            return true;
        L26:
            return false;
        L17:
            r104 = false;
            goto L18
        }
    }

    @Override // j70.o
    public final boolean h() {
        return true;
    }

    static {
        f15879c = new a();
    }

    public c() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return VSRoomLandscapeResetPlayerViewWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        a r102 = f15879c;
        DataCenter r103 = r101.f467480h;
        r102.getClass();
        return a.a(r103);
    }

    @Override // j70.d
    public final f C(h70.b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d.a.f467581t2;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((d) r100, "layerContext");
        return LayerIndex.INDEX_4;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        ElementConstraint r102 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r103 = ElementConstraint.Side.LEFT;
        r101.f467478f.getClass();
        f r104 = d.a.D;
        ElementConstraint.Side r105 = ElementConstraint.Side.RIGHT;
        r102.b(r103, r104, r105, 0.0f);
        ElementConstraint.Side r106 = ElementConstraint.Side.BOTTOM;
        r101.f467478f.getClass();
        r102.b(r106, d.a.f467510f1, r106, 17.0f);
        r101.f467478f.getClass();
        r102.b(r105, d.a.f467608z, r103, 0.0f);
        return r102;
    }
}
