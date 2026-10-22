package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LocalLifePreviewExtendAreaExtra;", "Ljava/io/Serializable;", "localLiveLife", "Lcom/bytedance/android/livesdkapi/depend/model/live/LocalLifePreviewExtendAreaExtra$LocalLiveLife;", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LocalLifePreviewExtendAreaExtra$LocalLiveLife;)V", "getLocalLiveLife", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LocalLifePreviewExtendAreaExtra$LocalLiveLife;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "LocalLiveLife", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalLifePreviewExtendAreaExtra implements Serializable {

    @SerializedName("local_life_live")
    private final LocalLiveLife localLiveLife;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LocalLifePreviewExtendAreaExtra$LocalLiveLife;", "Ljava/io/Serializable;", "carouselInterval", "", "carouselList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExtendArea;", "cardType", "(JLjava/util/List;J)V", "getCardType", "()J", "getCarouselInterval", "getCarouselList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LocalLiveLife implements Serializable {

        @SerializedName("carousel_card_type")
        private final long cardType;

        @SerializedName("carousel_interval")
        private final long carouselInterval;

        @SerializedName("carousel_list")
        private final List<PreviewExtendArea> carouselList;

        public LocalLiveLife() {
            this(0, null, 0, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalLiveLife copy$default(LocalLiveLife r100, long r101, List r102, long r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L5;
            r101 = r100.carouselInterval;
        L5:
            long r103 = r101;
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.carouselList;
        L8:
            List r104 = r102;
            if ((r111 & 4) == 0) goto L12;
            r110 = r100.cardType;
        L12:
            return r100.copy(r103, r104, r110);
        }

        public final long component1() {
            return this.carouselInterval;
        }

        public final List<PreviewExtendArea> component2() {
            return this.carouselList;
        }

        public final long component3() {
            return this.cardType;
        }

        public final LocalLiveLife copy(long r100, List<PreviewExtendArea> r110, long r111) {
            return new LocalLiveLife(r100, r110, r111);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LocalLiveLife) == false) goto L12;
            LocalLiveLife r101 = (LocalLiveLife) r100;
            if (this.carouselInterval == r101.carouselInterval) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.carouselList, r101.carouselList) == true) goto L10;
            return false;
        L10:
            if (this.cardType == r101.cardType) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            long r100 = this.carouselInterval;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            List<PreviewExtendArea> r102 = this.carouselList;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L6:
            long r104 = this.cardType;
            return ((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "LocalLiveLife(carouselInterval=" + this.carouselInterval + ", carouselList=" + this.carouselList + ", cardType=" + this.cardType + ")";
        }

        public final long getCardType() {
            return this.cardType;
        }

        public final long getCarouselInterval() {
            return this.carouselInterval;
        }

        public final List<PreviewExtendArea> getCarouselList() {
            return this.carouselList;
        }

        public LocalLiveLife(long r100, List<PreviewExtendArea> r101, long r102) {
            this.carouselInterval = r100;
            this.carouselList = r101;
            this.cardType = r102;
        }

        public /* synthetic */ LocalLiveLife(long r100, List r101, long r102, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            long r103 = 0;
        L7:
            if ((r110 & 2) == 0) goto L9;
            r101 = null;
        L9:
            List r112 = r101;
            if ((r110 & 4) == 0) goto L12;
            long r104 = 0;
        L13:
            this(r103, r112, r104);
            return;
        L12:
            r104 = r102;
            goto L13
        L5:
            r103 = r100;
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalLifePreviewExtendAreaExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LocalLifePreviewExtendAreaExtra copy$default(LocalLifePreviewExtendAreaExtra r100, LocalLiveLife r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.localLiveLife;
    L6:
        return r100.copy(r101);
    }

    public final LocalLiveLife component1() {
        return this.localLiveLife;
    }

    public final LocalLifePreviewExtendAreaExtra copy(LocalLiveLife r100) {
        return new LocalLifePreviewExtendAreaExtra(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LocalLifePreviewExtendAreaExtra) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.localLiveLife, ((LocalLifePreviewExtendAreaExtra) r100).localLiveLife) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        LocalLiveLife r100 = this.localLiveLife;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "LocalLifePreviewExtendAreaExtra(localLiveLife=" + this.localLiveLife + ")";
    }

    public final LocalLiveLife getLocalLiveLife() {
        return this.localLiveLife;
    }

    public LocalLifePreviewExtendAreaExtra(LocalLiveLife r100) {
        this.localLiveLife = r100;
    }

    public /* synthetic */ LocalLifePreviewExtendAreaExtra(LocalLiveLife r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
