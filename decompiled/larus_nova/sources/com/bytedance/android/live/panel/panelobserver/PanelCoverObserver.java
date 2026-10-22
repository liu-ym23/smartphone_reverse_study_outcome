package com.bytedance.android.live.panel.panelobserver;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.panel.ActionType;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.panel.RemoveReason;
import com.bytedance.android.live.room.api.panel.b;
import com.bytedance.android.live.room.api.panel.e;
import com.bytedance.android.live.room.api.panel.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class PanelCoverObserver implements com.bytedance.android.live.panel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.bytedance.android.live.room.api.panel.a> f85376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<PanelName, e> f85377b;

    public static final class a {
    }

    static {
    }

    public PanelCoverObserver() {
    }

    @Override // com.bytedance.android.live.panel.a
    public final void destroy() {
        Map<String, com.bytedance.android.live.room.api.panel.a> r100 = this.f85376a;
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, com.bytedance.android.live.room.api.panel.a>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, com.bytedance.android.live.room.api.panel.a> r102 = r101.next();
        ALogger.i("PanelCoverObserver", "destroy, clear listener " + r102.getKey());
        r102.getValue().c(RemoveReason.Destroy);
    L8:
        Map<String, com.bytedance.android.live.room.api.panel.a> r103 = this.f85376a;
        if (r103 == null) goto L11;
        r103.clear();
    L11:
        this.f85376a = null;
        Map<PanelName, e> r104 = this.f85377b;
        if (r104 == null) goto L14;
        r104.clear();
    L14:
        this.f85377b = null;
    }

    @Override // com.bytedance.android.live.panel.a
    public final PanelObserverType c() {
        return PanelObserverType.CoverObserver;
    }

    @Override // com.bytedance.android.live.panel.a
    public final void a(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelInfoProvider");
        r100.a(new PanelCoverObserver$onPanelOpen$1(this, r100), new PanelCoverObserver$onPanelOpen$2(r100));
    }

    @Override // com.bytedance.android.live.panel.a
    public final void b(List<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "panelInfoProviders");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        b r102 = (b) r101.next();
        e r103 = f.a(r102, ActionType.Close, -1);
        Map<String, com.bytedance.android.live.room.api.panel.a> r104 = this.f85376a;
        if (r104 == null) goto L11;
        Iterator r105 = ((LinkedHashMap) r104).entrySet().iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();
        ALogger.i("PanelCoverObserver", "onPanelClose, listener name = " + ((com.bytedance.android.live.room.api.panel.a) r106.getValue()).getName() + ", panel name = " + r103.f99049a + ", panel id - " + r103.f99050b);
        ((com.bytedance.android.live.room.api.panel.a) r106.getValue()).a(r103);
    L11:
        Map<PanelName, e> r107 = this.f85377b;
        if (r107 == null) goto L4;
        e r108 = r107.remove(r102.getPanelName());
        goto L4
    }
}
