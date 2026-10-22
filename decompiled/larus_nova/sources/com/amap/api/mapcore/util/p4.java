package com.amap.api.mapcore.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class p4 extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<p4> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f27828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f27829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f27830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f27831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f27832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f27835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<o4> f27836i;

    public static class a implements Parcelable.Creator<p4> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public p4 createFromParcel(Parcel r100) {
            return new p4(r100);
        }

        @Override // android.os.Parcelable.Creator
        public p4[] newArray(int r100) {
            return new p4[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public p4(Parcel r100) {
        this.f27828a = 3.0f;
        this.f27829b = 20.0f;
        this.f27830c = Float.MIN_VALUE;
        this.f27831d = Float.MAX_VALUE;
        this.f27832e = 200.0f;
        this.f27833f = true;
        this.f27834g = FakePickerAvatarCreator.LTGRAY;
        this.f27835h = 3.0d;
        this.f27836i = new ArrayList();
        this.f27828a = r100.readFloat();
        this.f27829b = r100.readFloat();
        this.f27830c = r100.readFloat();
        this.f27831d = r100.readFloat();
        this.f27832e = r100.readFloat();
        boolean[] r101 = new boolean[1];
        r100.readBooleanArray(r101);
        this.f27833f = r101[0];
        this.f27834g = r100.readInt();
        this.f27835h = r100.readDouble();
        this.f27836i = r100.readArrayList(o4.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.f27828a);
        r100.writeFloat(this.f27829b);
        r100.writeFloat(this.f27830c);
        r100.writeFloat(this.f27831d);
        r100.writeFloat(this.f27832e);
        r100.writeBooleanArray(new boolean[]{this.f27833f});
        r100.writeInt(this.f27834g);
        r100.writeDouble(this.f27835h);
        r100.writeList(this.f27836i);
    }
}
