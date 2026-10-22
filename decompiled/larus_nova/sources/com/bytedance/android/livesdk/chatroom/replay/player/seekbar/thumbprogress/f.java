package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.replay.player.seekbar.ReplaySeekBar;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public final ViewGroup A;
    public final int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f109774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f109775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f109776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f109777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f109778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f109779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f109780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f109781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f109782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f109783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f109784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VideoModel f109785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f109786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f109787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f109788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f109789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f109790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f109791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile int f109792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CompositeDisposable f109793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Animator f109794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Animator f109795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f109796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Context f109797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final PlayerProgressServiceContext f109798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c f109799z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f109800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f109801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f109802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f109803d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f109800a == r101.f109800a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f109801b, r101.f109801b) == true) goto L10;
            return false;
        L10:
            if (this.f109802c == r101.f109802c) goto L12;
            return false;
        L12:
            if (this.f109803d == r101.f109803d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f109800a * 31;
            Drawable r101 = this.f109801b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (((r100 + r102) * 31) + this.f109802c) * 31;
            long r104 = this.f109803d;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ThumbDrawableInfo(status=" + this.f109800a + ", drawable=" + this.f109801b + ", thumbIndex=" + this.f109802c + ", startLoadTimeStamp=" + this.f109803d + ")";
        }

        public b(int r100, RoundedBitmapDrawable r101, int r102, long r103) {
            this.f109800a = r100;
            this.f109801b = r101;
            this.f109802c = r102;
            this.f109803d = r103;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a.InterfaceC1654a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f109804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f109805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f109806c;

        @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a.InterfaceC1654a
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a.InterfaceC1654a
        public final void onPause() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a.InterfaceC1654a
        public final void onFail() {
            this.f109804a.j();
            StringBuilder r100 = new StringBuilder("tryDownloadThumb for ");
            String r101 = this.f109804a.g();
            if (r101 != null) goto L5;
            r101 = "null";
        L5:
            r100.append(r101);
            r100.append(':');
            r100.append(this.f109805b);
            r100.append(" fail!!!!");
            ALogger.e("ThumbProcessViewHolder", r100.toString());
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a.InterfaceC1654a
        public final void onSuccess() {
            StringBuilder r100 = new StringBuilder("tryDownloadThumb for ");
            String r101 = this.f109804a.g();
            if (r101 != null) goto L5;
            r101 = "null";
        L5:
            r100.append(r101);
            r100.append(':');
            r100.append(this.f109805b);
            r100.append(" success,cost:");
            r100.append(System.currentTimeMillis() - this.f109806c);
            ALogger.d("ThumbProcessViewHolder", r100.toString());
            this.f109804a.j();
        }

        public c(f r100, List r101, long r102) {
            this.f109804a = r100;
            this.f109805b = r101;
            this.f109806c = r102;
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f109807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f109808b;

        public d(f r100, Ref.BooleanRef r101) {
            this.f109807a = r100;
            this.f109808b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<b> r110) {
            Intrinsics.checkNotNullParameter(r110, "emitter");
            this.f109807a.f109788o = System.currentTimeMillis();
            f r100 = this.f109807a;
            int r101 = r100.f109790q;
            boolean r102 = true;
            r100.f109792s++;
            ALogger.d("ThumbProcessViewHolder", "loadThumbs:start load for " + this.f109807a.g() + "-[" + r101 + "],now TaskCount:" + this.f109807a.f109792s);
            f r103 = this.f109807a;
            com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c r104 = r103.f109799z;
            Context r105 = r103.f109797x;
            String r106 = r103.g();
            VideoThumbInfo r107 = this.f109807a.f();
            r104.getClass();
            Bitmap r111 = null;
            if (r105 == null) goto L34;
            if (r107 == null) goto L34;
            if (r106 == null) goto L34;
            Rect r112 = new Rect();
            int r113 = r107.getValueInt(5);
            int r114 = r107.getValueInt(6);
            int r115 = r107.getValueInt(3);
            int r116 = r107.getValueInt(4);
            int r108 = r107.getValueInt(0);
            if ((r101 + 1) <= r108) goto L10;
            int r109 = r108 - 1;
        L11:
            int r117 = r114 * r113;
            int r118 = r109 / r117;
            int r119 = r109 % r117;
            int r120 = (r119 % r113) * r115;
            r112.left = r120;
            int r121 = (r119 / r113) * r116;
            r112.top = r121;
            r112.right = r120 + r115;
            r112.bottom = r121 + r116;
            String r122 = com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.b.a(r105).getPath();     // Catch: FileNotFoundException -> L33
            StringBuilder r123 = new StringBuilder();     // Catch: FileNotFoundException -> L33
            r123.append(r122);     // Catch: FileNotFoundException -> L33
            r123.append("/live_longvideo_thumb/");     // Catch: FileNotFoundException -> L33
            r123.append(r106);     // Catch: FileNotFoundException -> L33
            r123.append(HTTP.URL_DEFAULT);     // Catch: FileNotFoundException -> L33
            if (r118 < 0) goto L23;
            int r124 = com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r107);     // Catch: FileNotFoundException -> L33
            if (r124 == 1) goto L25;
            if (r124 != 2) goto L23;
            if (r107.mImgUrlList.size() <= r118) goto L23;
            String r125 = (String) ListProtector.get(r107.mImgUrlList, r118);     // Catch: FileNotFoundException -> L33
        L31:
            r123.append(com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.b(r125));     // Catch: FileNotFoundException -> L33
            BitmapRegionDecoder r126 = BitmapRegionDecoder.newInstance(r123.toString(), false);     // Catch: FileNotFoundException -> L33
            Bitmap r127 = r126.decodeRegion(r112, null);     // Catch: FileNotFoundException -> L33
            r126.recycle();     // Catch: FileNotFoundException -> L33
            r111 = r127;
            goto L34
        L25:
            if (r107.mImgUrl.length() != 0) goto L27;
            boolean r128 = true;
        L28:
            if (r128 == false) goto L30;
            r125 = (String) ListProtector.get(r107.mImgUrlList, 0);     // Catch: FileNotFoundException -> L33
            goto L31
        L30:
            r125 = r107.mImgUrl;     // Catch: FileNotFoundException -> L33
            goto L31
        L27:
            r128 = false;
        L23:
            r125 = "";
        L33:
            ALogger.w("ThumbManager", "getThumbBitmap: cannot find file for " + r106 + '[' + r119 + "],skip");
            goto L34
        L10:
            r109 = r101;
        L34:
            if (r111 == null) goto L44;
            com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a r129 = this.f109807a.f109799z.f109768a;
            if (r129 == null) goto L38;
            r129.b();
        L38:
            RoundedBitmapDrawable r130 = RoundedBitmapDrawableFactory.create(this.f109807a.f109797x.getResources(), r111);
            r130.setAntiAlias(true);
            int r131 = this.f109807a.B;
            if (r131 != 3) goto L41;
        L42:
            r130.setCornerRadius(UtilityKotlinExtentionsKt.b(8));
        L43:
            r110.onNext(new b(1000, r130, r101, this.f109807a.f109788o));
            return;
        L41:
            if (r131 != 4) goto L43;
        L44:
            Ref.BooleanRef r132 = this.f109808b;
            long r133 = System.currentTimeMillis();
            f r134 = this.f109807a;
            long r135 = r133 - r134.f109787n;
            r134.f109799z.getClass();
            if (r135 > 50) goto L48;
            r102 = false;
        L48:
            r132.element = r102;
            if (this.f109808b.element == false) goto L55;
            r110.onNext(new b(1001, null, r101, 0));
            return;
        }
    }

    public static final class e implements Observer<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f109809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f109810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f109811c;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f109812a;

            public a(e r100) {
                this.f109812a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                Disposable r102 = this.f109812a.f109809a;
                if (r102 != null) goto L5;
                return;
            L5:
                if (r102.isDisposed() == true) goto L14;
                f r103 = this.f109812a.f109811c;
                r103.f109792s = RangesKt.coerceAtLeast(r103.f109792s - 1, 0);
                ALogger.w("ThumbProcessViewHolder", "reach Time Out,now runningCount:" + this.f109812a.f109811c.f109792s);
                Disposable r104 = this.f109812a.f109809a;
                if (r104 == null) goto L9;
                r104.dispose();
            L9:
                Disposable r105 = this.f109812a.f109810b;
                if (r105 == null) goto L15;
                r105.dispose();
                return;
            L15:
                return;
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            Disposable r100 = this.f109809a;
            if (r100 == null) goto L6;
            r100.dispose();
            return;
        }

        public e(f r100) {
            this.f109811c = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f109811c.f109792s--;
            ALogger.e("ThumbProcessViewHolder", Intrinsics.stringPlus(r100.getMessage(), "now runningCount:" + this.f109811c.f109792s));
            Disposable r101 = this.f109809a;
            if (r101 == null) goto L6;
            r101.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onNext(b r100) {
            b r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            this.f109811c.f109792s--;
            ALogger.d("ThumbProcessViewHolder", "ONNext,now runningCount:" + this.f109811c.f109792s);
            int r102 = r101.f109800a;
            boolean r103 = false;
            if (r102 == 1000) goto L15;
            if (r102 != 1001) goto L22;
            ALogger.d("ThumbProcessViewHolder", "loadThumbs:receive Loading for index:[" + r101.f109802c + ']');
            View r104 = (View) this.f109811c.f109778e.getValue();
            if (r104 != null) goto L10;
        L12:
            if (r103 == true) goto L22;
            this.f109811c.l(true);
            goto L22
        L10:
            if (r104.getVisibility() != 0) goto L12;
            r103 = true;
        L22:
            Disposable r105 = this.f109809a;
            if (r105 == null) goto L25;
            r105.dispose();
        L25:
            Disposable r106 = this.f109810b;
            if (r106 == null) goto L29;
            r106.dispose();
            return;
        L29:
            return;
        L15:
            if ((r101.f109801b instanceof Drawable) == false) goto L22;
            this.f109811c.l(false);
            ImageView r107 = (ImageView) this.f109811c.f109777d.getValue();
            if (r107 == null) goto L19;
            r107.setImageDrawable(r101.f109801b);
        L19:
            this.f109811c.f109787n = System.currentTimeMillis();
            ALogger.d("ThumbProcessViewHolder", "loadThumbs:receive success for:" + this.f109811c.g() + " index:[" + r101.f109802c + ",cost:" + (this.f109811c.f109787n - r101.f109803d) + ']');
            f r108 = this.f109811c;
            if (r108.f109789p != 0) goto L22;
            r108.f109789p = System.currentTimeMillis();
            goto L22
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f109809a = r100;
            this.f109810b = Observable.timer(2000, TimeUnit.MILLISECONDS).subscribe(new a(this));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.f$f, reason: collision with other inner class name */
    public static final class RunnableC1655f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f109813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f109814b;

        public RunnableC1655f(f r100, boolean r101) {
            this.f109813a = r100;
            this.f109814b = r101;
        }

        public final void a() {
            FrameLayout r100 = (FrameLayout) this.f109813a.f109776c.getValue();
            if (r100 == null) goto L5;
            UtilityKotlinExtentionsKt.k(r100, !this.f109814b);
        L5:
            View r101 = (View) this.f109813a.f109778e.getValue();
            if (r101 == null) goto L8;
            UtilityKotlinExtentionsKt.k(r101, this.f109814b);
        L8:
            View r102 = (View) this.f109813a.f109779f.getValue();
            if (r102 == null) goto L12;
            UtilityKotlinExtentionsKt.k(r102, this.f109814b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThumbInfo f109815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f109816b;

        public g(VideoThumbInfo r100, f r101) {
            this.f109815a = r100;
            this.f109816b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f109816b.e(this.f109815a, CollectionsKt.arrayListOf(new Integer[]{0}));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThumbInfo f109817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntRange f109818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f109819c;

        public h(VideoThumbInfo r100, IntRange r101, f r102) {
            this.f109817a = r100;
            this.f109818b = r101;
            this.f109819c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f109819c.e(this.f109817a, CollectionsKt.toList(this.f109818b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final ReplaySeekBar h() {
        return (ReplaySeekBar) this.f109784k.getValue();
    }

    public final boolean d() {
        if (this.f109798y.getThumbProcessEnable().getValue().booleanValue() == false) goto L7;
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c r100 = this.f109799z;
        VideoThumbInfo r101 = f();
        r100.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.a(r101) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final VideoThumbInfo f() {
        VideoModel r100 = this.f109785l;
        if (r100 == null) goto L10;
        List<VideoThumbInfo> r101 = r100.getThumbInfoList();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (ListProtector.get(r101, 0) != null) goto L9;
        return null;
    L9:
        return (VideoThumbInfo) ListProtector.get(r101, 0);
    L10:
        return null;
    }

    public final String g() {
        VideoModel r100 = this.f109785l;
        if (r100 == null) goto L8;
        VideoRef r101 = r100.getVideoRef();
        if (r101 == null) goto L8;
        String r102 = r101.mVideoId;
        if (r102 == null) goto L8;
        return r102;
    L8:
        VideoModel r103 = this.f109785l;
        if (r103 == null) goto L11;
        int r104 = r103.hashCode();
    L13:
        return String.valueOf(r104);
    L11:
        r104 = 0;
        goto L13
    }

    public final void j() {
        Ref.BooleanRef r100 = new Ref.BooleanRef();
        boolean r101 = true;
        r100.element = true;
        long r102 = System.currentTimeMillis() - this.f109787n;
        this.f109799z.getClass();
        if (r102 > 20) goto L6;
        r101 = false;
    L6:
        r100.element = r101;
        if (r101 == true) goto L9;
        return;
    L9:
        int r103 = this.f109792s;
        this.f109799z.getClass();
        if (r103 <= 10) goto L13;
        ALogger.e("ThumbProcessViewHolder", "loadThumbs:Running Task up to limit,skip");
        return;
    L13:
        Observable.create(new d(this, r100)).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this));
    }

    public final void k() {
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c r100 = this.f109799z;
        VideoThumbInfo r101 = f();
        r100.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.a(r101) == false) goto L23;
        VideoThumbInfo r102 = f();
        this.f109799z.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r102) != 1) goto L10;
        View r103 = this.f109774a;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L9:
        r103.postDelayed(new g(r102, this), 10000);
    L10:
        this.f109799z.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r102) != 2) goto L24;
        e(r102, CollectionsKt.arrayListOf(new Integer[]{0}));
        VideoThumbInfo r104 = f();
        if (r104 == null) goto L17;
        ArrayList<String> r105 = r104.mImgUrlList;
        if (r105 == null) goto L17;
        int r106 = r105.size();
    L18:
        IntRange r107 = RangesKt.until(0, r106);
        View r108 = this.f109774a;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L21:
        r108.postDelayed(new h(r102, r107, this), 10000);
        return;
    L17:
        r106 = 0;
        goto L18
    L24:
        return;
    }

    public final void i() {
        boolean r100 = false;
        if (d() == false) goto L34;
        VideoThumbInfo r101 = f();
        long r102 = this.f109798y.getCurrentDisplayTime().getValue().longValue();
        float r110 = this.f109798y.getXVelocity().getValue().floatValue();
        if (r101 == null) goto L33;
        int r103 = (int) ((r102 / ((long) 1000)) / r101.getValueDouble(8));
        int r104 = r101.getValueInt(5);
        int r105 = r101.getValueInt(6);
        r101.getValueInt(3);
        r101.getValueInt(4);
        this.f109791r = r103 / (r104 * r105);
        float r106 = Math.abs(r110);
        this.f109799z.getClass();
        if (r106 >= 800) goto L19;
        this.f109799z.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r101) != 2) goto L19;
        float r107 = 0;
        if (r110 <= r107) goto L14;
        e(r101, CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(this.f109791r), Integer.valueOf(this.f109791r + 1)}));
        goto L19
    L14:
        if (r110 >= r107) goto L17;
        e(r101, CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(this.f109791r), Integer.valueOf(this.f109791r - 1)}));
        goto L19
    L17:
        if (r110 != 0.0f) goto L19;
        e(r101, CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(this.f109791r)}));
    L19:
        this.f109799z.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r101) != 1) goto L25;
        if (d() == false) goto L25;
        e(r101, CollectionsKt.arrayListOf(new Integer[]{0}));
    L25:
        if (this.f109790q != r103) goto L32;
        View r108 = (View) this.f109778e.getValue();
        if (r108 != null) goto L29;
    L31:
        if (r100 == true) goto L32;
        return;
    L29:
        if (r108.getVisibility() != 0) goto L31;
        r100 = true;
    L32:
        this.f109790q = r103;
        j();
        return;
    L33:
        ALogger.e("ThumbProcessViewHolder", "handleThumbShow: null currentThumbInfo");
        return;
    L34:
        int r109 = this.B;
        if (r109 == 2) goto L39;
        if (r109 == 3) goto L39;
        if (r109 == 4) goto L39;
        if (r109 == 5) goto L39;
    L46:
        ALogger.d("ThumbProcessViewHolder", "can't show thumbInfo: enable:" + this.f109798y.getThumbProcessEnable().getValue().booleanValue());
        return;
    L39:
        View r111 = (View) this.f109778e.getValue();
        if (r111 != null) goto L42;
    L44:
        if (r100 == true) goto L46;
        l(true);
        goto L46
    L42:
        if (r111.getVisibility() != 0) goto L44;
        r100 = true;
        goto L44
    }

    public static final View a(f r100) {
        return (View) r100.f109783j.getValue();
    }

    public static final TextView b(f r100) {
        return (TextView) r100.f109780g.getValue();
    }

    public final void l(boolean r100) {
        View r101 = (View) this.f109778e.getValue();
        if (r101 == null) goto L6;
        r101.post(new RunnableC1655f(this, r100));
        return;
    }

    public static final View c(f r100, int r101) {
        View r102 = r100.f109774a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L6:
        return r102.findViewById(r101);
    }

    public final void e(VideoThumbInfo r110, List<Integer> r111) {
        if (r110 == null) goto L73;
        this.f109799z.getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.a(r110) == false) goto L74;
        long r100 = System.currentTimeMillis() - this.f109786m;
        this.f109799z.getClass();
        if (r100 < 500) goto L79;
        long r101 = System.currentTimeMillis();
        this.f109786m = r101;
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c r102 = this.f109799z;
        Context r103 = this.f109797x;
        String r104 = g();
        c r105 = new c(this, r111, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r105, "callback");
        if (r103 == null) goto L75;
        if (r104 == null) goto L76;
        if (r111 == null) goto L80;
        PolarisFileWrapper r106 = new PolarisFileWrapper(com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.b.a(r103), "live_longvideo_thumb");
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106, r104);
        if (r106.exists() == false) goto L30;
        if (r106.listFiles() == null) goto L30;
        if (r106.listFiles().length != 0) goto L20;
        boolean r108 = true;
    L22:
        if ((!r108) == false) goto L30;
        File[] r109 = r106.listFiles();
        int r112 = r109.length;
        long r113 = 0;
        int r114 = 0;
    L24:
        if (r114 >= r112) goto L27;
        r113 = r113 + r109[r114].length();
        r114 = r114 + 1;
        goto L24
    L27:
        if (r113 <= 20971520) goto L30;
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.d(r106);
        goto L30
    L20:
        r108 = false;
    L30:
        if (r107.exists() == false) goto L32;
    L34:
        int r115 = com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.c(r110);
        if (r115 == 1) goto L52;
        if (r115 != 2) goto L82;
        Iterator<Integer> r116 = r111.iterator();
    L41:
        if (r116.hasNext() == false) goto L83;
        int r117 = r116.next().intValue();
        if (r117 < 0) goto L41;
        if (r117 >= r110.mImgUrlList.size()) goto L41;
        String r118 = (String) ListProtector.get(r110.mImgUrlList, r117);
        if (new PolarisFileWrapper(r107, com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.b(r118)).exists() == true) goto L41;
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a r119 = r102.f109768a;
        if (r119 == null) goto L41;
        r119.a(r118, r107.getPath(), com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.b(r118), r105);
        goto L41
    L83:
        return;
    L82:
        return;
    L52:
        if (r110.mImgUrl.equals("") == false) goto L54;
        String r120 = (String) ListProtector.get(r110.mImgUrlList, 0);
    L56:
        if (new PolarisFileWrapper(r107, com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.b(r120)).exists() == true) goto L77;
        com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a r121 = r102.f109768a;
        if (r121 == null) goto L78;
        r121.a(r120, r107.getPath(), com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c.b(r120), r105);
        return;
    L78:
        return;
    L77:
        return;
    L54:
        r120 = r110.mImgUrl;
        goto L56
    L32:
        if (r107.mkdirs() == true) goto L34;
        return;
    L80:
        return;
    L76:
        return;
    L75:
        return;
    L79:
        return;
    L74:
        return;
    }

    public f(Context r100, final PlayerProgressServiceContext r101, com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.c r102, ViewGroup r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mVSProgressContext");
        Intrinsics.checkNotNullParameter(r102, "mThumbManager");
        Intrinsics.checkNotNullParameter(r103, "parent");
        this.f109797x = r100;
        this.f109798y = r101;
        this.f109799z = r102;
        this.A = r103;
        this.B = r104;
        this.f109775b = LazyKt.lazy(new ThumbProcessViewHolder$thumbContainer$2(this));
        this.f109776c = LazyKt.lazy(new ThumbProcessViewHolder$thumbImgLayout$2(this));
        this.f109777d = LazyKt.lazy(new ThumbProcessViewHolder$thumbImg$2(this));
        this.f109778e = LazyKt.lazy(new ThumbProcessViewHolder$thumbImgLoading$2(this));
        this.f109779f = LazyKt.lazy(new ThumbProcessViewHolder$thumbImgLoadingAnim$2(this));
        this.f109780g = LazyKt.lazy(new ThumbProcessViewHolder$tvThumbTitle$2(this));
        this.f109781h = LazyKt.lazy(new ThumbProcessViewHolder$tvCurTime$2(this));
        this.f109782i = LazyKt.lazy(new ThumbProcessViewHolder$tvTotalTime$2(this));
        this.f109783j = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ThumbProcessViewHolder$thumbHotLabelView$2(this));
        this.f109784k = LazyKt.lazy(new ThumbProcessViewHolder$portraitThumbProgress$2(this));
        this.f109786m = -1;
        this.f109790q = -1;
        this.f109791r = -1;
        CompositeDisposable r105 = new CompositeDisposable();
        this.f109793t = r105;
        this.f109796w = "null";
        if (r104 != 1) goto L5;
        View r106 = LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_thumb_process_portrait_view, r103, false);
    L15:
        this.f109774a = r106;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L18:
        r103.addView(r106, 0);
        ReplaySeekBar r107 = h();
        if (r107 == null) goto L21;
        r107.setThumbShow(false);
        r107.setTouchAble(false);
    L21:
        r105.add(r101.getCurrentDisplayTime().a().subscribe(new com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.g(r101, this)));
        r105.add(i80.a.a(r101.getTotalTime(), new ThumbProcessViewHolder$initView$$inlined$apply$lambda$2(this)));
        r105.add(r101.getTotalTime().a().subscribe(new com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.h(this)));
        r105.add(i80.a.a(r101.getThumbTitle(), new ThumbProcessViewHolder$initView$$inlined$apply$lambda$4(r101, this)));
        r105.add(i80.a.a(r101.getThumbHotLabel(), new ThumbProcessViewHolder$initView$$inlined$apply$lambda$5(this)));
        View r108 = this.f109774a;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L24:
        UtilityKotlinExtentionsKt.h(r108);
        return;
    L5:
        if (r104 != 3) goto L7;
        r106 = LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_thumb_process_portrait_view_opt, r103, false);
        goto L15
    L7:
        if (r104 != 4) goto L9;
        r106 = LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_thumb_process_landscape_view_opt, r103, false);
        goto L15
    L9:
        if (r104 == 5) goto L11;
        r106 = LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_thumb_process_landscape_view, r103, false);
        goto L15
    L11:
        r106 = LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_thumb_process_portrait_view_normal, r103, false);
        goto L15
    }
}
