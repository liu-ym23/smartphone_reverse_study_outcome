package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f78759a = null;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o5 f78760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f78761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBanUser f78762c;

        public a(o5 r100, Context r101, IBanUser r102) {
            this.f78760a = r100;
            this.f78761b = r101;
            this.f78762c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f78762c.getUrl();
            if (r101 == null) goto L25;
            u30.b r102 = ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).buildFullScreenWebPage(this.f78761b, r101);
            Resources r103 = this.f78761b.getResources();
            if (r103 == null) goto L7;
            String r104 = r103.getString(R.string.ttlive_ban_info);
        L8:
            u30.a r105 = r102.setTitle(r104);
            r105.f548548b = true;
            r105.b();
            o5 r106 = this.f78760a;
            Handler r107 = DialogLancet.resolveDialogHandler(r106);
            if (r107 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r106);
            r106.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r106);
            return;
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r106);
            throw th;
        L18:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r108 == null) goto L22;
            com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
            goto L22
        L11:
            if (Looper.myLooper() == r107.getLooper()) goto L13;
            r107.post(DialogLancet.createDismissRunnable(r106));
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o5 f78763a;

        public b(o5 r100) {
            this.f78763a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            o5 r101 = this.f78763a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    static {
        f78759a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static void a(o5 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static String b(int r100, com.bytedance.android.live.network.response.e r101) {
        return s1.C(r100, new Object[]{f78759a.format(new Date(((long) 1000) * (((bf2.a) r101.data).getBanTime() + ((bf2.a) r101.data).getBanDuration())))});
    }

    public static void c(Context r100, com.bytedance.android.live.network.response.e r101, String r110) {
        Intrinsics.checkNotNullParameter(r101, "latestBanRecord");
        Intrinsics.checkNotNullParameter(r110, "banType");
        if (r100 != null) goto L6;
        return;
    L6:
        if (((bf2.a) r101.data).isBannedForever() == false) goto L8;
        String r102 = "";
    L9:
        o5 r103 = new o5(r100);
        TextView r104 = r103.f113742b;
        String r105 = null;
        if (r104 == null) goto L16;
        Resources r106 = r100.getResources();
        if (r106 == null) goto L14;
        String r107 = r106.getString(R.string.ttlive_inroom_video_ban_title);
    L15:
        r104.setText(r107);
        goto L16
    L14:
        r107 = null;
    L16:
        TextView r108 = r103.f113743c;
        if (r108 == null) goto L19;
        r108.setText(r102);
    L19:
        TextView r109 = r103.f113743c;
        if (r109 == null) goto L22;
        UtilityKotlinExtentionsKt.z(r109, !StringsKt.isBlank(r102));
    L22:
        String r111 = ((bf2.a) r101.data).getBanDetailText();
        TextView r112 = r103.f113744d;
        if (r112 != null) goto L25;
    L32:
        View r113 = r103.f113741a;
        if (r113 == null) goto L35;
        r113.setOnClickListener(new z(r103, r100, r101, r110));
    L35:
        Button r114 = r103.f113746f;
        if (r114 == null) goto L42;
        Resources r115 = r100.getResources();
        if (r115 == null) goto L40;
        String r116 = r115.getString(R.string.ttlive_interact_pk_dialog_banned_tips_known);
    L41:
        r114.setText(r116);
        goto L42
    L40:
        r116 = null;
    L42:
        Button r117 = r103.f113746f;
        if (r117 == null) goto L45;
        r117.setOnClickListener(new a0(r103, r110));
    L45:
        String r118 = ((bf2.a) r101.data).getAppealUrl();
        if (r118 == null) goto L57;
        String r119 = UriProtector.getQueryParameter(UriProtector.parse(r118), "url");
        if (r119 == null) goto L59;
        String r120 = UriProtector.parse(r119).buildUpon().appendQueryParameter("enter_from", "link_popup").build().toString();
        Uri r121 = UriProtector.parse(r118);
        Uri.Builder r122 = r121.buildUpon().clearQuery();
        Iterator<T> r123 = UriProtector.getQueryParameterNames(r121).iterator();
    L52:
        if (r123.hasNext() == false) goto L56;
        String r124 = (String) r123.next();
        if ((!Intrinsics.areEqual(r124, "url")) == false) goto L52;
        r122.appendQueryParameter(r124, UriProtector.getQueryParameter(r121, r124));
        goto L52
    L56:
        r122.appendQueryParameter("url", r120);
        r118 = r122.build().toString();
    L59:
        if (TextUtils.isEmpty(r118) == false) goto L66;
        Button r125 = r103.f113747g;
        if (r125 == null) goto L63;
        r125.setVisibility(8);
    L63:
        TextView r126 = r103.f113748h;
        if (r126 == null) goto L75;
        r126.setVisibility(8);
    L75:
        a(r103);
        HashMap r127 = new HashMap();
        r127.put("ban_type", r110);
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_show", r127, new Object[0]);
        return;
    L66:
        Button r128 = r103.f113747g;
        if (r128 == null) goto L72;
        Resources r129 = r100.getResources();
        if (r129 == null) goto L71;
        r105 = r129.getString(R.string.ttlive_interact_pk_dialog_banned_tips_appeal);
    L71:
        r128.setText(r105);
    L72:
        Button r130 = r103.f113747g;
        if (r130 == null) goto L75;
        r130.setOnClickListener(new b0(r103, r118, r110));
        goto L75
    L57:
        r118 = null;
        goto L59
    L25:
        if (TextUtils.isEmpty(r111) == false) goto L31;
        Resources r131 = r100.getResources();
        if (r131 == null) goto L30;
        r111 = r131.getString(R.string.ttlive_ban_tips_enter);
        goto L31
    L30:
        r111 = null;
    L31:
        r112.setText(r111);
        goto L32
    L8:
        r102 = b(R.string.ttlive_interact_new_ban_time_left_content, r101);
        goto L9
    }

    public static void d(Context r100, IBanUser r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "banUser");
        ALogger.e("ttlive_link", "showAudienceLinkBanDialog " + r101);
        o5 r103 = new o5(r100);
        TextView r104 = r103.f113742b;
        String r105 = null;
        if (r104 == null) goto L9;
        Resources r106 = r100.getResources();
        if (r106 == null) goto L7;
        String r107 = r106.getString(R.string.ttlive_interact_paid_link_banned_title);
    L8:
        r104.setText(r107);
        goto L9
    L7:
        r107 = null;
    L9:
        TextView r108 = r103.f113743c;
        if (r108 == null) goto L16;
        if (r102 == false) goto L13;
        String r109 = r101.getAnchorExplain();
    L14:
        r108.setText(r109);
        goto L16
    L13:
        r109 = r101.getAudienceExplain();
    L16:
        if (r102 == true) goto L18;
    L36:
        TextView r110 = r103.f113744d;
        if (r110 == null) goto L39;
        r110.setVisibility(8);
    L39:
        View r111 = r103.f113745e;
        if (r111 == null) goto L42;
        r111.setVisibility(8);
    L42:
        Button r112 = r103.f113746f;
        if (r112 == null) goto L48;
        Resources r113 = r100.getResources();
        if (r113 == null) goto L47;
        r105 = r113.getString(R.string.ttlive_know);
    L47:
        r112.setText(r105);
    L48:
        Button r114 = r103.f113747g;
        if (r114 == null) goto L51;
        r114.setVisibility(8);
    L51:
        TextView r115 = r103.f113748h;
        if (r115 == null) goto L54;
        r115.setVisibility(8);
    L54:
        Button r116 = r103.f113746f;
        if (r116 == null) goto L57;
        r116.setOnClickListener(new b(r103));
    L57:
        a(r103);
        return;
    L18:
        if (TextUtils.isEmpty(r101.getUrl()) == true) goto L36;
        TextView r117 = r103.f113744d;
        if (r117 == null) goto L23;
        r117.setVisibility(0);
    L23:
        View r118 = r103.f113745e;
        if (r118 == null) goto L26;
        r118.setVisibility(0);
    L26:
        TextView r119 = r103.f113744d;
        if (r119 == null) goto L33;
        Resources r120 = r100.getResources();
        if (r120 == null) goto L31;
        String r121 = r120.getString(R.string.ttlive_ban_tips_enter);
    L32:
        r119.setText(r121);
        goto L33
    L31:
        r121 = null;
    L33:
        View r122 = r103.f113741a;
        if (r122 == null) goto L42;
        r122.setOnClickListener(new a(r103, r100, r101));
        goto L42
    }
}
