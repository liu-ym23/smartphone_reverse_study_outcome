package com.stepos.aiengine.data;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/data/FloatMatrix;", "", "", "rows", "cols", "", "data", "<init>", "(II[F)V", "row", "col", "", "get", "(II)F", UxipConstants.f30680s, "LY8/t;", "set", "(III)V", "(IIF)V", "getRow", "(I)[F", "", "getMatrix", "()[[F", Const.INTENT_KEY_APIKEY, "I", "getRows", "()I", Const.INTENT_KEY_PKGNAME, "getCols", "c", "[F", "getData", "()[F", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatMatrix {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int rows;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int cols;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final float[] data;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/aiengine/data/FloatMatrix$Companion;", "", "<init>", "()V", "empty", "Lcom/stepos/aiengine/data/FloatMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FloatMatrix empty() {
            return new FloatMatrix(0, 0, null, 4, null);
        }

        public Companion() {
        }
    }

    public FloatMatrix(int i10, int i11, float[] data) {
        p.i(data, "data");
        this.rows = i10;
        this.cols = i11;
        this.data = data;
    }

    public final float get(int row, int col) {
        return this.data[(row * this.cols) + col];
    }

    public final int getCols() {
        return this.cols;
    }

    public final float[] getData() {
        return this.data;
    }

    public final float[][] getMatrix() {
        int i10 = this.rows;
        float[][] fArr = new float[i10][];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr[i11] = getRow(i11);
        }
        return fArr;
    }

    public final float[] getRow(int row) {
        float[] fArr = this.data;
        int i10 = this.cols;
        return C1168p.p(fArr, row * i10, (row + 1) * i10);
    }

    public final int getRows() {
        return this.rows;
    }

    public final void set(int row, int col, int value) {
        this.data[(row * this.cols) + col] = value;
    }

    public final void set(int row, int col, float value) {
        this.data[(row * this.cols) + col] = value;
    }

    public /* synthetic */ FloatMatrix(int i10, int i11, float[] fArr, int i12, i iVar) {
        this(i10, i11, (i12 & 4) != 0 ? new float[i10 * i11] : fArr);
    }
}
