package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraDeviceStateCallbacks {

    public static final class ComboDeviceStateCallback extends CameraDevice.StateCallback {
        private final List<CameraDevice.StateCallback> mCallbacks;

        public ComboDeviceStateCallback(List<CameraDevice.StateCallback> r100) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraDevice.StateCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            CameraDevice.StateCallback r102 = r101.next();
            if ((r102 instanceof NoOpDeviceStateCallback) == true) goto L4;
            this.mCallbacks.add(r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r100) {
            Iterator<CameraDevice.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onClosed(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r100) {
            Iterator<CameraDevice.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onDisconnected(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r210};
            f06.b r110 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r111 = r103;
            int r104 = r111.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r111[r105];
            int r112 = r105;
            int r113 = r104;
            f06.a[] r114 = r111;
            f06.d r107 = r106.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "androidx/camera/camera2/internal/CameraDeviceStateCallbacks$ComboDeviceStateCallback", "onOpened", this, r101, "void", r110);     // Catch: Exception -> L24
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L24
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            Iterator<CameraDevice.StateCallback> r108 = this.mCallbacks.iterator();
        L21:
            if (r108.hasNext() == false) goto L23;
            r108.next().onOpened(r210);
            goto L21
        L23:
            return;
        L14:
            r105 = r112 + 1;
            r104 = r113;
            r111 = r114;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r100, int r101) {
            Iterator<CameraDevice.StateCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onError(r100, r101);
            goto L4
        }
    }

    public static final class NoOpDeviceStateCallback extends CameraDevice.StateCallback {
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r100) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r100) {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r100, int r101) {
        }

        public NoOpDeviceStateCallback() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r110) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r110};
            f06.b r111 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r112 = r103;
            int r113 = r112.length;
            int r104 = 0;
        L8:
            if (r104 >= r113) goto L22;
            f06.a r105 = r112[r104];
            int r114 = r104;
            if (r105.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "androidx/camera/camera2/internal/CameraDeviceStateCallbacks$NoOpDeviceStateCallback", "onOpened", this, r101, "void", r111).f474982a == true) goto L15;
            r100.add(r105);     // Catch: Exception -> L16
            goto L14
        L15:
            return;
        L14:
            r104 = r114 + 1;
            goto L8
        L22:
            return;
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public static CameraDevice.StateCallback createNoOpCallback() {
        return new NoOpDeviceStateCallback();
    }

    private CameraDeviceStateCallbacks() {
    }

    public static CameraDevice.StateCallback createComboCallback(List<CameraDevice.StateCallback> r100) {
        if (r100.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r100.size() != 1) goto L11;
        return (CameraDevice.StateCallback) ListProtector.get(r100, 0);
    L11:
        return new ComboDeviceStateCallback(r100);
    }

    public static CameraDevice.StateCallback createComboCallback(CameraDevice.StateCallback... r100) {
        return createComboCallback(Arrays.asList(r100));
    }
}
