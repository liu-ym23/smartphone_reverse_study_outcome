package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0086\u0001\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086\b\u001a/\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010'*\u0012\u0012\u0004\u0012\u0002H'0(j\b\u0012\u0004\u0012\u0002H'`)2\u0006\u0010*\u001a\u0002H'H\u0002¢\u0006\u0002\u0010+\u001a'\u0010,\u001a\u0002H'\"\u0004\b\u0000\u0010'*\u0012\u0012\u0004\u0012\u0002H'0(j\b\u0012\u0004\u0012\u0002H'`)H\u0002¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u0002H'\"\u0004\b\u0000\u0010'*\u0012\u0012\u0004\u0012\u0002H'0(j\b\u0012\u0004\u0012\u0002H'`)H\u0002¢\u0006\u0002\u0010-¨\u0006/"}, d2 = {"path", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "name", "", LynxVideoManagerLite.FILL, "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "path-R_LF-3I", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;Ljava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "group", "rotate", "pivotX", "pivotY", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "block", "push", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "pop", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "peek", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageVectorKt {
    public static final /* synthetic */ Object access$peek(ArrayList r100) {
        return peek(r100);
    }

    public static final /* synthetic */ Object access$pop(ArrayList r100) {
        return pop(r100);
    }

    private static final <T> T peek(ArrayList<T> r100) {
        return (T) ListProtector.get(r100, r100.size() - 1);
    }

    private static final <T> T pop(ArrayList<T> r100) {
        return (T) ListProtector.remove(r100, r100.size() - 1);
    }

    public static final /* synthetic */ boolean access$push(ArrayList r100, Object r101) {
        return push(r100, r101);
    }

    private static final <T> boolean push(ArrayList<T> r100, T r101) {
        return r100.add(r101);
    }

    public static final ImageVector.Builder group(ImageVector.Builder r100, String r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108, List<? extends PathNode> r109, Function1<? super ImageVector.Builder, Unit> r110) {
        r100.addGroup(r101, r102, r103, r104, r105, r106, r107, r108, r109);
        r110.invoke(r100);
        r100.clearGroup();
        return r100;
    }

    /* JADX INFO: renamed from: path-R_LF-3I, reason: not valid java name */
    public static final ImageVector.Builder m5569pathR_LF3I(ImageVector.Builder r110, String r111, Brush r112, float r210, Brush r211, float r212, float r213, int r214, int r215, float r216, int r217, Function1<? super PathBuilder, Unit> r218) {
        PathBuilder r100 = new PathBuilder();
        r218.invoke(r100);
        return ImageVector.Builder.m5567addPathoIyEayM$default(r110, r100.getNodes(), r217, r111, r112, r210, r211, r212, r213, r214, r215, r216, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder r110, String r111, float r112, float r113, float r114, float r115, float r116, float r117, float r210, List r211, Function1 r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        float r101 = 0.0f;
    L11:
        if ((r213 & 4) == 0) goto L13;
        float r102 = 0.0f;
    L15:
        if ((r213 & 8) == 0) goto L17;
        float r103 = 0.0f;
    L18:
        float r104 = 1.0f;
        if ((r213 & 16) == 0) goto L21;
        float r105 = 1.0f;
    L23:
        if ((r213 & 32) != 0) goto L27;
        r104 = r116;
    L27:
        if ((r213 & 64) == 0) goto L29;
        float r106 = 0.0f;
    L31:
        if ((r213 & 128) == 0) goto L33;
        float r107 = 0.0f;
    L35:
        if ((r213 & 256) == 0) goto L37;
        List r118 = VectorKt.getEmptyPath();
    L38:
        r110.addGroup(r100, r101, r102, r103, r105, r104, r106, r107, r118);
        r212.invoke(r110);
        r110.clearGroup();
        return r110;
    L37:
        r118 = r211;
        goto L38
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L21:
        r105 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L18
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: path-R_LF-3I$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m5570pathR_LF3I$default(ImageVector.Builder r110, String r210, Brush r211, float r212, Brush r213, float r214, float r215, int r216, int r217, float r218, int r219, Function1 r310, int r311, Object r312) {
        if ((r311 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r311 & 2) == 0) goto L9;
        Brush r101 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        float r102 = 1.0f;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Brush r103 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        float r104 = 1.0f;
    L23:
        if ((r311 & 32) == 0) goto L25;
        float r111 = 0.0f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        int r112 = VectorKt.getDefaultStrokeLineCap();
    L31:
        if ((r311 & 128) == 0) goto L33;
        int r113 = VectorKt.getDefaultStrokeLineJoin();
    L35:
        if ((r311 & 256) == 0) goto L37;
        float r114 = 4.0f;
    L39:
        if ((r311 & 512) == 0) goto L41;
        int r105 = VectorKt.getDefaultFillType();
    L42:
        PathBuilder r106 = new PathBuilder();
        r310.invoke(r106);
        return ImageVector.Builder.m5567addPathoIyEayM$default(r110, r106.getNodes(), r105, r100, r101, r102, r103, r104, r111, r112, r113, r114, 0.0f, 0.0f, 0.0f, 14336, null);
    L41:
        r105 = r219;
        goto L42
    L37:
        r114 = r218;
        goto L39
    L33:
        r113 = r217;
        goto L35
    L29:
        r112 = r216;
        goto L31
    L25:
        r111 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
