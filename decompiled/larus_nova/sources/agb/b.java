package agb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.flow.bottomsheet.biz.chatwindow.ChatWindowBottomFrameFragment;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.FlowChatActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public b() {
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final String clazz() {
        return FlowChatActivity.class.getName();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final BottomSheetFrameFragment f() {
        return new ChatWindowBottomFrameFragment();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final Integer b() {
        return Integer.valueOf(R.color.flow_ud_static_black_transparent_1);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.a.c
    public final void c(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        int r102 = FlowChatModule.f422022d;
        FlowChatModule.a.a().e(r100, ChatBundle.f(r101), null);
    }
}
