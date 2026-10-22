package com.stepos.aiengine.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/data/IntMatrix;", "Landroid/os/Parcelable;", "", "", "matrix", AppAgent.CONSTRUCT, "([[I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "row", "get", "(I)[I", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "[[I", "getMatrix", "()[[I", "getRows", "rows", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntMatrix implements Parcelable {
    private final int[][] matrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<IntMatrix> CREATOR = new IntMatrix$Companion$CREATOR$1();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/data/IntMatrix$Companion;", "", "Lcom/stepos/aiengine/data/IntMatrix;", "empty", "()Lcom/stepos/aiengine/data/IntMatrix;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final IntMatrix empty() {
            return new IntMatrix(new int[0][]);
        }
    }

    public /* synthetic */ IntMatrix(Parcel parcel, e eVar) {
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
        k.f(dest, "dest");
        dest.writeInt(this.matrix.length);
        for (int[] iArr : this.matrix) {
            dest.writeInt(iArr.length);
            dest.writeIntArray(iArr);
        }
    }

    public IntMatrix(int[][] matrix) {
        k.f(matrix, "matrix");
        this.matrix = matrix;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private IntMatrix(Parcel parcel) {
        int i = parcel.readInt();
        int[][] iArr = new int[i][];
        for (int i6 = 0; i6 < i; i6++) {
            int[] iArr2 = new int[parcel.readInt()];
            parcel.readIntArray(iArr2);
            iArr[i6] = iArr2;
        }
        this(iArr);
    }
}
