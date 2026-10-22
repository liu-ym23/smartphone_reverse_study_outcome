package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.b4;
import com.bytedance.android.livesdk.link.model.p3;
import com.bytedance.android.livesdk.link.model.v9;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "activityId", "Lcom/bytedance/android/livesdk/link/model/v9;", "titleArea", "", "update", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "e", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "getListener", "()Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "setListener", "(Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActTitleInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f96676g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f96677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f96678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f96679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f96680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f96681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f96682f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActTitleInfoView f96683a;

        public a(ActTitleInfoView r100) {
            this.f96683a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActTitleInfoView r101 = this.f96683a;
            int r102 = r101.f96679c;
            if (r102 < 0) goto L15;
            b r103 = r101.f96681e;
            if (r103 == null) goto L8;
            r103.Kv(r101.f96678b, r102);
        L8:
            HashMap r104 = new HashMap();
            r104.put("show_type", com.bytedance.android.live.revlink.impl.pk.flexactivity.b.a());
            r104.put("flex_activity_id", r101.f96678b);
            r104.put("room_status", "live");
            com.bytedance.android.live.revlink.impl.control.dialog.e r105 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), r101.f96678b);
            if (r105 == null) goto L13;
            Map<String, String> r106 = r105.f92385f;
            if (r106 == null) goto L13;
            r104.putAll(r106);
        L13:
            n r107 = new n();
            Map<String, String> r108 = r107.f516447a;
            Intrinsics.checkNotNullParameter(r108, "map");
            Intrinsics.checkNotNullParameter(r104, "map");
            r108.putAll(r104);
            m r109 = new m();
            r109.b(LogCommon.PAGE_SOURCE_LOG);
            r109.b(LogCommon.ROOM);
            List<Object> r110 = r107.f516448b;
            ArrayList r111 = (ArrayList) r110;
            r111.addAll(r109.f516446a);
            cy0.e.f465759a.getClass();
            j r112 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r113);
            ((i) ((f80.a) r113)).w3("livesdk_flexible_match_click", r107.f516447a, r107.f516448b);
            return;
        }
    }

    public interface b {
        void Kv(String r100, int r101);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActTitleInfoView f96684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f96685b;

        public c(ActTitleInfoView r100, String r101) {
            this.f96684a = r100;
            this.f96685b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActTitleInfoView r101 = this.f96684a;
            String r102 = this.f96685b;
            int r103 = ActTitleInfoView.f96676g;
            r101.getClass();
            com.bytedance.android.live.revenue.core.util.j.a r104 = com.bytedance.android.live.revenue.core.util.j.C0;
            k r105 = (k) com.bytedance.android.live.revenue.core.util.f.d(r104.a(), k.class);
            String r106 = "";
            if (r105 == null) goto L10;
            IRoom r107 = r105.getRoom();
            if (r107 == null) goto L10;
            IBaseUser r108 = r107.getOwner();
            if (r108 == null) goto L10;
            String r109 = r108.getNickName();
            if (r109 == null) goto L10;
        L11:
            k r110 = (k) com.bytedance.android.live.revenue.core.util.f.d(r104.a(), k.class);
            boolean r111 = false;
            if (r110 == null) goto L23;
            IRoom r112 = r110.getRoom();
            if (r112 == null) goto L23;
            IBaseUser r113 = r112.getOwner();
            if (r113 == null) goto L23;
            py.k r114 = r113.getAvatarMedium();
            if (r114 == null) goto L23;
            List<String> r115 = r114.getUrls();
            if (r115 == null) goto L23;
            String r116 = (String) ListProtector.get(r115, 0);
            if (r116 == null) goto L23;
        L24:
            HashMap r117 = new HashMap();
            k r118 = (k) com.bytedance.android.live.revenue.core.util.f.d(r104.a(), k.class);
            if (r118 == null) goto L34;
            IRoom r119 = r118.getRoom();
            if (r119 == null) goto L34;
            IBaseUser r120 = r119.getOwner();
            if (r120 == null) goto L34;
            String r121 = r120.getIdString();
            if (r121 == null) goto L34;
            r106 = r121;
        L34:
            r117.put("anchor_id", r106);
            r117.put("anchor_name", URLEncoder.encode(r109, "UTF-8"));
            r117.put("anchor_avatar_url", r116);
            String r122 = u.b(r102, r117);
            if (r122.length() <= 0) goto L37;
            r111 = true;
        L37:
            if (r111 == false) goto L39;
            String r123 = r122;
        L40:
            if (r123 == null) goto L43;
            ((pq2.a) vh6.c.b(pq2.a.class)).s3(r101.getContext(), UriProtector.parse(r122));
            return;
        L43:
            return;
        L39:
            r123 = null;
        L23:
            r116 = "";
        L10:
            r109 = "";
            goto L11
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f96686a;

        public d(long r100) {
            this.f96686a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            long r101 = ((Number) r100).longValue();
            return Long.valueOf(this.f96686a - r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActTitleInfoView f96687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b4 f96688b;

        public e(ActTitleInfoView r100, b4 r101) {
            this.f96687a = r100;
            this.f96688b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (r101.longValue() > 0) goto L7;
            ((TextView) this.f96687a._$_findCachedViewById(R.id.tv_count_down)).setText(this.f96688b.getEndText());
            UtilityKotlinExtentionsKt.t(this.f96687a._$_findCachedViewById(R.id.tv_countdown_tips));
            Disposable r102 = this.f96687a.f96680d;
            if (r102 == null) goto L9;
            r102.dispose();
            return;
        L9:
            return;
        L7:
            ActTitleInfoView r103 = this.f96687a;
            long r104 = r101.longValue();
            int r105 = ActTitleInfoView.f96676g;
            r103.R5(r104);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f96689a = null;

        static {
            f96689a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f96680d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final b getListener() {
        return this.f96681e;
    }

    public ActTitleInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96677a = new LinkedHashMap();
        this.f96678b = "";
        this.f96679c = -1;
        this.f96682f = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_flex_basic_info_view, this);
        ((TextView) _$_findCachedViewById(R.id.tv_register)).setOnClickListener(new a(this));
    }

    public final void R5(long r100) {
        String r101 = com.bytedance.live.kmp.util.e.c((int) r100);
        SpannableString r102 = new SpannableString(r101);
        r102.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(R.color.ttlive_flex_activity_count_down_bg_color), s1.h(R.color.ttlive_pk_sub_tab_sub_title_unselect_color)), 0, 2, 33);
        r102.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(R.color.ttlive_flex_activity_count_down_bg_color), s1.h(R.color.ttlive_pk_sub_tab_sub_title_unselect_color)), 3, 5, 33);
        r102.setSpan(new com.bytedance.android.live.revlink.impl.pk.flexactivity.e(s1.h(R.color.ttlive_flex_activity_count_down_bg_color), s1.h(R.color.ttlive_pk_sub_tab_sub_title_unselect_color)), 6, r101.length(), 33);
        ((TextView) _$_findCachedViewById(R.id.tv_count_down)).setText(r102);
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f96677a != null) goto L5;
        this.f96677a = new LinkedHashMap();
    L5:
        View r101 = this.f96677a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f96677a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setListener(b r100) {
        this.f96681e = r100;
    }

    public ActTitleInfoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96677a = new LinkedHashMap();
        this.f96678b = "";
        this.f96679c = -1;
        this.f96682f = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_flex_basic_info_view, this);
        ((TextView) _$_findCachedViewById(R.id.tv_register)).setOnClickListener(new a(this));
    }

    public final void update(String r110, v9 r111) {
        Intrinsics.checkNotNullParameter(r110, "activityId");
        Intrinsics.checkNotNullParameter(r111, "titleArea");
        this.f96678b = r110;
        p3 r112 = r111.getButton();
        int r100 = -1;
        if (r112 == null) goto L7;
        Long r113 = r112.getActType();
        if (r113 == null) goto L7;
        int r114 = (int) r113.longValue();
    L8:
        this.f96679c = r114;
        TextView r115 = (TextView) _$_findCachedViewById(R.id.tv_main_title);
        String r101 = r111.getTitle();
        String r102 = "";
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r115.setText(r101);
        TextView r116 = (TextView) _$_findCachedViewById(R.id.tv_sub_title);
        String r103 = r111.getDesc();
        if (r103 == null) goto L15;
        r102 = r103;
    L15:
        r116.setText(r102);
        String r117 = r111.getRuleUrl();
        boolean r104 = false;
        if (r117 != null) goto L18;
    L21:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L25;
        HSImageView r106 = (HSImageView) _$_findCachedViewById(R.id.ic_sub_title_rule);
        UtilityKotlinExtentionsKt.w(r106);
        r106.setOnClickListener(new c(this, r117));
    L26:
        p3 r118 = r111.getButton();
        ViewGroup.LayoutParams r107 = null;
        if (r118 == null) goto L29;
        String r108 = r118.getText();
    L30:
        if (r108 != null) goto L32;
    L35:
        boolean r109 = true;
    L37:
        if (r109 == true) goto L81;
        TextView r119 = (TextView) _$_findCachedViewById(R.id.tv_register);
        UtilityKotlinExtentionsKt.w(r119);
        if (r118 == null) goto L41;
        String r120 = r118.getText();
    L42:
        r119.setText(r120);
        if (r118 == null) goto L45;
        String r121 = r118.getBgColor();
    L46:
        if (r121 != null) goto L48;
    L51:
        boolean r122 = true;
    L52:
        if (r122 == true) goto L60;
        ShapeDrawable r123 = new ShapeDrawable();
        Integer r124 = Integer.valueOf(Color.parseColor(r121));     // Catch: IllegalArgumentException -> L56
    L57:
        if (r124 == null) goto L59;
        r123.getPaint().setColor(r124.intValue());
    L59:
        float r125 = com.bytedance.android.live.revenue.common.i.a(4);
        r123.setShape(new RoundRectShape(new float[]{r125, r125, r125, r125, r125, r125, r125, r125}, null, null));
        Unit r126 = Unit.INSTANCE;
        r119.setBackground(r123);
    L61:
        if (r118 == null) goto L63;
        String r127 = r118.getTextColor();
    L64:
        if (r127 != null) goto L66;
    L69:
        boolean r128 = true;
    L70:
        if (r128 == false) goto L116;
        r119.setTextColor(-1);
    L74:
        r119.setClickable(true);
        ViewGroup.LayoutParams r129 = _$_findCachedViewById(R.id.divider).getLayoutParams();
        if ((r129 instanceof ConstraintLayout.LayoutParams) == false) goto L78;
        r107 = r129;
    L78:
        ConstraintLayout.LayoutParams r130 = (ConstraintLayout.LayoutParams) r107;
        if (r130 == null) goto L89;
        ((ViewGroup.MarginLayoutParams) r130).topMargin = s1.f(80.0f);
    L89:
        Disposable r131 = this.f96680d;
        if (r131 == null) goto L92;
        r131.dispose();
    L92:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(R.id.ll_count_down));
        b4 r132 = r111.getCountDown();
        if (r132 == null) goto L118;
        Long r133 = r132.getTimestamp();
        if (r133 == null) goto L97;
        long r134 = r133.longValue();
    L99:
        if (r134 == 0) goto L119;
        UtilityKotlinExtentionsKt.w(_$_findCachedViewById(R.id.ll_count_down));
        String r135 = r132.getText();
        if (r135 != null) goto L103;
    L104:
        r104 = true;
    L106:
        if (r104 == true) goto L108;
        TextView r136 = (TextView) _$_findCachedViewById(R.id.tv_countdown_tips);
        r136.setText(r132.getText());
        UtilityKotlinExtentionsKt.w(r136);
    L109:
        long r137 = 1000;
        long r138 = ((r134 * r137) - com.bytedance.live.kmp.util.e.b()) / r137;
        if (r138 <= 0) goto L120;
        R5(r138);
        this.f96680d = du2.a.b(0, 1, TimeUnit.SECONDS).take(1 + r138).delay(0, TimeUnit.MILLISECONDS).map(new d(r138)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r132), f.f96689a);
        return;
    L120:
        return;
    L108:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(R.id.tv_countdown_tips));
        goto L109
    L103:
        if (StringsKt.isBlank(r135) == false) goto L106;
    L119:
        return;
    L97:
        r134 = 0;
        goto L99
    L118:
        return;
    L116:
        r100 = Color.parseColor(r127);     // Catch: IllegalArgumentException -> L113
    L72:
        r119.setTextColor(r100);
        goto L74
    L66:
        if (StringsKt.isBlank(r127) == true) goto L69;
        r128 = false;
        goto L70
    L63:
        r127 = null;
    L56:
        r124 = null;
        goto L57
    L60:
        r119.setBackgroundResource(R.drawable.ttlive_bg_live_red_btn);
        goto L61
    L48:
        if (StringsKt.isBlank(r121) == true) goto L51;
        r122 = false;
        goto L52
    L45:
        r121 = null;
        goto L46
    L41:
        r120 = null;
        goto L42
    L81:
        ViewGroup.LayoutParams r139 = _$_findCachedViewById(R.id.divider).getLayoutParams();
        if ((r139 instanceof ConstraintLayout.LayoutParams) == false) goto L85;
        r107 = r139;
    L85:
        ConstraintLayout.LayoutParams r140 = (ConstraintLayout.LayoutParams) r107;
        if (r140 == null) goto L88;
        ((ViewGroup.MarginLayoutParams) r140).topMargin = s1.f(20.0f);
    L88:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(R.id.tv_register));
        goto L89
    L32:
        if (StringsKt.isBlank(r108) == true) goto L35;
        r109 = false;
        goto L37
    L29:
        r108 = null;
        goto L30
    L25:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(R.id.ic_sub_title_rule));
        goto L26
    L18:
        if (StringsKt.isBlank(r117) == true) goto L21;
        r105 = false;
    L7:
        r114 = -1;
        goto L8
    }

    public ActTitleInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96677a = new LinkedHashMap();
        this.f96678b = "";
        this.f96679c = -1;
        this.f96682f = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_flex_basic_info_view, this);
        ((TextView) _$_findCachedViewById(R.id.tv_register)).setOnClickListener(new a(this));
    }
}
