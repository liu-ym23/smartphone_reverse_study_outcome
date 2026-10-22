package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftStateMachineConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f126971a = 0;

    public static abstract class Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f126972a;

        public static final class LazyEvent extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public LazyEventState f126973b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Event f126974c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Class<? extends g> f126975d;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$Event$LazyEvent$LazyEventState;", "", "INITIALIZE", "FINISH", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final enum LazyEventState extends Enum<LazyEventState> {
                public static final LazyEventState FINISH = null;
                public static final LazyEventState INITIALIZE = null;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ LazyEventState[] f126976a = null;

                static {
                    LazyEventState r100 = new LazyEventState("INITIALIZE", 0);
                    INITIALIZE = r100;
                    LazyEventState r101 = new LazyEventState("FINISH", 1);
                    FINISH = r101;
                    f126976a = new LazyEventState[]{r100, r101};
                }

                public static LazyEventState valueOf(String r100) {
                    return (LazyEventState) r27.a.a(LazyEventState.class, r100);
                }

                public static LazyEventState[] values() {
                    return (LazyEventState[]) f126976a.clone();
                }

                public LazyEventState(String r100, int r101) {
                    super(r100, r101);
                }
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LazyEvent";
            }

            public LazyEvent(j r100, Class r101) {
                Intrinsics.checkNotNullParameter(r100, "originEvent");
                Intrinsics.checkNotNullParameter(r101, "targetStateType");
                this.f126974c = r100;
                this.f126975d = r101;
                this.f126973b = LazyEventState.INITIALIZE;
            }
        }

        public static final class a extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final IBaseUser f126977b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeDefaultReceiver";
            }

            public a(IBaseUser r100) {
                this.f126977b = r100;
            }
        }

        public static final class a0 extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbsPanel<?> f126978b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "TriggerGroup";
            }

            public a0(AbsPanel<?> r100) {
                Intrinsics.checkNotNullParameter(r100, "panel");
                this.f126978b = r100;
            }
        }

        public static final class b extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeAllMicReceiver";
            }
        }

        public static final class b0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateAudienceReceiverList";
            }
        }

        public static final class c extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeReceiver";
            }
        }

        public static final class c0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateCurrentListItem";
            }

            static {
                new c0();
            }

            public c0() {
            }
        }

        public static final class d extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f126979b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f126980c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f126981d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final boolean f126982e;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeTab";
            }

            public /* synthetic */ d(int r100, boolean r110, int r111) {
                if ((r111 & 2) == 0) goto L5;
                boolean r101 = false;
            L7:
                if ((r111 & 8) == 0) goto L9;
                boolean r102 = true;
            L10:
                this(r100, r101, false, r102, false);
                return;
            L9:
                r102 = false;
                goto L10
            L5:
                r101 = r110;
                goto L7
            }

            public d(int r100, boolean r101, boolean r102, boolean r103, boolean r104) {
                this.f126979b = r100;
                this.f126980c = r101;
                this.f126981d = r103;
                this.f126982e = r104;
            }
        }

        public static final class d0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateExtraInfo";
            }
        }

        public static final class e extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ClickBuffTab";
            }
        }

        public static final class e0 extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final w0 f126983b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List<IBaseUser> f126984c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f126985d;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateGroupLiveList";
            }

            public e0(w0 r100, List r101) {
                Intrinsics.checkNotNullParameter(r101, "UserList");
                this.f126983b = r100;
                this.f126984c = r101;
                this.f126985d = true;
            }
        }

        public static final class f extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ClickDIYGiftTab";
            }
        }

        public static final class f0 extends Event {
            public f0() {
                throw null;
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateReceiverLiveList";
            }
        }

        public static final class g extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbsPanel<?> f126986b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ComboFinish";
            }

            public g(AbsPanel<?> r100) {
                Intrinsics.checkNotNullParameter(r100, "panel");
                this.f126986b = r100;
            }
        }

        public static final class g0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UserInteract";
            }

            public g0() {
            }
        }

        public static final class h extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f126987b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f126988c;

            public h() {
                this(0, 7);
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return this.f126988c;
            }

            public h(long r100, int r101) {
                if ((r101 & 2) == 0) goto L6;
                r100 = 0;
            L6:
                if ((r101 & 4) == 0) goto L8;
                String r102 = "HideDialog";
            L9:
                Intrinsics.checkNotNullParameter(r102, "TAG");
                this.f126987b = r100;
                this.f126988c = r102;
                return;
            L8:
                r102 = null;
                goto L9
            }
        }

        public static final class i extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LocateFirstGift";
            }

            public i() {
            }
        }

        public static final class j extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final LocateGiftInfo f126989b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LocateGift";
            }

            public j(LocateGiftInfo r100) {
                Intrinsics.checkNotNullParameter(r100, "locateGiftInfo");
                this.f126989b = r100;
            }
        }

        public static final class k extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f126990b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return UserChangedCallback.CHANGE_TYPE_LOGIN;
            }

            public k(int r100) {
                this.f126990b = r100;
            }
        }

        public static final class l extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final l f126991b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenDialog";
            }

            static {
                f126991b = new l();
            }

            public l() {
            }
        }

        public static final class m extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final x2 f126992b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f126993c;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenRechargeDialog";
            }

            public m(x2 r100, boolean r101) {
                this.f126992b = r100;
                this.f126993c = r101;
            }
        }

        public static final class n extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenRechargeRecommendDialog";
            }
        }

        public static final class o extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final o f126994b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ResetDialog";
            }

            static {
                f126994b = new o();
            }

            public o() {
            }
        }

        public static final class p extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbsPanel<?> f126995b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final AbsPanel.GiftPanelSelectType f126996c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f126997d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final boolean f126998e;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SelectGift";
            }

            public p(AbsPanel<?> r100, AbsPanel.GiftPanelSelectType r101, boolean r102, boolean r103) {
                Intrinsics.checkNotNullParameter(r100, "panel");
                Intrinsics.checkNotNullParameter(r101, "selectType");
                this.f126995b = r100;
                this.f126996c = r101;
                this.f126997d = r102;
                this.f126998e = r103;
            }
        }

        public static final class q extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbsPanel<?> f126999b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f127000c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f127001d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final IBaseUser f127002e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final int f127003f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final boolean f127004g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final com.bytedance.android.livesdk.gift.platform.core.model.n f127005h;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SendGift";
            }

            public /* synthetic */ q(AbsPanel r100, int r110, int r111, IBaseUser r112, com.bytedance.android.livesdk.gift.platform.core.model.n r113) {
                this(r100, r110, r111, r112, 0, false, r113);
            }

            public q(AbsPanel<?> r100, int r101, int r102, IBaseUser r103, int r104, boolean r105, com.bytedance.android.livesdk.gift.platform.core.model.n r106) {
                Intrinsics.checkNotNullParameter(r100, "panel");
                Intrinsics.checkNotNullParameter(r103, "toUser");
                Intrinsics.checkNotNullParameter(r106, "showInfo");
                this.f126999b = r100;
                this.f127000c = r101;
                this.f127001d = r102;
                this.f127002e = r103;
                this.f127003f = r104;
                this.f127004g = r105;
                this.f127005h = r106;
            }
        }

        public static final class r extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SendGroupGift";
            }
        }

        public static final class s extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ShowBuffWidget";
            }
        }

        public static final class t extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ShowCustomGiftSelectPanel";
            }
        }

        public static final class u extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncGiftExtra";
            }
        }

        public static final class v extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public c f127006b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f127007c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f127008d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final int f127009e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final boolean f127010f;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncList";
            }

            public v(boolean r100, boolean r101, int r102, boolean r103) {
                this.f127007c = r100;
                this.f127008d = r101;
                this.f127009e = r102;
                this.f127010f = r103;
            }
        }

        public static final class w extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final c f127011b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncListSuccess";
            }

            public w(c r100) {
                Intrinsics.checkNotNullParameter(r100, "GiftData");
                this.f127011b = r100;
            }
        }

        public static final class x extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final x f127012b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncListSuccessWithoutNotify";
            }

            static {
                f127012b = new x();
            }

            public x() {
            }
        }

        public static final class y extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final y f127013b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncProp";
            }

            static {
                f127013b = new y();
            }

            public y() {
            }
        }

        public static final class z extends Event {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<? extends pz1.e> f127014b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f127015c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f127016d;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncPropSuccess";
            }

            public z(List r100) {
                Intrinsics.checkNotNullParameter(r100, "propPanel");
                this.f127014b = r100;
                this.f127015c = false;
                this.f127016d = true;
            }
        }

        public abstract String a();

        public Event() {
            this.f126972a = true;
        }
    }

    public static abstract class a implements g {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$a$a, reason: collision with other inner class name */
        public static final class C2035a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127017a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbsPanel<?> f127018b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List<AbsPanel<?>> f127019c;

            public C2035a() {
                throw null;
            }

            public C2035a(AbsPanel r100, AbsPanel r101, List r102) {
                Intrinsics.checkNotNullParameter(r100, "curPanel");
                Intrinsics.checkNotNullParameter(r102, "buffPanelList");
                this.f127017a = r100;
                this.f127018b = r101;
                this.f127019c = r102;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127020a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f127021b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f127022c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final DIYCardSelectType f127023d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final n f127024e;

            public b(AbsPanel r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, "curPanel");
                Intrinsics.checkNotNullParameter(null, "selectType");
                this.f127020a = r100;
                this.f127021b = r101;
                this.f127022c = false;
                this.f127023d = null;
                this.f127024e = null;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127025a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f127026b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f127027c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final p2 f127028d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final int f127029e;

            public c(AbsPanel<?> r100, int r101, int r102, p2 r103, int r104) {
                Intrinsics.checkNotNullParameter(r100, "curPanel");
                this.f127025a = r100;
                this.f127026b = r101;
                this.f127027c = r102;
                this.f127028d = r103;
                this.f127029e = r104;
            }
        }

        public static final class d extends a {
            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127030a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f127031b;

            public e(AbsPanel<?> r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, "curPanel");
                this.f127030a = r100;
                this.f127031b = r101;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127032a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f127033b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f127034c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final p2 f127035d;

            public f() {
                throw null;
            }

            public f(int r100, int r101) {
                Intrinsics.checkNotNullParameter(null, "curPanel");
                this.f127032a = null;
                this.f127033b = r100;
                this.f127034c = r101;
                this.f127035d = null;
            }
        }

        public static final class g extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AbsPanel<?> f127036a;

            public g(AbsPanel<?> r100) {
                Intrinsics.checkNotNullParameter(r100, "curPanel");
                this.f127036a = r100;
            }
        }

        public static final class h extends a {
            public h() {
            }
        }

        public a() {
        }

        public final AbsPanel<?> a() {
            if ((this instanceof e) == false) goto L7;
            return ((e) this).f127030a;
        L7:
            if ((this instanceof g) == false) goto L11;
            return ((g) this).f127036a;
        L11:
            if ((this instanceof c) == false) goto L15;
            return ((c) this).f127025a;
        L15:
            if ((this instanceof f) == false) goto L19;
            return ((f) this).f127032a;
        L19:
            if ((this instanceof C2035a) == false) goto L23;
            return ((C2035a) this).f127017a;
        L23:
            if ((this instanceof b) == true) goto L25;
            return null;
        L25:
            return ((b) this).f127020a;
        }

        public final AbsPanel<?> b() {
            if ((this instanceof e) == false) goto L7;
            return ((e) this).f127030a;
        L7:
            if ((this instanceof g) == false) goto L11;
            return ((g) this).f127036a;
        L11:
            if ((this instanceof c) == false) goto L15;
            return ((c) this).f127025a;
        L15:
            if ((this instanceof f) == false) goto L19;
            return ((f) this).f127032a;
        L19:
            if ((this instanceof C2035a) == false) goto L25;
            C2035a r100 = (C2035a) this;
            AbsPanel<?> r101 = r100.f127018b;
            if (r101 == null) goto L23;
            return r101;
        L23:
            return r100.f127017a;
        L25:
            if ((this instanceof b) == true) goto L27;
            return null;
        L27:
            return ((b) this).f127020a;
        }

        public final String c() {
            if ((this instanceof d) == false) goto L6;
            return "Dismiss";
        L6:
            if ((this instanceof h) == false) goto L9;
            return "IdleOpen";
        L9:
            if ((this instanceof e) == false) goto L12;
            StringBuilder r100 = new StringBuilder("GiftSelected:");
            e r101 = (e) this;
            r100.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r101.f127030a.c())), TuplesKt.to("selectType", r101.f127030a.f126616d)}).toString());
            return r100.toString();
        L12:
            if ((this instanceof C2035a) == false) goto L22;
            StringBuilder r102 = new StringBuilder("BuffSelected:");
            Pair[] r103 = new Pair[5];
            C2035a r110 = (C2035a) this;
            r103[0] = TuplesKt.to("panelId", Long.valueOf(r110.f127017a.c()));
            r103[1] = TuplesKt.to("selectType", r110.f127017a.f126616d);
            AbsPanel<?> r104 = r110.f127018b;
            Integer r105 = null;
            if (r104 == null) goto L16;
            Long r106 = Long.valueOf(r104.c());
        L17:
            r103[2] = TuplesKt.to("buffPanelId", r106);
            if (r110.f127018b == null) goto L20;
            r105 = 0;
        L20:
            r103[3] = TuplesKt.to("buffLevel", r105);
            r103[4] = TuplesKt.to("buffListSize", Integer.valueOf(r110.f127019c.size()));
            r102.append(MapsKt.mapOf(r103).toString());
            return r102.toString();
        L16:
            r106 = null;
            goto L17
        L22:
            if ((this instanceof c) == false) goto L25;
            StringBuilder r107 = new StringBuilder("DialogGiftCombo:");
            c r111 = (c) this;
            r107.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r111.f127025a.c())), TuplesKt.to("comboNum", Integer.valueOf(r111.f127026b)), TuplesKt.to("sendNum", Integer.valueOf(r111.f127027c)), TuplesKt.to("buffLevel", Integer.valueOf(r111.f127029e))}).toString());
            return r107.toString();
        L25:
            if ((this instanceof g) == false) goto L28;
            return "GroupSelected:" + MapsKt.mapOf(TuplesKt.to("panelId", Long.valueOf(((g) this).f127036a.c()))).toString();
        L28:
            if ((this instanceof f) == false) goto L31;
            StringBuilder r108 = new StringBuilder("GroupCombo:");
            f r109 = (f) this;
            r108.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r109.f127032a.c())), TuplesKt.to("comboNum", Integer.valueOf(r109.f127033b)), TuplesKt.to("sendNum", Integer.valueOf(r109.f127034c))}).toString());
            return r108.toString();
        L31:
            if ((this instanceof b) == false) goto L35;
            StringBuilder r112 = new StringBuilder("DIYSelected:");
            b r113 = (b) this;
            r112.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r113.f127020a.c())), TuplesKt.to("curIndex", Integer.valueOf(r113.f127021b)), TuplesKt.to("needAnim", Boolean.valueOf(r113.f127022c))}).toString());
            return r112.toString();
        L35:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b implements g {

        public static final class a extends b {
            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$b$b, reason: collision with other inner class name */
        public static final class C2036b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Map<String, g0> f127037a;

            /* JADX WARN: Multi-variable type inference failed */
            public C2036b(Map<String, ? extends g0> r100) {
                Intrinsics.checkNotNullParameter(r100, "giftExtrasMap");
                this.f127037a = r100;
            }
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<w1> f127038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<w1, Map<Integer, List<AbsPanel<?>>>> f127039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<pz1.e> f127040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<List<AbsPanel<?>>> f127041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<Integer, Integer> f127042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f127043f;

        public c() {
            this(null, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L18;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f127038a, r101.f127038a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f127039b, r101.f127039b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f127040c, r101.f127040c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f127041d, r101.f127041d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f127042e, r101.f127042e) == true) goto L16;
            return false;
        L16:
            if (this.f127043f == r101.f127043f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            List<w1> r100 = this.f127038a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r104 = this.f127039b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<pz1.e> r107 = this.f127040c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            List<List<AbsPanel<?>>> r110 = this.f127041d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Map<Integer, Integer> r113 = this.f127042e;
            if (r113 == null) goto L21;
            r101 = r113.hashCode();
        L21:
            int r114 = (r112 + r101) * 31;
            boolean r115 = this.f127043f;
            ?? r116 = r115;
            if (r115 == false) goto L25;
            r116 = 1;
        L25:
            return r114 + r116;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "GiftListData(giftPages=" + this.f127038a + ", mGiftPanelMap=" + this.f127039b + ", propPanels=" + this.f127040c + ", mGiftAllList=" + this.f127041d + ", tabToPageMap=" + this.f127042e + ", isSend=" + this.f127043f + ")";
        }

        public /* synthetic */ c(List r110, int r111) {
            HashMap r100 = null;
            if ((r111 & 1) == 0) goto L5;
            ArrayList r101 = new ArrayList();
        L7:
            if ((r111 & 2) == 0) goto L9;
            HashMap r102 = new HashMap();
        L11:
            if ((r111 & 4) == 0) goto L13;
            List r103 = null;
        L15:
            if ((r111 & 8) == 0) goto L17;
            ArrayList r104 = new ArrayList();
        L19:
            if ((r111 & 16) == 0) goto L21;
            r100 = new HashMap();
        L21:
            this(r101, r102, r103, r104, r100, false);
            return;
        L17:
            r104 = null;
            goto L19
        L13:
            r103 = r110;
            goto L15
        L9:
            r102 = null;
            goto L11
        L5:
            r101 = null;
            goto L7
        }

        public static c a(c r100, List r101, List r102, boolean r110, int r111) {
            if ((r111 & 1) == 0) goto L5;
            r101 = r100.f127038a;
        L5:
            List r103 = r101;
            if ((r111 & 2) == 0) goto L8;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r104 = r100.f127039b;
        L10:
            if ((r111 & 4) == 0) goto L12;
            r102 = r100.f127040c;
        L12:
            List r105 = r102;
            if ((r111 & 8) == 0) goto L15;
            List<List<AbsPanel<?>>> r106 = r100.f127041d;
        L17:
            if ((r111 & 16) == 0) goto L19;
            Map<Integer, Integer> r107 = r100.f127042e;
        L21:
            if ((r111 & 32) == 0) goto L23;
            r110 = r100.f127043f;
        L23:
            Intrinsics.checkNotNullParameter(r103, "giftPages");
            Intrinsics.checkNotNullParameter(r104, "mGiftPanelMap");
            Intrinsics.checkNotNullParameter(r106, "mGiftAllList");
            Intrinsics.checkNotNullParameter(r107, "tabToPageMap");
            return new c(r103, r104, r105, r106, r107, r110);
        L19:
            r107 = null;
            goto L21
        L15:
            r106 = null;
            goto L17
        L8:
            r104 = null;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends w1> r100, Map<w1, Map<Integer, List<AbsPanel<?>>>> r101, List<? extends pz1.e> r102, List<List<AbsPanel<?>>> r103, Map<Integer, Integer> r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r100, "giftPages");
            Intrinsics.checkNotNullParameter(r101, "mGiftPanelMap");
            Intrinsics.checkNotNullParameter(r103, "mGiftAllList");
            Intrinsics.checkNotNullParameter(r104, "tabToPageMap");
            this.f127038a = r100;
            this.f127039b = r101;
            this.f127040c = r102;
            this.f127041d = r103;
            this.f127042e = r104;
            this.f127043f = r105;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<IBaseUser> f127044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w0 f127045b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f127044a, r101.f127044a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f127045b, r101.f127045b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<IBaseUser> r100 = this.f127044a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            w0 r104 = this.f127045b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "GiftReceiverListData(userList=" + this.f127044a + ", groupShowInfo=" + this.f127045b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends IBaseUser> r100, w0 r101) {
            Intrinsics.checkNotNullParameter(r100, "userList");
            this.f127044a = r100;
            this.f127045b = r101;
        }
    }

    public static abstract class e implements g {

        public static final class a extends e {
            public a() {
            }
        }

        public static final class b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f127046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f127047b;

            public b(c r100, boolean r101) {
                this.f127046a = r100;
                this.f127047b = r101;
            }
        }

        public static final class c extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f127048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f127049b;

            public c(c r100, boolean r101) {
                this.f127048a = r100;
                this.f127049b = r101;
            }
        }

        public e() {
        }

        public final List<w1> a() {
            if ((this instanceof c) == false) goto L9;
            c r100 = ((c) this).f127048a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f127038a;
        L9:
            if ((this instanceof b) == false) goto L15;
            c r101 = ((b) this).f127046a;
            if (r101 != null) goto L13;
            return null;
        L13:
            return r101.f127038a;
        L15:
            return null;
        }

        public final Map<w1, Map<Integer, List<AbsPanel<?>>>> b() {
            if ((this instanceof c) == false) goto L8;
            c r100 = ((c) this).f127048a;
            if (r100 == null) goto L12;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r101 = r100.f127039b;
        L13:
            if (r101 == null) goto L15;
            return r101;
        L15:
            return new LinkedHashMap();
        L12:
            r101 = null;
            goto L13
        L8:
            if ((this instanceof b) == false) goto L12;
            c r102 = ((b) this).f127046a;
            if (r102 == null) goto L12;
            r101 = r102.f127039b;
            goto L13
        }

        public final List<pz1.e> c() {
            List<pz1.e> r100 = null;
            if ((this instanceof c) == false) goto L8;
            c r101 = ((c) this).f127048a;
            if (r101 == null) goto L12;
            r100 = r101.f127040c;
        L12:
            if (r100 == null) goto L14;
            return r100;
        L14:
            return CollectionsKt.emptyList();
        L8:
            if ((this instanceof b) == false) goto L12;
            c r102 = ((b) this).f127046a;
            if (r102 == null) goto L12;
            r100 = r102.f127040c;
            goto L12
        }

        public final String d() {
            if ((this instanceof a) == false) goto L6;
            return "IDLE";
        L6:
            if ((this instanceof c) == false) goto L9;
            return "OnSyncList:";
        L9:
            if ((this instanceof b) == false) goto L13;
            return "OnSyncFinish";
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class f {

        public static final class a extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f127050a;

            public a(boolean r100) {
                this.f127050a = r100;
            }
        }

        public static final class b extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f127051a = null;

            static {
                f127051a = new b();
            }

            public b() {
            }
        }

        public static final class c extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f127052a = null;

            static {
                f127052a = new c();
            }

            public c() {
            }
        }

        public static final class d extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f127053a = null;

            static {
                f127053a = new d();
            }

            public d() {
            }
        }

        public static final class e extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f127054a = null;

            static {
                f127054a = new e();
            }

            public e() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$f$f, reason: collision with other inner class name */
        public static final class C2050f extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f127055a;

            public C2050f(boolean r100) {
                this.f127055a = r100;
            }
        }

        public f() {
        }
    }

    public interface g {
    }

    public static abstract class h implements g {

        public static final class a extends h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f127056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f127057b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Map<Integer, Integer> f127058c;

            public a(int r100, boolean r101, Map r102) {
                Intrinsics.checkNotNullParameter(r102, "orderRule");
                this.f127056a = r100;
                this.f127057b = r101;
                this.f127058c = r102;
            }
        }

        public h() {
        }

        public final String b() {
            if ((this instanceof a) == false) goto L7;
            StringBuilder r100 = new StringBuilder("TAB:");
            a r101 = (a) this;
            r100.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("currentTab", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r101.f127056a)), TuplesKt.to("isDefault", Boolean.valueOf(r101.f127057b))}));
            return r100.toString();
        L7:
            throw new NoWhenBranchMatchedException();
        }

        public final int a(int r100) {
            Integer r101 = ((a) this).f127058c.get(Integer.valueOf(r100));
            if (r101 != null) goto L7;
            return 0;
        L7:
            return r101.intValue();
        }
    }

    public GiftStateMachineConfig() {
    }

    static {
    }

    public static StateMachine a(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<a, Event, f>, Unit> r102 = new GiftStateMachineConfig$createDialogStateMachine$1(r100);
        r101.getClass();
        return StateMachine.a.a(r102);
    }

    public static StateMachine b(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<e, Event, f>, Unit> r102 = new GiftStateMachineConfig$createListStateMachine$1(r100);
        r101.getClass();
        return StateMachine.a.a(r102);
    }

    public static StateMachine c(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<h, Event, f>, Unit> r102 = new GiftStateMachineConfig$createTabStateMachine$1(r100);
        r101.getClass();
        return StateMachine.a.a(r102);
    }
}
