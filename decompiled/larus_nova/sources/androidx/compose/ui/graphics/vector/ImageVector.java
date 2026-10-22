package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B[\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", RootDescription.ROOT_ELEMENT, "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "genId", "", "<init>", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getDefaultWidth-D9Ej5fM", "()F", FaceService.girlLabel, "getDefaultHeight-D9Ej5fM", "getViewportWidth", "getViewportHeight", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintColor-0d7_KjU", "()J", "J", "getTintBlendMode-0nO6VwU", "()I", "I", "getAutoMirror", "()Z", "getGenId$ui_release", "equals", "other", "hashCode", "Builder", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageVector {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static int imageVectorCount;
    private static final Object lock = null;
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

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001EBO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011BG\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0012Jf\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\u0006\u0010*\u001a\u00020\u0000J¡\u0001\u0010+\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u00020\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\b2\b\b\u0002\u00104\u001a\u00020\b2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\b2\b\b\u0002\u0010;\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\b¢\u0006\u0004\b=\u0010>J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020BH\u0002J\f\u0010C\u001a\u00020D*\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006F"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "<init>", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "J", "I", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "Lkotlin/collections/ArrayList;", RootDescription.ROOT_ELEMENT, "isConsumed", "currentGroup", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "addGroup", "rotate", "pivotX", "pivotY", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clearGroup", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", LynxVideoManagerLite.FILL, "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0002\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", "name", "", "rotate", "", "pivotX", "pivotY", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "<init>", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRotate", "()F", "setRotate", "(F)V", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "getChildren", "setChildren", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
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

            public final void setChildren(List<VectorNode> r100) {
                this.children = r100;
            }

            public final void setClipPathData(List<? extends PathNode> r100) {
                this.clipPathData = r100;
            }

            public final void setName(String r100) {
                this.name = r100;
            }

            public final void setPivotX(float r100) {
                this.pivotX = r100;
            }

            public final void setPivotY(float r100) {
                this.pivotY = r100;
            }

            public final void setRotate(float r100) {
                this.rotate = r100;
            }

            public final void setScaleX(float r100) {
                this.scaleX = r100;
            }

            public final void setScaleY(float r100) {
                this.scaleY = r100;
            }

            public final void setTranslationX(float r100) {
                this.translationX = r100;
            }

            public final void setTranslationY(float r100) {
                this.translationY = r100;
            }

            public GroupParams(String r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, List<? extends PathNode> r108, List<VectorNode> r110) {
                this.name = r100;
                this.rotate = r101;
                this.pivotX = r102;
                this.pivotY = r103;
                this.scaleX = r104;
                this.scaleY = r105;
                this.translationX = r106;
                this.translationY = r107;
                this.clipPathData = r108;
                this.children = r110;
            }

            public /* synthetic */ GroupParams(String r110, float r111, float r112, float r113, float r114, float r115, float r116, float r117, List r118, List r210, int r211, DefaultConstructorMarker r212) {
                if ((r211 & 1) == 0) goto L5;
                String r100 = "";
            L6:
                float r101 = 0.0f;
                if ((r211 & 2) == 0) goto L9;
                float r102 = 0.0f;
            L11:
                if ((r211 & 4) == 0) goto L13;
                float r103 = 0.0f;
            L15:
                if ((r211 & 8) == 0) goto L17;
                float r104 = 0.0f;
            L18:
                float r105 = 1.0f;
                if ((r211 & 16) == 0) goto L21;
                float r106 = 1.0f;
            L23:
                if ((r211 & 32) != 0) goto L27;
                r105 = r115;
            L27:
                if ((r211 & 64) == 0) goto L29;
                float r107 = 0.0f;
            L31:
                if ((r211 & 128) != 0) goto L35;
                r101 = r117;
            L35:
                if ((r211 & 256) == 0) goto L37;
                List r108 = VectorKt.getEmptyPath();
            L39:
                if ((r211 & 512) == 0) goto L41;
                List r109 = new ArrayList();
            L42:
                this(r100, r102, r103, r104, r106, r105, r107, r101, r108, r109);
                return;
            L41:
                r109 = r210;
                goto L42
            L37:
                r108 = r118;
                goto L39
            L29:
                r107 = r116;
                goto L31
            L21:
                r106 = r114;
                goto L23
            L17:
                r104 = r113;
                goto L18
            L13:
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r100 = r110;
                goto L6
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith = @ReplaceWith(expression = "Builder(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, tintBlendMode, false)", imports = {"androidx.compose.ui.graphics.vector"}))
        public /* synthetic */ Builder(String r100, float r101, float r102, float r103, float r104, long r105, int r106, DefaultConstructorMarker r107) {
            this(r100, r101, r102, r103, r104, r105, r106);
        }

        public /* synthetic */ Builder(String r100, float r101, float r102, float r103, float r104, long r105, int r106, boolean r107, DefaultConstructorMarker r110) {
            this(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        private final void ensureNotConsumed() {
            if ((!this.isConsumed) == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            return;
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) ImageVectorKt.access$peek(this.nodes);
        }

        public final ImageVector build() {
            ensureNotConsumed();
        L4:
            if (this.nodes.size() <= 1) goto L6;
            clearGroup();
            goto L4
        L6:
            ImageVector r100 = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, 0, 512, null);
            this.isConsumed = true;
            return r100;
        }

        public final Builder clearGroup() {
            ensureNotConsumed();
            GroupParams r100 = (GroupParams) ImageVectorKt.access$pop(this.nodes);
            getCurrentGroup().getChildren().add(asVectorGroup(r100));
            return this;
        }

        private final VectorGroup asVectorGroup(GroupParams r110) {
            return new VectorGroup(r110.getName(), r110.getRotate(), r110.getPivotX(), r110.getPivotY(), r110.getScaleX(), r110.getScaleY(), r110.getTranslationX(), r110.getTranslationY(), r110.getClipPathData(), r110.getChildren());
        }

        private Builder(String r110, float r111, float r112, float r113, float r114, long r115, int r116) {
            this(r110, r111, r112, r113, r114, r115, r116, false, null);
        }

        private Builder(String r110, float r111, float r112, float r210, float r211, long r212, int r213, boolean r214) {
            this.name = r110;
            this.defaultWidth = r111;
            this.defaultHeight = r112;
            this.viewportWidth = r210;
            this.viewportHeight = r211;
            this.tintColor = r212;
            this.tintBlendMode = r213;
            this.autoMirror = r214;
            ArrayList<GroupParams> r100 = new ArrayList();
            this.nodes = r100;
            GroupParams r113 = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.root = r113;
            ImageVectorKt.access$push(r100, r113);
        }

        public /* synthetic */ Builder(String r110, float r111, float r112, float r113, float r114, long r115, int r116, int r210, DefaultConstructorMarker r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r210 & 32) == 0) goto L9;
            long r101 = Color.Companion.m4863getUnspecified0d7_KjU();
        L11:
            if ((r210 & 64) == 0) goto L13;
            int r102 = BlendMode.Companion.m4766getSrcIn0nO6VwU();
        L14:
            this(r100, r111, r112, r113, r114, r101, r102, null);
            return;
        L13:
            r102 = r116;
            goto L14
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }

        public final Builder addGroup(String r110, float r111, float r112, float r113, float r210, float r211, float r212, float r213, List<? extends PathNode> r214) {
            ensureNotConsumed();
            GroupParams r114 = new GroupParams(r110, r111, r112, r113, r210, r211, r212, r213, r214, null, 512, null);
            ImageVectorKt.access$push(this.nodes, r114);
            return this;
        }

        public /* synthetic */ Builder(String r110, float r111, float r112, float r113, float r114, long r115, int r210, boolean r211, int r212, DefaultConstructorMarker r213) {
            if ((r212 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r212 & 32) == 0) goto L9;
            long r101 = Color.Companion.m4863getUnspecified0d7_KjU();
        L11:
            if ((r212 & 64) == 0) goto L13;
            int r116 = BlendMode.Companion.m4766getSrcIn0nO6VwU();
        L15:
            if ((r212 & 128) == 0) goto L17;
            boolean r117 = false;
        L18:
            this(r100, r111, r112, r113, r114, r101, r116, r117, null);
            return;
        L17:
            r117 = r211;
            goto L18
        L13:
            r116 = r210;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addGroup$default(Builder r110, String r111, float r112, float r113, float r114, float r115, float r116, float r117, float r118, List r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = "";
        L6:
            float r101 = 0.0f;
            if ((r210 & 2) == 0) goto L9;
            float r102 = 0.0f;
        L11:
            if ((r210 & 4) == 0) goto L13;
            float r103 = 0.0f;
        L15:
            if ((r210 & 8) == 0) goto L17;
            float r104 = 0.0f;
        L18:
            float r105 = 1.0f;
            if ((r210 & 16) == 0) goto L21;
            float r106 = 1.0f;
        L23:
            if ((r210 & 32) != 0) goto L27;
            r105 = r116;
        L27:
            if ((r210 & 64) == 0) goto L29;
            float r107 = 0.0f;
        L31:
            if ((r210 & 128) != 0) goto L35;
            r101 = r118;
        L35:
            if ((r210 & 256) == 0) goto L37;
            List r108 = VectorKt.getEmptyPath();
        L39:
            return r110.addGroup(r100, r102, r103, r104, r106, r105, r107, r101, r108);
        L37:
            r108 = r119;
            goto L39
        L29:
            r107 = r117;
            goto L31
        L21:
            r106 = r115;
            goto L23
        L17:
            r104 = r114;
            goto L18
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L6
        }

        /* JADX INFO: renamed from: addPath-oIyEayM, reason: not valid java name */
        public final Builder m5568addPathoIyEayM(List<? extends PathNode> r110, int r210, String r211, Brush r212, float r213, Brush r214, float r215, float r216, int r217, int r218, float r219, float r310, float r311, float r312) {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(new VectorPath(r211, r110, r210, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, null));
            return this;
        }

        /* JADX INFO: renamed from: addPath-oIyEayM$default, reason: not valid java name */
        public static /* synthetic */ Builder m5567addPathoIyEayM$default(Builder r110, List r111, int r112, String r113, Brush r114, float r210, Brush r211, float r212, float r213, int r214, int r215, float r216, float r217, float r218, float r219, int r310, Object r311) {
            if ((r310 & 2) == 0) goto L5;
            int r100 = VectorKt.getDefaultFillType();
        L7:
            if ((r310 & 4) == 0) goto L9;
            String r101 = "";
        L10:
            Brush r102 = null;
            if ((r310 & 8) == 0) goto L13;
            Brush r103 = null;
        L14:
            float r104 = 1.0f;
            if ((r310 & 16) == 0) goto L17;
            float r105 = 1.0f;
        L19:
            if ((r310 & 32) != 0) goto L23;
            r102 = r211;
        L23:
            if ((r310 & 64) == 0) goto L25;
            float r106 = 1.0f;
        L26:
            float r107 = 0.0f;
            if ((r310 & 128) == 0) goto L29;
            float r108 = 0.0f;
        L31:
            if ((r310 & 256) == 0) goto L33;
            int r115 = VectorKt.getDefaultStrokeLineCap();
        L35:
            if ((r310 & 512) == 0) goto L37;
            int r116 = VectorKt.getDefaultStrokeLineJoin();
        L39:
            if ((r310 & 1024) == 0) goto L41;
            float r117 = 4.0f;
        L43:
            if ((r310 & 2048) == 0) goto L45;
            float r118 = 0.0f;
        L47:
            if ((r310 & 4096) != 0) goto L51;
            r104 = r218;
        L51:
            if ((r310 & 8192) != 0) goto L55;
            r107 = r219;
        L55:
            return r110.m5568addPathoIyEayM(r111, r100, r101, r103, r105, r102, r106, r108, r115, r116, r117, r118, r104, r107);
        L45:
            r118 = r217;
            goto L47
        L41:
            r117 = r216;
            goto L43
        L37:
            r116 = r215;
            goto L39
        L33:
            r115 = r214;
            goto L35
        L29:
            r108 = r213;
            goto L31
        L25:
            r106 = r212;
            goto L26
        L17:
            r105 = r210;
            goto L19
        L13:
            r103 = r114;
            goto L14
        L9:
            r101 = r113;
            goto L10
        L5:
            r100 = r112;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00060\u0001j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", "<init>", "()V", "imageVectorCount", "", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "generateImageVectorId", "generateImageVectorId$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int generateImageVectorId$ui_release() {
            Object r100 = ImageVector.access$getLock$cp();
            monitor-enter(r100);
            int r101 = ImageVector.access$getImageVectorCount$cp();     // Catch: Throwable -> L7
            ImageVector.access$setImageVectorCount$cp(r101 + 1);     // Catch: Throwable -> L7
            monitor-exit(r100);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ ImageVector(String r100, float r101, float r102, float r103, float r104, VectorGroup r105, long r106, int r107, boolean r110, int r111, DefaultConstructorMarker r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
    }

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        lock = r100;
    }

    public int hashCode() {
        int r100 = ((((((((((((((this.name.hashCode() * 31) + Dp.m7550hashCodeimpl(this.defaultWidth)) * 31) + Dp.m7550hashCodeimpl(this.defaultHeight)) * 31) + Float.floatToIntBits(this.viewportWidth)) * 31) + Float.floatToIntBits(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m4834hashCodeimpl(this.tintColor)) * 31) + BlendMode.m4738hashCodeimpl(this.tintBlendMode)) * 31;
        if (this.autoMirror == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public static final /* synthetic */ int access$getImageVectorCount$cp() {
        return imageVectorCount;
    }

    public static final /* synthetic */ Object access$getLock$cp() {
        return lock;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* JADX INFO: renamed from: getDefaultHeight-D9Ej5fM, reason: not valid java name */
    public final float m5563getDefaultHeightD9Ej5fM() {
        return this.defaultHeight;
    }

    /* JADX INFO: renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name */
    public final float m5564getDefaultWidthD9Ej5fM() {
        return this.defaultWidth;
    }

    public final int getGenId$ui_release() {
        return this.genId;
    }

    public final String getName() {
        return this.name;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: getTintBlendMode-0nO6VwU, reason: not valid java name */
    public final int m5565getTintBlendMode0nO6VwU() {
        return this.tintBlendMode;
    }

    /* JADX INFO: renamed from: getTintColor-0d7_KjU, reason: not valid java name */
    public final long m5566getTintColor0d7_KjU() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public static final /* synthetic */ void access$setImageVectorCount$cp(int r100) {
        imageVectorCount = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageVector) == true) goto L8;
        return false;
    L8:
        ImageVector r101 = (ImageVector) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.defaultWidth, r101.defaultWidth) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.defaultHeight, r101.defaultHeight) == true) goto L18;
        return false;
    L18:
        if (this.viewportWidth != r101.viewportWidth) goto L20;
        boolean r102 = true;
    L21:
        if (r102 == true) goto L24;
        return false;
    L24:
        if (this.viewportHeight != r101.viewportHeight) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.root, r101.root) == true) goto L33;
        return false;
    L33:
        if (Color.m4828equalsimpl0(this.tintColor, r101.tintColor) == true) goto L36;
        return false;
    L36:
        if (BlendMode.m4737equalsimpl0(this.tintBlendMode, r101.tintBlendMode) == true) goto L39;
        return false;
    L39:
        if (this.autoMirror == r101.autoMirror) goto L41;
        return false;
    L41:
        return true;
    L26:
        r103 = false;
        goto L27
    L20:
        r102 = false;
        goto L21
    }

    private ImageVector(String r100, float r101, float r102, float r103, float r104, VectorGroup r105, long r106, int r107, boolean r110, int r111) {
        this.name = r100;
        this.defaultWidth = r101;
        this.defaultHeight = r102;
        this.viewportWidth = r103;
        this.viewportHeight = r104;
        this.root = r105;
        this.tintColor = r106;
        this.tintBlendMode = r107;
        this.autoMirror = r110;
        this.genId = r111;
    }

    public /* synthetic */ ImageVector(String r110, float r111, float r112, float r113, float r114, VectorGroup r210, long r211, int r212, boolean r213, int r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 512) == 0) goto L5;
        int r115 = Companion.generateImageVectorId$ui_release();
    L6:
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r115, null);
        return;
    L5:
        r115 = r214;
        goto L6
    }
}
