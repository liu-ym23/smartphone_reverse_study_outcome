package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkPanelTopBarWidget f75418a;

    public y(LinkPanelTopBarWidget r100) {
        this.f75418a = r100;
    }

    @Override // com.bytedance.android.livesdk.app.dataholder.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (this.f75418a.f75372a == false) goto L6;
        return;
    L6:
        if (r101 != null) goto L9;
    L14:
        if (r101 != null) goto L17;
    L22:
        if (r101 != null) goto L25;
        return;
    L25:
        if (r101.intValue() != 2) goto L33;
        ViewGroup r102 = this.f75418a.f75373b;
        if (r102 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L29:
        ((TextView) r102.findViewById(R.id.admin_operation)).setText(R.string.ttlive_live_interact_disconnect);
        return;
    L33:
        return;
    L17:
        if (r101.intValue() != 1) goto L22;
        ViewGroup r103 = this.f75418a.f75373b;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L21:
        ((TextView) r103.findViewById(R.id.admin_operation)).setText(R.string.ttlive_interact_audience_cancel_apply);
        return;
    L9:
        if (r101.intValue() != 0) goto L14;
        ViewGroup r104 = this.f75418a.f75373b;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L13:
        ((TextView) r104.findViewById(R.id.admin_operation)).setText(R.string.ttlive_video_talk_room_audio_apply);
    }
}
