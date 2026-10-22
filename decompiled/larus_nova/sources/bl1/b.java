package bl1;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends ReplayTetrisDescriptor<uq1.b> {
    public b() {
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
        if (((Boolean) r101.invoke(4)).booleanValue() == false) goto L7;
    L14:
        ALogger.d("VideoPlayerTetrisDescriptor", "LandscapePlayerTetrisDescriptor canLoad: " + r102);
        return r102;
    L7:
        if (((Boolean) r101.invoke(2)).booleanValue() == true) goto L9;
    L13:
        r102 = false;
        goto L14
    L9:
        if (((Boolean) r101.invoke(4)).booleanValue() == true) goto L14;
        if (((Boolean) r101.invoke(1)).booleanValue() == true) goto L13;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        uq1.b r102 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        ElementConstraint r103 = new ElementConstraint(0.0f, 0.0f);
        ElementConstraint.Side r104 = ElementConstraint.Side.TOP;
        r102.f551200d.getClass();
        j70.g r105 = uq1.a.f551189p;
        r103.b(r104, r105, r104, 0.0f);
        ElementConstraint.Side r106 = ElementConstraint.Side.BOTTOM;
        r102.f551200d.getClass();
        r103.b(r106, r105, r106, 0.0f);
        ElementConstraint.Side r107 = ElementConstraint.Side.LEFT;
        r102.f551200d.getClass();
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r108 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.p r109 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        Context r110 = r102.getContext();
        r109.getClass();
        r103.b(r107, r105, r107, com.bytedance.android.livesdk.chatroom.replay.ui.p.o(r110));
        ElementConstraint.Side r111 = ElementConstraint.Side.RIGHT;
        r102.f551200d.getClass();
        com.bytedance.android.livesdk.chatroom.replay.ui.p r112 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        Context r113 = r102.getContext();
        r112.getClass();
        r103.b(r111, r105, r111, com.bytedance.android.livesdk.chatroom.replay.ui.p.o(r113));
        return r103;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_4;
    }
}
