package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.p0;
import com.amap.api.mapcore.util.t3;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.w3;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;

/* JADX INFO: loaded from: classes28.dex */
public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = null;
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public CameraPosition build() {
        L8:
            th = move-exception;
            t6.a(th, CameraPosition.CLASSNAME, "build");
            return null;
        L4:
            if (this.target != null) goto L6;
            return null;
        L6:
            return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
        }

        public Builder() {
        }

        public Builder(CameraPosition r100) {
            target(r100.target).bearing(r100.bearing).tilt(r100.tilt).zoom(r100.zoom);
        }

        public Builder bearing(float r100) {
            this.bearing = r100;
            return this;
        }

        public Builder target(LatLng r100) {
            this.target = r100;
            return this;
        }

        public Builder tilt(float r100) {
            this.tilt = r100;
            return this;
        }

        public Builder zoom(float r100) {
            this.zoom = r100;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return w3.a(new String[]{w3.a(PickerReporterConstants.KEY.TARGET, this.target), w3.a(GestureAction.zoom, Float.valueOf(this.zoom)), w3.a("tilt", Float.valueOf(this.tilt)), w3.a("bearing", Float.valueOf(this.bearing))});
    }

    static {
        CREATOR = new CameraPositionCreator();
    }

    public static Builder builder() {
        return new Builder();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static Builder builder(CameraPosition r100) {
        return new Builder(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraPosition) == true) goto L8;
        return false;
    L8:
        CameraPosition r101 = (CameraPosition) r100;
        if (this.target.equals(r101.target) == true) goto L11;
    L17:
        return false;
    L11:
        if (Float.floatToIntBits(this.zoom) != Float.floatToIntBits(r101.zoom)) goto L17;
        if (Float.floatToIntBits(this.tilt) != Float.floatToIntBits(r101.tilt)) goto L17;
        if (Float.floatToIntBits(this.bearing) != Float.floatToIntBits(r101.bearing)) goto L17;
        return true;
    }

    public static final CameraPosition fromLatLngZoom(LatLng r100, float r101) {
        return new CameraPosition(r100, r101, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.bearing);
        r100.writeFloat((float) this.target.latitude);
        r100.writeFloat((float) this.target.longitude);
        r100.writeFloat(this.tilt);
        r100.writeFloat(this.zoom);
    }

    public CameraPosition(LatLng r100, float r101, float r102, float r103) {
        if (r100 != null) goto L5;
        p0.a(2131034393);
    L5:
        this.target = r100;
        this.zoom = r101;
        this.tilt = r102;
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r103 = (r103 % 360.0f) + 360.0f;
    L8:
        this.bearing = r103 % 360.0f;
        if (r100 == null) goto L11;
        this.isAbroad = !t3.b(r100.latitude, r100.longitude);
        return;
    L11:
        this.isAbroad = false;
    }
}
