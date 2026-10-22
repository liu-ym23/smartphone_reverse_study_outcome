package a66;

import android.app.Activity;
import android.content.res.Resources;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements com.bytedance.ies.xbridge.event.bridge.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f1958a;

    public b(Activity r100) {
        this.f1958a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.bridge.b.a
    public final void a(int r100) {
        Event r101 = new Event(AppEvent.KeyboardStatusChange.getEventName(), System.currentTimeMillis(), null);
        Activity r102 = this.f1958a;
        Pair[] r103 = new Pair[2];
        int r104 = com.bytedance.ies.xbridge.event.bridge.b.f249480a;
        double r105 = r100;
        if (r102 == null) goto L5;
        Resources r106 = r102.getApplicationContext().getResources();
    L6:
        Pair r107 = TuplesKt.to("height", Integer.valueOf((int) ((r105 / ((double) WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density)) + ((double) 0.5f))));
        boolean r108 = false;
        r103[0] = r107;
        if (r100 == 0) goto L9;
        r108 = true;
    L9:
        r103[1] = TuplesKt.to("visible", Boolean.valueOf(r108));
        r101.setMapParams(MapsKt.mapOf(r103));
        EventCenter.enqueueEvent(r101);
        return;
    L5:
        r106 = Resources.getSystem();
        goto L6
    }
}
