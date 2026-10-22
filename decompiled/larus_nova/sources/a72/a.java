package a72;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final int o() {
        return R.drawable.ttlive_comment_panel_interest_button;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "bridges");
        super.t(r100, r101);
        r101.C0();
    }

    public a(InputFunctionEnum r100, Context r101, InputSectionType r102) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sectionType");
        super(r100, r101, r102);
    }
}
