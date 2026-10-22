package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class QuickShotPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoViewParams f112448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f112449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f112450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRoom f112451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f112452e;

    public static final class a {
    }

    public interface b {
        PopupWindow Xc(long r100, Bitmap r101, VideoViewParams r102);

        void vp(long r100, int r101, String r102);

        void ya(String r100, long r101, Bitmap r102, VideoViewParams r103);
    }

    public static final class c implements o60.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickShotPresenter f112453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f112454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bitmap f112455c;

        @Override // o60.e
        public final void onPermissionDenied(String... r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            this.f112453a.c(this.f112454b, this.f112455c);
        }

        public c(QuickShotPresenter r100, long r101, Bitmap r102) {
            this.f112453a = r100;
            this.f112454b = r101;
            this.f112455c = r102;
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickShotPresenter f112456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f112457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f112458c;

        public d(QuickShotPresenter r100, Bitmap r101, long r102) {
            this.f112456a = r100;
            this.f112457b = r101;
            this.f112458c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final Bitmap call() {
            long r100 = System.currentTimeMillis();
            int r101 = oo1.i.f524556a;
            Bitmap r102 = this.f112457b;
            yr1.p r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.w();
            QuickShotPresenter r104 = this.f112456a;
            Context r105 = r104.f112449b;
            IBaseUser r106 = r104.f112451d.getOwner();
            if (r106 == null) goto L6;
            String r107 = r106.getNickName();
            if (r107 == null) goto L6;
        L7:
            View r108 = r103.getQuickShotWatermark(r105, r107);
            vr1.u r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, null, 3);
            if (r109 == null) goto L18;
            Room r110 = r109.j0();
            if (r110 == null) goto L18;
            VSRoom r111 = (VSRoom) r110.castToOrNull(VSRoom.class);
            if (r111 == null) goto L18;
            EpisodeExtraInfo r112 = r111.getEpisodeExtra();
            if (r112 == null) goto L18;
            if (r112.getStyle() != 2) goto L18;
            float r113 = 0.03f;
        L19:
            Intrinsics.checkNotNullParameter(r102, SimplayerImageStrategy.RESULT_BITMAP);
            if (r108 != null) goto L22;
        L25:
            long r114 = System.currentTimeMillis();
            long r115 = this.f112458c;
            long r116 = r114 - r100;
            int r117 = r9.f113944a;
            vr1.o r118 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
            Map<String, String> r119 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r115)), TuplesKt.to("duration", String.valueOf(r116))});
            am2.x r120 = new am2.x();
            r120.f4349a = "live";
            r120.f4353e = "other";
            r120.f4350b = "live_detail";
            r118.sendLog("livesdk_quick_shot_generate_frame", r119, new Object[]{r120, IRoom.class});
            return r102;
        L22:
            if (r102.getConfig() == null) goto L25;
            r108.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            Bitmap r121 = Bitmap.createBitmap(r108.getMeasuredWidth(), r108.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas r122 = new Canvas(r121);
            r108.layout(0, 0, r108.getMeasuredWidth(), r108.getMeasuredHeight());
            r108.draw(r122);
            int r123 = (int) (r102.getHeight() * r113);
            float r124 = r108.getMeasuredWidth() / r108.getMeasuredHeight();
            float r125 = r123;
            Bitmap r126 = Bitmap.createScaledBitmap(r121, (int) (r124 * r125), r123, false);
            int r127 = r102.getWidth();
            int r128 = r102.getHeight();
            Bitmap.Config r129 = r102.getConfig();
            Intrinsics.checkNotNull(r129);
            Bitmap r130 = Bitmap.createBitmap(r127, r128, r129);
            Canvas r131 = new Canvas(r130);
            r131.drawBitmap(r102, 0.0f, 0.0f, null);
            r131.drawBitmap(r126, 0.0f, r102.getHeight() - r125, null);
            r126.recycle();
            r121.recycle();
            r102 = r130;
        L18:
            r113 = 0.07f;
        L6:
            r107 = "";
            goto L7
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickShotPresenter f112459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f112460b;

        public e(QuickShotPresenter r100, long r101) {
            this.f112459a = r100;
            this.f112460b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            QuickShotPresenter r102 = this.f112459a;
            return new v5(r101, r102.f112452e.Xc(this.f112460b, r101, r102.f112448a));
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickShotPresenter f112461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f112462b;

        public f(QuickShotPresenter r100, long r101) {
            this.f112461a = r100;
            this.f112462b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            v5 r111 = (v5) r110;
            long r100 = System.currentTimeMillis();
            String r101 = com.bytedance.android.livesdk.chatroom.utils.m2.a(this.f112461a.f112449b, r111.f114267a, "douyin_quick_screenshot");
            long r102 = System.currentTimeMillis();
            DataCenter r103 = this.f112461a.f112450c;
            if (r103 != null) goto L5;
        L7:
            QuickShotPresenter r104 = this.f112461a;
            r104.f112452e.ya(r101, this.f112462b, r111.f114267a, r104.f112448a);
            long r105 = this.f112462b;
            boolean r112 = !TextUtils.isEmpty(r101);
            long r106 = r102 - r100;
            int r107 = r9.f113944a;
            vr1.o r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
            Pair[] r109 = new Pair[3];
            if (r112 == false) goto L10;
            String r113 = "1";
        L11:
            r109[0] = TuplesKt.to("status", r113);
            r109[1] = TuplesKt.to("sessionId", String.valueOf(r105));
            r109[2] = TuplesKt.to("duration", String.valueOf(r106));
            Map<String, String> r114 = MapsKt.mapOf(r109);
            am2.x r115 = new am2.x();
            r115.f4349a = "live";
            r115.f4353e = "other";
            r115.f4350b = "live_detail";
            r108.sendLog("livesdk_quick_shot_save_frame", r114, new Object[]{r115, IRoom.class});
            return;
        L10:
            r113 = "2";
            goto L11
        L5:
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r103, true) != true) goto L7;
            com.bytedance.android.live.core.utils.f2.c("快拍海报保存成功", 0);
            goto L7
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickShotPresenter f112463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f112464b;

        public g(QuickShotPresenter r100, long r101) {
            this.f112463a = r100;
            this.f112464b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            b r102 = this.f112463a.f112452e;
            long r103 = this.f112464b;
            int r104 = com.bytedance.android.livesdk.chatroom.utils.n.a(r101);
            String r105 = r101.getMessage();
            if (r105 != null) goto L5;
            r105 = "";
        L5:
            r102.vp(r103, r104, r105);
        }
    }

    static {
    }

    public final void b(final long r110) {
        Context r100 = this.f112449b;
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        final Activity r101 = (Activity) r100;
        if (r101 == null) goto L11;
        final long r102 = System.currentTimeMillis();
        int r103 = bs1.a.f20221a;
        ILivePlayerClient r104 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        if (r104 == null) goto L12;
        r104.saveFrame(new QuickShotPresenter$onClickQuickShotBtn$$inlined$apply$lambda$2(r101, r102, this, r110));
        return;
    L12:
        return;
    }

    public final void c(long r100, Bitmap r101) {
        if (r101 == null) goto L10;
        DataCenter r102 = this.f112450c;
        if (r102 == null) goto L7;
        VideoViewParams r103 = (VideoViewParams) r102.get("live_render_view_params", null);
        if (r103 == null) goto L7;
    L8:
        this.f112448a = r103;
        Observable.fromCallable(new d(this, r101, r100)).compose(RxUtil.rxSchedulerHelper()).subscribeOn(AndroidSchedulers.mainThread()).map(new e(this, r100)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new f(this, r100), new g(this, r100));
        return;
    L7:
        r103 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L8
    }

    public QuickShotPresenter(Context r100, DataCenter r101, IRoom r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "currentContext");
        Intrinsics.checkNotNullParameter(r101, "currentDataCenter");
        Intrinsics.checkNotNullParameter(r102, "mRoom");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f112449b = r100;
        this.f112450c = r101;
        this.f112451d = r102;
        this.f112452e = r103;
        this.f112448a = new VideoViewParams(0, 0, 0, 0.0f);
    }

    public final void a(Activity r100, Bitmap r101, long r102, long r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "it");
        long r103 = System.currentTimeMillis() - r110;
        int r111 = r9.f113944a;
        vr1.o r112 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
        boolean r104 = false;
        Map<String, String> r113 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r102)), TuplesKt.to("duration", String.valueOf(r103))});
        am2.x r105 = new am2.x();
        r105.f4349a = "live";
        r105.f4353e = "other";
        r105.f4350b = "live_detail";
        r112.sendLog("livesdk_quick_shot_catch_frame", r113, new Object[]{r105, IRoom.class});
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        if (r104 == false) goto L9;
    L11:
        c(r102, r101);
        return;
    L9:
        if (m60.c.d(r100, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) == true) goto L11;
        SettingKey<Boolean> r114 = m60.i.f512260a;
        new m60.i.b(r100).b(new c(this, r102, r101), null, TokenCert.Companion.with("bpea-live_quick_shot_request_permission"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        return;
    L5:
        if (r100.getApplicationInfo().targetSdkVersion < 30) goto L7;
        r104 = true;
        goto L7
    }
}
