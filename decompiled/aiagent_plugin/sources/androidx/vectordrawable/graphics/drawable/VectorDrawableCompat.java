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
import android.util.Log;
import android.util.Xml;
import androidx.core.content.b.h;
import androidx.core.content.b.i;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
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
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {
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
        f mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState r4) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (r4 == null) goto L12;
            this.mChangingConfigurations = r4.mChangingConfigurations;
            this.mVPathRenderer = new f(r4.mVPathRenderer);
            if (r4.mVPathRenderer.f2889b == null) goto L8;
            f r0 = this.mVPathRenderer;
            r0.f2889b = new Paint(r4.mVPathRenderer.f2889b);
        L8:
            if (r4.mVPathRenderer.f2888a == null) goto L10;
            f r1 = this.mVPathRenderer;
            r1.f2888a = new Paint(r4.mVPathRenderer.f2888a);
        L10:
            this.mTint = r4.mTint;
            this.mTintMode = r4.mTintMode;
            this.mAutoMirrored = r4.mAutoMirrored;
            return;
        }

        public void drawCachedBitmapWithRootAlpha(Canvas r2, ColorFilter r3, Rect r4) {
            Paint r5 = getPaint(r3);
            r2.drawBitmap(this.mCachedBitmap, null, r4, r5);
        }

        public boolean hasTranslucentRoot() {
            if (this.mVPathRenderer.getRootAlpha() >= 255) goto L5;
            return true;
        L5:
            return false;
        }

        public Paint getPaint(ColorFilter r3) {
            if (hasTranslucentRoot() == true) goto L8;
            if (r3 != null) goto L8;
            return null;
        L8:
            if (this.mTempPaint != null) goto L10;
            Paint r0 = new Paint();
            this.mTempPaint = r0;
            r0.setFilterBitmap(true);
        L10:
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(r3);
            return this.mTempPaint;
        }

        public void updateCachedBitmap(int r3, int r4) {
            this.mCachedBitmap.eraseColor(0);
            Canvas r0 = new Canvas(this.mCachedBitmap);
            this.mVPathRenderer.a(r0, r3, r4, null);
        }

        public void createCachedBitmapIfNeeded(int r2, int r3) {
            if (this.mCachedBitmap != null) goto L5;
        L6:
            this.mCachedBitmap = Bitmap.createBitmap(r2, r3, Bitmap.Config.ARGB_8888);
            this.mCacheDirty = true;
            return;
        L5:
            if (canReuseBitmap(r2, r3) == false) goto L6;
        }

        public boolean canReuseBitmap(int r2, int r3) {
            if (r2 == this.mCachedBitmap.getWidth()) goto L5;
            return false;
        L5:
            if (r3 != this.mCachedBitmap.getHeight()) goto L10;
            return true;
        L10:
            return false;
        }

        public boolean canReuseCache() {
            if (this.mCacheDirty == false) goto L5;
            return false;
        L5:
            if (this.mCachedTint == this.mTint) goto L7;
            return false;
        L7:
            if (this.mCachedTintMode == this.mTintMode) goto L9;
            return false;
        L9:
            if (this.mCachedAutoMirrored == this.mAutoMirrored) goto L11;
            return false;
        L11:
            if (this.mCachedRootAlpha != this.mVPathRenderer.getRootAlpha()) goto L19;
            return true;
        L19:
            return false;
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
            this.mVPathRenderer = new f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r1) {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.a();
        }

        public boolean onStateChanged(int[] r2) {
            boolean r3 = this.mVPathRenderer.a(r2);
            this.mCacheDirty |= r3;
            return r3;
        }
    }

    private static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState r1) {
            this.mDelegateState = r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat r0 = new VectorDrawableCompat();
            r0.mDelegateDrawable = (VectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateState.newDrawable(), VectorDrawable.class, "com.obric.aiagent.plugin");
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r3) {
            VectorDrawableCompat r0 = new VectorDrawableCompat();
            r0.mDelegateDrawable = (VectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateState.newDrawable(r3), VectorDrawable.class, "com.obric.aiagent.plugin");
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2, Resources.Theme r3) {
            VectorDrawableCompat r0 = new VectorDrawableCompat();
            r0.mDelegateDrawable = (VectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateState.newDrawable(r2, r3), VectorDrawable.class, "com.obric.aiagent.plugin");
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }
    }

    private static class a extends e {
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e
        public boolean a() {
            return true;
        }

        a() {
        }

        a(a r1) {
            super(r1);
        }

        public void a(Resources r3, AttributeSet r4, Resources.Theme r5, XmlPullParser r6) {
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.aiagent.plugin");
            if (i.a(r8, "pathData") == true) goto L5;
            return;
        L5:
            TypedArray r9 = i.a(r3, r5, r7, androidx.vectordrawable.graphics.drawable.a.f2896d);
            a(r9, r8);
            r9.recycle();
        }

        private void a(TypedArray r4, XmlPullParser r5) {
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.aiagent.plugin");
            String r1 = r4.getString(0);
            if (r1 == null) goto L5;
            this.m = r1;
        L5:
            String r2 = r4.getString(1);
            if (r2 == null) goto L8;
            this.l = androidx.core.graphics.i.b(r2);
        L8:
            this.n = i.a(r4, r6, "fillType", 2, 0);
        }
    }

    private static class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.core.content.b.d f2878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.core.content.b.d f2880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2882e;
        float f;
        float g;
        float h;
        Paint.Cap i;
        Paint.Join j;
        float k;
        private int[] p;

        b() {
            this.f2879b = 0.0f;
            this.f2881d = 1.0f;
            this.f2882e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
        }

        b(b r3) {
            super(r3);
            this.f2879b = 0.0f;
            this.f2881d = 1.0f;
            this.f2882e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
            this.p = r3.p;
            this.f2878a = r3.f2878a;
            this.f2879b = r3.f2879b;
            this.f2881d = r3.f2881d;
            this.f2880c = r3.f2880c;
            this.n = r3.n;
            this.f2882e = r3.f2882e;
            this.f = r3.f;
            this.g = r3.g;
            this.h = r3.h;
            this.i = r3.i;
            this.j = r3.j;
            this.k = r3.k;
        }

        private Paint.Cap a(int r1, Paint.Cap r2) {
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return r2;
        L9:
            return Paint.Cap.SQUARE;
        L11:
            return Paint.Cap.ROUND;
        L13:
            return Paint.Cap.BUTT;
        }

        private Paint.Join a(int r1, Paint.Join r2) {
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return r2;
        L9:
            return Paint.Join.BEVEL;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        }

        public void a(Resources r3, AttributeSet r4, Resources.Theme r5, XmlPullParser r6) {
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.aiagent.plugin");
            TypedArray r9 = i.a(r3, r5, r7, androidx.vectordrawable.graphics.drawable.a.f2895c);
            a(r9, r8, r5);
            r9.recycle();
        }

        private void a(TypedArray r7, XmlPullParser r8, Resources.Theme r9) {
            XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.p = null;
            if (i.a(r10, "pathData") == true) goto L5;
            return;
        L5:
            String r0 = r7.getString(0);
            if (r0 == null) goto L8;
            this.m = r0;
        L8:
            String r1 = r7.getString(2);
            if (r1 == null) goto L11;
            this.l = androidx.core.graphics.i.b(r1);
        L11:
            this.f2880c = i.a(r7, r10, r9, "fillColor", 1, 0);
            this.f2882e = i.a(r7, r10, "fillAlpha", 12, this.f2882e);
            this.i = a(i.a(r7, r10, "strokeLineCap", 8, -1), this.i);
            this.j = a(i.a(r7, r10, "strokeLineJoin", 9, -1), this.j);
            this.k = i.a(r7, r10, "strokeMiterLimit", 10, this.k);
            this.f2878a = i.a(r7, r10, r9, "strokeColor", 3, 0);
            this.f2881d = i.a(r7, r10, "strokeAlpha", 11, this.f2881d);
            this.f2879b = i.a(r7, r10, "strokeWidth", 4, this.f2879b);
            this.g = i.a(r7, r10, "trimPathEnd", 6, this.g);
            this.h = i.a(r7, r10, "trimPathOffset", 7, this.h);
            this.f = i.a(r7, r10, "trimPathStart", 5, this.f);
            this.n = i.a(r7, r10, "fillType", 13, this.n);
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.d
        public boolean b() {
            if (this.f2880c.d() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f2878a.d() == true) goto L8;
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.d
        public boolean a(int[] r2) {
            boolean r0 = this.f2880c.a(r2);
            return this.f2878a.a(r2) | r0;
        }

        int getStrokeColor() {
            return this.f2878a.b();
        }

        void setStrokeColor(int r1) {
            this.f2878a.b(r1);
        }

        float getStrokeWidth() {
            return this.f2879b;
        }

        void setStrokeWidth(float r1) {
            this.f2879b = r1;
        }

        float getStrokeAlpha() {
            return this.f2881d;
        }

        void setStrokeAlpha(float r1) {
            this.f2881d = r1;
        }

        int getFillColor() {
            return this.f2880c.b();
        }

        void setFillColor(int r1) {
            this.f2880c.b(r1);
        }

        float getFillAlpha() {
            return this.f2882e;
        }

        void setFillAlpha(float r1) {
            this.f2882e = r1;
        }

        float getTrimPathStart() {
            return this.f;
        }

        void setTrimPathStart(float r1) {
            this.f = r1;
        }

        float getTrimPathEnd() {
            return this.g;
        }

        void setTrimPathEnd(float r1) {
            this.g = r1;
        }

        float getTrimPathOffset() {
            return this.h;
        }

        void setTrimPathOffset(float r1) {
            this.h = r1;
        }
    }

    private static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f2883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<d> f2884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Matrix f2886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2887e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k;
        private int[] l;
        private String m;

        public c(c r7, androidx.b.a<String, Object> r8) {
            super(null);
            this.f2883a = new Matrix();
            this.f2884b = new ArrayList();
            this.f2885c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            Matrix r2 = new Matrix();
            this.f2886d = r2;
            this.m = null;
            this.f2885c = r7.f2885c;
            this.f = r7.f;
            this.g = r7.g;
            this.h = r7.h;
            this.i = r7.i;
            this.j = r7.j;
            this.k = r7.k;
            this.l = r7.l;
            String r1 = r7.m;
            this.m = r1;
            this.f2887e = r7.f2887e;
            if (r1 == null) goto L5;
            r8.put(r1, this);
        L5:
            r2.set(r7.f2886d);
            ArrayList<d> r9 = r7.f2884b;
            int r3 = 0;
        L7:
            if (r3 >= r9.size()) goto L23;
            d r4 = r9.get(r3);
            if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L12;
            c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
            this.f2884b.add(new c(r5, r8));
        L20:
            r3 = r3 + 1;
            goto L7
        L12:
            if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L15;
            e r6 = new b((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
        L17:
            this.f2884b.add(r6);
            if (r6.m == null) goto L20;
            r8.put(r6.m, r6);
            goto L20
        L15:
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L22;
            r6 = new a((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
            goto L17
        L22:
            throw new IllegalStateException("Unknown object in the tree!");
        }

        public c() {
            super(null);
            this.f2883a = new Matrix();
            this.f2884b = new ArrayList();
            this.f2885c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.f2886d = new Matrix();
            this.m = null;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f2886d;
        }

        public void a(Resources r3, AttributeSet r4, Resources.Theme r5, XmlPullParser r6) {
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.aiagent.plugin");
            TypedArray r9 = i.a(r3, r5, r7, androidx.vectordrawable.graphics.drawable.a.f2894b);
            a(r9, r8);
            r9.recycle();
        }

        private void a(TypedArray r4, XmlPullParser r5) {
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.l = null;
            this.f2885c = i.a(r4, r6, "rotation", 5, this.f2885c);
            this.f = r4.getFloat(1, this.f);
            this.g = r4.getFloat(2, this.g);
            this.h = i.a(r4, r6, "scaleX", 3, this.h);
            this.i = i.a(r4, r6, "scaleY", 4, this.i);
            this.j = i.a(r4, r6, "translateX", 6, this.j);
            this.k = i.a(r4, r6, "translateY", 7, this.k);
            String r7 = r4.getString(0);
            if (r7 == null) goto L5;
            this.m = r7;
        L5:
            a();
        }

        private void a() {
            this.f2886d.reset();
            this.f2886d.postTranslate(-this.f, -this.g);
            this.f2886d.postScale(this.h, this.i);
            this.f2886d.postRotate(this.f2885c, 0.0f, 0.0f);
            this.f2886d.postTranslate(this.j + this.f, this.k + this.g);
        }

        public float getRotation() {
            return this.f2885c;
        }

        public void setRotation(float r2) {
            if (r2 == this.f2885c) goto L6;
            this.f2885c = r2;
            a();
            return;
        }

        public float getPivotX() {
            return this.f;
        }

        public void setPivotX(float r2) {
            if (r2 == this.f) goto L6;
            this.f = r2;
            a();
            return;
        }

        public float getPivotY() {
            return this.g;
        }

        public void setPivotY(float r2) {
            if (r2 == this.g) goto L6;
            this.g = r2;
            a();
            return;
        }

        public float getScaleX() {
            return this.h;
        }

        public void setScaleX(float r2) {
            if (r2 == this.h) goto L6;
            this.h = r2;
            a();
            return;
        }

        public float getScaleY() {
            return this.i;
        }

        public void setScaleY(float r2) {
            if (r2 == this.i) goto L6;
            this.i = r2;
            a();
            return;
        }

        public float getTranslateX() {
            return this.j;
        }

        public void setTranslateX(float r2) {
            if (r2 == this.j) goto L6;
            this.j = r2;
            a();
            return;
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setTranslateY(float r2) {
            if (r2 == this.k) goto L6;
            this.k = r2;
            a();
            return;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.d
        public boolean b() {
            int r1 = 0;
        L4:
            if (r1 >= this.f2884b.size()) goto L10;
            if (((d) ZeusTransformUtils.preCheckCast(this.f2884b.get(r1), d.class, "com.obric.aiagent.plugin")).b() == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.d
        public boolean a(int[] r6) {
            int r0 = 0;
            boolean r1 = false;
        L4:
            if (r0 >= this.f2884b.size()) goto L6;
            r1 = r1 | ((d) ZeusTransformUtils.preCheckCast(this.f2884b.get(r0), d.class, "com.obric.aiagent.plugin")).a(r6);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }
    }

    private static abstract class d {
        public boolean a(int[] r1) {
            return false;
        }

        public boolean b() {
            return false;
        }

        private d() {
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }
    }

    private static abstract class e extends d {
        protected androidx.core.graphics.i.b[] l;
        String m;
        int n;
        int o;

        public boolean a() {
            return false;
        }

        public e() {
            super(null);
            this.l = null;
            this.n = 0;
        }

        public void a(int r4) {
            String r0 = "";
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L5;
            r0 = r0 + "    ";
            r1 = r1 + 1;
            goto L3
        L5:
            a(VectorDrawableCompat.LOGTAG, r0 + "current path is :" + this.m + " pathData is " + a(this.l));
        }

        public String a(androidx.core.graphics.i.b[] r6) {
            String r0 = " ";
            int r1 = 0;
        L4:
            if (r1 >= r6.length) goto L10;
            r0 = r0 + r6[r1].f1217a + ":";
            float[] r2 = r6[r1].f1218b;
            int r3 = 0;
        L7:
            if (r3 >= r2.length) goto L9;
            r0 = r0 + r2[r3] + ",";
            r3 = r3 + 1;
            goto L7
        L9:
            r1 = r1 + 1;
            goto L4
        L10:
            return r0;
        }

        public e(e r2) {
            super(null);
            this.l = null;
            this.n = 0;
            this.m = r2.m;
            this.o = r2.o;
            this.l = androidx.core.graphics.i.a(r2.l);
        }

        public void a(Path r1) {
            r1.reset();
            androidx.core.graphics.i.b[] r0 = this.l;
            if (r0 == null) goto L6;
            androidx.core.graphics.i.b.a(r0, r1);
            return;
        }

        public String getPathName() {
            return this.m;
        }

        public androidx.core.graphics.i.b[] getPathData() {
            return this.l;
        }

        public void setPathData(androidx.core.graphics.i.b[] r2) {
            if (androidx.core.graphics.i.a(this.l, r2) == true) goto L5;
            this.l = androidx.core.graphics.i.a(r2);
            return;
        L5:
            androidx.core.graphics.i.b(this.l, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    private static class f {
        private static final Matrix n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Paint f2888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Paint f2889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final c f2890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2892e;
        float f;
        float g;
        int h;
        String i;
        Boolean j;
        final androidx.b.a<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        private static float a(float r0, float r1, float r2, float r3) {
            return (r0 * r3) - (r1 * r2);
        }

        static {
            n = new Matrix();
        }

        public f() {
            this.o = new Matrix();
            this.f2891d = 0.0f;
            this.f2892e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new androidx.b.a();
            this.f2890c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public void setRootAlpha(int r1) {
            this.h = r1;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float r2) {
            setRootAlpha((int) (r2 * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public f(f r4) {
            this.o = new Matrix();
            this.f2891d = 0.0f;
            this.f2892e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            androidx.b.a<String, Object> r0 = new androidx.b.a();
            this.k = r0;
            this.f2890c = new c(r4.f2890c, r0);
            this.l = new Path(r4.l);
            this.m = new Path(r4.m);
            this.f2891d = r4.f2891d;
            this.f2892e = r4.f2892e;
            this.f = r4.f;
            this.g = r4.g;
            this.q = r4.q;
            this.h = r4.h;
            this.i = r4.i;
            String r1 = r4.i;
            if (r1 == null) goto L5;
            r0.put(r1, this);
        L5:
            this.j = r4.j;
        }

        private void a(c r9, Matrix r10, Canvas r11, int r12, int r13, ColorFilter r14) {
            r9.f2883a.set(r10);
            r9.f2883a.preConcat(r9.f2886d);
            r11.save();
            int r15 = 0;
        L4:
            if (r15 >= r9.f2884b.size()) goto L12;
            d r0 = (d) ZeusTransformUtils.preCheckCast(r9.f2884b.get(r15), d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L9;
            a((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin"), r9.f2883a, r11, r12, r13, r14);
        L11:
            r15 = r15 + 1;
            goto L4
        L9:
            if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L11;
            a(r9, (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14);
            goto L11
        L12:
            r11.restore();
        }

        public void a(Canvas r8, int r9, int r10, ColorFilter r11) {
            a(this.f2890c, n, r8, r9, r10, r11);
        }

        private void a(c r8, e r9, Canvas r10, int r11, int r12, ColorFilter r13) {
            float r14 = r11 / this.f;
            float r15 = r12 / this.g;
            float r0 = Math.min(r14, r15);
            Matrix r16 = r8.f2883a;
            this.o.set(r16);
            this.o.postScale(r14, r15);
            float r17 = a(r16);
            if (r17 != 0.0f) goto L5;
            return;
        L5:
            r9.a(this.l);
            Path r18 = this.l;
            this.m.reset();
            if (r9.a() == false) goto L12;
            Path r19 = this.m;
            if (r9.n != 0) goto L10;
            Path.FillType r20 = Path.FillType.WINDING;
        L11:
            r19.setFillType(r20);
            this.m.addPath(r18, this.o);
            r10.clipPath(this.m);
            return;
        L10:
            r20 = Path.FillType.EVEN_ODD;
            goto L11
        L12:
            b r21 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (r21.f == 0.0f) goto L15;
        L16:
            float r1 = (r21.f + r21.h) % 1.0f;
            float r4 = (r21.g + r21.h) % 1.0f;
            if (this.p != null) goto L19;
            this.p = new PathMeasure();
        L19:
            this.p.setPath(this.l, false);
            float r2 = this.p.getLength();
            float r3 = r1 * r2;
            float r5 = r4 * r2;
            r18.reset();
            if (r3 <= r5) goto L22;
            this.p.getSegment(r3, r2, r18, true);
            this.p.getSegment(0.0f, r5, r18, true);
        L23:
            r18.rLineTo(0.0f, 0.0f);
        L24:
            this.m.addPath(r18, this.o);
            if (r21.f2880c.e() == false) goto L39;
            androidx.core.content.b.d r110 = r21.f2880c;
            if (this.f2889b != null) goto L29;
            Paint r6 = new Paint(1);
            this.f2889b = r6;
            r6.setStyle(Paint.Style.FILL);
        L29:
            Paint r7 = this.f2889b;
            if (r110.c() == false) goto L32;
            Shader r111 = r110.a();
            r111.setLocalMatrix(this.o);
            r7.setShader(r111);
            r7.setAlpha(Math.round(r21.f2882e * 255.0f));
        L33:
            r7.setColorFilter(r13);
            Path r112 = this.m;
            if (r21.n != 0) goto L36;
            Path.FillType r22 = Path.FillType.WINDING;
        L37:
            r112.setFillType(r22);
            r10.drawPath(this.m, r7);
            goto L39
        L36:
            r22 = Path.FillType.EVEN_ODD;
            goto L37
        L32:
            r7.setShader(null);
            r7.setAlpha(255);
            r7.setColor(VectorDrawableCompat.applyAlpha(r110.b(), r21.f2882e));
        L39:
            if (r21.f2878a.e() == false) goto L56;
            androidx.core.content.b.d r113 = r21.f2878a;
            if (this.f2888a != null) goto L43;
            Paint r23 = new Paint(1);
            this.f2888a = r23;
            r23.setStyle(Paint.Style.STROKE);
        L43:
            Paint r24 = this.f2888a;
            if (r21.j == null) goto L47;
            r24.setStrokeJoin(r21.j);
        L47:
            if (r21.i == null) goto L49;
            r24.setStrokeCap(r21.i);
        L49:
            r24.setStrokeMiter(r21.k);
            if (r113.c() == false) goto L52;
            Shader r114 = r113.a();
            r114.setLocalMatrix(this.o);
            r24.setShader(r114);
            r24.setAlpha(Math.round(r21.f2881d * 255.0f));
        L53:
            r24.setColorFilter(r13);
            r24.setStrokeWidth(r21.f2879b * (r0 * r17));
            r10.drawPath(this.m, r24);
            return;
        L52:
            r24.setShader(null);
            r24.setAlpha(255);
            r24.setColor(VectorDrawableCompat.applyAlpha(r113.b(), r21.f2881d));
            goto L53
        L56:
            return;
        L22:
            this.p.getSegment(r3, r5, r18, true);
            goto L23
        L15:
            if (r21.g == 1.0f) goto L24;
            goto L16
        }

        private float a(Matrix r9) {
            float[] r8 = {0.0f, 1.0f, 1.0f, 0.0f};
            r9.mapVectors(r8);
            float r0 = (float) Math.hypot(r8[0], r8[1]);
            float r3 = (float) Math.hypot(r8[2], r8[3]);
            float r10 = a(r8[0], r8[1], r8[2], r8[3]);
            float r11 = Math.max(r0, r3);
            if (r11 > 0.0f) goto L5;
            return 0.0f;
        L5:
            return Math.abs(r10) / r11;
        }

        public boolean a() {
            if (this.j != null) goto L6;
            this.j = Boolean.valueOf(this.f2890c.b());
        L6:
            return this.j.booleanValue();
        }

        public boolean a(int[] r1) {
            return this.f2890c.a(r1);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r1) {
        super.applyTheme(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
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
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r1) {
        return super.getPadding(r1);
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
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r1) {
        super.setChangingConfigurations(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r1, PorterDuff.Mode r2) {
        super.setColorFilter(r1, r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r1) {
        super.setFilterBitmap(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r1, float r2) {
        super.setHotspot(r1, r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r1, int r2, int r3, int r4) {
        super.setHotspotBounds(r1, r2, r3, r4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r1) {
        return super.setState(r1);
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState r3) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = r3;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r3.mTint, r3.mTintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mDelegateDrawable == null) goto L7;
        this.mDelegateDrawable.mutate();
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

    Object getTargetByName(String r1) {
        return this.mVectorState.mVPathRenderer.k.get(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
    L8:
        VectorDrawableCompatState r0 = this.mVectorState;
        r0.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.draw(r10);
        return;
    L6:
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0) goto L9;
        return;
    L9:
        if (this.mTmpBounds.height() <= 0) goto L36;
        ColorFilter r0 = this.mColorFilter;
        if (r0 != null) goto L14;
        r0 = this.mTintFilter;
    L14:
        r10.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float r1 = Math.abs(this.mTmpFloats[0]);
        float r3 = Math.abs(this.mTmpFloats[4]);
        float r4 = Math.abs(this.mTmpFloats[1]);
        float r5 = Math.abs(this.mTmpFloats[3]);
        if (r4 == 0.0f) goto L17;
    L18:
        r1 = 1.0f;
        r3 = 1.0f;
    L19:
        int r2 = (int) (this.mTmpBounds.width() * r1);
        int r6 = (int) (this.mTmpBounds.height() * r3);
        int r7 = Math.min(2048, r2);
        int r8 = Math.min(2048, r6);
        if (r7 <= 0) goto L35;
        if (r8 <= 0) goto L37;
        int r9 = r10.save();
        r10.translate(this.mTmpBounds.left, this.mTmpBounds.top);
        if (needMirroring() == false) goto L26;
        r10.translate(this.mTmpBounds.width(), 0.0f);
        r10.scale(-1.0f, 1.0f);
    L26:
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(r7, r8);
        if (this.mAllowCaching == true) goto L30;
        this.mVectorState.updateCachedBitmap(r7, r8);
    L32:
        this.mVectorState.drawCachedBitmapWithRootAlpha(r10, r0, this.mTmpBounds);
        r10.restoreToCount(r9);
        return;
    L30:
        if (this.mVectorState.canReuseCache() == true) goto L32;
        this.mVectorState.updateCachedBitmap(r7, r8);
        this.mVectorState.updateCacheStates();
        goto L32
    L37:
        return;
    L35:
        return;
    L17:
        if (r5 == 0.0f) goto L19;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.mDelegateDrawable == null) goto L7;
        return androidx.core.graphics.drawable.a.c(this.mDelegateDrawable);
    L7:
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.mDelegateDrawable == null) goto L7;
        this.mDelegateDrawable.setAlpha(r2);
        return;
    L7:
        if (this.mVectorState.mVPathRenderer.getRootAlpha() == r2) goto L10;
        this.mVectorState.mVPathRenderer.setRootAlpha(r2);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setColorFilter(r2);
        return;
    L6:
        this.mColorFilter = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable == null) goto L7;
        return androidx.core.graphics.drawable.a.e(this.mDelegateDrawable);
    L7:
        return this.mColorFilter;
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter r1, ColorStateList r2, PorterDuff.Mode r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r2.getColorForState(getState(), 0), r3);
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTint(int r2) {
        if (this.mDelegateDrawable == null) goto L6;
        androidx.core.graphics.drawable.a.a(this.mDelegateDrawable, r2);
        return;
    L6:
        setTintList(ColorStateList.valueOf(r2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTintList(ColorStateList r3) {
        if (this.mDelegateDrawable == null) goto L6;
        androidx.core.graphics.drawable.a.a(this.mDelegateDrawable, r3);
        return;
    L6:
        VectorDrawableCompatState r0 = this.mVectorState;
        if (r0.mTint == r3) goto L10;
        r0.mTint = r3;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r3, r0.mTintMode);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.c
    public void setTintMode(PorterDuff.Mode r3) {
        if (this.mDelegateDrawable == null) goto L6;
        androidx.core.graphics.drawable.a.a(this.mDelegateDrawable, r3);
        return;
    L6:
        VectorDrawableCompatState r0 = this.mVectorState;
        if (r0.mTintMode == r3) goto L10;
        r0.mTintMode = r3;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r0.mTint, r3);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.isStateful();
    L7:
        if (super.isStateful() == true) goto L18;
        VectorDrawableCompatState r0 = this.mVectorState;
        if (r0 != null) goto L11;
    L17:
        return false;
    L11:
        if (r0.isStateful() == true) goto L18;
        if (this.mVectorState.mTint == null) goto L17;
        if (this.mVectorState.mTint.isStateful() == false) goto L17;
    L18:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r6) {
        if (this.mDelegateDrawable != null) goto L5;
        boolean r0 = false;
        VectorDrawableCompatState r1 = this.mVectorState;
        if (r1.mTint == null) goto L12;
        if (r1.mTintMode == null) goto L12;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r1.mTint, r1.mTintMode);
        invalidateSelf();
        r0 = true;
    L12:
        if (r1.isStateful() == false) goto L17;
        if (r1.onStateChanged(r6) == false) goto L17;
        invalidateSelf();
        return true;
    L17:
        return r0;
    L5:
        return this.mDelegateDrawable.setState(r6);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mDelegateDrawable != null) goto L5;
        return -3;
    L5:
        return this.mDelegateDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicWidth();
    L7:
        return (int) this.mVectorState.mVPathRenderer.f2891d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicHeight();
    L7:
        return (int) this.mVectorState.mVPathRenderer.f2892e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.mDelegateDrawable == null) goto L7;
        androidx.core.graphics.drawable.a.d(this.mDelegateDrawable);
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable == null) goto L7;
        return androidx.core.graphics.drawable.a.b(this.mDelegateDrawable);
    L7:
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        if (this.mDelegateDrawable == null) goto L6;
        androidx.core.graphics.drawable.a.a(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mVectorState.mAutoMirrored = r2;
    }

    public float getPixelSize() {
        VectorDrawableCompatState r0 = this.mVectorState;
        if (r0 != null) goto L5;
        return 1.0f;
    L5:
        if (r0.mVPathRenderer != null) goto L7;
        return 1.0f;
    L7:
        if (this.mVectorState.mVPathRenderer.f2891d != 0.0f) goto L9;
        return 1.0f;
    L9:
        if (this.mVectorState.mVPathRenderer.f2892e != 0.0f) goto L11;
        return 1.0f;
    L11:
        if (this.mVectorState.mVPathRenderer.g != 0.0f) goto L13;
        return 1.0f;
    L13:
        if (this.mVectorState.mVPathRenderer.f == 0.0f) goto L23;
        float r1 = this.mVectorState.mVPathRenderer.f2891d;
        float r2 = this.mVectorState.mVPathRenderer.f2892e;
        float r3 = this.mVectorState.mVPathRenderer.f;
        return Math.min(r3 / r1, this.mVectorState.mVPathRenderer.g / r2);
    L23:
        return 1.0f;
    }

    public static VectorDrawableCompat create(Resources r6, int r7, Resources.Theme r8) {
        if (Build.VERSION.SDK_INT < 24) goto L23;
        VectorDrawableCompat r0 = new VectorDrawableCompat();
        r0.mDelegateDrawable = h.a(r6, r7, r8);
        r0.mCachedConstantStateDelegate = new VectorDrawableDelegateState(r0.mDelegateDrawable.getConstantState());
        return r0;
    L23:
        XmlResourceParser r9 = r6.getXml(r7);     // Catch: IOException -> L17 XmlPullParserException -> L19
        AttributeSet r2 = Xml.asAttributeSet(r9);     // Catch: IOException -> L17 XmlPullParserException -> L19
    L7:
        int r3 = r9.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r3 == 2) goto L12;
        if (r3 != 1) goto L7;
    L12:
        if (r3 != 2) goto L16;
        return createFromXmlInner(r6, r9, r2, r8);
    L16:
        throw new XmlPullParserException("No start tag found");     // Catch: IOException -> L17 XmlPullParserException -> L19
    L17:
        e = move-exception;
        INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOGTAG, "parser error", e);
        return null;
    L19:
        e = move-exception;
        INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOGTAG, "parser error", e);
        return null;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        VectorDrawableCompat r0 = new VectorDrawableCompat();
        r0.inflate(r2, r6, r7, r5);
        return r0;
    }

    static int applyAlpha(int r2, float r3) {
        return (r2 & 16777215) | (((int) (Color.alpha(r2) * r3)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r3, XmlPullParser r4, AttributeSet r5) {
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.inflate(r3, r6, r7);
        return;
    L6:
        inflate(r3, r6, r7, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if (this.mDelegateDrawable == null) goto L6;
        androidx.core.graphics.drawable.a.a(this.mDelegateDrawable, r3, r7, r8, r6);
        return;
    L6:
        VectorDrawableCompatState r0 = this.mVectorState;
        r0.mVPathRenderer = new f();
        TypedArray r1 = i.a(r3, r6, r8, androidx.vectordrawable.graphics.drawable.a.f2893a);
        updateStateFromTypedArray(r1, r7, r6);
        r1.recycle();
        r0.mChangingConfigurations = getChangingConfigurations();
        r0.mCacheDirty = true;
        inflateInternal(r3, r7, r8, r6);
        this.mTintFilter = updateTintFilter(this.mTintFilter, r0.mTint, r0.mTintMode);
    }

    private static PorterDuff.Mode parseTintModeCompat(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
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

    private void updateStateFromTypedArray(TypedArray r5, XmlPullParser r6, Resources.Theme r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.aiagent.plugin");
        VectorDrawableCompatState r4 = this.mVectorState;
        f r0 = r4.mVPathRenderer;
        r4.mTintMode = parseTintModeCompat(i.a(r5, r8, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList r9 = i.a(r5, r8, r7, "tint", 1);
        if (r9 == null) goto L5;
        r4.mTint = r9;
    L5:
        r4.mAutoMirrored = i.a(r5, r8, "autoMirrored", 5, r4.mAutoMirrored);
        r0.f = i.a(r5, r8, "viewportWidth", 7, r0.f);
        r0.g = i.a(r5, r8, "viewportHeight", 8, r0.g);
        if (r0.f <= 0.0f) goto L24;
        if (r0.g <= 0.0f) goto L22;
        r0.f2891d = r5.getDimension(3, r0.f2891d);
        r0.f2892e = r5.getDimension(2, r0.f2892e);
        if (r0.f2891d <= 0.0f) goto L20;
        if (r0.f2892e <= 0.0f) goto L18;
        r0.setAlpha(i.a(r5, r8, "alpha", 4, r0.getAlpha()));
        String r10 = r5.getString(0);
        if (r10 == null) goto L25;
        r0.i = r10;
        r0.k.put(r10, r0);
        return;
    L25:
        return;
    L18:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires height > 0");
    L20:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires width > 0");
    L22:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    L24:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    private void inflateInternal(Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) {
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r12, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        VectorDrawableCompatState r10 = this.mVectorState;
        f r0 = r10.mVPathRenderer;
        ArrayDeque r2 = new ArrayDeque();
        r2.push(r0.f2890c);
        int r3 = r15.getEventType();
        int r4 = r15.getDepth() + 1;
        boolean r6 = true;
    L3:
        if (r3 == 1) goto L32;
        if (r15.getDepth() >= r4) goto L8;
        if (r3 == 3) goto L32;
    L8:
        if (r3 != 2) goto L27;
        String r5 = r15.getName();
        c r7 = (c) ZeusTransformUtils.preCheckCast(r2.peek(), c.class, "com.obric.aiagent.plugin");
        if ("path".equals(r5) == false) goto L16;
        b r8 = new b();
        r8.a(r11, r16, r14, r15);
        r7.f2884b.add(r8);
        if (r8.getPathName() == null) goto L14;
        r0.k.put(r8.getPathName(), r8);
    L14:
        r6 = false;
        r10.mChangingConfigurations = r8.o | r10.mChangingConfigurations;
    L31:
        r3 = r15.next();
        goto L3
    L16:
        if (SHAPE_CLIP_PATH.equals(r5) == false) goto L22;
        a r9 = new a();
        r9.a(r11, r16, r14, r15);
        r7.f2884b.add(r9);
        if (r9.getPathName() == null) goto L20;
        r0.k.put(r9.getPathName(), r9);
    L20:
        r10.mChangingConfigurations = r9.o | r10.mChangingConfigurations;
        goto L31
    L22:
        if (SHAPE_GROUP.equals(r5) == false) goto L31;
        c r17 = new c();
        r17.a(r11, r16, r14, r15);
        r7.f2884b.add(r17);
        r2.push(r17);
        if (r17.getGroupName() == null) goto L26;
        r0.k.put(r17.getGroupName(), r17);
    L26:
        r10.mChangingConfigurations = r17.f2887e | r10.mChangingConfigurations;
        goto L31
    L27:
        if (r3 != 3) goto L31;
        if (SHAPE_GROUP.equals(r15.getName()) == false) goto L31;
        r2.pop();
    L32:
        if (r6 == true) goto L35;
        return;
    L35:
        throw new XmlPullParserException("no path defined");
    }

    private void printGroupTree(c r5, int r6) {
        int r0 = 0;
        String r1 = "";
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L5;
        r1 = r1 + "    ";
        r2 = r2 + 1;
        goto L3
    L5:
        INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(LOGTAG, r1 + "current group is :" + r5.getGroupName() + " rotation is " + r5.f2885c);
        INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(LOGTAG, r1 + "matrix is :" + r5.getLocalMatrix().toString());
    L7:
        if (r0 >= r5.f2884b.size()) goto L13;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r5.f2884b.get(r0), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L11;
        printGroupTree((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), r6 + 1);
    L12:
        r0 = r0 + 1;
        goto L7
    L11:
        ((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a(r6 + 1);
        goto L12
    }

    void setAllowCaching(boolean r1) {
        this.mAllowCaching = r1;
    }

    private boolean needMirroring() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if (isAutoMirrored() == true) goto L7;
        return false;
    L7:
        if (androidx.core.graphics.drawable.a.i(this) == 1) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setBounds(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) goto L5;
        int r0 = super.getChangingConfigurations();
        return this.mVectorState.getChangingConfigurations() | r0;
    L5:
        return this.mDelegateDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.invalidateSelf();
        return;
    L6:
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.scheduleSelf(r5, r4);
        return;
    L6:
        super.scheduleSelf(r5, r4);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.setVisible(r2, r3);
    L7:
        return super.setVisible(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.unscheduleSelf(r4);
        return;
    L6:
        super.unscheduleSelf(r4);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_vectordrawable_graphics_drawable_VectorDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
