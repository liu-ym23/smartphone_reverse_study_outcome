package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ8\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082\bJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "<init>", "()V", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodeData", "", "clear", "", "parsePathString", "pathData", "", "pathStringToNodes", "resizeNodeData", "dataCount", "", "addPathNodes", "", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", PickerReporterConstants.KEY.TARGET, "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PathParser {
    private float[] nodeData;
    private ArrayList<PathNode> nodes;

    public final void clear() {
        ArrayList<PathNode> r100 = this.nodes;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public final List<PathNode> toNodes() {
        ArrayList<PathNode> r100 = this.nodes;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return CollectionsKt.emptyList();
    }

    public PathParser() {
        this.nodeData = new float[64];
    }

    private final void resizeNodeData(int r100) {
        float[] r101 = this.nodeData;
        if (r100 < r101.length) goto L6;
        float[] r102 = new float[r100 * 2];
        this.nodeData = r102;
        ArraysKt.copyInto(r101, r102, 0, 0, r101.length);
        return;
    }

    public final PathParser addPathNodes(List<? extends PathNode> r100) {
        ArrayList<PathNode> r101 = this.nodes;
        if (r101 != null) goto L5;
        r101 = new ArrayList();
        this.nodes = r101;
    L5:
        r101.addAll(r100);
        return this;
    }

    public final PathParser parsePathString(String r100) {
        ArrayList<PathNode> r101 = this.nodes;
        if (r101 != null) goto L5;
        r101 = new ArrayList();
        this.nodes = r101;
    L6:
        pathStringToNodes(r100, r101);
        return this;
    L5:
        r101.clear();
        goto L6
    }

    public final Path toPath(Path r100) {
        ArrayList<PathNode> r101 = this.nodes;
        if (r101 == null) goto L7;
        Path r102 = PathParserKt.toPath(r101, r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return AndroidPath_androidKt.Path();
    }

    public final ArrayList<PathNode> pathStringToNodes(String r110, ArrayList<PathNode> r111) {
        int r100 = r110.length();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L8;
        if (Intrinsics.compare(r110.charAt(r101), 32) > 0) goto L8;
        r101 = r101 + 1;
    L8:
        if (r100 <= r101) goto L12;
        if (Intrinsics.compare(r110.charAt(r100 - 1), 32) > 0) goto L12;
        r100 = r100 - 1;
    L12:
        int r102 = 0;
    L13:
        if (r101 >= r100) goto L48;
    L14:
        int r103 = r101 + 1;
        char r104 = r110.charAt(r101);
        int r105 = r104 | ' ';
        if (((r105 - 97) * (r105 + NetError.ERR_ALPN_NEGOTIATION_FAILED)) <= 0) goto L17;
    L19:
        if (r103 >= r100) goto L20;
        r101 = r103;
        goto L14
    L20:
        r104 = 0;
    L21:
        if (r104 == 0) goto L46;
        if ((r104 | ' ') == 122) goto L45;
        r102 = 0;
    L25:
        if (r103 >= r100) goto L29;
        if (Intrinsics.compare(r110.charAt(r103), 32) > 0) goto L29;
        r103 = r103 + 1;
    L29:
        long r106 = FastFloatParserKt.nextFloat(r110, r103, r100);
        int r107 = (int) (r106 >>> 32);
        float r108 = Float.intBitsToFloat((int) (r106 & BodyPartID.bodyIdMax));
        if (Float.isNaN(r108) == true) goto L35;
        float[] r109 = this.nodeData;
        int r112 = r102 + 1;
        r109[r102] = r108;
        if (r112 < r109.length) goto L34;
        float[] r113 = new float[r112 * 2];
        this.nodeData = r113;
        ArraysKt.copyInto(r109, r113, 0, 0, r109.length);
    L34:
        r102 = r112;
    L35:
        if (r107 >= r100) goto L39;
        if (r110.charAt(r107) != ',') goto L39;
        r107 = r107 + 1;
    L39:
        if (r107 >= r100) goto L44;
        if (Float.isNaN(r108) == true) goto L44;
        r103 = r107;
    L44:
        r103 = r107;
    L45:
        PathNodeKt.addPathNodes(r104, r111, this.nodeData, r102);
    L46:
        r101 = r103;
        goto L13
    L17:
        if (r105 == 101) goto L19;
    L48:
        return r111;
    }

    public static /* synthetic */ Path toPath$default(PathParser r100, Path r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = AndroidPath_androidKt.Path();
    L6:
        return r100.toPath(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList pathStringToNodes$default(PathParser r100, String r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new ArrayList();
    L6:
        return r100.pathStringToNodes(r101, r102);
    }
}
