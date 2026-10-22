package com.bytedance.android.shopping.order;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.o;
import com.bytedance.android.shopping.anchorv3.comment.helper.ShowOrderSource;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.order.api.OrderApi;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class PublishUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f179649a = null;

    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f179650a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.order.PublishUtil$a$a, reason: collision with other inner class name */
        public static final class RunnableC2677a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f179651a;

            public RunnableC2677a(a r100) {
                this.f179651a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
                r100.put("eventName", "ecPostCommentVideo");     // Catch: Throwable -> L4
                r100.put("data", this.f179651a.f179650a);     // Catch: Throwable -> L4
                Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L4
                ECLiveHybridUtil.f("notification", r100);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            vi.a r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo();
            JSONObject r101 = new JSONObject();
            r101.put("eventName", "ecPostCommentVideo");
            r101.put("data", this.f179650a);
            Unit r102 = Unit.INSTANCE;
            r100.d(r101);
            Handler r103 = PublishUtil.f179649a;
            PublishUtil.f179649a.post(new RunnableC2677a(this));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public a(JSONObject r100) {
            this.f179650a = r100;
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f179652a = null;

        static {
            f179652a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            cg3.h r102 = (cg3.h) r100;
            cg3.d r103 = (cg3.d) r101;
            Intrinsics.checkNotNullParameter(r102, "shareInfoResponseDTO");
            Intrinsics.checkNotNullParameter(r103, "commentPublishResponseDTO");
            cg3.e r104 = r102.a();
            if (r104 != null) goto L6;
            r104 = new cg3.e(0);
        L6:
            return new cg3.c(r104, r103);
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cg3.e f179653a;

        public c(cg3.e r100) {
            this.f179653a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            cg3.d r101 = (cg3.d) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new cg3.c(this.f179653a, r101);
        }
    }

    public static final class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f179654a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f179655a;

            public a(d r100) {
                this.f179655a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
                r100.put("eventName", "ecPostCommentVideoTask");     // Catch: Throwable -> L4
                r100.put("data", this.f179655a.f179654a);     // Catch: Throwable -> L4
                Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L4
                ECLiveHybridUtil.f("notification", r100);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            vi.a r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo();
            JSONObject r101 = new JSONObject();
            r101.put("eventName", "ecPostCommentVideoTask");
            r101.put("data", this.f179654a);
            Unit r102 = Unit.INSTANCE;
            r100.d(r101);
            Handler r103 = PublishUtil.f179649a;
            PublishUtil.f179649a.post(new a(this));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public d(JSONObject r100) {
            this.f179654a = r100;
        }
    }

    public PublishUtil() {
    }

    static {
        f179649a = new Handler(Looper.getMainLooper());
    }

    public static String b(cg3.f r100) {
        StringBuilder r101 = new StringBuilder("{\"order_id\":\"");
        if (r100 == null) goto L5;
        Long r102 = r100.d();
    L6:
        r101.append(r102);
        r101.append("\",\"show_order_source\":\"");
        r101.append(ShowOrderSource.COMMENT_PUBLISH_SHOW_ORDER.getSource());
        r101.append("\"}");
        return r101.toString();
    L5:
        r102 = null;
        goto L6
    }

    public static Observable c(cg3.g r110, cg3.f r111) {
        OrderApi.f179667a.getClass();
        OrderApi r100 = OrderApi.a.f179668a;
        if (r110 == null) goto L5;
        Long r101 = r110.f23659a;
    L6:
        if (r110 == null) goto L8;
        Long r102 = r110.f23660b;
    L9:
        if (r110 == null) goto L11;
        Long r103 = r110.f23661c;
    L12:
        if (r111 == null) goto L14;
        Long r104 = r111.q();
    L15:
        if (r111 == null) goto L17;
        String r105 = r111.a();
    L18:
        if (r111 == null) goto L20;
        Long r106 = r111.b();
    L21:
        if (r111 == null) goto L23;
        Long r107 = r111.d();
    L24:
        if (r111 == null) goto L26;
        Long r112 = r111.g();
    L27:
        if (r111 == null) goto L29;
        Long r113 = r111.j();
    L30:
        if (r111 == null) goto L32;
        Long r114 = r111.k();
    L33:
        if (r111 == null) goto L35;
        Long r115 = r111.l();
    L36:
        if (r111 == null) goto L38;
        String r116 = r111.e();
    L39:
        if (r111 == null) goto L41;
        String r117 = r111.p();
    L42:
        if (r111 == null) goto L44;
        Boolean r118 = r111.c();
    L46:
        return r100.publishComment(r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r118).subscribeOn(Schedulers.io());
    L44:
        r118 = null;
        goto L46
    L41:
        r117 = null;
        goto L42
    L38:
        r116 = null;
        goto L39
    L35:
        r115 = null;
        goto L36
    L32:
        r114 = null;
        goto L33
    L29:
        r113 = null;
        goto L30
    L26:
        r112 = null;
        goto L27
    L23:
        r107 = null;
        goto L24
    L20:
        r106 = null;
        goto L21
    L17:
        r105 = null;
        goto L18
    L14:
        r104 = null;
        goto L15
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public static void f(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        JSONObject r102 = new JSONObject();
        r102.put(SimilarProductParam.AWEME_ID, r100);
        r102.put("motivate_ret", r101);
        JSONObject r103 = new JSONObject();
        r103.put("data", r102);
        int r104 = 0;
        if (r100.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        r104 = -1;
    L8:
        r103.put("code", r104);
        new PthreadTimer("r/PublishUtil").schedule(new d(r103), 1000);
        return;
    L5:
        r105 = false;
        goto L6
    }

    public static void a(final String r100, String r101, String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r102 = true;
        if (r110 != null) goto L7;
    L11:
        int r103 = ECSdk.f48106a;
        s83.g r104 = (s83.g) ECSdk.a(s83.g.class);
        if (r104 == null) goto L14;
        r104.L(r100, "", "", null, null);
    L14:
        JSONObject r105 = new JSONObject();
        r105.put(SimilarProductParam.AWEME_ID, r100);
        JSONObject r111 = new JSONObject();
        int r106 = 0;
        if (r100.length() == 0) goto L18;
        r102 = false;
    L18:
        if (r102 == false) goto L20;
        r106 = -1;
    L20:
        r111.put("code", r106);
        r111.put("data", r105);
        new PthreadTimer("r/PublishUtil").schedule(new a(r111), 1000);
        return;
    L7:
        if (k.c(r110) != true) goto L11;
        int r107 = ECSdk.f48106a;
        s83.g r108 = (s83.g) ECSdk.a(s83.g.class);
        if (r108 == null) goto L14;
        r108.L(r100, r101, r110, new PublishUtil$broadcast$1(r100), new PublishUtil$broadcast$2(r100));
        goto L14
    }

    public static void e(Context r110, cg3.k r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "param");
        cg3.e r100 = r111.f23666a;
        cg3.f r101 = r111.f23667b;
        String r102 = r111.f23668c;
        String r103 = r111.f23669d;
        Object r104 = r111.f23670e;
        Function2<Boolean, String, Unit> r113 = r111.f23671f;
        JSONObject r105 = new JSONObject();
        String r106 = "";
        if (r100 == null) goto L6;
        String r107 = r100.c();
        if (r107 == null) goto L6;
    L7:
        r105.put("anchor_title", r107);
        if (r100 == null) goto L13;
        String r108 = r100.b();
        if (r108 == null) goto L13;
        r106 = r108;
    L13:
        r105.put("anchor_description", r106);
        String r109 = null;
        if (r101 == null) goto L18;
        Long r114 = r101.g();
        if (r114 == null) goto L18;
        String r115 = String.valueOf(r114.longValue());
    L19:
        r105.put("product_id", r115);
        String r116 = r105.toString();
        o r117 = o.f48129a;
        Bundle r118 = new Bundle();
        r118.putString("local_video_path", r102);
        r118.putString("music_id", r103);
        if (r101 == null) goto L24;
        Long r119 = r101.g();
        if (r119 == null) goto L24;
        String r120 = String.valueOf(r119.longValue());
    L25:
        r118.putString("anchor_id", r120);
        r118.putString("content", r116);
        if (r112 == false) goto L31;
        if (r101 == null) goto L29;
        String r121 = r101.a();
    L30:
        r118.putString("text", r121);
        goto L31
    L29:
        r121 = null;
    L31:
        if (r100 == null) goto L35;
        Integer r122 = r100.a();
        if (r122 == null) goto L35;
        r109 = String.valueOf(r122.intValue());
    L35:
        r118.putString("rank_type", r109);
        r118.putInt("story_source_type", 10);
        r118.putString("shaidan_source_page", "comment_edit_page");
        r118.putString("activity_extra_json", b(r101));
        Unit r123 = Unit.INSTANCE;
        r117.d(r110, r118, r104, r113);
        return;
    L24:
        r120 = null;
    L18:
        r115 = null;
    L6:
        r107 = "";
        goto L7
    }

    public static Observable d(cg3.g r110, tl.a r111, cg3.e r112, Function1 r113) {
        if (r113 == null) goto L4;
        Unit r114 = (Unit) r113.invoke(Boolean.TRUE);
    L4:
        String r115 = null;
        if (r110 == null) goto L9;
        List<cg3.f> r100 = r110.f23662d;
        if (r100 == null) goto L9;
        cg3.f r101 = (cg3.f) CollectionsKt.firstOrNull(r100);
    L10:
        if (r112 != null) goto L38;
        OrderApi.f179667a.getClass();
        OrderApi r102 = OrderApi.a.f179668a;
        if (r111 == null) goto L14;
        Long r103 = r111.f546600a;
    L15:
        if (r111 == null) goto L17;
        Long r104 = r111.f546601b;
    L18:
        if (r111 == null) goto L20;
        String r105 = r111.f546602c;
    L21:
        if (r111 == null) goto L23;
        Long r106 = r111.f546603d;
    L24:
        if (r111 == null) goto L26;
        Long r107 = r111.f546604e;
    L27:
        if (r111 == null) goto L29;
        Long r108 = r111.f546605f;
    L30:
        if (r111 == null) goto L32;
        String r109 = r111.f546606g;
    L33:
        if (r111 == null) goto L36;
        r115 = r111.f546607h;
    L36:
        return Observable.zip(r102.getShareInfo(r103, r104, r105, r106, r107, r108, r109, r115).subscribeOn(Schedulers.io()), c(r110, r101), b.f179652a);
    L32:
        r109 = null;
        goto L33
    L29:
        r108 = null;
        goto L30
    L26:
        r107 = null;
        goto L27
    L23:
        r106 = null;
        goto L24
    L20:
        r105 = null;
        goto L21
    L17:
        r104 = null;
        goto L18
    L14:
        r103 = null;
        goto L15
    L38:
        return c(r110, r101).map(new c(r112));
    L9:
        r101 = null;
        goto L10
    }
}
