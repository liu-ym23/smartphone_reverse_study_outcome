package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfigAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "<init>", "()V", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SwitchConfigAdapter extends AbstractParcelableAdapter {
    public static final Parcelable.Creator<SwitchConfigAdapter> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f163103a;

    public static final class a implements Parcelable.Creator<SwitchConfigAdapter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SwitchConfigAdapter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new SwitchConfigAdapter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SwitchConfigAdapter[] newArray(int r100) {
            return new SwitchConfigAdapter[r100];
        }
    }

    public static final class b {
    }

    static {
        CREATOR = new a();
    }

    public SwitchConfigAdapter() {
    }

    public SwitchConfigAdapter(Parcel r100) {
        this();
        this.f163103a = r100.readLong();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f163103a);
    }
}
