package bl1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.replay.element.ReplayPortraitGestureWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends ReplayWidgetDescriptor<uq1.b> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public v() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ReplayPortraitGestureWidget.class;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.L;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final boolean N(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        if (((Boolean) r101.invoke(4)).booleanValue() == true) goto L5;
        return true;
    L5:
        if (((Boolean) r101.invoke(1)).booleanValue() == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        uq1.b r102 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        ElementConstraint r103 = new ElementConstraint(0.0f, 0.0f);
        ElementConstraint.Side r104 = ElementConstraint.Side.LEFT;
        r102.f551200d.getClass();
        j70.g r105 = uq1.a.f551189p;
        r103.b(r104, r105, r104, 0.0f);
        ElementConstraint.Side r106 = ElementConstraint.Side.RIGHT;
        r102.f551200d.getClass();
        r103.b(r106, r105, r106, 0.0f);
        ElementConstraint.Side r107 = ElementConstraint.Side.BOTTOM;
        r102.f551200d.getClass();
        r103.b(r107, r105, r107, 0.0f);
        ElementConstraint.Side r108 = ElementConstraint.Side.TOP;
        r102.f551200d.getClass();
        r103.b(r108, r105, r108, 0.0f);
        return r103;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_0;
    }
}
