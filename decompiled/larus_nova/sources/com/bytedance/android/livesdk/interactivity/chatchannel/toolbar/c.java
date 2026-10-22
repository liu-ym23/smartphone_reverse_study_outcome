package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Consumer<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f134395a;

    public c(a r100) {
        this.f134395a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Bitmap r100) {
        Bitmap r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L16;
        View r102 = this.f134395a.f134384a;
        if (r102 == null) goto L17;
        View r103 = r102.findViewById(R.id.icon);
        if (r103 == null) goto L15;
        ALogger.e("ToolbarRoomChannelBehavior", "load remote img.");
        r103.setBackground(new BitmapDrawable(r101));
        return;
    L15:
        return;
    L17:
        return;
    }
}
