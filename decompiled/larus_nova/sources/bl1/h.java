package bl1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends ReplayWidgetDescriptor<uq1.b> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.B().getWidgetClass(4);
    }

    public h() {
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.E;
    }

    @Override // j70.h
    public final com.bytedance.android.live.core.tetris.layer.view.b K(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        com.bytedance.android.live.core.tetris.layer.view.b r101 = new com.bytedance.android.live.core.tetris.layer.view.b();
        r101.c();
        return r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final boolean N(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return !((Boolean) r101.invoke(4)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return new ElementConstraint(-1.0f, -1.0f);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_6;
    }
}
