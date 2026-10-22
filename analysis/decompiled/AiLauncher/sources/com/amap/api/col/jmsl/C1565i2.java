package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.autonavi.aps.amapapi.config.Const;

/* renamed from: com.amap.api.col.jmsl.i2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1565i2 implements IDistanceSearch {

    /* renamed from: d, reason: collision with root package name */
    public static final String f16662d = "t4";

    /* renamed from: a, reason: collision with root package name */
    public Context f16663a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f16664b;

    /* renamed from: c, reason: collision with root package name */
    public DistanceSearch.OnDistanceSearchListener f16665c;

    /* renamed from: com.amap.api.col.jmsl.i2$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DistanceSearch.DistanceQuery f16666a;

        public a(DistanceSearch.DistanceQuery distanceQuery) {
            this.f16666a = distanceQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = Const.I_TILE_TINY;
            messageObtainMessage.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResultCalculateRouteDistance = null;
            try {
                try {
                    distanceResultCalculateRouteDistance = C1565i2.this.calculateRouteDistance(this.f16666a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1565i2.this.f16665c;
                bundle.putParcelable("result", distanceResultCalculateRouteDistance);
                messageObtainMessage.setData(bundle);
                C1565i2.this.f16664b.sendMessage(messageObtainMessage);
            }
        }
    }

    public C1565i2(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16663a = context.getApplicationContext();
        this.f16664b = HandlerC1626y0.a();
        C1631z1.l(this.f16663a, "DistanceSearchCore");
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            C1559h0.c(this.f16663a);
            if (distanceQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DistanceSearch.DistanceQuery distanceQueryClone = distanceQuery.m28clone();
            DistanceResult distanceResultG = new a3(this.f16663a, distanceQueryClone).g();
            if (distanceResultG != null) {
                distanceResultG.setDistanceQuery(distanceQueryClone);
            }
            return distanceResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, f16662d, "calculateWalkRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery) {
        C1535b0.c().b(new a(distanceQuery));
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f16665c = onDistanceSearchListener;
    }
}
