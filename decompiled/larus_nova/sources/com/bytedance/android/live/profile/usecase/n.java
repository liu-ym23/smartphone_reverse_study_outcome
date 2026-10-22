package com.bytedance.android.live.profile.usecase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements ut0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f87031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f87032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.profile.usecase.a f87033c;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f87034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f87035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ps0.b f87036c;

        public a(n r100, Context r101, ps0.b r102) {
            this.f87034a = r100;
            this.f87035b = r101;
            this.f87036c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r110) {
            n.e(this.f87034a, "confirm");
            n r111 = this.f87034a;
            Context r101 = this.f87035b;
            boolean r102 = !r111.f87031a;
            Disposable r103 = os0.b.b(r111.f87033c.getRoomDataCenter()).i(this.f87036c.getId(), r102, new o(r111, r102), new p(r111, r101));
            if (r103 == null) goto L5;
            r r112 = r111.f87033c.getNewProfileRequestManager();
            r112.getClass();
            Intrinsics.checkNotNullParameter(r103, "disposable");
            r112.f87052a.add(r103);
        L5:
            r100.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f87037a;

        public b(n r100) {
            this.f87037a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            n.e(this.f87037a, "cancel");
            r100.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f87038a;

        public c(n r100) {
            this.f87038a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            n.e(this.f87038a, "cancel");
        }
    }

    @Override // ut0.e
    public final MutableLiveData<Boolean> a() {
        return this.f87032b;
    }

    public n(com.bytedance.android.live.profile.usecase.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileViewModel");
        this.f87033c = r100;
        this.f87032b = new MutableLiveData();
    }

    @Override // ut0.e
    public final void b(boolean r100) {
        this.f87031a = r100;
        this.f87032b.postValue(Boolean.valueOf(r100));
    }

    @Override // ut0.e
    public final void showAnonymousUserSilentDialog(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        NewProfileTrackUseCase r100 = this.f87033c.getLogUseCase();
        boolean r101 = this.f87031a;
        r100.getClass();
        HashMap r102 = new HashMap();
        String r103 = "unmute";
        if (r101 == false) goto L5;
        Object r104 = "unmute";
    L6:
        r102.put("mute_type", r104);
        r100.B("livesdk_mute_click", r102);
        ps0.b r105 = this.f87033c.getRoom();
        x0.d r106 = new x0.d();
        r106.f162243b = r110;
        r106.f162242a = 4;
        if (this.f87031a == false) goto L9;
        int r107 = R.string.ttlive_unslient_anonymous_description;
    L10:
        r106.f162245d = s1.B(r107);
        String r108 = s1.B(R.string.ttlive_text_ensure);
        a r109 = new a(this, r110, r105);
        x0.c[] r111 = r106.f162248g;
        x0.c r112 = r111[0];
        if (r112 != null) goto L13;
        r112 = new x0.c();
        r111[0] = r112;
    L13:
        r112.f162239a = r108;
        r112.f162240b = r109;
        String r113 = s1.B(R.string.ttlive_text_cancel);
        b r114 = new b(this);
        x0.c[] r115 = r106.f162248g;
        x0.c r116 = r115[1];
        if (r116 != null) goto L16;
        r116 = new x0.c();
        r115[1] = r116;
    L16:
        r116.f162239a = r113;
        r116.f162240b = r114;
        r106.f162249h = new c(this);
        x0 r117 = new x0(r106.f162243b, r106);
        if (DialogLancet.shouldBlockDialogShow(r117) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r117);
    L21:
        HashMap r118 = new HashMap();
        if (this.f87031a == true) goto L25;
        r103 = ITTVideoEngineEventSource.KEY_MUTE;
    L25:
        r118.put("mute_type", r103);
        j0.l().sendLog("livesdk_mute_toast_show", r118, new Object[]{IRoom.class});
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L20:
        DialogLancet.beforeDialogShow(r117);
        r117.show();
        DialogLancet.afterDialogShow(r117);
        goto L21
    L9:
        r107 = R.string.ttlive_slient_anonymous_description;
        goto L10
    L5:
        r104 = ITTVideoEngineEventSource.KEY_MUTE;
        goto L6
    }

    public static final void e(n r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        if (r100.f87031a == false) goto L5;
        String r103 = "unmute";
    L6:
        r102.put("mute_type", r103);
        r102.put("click_type", r101);
        j0.l().sendLog("livesdk_mute_toast_click", r102, new Object[]{IRoom.class});
        return;
    L5:
        r103 = ITTVideoEngineEventSource.KEY_MUTE;
        goto L6
    }

    @Override // ut0.e
    public final void c(Context r110, UserProfileEvent r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ps0.b r100 = this.f87033c.getRoom();
        boolean r101 = this.f87033c.isVertical();
        if (NetworkUtils.f(r110) == true) goto L6;
        f2.b(R.string.ttlive_core_network_unavailable, 0);
        return;
    L6:
        NewProfileTrackUseCase r102 = this.f87033c.getLogUseCase();
        r102.getClass();
        com.bytedance.android.livesdk.chatroom.o r103 = os0.b.a();
        if (r103 != null) goto L9;
    L13:
        r102.B("livesdk_anchor_room_manage_click", r102.f86985e);
    L14:
        boolean r104 = this.f87033c.getPageTypeUseCase().f87043a;
        IBaseUser r105 = this.f87033c.getRoomUser();
        IRoom r106 = r100.b();
        if ((r106 instanceof IRoom) == true) goto L17;
        r106 = null;
    L17:
        IRoom r107 = r106;
        Dialog r112 = os0.b.b(this.f87033c.getRoomDataCenter()).f(r110, r107, r105, r104, r101, r111, Bundle.EMPTY);
        if (r112 != null) goto L20;
        return;
    L20:
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r112);
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        DialogLancet.beforeDialogShow(r112);
        r112.show();
        DialogLancet.afterDialogShow(r112);
        return;
    L9:
        if (r103.isMediaRoom() != true) goto L13;
        if (Intrinsics.areEqual(r103.isAnchor(), Boolean.TRUE) == false) goto L13;
        HashMap r108 = new HashMap(r102.f86985e);
        r108.put("live_type", "media");
        r102.B("livesdk_anchor_room_manage_click", r108);
        goto L14
    }

    @Override // ut0.e
    public final void d(Activity r100, UserProfileEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ps0.b r102 = this.f87033c.getRoom();
        IBaseUser r103 = this.f87033c.getRoomUser();
        this.f87033c.isVertical();
        IRoom r104 = r102.b();
        if ((r104 instanceof IRoom) == true) goto L5;
        r104 = null;
    L5:
        IRoom r105 = r104;
        if (r105 == null) goto L12;
        if (r101 == null) goto L13;
        IMiddlewareReportService r106 = (IMiddlewareReportService) jc1.k.f(IMiddlewareReportService.class);
        if (r106 == null) goto L14;
        y71.a r107 = new y71.a(ReportConstant$BusinessSource.NewProfile);
        r107.f566572a = r103;
        r107.f566573b = r105;
        r107.f566574c = r101.mSource;
        r107.f566575d = r101.mReportSource;
        r107.f566576e = r101.mReportTypeForLog;
        r107.f566577f = r101.mCommentReportModel;
        r107.a(r101.getReportObject());
        r106.report(r107);
        return;
    L14:
        return;
    L13:
        return;
    }
}
