package com.meizu.aiservice.api.bean;

import android.graphics.Point;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class ImageContour extends ArrayList<Point> implements Parcelable {
    public static final Parcelable.Creator<ImageContour> CREATOR = new a3.a(2);

    public ImageContour() {
    }

    public static ImageContour from(Collection<Point> collection) {
        return new ImageContour(collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Point> getPoints() {
        return new ArrayList(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeParcelableList(this, i8);
    }

    public ImageContour(Collection<Point> collection) {
        super(collection);
    }

    public ImageContour(Parcel parcel) {
        if (Build.VERSION.SDK_INT >= 33) {
            parcel.readParcelableList(this, getClass().getClassLoader(), Point.class);
        } else {
            parcel.readParcelableList(this, getClass().getClassLoader());
        }
    }
}
