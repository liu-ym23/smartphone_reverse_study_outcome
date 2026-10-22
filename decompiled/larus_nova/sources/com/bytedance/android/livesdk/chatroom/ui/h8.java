package com.bytedance.android.livesdk.chatroom.ui;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f113574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f113575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i8 f113576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f113577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super String, String> f113578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super i8, Unit> f113579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super String, Unit> f113580g;

    public h8(ConstraintLayout r100, ImageView r101, TextView r102, i8 r103, Function0<String> r104, Function1<? super String, String> r105, Function1<? super i8, Unit> r106, LiveMode r107, Function1<? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "probeLayout");
        Intrinsics.checkNotNullParameter(r101, "stateImageView");
        Intrinsics.checkNotNullParameter(r102, "stateTextView");
        Intrinsics.checkNotNullParameter(r103, "curProbeResult");
        Intrinsics.checkNotNullParameter(r104, "defaultProbeKey");
        Intrinsics.checkNotNullParameter(r105, "findNameFunc");
        Intrinsics.checkNotNullParameter(r106, "reportLog");
        Intrinsics.checkNotNullParameter(r107, "type");
        Intrinsics.checkNotNullParameter(r110, "updateFunc");
        this.f113574a = r100;
        this.f113575b = r101;
        this.f113576c = r103;
        this.f113577d = r104;
        this.f113578e = r105;
        this.f113579f = r106;
        this.f113580g = r110;
    }
}
