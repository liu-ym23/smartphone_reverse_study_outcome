package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemAdapter;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.config.w7;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/LinkPKAudienceInteractDynamicEmojiDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/BaseAudienceInteractDynamicEmojiDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractDynamicEmojiDialog extends BaseAudienceInteractDynamicEmojiDialog {
    public static final /* synthetic */ int D = 0;
    public com.bytedance.android.live.livepkaudience.emoji.panel.l B;
    public com.bytedance.android.live.livepkaudience.emoji.panel.a C;

    public static final class a {
        public a() {
        }

        public static LinkPKAudienceInteractDynamicEmojiDialog a(Context r100, DataCenter r101) {
            int r102 = LinkPKAudienceInteractDynamicEmojiDialog.D;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "dataCenter");
            Intrinsics.checkNotNullParameter("seat", "requestPage");
            ALogger.i("LinkPKAudienceInteractDynamicEmojiDialog", "new instance link pk audience from seat");
            LinkPKAudienceInteractDynamicEmojiDialog r103 = new LinkPKAudienceInteractDynamicEmojiDialog(r100, r101, true);
            Intrinsics.checkNotNullParameter("seat", "<set-?>");
            r103.f81878t = "seat";
            return r103;
        }
    }

    public static final class b implements com.bytedance.android.live.livepkaudience.vm.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkPKAudienceInteractDynamicEmojiDialog f81914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f81915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f81916c;

        @Override // com.bytedance.android.live.livepkaudience.vm.a
        public final void onSuccess() {
            LinkPKAudienceInteractDynamicEmojiDialog r100 = this.f81914a;
            r100.getClass();
            BaseAudienceInteractDynamicEmojiDialog.M0(r100);
            String r101 = "switchCamera onSuccess openCamera : " + this.f81915b + ", skipShowBeauty: " + this.f81916c;
            ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", r101);
            dl0.m.f469074a.getClass();
            dl0.m.C("LinkPKAudienceInteractDynamicEmojiDialog_switchCamera", r101);
            if (this.f81915b == false) goto L5;
            this.f81914a.getClass();
            HashMap r102 = new HashMap();
            r102.put("user_type", "guest");
            r102.put("filp_status", "before");
            r102.put("scene_type", "normal");
            el0.j.k(r102);
            el0.j.m(r102);
            el0.j.n(r102, 1);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_connection_user_camera_open_success", r102, new Object[]{am2.x.class, Room.class});
        L7:
            if (this.f81915b == false) goto L9;
            return;
        L9:
            if (this.f81916c == false) goto L17;
            LinkPKAudienceInteractDynamicEmojiDialog r103 = this.f81914a;
            r103.getClass();
            com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r104 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r104 == null) goto L13;
            m00.g r105 = r104.go();
        L14:
            n r106 = new n(r103, r105);
            LivePluginSPIManager.f85856e.getClass();
            LivePluginSPIManager.a().addOnSuccess(new m(r103, r106)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
            return;
        L13:
            r105 = null;
            goto L14
        L17:
            return;
        L5:
            cl0.a r107 = cl0.a.f24084d;
            LinkedHashMap r108 = new LinkedHashMap();
            com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();
            com.bytedance.android.live.core.privacy.av.api.b.a.C1072a r109 = com.bytedance.android.live.core.privacy.av.api.b.a.f65135a;
            com.bytedance.android.live.core.privacy.av.api.a r110 = com.bytedance.android.live.core.privacy.av.api.a.f65132b;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r108, "params");
            Intrinsics.checkNotNullParameter(r109, "callback");
            Intrinsics.checkNotNullParameter(r110, "config");
            r107.e("close_camera_by_self", r108, r109, r110);
            goto L7
        }

        @Override // com.bytedance.android.live.livepkaudience.vm.a
        public final void onError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            LinkPKAudienceInteractDynamicEmojiDialog r101 = this.f81914a;
            r101.getClass();
            BaseAudienceInteractDynamicEmojiDialog.M0(r101);
        }

        public b(LinkPKAudienceInteractDynamicEmojiDialog r100, boolean r101, boolean r102) {
            this.f81914a = r100;
            this.f81915b = r101;
            this.f81916c = r102;
        }
    }

    static {
        new a();
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final boolean Q0() {
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final int R0() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void P0() {
        if (this.f81871m == false) goto L6;
        return;
    L6:
        if (this.f81872n == false) goto L8;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r100 = new com.bytedance.android.live.livepkaudience.emoji.panel.n(this);
    L9:
        this.f81880v = r100;
        ((ArrayList) this.f81879u).add(r100);
        return;
    L8:
        r100 = new com.bytedance.android.live.livepkaudience.emoji.panel.k(this);
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void T0() {
        o r100 = new o(this.f81871m, this.f81883y);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f81865g = r100;
        r100.f531633a = this;
        d r101 = this.f81865g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        if (r101 == null) goto L9;
        o r102 = (o) r101;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractDynamicEmojiPresenter");
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void U0() {
        String r100 = this.f81878t;
        int r101 = r100.hashCode();
        if (r101 != (-1383228885)) goto L5;
        r100.equals("bottom");
    L9:
        com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r102 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r102 == null) goto L12;
        com.bytedance.android.live.livepkaudience.service.d.b.b(r102);
    L12:
        int r103 = al0.c.f4120b;
        String r104 = tc0.c.h().G;
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        al0.c.c(r104);
        return;
    L5:
        if (r101 != 3526149) goto L9;
        r100.equals("seat");
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void w5() {
        LifecycleOwner r100 = this.f81883y.lifecycleOwner;
        boolean r101 = r100 instanceof Fragment;
        Context r102 = null;
        if (r101 == false) goto L15;
        if (r101 == true) goto L6;
        r100 = null;
    L6:
        Fragment r103 = (Fragment) r100;
        if (r103 == null) goto L9;
        Context r104 = r103.getContext();
    L11:
        if ((r104 instanceof FragmentActivity) == false) goto L14;
        r102 = r104;
    L14:
        r102 = (FragmentActivity) r102;
    L20:
        if (r102 != null) goto L23;
        ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", "fragmentActivity is null context:" + this.f81883y.lifecycleOwner.getClass());
        return;
    L23:
        BaseAudienceInteractDynamicEmojiDialog.M0(this);
        z5(2, true);
        return;
    L9:
        r104 = null;
        goto L11
    L15:
        boolean r105 = r100 instanceof FragmentActivity;
        if (r105 == false) goto L20;
        if (r105 == true) goto L19;
        r100 = null;
    L19:
        r102 = (FragmentActivity) r100;
        goto L20
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void O0() {
        if (hd0.c.f().h() == false) goto L41;
        boolean r100 = this.f81871m;
        int r101 = dl0.t.f469082a;
        ArrayList r102 = new ArrayList();
        if (r100 == false) goto L7;
        r102.add(1);
    L13:
        if (r102.size() <= 1) goto L42;
        com.bytedance.android.live.livepkaudience.emoji.panel.b r103 = new com.bytedance.android.live.livepkaudience.emoji.panel.b(this, new com.bytedance.android.live.livepkaudience.emoji.panel.c(CollectionsKt.toIntArray(r102), this.f81873o));
        ListProtector.add(this.f81879u, 0, r103);
        int r104 = this.f81873o;
        com.bytedance.android.live.livepkaudience.emoji.panel.c r105 = r103.f81978b;
        if (r105 == null) goto L40;
        r105.f81980b = r104;
        com.bytedance.android.live.livepkaudience.emoji.panel.l r106 = this.B;
        if (r106 == null) goto L19;
        ((ArrayList) this.f81879u).remove(r106);
    L19:
        com.bytedance.android.live.livepkaudience.emoji.panel.a r107 = this.C;
        if (r107 == null) goto L22;
        ((ArrayList) this.f81879u).remove(r107);
    L22:
        if (r104 == 1) goto L25;
    L36:
        LinkPKAudienceInteractPanelItemAdapter r108 = this.f81863e;
        if (r108 == null) goto L43;
        r108.notifyDataSetChanged();
        return;
    L43:
        return;
    L25:
        if (this.f81871m == true) goto L36;
        if (this.B != null) goto L30;
        this.B = new com.bytedance.android.live.livepkaudience.emoji.panel.l(this);
    L30:
        if (this.C != null) goto L32;
        this.C = new com.bytedance.android.live.livepkaudience.emoji.panel.a(this);
    L32:
        com.bytedance.android.live.livepkaudience.emoji.panel.g r109 = this.f81880v;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r110 = r103;
        if (r109 == null) goto L35;
        r110 = r109;
    L35:
        int r111 = CollectionsKt.indexOf(this.f81879u, r110);
        List<com.bytedance.android.live.livepkaudience.emoji.panel.g> r112 = this.f81879u;
        int r113 = r111 + 1;
        com.bytedance.android.live.livepkaudience.emoji.panel.a r114 = this.C;
        Intrinsics.checkNotNull(r114);
        ListProtector.add(r112, r113, r114);
        List<com.bytedance.android.live.livepkaudience.emoji.panel.g> r115 = this.f81879u;
        com.bytedance.android.live.livepkaudience.emoji.panel.l r116 = this.B;
        Intrinsics.checkNotNull(r116);
        ListProtector.add(r115, r113, r116);
        goto L36
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.panel.DigitShowModeData");
    L42:
        return;
    L7:
        r102.add(2);
        if (w7.f121501a.getValue().booleanValue() == false) goto L13;
        if (b6.f65236h.getValue().booleanValue() == false) goto L13;
        r102.add(1);
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void x5(boolean r110, boolean r111) {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r100 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r100 == null) goto L6;
        r100.f(r110, false, false, false, r111, false, new b(this, r110, r111));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void z5(int r100, boolean r101) {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r102 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        boolean r103 = true;
        if (r102 == null) goto L11;
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r104 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r104 == null) goto L7;
        String r105 = r104.getAudienceSelfLinkMicId();
    L9:
        if (r102.d(r105) != true) goto L11;
        int r106 = 1;
    L12:
        this.f81873o = r106;
        String r107 = "switchShowMode selectMode: " + r100 + ", videoMode: " + r106;
        ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", r107);
        dl0.m.f469074a.getClass();
        dl0.m.C("LinkPKAudienceInteractDynamicEmojiDialog_switchShowMode", r107);
        if (r106 != r100) goto L15;
    L33:
        Handler r108 = DialogLancet.resolveDialogHandler(this);
        if (r108 != null) goto L36;
    L38:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L41 Exception -> L43
    L47:
        DialogLancet.afterDialogDismiss(this);
        return;
    L41:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L43:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L41
        Throwable r109 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L41
        if (r109 == null) goto L47;
        com.bytedance.crash.d.d(r109, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L41
        goto L47
    L36:
        if (Looper.myLooper() == r108.getLooper()) goto L38;
        r108.post(DialogLancet.createDismissRunnable(this));
        return;
    L15:
        if (r100 == 1) goto L17;
    L29:
        if (r100 == 1) goto L32;
        r103 = false;
    L32:
        x5(r103, r101);
        goto L33
    L17:
        if (this.f81871m == true) goto L29;
        com.bytedance.android.live.livepkaudience.vm.c r110 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r110 == null) goto L29;
        if (r110.a() == true) goto L29;
        com.bytedance.android.live.livepkaudience.vm.c r111 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r111 != null) goto L25;
    L27:
        f2.b(R.string.ttlive_interact_anchor_close_camera, 0);
        return;
    L25:
        if (r111.e() != true) goto L27;
        f2.b(R.string.ttlive_interact_camera_beclosed_toast, 0);
        return;
    L7:
        r105 = null;
    L11:
        r106 = 2;
        goto L12
    }

    public LinkPKAudienceInteractDynamicEmojiDialog(Context r100, DataCenter r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101, r102);
    }
}
