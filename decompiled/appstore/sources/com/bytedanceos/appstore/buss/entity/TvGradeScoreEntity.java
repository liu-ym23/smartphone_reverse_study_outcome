package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvGradeScoreEntity;", "Landroid/os/Parcelable;", "count", "", "score", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "getScore", "()Ljava/lang/Integer;", "setScore", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedanceos/appstore/buss/entity/TvGradeScoreEntity;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvGradeScoreEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TvGradeScoreEntity> CREATOR = null;

    @Nullable
    private String count;

    @Nullable
    private Integer score;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TvGradeScoreEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvGradeScoreEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            String r11 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r12 = null;
        L7:
            return new TvGradeScoreEntity(r11, r12);
        L5:
            r12 = Integer.valueOf(r10.readInt());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvGradeScoreEntity[] newArray(int r10) {
            return new TvGradeScoreEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvGradeScoreEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvGradeScoreEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TvGradeScoreEntity() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TvGradeScoreEntity copy$default(TvGradeScoreEntity r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.count;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.score;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.count;
    }

    @Nullable
    public final Integer component2() {
        return this.score;
    }

    @NotNull
    public final TvGradeScoreEntity copy(@Nullable String r10, @Nullable Integer r11) {
        return new TvGradeScoreEntity(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvGradeScoreEntity) == true) goto L8;
        return false;
    L8:
        TvGradeScoreEntity r11 = (TvGradeScoreEntity) r10;
        if (q.b(this.count, r11.count) == true) goto L12;
        return false;
    L12:
        if (q.b(this.score, r11.score) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getCount() {
        return this.count;
    }

    @Nullable
    public final Integer getScore() {
        return this.score;
    }

    public int hashCode() {
        String r10 = this.count;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Integer r14 = this.score;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setCount(@Nullable String r10) {
        this.count = r10;
    }

    public final void setScore(@Nullable Integer r10) {
        this.score = r10;
    }

    @NotNull
    public String toString() {
        return "TvGradeScoreEntity(count=" + this.count + ", score=" + this.score + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.count);
        Integer r12 = this.score;
        if (r12 != null) goto L6;
        int r13 = 0;
    L5:
        r10.writeInt(r13);
        return;
    L6:
        r10.writeInt(1);
        r13 = r12.intValue();
        goto L5
    }

    public TvGradeScoreEntity(@Nullable String r10, @Nullable Integer r11) {
        this.count = r10;
        this.score = r11;
    }

    public /* synthetic */ TvGradeScoreEntity(String r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
