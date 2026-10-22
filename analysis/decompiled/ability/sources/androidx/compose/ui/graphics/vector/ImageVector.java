package androidx.compose.ui.graphics.vector;

import C7.c;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0007\u0018\u0000 02\u00020\u0001:\u000210B[\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\u0013\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b/\u0010\u001a¨\u00062"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/ui/unit/Dp;", "defaultWidth", "defaultHeight", "", "viewportWidth", "viewportHeight", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "root", "Landroidx/compose/ui/graphics/Color;", "tintColor", "Landroidx/compose/ui/graphics/BlendMode;", "tintBlendMode", "", "autoMirror", "", "genId", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZILkotlin/jvm/internal/e;)V", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "F", "getDefaultWidth-D9Ej5fM", "()F", "getDefaultHeight-D9Ej5fM", "getViewportWidth", "getViewportHeight", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "J", "getTintColor-0d7_KjU", "()J", "I", "getTintBlendMode-0nO6VwU", "Z", "getAutoMirror", "()Z", "getGenId$ui_release", "Companion", "Builder", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageVector {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int imageVectorCount;
    private static final Object lock;
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final int genId;
    private final String name;
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001NBO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011BG\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0000¢\u0006\u0004\b&\u0010'J¡\u0001\u0010;\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0!2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\u00072\b\b\u0002\u00108\u001a\u00020\u0007¢\u0006\u0004\b9\u0010:J\r\u0010=\u001a\u00020<¢\u0006\u0004\b=\u0010>R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010@R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010@R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010@R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010AR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010BR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010CR$\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00160Dj\b\u0012\u0004\u0012\u00020\u0016`E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010CR\u0014\u0010M\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/ui/unit/Dp;", "defaultWidth", "defaultHeight", "", "viewportWidth", "viewportHeight", "Landroidx/compose/ui/graphics/Color;", "tintColor", "Landroidx/compose/ui/graphics/BlendMode;", "tintBlendMode", "", "autoMirror", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/e;)V", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/e;)V", "LC7/r;", "ensureNotConsumed", "()V", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "asVectorGroup", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;)Landroidx/compose/ui/graphics/vector/VectorGroup;", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "addGroup", "(Ljava/lang/String;FFFFFFFLjava/util/List;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "clearGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "pathData", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "Landroidx/compose/ui/graphics/Brush;", "fill", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "addPath", "Landroidx/compose/ui/graphics/vector/ImageVector;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Ljava/lang/String;", "F", "J", "I", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "nodes", "Ljava/util/ArrayList;", "root", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "isConsumed", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "currentGroup", "GroupParams", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList<GroupParams> nodes;
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0002\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", HintConstants.AUTOFILL_HINT_NAME, "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRotate", "()F", "setRotate", "(F)V", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "getChildren", "setChildren", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class GroupParams {
            private List<VectorNode> children;
            private List<? extends PathNode> clipPathData;
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
            }

            public final List<VectorNode> getChildren() {
                return this.children;
            }

            public final List<PathNode> getClipPathData() {
                return this.clipPathData;
            }

            public final String getName() {
                return this.name;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setChildren(List<VectorNode> list) {
                this.children = list;
            }

            public final void setClipPathData(List<? extends PathNode> list) {
                this.clipPathData = list;
            }

            public final void setName(String str) {
                this.name = str;
            }

            public final void setPivotX(float f) {
                this.pivotX = f;
            }

            public final void setPivotY(float f) {
                this.pivotY = f;
            }

            public final void setRotate(float f) {
                this.rotate = f;
            }

            public final void setScaleX(float f) {
                this.scaleX = f;
            }

            public final void setScaleY(float f) {
                this.scaleY = f;
            }

            public final void setTranslationX(float f) {
                this.translationX = f;
            }

            public final void setTranslationY(float f) {
                this.translationY = f;
            }

            public GroupParams(String str, float f, float f7, float f9, float f10, float f11, float f12, float f13, List<? extends PathNode> list, List<VectorNode> list2) {
                this.name = str;
                this.rotate = f;
                this.pivotX = f7;
                this.pivotY = f9;
                this.scaleX = f10;
                this.scaleY = f11;
                this.translationX = f12;
                this.translationY = f13;
                this.clipPathData = list;
                this.children = list2;
            }

            public /* synthetic */ GroupParams(String str, float f, float f7, float f9, float f10, float f11, float f12, float f13, List list, List list2, int i, e eVar) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f7, (i & 8) != 0 ? 0.0f : f9, (i & 16) != 0 ? 1.0f : f10, (i & 32) != 0 ? 1.0f : f11, (i & 64) != 0 ? 0.0f : f12, (i & 128) != 0 ? 0.0f : f13, (i & 256) != 0 ? VectorKt.getEmptyPath() : list, (i & 512) != 0 ? new ArrayList() : list2);
            }
        }

        @c
        public /* synthetic */ Builder(String str, float f, float f7, float f9, float f10, long j5, int i, e eVar) {
            this(str, f, f7, f9, f10, j5, i);
        }

        public static /* synthetic */ Builder addGroup$default(Builder builder, String str, float f, float f7, float f9, float f10, float f11, float f12, float f13, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            if ((i & 4) != 0) {
                f7 = 0.0f;
            }
            if ((i & 8) != 0) {
                f9 = 0.0f;
            }
            if ((i & 16) != 0) {
                f10 = 1.0f;
            }
            if ((i & 32) != 0) {
                f11 = 1.0f;
            }
            if ((i & 64) != 0) {
                f12 = 0.0f;
            }
            if ((i & 128) != 0) {
                f13 = 0.0f;
            }
            if ((i & 256) != 0) {
                list = VectorKt.getEmptyPath();
            }
            float f14 = f13;
            List list2 = list;
            float f15 = f12;
            float f16 = f10;
            return builder.addGroup(str, f, f7, f9, f16, f11, f15, f14, list2);
        }

        /* renamed from: addPath-oIyEayM$default, reason: not valid java name */
        public static /* synthetic */ Builder m4864addPathoIyEayM$default(Builder builder, List list, int i, String str, Brush brush, float f, Brush brush2, float f7, float f9, int i6, int i10, float f10, float f11, float f12, float f13, int i11, Object obj) {
            return builder.m4865addPathoIyEayM(list, (i11 & 2) != 0 ? VectorKt.getDefaultFillType() : i, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? null : brush, (i11 & 16) != 0 ? 1.0f : f, (i11 & 32) == 0 ? brush2 : null, (i11 & 64) != 0 ? 1.0f : f7, (i11 & 128) != 0 ? 0.0f : f9, (i11 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i6, (i11 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i10, (i11 & 1024) != 0 ? 4.0f : f10, (i11 & 2048) != 0 ? 0.0f : f11, (i11 & 4096) == 0 ? f12 : 1.0f, (i11 & 8192) != 0 ? 0.0f : f13);
        }

        private final VectorGroup asVectorGroup(GroupParams groupParams) {
            return new VectorGroup(groupParams.getName(), groupParams.getRotate(), groupParams.getPivotX(), groupParams.getPivotY(), groupParams.getScaleX(), groupParams.getScaleY(), groupParams.getTranslationX(), groupParams.getTranslationY(), groupParams.getClipPathData(), groupParams.getChildren());
        }

        private final void ensureNotConsumed() {
            if (this.isConsumed) {
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) ImageVectorKt.peek(this.nodes);
        }

        public final Builder addGroup(String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData) {
            ensureNotConsumed();
            ImageVectorKt.push(this.nodes, new GroupParams(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData, null, 512, null));
            return this;
        }

        /* renamed from: addPath-oIyEayM, reason: not valid java name */
        public final Builder m4865addPathoIyEayM(List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(new VectorPath(name, pathData, pathFillType, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, trimPathStart, trimPathEnd, trimPathOffset, null));
            return this;
        }

        public final ImageVector build() {
            ensureNotConsumed();
            while (this.nodes.size() > 1) {
                clearGroup();
            }
            ImageVector imageVector = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, 0, 512, null);
            this.isConsumed = true;
            return imageVector;
        }

        public final Builder clearGroup() {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(asVectorGroup((GroupParams) ImageVectorKt.pop(this.nodes)));
            return this;
        }

        public /* synthetic */ Builder(String str, float f, float f7, float f9, float f10, long j5, int i, boolean z10, e eVar) {
            this(str, f, f7, f9, f10, j5, i, z10);
        }

        private Builder(String str, float f, float f7, float f9, float f10, long j5, int i, boolean z10) {
            this.name = str;
            this.defaultWidth = f;
            this.defaultHeight = f7;
            this.viewportWidth = f9;
            this.viewportHeight = f10;
            this.tintColor = j5;
            this.tintBlendMode = i;
            this.autoMirror = z10;
            ArrayList<GroupParams> arrayList = new ArrayList<>();
            this.nodes = arrayList;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
            this.root = groupParams;
            ImageVectorKt.push(arrayList, groupParams);
        }

        public /* synthetic */ Builder(String str, float f, float f7, float f9, float f10, long j5, int i, boolean z10, int i6, e eVar) {
            this((i6 & 1) != 0 ? "" : str, f, f7, f9, f10, (i6 & 32) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5, (i6 & 64) != 0 ? BlendMode.INSTANCE.m4078getSrcIn0nO6VwU() : i, (i6 & 128) != 0 ? false : z10, (e) null);
        }

        public /* synthetic */ Builder(String str, float f, float f7, float f9, float f10, long j5, int i, int i6, e eVar) {
            this((i6 & 1) != 0 ? "" : str, f, f7, f9, f10, (i6 & 32) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5, (i6 & 64) != 0 ? BlendMode.INSTANCE.m4078getSrcIn0nO6VwU() : i, (e) null);
        }

        private Builder(String str, float f, float f7, float f9, float f10, long j5, int i) {
            this(str, f, f7, f9, f10, j5, i, false, (e) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00060\u0001j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", AppAgent.CONSTRUCT, "()V", "imageVectorCount", "", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "generateImageVectorId", "generateImageVectorId$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final int generateImageVectorId$ui_release() {
            int i;
            synchronized (ImageVector.lock) {
                i = ImageVector.imageVectorCount;
                ImageVector.imageVectorCount = i + 1;
            }
            return i;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        lock = companion;
    }

    public /* synthetic */ ImageVector(String str, float f, float f7, float f9, float f10, VectorGroup vectorGroup, long j5, int i, boolean z10, int i6, e eVar) {
        this(str, f, f7, f9, f10, vectorGroup, j5, i, z10, i6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) other;
        return k.b(this.name, imageVector.name) && Dp.m6849equalsimpl0(this.defaultWidth, imageVector.defaultWidth) && Dp.m6849equalsimpl0(this.defaultHeight, imageVector.defaultHeight) && this.viewportWidth == imageVector.viewportWidth && this.viewportHeight == imageVector.viewportHeight && k.b(this.root, imageVector.root) && Color.m4140equalsimpl0(this.tintColor, imageVector.tintColor) && BlendMode.m4049equalsimpl0(this.tintBlendMode, imageVector.tintBlendMode) && this.autoMirror == imageVector.autoMirror;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* renamed from: getDefaultHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultHeight() {
        return this.defaultHeight;
    }

    /* renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultWidth() {
        return this.defaultWidth;
    }

    /* renamed from: getGenId$ui_release, reason: from getter */
    public final int getGenId() {
        return this.genId;
    }

    public final String getName() {
        return this.name;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    /* renamed from: getTintBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getTintBlendMode() {
        return this.tintBlendMode;
    }

    /* renamed from: getTintColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintColor() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return Boolean.hashCode(this.autoMirror) + ((BlendMode.m4050hashCodeimpl(this.tintBlendMode) + b.c((this.root.hashCode() + a.b(this.viewportHeight, a.b(this.viewportWidth, b.b(this.defaultHeight, b.b(this.defaultWidth, this.name.hashCode() * 31, 31), 31), 31), 31)) * 31, 31, this.tintColor)) * 31);
    }

    private ImageVector(String str, float f, float f7, float f9, float f10, VectorGroup vectorGroup, long j5, int i, boolean z10, int i6) {
        this.name = str;
        this.defaultWidth = f;
        this.defaultHeight = f7;
        this.viewportWidth = f9;
        this.viewportHeight = f10;
        this.root = vectorGroup;
        this.tintColor = j5;
        this.tintBlendMode = i;
        this.autoMirror = z10;
        this.genId = i6;
    }

    public /* synthetic */ ImageVector(String str, float f, float f7, float f9, float f10, VectorGroup vectorGroup, long j5, int i, boolean z10, int i6, int i10, e eVar) {
        this(str, f, f7, f9, f10, vectorGroup, j5, i, z10, (i10 & 512) != 0 ? INSTANCE.generateImageVectorId$ui_release() : i6, null);
    }
}
