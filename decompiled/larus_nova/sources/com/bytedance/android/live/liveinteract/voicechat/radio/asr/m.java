package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements b.InterfaceC1245b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f80535a;

    public m(k r100) {
        this.f80535a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.b.InterfaceC1245b
    public final void onPCMDataReceived(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "pcmData");
        if (this.f80535a.f80517f == false) goto L5;
        return;
    L5:
        if (this.f80535a.f80516e == false) goto L48;
        h r102 = this.f80535a.f80513b;
        if (r102 == null) goto L49;
        boolean r103 = false;
        if (r102.f80503f == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 != true) goto L50;
        h r105 = this.f80535a.f80513b;
        if (r105 == null) goto L51;
        Integer r106 = Integer.valueOf(r101);
        if (r105.f80500c == true) goto L20;
        return;
    L20:
        if (r105.f80503f == true) goto L22;
    L24:
        if (r103 == false) goto L53;
        if (r106 == null) goto L27;
        int r107 = r106.intValue();
    L28:
        int r108 = r105.f80499b.feedAudio(r100, r107);
        if (r108 == 0) goto L54;
        StringBuilder r109 = new StringBuilder("feed audio error. ret=");
        r109.append(r108);
        r109.append(" state=");
        int r110 = r105.f80498a.get();
        if (r110 == 0) goto L44;
        if (r110 != 1) goto L34;
        String r111 = ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE;
    L45:
        r109.append(r111);
        r105.d(r109.toString());
        return;
    L34:
        if (r110 != 2) goto L36;
        r111 = "starting";
        goto L45
    L36:
        if (r110 != 3) goto L38;
        r111 = "running";
        goto L45
    L38:
        if (r110 == 4) goto L40;
        r111 = "unknown";
        goto L45
    L40:
        r111 = "stopping";
        goto L45
    L44:
        r111 = "invalid";
        goto L45
    L54:
        return;
    L27:
        r107 = r100.length;
        goto L28
    L53:
        return;
    L22:
        if (r105.b() == false) goto L24;
        r103 = true;
        goto L24
    L51:
        return;
    L50:
        return;
    L11:
        if (r102.b() == false) goto L13;
        r104 = true;
        goto L14
    L49:
        return;
    }
}
