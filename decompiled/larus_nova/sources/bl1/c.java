package bl1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends ReplayTetrisDescriptor<uq1.b> {
    public c() {
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.f551185l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor
    public final boolean N(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        boolean r102 = true;
        if (((Boolean) r101.invoke(2)).booleanValue() == true) goto L7;
        if (((Boolean) r101.invoke(4)).booleanValue() == true) goto L7;
    L14:
        ALogger.d("VideoPlayerTetrisDescriptor", "VideoPlayerTetrisDescriptor canLoad: " + r102);
        return r102;
    L7:
        if (((Boolean) r101.invoke(2)).booleanValue() == true) goto L9;
    L13:
        r102 = false;
        goto L14
    L9:
        if (((Boolean) r101.invoke(1)).booleanValue() == false) goto L13;
        if (((Boolean) r101.invoke(4)).booleanValue() == true) goto L13;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        uq1.b r102 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r103 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.p r104 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        if (r104.l() == false) goto L5;
        ElementConstraint r105 = new ElementConstraint(-1.0f, 0.0f);
        ElementConstraint.Side r106 = ElementConstraint.Side.TOP;
        r102.f551200d.getClass();
        r105.b(r106, uq1.a.f551189p, r106, 0.0f);
        ElementConstraint.Side r107 = ElementConstraint.Side.BOTTOM;
        r105.d(r107, r107, 0.0f);
        r105.f65829g = true;
        r105.f65830h = true;
        return r105;
    L5:
        ElementConstraint r108 = new ElementConstraint(-1.0f, 0.0f);
        ElementConstraint.Side r109 = ElementConstraint.Side.TOP;
        r102.f551200d.getClass();
        j70.g r110 = uq1.a.f551189p;
        r108.b(r109, r110, r109, 0.0f);
        ElementConstraint.Side r111 = ElementConstraint.Side.BOTTOM;
        r102.f551200d.getClass();
        r108.b(r111, r110, r111, 0.0f);
        r108.f65829g = true;
        r108.f65830h = true;
        return r108;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_5;
    }
}
