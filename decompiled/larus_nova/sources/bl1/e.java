package bl1;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.replay.element.ReplayCastScreenTetris;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends j70.j<uq1.b> {
    @Override // j70.k
    public final Tetris<? extends h70.b> b() {
        return new ReplayCastScreenTetris();
    }

    public e() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.I;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return LayerIndex.INDEX_0;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        ElementConstraint r102 = new ElementConstraint(0.0f, 0.0f);
        ElementConstraint.Side r103 = ElementConstraint.Side.LEFT;
        r102.d(r103, r103, 0.0f);
        ElementConstraint.Side r104 = ElementConstraint.Side.RIGHT;
        r102.d(r104, r104, 0.0f);
        ElementConstraint.Side r105 = ElementConstraint.Side.BOTTOM;
        r101.f551200d.getClass();
        j70.g r106 = uq1.a.f551189p;
        r102.b(r105, r106, r105, 0.0f);
        ElementConstraint.Side r107 = ElementConstraint.Side.TOP;
        r101.f551200d.getClass();
        r102.b(r107, r106, r107, 0.0f);
        return r102;
    }

    @Override // j70.h
    public final com.bytedance.android.live.core.tetris.layer.view.b K(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        com.bytedance.android.live.core.tetris.layer.view.b r101 = new com.bytedance.android.live.core.tetris.layer.view.b();
        r101.d();
        return r101;
    }
}
