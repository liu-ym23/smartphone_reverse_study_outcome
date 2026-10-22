package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.audience.SeiLoadPkSource;
import com.bytedance.android.live.revlink.impl.audience.h;
import com.bytedance.android.live.revlink.impl.multianchor.utils.h0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.utils.s;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import f31.k;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiAudienceSeiComponent implements com.bytedance.android.live.revlink.link.biz.service.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f97721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f97722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f97723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.audience.f f97724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.audience.a f97725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f97726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f97727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RevSeiFrame f97728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f97729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b f97730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MultiAnchorLinkContext f97731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f97732l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAudienceSeiComponent f97733a;

        public a(MultiAudienceSeiComponent r100) {
            this.f97733a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            Disposable r102 = this.f97733a.f97732l.f98098b.f97651b;
            if (r102 == null) goto L6;
            r102.dispose();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<RevSeiFrame, Unit> {
        public AnonymousClass1(MultiAudienceSeiComponent r100) {
            super(1, r100, MultiAudienceSeiComponent.class, "onSeiFrameChange", "onSeiFrameChange(Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RevSeiFrame r310) {
            MultiAudienceSeiComponent r100 = (MultiAudienceSeiComponent) this.receiver;
            if (r310 != null) goto L5;
            r100.getClass();
            return;
        L5:
            h r101 = r100.f97723c;
            String r102 = r310.C;
            boolean r103 = r100.f97726f;
            r101.getClass();
            if (r102 != null) goto L8;
        L11:
            boolean r104 = true;
        L13:
            if (r104 == false) goto L16;
            String r110 = " sei=";
            CharSequence r105 = "TTLiveSDK_Windows";
            CharSequence r311 = "TTLiveSDK_IOS";
        L96:
            if (((String) r310.f90923f.getValue()) == null) goto L99;
            i.F(r100).f();
            i.F(r100).e();
        L99:
            if (z41.d.f569904c.B6() == true) goto L101;
        L180:
            r100.a(r310);
            r100.f97728h = r310;
            if (r100.f97726f == false) goto L188;
            com.bytedance.android.live.revlink.impl.settings.live.c r106 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
            r106.getClass();
            if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.f97608m.getValue(r106, com.bytedance.android.live.revlink.impl.settings.live.c.f97596a[11])).booleanValue() == false) goto L188;
            l r107 = l.f267516a;
            String r108 = r310.C;
            if (r108 != null) goto L187;
            r108 = "";
        L187:
            Observable r109 = Observable.just(r108).map(new d(r310)).filter(e.f97762a);
            int r111 = p.f267522a;
            r109.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r100, r310), new g(r100));
            return;
        L188:
            String r112 = r310.C;
            if (StringsKt.contains$default(r112, "TTLiveSDK_Android", false, 2, null) == false) goto L191;
        L196:
            String r113 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r100);
            StringBuilder r114 = new StringBuilder("seiUpdated=");
            r114.append(r100.f97726f);
            r114.append(" intercept sei unload, loadDuration=");
            i97.a r115 = i97.a.f488802a;
            r114.append(System.currentTimeMillis() - r100.f97727g);
            r114.append("ms, ");
            r114.append(r112);
            jy0.b.f(r113, r114.toString(), null, 4);
            return;
        L191:
            if (StringsKt.contains$default(r112, r311, false, 2, null) == true) goto L196;
            if (LiveSeiUtil.b(r112) == true) goto L196;
            if (StringsKt.contains$default(r112, r105, false, 2, null) == true) goto L196;
            return;
        L101:
            if (StringsKt.contains$default(r310.C, "app_data", false, 2, null) == false) goto L180;
            Integer r116 = r310.n();
            if (r116 != null) goto L106;
        L107:
            Intrinsics.checkNotNullParameter(r100, "$this$seiLoadMonitor");
            com.bytedance.android.live.revlink.impl.audience.g r117 = i.getContext(r100).Ee();
            Integer r118 = r310.n();
            if (r118 == null) goto L110;
            int r119 = r118.intValue();
        L111:
            String r120 = r310.C;
            long r121 = r100.f97727g;
            r117.getClass();
            if (r119 == 6) goto L125;
            i97.a r122 = i97.a.f488802a;
            long r123 = System.currentTimeMillis() - r121;
            jy0.b.c("ttlive_revlink_sei", "scene=7 seiVersion=" + r119 + " invalid loadedDuration=" + r123 + r110 + r120, null, 4);
            if (r123 <= 10000) goto L125;
            if ((System.currentTimeMillis() - r117.f92075e) < 60000) goto L125;
            r117.f92075e = System.currentTimeMillis();
            JSONObject r124 = new JSONObject();
            int r125 = y50.b.f566204a;
            y50.b.a.c(r124, "loaded_duration", r123);
            y50.b.a.b(r124, "sei_version", r119);
            y50.b.a.d(r124, "sei_string", r120);
            com.bytedance.android.live.revlink.impl.audience.g.m(r117, "revlink_sei_version_invalid", r124, 7, r119, null, 48);
            com.bytedance.android.live.revlink.impl.global.c r126 = r117.f94912d;
            if (r126 == null) goto L122;
            d31.f r210 = r126.y2();
        L123:
            if (r210 == null) goto L125;
            d31.f.f(r210, "revlink_sei_version_invalid", r119, null, 7, 0, null, null, null, 244);
            goto L125
        L122:
            r210 = null;
        L125:
            com.bytedance.android.live.revlink.impl.audience.f r127 = r100.f97724d;
            String r128 = r310.C;
            JSONObject r129 = r310.d();
            r127.getClass();
            if (r128 != null) goto L128;
        L131:
            boolean r130 = true;
        L132:
            if (r130 == true) goto L179;
            if (r129 == null) goto L179;
            int r131 = r129.optInt("ver");
            if (r131 != 2) goto L138;
        L141:
            boolean r132 = true;
        L142:
            if (r132 == false) goto L179;
            JSONArray r133 = r129.optJSONArray("grids");
            if (r133 != null) goto L147;
        L150:
            jy0.b.d("ttlive_revlink_sei", "sei grids empty, cnt=" + r127.f92070a);
            if (r127.f92072c == true) goto L176;
            if (t.a(r127.f92071b) <= 10000) goto L176;
            if (r127.f92070a <= 3) goto L176;
            com.bytedance.android.live.revlink.impl.global.c r134 = r127.f92073d;
            if (r134 == null) goto L159;
            com.bytedance.android.live.revlink.impl.audience.g r135 = r134.Ee();
        L160:
            if (r135 != null) goto L162;
        L174:
            r127.f92072c = true;
            goto L176
        L162:
            if (r131 != 2) goto L165;
            int r136 = 1;
        L168:
            JSONObject r137 = new JSONObject();
            int r138 = y50.b.f566204a;
            y50.b.a.d(r137, "sei_string", r128);
            com.bytedance.android.live.revlink.impl.audience.g.m(r135, "sei_grids_empty", r137, r136, 0, null, 56);
            com.bytedance.android.live.revlink.impl.global.c r139 = r135.f94912d;
            if (r139 == null) goto L171;
            d31.f r140 = r139.y2();
        L172:
            if (r140 == null) goto L174;
            d31.f.f(r140, "sei_grids_empty", 0, null, r136, 0, null, null, null, 246);
            goto L174
        L171:
            r140 = null;
            goto L172
        L165:
            if (r131 != 6) goto L167;
            r136 = 7;
            goto L168
        L167:
            r136 = 0;
            goto L168
        L159:
            r135 = null;
        L176:
            if (r127.f92070a != 0) goto L178;
            i97.a r141 = i97.a.f488802a;
            r127.f92071b = System.currentTimeMillis();
        L178:
            r127.f92070a++;
            goto L179
        L147:
            if (r133.length() == 0) goto L150;
            r127.f92070a = 0;
            r127.f92071b = 0;
            goto L179
        L138:
            if (r131 == 6) goto L141;
            r132 = false;
        L179:
            r100.a(r310);
            r100.f97728h = r310;
            return;
        L128:
            if (r128.length() == 0) goto L131;
            r130 = false;
            goto L132
        L110:
            r119 = -1;
            goto L111
        L106:
            if (r116.intValue() == 6) goto L125;
        L16:
            if (r103 == false) goto L18;
        L59:
            r110 = " sei=";
        L60:
            r105 = "TTLiveSDK_Windows";
            r311 = "TTLiveSDK_IOS";
        L58:
            boolean r142 = false;
        L62:
            if (r102 != null) goto L64;
        L66:
            boolean r143 = false;
        L67:
            if (r143 == false) goto L96;
            if (StringsKt.contains$default(r102, "\\\"ver\\\":2,", r142, 2, null) == false) goto L96;
            StringBuilder r144 = new StringBuilder("multi link receive pk sei loadedTime=");
            i97.a r145 = i97.a.f488802a;
            r144.append(System.currentTimeMillis() - r101.f92080d);
            r144.append(' ');
            r144.append(r102);
            jy0.b.d("ttlive_pk_sei_unload", r144.toString());
            if ((System.currentTimeMillis() - r101.f92080d) < r101.f92078b.h9()) goto L96;
            r101.f92079c.getClass();
            JSONObject r146 = h0.b(r102);
            if (r146 != null) goto L77;
        L76:
            p0 r147 = null;
        L81:
            if (r147 == null) goto L96;
            if (r147.getVersion() != 2) goto L96;
            jy0.b.d("ttlive_pk_sei_unload", "try unload multi link, launch pk");
            if ((System.currentTimeMillis() - r101.f92081e) < r101.f92078b.A3()) goto L96;
            if (r101.f92077a.a4() == false) goto L96;
            r101.f92081e = System.currentTimeMillis();
            com.bytedance.android.live.revlink.impl.global.c r148 = r101.f92083g;
            if (r148 == null) goto L92;
            IPkAudienceLoadService r149 = r148.Ik();
        L93:
            if (r149 == null) goto L96;
            SeiLoadPkSource r150 = SeiLoadPkSource.NORMAL_SEI;
            r149.a();
            goto L96
        L92:
            r149 = null;
            goto L93
        L77:
            r101.f92079c.getClass();
            JSONObject r151 = h0.a(r146);
            if (r151 == null) goto L76;
            int r152 = s.f97134c;
            r147 = s.a.a(r151, r102);
            goto L81
        L64:
            if (StringsKt.contains$default(r102, "app_data", r142, 2, null) != true) goto L66;
            r143 = true;
            goto L67
        L18:
            if (StringsKt.contains$default(r102, "TTLiveSDK_Android", false, 2, null) == false) goto L20;
        L29:
            boolean r153 = true;
        L30:
            if (r153 == false) goto L59;
            jy0.b.d("ttlive_pk_sei_unload", "scene=7 commonLiveSeiCount=" + r101.f92082f + " sei=" + r102);
            int r154 = r101.f92082f + 1;
            r101.f92082f = r154;
            if (r154 <= r101.f92078b.b2()) goto L59;
            i97.a r155 = i97.a.f488802a;
            r110 = " sei=";
            if ((System.currentTimeMillis() - r101.f92080d) <= r101.f92078b.B5()) goto L60;
            com.bytedance.android.live.revlink.impl.global.c r156 = r101.f92083g;
            if (r156 == null) goto L38;
            com.bytedance.android.live.revlink.impl.audience.g r157 = r156.Ee();
        L39:
            if (r157 == null) goto L49;
            int r158 = r101.f92082f;
            long r159 = System.currentTimeMillis() - r101.f92080d;
            Intrinsics.checkNotNullParameter(r102, "rawSei");
            r105 = "TTLiveSDK_Windows";
            r311 = "TTLiveSDK_IOS";
            if ((System.currentTimeMillis() - r157.f92076f) < 60000) goto L51;
            r157.f92076f = System.currentTimeMillis();
            JSONObject r160 = new JSONObject();
            y50.b.a.b(r160, "sei_count", r158);
            y50.b.a.c(r160, "loaded_time", r159);
            y50.b.a.d(r160, "raw_sei", r102);
            com.bytedance.android.live.revlink.impl.audience.g.m(r157, "sei_backup_unload", r160, 7, 0, null, 56);
            com.bytedance.android.live.revlink.impl.global.c r161 = r157.f94912d;
            if (r161 == null) goto L46;
            d31.f r211 = r161.y2();
        L47:
            if (r211 == null) goto L51;
            d31.f.f(r211, "sei_backup_unload", 0, null, 7, 0, null, null, null, 246);
            goto L51
        L46:
            r211 = null;
        L51:
            if (r101.f92077a.A4() == false) goto L58;
            com.bytedance.android.live.revlink.impl.global.c r162 = r101.f92083g;
            if (r162 == null) goto L55;
            com.bytedance.android.live.revlink.impl.service.internal.a r163 = r162.Do();
        L56:
            if (r163 == null) goto L58;
            r142 = false;
            com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r163, 64, false, 6);
            goto L62
        L55:
            r163 = null;
            goto L56
        L49:
            r105 = "TTLiveSDK_Windows";
            r311 = "TTLiveSDK_IOS";
            goto L51
        L38:
            r157 = null;
            goto L39
        L20:
            if (StringsKt.contains$default(r102, "TTLiveSDK_IOS", false, 2, null) == true) goto L29;
            if (StringsKt.contains$default(r102, "TTLiveSDK_Windows", false, 2, null) == true) goto L29;
            if (StringsKt.contains$default(r102, "\\\"ver\\\":15", false, 2, null) == true) goto L29;
            if (LiveSeiUtil.b(r102) == true) goto L29;
            r153 = false;
            goto L30
        L8:
            if (r102.length() == 0) goto L11;
            r104 = false;
            goto L13
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RevSeiFrame r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass2(MultiAudienceSeiComponent r100) {
            super(1, r100, MultiAudienceSeiComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(f31.f r100) {
            MultiAudienceSeiComponent r101 = (MultiAudienceSeiComponent) this.receiver;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            r101.b(r100);
            r101.f97725e.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(f31.f r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass3(MultiAudienceSeiComponent r100) {
            super(2, r100, MultiAudienceSeiComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            MultiAudienceSeiComponent r102 = (MultiAudienceSeiComponent) this.receiver;
            f31.f r103 = r102.getContext().hh().getValue();
            if (r103 == null) goto L23;
            List<k> r104 = r103.f475330a;
            if (r104 == null) goto L18;
            Iterator<T> r105 = r104.iterator();
        L9:
            if (r105.hasNext() == false) goto L18;
            k r106 = (k) r105.next();
            com.bytedance.android.livesdk.link.model.p r107 = i.t(r102).getGuestInfo(null, r106.f475348a);
            if (r107 == null) goto L16;
            IBaseUser r108 = r107.getUser();
            if (r108 == null) goto L16;
            String r109 = iz.a.a(r108);
            if (r109 == null) goto L16;
        L17:
            Intrinsics.checkNotNullParameter(r109, "<set-?>");
            r106.f475349b = r109;
        L16:
            r109 = "";
        L18:
            r102.b(r103);
            r100.size();
            return;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r100, Integer r101) {
            invoke(r100, r101.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass5(MultiAudienceSeiComponent r100) {
            super(1, r100, MultiAudienceSeiComponent.class, "notifySeiForMonitor", "notifySeiForMonitor(Ljava/lang/String;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String r110) {
            com.bytedance.android.live.revlink.impl.audience.a r100 = ((MultiAudienceSeiComponent) this.receiver).f97725e;
            if (r100.f92056c == false) goto L77;
            r100.f92059f++;
            String r101 = "";
            if (r110 != null) goto L8;
            String r102 = "";
        L9:
            v r103 = null;
            jy0.b.c("RevenueAudienceSeiMonitor", r102, null, 4);
            int r104 = com.bytedance.android.live.revlink.impl.audience.e.f92068a;
            if (r110 != null) goto L12;
            String r105 = "";
        L13:
            Intrinsics.checkNotNullParameter(r105, "str");
            if (StringsKt.contains$default(r105, "TTLiveSDK_", false, 2, null) == false) goto L16;
            Pair r106 = new Pair(1, null);
        L47:
            int r107 = ((Number) r106.component1()).intValue();
            String r108 = (String) r106.component2();
            if (r108 == null) goto L54;
            if (r100.f92057d.size() <= com.bytedance.android.live.revlink.impl.audience.a.b().O4()) goto L52;
            r100.f92057d.removeFirstOrNull();
        L52:
            ArrayDeque<Pair<Long, String>> r109 = r100.f92057d;
            i97.a r111 = i97.a.f488802a;
            r109.addLast(new Pair(Long.valueOf(System.currentTimeMillis()), r108));
        L54:
            if (r107 == 3) goto L56;
            return;
        L56:
            if (r100.f92061h == false) goto L58;
            boolean r112 = com.bytedance.android.live.revlink.impl.audience.a.b().q8();
        L59:
            if (r112 == false) goto L75;
            com.bytedance.android.live.revlink.impl.global.c r113 = r100.f92060g;
            if (r113 == null) goto L63;
            r103 = r113.getMultiLinkMonitor();
        L63:
            if (r103 == null) goto L76;
            JSONObject r114 = new JSONObject();
            int r115 = y50.b.f566204a;
            y50.b.a.b(r114, "error_code", r107);
            if (r108 == null) goto L68;
            r101 = r108;
        L68:
            y50.b.a.d(r114, "sei", r101);
            r103.g(r114);
            r103.I("revenue_audience_illegal_sei", r114, false);
            return;
        L76:
            return;
        L75:
            return;
        L58:
            r112 = com.bytedance.android.live.revlink.impl.audience.a.b().Z8();
            goto L59
        L16:
            int r116 = StringsKt.indexOf$default(r105, "app_data", 0, false, 6, null);
            if (r116 != (-1)) goto L19;
            r106 = new Pair(2, null);
            goto L47
        L19:
            int r117 = r105.length();
        L21:
            if (r116 >= r117) goto L25;
            if (r105.charAt(r116) == '{') goto L25;
            r116 = r116 + 1;
        L25:
            if (r116 < r117) goto L27;
        L29:
            int r118 = -1;
        L30:
            if (r118 != (-1)) goto L33;
            Pair r119 = new Pair(3, r105);
        L32:
            r106 = r119;
            goto L47
        L33:
            int r120 = 0;
        L34:
            if (r116 >= r117) goto L44;
            if (r105.charAt(r116) != '{') goto L39;
            r120 = r120 + 1;
        L41:
            if (r120 == 0) goto L44;
            r116 = r116 + 1;
            goto L34
        L39:
            if (r105.charAt(r116) != '}') goto L41;
            r120 = r120 - 1;
        L44:
            if (r120 != 0) goto L46;
            r106 = new Pair(4, r105.substring(r118, r116 + 1));
            goto L47
        L46:
            r119 = new Pair(3, r105);
            goto L32
        L27:
            if (r105.charAt(r116) != '{') goto L29;
            r118 = r116;
            goto L30
        L12:
            r105 = r110;
            goto L13
        L8:
            r102 = r110;
            goto L9
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.f97729i = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().lb(), new AnonymousClass1(this)), this.f97722b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass2(this)), this.f97722b);
        com.bytedance.revenue.platform.api.core.rx.f.a(i.t(this).m(new AnonymousClass3(this)), this.f97722b);
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().ci().subscribe(new a(this)), this.f97722b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().ul(), new AnonymousClass5(this)), this.f97722b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.f97729i = false;
        this.f97722b.clear();
        this.f97725e.a();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f97721a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.f97730j;
    }

    public final void a(RevSeiFrame r110) {
        Long r100 = r110.e();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.longValue() > (-1)) goto L7;
        return;
    L7:
        Integer r101 = r110.n();
        if (r101 != null) goto L11;
    L12:
        if (r101 != null) goto L15;
        return;
    L15:
        if (r101.intValue() == 2) goto L17;
        return;
    L17:
        boolean r102 = true;
        this.f97726f = true;
        i.F(this).f();
        p0 r103 = r110.b();
        if (r103 == null) goto L40;
        List<RevSeiRegion> r104 = r103.e();
        if (r104 == null) goto L40;
        Iterator<T> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L40;
        RevSeiRegion r106 = (RevSeiRegion) r105.next();
        if (Intrinsics.areEqual(r106.getInteractId(), i.e0(this)) == true) goto L23;
        String r107 = r106.getInteractId();
        if (r107 != null) goto L31;
        r107 = "";
    L31:
        if (StringsKt.startsWith$default(r107, "1_", false, 2, null) == true) goto L35;
        z41.g r108 = z41.g.f569928o;
        r108.getClass();
        if (((Boolean) z41.g.f569926m.getValue(r108, z41.g.f569914a[11])).booleanValue() == true) goto L23;
    L35:
        m r109 = getContext().im();
        if (r106.getStatus() != 0) goto L38;
        boolean r111 = true;
    L39:
        r109.a(r107, r111);
        goto L23
    L38:
        r111 = false;
    L40:
        p0 r112 = r110.b();
        if (r112 == null) goto L56;
        List<RevSeiRegion> r113 = r112.e();
        if (r113 == null) goto L56;
        Iterator<T> r114 = r113.iterator();
    L46:
        if (r114.hasNext() == false) goto L50;
        Object r115 = r114.next();
        if ((!Intrinsics.areEqual(((RevSeiRegion) r115).getInteractId(), i.e0(this))) == false) goto L46;
    L51:
        RevSeiRegion r116 = (RevSeiRegion) r115;
        if (r116 == null) goto L56;
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r117 = i.U(this);
        if (r117 == null) goto L56;
        r117.b("double_mute_status", String.valueOf(r116.getMuteAudio()));
        goto L56
    L50:
        r115 = null;
    L56:
        this.f97726f = true;
        p0 r118 = r110.b();
        if (r118 == null) goto L210;
        List<RevSeiRegion> r119 = r118.e();
        if (r119 == null) goto L211;
        List<RevSeiRegion> r120 = r119;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator r122 = r120.iterator();
    L62:
        if (r122.hasNext() == false) goto L68;
        RevSeiRegion r123 = (RevSeiRegion) r122.next();
        String r124 = r123.getInteractId();
        if (r124 != null) goto L66;
        String r125 = "";
    L67:
        Intrinsics.checkNotNullParameter(r123, "$this$toLinkRegion");
        Intrinsics.checkNotNullParameter(r125, "key");
        r121.add(new pc0.c(r125, (float) r123.getX(), (float) r123.getY(), (float) r123.getWidth(), (float) r123.getHeight()));
        r122 = r122;
        goto L62
    L66:
        r125 = r124;
        goto L67
    L68:
        com.bytedance.android.live.revlink.impl.pk.utils.h r126 = i.q(this);
        p0 r127 = r110.b();
        r126.getClass();
        Intrinsics.checkNotNullParameter(r121, "linkRegions");
        com.bytedance.android.live.revlink.impl.global.c r128 = r126.f97093c;
        if (r128 == null) goto L71;
        RevLinkWindowRegionContext r129 = r128.P8();
    L72:
        if (r129 == null) goto L181;
        com.bytedance.android.live.revlink.impl.region.c r130 = r129.getRevStreamRegionUpdater();
        if (r130 == null) goto L181;
        Intrinsics.checkNotNullParameter(r121, "linkRegions");
        if (r127 == null) goto L78;
        List<RevSeiRegion> r131 = r127.e();
    L79:
        p0 r132 = r130.f97499a;
        if (r132 == null) goto L82;
        List<RevSeiRegion> r133 = r132.e();
    L83:
        if (r131 != null) goto L86;
        if (r133 != null) goto L86;
    L158:
        if (r102 == true) goto L181;
        com.bytedance.android.live.revlink.impl.global.c r134 = r130.f97502d;
        if (r134 == null) goto L162;
        RevLinkWindowRegionContext r135 = r134.P8();
    L163:
        if (r135 == null) goto L165;
        r135.clearStreamRegion();
    L165:
        Iterator r136 = r121.iterator();
    L167:
        if (r136.hasNext() == false) goto L174;
        pc0.c r137 = (pc0.c) r136.next();
        com.bytedance.android.live.revlink.impl.global.c r138 = r130.f97502d;
        if (r138 == null) goto L171;
        RevLinkWindowRegionContext r139 = r138.P8();
    L172:
        if (r139 == null) goto L167;
        r139.updateStreamRegion(r137.f528461a, r137);
        goto L167
    L171:
        r139 = null;
        goto L172
    L174:
        com.bytedance.android.live.revlink.impl.global.c r140 = r130.f97502d;
        if (r140 == null) goto L177;
        RevLinkWindowRegionContext r141 = r140.P8();
    L178:
        if (r141 == null) goto L180;
        r141.notifyStreamRegionUpdate();
    L180:
        r130.f97499a = r127;
        goto L181
    L177:
        r141 = null;
        goto L178
    L162:
        r135 = null;
    L86:
        if (r131 == null) goto L88;
        Integer r142 = Integer.valueOf(r131.size());
    L89:
        if (r133 == null) goto L91;
        Integer r143 = Integer.valueOf(r133.size());
    L93:
        if ((!Intrinsics.areEqual(r142, r143)) == true) goto L156;
        if (r131 == null) goto L158;
        if (r133 == null) goto L158;
        int r144 = r131.size();
        int r145 = 0;
    L98:
        if (r145 >= r144) goto L158;
        RevSeiRegion r146 = (RevSeiRegion) ListProtector.get(r131, r145);
        RevSeiRegion r147 = (RevSeiRegion) ListProtector.get(r133, r145);
        if (r146 != null) goto L103;
        if (r147 != null) goto L103;
    L153:
        boolean r148 = true;
    L155:
        if (r148 == false) goto L156;
        r145 = r145 + 1;
    L103:
        if (Intrinsics.areEqual(r146, r147) == true) goto L153;
        if (r146 == null) goto L107;
        Double r149 = Double.valueOf(r146.getX());
    L108:
        if (r147 == null) goto L110;
        Double r150 = Double.valueOf(r147.getX());
    L112:
        if (Intrinsics.areEqual(r149, r150) == false) goto L154;
        if (r146 == null) goto L115;
        Double r151 = Double.valueOf(r146.getY());
    L116:
        if (r147 == null) goto L118;
        Double r152 = Double.valueOf(r147.getY());
    L120:
        if (Intrinsics.areEqual(r151, r152) == false) goto L154;
        if (r146 == null) goto L123;
        String r153 = r146.getUidStr();
    L124:
        if (r147 == null) goto L126;
        String r154 = r147.getUidStr();
    L128:
        if (Intrinsics.areEqual(r153, r154) == false) goto L154;
        if (r146 == null) goto L131;
        Long r155 = Long.valueOf(r146.getUid());
    L132:
        if (r147 == null) goto L134;
        Long r156 = Long.valueOf(r147.getUid());
    L136:
        if (Intrinsics.areEqual(r155, r156) == false) goto L154;
        if (r146 == null) goto L139;
        Double r157 = Double.valueOf(r146.getWidth());
    L140:
        if (r147 == null) goto L142;
        Double r158 = Double.valueOf(r147.getWidth());
    L144:
        if (Intrinsics.areEqual(r157, r158) == false) goto L154;
        if (r146 == null) goto L147;
        Double r159 = Double.valueOf(r146.getHeight());
    L148:
        if (r147 == null) goto L150;
        Double r160 = Double.valueOf(r147.getHeight());
    L152:
        if (Intrinsics.areEqual(r159, r160) == false) goto L154;
    L150:
        r160 = null;
        goto L152
    L147:
        r159 = null;
        goto L148
    L142:
        r158 = null;
        goto L144
    L139:
        r157 = null;
        goto L140
    L134:
        r156 = null;
        goto L136
    L131:
        r155 = null;
        goto L132
    L126:
        r154 = null;
        goto L128
    L123:
        r153 = null;
        goto L124
    L118:
        r152 = null;
        goto L120
    L115:
        r151 = null;
    L154:
        r148 = false;
        goto L155
    L110:
        r150 = null;
        goto L112
    L107:
        r149 = null;
    L156:
        r102 = false;
        goto L158
    L91:
        r143 = null;
        goto L93
    L88:
        r142 = null;
        goto L89
    L82:
        r133 = null;
        goto L83
    L78:
        r131 = null;
    L181:
        MultiAudienceSeiComponent$logUILayoutChange$1 r161 = MultiAudienceSeiComponent$logUILayoutChange$1.INSTANCE;
        Integer r162 = r110.m();
        if (r162 == null) goto L184;
        int r163 = r162.intValue();
    L185:
        MultiAudienceSeiComponent$logUILayoutChange$1.invoke$default(r161, r163, false, 2, null);
        i.F(this).e();
        return;
    L184:
        r163 = 0;
        goto L185
    L71:
        r129 = null;
        goto L72
    L211:
        return;
    L210:
        return;
    L11:
        if (r101.intValue() == 6) goto L17;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revlink.impl.utils.e0] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    public final void b(f31.f r100) {
        Intrinsics.checkNotNullParameter(this, "$this$windowDiffCheckUtil");
        ?? r101 = i.getContext(this).w6();
        if (r100 == null) goto L10;
        List<k> r102 = r100.f475330a;
        if (r102 == null) goto L10;
        List<k> r103 = r102;
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        r104.add(new b((k) r105.next()));
    L11:
        r101.a(r104);
        return;
    L10:
        r104 = CollectionsKt.emptyList();
        goto L11
    }

    public MultiAudienceSeiComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r100, MultiAnchorLinkContext r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "linkContext");
        Intrinsics.checkNotNullParameter(r102, "bizDataContext");
        this.f97730j = r100;
        this.f97731k = r101;
        this.f97732l = r102;
        this.f97721a = "MultiAudienceSeiComponent";
        this.f97722b = new CompositeDisposable();
        this.f97723c = new h(getContext());
        this.f97724d = new com.bytedance.android.live.revlink.impl.audience.f(getContext());
        com.bytedance.android.live.revlink.impl.audience.a r103 = new com.bytedance.android.live.revlink.impl.audience.a(getContext());
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r104 = i.E(this);
        if (r104 == null) goto L5;
        com.bytedance.android.live.revlink.impl.audience.c r105 = r104.f92436b;
    L7:
        if (Intrinsics.areEqual(r105, com.bytedance.android.live.revlink.impl.audience.c.b.f92066b) == false) goto L10;
        int r106 = 1;
    L16:
        r103.f92056c = true;
        long r107 = com.bytedance.android.live.revlink.impl.audience.a.b().a1();
        boolean r108 = com.bytedance.android.live.revlink.impl.audience.a.b().H3();
        l r109 = l.f267516a;
        int r110 = p.f267522a;
        Scheduler r111 = Schedulers.computation();
        r103.f92054a = Observable.timer(r107, TimeUnit.MILLISECONDS, r111).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.audience.b(r103, r108));
        i97.a r112 = i97.a.f488802a;
        r103.f92055b = System.currentTimeMillis();
        r103.f92058e = r106 | r103.f92058e;
        Unit r113 = Unit.INSTANCE;
        this.f97725e = r103;
        this.f97727g = System.currentTimeMillis();
        return;
    L10:
        if (Intrinsics.areEqual(r105, com.bytedance.android.live.revlink.impl.audience.c.a.f92065b) == false) goto L13;
        r106 = 2;
        goto L16
    L13:
        if (Intrinsics.areEqual(r105, com.bytedance.android.live.revlink.impl.audience.c.C1433c.f92067b) == false) goto L15;
        r106 = 3;
        goto L16
    L15:
        r106 = 0;
        goto L16
    L5:
        r105 = null;
        goto L7
    }
}
