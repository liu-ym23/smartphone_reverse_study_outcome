package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewSwitcher f79620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f79621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f79622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f79623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public QuickInteractTask f79624e;

    public n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        ViewSwitcher r101 = (ViewSwitcher) r100.findViewById(R.id.interact_switcher);
        this.f79620a = r101;
        this.f79621b = (HSImageView) r100.findViewById(R.id.interact_avatar);
        this.f79622c = (TextView) r100.findViewById(R.id.interact_content);
        this.f79623d = r100.findViewById(R.id.score_switcher);
        r101.setMeasureAllChildren(false);
        r101.setInAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_in));
        r101.setOutAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_out));
    }
}
