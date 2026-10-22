package b96;

import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.update.ErrorCode;
import com.bytedance.iesgurd.update.UpdateException;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrepareMeta f18317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.iesgurd.meta.c f18318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f18319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GeckoUpdateListener f18320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.iesgurd.j f18322f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PrepareMeta f18325c;

        public a(j r100, String r101, PrepareMeta r102) {
            this.f18323a = r100;
            this.f18324b = r101;
            this.f18325c = r102;
        }

        public final void a() {
            RuntimeException r100 = new RuntimeException(this.f18324b);     // Catch: Throwable -> L10
            GeckoUpdateListener r101 = this.f18323a.f18320d;     // Catch: Throwable -> L10
            if (r101 == null) goto L5;
            r101.onActivateFail(this.f18325c.getPack(), r100);     // Catch: Throwable -> L10
            r101.onUpdateFailed(this.f18325c.getPack(), r100);     // Catch: Throwable -> L10
            r101.onUpdateFailed(this.f18325c.getChannel(), r100);     // Catch: Throwable -> L10
        L5:
            Set<GeckoUpdateListener> r102 = ty5.a.f547967a;     // Catch: Throwable -> L10
            Iterator r103 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L10
        L6:
            if (r103.hasNext() == false) goto L12;
            GeckoUpdateListener r104 = (GeckoUpdateListener) r103.next();     // Catch: Throwable -> L10
            r104.onUpdateFailed(this.f18325c.getPack(), r100);     // Catch: Throwable -> L10
            r104.onUpdateFailed(this.f18325c.getChannel(), r100);     // Catch: Throwable -> L10
        L12:
            com.bytedance.iesgurd.j r105 = this.f18323a.f18322f;
            String r106 = this.f18325c.getChannel();
            String r107 = this.f18324b;
            if (r107 != null) goto L16;
            r107 = "";
        L16:
            r105.b(r106, r107);
            return;
        L10:
            th = move-exception;
            GeckoLogger.w("onEventUpdateFailed exception: " + th.getMessage());
            goto L12
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrepareMeta f18327b;

        public b(j r100, PrepareMeta r101) {
            this.f18326a = r100;
            this.f18327b = r101;
        }

        public final void a() {
            long r100 = this.f18327b.getVersion();
            GeckoUpdateListener r101 = this.f18326a.f18320d;     // Catch: Throwable -> L11
            if (r101 == null) goto L6;
            r101.onActivateSuccess(this.f18327b.getPack());     // Catch: Throwable -> L11
            r101.onUpdateSuccess(this.f18327b.getPack(), r100);     // Catch: Throwable -> L11
            r101.onUpdateSuccess(this.f18327b.getChannel(), r100);     // Catch: Throwable -> L11
        L6:
            Iterator r102 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L11
        L7:
            if (r102.hasNext() == false) goto L13;
            GeckoUpdateListener r103 = (GeckoUpdateListener) r102.next();     // Catch: Throwable -> L11
            r103.onActivateSuccess(this.f18327b.getPack());     // Catch: Throwable -> L11
            r103.onUpdateSuccess(this.f18327b.getPack(), r100);     // Catch: Throwable -> L11
            r103.onUpdateSuccess(this.f18327b.getChannel(), r100);     // Catch: Throwable -> L11
        L13:
            this.f18326a.f18322f.d(this.f18327b.getChannel(), r100);
            this.f18327b.getAccessKey();
            this.f18327b.getChannel();
            this.f18327b.getLocalVersion();
            Iterator r104 = ((ConcurrentHashMap) IESGurdKit.f250623a).entrySet().iterator();
        L15:
            if (r104.hasNext() == false) goto L17;
            ((com.bytedance.iesgurd.c) ((Map.Entry) r104.next()).getValue()).c();
            goto L15
        L17:
            return;
        L11:
            th = move-exception;
            GeckoLogger.w("onEventUpdateSuccess exception: " + th.getMessage());
            goto L13
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

    public final void a() {
        PrepareMeta r100 = this.f18317a;     // Catch: Throwable -> L48 UpdateException -> L57
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L48 UpdateException -> L57
    L6:
        new e(r100, this.f18322f).d();     // Catch: Throwable -> L48 UpdateException -> L57
        PrepareMeta r101 = this.f18317a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L10:
        ny5.a r102 = r101.getUpdateBuffer();
        if (r102 == null) goto L13;
        r102.release();
    L13:
        StringBuilder r103 = new StringBuilder("[");
        PrepareMeta r104 = this.f18317a;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L16:
        r103.append(r104);
        r103.append("]update success");
        GeckoLogger.d(r103.toString());
        long r105 = System.currentTimeMillis();
        com.bytedance.iesgurd.meta.c r106 = this.f18318b;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L19:
        r106.f250770a = true;
        com.bytedance.iesgurd.meta.c r107 = this.f18318b;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L22:
        r107.f250771b = r105 - this.f18321e;
        com.bytedance.iesgurd.meta.c r108 = this.f18318b;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L25:
        PrepareMeta r109 = this.f18317a;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L28:
        com.bytedance.iesgurd.meta.c.a r110 = r108.a(r109.getUpdateWithPatch());
        r110.setResult(true);
        com.bytedance.iesgurd.meta.c r111 = this.f18318b;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L31:
        r111.f250772c = r105 - r110.f250786f;
        PrepareMeta r112 = this.f18317a;
        if (r112 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L34:
        r112.upload();
        List<Function0<Unit>> r113 = GkFSUtils.f245072a;
        PrepareMeta r114 = this.f18317a;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L37:
        String r115 = r114.getAccessKey();
        PrepareMeta r116 = this.f18317a;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L40:
        Pair r117 = GkFSUtils.i(r115, r116.getChannel());
        boolean r118 = ((Boolean) r117.component1()).booleanValue();
        List r119 = (List) r117.component2();
        if (r118 == false) goto L43;
        GkFSExecutor.a(new k(this, r119));
        return;
    L43:
        PrepareMeta r120 = this.f18317a;
        if (r120 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L46:
        c(r120);
        return;
    L66:
        th = move-exception;
        PrepareMeta r121 = this.f18317a;
        if (r121 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L70:
        ny5.a r122 = r121.getUpdateBuffer();
        if (r122 == null) goto L73;
        r122.release();
    L73:
        throw th;
    L57:
        e = move-exception;
        d(e);     // Catch: Throwable -> L66
        PrepareMeta r123 = this.f18317a;
        if (r123 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L62:
        ny5.a r124 = r123.getUpdateBuffer();
        if (r124 == null) goto L78;
        r124.release();
        return;
    L78:
        return;
    L48:
        th = move-exception;
        d(new UpdateException(ErrorCode.UNEXPECTED, "unexpected exception: " + th.getStackTrace()));     // Catch: Throwable -> L66
        PrepareMeta r125 = this.f18317a;
        if (r125 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L53:
        ny5.a r126 = r125.getUpdateBuffer();
        if (r126 == null) goto L77;
        r126.release();
        return;
    }

    public final void c(PrepareMeta r100) {
        GeckoExecutors.a().execute(new b(this, r100));
    }

    public final void d(UpdateException r100) {
        com.bytedance.iesgurd.meta.c r101 = this.f18318b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L5:
        PrepareMeta r102 = this.f18317a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L8:
        com.bytedance.iesgurd.meta.c.a r103 = r101.a(r102.getUpdateWithPatch());
        r103.setResult(false);
        r103.f250782b = r100.getCode();
        r103.f250783c = r100.getMessage();
        PrepareMeta r104 = this.f18317a;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L12:
        if (r104.getUpdateWithPatch() == false) goto L21;
        StringBuilder r105 = new StringBuilder("[");
        PrepareMeta r106 = this.f18317a;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L16:
        r105.append(r106);
        r105.append("]update failed, fallback to full: ");
        r105.append(r100.getMessage());
        GeckoLogger.d(r105.toString());
        PrepareMeta r107 = this.f18317a;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L19:
        r107.setUpdateWithPatch(false);
        a();
        return;
    L21:
        com.bytedance.iesgurd.meta.c r108 = this.f18318b;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L24:
        r108.f250773d = 0;
        r108.f250775f = 0;
        r108.f250776g = 0;
        r108.f250777h = 0;
        r108.f250778i = 0;
        r108.f250779j = 0;
        com.bytedance.iesgurd.meta.c r109 = this.f18318b;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L27:
        r109.f250770a = false;
        PrepareMeta r110 = this.f18317a;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L30:
        r110.upload();
        PrepareMeta r111 = this.f18317a;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L33:
        String r112 = r100.getMessage();
        if (r112 != null) goto L36;
        Intrinsics.throwNpe();
    L36:
        b(r111, r112);
    }

    public j(PrepareMeta r100, com.bytedance.iesgurd.j r101) {
        this.f18322f = r101;
    }

    public final void b(PrepareMeta r100, String r101) {
        GeckoLogger.w("[" + r100 + "]update failed: " + r101);
        GeckoExecutors.a().execute(new a(this, r101, r100));
    }
}
