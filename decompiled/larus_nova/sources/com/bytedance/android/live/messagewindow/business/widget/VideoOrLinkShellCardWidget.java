package com.bytedance.android.live.messagewindow.business.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import zg1.l3;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/widget/VideoOrLinkShellCardWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoOrLinkShellCardWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v61.a f83014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v61.a f83015b;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        v61.a r100 = this.f83014a;
        if (r100 == null) goto L5;
        wq(r100);
    L5:
        v61.a r101 = this.f83015b;
        if (r101 == null) goto L8;
        wq(r101);
    L8:
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L12;
        r102.removeObserver(this);
        return;
    }

    public VideoOrLinkShellCardWidget() {
    }

    public static void wq(v61.a r100) {
        if (r100.isShowing() == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.dismiss();
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        v61.a r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 == null) goto L73;
        int r104 = r103.hashCode();
        if (r104 == (-1130046128)) goto L40;
        if (r104 == (-261927283)) goto L14;
        return;
    L14:
        if (r103.equals("cmd_video_talkroom_state_change") == false) goto L60;
        if (r101 == null) goto L36;
        Object r105 = r101.getData();
        if ((r105 instanceof l3) == true) goto L19;
        r105 = null;
    L19:
        l3 r106 = (l3) r105;
        if (r106 == null) goto L36;
        if (r106.f571872a != 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == true) goto L28;
        r106 = null;
    L28:
        if (r106 == null) goto L36;
        v61.a r108 = this.f83014a;
        if (r108 != null) goto L32;
        return;
    L32:
        if ((!r108.isShowing()) == false) goto L34;
        r102 = r108;
    L34:
        if (r102 == null) goto L62;
        r102.show();
        return;
    L62:
        return;
    L24:
        r107 = false;
    L36:
        v61.a r109 = this.f83014a;
        if (r109 == null) goto L64;
        wq(r109);
        Unit r110 = Unit.INSTANCE;
        return;
    L64:
        return;
    L60:
        return;
    L40:
        if (r103.equals("cmd_interact_player_view_change") == false) goto L66;
        if (r101 == null) goto L67;
        Object r111 = r101.getData();
        if ((r111 instanceof kd0.a) == true) goto L45;
        r111 = null;
    L45:
        kd0.a r112 = (kd0.a) r111;
        if (r112 != null) goto L48;
        return;
    L48:
        if (r112.f502709a == false) goto L56;
        v61.a r113 = this.f83015b;
        if (r113 != null) goto L52;
        return;
    L52:
        if ((!r113.isShowing()) == false) goto L54;
        r102 = r113;
    L54:
        if (r102 == null) goto L70;
        r102.show();
        return;
    L70:
        return;
    L56:
        v61.a r114 = this.f83015b;
        if (r114 == null) goto L72;
        wq(r114);
        return;
    L72:
        return;
    L67:
        return;
    L66:
        return;
    L73:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        if (v71.a.c() == true) goto L5;
        return;
    L5:
        IMsgWindowService r101 = (IMsgWindowService) k.f(IMsgWindowService.class);
        dm0.a r102 = null;
        if (r101 == null) goto L12;
        u61.a r103 = r101.cardBuilder();
        if (r103 == null) goto L12;
        cm0.a r104 = r103.a(new AnonymousClass1(this));
        if (r104 == null) goto L12;
        dm0.a r105 = r104.b();
    L13:
        this.f83014a = r105;
        IMsgWindowService r106 = (IMsgWindowService) k.f(IMsgWindowService.class);
        if (r106 == null) goto L20;
        u61.a r107 = r106.cardBuilder();
        if (r107 == null) goto L20;
        cm0.a r108 = r107.a(new AnonymousClass2(this));
        if (r108 == null) goto L20;
        r102 = r108.b();
    L20:
        this.f83015b = r102;
        DataCenter r109 = this.dataCenter;
        if (r109 == null) goto L26;
        DataCenter r110 = r109.observe("cmd_interact_player_view_change", this);
        if (r110 == null) goto L27;
        r110.observe("cmd_video_talkroom_state_change", this);
        return;
    L27:
        return;
    L26:
        return;
    L12:
        r105 = null;
        goto L13
    }
}
