package bl1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.replay.widget.ReplayEndWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j extends j70.n<uq1.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f19403c;

    @Override // j70.o
    public final boolean h() {
        return true;
    }

    @Override // j70.n, j70.o
    public final Object[] a() {
        if (Intrinsics.areEqual(this.f19403c, Boolean.TRUE) == true) goto L7;
        return null;
    L7:
        return new Object[]{"cmd_replay_widget_refreshed"};
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ReplayEndWidget.class;
    }

    public j(Boolean r100) {
        this.f19403c = r100;
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
        return uq1.a.f551197x;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return LayerIndex.INDEX_11;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return ElementConstraint.f65822n;
    }
}
