package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.ui.EditIntroductionActivity;
import com.bytedance.android.livesdk.chatroom.ui.EditIntroductionFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.xe;
import w20.ye;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showPaidLiveTicketEditPage")
public final class ShowPaidLiveTicketEditPageMethod extends w20.p6<xe, ye> implements com.bytedance.android.livesdk.chatroom.ui.n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.browser.jsbridge.upload.q f63271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xe f63272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CallContext f63273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f63274d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$ShowPaidLiveTicketEditPageMethodApi;", "", "", "url", "uri", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$b;", "ticketImgGet", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ShowPaidLiveTicketEditPageMethodApi {
        @GET
        Observable<com.bytedance.android.live.network.response.e<b>> ticketImgGet(@Url String r100, @Query("uri") String r101);
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShowPaidLiveTicketEditPageMethod$b;", "", "Lpy/k;", "image", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("image")
        private final py.k image;

        public b() {
        }

        public final py.k a() {
            return this.image;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f63275a = null;

        static {
            f63275a = new c();
        }

        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            py.k r101 = ((b) ((com.bytedance.android.live.network.response.e) r100).data).a();
            if (r101 == null) goto L7;
            List<String> r102 = r101.getUrls();
            if (r102 == null) goto L7;
            String r103 = (String) CollectionsKt.firstOrNull(r102);
        L8:
            Iterator r104 = ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.f114622b).iterator();
        L10:
            if (r104.hasNext() == false) goto L12;
            ((com.bytedance.android.livesdk.chatroom.utils.d0) r104.next()).z9(r103);
            goto L10
        L12:
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f63276a = null;

        static {
            f63276a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.n6
    public final void i() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f63272b = null;
        this.f63273c = null;
    }

    public ShowPaidLiveTicketEditPageMethod() {
    }

