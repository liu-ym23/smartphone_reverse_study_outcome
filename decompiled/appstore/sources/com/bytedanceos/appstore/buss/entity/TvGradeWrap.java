package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvGradeWrap;", "Landroid/os/Parcelable;", "count", "", ServerElements.SCORES, "score", "", "Lcom/bytedanceos/appstore/buss/entity/TvGradeScoreEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "getScore", "()Ljava/util/List;", "setScore", "(Ljava/util/List;)V", "getScores", "setScores", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvGradeWrap implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TvGradeWrap> CREATOR = null;

    @Nullable
    private String count;

    @Nullable
    private List<TvGradeScoreEntity> score;

    @Nullable
    private String scores;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TvGradeWrap> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvGradeWrap createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            String r11 = r10.readString();
            String r12 = r10.readString();
            ArrayList r13 = null;
            if (r10.readInt() == 0) goto L14;
            int r14 = r10.readInt();
            ArrayList r15 = new ArrayList(r14);
            int r16 = 0;
        L6:
            if (r16 == r14) goto L12;
            if (r10.readInt() != 0) goto L10;
            TvGradeScoreEntity r17 = null;
        L11:
            r15.add(r17);
            r16 = r16 + 1;
            goto L6
        L10:
            r17 = TvGradeScoreEntity.CREATOR.createFromParcel(r10);
            goto L11
        L12:
            r13 = r15;
        L14:
            return new TvGradeWrap(r11, r12, r13);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvGradeWrap[] newArray(int r10) {
            return new TvGradeWrap[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvGradeWrap createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvGradeWrap[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public TvGradeWrap() {
        String r10 = null;
        String r11 = null;
        List r12 = null;
        this(r10, r11, r12, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TvGradeWrap copy$default(TvGradeWrap r10, String r11, String r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.count;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.scores;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.score;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.count;
    }

    @Nullable
    public final String component2() {
        return this.scores;
    }

    @Nullable
    public final List<TvGradeScoreEntity> component3() {
        return this.score;
    }

    @NotNull
    public final TvGradeWrap copy(@Nullable String r10, @Nullable String r11, @Nullable List<TvGradeScoreEntity> r12) {
        return new TvGradeWrap(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvGradeWrap) == true) goto L8;
        return false;
    L8:
        TvGradeWrap r11 = (TvGradeWrap) r10;
        if (q.b(this.count, r11.count) == true) goto L12;
        return false;
    L12:
        if (q.b(this.scores, r11.scores) == true) goto L15;
        return false;
    L15:
        if (q.b(this.score, r11.score) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String getCount() {
        return this.count;
    }

    @Nullable
    public final List<TvGradeScoreEntity> getScore() {
        return this.score;
    }

    @Nullable
    public final String getScores() {
        return this.scores;
    }

    public int hashCode() {
        String r10 = this.count;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.scores;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        List<TvGradeScoreEntity> r17 = this.score;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setCount(@Nullable String r10) {
        this.count = r10;
    }

    public final void setScore(@Nullable List<TvGradeScoreEntity> r10) {
        this.score = r10;
    }

    public final void setScores(@Nullable String r10) {
        this.scores = r10;
    }

    @NotNull
    public String toString() {
        return "TvGradeWrap(count=" + this.count + ", scores=" + this.scores + ", score=" + this.score + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.count);
        r10.writeString(this.scores);
        List<TvGradeScoreEntity> r12 = this.score;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.size());
        Iterator<TvGradeScoreEntity> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        TvGradeScoreEntity r14 = r13.next();
        if (r14 == null) goto L10;
        r10.writeInt(1);
        r14.writeToParcel(r10, r11);
        goto L7
    L10:
        r10.writeInt(0);
        goto L7
    }

    public TvGradeWrap(@Nullable String r10, @Nullable String r11, @Nullable List<TvGradeScoreEntity> r12) {
        this.count = r10;
        this.scores = r11;
        this.score = r12;
    }

    public /* synthetic */ TvGradeWrap(String r10, String r11, List r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
