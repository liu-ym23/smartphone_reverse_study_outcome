package cgb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.flow.bottomsheet.biz.threadwindow.ThreadWindowFrameFragment;
import com.ss.android.lark.flow.threadwindow.FlowThreadWindowActivity;
import com.ss.android.lark.flow.threadwindow.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public a() {
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final String clazz() {
        return FlowThreadWindowActivity.class.getName();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final BottomSheetFrameFragment f() {
        return new ThreadWindowFrameFragment();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final Integer b() {
        return Integer.valueOf(R.color.flow_ud_static_black_transparent_1);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void c(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        ChatBundle r102 = ChatBundle.f(r101);
        int r103 = i.f424238a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatBundle");
        i.b(r100, r102.l());
    }
}
