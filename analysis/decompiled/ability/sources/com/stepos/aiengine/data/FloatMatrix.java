package com.stepos.aiengine.data;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/data/FloatMatrix;", "", "", "rows", "cols", "", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(II[F)V", "row", "col", "", "get", "(II)F", "value", "LC7/r;", "set", "(III)V", "(IIF)V", "getRow", "(I)[F", "", "getMatrix", "()[[F", "a", "I", "getRows", "()I", "b", "getCols", "c", "[F", "getData", "()[F", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatMatrix {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int rows;

    /* renamed from: b, reason: from kotlin metadata */
    public final int cols;

    /* renamed from: c, reason: from kotlin metadata */
    public final float[] data;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/aiengine/data/FloatMatrix$Companion;", "", "Lcom/stepos/aiengine/data/FloatMatrix;", "empty", "()Lcom/stepos/aiengine/data/FloatMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final FloatMatrix empty() {
            return new FloatMatrix(0, 0, null, 4, null);
        }
    }

    public FloatMatrix(int i, int i6, float[] data) {
        k.f(data, "data");
        this.rows = i;
        this.cols = i6;
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
        int i = this.rows;
        float[][] fArr = new float[i][];
        for (int i6 = 0; i6 < i; i6++) {
            fArr[i6] = getRow(i6);
        }
        return fArr;
    }

    public final float[] getRow(int row) {
        int i = this.cols;
        int i6 = row * i;
        int i10 = (row + 1) * i;
        float[] fArr = this.data;
        k.f(fArr, "<this>");
        l.q(i10, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i6, i10);
        k.e(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
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

    public /* synthetic */ FloatMatrix(int i, int i6, float[] fArr, int i10, e eVar) {
        this(i, i6, (i10 & 4) != 0 ? new float[i * i6] : fArr);
    }
}
