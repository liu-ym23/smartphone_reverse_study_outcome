package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.wr;
import com.bytedance.android.livesdk.utils.q6;
import com.bytedance.android.livesdk.w8;
import com.bytedance.android.livesdk.z8;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.LiveMultiTabRoomViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/widget/GuidePageController;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCleared", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuidePageController implements LifecycleObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f160899d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f160900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h70.b f160901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveGuidePageViewModel f160902c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.GuidePageController$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/clearscreen/m;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/clearscreen/m;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.clearscreen.m, Unit> {
        public AnonymousClass1(GuidePageController r100) {
            super(1, r100, GuidePageController.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/clearscreen/ShowClearGuideEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.bytedance.android.livesdk.clearscreen.m r110) {
            Intrinsics.checkNotNullParameter(r110, "p1");
            GuidePageController r100 = (GuidePageController) this.receiver;
            int r101 = GuidePageController.f160899d;
            r100.getClass();
            ALogger.d("LiveGuidePage", "receive event ShowClearGuideEvent");
            h70.b r102 = r100.f160901b;
            if (r102 == null) goto L5;
            Context r103 = r102.getContext();
        L6:
            SharedPrefHelper r104 = SharedPrefHelper.b(r103);
            RoomContext.a r105 = RoomContext.Companion;
            if (RoomContext.a.c(r105, null, 0, 3) == null) goto L11;
            RoomContext r106 = RoomContext.a.c(r105, null, 0, 3);
            Intrinsics.checkNotNull(r106);
            if (r106.isCleanMode().getValue().booleanValue() == false) goto L11;
            return;
        L11:
            int r107 = b0.f161424a[r110.f119467a.ordinal()];
            boolean r108 = false;
            if (r107 != 1) goto L14;
            com.bytedance.android.livesdk.sharedpref.e<Map<String, Long>> r109 = a.f160903a;
            if (ClearScreenHelper.k().c() == true) goto L52;
            Long r111 = a.f160903a.getValue().get(a.a());
            if (r111 == null) goto L37;
            long r112 = r111.longValue();
        L39:
            if (r112 < ClearScreenHelper.j().g()) goto L41;
            boolean r113 = true;
        L42:
            Long r114 = a.f160904b.getValue();
            if (r114 != null) goto L45;
        L48:
            boolean r115 = true;
        L49:
            if (r113 == true) goto L52;
            if (r115 == true) goto L52;
            r108 = true;
            goto L52
        L45:
            if (q6.a(r114.longValue()) != true) goto L48;
            r115 = false;
            goto L49
        L41:
            r113 = false;
            goto L42
        L37:
            r112 = 0;
        L52:
            if (r108 == false) goto L54;
            ALogger.i("LiveGuidePage", "点击清屏引导无法展示，正处于频控中");
            return;
        L54:
            z8 r116 = new z8();
            r116.f162566b = true;
            r116.f162565a = "tap_check_mode.zip";
            w8 r117 = new w8(q.f161940a, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_single_tap_enter_clear_screen_v2));
            r117.f160661e = 10L;
            r117.f160659c = r116;
            r117.f160657a = "live.pref.PREF_SINGLE_TAP_CLEARSCREEN_ENTRANCE_GUIDE" + a.a();
            r117.f160658b = 1;
            com.bytedance.android.livesdk.sharedpref.e<Map<String, Long>> r118 = a.f160903a;
            Map<String, Long> r119 = r118.getValue();
            String r120 = a.a();
            Long r121 = r118.getValue().get(a.a());
            if (r121 == null) goto L57;
            long r122 = r121.longValue();
        L58:
            r119.put(r120, Long.valueOf(r122 + 1));
            com.bytedance.android.livesdk.sharedpref.e<Long> r123 = a.f160904b;
            Long r124 = Long.valueOf(System.currentTimeMillis());
            r123.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r123, r124);
            r100.a(r117);
            return;
        L57:
            r122 = 0;
            goto L58
        L14:
            if (r107 == 2) goto L28;
            if (r107 == 3) goto L18;
            return;
        L18:
            if (ClearScreenHelper.a() == true) goto L66;
            String r125 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_clearscreen_swipe);
            Ref.ObjectRef r126 = new Ref.ObjectRef();
            r126.element = "live.pref.PREF_CLEARSCREEN_ENTRANCE_GUIDE";
            Ref.BooleanRef r127 = new Ref.BooleanRef();
            r127.element = false;
            if (TextUtils.equals(r110.f119468b, "3") == false) goto L24;
            r125 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_clearscreen_swipe_low_battery);
            r126.element = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_POWER_GUIDE";
            r127.element = true;
        L26:
            d0 r128 = new d0(r100, r104, r126, r127, r110);
            z r129 = new z(q.f161940a, r125);
            z8 r130 = new z8();
            r130.f162566b = true;
            r130.f162565a = "swipe_right.zip";
            r129.f162265a = r130;
            r100.f160902c.insertGuideInfo(r129, r128);
            return;
        L24:
            if (TextUtils.equals(r110.f119468b, "4") == false) goto L26;
            r125 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_clearscreen_swipe_stall);
            r126.element = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_STALL_GUIDE";
            r127.element = true;
            goto L26
        L66:
            return;
        L28:
            if (c.a() == true) goto L30;
            ALogger.i("LiveGuidePage", "进房点击清屏引导无法展示");
            return;
        L30:
            z8 r131 = new z8();
            r131.f162566b = true;
            r131.f162565a = "tap_check_mode.zip";
            w8 r132 = new w8(q.f161940a, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_single_tap_enter_clear_screen_v2));
            r132.f160661e = 10L;
            r132.f160659c = r131;
            com.bytedance.android.livesdk.sharedpref.e<String> r133 = c.f160905a;
            List r134 = CollectionsKt.toMutableList(c.b());
            ListProtector.add(r134, 0, Long.valueOf(System.currentTimeMillis()));
            Unit r135 = Unit.INSTANCE;
            String r136 = CollectionsKt.joinToString$default(r134, ",", null, null, 0, null, null, 62, null);
            r133.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r133, r136);
            r100.a(r132);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.clearscreen.m r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.GuidePageController$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/w8;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/w8;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<w8, Unit> {
        public AnonymousClass2(GuidePageController r100) {
            super(1, r100, GuidePageController.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/LiveShowGuideEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(w8 r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            GuidePageController r101 = (GuidePageController) this.receiver;
            int r102 = GuidePageController.f160899d;
            r101.a(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(w8 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, Long>> f160903a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final com.bytedance.android.livesdk.sharedpref.e<Long> f160904b = null;

        static {
            f160903a = new com.bytedance.android.livesdk.sharedpref.e("key_clear_screen_tips_users", new LinkedHashMap());
            f160904b = new com.bytedance.android.livesdk.sharedpref.e("key_clear_screen_tips_last_time", 0L);
        }

        public static String a() {
            return ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.bytedance.android.livesdk.sharedpref.e<String> f160905a = null;

        static {
            f160905a = new com.bytedance.android.livesdk.sharedpref.e("key_room_enter_clear_screen_guide_show_counts", "");
        }

        public static List b() {
            List r100 = StringsKt.split$default(f160905a.getValue(), new String[]{","}, false, 0, 6, null);
            ArrayList r101 = new ArrayList();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            Object r103 = r102.next();
            if (((String) r103).length() <= 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L4;
            r101.add(r103);
            goto L4
        L8:
            r104 = false;
            goto L9
        L11:
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r106 = r101.iterator();
        L13:
            if (r106.hasNext() == false) goto L15;
            r105.add(Long.valueOf(CastLongProtector.parseLong((String) r106.next())));
            goto L13
        L15:
            return r105;
        }

        public static boolean a() {
            if (ClearScreenHelper.k().c() == false) goto L5;
            return true;
        L5:
            ArrayList r100 = (ArrayList) b();
            if (r100.size() >= ClearScreenHelper.j().n()) goto L8;
            boolean r101 = true;
        L9:
            Iterator r102 = r100.iterator();
            int r103 = 0;
        L11:
            if (r102.hasNext() == false) goto L16;
            if ((!q6.a(((Number) r102.next()).longValue())) == true) goto L17;
            r103 = r103 + 1;
        L17:
            if (r103 == (-1)) goto L19;
        L21:
            int r104 = r103 + 1;
        L23:
            if (r104 >= ClearScreenHelper.j().m()) goto L25;
            boolean r105 = true;
        L26:
            ALogger.i("EnterRoomClickClearGuideInterval", "isLessMaxShowCount=" + r101 + ", todayCanShow=" + r105);
            if (r101 == false) goto L30;
            if (r105 == false) goto L30;
            return true;
        L30:
            return false;
        L25:
            r105 = false;
            goto L26
        L19:
            if ((!r100.isEmpty()) == false) goto L21;
            r104 = r100.size();
            goto L23
        L16:
            r103 = -1;
            goto L17
        L8:
            r101 = false;
            goto L9
        }
    }

    public static final class d implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuidePageController f160906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w8 f160907b;

        @Override // com.bytedance.android.livesdk.widget.g0
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.widget.g0
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
        }

        @Override // com.bytedance.android.livesdk.widget.g0
        public final void d() {
        }

        @Override // com.bytedance.android.livesdk.widget.g0
        public final void c() {
            w8 r100 = this.f160907b;
            String r101 = r100.f160657a;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
        L13:
            if (r102 == false) goto L19;
            h70.b r104 = this.f160906a.f160901b;
            if (r104 == null) goto L17;
            Context r105 = r104.getContext();
        L18:
            SharedPrefHelper r106 = SharedPrefHelper.b(r105);
            w8 r107 = this.f160907b;
            r106.l(r107.f160657a, r107.f160658b);
            r106.a();
            goto L19
        L17:
            r105 = null;
        L19:
            Long r108 = this.f160907b.f160661e;
            if (r108 == null) goto L25;
            Intrinsics.checkNotNull(r108);
            if (r108.longValue() <= 0) goto L26;
            LiveGuidePageViewModel r109 = this.f160906a.f160902c;
            Long r110 = this.f160907b.f160661e;
            Intrinsics.checkNotNull(r110);
            r109.countdown(r110.longValue());
            return;
        L26:
            return;
        L25:
            return;
        L11:
            if (r100.f160658b == null) goto L13;
            r102 = true;
            goto L13
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r103 = false;
            goto L9
        }

        public d(GuidePageController r100, w8 r101) {
            this.f160906a = r100;
            this.f160907b = r101;
        }
    }

    public final class e implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f160908a;

        public e(Function1 r100) {
            this.f160908a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f160908a.invoke(r100);
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onCleared() {
        ALogger.d("LiveGuidePage", "controller onCleared");
        this.f160900a.dispose();
    }

    public final void a(w8 r100) {
        ALogger.d("LiveGuidePage", "receive event LiveShowGuideEvent");
        d r101 = new d(this, r100);
        z r102 = new z(r100.f160663g, r100.f160664h);
        r102.f162266b = r100.f160660d;
        r102.f162265a = r100.f160659c;
        r102.f162267c = r100.f160662f;
        this.f160902c.insertGuideInfo(r102, r101);
    }

    public final <T> void b(Class<T> r100, Function1<? super T, Unit> r101) {
        RxUtilKt.c(xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r101)), this.f160900a);
    }

    public GuidePageController(h70.b r100, LiveGuidePageTetris r101, LiveGuidePageViewModel r102) {
        Intrinsics.checkNotNullParameter(r101, "tetris");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f160901b = r100;
        this.f160902c = r102;
        Boolean r103 = wr.f121547a.getValue();
        this.f160900a = new CompositeDisposable();
        if (r103.booleanValue() == false) goto L12;
        b(com.bytedance.android.livesdk.clearscreen.m.class, new AnonymousClass1(this));
        b(w8.class, new AnonymousClass2(this));
        if (r100 == null) goto L7;
        Context r104 = r100.getContext();
    L8:
        FragmentActivity r105 = (FragmentActivity) r104;
        if (r105 == null) goto L13;
        ((LiveMultiTabRoomViewModel) ViewModelProviders.of(r105).get(LiveMultiTabRoomViewModel.class)).getShowGuide().observe(r101, new c0(this));
        return;
    L13:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
