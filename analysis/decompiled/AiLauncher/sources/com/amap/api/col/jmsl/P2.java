package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class P2 implements INearbySearch {

    /* renamed from: l, reason: collision with root package name */
    public static long f16273l;

    /* renamed from: b, reason: collision with root package name */
    public String f16275b;

    /* renamed from: c, reason: collision with root package name */
    public Context f16276c;

    /* renamed from: d, reason: collision with root package name */
    public HandlerC1626y0 f16277d;

    /* renamed from: e, reason: collision with root package name */
    public ExecutorService f16278e;

    /* renamed from: j, reason: collision with root package name */
    public UploadInfoCallback f16283j;

    /* renamed from: k, reason: collision with root package name */
    public TimerTask f16284k;

    /* renamed from: a, reason: collision with root package name */
    public List<NearbySearch.NearbyListener> f16274a = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public LatLonPoint f16279f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f16280g = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16281h = false;

    /* renamed from: i, reason: collision with root package name */
    public Timer f16282i = new Timer();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = P2.this.f16277d.obtainMessage();
            messageObtainMessage.arg1 = 8;
            messageObtainMessage.obj = P2.this.f16274a;
            try {
                try {
                    P2.f(P2.this);
                    messageObtainMessage.what = 1000;
                    if (P2.this.f16277d == null) {
                        return;
                    }
                } catch (AMapException e10) {
                    messageObtainMessage.what = e10.getErrorCode();
                    C1631z1.o(e10, "NearbySearch", "clearUserInfoAsyn");
                    if (P2.this.f16277d == null) {
                        return;
                    }
                }
                P2.this.f16277d.sendMessage(messageObtainMessage);
            } catch (Throwable th) {
                if (P2.this.f16277d != null) {
                    P2.this.f16277d.sendMessage(messageObtainMessage);
                }
                throw th;
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadInfo f16286a;

        public b(UploadInfo uploadInfo) {
            this.f16286a = uploadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Message messageObtainMessage = P2.this.f16277d.obtainMessage();
                messageObtainMessage.arg1 = 10;
                messageObtainMessage.obj = P2.this.f16274a;
                messageObtainMessage.what = P2.a(P2.this, this.f16286a);
                P2.this.f16277d.sendMessage(messageObtainMessage);
            } catch (Throwable th) {
                C1631z1.o(th, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearbySearch.NearbyQuery f16288a;

        public c(NearbySearch.NearbyQuery nearbyQuery) {
            this.f16288a = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = P2.this.f16277d.obtainMessage();
            messageObtainMessage.arg1 = 9;
            HandlerC1626y0.g gVar = new HandlerC1626y0.g();
            gVar.f17047a = P2.this.f16274a;
            messageObtainMessage.obj = gVar;
            try {
                try {
                    gVar.f17048b = P2.this.searchNearbyInfo(this.f16288a);
                    messageObtainMessage.what = 1000;
                    if (P2.this.f16277d == null) {
                        return;
                    }
                } catch (AMapException e10) {
                    messageObtainMessage.what = e10.getErrorCode();
                    C1631z1.o(e10, "NearbySearch", "searchNearbyInfoAsyn");
                    if (P2.this.f16277d == null) {
                        return;
                    }
                }
                P2.this.f16277d.sendMessage(messageObtainMessage);
            } catch (Throwable th) {
                if (P2.this.f16277d != null) {
                    P2.this.f16277d.sendMessage(messageObtainMessage);
                }
                throw th;
            }
        }
    }

    public class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (P2.this.f16283j != null) {
                    int iB = P2.this.b(P2.this.f16283j.OnUploadInfoCallback());
                    Message messageObtainMessage = P2.this.f16277d.obtainMessage();
                    messageObtainMessage.arg1 = 10;
                    messageObtainMessage.obj = P2.this.f16274a;
                    messageObtainMessage.what = iB;
                    P2.this.f16277d.sendMessage(messageObtainMessage);
                }
            } catch (Throwable th) {
                C1631z1.o(th, "NearbySearch", "UpdateDataTask");
            }
        }

        public /* synthetic */ d(P2 p22, a aVar) {
            this();
        }
    }

    public P2(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16276c = context.getApplicationContext();
        this.f16277d = HandlerC1626y0.a();
        C1631z1.l(this.f16276c, "NearbySearchCore");
    }

    public static int a(P2 p22, UploadInfo uploadInfo) {
        return p22.f16281h ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : p22.b(uploadInfo);
    }

    public static int f(P2 p22) throws AMapException {
        p22.getClass();
        try {
            if (p22.f16281h) {
                throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            }
            String str = p22.f16275b;
            if (!(TextUtils.isEmpty(str) ? false : Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find())) {
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            C1559h0.c(p22.f16276c);
            return new H0(p22.f16276c, p22.f16275b).g().intValue();
        } catch (AMapException e10) {
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f16274a.add(nearbyListener);
        } finally {
        }
    }

    public final int b(UploadInfo uploadInfo) {
        try {
            C1559h0.c(this.f16276c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - f16273l < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            f16273l = time;
            String userID = uploadInfo.getUserID();
            if (!(TextUtils.isEmpty(userID) ? false : Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(userID).find())) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.f16280g)) {
                this.f16280g = userID;
            }
            if (!userID.equals(this.f16280g)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.f16279f)) {
                new Y0(this.f16276c, uploadInfo).g();
                this.f16279f = point.copy();
                return 1000;
            }
            return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        } catch (AMapException e10) {
            return e10.getErrorCode();
        } catch (Throwable unused) {
            return AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void clearUserInfoAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            C1631z1.o(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void destroy() {
        try {
            this.f16282i.cancel();
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f16274a.remove(nearbyListener);
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            C1559h0.c(this.f16276c);
            if (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new Q0(this.f16276c, nearbyQuery).g();
        } catch (AMapException e10) {
            throw e10;
        } catch (Throwable th) {
            C1631z1.o(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery) {
        try {
            C1535b0.c().b(new c(nearbyQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void setUserID(String str) {
        this.f16275b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i10) {
        TimerTask timerTask;
        if (i10 < 7000) {
            i10 = 7000;
        }
        try {
            this.f16283j = uploadInfoCallback;
            if (this.f16281h && (timerTask = this.f16284k) != null) {
                timerTask.cancel();
            }
            this.f16281h = true;
            d dVar = new d(this, null);
            this.f16284k = dVar;
            this.f16282i.schedule(dVar, 0L, i10);
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void stopUploadNearbyInfoAuto() {
        TimerTask timerTask;
        try {
            timerTask = this.f16284k;
        } finally {
            this.f16281h = false;
            this.f16284k = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            this.f16281h = false;
            this.f16284k = null;
        } else {
            this.f16281h = false;
            this.f16284k = null;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        if (this.f16278e == null) {
            this.f16278e = Executors.newSingleThreadExecutor();
        }
        this.f16278e.submit(new b(uploadInfo));
    }
}
