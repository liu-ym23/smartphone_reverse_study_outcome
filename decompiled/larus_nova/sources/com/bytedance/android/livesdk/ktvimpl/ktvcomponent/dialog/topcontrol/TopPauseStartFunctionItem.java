package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class TopPauseStartFunctionItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f144245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f144246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c f144247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f144248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f144249e;

    public final void a() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r100 = this.f144247c;
        KtvRoomLyricsStateMachineConfig.d r101 = null;
        if (r100 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r102 = r100.getCurState();
    L6:
        boolean r103 = r102 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r104 = this.f144247c;
        if (r104 == null) goto L9;
        r101 = r104.getCurState();
    L9:
        boolean r105 = r101 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d;
        if (r103 == true) goto L21;
        if (r105 == true) goto L21;
        ImageView r106 = this.f144245a;
        if (r106 == null) goto L15;
        r106.setAlpha(0.5f);
    L15:
        ImageView r107 = this.f144245a;
        if (r107 == null) goto L18;
        r107.setEnabled(false);
    L18:
        ImageView r108 = this.f144245a;
        if (r108 == null) goto L44;
        r108.setTag(Boolean.FALSE);
        return;
    L44:
        return;
    L21:
        ImageView r109 = this.f144245a;
        if (r109 == null) goto L24;
        r109.setAlpha(1.0f);
    L24:
        ImageView r110 = this.f144245a;
        if (r110 == null) goto L27;
        r110.setEnabled(true);
    L27:
        ImageView r111 = this.f144245a;
        if (r111 == null) goto L30;
        r111.setTag(Boolean.TRUE);
    L30:
        ImageView r112 = this.f144245a;
        if (r112 == null) goto L33;
        UtilityKotlinExtentionsKt.f(r112);
    L33:
        if (r105 == false) goto L37;
        ImageView r113 = this.f144245a;
        if (r113 == null) goto L40;
        r113.setBackgroundResource(this.f144248d.f144251b);
    L40:
        ImageView r114 = this.f144245a;
        if (r114 == null) goto L46;
        r114.setOnClickListener(x0.a(new TopPauseStartFunctionItem$handleStateChanged$1(this)));
        return;
    L46:
        return;
    L37:
        ImageView r115 = this.f144245a;
        if (r115 == null) goto L40;
        r115.setBackgroundResource(this.f144248d.f144250a);
        goto L40
    L5:
        r102 = null;
        goto L6
    }

    public TopPauseStartFunctionItem(LifecycleOwner r100, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r101, a r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "iconRes");
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        this.f144246b = r100;
        this.f144247c = r101;
        this.f144248d = r102;
        this.f144249e = r103;
    }
}
