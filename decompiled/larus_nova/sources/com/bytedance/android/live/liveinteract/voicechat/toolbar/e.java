package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.util.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f80821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f80822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRoom f80823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f80824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f80825e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f80826a;

        public a(e r100) {
            this.f80826a = r100;
        }

        public final void a() {
            i0 r100 = TalkRoomLogUtils.f77433a;
            TalkRoomLogUtils.o1(this.f80826a.f80825e);
            li0.b r101 = li0.b.f509313b;
            String r102 = this.f80826a.f80825e;
            Intrinsics.checkNotNullParameter("grouppk_icon", "requestPage");
            Intrinsics.checkNotNullParameter(r102, "source");
            LinkedHashMap r103 = new LinkedHashMap();
            TalkRoomLogUtils.B0(r103, null, null, 6);
            r103.put("request_page", "grouppk_icon");
            TalkRoomLogUtils.i1(r103);
            r103.put("source", r102);
            j0.l().sendLog("livesdk_grouppk_icon_show", r103, new Object[]{IRoom.class});
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public e() {
        this.f80824d = new CompositeDisposable();
        this.f80825e = OpenPanelSource.PK_ICON.getValue();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        com.bytedance.android.live.liveinteract.revenue.fight.b r101 = ((IInteractService) k.n(IInteractService.class)).teamFightService();
        if (r101 == null) goto L6;
        r101.d0(mi0.g.f514045b, new mi0.b("grouppk_icon", this.f80825e));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void setAlpha(float r100) {
        View r101 = this.f80821a;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f80824d.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f80821a = r100;
        r100.getContext();
        this.f80822b = a0.m(r101).f66429c;
        this.f80823c = a0.n(r101);
        if (this.f80822b == true) goto L5;
        return;
    L5:
        View r102 = this.f80821a;
        if (r102 == null) goto L9;
        r102.post(new a(this));
        return;
    }
}
