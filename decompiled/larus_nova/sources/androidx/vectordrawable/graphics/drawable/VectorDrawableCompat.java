package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private boolean mAllowCaching;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VClipPath extends VPath {
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }

        public VClipPath() {
        }

        public VClipPath(VClipPath r100) {
            super(r100);
        }

        private void updateStateFromTypedArray(TypedArray r100, XmlPullParser r101) {
            String r102 = r100.getString(0);
            if (r102 == null) goto L5;
            this.mPathName = r102;
        L5:
            String r103 = r100.getString(1);
            if (r103 == null) goto L8;
            this.mNodes = PathParser.createNodesFromPathData(r103);
        L8:
            this.mFillRule = TypedArrayUtils.getNamedInt(r100, r101, "fillType", 2, 0);
        }

        public void inflate(Resources r100, AttributeSet r101, Resources.Theme r102, XmlPullParser r103) {
            if (TypedArrayUtils.hasAttribute(r103, "pathData") == true) goto L5;
            return;
        L5:
            TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r102, r101, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
            updateStateFromTypedArray(r104, r103);
            r104.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VFullPath extends VPath {
        float mFillAlpha;
        ComplexColorCompat mFillColor;
        float mStrokeAlpha;
        ComplexColorCompat mStrokeColor;
        Paint.Cap mStrokeLineCap;
        Paint.Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme r100) {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) goto L5;
            return true;
        L5:
            return false;
        }

        public int getFillColor() {
            return this.mFillColor.getColor();
        }

        public int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            if (this.mFillColor.isStateful() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mStrokeColor.isStateful() == true) goto L8;
            return false;
        }

        public VFullPath() {
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public VFullPath(VFullPath r100) {
            super(r100);
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = r100.mThemeAttrs;
            this.mStrokeColor = r100.mStrokeColor;
            this.mStrokeWidth = r100.mStrokeWidth;
            this.mStrokeAlpha = r100.mStrokeAlpha;
            this.mFillColor = r100.mFillColor;
            this.mFillRule = r100.mFillRule;
            this.mFillAlpha = r100.mFillAlpha;
            this.mTrimPathStart = r100.mTrimPathStart;
            this.mTrimPathEnd = r100.mTrimPathEnd;
            this.mTrimPathOffset = r100.mTrimPathOffset;
            this.mStrokeLineCap = r100.mStrokeLineCap;
            this.mStrokeLineJoin = r100.mStrokeLineJoin;
            this.mStrokeMiterlimit = r100.mStrokeMiterlimit;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] r100) {
            boolean r101 = this.mFillColor.onStateChanged(r100);
            return this.mStrokeColor.onStateChanged(r100) | r101;
        }

        public void setFillAlpha(float r100) {
            this.mFillAlpha = r100;
        }

        public void setFillColor(int r100) {
            this.mFillColor.setColor(r100);
        }

        public void setStrokeAlpha(float r100) {
            this.mStrokeAlpha = r100;
        }

        public void setStrokeColor(int r100) {
            this.mStrokeColor.setColor(r100);
        }

        public void setStrokeWidth(float r100) {
            this.mStrokeWidth = r100;
        }

        public void setTrimPathEnd(float r100) {
            this.mTrimPathEnd = r100;
        }

        public void setTrimPathOffset(float r100) {
            this.mTrimPathOffset = r100;
        }

        public void setTrimPathStart(float r100) {
            this.mTrimPathStart = r100;
        }

        private Paint.Cap getStrokeLineCap(int r100, Paint.Cap r101) {
            if (r100 == 0) goto L13;
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return r101;
        L9:
            return Paint.Cap.SQUARE;
        L11:
            return Paint.Cap.ROUND;
        L13:
            return Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int r100, Paint.Join r101) {
            if (r100 == 0) goto L13;
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return r101;
        L9:
            return Paint.Join.BEVEL;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(TypedArray r100, XmlPullParser r101, Resources.Theme r110) {
            this.mThemeAttrs = null;
            if (TypedArrayUtils.hasAttribute(r101, "pathData") == true) goto L5;
            return;
        L5:
            String r102 = r100.getString(0);
            if (r102 == null) goto L8;
            this.mPathName = r102;
        L8:
            String r103 = r100.getString(2);
            if (r103 == null) goto L11;
            this.mNodes = PathParser.createNodesFromPathData(r103);
        L11:
            this.mFillColor = TypedArrayUtils.getNamedComplexColor(r100, r101, r110, "fillColor", 1, 0);
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(r100, r101, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(r100, r101, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(r100, r101, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(r100, r101, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(r100, r101, r110, "strokeColor", 3, 0);
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(r100, r101, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(r100, r101, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(r100, r101, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(r100, r101, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(r100, r101, "trimPathStart", 5, this.mTrimPathStart);
            this.mFillRule = TypedArrayUtils.getNamedInt(r100, r101, "fillType", 13, this.mFillRule);
        }

        public void inflate(Resources r100, AttributeSet r101, Resources.Theme r102, XmlPullParser r103) {
            TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r102, r101, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(r104, r103, r102);
            r104.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VGroup extends VObject {
        int mChangingConfigurations;
        final ArrayList<VObject> mChildren;
        private String mGroupName;
        final Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        float mRotate;
        private float mScaleX;
        private float mScaleY;
        final Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup() {
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            int r100 = 0;
        L4:
            if (r100 >= this.mChildren.size()) goto L10;
            if (((VObject) ListProtector.get(this.mChildren, r100)).isStateful() == true) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] r100) {
            int r101 = 0;
            boolean r102 = false;
        L4:
            if (r101 >= this.mChildren.size()) goto L6;
            r102 = r102 | ((VObject) ListProtector.get(this.mChildren, r101)).onStateChanged(r100);
            r101 = r101 + 1;
            goto L4
        L6:
            return r102;
        }

        public void setPivotX(float r100) {
            if (r100 == this.mPivotX) goto L6;
            this.mPivotX = r100;
            updateLocalMatrix();
            return;
        }

        public void setPivotY(float r100) {
            if (r100 == this.mPivotY) goto L6;
            this.mPivotY = r100;
            updateLocalMatrix();
            return;
        }

        public void setRotation(float r100) {
            if (r100 == this.mRotate) goto L6;
            this.mRotate = r100;
            updateLocalMatrix();
            return;
        }

        public void setScaleX(float r100) {
            if (r100 == this.mScaleX) goto L6;
            this.mScaleX = r100;
            updateLocalMatrix();
            return;
        }

        public void setScaleY(float r100) {
            if (r100 == this.mScaleY) goto L6;
            this.mScaleY = r100;
            updateLocalMatrix();
            return;
        }

        public void setTranslateX(float r100) {
            if (r100 == this.mTranslateX) goto L6;
            this.mTranslateX = r100;
            updateLocalMatrix();
            return;
        }

        public void setTranslateY(float r100) {
            if (r100 == this.mTranslateY) goto L6;
            this.mTranslateY = r100;
            updateLocalMatrix();
            return;
        }

        public VGroup(VGroup r100, ArrayMap<String, Object> r101) {
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix r102 = new Matrix();
            this.mLocalMatrix = r102;
            this.mGroupName = null;
            this.mRotate = r100.mRotate;
            this.mPivotX = r100.mPivotX;
            this.mPivotY = r100.mPivotY;
            this.mScaleX = r100.mScaleX;
            this.mScaleY = r100.mScaleY;
            this.mTranslateX = r100.mTranslateX;
            this.mTranslateY = r100.mTranslateY;
            this.mThemeAttrs = r100.mThemeAttrs;
            String r103 = r100.mGroupName;
            this.mGroupName = r103;
            this.mChangingConfigurations = r100.mChangingConfigurations;
            if (r103 == null) goto L5;
            r101.put(r103, this);
        L5:
            r102.set(r100.mLocalMatrix);
            ArrayList<VObject> r104 = r100.mChildren;
            int r105 = 0;
        L7:
            if (r105 >= r104.size()) goto L23;
            Object r106 = ListProtector.get(r104, r105);
            if ((r106 instanceof VGroup) == false) goto L12;
            this.mChildren.add(new VGroup((VGroup) r106, r101));
        L20:
            r105 = r105 + 1;
            goto L7
        L12:
            if ((r106 instanceof VFullPath) == false) goto L15;
            VPath r107 = new VFullPath((VFullPath) r106);
        L17:
            this.mChildren.add(r107);
            String r108 = r107.mPathName;
            if (r108 == null) goto L20;
            r101.put(r108, r107);
            goto L20
        L15:
            if ((r106 instanceof VClipPath) == false) goto L22;
            r107 = new VClipPath((VClipPath) r106);
            goto L17
        L22:
            throw new IllegalStateException("Unknown object in the tree!");
        }

        private void updateStateFromTypedArray(TypedArray r100, XmlPullParser r101) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(r100, r101, "rotation", 5, this.mRotate);
            this.mPivotX = r100.getFloat(1, this.mPivotX);
            this.mPivotY = r100.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(r100, r101, LiveDegradeFpsAnimator.SCALE_X, 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(r100, r101, LiveDegradeFpsAnimator.SCALE_Y, 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(r100, r101, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(r100, r101, "translateY", 7, this.mTranslateY);
            String r102 = r100.getString(0);
            if (r102 == null) goto L5;
            this.mGroupName = r102;
        L5:
            updateLocalMatrix();
        }

        public void inflate(Resources r100, AttributeSet r101, Resources.Theme r102, XmlPullParser r103) {
            TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r102, r101, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(r104, r103);
            r104.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class VObject {
        private VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] r100) {
            return false;
        }

        public /* synthetic */ VObject(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class VPath extends VObject {
        protected static final int FILL_TYPE_WINDING = 0;
        int mChangingConfigurations;
        int mFillRule;
        protected PathParser.PathDataNode[] mNodes;
        String mPathName;

        public VPath() {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public void applyTheme(Resources.Theme r100) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public boolean isClipPath() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public VPath(VPath r100) {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = r100.mPathName;
            this.mChangingConfigurations = r100.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(r100.mNodes);
        }

        public String nodesToString(PathParser.PathDataNode[] r100) {
            StringBuilder r101 = new StringBuilder(" ");
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            PathParser.PathDataNode r104 = r100[r103];
            r101.append(r104.getType());
            r101.append(":");
            float[] r105 = r104.getParams();
            int r106 = r105.length;
            int r107 = 0;
        L5:
            if (r107 >= r106) goto L7;
            r101.append(r105[r107]);
            r101.append(",");
            r107 = r107 + 1;
            goto L5
        L7:
            r103 = r103 + 1;
            goto L3
        L9:
            return r101.toString();
        }

        public void printVPath(int r100) {
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            r101 = r101 + 1;
            goto L3
        L5:
            nodesToString(this.mNodes);
        }

        public void setPathData(PathParser.PathDataNode[] r100) {
            if (PathParser.canMorph(this.mNodes, r100) == true) goto L5;
            this.mNodes = PathParser.deepCopyNodes(r100);
            return;
        L5:
            PathParser.updateNodes(this.mNodes, r100);
        }

        public void toPath(Path r100) {
            r100.reset();
            PathParser.PathDataNode[] r101 = this.mNodes;
            if (r101 == null) goto L6;
            PathParser.nodesToPath(r101, r100);
            return;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = null;
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        Boolean mIsStateful;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        private static float cross(float r100, float r101, float r102, float r103) {
            return (r100 * r103) - (r101 * r102);
        }

        static {
            IDENTITY_MATRIX = new Matrix();
        }

        public boolean isStateful() {
            if (this.mIsStateful != null) goto L6;
            this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
        L6:
            return this.mIsStateful.booleanValue();
        }

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public VPathRenderer(VPathRenderer r100) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> r101 = new ArrayMap();
            this.mVGTargetsMap = r101;
            this.mRootGroup = new VGroup(r100.mRootGroup, r101);
            this.mPath = new Path(r100.mPath);
            this.mRenderPath = new Path(r100.mRenderPath);
            this.mBaseWidth = r100.mBaseWidth;
            this.mBaseHeight = r100.mBaseHeight;
            this.mViewportWidth = r100.mViewportWidth;
            this.mViewportHeight = r100.mViewportHeight;
            this.mChangingConfigurations = r100.mChangingConfigurations;
            this.mRootAlpha = r100.mRootAlpha;
            this.mRootName = r100.mRootName;
            String r102 = r100.mRootName;
            if (r102 == null) goto L5;
            r101.put(r102, this);
        L5:
            this.mIsStateful = r100.mIsStateful;
        }

        private float getMatrixScale(Matrix r110) {
            float[] r100 = {0.0f, 1.0f, 1.0f, 0.0f};
            r110.mapVectors(r100);
            float r101 = (float) Math.hypot(r100[0], r100[1]);
            float r102 = (float) Math.hypot(r100[2], r100[3]);
            float r111 = cross(r100[0], r100[1], r100[2], r100[3]);
            float r103 = Math.max(r101, r102);
            if (r103 > 0.0f) goto L5;
            return 0.0f;
        L5:
            return Math.abs(r111) / r103;
        }

        public boolean onStateChanged(int[] r100) {
            return this.mRootGroup.onStateChanged(r100);
        }

        public void setAlpha(float r100) {
            setRootAlpha((int) (r100 * 255.0f));
        }

        public void setRootAlpha(int r100) {
            this.mRootAlpha = r100;
        }

        public void draw(Canvas r100, int r101, int r110, ColorFilter r111) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, r100, r101, r110, r111);
        }

        private void drawGroupTree(VGroup r110, Matrix r111, Canvas r112, int r113, int r114, ColorFilter r115) {
            r110.mStackedMatrix.set(r111);
            r110.mStackedMatrix.preConcat(r110.mLocalMatrix);
            r112.save();
            int r116 = 0;
        L4:
            if (r116 >= r110.mChildren.size()) goto L12;
            VObject r100 = (VObject) ListProtector.get(r110.mChildren, r116);
            if ((r100 instanceof VGroup) == false) goto L9;
            drawGroupTree((VGroup) r100, r110.mStackedMatrix, r112, r113, r114, r115);
        L11:
            r116 = r116 + 1;
            goto L4
        L9:
            if ((r100 instanceof VPath) == false) goto L11;
            drawPath(r110, (VPath) r100, r112, r113, r114, r115);
            goto L11
        L12:
            r112.restore();
        }

        private void drawPath(VGroup r100, VPath r101, Canvas r110, int r111, int r112, ColorFilter r113) {
            float r114 = r111 / this.mViewportWidth;
            float r115 = r112 / this.mViewportHeight;
            float r102 = Math.min(r114, r115);
            Matrix r103 = r100.mStackedMatrix;
            this.mFinalPathMatrix.set(r103);
            this.mFinalPathMatrix.postScale(r114, r115);
            float r104 = getMatrixScale(r103);
            if (r104 != 0.0f) goto L5;
            return;
        L5:
            r101.toPath(this.mPath);
            Path r116 = this.mPath;
            this.mRenderPath.reset();
            if (r101.isClipPath() == false) goto L12;
            Path r105 = this.mRenderPath;
            if (r101.mFillRule != 0) goto L10;
            Path.FillType r106 = Path.FillType.WINDING;
        L11:
            r105.setFillType(r106);
            this.mRenderPath.addPath(r116, this.mFinalPathMatrix);
            r110.clipPath(this.mRenderPath);
            return;
        L10:
            r106 = Path.FillType.EVEN_ODD;
            goto L11
        L12:
            VFullPath r107 = (VFullPath) r101;
            float r108 = r107.mTrimPathStart;
            if (r108 == 0.0f) goto L15;
        L16:
            float r109 = r107.mTrimPathOffset;
            float r117 = (r108 + r109) % 1.0f;
            float r118 = (r107.mTrimPathEnd + r109) % 1.0f;
            if (this.mPathMeasure != null) goto L19;
            this.mPathMeasure = new PathMeasure();
        L19:
            this.mPathMeasure.setPath(this.mPath, false);
            float r119 = this.mPathMeasure.getLength();
            float r120 = r117 * r119;
            float r121 = r118 * r119;
            r116.reset();
            if (r120 <= r121) goto L22;
            this.mPathMeasure.getSegment(r120, r119, r116, true);
            this.mPathMeasure.getSegment(0.0f, r121, r116, true);
        L23:
            r116.rLineTo(0.0f, 0.0f);
        L24:
            this.mRenderPath.addPath(r116, this.mFinalPathMatrix);
            if (r107.mFillColor.willDraw() == false) goto L39;
            ComplexColorCompat r122 = r107.mFillColor;
            if (this.mFillPaint != null) goto L29;
            Paint r123 = new Paint(1);
            this.mFillPaint = r123;
            r123.setStyle(Paint.Style.FILL);
        L29:
            Paint r124 = this.mFillPaint;
            if (r122.isGradient() == false) goto L32;
            Shader r125 = r122.getShader();
            r125.setLocalMatrix(this.mFinalPathMatrix);
            r124.setShader(r125);
            r124.setAlpha(Math.round(r107.mFillAlpha * 255.0f));
        L33:
            r124.setColorFilter(r113);
            Path r126 = this.mRenderPath;
            if (r107.mFillRule != 0) goto L36;
            Path.FillType r127 = Path.FillType.WINDING;
        L37:
            r126.setFillType(r127);
            r110.drawPath(this.mRenderPath, r124);
            goto L39
        L36:
            r127 = Path.FillType.EVEN_ODD;
            goto L37
        L32:
            r124.setShader(null);
            r124.setAlpha(255);
            r124.setColor(VectorDrawableCompat.applyAlpha(r122.getColor(), r107.mFillAlpha));
        L39:
            if (r107.mStrokeColor.willDraw() == false) goto L56;
            ComplexColorCompat r128 = r107.mStrokeColor;
            if (this.mStrokePaint != null) goto L43;
            Paint r129 = new Paint(1);
            this.mStrokePaint = r129;
            r129.setStyle(Paint.Style.STROKE);
        L43:
            Paint r130 = this.mStrokePaint;
            Paint.Join r131 = r107.mStrokeLineJoin;
            if (r131 == null) goto L46;
            r130.setStrokeJoin(r131);
        L46:
            Paint.Cap r132 = r107.mStrokeLineCap;
            if (r132 == null) goto L49;
            r130.setStrokeCap(r132);
        L49:
            r130.setStrokeMiter(r107.mStrokeMiterlimit);
            if (r128.isGradient() == false) goto L52;
            Shader r133 = r128.getShader();
            r133.setLocalMatrix(this.mFinalPathMatrix);
            r130.setShader(r133);
            r130.setAlpha(Math.round(r107.mStrokeAlpha * 255.0f));
        L53:
            r130.setColorFilter(r113);
            r130.setStrokeWidth(r107.mStrokeWidth * (r102 * r104));
            r110.drawPath(this.mRenderPath, r130);
            return;
        L52:
            r130.setShader(null);
            r130.setAlpha(255);
            r130.setColor(VectorDrawableCompat.applyAlpha(r128.getColor(), r107.mStrokeAlpha));
            goto L53
        L56:
            return;
        L22:
            this.mPathMeasure.getSegment(r120, r121, r116, true);
            goto L23
        L15:
            if (r107.mTrimPathEnd == 1.0f) goto L24;
            goto L16
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public boolean canReuseCache() {
            if (this.mCacheDirty == false) goto L5;
        L13:
            return false;
        L5:
            if (this.mCachedTint != this.mTint) goto L13;
            if (this.mCachedTintMode != this.mTintMode) goto L13;
            if (this.mCachedAutoMirrored != this.mAutoMirrored) goto L13;
            if (this.mCachedRootAlpha != this.mVPathRenderer.getRootAlpha()) goto L13;
            return true;
        }

        public boolean hasTranslucentRoot() {
            if (this.mVPathRenderer.getRootAlpha() >= 255) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public VectorDrawableCompatState(VectorDrawableCompatState r100) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (r100 == null) goto L12;
            this.mChangingConfigurations = r100.mChangingConfigurations;
            VPathRenderer r101 = new VPathRenderer(r100.mVPathRenderer);
            this.mVPathRenderer = r101;
            if (r100.mVPathRenderer.mFillPaint == null) goto L8;
            r101.mFillPaint = new Paint(r100.mVPathRenderer.mFillPaint);
        L8:
            if (r100.mVPathRenderer.mStrokePaint == null) goto L10;
            VPathRenderer r102 = this.mVPathRenderer;
            r102.mStrokePaint = new Paint(r100.mVPathRenderer.mStrokePaint);
        L10:
            this.mTint = r100.mTint;
            this.mTintMode = r100.mTintMode;
            this.mAutoMirrored = r100.mAutoMirrored;
            return;
        }

        public Paint getPaint(ColorFilter r100) {
            if (hasTranslucentRoot() == true) goto L8;
            if (r100 != null) goto L8;
            return null;
        L8:
            if (this.mTempPaint != null) goto L10;
            Paint r101 = new Paint();
            this.mTempPaint = r101;
            r101.setFilterBitmap(true);
        L10:
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(r100);
            return this.mTempPaint;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] r100) {
            boolean r101 = this.mVPathRenderer.onStateChanged(r100);
            this.mCacheDirty |= r101;
            return r101;
        }

        public boolean canReuseBitmap(int r100, int r101) {
            if (r100 == this.mCachedBitmap.getWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r101 != this.mCachedBitmap.getHeight()) goto L7;
            return true;
        }

        public void createCachedBitmapIfNeeded(int r100, int r101) {
            if (this.mCachedBitmap != null) goto L5;
        L6:
            this.mCachedBitmap = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
            this.mCacheDirty = true;
            return;
        L5:
            if (canReuseBitmap(r100, r101) == false) goto L6;
        }

        public void updateCachedBitmap(int r100, int r101) {
            this.mCachedBitmap.eraseColor(0);
            Canvas r102 = new Canvas(this.mCachedBitmap);
            this.mVPathRenderer.draw(r102, r100, r101, null);
        }

        public void drawCachedBitmapWithRootAlpha(Canvas r100, ColorFilter r101, Rect r102) {
            Paint r103 = getPaint(r101);
            r100.drawBitmap(this.mCachedBitmap, null, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat r100 = new VectorDrawableCompat();
            r100.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return r100;
        }

        public VectorDrawableDelegateState(Drawable.ConstantState r100) {
            this.mDelegateState = r100;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            VectorDrawableCompat r101 = new VectorDrawableCompat();
            r101.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r100);
            return r101;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100, Resources.Theme r101) {
            VectorDrawableCompat r102 = new VectorDrawableCompat();
            r102.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r100, r101);
            return r102;
        }
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        DrawableCompat.canApplyTheme(r100);
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.getAlpha(r100);
    L7:
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getChangingConfigurations();
    L7:
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.getColorFilter(r100);
    L7:
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
    L8:
        VectorDrawableCompatState r100 = this.mVectorState;
        r100.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getIntrinsicHeight();
    L7:
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getIntrinsicWidth();
    L7:
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 != null) goto L5;
        return -3;
    L5:
        return r100.getOpacity();
    }

    public float getPixelSize() {
        VectorDrawableCompatState r100 = this.mVectorState;
        if (r100 == null) goto L17;
        VPathRenderer r101 = r100.mVPathRenderer;
        if (r101 == null) goto L19;
        float r102 = r101.mBaseWidth;
        if (r102 == 0.0f) goto L20;
        float r103 = r101.mBaseHeight;
        if (r103 == 0.0f) goto L21;
        float r104 = r101.mViewportHeight;
        if (r104 == 0.0f) goto L22;
        float r105 = r101.mViewportWidth;
        if (r105 != 0.0f) goto L16;
        return 1.0f;
    L16:
        return Math.min(r105 / r102, r104 / r103);
    L22:
        return 1.0f;
    L21:
        return 1.0f;
    L20:
        return 1.0f;
    L19:
        return 1.0f;
    L17:
        return 1.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        r100.invalidateSelf();
        return;
    L6:
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r100);
    L7:
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.isStateful();
    L7:
        if (super.isStateful() == true) goto L18;
        VectorDrawableCompatState r101 = this.mVectorState;
        if (r101 != null) goto L11;
    L17:
        return false;
    L11:
        if (r101.isStateful() == true) goto L18;
        ColorStateList r102 = this.mVectorState.mTint;
        if (r102 == null) goto L17;
        if (r102.isStateful() == false) goto L17;
    L18:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        r100.mutate();
        return this;
    L7:
        if (this.mMutated == false) goto L9;
    L11:
        return this;
    L9:
        if (super.mutate() != this) goto L11;
        this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
        this.mMutated = true;
        goto L11
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    private boolean needMirroring() {
        if (isAutoMirrored() == true) goto L5;
    L7:
        return false;
    L5:
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L7;
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public VectorDrawableCompat(VectorDrawableCompatState r100) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = r100;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r100.mTint, r100.mTintMode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r100) {
        super.applyTheme(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        r100.draw(r110);
        return;
    L6:
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0) goto L9;
        return;
    L9:
        if (this.mTmpBounds.height() <= 0) goto L36;
        ColorFilter r101 = this.mColorFilter;
        if (r101 != null) goto L14;
        r101 = this.mTintFilter;
    L14:
        r110.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float r102 = Math.abs(this.mTmpFloats[0]);
        float r103 = Math.abs(this.mTmpFloats[4]);
        float r104 = Math.abs(this.mTmpFloats[1]);
        float r105 = Math.abs(this.mTmpFloats[3]);
        if (r104 == 0.0f) goto L17;
    L18:
        r102 = 1.0f;
        r103 = 1.0f;
    L19:
        int r106 = (int) (this.mTmpBounds.width() * r102);
        int r107 = (int) (this.mTmpBounds.height() * r103);
        int r108 = Math.min(2048, r106);
        int r109 = Math.min(2048, r107);
        if (r108 <= 0) goto L35;
        if (r109 <= 0) goto L37;
        int r111 = r110.save();
        Rect r112 = this.mTmpBounds;
        r110.translate(r112.left, r112.top);
        if (needMirroring() == false) goto L26;
        r110.translate(this.mTmpBounds.width(), 0.0f);
        r110.scale(-1.0f, 1.0f);
    L26:
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(r108, r109);
        if (this.mAllowCaching == true) goto L30;
        this.mVectorState.updateCachedBitmap(r108, r109);
    L32:
        this.mVectorState.drawCachedBitmapWithRootAlpha(r110, r101, this.mTmpBounds);
        r110.restoreToCount(r111);
        return;
    L30:
        if (this.mVectorState.canReuseCache() == true) goto L32;
        this.mVectorState.updateCachedBitmap(r108, r109);
        this.mVectorState.updateCacheStates();
        goto L32
    L37:
        return;
    L35:
        return;
    L17:
        if (r105 == 0.0f) goto L19;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r100) {
        return super.getPadding(r100);
    }

    public Object getTargetByName(String r100) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 != null) goto L5;
        VectorDrawableCompatState r102 = this.mVectorState;
        ColorStateList r103 = r102.mTint;
        if (r103 == null) goto L11;
        PorterDuff.Mode r104 = r102.mTintMode;
        if (r104 == null) goto L11;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r103, r104);
        invalidateSelf();
        boolean r105 = true;
    L13:
        if (r102.isStateful() == false) goto L18;
        if (r102.onStateChanged(r100) == false) goto L18;
        invalidateSelf();
        return true;
    L18:
        return r105;
    L11:
        r105 = false;
        goto L13
    L5:
        return r101.setState(r100);
    }

    public void setAllowCaching(boolean r100) {
        this.mAllowCaching = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        r101.setAlpha(r100);
        return;
    L7:
        if (this.mVectorState.mVPathRenderer.getRootAlpha() == r100) goto L10;
        this.mVectorState.mVPathRenderer.setRootAlpha(r100);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setAutoMirrored(r101, r100);
        return;
    L6:
        this.mVectorState.mAutoMirrored = r100;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r100) {
        super.setChangingConfigurations(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setColorFilter(r100);
        return;
    L6:
        this.mColorFilter = r100;
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r100) {
        super.setFilterBitmap(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r100) {
        return super.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTint(r101, r100);
        return;
    L6:
        setTintList(ColorStateList.valueOf(r100));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintList(r101, r100);
        return;
    L6:
        VectorDrawableCompatState r102 = this.mVectorState;
        if (r102.mTint == r100) goto L10;
        r102.mTint = r100;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r100, r102.mTintMode);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintMode(r101, r100);
        return;
    L6:
        VectorDrawableCompatState r102 = this.mVectorState;
        if (r102.mTintMode == r100) goto L10;
        r102.mTintMode = r100;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r102.mTint, r100);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.unscheduleSelf(r100);
        return;
    L6:
        super.unscheduleSelf(r100);
    }

    public static int applyAlpha(int r100, float r101) {
        return (r100 & 16777215) | (((int) (Color.alpha(r100) * r101)) << 24);
    }

    private static PorterDuff.Mode parseTintModeCompat(int r100, PorterDuff.Mode r101) {
        if (r100 == 3) goto L21;
        if (r100 == 5) goto L19;
        if (r100 == 9) goto L17;
        switch(r100) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r101;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    private void printGroupTree(VGroup r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r103 = r103 + 1;
        goto L3
    L5:
        r100.getGroupName();
        r100.getLocalMatrix().toString();
    L7:
        if (r102 >= r100.mChildren.size()) goto L13;
        VObject r104 = (VObject) ListProtector.get(r100.mChildren, r102);
        if ((r104 instanceof VGroup) == false) goto L11;
        printGroupTree((VGroup) r104, r101 + 1);
    L12:
        r102 = r102 + 1;
        goto L7
    L11:
        ((VPath) r104).printVPath(r101 + 1);
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r100, long r101) {
        Drawable r102 = this.mDelegateDrawable;
        if (r102 == null) goto L6;
        r102.scheduleSelf(r100, r101);
        return;
    L6:
        super.scheduleSelf(r100, r101);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r100, PorterDuff.Mode r101) {
        super.setColorFilter(r100, r101);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r100, float r101) {
        super.setHotspot(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        Drawable r102 = this.mDelegateDrawable;
        if (r102 == null) goto L7;
        return r102.setVisible(r100, r101);
    L7:
        return super.setVisible(r100, r101);
    }

    public static VectorDrawableCompat create(Resources r100, int r101, Resources.Theme r102) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        VectorDrawableCompat r103 = new VectorDrawableCompat();
        r103.mDelegateDrawable = ResourcesCompat.getDrawable(r100, r101, r102);
        return r103;
    L7:
        return createWithoutDelegate(r100, r101, r102);
    }

    public static VectorDrawableCompat createWithoutDelegate(Resources r100, int r101, Resources.Theme r102) {
        XmlResourceParser r103 = r100.getXml(r101);     // Catch: Throwable -> L13
        AttributeSet r104 = Xml.asAttributeSet(r103);     // Catch: Throwable -> L13
    L3:
        int r105 = r103.next();     // Catch: Throwable -> L13
        if (r105 == 2) goto L8;
        if (r105 != 1) goto L3;
    L8:
        if (r105 != 2) goto L12;
        return createFromXmlInner(r100, r103, r104, r102);
    L12:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L13
    L13:
        return null;
    }

    private void updateStateFromTypedArray(TypedArray r100, XmlPullParser r101, Resources.Theme r102) throws XmlPullParserException {
        VectorDrawableCompatState r103 = this.mVectorState;
        VPathRenderer r104 = r103.mVPathRenderer;
        r103.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(r100, r101, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList r105 = TypedArrayUtils.getNamedColorStateList(r100, r101, r102, "tint", 1);
        if (r105 == null) goto L5;
        r103.mTint = r105;
    L5:
        r103.mAutoMirrored = TypedArrayUtils.getNamedBoolean(r100, r101, "autoMirrored", 5, r103.mAutoMirrored);
        r104.mViewportWidth = TypedArrayUtils.getNamedFloat(r100, r101, "viewportWidth", 7, r104.mViewportWidth);
        float r106 = TypedArrayUtils.getNamedFloat(r100, r101, "viewportHeight", 8, r104.mViewportHeight);
        r104.mViewportHeight = r106;
        if (r104.mViewportWidth <= 0.0f) goto L24;
        if (r106 <= 0.0f) goto L22;
        r104.mBaseWidth = r100.getDimension(3, r104.mBaseWidth);
        float r107 = r100.getDimension(2, r104.mBaseHeight);
        r104.mBaseHeight = r107;
        if (r104.mBaseWidth <= 0.0f) goto L20;
        if (r107 <= 0.0f) goto L18;
        r104.setAlpha(TypedArrayUtils.getNamedFloat(r100, r101, "alpha", 4, r104.getAlpha()));
        String r108 = r100.getString(0);
        if (r108 == null) goto L25;
        r104.mRootName = r108;
        r104.mVGTargetsMap.put(r108, r104);
        return;
    L25:
        return;
    L18:
        throw new XmlPullParserException(r100.getPositionDescription() + "<vector> tag requires height > 0");
    L20:
        throw new XmlPullParserException(r100.getPositionDescription() + "<vector> tag requires width > 0");
    L22:
        throw new XmlPullParserException(r100.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    L24:
        throw new XmlPullParserException(r100.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r100, XmlPullParser r101, AttributeSet r102) throws XmlPullParserException, IOException {
        Drawable r103 = this.mDelegateDrawable;
        if (r103 == null) goto L6;
        r103.inflate(r100, r101, r102);
        return;
    L6:
        inflate(r100, r101, r102, null);
    }

    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter r100, ColorStateList r101, PorterDuff.Mode r102) {
        if (r101 == null) goto L7;
        if (r102 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r101.getColorForState(getState(), 0), r102);
    L7:
        return null;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) throws XmlPullParserException, IOException {
        VectorDrawableCompat r104 = new VectorDrawableCompat();
        r104.inflate(r100, r101, r102, r103);
        return r104;
    }

    private void inflateInternal(Resources r110, XmlPullParser r111, AttributeSet r112, Resources.Theme r113) throws XmlPullParserException, IOException {
        VectorDrawableCompatState r100 = this.mVectorState;
        VPathRenderer r101 = r100.mVPathRenderer;
        ArrayDeque r102 = new ArrayDeque();
        r102.push(r101.mRootGroup);
        int r103 = r111.getEventType();
        int r104 = r111.getDepth() + 1;
        boolean r105 = true;
    L3:
        if (r103 == 1) goto L34;
        if (r111.getDepth() >= r104) goto L8;
        if (r103 == 3) goto L34;
    L8:
        if (r103 != 2) goto L29;
        String r106 = r111.getName();
        VGroup r107 = (VGroup) r102.peek();
        if (r107 == null) goto L33;
        if ("path".equals(r106) == false) goto L18;
        VFullPath r108 = new VFullPath();
        r108.inflate(r110, r112, r113, r111);
        r107.mChildren.add(r108);
        if (r108.getPathName() == null) goto L16;
        r101.mVGTargetsMap.put(r108.getPathName(), r108);
    L16:
        int r109 = r100.mChangingConfigurations;
        r100.mChangingConfigurations = r108.mChangingConfigurations | r109;
        r105 = false;
        goto L33
    L18:
        if (SHAPE_CLIP_PATH.equals(r106) == false) goto L24;
        VClipPath r114 = new VClipPath();
        r114.inflate(r110, r112, r113, r111);
        r107.mChildren.add(r114);
        if (r114.getPathName() == null) goto L22;
        r101.mVGTargetsMap.put(r114.getPathName(), r114);
    L22:
        int r115 = r100.mChangingConfigurations;
        r100.mChangingConfigurations = r114.mChangingConfigurations | r115;
        goto L33
    L24:
        if ("group".equals(r106) == false) goto L33;
        VGroup r116 = new VGroup();
        r116.inflate(r110, r112, r113, r111);
        r107.mChildren.add(r116);
        r102.push(r116);
        if (r116.getGroupName() == null) goto L28;
        r101.mVGTargetsMap.put(r116.getGroupName(), r116);
    L28:
        int r117 = r100.mChangingConfigurations;
        r100.mChangingConfigurations = r116.mChangingConfigurations | r117;
    L33:
        r103 = r111.next();
        goto L3
    L29:
        if (r103 != 3) goto L33;
        if ("group".equals(r111.getName()) == false) goto L33;
        r102.pop();
    L34:
        if (r105 == true) goto L37;
        return;
    L37:
        throw new XmlPullParserException("no path defined");
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) throws XmlPullParserException, IOException {
        Drawable r104 = this.mDelegateDrawable;
        if (r104 == null) goto L6;
        DrawableCompat.inflate(r104, r100, r101, r102, r103);
        return;
    L6:
        VectorDrawableCompatState r105 = this.mVectorState;
        r105.mVPathRenderer = new VPathRenderer();
        TypedArray r106 = TypedArrayUtils.obtainAttributes(r100, r103, r102, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(r106, r101, r103);
        r106.recycle();
        r105.mChangingConfigurations = getChangingConfigurations();
        r105.mCacheDirty = true;
        inflateInternal(r100, r101, r102, r103);
        this.mTintFilter = updateTintFilter(this.mTintFilter, r105.mTint, r105.mTintMode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r100, int r101, int r102, int r103) {
        super.setHotspotBounds(r100, r101, r102, r103);
    }
}
