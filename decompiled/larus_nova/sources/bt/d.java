package bt;

import com.bytedance.android.gamecp.business.gamedetail.base.config.ImmediatePlayBtnConfig$Type;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements a {
    public d() {
    }

    @Override // bt.a
    public final int c(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return R.drawable.gamecp_ic_flash_red;
    }

    @Override // bt.a
    public final int a(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ImmediatePlayBtnConfig$Type.MiniGame) goto L6;
        return R.drawable.shape_bg_fe2c55_corner_8;
    L6:
        return R.drawable.shape_bg_14fe2c55_corner_8;
    }

    @Override // bt.a
    public final int b(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ImmediatePlayBtnConfig$Type.MiniGame) goto L6;
        return R.color.gamecp_white;
    L6:
        return R.color.gamecp_game_FE2C55;
    }
}
