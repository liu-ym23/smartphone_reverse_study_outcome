package com.bytedance.android.livesdk.announcement.time;

import android.graphics.drawable.Drawable;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.LiveNumberPicker;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/time/AnnouncementTimeSelectWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementTimeSelectWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer[] f103547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f103548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f103549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f103550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Date> f103551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f103552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.announce.d> f103553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveNumberPicker f103554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveNumberPicker f103555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveNumberPicker f103556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f103557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HorizontalScrollView f103558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f103559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<TextView> f103560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.announce.b f103561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f103562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f103563r;

    public interface a {
        void a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f103564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f103567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Drawable f103568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Drawable f103569f;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r100) {
            this(s1.h(R.color.ttlive_douyin_dark_TextPrimary), ColorProtector.parseColor("#1FFFFFFF"), s1.h(R.color.ttlive_douyin_dark_TextPrimary), ColorProtector.parseColor("#80FFFFFF"), s1.m(R.drawable.ttlive_bg_dark_announcement_item_selected_theme), s1.m(R.drawable.ttlive_bg_dark_announcement_item_unselected_theme));
        }

        public b(int r100, int r101, int r102, int r103, Drawable r104, Drawable r105) {
            Intrinsics.checkNotNullParameter(r104, "weekSelectedBgDrawable");
            Intrinsics.checkNotNullParameter(r105, "weekUnSelectedBgDrawable");
            this.f103564a = r100;
            this.f103565b = r101;
            this.f103566c = r102;
            this.f103567d = r103;
            this.f103568e = r104;
            this.f103569f = r105;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_announcement_time_select;
    }

    public final b xq() {
        return (b) this.f103546a.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ((ArrayList) this.f103560o).clear();
    }

    public final com.bytedance.android.livesdk.announce.b wq() {
        int r100 = 0;
        com.bytedance.android.livesdk.announce.b r101 = new com.bytedance.android.livesdk.announce.b(r100);
        r101.f103131b.addAll(this.f103553h);
        Calendar r102 = Calendar.getInstance();
        List<Date> r103 = this.f103551f;
        LiveNumberPicker r104 = this.f103556k;
        if (r104 == null) goto L5;
        int r105 = r104.getCurrentNumber();
    L6:
        r102.setTime((Date) ListProtector.get(r103, r105));
        LiveNumberPicker r106 = this.f103554i;
        if (r106 == null) goto L13;
        String r107 = r106.getCurrentText();
        if (r107 == null) goto L13;
        Integer r108 = StringsKt.toIntOrNull(r107);
        if (r108 == null) goto L13;
        int r109 = r108.intValue();
    L14:
        r102.set(11, r109);
        LiveNumberPicker r110 = this.f103555j;
        if (r110 == null) goto L21;
        String r111 = r110.getCurrentText();
        if (r111 == null) goto L21;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L21;
        r100 = r112.intValue();
    L21:
        r102.set(12, r100);
        r101.f103130a = r102.getTime();
        return r101;
    L13:
        r109 = 0;
        goto L14
    L5:
        r105 = 0;
        goto L6
    }

    public final void yq() {
        Iterator r100 = ((ArrayList) this.f103560o).iterator();
    L4:
        if (r100.hasNext() == false) goto L16;
        Object r101 = ((TextView) r100.next()).getTag();
        if ((r101 instanceof com.bytedance.android.livesdk.announce.d) == true) goto L8;
        r101 = null;
    L8:
        com.bytedance.android.livesdk.announce.d r102 = (com.bytedance.android.livesdk.announce.d) r101;
        if (r102 == null) goto L4;
        if (r102.f103140b != true) goto L4;
        LiveNumberPicker r103 = this.f103556k;
        if (r103 == null) goto L26;
        r103.setEnabled(false);
        return;
    L26:
        return;
    L16:
        LiveNumberPicker r104 = this.f103556k;
        if (r104 == null) goto L27;
        r104.setEnabled(true);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f103554i = (LiveNumberPicker) findViewById(R.id.hour_num_picker);
        this.f103555j = (LiveNumberPicker) findViewById(R.id.min_num_picker);
        this.f103556k = (LiveNumberPicker) findViewById(R.id.date_num_picker);
        this.f103557l = (LinearLayout) findViewById(R.id.date_container);
        this.f103558m = (HorizontalScrollView) findViewById(R.id.scroll_view);
        this.f103559n = (LinearLayout) findViewById(R.id.ll_period);
        new kn2.a(new ln2.a(this.f103558m));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        Integer r100 = null;
        boolean r101 = true;
        int r102 = 0;
        if (this.f103563r == true) goto L7;
        LinearLayout r111 = this.f103559n;
        if (r111 == null) goto L43;
        r111.setVisibility(8);
    L43:
        Calendar r112 = Calendar.getInstance();
        ArrayList r103 = new ArrayList();
        Integer[] r104 = this.f103547b;
        int r105 = r104.length;
        int r106 = 0;
    L44:
        if (r106 >= r105) goto L50;
        int r107 = r104[r106].intValue();
        if (r107 != 0) goto L48;
        String r108 = CustomAlbumViewModel.DEFAULT_TAB_ID;
    L49:
        r103.add(r108);
        r106 = r106 + 1;
        goto L44
    L48:
        r108 = String.valueOf(r107);
        goto L49
    L50:
        LiveNumberPicker r109 = this.f103555j;
        if (r109 == null) goto L57;
        r109.f161032n = 0;
        r109.f();
        r109.e();
        r109.invalidate();
        r109.f161033o = r103.size() - 1;
        r109.f();
        r109.e();
        r109.invalidate();
        r109.f161029k = xq().f103564a;
        r109.d();
        r109.invalidate();
        r109.f161030l = xq().f103565b;
        r109.d();
        r109.invalidate();
        Object[] r113 = r103.toArray(new String[0]);
        if (r113 == null) goto L56;
        r109.T = (String[]) r113;
        r109.f();
        r109.invalidate();
        r109.f161031m = s1.e(16.0f);
        r109.c();
        r109.invalidate();
        goto L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L57:
        LiveNumberPicker r114 = this.f103555j;
        if (r114 == null) goto L60;
        r114.O = new c(this);
    L60:
        ArrayList r115 = new ArrayList();
        Iterator<Integer> r116 = new IntRange(0, this.f103548c).iterator();
    L62:
        if (r116.hasNext() == false) goto L68;
        int r117 = ((IntIterator) r116).nextInt();
        if (r117 >= 10) goto L66;
        String r118 = "0" + r117;
    L67:
        r115.add(r118);
        goto L62
    L66:
        r118 = String.valueOf(r117);
        goto L67
    L68:
        LiveNumberPicker r119 = this.f103554i;
        if (r119 == null) goto L75;
        r119.f161032n = 0;
        r119.f();
        r119.e();
        r119.invalidate();
        r119.f161033o = r115.size() - 1;
        r119.f();
        r119.e();
        r119.invalidate();
        r119.f161029k = xq().f103564a;
        r119.d();
        r119.invalidate();
        r119.f161030l = xq().f103565b;
        r119.d();
        r119.invalidate();
        Object[] r120 = r115.toArray(new String[0]);
        if (r120 == null) goto L74;
        r119.T = (String[]) r120;
        r119.f();
        r119.invalidate();
        r119.f161031m = s1.e(16.0f);
        r119.c();
        r119.invalidate();
        goto L75
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L75:
        LiveNumberPicker r121 = this.f103554i;
        if (r121 == null) goto L78;
        r121.O = new d(this);
    L78:
        ((ArrayList) this.f103551f).add(r112.getTime());
        List<String> r122 = this.f103552g;
        String[] r123 = com.bytedance.android.livesdk.announce.c.f103134a;
        ((ArrayList) r122).add(com.bytedance.android.livesdk.announce.c.b(r112.getTime()));
        Iterator<Integer> r124 = new IntRange(0, this.f103549d).iterator();
    L80:
        if (r124.hasNext() == false) goto L82;
        ((IntIterator) r124).nextInt();
        r112.add(5, 1);
        ((ArrayList) this.f103551f).add(r112.getTime());
        List<String> r125 = this.f103552g;
        String[] r126 = com.bytedance.android.livesdk.announce.c.f103134a;
        ((ArrayList) r125).add(com.bytedance.android.livesdk.announce.c.b(r112.getTime()));
        goto L80
    L82:
        LiveNumberPicker r127 = this.f103556k;
        if (r127 == null) goto L89;
        r127.f161032n = 0;
        r127.f();
        r127.e();
        r127.invalidate();
        r127.f161033o = ((ArrayList) this.f103552g).size() - 1;
        r127.f();
        r127.e();
        r127.invalidate();
        r127.f161029k = xq().f103564a;
        r127.d();
        r127.invalidate();
        r127.f161030l = xq().f103565b;
        r127.d();
        r127.invalidate();
        Object[] r128 = ((ArrayList) this.f103552g).toArray(new String[0]);
        if (r128 == null) goto L88;
        r127.T = (String[]) r128;
        r127.f();
        r127.invalidate();
        r127.f161031m = s1.e(16.0f);
        r127.c();
        r127.invalidate();
        goto L89
    L88:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L89:
        LiveNumberPicker r129 = this.f103556k;
        if (r129 == null) goto L92;
        r129.setActionListener(new e());
    L92:
        LiveNumberPicker r130 = this.f103556k;
        if (r130 == null) goto L95;
        r130.O = new com.bytedance.android.livesdk.announcement.time.b(this);
    L95:
        com.bytedance.android.livesdk.announce.b r131 = this.f103561p;
        if (r131 == null) goto L98;
        Date r132 = r131.f103130a;
    L99:
        if (r131 == null) goto L105;
        ArrayList<com.bytedance.android.livesdk.announce.d> r133 = r131.f103131b;
        if (r133 == null) goto L105;
        if ((!r133.isEmpty()) != true) goto L105;
        boolean r134 = true;
    L106:
        Calendar r135 = Calendar.getInstance();
        if (r132 != null) goto L109;
    L114:
        String[] r136 = com.bytedance.android.livesdk.announce.c.f103134a;
        Integer r137 = StringsKt.toIntOrNull(com.bytedance.android.livesdk.announce.c.d(r135.getTime()));
        if (r137 == null) goto L117;
        int r138 = r137.intValue();
    L118:
        Integer[] r139 = this.f103547b;
        int r140 = r139.length;
        int r141 = 0;
    L119:
        if (r141 >= r140) goto L127;
        Integer r142 = r139[r141];
        if (r142.intValue() < r138) goto L123;
        boolean r143 = true;
    L124:
        if (r143 == true) goto L128;
        r141 = r141 + 1;
    L128:
        if (r142 == null) goto L130;
        int r144 = r142.intValue();
    L131:
        if (r144 != (-1)) goto L133;
        r135.add(10, 1);
    L133:
        Date r145 = r135.getTime();
        LiveNumberPicker r146 = this.f103555j;
        if (r146 == null) goto L146;
        Integer r147 = Integer.valueOf(ArraysKt.indexOf(this.f103547b, Integer.valueOf(r144)));
        if (r147.intValue() == (-1)) goto L138;
        boolean r148 = true;
    L139:
        if (r148 == true) goto L142;
        r147 = null;
    L142:
        if (r147 == null) goto L144;
        int r149 = r147.intValue();
    L145:
        r146.f161034p = r149;
        r146.f();
        r146.e();
        r146.invalidate();
        goto L146
    L144:
        r149 = 0;
        goto L145
    L138:
        r148 = false;
    L146:
        LiveNumberPicker r150 = this.f103554i;
        if (r150 == null) goto L153;
        Integer r151 = StringsKt.toIntOrNull(com.bytedance.android.livesdk.announce.c.c(r145));
        if (r151 == null) goto L151;
        int r152 = r151.intValue();
    L152:
        r150.f161034p = r152;
        r150.f();
        r150.e();
        r150.invalidate();
        goto L153
    L151:
        r152 = 0;
    L153:
        LiveNumberPicker r153 = this.f103556k;
        if (r153 == null) goto L164;
        Integer r154 = Integer.valueOf(((ArrayList) this.f103552g).indexOf(com.bytedance.android.livesdk.announce.c.b(r145)));
        if (r154.intValue() != (-1)) goto L159;
        r101 = false;
    L159:
        if (r101 == false) goto L161;
        r100 = r154;
    L161:
        if (r100 == null) goto L163;
        r102 = r100.intValue();
    L163:
        r153.f161034p = r102;
        r153.f();
        r153.e();
        r153.invalidate();
    L164:
        yq();
        return;
    L130:
        r144 = -1;
        goto L131
    L123:
        r143 = false;
        goto L124
    L127:
        r142 = null;
        goto L128
    L117:
        r138 = 0;
        goto L118
    L109:
        if (((ArrayList) this.f103552g).contains(com.bytedance.android.livesdk.announce.c.b(r132)) == true) goto L111;
    L112:
        if (r134 == false) goto L114;
    L113:
        r135.setTime(r132);
        goto L114
    L111:
        if (r132.after(new Date()) == true) goto L113;
    L105:
        r134 = false;
        goto L106
    L98:
        r132 = null;
        goto L99
    L7:
        ((ArrayList) this.f103560o).clear();
        ((ArrayList) this.f103553h).clear();
        com.bytedance.android.livesdk.announce.b r155 = this.f103561p;
        if (r155 == null) goto L17;
        ArrayList<com.bytedance.android.livesdk.announce.d> r156 = r155.f103131b;
        if (r156 == null) goto L17;
        if ((!r156.isEmpty()) != true) goto L17;
        ((ArrayList) this.f103553h).addAll(this.f103561p.f103131b);
        Iterator r157 = ((ArrayList) this.f103553h).iterator();
    L15:
        if (r157.hasNext() == false) goto L17;
        ((com.bytedance.android.livesdk.announce.d) r157.next()).f103140b = true;
    L17:
        LinearLayout r158 = this.f103557l;
        if (r158 == null) goto L43;
        r158.removeAllViews();
        String[] r159 = com.bytedance.android.livesdk.announce.c.f103138e;
        int r160 = r159.length;
        int r161 = 0;
    L20:
        if (r161 >= r160) goto L32;
        String r162 = r159[r161];
        AppCompatTextView r163 = new AppCompatTextView(this.context);
        r163.setGravity(17);
        r163.setWidth((int) UtilityKotlinExtentionsKt.h(60.0f));
        r163.setHeight((int) UtilityKotlinExtentionsKt.h(28.0f));
        r163.setText(r162);
        Iterator r164 = ((ArrayList) this.f103553h).iterator();
    L23:
        if (r164.hasNext() == false) goto L27;
        Object r165 = r164.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.announce.d) r165).f103139a, r162) == false) goto L23;
    L28:
        com.bytedance.android.livesdk.announce.d r166 = (com.bytedance.android.livesdk.announce.d) r165;
        if (r166 != null) goto L31;
        r166 = new com.bytedance.android.livesdk.announce.d(r162, false);
    L31:
        r163.setTag(r166);
        r163.setTextSize(1, 13.0f);
        r163.setOnClickListener(new com.bytedance.android.livesdk.announcement.time.a(this));
        r163.setTextColor(xq().f103567d);
        zq(r163);
        ((ArrayList) this.f103560o).add(r163);
        r161 = r161 + 1;
        goto L20
    L27:
        r165 = null;
        goto L28
    L32:
        TextView r167 = (TextView) CollectionsKt.last(this.f103560o);
        List<TextView> r168 = this.f103560o;
        ListProtector.remove(r168, ((ArrayList) r168).size() - 1);
        ListProtector.add(this.f103560o, 0, r167);
        Iterator r169 = ((ArrayList) this.f103560o).iterator();
        int r170 = 0;
    L34:
        if (r169.hasNext() == false) goto L43;
        Object r171 = r169.next();
        int r172 = r170 + 1;
        if (r170 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        TextView r173 = (TextView) r171;
        if (r170 != 0) goto L41;
        float r174 = 0.0f;
    L42:
        LinearLayout.LayoutParams r175 = new LinearLayout.LayoutParams(-2, -2);
        r175.gravity = 16;
        r175.leftMargin = (int) UtilityKotlinExtentionsKt.h(r174);
        r158.addView(r173, r175);
        r170 = r172;
        goto L34
    L41:
        r174 = 8.0f;
        goto L42
    }

    public final void zq(TextView r100) {
        Object r101 = r100.getTag();
        if ((r101 instanceof com.bytedance.android.livesdk.announce.d) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.livesdk.announce.d r102 = (com.bytedance.android.livesdk.announce.d) r101;
        if (r102 != null) goto L8;
    L10:
        r100.setTextColor(xq().f103567d);
        r100.setBackground(xq().f103569f);
        return;
    L8:
        if (r102.f103140b != true) goto L10;
        r100.setTextColor(xq().f103566c);
        r100.setBackground(xq().f103568e);
    }

    public AnnouncementTimeSelectWidget(com.bytedance.android.livesdk.announce.b r100, boolean r101, boolean r102) {
        this.f103561p = r100;
        this.f103562q = r101;
        this.f103563r = r102;
        this.f103546a = LazyKt.lazy(new AnnouncementTimeSelectWidget$themeInfo$2(this));
        this.f103547b = new Integer[]{0, 10, 20, 30, 40, 50};
        this.f103548c = 23;
        this.f103549d = 5;
        this.f103551f = new ArrayList();
        this.f103552g = new ArrayList();
        this.f103553h = new ArrayList();
        this.f103560o = new ArrayList();
    }
}
