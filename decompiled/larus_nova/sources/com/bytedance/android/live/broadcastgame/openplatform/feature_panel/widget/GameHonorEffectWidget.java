package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget;

import android.content.SharedPreferences;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.IGameHonorEffectWidget;
import com.bytedance.android.live.broadcastgame.opengame.utils.Sp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.ja;
import com.bytedance.android.livesdk.message.model.ka;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vlc.l;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/widget/GameHonorEffectWidget;", "Lcom/bytedance/android/live/broadcastgame/api/IGameHonorEffectWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameHonorEffectWidget extends IGameHonorEffectWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f61686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<c> f61687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f61688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f61689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, d> f61690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f61691f;

    public final class a implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zy0.b f61692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f61693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GameHonorEffectWidget f61694c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f61693b.removeAllViews();
            UtilityKotlinExtentionsKt.z(this.f61693b, false);
            this.f61692a = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.f61692a != null) goto L5;
            return true;
        L5:
            return false;
        }

        public a(GameHonorEffectWidget r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            this.f61694c = r100;
            this.f61693b = r101;
        }
    }

    public abstract class b implements d, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f61695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ja f61696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f61697c;

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c) this).b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget.d
        public final void stopPlay() {
            ((com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c) this).b();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            MainThreadPostUtils.d(this);
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget.d
        public final long getId() {
            return this.f61695a;
        }

        public b(long r100, ja r101, a r102) {
            Intrinsics.checkNotNullParameter(r101, "honorInfo");
            Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f61695a = r100;
            this.f61696b = r101;
            this.f61697c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ja f61698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f61699b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f61698a, r101.f61698a) == true) goto L8;
            return false;
        L8:
            if (this.f61699b == r101.f61699b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ja r100 = this.f61698a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.f61699b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "HonorInfoWrapper(info=" + this.f61698a + ", messageId=" + this.f61699b + ")";
        }

        public c(ja r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f61698a = r100;
            this.f61699b = r101;
        }
    }

    public interface d extends Disposable {
        long getId();

        void stopPlay();
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vlc.d f61700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GameHonorEffectWidget f61701b;

        public e(vlc.d r100, GameHonorEffectWidget r101) {
            this.f61700a = r100;
            this.f61701b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f61700a.removeMessageListener(this.f61701b);
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameHonorEffectWidget f61702a;

        public f(GameHonorEffectWidget r100) {
            this.f61702a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f61702a.wq();
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_open_platform_game_honor_effect_view;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final boolean isMergeMode() {
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ALogger.i("GameHonorEffectWidget", "unload widget");
        SharedPreferences r100 = (SharedPreferences) Sp.f61147a.getValue();
        Long r101 = Long.valueOf(this.f61691f);
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter("ttlive_open_platform_honor_prev_message", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        SharedPreferences.Editor r102 = r100.edit();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L11;
        boolean r103 = r101 instanceof String;
        Object r104 = r101;
        if (r103 == true) goto L7;
        r104 = null;
    L7:
        String r105 = (String) r104;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r102.putString("ttlive_open_platform_honor_prev_message", r105);
    L51:
        r102.apply();
        this.f61686a.clear();
        return;
    L11:
        int r106 = 0;
        boolean r107 = false;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L21;
        boolean r108 = r101 instanceof Boolean;
        Object r109 = r101;
        if (r108 == true) goto L16;
        r109 = null;
    L16:
        Boolean r110 = (Boolean) r109;
        if (r110 == null) goto L19;
        r107 = r110.booleanValue();
    L19:
        r102.putBoolean("ttlive_open_platform_honor_prev_message", r107);
        goto L51
    L21:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        boolean r111 = r101 instanceof Float;
        Object r112 = r101;
        if (r111 == true) goto L25;
        r112 = null;
    L25:
        Float r113 = (Float) r112;
        if (r113 == null) goto L28;
        float r114 = r113.floatValue();
    L29:
        r102.putFloat("ttlive_open_platform_honor_prev_message", r114);
        goto L51
    L28:
        r114 = 0.0f;
        goto L29
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L34;
        r102.putLong("ttlive_open_platform_honor_prev_message", r101.longValue());
        goto L51
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L43;
        boolean r115 = r101 instanceof Integer;
        Object r116 = r101;
        if (r115 == true) goto L38;
        r116 = null;
    L38:
        Integer r117 = (Integer) r116;
        if (r117 == null) goto L41;
        r106 = r117.intValue();
    L41:
        r102.putInt("ttlive_open_platform_honor_prev_message", r106);
        goto L51
    L43:
        if (Set.class.isAssignableFrom(r101.getClass()) == false) goto L51;
        boolean r118 = r101 instanceof Set;
        Object r119 = r101;
        if (r118 == true) goto L47;
        r119 = null;
    L47:
        Set<String> r120 = (Set) r119;
        if (r120 != null) goto L50;
        r120 = new HashSet();
    L50:
        r102.putStringSet("ttlive_open_platform_honor_prev_message", r120);
        goto L51
    }

    public final void wq() {
        ALogger.i("GameHonorEffectWidget", "clear resource");
        this.f61687b.clear();
        ((LinkedHashMap) this.f61690e).clear();
        a r100 = this.f61689d;
        if (r100 == null) goto L5;
        this.f61686a.remove(r100);
    L5:
        this.f61689d = null;
    }

    public final void xq() {
        if (isAlive() == true) goto L5;
        return;
    L5:
        c r100 = this.f61687b.peek();
        ALogger.i("GameHonorEffectWidget", "handle next message, next item " + r100);
        if (r100 == null) goto L8;
    L10:
        if (r100 != null) goto L12;
        return;
    L12:
        if ((!this.f61690e.isEmpty()) == true) goto L28;
        this.f61687b.poll();
        this.f61691f = r100.f61699b;
        ja r110 = r100.f61698a;
        long r111 = System.currentTimeMillis() / ((long) 1000);
        if ((((long) r110.getDuration()) + r111) > r110.getPlayEndTimestamp()) goto L17;
        boolean r101 = true;
    L18:
        ALogger.i("GameHonorEffectWidget", "play animation, can play " + r101);
        if (r101 == false) goto L24;
        Function1<d, Unit> r112 = new GameHonorEffectWidget$playAnimation$1(this);
        a r102 = this.f61689d;
        if (r102 != null) goto L23;
        ViewGroup r103 = this.f61688c;
        Intrinsics.checkNotNull(r103);
        r102 = new a(this, r103);
        this.f61689d = r102;
        RxUtilKt.c(r102, this.f61686a);
    L23:
        final com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c r104 = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c(r111, r112, r110, r111, r110, r102);
        RxUtilKt.c(r104, this.f61686a);
        this.f61690e.put(Long.valueOf(r104.f61695a), r104);
        a r105 = r104.f61697c;
        r105.getClass();
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.b r106 = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.b(r105);
        Map r107 = MapsKt.mapOf(new Pair[]{TuplesKt.to("honor_scene", Integer.valueOf(r104.f61696b.getHonorScene())), TuplesKt.to("container_payload", r104.f61696b.getBody()), TuplesKt.to("id", String.valueOf(r104.f61695a))});
        Intrinsics.checkNotNullParameter(r107, "data");
        RxUtilKt.n(Observable.create(new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.a(r106, r107)), new GameHonorEffectWidget$HonorAnimationPlaySession$startPlay$1(r104));
        return;
    L24:
        xq();
        return;
    L17:
        r101 = false;
        goto L18
    L28:
        return;
    L8:
        if (this.f61690e.isEmpty() == false) goto L10;
        wq();
        goto L10
    }

    public GameHonorEffectWidget() {
        this.f61686a = new CompositeDisposable();
        this.f61687b = new LinkedList();
        this.f61690e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f61688c = (ViewGroup) this.contentView.findViewById(R.id.lynx_container);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        ALogger.i("GameHonorEffectWidget", "load widget");
        SharedPreferences r100 = (SharedPreferences) Sp.f61147a.getValue();
        float r101 = 0.0f;
        int r111 = 0;
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        boolean r115 = false;
        int r116 = 0;
        boolean r117 = false;
        int r118 = 0;
        boolean r119 = false;
        int r120 = 0;
        boolean r121 = false;
        int r122 = 0;
        boolean r123 = false;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(String.class)) == true) goto L5;
        KClass r102 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r124 = Boolean.TYPE;
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(r124)) == false) goto L155;
        Boolean r103 = Boolean.FALSE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L95;
        boolean r104 = r103 instanceof String;
        Comparable r105 = r103;
        if (r104 == true) goto L86;
        r105 = null;
    L86:
        String r106 = (String) r105;
        String r125 = "";
        if (r106 == null) goto L90;
        r125 = r106;
    L90:
        Object r107 = r100.getString("ttlive_open_platform_honor_prev_message", r125);
        if ((r107 instanceof Boolean) == true) goto L93;
        r107 = null;
    L93:
        Object r108 = (Boolean) r107;
    L150:
        if ((r108 instanceof Long) == true) goto L152;
        r108 = null;
    L152:
        Long r109 = (Long) r108;
    L551:
        if (r109 == null) goto L553;
        long r126 = r109.longValue();
    L554:
        this.f61691f = r126;
        vlc.d r127 = (vlc.d) this.dataCenter.get("data_message_manager");
        if (r127 != null) goto L557;
    L564:
        RxUtilKt.c(RxUtilKt.n(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).B0("interactive_honor_close"), new AnonymousClass2(this)), this.f61686a);
        RxUtilKt.c(Disposables.fromAction(new f(this)), this.f61686a);
        return;
    L557:
        if ((r127 instanceof xlc.a) == true) goto L559;
        vlc.d r128 = null;
    L560:
        xlc.a r129 = (xlc.a) r128;
        if (r129 == null) goto L563;
        r129.y(MessageType.OPEN_PLATFORM_LIVE_PLAY_HONOR_MESSAGE.getIntType(), this);
    L563:
        RxUtilKt.c(Disposables.fromAction(new e(r127, this)), this.f61686a);
        goto L564
    L559:
        r128 = r127;
        goto L560
    L553:
        r126 = 0;
        goto L554
    L95:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L98;
        r108 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", false));
        goto L150
    L98:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L110;
        boolean r130 = r103 instanceof Float;
        Comparable r131 = r103;
        if (r130 == true) goto L102;
        r131 = null;
    L102:
        Float r132 = (Float) r131;
        if (r132 == null) goto L105;
        r101 = r132.floatValue();
    L105:
        Object r133 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r101));
        if ((r133 instanceof Boolean) == true) goto L108;
        r133 = null;
    L108:
        r108 = (Boolean) r133;
        goto L150
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        boolean r134 = r103 instanceof Long;
        Comparable r135 = r103;
        if (r134 == true) goto L114;
        r135 = null;
    L114:
        Long r136 = (Long) r135;
        if (r136 == null) goto L117;
        long r137 = r136.longValue();
    L118:
        Object r138 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r137));
        if ((r138 instanceof Boolean) == true) goto L121;
        r138 = null;
    L121:
        r108 = (Boolean) r138;
        goto L150
    L117:
        r137 = 0;
        goto L118
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L135;
        boolean r139 = r103 instanceof Integer;
        Comparable r140 = r103;
        if (r139 == true) goto L127;
        r140 = null;
    L127:
        Integer r141 = (Integer) r140;
        if (r141 == null) goto L130;
        r114 = r141.intValue();
    L130:
        Object r142 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r114));
        if ((r142 instanceof Boolean) == true) goto L133;
        r142 = null;
    L133:
        r108 = (Boolean) r142;
        goto L150
    L135:
        if (Set.class.isAssignableFrom(Boolean.class) == false) goto L146;
        boolean r143 = r103 instanceof Set;
        Comparable r144 = r103;
        if (r143 == true) goto L139;
        r144 = null;
    L139:
        Set<String> r145 = (Set) r144;
        if (r145 != null) goto L142;
        r145 = new HashSet();
    L142:
        Object r146 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r145);
        if ((r146 instanceof Boolean) == true) goto L145;
        r146 = null;
    L145:
        r108 = (Boolean) r146;
        goto L150
    L146:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Boolean.class));
        if (v.a() == true) goto L154;
        r108 = Boolean.class.newInstance();
        goto L150
    L154:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Boolean.class) + '}');
    L155:
        KClass r147 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r148 = Float.TYPE;
        if (Intrinsics.areEqual(r147, Reflection.getOrCreateKotlinClass(r148)) == false) goto L234;
        Float r149 = Float.valueOf(0.0f);
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L171;
        boolean r150 = r149 instanceof String;
        Object r151 = r149;
        if (r150 == true) goto L162;
        r151 = null;
    L162:
        String r152 = (String) r151;
        String r153 = "";
        if (r152 == null) goto L166;
        r153 = r152;
    L166:
        Object r154 = r100.getString("ttlive_open_platform_honor_prev_message", r153);
        if ((r154 instanceof Float) == true) goto L169;
        r154 = null;
    L169:
        Object r155 = (Float) r154;
    L229:
        if ((r155 instanceof Long) == true) goto L231;
        r155 = null;
    L231:
        r109 = (Long) r155;
        goto L551
    L171:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L183;
        boolean r156 = r149 instanceof Boolean;
        Object r157 = r149;
        if (r156 == true) goto L175;
        r157 = null;
    L175:
        Boolean r158 = (Boolean) r157;
        if (r158 == null) goto L178;
        r115 = r158.booleanValue();
    L178:
        Object r159 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r115));
        if ((r159 instanceof Float) == true) goto L181;
        r159 = null;
    L181:
        r155 = (Float) r159;
        goto L229
    L183:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(r148)) == false) goto L189;
        if (r149 == null) goto L186;
        float r160 = r149.floatValue();
    L187:
        r155 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r160));
        goto L229
    L186:
        r160 = 0.0f;
        goto L187
    L189:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L202;
        boolean r161 = r149 instanceof Long;
        Object r162 = r149;
        if (r161 == true) goto L193;
        r162 = null;
    L193:
        Long r163 = (Long) r162;
        if (r163 == null) goto L196;
        long r164 = r163.longValue();
    L197:
        Object r165 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r164));
        if ((r165 instanceof Float) == true) goto L200;
        r165 = null;
    L200:
        r155 = (Float) r165;
        goto L229
    L196:
        r164 = 0;
        goto L197
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L214;
        boolean r166 = r149 instanceof Integer;
        Object r167 = r149;
        if (r166 == true) goto L206;
        r167 = null;
    L206:
        Integer r168 = (Integer) r167;
        if (r168 == null) goto L209;
        r116 = r168.intValue();
    L209:
        Object r169 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r116));
        if ((r169 instanceof Float) == true) goto L212;
        r169 = null;
    L212:
        r155 = (Float) r169;
        goto L229
    L214:
        if (Set.class.isAssignableFrom(Float.class) == false) goto L225;
        boolean r170 = r149 instanceof Set;
        Object r171 = r149;
        if (r170 == true) goto L218;
        r171 = null;
    L218:
        Set<String> r172 = (Set) r171;
        if (r172 != null) goto L221;
        r172 = new HashSet();
    L221:
        Object r173 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r172);
        if ((r173 instanceof Float) == true) goto L224;
        r173 = null;
    L224:
        r155 = (Float) r173;
        goto L229
    L225:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Float.class));
        if (v.a() == true) goto L233;
        r155 = Float.class.newInstance();
        goto L229
    L233:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Float.class) + '}');
    L234:
        KClass r174 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r175 = Long.TYPE;
        if (Intrinsics.areEqual(r174, Reflection.getOrCreateKotlinClass(r175)) == false) goto L313;
        Long r176 = 0L;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L250;
        boolean r177 = r176 instanceof String;
        Object r178 = r176;
        if (r177 == true) goto L241;
        r178 = null;
    L241:
        String r179 = (String) r178;
        String r180 = "";
        if (r179 == null) goto L245;
        r180 = r179;
    L245:
        Object r181 = r100.getString("ttlive_open_platform_honor_prev_message", r180);
        if ((r181 instanceof Long) == true) goto L248;
        r181 = null;
    L248:
        Object r182 = (Long) r181;
    L308:
        if ((r182 instanceof Long) == true) goto L310;
        r182 = null;
    L310:
        r109 = (Long) r182;
        goto L551
    L250:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L262;
        boolean r183 = r176 instanceof Boolean;
        Object r184 = r176;
        if (r183 == true) goto L254;
        r184 = null;
    L254:
        Boolean r185 = (Boolean) r184;
        if (r185 == null) goto L257;
        r117 = r185.booleanValue();
    L257:
        Object r186 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r117));
        if ((r186 instanceof Long) == true) goto L260;
        r186 = null;
    L260:
        r182 = (Long) r186;
        goto L308
    L262:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r148)) == false) goto L275;
        boolean r187 = r176 instanceof Float;
        Object r188 = r176;
        if (r187 == true) goto L266;
        r188 = null;
    L266:
        Float r189 = (Float) r188;
        if (r189 == null) goto L269;
        float r190 = r189.floatValue();
    L270:
        Object r191 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r190));
        if ((r191 instanceof Long) == true) goto L273;
        r191 = null;
    L273:
        r182 = (Long) r191;
        goto L308
    L269:
        r190 = 0.0f;
        goto L270
    L275:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r175)) == false) goto L281;
        if (r176 == null) goto L278;
        long r192 = r176.longValue();
    L279:
        r182 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r192));
        goto L308
    L278:
        r192 = 0;
        goto L279
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L293;
        boolean r193 = r176 instanceof Integer;
        Object r194 = r176;
        if (r193 == true) goto L285;
        r194 = null;
    L285:
        Integer r195 = (Integer) r194;
        if (r195 == null) goto L288;
        r118 = r195.intValue();
    L288:
        Object r196 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r118));
        if ((r196 instanceof Long) == true) goto L291;
        r196 = null;
    L291:
        r182 = (Long) r196;
        goto L308
    L293:
        if (Set.class.isAssignableFrom(Long.class) == false) goto L304;
        boolean r197 = r176 instanceof Set;
        Object r198 = r176;
        if (r197 == true) goto L297;
        r198 = null;
    L297:
        Set<String> r199 = (Set) r198;
        if (r199 != null) goto L300;
        r199 = new HashSet();
    L300:
        Object r200 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r199);
        if ((r200 instanceof Long) == true) goto L303;
        r200 = null;
    L303:
        r182 = (Long) r200;
        goto L308
    L304:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Long.class));
        if (v.a() == true) goto L312;
        r182 = Long.class.newInstance();
        goto L308
    L312:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Long.class) + '}');
    L313:
        KClass r201 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r202 = Integer.TYPE;
        if (Intrinsics.areEqual(r201, Reflection.getOrCreateKotlinClass(r202)) == false) goto L392;
        Integer r203 = 0;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L329;
        boolean r204 = r203 instanceof String;
        Object r205 = r203;
        if (r204 == true) goto L320;
        r205 = null;
    L320:
        String r206 = (String) r205;
        String r1100 = "";
        if (r206 == null) goto L324;
        r1100 = r206;
    L324:
        Object r207 = r100.getString("ttlive_open_platform_honor_prev_message", r1100);
        if ((r207 instanceof Integer) == true) goto L327;
        r207 = null;
    L327:
        Object r208 = (Integer) r207;
    L387:
        if ((r208 instanceof Long) == false) goto L549;
    L550:
        r109 = (Long) r208;
    L549:
        r208 = null;
        goto L550
    L329:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L341;
        boolean r209 = r203 instanceof Boolean;
        Object r210 = r203;
        if (r209 == true) goto L333;
        r210 = null;
    L333:
        Boolean r211 = (Boolean) r210;
        if (r211 == null) goto L336;
        r119 = r211.booleanValue();
    L336:
        Object r212 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r119));
        if ((r212 instanceof Integer) == true) goto L339;
        r212 = null;
    L339:
        r208 = (Integer) r212;
        goto L387
    L341:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r148)) == false) goto L354;
        boolean r213 = r203 instanceof Float;
        Object r214 = r203;
        if (r213 == true) goto L345;
        r214 = null;
    L345:
        Float r215 = (Float) r214;
        if (r215 == null) goto L348;
        float r216 = r215.floatValue();
    L349:
        Object r217 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r216));
        if ((r217 instanceof Integer) == true) goto L352;
        r217 = null;
    L352:
        r208 = (Integer) r217;
        goto L387
    L348:
        r216 = 0.0f;
        goto L349
    L354:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r175)) == false) goto L367;
        boolean r218 = r203 instanceof Long;
        Object r219 = r203;
        if (r218 == true) goto L358;
        r219 = null;
    L358:
        Long r220 = (Long) r219;
        if (r220 == null) goto L361;
        long r221 = r220.longValue();
    L362:
        Object r222 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r221));
        if ((r222 instanceof Integer) == true) goto L365;
        r222 = null;
    L365:
        r208 = (Integer) r222;
        goto L387
    L361:
        r221 = 0;
        goto L362
    L367:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r202)) == false) goto L372;
        if (r203 == null) goto L370;
        r120 = r203.intValue();
    L370:
        r208 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r120));
        goto L387
    L372:
        if (Set.class.isAssignableFrom(Integer.class) == false) goto L383;
        boolean r223 = r203 instanceof Set;
        Object r224 = r203;
        if (r223 == true) goto L376;
        r224 = null;
    L376:
        Set<String> r225 = (Set) r224;
        if (r225 != null) goto L379;
        r225 = new HashSet();
    L379:
        Object r226 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r225);
        if ((r226 instanceof Integer) == true) goto L382;
        r226 = null;
    L382:
        r208 = (Integer) r226;
        goto L387
    L383:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Integer.class));
        if (v.a() == true) goto L390;
        r208 = Integer.class.newInstance();
        goto L387
    L390:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Integer.class) + '}');
    L392:
        if (Set.class.isAssignableFrom(Long.class) == false) goto L469;
        HashSet r227 = new HashSet();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L407;
        boolean r228 = r227 instanceof String;
        Object r229 = r227;
        if (r228 == true) goto L398;
        r229 = null;
    L398:
        String r230 = (String) r229;
        String r1101 = "";
        if (r230 == null) goto L402;
        r1101 = r230;
    L402:
        Object r231 = r100.getString("ttlive_open_platform_honor_prev_message", r1101);
        if ((r231 instanceof Set) == true) goto L405;
        r231 = null;
    L405:
        r208 = (Set) r231;
    L465:
        if ((r208 instanceof Long) == true) goto L550;
    L407:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L419;
        boolean r232 = r227 instanceof Boolean;
        Object r233 = r227;
        if (r232 == true) goto L411;
        r233 = null;
    L411:
        Boolean r234 = (Boolean) r233;
        if (r234 == null) goto L414;
        r121 = r234.booleanValue();
    L414:
        Object r235 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r121));
        if ((r235 instanceof Set) == true) goto L417;
        r235 = null;
    L417:
        r208 = (Set) r235;
        goto L465
    L419:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r148)) == false) goto L432;
        boolean r236 = r227 instanceof Float;
        Object r237 = r227;
        if (r236 == true) goto L423;
        r237 = null;
    L423:
        Float r238 = (Float) r237;
        if (r238 == null) goto L426;
        float r239 = r238.floatValue();
    L427:
        Object r240 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r239));
        if ((r240 instanceof Set) == true) goto L430;
        r240 = null;
    L430:
        r208 = (Set) r240;
        goto L465
    L426:
        r239 = 0.0f;
        goto L427
    L432:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r175)) == false) goto L445;
        boolean r241 = r227 instanceof Long;
        Object r242 = r227;
        if (r241 == true) goto L436;
        r242 = null;
    L436:
        Long r243 = (Long) r242;
        if (r243 == null) goto L439;
        long r244 = r243.longValue();
    L440:
        Object r245 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r244));
        if ((r245 instanceof Set) == true) goto L443;
        r245 = null;
    L443:
        r208 = (Set) r245;
        goto L465
    L439:
        r244 = 0;
        goto L440
    L445:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r202)) == false) goto L457;
        boolean r246 = r227 instanceof Integer;
        Object r247 = r227;
        if (r246 == true) goto L449;
        r247 = null;
    L449:
        Integer r248 = (Integer) r247;
        if (r248 == null) goto L452;
        r122 = r248.intValue();
    L452:
        Object r249 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r122));
        if ((r249 instanceof Set) == true) goto L455;
        r249 = null;
    L455:
        r208 = (Set) r249;
        goto L465
    L457:
        if (Set.class.isAssignableFrom(Set.class) == false) goto L461;
        r208 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r227);
        if ((r208 instanceof Set) == true) goto L465;
        r208 = null;
        goto L465
    L461:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Set.class));
        if (v.a() == true) goto L468;
        r208 = Set.class.newInstance();
        goto L465
    L468:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Set.class) + '}');
    L469:
        Unit r250 = Unit.INSTANCE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L483;
        boolean r251 = r250 instanceof String;
        Object r252 = r250;
        if (r251 == true) goto L474;
        r252 = null;
    L474:
        String r253 = (String) r252;
        String r1102 = "";
        if (r253 == null) goto L478;
        r1102 = r253;
    L478:
        Object r254 = r100.getString("ttlive_open_platform_honor_prev_message", r1102);
        if ((r254 instanceof Unit) == true) goto L481;
        r254 = null;
    L481:
        r208 = (Unit) r254;
    L548:
        if ((r208 instanceof Long) == true) goto L550;
    L483:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r124)) == false) goto L495;
        boolean r255 = r250 instanceof Boolean;
        Object r256 = r250;
        if (r255 == true) goto L487;
        r256 = null;
    L487:
        Boolean r257 = (Boolean) r256;
        if (r257 == null) goto L490;
        r123 = r257.booleanValue();
    L490:
        Object r258 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r123));
        if ((r258 instanceof Unit) == true) goto L493;
        r258 = null;
    L493:
        r208 = (Unit) r258;
        goto L548
    L495:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r148)) == false) goto L508;
        boolean r259 = r250 instanceof Float;
        Object r260 = r250;
        if (r259 == true) goto L499;
        r260 = null;
    L499:
        Float r261 = (Float) r260;
        if (r261 == null) goto L502;
        float r262 = r261.floatValue();
    L503:
        Object r263 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r262));
        if ((r263 instanceof Unit) == true) goto L506;
        r263 = null;
    L506:
        r208 = (Unit) r263;
        goto L548
    L502:
        r262 = 0.0f;
        goto L503
    L508:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r175)) == false) goto L521;
        boolean r264 = r250 instanceof Long;
        Object r265 = r250;
        if (r264 == true) goto L512;
        r265 = null;
    L512:
        Long r266 = (Long) r265;
        if (r266 == null) goto L515;
        long r267 = r266.longValue();
    L516:
        Object r268 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r267));
        if ((r268 instanceof Unit) == true) goto L519;
        r268 = null;
    L519:
        r208 = (Unit) r268;
        goto L548
    L515:
        r267 = 0;
        goto L516
    L521:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r202)) == false) goto L533;
        boolean r269 = r250 instanceof Integer;
        Object r270 = r250;
        if (r269 == true) goto L525;
        r270 = null;
    L525:
        Integer r271 = (Integer) r270;
        if (r271 == null) goto L528;
        r111 = r271.intValue();
    L528:
        Object r272 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r111));
        if ((r272 instanceof Unit) == true) goto L531;
        r272 = null;
    L531:
        r208 = (Unit) r272;
        goto L548
    L533:
        if (Set.class.isAssignableFrom(Unit.class) == false) goto L544;
        boolean r273 = r250 instanceof Set;
        Object r274 = r250;
        if (r273 == true) goto L537;
        r274 = null;
    L537:
        Set<String> r275 = (Set) r274;
        if (r275 != null) goto L540;
        r275 = new HashSet();
    L540:
        Object r276 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r275);
        if ((r276 instanceof Unit) == true) goto L543;
        r276 = null;
    L543:
        r208 = (Unit) r276;
        goto L548
    L544:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Unit.class));
        if (v.a() == true) goto L567;
        r208 = Unit.class.newInstance();
        goto L548
    L567:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Unit.class) + '}');
    L5:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L10;
        Object r277 = r100.getString("ttlive_open_platform_honor_prev_message", "");
        if ((r277 instanceof String) == true) goto L74;
        r277 = null;
    L74:
        if ((r277 instanceof Long) == true) goto L76;
        r277 = null;
    L76:
        r109 = (Long) r277;
        goto L551
    L10:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L22;
        Object r1103 = "";
        if (("" instanceof Boolean) == true) goto L14;
        r1103 = null;
    L14:
        Boolean r1104 = (Boolean) r1103;
        if (r1104 == null) goto L17;
        r112 = r1104.booleanValue();
    L17:
        Object r278 = Boolean.valueOf(r100.getBoolean("ttlive_open_platform_honor_prev_message", r112));
        if ((r278 instanceof String) == true) goto L20;
        r278 = null;
    L20:
        r277 = (String) r278;
        goto L74
    L22:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Object r1105 = "";
        if (("" instanceof Float) == true) goto L26;
        r1105 = null;
    L26:
        Float r1106 = (Float) r1105;
        if (r1106 == null) goto L29;
        r101 = r1106.floatValue();
    L29:
        Object r279 = Float.valueOf(r100.getFloat("ttlive_open_platform_honor_prev_message", r101));
        if ((r279 instanceof String) == true) goto L32;
        r279 = null;
    L32:
        r277 = (String) r279;
        goto L74
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Object r1107 = "";
        if (("" instanceof Long) == true) goto L38;
        r1107 = null;
    L38:
        Long r1108 = (Long) r1107;
        if (r1108 == null) goto L41;
        long r280 = r1108.longValue();
    L42:
        Object r281 = Long.valueOf(r100.getLong("ttlive_open_platform_honor_prev_message", r280));
        if ((r281 instanceof String) == true) goto L45;
        r281 = null;
    L45:
        r277 = (String) r281;
        goto L74
    L41:
        r280 = 0;
        goto L42
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L59;
        Object r1109 = "";
        if (("" instanceof Integer) == true) goto L51;
        r1109 = null;
    L51:
        Integer r1110 = (Integer) r1109;
        if (r1110 == null) goto L54;
        r113 = r1110.intValue();
    L54:
        Object r282 = Integer.valueOf(r100.getInt("ttlive_open_platform_honor_prev_message", r113));
        if ((r282 instanceof String) == true) goto L57;
        r282 = null;
    L57:
        r277 = (String) r282;
        goto L74
    L59:
        if (Set.class.isAssignableFrom(String.class) == false) goto L70;
        Set<String> r1111 = "";
        if (("" instanceof Set) == true) goto L63;
        r1111 = null;
    L63:
        Set<String> r1112 = r1111;
        if (r1112 != null) goto L66;
        r1112 = new HashSet();
    L66:
        Object r283 = r100.getStringSet("ttlive_open_platform_honor_prev_message", r1112);
        if ((r283 instanceof String) == true) goto L69;
        r283 = null;
    L69:
        r277 = (String) r283;
        goto L74
    L70:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(String.class));
        if (v.a() == true) goto L78;
        r277 = String.class.newInstance();
        goto L74
    L78:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(String.class) + '}');
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        StringBuilder r101 = new StringBuilder("receive message, message id: ");
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getMessageId());
    L6:
        r101.append(r102);
        r101.append(", water level: ");
        r101.append(this.f61691f);
        ALogger.i("GameHonorEffectWidget", r101.toString());
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.f61691f != r100.getMessageId()) goto L12;
        return;
    L12:
        if ((r100 instanceof ka) == false) goto L21;
        Iterator<T> r103 = ((ka) r100).getHonorInfos().iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        ja r104 = (ja) r103.next();
        this.f61687b.offer(new c(r104, r100.getMessageId()));
        goto L15
    L17:
        xq();
        return;
    L21:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
