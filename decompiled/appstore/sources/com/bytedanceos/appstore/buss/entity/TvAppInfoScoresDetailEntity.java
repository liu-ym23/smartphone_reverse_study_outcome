package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvAppInfoScoresDetailEntity;", "Landroid/os/Parcelable;", "count", "", "score", "(II)V", "getCount", "()I", "getScore", "component1", "component2", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppInfoScoresDetailEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TvAppInfoScoresDetailEntity> CREATOR = null;
    private final int count;
    private final int score;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TvAppInfoScoresDetailEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoScoresDetailEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new TvAppInfoScoresDetailEntity(r10.readInt(), r10.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoScoresDetailEntity[] newArray(int r10) {
            return new TvAppInfoScoresDetailEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoScoresDetailEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoScoresDetailEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public TvAppInfoScoresDetailEntity(int r10, int r11) {
        this.count = r10;
        this.score = r11;
    }

    public static /* synthetic */ TvAppInfoScoresDetailEntity copy$default(TvAppInfoScoresDetailEntity r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.count;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.score;
    L9:
        return r10.copy(r11, r12);
    }

    public final int component1() {
        return this.count;
    }

    public final int component2() {
        return this.score;
    }

    @NotNull
    public final TvAppInfoScoresDetailEntity copy(int r10, int r11) {
        return new TvAppInfoScoresDetailEntity(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppInfoScoresDetailEntity) == true) goto L8;
        return false;
    L8:
        TvAppInfoScoresDetailEntity r11 = (TvAppInfoScoresDetailEntity) r10;
        if (this.count == r11.count) goto L12;
        return false;
    L12:
        if (this.score == r11.score) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Integer.hashCode(this.score);
    }

    @NotNull
    public String toString() {
        return "TvAppInfoScoresDetailEntity(count=" + this.count + ", score=" + this.score + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeInt(this.count);
        r10.writeInt(this.score);
    }
}
