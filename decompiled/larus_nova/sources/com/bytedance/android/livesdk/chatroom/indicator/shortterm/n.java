package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.a1;
import com.bytedance.android.live.core.setting.b1;
import com.bytedance.android.live.core.setting.d1;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.ITempShortTermManager;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements ITempShortTermManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IIconModel<?> f106654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f106656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f106657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f106658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f106659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> f106660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<Integer, ShortTermIndicatorConfig.TempStateCondition> f106661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f106662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ShortTermIndicatorManager f106663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<Integer, IIconModel<?>> f106664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f106665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<Integer, Map<Integer, Long>> f106666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<Integer, ArrayList<c>> f106667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f106668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o f106669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p f106670q;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIconModel<?> f106671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f106672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f106673c;

        public b(IIconModel r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "iconModel");
            this.f106671a = r100;
            this.f106672b = r101;
            this.f106673c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f106674a;

        public c(long r100) {
            this.f106674a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void initTempState() {
        Boolean r100 = null;
        com.bytedance.android.livesdk.chatroom.o r101 = z51.a.h(null, 3);
        if (r101 == null) goto L25;
        com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L26;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L27;
        ShortTermIndicatorConfig r104 = r103.getShortTermIndicatorConfig();
        if (r104 == null) goto L11;
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> r105 = r104.getTempStateStrategyMap();
    L12:
        this.f106660g = r105;
        ShortTermIndicatorConfig r106 = r103.getShortTermIndicatorConfig();
        if (r106 == null) goto L15;
        Map<Integer, ShortTermIndicatorConfig.TempStateCondition> r107 = r106.getTempStateConditionMap();
    L16:
        this.f106661h = r107;
        ShortTermIndicatorConfig r108 = r103.getShortTermIndicatorConfig();
        if (r108 == null) goto L19;
        List<String> r109 = r108.getStrategyFeatWhitelist();
    L20:
        this.f106662i = r109;
        IRoomAuthStatus r110 = r103.getRoomAuthStatus();
        if (r110 == null) goto L23;
        r100 = Boolean.valueOf(r110.enableTempShortTouch());
    L23:
        this.f106668o = r100.booleanValue();
        return;
    L19:
        r109 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L11:
        r105 = null;
        goto L12
    L27:
        return;
    L26:
        return;
    }

    public final void c() {
        if (this.f106668o == true) goto L6;
        return;
    L6:
        if (d(1) == true) goto L10;
        ALogger.i("TempShortTermManager", "setting not enable");
        return;
    L10:
        if (this.f106654a == null) goto L12;
    L34:
        ALogger.i("TempShortTermManager", " checkSinglePlay,hava temp shorttouch");
        return;
    L12:
        if (this.f106658e != null) goto L34;
        ShortTermIndicatorManager r100 = this.f106663j;
        if (r100 == null) goto L32;
        List<ShortTermIcon> r101 = r100.getIcons();
        if (r101 == null) goto L32;
        if (r101.size() != 1) goto L32;
        ALogger.i("TempShortTermManager", "icons size is 1");
        ShortTermIndicatorManager r102 = this.f106663j;
        if (r102 == null) goto L36;
        List<ShortTermIcon> r103 = r102.getIcons();
        if (r103 == null) goto L37;
        ShortTermIcon r104 = (ShortTermIcon) ListProtector.get(r103, 0);
        if (r104 == null) goto L38;
        IIconModel<?> r105 = this.f106664k.get(Integer.valueOf(r104.getTypeId()));
        if (r105 != null) goto L29;
        return;
    L29:
        if (a(r104.getTypeId(), 1) == false) goto L31;
        k(r105, 1, 0);
        ALogger.i("TempShortTermManager", "STRATEGY_SINGLE occurred,current typeId is " + r104.getTypeId());
        return;
    L31:
        ALogger.i("TempShortTermManager", "STRATEGY_SINGLE cant occurred,current typeId is " + r104.getTypeId());
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L32:
        ALogger.i("TempShortTermManager", " current icons size is not 1");
    }

    public final boolean i() {
        ShortTermIndicatorManager r100 = this.f106663j;
        Object r101 = null;
        if (r100 == null) goto L13;
        List<ShortTermIcon> r102 = r100.getIcons();
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (((ShortTermIcon) r104).isEnhancedTouch() == false) goto L8;
        r101 = r104;
    L12:
        r101 = (ShortTermIcon) r101;
    L13:
        if (r101 == null) goto L15;
        ALogger.i("TempShortTermManager", "temp icon suppressed by enhanced style icon: " + r101);
    L15:
        if (r101 == null) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void interruptCurrentTempState() {
        IIconModel<?> r100 = this.f106654a;
        if (r100 == null) goto L17;
        r100.onHideTempState();
        b(r100.getTypeId(), -1);
        ShortTermIndicatorManager r101 = this.f106663j;
        if (r101 == null) goto L14;
        List<ShortTermIcon> r102 = r101.getIcons();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        ShortTermIcon r104 = (ShortTermIcon) r103.next();
        if (r104.getTypeId() != r100.getTypeId()) goto L10;
        ViewGroup.LayoutParams r105 = r104.getView().getLayoutParams();
        r105.width = r100.getIconWidth();
        j(r104.getView());
    L14:
        ShortTermIndicatorManager r106 = this.f106663j;
        if (r106 == null) goto L17;
        r106.refresh();
    L17:
        this.f106654a = null;
        this.f106656c = null;
        this.f106655b = 1000;
        this.f106659f = 0;
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void onIconRefresh() {
        this.f106665l.removeCallbacks(this.f106670q);
        this.f106665l.postDelayed(this.f106670q, 2000);
    }

    public final void h() {
        interruptCurrentTempState();
        b r100 = this.f106658e;
        if (r100 == null) goto L7;
        k(r100.f106671a, r100.f106672b, r100.f106673c);
        this.f106658e = null;
        return;
    }

    public n(MiddlewareRoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        this.f106655b = 1000;
        this.f106664k = new HashMap();
        this.f106665l = new Handler(Looper.getMainLooper());
        this.f106666m = new HashMap();
        this.f106667n = new HashMap();
        this.f106668o = true;
        initTempState();
        r r101 = z51.a.d(r100);
        Object r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.j<? extends Object> r103 = r101.D();
        if (r103 == null) goto L7;
        Object r104 = r103.getValue();
    L9:
        if ((r104 instanceof ShortTermIndicatorManager) == false) goto L12;
        r102 = r104;
    L12:
        this.f106663j = (ShortTermIndicatorManager) r102;
        this.f106669p = new o(this);
        this.f106670q = new p(this);
        return;
    L7:
        r104 = null;
        goto L9
    }

    public static boolean d(int r100) {
        return d1.f65278a.getValue().contains(Integer.valueOf(r100));
    }

    public static void j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L5;
        int r102 = r101.width;
    L6:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L9;
        int r104 = r103.height;
    L10:
        r100.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(UtilityKotlinExtentionsKt.i(36), Integer.MIN_VALUE), 0, r102), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(UtilityKotlinExtentionsKt.i(36), Integer.MIN_VALUE), 0, r104));
        return;
    L9:
        r104 = UtilityKotlinExtentionsKt.i(36);
        goto L10
    L5:
        r102 = UtilityKotlinExtentionsKt.i(36);
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void addTempIconModel(IIconModel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        this.f106664k.put(Integer.valueOf(r100.getTypeId()), r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void onIconDestroy(IIconModel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        this.f106664k.remove(Integer.valueOf(r100.getTypeId()));
        if (Intrinsics.areEqual(r100, this.f106654a) == false) goto L5;
        h();
    L5:
        c();
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void showNormalState(IIconModel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        if (Intrinsics.areEqual(r100, this.f106654a) == false) goto L5;
        this.f106665l.removeCallbacks(this.f106669p);
        this.f106665l.postDelayed(this.f106669p, 0);
    L5:
        b r101 = this.f106658e;
        if (r101 == null) goto L8;
        IIconModel<?> r102 = r101.f106671a;
    L10:
        if (Intrinsics.areEqual(r100, r102) == false) goto L13;
        this.f106658e = null;
        return;
    L13:
        return;
    L8:
        r102 = null;
        goto L10
    }

    public final boolean a(int r110, int r111) {
        if (i() == false) goto L5;
        return false;
    L5:
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> r100 = this.f106660g;
        if (r100 != null) goto L8;
    L36:
        ALogger.i("TempShortTermManager", "typId " + r110 + " ,strategy " + r111 + ", not register on server platform");
        return false;
    L8:
        if (this.f106661h == null) goto L36;
        if (r100 == null) goto L35;
        ShortTermIndicatorConfig.TempStateStrategy r101 = r100.get(Integer.valueOf(r110));
        if (r101 == null) goto L35;
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo> r102 = r101.getStrategyMap();
        if (r102 == null) goto L35;
        if (r102.get(Integer.valueOf(r111)) == null) goto L35;
        Map<Integer, ShortTermIndicatorConfig.TempStateCondition> r103 = this.f106661h;
        if (r103 == null) goto L35;
        ShortTermIndicatorConfig.TempStateCondition r104 = r103.get(Integer.valueOf(r111));
        if (r104 == null) goto L35;
        Map<Integer, Long> r105 = this.f106666m.get(Integer.valueOf(r110));
        if (r105 == null) goto L28;
        Long r106 = r105.get(Integer.valueOf(r111));
        if (r106 == null) goto L28;
        long r107 = r106.longValue();
    L30:
        if ((System.currentTimeMillis() - r107) > (r104.getMinimumGap() * 1000)) goto L34;
        ALogger.i("TempShortTermManager", "typId " + r110 + " ,strategy " + r111 + ",match the minimumGap");
        return false;
    L34:
        return e(r110, r111);
    L28:
        r107 = 0;
    L35:
        return false;
    }

    public final void b(int r100, int r101) {
        ShortTermIndicatorManager r102 = this.f106663j;
        if (r102 == null) goto L9;
        ShortTermIndicatorConfig r103 = new ShortTermIndicatorConfig();
        r103.setElements(new HashMap());
        Map<Integer, ShortTermIndicatorConfig.Element> r104 = r103.getElements();
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(r100);
        ShortTermIndicatorConfig.Element r106 = new ShortTermIndicatorConfig.Element();
        r106.setType(r100);
        r106.setPriority(r101);
        Unit r107 = Unit.INSTANCE;
        r104.put(r105, r106);
    L7:
        Unit r108 = Unit.INSTANCE;
        r102.config(r103);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final void changeTempWidth(IIconModel<?> r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "iconModel");
        Intrinsics.checkNotNullParameter(r111, "view");
        ALogger.i("TempShortTermManager", "changeTempWidth, typeId is " + r110.getTypeId());
        b r100 = this.f106657d;
        ShortTermIcon r101 = null;
        if (r100 == null) goto L5;
        IIconModel<?> r102 = r100.f106671a;
    L7:
        if (Intrinsics.areEqual(r110, r102) == false) goto L46;
        r111.getLayoutParams().width = UtilityKotlinExtentionsKt.i(104);
        j(r111);
        b r112 = this.f106657d;
        if (r112 == null) goto L53;
        int r103 = r112.f106672b;
        long r104 = r112.f106673c;
        this.f106654a = r110;
        this.f106655b = f(r110.getTypeId(), r103);
        this.f106656c = Integer.valueOf(r103);
        this.f106659f = System.currentTimeMillis();
        int r113 = r110.getTypeId();
        long r105 = this.f106659f;
        if (this.f106666m.get(Integer.valueOf(r113)) != null) goto L13;
        this.f106666m.put(Integer.valueOf(r113), new HashMap());
    L13:
        Map<Integer, Long> r114 = this.f106666m.get(Integer.valueOf(r113));
        if (r114 == null) goto L16;
        Long r115 = r114.put(Integer.valueOf(r103), Long.valueOf(r105));
    L16:
        b(r110.getTypeId(), -2);
        ShortTermIndicatorManager r116 = this.f106663j;
        if (r116 == null) goto L26;
        List<ShortTermIcon> r117 = r116.getCurrentIconState();
        if (r117 == null) goto L26;
        Iterator<T> r118 = r117.iterator();
    L22:
        if (r118.hasNext() == false) goto L26;
        ShortTermIcon r106 = (ShortTermIcon) r118.next();
        if (r106.getTypeId() != r110.getTypeId()) goto L22;
        r101 = r106;
    L26:
        if (r101 == null) goto L32;
        ShortTermIndicatorManager r119 = this.f106663j;
        if (r119 == null) goto L32;
        List<ShortTermIcon> r120 = r119.getCurrentIconState();
        if (r120 == null) goto L32;
        r120.remove(r101);
        ListProtector.add(r120, 0, r101);
    L32:
        ShortTermIndicatorManager r121 = this.f106663j;
        if (r121 == null) goto L35;
        r121.refresh();
    L35:
        ALogger.i("TempShortTermManager", "temp short touch shows, typeId is " + r110.getTypeId());
        long r122 = g(r110.getTypeId(), r103);
        if (r122 <= 0) goto L41;
        if (r104 <= 0) goto L45;
        r122 = RangesKt.coerceAtMost(r122, r104);
    L45:
        this.f106665l.removeCallbacks(this.f106669p);
        this.f106665l.postDelayed(this.f106669p, r122);
        return;
    L41:
        if (r104 > 0) goto L44;
        r104 = 10000;
    L44:
        r122 = r104;
        goto L45
    L53:
        return;
    L46:
        ALogger.i("TempShortTermManager", "iconModel not same");
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final boolean e(int r110, int r111) {
        if (b1.f65216a.getValue().booleanValue() == true) goto L5;
        return true;
    L5:
        if (this.f106667n.get(Integer.valueOf(r110)) != null) goto L8;
        ArrayList<c> r112 = new ArrayList();
        r112.add(new c(System.currentTimeMillis()));
        this.f106667n.put(Integer.valueOf(r110), r112);
        return true;
    L8:
        ArrayList r113 = null;
        com.bytedance.android.livesdk.chatroom.o r100 = z51.a.h(null, 3);
        if (r100 == null) goto L56;
        com.bytedance.live.datacontext.m<IRoom> r101 = r100.getRoom();
        if (r101 == null) goto L56;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L56;
        ShortTermIndicatorConfig r103 = r102.getShortTermIndicatorConfig();
        if (r103 == null) goto L19;
        ShortTermIndicatorConfig.TempStateGlobalCondition r104 = r103.getTempStateGlobalCondition();
        if (r104 == null) goto L19;
        int r105 = r104.getAllowCount();
    L20:
        ShortTermIndicatorConfig r106 = r102.getShortTermIndicatorConfig();
        if (r106 == null) goto L25;
        ShortTermIndicatorConfig.TempStateGlobalCondition r107 = r106.getTempStateGlobalCondition();
        if (r107 == null) goto L25;
        int r108 = r107.getDurationGap();
    L26:
        ArrayList<c> r109 = this.f106667n.get(Integer.valueOf(r110));
        if (r109 == null) goto L37;
        r113 = new ArrayList();
        Iterator<T> r114 = r109.iterator();
    L30:
        if (r114.hasNext() == false) goto L37;
        Object r115 = r114.next();
        if ((System.currentTimeMillis() - ((c) r115).f106674a) >= (r108 * 1000)) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L30;
        r113.add(r115);
        goto L30
    L34:
        r116 = false;
    L37:
        if (r113 == null) goto L39;
        this.f106667n.put(Integer.valueOf(r110), (ArrayList<c>) r113);
    L39:
        if (r105 <= 0) goto L55;
        ArrayList<c> r117 = this.f106667n.get(Integer.valueOf(r110));
        if (r117 == null) goto L43;
        int r118 = r117.size();
    L45:
        if (r118 < r105) goto L49;
        ALogger.i("TempShortTermManager", "超额，不展示此次临态");
        return false;
    L49:
        if (this.f106667n.get(Integer.valueOf(r110)) != null) goto L51;
        this.f106667n.put(Integer.valueOf(r110), new ArrayList());
    L51:
        c r119 = new c(System.currentTimeMillis());
        ArrayList<c> r120 = this.f106667n.get(Integer.valueOf(r110));
        if (r120 == null) goto L54;
        r120.add(r119);
    L54:
        ALogger.i("TempShortTermManager", "频控通过，展示此次临态");
        goto L55
    L43:
        r118 = 0;
    L55:
        return true;
    L25:
        r108 = 0;
    L19:
        r105 = 0;
    L56:
        return false;
    }

    public final int f(int r100, int r101) {
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> r102 = this.f106660g;
        if (r102 == null) goto L13;
        ShortTermIndicatorConfig.TempStateStrategy r103 = r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L13;
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo> r104 = r103.getStrategyMap();
        if (r104 == null) goto L13;
        ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo r105 = r104.get(Integer.valueOf(r101));
        if (r105 == null) goto L13;
        ShortTermIndicatorConfig.TempStateType r106 = r105.getType();
        if (r106 == null) goto L13;
        return r106.getPriority();
    L13:
        return 1000;
    }

    public final long g(int r100, int r101) {
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> r102 = this.f106660g;
        if (r102 == null) goto L11;
        ShortTermIndicatorConfig.TempStateStrategy r103 = r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L11;
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo> r104 = r103.getStrategyMap();
        if (r104 == null) goto L11;
        ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo r105 = r104.get(Integer.valueOf(r101));
        if (r105 == null) goto L11;
        long r106 = r105.getDuration();
    L13:
        return r106 * ((long) 1000);
    L11:
        r106 = 5;
        goto L13
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final long getTempShortTouchShowTime(IIconModel<?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        return g(r100.getTypeId(), r101);
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo hasStrategyType(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy> r102 = this.f106660g;
        if (r102 == null) goto L21;
        Intrinsics.checkNotNull(r102);
        ShortTermIndicatorConfig.TempStateStrategy r103 = r102.get(Integer.valueOf(r101));
        if (r103 == null) goto L21;
        Map<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo> r104 = r103.getStrategyMap();
        if (r104 == null) goto L21;
        Iterator<Map.Entry<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo>> r105 = r104.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L21;
        Map.Entry<Integer, ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo> r106 = r105.next();
        if (TextUtils.isEmpty(r100) == true) goto L10;
        ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo r107 = r106.getValue();
        if (r107 == null) goto L16;
        String r108 = r107.getStrategy();
    L18:
        if (TextUtils.equals(r100, r108) == false) goto L10;
        return r106.getValue();
    L16:
        r108 = null;
    L21:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.ITempShortTermManager
    public final int handleTempShortTerm(IIconModel<?> r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        if (this.f106668o == true) goto L7;
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,room auth not enable");
        return 0;
    L7:
        if (a1.f65203a.getValue().booleanValue() == false) goto L37;
        if (d(r101) == true) goto L13;
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ",not enable");
        return 0;
    L13:
        if (Intrinsics.areEqual(r100, this.f106654a) == false) goto L19;
        Integer r103 = this.f106656c;
        if (r103 == null) goto L19;
        if (r101 != r103.intValue()) goto L19;
    L29:
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ",alread has this strategy");
        return 0;
    L19:
        b r104 = this.f106658e;
        if (r104 == null) goto L22;
        IIconModel<?> r105 = r104.f106671a;
    L24:
        if (Intrinsics.areEqual(r100, r105) == false) goto L32;
        b r106 = this.f106658e;
        if (r106 == null) goto L32;
        if (r101 == r106.f106672b) goto L29;
    L32:
        if (a(r100.getTypeId(), r101) == true) goto L35;
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ",cant show");
        return 0;
    L35:
        e(r100.getTypeId(), r101);
        goto L37
    L22:
        r105 = null;
    L37:
        if (this.f106654a != null) goto L40;
        k(r100, r101, r102);
    L49:
        return 0;
    L40:
        if (f(r100.getTypeId(), r101) >= this.f106655b) goto L43;
        this.f106658e = new b(r100, r101, r102);
    L43:
        if (f(r100.getTypeId(), r101) >= this.f106655b) goto L48;
        long r107 = System.currentTimeMillis() - this.f106659f;
        long r108 = 5000;
        if (r107 < r108) goto L47;
        h();
        goto L49
    L47:
        this.f106665l.removeCallbacks(this.f106669p);
        this.f106665l.postDelayed(this.f106669p, r108 - r107);
        goto L49
    L48:
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ", priority not higher than " + this.f106656c);
        goto L49
    }

    public final void k(IIconModel<?> r100, int r101, long r102) {
        if (i() == false) goto L6;
        return;
    L6:
        if (d(r101) == true) goto L10;
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ",not enable");
        return;
    L10:
        if (this.f106664k.containsKey(Integer.valueOf(r100.getTypeId())) == true) goto L13;
        ALogger.i("TempShortTermManager", "typId " + r100.getTypeId() + " ,strategy " + r101 + ", not in currentShortTermMap");
        return;
    L13:
        f(r100.getTypeId(), r101);
        this.f106657d = new b(r100, r101, r102);
        r100.onShowTempState(r101);
    }
}
