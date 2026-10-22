package bl1;

import com.bytedance.android.livesdk.chatroom.replay.widget.ReplayBottomPanelManagerWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends j70.i<uq1.b> {
    public d() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ReplayBottomPanelManagerWidget.class;
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
        return uq1.a.f551179f;
    }
}
