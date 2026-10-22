package com.bytedance.android.livesdk.floatview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.LiveMultiTabHandler;
import com.bytedance.android.livesdk.config.bx;
import com.bytedance.android.livesdk.config.gu0;
import com.bytedance.android.livesdk.config.o81;
import com.bytedance.android.livesdk.config.pl;
import com.bytedance.android.livesdk.config.sl;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.CommerceFragmentDispatcher;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.LiveBizWindowAbilityCenter;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.h1;

/* JADX INFO: loaded from: classes8.dex */
public final class NewVideoInnerFloatManager implements IVideoFloatManager {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final q f125055p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f125056q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f125057r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o81 f125058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoFloatWindowView f125059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoFloatWindowView f125060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<IVideoFloatManager.VideoFloatManagerListener> f125061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f125062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f125063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<InnerContextEntity> f125064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f125065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f125066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InnerContextEntity.InnerFloatExtra f125067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f125068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f125069l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveBizWindowAbilityEnv f125070m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveBizWindowAbilityCenter f125071n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f125072o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/NewVideoInnerFloatManager$ActionType;", "", "SHOW", "CLICK", "MUTECLICK", "CLOSE", "RETURNCLICK", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType CLOSE = null;
        public static final ActionType MUTECLICK = null;
        public static final ActionType RETURNCLICK = null;
        public static final ActionType SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f125073a = null;

        static {
            ActionType r100 = new ActionType("SHOW", 0);
            SHOW = r100;
            ActionType r101 = new ActionType("CLICK", 1);
            CLICK = r101;
            ActionType r102 = new ActionType("MUTECLICK", 2);
            MUTECLICK = r102;
            ActionType r103 = new ActionType("CLOSE", 3);
            CLOSE = r103;
            ActionType r104 = new ActionType("RETURNCLICK", 4);
            RETURNCLICK = r104;
            f125073a = new ActionType[]{r100, r101, r102, r103, r104};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) f125073a.clone();
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends h {
        @Override // nz.s
        public final void b() {
            q r100 = NewVideoInnerFloatManager.f125055p;
            VideoFloatWindowView r101 = b.a().f125059b;
            if (r101 != null) goto L5;
        L6:
            VideoFloatWindowView r102 = b.a().f125059b;
            if (r102 == null) goto L18;
            LivePlayerView r103 = r102.getMLivePlayerView$livesdk_saasRelease();
            if (r103 == null) goto L19;
            ILivePlayerClient r104 = r103.getClient();
            if (r104 != null) goto L13;
            return;
        L13:
            if (r104.isPlaying() == true) goto L21;
        L14:
            VideoFloatWindowView r105 = b.a().f125059b;
            if (r105 == null) goto L22;
            r105.g();
            return;
        L22:
            return;
        L21:
            return;
        L19:
            return;
        L18:
            return;
        L5:
            if (r101.f125102r == true) goto L14;
            goto L6
        }

        public a() {
        }

        @Override // nz.s
        public final void a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = NewVideoInnerFloatManager.f125055p;
            b.a().n(new InnerContextEntity(r100));
        }

        @Override // nz.s
        public final void c(Context r100) {
            ALogger.i("NewVideoInnerFloatManager", "onBackToDesktop");
            Lazy r101 = LiveMultiTabHandler.f114363a;
            IHostBusiness r102 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
            if (r102 == null) goto L7;
            ILiveMultiTabDepend r103 = r102.getLiveMultiTabDepend();
            if (r103 == null) goto L7;
            boolean r104 = r103.floatWindowPauseWhenBackground();
        L8:
            if (r104 == false) goto L16;
            q r105 = NewVideoInnerFloatManager.f125055p;
            if (b.a().l() == false) goto L16;
            VideoFloatWindowView r106 = b.a().f125059b;
            if (r106 == null) goto L14;
            r106.e();
        L14:
            ALogger.i("NewVideoInnerFloatManager", "moreLive pausePullStream");
            return;
        L16:
            if (NetworkUtils.isNetworkAvailable(r100) == true) goto L18;
            return;
        L18:
            if (NetworkUtils.isWifi(r100) == true) goto L26;
            q r107 = NewVideoInnerFloatManager.f125055p;
            VideoFloatWindowView r108 = b.a().f125059b;
            if (r108 == null) goto L22;
            r108.e();
        L22:
            ALogger.i("NewVideoInnerFloatManager", "4g pausePullStream");
            return;
        L26:
            return;
        L7:
            r104 = false;
            goto L8
        }

