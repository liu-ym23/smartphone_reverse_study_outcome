package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "", "getAddedLyricsLineByLine", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvAudienceLyricsDisplayView extends KtvAnchorLyricsDisplayView {
    public long K;
    public final HashSet<Integer> L;
    public Disposable M;
    public boolean N;
    public boolean O;
    public final List<a> P;
    public final Subject<Long> Q;
    public Disposable R;

    public interface a {
        void a();
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvAudienceLyricsDisplayView f143607a;

        public b(KtvAudienceLyricsDisplayView r100) {
            this.f143607a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            KtvAudienceLyricsDisplayView r102 = this.f143607a;
            r102.getClass();
            r102.e(r101.longValue());
            KtvAudienceLyricsDisplayView r103 = this.f143607a;
            r101.longValue();
            Iterator r104 = ((ArrayList) r103.P).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((a) r104.next()).a();
            goto L4
        }
    }

    public static final class c<T> implements Consumer {
        public c(KtvAudienceLyricsDisplayView r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = "lyrics latestOnly consumer error: " + r101.getClass().getSimpleName() + ':' + r101.getMessage();
            ALogger.i(bb0.b.b(), r102 + ", invoke class :KtvAudienceLyricsDisplayView");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvAudienceLyricsDisplayView f143608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f143609b;

        public d(KtvAudienceLyricsDisplayView r100, long r101) {
            this.f143608a = r100;
            this.f143609b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f143608a.K += this.f143609b;
            if (h.N() == false) goto L5;
            this.f143608a.g("timer_tick");
            KtvAudienceLyricsDisplayView r102 = this.f143608a;
            r102.Q.onNext(Long.valueOf(r102.K));
            return;
        L5:
            this.f143608a.k("switch_off");
            KtvAudienceLyricsDisplayView r103 = this.f143608a;
            r103.e(r103.K);
            KtvAudienceLyricsDisplayView r104 = this.f143608a;
            long r105 = r104.K;
            Iterator r106 = ((ArrayList) r104.P).iterator();
        L7:
            if (r106.hasNext() == false) goto L11;
            ((a) r106.next()).a();
            goto L7
        }
    }

    public KtvAudienceLyricsDisplayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvAudienceLyricsDisplayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void h() {
        this.f143582d = false;
        this.f143581c = 0;
        this.f143580b = 0;
        this.f143592n = 0;
        Iterator r100 = ((LinkedHashMap) this.f143579a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function1) ((Map.Entry) r100.next()).getValue()).invoke(0L);
        goto L4
    L6:
        this.f143583e.clear();
        Disposable r101 = this.M;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.M = null;
        k("release");
        getLyricsLineInfos().clear();
        this.L.clear();
        this.K = 0;
        this.N = true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView
    public int getAddedLyricsLineByLine() {
        if (this.L.isEmpty() == false) goto L6;
        return 0;
    L6:
        return getLyricsLineInfos().size();
    }

    public final void j() {
        Disposable r100 = this.M;
        if (r100 == null) goto L9;
        if (r100.isDisposed() == true) goto L9;
        return;
    L9:
        if (h.N() == false) goto L11;
        long r101 = h.K();
    L12:
        this.M = du2.a.b(0, r101, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r101));
        return;
    L11:
        r101 = 33;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.M;
        if (r100 != null) goto L5;
    L11:
        k("detach");
        this.M = null;
        this.R = null;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        if (((Boolean) h.N3.getValue(null, h.f556082a[246(0xf6, float:3.45E-43)])).booleanValue() != true) goto L11;
        Disposable r101 = this.M;
        if (r101 == null) goto L11;
        r101.dispose();
        goto L11
    }

    public final void g(String r100) {
        if (h.N() == true) goto L6;
        k("switch_off");
        return;
    L6:
        Disposable r101 = this.R;
        if (r101 != null) goto L9;
    L11:
        this.R = this.Q.toFlowable(BackpressureStrategy.LATEST).onBackpressureLatest().throttleLatest(h.K(), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread(), true).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        String r102 = "lyrics latestOnly consumer start:".concat(r100);
        ALogger.i(bb0.b.b(), r102 + ", invoke class :KtvAudienceLyricsDisplayView");
        return;
    L9:
        if (r101.isDisposed() == true) goto L11;
    }

    public final void i(int r100) {
        String r101 = bb0.b.b();
        ALogger.i(r101, ("sendCommand:" + r100) + ", invoke class :KtvAudienceLyricsDisplayView");
        if (r100 == 0) goto L21;
        if (r100 != 3) goto L7;
        this.O = false;
        h();
        j();
        return;
    L7:
        if (r100 != 4) goto L9;
        this.O = true;
        Disposable r102 = this.M;
        if (r102 == null) goto L18;
        r102.dispose();
    L18:
        this.M = null;
        k("song_pause");
        return;
    L9:
        if (r100 != 5) goto L11;
        this.O = false;
        j();
        return;
    L11:
        if (r100 != 6) goto L29;
        h();
        invalidate();
        return;
    L29:
        return;
    L21:
        if (this.O == true) goto L28;
        j();
        return;
    }

    public final void k(String r100) {
        Disposable r101 = this.R;
        if (r101 != null) goto L5;
    L10:
        this.R = null;
        return;
    L5:
        if (r101.isDisposed() == true) goto L10;
        Disposable r102 = this.R;
        if (r102 == null) goto L9;
        r102.dispose();
    L9:
        String r103 = "lyrics latestOnly consumer stop:".concat(r100);
        ALogger.i(bb0.b.b(), r103 + ", invoke class :KtvAudienceLyricsDisplayView");
        goto L10
    }

    public KtvAudienceLyricsDisplayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.L = new HashSet();
        this.N = true;
        this.P = new ArrayList();
        this.Q = PublishSubject.create().toSerialized();
        ((Boolean) h.L3.getValue(null, h.f556082a[244(0xf4, float:3.42E-43)])).booleanValue();
    }

    public final void f(int r210, com.bytedance.component.lyric.model.b r211, long r212) {
        Intrinsics.checkNotNullParameter(r211, "lyricsLineInfo");
        if (getHasAddedFullLyrics() == false) goto L5;
        return;
    L5:
        if (this.L.contains(Integer.valueOf(r210)) == true) goto L127;
        Intrinsics.checkNotNullParameter(r211, "lyricsLineInfo");
        String r100 = r211.f203031d;
        Paint r101 = new Paint();
        if (this.f143599u != 0.0f) goto L13;
        if (getMeasuredWidth() <= 0) goto L13;
        setOneLineMaxWidth(getMeasuredWidth());
    L15:
        r101.setTextSize(this.f143584f.getTextSize() * 1.1f);
        float r102 = this.f143599u - r101.measureText("   ");
        int r103 = getAddedLyricsLineByLine();
        if (r101.measureText(r100) > r102) goto L18;
    L90:
        int r104 = this.f143581c + 1;
        this.f143581c = r104;
        if (r103 >= r104) goto L93;
        this.f143583e.add(r211);
    L93:
        this.L.add(Integer.valueOf(r210));
        this.K = r212;
        System.currentTimeMillis();
        if (getConfig().f549322o == 4) goto L96;
        boolean r105 = true;
    L97:
        if (r105 == true) goto L99;
        return;
    L99:
        if (this.N == true) goto L101;
        return;
    L101:
        if (getLyricsLineInfos().size() > 0) goto L103;
    L105:
        boolean r106 = false;
    L106:
        this.N = r106;
        return;
    L103:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), 0)).f203029b <= 3000) goto L105;
        com.bytedance.component.lyric.model.b r107 = new com.bytedance.component.lyric.model.b();
        r107.f203035h = true;
        r107.f203029b = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), 0)).f203029b - 3000;
        r107.f203031d = "...";
        r107.f203033f = new String[]{".", ".", "."};
        r107.f203034g = new int[]{1000, 1000, 1000};
        r106 = false;
        ListProtector.add(getLyricsLineInfos(), 0, r107);
        setCurToAddLineIndex(getCurToAddLineIndex() + 1);
        goto L106
    L96:
        r105 = false;
        goto L97
    L18:
        if (r211.f203035h == true) goto L90;
        int r108 = this.f143591m;
        if (r108 != 2) goto L38;
        com.bytedance.component.lyric.model.b r109 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r110 = new com.bytedance.component.lyric.model.b();
        StringBuilder r111 = new StringBuilder();
        StringBuilder r112 = new StringBuilder();
        StringBuilder r113 = new StringBuilder();
        String r114 = r211.f203031d;
        if (r114 == null) goto L93;
        int r115 = r114.length();
        int r116 = 0;
    L25:
        if (r116 >= r115) goto L31;
        char r117 = r114.charAt(r116);
        r111.append(r117);
        if (r101.measureText(r111.toString()) <= r102) goto L29;
        r113.append(r117);
    L30:
        r116 = r116 + 1;
        goto L25
    L29:
        r112.append(r117);
        goto L30
    L31:
        r109.f203029b = r211.f203029b;
        r109.f203031d = r112.toString();
        int r118 = this.f143581c + 1;
        this.f143581c = r118;
        if (r103 >= r118) goto L34;
        this.f143583e.add(r109);
    L34:
        r110.f203029b = r211.f203029b + 4000;
        r110.f203031d = r113.toString();
        int r119 = this.f143581c + 1;
        this.f143581c = r119;
        if (r103 >= r119) goto L93;
        this.f143583e.add(r110);
        goto L93
    L38:
        if (r108 != 3) goto L93;
        com.bytedance.component.lyric.model.b r120 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r121 = new com.bytedance.component.lyric.model.b();
        StringBuilder r122 = new StringBuilder();
        String[] r123 = r211.f203033f;
        if (r123 == null) goto L93;
        ArrayList r124 = new ArrayList();
        ArrayList r125 = new ArrayList();
        ArrayList r126 = new ArrayList();
        StringBuilder r127 = new StringBuilder();
        StringBuilder r128 = new StringBuilder();
        ArrayList r129 = new ArrayList();
        int r130 = r211.f203029b;
        int r131 = r123.length;
        int r132 = r130;
        int r133 = 0;
    L42:
        if (r133 >= r131) goto L56;
        int r134 = r131;
        String r135 = r123[r133];
        r122.append(r135);
        String[] r136 = r123;
        if (r101.measureText(r122.toString()) <= r102) goto L50;
        r126.add(r135);
        r128.append(r135);
        int[] r137 = r211.f203034g;
        if (r137 == null) goto L55;
        if (r133 >= r137.length) goto L55;
        r129.add(Integer.valueOf(r137[r133]));
    L55:
        r133 = r133 + 1;
        r131 = r134;
        r123 = r136;
        goto L42
    L50:
        r124.add(r135);
        r127.append(r135);
        int[] r138 = r211.f203034g;
        if (r138 == null) goto L55;
        if (r133 >= r138.length) goto L55;
        r125.add(Integer.valueOf(r138[r133]));
        r132 = r132 + r138[r133];
        goto L55
    L56:
        r120.f203029b = r211.f203029b;
        Object[] r139 = r124.toArray(new String[0]);
        if (r139 == null) goto L89;
        r120.f203033f = (String[]) r139;
        r120.f203034g = new int[r125.size()];
        int r140 = r125.size();
        int r141 = 0;
    L59:
        if (r141 >= r140) goto L65;
        int[] r142 = r120.f203034g;
        if (r142 == null) goto L63;
        r142[r141] = ((Number) ListProtector.get(r125, r141)).intValue();
    L63:
        r141 = r141 + 1;
        goto L59
    L65:
        if (this.H == false) goto L71;
        String r143 = r127.toString();
        if (r143 == null) goto L70;
        r120.f203031d = StringsKt.trim(r143).toString();
    L72:
        int r144 = this.f143581c + 1;
        this.f143581c = r144;
        if (r103 >= r144) goto L75;
        this.f143583e.add(r120);
    L75:
        r121.f203029b = r132;
        Object[] r145 = r126.toArray(new String[0]);
        if (r145 == null) goto L87;
        r121.f203033f = (String[]) r145;
        r121.f203034g = new int[r129.size()];
        int r146 = r129.size();
        int r147 = 0;
    L78:
        if (r147 >= r146) goto L83;
        int[] r148 = r121.f203034g;
        if (r148 == null) goto L82;
        r148[r147] = ((Number) ListProtector.get(r129, r147)).intValue();
    L82:
        r147 = r147 + 1;
        goto L78
    L83:
        r121.f203031d = r128.toString();
        int r149 = this.f143581c + 1;
        this.f143581c = r149;
        if (r103 >= r149) goto L93;
        this.f143583e.add(r121);
        goto L93
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L71:
        r120.f203031d = r127.toString();
        goto L72
    L89:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        if (this.f143599u != 0.0f) goto L15;
        setOneLineMaxWidth(t6.a(getContext(), 240.0f));
        goto L15
    }

    public /* synthetic */ KtvAudienceLyricsDisplayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
