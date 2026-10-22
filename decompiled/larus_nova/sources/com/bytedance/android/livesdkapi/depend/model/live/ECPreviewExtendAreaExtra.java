package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ECPreviewExtendAreaExtra;", "Ljava/io/Serializable;", "ecom", "Lcom/bytedance/android/livesdkapi/depend/model/live/ECPreviewExtendAreaExtra$Ecom;", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ECPreviewExtendAreaExtra$Ecom;)V", "getEcom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ECPreviewExtendAreaExtra$Ecom;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Ecom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreviewExtendAreaExtra implements Serializable {

    @SerializedName("ecom")
    private final Ecom ecom;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ECPreviewExtendAreaExtra$Ecom;", "", "carouselInterval", "", "carouselList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExtendArea;", "(JLjava/util/List;)V", "getCarouselInterval", "()J", "getCarouselList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Ecom {

        @SerializedName("carousel_interval")
        private final long carouselInterval;

        @SerializedName("carousel_list")
        private final List<PreviewExtendArea> carouselList;

        public Ecom() {
            this(0, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ecom copy$default(Ecom r100, long r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.carouselInterval;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.carouselList;
        L9:
            return r100.copy(r101, r102);
        }

        public final long component1() {
            return this.carouselInterval;
        }

        public final List<PreviewExtendArea> component2() {
            return this.carouselList;
        }

        public final Ecom copy(long r100, List<PreviewExtendArea> r101) {
            return new Ecom(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Ecom) == false) goto L10;
            Ecom r101 = (Ecom) r100;
            if (this.carouselInterval == r101.carouselInterval) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.carouselList, r101.carouselList) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            long r100 = this.carouselInterval;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            List<PreviewExtendArea> r102 = this.carouselList;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public String toString() {
            return "Ecom(carouselInterval=" + this.carouselInterval + ", carouselList=" + this.carouselList + ")";
        }

        public final long getCarouselInterval() {
            return this.carouselInterval;
        }

        public final List<PreviewExtendArea> getCarouselList() {
            return this.carouselList;
        }

        public Ecom(long r100, List<PreviewExtendArea> r101) {
            this.carouselInterval = r100;
            this.carouselList = r101;
        }

        public /* synthetic */ Ecom(long r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPreviewExtendAreaExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECPreviewExtendAreaExtra copy$default(ECPreviewExtendAreaExtra r100, Ecom r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.ecom;
    L6:
        return r100.copy(r101);
    }

    public final Ecom component1() {
        return this.ecom;
    }

    public final ECPreviewExtendAreaExtra copy(Ecom r100) {
        return new ECPreviewExtendAreaExtra(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPreviewExtendAreaExtra) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.ecom, ((ECPreviewExtendAreaExtra) r100).ecom) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Ecom r100 = this.ecom;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ECPreviewExtendAreaExtra(ecom=" + this.ecom + ")";
    }

    public final Ecom getEcom() {
        return this.ecom;
    }

    public ECPreviewExtendAreaExtra(Ecom r100) {
        this.ecom = r100;
    }

    public /* synthetic */ ECPreviewExtendAreaExtra(Ecom r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
