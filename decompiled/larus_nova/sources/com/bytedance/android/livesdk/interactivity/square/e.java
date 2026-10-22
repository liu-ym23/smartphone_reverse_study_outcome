package com.bytedance.android.livesdk.interactivity.square;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;
import r52.u3;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f141152a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f141153b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f141154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Disposable f141155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f141156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f141157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Long> f141158g = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f141159a = null;

        static {
            f141159a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Integer r100 = (Integer) r110;
            HashMap r101 = new HashMap();
            if (e.a() == false) goto L5;
            String r102 = "live_take_detail";
        L6:
            r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r102);
            r101.put("module_name", "public_screen_square");
            r101.put("element_name", "message_cell");
            if (e.a() == false) goto L9;
            String r103 = "anchor";
        L22:
            r101.put("user_type", r103);
            if (e.a() == false) goto L25;
            String r104 = "1";
        L26:
            r101.put(IPerformanceManager.Params.is_anchor, r104);
            r101.put("comment_action_number", String.valueOf(e.f141157f));
            r101.put("comment_action_pv", String.valueOf(e.f141157f));
            r101.put("comment_id_list", CollectionsKt.joinToString$default(e.f141158g, ",", null, null, 0, null, null, 62, null));
            JSONObject r105 = new JSONObject();     // Catch: Exception -> L29
            r105.put("common_msg_pv", String.valueOf(e.f141156e));     // Catch: Exception -> L29
            Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L29
            r101.put("square_msg_type_count", r105.toString());     // Catch: Exception -> L29
        L31:
            j0.l().sendLog("livesdk_live_square_tab_message_show", r101, new Object[]{IRoom.class, x.class});
            e.f141157f = 0;
            e.f141156e = 0;
            ((ArrayList) e.f141158g).clear();
            return;
        L29:
            e = move-exception;
            SafetyGuard.a("square_msg_type_count", e, null);
            goto L31
        L25:
            r104 = "0";
            goto L26
        L9:
            MiddlewareRoomContext r107 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
            if (r107 == null) goto L18;
            m<User> r108 = r107.getUser();
            if (r108 == null) goto L18;
            User r109 = r108.getValue();
            if (r109 == null) goto L18;
            if (o.b(r109) != true) goto L18;
            boolean r111 = true;
        L19:
            if (r111 == false) goto L21;
            r103 = UserGroupScene.DEFAULT_NAME_SPACE;
            goto L22
        L21:
            r103 = "user";
        L18:
            r111 = false;
            goto L19
        L5:
            r102 = "live_detail";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f141160a = null;

        static {
            f141160a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SafetyGuard.a("reportShowStatistics error", (Throwable) r100, null);
        }
    }

    public static void b() {
        f141154c = Observable.just(1).observeOn(Schedulers.computation()).subscribe(a.f141159a, b.f141160a);
    }

    static {
        q0 r100 = u3.f536269a.getValue();
        f141152a = r100.c();
        f141153b = r100.g();
        f141158g = new ArrayList();
    }

    public static boolean a() {
        MiddlewareRoomContext r100 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L9;
        if (r101.getValue().booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
