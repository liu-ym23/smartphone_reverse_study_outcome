package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import hh1.v0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import uf2.d0;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/GuestLinkMainPageDialogForLinker;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/BaseGuestLinkMainPageDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestLinkMainPageDialogForLinker extends BaseGuestLinkMainPageDialog {
    public static final /* synthetic */ int P = 0;
    public boolean K;
    public long L;
    public IVoiceLiveTheme M;
    public final q N;
    public final j1 O;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f78457a = null;

        static {
            f78457a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f78458a = null;

        static {
            f78458a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkMainPageDialogForLinker f78459a;

        public d(GuestLinkMainPageDialogForLinker r100) {
            this.f78459a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "show helpPage");
            com.bytedance.android.live.base.model.message.guestlink.a r101 = this.f78459a.T90();
            if (r101 == null) goto L5;
            tb6.a.e(true, r101, "rules", null);
        L5:
            int r102 = com.bytedance.android.live.liveinteract.revenue.guestlink.a.f78416a;
            Context r103 = this.f78459a.requireContext();
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r104 = vm2.i.e().getGuidePanelSchema();
            String r105 = "";
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            String r106 = vm2.i.e().getGuidePanelUrl();
            if (r106 == null) goto L12;
            r105 = r106;
        L12:
            com.bytedance.android.live.liveinteract.revenue.guestlink.a.a(r103, r104, r105, null);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkMainPageDialogForLinker f78460a;

        public static final class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f78461a;

            public a(Ref.ObjectRef r100) {
                this.f78461a = r100;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                Dialog r102 = (Dialog) this.f78461a.element;
                if (r102 == null) goto L21;
                Handler r103 = DialogLancet.resolveDialogHandler(r102);
                if (r103 != null) goto L7;
            L9:
                DialogLancet.beforeDialogDismiss(r102);
                r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
            L18:
                DialogLancet.afterDialogDismiss(r102);
                goto L21
            L14:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
                Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
                if (r104 == null) goto L18;
                com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r102);
                throw th;
            L7:
                if (Looper.myLooper() == r103.getLooper()) goto L9;
                r103.post(DialogLancet.createDismissRunnable(r102));
            L21:
                ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel, negative button");
            }
        }

        public static final class b implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f78462a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f78463b;

            public b(e r100, Ref.ObjectRef r101) {
                this.f78462a = r100;
                this.f78463b = r101;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r110, int r111) {
                ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel, positive button");
                com.bytedance.android.live.base.model.message.guestlink.a r112 = this.f78462a.f78460a.T90();
                if (r112 == null) goto L23;
                long r100 = (p6.b() - r112.getStartTimeMs()) / ((long) 1000);
                int r113 = tb6.a.f545265a;
                tb6.a.e(true, r112, "double_end", Long.valueOf(r100));
                List<com.bytedance.android.live.base.model.message.guestlink.k> r114 = r112.getLinkedUsers();
                com.bytedance.android.live.base.model.message.guestlink.k r101 = null;
                Object r102 = null;
                if (r114 == null) goto L17;
                Iterator<T> r115 = r114.iterator();
            L8:
                if (r115.hasNext() == false) goto L16;
                Object r103 = r115.next();
                IBaseUser r104 = ((com.bytedance.android.live.base.model.message.guestlink.k) r103).getUser();
                if (r104 == null) goto L12;
                String r105 = r104.getIdString();
            L14:
                if (Intrinsics.areEqual(r105, je0.d.b0()) == false) goto L8;
                r102 = r103;
                goto L16
            L12:
                r105 = null;
            L16:
                r101 = (com.bytedance.android.live.base.model.message.guestlink.k) r102;
            L17:
                if (r101 != null) goto L19;
            L21:
                String r116 = "user";
            L22:
                tb6.a.d(true, r112, r116, r100);
                goto L23
            L19:
                if (com.bytedance.android.live.base.model.message.guestlink.l.a(r101) != true) goto L21;
                r116 = SourceType.DEFAULT;
            L23:
                Dialog r117 = (Dialog) this.f78463b.element;
                if (r117 == null) goto L42;
                Handler r118 = DialogLancet.resolveDialogHandler(r117);
                if (r118 != null) goto L28;
            L30:
                DialogLancet.beforeDialogDismiss(r117);
                r117.dismiss();     // Catch: Throwable -> L33 Exception -> L35
            L39:
                DialogLancet.afterDialogDismiss(r117);
                goto L42
            L33:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r117);
                throw th;
            L35:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
                Throwable r119 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
                if (r119 == null) goto L39;
                com.bytedance.crash.d.d(r119, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
                goto L39
            L28:
                if (Looper.myLooper() == r118.getLooper()) goto L30;
                r118.post(DialogLancet.createDismissRunnable(r117));
            L42:
                int r120 = vi0.b.f555007a;
                com.bytedance.android.live.base.model.message.guestlink.a r121 = this.f78462a.f78460a.T90();
                if (r121 == null) goto L46;
                String r122 = String.valueOf(r121.getChannelId());
                if (r122 == null) goto L46;
            L47:
                String r106 = String.valueOf(je0.d.a0());
                ChannelFinishReason r107 = ChannelFinishReason.LINKER;
                String r108 = r107.getRequestSource();
                Intrinsics.checkNotNullParameter(r122, RemoteMessageConst.Notification.CHANNEL_ID);
                Intrinsics.checkNotNullParameter(r106, "roomId");
                Intrinsics.checkNotNullParameter("", "errorMsg");
                Intrinsics.checkNotNullParameter(r108, "source");
                JSONObject r109 = new JSONObject();
                r109.put("channel_id", r122);
                r109.put("room_id", r106);
                r109.put("error", "");
                r109.put("source", r108);
                int r123 = rd0.a.f537202a;
                rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_channel_finish_api_call", 0, null, r109, 88);
                lb6.g r124 = this.f78462a.f78460a.D;
                if (r124 == null) goto L61;
                long r125 = je0.d.a0();
                com.bytedance.android.live.base.model.message.guestlink.a r126 = this.f78462a.f78460a.T90();
                if (r126 == null) goto L52;
                long r127 = r126.getChannelId();
            L53:
                r124.c(r125, r127, r107.getRequestSource(), r107.getRequestSource(), true);
                return;
            L52:
                r127 = 0;
                goto L53
            L61:
                return;
            L46:
                r122 = "";
                goto L47
            }
        }

        public e(GuestLinkMainPageDialogForLinker r100) {
            this.f78460a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, android.app.Dialog, com.bytedance.android.livesdk.widget.x0, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "click finishChannel");
            if (this.f78460a.T90() != null) goto L12;
            ALogger.e("GuestLinkMainPageDialogForLinker", "click finishChannel, channelInfo is null");
            this.f78460a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L32;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L32:
            return;
        L12:
            com.bytedance.android.live.base.model.message.guestlink.a r102 = this.f78460a.T90();
            if (r102 == null) goto L15;
            long r103 = (p6.b() - r102.getStartTimeMs()) / ((long) 1000);
            int r104 = tb6.a.f545265a;
            tb6.a.e(true, r102, "end", Long.valueOf(r103));
        L15:
            Ref.ObjectRef r105 = new Ref.ObjectRef();
            r105.element = null;
            String r106 = vm2.i.e().getLinkerFinishChannelDoubleCheckTitle();
            if (r106 != null) goto L18;
            r106 = s1.B(R.string.ttlive_guest_link_finish_channel_title_for_linker);
        L18:
            String r107 = vm2.i.e().getLinkerFinishChannelDoubleCheckMsg();
            if (r107 != null) goto L21;
            r107 = s1.B(R.string.ttlive_guest_link_finish_channel_message_for_linker);
        L21:
            x0.b r108 = new x0.b(this.f78460a.requireContext(), 0);
            x0.d r109 = r108.f162238a;
            r109.f162244c = r106;
            r109.f162245d = r107;
            r108.setCornerRadius(16.0f);
            r108.i(0, R.string.ttlive_guest_link_finish_channel_negative, new a(r105));
            r108.i(1, R.string.ttlive_guest_link_finish_channel_positive, new b(this, r105));
            ?? r110 = r108.h();
            r105.element = r110;
            if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L30;
            DialogLancet.handleBlockedDialogShow(r110);
            return;
        L30:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L25:
            DialogLancet.beforeDialogShow(r110);
            r110.show();
            DialogLancet.afterDialogShow(r110);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkMainPageDialogForLinker f78464a;

        public f(GuestLinkMainPageDialogForLinker r100) {
            this.f78464a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            ALogger.i("GuestLinkMainPageDialogForLinker", "click send gift");
            com.bytedance.android.live.base.model.message.guestlink.a r100 = this.f78464a.T90();
            if (r100 == null) goto L46;
            com.bytedance.android.live.base.model.message.guestlink.k r101 = null;
            Object r102 = null;
            tb6.a.e(true, r100, PbRequest.SwitchType.GIFT, null);
            long r103 = r100.getChannelId();
            List<com.bytedance.android.live.base.model.message.guestlink.k> r104 = r100.getLinkedUsers();
            if (r104 == null) goto L18;
            Iterator<T> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L16;
            Object r106 = r105.next();
            IBaseUser r107 = ((com.bytedance.android.live.base.model.message.guestlink.k) r106).getUser();
            if (r107 == null) goto L12;
            String r108 = r107.getIdString();
        L14:
            if (Intrinsics.areEqual(r108, je0.d.b0()) == false) goto L8;
        L17:
            com.bytedance.android.live.base.model.message.guestlink.k r109 = (com.bytedance.android.live.base.model.message.guestlink.k) r106;
        L19:
            List<com.bytedance.android.live.base.model.message.guestlink.k> r111 = r100.getLinkedUsers();
            if (r111 == null) goto L32;
            Iterator<T> r112 = r111.iterator();
        L23:
            if (r112.hasNext() == false) goto L31;
            Object r113 = r112.next();
            IBaseUser r114 = ((com.bytedance.android.live.base.model.message.guestlink.k) r113).getUser();
            if (r114 == null) goto L27;
            String r115 = r114.getIdString();
        L29:
            if ((!Intrinsics.areEqual(r115, je0.d.b0())) == false) goto L23;
            r102 = r113;
            goto L31
        L27:
            r115 = null;
        L31:
            r101 = (com.bytedance.android.live.base.model.message.guestlink.k) r102;
        L32:
            if (r109 == null) goto L38;
            if (r101 == null) goto L38;
            g50.c r116 = (g50.c) jc1.k.f(g50.c.class);
            if (r116 == null) goto L47;
            IBaseUser r117 = r101.getUser();
            Bundle r118 = new Bundle();
            r118.putString("gift_show_from", "audience_linkingpage");
            r118.putLong("guest_link_channel_id", r103);
            Unit r119 = Unit.INSTANCE;
            r116.openGiftDialog(r117, r118);
            return;
        L47:
            return;
        L38:
            ALogger.e("GuestLinkMainPageDialogForLinker", "send gift failed, cause: selfUser: " + r109 + ", targetUser: " + r101);
            return;
        L12:
            r108 = null;
            goto L14
        L16:
            r106 = null;
            goto L17
        L18:
            r109 = null;
            goto L19
        }
    }

    public static final class g implements rb6.a.InterfaceC7456a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkMainPageDialogForLinker f78465a;

        public g(GuestLinkMainPageDialogForLinker r100) {
            this.f78465a = r100;
        }

        @Override // rb6.a.InterfaceC7456a
        public final void W(long r100, OperateType r101) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            ALogger.d("GuestLinkMainPageDialogForLinker", "onPermissionCheckSuccess");
        }

        @Override // rb6.a.InterfaceC7456a
        public final void c1(long r100, OperateType r101, BaseCheckException r102) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            ALogger.d("GuestLinkMainPageDialogForLinker", "onPermissionCheckFailed");
            this.f78465a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L12;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void ca0() {
        super.ca0();
        View r100 = this.f78420d;
        if (r100 == null) goto L8;
        View r101 = r100.findViewById(R.id.live_surface_view_container);
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void initView() {
        super.initView();
        setBottomSheetSlideProcessor(b.f78457a);
        Dialog r100 = getDialog();
        if (r100 == null) goto L9;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        View r102 = r101.findViewById(R.id.ttlive_touch_outside);
        if (r102 == null) goto L9;
        r102.setOnClickListener(c.f78458a);
    L9:
        View r103 = this.f78435s;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        TextView r104 = this.f78436t;
        if (r104 == null) goto L19;
        String r105 = vm2.i.e().getLinkerPageTitle();
        if (r105 != null) goto L18;
        r105 = s1.B(R.string.ttlive_guest_link_title_for_linker);
    L18:
        r104.setText(r105);
    L19:
        HSImageView r106 = this.f78432p;
        if (r106 == null) goto L22;
        r106.setVisibility(0);
    L22:
        HSImageView r107 = this.f78432p;
        if (r107 == null) goto L25;
        r107.setOnClickListener(new d(this));
    L25:
        Button r108 = this.f78433q;
        if (r108 == null) goto L32;
        String r109 = vm2.i.e().getLinkerPageLeftBtnText();
        if (r109 != null) goto L31;
        r109 = s1.B(R.string.ttlive_guest_link_finish_channel);
    L31:
        r108.setText(r109);
    L32:
        Button r110 = this.f78433q;
        if (r110 == null) goto L35;
        r110.setOnClickListener(new e(this));
    L35:
        Button r111 = this.f78434r;
        if (r111 == null) goto L42;
        String r112 = vm2.i.e().getLinkerPageRightBtnText();
        if (r112 != null) goto L41;
        r112 = s1.B(R.string.ttlive_guest_link_send_gift);
    L41:
        r111.setText(r112);
    L42:
        this.f78434r.setOnClickListener(new f(this));
        if (this.L > 0) goto L45;
        aa0(-1);
    L45:
        lb6.g r113 = this.D;
        FrameLayout r114 = null;
        if (r113 == null) goto L52;
        ob6.a r115 = r113.j();
        if (r115 == null) goto L52;
        ec6.a r116 = r115.n();
        if (r116 == null) goto L52;
        v0 r117 = gc6.b.b(r116);
    L54:
        if ((r117 instanceof m00.g) == true) goto L56;
        v0 r118 = null;
    L57:
        m00.g r119 = (m00.g) r118;
        if (r119 == null) goto L60;
        SurfaceView r120 = r119.getSurfaceView();
    L61:
        ALogger.e("GuestLinkMainPageDialogForLinker", "addSurfaceView: surfaceView: " + r120);
        if (r120 == null) goto L84;
        ViewParent r121 = r120.getParent();
        if ((r121 instanceof ViewGroup) == true) goto L67;
        r121 = null;
    L67:
        ViewGroup r122 = (ViewGroup) r121;
        if (r122 == null) goto L70;
        r122.removeView(r120);
    L70:
        Dialog r123 = getDialog();
        if (r123 == null) goto L75;
        Window r124 = r123.getWindow();
        if (r124 == null) goto L75;
        r114 = (FrameLayout) r124.findViewById(R.id.live_surface_view_container);
    L75:
        if (r114 != null) goto L77;
    L79:
        com.bytedance.android.live.pushstream.d r125 = ((m00.g) r117).getLiveStream();
        if (r125 == null) goto L83;
        r125.O(true);
        return;
    L83:
        return;
    L77:
        if (r114.indexOfChild(r120) != (-1)) goto L79;
        r114.addView(r120);
        goto L79
    L84:
        return;
    L60:
        r120 = null;
        goto L61
    L56:
        r118 = r117;
    L52:
        r117 = null;
        goto L54
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        lb6.g r100 = this.D;
        if (r100 == null) goto L11;
        sb6.a r101 = r100.getLinkState();
        if (r101 == null) goto L11;
        if (r101.f541252a != true) goto L11;
        ALogger.e("GuestLinkMainPageDialogForLinker", "onDestroy -> finishChannel");
        lb6.g r102 = this.D;
        if (r102 == null) goto L11;
        r102.k("GuestLinkMainPageDialogForLinker#onDestroy");
    L11:
        lb6.g r103 = this.D;
        if (r103 == null) goto L20;
        ob6.a r104 = r103.j();
        if (r104 == null) goto L20;
        ei6.a r105 = r104.A();
        if (r105 == null) goto L20;
        gi6.e r106 = r105.getEventManager();
        if (r106 == null) goto L20;
        r106.b(null);
    L20:
        Lazy r107 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().b(this.N);
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k ga0(com.bytedance.android.live.base.model.message.guestlink.a r100) {
        List<com.bytedance.android.live.base.model.message.guestlink.k> r101 = r100.getLinkedUsers();
        Object r102 = null;
        if (r101 == null) goto L19;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        IBaseUser r105 = ((com.bytedance.android.live.base.model.message.guestlink.k) r104).getUser();
        if (r105 == null) goto L10;
        String r106 = r105.getIdString();
    L12:
        if (Intrinsics.areEqual(r106, je0.d.b0()) == false) goto L6;
        r102 = r104;
        goto L15
    L10:
        r106 = null;
    L15:
        return (com.bytedance.android.live.base.model.message.guestlink.k) r102;
    L19:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void Z90(com.bytedance.android.live.base.model.message.guestlink.a r110) {
        Intrinsics.checkNotNullParameter(r110, "channelInfo");
        if (this.K == true) goto L11;
        List<com.bytedance.android.live.base.model.message.guestlink.k> r100 = r110.getLinkedUsers();
        if (r100 == null) goto L7;
        int r101 = r100.size();
    L9:
        if (r101 < 2) goto L11;
        this.K = true;
        tb6.a.f(true, r110);
        int r102 = vi0.b.f555007a;
        String r103 = String.valueOf(r110.getChannelId());
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.Notification.CHANNEL_ID);
        JSONObject r104 = new JSONObject();
        r104.put("channel_id", r103);
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_full_channel_info", 0, null, r104, 88);
        goto L11
    L7:
        r101 = 0;
    L11:
        ha0(fa0(r110, BaseGuestLinkMainPageDialog.U90(r110)), 0);
        ha0(fa0(r110, BaseGuestLinkMainPageDialog.V90(r110)), 1);
        super.Z90(r110);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        ALogger.d("GuestLinkMainPageDialogForLinker", "BaseGuestLinkMainPageDialog#onSaveInstanceState: channelInfo: " + T90());
        com.bytedance.android.live.base.model.message.guestlink.a r101 = T90();
        if (r101 == null) goto L6;
        r100.putString("channel_info", com.bytedance.android.annie.api.data.subscribe.d.c(r101));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        if (this.D != null) goto L12;
        ALogger.d("GuestLinkMainPageDialogForLinker", "BaseGuestLinkMainPageDialog#onViewStateRestored: mLinkService is null, dialog dismiss");
        dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L31;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L31:
        return;
    L12:
        if (r100 == null) goto L16;
        String r102 = r100.getString("channel_info");
        if (r102 == null) goto L16;
        Gson r103 = com.bytedance.android.annie.api.data.subscribe.d.f38409a;
        com.bytedance.android.live.base.model.message.guestlink.a r104 = (com.bytedance.android.live.base.model.message.guestlink.a) com.bytedance.android.annie.api.data.subscribe.d.a(r102, com.bytedance.android.live.base.model.message.guestlink.a.class);
    L17:
        ALogger.d("GuestLinkMainPageDialogForLinker", "appEnterBackground: channelInfo: " + r104);
        if (r104 == null) goto L27;
        com.bytedance.android.live.base.model.message.guestlink.k r105 = ga0(r104);
        if (r105 == null) goto L22;
        int r106 = r105.getLinkType();
    L23:
        ALogger.d("GuestLinkMainPageDialogForLinker", "appEnterBackground: linkType: " + r106);
        lb6.g r107 = this.D;
        if (r107 == null) goto L26;
        r107.a(r106, new g(this));
    L26:
        Z90(r104);
        goto L27
    L22:
        r106 = 2;
    L27:
        this.C = r104;
        return;
    L16:
        r104 = null;
        goto L17
    }

    public GuestLinkMainPageDialogForLinker(GuestLinkWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "outerScopeProvider");
        super(r100, r101);
        this.O = r100;
        this.N = new q(this);
    }

    public static void ha0(z.a r100, int r101) {
        ALogger.e("GuestLinkMainPageDialogForLinker", "setLinkerUserLayer: position: " + r101 + ", targetLayer: " + r100);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r102 = ILiveWrappedLivePusher.a.b();
        m1.b r103 = null;
        if (r102 == null) goto L5;
        r103 = r102.newVideoMixerDescription(null);
    L5:
        if (r101 != 0) goto L20;
        if (r103 == null) goto L8;
        r103.e();
    L8:
        if (r103 == null) goto L10;
        r103.b();
    L10:
        if (r103 == null) goto L12;
        r103.c();
    L12:
        if (r103 == null) goto L14;
        r103.f();
    L14:
        if (r103 == null) goto L16;
        r103.i();
    L16:
        if (r103 == null) goto L18;
        r103.g();
    L18:
        if (r103 == null) goto L34;
        r103.h();
    L34:
        if (r100 == null) goto L37;
        r100.b();
        return;
    L37:
        return;
    L20:
        if (r103 == null) goto L22;
        r103.e();
    L22:
        if (r103 == null) goto L24;
        r103.b();
    L24:
        if (r103 == null) goto L26;
        r103.c();
    L26:
        if (r103 == null) goto L28;
        r103.f();
    L28:
        if (r103 == null) goto L30;
        r103.i();
    L30:
        if (r103 == null) goto L32;
        r103.g();
    L32:
        if (r103 == null) goto L34;
        r103.h();
        goto L34
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void X90(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        if (T90() != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.base.model.message.guestlink.a r102 = T90();
        Intrinsics.checkNotNull(r102);
        List<com.bytedance.android.live.base.model.message.guestlink.k> r103 = r102.getLinkedUsers();
        com.bytedance.android.live.base.model.message.guestlink.k r104 = null;
        Object r105 = null;
        if (r103 == null) goto L14;
        Iterator<T> r106 = r103.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.base.model.message.guestlink.k) r107).getLinkmicIdStr(), r100) == false) goto L9;
        r105 = r107;
    L13:
        r104 = (com.bytedance.android.live.base.model.message.guestlink.k) r105;
    L14:
        ALogger.d("GuestLinkMainPageDialogForLinker", "onRemoteVideoMute linker: " + r104 + ", interactId: " + r100 + ", mute: " + r101);
        if (r104 != null) goto L17;
        return;
    L17:
        if (r104.getLinkType() == 1) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L21;
        long r108 = 1;
    L22:
        r104.setBackground(r108);
        com.bytedance.android.live.base.model.message.guestlink.a r109 = T90();
        Intrinsics.checkNotNull(r109);
        Z90(r109);
        return;
    L21:
        r108 = 0;
        goto L22
    }

    public final z.a fa0(com.bytedance.android.live.base.model.message.guestlink.a r100, com.bytedance.android.live.base.model.message.guestlink.k r101) {
        lb6.g r102 = this.D;
        if (r102 == null) goto L11;
        ob6.a r103 = r102.j();
        if (r103 == null) goto L11;
        ec6.a r104 = r103.n();
        if (r104 == null) goto L11;
        sk0.c r105 = r104.r();
        if (r105 == null) goto L11;
        com.bytedance.android.live.pushstream.d r106 = gc6.b.a(r105);
    L13:
        if (Intrinsics.areEqual(r101, ga0(r100)) == false) goto L20;
        if (r106 == null) goto L52;
        d0 r107 = r106.getLiveCore();
        if (r107 == null) goto L53;
        z r108 = r107.C();
        if (r108 != null) goto L55;
        return null;
    L55:
        return r108.K0();
    L53:
        return null;
    L52:
        return null;
    L20:
        StringBuilder r109 = new StringBuilder("getLayerDescription: linkmic_id_str: ");
        if (r101 == null) goto L23;
        String r110 = r101.getLinkmicIdStr();
    L24:
        r109.append(r110);
        r109.append(", layer: ");
        if (r106 == null) goto L33;
        d0 r111 = r106.getLiveCore();
        if (r111 == null) goto L33;
        z r112 = r111.C();
        if (r112 == null) goto L33;
        if (r101 == null) goto L32;
        r101.getLinkmicIdStr();
    L32:
        z.a r113 = r112.l();
    L34:
        r109.append(r113);
        r109.append(", layerControlSize: ");
        if (r106 == null) goto L41;
        d0 r114 = r106.getLiveCore();
        if (r114 == null) goto L41;
        z r115 = r114.C();
        if (r115 == null) goto L41;
        Integer r116 = Integer.valueOf(r115.g());
    L42:
        r109.append(r116);
        r109.append(",targetLinkerUser: ");
        r109.append(r101);
        ALogger.d("GuestLinkMainPageDialogForLinker", r109.toString());
        if (r106 == null) goto L56;
        d0 r117 = r106.getLiveCore();
        if (r117 == null) goto L57;
        z r118 = r117.C();
        if (r118 == null) goto L58;
        if (r101 == null) goto L51;
        r101.getLinkmicIdStr();
    L51:
        return r118.l();
    L58:
        return null;
    L57:
        return null;
    L56:
        return null;
    L41:
        r116 = null;
    L33:
        r113 = null;
        goto L34
    L23:
        r110 = null;
    L11:
        r106 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog, com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ALogger.i("GuestLinkMainPageDialogForLinker", "onViewCreated");
        super.onViewCreated(r100, r101);
        da0(this.M);
        Lazy r102 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().a(this.N);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.BaseGuestLinkMainPageDialog
    public final void Y90(String[] r100, boolean[] r110, int[] r111) {
        Integer r101 = null;
        if (T90() == null) goto L27;
        if (r100 == null) goto L27;
        if (r111 == null) goto L27;
        if (r100.length != r111.length) goto L27;
        int r112 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r102 >= r112) goto L26;
        String r104 = r100[r102];
        com.bytedance.android.live.base.model.message.guestlink.a r105 = T90();
        Intrinsics.checkNotNull(r105);
        com.bytedance.android.live.base.model.message.guestlink.k r106 = BaseGuestLinkMainPageDialog.U90(r105);
        if (r106 == null) goto L14;
        String r107 = r106.getLinkmicIdStr();
    L16:
        if (Intrinsics.areEqual(r104, r107) == false) goto L18;
        ea0(r106, this.f78441y, this.f78439w, r111[r103]);
    L18:
        com.bytedance.android.live.base.model.message.guestlink.a r108 = T90();
        Intrinsics.checkNotNull(r108);
        com.bytedance.android.live.base.model.message.guestlink.k r109 = BaseGuestLinkMainPageDialog.V90(r108);
        if (r109 == null) goto L21;
        String r113 = r109.getLinkmicIdStr();
    L23:
        if (Intrinsics.areEqual(r104, r113) == false) goto L25;
        ea0(r109, this.f78442z, this.f78440x, r111[r103]);
    L25:
        r103 = r103 + 1;
        r102 = r102 + 1;
        goto L10
    L21:
        r113 = null;
        goto L23
    L14:
        r107 = null;
        goto L16
    L26:
        return;
    L27:
        StringBuilder r114 = new StringBuilder("onTalkStateUpdated: return, channelInfo: ");
        r114.append(T90());
        r114.append(", talkVolumes: ");
        r114.append(r111);
        r114.append(",  linkIds.size != talkVolumes.size: ");
        if (r100 == null) goto L30;
        Integer r115 = Integer.valueOf(r100.length);
    L31:
        if (r111 == null) goto L33;
        r101 = Integer.valueOf(r111.length);
    L33:
        r114.append(!Intrinsics.areEqual(r115, r101));
        r114.append(' ');
        ALogger.d("GuestLinkMainPageDialogForLinker", r114.toString());
        return;
    L30:
        r115 = null;
        goto L31
    }
}
