package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import android.view.View;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import zg1.f0;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f85777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f85778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StreamAutoAdapterPanelObserver$giftPanelObserver$1 f85779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StreamAutoAdapterService f85780d;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterPanelObserver$giftPanelObserver$1] */
    public o() {
        StreamAutoAdapterService r100 = StreamAutoAdapterService.f85743o;
        Intrinsics.checkNotNullParameter(r100, "adapterService");
        this.f85780d = r100;
        this.f85777a = new CompositeDisposable();
        this.f85779c = new StreamAutoAdapterPanelObserver$giftPanelObserver$1(this);
    }

    public static final void a(o r100, ds0.b r101) {
        r100.f85780d.getClass();
        if (StreamAutoAdapterService.f85742n == true) goto L6;
        r100.f85780d.getClass();
        StreamAutoAdapterService.g(r101);
        return;
    L6:
        if (Intrinsics.areEqual(r101.f469805b, "open") == false) goto L25;
        Dialog r102 = r101.f469807d.get();
        if (r102 == null) goto L17;
        if ((r102 instanceof LiveStandardSheetDialog) == false) goto L14;
        ((LiveStandardSheetDialog) r102).f154341f = new m(r100, r101);
    L14:
        if ((r102 instanceof LiveBottomSheetDialog) == false) goto L17;
        ((LiveBottomSheetDialog) r102).setStateCallback(new n(r100, r101));
    L17:
        if (r101.f469806c != 0) goto L25;
        Dialog r103 = r101.f469807d.get();
        if (r103 != null) goto L21;
        r100.f85780d.e("listenCommonPanel failed! " + r101.getType() + " with null dialog!");
        return;
    L21:
        View r104 = r103.findViewById(r101.f469808e);
        if (r104 != null) goto L24;
        r100.f85780d.e("listenCommonPanel failed! " + r101.getType() + " get root view failed!");
        return;
    L24:
        r104.post(new g(r100, r101, r104));
        return;
    L25:
        r100.f85780d.c(r101);
    }
}
