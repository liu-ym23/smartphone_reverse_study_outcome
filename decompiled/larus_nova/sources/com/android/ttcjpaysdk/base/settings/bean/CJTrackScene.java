package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\f¢\u0006\u0002\u0010\rR\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackScene;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "scene_name", "", "track_name", "track_version", "start_event", "Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackEventDetail;", "end_event", "events", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackEventDetail;Lcom/android/ttcjpaysdk/base/settings/bean/CJTrackEventDetail;Ljava/util/ArrayList;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJTrackScene implements CJPayObject, Serializable {
    public CJTrackEventDetail end_event;
    public ArrayList<CJTrackEventDetail> events;
    public String scene_name;
    public CJTrackEventDetail start_event;
    public String track_name;
    public String track_version;

    public CJTrackScene() {
        this(null, null, null, null, null, null, 63, null);
    }

    public CJTrackScene(String r100, String r101, String r102, CJTrackEventDetail r103, CJTrackEventDetail r104, ArrayList<CJTrackEventDetail> r105) {
        Intrinsics.checkNotNullParameter(r100, "scene_name");
        Intrinsics.checkNotNullParameter(r101, "track_name");
        Intrinsics.checkNotNullParameter(r102, "track_version");
        this.scene_name = r100;
        this.track_name = r101;
        this.track_version = r102;
        this.start_event = r103;
        this.end_event = r104;
        this.events = r105;
    }

    public /* synthetic */ CJTrackScene(String r100, String r101, String r102, CJTrackEventDetail r103, CJTrackEventDetail r104, ArrayList r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r111 & 8) == 0) goto L17;
        CJTrackEventDetail r107 = null;
    L19:
        if ((r111 & 16) == 0) goto L21;
        CJTrackEventDetail r108 = null;
    L23:
        if ((r111 & 32) == 0) goto L25;
        ArrayList r114 = null;
    L26:
        this(r113, r106, r105, r107, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
