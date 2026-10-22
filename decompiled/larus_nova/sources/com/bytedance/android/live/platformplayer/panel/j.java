package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import zg1.w1;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f85769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w1 f85770b;

    public j(k r100, w1 r101) {
        this.f85769a = r100;
        this.f85770b = r101;
    }

    public final void a() {
        DialogFragment r100 = this.f85770b.f571971a.get();
        Dialog r101 = null;
        if ((r100 instanceof LiveDialogFragment) == true) goto L5;
        r100 = null;
    L5:
        LiveDialogFragment r102 = (LiveDialogFragment) r100;
        if (r102 == null) goto L12;
        ds0.b r103 = new ds0.b();
        r103.a(LivePanelType.PERSONAL_PROFILE);
        r103.f469806c = r102.getContentViewHeight();
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r103.f469805b = "open";
        r103.f469808e = R.id.ttlive_design_bottom_sheet;
        DialogFragment r104 = this.f85770b.f571971a.get();
        if (r104 == null) goto L10;
        r101 = r104.getDialog();
    L10:
        WeakReference<Dialog> r105 = new WeakReference(r101);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r103.f469807d = r105;
        o.a(this.f85769a.f85771a, r103);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
