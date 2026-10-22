package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.c1;
import com.amap.api.mapcore.util.f1;
import com.amap.api.mapcore.util.i1;
import com.amap.api.mapcore.util.p0;
import com.amap.api.mapcore.util.r5;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.u3;
import com.amap.api.mapcore.util.u5;
import com.amap.api.mapcore.util.v5;
import com.amap.api.mapcore.util.w3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class OfflineMapManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OfflineMapDownloadListener f28712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OfflineLoadedListener f28713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f28714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f28715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    i1 f28716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    f1 f28717g;

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean r100, String r101);

        void onDownload(int r100, int r101, String r102);

        void onRemove(boolean r100, String r101, String r102);
    }

    public class a implements f1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OfflineMapManager f28718a;

        /* JADX INFO: renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$a$a, reason: collision with other inner class name */
        public class RunnableC0516a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c1 f28719a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28720b;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_maps_offlinemap_OfflineMapManager$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_maps_offlinemap_OfflineMapManager$a$a__run$___twin___() {
                OfflineMapManager.a(this.f28720b.f28718a).onDownload(this.f28719a.l().e(), this.f28719a.getcompleteCode(), this.f28719a.getCity());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                th.printStackTrace();
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_maps_offlinemap_OfflineMapManager$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0516a r100) {
                r100.com_amap_api_maps_offlinemap_OfflineMapManager$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0516a(a r100, c1 r101) {
                this.f28720b = r100;
                this.f28719a = r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c1 f28721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28722b;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_maps_offlinemap_OfflineMapManager$a$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_maps_offlinemap_OfflineMapManager$a$b__run$___twin___() {
            L10:
                th = move-exception;
                th.printStackTrace();
                return;
            L3:
                if (this.f28721a.l().equals(this.f28721a.f27094q) == false) goto L5;
            L8:
                OfflineMapManager.a(this.f28722b.f28718a).onCheckUpdate(true, this.f28721a.getCity());     // Catch: Throwable -> L10
            L13:
                return;
            L5:
                if (this.f28721a.l().equals(this.f28721a.f27088k) == true) goto L8;
                OfflineMapManager.a(this.f28722b.f28718a).onCheckUpdate(false, this.f28721a.getCity());     // Catch: Throwable -> L10
                goto L13
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_maps_offlinemap_OfflineMapManager$a$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
                r100.com_amap_api_maps_offlinemap_OfflineMapManager$a$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(a r100, c1 r101) {
                this.f28722b = r100;
                this.f28721a = r101;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c1 f28723a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28724b;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_maps_offlinemap_OfflineMapManager$a$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_maps_offlinemap_OfflineMapManager$a$c__run$___twin___() {
            L8:
                th = move-exception;
                th.printStackTrace();
                return;
            L4:
                if (this.f28723a.l().equals(this.f28723a.f27088k) == false) goto L6;
                OfflineMapManager.a(this.f28724b.f28718a).onRemove(true, this.f28723a.getCity(), "");     // Catch: Throwable -> L8
            L11:
                return;
            L6:
                OfflineMapManager.a(this.f28724b.f28718a).onRemove(false, this.f28723a.getCity(), "");     // Catch: Throwable -> L8
                goto L11
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_maps_offlinemap_OfflineMapManager$a$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
                r100.com_amap_api_maps_offlinemap_OfflineMapManager$a$c__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(a r100, c1 r101) {
                this.f28724b = r100;
                this.f28723a = r101;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f28725a;

            @Override // java.lang.Runnable
            public void run() {
                com_amap_api_maps_offlinemap_OfflineMapManager$a$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_amap_api_maps_offlinemap_OfflineMapManager$a$d__run$___twin___() {
                OfflineMapManager.c(this.f28725a.f28718a).onVerifyComplete();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                th.printStackTrace();
            }

            public d(a r100) {
                this.f28725a = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_maps_offlinemap_OfflineMapManager$a$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
                r100.com_amap_api_maps_offlinemap_OfflineMapManager$a$d__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.amap.api.mapcore.util.f1.d
        public void onVerifyComplete() {
            if (OfflineMapManager.c(this.f28718a) == null) goto L6;
            OfflineMapManager.b(this.f28718a).post(new d(this));
            return;
        }

        public a(OfflineMapManager r100) {
            this.f28718a = r100;
        }

        @Override // com.amap.api.mapcore.util.f1.d
        public void a(c1 r100) {
            if (OfflineMapManager.a(this.f28718a) == null) goto L6;
            OfflineMapManager.b(this.f28718a).post(new RunnableC0516a(this, r100));
            return;
        }

        @Override // com.amap.api.mapcore.util.f1.d
        public void b(c1 r100) {
            if (OfflineMapManager.a(this.f28718a) == null) goto L7;
            if (r100 == null) goto L8;
            OfflineMapManager.b(this.f28718a).post(new b(this, r100));
            return;
        L8:
            return;
        }

        @Override // com.amap.api.mapcore.util.f1.d
        public void c(c1 r100) {
            if (OfflineMapManager.a(this.f28718a) == null) goto L7;
            if (r100 == null) goto L8;
            OfflineMapManager.b(this.f28718a).post(new c(this, r100));
            return;
        L8:
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OfflineMapManager f28727b;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_maps_offlinemap_OfflineMapManager$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_offlinemap_OfflineMapManager$b__run$___twin___() {
            this.f28727b.f28717g.h(this.f28726a);     // Catch: AMapException -> L4
            return;
        L4:
            e = move-exception;
            t6.a(e, "OfflineMapManager", "downloadByProvinceName");
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_offlinemap_OfflineMapManager$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_amap_api_maps_offlinemap_OfflineMapManager$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(OfflineMapManager r100, String r101) {
            this.f28727b = r100;
            this.f28726a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OfflineMapManager f28729b;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_maps_offlinemap_OfflineMapManager$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_offlinemap_OfflineMapManager$c__run$___twin___() {
            this.f28729b.f28717g.g(this.f28728a);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_offlinemap_OfflineMapManager$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_amap_api_maps_offlinemap_OfflineMapManager$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(OfflineMapManager r100, String r101) {
            this.f28729b = r100;
            this.f28728a = r101;
        }
    }

    public void restart() {
    }

    public void destroy() {
        f1 r100 = this.f28717g;     // Catch: Throwable -> L13
        if (r100 == null) goto L5;
        r100.a();     // Catch: Throwable -> L13
    L5:
        this.f28712b = null;     // Catch: Throwable -> L13
        Handler r101 = this.f28714d;     // Catch: Throwable -> L13
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);     // Catch: Throwable -> L13
    L8:
        this.f28714d = null;     // Catch: Throwable -> L13
        Handler r102 = this.f28715e;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        r102.removeCallbacksAndMessages(null);     // Catch: Throwable -> L13
    L11:
        this.f28715e = null;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        i1 r100 = this.f28716f;
        ArrayList<OfflineMapProvince> r101 = r100.f27428a;
        monitor-enter(r101);
        ArrayList<OfflineMapCity> r102 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<OfflineMapProvince> r103 = r100.f27428a.iterator();     // Catch: Throwable -> L20
    L6:
        if (r103.hasNext() == false) goto L18;
        OfflineMapProvince r104 = r103.next();     // Catch: Throwable -> L20
        if (r104 == null) goto L6;
        Iterator<OfflineMapCity> r105 = r104.getCityList().iterator();     // Catch: Throwable -> L20
    L12:
        if (r105.hasNext() == false) goto L6;
        OfflineMapCity r106 = r105.next();     // Catch: Throwable -> L20
        if (r106.getState() == 4) goto L17;
        if (r106.getState() != 7) goto L12;
    L17:
        r102.add(r106);     // Catch: Throwable -> L20
        goto L12
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r102;
    L20:
        th = move-exception;
        throw th;
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        i1 r100 = this.f28716f;
        ArrayList<OfflineMapProvince> r101 = r100.f27428a;
        monitor-enter(r101);
        ArrayList<OfflineMapProvince> r102 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<OfflineMapProvince> r103 = r100.f27428a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r103.hasNext() == false) goto L15;
        OfflineMapProvince r104 = r103.next();     // Catch: Throwable -> L17
        if (r104 == null) goto L6;
        if (r104.getState() == 4) goto L14;
        if (r104.getState() != 7) goto L6;
    L14:
        r102.add(r104);     // Catch: Throwable -> L17
        goto L6
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r102;
    L17:
        th = move-exception;
        throw th;
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        i1 r100 = this.f28716f;
        ArrayList<OfflineMapProvince> r101 = r100.f27428a;
        monitor-enter(r101);
        ArrayList<OfflineMapCity> r102 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<OfflineMapProvince> r103 = r100.f27428a.iterator();     // Catch: Throwable -> L18
    L6:
        if (r103.hasNext() == false) goto L16;
        OfflineMapProvince r104 = r103.next();     // Catch: Throwable -> L18
        if (r104 == null) goto L6;
        Iterator<OfflineMapCity> r105 = r104.getCityList().iterator();     // Catch: Throwable -> L18
    L12:
        if (r105.hasNext() == false) goto L6;
        OfflineMapCity r106 = r105.next();     // Catch: Throwable -> L18
        if (r100.a(r106.getState()) == false) goto L12;
        r102.add(r106);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r102;
    L18:
        th = move-exception;
        throw th;
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        i1 r100 = this.f28716f;
        ArrayList<OfflineMapProvince> r101 = r100.f27428a;
        monitor-enter(r101);
        ArrayList<OfflineMapProvince> r102 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<OfflineMapProvince> r103 = r100.f27428a.iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L13;
        OfflineMapProvince r104 = r103.next();     // Catch: Throwable -> L15
        if (r104 == null) goto L6;
        if (r100.a(r104.getState()) == false) goto L6;
        r102.add(r104);     // Catch: Throwable -> L15
        goto L6
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r102;
    L15:
        th = move-exception;
        throw th;
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        i1 r100 = this.f28716f;
        r100.getClass();
        ArrayList<OfflineMapCity> r101 = new ArrayList();
        ArrayList<OfflineMapProvince> r102 = r100.f27428a;
        monitor-enter(r102);
        Iterator<OfflineMapProvince> r103 = r100.f27428a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r103.hasNext() == false) goto L11;
        Iterator<OfflineMapCity> r104 = r103.next().getCityList().iterator();     // Catch: Throwable -> L13
    L9:
        if (r104.hasNext() == false) goto L6;
        r101.add(r104.next());     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return r101;
    L13:
        th = move-exception;
        throw th;
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f28716f.b();
    }

    public void pause() {
        this.f28717g.d();
    }

    public void stop() {
        this.f28717g.c();
    }

    private void a(Context r100) {
        Context r101 = r100.getApplicationContext();
        this.f28711a = r101;
        f1.f27221n = false;
        f1 r102 = f1.a(r101);
        this.f28717g = r102;
        r102.a(new a(this));
        this.f28717g.b();     // Catch: Throwable -> L5
        this.f28716f = this.f28717g.f27233j;     // Catch: Throwable -> L5
        u3.e(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ Handler b(OfflineMapManager r100) {
        return r100.f28714d;
    }

    public static /* synthetic */ OfflineLoadedListener c(OfflineMapManager r100) {
        return r100.f28713c;
    }

    public void downloadByCityCode(String r100) throws AMapException {
        this.f28717g.i(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void downloadByCityName(String r100) throws AMapException {
        this.f28717g.h(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void downloadByProvinceName(String r100) throws AMapException {
    L14:
        th = move-exception;
        if ((th instanceof AMapException) == true) goto L20;
        t6.a(th, "OfflineMapManager", "downloadByProvinceName");
        return;
    L20:
        throw th;
    L3:
        if (w3.d(this.f28711a) == false) goto L13;
        OfflineMapProvince r101 = getItemByProvinceName(r100);     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        Iterator<OfflineMapCity> r102 = r101.getCityList().iterator();     // Catch: Throwable -> L14
    L8:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next().getCity();     // Catch: Throwable -> L14
        this.f28715e.post(new b(this, r103));     // Catch: Throwable -> L14
        goto L8
    L23:
        return;
    L11:
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);     // Catch: Throwable -> L14
    L13:
        throw new AMapException(AMapException.ERROR_CONNECTION);     // Catch: Throwable -> L14
    }

    public OfflineMapCity getItemByCityCode(String r100) {
        i1 r101 = this.f28716f;
        r101.getClass();
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if ("".equals(r100) == true) goto L24;
        ArrayList<OfflineMapProvince> r102 = r101.f27428a;
        monitor-enter(r102);
        Iterator<OfflineMapProvince> r103 = r101.f27428a.iterator();     // Catch: Throwable -> L21
    L11:
        if (r103.hasNext() == false) goto L19;
        Iterator<OfflineMapCity> r104 = r103.next().getCityList().iterator();     // Catch: Throwable -> L21
    L14:
        if (r104.hasNext() == false) goto L11;
        OfflineMapCity r105 = r104.next();     // Catch: Throwable -> L21
        if (r105.getCode().equals(r100) == false) goto L14;
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r105;
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public OfflineMapCity getItemByCityName(String r100) {
        i1 r101 = this.f28716f;
        r101.getClass();
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if ("".equals(r100) == true) goto L24;
        ArrayList<OfflineMapProvince> r102 = r101.f27428a;
        monitor-enter(r102);
        Iterator<OfflineMapProvince> r103 = r101.f27428a.iterator();     // Catch: Throwable -> L21
    L11:
        if (r103.hasNext() == false) goto L19;
        Iterator<OfflineMapCity> r104 = r103.next().getCityList().iterator();     // Catch: Throwable -> L21
    L14:
        if (r104.hasNext() == false) goto L11;
        OfflineMapCity r105 = r104.next();     // Catch: Throwable -> L21
        if (r105.getCity().trim().equalsIgnoreCase(r100.trim()) == false) goto L14;
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r105;
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public OfflineMapProvince getItemByProvinceName(String r100) {
        return this.f28716f.a(r100);
    }

    public void pauseByName(String r100) {
        this.f28717g.f(r100);
    }

    public void remove(String r100) {
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f28717g.d(r100) == false) goto L5;
        this.f28717g.g(r100);     // Catch: Throwable -> L18
        return;
    L5:
        OfflineMapProvince r101 = this.f28716f.a(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L8;
    L14:
        OfflineMapDownloadListener r102 = this.f28712b;     // Catch: Throwable -> L18
        if (r102 == null) goto L23;
        r102.onRemove(false, r100, p0.a(2131034196));     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L8:
        if (r101.getCityList() == null) goto L14;
        Iterator<OfflineMapCity> r103 = r101.getCityList().iterator();     // Catch: Throwable -> L18
    L12:
        if (r103.hasNext() == false) goto L25;
        String r104 = r103.next().getCity();     // Catch: Throwable -> L18
        this.f28715e.post(new c(this, r104));     // Catch: Throwable -> L18
        goto L12
    }

    public void setOnOfflineLoadedListener(OfflineLoadedListener r100) {
        this.f28713c = r100;
    }

    public void updateOfflineCityByCode(String r100) throws AMapException {
        OfflineMapCity r101 = getItemByCityCode(r100);
        if (r101 == null) goto L9;
        if (r101.getCity() == null) goto L9;
        String r102 = r101.getCity();
        this.f28717g.a(r102);
        return;
    L9:
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public void updateOfflineCityByName(String r100) throws AMapException {
        this.f28717g.a(r100);
    }

    public void updateOfflineMapProvinceByName(String r100) throws AMapException {
        this.f28717g.a(r100);
    }

    public static /* synthetic */ OfflineMapDownloadListener a(OfflineMapManager r100) {
        return r100.f28712b;
    }

    public OfflineMapManager(Context r100, OfflineMapDownloadListener r101) throws Exception {
        v5 r102 = u5.a(r100, w3.b());
        if (r102.f28191a != u5.e.f28083b) goto L7;
        this.f28712b = r101;
        this.f28711a = r100.getApplicationContext();
        this.f28714d = new Handler(this.f28711a.getMainLooper());
        this.f28715e = new Handler(this.f28711a.getMainLooper());
        a(r100);
        r5.a().a(this.f28711a);
        return;
    L7:
        throw new Exception(r102.f28192b);
    }

    public OfflineMapManager(Context r100, OfflineMapDownloadListener r101, AMap r102) {
        this.f28712b = r101;
        this.f28711a = r100.getApplicationContext();
        this.f28714d = new Handler(this.f28711a.getMainLooper());
        this.f28715e = new Handler(this.f28711a.getMainLooper());
        a(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