    public static boolean j(xe r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.d() != null) goto L8;
        return false;
    L8:
        xe.a r101 = r100.d();
        String r102 = null;
        if (r101 == null) goto L11;
        String r103 = r101.e();
    L13:
        if (mz.c.b(r103) == false) goto L15;
        return false;
    L15:
        xe.a r104 = r100.d();
        if (r104 == null) goto L18;
        String r105 = r104.c();
    L20:
        if (mz.c.b(r105) == false) goto L22;
        return false;
    L22:
        xe.a r106 = r100.d();
        if (r106 == null) goto L25;
        String r107 = r106.a();
    L27:
        if (mz.c.b(r107) == false) goto L29;
        return false;
    L29:
        xe.a r108 = r100.d();
        if (r108 == null) goto L32;
        String r109 = r108.d();
    L34:
        if (mz.c.b(r109) == false) goto L36;
        return false;
    L36:
        xe.a r110 = r100.d();
        if (r110 == null) goto L39;
        String r111 = r110.f();
    L41:
        if (mz.c.b(r111) == false) goto L43;
        return false;
    L43:
        xe.a r112 = r100.d();
        if (r112 == null) goto L46;
        String r113 = r112.b();
    L48:
        if (mz.c.b(r113) == false) goto L50;
        return false;
    L50:
        xe.a r114 = r100.d();
        if (r114 != null) goto L53;
    L77:
        return false;
    L53:
        if (r114.g() == null) goto L77;
        xe.a r115 = r100.d();
        if (r115 == null) goto L77;
        xe.b r116 = r115.g();
        if (r116 == null) goto L77;
        Integer r117 = r116.a();
        if (r117 == null) goto L77;
        r117.intValue();
        xe.a r118 = r100.d();
        if (r118 == null) goto L77;
        xe.b r119 = r118.g();
        if (r119 == null) goto L77;
        Integer r120 = r119.b();
        if (r120 == null) goto L77;
        r120.intValue();
        xe.a r121 = r100.d();
        if (r121 == null) goto L73;
        xe.b r122 = r121.g();
        if (r122 == null) goto L73;
        r102 = r122.c();
    L73:
        if (mz.c.b(r102) == false) goto L75;
        return false;
    L75:
        return true;
    L46:
        r113 = null;
        goto L48
    L39:
        r111 = null;
        goto L41
    L32:
        r109 = null;
        goto L34
    L25:
        r107 = null;
        goto L27
    L18:
        r105 = null;
        goto L20
    L11:
        r103 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.n6
    public final void A9(Fragment r110) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        xe r100 = this.f63272b;     // Catch: Exception -> L10
        if (r100 == null) goto L8;
        JsonObject r101 = r100.f();     // Catch: Exception -> L10
        if (r101 == null) goto L8;
        JSONObject r102 = tv5.a.c(r101);     // Catch: Exception -> L10
    L113:
    L18:
        this.f63274d = r102;
        this.f63271a = new com.bytedance.android.live.browser.jsbridge.upload.q(r110);
        if (this.f63274d == null) goto L116;
        CallContext r111 = this.f63273c;
        if (r111 != null) goto L23;
        return;
    L23:
        if (j(this.f63272b) == false) goto L103;
        com.bytedance.android.live.browser.jsbridge.upload.q r103 = this.f63271a;
        if (r103 == null) goto L103;
        xe r104 = this.f63272b;
        if (r104 == null) goto L34;
        xe.a r105 = r104.d();
        if (r105 == null) goto L34;
        String r106 = r105.c();
        if (r106 == null) goto L34;
        String r107 = r106;
    L35:
        xe r108 = this.f63272b;
        if (r108 == null) goto L43;
        xe.a r109 = r108.d();
        if (r109 == null) goto L43;
        String r112 = r109.a();
        if (r112 == null) goto L43;
        String r113 = r112;
    L44:
        xe r114 = this.f63272b;
        if (r114 == null) goto L52;
        xe.a r115 = r114.d();
        if (r115 == null) goto L52;
        String r116 = r115.d();
        if (r116 == null) goto L52;
        String r117 = r116;
    L53:
        xe r118 = this.f63272b;
        if (r118 == null) goto L61;
        xe.a r119 = r118.d();
        if (r119 == null) goto L61;
        String r120 = r119.f();
        if (r120 == null) goto L61;
        String r121 = r120;
    L62:
        xe r122 = this.f63272b;
        if (r122 == null) goto L70;
        xe.a r123 = r122.d();
        if (r123 == null) goto L70;
        String r124 = r123.e();
        if (r124 == null) goto L70;
        String r125 = r124;
    L71:
        xe r126 = this.f63272b;
        if (r126 == null) goto L81;
        xe.a r127 = r126.d();
        if (r127 == null) goto L81;
        xe.b r128 = r127.g();
        if (r128 == null) goto L81;
        String r129 = r128.c();
        if (r129 == null) goto L81;
        String r130 = r129;
    L82:
        xe r131 = this.f63272b;
        if (r131 == null) goto L91;
        xe.a r132 = r131.d();
        if (r132 == null) goto L91;
        xe.b r133 = r132.g();
        if (r133 == null) goto L91;
        Integer r134 = r133.a();
        if (r134 == null) goto L91;
        int r135 = r134.intValue();
    L92:
        xe r136 = this.f63272b;
        if (r136 == null) goto L101;
        xe.a r137 = r136.d();
        if (r137 == null) goto L101;
        xe.b r138 = r137.g();
        if (r138 == null) goto L101;
        Integer r139 = r138.b();
        if (r139 == null) goto L101;
        int r140 = r139.intValue();
    L102:
        r103.E = new com.bytedance.android.live.browser.jsbridge.upload.z(r107, r113, r117, r121, r125, r130, r135, r140);
    L101:
        r140 = 0;
    L91:
        r135 = 0;
    L81:
        r130 = "";
    L70:
        r125 = "";
    L61:
        r121 = "";
    L52:
        r117 = "";
    L43:
        r113 = "";
    L34:
        r107 = "";
    L103:
        com.bytedance.android.live.browser.jsbridge.upload.q r141 = this.f63271a;
        if (r141 == null) goto L118;
        JSONObject r142 = this.f63274d;
        Intrinsics.checkNotNull(r142);
        r141.D = this;
        r141.invoke2(r142, r111);     // Catch: Exception -> L108
        return;
    L108:
        e = move-exception;
        ALogger.e("EncryptedUploadMethod", "native upload failure " + e.getMessage());
        return;
    L118:
        return;
    L116:
        return;
    L8:
        r102 = new JSONObject("");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        StringBuilder r143 = new StringBuilder("create json object crash, ");
        r143.append(e.getMessage());
        r143.append(", ");
        xe r144 = this.f63272b;
        if (r144 == null) goto L16;
        JsonObject r145 = r144.f();
        if (r145 == null) goto L16;
        String r146 = r145.toString();
    L17:
        r143.append(r146);
        ALogger.e("PreloadReplayMethod", r143.toString());
        r102 = new JSONObject();
    L16:
        r146 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.n6
    public final void B9(String r100) {
        ye r101 = new ye();
        r101.a(1);
        ye.a r102 = new ye.a();
        r102.a(r100);
        Unit r103 = Unit.INSTANCE;
        r101.b(r102);
        finishWithResult(r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.n6
    public final void z9(String r100) {
        String r101 = "";
        if (j(this.f63272b) == false) goto L31;
        if (r100 != null) goto L6;
        return;
    L6:
        xe r102 = this.f63272b;
        if (r102 == null) goto L54;
        xe.a r103 = r102.d();
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.b() == null) goto L60;
        ShowPaidLiveTicketEditPageMethodApi r104 = (ShowPaidLiveTicketEditPageMethodApi) com.bytedance.android.live.network.c.b().e(ShowPaidLiveTicketEditPageMethodApi.class);
        if (r104 == null) goto L56;
        xe r105 = this.f63272b;
        if (r105 == null) goto L23;
        xe.a r106 = r105.d();
        if (r106 == null) goto L23;
        String r107 = r106.b();
        if (r107 == null) goto L23;
        r101 = r107;
    L23:
        Observable<com.bytedance.android.live.network.response.e<b>> r108 = r104.ticketImgGet(r101, r100);
        if (r108 == null) goto L57;
        Observable<com.bytedance.android.live.network.response.e<b>> r109 = r108.subscribeOn(Schedulers.io());
        if (r109 == null) goto L58;
        Observable<com.bytedance.android.live.network.response.e<b>> r110 = r109.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L59;
        r110.subscribe(c.f63275a, d.f63276a);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L60:
        return;
    L54:
        return;
    L31:
        xe r111 = this.f63272b;
        if (r111 == null) goto L38;
        String r112 = r111.c();
        if (r112 == null) goto L38;
        r101 = r112;
    L38:
        if (r101.length() != 0) goto L40;
        boolean r113 = true;
    L41:
        if (r113 == false) goto L45;
        ALogger.i("PreloadReplayMethod", "prefix is empty, " + this.f63272b);
        return;
    L45:
        if (StringsKt.endsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == false) goto L47;
        String r114 = r101 + r100;
    L48:
        Iterator r115 = ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.f114622b).iterator();
    L50:
        if (r115.hasNext() == false) goto L52;
        ((com.bytedance.android.livesdk.chatroom.utils.d0) r115.next()).z9(r114);
        goto L50
    L52:
        return;
    L47:
        r114 = r101 + '/' + r100;
        goto L48
    L40:
        r113 = false;
        goto L41
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        xe r112 = (xe) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f63272b = r112;
        this.f63273c = r111;
        Integer r100 = r112.e();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        ALogger.i("PreloadReplayMethod", "jsb params.pageHeight: " + r112.e());
        String r103 = "";
        if (r102 != 0) goto L20;
        Context r113 = r111.getContext();
        Bundle r104 = new Bundle();
        String r105 = String.valueOf(r113.hashCode()) + String.valueOf(System.currentTimeMillis());
        Map<String, com.bytedance.android.livesdk.chatroom.ui.n6> r106 = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a;
        Intrinsics.checkNotNullParameter(r105, "key");
        Intrinsics.checkNotNullParameter(this, "callback");
        com.bytedance.android.livesdk.chatroom.utils.s4.f114621a.put(r105, this);
        r104.putString("upload_callback_key", r105);
        xe r114 = this.f63272b;
        if (r114 == null) goto L14;
        String r115 = r114.b();
        if (r115 == null) goto L14;
        r103 = r115;
    L14:
        r104.putString("edit_content", r103);
        xe r116 = this.f63272b;
        if (r116 == null) goto L19;
        Boolean r117 = r116.a();
        if (r117 == null) goto L19;
        r101 = r117.booleanValue();
    L19:
        r104.putBoolean("add_image_directly", r101);
        Intent r118 = new Intent(r113, EditIntroductionActivity.class);
        r118.putExtras(r104);
        r113.startActivity(r118);
        return;
    L20:
        Context r119 = r111.getContext();
        Bundle r107 = new Bundle();
        String r108 = String.valueOf(r119.hashCode()) + String.valueOf(System.currentTimeMillis());
        Map<String, com.bytedance.android.livesdk.chatroom.ui.n6> r120 = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a;
        Intrinsics.checkNotNullParameter(r108, "key");
        Intrinsics.checkNotNullParameter(this, "callback");
        com.bytedance.android.livesdk.chatroom.utils.s4.f114621a.put(r108, this);
        r107.putString("upload_callback_key", r108);
        xe r121 = this.f63272b;
        if (r121 == null) goto L26;
        String r122 = r121.b();
        if (r122 == null) goto L26;
        r103 = r122;
    L26:
        r107.putString("edit_content", r103);
        xe r123 = this.f63272b;
        if (r123 == null) goto L31;
        Boolean r124 = r123.a();
        if (r124 == null) goto L31;
        boolean r125 = r124.booleanValue();
    L32:
        r107.putBoolean("add_image_directly", r125);
        r107.putInt("page_height", r102);
        int r126 = EditIntroductionFragment.f112142p;
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "extras");
        FragmentActivity r127 = ContextUtil.contextToFragmentActivity(r119);
        if (r127 == null) goto L36;
        FragmentManager r128 = r127.getSupportFragmentManager();
        if (r128 == null) goto L36;
    L41:
        if (r128 != null) goto L43;
        x8.a.b("EditIntroductionFragment", "fragmentManager is null", false);
        return;
    L43:
        EditIntroductionFragment r109 = new EditIntroductionFragment();
        r107.putBoolean("open_as_dialog_fragment", true);
        Unit r129 = Unit.INSTANCE;
        r109.setArguments(r107);
        LandscapeRestrictionOperation r130 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, "EditIntroductionFragment", r130);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r128, r109, r130) == true) goto L54;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
    L47:
        r109.show(r128, "EditIntroductionFragment");
        return;
    L54:
        return;
    L36:
        FragmentActivity r131 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r131 == null) goto L39;
        r128 = r131.getSupportFragmentManager();
        goto L41
    L39:
        r128 = null;
    L31:
        r125 = false;
        goto L32
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.n6
    public final void C9(int r100, int r101, Intent r102) {
        com.bytedance.android.live.browser.jsbridge.upload.q r103 = this.f63271a;     // Catch: Exception -> L6
        if (r103 == null) goto L11;
        r103.onActivityResult(r100, r101, r102);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ALogger.e("PreloadReplayMethod", "upload fail " + e.getMessage());
    }
}
