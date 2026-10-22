package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/LinkDistributeSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkDistributeSettingDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f80982i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f80983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f80984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f80985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f80986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f80987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f80988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f80989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ILinkDistributionSettingCallback f80990h;

    public static final class a {
        public static String a() {
            ILinkmicAudienceSetting.LinkmicSettingStatus r100 = b6.f65256r.getValue();
            if (r100 == null) goto L9;
            int r101 = h.f81066a[r100.ordinal()];
            if (r101 != 1) goto L8;
            return "mutual";
        L8:
            if (r101 != 2) goto L9;
            return "all";
        L9:
            return "none";
        }

        public static void b() {
            LinkedHashMap r100 = new LinkedHashMap();
            int r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            if (r101 != 5) goto L5;
        L11:
            String r102 = "radio";
        L12:
            r100.put("function_type", r102);
            if (b6.f65254q.getValue().booleanValue() == false) goto L15;
            String r103 = "on";
        L16:
            r100.put(EventConstants.ExtraJson.SWITCH_STATUS, r103);
            j0.l().sendLog("livesdk_guest_link_distribute_switch", r100, new Object[]{IRoom.class, am2.x.class});
            return;
        L15:
            r103 = "off";
            goto L16
        L5:
            if (r101 != 9) goto L7;
            r102 = "ktv";
            goto L12
        L7:
            if (r101 != 10) goto L11;
            r102 = "watch";
            goto L12
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkDistributeSettingDialog f80991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILinkmicAudienceSetting.LinkmicSettingStatus f80992b;

        public b(LinkDistributeSettingDialog r100, ILinkmicAudienceSetting.LinkmicSettingStatus r101) {
            this.f80991a = r100;
            this.f80992b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
            com.bytedance.android.livesdk.sharedpref.e<ILinkmicAudienceSetting.LinkmicSettingStatus> r102 = b6.f65256r;
            ILinkmicAudienceSetting.LinkmicSettingStatus r103 = this.f80992b;
            r102.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
            LinkDistributeSettingDialog r104 = this.f80991a;
            int r105 = LinkDistributeSettingDialog.f80982i;
            r104.getClass();
            LinkedHashMap r106 = new LinkedHashMap();
            int r107 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            TalkRoomLogUtils.B0(r106, Integer.valueOf(r107), null, 4);
            TalkRoomLogUtils.I0(r106, r107);
            r106.put("selection", a.a());
            r106.put("request_page", r104.f80988f);
            j0.l().sendLog("livesdk_guest_connection_distribution_popup_select", r106, new Object[]{IRoom.class, am2.x.class});
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f80993a = null;

        static {
            f80993a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            r101.printStackTrace();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_link_distribute_setting;
    }

    public final void M0() {
        List<e> r100 = this.f80986d;
        j r101 = new j(this);
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r101, "listener");
        e.a r102 = new e.a();
        String r103 = s1.B(R.string.ttlive_live_link_distribute_item_every);
        Intrinsics.checkNotNullParameter(r103, "title");
        r102.f81058b = r103;
        r102.f81059c = R.id.link_distribute_setting_every;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r102.f81061e = r101;
        r102.f81060d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.getValue();
        ArrayList r104 = (ArrayList) r100;
        r104.add(new e(r102));
        e.a r105 = new e.a();
        String r106 = s1.B(R.string.ttlive_live_link_distribute_item_friends);
        Intrinsics.checkNotNullParameter(r106, "title");
        r105.f81058b = r106;
        String r107 = s1.B(R.string.ttlive_live_link_distribute_item_friends_dec);
        Intrinsics.checkNotNullParameter(r107, "dec");
        r105.f81057a = r107;
        r105.f81059c = R.id.link_distribute_setting_friends;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r105.f81061e = r101;
        r105.f81060d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.getValue();
        r104.add(new e(r105));
        e.a r108 = new e.a();
        String r109 = s1.B(R.string.ttlive_live_link_distribute_item_off);
        Intrinsics.checkNotNullParameter(r109, "title");
        r108.f81058b = r109;
        String r110 = s1.B(R.string.ttlive_live_link_distribute_item_off_dec);
        Intrinsics.checkNotNullParameter(r110, "dec");
        r108.f81057a = r110;
        r108.f81059c = R.id.link_distribute_setting_off;
        r108.f81060d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue();
        Intrinsics.checkNotNullParameter(r101, "listener");
        r108.f81061e = r101;
        r104.add(new e(r108));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.f80989g == false) goto L31;
        Window r101 = getWindow();
        if (r101 == null) goto L32;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L24;
        r102.dimAmount = 0.0f;
    L24:
        r101.clearFlags(2);
        r101.setAttributes(r102);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void N0(ILinkmicAudienceSetting.LinkmicSettingStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        JSONArray r101 = new JSONArray();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r103.put("status", r100.getValue());     // Catch: JSONException -> L5
        r102.put("key", ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_DELEGATED_TO_FRIENDS.getValue());     // Catch: JSONException -> L5
        r102.put("value", r103);     // Catch: JSONException -> L5
        r101.put(r102);     // Catch: JSONException -> L5
    L7:
        com.bytedance.live.datacontext.m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L10;
        IRoom r105 = r104.getValue();
    L11:
        if (r105 == null) goto L14;
        this.f80985c.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updateAudienceSettings(r105.getId(), r101.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r100), c.f80993a));
    L14:
        if (TextUtils.equals("privacy_settings", this.f80988f) == false) goto L23;
        LinkedHashMap r106 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r106, null, null, 6);
        TalkRoomLogUtils.J0(r106);
        int r107 = i.f81067a[r100.ordinal()];
        if (r107 != 1) goto L18;
        String r108 = "mutual";
    L22:
        r106.put("selection", r108);
        r106.put("request_page", this.f80988f);
        j0.l().sendLog("livesdk_guest_connection_distribution_popup_select", r106, new Object[0]);
        goto L23
    L18:
        if (r107 == 2) goto L20;
        r108 = "none";
        goto L22
    L20:
        r108 = "all";
    L23:
        ILinkDistributionSettingCallback r109 = this.f80990h;
        if (r109 == null) goto L29;
        r109.onStatusChanged(r100.getValue());
        return;
    L29:
        return;
    L10:
        r105 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = c1.f78742a;
        c1.b(getWindow(), 0, 14);
        Map r102 = (Map) vm2.d.T1.getValue(null, vm2.d.f555776a[147(0x93, float:2.06E-43)]);
        if (r102 == null) goto L12;
        ((ImageView) findViewById(R.id.iv_link_distribute_help)).setVisibility(0);
        String r103 = (String) r102.get("title");
        if (r103 == null) goto L7;
        ((TextView) findViewById(R.id.tv_link_distribute_setting_tips)).setText(r103);
    L7:
        String r104 = (String) r102.get("rule_url");
        if (r104 == null) goto L12;
        ImageView r105 = (ImageView) findViewById(R.id.iv_link_distribute_help);
        if (r105 == null) goto L12;
        r105.setOnClickListener(new l(r104, this));
    L12:
        Iterator r106 = ((ArrayList) this.f80986d).iterator();
    L14:
        if (r106.hasNext() == false) goto L42;
        e r107 = (e) r106.next();
        View r108 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_setting_item, null);
        r108.setId(r107.f81054c);
        ((ViewGroup) this.f80983a.getValue()).addView(r108);
        ((ArrayList) this.f80984b).add(r108);
        r108.setOnClickListener(r107.f81056e);
        TextView r109 = (TextView) r108.findViewById(R.id.tv_link_distribute_setting_item_title);
        TextView r110 = (TextView) r108.findViewById(R.id.tv_link_distribute_setting_item_dec);
        if (TextUtils.isEmpty(r107.f81053b) == false) goto L18;
        r109.setVisibility(8);
    L20:
        if (TextUtils.isEmpty(r107.f81052a) == false) goto L23;
        if (r110 == null) goto L28;
        r110.setVisibility(8);
    L28:
        if (this.f80987e != r107.f81055d) goto L34;
        ImageView r111 = (ImageView) r108.findViewById(R.id.item_right_icon);
        if (r111 == null) goto L32;
        r111.setVisibility(0);
    L32:
        if (r111 == null) goto L34;
        r111.setImageResource(R.drawable.ic_ttlive_dialog_item_selected);
    L34:
        StringBuilder r112 = new StringBuilder();
        r112.append(r107.f81053b);
        r112.append(r107.f81052a);
        if (this.f80987e != r107.f81055d) goto L41;
        Resources r113 = getContext().getResources();
        if (r113 == null) goto L41;
        String r114 = r113.getString(R.string.ttlive_content_description_selected);
        if (r114 == null) goto L41;
        r112.append(r114);
    L41:
        r108.setContentDescription(r112.toString());
        goto L14
    L23:
        if (r110 == null) goto L25;
        r110.setVisibility(0);
    L25:
        if (r110 == null) goto L28;
        r110.setText(r107.f81052a);
        goto L28
    L18:
        r109.setVisibility(0);
        r109.setText(r107.f81053b);
        goto L20
    L42:
        ((LinearLayout) findViewById(R.id.tv_dialog_link_distribute_setting_cancel_layout)).setOnClickListener(new k(this));
        if (this.f80989g == false) goto L56;
        Window r115 = getWindow();
        if (r115 == null) goto L57;
        WindowManager.LayoutParams r116 = r115.getAttributes();
        if (r116 == null) goto L49;
        r116.dimAmount = 0.5f;
    L49:
        r115.addFlags(2);
        r115.setAttributes(r116);
        return;
    L57:
        return;
    }

    public LinkDistributeSettingDialog(Context r100, int r101, String r102, boolean r103, ILinkDistributionSettingCallback r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "from");
        super(r100);
        this.f80987e = r101;
        this.f80988f = r102;
        this.f80989g = r103;
        this.f80990h = r104;
        this.f80983a = LazyKt.lazy(new LinkDistributeSettingDialog$mItemContainer$2(this));
        this.f80984b = new ArrayList();
        this.f80985c = new CompositeDisposable();
        this.f80986d = new ArrayList();
    }
}
