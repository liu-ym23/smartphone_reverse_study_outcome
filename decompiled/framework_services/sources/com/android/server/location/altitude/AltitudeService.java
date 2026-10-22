package com.android.server.location.altitude;

import android.content.Context;
import android.frameworks.location.altitude.AddMslAltitudeToLocationRequest;
import android.frameworks.location.altitude.AddMslAltitudeToLocationResponse;
import android.frameworks.location.altitude.GetGeoidHeightRequest;
import android.frameworks.location.altitude.GetGeoidHeightResponse;
import android.frameworks.location.altitude.IAltitudeService;
import android.location.Location;
import android.location.altitude.AltitudeConverter;
import android.os.RemoteException;
import android.util.Log;
import com.android.server.SystemService;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class AltitudeService extends IAltitudeService.Stub {
    private static final String TAG = "AltitudeService";
    private final AltitudeConverter mAltitudeConverter;
    private final Context mContext;

    public static class Lifecycle extends SystemService {
        private static final String SERVICE_NAME = null;
        private AltitudeService mService;

        static {
            SERVICE_NAME = IAltitudeService.DESCRIPTOR + "/default";
        }

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new AltitudeService(getContext());
            publishBinderService(SERVICE_NAME, this.mService);
        }
    }

    public AltitudeService(Context context) {
        this.mAltitudeConverter = new AltitudeConverter();
        this.mContext = context;
    }

    public AddMslAltitudeToLocationResponse addMslAltitudeToLocation(AddMslAltitudeToLocationRequest request) throws RemoteException {
        Location location = new Location("");
        location.setLatitude(request.latitudeDegrees);
        location.setLongitude(request.longitudeDegrees);
        location.setAltitude(request.altitudeMeters);
        location.setVerticalAccuracyMeters(request.verticalAccuracyMeters);
        AddMslAltitudeToLocationResponse response = new AddMslAltitudeToLocationResponse();
        this.mAltitudeConverter.addMslAltitudeToLocation(this.mContext, location);     // Catch: IOException -> L6
        response.mslAltitudeMeters = location.getMslAltitudeMeters();
        response.mslAltitudeAccuracyMeters = location.getMslAltitudeAccuracyMeters();
        response.success = true;
        return response;
    L6:
        e = move-exception;
        Log.e(TAG, "", e);
        response.success = false;
        return response;
    }

    public GetGeoidHeightResponse getGeoidHeight(GetGeoidHeightRequest request) throws RemoteException {
        return this.mAltitudeConverter.getGeoidHeight(this.mContext, request);
    L4:
        e = move-exception;
        Log.e(TAG, "", e);
        GetGeoidHeightResponse response = new GetGeoidHeightResponse();
        response.success = false;
        return response;
    }

    public String getInterfaceHash() {
        return "e47d23f579ff7a897fb03e7e7f1c3006cfc6036b";
    }

    public int getInterfaceVersion() {
        return 2;
    }
}
