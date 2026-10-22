package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class CheckFilter extends AbstractParcelableAdapter {
    public static final Parcelable.Creator<CheckFilter> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? extends List<String>> f163086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f163087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163088c;

    public static final class a implements Parcelable.Creator<CheckFilter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CheckFilter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new CheckFilter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CheckFilter[] newArray(int r100) {
            return new CheckFilter[r100];
        }
    }

    public static final class b {
    }

    public CheckFilter() {
        this(0);
    }

    static {
        CREATOR = new a();
    }

    public CheckFilter(Parcel r110) {
        int r100 = r110.readInt();
        int r101 = 0;
        ArrayList r102 = null;
        if (r100 != 0) goto L5;
        HashMap r103 = null;
    L16:
        if (r103 != null) goto L18;
        r103 = new HashMap();
    L18:
        this.f163086a = r103;
        int r104 = r110.readInt();
        if (r104 == 0) goto L24;
        r102 = new ArrayList();
    L22:
        if (r101 >= r104) goto L24;
        String r105 = r110.readString();
        Intrinsics.checkNotNull(r105);
        r102.add(r105);
        r101 = r101 + 1;
    L24:
        if (r102 != null) goto L26;
        r102 = new ArrayList();
    L26:
        this.f163087b = r102;
        String r111 = r110.readString();
        Intrinsics.checkNotNull(r111);
        this.f163088c = r111;
        return;
    L5:
        r103 = new LinkedHashMap();
        int r106 = 0;
    L6:
        if (r106 >= r100) goto L16;
        String r107 = r110.readString();
        Intrinsics.checkNotNull(r107);
        int r108 = r110.readInt();
        if (r108 != 0) goto L10;
        ArrayList r109 = null;
    L13:
        if (r109 != null) goto L15;
        r109 = new ArrayList();
    L15:
        Pair r112 = new Pair(r107, r109);
        r103.put(r112.getFirst(), r112.getSecond());
        r106 = r106 + 1;
        goto L6
    L10:
        r109 = new ArrayList();
        int r113 = 0;
    L11:
        if (r113 >= r108) goto L13;
        String r114 = r110.readString();
        Intrinsics.checkNotNull(r114);
        r109.add(r114);
        r113 = r113 + 1;
        goto L11
    }

    public /* synthetic */ CheckFilter(int r100) {
        this(new HashMap(), new ArrayList(), "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Map<String, ? extends List<String>> r102 = this.f163086a;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.size();
    L6:
        r100.writeInt(r104);
        if (r104 <= 0) goto L21;
        Intrinsics.checkNotNull(r102);
        Iterator<T> r105 = r102.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L21;
        Map.Entry r106 = (Map.Entry) r105.next();
        r100.writeString((String) r106.getKey());
        List r107 = (List) r106.getValue();
        if (r107 == null) goto L14;
        int r108 = r107.size();
    L15:
        r100.writeInt(r108);
        if (r108 <= 0) goto L10;
        Intrinsics.checkNotNull(r107);
        Iterator r109 = r107.iterator();
    L19:
        if (r109.hasNext() == false) goto L10;
        r100.writeString((String) r109.next());
        goto L19
    L14:
        r108 = 0;
    L21:
        List<String> r110 = this.f163087b;
        if (r110 == null) goto L24;
        r103 = r110.size();
    L24:
        r100.writeInt(r103);
        if (r103 <= 0) goto L30;
        Intrinsics.checkNotNull(r110);
        Iterator<T> r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        r100.writeString((String) r111.next());
    L30:
        r100.writeString(this.f163088c);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public CheckFilter(Map<String, ? extends List<String>> r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "id");
        this.f163086a = r100;
        this.f163087b = r101;
        this.f163088c = r102;
    }
}
