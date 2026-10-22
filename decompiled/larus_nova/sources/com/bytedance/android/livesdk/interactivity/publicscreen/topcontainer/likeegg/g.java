package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositeImagePreviewDialog f139927a;

    public g(CompositeImagePreviewDialog r100) {
        this.f139927a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ALogger.d("CompositeImagePreviewDialog", "retry composite image loading");
        Function0<Unit> r101 = this.f139927a.D;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke();
    L5:
        this.f139927a.Y0();
    }
}
