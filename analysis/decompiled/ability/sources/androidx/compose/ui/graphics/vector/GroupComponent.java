package androidx.compose.ui.graphics.vector;

import C7.r;
import S7.k;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0007*\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0001H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\u0003R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R$\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R$\u00101\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R6\u00107\u001a\b\u0012\u0004\u0012\u000206052\f\u0010-\u001a\b\u0012\u0004\u0012\u000206058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010+\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010/R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R0\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010@8\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010BR*\u0010H\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010LR*\u0010N\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR*\u0010T\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR*\u0010W\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010O\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR*\u0010Z\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010Q\"\u0004\b\\\u0010SR*\u0010]\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010SR*\u0010`\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010O\u001a\u0004\ba\u0010Q\"\u0004\bb\u0010SR*\u0010c\u001a\u00020M2\u0006\u0010-\u001a\u00020M8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010O\u001a\u0004\bd\u0010Q\"\u0004\be\u0010SR\u0016\u0010f\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010/R\u0011\u0010i\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u00100¨\u0006l"}, d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", AppAgent.CONSTRUCT, "()V", "", "index", "instance", "LC7/r;", "insertAt", "(ILandroidx/compose/ui/graphics/vector/VNode;)V", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "count", "move", "(III)V", "remove", "(II)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/Brush;", "brush", "markTintForBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "markTintForColor-8_81llA", "(J)V", "markTintForColor", "node", "markTintForVNode", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "markNotTintable", "updateClipPath", "updateMatrix", "Landroidx/compose/ui/graphics/Matrix;", "groupMatrix", "[F", "", "children", "Ljava/util/List;", "", "value", "isTintable", "Z", "()Z", "tintColor", "J", "getTintColor-0d7_KjU", "()J", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "isClipPathDirty", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "Lkotlin/Function1;", "invalidateListener", "LS7/k;", "getInvalidateListener$ui_release", "()LS7/k;", "setInvalidateListener$ui_release", "(LS7/k;)V", "wrappedListener", HintConstants.AUTOFILL_HINT_NAME, "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "", Key.ROTATION, "F", "getRotation", "()F", "setRotation", "(F)V", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "isMatrixDirty", "getNumChildren", "()I", "numChildren", "getWillClipPath", "willClipPath", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GroupComponent extends VNode {
    public static final int $stable = 8;
    private final List<VNode> children;
    private Path clipPath;
    private List<? extends PathNode> clipPathData;
    private float[] groupMatrix;
    private k invalidateListener;
    private boolean isClipPathDirty;
    private boolean isMatrixDirty;
    private boolean isTintable;
    private String name;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private long tintColor;
    private float translationX;
    private float translationY;
    private final k wrappedListener;

    public GroupComponent() {
        super(null);
        this.children = new ArrayList();
        this.isTintable = true;
        this.tintColor = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        this.clipPathData = VectorKt.getEmptyPath();
        this.isClipPathDirty = true;
        this.wrappedListener = new k() { // from class: androidx.compose.ui.graphics.vector.GroupComponent$wrappedListener$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((VNode) obj);
                return r.f317a;
            }

            public final void invoke(VNode vNode) {
                this.this$0.markTintForVNode(vNode);
                k invalidateListener = this.this$0.getInvalidateListener();
                if (invalidateListener != null) {
                    invalidateListener.invoke(vNode);
                }
            }
        };
        this.name = "";
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    private final void markNotTintable() {
        this.isTintable = false;
        this.tintColor = Color.INSTANCE.m4175getUnspecified0d7_KjU();
    }

    private final void markTintForBrush(Brush brush) {
        if (this.isTintable && brush != null) {
            if (brush instanceof SolidColor) {
                m4858markTintForColor8_81llA(((SolidColor) brush).getValue());
            } else {
                markNotTintable();
            }
        }
    }

    /* renamed from: markTintForColor-8_81llA, reason: not valid java name */
    private final void m4858markTintForColor8_81llA(long color) {
        if (this.isTintable && color != 16) {
            long j5 = this.tintColor;
            if (j5 == 16) {
                this.tintColor = color;
            } else {
                if (VectorKt.m4882rgbEqualOWjLjI(j5, color)) {
                    return;
                }
                markNotTintable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markTintForVNode(VNode node) {
        if (node instanceof PathComponent) {
            PathComponent pathComponent = (PathComponent) node;
            markTintForBrush(pathComponent.getFill());
            markTintForBrush(pathComponent.getStroke());
        } else if (node instanceof GroupComponent) {
            GroupComponent groupComponent = (GroupComponent) node;
            if (groupComponent.isTintable && this.isTintable) {
                m4858markTintForColor8_81llA(groupComponent.tintColor);
            } else {
                markNotTintable();
            }
        }
    }

    private final void updateClipPath() {
        if (getWillClipPath()) {
            Path Path = this.clipPath;
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
                this.clipPath = Path;
            }
            PathParserKt.toPath(this.clipPathData, Path);
        }
    }

    private final void updateMatrix() {
        float[] fArrM4380constructorimpl$default = this.groupMatrix;
        if (fArrM4380constructorimpl$default == null) {
            fArrM4380constructorimpl$default = Matrix.m4380constructorimpl$default(null, 1, null);
            this.groupMatrix = fArrM4380constructorimpl$default;
        } else {
            Matrix.m4389resetimpl(fArrM4380constructorimpl$default);
        }
        float[] fArr = fArrM4380constructorimpl$default;
        Matrix.m4402translateimpl$default(fArr, this.pivotX + this.translationX, this.pivotY + this.translationY, 0.0f, 4, null);
        Matrix.m4394rotateZimpl(fArr, this.rotation);
        Matrix.m4395scaleimpl(fArr, this.scaleX, this.scaleY, 1.0f);
        Matrix.m4402translateimpl$default(fArr, -this.pivotX, -this.pivotY, 0.0f, 4, null);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        if (this.isMatrixDirty) {
            updateMatrix();
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            updateClipPath();
            this.isClipPathDirty = false;
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            float[] fArr = this.groupMatrix;
            if (fArr != null) {
                transform.mo4636transform58bKbWc(Matrix.m4378boximpl(fArr).m4403unboximpl());
            }
            Path path = this.clipPath;
            if (getWillClipPath() && path != null) {
                DrawTransform.m4763clipPathmtrdDE$default(transform, path, 0, 2, null);
            }
            List<VNode> list = this.children;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).draw(drawScope);
            }
            a.A(drawContext, jMo4628getSizeNHjbRc);
        } catch (Throwable th) {
            a.A(drawContext, jMo4628getSizeNHjbRc);
            throw th;
        }
    }

    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    /* renamed from: getInvalidateListener$ui_release, reason: from getter */
    public k getInvalidateListener() {
        return this.invalidateListener;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    /* renamed from: getTintColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintColor() {
        return this.tintColor;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void insertAt(int index, VNode instance) {
        if (index < getNumChildren()) {
            this.children.set(index, instance);
        } else {
            this.children.add(instance);
        }
        markTintForVNode(instance);
        instance.setInvalidateListener$ui_release(this.wrappedListener);
        invalidate();
    }

    /* renamed from: isTintable, reason: from getter */
    public final boolean getIsTintable() {
        return this.isTintable;
    }

    public final void move(int from, int to, int count) {
        int i = 0;
        if (from > to) {
            while (i < count) {
                VNode vNode = this.children.get(from);
                this.children.remove(from);
                this.children.add(to, vNode);
                to++;
                i++;
            }
        } else {
            while (i < count) {
                VNode vNode2 = this.children.get(from);
                this.children.remove(from);
                this.children.add(to - 1, vNode2);
                i++;
            }
        }
        invalidate();
    }

    public final void remove(int index, int count) {
        for (int i = 0; i < count; i++) {
            if (index < this.children.size()) {
                this.children.get(index).setInvalidateListener$ui_release(null);
                this.children.remove(index);
            }
        }
        invalidate();
    }

    public final void setClipPathData(List<? extends PathNode> list) {
        this.clipPathData = list;
        this.isClipPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void setInvalidateListener$ui_release(k kVar) {
        this.invalidateListener = kVar;
    }

    public final void setName(String str) {
        this.name = str;
        invalidate();
    }

    public final void setPivotX(float f) {
        this.pivotX = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setPivotY(float f) {
        this.pivotY = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setRotation(float f) {
        this.rotation = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationX(float f) {
        this.translationX = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationY(float f) {
        this.translationY = f;
        this.isMatrixDirty = true;
        invalidate();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.name);
        List<VNode> list = this.children;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            VNode vNode = list.get(i);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