        @Override // nz.s
        public final void onPause(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = NewVideoInnerFloatManager.f125055p;
            b.a().m("onContextPause = " + r100);
            VideoFloatWindowView r102 = b.a().f125059b;
            Context r103 = null;
            if (r102 == null) goto L5;
            Object r104 = r102.getParent();
        L7:
            if ((r104 instanceof View) == true) goto L9;
            r104 = null;
        L9:
            View r105 = (View) r104;
            if (r105 == null) goto L13;
            r103 = r105.getContext();
        L13:
            if (Intrinsics.areEqual(s2.a(r103), r100) == false) goto L18;
            VideoFloatWindowView r106 = b.a().f125059b;
            if (r106 == null) goto L19;
            r106.onPause();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r104 = null;
            goto L7
        }

        @Override // nz.s
        public final void onResume(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = NewVideoInnerFloatManager.f125055p;
            b.a().m("onContextResume = " + r100);
            VideoFloatWindowView r102 = b.a().f125059b;
            Context r103 = null;
            if (r102 == null) goto L5;
            Object r104 = r102.getParent();
        L7:
            if ((r104 instanceof View) == true) goto L9;
            r104 = null;
        L9:
            View r105 = (View) r104;
            if (r105 == null) goto L13;
            r103 = r105.getContext();
        L13:
            if (Intrinsics.areEqual(s2.a(r103), r100) == false) goto L18;
            VideoFloatWindowView r106 = b.a().f125059b;
            if (r106 == null) goto L19;
            r106.onResume();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r104 = null;
            goto L7
        }

        @Override // nz.s
        public final void onStart(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = NewVideoInnerFloatManager.f125055p;
            NewVideoInnerFloatManager r102 = b.a();
            InnerContextEntity r103 = ox1.d.a(r100, b.a().f125067j);
            boolean r104 = r100 instanceof LifecycleOwner;
            Object r105 = r100;
            if (r104 == true) goto L5;
            r105 = null;
        L5:
            r102.o(r103, (LifecycleOwner) r105);
        }

