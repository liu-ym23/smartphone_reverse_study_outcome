package com.bytedance.android.livesdk.vs.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/SearchPanelParam;", "Landroid/os/Parcelable;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchPanelParam implements Parcelable {
    public static final Parcelable.Creator<SearchPanelParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CollectionItem> f159398b;

    public static class a implements Parcelable.Creator<SearchPanelParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchPanelParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            int r101 = r100.readInt();
            if (r100.readInt() == 0) goto L7;
            int r102 = r100.readInt();
            ArrayList r103 = new ArrayList(r102);
        L5:
            if (r102 == 0) goto L9;
            r103.add(CollectionItem.CREATOR.createFromParcel(r100));
            r102 = r102 - 1;
        L9:
            return new SearchPanelParam(r101, r103);
        L7:
            r103 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SearchPanelParam[] newArray(int r100) {
            return new SearchPanelParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchPanelParam) == false) goto L10;
        SearchPanelParam r101 = (SearchPanelParam) r100;
        if (this.f159397a == r101.f159397a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f159398b, r101.f159398b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f159397a * 31;
        List<CollectionItem> r101 = this.f159398b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "SearchPanelParam(index=" + this.f159397a + ", CollectionPreloadData=" + this.f159398b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f159397a);
        List<CollectionItem> r102 = this.f159398b;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<CollectionItem> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, 0);
        goto L6
    L11:
        return;
    L8:
        r100.writeInt(0);
    }

    public SearchPanelParam() {
        this(0, new ArrayList());
    }

    public SearchPanelParam(int r100, List<CollectionItem> r101) {
        this.f159397a = r100;
        this.f159398b = r101;
    }
}
