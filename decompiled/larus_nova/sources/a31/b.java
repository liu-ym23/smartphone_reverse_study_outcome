package a31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import x21.d;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final PlayMode a(FeedMultiPlayMode r100) {
        if (r100 == null) goto L16;
        int r101 = a.f1523a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 != 4) goto L16;
        return PlayMode.TEAM_PK;
    L15:
        return PlayMode.PERSONAL_PK;
    L16:
        return PlayMode.PERSONAL_PK;
    }

    public static final int b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLynxPkState");
        if ((r100 instanceof d.C8188d) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof d.c) == false) goto L9;
        return 1;
    L9:
        if ((r100 instanceof d.b) == false) goto L12;
        return 2;
    L12:
        if ((r100 instanceof d.a) == false) goto L16;
        return 3;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
