package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u00100\u001a\u00020\u0013H\u0002J\b\u0010T\u001a\u00020\u0013H\u0002J\u0016\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020P2\u0006\u0010W\u001a\u00020\u0001J\u001e\u0010X\u001a\u00020\u00132\u0006\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020P2\u0006\u0010[\u001a\u00020PJ\u0016\u0010\\\u001a\u00020\u00132\u0006\u0010V\u001a\u00020P2\u0006\u0010[\u001a\u00020PJ\f\u0010]\u001a\u00020\u0013*\u00020^H\u0016J\b\u0010_\u001a\u000201H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0013\u0018\u00010*X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130*X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00102\u001a\u0002012\u0006\u0010\t\u001a\u000201@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R$\u0010@\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R$\u0010C\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R$\u0010F\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R$\u0010I\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010:\"\u0004\bK\u0010<R$\u0010L\u001a\u0002072\u0006\u0010\t\u001a\u000207@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\u0011\u0010O\u001a\u00020P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "<init>", "()V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "children", "", "value", "", "isTintable", "()Z", "Landroidx/compose/ui/graphics/Color;", "tintColor", "getTintColor-0d7_KjU", "()J", "J", "markTintForBrush", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "markTintForColor", "color", "markTintForColor-8_81llA", "(J)V", "markTintForVNode", "node", "markNotTintable", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "willClipPath", "getWillClipPath", "isClipPathDirty", SVGRenderEngine.CLIP_PATH, "Landroidx/compose/ui/graphics/Path;", "invalidateListener", "Lkotlin/Function1;", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "wrappedListener", "updateClipPath", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "rotation", "getRotation", "()F", "setRotation", "(F)V", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", LiveDegradeFpsAnimator.SCALE_X, "getScaleX", "setScaleX", LiveDegradeFpsAnimator.SCALE_Y, "getScaleY", "setScaleY", LiveDegradeFpsAnimator.TRANSLATION_X, "getTranslationX", "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "setTranslationY", "numChildren", "", "getNumChildren", "()I", "isMatrixDirty", "updateMatrix", "insertAt", "index", "instance", "move", "from", RemoteMessageConst.TO, "count", "remove", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toString", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroupComponent extends VNode {
    public static final int $stable = 8;
    private final List<VNode> children;
    private Path clipPath;
    private List<? extends PathNode> clipPathData;
    private float[] groupMatrix;
    private Function1<? super VNode, Unit> invalidateListener;
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
    private final Function1<VNode, Unit> wrappedListener;

    public GroupComponent() {
        super(null);
        this.children = new ArrayList();
        this.isTintable = true;
        this.tintColor = Color.Companion.m4863getUnspecified0d7_KjU();
        this.clipPathData = VectorKt.getEmptyPath();
        this.isClipPathDirty = true;
        this.wrappedListener = new GroupComponent$wrappedListener$1(this);
        this.name = "";
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    private final void markNotTintable() {
        this.isTintable = false;
        this.tintColor = Color.Companion.m4863getUnspecified0d7_KjU();
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    private final void updateMatrix() {
        float[] r100 = this.groupMatrix;
        if (r100 != null) goto L5;
        r100 = Matrix.m5077constructorimpl$default(null, 1, null);
        this.groupMatrix = r100;
    L6:
        float r101 = this.translationX;
        float r102 = this.pivotX + r101;
        float r103 = this.translationY;
        float r104 = this.pivotY + r103;
        Matrix.m5099translateimpl$default(r100, r102, r104, 0.0f, 4, null);
        Matrix.m5091rotateZimpl(r100, this.rotation);
        Matrix.m5092scaleimpl(r100, this.scaleX, this.scaleY, 1.0f);
        float r105 = -this.pivotX;
        float r106 = -this.pivotY;
        Matrix.m5099translateimpl$default(r100, r105, r106, 0.0f, 4, null);
        return;
    L5:
        Matrix.m5086resetimpl(r100);
        goto L6
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("VGroup: ");
        r100.append(this.name);
        List<VNode> r101 = this.children;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        VNode r104 = (VNode) ListProtector.get(r101, r103);
        r100.append("\t");
        r100.append(r104.toString());
        r100.append("\n");
        r103 = r103 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    private final void updateClipPath() {
        if (getWillClipPath() == false) goto L9;
        Path r100 = this.clipPath;
        if (r100 != null) goto L7;
        r100 = AndroidPath_androidKt.Path();
        this.clipPath = r100;
    L7:
        PathParserKt.toPath(this.clipPathData, r100);
        return;
    }

    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public Function1<VNode, Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
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

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    /* JADX INFO: renamed from: getTintColor-0d7_KjU, reason: not valid java name */
    public final long m5562getTintColor0d7_KjU() {
        return this.tintColor;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final boolean isTintable() {
        return this.isTintable;
    }

    private final void markTintForBrush(Brush r100) {
        if (this.isTintable == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if ((r100 instanceof SolidColor) == false) goto L9;
        m5561markTintForColor8_81llA(((SolidColor) r100).m5188getValue0d7_KjU());
        return;
    L9:
        markNotTintable();
    }

    /* JADX INFO: renamed from: markTintForColor-8_81llA, reason: not valid java name */
    private final void m5561markTintForColor8_81llA(long r100) {
        if (this.isTintable == true) goto L5;
        return;
    L5:
        boolean r101 = true;
        if (r100 == 16) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        long r103 = this.tintColor;
        if (r103 == 16) goto L14;
        r101 = false;
    L14:
        if (r101 == false) goto L17;
        this.tintColor = r100;
        return;
    L17:
        if (VectorKt.m5584rgbEqualOWjLjI(r103, r100) == true) goto L22;
        markNotTintable();
        return;
    L22:
        return;
    L20:
        return;
    L8:
        r102 = false;
        goto L9
    }

    private final void markTintForVNode(VNode r100) {
        if ((r100 instanceof PathComponent) == false) goto L6;
        PathComponent r101 = (PathComponent) r100;
        markTintForBrush(r101.getFill());
        markTintForBrush(r101.getStroke());
        return;
    L6:
        if ((r100 instanceof GroupComponent) == false) goto L15;
        GroupComponent r102 = (GroupComponent) r100;
        if (r102.isTintable == true) goto L10;
    L12:
        markNotTintable();
        return;
    L10:
        if (this.isTintable == false) goto L12;
        m5561markTintForColor8_81llA(r102.tintColor);
        return;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope r100) {
        int r101 = 0;
        if (this.isMatrixDirty == false) goto L6;
        updateMatrix();
        this.isMatrixDirty = false;
    L6:
        if (this.isClipPathDirty == false) goto L8;
        updateClipPath();
        this.isClipPathDirty = false;
    L8:
        DrawContext r102 = r100.getDrawContext();
        long r103 = r102.mo5329getSizeNHjbRc();
        r102.getCanvas().save();
        DrawTransform r104 = r102.getTransform();     // Catch: Throwable -> L22
        float[] r105 = this.groupMatrix;     // Catch: Throwable -> L22
        if (r105 == null) goto L12;
        r104.mo5337transform58bKbWc(Matrix.m5075boximpl(r105).m5100unboximpl());     // Catch: Throwable -> L22
    L12:
        Path r106 = this.clipPath;     // Catch: Throwable -> L22
        if (getWillClipPath() == false) goto L16;
        if (r106 == null) goto L16;
        DrawTransform.CC.m5466clipPathmtrdDE$default(r104, r106, 0, 2, null);     // Catch: Throwable -> L22
    L16:
        List<VNode> r107 = this.children;     // Catch: Throwable -> L22
        int r108 = r107.size();     // Catch: Throwable -> L22
    L17:
        if (r101 >= r108) goto L20;
        r107.get(r101).draw(r100);     // Catch: Throwable -> L22
        r101 = r101 + 1;
        goto L17
    L20:
        r102.getCanvas().restore();
        r102.mo5330setSizeuvyYCjk(r103);
        return;
    L22:
        th = move-exception;
        r102.getCanvas().restore();
        r102.mo5330setSizeuvyYCjk(r103);
        throw th;
    }

    public final void setClipPathData(List<? extends PathNode> r100) {
        this.clipPathData = r100;
        this.isClipPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void setInvalidateListener$ui_release(Function1<? super VNode, Unit> r100) {
        this.invalidateListener = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
        invalidate();
    }

    public final void setPivotX(float r100) {
        this.pivotX = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setPivotY(float r100) {
        this.pivotY = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setRotation(float r100) {
        this.rotation = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleX(float r100) {
        this.scaleX = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleY(float r100) {
        this.scaleY = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationX(float r100) {
        this.translationX = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationY(float r100) {
        this.translationY = r100;
        this.isMatrixDirty = true;
        invalidate();
    }

    public static final /* synthetic */ void access$markTintForVNode(GroupComponent r100, VNode r101) {
        r100.markTintForVNode(r101);
    }

    public final void insertAt(int r100, VNode r101) {
        if (r100 >= getNumChildren()) goto L5;
        ListProtector.set(this.children, r100, r101);
    L6:
        markTintForVNode(r101);
        r101.setInvalidateListener$ui_release(this.wrappedListener);
        invalidate();
        return;
    L5:
        this.children.add(r101);
        goto L6
    }

    public final void remove(int r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100 >= this.children.size()) goto L7;
        ((VNode) ListProtector.get(this.children, r100)).setInvalidateListener$ui_release(null);
        ListProtector.remove(this.children, r100);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        invalidate();
    }

    public final void move(int r100, int r101, int r102) {
        int r103 = 0;
        if (r100 <= r101) goto L6;
    L4:
        if (r103 >= r102) goto L8;
        VNode r104 = (VNode) ListProtector.get(this.children, r100);
        ListProtector.remove(this.children, r100);
        ListProtector.add(this.children, r101, r104);
        r101 = r101 + 1;
        r103 = r103 + 1;
    L8:
        invalidate();
        return;
    L6:
        if (r103 >= r102) goto L8;
        VNode r105 = (VNode) ListProtector.get(this.children, r100);
        ListProtector.remove(this.children, r100);
        ListProtector.add(this.children, r101 - 1, r105);
        r103 = r103 + 1;
        goto L6
    }
}
