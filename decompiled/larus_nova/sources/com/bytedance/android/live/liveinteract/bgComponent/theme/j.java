package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.bgComponent.theme.api.VoiceLiveThemeApi;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.c70;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadBackgroundResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveThemeListResponse;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class j extends com.bytedance.android.live.liveinteract.bgComponent.theme.d implements x00.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j f71748l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final be0.c f71750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public km3.g f71751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f71752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f71753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<ThemeUpLoadListener> f71754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f71755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f71756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f71757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f71758k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f71759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f71760b;

        public b(j r100, int r101) {
            this.f71759a = r100;
            this.f71760b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IVoiceLiveTheme r101 = ((UploadBackgroundResponse) ((Response) r100).data).voiceLiveTheme;
            if (r101 == null) goto L6;
            this.f71759a.c(r101, this.f71760b);
            ALogger.d("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.success," + r101);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f71761a = null;

        static {
            f71761a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.failed:" + ((Throwable) r100).getMessage());
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f71762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IVoiceLiveTheme f71763b;

        public d(j r100, IVoiceLiveTheme r101) {
            this.f71762a = r100;
            this.f71763b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            this.f71762a.A(this.f71763b.getBgType());
            if (IVoiceLiveThemeKt.isUgcVideoTheme(this.f71763b) == false) goto L11;
            j r102 = this.f71762a;
            IAnimatedBgInfo r103 = this.f71763b.getAnimatedBgInfo();
            if (r103 == null) goto L9;
            py.k r104 = r103.getAnimatedBg();
            if (r104 == null) goto L9;
            String r105 = r104.getUri();
        L10:
            String r106 = String.valueOf(r105);
            r102.getClass();
            j.z(r106);
        L9:
            r105 = null;
        L11:
            com.bytedance.android.live.liveinteract.bgComponent.theme.h.a(true, null);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f71764a = null;

        static {
            f71764a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            f2.b(R.string.ttlive_theme_dialog_request_failed_toast, 0);
            com.bytedance.android.live.liveinteract.bgComponent.theme.h.a(false, (Throwable) r100);
        }
    }

    public static final class f implements com.bytedance.android.live.liveinteract.bgComponent.theme.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f71765a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f71766a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f71767b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f71768c;

            public a(f r100, long r101, long r102) {
                this.f71766a = r100;
                this.f71767b = r101;
                this.f71768c = r102;
            }

            public final void a() {
                km3.g r100 = this.f71766a.f71765a.f71751d;
                if (r100 != null) goto L5;
                return;
            L5:
                if (r100 != null) goto L7;
            L15:
                int r101 = (int) ((this.f71767b * ((long) 100)) / (this.f71768c + ((long) 10)));
                km3.g r102 = this.f71766a.f71765a.f71751d;
                Intrinsics.checkNotNull(r102);
                if (r101 <= r102.getProgress()) goto L24;
                km3.g r103 = this.f71766a.f71765a.f71751d;
                if (r103 == null) goto L25;
                r103.setProgress(r101);
                return;
            L25:
                return;
            L24:
                return;
            L7:
                if (r100.isShowing() == true) goto L15;
                km3.g r104 = this.f71766a.f71765a.f71751d;
                if (r104 == null) goto L15;
                if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L22;
                DialogLancet.handleBlockedDialogShow(r104);
                goto L15
            L22:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
            L14:
                DialogLancet.beforeDialogShow(r104);
                r104.show();
                DialogLancet.afterDialogShow(r104);
                goto L15
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

        public f(j r100) {
            this.f71765a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.e.a
        public final void onProgress(long r100, long r110) {
            this.f71765a.f71752e.post(new a(this, r100, r110));
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f71769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f71770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f71771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2 f71772d;

        public g(j r100, int r101, long r102, Function2 r103) {
            this.f71769a = r100;
            this.f71770b = r101;
            this.f71771c = r102;
            this.f71772d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            VoiceLiveThemeListResponse r102 = (VoiceLiveThemeListResponse) r101.data;
            if (r102 == null) goto L5;
            List<IVoiceLiveTheme> r103 = r102.themeList;
        L6:
            List<IVoiceLiveTheme> r104 = r103;
            if (r104 != null) goto L9;
        L12:
            boolean r105 = true;
        L14:
            if (r105 == false) goto L16;
            ALogger.e("[VideoTalk]VoiceLiveThemeManager", "theme list is empty");
            int r106 = com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.f71805a;
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, new Exception("theme list is empty"));
            return;
        L16:
            VoiceLiveThemeListResponse r107 = (VoiceLiveThemeListResponse) r101.data;
            if (r107 == null) goto L19;
            ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.success.bgType:" + this.f71770b + ",roomId:" + this.f71771c + ",preChoice:" + r107.lastThemeKey + ",ugc:" + r107.ugcAvailable + ",imgType:" + String.valueOf(r107.imageType) + ",animType:" + String.valueOf(r107.animatedType) + ",list:" + r107.themeList);
        L19:
            j.t(this.f71769a, (VoiceLiveThemeListResponse) r101.data, this.f71770b);
            Function2 r108 = this.f71772d;
            if (r108 == null) goto L22;
            Unit r109 = (Unit) r108.invoke(((VoiceLiveThemeListResponse) r101.data).themeList, Boolean.TRUE);
        L22:
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(true, null);
            return;
        L9:
            if (r104.isEmpty() == true) goto L12;
            r105 = false;
            goto L14
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f71773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f71774b;

        public h(int r100, Function2 r101) {
            this.f71773a = r100;
            this.f71774b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.failed.bgType:" + this.f71773a);
            Function2 r102 = this.f71774b;
            if (r102 == null) goto L5;
            Unit r103 = (Unit) r102.invoke(null, Boolean.FALSE);
        L5:
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, r101);
        }
    }

    static {
        f71748l = new j();
    }

    @Override // x00.a
    public final String[] i() {
        return (String[]) this.f71755h.clone();
    }

    @Override // x00.a
    public final String[] s() {
        return (String[]) this.f71756i.clone();
    }

    public j() {
        this.f71750c = new be0.c();
        this.f71752e = new Handler(Looper.getMainLooper());
        this.f71755h = new String[0];
        this.f71756i = new String[0];
        new HashMap();
        this.f71757j = new CompositeDisposable();
        this.f71758k = new f(this);
    }

    @Override // x00.c
    public final void b() {
        String r100 = VideoThemeDownloadManager.c();
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.substring(0, r100.length() - 1));
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.canWrite() == false) goto L9;
        r101.delete();
        return;
    }

    @Override // x00.a
    public final int e() {
        return this.f71749b;
    }

    public static void z(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
    L9:
        PolarisFileWrapper r102 = new PolarisFileWrapper(VideoThemeDownloadManager.d(r100));
        if (r102.exists() == true) goto L12;
        return;
    L12:
        if (r102.canWrite() == false) goto L16;
        r102.delete();
        return;
    L16:
        return;
    L5:
        if (r101.canWrite() == false) goto L9;
        if (r101.delete() == false) goto L9;
    }

    public final void A(int r110) {
        NextLiveData<ArrayList<IVoiceLiveTheme>> r100 = this.f71750c.a(r110).b();
        ArrayList<IVoiceLiveTheme> r101 = r100.getValue();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<T> r103 = r101.iterator();
    L12:
        Object r104 = null;
        if (r103.hasNext() == false) goto L22;
        Object r105 = r103.next();
        IVoiceLiveTheme r106 = (IVoiceLiveTheme) r105;
        if (IVoiceLiveThemeKt.isUgcImage(r106) == false) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L12;
    L23:
        IVoiceLiveTheme r108 = (IVoiceLiveTheme) r105;
        if (r108 != null) goto L26;
        r108 = w(5);
    L26:
        Iterator<T> r109 = r101.iterator();
    L28:
        if (r109.hasNext() == false) goto L32;
        Object r111 = r109.next();
        if (IVoiceLiveThemeKt.isUgcImage((IVoiceLiveTheme) r111) == false) goto L28;
        r104 = r111;
    L32:
        IVoiceLiveTheme r112 = (IVoiceLiveTheme) r104;
        if (r112 != null) goto L35;
        return;
    L35:
        r101.remove(r112);
        c(r108, r110);
        Room r113 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r113 == null) goto L38;
        long r114 = r113.getRoomId();
    L40:
        if (r114 == 0) goto L42;
        m(r114, r108, r110);
    L42:
        r100.setValue(r101);
        return;
    L38:
        r114 = 0;
        goto L40
    L17:
        if (IVoiceLiveThemeKt.isAddImage(r106) == true) goto L19;
        r107 = true;
        goto L20
    L22:
        r105 = null;
        goto L23
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // x00.a, x00.c
    public final IVoiceLiveTheme a(int r100) {
        return this.f71750c.a(r100).a().getValue();
    }

    @Override // x00.a
    public final void h(int r100) {
        Room r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r101 == null) goto L5;
        long r102 = r101.getRoomId();
    L6:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestOneKeyBroadcastThemeList.type:" + r100 + ",roomId:" + r102);
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchOneKeyVoiceLiveThemeList(r100, r102, 4).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r100, r102), m.f71779a);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.b, x00.a
    public final void l(int r100) {
        if (VoiceLiveThemeManageDialog.f71719j == false) goto L6;
        g(r100, null);
        return;
    }

    @Override // x00.a
    public final boolean n(int r100) {
        Integer r101 = this.f71750c.a(r100).c().getValue();
        if (r101 != null) goto L5;
        r101 = 0;
    L5:
        int r102 = r101.intValue();
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L10;
        return false;
    L10:
        if (r100 == 3) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // x00.a
    public final boolean o(int r100) {
        Integer r101 = this.f71750c.a(r100).c().getValue();
        if (r101 != null) goto L6;
        r101 = 0;
    L6:
        if (r101.intValue() == 2) goto L8;
        return false;
    L8:
        if (r100 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // x00.a
    public final IVoiceLiveTheme q(int r100) {
        return this.f71750c.a(r100).getCurrentTheme().getValue();
    }

    public final ArrayList<IVoiceLiveTheme> v(int r100) {
        ArrayList<IVoiceLiveTheme> r101 = this.f71750c.a(r100).b().getValue();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new ArrayList();
    }

    public final IVoiceLiveTheme w(int r100) {
        Iterator<T> r101 = v(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((IVoiceLiveTheme) r102).getImageUri(), c70.f119926a.getValue().imageUri) == false) goto L4;
    L9:
        IVoiceLiveTheme r103 = (IVoiceLiveTheme) r102;
        if (r103 == null) goto L12;
        return r103;
    L12:
        return com.bytedance.android.livesdk.model.k.a();
    L8:
        r102 = null;
        goto L9
    }

    public final boolean x(File r100) {
        if (r100 != null) goto L5;
    L24:
        return false;
    L5:
        if (r100.exists() == false) goto L24;
        String r101 = r100.getName();
        int r102 = StringsKt.lastIndexOf$default(r100.getName(), ".", 0, false, 6, null) + 1;
        if (r101 == null) goto L23;
        String r103 = r101.substring(r102);
        String[] r104 = this.f71755h;
        if (r104.length != 0) goto L12;
        boolean r105 = true;
    L14:
        if ((!r105) == false) goto L21;
        int r106 = r104.length;
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L28;
        if (Intrinsics.areEqual(r104[r107], r103) == true) goto L19;
        r107 = r107 + 1;
        goto L16
    L19:
        return true;
    L28:
        return false;
    L21:
        return false;
    L12:
        r105 = false;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean y(File r100) {
        if (r100 != null) goto L5;
    L24:
        return false;
    L5:
        if (r100.exists() == false) goto L24;
        String r101 = r100.getName();
        int r102 = StringsKt.lastIndexOf$default(r100.getName(), ".", 0, false, 6, null) + 1;
        if (r101 == null) goto L23;
        String r103 = r101.substring(r102);
        String[] r104 = this.f71756i;
        if (r104.length != 0) goto L12;
        boolean r105 = true;
    L14:
        if ((!r105) == false) goto L21;
        int r106 = r104.length;
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L28;
        if (Intrinsics.areEqual(r104[r107], r103) == true) goto L19;
        r107 = r107 + 1;
        goto L16
    L19:
        return true;
    L28:
        return false;
    L21:
        return false;
    L12:
        r105 = false;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // x00.a
    public final void c(IVoiceLiveTheme r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "updateCurrentTheme.bgType:" + r101 + ", theme:" + r100);
        be0.a r102 = this.f71750c.a(r101);
        r102.a().setValue(r102.getCurrentTheme().getValue());
        r102.getCurrentTheme().setValue(r100);
        if (IVoiceLiveThemeKt.isUgcImage(r100) == false) goto L29;
        ArrayList<IVoiceLiveTheme> r103 = r102.b().getValue();
        if (r103 != null) goto L7;
        r103 = new ArrayList();
    L7:
        Iterator<T> r104 = r103.iterator();
    L8:
        String r105 = null;
        if (r104.hasNext() == false) goto L13;
        Object r106 = r104.next();
        if (IVoiceLiveThemeKt.isUgcImage((IVoiceLiveTheme) r106) == false) goto L8;
    L14:
        IVoiceLiveTheme r107 = (IVoiceLiveTheme) r106;
        if (r107 == null) goto L24;
        int r108 = r103.indexOf(r107);
        if (IVoiceLiveThemeKt.isSourceEqual(r107, r100) == true) goto L30;
        ListProtector.set(r103, r108, r100);
        IAnimatedBgInfo r109 = r107.getAnimatedBgInfo();
        if (r109 == null) goto L23;
        py.k r110 = r109.getAnimatedBg();
        if (r110 == null) goto L23;
        r105 = r110.getUri();
    L23:
        z(String.valueOf(r105));
        r102.b().setValue(r103);
        return;
    L30:
        return;
    L24:
        ListProtector.add(r103, 0, r100);
        r102.b().setValue(r103);
        return;
    L13:
        r106 = null;
        goto L14
    }

    @Override // x00.a
    public final void d(long r100, IVoiceLiveTheme r101) {
        Intrinsics.checkNotNullParameter(r101, "theme");
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "deleteTheme.room:" + r100 + ",theme:" + r101);
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r101) == false) goto L7;
        A(r101.getBgType());
        return;
    L7:
        if (r101.getAnimatedBgInfo() == null) goto L12;
        IAnimatedBgInfo r102 = r101.getAnimatedBgInfo();
        Intrinsics.checkNotNull(r102);
        py.k r103 = r102.getAnimatedBg();
        if (r103 == null) goto L11;
        String r104 = r103.getUri();
    L13:
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        return;
    L21:
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).deleteTheme(r100, r104, r101.getBgType()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r101), e.f71764a);
        return;
    L15:
        if (r104.length() == 0) goto L18;
        r105 = false;
        goto L19
    L11:
        r104 = null;
        goto L13
    L12:
        r104 = r101.getImageUri();
        goto L13
    }

    @Override // x00.a
    public final void f(Observer<IVoiceLiveTheme> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f71750c.a(r101).getCurrentTheme().removeObserver(r100);
    }

    @Override // x00.a
    public final void g(int r100, Function2<? super List<? extends IVoiceLiveTheme>, ? super Boolean, Unit> r110) {
        Room r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r101 == null) goto L5;
        long r102 = r101.getRoomId();
    L6:
        long r103 = r102;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.type:" + r100 + ",roomId:" + r103);
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchVoiceLiveThemeList(r100, r103).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r100, r103, r110), new h(r100, r110));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static final void t(j r110, VoiceLiveThemeListResponse r111, int r112) {
        r110.getClass();
        ArrayList<IVoiceLiveTheme> r100 = new ArrayList();
        List<IVoiceLiveTheme> r101 = r111.themeList;
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        be0.a r102 = r110.f71750c.a(r112);
        r102.c().setValue(Integer.valueOf(r111.ugcAvailable));
        String[] r103 = r111.animatedType;
        int r104 = 0;
        if (r103 != null) goto L8;
        r103 = new String[0];
    L8:
        r110.f71756i = r103;
        String[] r105 = r111.imageType;
        if (r105 != null) goto L11;
        r105 = new String[0];
    L11:
        r110.f71755h = r105;
        ae0.a.f3062a.getClass();
        Intrinsics.checkNotNullParameter(r100, "themes");
        Iterator r106 = CollectionsKt.listOf(new ae0.a[]{new ae0.d(), new ae0.c(), new ae0.b()}).iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        r100 = ((ae0.a) r106.next()).a(r100);
        goto L13
    L15:
        if (r100 == null) goto L74;
        Iterator<T> r107 = r100.iterator();
        int r108 = -1;
        int r109 = -1;
        int r113 = -1;
    L18:
        if (r107.hasNext() == false) goto L32;
        Object r114 = r107.next();
        int r115 = r104 + 1;
        if (r104 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        IVoiceLiveTheme r116 = (IVoiceLiveTheme) r114;
        if (IVoiceLiveThemeKt.isConfig(r116) == false) goto L26;
        r108 = r104;
    L31:
        r104 = r115;
        goto L18
    L26:
        if (Intrinsics.areEqual(r116.isPreLoad(), Boolean.TRUE) == false) goto L29;
        r109 = r104;
        goto L31
    L29:
        if (Intrinsics.areEqual(r116.getImageUri(), r111.lastThemeKey) == false) goto L31;
        r113 = r104;
        goto L31
    L32:
        int r117 = r100.size();
        String r118 = null;
        if (r108 < 0) goto L36;
        if (r108 >= r117) goto L36;
        IVoiceLiveTheme r119 = (IVoiceLiveTheme) ListProtector.get(r100, r108);
    L37:
        if (r109 < 0) goto L40;
        if (r109 >= r117) goto L40;
        IVoiceLiveTheme r120 = (IVoiceLiveTheme) ListProtector.get(r100, r109);
    L41:
        if (r113 < 0) goto L44;
        if (r113 >= r117) goto L44;
        IVoiceLiveTheme r121 = (IVoiceLiveTheme) ListProtector.get(r100, r113);
    L45:
        IVoiceLiveTheme r122 = r102.getCurrentTheme().getValue();
        if (r119 != null) goto L48;
        r119 = r122;
    L48:
        if (r119 == null) goto L51;
        r120 = r119;
    L51:
        if (r120 == null) goto L54;
        r121 = r120;
    L54:
        if (r121 != null) goto L56;
        r121 = r102.d();
    L56:
        if (r122 == null) goto L58;
        String r123 = r122.getImageUri();
    L59:
        if (r121 == null) goto L62;
        r118 = r121.getImageUri();
    L62:
        if ((!Intrinsics.areEqual(r123, r118)) == false) goto L71;
        if (r121 == null) goto L71;
        r102.getCurrentTheme().setValue(r121);
        Room r124 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r124 == null) goto L67;
        long r125 = r124.getRoomId();
    L69:
        if (r125 <= 0) goto L71;
        r110.m(r125, r121, r112);
        goto L71
    L67:
        r125 = 0;
    L71:
        r102.b().setValue(r100);
        return;
    L58:
        r123 = null;
    L44:
        r121 = null;
    L40:
        r120 = null;
    L36:
        r119 = null;
        goto L37
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme> /* = java.util.ArrayList<com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme> */");
    }

    @Override // x00.a
    public final void j(LifecycleOwner r100, Observer<IVoiceLiveTheme> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f71750c.a(r102).getCurrentTheme().observe(r100, r101, true);
    }

    @Override // x00.a
    public final void k(int r110, long r111, Function2 r210) {
        Room r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r100 == null) goto L5;
        long r101 = r100.getRoomId();
    L6:
        long r102 = r101;
        if (r110 != 100) goto L9;
        int r112 = 1;
    L10:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList ;; realBgType == " + r112 + " ;; bgType == " + r110 + " ;; imageType == 5 ;; roomId == " + r102 + " ;; playMode == " + r111);
        RxUtilKt.c(((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchVoiceLiveThemeList(r112, r102, String.valueOf(5), r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this, r111, r110, r102, r210), new o(r210, r110)), this.f71757j);
        return;
    L9:
        r112 = r110;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    @Override // x00.a
    public final void m(long r110, IVoiceLiveTheme r111, int r112) {
        Intrinsics.checkNotNullParameter(r111, "theme");
        if (r110 > 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r111.isPreLoad(), Boolean.TRUE) == true) goto L42;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "selectTheme.room:" + r110 + ",bgType:" + r112 + ",theme:" + r111);
        this.f71749b = r112;
        boolean r100 = true;
        if (r112 != 100) goto L10;
        int r101 = 1;
    L11:
        VoiceLiveThemeApi r102 = (VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class);
        String r103 = r111.getImageUri();
        if (r103 != null) goto L14;
    L17:
        if (r100 == false) goto L38;
        IAnimatedBgInfo r104 = r111.getAnimatedBgInfo();
        if (r104 == null) goto L22;
        String r105 = r104.getFileFormat();
        if (r105 == null) goto L22;
    L23:
        String r106 = r105;
        IAnimatedBgInfo r107 = r111.getAnimatedBgInfo();
        if (r107 == null) goto L27;
        Object r108 = r107.getThemeShowArea();
        if (r108 == null) goto L27;
    L28:
        IAnimatedBgInfo r109 = r111.getAnimatedBgInfo();
        if (r109 == null) goto L36;
        py.k r113 = r109.getAnimatedBg();
        if (r113 == null) goto L36;
        String r114 = r113.getUri();
        if (r114 == null) goto L36;
        String r115 = r114;
    L37:
        Observable r116 = r102.addUgcBgTheme(r110, r115, r106, (String) r108, r101, false);
    L39:
        r116.compose(RxUtil.rxSchedulerHelper()).subscribe(new p(r110, r111), new q(this, r111, r112));
        return;
    L36:
        r115 = "";
    L27:
        r108 = "";
    L22:
        r105 = "gif";
        goto L23
    L38:
        r116 = r102.selectTheme(r110, r111.getImageUri(), r111.getImageType(), r101);
        goto L39
    L14:
        if (r103.length() == 0) goto L17;
        r100 = false;
        goto L17
    L10:
        r101 = r112;
        goto L11
    }

    @Override // x00.a
    public final void p(LifecycleOwner r100, Observer<ArrayList<IVoiceLiveTheme>> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f71750c.a(r102).b().observe(r100, r101, true);
    }

    @Override // x00.c
    public final void r(FragmentActivity r110, long r111, String r210, IThemeShowArea r211, int r212, ThemeUpLoadListener r213) {
        Intrinsics.checkNotNullParameter(r210, "path");
        PolarisFileWrapper r100 = new PolarisFileWrapper(r210);
        if (r100.exists() == true) goto L9;
        f2.b(R.string.ttlive_theme_dialog_upload_failed_toast, 0);
        if (r213 == null) goto L38;
        r213.onUploadFailed();
        return;
    L38:
        return;
    L9:
        if (y(r100) == false) goto L17;
        if (FileUtils.getFileSize(r100) <= 20971520) goto L17;
        f2.b(R.string.ttlive_custom_theme_video_oversize, 0);
        if (r213 == null) goto L39;
        r213.onUploadFailed();
        return;
    L39:
        return;
    L17:
        if (x(r100) == true) goto L19;
    L24:
        ALogger.d("[VideoTalk]VoiceLiveThemeManager", "uploadFile.bgType" + r212 + ",roomId:" + r111 + ",path" + r210);
        if (r110 == null) goto L32;
        km3.g r101 = new km3.g(r110);
        r101.setMessage(r101.getContext().getResources().getString(R.string.ttlive_custom_theme_uploading));
        r101.setCancelable(false);
        r101.b();
        if (r101.f504057b == false) goto L31;
        View r102 = r101.f504059d;
        if (r102 == null) goto L31;
        r102.setAlpha(0.5f);
    L31:
        r101.setProgressStyle(0);
        r101.f504060e = new k(this);
        Unit r103 = Unit.INSTANCE;
        this.f71751d = r101;
    L32:
        String r104 = r100.getName();
        int r105 = StringsKt.lastIndexOf$default(r100.getName(), ".", 0, false, 6, null) + 1;
        if (r104 == null) goto L37;
        String r106 = r104.substring(r105);
        com.bytedance.android.live.liveinteract.bgComponent.theme.e r107 = new com.bytedance.android.live.liveinteract.bgComponent.theme.e(this.f71758k, r100);
        MultipartTypedOutput r108 = new MultipartTypedOutput();
        r108.addPart("data", r107);
        this.f71754g = new WeakReference(r213);
        this.f71753f = ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).uploadFile("audio_room_bg", r108).compose(RxUtil.rxSchedulerHelper()).subscribe(new r(this, r210, r100, r211, r212, r111, r106), new s(this, r110));
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        if (FileUtils.getFileSize(r100) <= 20971520) goto L24;
        f2.b(R.string.ttlive_custom_theme_image_oversize, 0);
        if (r213 == null) goto L40;
        r213.onUploadFailed();
        return;
    }

    public final void u(long r100, String r110, String r111, IThemeShowArea r112, int r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "imageUri");
        Intrinsics.checkNotNullParameter(r111, "fileFormat");
        if (r112 == null) goto L5;
        String r115 = String.valueOf(com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(r112));
    L6:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.roomId:" + r100 + ",image:" + r110 + ",format:" + r111 + ",bgType:" + r113 + ",isPreLoad:" + r114);
        this.f71757j.add(((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).addUgcBgTheme(r100, r110, r111, r115, r113, r114).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r113), c.f71761a));
        return;
    L5:
        r115 = "";
        goto L6
    }
}
