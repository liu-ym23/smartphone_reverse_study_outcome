package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.IViewLoadCallback;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.n1;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public class BaseQrCodeShareHelper implements IQrCodeShareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> f111531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.chatroom.ssposter.util.b> f111532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<k> f111533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<j> f111534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f111535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Disposable> f111536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f111537g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f111538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ssposter.util.b f111539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f111540c;

        public a(Bitmap r100, com.bytedance.android.livesdk.chatroom.ssposter.util.b r101, View r102) {
            this.f111538a = r100;
            this.f111539b = r101;
            this.f111540c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f111539b.f111577b.invoke(this.f111540c, this.f111538a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f111541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f111542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper f111543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f111544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f111545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f111546f;

        public c(Bitmap r100, View r101, BaseQrCodeShareHelper r102, Map r103, i r104, boolean r105) {
            this.f111541a = r100;
            this.f111542b = r101;
            this.f111543c = r102;
            this.f111544d = r103;
            this.f111545e = r104;
            this.f111546f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f111543c.c(this.f111542b, this.f111541a, this.f111546f);     // Catch: Throwable -> L8
            i r100 = this.f111545e;     // Catch: Throwable -> L8
            Bitmap r101 = this.f111541a;     // Catch: Throwable -> L8
            r100.getClass();     // Catch: Throwable -> L8
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);     // Catch: Throwable -> L8
            if (r100.f111608c == true) goto L11;
            r100.f111608c = true;     // Catch: Throwable -> L8
            IViewLoadCallback r102 = r100.f111609d;     // Catch: Throwable -> L8
            if (r102 == null) goto L15;
            r102.onOriginalPicLoadSuccess(r101);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ssposter.util.b f111547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper f111548b;

        public d(com.bytedance.android.livesdk.chatroom.ssposter.util.b r100, BaseQrCodeShareHelper r101) {
            this.f111547a = r100;
            this.f111548b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            com.bytedance.android.livesdk.chatroom.ssposter.util.b r102 = this.f111547a;
            if (r102.f111578c != null) goto L27;
            r102.f111578c = r101;
            Iterator<m> r103 = this.f111548b.f111535e.iterator();
        L6:
            if (r103.hasNext() == false) goto L9;
            MainThreadPostUtils.e(new com.bytedance.android.livesdk.chatroom.ssposter.util.a(r103.next(), this, r101));
            goto L6
        L9:
            if (BaseQrCodeShareHelper.b(this.f111548b) == false) goto L15;
            BaseQrCodeShareHelper r104 = this.f111548b;
            r104.f111537g = 0;
            Iterator<m> r105 = r104.f111535e.iterator();
        L12:
            if (r105.hasNext() == false) goto L14;
            r105.next().f111620c.b();
            goto L12
        L14:
            this.f111548b.l();
            return;
        L15:
            CopyOnWriteArrayList<m> r106 = this.f111548b.f111535e;
            ArrayList r107 = new ArrayList();
            Iterator<m> r108 = r106.iterator();
        L17:
            if (r108.hasNext() == false) goto L21;
            m r109 = r108.next();
            if ((!r109.f111620c.a()) == false) goto L17;
            r107.add(r109);
            goto L17
        L21:
            Iterator r110 = r107.iterator();
        L23:
            if (r110.hasNext() == false) goto L41;
            m r111 = (m) r110.next();
            if (this.f111548b.d(r111.f111618a) == false) goto L23;
            r111.f111620c.b();
            goto L23
        L41:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ssposter.util.b f111549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper f111550b;

        public e(com.bytedance.android.livesdk.chatroom.ssposter.util.b r100, BaseQrCodeShareHelper r101) {
            this.f111549a = r100;
            this.f111550b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x8.a.f562881a;
            x8.a.c(this.f111550b.j(), (Throwable) r100, false);
            BaseQrCodeShareHelper r102 = this.f111550b;
            if (r102.f111537g == 1) goto L5;
        L17:
            CopyOnWriteArrayList<m> r103 = r102.f111535e;
            ArrayList r104 = new ArrayList();
            Iterator<m> r105 = r103.iterator();
        L19:
            if (r105.hasNext() == false) goto L23;
            m r106 = r105.next();
            if ((!r106.f111620c.a()) == false) goto L19;
            r104.add(r106);
            goto L19
        L23:
            Iterator r107 = r104.iterator();
        L25:
            if (r107.hasNext() == false) goto L49;
            m r108 = (m) r107.next();
            if (this.f111550b.d(r108.f111618a) == false) goto L25;
            r108.f111620c.b();
            goto L25
        L49:
            return;
        L5:
            if (this.f111549a.f111578c != null) goto L17;
            r102.f111537g = 2;
            Iterator<m> r109 = r102.f111535e.iterator();
        L8:
            if (r109.hasNext() == false) goto L16;
            i r110 = r109.next().f111620c;
            if (r110.f111606a == true) goto L8;
            if (r110.f111607b == true) goto L8;
            r110.f111607b = true;
            IViewLoadCallback r111 = r110.f111609d;
            if (r111 == null) goto L8;
            r111.onLoadFail();
            goto L8
        L16:
            this.f111550b.l();
        }
    }

    public static final class f implements IDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 f111551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f111552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 f111553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper f111554d;

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFirstStart(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFirstSuccess(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onPause(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onPrepare(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onRetry(DownloadInfo r100, BaseException r101) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onCanceled(DownloadInfo r100) {
            this.f111553c.invoke2();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            this.f111551a.invoke2(BitmapFactory.decodeFile(this.f111552b));
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            int r102 = x8.a.f562881a;
            x8.a.c(this.f111554d.j(), r101, false);
            this.f111553c.invoke2();
        }

        public f(BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 r100, String r101, BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 r102, BaseQrCodeShareHelper r103) {
            this.f111551a = r100;
            this.f111552b = r101;
            this.f111553c = r102;
            this.f111554d = r103;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 f111555a;

        public g(BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 r100) {
            this.f111555a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 r101 = this.f111555a;
            r101.invoke2((Bitmap) r100);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 f111556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseQrCodeShareHelper f111557b;

        public h(BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 r100, BaseQrCodeShareHelper r101) {
            this.f111556a = r100;
            this.f111557b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x8.a.f562881a;
            String r102 = this.f111557b.j();
            x8.a.c(r102, (Throwable) r100, false);
            this.f111556a.invoke2();
        }
    }

    static {
    }

    public void c(View r100, Bitmap r101, boolean r102) {
        throw null;
    }

    public int e() {
        return R.id.preview_image_saving_guide;
    }

    public float f() {
        throw null;
    }

    public int g() {
        throw null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public int getOriginalPicViewId() {
        return R.id.preview_original_bg;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final int getQrCodeContainerId() {
        return R.id.preview_qr_code_container;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public int getWatermarkContainerId() {
        return R.id.preview_watermark_host;
    }

    public int h() {
        return R.id.preview_search_guide;
    }

    public int i() {
        throw null;
    }

    public String j() {
        return "BaseQrCodeShareHelper";
    }

    public void n() {
        this.f111537g = 0;
        l();
        if (getPicNum() != 0) goto L5;
        return;
    L5:
        this.f111537g = 1;
        l();
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.b> r100 = this.f111532b;
        if (r100 == null) goto L20;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.b) r103).f111578c != null) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r101.add(r103);
        goto L9
    L13:
        r104 = false;
        goto L14
    L16:
        Iterator r105 = r101.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.ssposter.util.b r106 = (com.bytedance.android.livesdk.chatroom.ssposter.util.b) r105.next();
        ((ArrayList) this.f111536f).add(a1.k(r106.f111576a).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r106, this), new e(r106, this)));
    L20:
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r107 = this.f111531a;
        if (r107 == null) goto L59;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L24:
        if (r109.hasNext() == false) goto L31;
        Object r110 = r109.next();
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.e) r110).f111597c != null) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L24;
        r108.add(r110);
        goto L24
    L28:
        r111 = false;
        goto L29
    L31:
        Iterator r112 = r108.iterator();
    L33:
        if (r112.hasNext() == false) goto L88;
        com.bytedance.android.livesdk.chatroom.ssposter.util.e r113 = (com.bytedance.android.livesdk.chatroom.ssposter.util.e) r112.next();
        BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 r114 = new BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3(r113, this);
        BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 r115 = new BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4(r113, this);
        if (r113.f111598d == true) goto L36;
        ((ArrayList) this.f111536f).add(a1.k(r113.f111596b).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r114), new h(r115, this)));
        goto L33
    L36:
        List<String> r116 = r113.f111596b.mUrls;
        if (r116 == null) goto L33;
        String r117 = (String) ListProtector.get(r116, 0);
        if (r117 == null) goto L33;
        if (r117.length() != 0) goto L44;
        boolean r118 = true;
    L45:
        if (r118 == true) goto L33;
        PolarisFileWrapper r119 = new PolarisFileWrapper(n1.a(s1.getContext()), "qr_share");
        String r120 = DigestUtils.md5Hex(r117);
        if (StringUtils.isEmpty(r120) == false) goto L49;
        r120 = "images";
    L49:
        String r121 = r120 + ".jpeg";
        String r122 = r119.getPath() + HTTP.URL_DEFAULT + r121;
        Bitmap r123 = BitmapFactory.decodeFile(r122);
        if (r123 != null) goto L51;
        DownloadTask r124 = Downloader.with(s1.getContext()).url(r113.f111596b.mUri).name(r121).savePath(r119.getPath()).monitorScene("live_vs_poster_share");
        Class r125 = a();     // Catch: Exception -> L55
        Object r126 = r125.newInstance();     // Catch: Exception -> L55
        Method r127 = r125.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L55
        r127.setAccessible(true);     // Catch: Exception -> L55
        r127.invoke(r126, new Object[]{86400});     // Catch: Exception -> L55
    L57:
        r124.addDownloadListener(hashCode(), new f(r114, r122, r115, this), ListenerType.MAIN, false);
        r124.download();
    L55:
        e = move-exception;
        int r128 = x8.a.f562881a;
        x8.a.b("BaseQrCodeShareHelper", "set cache life time max fail : " + e.getMessage(), false);
        goto L57
    L51:
        r114.invoke2(r123);
        goto L33
    L44:
        r118 = false;
        goto L45
    L88:
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final int getPicNum() {
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r100 = this.f111531a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final void l() {
        Iterator r100 = CollectionsKt.toList(this.f111536f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Disposable) r100.next()).dispose();
        goto L4
    L6:
        ((ArrayList) this.f111536f).clear();
    }

    public BaseQrCodeShareHelper() {
        this.f111535e = new CopyOnWriteArrayList();
        this.f111536f = new ArrayList();
    }

    public static final boolean b(BaseQrCodeShareHelper r100) {
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.b> r101 = r100.f111532b;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.b) r102.next()).f111578c != null) goto L6;
        return false;
    L10:
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r103 = r100.f111531a;
        if (r103 == null) goto L18;
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.e) r104.next()).f111597c != null) goto L14;
        return false;
    L18:
        return true;
    }

    public final boolean d(int r100) {
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.b> r101 = this.f111532b;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.b) r102.next()).f111578c != null) goto L6;
        return false;
    L10:
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r103 = this.f111531a;
        if (r103 == null) goto L27;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.e) r106).f111595a != r100) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L14;
        r104.add(r106);
        goto L14
    L18:
        r107 = false;
        goto L19
    L21:
        Iterator r108 = r104.iterator();
    L23:
        if (r108.hasNext() == false) goto L27;
        if (((com.bytedance.android.livesdk.chatroom.ssposter.util.e) r108.next()).f111597c != null) goto L23;
        return false;
    L27:
        return true;
    }

    public final void m(List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((com.bytedance.android.livesdk.chatroom.ssposter.util.e) r103).f111595a = r102;
        r102 = r104;
        goto L4
    L9:
        this.f111531a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final ViewGroup getSaveView(int r100, Context r110, IViewLoadCallback r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return k(g(), r100, r110, new i(r111), r112, true);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final ViewGroup getShowView(int r100, Context r110, IViewLoadCallback r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "callback");
        return k(i(), r100, r110, new i(r111), r112, false);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final ViewGroup getShowView(int r100, Context r101, IViewLoadCallback r110, Map<String, String> r111, View r112) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "callback");
        return k(i(), r100, r101, new i(r110), r111, false);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final ViewGroup getSaveView(int r100, Context r101, IViewLoadCallback r110, Map<String, String> r111, View r112, Pair<Integer, Integer> r113) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return k(g(), r100, r101, new i(r110), r111, true);
    }

    public final ViewGroup k(int r110, int r111, Context r112, i r113, Map<String, String> r114, boolean r115) {
        if (r111 >= 0) goto L4;
        return null;
    L4:
        if (r111 >= getPicNum()) goto L69;
        FrameLayout r100 = new FrameLayout(r112);
        r100.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View r116 = LayoutInflater.from(r112).inflate(r110, r100, true);
        if (r114 != null) goto L9;
    L18:
        List<k> r117 = this.f111533c;
        if (r117 == null) goto L24;
        Iterator<T> r118 = r117.iterator();
    L22:
        if (r118.hasNext() == false) goto L24;
        ((k) r118.next()).f111612a.invoke(r116);
    L24:
        List<j> r119 = this.f111534d;
        if (r119 == null) goto L32;
        Iterator<T> r120 = r119.iterator();
    L28:
        if (r120.hasNext() == false) goto L32;
        j r101 = (j) r120.next();
        Bitmap r102 = r101.f111610a;
        if (r102 == null) goto L28;
        r101.f111611b.invoke(r116, r102);
    L32:
        m r121 = new m(r111, r116, r113, r115);
        this.f111535e.add(r121);
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.b> r122 = this.f111532b;
        if (r122 == null) goto L40;
        Iterator<T> r123 = r122.iterator();
    L36:
        if (r123.hasNext() == false) goto L40;
        com.bytedance.android.livesdk.chatroom.ssposter.util.b r103 = (com.bytedance.android.livesdk.chatroom.ssposter.util.b) r123.next();
        Bitmap r104 = r103.f111578c;
        if (r104 == null) goto L36;
        MainThreadPostUtils.e(new a(r104, r103, r116));
    L40:
        List<com.bytedance.android.livesdk.chatroom.ssposter.util.e> r124 = this.f111531a;
        if (r124 == null) goto L48;
        com.bytedance.android.livesdk.chatroom.ssposter.util.e r125 = (com.bytedance.android.livesdk.chatroom.ssposter.util.e) ListProtector.get(r124, r111);
        if (r125 == null) goto L48;
        Bitmap r105 = r125.f111597c;
        if (r105 == null) goto L48;
        MainThreadPostUtils.e(new c(r105, r116, this, r114, r113, r115));
    L48:
        if (d(r111) == false) goto L51;
        r113.b();
    L53:
        if (r115 == false) goto L55;
        r116.measure(View.MeasureSpec.makeMeasureSpec((int) UtilityKotlinExtentionsKt.h(f()), 1073741824), View.MeasureSpec.makeMeasureSpec(UtilityKotlinExtentionsKt.i(0), 0));
        r116.layout(0, 0, r116.getMeasuredWidth(), r116.getMeasuredHeight());
    L55:
        return r100;
    L51:
        if (this.f111537g == 1) goto L53;
        n();
        goto L53
    L9:
        if (r114.containsKey("image_saving_guide") == false) goto L14;
        TextView r106 = (TextView) r116.findViewById(e());
        if (r106 == null) goto L14;
        r106.setText(r114.get("image_saving_guide"));
    L14:
        if (r114.containsKey("search_guide") == false) goto L18;
        TextView r107 = (TextView) r116.findViewById(h());
        if (r107 == null) goto L18;
        r107.setText(r114.get("search_guide"));
        goto L18
    L69:
        return null;
    }
}
