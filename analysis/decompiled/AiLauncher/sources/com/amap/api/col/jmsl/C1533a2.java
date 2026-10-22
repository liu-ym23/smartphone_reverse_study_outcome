package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.a2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1533a2 implements ICloudSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f16516a;

    /* renamed from: b, reason: collision with root package name */
    public CloudSearch.OnCloudSearchListener f16517b;

    /* renamed from: c, reason: collision with root package name */
    public CloudSearch.Query f16518c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<Integer, CloudResult> f16519d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f16520e;

    /* renamed from: com.amap.api.col.jmsl.a2$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CloudSearch.Query f16521a;

        public a(CloudSearch.Query query) {
            this.f16521a = query;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.arg1 = 12;
                    messageObtainMessage.what = 700;
                    HandlerC1626y0.e eVar = new HandlerC1626y0.e();
                    eVar.f17044b = C1533a2.this.f16517b;
                    messageObtainMessage.obj = eVar;
                    eVar.f17043a = C1533a2.b(C1533a2.this, this.f16521a);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                C1533a2.this.f16520e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.a2$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16523a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16524b;

        public b(String str, String str2) {
            this.f16523a = str;
            this.f16524b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.arg1 = 12;
                    messageObtainMessage.what = 701;
                    HandlerC1626y0.d dVar = new HandlerC1626y0.d();
                    dVar.f17042b = C1533a2.this.f16517b;
                    messageObtainMessage.obj = dVar;
                    dVar.f17041a = C1533a2.a(C1533a2.this, this.f16523a, this.f16524b);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                C1533a2.this.f16520e.sendMessage(messageObtainMessage);
            }
        }
    }

    public C1533a2(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16516a = context.getApplicationContext();
        this.f16520e = HandlerC1626y0.a();
        C1631z1.l(this.f16516a, "CloudSearchCore");
    }

    public static CloudItemDetail a(C1533a2 c1533a2, String str, String str2) throws AMapException {
        c1533a2.getClass();
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        try {
            return new G2(c1533a2.f16516a, new C1561h2(str, str2)).g();
        } catch (Throwable th) {
            C1631z1.o(th, "CloudSearch", "searchCloudDetail");
            if (th instanceof AMapException) {
                throw th;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static CloudResult b(C1533a2 c1533a2, CloudSearch.Query query) throws AMapException {
        c1533a2.getClass();
        CloudResult cloudResult = null;
        try {
            if (!c1533a2.d(query)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!query.queryEquals(c1533a2.f16518c)) {
                c1533a2.f16518c = query.m21clone();
                HashMap<Integer, CloudResult> map = c1533a2.f16519d;
                if (map != null) {
                    map.clear();
                }
            }
            CloudResult cloudResultG = new N2(c1533a2.f16516a, query).g();
            try {
                c1533a2.f16519d = new HashMap<>();
                return cloudResultG;
            } catch (Throwable th) {
                th = th;
                cloudResult = cloudResultG;
                C1631z1.o(th, "CloudSearch", "searchCloud");
                if (th instanceof AMapException) {
                    throw th;
                }
                th.printStackTrace();
                return cloudResult;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean d(CloudSearch.Query query) {
        if (query == null || C1631z1.p(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Polygon")) {
            List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
            for (int i10 = 0; i10 < polyGonList.size(); i10++) {
                if (polyGonList.get(i10) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudAsyn(CloudSearch.Query query) {
        try {
            C1535b0.c().b(new a(query));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudDetailAsyn(String str, String str2) {
        try {
            C1535b0.c().b(new b(str, str2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f16517b = onCloudSearchListener;
    }
}
