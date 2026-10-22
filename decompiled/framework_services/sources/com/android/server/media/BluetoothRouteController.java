package com.android.server.media;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.media.MediaRoute2Info;
import android.os.UserHandle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface BluetoothRouteController {

    public interface BluetoothRoutesUpdatedListener {
        void onBluetoothRoutesUpdated();
    }

    public static class NoOpBluetoothRouteController implements BluetoothRouteController {
        public NoOpBluetoothRouteController() {
        }

        @Override // com.android.server.media.BluetoothRouteController
        public void start(UserHandle userHandle) {
        }

        @Override // com.android.server.media.BluetoothRouteController
        public void stop() {
        }

        @Override // com.android.server.media.BluetoothRouteController
        public void transferTo(String routeId) {
        }

        @Override // com.android.server.media.BluetoothRouteController
        public MediaRoute2Info getSelectedRoute() {
            return null;
        }

        @Override // com.android.server.media.BluetoothRouteController
        public List<MediaRoute2Info> getTransferableRoutes() {
            return Collections.emptyList();
        }

        @Override // com.android.server.media.BluetoothRouteController
        public List<MediaRoute2Info> getAllBluetoothRoutes() {
            return Collections.emptyList();
        }

        @Override // com.android.server.media.BluetoothRouteController
        public boolean updateVolumeForDevices(int devices, int volume) {
            return false;
        }
    }

    List<MediaRoute2Info> getAllBluetoothRoutes();

    MediaRoute2Info getSelectedRoute();

    List<MediaRoute2Info> getTransferableRoutes();

    void start(UserHandle r1);

    void stop();

    void transferTo(String r1);

    boolean updateVolumeForDevices(int r1, int r2);

    static BluetoothRouteController createInstance(Context context, BluetoothRoutesUpdatedListener listener) {
        listener.getClass();
        ((BluetoothManager) context.getSystemService(BluetoothManager.class)).getAdapter();
        return new NoOpBluetoothRouteController();
    }
}
