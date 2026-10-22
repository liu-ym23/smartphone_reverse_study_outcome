package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/CollectSuccessDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectSuccessDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f61177a;

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_open_game_collect_success;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f61177a == false) goto L21;
        Window r101 = getWindow();
        if (r101 == null) goto L9;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L9;
        r102.width = s1.f(390.0f);
    L9:
        View r103 = findViewById(R.id.root_layout);
        if (r103 == null) goto L17;
        a1.k(r103, s1.q(getContext()).heightPixels);
        Drawable r104 = r103.getBackground();
        if ((r104 instanceof GradientDrawable) == true) goto L14;
        r104 = null;
    L14:
        GradientDrawable r105 = (GradientDrawable) r104;
        float r106 = s1.e(12.0f);
        if (r105 == null) goto L17;
        r105.setCornerRadii(new float[]{r106, r106, 0.0f, 0.0f, 0.0f, 0.0f, r106, r106});
    L17:
        Window r107 = getWindow();
        if (r107 == null) goto L20;
        r107.setGravity(5);
    L20:
        t8.d(getWindow());
    L21:
        ((TextView) findViewById(R.id.user_understand)).setOnClickListener(new a(this));
        String r108 = i2.f114501a;
        i2.e((HSImageView) findViewById(R.id.revisit_collect_game_tip), "/broadcastgame/ttlive_open_game_tip_visit_collect_path.png");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        if (this.f61177a == false) goto L6;
        if (r100 == false) goto L6;
        t8.d(getWindow());
    L6:
        super.onWindowFocusChanged(r100);
    }

    public CollectSuccessDialog(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false);
        this.f61177a = r101;
    }
}
