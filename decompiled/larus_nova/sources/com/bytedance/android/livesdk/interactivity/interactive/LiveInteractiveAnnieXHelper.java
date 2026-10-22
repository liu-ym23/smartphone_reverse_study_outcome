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
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
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
import com.bytedance.ies.bullet.kit.web.SSWebView;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveAnnieXHelper;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractivePresenter$IView;", "Landroid/content/Context;", "getContext", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInteractiveAnnieXHelper implements LiveInteractivePresenter.IView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f137015t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<Boolean> f137016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f137018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f137019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f137020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveInteractivePresenter f137021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.x<String, String> f137022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f137023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EpisodeInteractiveDialog f137024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IAbsCardWindow f137025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f137026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f137027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f137028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f137029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f137030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f137031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f137032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f137033r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.interactive.b f137034s;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137036b;

        public b(LiveInteractiveAnnieXHelper r100, long r101) {
            this.f137035a = r100;
            this.f137036b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            JSONObject r102 = new JSONObject();
            r102.put("type", "change_camera_id");
            JSONObject r103 = new JSONObject();
            long r104 = this.f137036b;
            vr1.u r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137035a.f137032q, null, 2);
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
            r108 = String.valueOf(this.f137036b);
            goto L12
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137037a;

        public c(LiveInteractiveAnnieXHelper r100) {
            this.f137037a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().x(this.f137037a.f137019d, "H5_roomStatusChange", r101);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f137038a = null;

        static {
            f137038a = new d();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137040b;

        public e(LiveInteractiveAnnieXHelper r100, long r101) {
            this.f137039a = r100;
            this.f137040b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            JSONObject r102 = new JSONObject();
            r102.put("type", "sei");
            JSONObject r103 = new JSONObject();
            LiveInteractiveAnnieXHelper r104 = this.f137039a;
            int r105 = LiveInteractiveAnnieXHelper.f137015t;
            r103.put("room_id", String.valueOf(r104.i()));
            DataCenter r106 = this.f137039a.f137032q;
            int r107 = o82.i.f522359a;
            vr1.u r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r106, null, 2);
            if (r108 == null) goto L5;
            long r109 = r108.d1();
        L6:
            r103.put("time_point", r109 / ((long) 1000));
            r103.put("speed", 1.0d);
            r103.put("sei_ts", this.f137040b);
            r103.put("extra", r101);
            r102.put("data", r103);
            r102.put("log", LiveInteractiveAnnieXHelper.a(this.f137039a));
            Iterator<Map.Entry<String, String>> r110 = this.f137039a.g().entrySet().iterator();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137042b;

        public f(LiveInteractiveAnnieXHelper r100, long r101) {
            this.f137041a = r100;
            this.f137042b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f137041a.o("H5_roomStatusChange", r101);
            if (this.f137041a.f137018c == null) goto L6;
            o82.h.b("[" + this.f137041a.hashCode() + "]notify vs sei event, sei time: " + this.f137042b);
            o82.h.b("[" + this.f137041a.hashCode() + "]notify vs sei event, data: " + r101);
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f137041a.hashCode());
            r102.append("]vs sei event");
            o82.h.a(r102.toString(), r101);
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f137043a = null;

        static {
            f137043a = new g();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f137046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f137047d;

        public h(LiveInteractiveAnnieXHelper r100, String r101, long r102, float r103) {
            this.f137044a = r100;
            this.f137045b = r101;
            this.f137046c = r102;
            this.f137047d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JSONObject r101 = new JSONObject();
            r101.put("type", this.f137045b);
            JSONObject r102 = new JSONObject();
            LiveInteractiveAnnieXHelper r103 = this.f137044a;
            int r104 = LiveInteractiveAnnieXHelper.f137015t;
            r102.put("room_id", String.valueOf(r103.i()));
            r102.put("time_point", this.f137046c);
            r102.put("speed", this.f137047d);
            r102.put("sei_ts", o82.i.c(this.f137044a.f137032q));
            r102.put("extra", (JSONObject) r100);
            r101.put("data", r102);
            r101.put("log", LiveInteractiveAnnieXHelper.a(this.f137044a));
            Iterator<Map.Entry<String, String>> r105 = this.f137044a.g().entrySet().iterator();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f137050c;

        public i(LiveInteractiveAnnieXHelper r100, String r101, long r102) {
            this.f137048a = r100;
            this.f137049b = r101;
            this.f137050c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f137048a.o("H5_roomStatusChange", r101);
            if (this.f137048a.f137018c == null) goto L6;
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f137048a.hashCode());
            r102.append("]notify vs play event, type: ");
            r102.append(this.f137049b);
            r102.append(", time point: ");
            long r103 = 60;
            r102.append(this.f137050c / r103);
            r102.append(":");
            r102.append(this.f137050c % r103);
            o82.h.b(r102.toString());
            o82.h.b("[" + this.f137048a.hashCode() + "]notify vs play event, data: " + r101);
            o82.h.a("vs play event", r101);
            return;
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f137051a = null;

        static {
            f137051a = new j();
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
        public static final k f137052a = null;

        static {
            f137052a = new k();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137053a;

        public l(LiveInteractiveAnnieXHelper r100) {
            this.f137053a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveAnnieXHelper.a(this.f137053a));
            return r102;
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.base.model.message.n f137055b;

        public m(LiveInteractiveAnnieXHelper r100, com.bytedance.android.live.base.model.message.n r101) {
            this.f137054a = r100;
            this.f137055b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("[" + this.f137054a.hashCode() + "]H5_roomStatusChange" + r101);
            o82.h.a("LiveInteractiveMessage", this.f137055b.extra());
            this.f137054a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class n<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f137056a = null;

        static {
            f137056a = new n();
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
        public static final o f137057a = null;

        static {
            f137057a = new o();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137058a;

        public p(LiveInteractiveAnnieXHelper r100) {
            this.f137058a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveAnnieXHelper.a(this.f137058a));
            return r102;
        }
    }

    public static final class q<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ku2.b f137060b;

        public q(LiveInteractiveAnnieXHelper r100, ku2.b r101) {
            this.f137059a = r100;
            this.f137060b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("[" + this.f137059a.hashCode() + "]H5_roomStatusChange" + r101);
            o82.h.a("InRoomBannerMessage", this.f137060b.extra());
            this.f137059a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class r<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f137061a = null;

        static {
            f137061a = new r();
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
        public static final s f137062a = null;

        static {
            f137062a = new s();
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137063a;

        public t(LiveInteractiveAnnieXHelper r100) {
            this.f137063a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            JSONObject r102 = new JSONObject();
            r102.put("type", "refresh");
            r102.put("data", r101);
            r102.put("log", LiveInteractiveAnnieXHelper.a(this.f137063a));
            return r102;
        }
    }

    public static final class u<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o5 f137065b;

        public u(LiveInteractiveAnnieXHelper r100, o5 r101) {
            this.f137064a = r100;
            this.f137065b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            o82.h.c("H5_roomStatusChange" + r101);
            o82.h.a("VSInteractiveMessage", this.f137065b.extra());
            this.f137064a.o("H5_roomStatusChange", r101);
        }
    }

    public static final class v<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f137066a = null;

        static {
            f137066a = new v();
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
        public final /* synthetic */ Runnable f137067a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public w(x r100) {
            this.f137067a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137067a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137067a.run();
        }
    }

    public static final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f137069b;

        public x(LiveInteractiveAnnieXHelper r100, View r101) {
            this.f137068a = r100;
            this.f137069b = r101;
        }

        public final void a() {
            boolean r100 = false;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L5;
            this.f137069b.setVisibility(8);
            this.f137068a.f137027l = 0;
        L14:
            if (this.f137069b.getLayoutParams() == null) goto L33;
            DataCenter r101 = this.f137068a.f137032q;
            if (r101 == null) goto L19;
            r101.put("data_vs_interactive_widget_region", null);
        L19:
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L28;
            LiveInteractiveAnnieXHelper r102 = this.f137068a;
            DataCenter r103 = r102.f137032q;
            if (r103 == null) goto L31;
            IAbsCardWindow r104 = r102.f137025j;
            if (r104 != null) goto L25;
        L27:
            r103.put("data_live_interactive_component_show", Boolean.valueOf(r100));
            goto L31
        L25:
            if (r104.isShowingWindow() != true) goto L27;
            r100 = true;
        L31:
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.f137068a.f137032q);
            return;
        L28:
            DataCenter r105 = this.f137068a.f137032q;
            if (r105 == null) goto L31;
            r105.put("data_live_interactive_component_show", Boolean.FALSE);
            goto L31
        L33:
            return;
        L5:
            IAbsCardWindow r106 = this.f137068a.f137025j;
            if (r106 == null) goto L14;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L11;
            r106 = null;
        L11:
            if (r106 == null) goto L14;
            r106.dismissWindow();
            this.f137068a.f137027l = 0;
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper f137070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f137071b;

        public y(LiveInteractiveAnnieXHelper r100, View r101) {
            this.f137070a = r100;
            this.f137071b = r101;
        }

        public final void a() {
            int[] r100 = new int[2];
            this.f137071b.getLocationOnScreen(r100);
            DataCenter r101 = this.f137070a.f137032q;
            int r102 = r100[0];
            r101.put("data_vs_interactive_widget_region", new RectF(r102, r100[1], r102 + this.f137071b.getLayoutParams().width, r100[1] + this.f137071b.getLayoutParams().height));
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
        public final /* synthetic */ View f137072a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public z(View r100) {
            this.f137072a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim cancel, view=" + this.f137072a.hashCode());
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f137072a.setAlpha(1);
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim finish, view=" + this.f137072a.hashCode());
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
        DataCenter r100 = this.f137032q;
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
        return this.f137034s.u9();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final String getLogTag() {
        return this.f137034s.getTag();
    }

    public com.bytedance.android.livesdk.interactivity.interactive.c h() {
        vr1.u r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137032q, null, 2);
        if (r100 == null) goto L5;
        ViewModel r101 = r100.c();
    L7:
        if ((r101 instanceof EpisodeInteractiveContext) == true) goto L9;
        r101 = null;
    L9:
        EpisodeInteractiveContext r102 = (EpisodeInteractiveContext) r101;
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.interactive.c> r103 = r102.getLiveInteractiveAnnieXInfo();
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
        DataCenter r100 = this.f137032q;
        if (r100 == null) goto L7;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r100);
        if (r101 == null) goto L7;
        return r101.getRoomId();
    L7:
        return 0;
    }

    public final void release() {
        o82.h.b("[" + hashCode() + "]release hybrid component");
        View r100 = this.f137023h;
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L9;
        r101.removeAllViews();
    L9:
        if (h() != null) goto L12;
        o82.h.b("[" + hashCode() + "]release hybridCard also");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().s(this.f137019d);
        this.f137018c = null;
        this.f137019d = null;
        return;
    }

    public Map<String, String> g() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView, com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public Context getContext() {
        return this.f137033r;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final DataCenter getDataCenter() {
        return this.f137032q;
    }

    public static final JSONObject a(LiveInteractiveAnnieXHelper r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        if (r100.f137032q == null) goto L31;
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
        IRoom r107 = (IRoom) r100.f137032q.get("data_room", null);
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
        if (this.f137034s.isVisible() == false) goto L12;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137018c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L15;
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(k.f137052a).map(new l(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new m(this, r100), n.f137056a);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void Nj(long r100) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new b(this, r100)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new c(this), d.f137038a);
    }

    public final String b(String r100) {
        Uri r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(UriProtector.parse(r100), this.f137032q);
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
        if (this.f137031p == false) goto L23;
        String r107 = "0";
    L24:
        r105.appendQueryParameter("is_hor", r107);
        goto L26
    L23:
        r107 = "1";
    L26:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137032q).isPaidLive() == false) goto L33;
        if (r105 == null) goto L29;
        r105.appendQueryParameter("is_paidlive", "1");
    L29:
        if (r105 == null) goto L31;
        r105.appendQueryParameter("ticket_session_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.b.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137032q).J0(), this.f137032q)));
    L31:
        if (r105 == null) goto L33;
        r105.appendQueryParameter(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f137032q).J0().q(this.f137032q));
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
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new e(this, r100)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new f(this, r100), g.f137043a);
    }

    public final void l(IBannerInfo r100) {
        o82.h.b("[" + hashCode() + "]on banner data");
        this.f137034s.ol();
        if (this.f137034s.isVisible() == false) goto L41;
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
        if (Intrinsics.areEqual(this.f137016a.getValue(), Boolean.TRUE) == false) goto L35;
        k(r100, r105, this.f137023h);
        return;
    L35:
        o82.h.b("[" + hashCode() + "]onBannerData contentView hasn't init, wait");
        NextLiveData<Boolean> r109 = this.f137016a;
        Context r110 = this.f137033r;
        if (r110 == null) goto L40;
        r109.observe((FragmentActivity) r110, new com.bytedance.android.livesdk.interactivity.interactive.f(this, r100, r105));
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
        if (this.f137018c == null) goto L9;
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
        View r101 = this.f137023h;
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
        if (this.f137017b != 1) goto L38;
        EpisodeInteractiveDialog r103 = this.f137024i;
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
        if (this.f137032q != null) goto L5;
        return;
    L5:
        if (this.f137023h != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L10;
    L19:
        View r101 = this.f137023h;
        if (r101 != null) goto L22;
        return;
    L22:
        boolean r102 = false;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L25;
        r101.setVisibility(0);
    L33:
        WebView r103 = this.f137018c;
        if (r103 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r103);
    L36:
        this.f137027l = 1;
        if (this.f137031p == true) goto L40;
        r101.post(new y(this, r101));
    L40:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L49;
        DataCenter r104 = this.f137032q;
        if (r104 == null) goto L52;
        IAbsCardWindow r105 = this.f137025j;
        if (r105 != null) goto L46;
    L48:
        r104.put("data_live_interactive_component_show", Boolean.valueOf(r102));
        goto L52
    L46:
        if (r105.isShowingWindow() != true) goto L48;
        r102 = true;
    L52:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.f137032q);
        if (r100 == false) goto L59;
        ViewPropertyAnimator r106 = r101.animate().alpha(1);
        if (this.f137031p == false) goto L57;
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
        DataCenter r108 = this.f137032q;
        if (r108 == null) goto L52;
        r108.put("data_live_interactive_component_show", Boolean.TRUE);
        goto L52
    L25:
        IAbsCardWindow r109 = this.f137025j;
        if (r109 == null) goto L33;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L31;
        r109 = null;
    L31:
        if (r109 == null) goto L33;
        r109.showWindow();
        goto L33
    L10:
        if (this.f137017b != 1) goto L19;
        EpisodeInteractiveDialog r110 = this.f137024i;
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

    public void t(com.bytedance.android.livesdk.interactivity.interactive.c r100) {
        Intrinsics.checkNotNullParameter(r100, "interactiveInfo");
        ViewModel r101 = null;
        vr1.u r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137032q, null, 2);
        if (r102 == null) goto L5;
        ViewModel r103 = r102.c();
    L7:
        if ((r103 instanceof EpisodeInteractiveContext) == false) goto L10;
        r101 = r103;
    L10:
        EpisodeInteractiveContext r104 = (EpisodeInteractiveContext) r101;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.interactive.c> r105 = r104.getLiveInteractiveAnnieXInfo();
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
        if (this.f137034s.isVisible() == false) goto L24;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137018c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L27;
        DataCenter r101 = this.f137032q;
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
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(s.f137062a).map(new t(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new u(this, r100), v.f137066a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void wz(ku2.b r100) {
        if (this.f137034s.isVisible() == false) goto L24;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f137018c != null) goto L8;
        return;
    L8:
        if (r100.extra() == null) goto L27;
        DataCenter r101 = this.f137032q;
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
        ((SingleSubscribeProxy) Single.just(r100.extra()).observeOn(Schedulers.io()).map(o.f137057a).map(new p(this)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new q(this, r100), r.f137061a);
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
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().x(this.f137019d, r100, r101);
    }

    public final void k(final IBannerInfo r210, final boolean r211, View r212) {
        o82.h.b("start initHybridComponentForAnnie[" + hashCode() + "], contentView:" + r212 + ",bannerInfo:" + r210);
        Jsb2MethodFinder r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().A();
        this.f137020e = r100;
        if (r100 != null) goto L5;
        o82.h.b("[" + hashCode() + "]register interactive jsb failed");
    L8:
        com.bytedance.android.livesdk.interactivity.interactive.c r101 = h();
        View r110 = null;
        if (r101 != null) goto L11;
    L36:
        Context r111 = this.f137033r;
        if (r111 == null) goto L60;
        final o82.g r112 = new o82.g(!r211);
        String r102 = "";
        if (r211 == false) goto L52;
        VSBannerInfo r103 = (VSBannerInfo) r210.castToOrNull(VSBannerInfo.class);
        if (r103 == null) goto L44;
        String r104 = r103.getLynxUrl();
        if (r104 == null) goto L44;
    L45:
        Uri.Builder r105 = x6.a.d(b(r104)).buildUpon();
        VSBannerInfo r106 = (VSBannerInfo) r210.castToOrNull(VSBannerInfo.class);
        if (r106 == null) goto L51;
        String r107 = r106.getH5Url();
        if (r107 == null) goto L51;
        r102 = r107;
    L51:
        Uri r108 = r105.appendQueryParameter("fallback_url", b(r102)).build();
    L59:
        final Uri r109 = r108;
        o82.h.b("[" + hashCode() + "]load url: " + r109);
        vr1.j r113 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i();
        Object r114 = this.f137020e;
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put("key1", "value1");
        Unit r116 = Unit.INSTANCE;
        this.f137019d = r113.c(r111, r109, r114, r115, new LiveInteractiveAnnieXHelper$obtainHybridComponentForAnnie$$inlined$let$lambda$1(r112, r109, this, r211, r210), new LiveInteractiveAnnieXHelper$obtainHybridComponentForAnnie$$inlined$let$lambda$2(r112, this, r211, r210));
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: obtain instance " + this.f137018c);
        SSWebView r117 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().d(this.f137019d);
    L61:
        if (r117 == null) goto L99;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().i(this.f137019d, this.f137020e);
        this.f137018c = r117;
        r117.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r117.getParent() == null) goto L70;
        o82.h.b("initHybridComponentForAnnie[" + hashCode() + "]: HybridCard has parentView which need to be removed");
        ViewParent r118 = r117.getParent();
        if ((r118 instanceof ViewGroup) == true) goto L67;
        r118 = null;
    L67:
        ViewGroup r119 = (ViewGroup) r118;
        if (r119 == null) goto L70;
        r119.removeView(r117);
    L70:
        boolean r120 = r212 instanceof ViewGroup;
        if (r120 == true) goto L73;
        View r121 = null;
    L74:
        ViewGroup r122 = (ViewGroup) r121;
        if (r122 == null) goto L77;
        r122.addView(r117, 0);
    L77:
        StringBuilder r123 = new StringBuilder("initHybridComponentForAnnie[");
        r123.append(hashCode());
        r123.append("], after add view, contentView now childCount:");
        if (r120 == true) goto L80;
        View r124 = null;
    L81:
        ViewGroup r125 = (ViewGroup) r124;
        if (r125 == null) goto L84;
        Integer r126 = Integer.valueOf(r125.getChildCount());
    L85:
        r123.append(r126);
        o82.h.b(r123.toString());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L99;
        View r127 = new View(this.f137033r);
        r127.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if ((r212 instanceof FrameLayout) == false) goto L91;
        r110 = r212;
    L91:
        FrameLayout r128 = (FrameLayout) r110;
        if (r128 == null) goto L94;
        r128.addView(r127);
    L94:
        if (r212 == null) goto L96;
        r212.setFocusable(true);
    L96:
        if (r212 == null) goto L98;
        r212.setFocusableInTouchMode(true);
    L98:
        r127.setBackground(new ColorDrawable(0));
        r3.a(r212, "活动入口");
        goto L99
    L84:
        r126 = null;
        goto L85
    L80:
        r124 = r212;
        goto L81
    L73:
        r121 = r212;
    L99:
        b20("init", 0, 1.0f, new JSONObject());
        return;
    L44:
        r104 = "";
        goto L45
    L52:
        VSBannerInfo r129 = (VSBannerInfo) r210.castToOrNull(VSBannerInfo.class);
        if (r129 == null) goto L58;
        String r130 = r129.getH5Url();
        if (r130 == null) goto L58;
        r102 = r130;
    L58:
        r108 = x6.a.b(b(r102));
        goto L59
    L60:
        String r131 = "obtainHybridComponentForAnnie[" + hashCode() + "]: return null";
        RuntimeException r132 = new RuntimeException("obtainHybridComponentForAnnie null");
        Intrinsics.checkNotNullParameter(r131, "msg");
        Intrinsics.checkNotNullParameter(r132, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        ALogger.e("LiveInteractive", r131, r132);
        r117 = null;
        goto L61
    L11:
        if (Intrinsics.areEqual(r101.f137164a, r210) == false) goto L36;
        Object r133 = r101.f137166c;
        if (r133 == null) goto L34;
        boolean r134 = r101.f137165b;
        vr1.u r135 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137032q, null, 2);
        if (r135 != null) goto L17;
    L18:
        vr1.u r136 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f137032q, null, 2);
        if (r136 == null) goto L21;
        boolean r137 = r136.isPortraitInteraction();
    L22:
        r101.f137165b = r137;
        StringBuilder r138 = new StringBuilder("[");
        r138.append(hashCode());
        r138.append("]roomHorizontalChange: is_horizontal: ");
        DataCenter r139 = this.f137032q;
        if (r139 == null) goto L25;
        Boolean r140 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r139, true));
    L26:
        r138.append(r140);
        o82.h.b(r138.toString());
        vr1.j r141 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i();
        JSONObject r142 = new JSONObject();
        DataCenter r143 = this.f137032q;
        if (r143 != null) goto L29;
    L31:
        int r144 = 1;
    L32:
        r142.put("is_horizontal", r144);
        Unit r145 = Unit.INSTANCE;
        r141.x(r133, "roomHorizontalChange", r142);
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: reuse hybrid card, sendRoomHorizontalChangeJSEvent");
    L33:
        Unit r146 = Unit.INSTANCE;
    L35:
        this.f137019d = r133;
        r117 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().d(this.f137019d);
        goto L61
    L29:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r143, true) != true) goto L31;
        r144 = 0;
        goto L32
    L25:
        r140 = null;
        goto L26
    L21:
        r137 = false;
        goto L22
    L17:
        if (r134 == r135.isPortraitInteraction()) goto L33;
    L34:
        r133 = null;
        goto L35
    L5:
        o82.h.b("[" + hashCode() + "]register interactive jsb");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.f137020e, "interactiveBannerShow", new com.bytedance.android.livesdk.interactivity.interactive.g(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.f137020e, "interactiveSetStorage", new com.bytedance.android.livesdk.interactivity.interactive.h(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.f137020e, "interactiveGetStorage", new com.bytedance.android.livesdk.interactivity.interactive.i(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.f137020e, "getSeiInfo", new com.bytedance.android.livesdk.interactivity.interactive.j(this));
        EpisodeInteractiveDialog r147 = this.f137024i;
        if (r147 == null) goto L8;
        r147.setOnDismissListener(new com.bytedance.android.livesdk.interactivity.interactive.k(this));
        goto L8
    }

    public LiveInteractiveAnnieXHelper(boolean r100, DataCenter r101, Context r102, com.bytedance.android.livesdk.interactivity.interactive.b r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f137031p = r100;
        this.f137032q = r101;
        this.f137033r = r102;
        this.f137034s = r103;
        this.f137016a = new NextLiveData();
        this.f137026k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void b20(String r100, long r101, float r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r111, "extra");
        ((SingleSubscribeProxy) Single.just(r111).observeOn(Schedulers.io()).map(new h(this, r100, r101, r110)).observeOn(AndroidSchedulers.mainThread()).as(this.f137034s.s7())).subscribe(new i(this, r100, r101), j.f137051a);
    }
}
