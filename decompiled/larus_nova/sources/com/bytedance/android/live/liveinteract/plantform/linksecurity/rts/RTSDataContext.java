package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model.LinkmicRtsKickOutContent;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model.LinkmicRtsUpdateLinkStatusContent;
import com.bytedance.android.livesdk.multilink.base.model.b0;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/RTSDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/a$c;", "", "interactId", "Lph0/b;", "event", "", "putLinkTypeEvent", "Lph0/c;", "putSilenceEvent", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsUpdateLinkStatusContent;", "msg", "onReceiveUpdateLinkStatusMsg", "Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/model/LinkmicRtsKickOutContent;", "onReceiveKickOutMsg", "message", "onReceiveAedStateMessage", "onRoomRtsMessage", "Lcom/bytedance/live/datacontext/n;", "linkTypeEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getLinkTypeEvent", "()Lcom/bytedance/live/datacontext/n;", "linkTypeEvent", "", "silenceEventMap", "Ljava/util/Map;", "silenceEvent$delegate", "getSilenceEvent", "silenceEvent", "Lph0/a;", "kickOutEvent$delegate", "getKickOutEvent", "kickOutEvent", "aedStateEvent$delegate", "getAedStateEvent", "aedStateEvent", "roomRtsEvent$delegate", "getRoomRtsEvent", "roomRtsEvent", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTSDataContext extends DataContext implements com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p aedStateEvent$delegate;
    private final p kickOutEvent$delegate;
    private final p linkTypeEvent$delegate;
    private final p roomRtsEvent$delegate;
    private final p silenceEvent$delegate;
    private final Map<String, ph0.c> silenceEventMap;

    public static final class a {
        public final RTSDataContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(RTSDataContext.class);
            if ((r100 instanceof RTSDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (RTSDataContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RTSDataContext.class, "linkTypeEvent", "getLinkTypeEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RTSDataContext.class, "silenceEvent", "getSilenceEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RTSDataContext.class, "kickOutEvent", "getKickOutEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RTSDataContext.class, "aedStateEvent", "getAedStateEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RTSDataContext.class, "roomRtsEvent", "getRoomRtsEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<String> getAedStateEvent() {
        return (n) this.aedStateEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final n<ph0.a> getKickOutEvent() {
        return (n) this.kickOutEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<ph0.b> getLinkTypeEvent() {
        return (n) this.linkTypeEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<String> getRoomRtsEvent() {
        return (n) this.roomRtsEvent$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<ph0.c> getSilenceEvent() {
        return (n) this.silenceEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public RTSDataContext() {
        this.linkTypeEvent$delegate = q.c(this);
        this.silenceEventMap = new LinkedHashMap();
        this.silenceEvent$delegate = q.c(this);
        this.kickOutEvent$delegate = q.c(this);
        this.aedStateEvent$delegate = q.c(this);
        this.roomRtsEvent$delegate = q.c(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c
    public void onReceiveAedStateMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        getAedStateEvent().setValue(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c
    public void onReceiveKickOutMsg(LinkmicRtsKickOutContent r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        n<ph0.a> r101 = getKickOutEvent();
        String r102 = r100.getLinkMicIdStr();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.setValue(new ph0.a(r102));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c
    public void onReceiveUpdateLinkStatusMsg(LinkmicRtsUpdateLinkStatusContent r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r101 = r100.getTargetLinkMicIdStr();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = b0.a(r100);
        String r104 = r100.getTargetLinkMicIdStr();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        putLinkTypeEvent(r101, new ph0.b(r103, r104, r100.getLinkType(), r100.getForceResumeVideoStream()));
        String r105 = r100.getTargetLinkMicIdStr();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        String r106 = b0.a(r100);
        String r107 = r100.getTargetLinkMicIdStr();
        if (r107 == null) goto L15;
        r102 = r107;
    L15:
        putSilenceEvent(r105, new ph0.c(r106, r102, r100.getSilenceStatus(), r100.getForceResumeAudioStream()));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c
    public void onRoomRtsMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        getRoomRtsEvent().setValue(r100);
    }

    private final void putLinkTypeEvent(String r100, ph0.b r101) {
        getLinkTypeEvent().setValue(r101);
    }

    private final void putSilenceEvent(String r100, ph0.c r101) {
        getSilenceEvent().setValue(r101);
        this.silenceEventMap.put(r100, r101);
    }
}
