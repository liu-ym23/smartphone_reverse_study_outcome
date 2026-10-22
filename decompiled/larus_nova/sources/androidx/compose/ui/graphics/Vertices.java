package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001b\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/Vertices;", "", "vertexMode", "Landroidx/compose/ui/graphics/VertexMode;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "textureCoordinates", "colors", "Landroidx/compose/ui/graphics/Color;", "indices", "", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVertexMode-c2xauaI", "()I", "I", "", "getPositions", "()[F", "getTextureCoordinates", "", "getColors", "()[I", "", "getIndices", "()[S", "encodeColorList", "encodePointList", "points", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Vertices {
    private final int[] colors;
    private final short[] indices;
    private final float[] positions;
    private final float[] textureCoordinates;
    private final int vertexMode;

    public /* synthetic */ Vertices(int r100, List r101, List r102, List r103, List r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final short[] getIndices() {
        return this.indices;
    }

    public final float[] getPositions() {
        return this.positions;
    }

    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    /* JADX INFO: renamed from: getVertexMode-c2xauaI, reason: not valid java name */
    public final int m5256getVertexModec2xauaI() {
        return this.vertexMode;
    }

    private final int[] encodeColorList(List<Color> r100) {
        int r101 = r100.size();
        int[] r102 = new int[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ColorKt.m4881toArgb8_81llA(((Color) ListProtector.get(r100, r103)).m4837unboximpl());
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private final float[] encodePointList(List<Offset> r100) {
        int r101 = r100.size() * 2;
        float[] r102 = new float[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        long r104 = ((Offset) ListProtector.get(r100, r103 / 2)).m4592unboximpl();
        if ((r103 % 2) != 0) goto L7;
        float r105 = Float.intBitsToFloat((int) (r104 >> 32));
    L8:
        r102[r103] = r105;
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = Float.intBitsToFloat((int) (r104 & BodyPartID.bodyIdMax));
        goto L8
    L9:
        return r102;
    }

    private Vertices(int r100, List<Offset> r101, List<Offset> r102, List<Color> r103, List<Integer> r110) {
        this.vertexMode = r100;
        if (r102.size() == r101.size()) goto L6;
        InlineClassHelperKt.throwIllegalArgumentException("positions and textureCoordinates lengths must match.");
    L6:
        if (r103.size() == r101.size()) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("positions and colors lengths must match.");
    L8:
        int r104 = r110.size();
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r106 >= r104) goto L20;
        int r107 = ((Number) ListProtector.get(r110, r106)).intValue();
        boolean r108 = true;
        if (r107 >= 0) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L21;
        r106 = r106 + 1;
    L21:
        if (r108 == false) goto L23;
        InlineClassHelperKt.throwIllegalArgumentException("indices values must be valid indices in the positions list.");
    L23:
        this.positions = encodePointList(r101);
        this.textureCoordinates = encodePointList(r102);
        this.colors = encodeColorList(r103);
        int r111 = r110.size();
        short[] r112 = new short[r111];
    L24:
        if (r105 >= r111) goto L26;
        r112[r105] = (short) ((Number) ListProtector.get(r110, r105)).intValue();
        r105 = r105 + 1;
        goto L24
    L26:
        this.indices = r112;
        return;
    L13:
        if (r107 >= r101.size()) goto L16;
        r109 = false;
        goto L17
    L20:
        r108 = false;
        goto L21
    }
}
