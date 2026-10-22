package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.g6;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes46.dex */
public final class j0 extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a implements vlc.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f76455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f76456c;

    public static final class a {
    }

    static {
    }

    public j0() {
        this.f76455b = new CompositeDisposable();
        this.f76456c = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        com.bytedance.android.livesdk.chatroom.t r100 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        r101.c(new VoiceAnchorGuideInfoHandler$attachMessage$1(this));
    L7:
        Disposable r102 = xs2.b.a().b(dh0.a.class).subscribe(new k0(this));
        if (r102 == null) goto L11;
        this.f76455b.add(r102);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        com.bytedance.android.livesdk.chatroom.t r100 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        r101.c(new VoiceAnchorGuideInfoHandler$detachMessage$1(this));
    L7:
        this.f76455b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(ILinkMicGuideMessageBridge r100) {
        if (vm2.c.i() == true) goto L5;
        return true;
    L5:
        List<ch0.e> r101 = a().f().getValue();
        if (r101 == null) goto L8;
        int r102 = r101.size();
    L10:
        if (r102 < r100.getAudienceLimit()) goto L14;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since online count hits limit");
        return true;
    L14:
        if (this.f76456c == true) goto L17;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since message too often");
        return true;
    L17:
        com.bytedance.live.datacontext.m<Boolean> r103 = com.bytedance.android.live.liveinteract.api.utils.m.d().I1();
        if (r103 != null) goto L20;
    L23:
        Integer r104 = (Integer) hd0.c.f().f481009b;
        if (r104 != null) goto L27;
    L28:
        Integer r105 = (Integer) hd0.c.f().f481009b;
        if (r105 != null) goto L32;
    L34:
        boolean r106 = false;
    L36:
        if (r106 == false) goto L39;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since guest is not idle");
        return true;
    L39:
        f6 r107 = r100.getAnchorGuideInfo();
        if (r107 == null) goto L42;
        List<g6> r108 = r107.getInfoItems();
    L43:
        if (r108 == null) goto L52;
        f6 r109 = r100.getAnchorGuideInfo();
        if (r109 == null) goto L52;
        List<g6> r110 = r109.getInfoItems();
        if (r110 == null) goto L52;
        if (r110.size() != 3) goto L52;
        return false;
    L52:
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since message not complete");
        return true;
    L42:
        r108 = null;
        goto L43
    L32:
        if (r105.intValue() != 2) goto L34;
    L35:
        r106 = true;
        goto L36
    L27:
        if (r104.intValue() == 1) goto L35;
    L20:
        if (r103.getValue().booleanValue() != true) goto L23;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since in ktv mode");
        return true;
    L8:
        r102 = 0;
        goto L10
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof ILinkMicGuideMessageBridge) == false) goto L17;
        ILinkMicGuideMessageBridge r101 = (ILinkMicGuideMessageBridge) r100;
        if (r101.getGuidelineType() != 0) goto L18;
        gh0.b.a("AudioAnchorGuide", "receive ILinkMicGuideMessageBridge", false);
        gh0.b.a("AudioAnchorGuide", "handleAudioGuideLineMsg, intercept = " + d(r101) + ", audienceLimit = " + r101.getAudienceLimit() + ", anchorGuideInfo = " + r101.getAnchorGuideInfo(), false);
        if (d(r101) == true) goto L20;
        int r102 = r101.getAudienceLimit();
        f6 r103 = r101.getAnchorGuideInfo();
        if (r103 != null) goto L12;
        return;
    L12:
        if (je0.d.D() == false) goto L14;
        int r104 = vm2.c.a().anchorRateLimit;
    L15:
        this.f76456c = false;
        this.f76455b.add(Observable.timer(r104, TimeUnit.SECONDS).subscribe(new l0(this, r104)));
        a().k1(new ch0.l(r102, r103));
        return;
    L14:
        r104 = vm2.c.a().audienceRateLimit;
        goto L15
    L20:
        return;
    L18:
        return;
    }
}
