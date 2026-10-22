package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lz2.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "<init>", "()V", "BidConfigAdapter", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class BidInfoAdapter extends AbstractParcelableAdapter {
    public static final Parcelable.Creator<BidInfoAdapter> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f163080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BidConfigAdapter[] f163081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends lz2.a> f163082c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "<init>", "()V", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class BidConfigAdapter extends AbstractParcelableAdapter {
        public static final Parcelable.Creator<BidConfigAdapter> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f163084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Integer> f163085c;

        public static final class a implements Parcelable.Creator<BidConfigAdapter> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final BidConfigAdapter createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "source");
                return new BidConfigAdapter(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final BidConfigAdapter[] newArray(int r100) {
                return new BidConfigAdapter[r100];
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public BidConfigAdapter() {
            this.f163083a = "__hybrid_default";
        }

        public BidConfigAdapter(Parcel r100) {
            this();
            String r101 = r100.readString();
            Intrinsics.checkNotNull(r101);
            this.f163083a = r101;
            this.f163084b = r100.readLong();
            int r102 = r100.readInt();
            if (r102 != 0) goto L5;
            LinkedHashMap r103 = null;
        L9:
            this.f163085c = r103;
            return;
        L5:
            LinkedHashMap r104 = new LinkedHashMap();
            int r105 = 0;
        L6:
            if (r105 >= r102) goto L8;
            String r106 = r100.readString();
            Intrinsics.checkNotNull(r106);
            Pair r107 = new Pair(r106, Integer.valueOf(r100.readInt()));
            r104.put(r107.getFirst(), r107.getSecond());
            r105 = r105 + 1;
            goto L6
        L8:
            r103 = r104;
            goto L9
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f163083a);
            r100.writeLong(this.f163084b);
            Map<String, Integer> r102 = this.f163085c;
            if (r102 == null) goto L5;
            int r103 = r102.size();
        L6:
            r100.writeInt(r103);
            if (r103 <= 0) goto L12;
            Intrinsics.checkNotNull(r102);
            Iterator<T> r104 = r102.entrySet().iterator();
        L10:
            if (r104.hasNext() == false) goto L14;
            Map.Entry r105 = (Map.Entry) r104.next();
            r100.writeString((String) r105.getKey());
            r100.writeInt(((Number) r105.getValue()).intValue());
            goto L10
        L14:
            return;
        L12:
            return;
        L5:
            r103 = 0;
            goto L6
        }
    }

    public static final class a implements Parcelable.Creator<BidInfoAdapter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BidInfoAdapter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new BidInfoAdapter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BidInfoAdapter[] newArray(int r100) {
            return new BidInfoAdapter[r100];
        }
    }

    public static final class b {
    }

    static {
        CREATOR = new a();
    }

    public BidInfoAdapter() {
    }

    public BidInfoAdapter(Parcel r100) {
        this();
        this.f163080a = r100.readLong();
        int r101 = r100.readInt();
        int r102 = 0;
        ArrayList r103 = null;
        if (r101 != 0) goto L5;
        BidConfigAdapter[] r104 = null;
    L8:
        this.f163081b = r104;
        int r105 = r100.readInt();
        if (r105 == 0) goto L14;
        r103 = new ArrayList();
    L12:
        if (r102 >= r105) goto L14;
        String r106 = r100.readString();
        Intrinsics.checkNotNull(r106);
        String r107 = r100.readString();
        Intrinsics.checkNotNull(r107);
        r103.add(new c(r106, r107));
        r102 = r102 + 1;
    L14:
        this.f163082c = r103;
        return;
    L5:
        r104 = new BidConfigAdapter[r101];
        int r108 = 0;
    L6:
        if (r108 >= r101) goto L8;
        r104[r108] = BidConfigAdapter.CREATOR.createFromParcel(r100);
        r108 = r108 + 1;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f163080a);
        BidConfigAdapter[] r102 = this.f163081b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.length;
    L6:
        r100.writeInt(r104);
        if (r104 <= 0) goto L11;
        Intrinsics.checkNotNull(r102);
        int r105 = r102.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r102[r106].writeToParcel(r100, r101);
        r106 = r106 + 1;
    L11:
        List<? extends lz2.a> r107 = this.f163082c;
        if (r107 == null) goto L14;
        r103 = r107.size();
    L14:
        r100.writeInt(r103);
        if (r103 <= 0) goto L24;
        Intrinsics.checkNotNull(r107);
        Iterator<T> r108 = r107.iterator();
    L18:
        if (r108.hasNext() == false) goto L29;
        lz2.a r109 = (lz2.a) r108.next();
        r100.writeString(r109.f511342a);
        if ((r109 instanceof c) == false) goto L22;
        String r110 = ((c) r109).f511354e;
    L23:
        r100.writeString(r110);
        goto L18
    L22:
        r110 = r109.b().toString();
        goto L23
    L29:
        return;
    L24:
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
