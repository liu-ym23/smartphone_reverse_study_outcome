package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import p2.C5047a;

/* loaded from: classes2.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new c();
    private static final Comparator zaa = new Comparator() { // from class: com.google.android.gms.common.moduleinstall.internal.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Feature feature = (Feature) obj;
            Feature feature2 = (Feature) obj2;
            Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
            return !feature.getName().equals(feature2.getName()) ? feature.getName().compareTo(feature2.getName()) : (feature.getVersion() > feature2.getVersion() ? 1 : (feature.getVersion() == feature2.getVersion() ? 0 : -1));
        }
    };
    private final List zab;
    private final boolean zac;
    private final String zad;
    private final String zae;

    public ApiFeatureRequest(List list, boolean z10, String str, String str2) {
        C1669j.k(list);
        this.zab = list;
        this.zac = z10;
        this.zad = str;
        this.zae = str2;
    }

    public static ApiFeatureRequest fromModuleInstallRequest(q2.d dVar) {
        return zaa(dVar.a(), true);
    }

    public static ApiFeatureRequest zaa(List list, boolean z10) {
        TreeSet treeSet = new TreeSet(zaa);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((com.google.android.gms.common.api.e) it.next()).e());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z10, null, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.zac == apiFeatureRequest.zac && C1668i.a(this.zab, apiFeatureRequest.zab) && C1668i.a(this.zad, apiFeatureRequest.zad) && C1668i.a(this.zae, apiFeatureRequest.zae);
    }

    public List<Feature> getApiFeatures() {
        return this.zab;
    }

    public final int hashCode() {
        return C1668i.b(Boolean.valueOf(this.zac), this.zab, this.zad, this.zae);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.B(parcel, 1, getApiFeatures(), false);
        C5047a.g(parcel, 2, this.zac);
        C5047a.x(parcel, 3, this.zad, false);
        C5047a.x(parcel, 4, this.zae, false);
        C5047a.b(parcel, iA);
    }
}