        @Override // nz.s
        public final void onStop(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = NewVideoInnerFloatManager.f125055p;
            b.a().p(new InnerContextEntity(r100));
        }
    }

    public static final class b {
        public static NewVideoInnerFloatManager a() {
            return (NewVideoInnerFloatManager) NewVideoInnerFloatManager.f125057r.getValue();
        }
    }

    public static void g() {
        com.bytedance.android.livesdk.floatview.inner.b.b("start commerce window", 0, true);
    }

    static {
        f125055p = new q(jc1.a.b(), new a());
        f125056q = LazyKt.lazy(NewVideoInnerFloatManager$Companion$fragmentLifecycleListener$2.INSTANCE);
        f125057r = LazyKt.lazy(NewVideoInnerFloatManager$Companion$instance$2.INSTANCE);
    }

    public static RelativeLayout.LayoutParams h() {
        RelativeLayout.LayoutParams r100 = new RelativeLayout.LayoutParams(1, 1);
        r100.addRule(12);
        r100.addRule(11);
        r100.bottomMargin = (int) t6.a(jc1.a.b(), 86.0f);
        return r100;
    }

    public final void d() {
        if (bx.f119905a.getValue().a() == false) goto L13;
        VideoFloatWindowView r100 = this.f125059b;
        if (r100 == null) goto L11;
        InnerContextEntity r101 = r100.getContainContext();
        if (r101 == null) goto L9;
        FrameLayout r102 = r101.getRootView();
    L10:
        f(r102);
        goto L11
    L9:
        r102 = null;
    L11:
        e();
        this.f125063f = 0;
        this.f125059b = null;
        return;
    }

    public final void e() {
        ((ArrayList) this.f125064g).clear();
        InnerContextEntity.InnerFloatExtra r100 = this.f125067j;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f125065h = 0;
        this.f125063f = 0;
    }

    public final boolean l() {
        InnerContextEntity.InnerFloatExtra r100 = this.f125067j;
        if (r100 == null) goto L7;
        FloatWindowBusinessLine r101 = r100.getBusinessLine();
        if (r101 == null) goto L7;
        String r102 = r101.getValue();
    L9:
        return Intrinsics.areEqual(r102, FloatWindowBusinessLine.MoreAnchor.getValue());
    L7:
        r102 = null;
        goto L9
    }

    public final void q() {
        VideoFloatWindowView r100 = this.f125059b;
        if (r100 == null) goto L32;
        InnerContextEntity r101 = r100.f125096l;
        if (r101 == null) goto L24;
        InnerContextEntity.InnerFloatExtra r102 = r101.getEnterExtra();
        if (r102 == null) goto L24;
        if (r102.getWhetherUnMuteWhenStop() != true) goto L24;
        LivePlayerView r103 = r100.f125093i;
        if (r103 == null) goto L22;
        ILivePlayerClient r104 = r103.getClient();
        if (r104 == null) goto L22;
        if (r104.isMute() != true) goto L22;
        LivePlayerView r105 = r100.f125093i;
        if (r105 == null) goto L24;
        ILivePlayerClient r106 = r105.getClient();
        if (r106 == null) goto L24;
        r106.unmute("VideoFloatWindowView.resumeNormal");
    L22:
        if (Intrinsics.areEqual(r100.f125104t, Boolean.TRUE) == false) goto L24;
        xs2.b.a().post(new h1(48));
    L24:
        InnerContextEntity r107 = r100.f125096l;
        if (r107 == null) goto L31;
        InnerContextEntity.InnerFloatExtra r108 = r107.getEnterExtra();
        if (r108 == null) goto L31;
        if (r108.getForceResumeWhenStop() != true) goto L31;
        xs2.b.a().post(new h1(42));
        return;
    L31:
        xs2.b.a().post(new h1(33));
        return;
    L32:
        InnerContextEntity.InnerFloatExtra r109 = this.f125067j;
        if (r109 != null) goto L35;
    L37:
        xs2.b.a().post(new h1(33));
        return;
    L35:
        if (r109.getForceResumeWhenStop() != true) goto L37;
        xs2.b.a().post(new h1(42));
    }

    public final void r() {
        ALogger.i("NewVideoInnerFloatManager", "stopFloatNow");
        q();
        VideoFloatWindowView r100 = this.f125059b;
        if (r100 == null) goto L14;
        InnerContextEntity r101 = r100.getContainContext();
        if (r101 == null) goto L7;
        FrameLayout r102 = r101.getRootView();
    L8:
        f(r102);
        if (l() == true) goto L14;
        InnerContextEntity r103 = r100.getContainContext();
        if (r103 == null) goto L14;
        List<Integer> r104 = this.f125066i;
        ArrayList r105 = (ArrayList) r104;
        r105.remove(Integer.valueOf(r103.hashCode()));
        ((ArrayList) this.f125064g).remove(r103);
        goto L14
    L7:
        r102 = null;
    L14:
        if (this.f125063f != 2) goto L17;
        this.f125063f = 3;
        return;
    }

    public final void s() {
        ALogger.i("NewVideoInnerFloatManager", "stopShowFloat");
        q();
        VideoFloatWindowView r100 = this.f125059b;
        if (r100 == null) goto L9;
        InnerContextEntity r101 = r100.getContainContext();
        if (r101 == null) goto L7;
        FrameLayout r102 = r101.getRootView();
    L8:
        f(r102);
        goto L9
    L7:
        r102 = null;
    L9:
        e();
        this.f125063f = 0;
        t(this.f125061d, ActionType.CLOSE, false);
        LiveMultiTabFloatWindowStore r103 = LiveMultiTabFloatWindowStore.INSTANCE;
        r103.setTabChange(false);
        r103.setMoreLiveToLiveTab(false);
    }

    public NewVideoInnerFloatManager() {
        if (p.a() == false) goto L8;
        IHostApp r100 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r100 == null) goto L7;
        r100.registerLiveLifeCycleListener(f125055p);
    L7:
        CommerceFragmentDispatcher.INSTANCE.registerListener((IDialogFragmentLifecycle) f125056q.getValue());
    L9:
        this.f125058a = gu0.f120315a.getValue();
        this.f125061d = new ArrayList();
        new HashSet();
        this.f125064g = new ArrayList();
        this.f125066i = new ArrayList();
        this.f125068k = LazyKt.lazy(NewVideoInnerFloatManager$accessList$2.INSTANCE);
        this.f125069l = LazyKt.lazy(NewVideoInnerFloatManager$transCheckWhiteList$2.INSTANCE);
        LiveBizWindowAbilityEnv r101 = new LiveBizWindowAbilityEnv();
        r101.setShowingOnToolbar(NewVideoInnerFloatManager$abilityEnv$1$1.INSTANCE);
        Unit r102 = Unit.INSTANCE;
        this.f125070m = r101;
        this.f125071n = new LiveBizWindowAbilityCenter(r101);
        return;
    L8:
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        goto L9
    }

    public static boolean j() {
        VideoFloatWindowView r100 = b.a().f125059b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f125103s != true) goto L7;
        return true;
    }

    public final boolean i() {
        if (b.a().f125059b == null) goto L7;
        if (this.f125062e == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f125063f == 4) goto L8;
        return false;
    }

    public static final void a(NewVideoInnerFloatManager r100) {
        int r101 = ((ArrayList) r100.f125064g).size();
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L13;
        InnerContextEntity r102 = (InnerContextEntity) ListProtector.get(r100.f125064g, r101);
        if (r102.getType() != 2) goto L12;
        Activity r103 = r102.getActivity();
        if (r103 == null) goto L12;
        if (((ArrayList) r100.f125064g).contains(new InnerContextEntity(r103)) == true) goto L3;
    L12:
        r102.finish();
        goto L3
    }

    public static void c(FloatWindowBusinessLine r100) {
        if (pl.f120989a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        if (r100 != null) goto L11;
        f2.c("debug：请在小窗api入参InnerContextEntity.InnerFloatExtra中补充参数businessLine，如有疑问请联系liusihao.0908", 0);
        return;
    L11:
        return;
    }

    public static boolean k(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        IHostApp r101 = (IHostApp) jc1.k.f(IHostApp.class);
        Object r102 = null;
        if (r101 == null) goto L8;
        List<Class> r103 = r101.getAllLiveActivity();
    L9:
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((Class) r105).isAssignableFrom(r100.getClass()) == false) goto L12;
        r102 = r105;
    L16:
        r102 = (Class) r102;
    L17:
        if (r102 == null) goto L23;
        return true;
    L23:
        return false;
    L8:
        r103 = null;
        goto L9
    }

    public final void f(FrameLayout r100) {
        VideoFloatWindowView r101 = this.f125059b;
        if (r101 == null) goto L17;
        m("detach " + r101.getContainContext());
        this.f125062e = false;
        VideoFloatWindowView r102 = this.f125059b;
        if (r102 == null) goto L7;
        ViewParent r103 = r102.getParent();
    L9:
        if (Intrinsics.areEqual(r100, r103) == false) goto L18;
        r101.stop();
        if (r100 == null) goto L14;
        r100.removeView(this.f125059b);
    L14:
        if (bx.f119905a.getValue().a() == true) goto L19;
        this.f125059b = null;
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager
    public final void layoutParams(RelativeLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        VideoFloatWindowView r101 = this.f125059b;
        if (r101 == null) goto L8;
        FrameLayout r102 = r101.getVideoContainer();
        if (r102 == null) goto L9;
        r100.width = 1;
        r100.height = 1;
        r102.setLayoutParams(r100);
        return;
    L9:
        return;
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        ALogger.i("NewVideoInnerFloatManager", "state = " + this.f125063f + tb2.c.DEFAULT_TEXT + r100);
    }

    public final void n(InnerContextEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        m("onContextDestroy = " + r100);
        if (((ArrayList) this.f125064g).contains(r100) == false) goto L6;
        ((ArrayList) this.f125064g).remove(r100);
    L6:
        if (((ArrayList) this.f125066i).contains(Integer.valueOf(r100.hashCode())) == false) goto L9;
        ((ArrayList) this.f125066i).remove(Integer.valueOf(r100.hashCode()));
    L9:
        if (this.f125065h != r100.hashCode()) goto L12;
        e();
        return;
    }

    public final void p(InnerContextEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        m("onContextStop = " + r100);
        int r101 = this.f125063f;
        if (r101 == 2) goto L6;
        if (r101 == 4) goto L6;
        return;
    L6:
        q r102 = f125055p;
        if (r102.f125265a == true) goto L16;
        if (r101 != 4) goto L16;
        if (((ArrayList) b.a().f125064g).contains(r100) == false) goto L16;
        if (((ArrayList) b.a().f125064g).size() > 1) goto L14;
    L15:
        q();
        this.f125063f = 0;
        b.a().f125062e = false;
        goto L16
    L14:
        if (r100.hashCode() == this.f125065h) goto L15;
    L16:
        VideoFloatWindowView r103 = b.a().f125059b;
        if (r103 == null) goto L37;
        InnerContextEntity r104 = r103.getContainContext();
        if (r104 != null) goto L21;
        return;
    L21:
        if (r104.equals(r100) != true) goto L39;
        StringBuilder r105 = new StringBuilder("equal ");
        VideoFloatWindowView r106 = b.a().f125059b;
        String r107 = null;
        if (r106 == null) goto L25;
        InnerContextEntity r108 = r106.getContainContext();
    L26:
        r105.append(r108);
        r105.append(tb2.c.DEFAULT_TEXT);
        r105.append(r100);
        m(r105.toString());
        if (r102.f125265a == false) goto L29;
        return;
    L29:
        if (((ArrayList) b.a().f125064g).size() != 1) goto L41;
        Activity r109 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
        if (r109 == null) goto L34;
        r107 = r109.getClass().getSimpleName();
    L34:
        if ((!Intrinsics.areEqual(r107, ((IHostApp) jc1.k.n(IHostApp.class)).getTimingCloseActivityName())) == false) goto L42;
        q();
        b.a().f(r100.getRootView());
        b.a().f125062e = false;
        this.f125063f = 0;
        m("onContextDetach and resume " + r100);
        return;
    L42:
        return;
    L41:
        return;
    L25:
        r108 = null;
        goto L26
    L39:
        return;
    }

    public final void b(final InnerContextEntity r110, LifecycleOwner r111) {
        ALogger.i("NewVideoInnerFloatManager", "attachEntity success");
        b.a().f125062e = true;
        InnerContextEntity.InnerFloatExtra r100 = this.f125067j;
        if (r100 == null) goto L6;
        String r101 = r100.getRequestPage();
        if (r101 == null) goto L6;
    L7:
        r110.setRequestPage(r101);
        final NewVideoInnerFloatManager r102 = b.a();
        final FrameLayout r103 = r110.getRootView();
        r102.getClass();
        r102.m("attach " + r110);
        if (r103 == null) goto L150;
        String r104 = null;
        int r105 = 0;
        if (r102.f125059b != null) goto L51;
        VideoFloatWindowView r106 = r102.f125060c;
        if (r106 == null) goto L16;
        Context r107 = r106.getContext();
    L18:
        if ((!Intrinsics.areEqual(r107, r103.getContext())) == false) goto L20;
        r102.f125060c = null;
    L20:
        VideoFloatWindowView r108 = r102.f125060c;
        if (r108 == null) goto L23;
        r102.f125059b = r108;
    L24:
        VideoFloatWindowView r109 = r102.f125059b;
        if (r109 == null) goto L35;
        FrameLayout r112 = r109.getVideoContainer();
        if (r112 == null) goto L35;
        InnerContextEntity.InnerFloatExtra r113 = r102.f125067j;
        if (r113 == null) goto L33;
        RelativeLayout.LayoutParams r114 = r113.getParams();
        if (r114 == null) goto L33;
    L34:
        r112.setLayoutParams(r114);
    L33:
        r114 = h();
    L35:
        VideoFloatWindowView r115 = r102.f125059b;
        if (r115 == null) goto L48;
        DragRelativeLayout r116 = r115.getDragLayoutView();
        if (r116 == null) goto L48;
        InnerContextEntity.InnerFloatExtra r117 = r102.f125067j;
        if (r117 == null) goto L42;
        int r118 = UtilityKotlinExtentionsKt.i(r117.getFloatViewHorizontalMargin());
    L43:
        a1.m(r116, r118);
        InnerContextEntity.InnerFloatExtra r119 = r102.f125067j;
        if (r119 == null) goto L46;
        int r120 = UtilityKotlinExtentionsKt.i(r119.getFloatViewHorizontalMargin());
    L47:
        a1.n(r116, r120);
        goto L48
    L46:
        r120 = 0;
        goto L47
    L42:
        r118 = 0;
    L48:
        VideoFloatWindowView r121 = r102.f125059b;
        if (r121 == null) goto L51;
        r121.setFloatViewListener(new NewVideoInnerFloatManager$setVideoFloatManagerListener$1(r102));
        goto L51
    L23:
        r102.f125059b = new VideoFloatWindowView(r103.getContext(), 1);
        goto L24
    L16:
        r107 = null;
    L51:
        VideoFloatWindowView r122 = r102.f125059b;
        if (r122 == null) goto L54;
        r122.setContainContext(r110);
    L54:
        VideoFloatWindowView r123 = r102.f125059b;
        if (r123 == null) goto L57;
        Room r124 = r123.getCurRoomData();
    L59:
        if (r124 != null) goto L62;
    L79:
        boolean r125 = true;
    L81:
        if (r125 == false) goto L85;
        r102.m("data changed");
        VideoFloatWindowView r126 = r102.f125059b;
        if (r126 == null) goto L85;
        r126.stop();
    L85:
        VideoFloatWindowView r127 = r102.f125059b;
        if (r127 == null) goto L88;
        ViewParent r128 = r127.getParent();
    L89:
        if (r128 == r103) goto L128;
        VideoFloatWindowView r129 = r102.f125059b;
        if (r129 == null) goto L93;
        ViewParent r130 = r129.getParent();
    L95:
        if ((r130 instanceof ViewGroup) == true) goto L97;
        r130 = null;
    L97:
        ViewGroup r131 = (ViewGroup) r130;
        if (r131 == null) goto L100;
        r131.removeView(r102.f125059b);
    L100:
        InnerContextEntity.InnerFloatExtra r132 = r110.getEnterExtra();
        if (r132 != null) goto L103;
    L127:
        r103.addView(r102.f125059b);
        r102.m("change to " + r110);
        goto L128
    L103:
        if (r132.getEnableChangePosition() != true) goto L127;
        VideoFloatWindowView r133 = r102.f125059b;
        if (r133 == null) goto L115;
        FrameLayout r134 = r133.getVideoContainer();
        if (r134 == null) goto L115;
        InnerContextEntity.InnerFloatExtra r135 = r110.getEnterExtra();
        if (r135 == null) goto L113;
        RelativeLayout.LayoutParams r136 = r135.getParams();
        if (r136 == null) goto L113;
    L114:
        r134.setLayoutParams(r136);
    L113:
        r136 = h();
    L115:
        VideoFloatWindowView r137 = r102.f125059b;
        if (r137 == null) goto L127;
        DragRelativeLayout r138 = r137.getDragLayoutView();
        if (r138 == null) goto L127;
        InnerContextEntity.InnerFloatExtra r139 = r102.f125067j;
        if (r139 == null) goto L122;
        int r140 = UtilityKotlinExtentionsKt.i(r139.getFloatViewHorizontalMargin());
    L123:
        a1.m(r138, r140);
        InnerContextEntity.InnerFloatExtra r141 = r102.f125067j;
        if (r141 == null) goto L126;
        r105 = UtilityKotlinExtentionsKt.i(r141.getFloatViewHorizontalMargin());
    L126:
        a1.n(r138, r105);
        goto L127
    L122:
        r140 = 0;
        goto L123
    L93:
        r130 = null;
    L128:
        Function1<Room, Unit> r142 = new NewVideoInnerFloatManager$attach$3(r102, r110, r103);
        Intrinsics.checkNotNullParameter(r142, "action");
        if (r110.getDataSource() != null) goto L137;
        RoomContext r143 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r143 == null) goto L140;
        com.bytedance.live.datacontext.m<Room> r144 = r143.getRoom();
        if (r144 == null) goto L140;
        Room r145 = r144.getValue();
        if (r145 == null) goto L140;
        r142.invoke(r145);
    L140:
        List<String> r146 = p.f125261c;
        VideoFloatWindowView r147 = b.a().f125059b;
        if (r147 == null) goto L146;
        InnerContextEntity r148 = r147.getContainContext();
        if (r148 == null) goto L146;
        r104 = r148.getRequestPage();
    L146:
        if (CollectionsKt.contains(r146, r104) == false) goto L148;
        com.bytedance.android.livesdk.log.u.l().c(am2.r.class).getMap().put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
    L149:
        xs2.b.a().post(new u22.e());
        goto L150
    L148:
        com.bytedance.android.livesdk.log.u.l().c(am2.r.class).getMap().remove("data_type");
        goto L149
    L137:
        InnerContextEntity.FloatWindowDataSource r149 = r110.getDataSource();
        if (r149 == null) goto L140;
        r149.runAfterDataReady(r111, r142);
        goto L140
    L88:
        r128 = null;
        goto L89
    L62:
        if (r110.getDataSource() != null) goto L71;
        RoomContext r150 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r150 == null) goto L68;
        com.bytedance.live.datacontext.m<Room> r151 = r150.getRoom();
        if (r151 == null) goto L68;
        Room r152 = r151.getValue();
    L69:
        r125 = !Intrinsics.areEqual(r152, r124);
    L68:
        r152 = null;
        goto L69
    L71:
        if ((r110.getDataSource() instanceof ox1.b) == false) goto L80;
        long r153 = r124.f162599id;
        InnerContextEntity.FloatWindowDataSource r154 = r110.getDataSource();
        if ((r154 instanceof ox1.b) == true) goto L75;
        r154 = null;
    L75:
        ox1.b r155 = (ox1.b) r154;
        if (r155 == null) goto L79;
        if (r153 != r155.f527070c) goto L79;
    L80:
        r125 = false;
        goto L81
    L57:
        r124 = null;
    L150:
        this.f125063f = 2;
        return;
    L6:
        r101 = "";
        goto L7
    }

    public final void o(InnerContextEntity r110, LifecycleOwner r111) {
        Intrinsics.checkNotNullParameter(r110, "entity");
        m("onContextStart = " + r110);
        if (((ArrayList) this.f125066i).contains(Integer.valueOf(r110.hashCode())) == true) goto L5;
        ((ArrayList) this.f125066i).add(Integer.valueOf(r110.hashCode()));
    L5:
        boolean r100 = false;
        Activity r101 = null;
        if (this.f125065h == r110.hashCode()) goto L8;
    L17:
        WeakReference<Activity> r102 = r110.getActivityRef();
        if (r102 == null) goto L20;
        Activity r103 = r102.get();
    L22:
        if (k(r103) == true) goto L25;
    L55:
        WeakReference<Activity> r104 = r110.getActivityRef();
        if (r104 == null) goto L58;
        Activity r105 = r104.get();
    L60:
        if (k(r105) == true) goto L129;
        IHostApp r106 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r106 == null) goto L65;
        String r107 = r106.getTimingCloseActivityName();
    L66:
        if (r107 == null) goto L83;
        WeakReference<Activity> r108 = r110.getActivityRef();
        if (r108 == null) goto L76;
        Activity r109 = r108.get();
        if (r109 == null) goto L76;
        String r112 = r109.getLocalClassName();
        if (r112 == null) goto L76;
        if (StringsKt.contains$default(r112, r107, false, 2, null) != true) goto L76;
        boolean r113 = true;
    L77:
        if (r113 == true) goto L80;
        r107 = null;
    L80:
        if (r107 == null) goto L83;
    L76:
        r113 = false;
    L83:
        if (sl.f121236a.getValue().booleanValue() == false) goto L123;
        List r114 = (List) this.f125069l.getValue();
        if (r114 == null) goto L102;
        List r115 = r114;
        InnerContextEntity.InnerFloatExtra r116 = r110.getEnterExtra();
        if (r116 == null) goto L89;
        String r117 = r116.getRequestPage();
    L91:
        if (CollectionsKt.contains(r115, r117) != true) goto L102;
        WeakReference<Activity> r118 = r110.getActivityRef();
        if (r118 == null) goto L95;
        Activity r119 = r118.get();
    L96:
        if (r119 == null) goto L98;
        int r120 = r119.hashCode();
    L100:
        if (r120 != this.f125065h) goto L102;
        boolean r121 = true;
    L103:
        if (r121 == true) goto L123;
        WeakReference<Activity> r122 = r110.getActivityRef();
        if (r122 == null) goto L123;
        Activity r123 = r122.get();
        if (r123 == null) goto L123;
        int r124 = l.f125236a;
        Intrinsics.checkNotNullParameter(r123, "activity");
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L116
        int r126 = r123.getWindow().getAttributes().flags;     // Catch: Throwable -> L116
        if ((67108864 & r126) == 0) goto L112;
    L115:
        boolean r127 = true;
    L119:
        if (r127 == false) goto L121;
        r101 = r123;
    L121:
        if (r101 == null) goto L123;
    L112:
        if ((r126 & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) goto L115;
        if (r123.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent}).getBoolean(0, false) == true) goto L115;
    L118:
        r127 = false;
    L116:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L118
    L98:
        r120 = 0;
        goto L100
    L95:
        r119 = null;
        goto L96
    L89:
        r117 = null;
    L102:
        r121 = false;
    L123:
        int r129 = this.f125065h;
        if (r129 == 0) goto L129;
        int r130 = ((ArrayList) this.f125066i).indexOf(Integer.valueOf(r129));
        int r131 = ((ArrayList) this.f125066i).indexOf(Integer.valueOf(r110.hashCode()));
        if (r131 <= 0) goto L130;
        if (r130 > r131) goto L129;
    L130:
        if (r100 == false) goto L133;
        ALogger.i("NewVideoInnerFloatManager", "attachEntity fail: shouldIgnoreStart");
        return;
    L133:
        int r132 = this.f125063f;
        if (r132 == 1) goto L144;
        if (r132 == 2) goto L144;
        if (r132 == 3) goto L139;
        return;
    L139:
        if ((!((ArrayList) this.f125064g).isEmpty()) == false) goto L150;
        List<InnerContextEntity> r133 = this.f125064g;
        if (Intrinsics.areEqual(r110, (InnerContextEntity) ListProtector.get(r133, ((ArrayList) r133).size() - 1)) == false) goto L151;
        List<InnerContextEntity> r134 = this.f125064g;
        b((InnerContextEntity) ListProtector.get(r134, ((ArrayList) r134).size() - 1), r111);
        return;
    L151:
        return;
    L150:
        return;
    L144:
        if (((ArrayList) this.f125064g).contains(r110) == true) goto L146;
        ((ArrayList) this.f125064g).add(r110);
    L146:
        b(r110, r111);
        return;
    L65:
        r107 = null;
    L129:
        r100 = true;
        goto L130
    L58:
        r105 = null;
        goto L60
    L25:
        if (this.f125063f != 2) goto L27;
    L36:
        int r135 = ((ArrayList) this.f125066i).indexOf(Integer.valueOf(this.f125065h));
        int r136 = ((ArrayList) this.f125066i).indexOf(Integer.valueOf(r110.hashCode()));
        if (r136 <= 0) goto L55;
        if (r136 <= r135) goto L55;
        VideoFloatWindowView r137 = this.f125059b;
        if (r137 == null) goto L46;
        InnerContextEntity r138 = r137.getContainContext();
        if (r138 == null) goto L44;
        FrameLayout r139 = r138.getRootView();
    L45:
        f(r139);
        goto L46
    L44:
        r139 = null;
    L46:
        this.f125062e = false;
        this.f125063f = 0;
        VideoFloatWindowView r140 = this.f125059b;
        if (r140 != null) goto L49;
    L51:
        boolean r141 = false;
    L52:
        if (r141 == false) goto L54;
        q();
    L54:
        m("onContextStart and start " + r110);
        goto L55
    L49:
        if (r140.n() != true) goto L51;
        r141 = true;
        goto L52
    L27:
        if (l() == false) goto L33;
        int r142 = this.f125063f;
        if (r142 == 2) goto L32;
        if (r142 != 3) goto L33;
    L32:
        boolean r143 = false;
    L34:
        if (r143 == false) goto L36;
    L33:
        r143 = true;
        goto L34
    L20:
        r103 = null;
        goto L22
    L8:
        if (((ArrayList) this.f125064g).contains(r110) == true) goto L17;
        VideoFloatWindowView r144 = this.f125059b;
        if (r144 == null) goto L16;
        q();
        InnerContextEntity r145 = r144.getContainContext();
        if (r145 == null) goto L14;
        FrameLayout r146 = r145.getRootView();
    L15:
        f(r146);
        goto L16
    L14:
        r146 = null;
    L16:
        this.f125062e = false;
        this.f125063f = 0;
        m("onContextResume and resume " + r110);
        goto L17
    }

    public static void t(List r100, ActionType r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r103 = new ArrayList(r100);
        int r104 = i.f125145a[r101.ordinal()];
        if (r104 != 1) goto L7;
        Iterator r105 = r103.iterator();
    L41:
        if (r105.hasNext() == false) goto L75;
        IVideoFloatManager.VideoFloatManagerListener r106 = (IVideoFloatManager.VideoFloatManagerListener) r105.next();
        if (r106 == null) goto L41;
        r106.onShow();
        goto L41
    L75:
        return;
    L7:
        if (r104 != 2) goto L9;
        Iterator r107 = r103.iterator();
    L35:
        if (r107.hasNext() == false) goto L74;
        IVideoFloatManager.VideoFloatManagerListener r108 = (IVideoFloatManager.VideoFloatManagerListener) r107.next();
        if (r108 == null) goto L35;
        r108.onClick();
        goto L35
    L74:
        return;
    L9:
        if (r104 != 3) goto L11;
        Iterator r109 = r103.iterator();
    L29:
        if (r109.hasNext() == false) goto L73;
        IVideoFloatManager.VideoFloatManagerListener r110 = (IVideoFloatManager.VideoFloatManagerListener) r109.next();
        if (r110 == null) goto L29;
        r110.onMuteButtonClick(r102);
        goto L29
    L73:
        return;
    L11:
        if (r104 != 4) goto L13;
        Iterator r111 = r103.iterator();
    L23:
        if (r111.hasNext() == false) goto L72;
        IVideoFloatManager.VideoFloatManagerListener r112 = (IVideoFloatManager.VideoFloatManagerListener) r111.next();
        if (r112 == null) goto L23;
        r112.onClose(r102);
        goto L23
    L72:
        return;
    L13:
        if (r104 != 5) goto L45;
        Iterator r113 = r103.iterator();
    L17:
        if (r113.hasNext() == false) goto L71;
        IVideoFloatManager.VideoFloatManagerListener r114 = (IVideoFloatManager.VideoFloatManagerListener) r113.next();
        if (r114 == null) goto L17;
        r114.onReturnClick();
        goto L17
    L71:
        return;
    }
}
