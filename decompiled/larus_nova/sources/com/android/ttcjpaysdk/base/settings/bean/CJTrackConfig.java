package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.caijing.sdk.infra.base.event.DynamicEventTracker;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J2\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0005R*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "Lcom/bytedance/caijing/sdk/infra/base/event/DynamicEventTracker$d;", "info", "", "setInfo", "Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackEventDetail;", "event", "", "trackVersion", "sceneName", "trackName", "Lcom/bytedance/caijing/sdk/infra/base/event/DynamicEventTracker$EventTyp;", "type", "parseEvent", "transform", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackScene;", "Lkotlin/collections/ArrayList;", InvRouter.SCENES, "Ljava/util/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJTrackConfig implements CJPayObject, Serializable {
    public ArrayList<CJTrackScene> scenes;

    /* JADX WARN: Multi-variable type inference failed */
    public CJTrackConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void transform() {
        ArrayList<CJTrackScene> r100 = this.scenes;     // Catch: Exception -> L15
        if (r100 == null) goto L14;
        Iterator<T> r101 = r100.iterator();     // Catch: Exception -> L15
    L6:
        if (r101.hasNext() == false) goto L25;
        CJTrackScene r102 = (CJTrackScene) r101.next();     // Catch: Exception -> L15
        DynamicEventTracker.d r103 = parseEvent(r102.start_event, r102.track_version, r102.scene_name, r102.track_name, DynamicEventTracker.EventTyp.START);     // Catch: Exception -> L15
        r103.f202341e = true;     // Catch: Exception -> L15
        setInfo(r103);     // Catch: Exception -> L15
        DynamicEventTracker.d r104 = parseEvent(r102.end_event, r102.track_version, r102.scene_name, r102.track_name, DynamicEventTracker.EventTyp.END);     // Catch: Exception -> L15
        r104.f202341e = true;     // Catch: Exception -> L15
        setInfo(r104);     // Catch: Exception -> L15
        ArrayList<CJTrackEventDetail> r105 = r102.events;     // Catch: Exception -> L15
        if (r105 == null) goto L6;
        Iterator<T> r106 = r105.iterator();     // Catch: Exception -> L15
    L11:
        if (r106.hasNext() == false) goto L6;
        setInfo(parseEvent((CJTrackEventDetail) r106.next(), r102.track_version, r102.scene_name, r102.track_name, DynamicEventTracker.EventTyp.PROCESS));     // Catch: Exception -> L15
    L25:
        return;
    L14:
        return;
    }

    public CJTrackConfig(ArrayList<CJTrackScene> r100) {
        this.scenes = r100;
    }

    private final void setInfo(DynamicEventTracker.d r100) {
        Lazy<DynamicEventTracker> r101 = DynamicEventTracker.f202325b;
        HashMap<String, ArrayList<DynamicEventTracker.d>> r102 = DynamicEventTracker.f202326c;
        ArrayList<DynamicEventTracker.d> r103 = r102.get(r100.f202339c);
        if (r103 == null) goto L5;
        r103.add(r100);
        return;
    L5:
        String r104 = r100.f202339c;
        ArrayList<DynamicEventTracker.d> r105 = new ArrayList();
        r105.add(r100);
        r102.put(r104, r105);
    }

    public /* synthetic */ CJTrackConfig(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }

    private final DynamicEventTracker.d parseEvent(CJTrackEventDetail r100, String r101, String r102, String r103, DynamicEventTracker.EventTyp r104) {
        DynamicEventTracker.d r105 = new DynamicEventTracker.d();
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f202337a = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r105.f202338b = r103;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r105.f202340d = r104;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f202344h = r101;
        String r106 = r100.event;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f202339c = r106;
        r105.f202341e = r100.is_collection;
        r105.f202343g = r100.rule;
        String r107 = r100.desc;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f202342f = r107;
    L5:
        return r105;
    }
}
