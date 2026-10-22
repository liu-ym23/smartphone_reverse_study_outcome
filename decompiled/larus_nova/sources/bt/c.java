package bt;

import com.bytedance.android.gamecp.business.gamedetail.base.config.ImmediatePlayBtnConfig$Type;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements a {
    public c() {
    }

    @Override // bt.a
    public final int a(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return R.drawable.shape_bg_ffffff_corner_8;
    }

    @Override // bt.a
    public final int b(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return R.color.gamecp_text_black;
    }

    @Override // bt.a
    public final int c(ImmediatePlayBtnConfig$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ImmediatePlayBtnConfig$Type.CloudGame) goto L5;
        return R.drawable.gamecp_ic_flash_black;
    L5:
        if (r100 == ImmediatePlayBtnConfig$Type.MiniPlay) goto L11;
        return 0;
    L11:
        return R.drawable.gamecp_ic_flash_black;
    }
}
