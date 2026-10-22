package com.bytedance.android.livesdk.interactivity.interactive;

import android.animation.Animator;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveDialog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.vs.model.VSBannerInfo;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.interact.IAbsCardWindow;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveHelper;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractivePresenter$IView;", "Landroid/content/Context;", "getContext", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInteractiveHelper implements LiveInteractivePresenter.IView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f137079r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<Boolean> f137080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HybridCard f137082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveInteractivePresenter f137083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.x<String, String> f137084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f137085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EpisodeInteractiveDialog f137086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IAbsCardWindow f137087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f137088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f137089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f137090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f137091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f137092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f137093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f137094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f137095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.interactive.b f137096q;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137098b;

        public b(LiveInteractiveHelper r100, long r101) {
            this.f137097a = r100;
            this.f137098b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            JSONObject r102 = new JSONObject();
            r102.put("type", "change_camera_id");
            JSONObject r103 = new JSONObject();
            long r104 = this.f137098b;
            vr1.u r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137097a.f137094o, null, 2);
            if (r105 == null) goto L11;
            Room r106 = r105.j0();
            if (r106 == null) goto L11;
            IEpisodeExtraInfo r107 = r106.getEpisodeComponentData();
            if (r107 == null) goto L11;
            if (r104 != r107.getDefaultCameraId()) goto L11;
            Object r108 = 0L;
        L12:
            r103.put(ShortVideoSegments.KEY_CAMERA_ID, r108);
            r102.put("data", r103);
            return r102;
        L11:
            r108 = String.valueOf(this.f137098b);
            goto L12
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137099a;

        public c(LiveInteractiveHelper r100) {
            this.f137099a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            HybridCard r102 = this.f137099a.f137082c;
            if (r102 == null) goto L6;
            r102.sendJsEvent("H5_roomStatusChange", r101);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f137100a = null;

        static {
            f137100a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137102b;

        public e(LiveInteractiveHelper r100, long r101) {
            this.f137101a = r100;
            this.f137102b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            JSONObject r102 = new JSONObject();
            r102.put("type", "sei");
            JSONObject r103 = new JSONObject();
            LiveInteractiveHelper r104 = this.f137101a;
            int r105 = LiveInteractiveHelper.f137079r;
            r103.put("room_id", String.valueOf(r104.i()));
            DataCenter r106 = this.f137101a.f137094o;
            int r107 = o82.i.f522359a;
            vr1.u r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r106, null, 2);
            if (r108 == null) goto L5;
            long r109 = r108.d1();
        L6:
            r103.put("time_point", r109 / ((long) 1000));
            r103.put("speed", 1.0d);
            r103.put("sei_ts", this.f137102b);
            r103.put("extra", r101);
            r102.put("data", r103);
            r102.put("log", LiveInteractiveHelper.a(this.f137101a));
            Iterator<Map.Entry<String, String>> r110 = this.f137101a.g().entrySet().iterator();
        L8:
            if (r110.hasNext() == false) goto L10;
            Map.Entry<String, String> r111 = r110.next();
            r102.put(r111.getKey(), r111.getValue());
            goto L8
        L10:
            return r102;
        L5:
            r109 = 0;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137104b;

        public f(LiveInteractiveHelper r100, long r101) {
            this.f137103a = r100;
            this.f137104b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f137103a.o("H5_roomStatusChange", r101);
            if (this.f137103a.f137082c == null) goto L6;
            o82.h.b("[" + this.f137103a.hashCode() + "]notify vs sei event, sei time: " + this.f137104b);
            o82.h.b("[" + this.f137103a.hashCode() + "]notify vs sei event, data: " + r101);
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f137103a.hashCode());
            r102.append("]vs sei event");
            o82.h.a(r102.toString(), r101);
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f137105a = null;

        static {
            f137105a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.i("LiveInteractiveHelper", "send sei fail cause:" + ((Throwable) r100).getMessage());
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f137108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f137109d;

        public h(LiveInteractiveHelper r100, String r101, long r102, float r103) {
            this.f137106a = r100;
            this.f137107b = r101;
            this.f137108c = r102;
            this.f137109d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = new JSONObject();
            r101.put("type", this.f137107b);
            JSONObject r102 = new JSONObject();
            LiveInteractiveHelper r103 = this.f137106a;
            int r104 = LiveInteractiveHelper.f137079r;
            r102.put("room_id", String.valueOf(r103.i()));
            r102.put("time_point", this.f137108c);
            r102.put("speed", this.f137109d);
            r102.put("sei_ts", o82.i.c(this.f137106a.f137094o));
            r102.put("extra", (JSONObject) r100);
            r101.put("data", r102);
            r101.put("log", LiveInteractiveHelper.a(this.f137106a));
            Iterator<Map.Entry<String, String>> r105 = this.f137106a.g().entrySet().iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            Map.Entry<String, String> r106 = r105.next();
            r101.put(r106.getKey(), r106.getValue());
            goto L4
        L6:
            return r101;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f137112c;

        public i(LiveInteractiveHelper r100, String r101, long r102) {
            this.f137110a = r100;
            this.f137111b = r101;
            this.f137112c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f137110a.o("H5_roomStatusChange", r101);
            if (this.f137110a.f137082c == null) goto L6;
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f137110a.hashCode());
            r102.append("]notify vs play event, type: ");
            r102.append(this.f137111b);
            r102.append(", time point: ");
            long r103 = 60;
            r102.append(this.f137112c / r103);
            r102.append(":");
            r102.append(this.f137112c % r103);
            o82.h.b(r102.toString());
            o82.h.b("[" + this.f137110a.hashCode() + "]notify vs play event, data: " + r101);
            o82.h.a("vs play event", r101);
            return;
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f137113a = null;

        static {
            f137113a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f137114a = null;

        static {
            f137114a = new k();
        }

        public k() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r101);
        }
    }

    public static final class l<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137115a;

        public l(LiveInteractiveHelper r100) {
            this.f137115a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveHelper.a(this.f137115a));
            return r102;
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.base.model.message.n f137117b;

        public m(LiveInteractiveHelper r100, com.bytedance.android.live.base.model.message.n r101) {
            this.f137116a = r100;
            this.f137117b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("[" + this.f137116a.hashCode() + "]H5_roomStatusChange" + r101);
            o82.h.a("LiveInteractiveMessage", this.f137117b.extra());
            this.f137116a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class n<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f137118a = null;

        static {
            f137118a = new n();
        }

        public n() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class o<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f137119a = null;

        static {
            f137119a = new o();
        }

        public o() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r101);
        }
    }

    public static final class p<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137120a;

        public p(LiveInteractiveHelper r100) {
            this.f137120a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveHelper.a(this.f137120a));
            return r102;
        }
    }

    public static final class q<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ku2.b f137122b;

        public q(LiveInteractiveHelper r100, ku2.b r101) {
            this.f137121a = r100;
            this.f137122b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("[" + this.f137121a.hashCode() + "]H5_roomStatusChange" + r101);
            o82.h.a("InRoomBannerMessage", this.f137122b.extra());
            this.f137121a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class r<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f137123a = null;

        static {
            f137123a = new r();
        }

        public r() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class s<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f137124a = null;

        static {
            f137124a = new s();
        }

        public s() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r101);
        }
    }

    public static final class t<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137125a;

        public t(LiveInteractiveHelper r100) {
            this.f137125a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveHelper.a(this.f137125a));
            return r102;
        }
    }

    public static final class u<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o5 f137127b;

        public u(LiveInteractiveHelper r100, o5 r101) {
            this.f137126a = r100;
            this.f137127b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("H5_roomStatusChange" + r101);
            o82.h.a("VSInteractiveMessage", this.f137127b.extra());
            this.f137126a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class v<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f137128a = null;

        static {
            f137128a = new v();
        }

        public v() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class w implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f137129a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public w(x r100) {
            this.f137129a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137129a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137129a.run();
        }
    }

    public static final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f137131b;

        public x(LiveInteractiveHelper r100, View r101) {
            this.f137130a = r100;
            this.f137131b = r101;
        }

        public final void a() {
            boolean r100 = false;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L5;
            this.f137131b.setVisibility(8);
            this.f137130a.f137089j = 0;
        L14:
            if (this.f137131b.getLayoutParams() == null) goto L33;
            DataCenter r101 = this.f137130a.f137094o;
            if (r101 == null) goto L19;
            r101.put("data_vs_interactive_widget_region", null);
        L19:
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L28;
            LiveInteractiveHelper r102 = this.f137130a;
            DataCenter r103 = r102.f137094o;
            if (r103 == null) goto L31;
            IAbsCardWindow r104 = r102.f137087h;
            if (r104 != null) goto L25;
        L27:
            r103.put("data_live_interactive_component_show", Boolean.valueOf(r100));
            goto L31
        L25:
            if (r104.isShowingWindow() != true) goto L27;
            r100 = true;
        L31:
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.f137130a.f137094o);
            return;
        L28:
            DataCenter r105 = this.f137130a.f137094o;
            if (r105 == null) goto L31;
            r105.put("data_live_interactive_component_show", Boolean.FALSE);
            goto L31
        L33:
            return;
        L5:
            IAbsCardWindow r106 = this.f137130a.f137087h;
            if (r106 == null) goto L14;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L11;
            r106 = null;
        L11:
            if (r106 == null) goto L14;
            r106.dismissWindow();
            this.f137130a.f137089j = 0;
            goto L14
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

    public static final class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveHelper f137132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f137133b;

        public y(LiveInteractiveHelper r100, View r101) {
            this.f137132a = r100;
            this.f137133b = r101;
        }

        public final void a() {
            int[] r100 = new int[2];
            this.f137133b.getLocationOnScreen(r100);
            DataCenter r101 = this.f137132a.f137094o;
            int r102 = r100[0];
            r101.put("data_vs_interactive_widget_region", new RectF(r102, r100[1], r102 + this.f137133b.getLayoutParams().width, r100[1] + this.f137133b.getLayoutParams().height));
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

    public static final class z implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f137134a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public z(View r100) {
            this.f137134a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim cancel, view=" + this.f137134a.hashCode());
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137134a.setAlpha(1);
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim finish, view=" + this.f137134a.hashCode());
        }
    }

    static {
    }

    public boolean c() {
        return true;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public String j() {
        return "live_";
    }

    public LiveInteractivePresenter e() {
        return new LiveInteractivePresenter();
    }

    public final long f() {
        DataCenter r100 = this.f137094o;
        if (r100 == null) goto L20;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r100);
        if (r101 == null) goto L20;
        IBaseUser r102 = r101.getOwner();
        if (r102 == null) goto L20;
        String r103 = r102.getIdString();
        if (r103 == null) goto L20;
        Intrinsics.checkNotNullParameter(r103, "$this$safeToLong");
        if (r103.length() != 0) goto L13;
        boolean r104 = true;
    L14:
        Long r105 = null;
        if (r104 == false) goto L23;
    L18:
        if (r105 == null) goto L20;
        return r105.longValue();
    L23:
        r105 = Long.valueOf(CastLongProtector.parseLong(r103));     // Catch: Throwable -> L22
        goto L18
    L13:
        r104 = false;
    L20:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f137096q.u9();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final String getLogTag() {
        return this.f137096q.getTag();
    }

    public km1.a h() {
        vr1.u r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137094o, null, 2);
        if (r100 == null) goto L5;
        ViewModel r101 = r100.c();
    L7:
        if ((r101 instanceof EpisodeInteractiveContext) == true) goto L9;
        r101 = null;
    L9:
        EpisodeInteractiveContext r102 = (EpisodeInteractiveContext) r101;
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.n<km1.a> r103 = r102.getLiveInteractiveInfo();
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.getValue();
    L15:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    public final long i() {
        DataCenter r100 = this.f137094o;
        if (r100 == null) goto L7;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r100);
        if (r101 == null) goto L7;
        return r101.getRoomId();
    L7:
        return 0;
    }

    public final void release() {
        o82.h.b("[" + hashCode() + "]release hybrid component");
        View r100 = this.f137085f;
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L9;
        r101.removeAllViews();
    L9:
        if (h() != null) goto L15;
        o82.h.b("[" + hashCode() + "]release hybridCard also");
        HybridCard r102 = this.f137082c;
        if (r102 == null) goto L13;
        r102.release();
    L13:
        this.f137082c = null;
        return;
    }

    public Map<String, String> g() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView, com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public Context getContext() {
        return this.f137095p;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final DataCenter getDataCenter() {
        return this.f137094o;
    }

    public static final JSONObject a(LiveInteractiveHelper r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        if (r100.f137094o == null) goto L31;
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().j(am2.x.class);
        String r103 = "";
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().i(r102) == true) goto L8;
        String r104 = "";
    L24:
        r101.put("enter_from_merge", r103).put("enter_method", r104).put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail").put("room_id", String.valueOf(r100.i())).put("anchor_id", String.valueOf(r100.f()));
        Iterator<Map.Entry<String, String>> r105 = r100.g().entrySet().iterator();
    L26:
        if (r105.hasNext() == false) goto L28;
        Map.Entry<String, String> r106 = r105.next();
        r101.put(r106.getKey(), r106.getValue());
        goto L26
    L28:
        IRoom r107 = (IRoom) r100.f137094o.get("data_room", null);
        if (r107 == null) goto L31;
        r101.put("request_id", r107.getRequestId()).put("log_pb", r107.getLog_pb());
        goto L31
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().o(r102, "enter_from") == false) goto L10;
        String r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().a(r102, "enter_from");
    L12:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().o(r102, "source") == false) goto L14;
        String r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().a(r102, "source");
    L15:
        HashMap r110 = new HashMap();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().dataMapping(r108, r109, r110);
        String r111 = (String) r110.get("enter_from_merge");
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        String r112 = (String) r110.get("enter_method");
        if (r112 == null) goto L22;
        r103 = r112;
    L22:
        String r113 = r103;
        r103 = r111;
        r104 = r113;
        goto L24
    L14:
        r109 = "";
        goto L15
    L10:
        r108 = "";
    L31:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void HR(com.bytedance.android.live.base.model.message.n r100) {
        if (this.f137096q.isVisible() == false) goto L12;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137082c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L15;
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(k.f137114a).map(new l(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new m(this, r100), n.f137118a);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void Nj(long r100) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new b(this, r100)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new c(this), d.f137100a);
    }

    public final String b(String r100) {
        Uri r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(UriProtector.parse(r100), this.f137094o);
        if (r101 == null) goto L13;
        Uri.Builder r102 = r101.buildUpon();
        if (r102 == null) goto L13;
        Uri.Builder r103 = r102.appendQueryParameter("request_page", "top");
        if (r103 == null) goto L13;
        String r104 = fq1.t.a().getCurrentUserId();
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        Uri.Builder r105 = r103.appendQueryParameter("user_id", r104);
    L14:
        if (r105 == null) goto L19;
        Uri.Builder r106 = r105.appendQueryParameter("room_id", String.valueOf(i()));
        if (r106 == null) goto L19;
        r106.appendQueryParameter("anchor_id", String.valueOf(f()));
    L19:
        if (r105 == null) goto L26;
        if (this.f137093n == false) goto L23;
        String r107 = "0";
    L24:
        r105.appendQueryParameter("is_hor", r107);
        goto L26
    L23:
        r107 = "1";
    L26:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137094o).isPaidLive() == false) goto L33;
        if (r105 == null) goto L29;
        r105.appendQueryParameter("is_paidlive", "1");
    L29:
        if (r105 == null) goto L31;
        r105.appendQueryParameter("ticket_session_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.b.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137094o).J0(), this.f137094o)));
    L31:
        if (r105 == null) goto L33;
        r105.appendQueryParameter(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137094o).J0().q(this.f137094o));
    L33:
        Iterator<Map.Entry<String, String>> r108 = g().entrySet().iterator();
    L35:
        if (r108.hasNext() == false) goto L39;
        Map.Entry<String, String> r109 = r108.next();
        if (r105 == null) goto L35;
        r105.appendQueryParameter(r109.getKey(), r109.getValue());
        goto L35
    L39:
        if (r105 == null) goto L50;
        String r110 = r105.toString();
        if (r110 != null) goto L44;
        return "";
    L44:
        return r110;
    L50:
        return "";
    L13:
        r105 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void jP(long r100) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new e(this, r100)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new f(this, r100), g.f137105a);
    }

    public final void l(IBannerInfo r100) {
        o82.h.b("[" + hashCode() + "]on banner data");
        this.f137096q.ol();
        if (this.f137096q.isVisible() == false) goto L41;
        if (r100 == null) goto L41;
        VSBannerInfo r101 = (VSBannerInfo) r100.castToOrNull(VSBannerInfo.class);
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.getH5Url();
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L41;
        release();
        VSBannerInfo r104 = (VSBannerInfo) r100.castToOrNull(VSBannerInfo.class);
        boolean r105 = false;
        if (r104 == null) goto L15;
        boolean r106 = r104.isLynxContainerEnabled();
    L16:
        if (r106 == false) goto L25;
        VSBannerInfo r107 = (VSBannerInfo) r100.castToOrNull(VSBannerInfo.class);
        if (r107 == null) goto L21;
        r102 = r107.getLynxUrl();
    L21:
        if (TextUtils.isEmpty(r102) == true) goto L25;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().q() == false) goto L25;
        r105 = true;
    L25:
        if (r105 == false) goto L29;
        VSBannerInfo r108 = (VSBannerInfo) r100.castToOrNull(VSBannerInfo.class);
        if (r108 == null) goto L33;
        r108.getLynxUrl();
    L33:
        if (Intrinsics.areEqual(this.f137080a.getValue(), Boolean.TRUE) == false) goto L35;
        k(r100, r105, this.f137085f);
        return;
    L35:
        o82.h.b("[" + hashCode() + "]onBannerData contentView hasn't init, wait");
        NextLiveData<Boolean> r109 = this.f137080a;
        Context r110 = this.f137095p;
        if (r110 == null) goto L40;
        r109.observe((FragmentActivity) r110, new d0(this, r100, r105));
        return;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L29:
        VSBannerInfo r111 = (VSBannerInfo) r100.castToOrNull(VSBannerInfo.class);
        if (r111 == null) goto L33;
        r111.getH5Url();
        goto L33
    L15:
        r106 = false;
        goto L16
    L8:
        r103 = null;
    L41:
        o82.h.b("[" + hashCode() + "]banner data is empty");
    }

    public final void m(boolean r100) {
        if (this.f137082c == null) goto L9;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L6
        r102.put("foreground", r100);     // Catch: Exception -> L6
        r101.put("type", "app");     // Catch: Exception -> L6
        r101.put("args", r102);     // Catch: Exception -> L6
        o("H5_appStateChange", r101);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void p(boolean r100) {
        View r101 = this.f137085f;
        if (r101 != null) goto L5;
        return;
    L5:
        o82.h.b("setHybridComponentGone[" + hashCode() + "];withAnim=" + r100 + ", view=" + r101.hashCode());
        x r102 = new x(this, r101);
        if (r100 == false) goto L8;
        r101.animate().alpha(0).setDuration(200).setListener(new w(r102)).start();
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L12;
        return;
    L12:
        if (this.f137081b != 1) goto L38;
        EpisodeInteractiveDialog r103 = this.f137086g;
        if (r103 == null) goto L32;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r103);
        goto L32
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r105 == null) goto L29;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L18:
        if (Looper.myLooper() == r104.getLooper()) goto L20;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L32:
        o82.h.b("setHybridComponentGone[" + hashCode() + "] hide dialog");
        return;
    L38:
        return;
    L8:
        r101.setAlpha(0);
        r102.run();
        goto L10
    }

    public final void s(boolean r100) {
        if (this.f137094o != null) goto L5;
        return;
    L5:
        if (this.f137085f != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L10;
    L19:
        View r101 = this.f137085f;
        if (r101 != null) goto L22;
        return;
    L22:
        boolean r102 = false;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L25;
        r101.setVisibility(0);
    L33:
        HybridCard r103 = this.f137082c;
        if (r103 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r103);
    L36:
        this.f137089j = 1;
        if (this.f137093n == true) goto L40;
        r101.post(new y(this, r101));
    L40:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L49;
        DataCenter r104 = this.f137094o;
        if (r104 == null) goto L52;
        IAbsCardWindow r105 = this.f137087h;
        if (r105 != null) goto L46;
    L48:
        r104.put("data_live_interactive_component_show", Boolean.valueOf(r102));
        goto L52
    L46:
        if (r105.isShowingWindow() != true) goto L48;
        r102 = true;
    L52:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.f137094o);
        if (r100 == false) goto L59;
        ViewPropertyAnimator r106 = r101.animate().alpha(1);
        if (this.f137093n == false) goto L57;
        int r107 = 200;
    L58:
        r106.setDuration(r107).setListener(new z(r101)).start();
        return;
    L57:
        r107 = 300;
        goto L58
    L59:
        r101.setAlpha(1);
        o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim false, view=" + r101.hashCode());
        return;
    L49:
        DataCenter r108 = this.f137094o;
        if (r108 == null) goto L52;
        r108.put("data_live_interactive_component_show", Boolean.TRUE);
        goto L52
    L25:
        IAbsCardWindow r109 = this.f137087h;
        if (r109 == null) goto L33;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L31;
        r109 = null;
    L31:
        if (r109 == null) goto L33;
        r109.showWindow();
        goto L33
    L10:
        if (this.f137081b != 1) goto L19;
        EpisodeInteractiveDialog r110 = this.f137086g;
        if (r110 != null) goto L14;
    L18:
        o82.h.b("setHybridComponentVisible[" + hashCode() + "] show dialog");
        goto L19
    L14:
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L62;
        DialogLancet.handleBlockedDialogShow(r110);
        goto L18
    L62:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L61
    L17:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L18
    }

    public void t(km1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interactiveInfo");
        ViewModel r101 = null;
        vr1.u r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137094o, null, 2);
        if (r102 == null) goto L5;
        ViewModel r103 = r102.c();
    L7:
        if ((r103 instanceof EpisodeInteractiveContext) == false) goto L10;
        r101 = r103;
    L10:
        EpisodeInteractiveContext r104 = (EpisodeInteractiveContext) r101;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.n<km1.a> r105 = r104.getLiveInteractiveInfo();
        if (r105 == null) goto L17;
        r105.setValue(r100);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void ux(o5 r100) {
        if (this.f137096q.isVisible() == false) goto L24;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137082c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L27;
        DataCenter r101 = this.f137094o;
        if (r101 == null) goto L22;
        IRoom r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r101);
        if (r102 == null) goto L22;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L22;
        ju2.d r104 = (ju2.d) r103.castToOrNull(ju2.d.class);
        if (r104 == null) goto L22;
        if (r104.isEnableEpisodeInteractive() == true) goto L22;
        o82.h.b("abandon Interact Message cuzz of auth.interactiveComponent is hidden");
        return;
    L22:
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(s.f137124a).map(new t(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new u(this, r100), v.f137128a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void wz(ku2.b r100) {
        if (this.f137096q.isVisible() == false) goto L24;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137082c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L27;
        DataCenter r101 = this.f137094o;
        if (r101 == null) goto L22;
        IRoom r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r101);
        if (r102 == null) goto L22;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L22;
        ju2.d r104 = (ju2.d) r103.castToOrNull(ju2.d.class);
        if (r104 == null) goto L22;
        if (r104.isEnableEpisodeInteractive() == true) goto L22;
        o82.h.b("abandon Interact Message cuzz of auth.interactiveComponent is hidden");
        return;
    L22:
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(o.f137119a).map(new p(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new q(this, r100), r.f137123a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void zP(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        JSONObject r101 = new JSONObject();
        r101.put("url", r100);     // Catch: JSONException -> L5
    L7:
        o82.h.b("[" + hashCode() + "]H5_VSVoteListClosed: url: " + r100);
        StringBuilder r102 = new StringBuilder("[");
        r102.append(hashCode());
        r102.append("]vs panel close event");
        o82.h.a(r102.toString(), r100);
        o("H5_VSVoteListClosed", r101);
        return;
    L5:
        e = move-exception;
        ALogger.e("LiveInteractiveHelper", e);
        goto L7
    }

    public final void o(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        HybridCard r102 = this.f137082c;
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    public final void k(IBannerInfo r110, boolean r111, View r112) {
        o82.h.b("start initHybridComponentForAnnie[" + hashCode() + "], contentView:" + r112 + ",bannerInfo:" + r110);
        km1.a r100 = h();
        View r101 = null;
        if (r100 != null) goto L5;
    L27:
        Context r102 = this.f137095p;
        if (r102 == null) goto L54;
        o82.g r103 = new o82.g(!r111);
        String r104 = "";
        if (r111 == false) goto L43;
        VSBannerInfo r113 = (VSBannerInfo) r110.castToOrNull(VSBannerInfo.class);
        if (r113 == null) goto L35;
        String r114 = r113.getLynxUrl();
        if (r114 == null) goto L35;
    L36:
        Uri.Builder r115 = x6.a.d(b(r114)).buildUpon();
        VSBannerInfo r105 = (VSBannerInfo) r110.castToOrNull(VSBannerInfo.class);
        if (r105 == null) goto L42;
        String r106 = r105.getH5Url();
        if (r106 == null) goto L42;
        r104 = r106;
    L42:
        Uri r116 = r115.appendQueryParameter("fallback_url", b(r104)).build();
    L50:
        o82.h.b("[" + hashCode() + "]load url: " + r116);
        HybridCard r117 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().getHybridCard(r102, r116, new c0(r103, r116, this, r110));
        if (r117 == null) goto L53;
        a7.a.a(r117, null, null, 3);
    L53:
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: obtain instance " + r117);
    L56:
        if (r117 == null) goto L95;
        this.f137082c = r117;
        r117.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r117.getParent() == null) goto L65;
        o82.h.b("initHybridComponentForAnnie[" + hashCode() + "]: HybridCard has parentView which need to be removed");
        ViewParent r118 = r117.getParent();
        if ((r118 instanceof ViewGroup) == true) goto L62;
        r118 = null;
    L62:
        ViewGroup r119 = (ViewGroup) r118;
        if (r119 == null) goto L65;
        r119.removeView(r117);
    L65:
        boolean r120 = r112 instanceof ViewGroup;
        if (r120 == true) goto L68;
        View r107 = null;
    L69:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L72;
        r108.addView(r117, 0);
    L72:
        StringBuilder r121 = new StringBuilder("initHybridComponentForAnnie[");
        r121.append(hashCode());
        r121.append("], after add view, contentView now childCount:");
        if (r120 == true) goto L75;
        View r122 = null;
    L76:
        ViewGroup r123 = (ViewGroup) r122;
        if (r123 == null) goto L79;
        Integer r124 = Integer.valueOf(r123.getChildCount());
    L80:
        r121.append(r124);
        o82.h.b(r121.toString());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L95;
        View r125 = new View(this.f137095p);
        r125.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if ((r112 instanceof FrameLayout) == false) goto L86;
        r101 = r112;
    L86:
        FrameLayout r109 = (FrameLayout) r101;
        if (r109 == null) goto L89;
        r109.addView(r125);
    L89:
        if (r112 == null) goto L91;
        r112.setFocusable(true);
    L91:
        if (r112 == null) goto L93;
        r112.setFocusableInTouchMode(true);
    L93:
        r125.setBackground(new ColorDrawable(0));
        r3.a(r112, "活动入口");
        goto L95
    L79:
        r124 = null;
        goto L80
    L75:
        r122 = r112;
        goto L76
    L68:
        r107 = r112;
    L95:
        if (this.f137082c != null) goto L97;
        o82.h.b("[" + hashCode() + "]register interactive jsb failed");
    L112:
        b20("init", 0, 1.0f, new JSONObject());
        return;
    L97:
        o82.h.b("[" + hashCode() + "]register interactive jsb");
        HybridCard r126 = this.f137082c;
        if (r126 == null) goto L100;
        r126.registerMethod("interactiveBannerShow", new e0(this));
    L100:
        HybridCard r127 = this.f137082c;
        if (r127 == null) goto L103;
        r127.registerMethod("interactiveSetStorage", new f0(this));
    L103:
        HybridCard r128 = this.f137082c;
        if (r128 == null) goto L106;
        r128.registerMethod("interactiveGetStorage", new g0(this));
    L106:
        HybridCard r129 = this.f137082c;
        if (r129 == null) goto L109;
        r129.registerMethod("getSeiInfo", new h0(this));
    L109:
        EpisodeInteractiveDialog r130 = this.f137086g;
        if (r130 == null) goto L112;
        r130.setOnDismissListener(new i0(this));
    L35:
        r114 = "";
        goto L36
    L43:
        VSBannerInfo r131 = (VSBannerInfo) r110.castToOrNull(VSBannerInfo.class);
        if (r131 == null) goto L49;
        String r132 = r131.getH5Url();
        if (r132 == null) goto L49;
        r104 = r132;
    L49:
        r116 = x6.a.b(b(r104));
        goto L50
    L54:
        String r133 = "obtainHybridComponentForAnnie[" + hashCode() + "]: return null";
        RuntimeException r134 = new RuntimeException("obtainHybridComponentForAnnie null");
        Intrinsics.checkNotNullParameter(r133, "msg");
        Intrinsics.checkNotNullParameter(r134, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        ALogger.e("LiveInteractive", r133, r134);
    L55:
        r117 = null;
        goto L56
    L5:
        if (Intrinsics.areEqual(r100.f504042a, r110) == false) goto L27;
        r117 = r100.f504045d;
        if (r117 == null) goto L55;
        boolean r135 = r100.f504044c;
        vr1.u r136 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137094o, null, 2);
        if (r136 != null) goto L11;
    L12:
        vr1.u r137 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137094o, null, 2);
        if (r137 == null) goto L15;
        boolean r138 = r137.isPortraitInteraction();
    L16:
        r100.f504044c = r138;
        StringBuilder r139 = new StringBuilder("[");
        r139.append(hashCode());
        r139.append("]roomHorizontalChange: is_horizontal: ");
        DataCenter r140 = this.f137094o;
        if (r140 == null) goto L19;
        Boolean r141 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r140, true));
    L20:
        r139.append(r141);
        o82.h.b(r139.toString());
        JSONObject r142 = new JSONObject();
        DataCenter r143 = this.f137094o;
        if (r143 != null) goto L23;
    L25:
        int r144 = 1;
    L26:
        r142.put("is_horizontal", r144);
        Unit r145 = Unit.INSTANCE;
        r117.sendJsEvent("roomHorizontalChange", r142);
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: reuse hybrid card, sendRoomHorizontalChangeJSEvent");
        goto L56
    L23:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r143, true) != true) goto L25;
        r144 = 0;
        goto L26
    L19:
        r141 = null;
        goto L20
    L15:
        r138 = false;
        goto L16
    L11:
        if (r135 == r136.isPortraitInteraction()) goto L56;
        goto L12
    }

    public LiveInteractiveHelper(boolean r100, DataCenter r101, Context r102, com.bytedance.android.livesdk.interactivity.interactive.b r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f137093n = r100;
        this.f137094o = r101;
        this.f137095p = r102;
        this.f137096q = r103;
        this.f137080a = new NextLiveData();
        this.f137088i = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void b20(String r100, long r101, float r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r111, "extra");
        ((SingleSubscribeProxy) Single.just(r111).observeOn(Schedulers.io()).map(new h(this, r100, r101, r110)).observeOn(AndroidSchedulers.mainThread()).as(this.f137096q.s7())).subscribe(new i(this, r100, r101), j.f137113a);
    }
}
