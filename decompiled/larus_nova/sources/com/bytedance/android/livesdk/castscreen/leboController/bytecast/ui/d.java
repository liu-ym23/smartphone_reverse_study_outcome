package com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui;

import android.content.Context;
import android.view.Display;
import androidx.lifecycle.Observer;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Room f104591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LivePlayerView f104592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> f104593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f104594d;

    public static final class a extends ILivePlayerScene {
        @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene
        public final String getScene() {
            return "system_cast";
        }

        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f104595a = null;

        static {
            f104595a = new b();
        }

        public b() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f104596a = null;

        static {
            f104596a = new c();
        }

        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L13;
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
            r101.put("is_system_mirror", true);     // Catch: Exception -> L6
        L7:
            String r102 = LiveByteCastUIManager.f104549a;
            IHostLiveByteCast r103 = LiveByteCastUIManager.k();
            if (r103 == null) goto L14;
            r103.logCastStart(LiveByteCastUIManager.f104552d, r101);
            return;
        L14:
            return;
        L6:
            r101 = new JSONObject();
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.d$d, reason: collision with other inner class name */
    public static final class C1576d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1576d f104597a = null;

        static {
            f104597a = new C1576d();
        }

        public C1576d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L14;
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
            r101.put("is_system_mirror", true);     // Catch: Exception -> L6
        L7:
            String r102 = LiveByteCastUIManager.f104549a;
            IHostLiveByteCast r103 = LiveByteCastUIManager.k();
            if (r103 == null) goto L10;
            r103.logCastClose(LiveByteCastUIManager.f104552d, r101);
        L10:
            Objects.toString(d.f104592b);
            return;
        L6:
            r101 = new JSONObject();
            goto L7
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f104598a = null;

        static {
            f104598a = new e();
        }

        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f104599a = null;

        static {
            f104599a = new f();
        }

        public f() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f104600a = null;

        static {
            f104600a = new g();
        }

        public g() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L13;
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
            r101.put("is_system_mirror", true);     // Catch: Exception -> L6
        L7:
            String r102 = LiveByteCastUIManager.f104549a;
            IHostLiveByteCast r103 = LiveByteCastUIManager.k();
            if (r103 == null) goto L14;
            r103.logCastClose(LiveByteCastUIManager.f104552d, r101);
            return;
        L14:
            return;
        L6:
            r101 = new JSONObject();
            goto L7
        }
    }

    public static boolean c() {
        String r100 = LiveByteCastUIManager.f104549a;
        IHostLiveByteCast r101 = LiveByteCastUIManager.k();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isSysMiracast();
    }

    static {
    }

    public static void d(LivePlayerView r100) {
        Intrinsics.checkNotNullParameter(r100, "playerView");
        r100.getClient().getEventHub().getStartPullStream().observeForever(b.f104595a);
        r100.getClient().getEventHub().getPlaying().observeForever(c.f104596a);
        r100.getClient().getEventHub().getStopped().observeForever(C1576d.f104597a);
        r100.getClient().getEventHub().getFirstFrame().observeForever(e.f104598a);
        r100.getClient().getEventHub().getPlayerMediaError().observeForever(f.f104599a);
        r100.getClient().getEventHub().getPlayComplete().observeForever(g.f104600a);
    }

    public static LivePlayerView a(Context r100, String r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        LivePlayerConfig r102 = LivePlayerConfig.Companion.buildWith(new a());
        LivePlayerView r103 = f104592b;
        if (r103 == null) goto L9;
        r103.release();
        f104592b = null;
    L9:
        LivePlayerView r104 = new LivePlayerView(r100, r102);
        f104592b = r104;
        r104.setScaleType(0);
        LiveRequest r105 = new LiveRequest.Builder().streamData(r101).build();
        LivePlayerView r106 = f104592b;
        if (r106 == null) goto L13;
        r106.start(r105);
    L13:
        return f104592b;
    L14:
        return null;
    }

    public static void b(Context r100, final DataCenter r101) {
        Lazy r102 = LiveByteCastUIEventHelper.f104521a;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("is_system_mirror", true);     // Catch: Exception -> L5
        r103.put("is_system_push", false);     // Catch: Exception -> L5
        r103.put("non_sys_cast_num", 0);     // Catch: Exception -> L5
    L7:
        if (LiveByteCastUIEventHelper.f104522b == false) goto L12;
        LiveByteCastUIEventHelper.f104522b = false;
        IHostLiveByteCast r104 = (IHostLiveByteCast) LiveByteCastUIEventHelper.f104521a.getValue();
        if (r104 == null) goto L11;
        r104.logScreenCastEnter(new LiveByteCastUIEventHelper$logMiraUrlStart$1(r101));
    L11:
        LiveByteCastUIEventHelper.f("castsdk_mobile_search_start", r101, r103);
        LiveByteCastUIEventHelper.f("castsdk_mobile_search_success_page_show", r101, r103);
    L12:
        LiveByteCastUIEventHelper.f("castsdk_mobile_fetch_url_start", r101, r103);
        LiveByteCastUIEventHelper.f("castsdk_mobile_fetch_url_result", r101, r103);
        IHostLiveByteCast r105 = (IHostLiveByteCast) LiveByteCastUIEventHelper.f104521a.getValue();
        if (r105 == null) goto L15;
        LiveCastSourceUIDepend r106 = LiveByteCastUIManager.f104552d;
        r103.put("non_sys_cast_num", 0);
        Unit r107 = Unit.INSTANCE;
        r105.logMiraFetchMedia(r106, r103);
    L15:
        if (r100 != null) goto L17;
        return;
    L17:
        String r108 = LiveByteCastUIManager.f104549a;
        IHostLiveByteCast r109 = LiveByteCastUIManager.k();
        if (r109 == null) goto L20;
        Display r110 = r109.getDisplay();
    L21:
        if (r110 == null) goto L62;
        com.bytedance.android.livesdk.castscreen.views.b.a r111 = com.bytedance.android.livesdk.castscreen.views.b.f104778e;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "display");
        monitor-enter(r111);
        com.bytedance.android.livesdk.castscreen.views.b r112 = com.bytedance.android.livesdk.castscreen.views.b.f104777d;     // Catch: Throwable -> L59
        if (r112 == null) goto L30;
        Display r113 = r112.getDisplay();     // Catch: Throwable -> L59
        if (r113 == null) goto L30;
        if (r113.getDisplayId() != r110.getDisplayId()) goto L30;
    L34:
        com.bytedance.android.livesdk.castscreen.views.b r114 = com.bytedance.android.livesdk.castscreen.views.b.f104777d;     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L59
        monitor-exit(r111);
        Room r115 = f104591a;     // Catch: Exception -> L54
        if (r115 == null) goto L39;
        f104592b = a(r100, r115.getMultiStreamData());     // Catch: Exception -> L54
    L39:
        LivePlayerView r116 = f104592b;     // Catch: Exception -> L54
        if (r116 == null) goto L43;
        Intrinsics.checkNotNull(r116);     // Catch: Exception -> L54
        d(r116);     // Catch: Exception -> L54
    L43:
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L64;
        DialogLancet.handleBlockedDialogShow(r114);     // Catch: Exception -> L54
    L48:
        r114.a(f104592b);     // Catch: Exception -> L54
        Lazy r117 = LiveByteCastUIEventHelper.f104521a;     // Catch: Exception -> L54
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L51
        r118.put("is_system_mirror", true);     // Catch: Exception -> L51
        r118.put("is_system_push", false);     // Catch: Exception -> L51
    L52:
        LiveByteCastUIEventHelper.f("castsdk_mobile_search_success_page_choose", r101, r118);     // Catch: Exception -> L54
        LiveByteCastUIEventHelper.f("castsdk_mobile_receiver_contact_start", r101, r118);     // Catch: Exception -> L54
        LiveByteCastUIEventHelper.f("castsdk_mobile_receiver_contact", r101, r118);     // Catch: Exception -> L54
        LiveByteCastUIEventHelper.b(r101, "success", 0, "");     // Catch: Exception -> L54
        return;
    L51:
        r118 = new JSONObject();     // Catch: Exception -> L54
        goto L52
    L64:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L47:
        DialogLancet.beforeDialogShow(r114);     // Catch: Exception -> L54
        r114.show();     // Catch: Exception -> L54
        DialogLancet.afterDialogShow(r114);     // Catch: Exception -> L54
    L54:
        e = move-exception;
        Lazy r119 = LiveByteCastUIEventHelper.f104521a;
        String r120 = e.getMessage();
        if (r120 != null) goto L58;
        r120 = "";
    L58:
        LiveByteCastUIEventHelper.b(r101, "fail", -1, r120);
        return;
    L30:
        com.bytedance.android.livesdk.castscreen.views.b r121 = com.bytedance.android.livesdk.castscreen.views.b.f104777d;     // Catch: Throwable -> L59
        if (r121 == null) goto L33;
        com.bytedance.android.livesdk.castscreen.views.b.a.a(r121);     // Catch: Throwable -> L59
    L33:
        com.bytedance.android.livesdk.castscreen.views.b.f104777d = new com.bytedance.android.livesdk.castscreen.views.b(r100, r110);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L62:
        return;
    L20:
        r110 = null;
    L5:
        r103 = new JSONObject();
        goto L7
    }
}
