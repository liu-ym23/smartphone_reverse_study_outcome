package com.baidu.mapsdkplatform.comapi.map.z;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.a0;
import com.baidu.platform.comapi.map.q;
import com.baidu.platform.comapi.map.z;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comjni.engine.MessageProxy;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import org.json.JSONException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.a f8151a;

    /* renamed from: b, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f8152b;

    /* renamed from: c, reason: collision with root package name */
    private int f8153c;

    /* renamed from: d, reason: collision with root package name */
    private TraceAnimationListener f8154d;

    /* renamed from: f, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.b f8156f;

    /* renamed from: g, reason: collision with root package name */
    private MapSurfaceView f8157g;

    /* renamed from: h, reason: collision with root package name */
    private MapTextureView f8158h;

    /* renamed from: e, reason: collision with root package name */
    private e f8155e = new e();

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f8159i = false;

    public class a implements com.baidu.mapsdkplatform.comapi.map.z.b {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void a(TraceOverlay traceOverlay) {
            c.this.e(traceOverlay);
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void b(TraceOverlay traceOverlay) {
            c.this.a();
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void c(TraceOverlay traceOverlay) {
            c.this.c(traceOverlay);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TraceOverlay f8161a;

        public b(TraceOverlay traceOverlay) {
            this.f8161a = traceOverlay;
        }

        @Override // java.lang.Runnable
        public void run() throws NoSuchAlgorithmException {
            if (c.this.f8151a == null || c.this.f8152b == null) {
                return;
            }
            c.this.d(this.f8161a);
            c.this.f8151a.a();
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.z.c$c, reason: collision with other inner class name */
    public class RunnableC0030c implements Runnable {
        public RunnableC0030c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f8151a.a();
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TraceOverlay f8164a;

        public d(TraceOverlay traceOverlay) {
            this.f8164a = traceOverlay;
        }

        @Override // java.lang.Runnable
        public void run() throws NoSuchAlgorithmException {
            c.this.d(this.f8164a);
            c.this.f8151a.a();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class e extends i {
        public e() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            int i4 = message.what;
            if (i4 != 65302) {
                if (i4 != 65303 || c.this.f8154d == null) {
                    return;
                }
                c.this.f8154d.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
                return;
            }
            int i5 = message.arg1;
            if (i5 > 0 && i5 <= 1000 && c.this.f8154d != null) {
                c.this.f8154d.onTraceAnimationUpdate(message.arg1 / 10.0f);
            }
            if (message.arg2 != 1 || c.this.f8154d == null) {
                return;
            }
            c.this.f8154d.onTraceAnimationFinish();
        }
    }

    public c(MapSurfaceView mapSurfaceView) {
        this.f8153c = 1;
        if (mapSurfaceView == null) {
            return;
        }
        this.f8151a = new com.baidu.mapsdkplatform.comapi.map.z.a();
        this.f8157g = mapSurfaceView;
        this.f8152b = mapSurfaceView.getBaseMap();
        mapSurfaceView.addOverlay(this.f8151a);
        this.f8151a.SetOverlayShow(true);
        this.f8153c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(TraceOverlay traceOverlay) throws NoSuchAlgorithmException {
        if (this.f8151a == null || traceOverlay == null) {
            return;
        }
        boolean zIsAnimate = traceOverlay.isAnimate();
        this.f8151a.a(zIsAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationDuration(), traceOverlay.getAnimationType());
        this.f8151a.b(traceOverlay.isRotateWhenTrack());
        q qVar = new q(new z().a(-15794282).b(14));
        qVar.a(b(traceOverlay));
        if (traceOverlay.isUseColorArray()) {
            qVar.a(traceOverlay.isUseColorArray());
            int[] iArrA = a(traceOverlay);
            for (int i4 = 0; i4 < iArrA.length; i4++) {
                int i5 = iArrA[i4];
                iArrA[i4] = ((i5 >> 16) & 255) | ((-16777216) & i5) | ((i5 & 255) << 16) | (65280 & i5);
            }
            qVar.a(iArrA);
        }
        qVar.a(new a0().d(-1).a(traceOverlay.getColor()).b(traceOverlay.getWidth()));
        qVar.f9185c = traceOverlay.isTrackMove();
        qVar.f9186d = traceOverlay.isPointMove();
        qVar.f9187e = !traceOverlay.isDataReduction();
        qVar.f9188f = !traceOverlay.isDataSmooth();
        qVar.f9192j = traceOverlay.isTrackBloom();
        qVar.f9193k = traceOverlay.getBloomSpeed();
        qVar.a(zIsAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationType());
        if (traceOverlay.getIcon() != null) {
            qVar.f9190h = false;
            this.f8151a.setParam(a(traceOverlay.getIcon().getBitmap()));
        }
        BM3DModelOptions icon3D = traceOverlay.getIcon3D();
        if (icon3D != null) {
            qVar.f9190h = true;
            this.f8151a.setParam(a(icon3D));
        }
        this.f8151a.a(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(TraceOverlay traceOverlay) {
        if (traceOverlay == null || this.f8151a == null) {
            return;
        }
        if (!traceOverlay.isStatusChanged()) {
            this.f8151a.clear();
            MapTaskManager.getDefaultThreadPool().execute(new d(traceOverlay));
        } else {
            this.f8151a.a(traceOverlay.isOnPause());
            this.f8151a.c(true);
            MapTaskManager.getDefaultThreadPool().execute(new RunnableC0030c());
        }
    }

    private List<GeoPoint> b(TraceOverlay traceOverlay) {
        if (traceOverlay == null || traceOverlay.getPoints() == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : traceOverlay.getPoints()) {
            arrayList.add(CoordUtil.ll2mc(latLng));
            builder.include(latLng);
        }
        return arrayList;
    }

    public TraceOverlay a(TraceOptions traceOptions) {
        if (traceOptions == null) {
            return null;
        }
        TraceOverlay overlay = traceOptions.getOverlay();
        overlay.mListener = this.f8156f;
        MapTaskManager.getDefaultThreadPool().execute(new b(overlay));
        return overlay;
    }

    public void c() {
        this.f8156f = new a();
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.f8155e);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.f8155e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(TraceOverlay traceOverlay) {
        if (traceOverlay != null && this.f8151a != null) {
            e();
        }
        return false;
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.z.a aVar = this.f8151a;
        if (aVar == null) {
            return;
        }
        aVar.clear();
        this.f8151a.a();
    }

    public void e() {
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.f8155e);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.f8155e);
        int i4 = this.f8153c;
        if (i4 == 1 && (mapSurfaceView = this.f8157g) != null) {
            mapSurfaceView.removeOverlay(this.f8151a);
        } else if (i4 == 2 && (mapTextureView = this.f8158h) != null) {
            mapTextureView.removeOverlay(this.f8151a);
        }
        if (this.f8154d != null) {
            this.f8154d = null;
        }
        this.f8159i = true;
    }

    private int[] a(TraceOverlay traceOverlay) {
        if (traceOverlay == null || traceOverlay.getColors() == null) {
            return null;
        }
        return traceOverlay.getColors();
    }

    public com.baidu.mapsdkplatform.comapi.map.z.a b() {
        return this.f8151a;
    }

    public c(MapTextureView mapTextureView) throws JSONException {
        this.f8153c = 1;
        if (mapTextureView == null) {
            return;
        }
        this.f8151a = new com.baidu.mapsdkplatform.comapi.map.z.a();
        this.f8158h = mapTextureView;
        this.f8152b = mapTextureView.getBaseMap();
        mapTextureView.addOverlay(this.f8151a);
        this.f8151a.SetOverlayShow(true);
        this.f8153c = 2;
    }

    public void a(TraceAnimationListener traceAnimationListener) {
        this.f8154d = traceAnimationListener;
    }

    private Bundle a(Bitmap bitmap) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        if (bitmap == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("image_width", bitmap.getWidth());
        bundle.putInt("image_height", bitmap.getHeight());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getWidth() * 4);
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        byte[] bArrArray = byteBufferAllocate.array();
        bundle.putByteArray("image_data", bArrArray);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        }
        if (messageDigest != null) {
            messageDigest.update(bArrArray, 0, bArrArray.length);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b4 : bArrDigest) {
                sb.append(Integer.toString((b4 & UByte.MAX_VALUE) + 256, 16).substring(1));
            }
            bundle.putString("image_hashcode", sb.toString());
        }
        return bundle;
    }

    private Bundle a(BM3DModelOptions bM3DModelOptions) {
        if (bM3DModelOptions == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("icon_3D", 1);
        bundle.putInt("modelType", bM3DModelOptions.getBM3DModelType().ordinal());
        bundle.putString("modelPath", bM3DModelOptions.getModelPath());
        bundle.putString("modelName", bM3DModelOptions.getModelName());
        bundle.putFloat("scale", bM3DModelOptions.getScale());
        bundle.putBoolean("zoomFixed", bM3DModelOptions.isZoomFixed());
        bundle.putInt("yawAxis", bM3DModelOptions.getYawAxis());
        bundle.putFloat("rotateX", bM3DModelOptions.getRotateX());
        bundle.putFloat("rotateY", bM3DModelOptions.getRotateY());
        bundle.putFloat("rotateZ", bM3DModelOptions.getRotateZ());
        bundle.putFloat("offsetX", bM3DModelOptions.getOffsetX());
        bundle.putFloat("offsetY", bM3DModelOptions.getOffsetY());
        bundle.putFloat("offsetZ", bM3DModelOptions.getOffsetZ());
        if (bM3DModelOptions.isSkeletonAnimationEnable()) {
            bundle.putInt("animationIndex", bM3DModelOptions.getAnimationIndex());
            bundle.putBoolean("animationIsEnable", bM3DModelOptions.isSkeletonAnimationEnable());
            bundle.putInt("animationRepeatCount", bM3DModelOptions.getAnimationRepeatCount());
            bundle.putFloat("animationSpeed", bM3DModelOptions.getAnimationSpeed());
        }
        return bundle;
    }

    public boolean d() {
        return this.f8159i;
    }
}
