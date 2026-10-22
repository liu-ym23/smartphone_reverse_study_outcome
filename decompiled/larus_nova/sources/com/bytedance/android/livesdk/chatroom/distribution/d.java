package com.bytedance.android.livesdk.chatroom.distribution;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.widgetdescriptor.template.distribution.externalinjectcomponent.ExternalInjectWrapperWidget;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f105742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ExternalInjectWrapperWidget> f105743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f105744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f105745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataCenter f105746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f105747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WidgetManager f105748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LifecycleOwner f105749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IExternalConfigJudger f105750i;

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        Iterator r101 = ((LinkedHashMap) this.f105743b).entrySet().iterator();     // Catch: Throwable -> L10
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Throwable -> L10
        WidgetManager r103 = this.f105748g;     // Catch: Throwable -> L10
        if (r103 == null) goto L4;
        r103.unload((Widget) r102.getValue());     // Catch: Throwable -> L10
        goto L4
    L8:
        ((LinkedHashMap) this.f105743b).clear();     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public d(DataCenter r100, View r101, RecyclableWidgetManager r102, Fragment r103, IExternalConfigJudger r104, String r105) {
        this.f105746e = r100;
        this.f105747f = r101;
        this.f105748g = r102;
        this.f105749h = r103;
        this.f105750i = r104;
        FrameLayout r106 = null;
        if (r100 == null) goto L5;
        p0 r107 = (p0) r100.get("zygote_event_hub", null);
    L6:
        this.f105742a = r107;
        this.f105743b = new LinkedHashMap();
        View r108 = this.f105747f;
        if (r108 == null) goto L9;
        FrameLayout r109 = (FrameLayout) r108.findViewById(R.id.interaction_bottom_container_view);
    L10:
        this.f105744c = r109;
        View r110 = this.f105747f;
        if (r110 == null) goto L13;
        r106 = (FrameLayout) r110.findViewById(R.id.fragment_container);
    L13:
        this.f105745d = r106;
        return;
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }
}
