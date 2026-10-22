package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.M2;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
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

        public Builder() {
        }

        public Builder bearing(float f10) {
            this.bearing = f10;
            return this;
        }

        public CameraPosition build() {
            try {
                if (this.target != null) {
                    return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
                }
                Log.w(CameraPosition.CLASSNAME, "target is null");
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public Builder tilt(float f10) {
            this.tilt = f10;
            return this;
        }

        public Builder zoom(float f10) {
            this.zoom = f10;
            return this;
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }
    }

    public CameraPosition(LatLng latLng, float f10, float f11, float f12) {
        if (latLng == null) {
            Log.w(CLASSNAME, "构建CameraPosition时,位置(target)不能为null");
        }
        this.target = latLng;
        this.zoom = f10;
        this.tilt = f11;
        this.bearing = (((double) f12) <= 0.0d ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !M2.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f10) {
        return new CameraPosition(latLng, f10, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return C1570k.e(C1570k.d("target", this.target), C1570k.d("zoom", Float.valueOf(this.zoom)), C1570k.d("tilt", Float.valueOf(this.tilt)), C1570k.d(Const.JSON_KEY_BEARING, Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }
}
