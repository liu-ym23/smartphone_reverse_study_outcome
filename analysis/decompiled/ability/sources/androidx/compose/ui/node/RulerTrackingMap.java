package androidx.compose.ui.node;

import D7.q;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.layout.Ruler;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006+"}, d2 = {"Landroidx/compose/ui/node/RulerTrackingMap;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/layout/Ruler;", "ruler", "", "defaultValue", "getOrDefault", "(Landroidx/compose/ui/layout/Ruler;F)F", "value", "LC7/r;", "set", "(Landroidx/compose/ui/layout/Ruler;F)V", "", "contains", "(Landroidx/compose/ui/layout/Ruler;)Z", "isLookingAhead", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "node", "Landroidx/collection/MutableScatterMap;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "Landroidx/compose/ui/node/LayoutNode;", "rulerReaders", "notifyChanged", "(ZLandroidx/compose/ui/node/LookaheadCapablePlaceable;Landroidx/collection/MutableScatterMap;)V", "clear", "", "size", "I", "", "rulers", "[Landroidx/compose/ui/layout/Ruler;", "", "values", "[F", "", "accessFlags", "[B", "layoutNodes", "Landroidx/collection/MutableScatterSet;", "newRulers", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class RulerTrackingMap {
    private int size;
    private Ruler[] rulers = new Ruler[32];
    private float[] values = new float[32];
    private byte[] accessFlags = new byte[32];
    private MutableScatterSet<WeakReference<LayoutNode>> layoutNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<Ruler> newRulers = ScatterSetKt.mutableScatterSetOf();

    public final void clear() {
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            this.rulers[i6] = null;
            this.values[i6] = Float.NaN;
            this.accessFlags[i6] = 0;
        }
        this.size = 0;
    }

    public final boolean contains(Ruler ruler) {
        return q.N(ruler, this.rulers);
    }

    public final float getOrDefault(Ruler ruler, float defaultValue) {
        int iU0 = q.u0(this.rulers, ruler);
        return iU0 < 0 ? defaultValue : this.values[iU0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void notifyChanged(boolean r23, androidx.compose.ui.node.LookaheadCapablePlaceable r24, androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<androidx.compose.ui.node.WeakReference<androidx.compose.ui.node.LayoutNode>>> r25) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.RulerTrackingMap.notifyChanged(boolean, androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.collection.MutableScatterMap):void");
    }

    public final void set(Ruler ruler, float value) {
        int iU0 = q.u0(this.rulers, ruler);
        if (iU0 >= 0) {
            float[] fArr = this.values;
            if (fArr[iU0] != value) {
                fArr[iU0] = value;
                this.accessFlags[iU0] = 1;
                return;
            } else {
                byte[] bArr = this.accessFlags;
                if (bArr[iU0] == 2) {
                    bArr[iU0] = 0;
                    return;
                }
                return;
            }
        }
        int i = this.size;
        Ruler[] rulerArr = this.rulers;
        if (i == rulerArr.length) {
            int i6 = i * 2;
            Object[] objArrCopyOf = Arrays.copyOf(rulerArr, i6);
            k.e(objArrCopyOf, "copyOf(...)");
            this.rulers = (Ruler[]) objArrCopyOf;
            float[] fArrCopyOf = Arrays.copyOf(this.values, i6);
            k.e(fArrCopyOf, "copyOf(...)");
            this.values = fArrCopyOf;
            byte[] bArrCopyOf = Arrays.copyOf(this.accessFlags, i6);
            k.e(bArrCopyOf, "copyOf(...)");
            this.accessFlags = bArrCopyOf;
        }
        this.rulers[i] = ruler;
        this.accessFlags[i] = 3;
        this.values[i] = value;
        this.size++;
    }
}
