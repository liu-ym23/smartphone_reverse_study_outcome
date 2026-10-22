package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bef.effectsdk.RequirementDefine;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.ui.RecenterGuideView;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.h1;
import zg1.n3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/vr/VrModeAudienceTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrModeAudienceTetris extends LiveTetris<e0> implements Observer<KVData> {
    public static final /* synthetic */ int P = 0;
    public VrAudienceCursorView A;
    public View B;
    public TextView C;
    public View D;
    public RecenterGuideView E;
    public ImageView F;
    public RoomContext G;
    public com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a H;
    public Disposable I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CompositeDisposable f111884J;
    public final Rect K;
    public final List<ph1.a> L;
    public boolean M;
    public long N;
    public boolean O;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f111885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f111886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.livesdk.widget.y f111887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.android.livesdk.widget.y f111888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ao1.a f111889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy<VrModeAudienceTetris$clearInterceptor$1.a> f111890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f111891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f111892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f111893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f111894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f111895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f111896z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111897a;

        public b(VrModeAudienceTetris r100) {
            this.f111897a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            VrModeAudienceTetris r102 = this.f111897a;
            int r103 = VrModeAudienceTetris.P;
            if (VrUtils.t(r102.getDataCenter(), false) == true) goto L6;
            return;
        L6:
            if (r101.booleanValue() == false) goto L8;
            this.f111897a.c0();
            return;
        L8:
            this.f111897a.g0();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111898a;

        public c(VrModeAudienceTetris r100) {
            this.f111898a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L15;
            int r101 = gh1.a.f481246c;
            VrModeAudienceTetris r102 = this.f111898a;
            int r103 = VrModeAudienceTetris.P;
            DataCenter r104 = r102.getDataCenter();
            RoomContext r105 = RoomContext.a.c(RoomContext.Companion, r104, 0, 2);
            if (r105 != null) goto L8;
        L10:
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r106 = this.f111898a.H;
            if (r106 == null) goto L14;
            r106.closeVrSensorWhenClickSwitchOrientation();
            return;
        L14:
            return;
        L8:
            if (r105.getStickyBehaviorEvents() != null) goto L10;
            r105.setStickyBehaviorEvents(new ArrayList());
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111900a;

        public d(VrModeAudienceTetris r100) {
            this.f111900a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            h80.c r101 = (h80.c) r100;
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r102 = this.f111900a.H;
            if (r102 == null) goto L6;
            r102.exitVrMode();
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f111902b;

        public e(VrModeAudienceTetris r100, boolean r101) {
            this.f111901a = r100;
            this.f111902b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111901a.H;
            if (r101 == null) goto L9;
            com.bytedance.live.datacontext.m<? extends Boolean> r102 = r101.isVrSensorOpen();
            if (r102 == null) goto L9;
            if (r102.getValue().booleanValue() != true) goto L9;
            int r103 = 1;
        L10:
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r104 = this.f111901a.H;
            if (r104 == null) goto L13;
            r104.openVrSensor(r103 ^ 1);
        L13:
            ILivePlayerClient r105 = LivePlatformPlayerManager.f();
            if (r105 == null) goto L16;
            r105.setGyroStatusInitial(r103);
        L16:
            VrModeAudienceTetris.a0(this.f111901a, RequirementDefine.REQUIREMENT_GYROSCOPE_TAG, true ^ this.f111902b);
            return;
        L9:
            r103 = 0;
            goto L10
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f111904b;

        public f(VrModeAudienceTetris r100, boolean r101) {
            this.f111903a = r100;
            this.f111904b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111903a.H;
            if (r101 == null) goto L5;
            r101.notifyRecenter();
        L5:
            int r102 = r.f111945b;
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r103 = this.f111903a.H;
            boolean r104 = false;
            if (r103 == null) goto L12;
            com.bytedance.live.datacontext.m<? extends Boolean> r105 = r103.isVrSensorOpen();
            if (r105 == null) goto L12;
            Boolean r106 = r105.getValue();
            if (r106 == null) goto L12;
            boolean r107 = r106.booleanValue();
        L13:
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r108 = this.f111903a.H;
            if (r108 == null) goto L20;
            com.bytedance.live.datacontext.m<? extends Boolean> r109 = r108.isVrMode();
            if (r109 == null) goto L20;
            Boolean r110 = r109.getValue();
            if (r110 == null) goto L20;
            r104 = r110.booleanValue();
        L20:
            r.b("restting", r107, r104);
            VrModeAudienceTetris.a0(this.f111903a, "restting", !this.f111904b);
            return;
        L12:
            r107 = false;
            goto L13
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111905a;

        public g(VrModeAudienceTetris r100) {
            this.f111905a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L19;
            VrUtils.f114389e.getClass();
            if (VrUtils.f114388d != 0) goto L7;
            boolean r101 = true;
        L9:
            if (this.f111905a.M == true) goto L13;
            ILivePlayerClient r102 = LivePlatformPlayerManager.f();
            if (r102 == null) goto L13;
            r102.gyroEnable(r101);
        L13:
            RoomContext r103 = this.f111905a.G;
            if (r103 == null) goto L20;
            com.bytedance.live.datacontext.m<Boolean> r104 = r103.getVrSensorOpened();
            if (r104 == null) goto L21;
            r104.setValue(Boolean.valueOf(r101));
            return;
        L21:
            return;
        L20:
            return;
        L7:
            r101 = false;
            goto L9
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f111907b;

        public h(VrModeAudienceTetris r100, boolean r101) {
            this.f111906a = r100;
            this.f111907b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VrModeAudienceTetris r101 = this.f111906a;
            int r102 = VrModeAudienceTetris.P;
            if (com.bytedance.android.livesdk.feedback.utils.a.b(r101.getDataCenter(), 6) == false) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r103 = this.f111906a.H;
            if (r103 == null) goto L8;
            r103.exitVrMode();
        L8:
            VrModeAudienceTetris.a0(this.f111906a, "exit_vr_model", !this.f111907b);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f111909b;

        public i(VrModeAudienceTetris r100, boolean r101) {
            this.f111908a = r100;
            this.f111909b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VrModeAudienceTetris r101 = this.f111908a;
            int r102 = VrModeAudienceTetris.P;
            if (com.bytedance.android.livesdk.feedback.utils.a.b(r101.getDataCenter(), 6) == false) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r103 = this.f111908a.H;
            if (r103 == null) goto L8;
            r103.exitVrMode();
        L8:
            VrModeAudienceTetris.a0(this.f111908a, "exit_vr_model", !this.f111909b);
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111910a;

        public j(VrModeAudienceTetris r100) {
            this.f111910a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            xs2.b.a().post(new h1(6));
            VrModeAudienceTetris r101 = this.f111910a;
            int r102 = VrModeAudienceTetris.P;
            r101.d0();
        }
    }

    public static final class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f111912b;

        public k(VrModeAudienceTetris r100, boolean r101) {
            this.f111911a = r100;
            this.f111912b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RoomContext r101 = this.f111911a.G;
            if (r101 == null) goto L7;
            com.bytedance.live.datacontext.m<Boolean> r102 = r101.getVrOrientationChangeByClick();
            if (r102 == null) goto L7;
            r102.setValue(Boolean.TRUE);
        L7:
            DataCenter r103 = this.f111911a.getDataCenter();
            if (r103 != null) goto L10;
        L12:
            boolean r104 = false;
        L13:
            if (r104 == false) goto L15;
            int r105 = 2;
        L16:
            xs2.b.a().post(new HorizontalPlayEvent(r105, 1));
            this.f111911a.Z("landscape", true ^ this.f111912b, MapsKt.mapOf(TuplesKt.to("landscape_type", String.valueOf(r105))));
            return;
        L15:
            r105 = 1;
            goto L16
        L10:
            if (com.bytedance.android.live.core.utils.z.m(r103, true) != true) goto L12;
            r104 = true;
            goto L13
        }
    }

    public static final class l<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VrModeAudienceTetris f111913a;

        public l(VrModeAudienceTetris r100) {
            this.f111913a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) ((KVData) r100).getData();
            VrModeAudienceTetris r102 = this.f111913a;
            int r103 = VrModeAudienceTetris.P;
            r102.getDataCenter();
            boolean r104 = VrUtils.s();
            RxBusAbility.INSTANCE.getRxBus(((e0) this.f111913a.K()).f467480h).post(new n3(r104));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c0() {
        RoomContext r100 = this.G;
        Boolean r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<Room> r102 = r100.getRoom();
        if (r102 == null) goto L7;
        Room r103 = r102.getValue();
    L9:
        if (VrUtils.g(r103) == true) goto L12;
        return;
    L12:
        if (VrUtils.h() == false) goto L55;
        boolean r104 = true;
        if (getDataCenter() == null) goto L21;
        DataCenter r105 = getDataCenter();
        if (r105 == null) goto L19;
        r101 = (Boolean) r105.get("data_hide_screen", Boolean.FALSE);
    L19:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
    L33:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r107 = this.H;
        if (r107 == null) goto L40;
        com.bytedance.live.datacontext.m<? extends Boolean> r108 = r107.isVrSensorOpen();
        if (r108 == null) goto L40;
        Boolean r109 = r108.getValue();
        if (r109 == null) goto L40;
        boolean r110 = r109.booleanValue();
    L41:
        if (r106 == true) goto L55;
        if (r110 != true) goto L45;
        return;
    L45:
        if (VrUtils.h() == true) goto L47;
    L51:
        r104 = false;
    L52:
        if (r104 == false) goto L55;
        return;
    L47:
        if (VrUtils.m() == VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY.getType()) goto L52;
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_NEVER.getType()) goto L51;
    L40:
        r110 = false;
        goto L41
    L24:
        if (VrUtils.h() == true) goto L26;
    L30:
        boolean r111 = false;
    L31:
        if (r111 == false) goto L33;
        return;
    L26:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY.getType()) goto L28;
    L29:
        r111 = true;
        goto L31
    L28:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_NEVER.getType()) goto L30;
    L21:
        r106 = false;
    L55:
        if (this.f111889s != null) goto L58;
        ao1.a r112 = new ao1.a(((e0) K()).getContext(), this.H, getDataCenter());
        this.f111889s = r112;
        int r113 = gh1.a.f481246c;
        gh1.a.C6019a.a(getDataCenter(), r112);
        return;
    L58:
        return;
    L7:
        r103 = null;
        goto L9
    }

    public final void g0() {
        ao1.a r100 = this.f111889s;
        if (r100 == null) goto L5;
        int r101 = gh1.a.f481246c;
        gh1.a.C6019a.b(getDataCenter(), r100);
    L5:
        this.f111889s = null;
    }

    public VrModeAudienceTetris() {
        this.f111890t = LazyKt.lazy(new VrModeAudienceTetris$clearInterceptor$1(this));
        this.f111884J = new CompositeDisposable();
        this.K = new Rect();
        this.L = new ArrayList();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        DataCenter r100 = getDataCenter();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("cmd_current_sub_camera_state");
    L7:
        if ((r102 instanceof es0.a) == false) goto L10;
        r101 = r102;
    L10:
        es0.a r103 = (es0.a) r101;
        if (r103 == null) goto L13;
        boolean r104 = r103.f473677b;
    L14:
        ILivePlayerClient r105 = LivePlatformPlayerManager.f();
        if (r105 == null) goto L17;
        r105.setVrDirectMode(ILivePlayerVRController.Companion.getPANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH());
    L17:
        ILivePlayerClient r106 = LivePlatformPlayerManager.f();
        if (r106 == null) goto L24;
        IRoomEventHub r107 = r106.getEventHub();
        if (r107 == null) goto L24;
        MutableLiveData<Boolean> r108 = r107.getReset();
        if (r108 == null) goto L24;
        r108.observe(this, new g(this));
    L24:
        boolean r109 = true;
        UIUtils.setClickListener(true, this.f111893w, new h(this, r104));
        UIUtils.setClickListener(true, this.f111894x, new i(this, r104));
        UIUtils.setClickListener(true, this.f111892v, new j(this));
        UIUtils.setClickListener(true, this.F, new k(this, r104));
        DataCenter r110 = getDataCenter();
        if (r110 == null) goto L27;
        r110.observe("data_is_portrait", new l(this));
    L27:
        View r111 = this.f111893w;
        if (r111 == null) goto L30;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r111), false));
    L30:
        ImageView r112 = this.f111894x;
        if (r112 == null) goto L33;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r112), false));
    L33:
        View r113 = this.f111892v;
        if (r113 == null) goto L36;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r113), false));
    L36:
        View r114 = this.B;
        if (r114 == null) goto L39;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r114), false));
    L39:
        VrAudienceCursorView r115 = this.A;
        if (r115 == null) goto L42;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r115), true));
    L42:
        ImageView r116 = this.f111895y;
        if (r116 == null) goto L45;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r116), false));
        r116.setOnClickListener(new e(this, r104));
    L45:
        ImageView r117 = this.f111896z;
        if (r117 == null) goto L48;
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r117), false));
        r117.setOnClickListener(new f(this, r104));
    L48:
        ImageView r118 = this.F;
        if (r118 != null) goto L51;
    L54:
        VrAudienceCursorView r119 = this.A;
        if (r119 == null) goto L57;
        r119.getDragPosFilters().put("sensorBtn", new VrModeAudienceTetris$setCursorForbidRegion$$inlined$let$lambda$1(this));
        r119.getLandingPosFilters().put("sensorBtn", new VrModeAudienceTetris$setCursorForbidRegion$$inlined$let$lambda$2(this));
    L57:
        VrAudienceCursorView r120 = this.A;
        if (r120 == null) goto L60;
        r120.getDragPosFilters().put("exitBtn", new VrModeAudienceTetris$setCursorForbidRegionForExit$$inlined$let$lambda$1(this));
        r120.getLandingPosFilters().put("exitBtn", new VrModeAudienceTetris$setCursorForbidRegionForExit$$inlined$let$lambda$2(this));
    L60:
        VrUtils.f114389e.getClass();
        if (VrUtils.f114388d == 0) goto L64;
        r109 = false;
    L64:
        f0(r109, false);
        return;
    L51:
        if (VrUtils.B() == true) goto L53;
        r118.setVisibility(8);
    L53:
        ((ArrayList) this.L).add(new ph1.a(new WeakReference(r118), false));
        goto L54
    L13:
        r104 = false;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0() {
        if (SettingKeyUtils.c() == false) goto L5;
        VrUtils.b(false, this.L, ((e0) K()).b());
    L5:
        ((ArrayList) this.L).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DataCenter getDataCenter() {
        return ((e0) K()).f467480h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [h70.b] */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onCreate() {
        super.onCreate();
        DataCenter r100 = ((e0) K()).f467480h;
        Boolean r101 = null;
        this.G = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        Pair r102 = com.bytedance.live.datacontext.d.a(new VrModeAudienceTetris$initVrCtx$1(this));
        Object r103 = r102.getFirst();
        ((LiveVrContext) r103).registerMultiCameraCallback();
        Unit r104 = Unit.INSTANCE;
        this.H = (com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a) r103;
        this.I = (Disposable) r102.getSecond();
        com.bytedance.live.datacontext.d.c((DataContext) r102.getFirst(), LiveVrContext.TAG);
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r105 = this.H;
        if (r105 == null) goto L11;
        RxUtilKt.c(r105.isVrMode().a().subscribe(new s(r105, this)), this.f111884J);
        RxUtilKt.c(r105.isVrSensorOpen().a().subscribe(new t(r105, this)), this.f111884J);
        com.bytedance.live.datacontext.k<Unit> r106 = r105.getShowRecenterGuide();
        if (r106 == null) goto L11;
        PublishSubject r107 = r106.onEvent();
        if (r107 == null) goto L11;
        Disposable r108 = r107.subscribe(new u(this));
        if (r108 == null) goto L11;
        RxUtilKt.c(r108, this.f111884J);
    L11:
        this.f111885o = xs2.b.a().b(zg1.s.class).distinctUntilChanged(v.f111954a).subscribe(new w(this));
        VrAudienceCursorView r109 = this.A;
        if (r109 != null) goto L14;
    L25:
        IStrategyService r110 = (IStrategyService) jc1.k.f(IStrategyService.class);
        boolean r111 = false;
        if (r110 == null) goto L42;
        LiveData r112 = r110.getFactor("vr_stream_downgrade_level", 0, false, true);
        if (r112 == null) goto L42;
        Integer r113 = (Integer) r112.getValue();
        if (r113 != null) goto L34;
        r113 = 0;
    L34:
        if (Intrinsics.compare(r113.intValue(), 1) < 0) goto L36;
        boolean r114 = true;
    L37:
        this.M = r114;
        if (r114 == false) goto L42;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r115 = LiveVrContext.c.a();
        if (r115 == null) goto L42;
        r115.openVrSensor(false);
        goto L42
    L36:
        r114 = false;
    L42:
        System.currentTimeMillis();
        if (this.M == true) goto L66;
        RoomContext r116 = this.G;
        if (r116 == null) goto L51;
        com.bytedance.live.datacontext.m<Boolean> r117 = r116.getChangingCamera();
        if (r117 == null) goto L51;
        if (r117.getValue().booleanValue() != true) goto L51;
    L56:
        RoomContext r118 = this.G;
        if (r118 == null) goto L65;
        com.bytedance.live.datacontext.m<Boolean> r119 = r118.getVrSensorOpened();
        if (r119 == null) goto L65;
        Boolean r120 = r119.getValue();
        if (r120 == null) goto L65;
        r111 = r120.booleanValue();
    L65:
        r111 = true;
    L51:
        DataCenter r121 = getDataCenter();
        if (r121 == null) goto L55;
        r101 = (Boolean) r121.get("data_has_change_screen_orientation", Boolean.FALSE);
    L55:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L56;
        VrUtils.f114389e.getClass();
        if (VrUtils.f114388d == 0) goto L65;
    L66:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r122 = this.H;
        if (r122 == null) goto L69;
        r122.openVrSensor(r111);
    L69:
        RoomContext r123 = this.G;
        if (r123 == null) goto L81;
        com.bytedance.live.datacontext.m<Boolean> r124 = r123.getChangingCamera();
        if (r124 == null) goto L81;
        if (r124.getValue().booleanValue() != true) goto L81;
        RoomContext r125 = this.G;
        if (r125 == null) goto L81;
        com.bytedance.live.datacontext.m<Boolean> r126 = r125.getChangingCamera();
        if (r126 == null) goto L81;
        r126.setValue(Boolean.FALSE);
    L81:
        if (VrUtils.h() == false) goto L91;
        DataCenter r127 = getDataCenter();
        if (r127 == null) goto L85;
        r127.observe("data_hide_screen", this);
    L85:
        RoomContext r128 = this.G;
        if (r128 == null) goto L102;
        com.bytedance.live.datacontext.n<ArrayList<ph1.a>> r129 = r128.getVrCleanModeAnchorViews();
        if (r129 == null) goto L102;
        r129.setValue(new ArrayList());
    L102:
        RoomContext r130 = this.G;
        if (r130 == null) goto L111;
        com.bytedance.live.datacontext.m<Boolean> r131 = r130.isLandscapeLock();
        if (r131 == null) goto L111;
        Observable<Boolean> r132 = r131.a();
        if (r132 == null) goto L111;
        Disposable r133 = r132.subscribe(new b(this));
        if (r133 == null) goto L111;
        RxUtilKt.c(r133, this.f111884J);
    L111:
        RoomContext r134 = this.G;
        if (r134 == null) goto L116;
        com.bytedance.live.datacontext.m<Boolean> r135 = r134.getVrTetrisCreated();
        if (r135 == null) goto L116;
        r135.setValue(Boolean.TRUE);
    L116:
        RoomContext r136 = this.G;
        if (r136 == null) goto L126;
        com.bytedance.live.datacontext.m<Boolean> r137 = r136.getVrOrientationChangeByClick();
        if (r137 == null) goto L126;
        Observable<Boolean> r138 = r137.a();
        if (r138 == null) goto L126;
        Disposable r139 = r138.subscribe(new c(this));
        if (r139 == null) goto L126;
        RxUtilKt.c(r139, this.f111884J);
    L126:
        if (VrUtils.B() == false) goto L140;
        RoomContext r140 = this.G;
        if (r140 == null) goto L136;
        com.bytedance.live.datacontext.m<Boolean> r141 = r140.getVrInImmersedMode();
        if (r141 == null) goto L136;
        if (r141.getValue().booleanValue() != true) goto L136;
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r142 = this.H;
        if (r142 == null) goto L140;
        r142.enterVrMode();
    L136:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r143 = this.H;
        if (r143 == null) goto L140;
        r143.exitVrMode();
    L140:
        if (ho1.a.o(getComponentContext()) == false) goto L151;
        e0 r144 = (e0) getComponentContext();
        if (r144 == null) goto L152;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.n r145 = ho1.a.e(r144);
        if (r145 == null) goto L153;
        PropertyOwner r146 = r145.sa();
        if (r146 == null) goto L154;
        Disposable r147 = r146.subscribe(new d(this));
        if (r147 == null) goto L155;
        RxUtilKt.c(r147, this.f111884J);
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    L91:
        if (SettingKeyUtils.d() == false) goto L102;
        if (SettingKeyUtils.c() == false) goto L102;
        DataCenter r148 = getDataCenter();
        if (r148 == null) goto L97;
        r148.observe("data_hide_screen", this);
    L97:
        RoomContext r149 = this.G;
        if (r149 == null) goto L102;
        com.bytedance.live.datacontext.n<ArrayList<ph1.a>> r150 = r149.getVrCleanModeAnchorViews();
        if (r150 == null) goto L102;
        r150.setValue(new ArrayList());
        goto L102
    L14:
        if (r109.f111870e != null) goto L25;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r151 = LiveVrContext.c.a();
        if (r151 == null) goto L23;
        com.bytedance.live.datacontext.k<MotionEvent> r152 = r151.getDirectionIndicatorTouchEvent();
        if (r152 == null) goto L23;
        PublishSubject r153 = r152.onEvent();
        if (r153 == null) goto L23;
        Disposable r154 = r153.subscribe(new q(r109));
    L24:
        r109.f111870e = r154;
    L23:
        r154 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        VrAudienceCursorView r100 = this.A;
        if (r100 == null) goto L13;
        o r101 = r100.f111881p;
        if (r101 == null) goto L13;
        ILivePlayerClient r102 = LivePlatformPlayerManager.f();
        if (r102 == null) goto L13;
        IRoomEventHub r103 = r102.getEventHub();
        if (r103 == null) goto L13;
        MutableLiveData<List<Float>> r104 = r103.getVrViewAngleChange();
        if (r104 == null) goto L13;
        r104.removeObserver(r101);
    L13:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r105 = this.H;
        if (r105 == null) goto L16;
        r105.releaseObservers();
    L16:
        this.H = null;
        Disposable r106 = this.I;
        if (r106 == null) goto L19;
        r106.dispose();
    L19:
        this.I = null;
        Disposable r107 = this.f111885o;
        if (r107 == null) goto L22;
        r107.dispose();
    L22:
        this.f111884J.clear();
        b0(0);
        RecenterGuideView r108 = this.E;
        if (r108 == null) goto L25;
        r108.a();
    L25:
        DataCenter r109 = getDataCenter();
        if (r109 == null) goto L28;
        r109.removeObserver(this);
    L28:
        RoomContext r110 = this.G;
        if (r110 == null) goto L35;
        com.bytedance.live.datacontext.n<ArrayList<ph1.a>> r111 = r110.getVrCleanModeAnchorViews();
        if (r111 == null) goto L35;
        ArrayList<ph1.a> r112 = r111.getValue();
        if (r112 == null) goto L35;
        r112.clear();
    L35:
        d0();
        RoomContext r113 = this.G;
        if (r113 != null) goto L38;
    L39:
        RoomContext r114 = this.G;
        if (r114 == null) goto L46;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.getVrTetrisCreated();
        if (r115 == null) goto L47;
        r115.setValue(Boolean.FALSE);
        return;
    L47:
        return;
    L46:
        return;
    L38:
        if (r113.isCleared() != true) goto L39;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (SettingKeyUtils.d() == true) goto L5;
    L7:
        int r101 = R.layout.ttlive_layout_vr_mode_audience_tetris;
    L8:
        View r102 = r100.b(r101);
        this.f111892v = r102.findViewById(R.id.close);
        this.f111893w = r102.findViewById(R.id.exit_vr_mode);
        this.f111894x = (ImageView) r102.findViewById(R.id.exit_vr_mode_icon);
        this.f111896z = (ImageView) r102.findViewById(R.id.open_vr_viewport_reset);
        this.f111895y = (ImageView) r102.findViewById(R.id.open_vr_sensor);
        this.A = (VrAudienceCursorView) r102.findViewById(R.id.vrCursorContainer);
        this.B = r102.findViewById(R.id.iv_vr_indicator);
        this.C = (TextView) r102.findViewById(R.id.exit_vr_mode_text);
        this.D = r102.findViewById(R.id.exit_vr_mode_icon);
        this.E = (RecenterGuideView) r102.findViewById(R.id.recenterGuideView);
        this.F = (ImageView) r102.findViewById(R.id.change_vr_orientation);
        VrAudienceCursorView r103 = this.A;
        if (r103 == null) goto L11;
        r103.setDataCenter(getDataCenter());
    L11:
        return r102;
    L5:
        if (SettingKeyUtils.e() == false) goto L7;
        r101 = R.layout.ttlive_layout_vr_mode_audience_tetris_new;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(Function2<? super Float, ? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        View r101 = L();
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.feedback.utils.b.a((ViewGroup) r101, this.f111896z, this.K);
        r100.invoke(Float.valueOf(this.K.left - UIUtils.dip2Px(((e0) K()).getContext(), 8.0f)), Float.valueOf(this.K.top - UIUtils.dip2Px(((e0) K()).getContext(), 8.0f)));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void W(Function2<? super Float, ? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        View r101 = this.f111892v;
        if (r101 == null) goto L6;
        int[] r102 = new int[2];
        r101.getLocationOnScreen(r102);
        r100.invoke(Float.valueOf((r102[0] - a1.g(r101)) - a1.f(r101)), Float.valueOf(r101.getMeasuredHeight() + a1.h(r101)));
        return;
    }

    public final void b0(int r110) {
        if (this.O == true) goto L5;
        return;
    L5:
        String r100 = String.valueOf(VrUtils.l(getDataCenter()));
        long r101 = System.currentTimeMillis();
        HashMap r102 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r104 = "";
        if (r103 == null) goto L11;
        Map<String, String> r105 = r103.getMap();
        if (r105 == null) goto L11;
        String r106 = r105.get("action_type");
        if (r106 == null) goto L11;
    L13:
        if (r103 == null) goto L18;
        Map<String, String> r107 = r103.getMap();
        if (r107 == null) goto L18;
        String r108 = r107.get("enter_from_merge");
        if (r108 == null) goto L18;
    L20:
        if (r103 == null) goto L25;
        Map<String, String> r109 = r103.getMap();
        if (r109 == null) goto L25;
        String r111 = r109.get("enter_method");
        if (r111 == null) goto L25;
    L26:
        r102.put("enter_from_merge", r108);
        r102.put("enter_method", r111);
        DataCenter r112 = getDataCenter();
        if (r112 == null) goto L31;
        Room r113 = com.bytedance.android.live.core.utils.z.o(r112);
        if (r113 == null) goto L31;
        Long r114 = Long.valueOf(r113.f162599id);
    L32:
        r102.put("room_id", String.valueOf(r114));
        DataCenter r115 = getDataCenter();
        if (r115 == null) goto L40;
        Room r116 = com.bytedance.android.live.core.utils.z.o(r115);
        if (r116 == null) goto L40;
        String r117 = r116.getOwnerUserIdString();
        if (r117 == null) goto L40;
        r104 = r117;
    L40:
        r102.put("anchor_id", r104);
        r102.put("action_type", r106);
        long r118 = this.N;
        if (r118 <= 0) goto L43;
        r102.put("duration", String.valueOf(r101 - r118));
    L43:
        r102.put("leave_type", String.valueOf(r110));
        r102.put("screen_direction", r100);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_vr_paly_duration", r102, new Object[0]);
        return;
    L31:
        r114 = null;
    L25:
        r111 = "";
    L18:
        r108 = "";
    L11:
        r106 = "";
        goto L13
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1122045708)) goto L12;
        return;
    L12:
        if (r102.equals("data_hide_screen") == true) goto L14;
        return;
    L14:
        if (SettingKeyUtils.d() == false) goto L18;
        if (SettingKeyUtils.c() == false) goto L18;
    L20:
        g0();
        if (VrUtils.i(getDataCenter()) == false) goto L24;
        c0();
    L24:
        if (VrUtils.h() == false) goto L26;
        c0();
    L26:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r103 = this.H;
        if (r103 == null) goto L34;
        Boolean r104 = (Boolean) r101.getData();
        if (r104 != null) goto L31;
        r104 = Boolean.FALSE;
    L31:
        r103.setInCleanMode(r104.booleanValue());
        return;
    L34:
        return;
    L18:
        if (VrUtils.h() == true) goto L20;
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(boolean r100, boolean r101) {
        if (r100 == false) goto L19;
        if (SettingKeyUtils.d() == true) goto L7;
    L9:
        int r102 = R.drawable.ttlive_ic_vr_sensor_open;
    L10:
        ImageView r103 = this.f111895y;
        if (r103 == null) goto L14;
        r103.setImageDrawable(((e0) K()).getContext().getResources().getDrawable(r102));
    L14:
        if (SettingKeyUtils.d() == false) goto L16;
        SettingKeyUtils.e();
    L16:
        if (r101 == false) goto L35;
        f2.c("可通过转动手机切换视角", 0);
    L35:
        JSONObject r104 = new JSONObject();
        r104.put("vr_sensor_open", r100);     // Catch: JSONException -> L39
    L37:
        com.bytedance.android.livesdk.log.b0.o().k("LiveVRMonitor_live_play", r104);
        return;
    L7:
        if (SettingKeyUtils.e() == false) goto L9;
        r102 = R.drawable.ttlive_vr_view_fixed_immersed_large;
        goto L10
    L19:
        if (SettingKeyUtils.d() == true) goto L21;
    L23:
        int r105 = R.drawable.ttlive_ic_vr_sensor_close;
    L24:
        ImageView r106 = this.f111895y;
        if (r106 == null) goto L28;
        r106.setImageDrawable(((e0) K()).getContext().getResources().getDrawable(r105));
    L28:
        if (SettingKeyUtils.d() == true) goto L30;
    L32:
        String r107 = "视角已固定，拖动屏幕切换视角";
    L33:
        if (r101 == false) goto L35;
        f2.c(r107, 0);
        goto L35
    L30:
        if (SettingKeyUtils.e() == false) goto L32;
        r107 = "视角已固定";
        goto L33
    L21:
        if (SettingKeyUtils.e() == false) goto L23;
        r105 = R.drawable.ttlive_vr_view_not_fixed_immersed_large;
        goto L24
    }

    public static /* synthetic */ void a0(VrModeAudienceTetris r100, String r101, boolean r102) {
        r100.Z(r101, r102, MapsKt.emptyMap());
    }

    public final void Z(String r100, boolean r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "iconType");
        Intrinsics.checkNotNullParameter(r102, FrescoMonitorConst.IMAGEX_CUSTOM_PARAM);
        HashMap r103 = new HashMap();
        int r104 = r.f111945b;
        r.a(getDataCenter(), r103, true);
        r103.put("vr_icon_type", r100);
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r103.put("is_original_vr", r105);
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r106 = this.H;
        if (r106 == null) goto L13;
        com.bytedance.live.datacontext.m<? extends Boolean> r107 = r106.isVrSensorOpen();
        if (r107 == null) goto L13;
        if (r107.getValue().booleanValue() != true) goto L13;
        String r108 = "on";
    L14:
        r103.put("gyroscope_state", r108);
        r103.putAll(r102);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_vrmodel_toolbar_click", r103, new Object[0]);
        return;
    L13:
        r108 = "off";
        goto L14
    L5:
        r105 = "0";
        goto L6
    }
}
