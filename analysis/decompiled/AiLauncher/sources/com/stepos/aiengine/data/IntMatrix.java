package com.stepos.aiengine.data;

import Y8.t;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/data/IntMatrix;", "Landroid/os/Parcelable;", "", "", "matrix", "<init>", "([[I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "row", "get", "(I)[I", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "[[I", "getMatrix", "()[[I", "getRows", "rows", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IntMatrix implements Parcelable {
    private final int[][] matrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<IntMatrix> CREATOR = new Parcelable.Creator<IntMatrix>() { // from class: com.stepos.aiengine.data.IntMatrix$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntMatrix createFromParcel(Parcel source) {
            p.i(source, "source");
            return new IntMatrix(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntMatrix[] newArray(int size) {
            return new IntMatrix[size];
        }
    };

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/data/IntMatrix$Companion;", "", "<init>", "()V", "empty", "Lcom/stepos/aiengine/data/IntMatrix;", "CREATOR", "Landroid/os/Parcelable$Creator;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final IntMatrix empty() {
            return new IntMatrix(new int[0][]);
        }

        public Companion() {
        }
    }

    public /* synthetic */ IntMatrix(Parcel parcel, i iVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int[] get(int row) {
        return this.matrix[row];
    }

    public final int[][] getMatrix() {
        return this.matrix;
    }

    public final int getRows() {
        return this.matrix.length;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.matrix.length);
        for (int[] iArr : this.matrix) {
            dest.writeInt(iArr.length);
            dest.writeIntArray(iArr);
        }
    }

    public IntMatrix(int[][] matrix) {
        p.i(matrix, "matrix");
        this.matrix = matrix;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private IntMatrix(Parcel parcel) {
        int i10 = parcel.readInt();
        int[][] iArr = new int[i10][];
        for (int i11 = 0; i11 < i10; i11++) {
            int[] iArr2 = new int[parcel.readInt()];
            parcel.readIntArray(iArr2);
            t tVar = t.f7040a;
            iArr[i11] = iArr2;
        }
        this(iArr);
    }
}
