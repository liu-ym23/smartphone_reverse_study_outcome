package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.g0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.h0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.i0;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentEmptyView;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import je2.c;
import je2.d;
import je2.e;
import je2.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvComponentMusicReportInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f144295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f144296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f144297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f144298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f144299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f144300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f144301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MusicReportInfoViewStateObserver f144302h;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/musicreportinfo/KtvComponentMusicReportInfoManager$MusicReportInfoViewStateObserver;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lje2/f;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class MusicReportInfoViewStateObserver implements Observer<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMusicReportInfoManager f144303a;

        public MusicReportInfoViewStateObserver(KtvComponentMusicReportInfoManager r100) {
            this.f144303a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            f r100 = (f) r110;
            String r101 = null;
            if ((r100 instanceof f.b) == false) goto L27;
            e r102 = this.f144303a.f144300f;
            KtvComponentEmptyView r103 = r102.f498804a;
            if (r103 == null) goto L7;
            UtilityKotlinExtentionsKt.t(r103);
        L7:
            TextView r104 = r102.f498806c;
            if (r104 == null) goto L10;
            UtilityKotlinExtentionsKt.t(r104);
        L10:
            TextView r105 = r102.f498807d;
            if (r105 == null) goto L13;
            UtilityKotlinExtentionsKt.t(r105);
        L13:
            i0 r106 = r102.f498808e;
            if (r106 == null) goto L16;
            r106.c();
        L16:
            TextView r107 = r102.f498809f;
            if (r107 == null) goto L19;
            UtilityKotlinExtentionsKt.w(r107);
        L19:
            TextView r108 = this.f144303a.f144300f.f498809f;
            if (r108 == null) goto L275;
            r108.setTextSize(20.0f);
            if (((f.b) r100).f498811a == false) goto L25;
            r101 = s1.B(R.string.ttlive_ktv_room_lyrics_empty_new);
        L25:
            r108.setText(r101);
            return;
        L275:
            return;
        L27:
            if ((r100 instanceof f.C6423f) == false) goto L58;
            e r109 = this.f144303a.f144300f;
            KtvComponentEmptyView r111 = r109.f498804a;
            if (r111 == null) goto L31;
            UtilityKotlinExtentionsKt.w(r111);
        L31:
            KtvComponentEmptyView r112 = r109.f498805b;
            if (r112 == null) goto L34;
            UtilityKotlinExtentionsKt.t(r112);
        L34:
            TextView r113 = r109.f498806c;
            if (r113 == null) goto L37;
            UtilityKotlinExtentionsKt.t(r113);
        L37:
            TextView r114 = r109.f498807d;
            if (r114 == null) goto L40;
            UtilityKotlinExtentionsKt.t(r114);
        L40:
            i0 r115 = r109.f498808e;
            if (r115 == null) goto L43;
            r115.c();
        L43:
            TextView r116 = r109.f498809f;
            if (r116 == null) goto L46;
            UtilityKotlinExtentionsKt.t(r116);
        L46:
            j r117 = j.f143561l;
            f.C6423f r118 = (f.C6423f) r100;
            KtvMusic r119 = r118.f498816a;
            r117.getClass();
            if (j.d(r119) == false) goto L54;
            KtvComponentEmptyView r120 = r109.f498804a;
            if (r120 == null) goto L51;
            r120.b(r118.f498816a);
        L51:
            KtvComponentEmptyView r121 = r109.f498804a;
            if (r121 == null) goto L277;
            UtilityKotlinExtentionsKt.w(r121);
            return;
        L277:
            return;
        L54:
            KtvComponentEmptyView r122 = r109.f498804a;
            if (r122 == null) goto L279;
            UtilityKotlinExtentionsKt.t(r122);
            return;
        L279:
            return;
        L58:
            if ((r100 instanceof f.g) == false) goto L78;
            e r123 = this.f144303a.f144300f;
            KtvComponentEmptyView r124 = r123.f498804a;
            if (r124 == null) goto L62;
            UtilityKotlinExtentionsKt.t(r124);
        L62:
            KtvComponentEmptyView r125 = r123.f498805b;
            if (r125 == null) goto L65;
            UtilityKotlinExtentionsKt.w(r125);
        L65:
            TextView r126 = r123.f498806c;
            if (r126 == null) goto L68;
            UtilityKotlinExtentionsKt.t(r126);
        L68:
            TextView r127 = r123.f498807d;
            if (r127 == null) goto L71;
            UtilityKotlinExtentionsKt.t(r127);
        L71:
            i0 r128 = r123.f498808e;
            if (r128 == null) goto L74;
            r128.c();
        L74:
            KtvComponentEmptyView r129 = this.f144303a.f144300f.f498805b;
            if (r129 == null) goto L281;
            r129.d(((f.g) r100).f498817a);
            return;
        L281:
            return;
        L78:
            if ((r100 instanceof f.e) == false) goto L110;
            e r130 = this.f144303a.f144300f;
            KtvComponentEmptyView r131 = r130.f498804a;
            if (r131 == null) goto L82;
            UtilityKotlinExtentionsKt.t(r131);
        L82:
            KtvComponentEmptyView r132 = r130.f498805b;
            if (r132 == null) goto L85;
            UtilityKotlinExtentionsKt.t(r132);
        L85:
            TextView r133 = r130.f498806c;
            if (r133 == null) goto L88;
            UtilityKotlinExtentionsKt.w(r133);
        L88:
            TextView r134 = r130.f498807d;
            if (r134 == null) goto L91;
            UtilityKotlinExtentionsKt.t(r134);
        L91:
            i0 r135 = r130.f498808e;
            if (r135 == null) goto L94;
            r135.c();
        L94:
            TextView r136 = r130.f498809f;
            if (r136 == null) goto L97;
            UtilityKotlinExtentionsKt.t(r136);
        L97:
            f.e r137 = (f.e) r100;
            Long r138 = r137.f498814a;
            if (r138 != null) goto L100;
            return;
        L100:
            if (r137.f498815b == null) goto L297;
            TextView r139 = this.f144303a.f144300f.f498806c;
            if (r139 != null) goto L105;
            return;
        L105:
            if (r138.longValue() > 10) goto L107;
            int r140 = R.drawable.ttlive_ktv_challenge_count_down_end_icon;
        L108:
            Drawable r141 = s1.m(r140);
            r141.setBounds(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
            r139.setCompoundDrawables(r141, null, null, null);
            r139.setCompoundDrawablePadding(UtilityKotlinExtentionsKt.i(1));
            r139.setText(String.valueOf(KtvUtilsKt.e(r137.f498814a.longValue())));
            r139.setTextColor(ColorProtector.parseColor(r137.f498815b));
            return;
        L107:
            r140 = R.drawable.ttlive_ktv_challenge_count_down_icon;
            goto L108
        L297:
            return;
        L110:
            if ((r100 instanceof f.c) == false) goto L133;
            e r142 = this.f144303a.f144300f;
            KtvComponentEmptyView r143 = r142.f498804a;
            if (r143 == null) goto L114;
            UtilityKotlinExtentionsKt.t(r143);
        L114:
            KtvComponentEmptyView r144 = r142.f498805b;
            if (r144 == null) goto L117;
            UtilityKotlinExtentionsKt.t(r144);
        L117:
            TextView r145 = r142.f498806c;
            if (r145 == null) goto L120;
            UtilityKotlinExtentionsKt.t(r145);
        L120:
            TextView r146 = r142.f498807d;
            if (r146 == null) goto L123;
            UtilityKotlinExtentionsKt.w(r146);
        L123:
            i0 r147 = r142.f498808e;
            if (r147 == null) goto L126;
            r147.c();
        L126:
            TextView r148 = r142.f498809f;
            if (r148 == null) goto L129;
            UtilityKotlinExtentionsKt.t(r148);
        L129:
            TextView r149 = this.f144303a.f144300f.f498807d;
            if (r149 == null) goto L286;
            r149.setText(((f.c) r100).f498812a);
            return;
        L286:
            return;
        L133:
            if ((r100 instanceof f.d) == false) goto L255;
            e r150 = this.f144303a.f144300f;
            KtvComponentEmptyView r151 = r150.f498804a;
            if (r151 == null) goto L137;
            UtilityKotlinExtentionsKt.t(r151);
        L137:
            KtvComponentEmptyView r152 = r150.f498805b;
            if (r152 == null) goto L140;
            UtilityKotlinExtentionsKt.t(r152);
        L140:
            TextView r153 = r150.f498806c;
            if (r153 == null) goto L143;
            UtilityKotlinExtentionsKt.t(r153);
        L143:
            TextView r154 = r150.f498807d;
            if (r154 == null) goto L146;
            UtilityKotlinExtentionsKt.t(r154);
        L146:
            i0 r155 = r150.f498808e;
            if (r155 == null) goto L149;
            r155.c();
        L149:
            TextView r156 = r150.f498809f;
            if (r156 == null) goto L152;
            UtilityKotlinExtentionsKt.t(r156);
        L152:
            f.d r157 = (f.d) r100;
            j r158 = j.f143561l;
            Long r159 = r157.f498813a.i();
            r158.getClass();
            if (j.e(r159) == true) goto L155;
            return;
        L155:
            if (r157.f498813a.l() == false) goto L205;
            i0 r160 = this.f144303a.f144300f.f498808e;
            if (r160 == null) goto L289;
            float r161 = r157.f498813a.g();
            String r162 = r157.f498813a.j();
            String r163 = r157.f498813a.f();
            ConstraintLayout r164 = r160.f144480d;
            if (r164 == null) goto L161;
            r164.setVisibility(0);
        L161:
            TextView r165 = r160.f144482f;
            if (r165 == null) goto L164;
            r165.getViewTreeObserver().addOnGlobalLayoutListener(new g0(r165, r160));
        L164:
            TextView r166 = r160.f144481e;
            if (r166 == null) goto L167;
            r166.getViewTreeObserver().addOnGlobalLayoutListener(new h0(r166, r160));
        L167:
            ImageView r167 = r160.f144483g;
            if (r167 == null) goto L170;
            r167.setVisibility(0);
        L170:
            int r168 = (int) r161;
            TextView r169 = r160.f144481e;
            if (r169 == null) goto L173;
            StringBuilder r170 = new StringBuilder();
            r170.append(r168);
            r170.append(' ');
            r169.setText(r170.toString());
        L173:
            if (r163 != null) goto L175;
        L178:
            boolean r171 = true;
        L179:
            if (r171 == false) goto L181;
        L183:
            if (r162 != null) goto L185;
        L188:
            boolean r172 = true;
        L189:
            if (r172 == false) goto L191;
        L193:
            TextView r173 = r160.f144479c;
            if (r173 == null) goto L196;
            r173.setText(s1.C(R.string.ttlive_ktv_component_feedback_tips, new Object[]{r163}));
        L196:
            TextView r174 = r160.f144478b;
            if (r174 == null) goto L199;
            r174.setText(s1.C(R.string.ttlive_ktv_room_feedback_sing_title_v2, new Object[]{r162}));
        L199:
            ImageView r175 = r160.f144477a;
            if (r175 == null) goto L202;
            r175.setVisibility(0);
        L202:
            ConstraintLayout r176 = r160.f144480d;
            if (r176 == null) goto L290;
            r176.setBackground(s1.m(R.drawable.ttlive_ktv_component_feedback_bg_success));
            return;
        L290:
            return;
        L191:
            if (r162.length() <= 6) goto L193;
            r162 = r162.subSequence(0, 6) + "...";
            goto L193
        L185:
            if (r162.length() == 0) goto L188;
            r172 = false;
            goto L189
        L181:
            if (r163.length() <= 4) goto L183;
            r163 = r163.subSequence(0, 4) + "...";
            goto L183
        L175:
            if (r163.length() == 0) goto L178;
            r171 = false;
            goto L179
        L289:
            return;
        L205:
            i0 r177 = this.f144303a.f144300f.f498808e;
            if (r177 == null) goto L292;
            float r178 = r157.f498813a.g();
            String r179 = r157.f498813a.j();
            String r180 = r157.f498813a.f();
            double r181 = r157.f498813a.c();
            ConstraintLayout r182 = r177.f144480d;
            if (r182 == null) goto L210;
            r182.setVisibility(0);
        L210:
            TextView r183 = r177.f144482f;
            if (r183 == null) goto L213;
            r183.setTextColor(-1);
        L213:
            TextView r184 = r177.f144481e;
            if (r184 == null) goto L216;
            r184.setTextColor(-1);
        L216:
            ImageView r185 = r177.f144483g;
            if (r185 == null) goto L219;
            r185.setVisibility(8);
        L219:
            TextView r186 = r177.f144481e;
            if (r186 == null) goto L222;
            r186.setText(String.valueOf((int) r178) + " ");
        L222:
            if (r180 != null) goto L224;
        L227:
            boolean r187 = true;
        L228:
            if (r187 == false) goto L230;
        L232:
            if (r179 != null) goto L234;
        L237:
            boolean r188 = true;
        L238:
            if (r188 == false) goto L240;
        L242:
            int r189 = Math.abs(((int) r181) - ((int) r178));
            TextView r190 = r177.f144479c;
            if (r190 == null) goto L245;
            r190.setText(s1.C(R.string.ttlive_ktv_component_feedback_failed_tips, new Object[]{r180, Integer.valueOf(r189)}));
        L245:
            TextView r191 = r177.f144478b;
            if (r191 == null) goto L248;
            r191.setText(s1.C(R.string.ttlive_ktv_room_feedback_sing_title_v2, new Object[]{r179}));
        L248:
            ImageView r192 = r177.f144477a;
            if (r192 == null) goto L251;
            r192.setVisibility(8);
        L251:
            ConstraintLayout r193 = r177.f144480d;
            if (r193 == null) goto L293;
            r193.setBackground(s1.m(R.drawable.ttlive_ktv_component_feedback_bg_failed));
            return;
        L293:
            return;
        L240:
            if (r179.length() <= 6) goto L242;
            r179 = r179.subSequence(0, 6) + "...";
            goto L242
        L234:
            if (r179.length() == 0) goto L237;
            r188 = false;
            goto L238
        L230:
            if (r180.length() <= 4) goto L232;
            r180 = r180.subSequence(0, 4) + "...";
            goto L232
        L224:
            if (r180.length() == 0) goto L227;
            r187 = false;
            goto L228
        L292:
            return;
        L255:
            if ((r100 instanceof f.a) == false) goto L295;
            e r194 = this.f144303a.f144300f;
            KtvComponentEmptyView r195 = r194.f498804a;
            if (r195 == null) goto L259;
            UtilityKotlinExtentionsKt.t(r195);
        L259:
            KtvComponentEmptyView r196 = r194.f498805b;
            if (r196 == null) goto L262;
            UtilityKotlinExtentionsKt.t(r196);
        L262:
            TextView r197 = r194.f498806c;
            if (r197 == null) goto L265;
            UtilityKotlinExtentionsKt.t(r197);
        L265:
            TextView r198 = r194.f498807d;
            if (r198 == null) goto L268;
            UtilityKotlinExtentionsKt.t(r198);
        L268:
            i0 r199 = r194.f498808e;
            if (r199 == null) goto L271;
            r199.c();
        L271:
            TextView r200 = r194.f498809f;
            if (r200 == null) goto L296;
            UtilityKotlinExtentionsKt.t(r200);
            return;
        L296:
            return;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMusicReportInfoManager f144304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f144305b;

        public b(KtvComponentMusicReportInfoManager r100, Function0 r101) {
            this.f144304a = r100;
            this.f144305b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if ((this.f144304a.f144301g.getValue() instanceof f.C6423f) == false) goto L5;
            this.f144304a.f(f.a.f498810a);
        L5:
            Function0 r102 = this.f144305b;
            if (r102 == null) goto L9;
            Unit r103 = (Unit) r102.invoke();
            return;
        }
    }

    static {
    }

    public final void a() {
        this.f144301g.removeObserver(this.f144302h);
        Disposable r100 = this.f144295a;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f144296b;
        if (r101 != null) goto L10;
    L12:
        Disposable r102 = this.f144297c;
        if (r102 != null) goto L15;
    L17:
        Disposable r103 = this.f144298d;
        if (r103 != null) goto L20;
    L22:
        Disposable r104 = this.f144299e;
        if (r104 != null) goto L25;
        return;
    L25:
        if (r104.isDisposed() == true) goto L29;
        r104.dispose();
        return;
    L29:
        return;
    L20:
        if (r103.isDisposed() == true) goto L22;
        r103.dispose();
        goto L22
    L15:
        if (r102.isDisposed() == true) goto L17;
        r102.dispose();
        goto L17
    L10:
        if (r101.isDisposed() == true) goto L12;
        r101.dispose();
        goto L12
    L5:
        if (r100.isDisposed() == true) goto L7;
        r100.dispose();
        goto L7
    }

    public KtvComponentMusicReportInfoManager() {
        this.f144300f = new e();
        this.f144301g = new MutableLiveData(f.a.f498810a);
        this.f144302h = new MusicReportInfoViewStateObserver(this);
    }

    public final void b(boolean r100) {
        Disposable r101 = this.f144298d;
        if (r101 != null) goto L5;
    L7:
        f(new f.b(r100));
        this.f144298d = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new je2.a(this));
        return;
    L5:
        if (r101.isDisposed() == true) goto L7;
        r101.dispose();
        goto L7
    }

    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "seiModel");
        Disposable r101 = this.f144299e;
        if (r101 != null) goto L5;
    L7:
        f(new f.d(r100));
        this.f144299e = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L5:
        if (r101.isDisposed() == true) goto L7;
        r101.dispose();
        goto L7
    }

    public final void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "viewState");
        MutableLiveData r101 = this.f144301g;
        if ((r101 instanceof MutableLiveData) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L8;
        r101.setValue(r100);
        return;
    }

    public static void e(KtvComponentMusicReportInfoManager r100, KtvMusic r101, long r102) {
        Disposable r103 = r100.f144295a;
        if (r103 != null) goto L5;
    L7:
        r100.f(new f.g(r101));
        r100.f144295a = Observable.timer(r102, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r100, null));
        return;
    L5:
        if (r103.isDisposed() == true) goto L7;
        r103.dispose();
        goto L7
    }

    public final void d(KtvMusic r100, long r101, Function0<Unit> r102) {
        Disposable r103 = this.f144296b;
        if (r103 != null) goto L5;
    L7:
        f(new f.C6423f(r100));
        this.f144296b = Observable.timer(r101, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r102));
        return;
    L5:
        if (r103.isDisposed() == true) goto L7;
        r103.dispose();
        goto L7
    }
}
