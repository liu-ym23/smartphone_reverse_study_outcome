package com.caverock.androidsvg;

import A5.a;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.stepos.ailauncher.common.memory.e;
import com.zyql.ai.selector.config.PictureConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* loaded from: classes.dex */
class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures;
    private Canvas canvas;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    private RendererState state;
    private Stack<RendererState> stateStack;

    /* renamed from: com.caverock.androidsvg.SVGAndroidRenderer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin;

        static {
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        public MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            this.startArc = true;
            this.normalCubic = false;
            MarkerVector markerVector = this.lastPos;
            SVGAndroidRenderer.arcTo(markerVector.f19294x, markerVector.f19295y, f10, f11, f12, z10, z11, f13, f14, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f10, float f11, float f12, float f13, float f14, float f15) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f10, f11);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f14, f15, f14 - f12, f15 - f13);
            this.closepathReAdjustPending = false;
        }

        public List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f10, float f11) {
            this.lastPos.add(f10, f11);
            this.markers.add(this.lastPos);
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            MarkerVector markerVector = this.lastPos;
            this.lastPos = sVGAndroidRenderer.new MarkerVector(f10, f11, f10 - markerVector.f19294x, f11 - markerVector.f19295y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f10, float f11) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f10;
            this.startY = f11;
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f10, f11, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f10, float f11, float f12, float f13) {
            this.lastPos.add(f10, f11);
            this.markers.add(this.lastPos);
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f12, f13, f12 - f10, f13 - f11);
            this.closepathReAdjustPending = false;
        }
    }

    public class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        public PathConverter(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f10, f11, f12, z10, z11, f13, f14, this);
            this.lastX = f13;
            this.lastY = f14;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f10, float f11, float f12, float f13, float f14, float f15) {
            this.path.cubicTo(f10, f11, f12, f13, f14, f15);
            this.lastX = f14;
            this.lastY = f15;
        }

        public Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f10, float f11) {
            this.path.lineTo(f10, f11);
            this.lastX = f10;
            this.lastY = f11;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f10, float f11) {
            this.path.moveTo(f10, f11);
            this.lastX = f10;
            this.lastY = f11;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f10, float f11, float f12, float f13) {
            this.path.quadTo(f10, f11, f12, f13);
            this.lastX = f12;
            this.lastY = f13;
        }
    }

    public class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        public PathTextDrawer(Path path, float f10, float f11) {
            super(f10, f11);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            String str2;
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    str2 = str;
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str2, this.path, this.f19296x, this.f19297y, SVGAndroidRenderer.this.state.fillPaint);
                } else {
                    str2 = str;
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str2, this.path, this.f19296x, this.f19297y, SVGAndroidRenderer.this.state.strokePaint);
                }
            } else {
                str2 = str;
            }
            this.f19296x += SVGAndroidRenderer.this.state.fillPaint.measureText(str2);
        }
    }

    public class PlainTextDrawer extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        float f19296x;

        /* renamed from: y, reason: collision with root package name */
        float f19297y;

        public PlainTextDrawer(float f10, float f11) {
            super(SVGAndroidRenderer.this, null);
            this.f19296x = f10;
            this.f19297y = f11;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f19296x, this.f19297y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f19296x, this.f19297y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f19296x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    public class PlainTextToPath extends TextProcessor {
        Path textAsPath;

        /* renamed from: x, reason: collision with root package name */
        float f19298x;

        /* renamed from: y, reason: collision with root package name */
        float f19299y;

        public PlainTextToPath(float f10, float f11, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.f19298x = f10;
            this.f19299y = f11;
            this.textAsPath = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            String str2;
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                str2 = str;
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str2, 0, str.length(), this.f19298x, this.f19299y, path);
                this.textAsPath.addPath(path);
            } else {
                str2 = str;
            }
            this.f19298x += SVGAndroidRenderer.this.state.fillPaint.measureText(str2);
        }
    }

    public class TextBoundsCalculator extends TextProcessor {
        RectF bbox;

        /* renamed from: x, reason: collision with root package name */
        float f19300x;

        /* renamed from: y, reason: collision with root package name */
        float f19301y;

        public TextBoundsCalculator(float f10, float f11) {
            super(SVGAndroidRenderer.this, null);
            this.bbox = new RectF();
            this.f19300x = f10;
            this.f19301y = f11;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject svgObjectResolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) svgObjectResolveIRI;
            Path path2 = SVGAndroidRenderer.this.new PathConverter(path.f19277d).getPath();
            Matrix matrix = path.transform;
            if (matrix != null) {
                path2.transform(matrix);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f19300x, this.f19301y);
                this.bbox.union(rectF);
            }
            this.f19300x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    public abstract class TextProcessor {
        private TextProcessor() {
        }

        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        public /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public SVGAndroidRenderer(Canvas canvas, float f10) {
        this.canvas = canvas;
        this.dpi = f10;
    }

    private void addObjectToClip(SVG.SvgObject svgObject, boolean z10, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVG.Use) {
                if (z10) {
                    addObjectToClip((SVG.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVG.Path) {
                addObjectToClip((SVG.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.Text) {
                addObjectToClip((SVG.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.GraphicsElement) {
                addObjectToClip((SVG.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.toString());
            }
            clipStatePop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f10, float f11, float f12, float f13, float f14, boolean z10, boolean z11, float f15, float f16, SVG.PathInterface pathInterface) {
        if (f10 == f15 && f11 == f16) {
            return;
        }
        if (f12 == 0.0f || f13 == 0.0f) {
            pathInterface.lineTo(f15, f16);
            return;
        }
        float fAbs = Math.abs(f12);
        float fAbs2 = Math.abs(f13);
        double radians = Math.toRadians(f14 % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d10 = (f10 - f15) / 2.0d;
        double d11 = (f11 - f16) / 2.0d;
        double d12 = (dCos * d10) + (dSin * d11);
        double d13 = ((-dSin) * d10) + (dCos * d11);
        double d14 = fAbs * fAbs;
        double d15 = fAbs2 * fAbs2;
        double d16 = d12 * d12;
        double d17 = d13 * d13;
        double d18 = (d16 / d14) + (d17 / d15);
        if (d18 > 0.99999d) {
            double dSqrt = Math.sqrt(d18) * 1.00001d;
            fAbs = (float) (fAbs * dSqrt);
            fAbs2 = (float) (dSqrt * fAbs2);
            d14 = fAbs * fAbs;
            d15 = fAbs2 * fAbs2;
        }
        double d19 = z10 == z11 ? -1.0d : 1.0d;
        double d20 = d14 * d15;
        double d21 = d14 * d17;
        double d22 = d15 * d16;
        double d23 = ((d20 - d21) - d22) / (d21 + d22);
        if (d23 < 0.0d) {
            d23 = 0.0d;
        }
        double dSqrt2 = d19 * Math.sqrt(d23);
        double d24 = fAbs;
        double d25 = fAbs2;
        double d26 = ((d24 * d13) / d25) * dSqrt2;
        double d27 = (-((d25 * d12) / d24)) * dSqrt2;
        double d28 = ((f10 + f15) / 2.0d) + ((dCos * d26) - (dSin * d27));
        double d29 = ((f11 + f16) / 2.0d) + (dSin * d26) + (dCos * d27);
        double d30 = (d12 - d26) / d24;
        double d31 = (d13 - d27) / d25;
        double d32 = ((-d12) - d26) / d24;
        double d33 = ((-d13) - d27) / d25;
        double d34 = (d30 * d30) + (d31 * d31);
        double dAcos = (d31 < 0.0d ? -1.0d : 1.0d) * Math.acos(d30 / Math.sqrt(d34));
        double dCheckedArcCos = ((d30 * d33) - (d31 * d32) < 0.0d ? -1.0d : 1.0d) * checkedArcCos(((d30 * d32) + (d31 * d33)) / Math.sqrt(d34 * ((d32 * d32) + (d33 * d33))));
        if (!z11 && dCheckedArcCos > 0.0d) {
            dCheckedArcCos -= 6.283185307179586d;
        } else if (z11 && dCheckedArcCos < 0.0d) {
            dCheckedArcCos += 6.283185307179586d;
        }
        float[] fArrArcToBeziers = arcToBeziers(dAcos % 6.283185307179586d, dCheckedArcCos % 6.283185307179586d);
        Matrix matrix = new Matrix();
        matrix.postScale(fAbs, fAbs2);
        matrix.postRotate(f14);
        matrix.postTranslate((float) d28, (float) d29);
        matrix.mapPoints(fArrArcToBeziers);
        fArrArcToBeziers[fArrArcToBeziers.length - 2] = f15;
        fArrArcToBeziers[fArrArcToBeziers.length - 1] = f16;
        for (int i10 = 0; i10 < fArrArcToBeziers.length; i10 += 6) {
            pathInterface.cubicTo(fArrArcToBeziers[i10], fArrArcToBeziers[i10 + 1], fArrArcToBeziers[i10 + 2], fArrArcToBeziers[i10 + 3], fArrArcToBeziers[i10 + 4], fArrArcToBeziers[i10 + 5]);
        }
    }

    private static float[] arcToBeziers(double d10, double d11) {
        int iCeil = (int) Math.ceil((Math.abs(d11) * 2.0d) / 3.141592653589793d);
        double d12 = d11 / iCeil;
        double d13 = d12 / 2.0d;
        double dSin = (Math.sin(d13) * 1.3333333333333333d) / (Math.cos(d13) + 1.0d);
        float[] fArr = new float[iCeil * 6];
        int i10 = 0;
        int i11 = 0;
        while (i10 < iCeil) {
            double d14 = d10 + (i10 * d12);
            double dCos = Math.cos(d14);
            double dSin2 = Math.sin(d14);
            float[] fArr2 = fArr;
            fArr2[i11] = (float) (dCos - (dSin * dSin2));
            fArr2[i11 + 1] = (float) (dSin2 + (dCos * dSin));
            double d15 = d14 + d12;
            double dCos2 = Math.cos(d15);
            double dSin3 = Math.sin(d15);
            fArr2[i11 + 2] = (float) ((dSin * dSin3) + dCos2);
            fArr2[i11 + 3] = (float) (dSin3 - (dSin * dCos2));
            int i12 = i11 + 5;
            fArr2[i11 + 4] = (float) dCos2;
            i11 += 6;
            fArr2[i12] = (float) dSin3;
            i10++;
            fArr = fArr2;
            iCeil = iCeil;
        }
        return fArr;
    }

    @TargetApi(19)
    private Path calculateClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathObjectToPath;
        SVG.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (svgObjectResolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) svgObjectResolveIRI;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        Boolean bool = clipPath.clipPathUnitsAreUser;
        boolean z10 = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z10) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = clipPath.transform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVG.SvgElement) && (pathObjectToPath = objectToPath((SVG.SvgElement) svgObject, true)) != null) {
                path.op(pathObjectToPath, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path pathCalculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (pathCalculateClipPath != null) {
                path.op(pathCalculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = this.stateStack.pop();
        return path;
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        SVG.Length length = line.f19271x1;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = line.f19273y1;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = line.f19272x2;
        float fFloatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
        SVG.Length length4 = line.f19274y2;
        float fFloatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f10 = fFloatValueX2 - fFloatValueX;
        float f11 = fFloatValueY2 - fFloatValueY;
        arrayList.add(new MarkerVector(fFloatValueX, fFloatValueY, f10, f11));
        arrayList.add(new MarkerVector(fFloatValueX2, fFloatValueY2, f10, f11));
        return arrayList;
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.f19302x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r11 != 8) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Matrix calculateViewBoxTransform(com.caverock.androidsvg.SVG.Box r9, com.caverock.androidsvg.SVG.Box r10, com.caverock.androidsvg.PreserveAspectRatio r11) {
        /*
            r8 = this;
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            if (r11 == 0) goto L9d
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r0 = r11.getAlignment()
            if (r0 != 0) goto Lf
            goto L9d
        Lf:
            float r0 = r9.width
            float r1 = r10.width
            float r0 = r0 / r1
            float r1 = r9.height
            float r2 = r10.height
            float r1 = r1 / r2
            float r2 = r10.minX
            float r2 = -r2
            float r3 = r10.minY
            float r3 = -r3
            com.caverock.androidsvg.PreserveAspectRatio r4 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L35
            float r10 = r9.minX
            float r9 = r9.minY
            r8.preTranslate(r10, r9)
            r8.preScale(r0, r1)
            r8.preTranslate(r2, r3)
            return r8
        L35:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r4 = r11.getScale()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r4 != r5) goto L42
            float r0 = java.lang.Math.max(r0, r1)
            goto L46
        L42:
            float r0 = java.lang.Math.min(r0, r1)
        L46:
            float r1 = r9.width
            float r1 = r1 / r0
            float r4 = r9.height
            float r4 = r4 / r0
            int[] r5 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r6 = r11.getAlignment()
            int r6 = r6.ordinal()
            r6 = r5[r6]
            r7 = 1073741824(0x40000000, float:2.0)
            switch(r6) {
                case 1: goto L63;
                case 2: goto L63;
                case 3: goto L63;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L68
        L5e:
            float r6 = r10.width
            float r6 = r6 - r1
        L61:
            float r2 = r2 - r6
            goto L68
        L63:
            float r6 = r10.width
            float r6 = r6 - r1
            float r6 = r6 / r7
            goto L61
        L68:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r11 = r11.getAlignment()
            int r11 = r11.ordinal()
            r11 = r5[r11]
            r1 = 2
            if (r11 == r1) goto L8b
            r1 = 3
            if (r11 == r1) goto L86
            r1 = 5
            if (r11 == r1) goto L8b
            r1 = 6
            if (r11 == r1) goto L86
            r1 = 7
            if (r11 == r1) goto L8b
            r1 = 8
            if (r11 == r1) goto L86
            goto L90
        L86:
            float r10 = r10.height
            float r10 = r10 - r4
        L89:
            float r3 = r3 - r10
            goto L90
        L8b:
            float r10 = r10.height
            float r10 = r10 - r4
            float r10 = r10 / r7
            goto L89
        L90:
            float r10 = r9.minX
            float r9 = r9.minY
            r8.preTranslate(r10, r9)
            r8.preScale(r0, r0)
            r8.preTranslate(r2, r3)
        L9d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.calculateViewBoxTransform(com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForClipPath_OldStyle(SVG.SvgElement svgElement, SVG.Box box) {
        SVG.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (svgObjectResolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) svgObjectResolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = clipPath.clipPathUnitsAreUser;
        boolean z10 = bool == null || bool.booleanValue();
        if ((svgElement instanceof SVG.Group) && !z10) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getNodeName());
            return;
        }
        clipStatePush();
        if (!z10) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
            this.canvas.concat(matrix);
        }
        Matrix matrix2 = clipPath.transform;
        if (matrix2 != null) {
            this.canvas.concat(matrix2);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path path = new Path();
        Iterator<SVG.SvgObject> it = clipPath.children.iterator();
        while (it.hasNext()) {
            addObjectToClip(it.next(), true, path, new Matrix());
        }
        this.canvas.clipPath(path);
        clipStatePop();
    }

    private void checkForGradientsAndPatterns(SVG.SvgElement svgElement) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.state.style.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) svgPaint2);
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int iIndexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (iIndexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e10) {
            Log.e(TAG, "Could not decode bad Data URL", e10);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Typeface checkGenericFont(java.lang.String r5, java.lang.Integer r6, com.caverock.androidsvg.SVG.Style.FontStyle r7) {
        /*
            r4 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r4 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r0 = 0
            r1 = 1
            if (r7 != r4) goto L8
            r4 = r1
            goto L9
        L8:
            r4 = r0
        L9:
            int r6 = r6.intValue()
            r7 = 500(0x1f4, float:7.0E-43)
            r2 = 2
            r3 = 3
            if (r6 <= r7) goto L19
            if (r4 == 0) goto L17
            r4 = r3
            goto L1e
        L17:
            r4 = r1
            goto L1e
        L19:
            if (r4 == 0) goto L1d
            r4 = r2
            goto L1e
        L1d:
            r4 = r0
        L1e:
            r5.getClass()
            int r6 = r5.hashCode()
            r7 = -1
            switch(r6) {
                case -1536685117: goto L57;
                case -1431958525: goto L4c;
                case -1081737434: goto L41;
                case 109326717: goto L36;
                case 1126973893: goto L2b;
                default: goto L29;
            }
        L29:
            r0 = r7
            goto L60
        L2b:
            java.lang.String r6 = "cursive"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L34
            goto L29
        L34:
            r0 = 4
            goto L60
        L36:
            java.lang.String r6 = "serif"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L3f
            goto L29
        L3f:
            r0 = r3
            goto L60
        L41:
            java.lang.String r6 = "fantasy"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L4a
            goto L29
        L4a:
            r0 = r2
            goto L60
        L4c:
            java.lang.String r6 = "monospace"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L55
            goto L29
        L55:
            r0 = r1
            goto L60
        L57:
            java.lang.String r6 = "sans-serif"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L60
            goto L29
        L60:
            switch(r0) {
                case 0: goto L81;
                case 1: goto L7a;
                case 2: goto L73;
                case 3: goto L6c;
                case 4: goto L65;
                default: goto L63;
            }
        L63:
            r4 = 0
            return r4
        L65:
            android.graphics.Typeface r5 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r5, r4)
            return r4
        L6c:
            android.graphics.Typeface r5 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r5, r4)
            return r4
        L73:
            android.graphics.Typeface r5 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r5, r4)
            return r4
        L7a:
            android.graphics.Typeface r5 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r5, r4)
            return r4
        L81:
            android.graphics.Typeface r5 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.checkGenericFont(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        Boolean bool;
        if ((svgObject instanceof SVG.SvgElementBase) && (bool = ((SVG.SvgElementBase) svgObject).spacePreserve) != null) {
            this.state.spacePreserve = bool.booleanValue();
        }
    }

    private static double checkedArcCos(double d10) {
        if (d10 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d10 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d10);
    }

    private static int clamp255(float f10) {
        int i10 = (int) (f10 * 256.0f);
        if (i10 < 0) {
            return 0;
        }
        if (i10 > 255) {
            return 255;
        }
        return i10;
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void clipStatePush() {
        CanvasLegacy.save(this.canvas, CanvasLegacy.MATRIX_SAVE_FLAG);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private static int colourWithOpacity(int i10, float f10) {
        int i11 = 255;
        int iRound = Math.round(((i10 >> 24) & 255) * f10);
        if (iRound < 0) {
            i11 = 0;
        } else if (iRound <= 255) {
            i11 = iRound;
        }
        return (i10 & 16777215) | (i11 << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private void decodePaintReference(boolean z10, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(paintReference.href);
        if (svgObjectResolveIRI == null) {
            error("%s reference '%s' not found", z10 ? "Fill" : "Stroke", paintReference.href);
            SVG.SvgPaint svgPaint = paintReference.fallback;
            if (svgPaint != null) {
                setPaintColour(this.state, z10, svgPaint);
                return;
            } else if (z10) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (svgObjectResolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradient(z10, box, (SVG.SvgLinearGradient) svgObjectResolveIRI);
        } else if (svgObjectResolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradient(z10, box, (SVG.SvgRadialGradient) svgObjectResolveIRI);
        } else if (svgObjectResolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z10, (SVG.SolidColor) svgObjectResolveIRI);
        }
    }

    private boolean display() {
        Boolean bool = this.state.style.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(((SVG.PaintReference) svgPaint).href);
            if (svgObjectResolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) svgObjectResolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        RendererState rendererState = this.state;
        if (rendererState.style.vectorEffect != SVG.Style.VectorEffect.NonScalingStroke) {
            this.canvas.drawPath(path, rendererState.strokePaint);
            return;
        }
        Matrix matrix = this.canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        this.canvas.setMatrix(new Matrix());
        Shader shader = this.state.strokePaint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        this.canvas.drawPath(path2, this.state.strokePaint);
        this.canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    private float dotProduct(float f10, float f11, float f12, float f13) {
        return (f10 * f12) + (f11 * f13);
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator<SVG.SvgObject> it = textContainer.children.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                SVG.SvgObject next = it.next();
                if (next instanceof SVG.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) next).text, z10, !it.hasNext()));
                } else {
                    processTextChild(next, textProcessor);
                }
                z10 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb2) {
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) next, sb2);
            } else if (next instanceof SVG.TextSequence) {
                sb2.append(textXMLSpaceTransform(((SVG.TextSequence) next).text, z10, !it.hasNext()));
            }
            z10 = false;
        }
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject svgObjectResolveIRI = gradientElement.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) svgObjectResolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) svgObjectResolveIRI);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) svgObjectResolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = gradientElement2.href;
        if (str2 != null) {
            fillInChainedGradientFields(gradientElement, str2);
        }
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject svgObjectResolveIRI = pattern.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) svgObjectResolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.f19278x == null) {
            pattern.f19278x = pattern2.f19278x;
        }
        if (pattern.f19279y == null) {
            pattern.f19279y = pattern2.f19279y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        String str2 = pattern2.href;
        if (str2 != null) {
            fillInChainedPatternFields(pattern, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fillWithPattern(com.caverock.androidsvg.SVG.SvgElement r21, android.graphics.Path r22, com.caverock.androidsvg.SVG.Pattern r23) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.fillWithPattern(com.caverock.androidsvg.SVG$SvgElement, android.graphics.Path, com.caverock.androidsvg.SVG$Pattern):void");
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.state.style;
        if (style.direction == SVG.Style.TextDirection.LTR || (textAnchor = style.textAnchor) == SVG.Style.TextAnchor.Middle) {
            return style.textAnchor;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
    }

    private Path.FillType getClipRuleFromState() {
        SVG.Style.FillRule fillRule = this.state.style.clipRule;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private Path.FillType getFillTypeFromState() {
        SVG.Style.FillRule fillRule = this.state.style.fillRule;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        HashSet<String> hashSet = new HashSet<>();
        supportedFeatures = hashSet;
        hashSet.add("Structure");
        supportedFeatures.add("BasicStructure");
        supportedFeatures.add("ConditionalProcessing");
        supportedFeatures.add("Image");
        supportedFeatures.add("Style");
        supportedFeatures.add("ViewportAttribute");
        supportedFeatures.add("Shape");
        supportedFeatures.add("BasicText");
        supportedFeatures.add("PaintAttribute");
        supportedFeatures.add("BasicPaintAttribute");
        supportedFeatures.add("OpacityAttribute");
        supportedFeatures.add("BasicGraphicsAttribute");
        supportedFeatures.add("Marker");
        supportedFeatures.add("Gradient");
        supportedFeatures.add("Pattern");
        supportedFeatures.add("Clip");
        supportedFeatures.add("BasicClip");
        supportedFeatures.add("Mask");
        supportedFeatures.add("View");
    }

    private boolean isSpecified(SVG.Style style, long j10) {
        return (style.specifiedFlags & j10) != 0;
    }

    private void makeLinearGradient(boolean z10, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float fFloatValue;
        float f10;
        float fFloatValue2;
        float f11;
        String str = svgLinearGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgLinearGradient, str);
        }
        Boolean bool = svgLinearGradient.gradientUnitsAreUser;
        int i10 = 0;
        boolean z11 = bool != null && bool.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z10 ? rendererState.fillPaint : rendererState.strokePaint;
        if (z11) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            SVG.Length length = svgLinearGradient.f19284x1;
            float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = svgLinearGradient.f19286y1;
            fFloatValue = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = svgLinearGradient.f19285x2;
            float fFloatValueX2 = length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width;
            SVG.Length length4 = svgLinearGradient.f19287y2;
            f11 = fFloatValueX2;
            f10 = fFloatValueX;
            fFloatValue2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = svgLinearGradient.f19284x1;
            float fFloatValue3 = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = svgLinearGradient.f19286y1;
            fFloatValue = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = svgLinearGradient.f19285x2;
            float fFloatValue4 = length7 != null ? length7.floatValue(this, 1.0f) : 1.0f;
            SVG.Length length8 = svgLinearGradient.f19287y2;
            f10 = fFloatValue3;
            fFloatValue2 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            f11 = fFloatValue4;
        }
        float f12 = fFloatValue;
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z11) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgLinearGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z10) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgLinearGradient.children.iterator();
        float f13 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            Float f14 = stop.offset;
            float fFloatValue5 = f14 != null ? f14.floatValue() : 0.0f;
            if (i10 == 0 || fFloatValue5 >= f13) {
                fArr[i10] = fFloatValue5;
                f13 = fFloatValue5;
            } else {
                fArr[i10] = f13;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i10] = colourWithOpacity(colour.colour, style.stopOpacity.floatValue());
            i10++;
            statePop();
        }
        if ((f10 == f11 && f12 == fFloatValue2) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgLinearGradient.spreadMethod;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        statePop();
        LinearGradient linearGradient = new LinearGradient(f10, f12, f11, fFloatValue2, iArr, fArr, tileMode2);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        SVG.Length length = line.f19271x1;
        float fFloatValueX = length == null ? 0.0f : length.floatValueX(this);
        SVG.Length length2 = line.f19273y1;
        float fFloatValueY = length2 == null ? 0.0f : length2.floatValueY(this);
        SVG.Length length3 = line.f19272x2;
        float fFloatValueX2 = length3 == null ? 0.0f : length3.floatValueX(this);
        SVG.Length length4 = line.f19274y2;
        float fFloatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(fFloatValueX, fFloatValueX2), Math.min(fFloatValueY, fFloatValueY2), Math.abs(fFloatValueX2 - fFloatValueX), Math.abs(fFloatValueY2 - fFloatValueY));
        }
        Path path = new Path();
        path.moveTo(fFloatValueX, fFloatValueY);
        path.lineTo(fFloatValueX2, fFloatValueY2);
        return path;
    }

    private void makeRadialGradient(boolean z10, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f10;
        float fFloatValue;
        float f11;
        String str = svgRadialGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgRadialGradient, str);
        }
        Boolean bool = svgRadialGradient.gradientUnitsAreUser;
        int i10 = 0;
        boolean z11 = bool != null && bool.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z10 ? rendererState.fillPaint : rendererState.strokePaint;
        if (z11) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = svgRadialGradient.cx;
            float fFloatValueX = length2 != null ? length2.floatValueX(this) : length.floatValueX(this);
            SVG.Length length3 = svgRadialGradient.cy;
            float fFloatValueY = length3 != null ? length3.floatValueY(this) : length.floatValueY(this);
            SVG.Length length4 = svgRadialGradient.f19288r;
            fFloatValue = length4 != null ? length4.floatValue(this) : length.floatValue(this);
            f10 = fFloatValueX;
            f11 = fFloatValueY;
        } else {
            SVG.Length length5 = svgRadialGradient.cx;
            float fFloatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length6 = svgRadialGradient.cy;
            float fFloatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length7 = svgRadialGradient.f19288r;
            f10 = fFloatValue2;
            fFloatValue = length7 != null ? length7.floatValue(this, 1.0f) : 0.5f;
            f11 = fFloatValue3;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z11) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgRadialGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z10) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgRadialGradient.children.iterator();
        float f12 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            Float f13 = stop.offset;
            float fFloatValue4 = f13 != null ? f13.floatValue() : 0.0f;
            if (i10 == 0 || fFloatValue4 >= f12) {
                fArr[i10] = fFloatValue4;
                f12 = fFloatValue4;
            } else {
                fArr[i10] = f12;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i10] = colourWithOpacity(colour.colour, style.stopOpacity.floatValue());
            i10++;
            statePop();
        }
        if (fFloatValue == 0.0f || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgRadialGradient.spreadMethod;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        statePop();
        RadialGradient radialGradient = new RadialGradient(f10, f11, fFloatValue, iArr, fArr, tileMode2);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private SVG.Box makeViewPort(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
        return new SVG.Box(fFloatValueX, fFloatValueY, length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width, length4 != null ? length4.floatValueY(this) : currentViewPortInUserUnits.height);
    }

    @TargetApi(19)
    private Path objectToPath(SVG.SvgElement svgElement, boolean z10) {
        Path pathMakePathAndBoundingBox;
        Path pathCalculateClipPath;
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z10) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(use.href);
            if (svgObjectResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = this.stateStack.pop();
                return null;
            }
            if (!(svgObjectResolveIRI instanceof SVG.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            }
            pathMakePathAndBoundingBox = objectToPath((SVG.SvgElement) svgObjectResolveIRI, false);
            if (pathMakePathAndBoundingBox == null) {
                return null;
            }
            if (use.boundingBox == null) {
                use.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
            }
            Matrix matrix = use.transform;
            if (matrix != null) {
                pathMakePathAndBoundingBox.transform(matrix);
            }
        } else if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                pathMakePathAndBoundingBox = new PathConverter(((SVG.Path) svgElement).f19277d).getPath();
                if (svgElement.boundingBox == null) {
                    svgElement.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
                }
            } else {
                pathMakePathAndBoundingBox = svgElement instanceof SVG.Rect ? makePathAndBoundingBox((SVG.Rect) svgElement) : svgElement instanceof SVG.Circle ? makePathAndBoundingBox((SVG.Circle) svgElement) : svgElement instanceof SVG.Ellipse ? makePathAndBoundingBox((SVG.Ellipse) svgElement) : svgElement instanceof SVG.PolyLine ? makePathAndBoundingBox((SVG.PolyLine) svgElement) : null;
            }
            if (pathMakePathAndBoundingBox == null) {
                return null;
            }
            if (graphicsElement.boundingBox == null) {
                graphicsElement.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
            }
            Matrix matrix2 = graphicsElement.transform;
            if (matrix2 != null) {
                pathMakePathAndBoundingBox.transform(matrix2);
            }
            pathMakePathAndBoundingBox.setFillType(getClipRuleFromState());
        } else {
            if (!(svgElement instanceof SVG.Text)) {
                error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
                return null;
            }
            SVG.Text text = (SVG.Text) svgElement;
            pathMakePathAndBoundingBox = makePathAndBoundingBox(text);
            if (pathMakePathAndBoundingBox == null) {
                return null;
            }
            Matrix matrix3 = text.transform;
            if (matrix3 != null) {
                pathMakePathAndBoundingBox.transform(matrix3);
            }
            pathMakePathAndBoundingBox.setFillType(getClipRuleFromState());
        }
        if (this.state.style.clipPath != null && (pathCalculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) != null) {
            pathMakePathAndBoundingBox.op(pathCalculateClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return pathMakePathAndBoundingBox;
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void popLayer(SVG.SvgElement svgElement) {
        popLayer(svgElement, svgElement.boundingBox);
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f10;
        float fFloatValueY;
        float fFloatValueX;
        SVG.Style.TextAnchor anchorPosition;
        if (textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                statePush();
                renderTextPath((SVG.TextPath) svgObject);
                statePop();
                return;
            }
            if (!(svgObject instanceof SVG.TSpan)) {
                if (svgObject instanceof SVG.TRef) {
                    statePush();
                    SVG.TRef tRef = (SVG.TRef) svgObject;
                    updateStyleForElement(this.state, tRef);
                    if (display()) {
                        checkForGradientsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                        SVG.SvgObject svgObjectResolveIRI = svgObject.document.resolveIRI(tRef.href);
                        if (svgObjectResolveIRI == null || !(svgObjectResolveIRI instanceof SVG.TextContainer)) {
                            error("Tref reference '%s' not found", tRef.href);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            extractRawText((SVG.TextContainer) svgObjectResolveIRI, sb2);
                            if (sb2.length() > 0) {
                                textProcessor.processText(sb2.toString());
                            }
                        }
                    }
                    statePop();
                    return;
                }
                return;
            }
            debug("TSpan render", new Object[0]);
            statePush();
            SVG.TSpan tSpan = (SVG.TSpan) svgObject;
            updateStyleForElement(this.state, tSpan);
            if (display()) {
                List<SVG.Length> list = tSpan.f19289x;
                boolean z10 = list != null && list.size() > 0;
                boolean z11 = textProcessor instanceof PlainTextDrawer;
                float fFloatValueY2 = 0.0f;
                if (z11) {
                    float fFloatValueX2 = !z10 ? ((PlainTextDrawer) textProcessor).f19296x : tSpan.f19289x.get(0).floatValueX(this);
                    List<SVG.Length> list2 = tSpan.f19290y;
                    fFloatValueY = (list2 == null || list2.size() == 0) ? ((PlainTextDrawer) textProcessor).f19297y : tSpan.f19290y.get(0).floatValueY(this);
                    List<SVG.Length> list3 = tSpan.dx;
                    fFloatValueX = (list3 == null || list3.size() == 0) ? 0.0f : tSpan.dx.get(0).floatValueX(this);
                    List<SVG.Length> list4 = tSpan.dy;
                    if (list4 != null && list4.size() != 0) {
                        fFloatValueY2 = tSpan.dy.get(0).floatValueY(this);
                    }
                    f10 = fFloatValueY2;
                    fFloatValueY2 = fFloatValueX2;
                } else {
                    f10 = 0.0f;
                    fFloatValueY = 0.0f;
                    fFloatValueX = 0.0f;
                }
                if (z10 && (anchorPosition = getAnchorPosition()) != SVG.Style.TextAnchor.Start) {
                    float fCalculateTextWidth = calculateTextWidth(tSpan);
                    if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                        fCalculateTextWidth /= 2.0f;
                    }
                    fFloatValueY2 -= fCalculateTextWidth;
                }
                checkForGradientsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                if (z11) {
                    PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                    plainTextDrawer.f19296x = fFloatValueY2 + fFloatValueX;
                    plainTextDrawer.f19297y = fFloatValueY + f10;
                }
                boolean zPushLayer = pushLayer();
                enumerateTextSpans(tSpan, textProcessor);
                if (zPushLayer) {
                    popLayer(tSpan);
                }
            }
            statePop();
        }
    }

    private boolean pushLayer() {
        SVG.SvgObject svgObjectResolveIRI;
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 31);
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        String str = rendererState.style.mask;
        if (str != null && ((svgObjectResolveIRI = this.document.resolveIRI(str)) == null || !(svgObjectResolveIRI instanceof SVG.Mask))) {
            error("Mask reference '%s' not found", this.state.style.mask);
            this.state.style.mask = null;
        }
        return true;
    }

    private MarkerVector realignMarkerMid(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float fDotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector2.f19294x - markerVector.f19294x, markerVector2.f19295y - markerVector.f19295y);
        if (fDotProduct == 0.0f) {
            fDotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector3.f19294x - markerVector2.f19294x, markerVector3.f19295y - markerVector2.f19295y);
        }
        if (fDotProduct > 0.0f || (fDotProduct == 0.0f && (markerVector2.dx > 0.0f || markerVector2.dy >= 0.0f))) {
            return markerVector2;
        }
        markerVector2.dx = -markerVector2.dx;
        markerVector2.dy = -markerVector2.dy;
        return markerVector2;
    }

    private void render(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVG.Svg) {
            render((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            render((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            render((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            render((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            render((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            render((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            render((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            render((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            render((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            render((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            render((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            render((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            render((SVG.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z10) {
        if (z10) {
            parentPush(svgContainer);
        }
        Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z10) {
            parentPop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r7 != 8) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void renderMarker(com.caverock.androidsvg.SVG.Marker r12, com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.renderMarker(com.caverock.androidsvg.SVG$Marker, com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector):void");
    }

    private void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        SVG.Marker marker2;
        SVG.Marker marker3;
        int size;
        SVG.Style style = this.state.style;
        String str = style.markerStart;
        if (str == null && style.markerMid == null && style.markerEnd == null) {
            return;
        }
        if (str == null) {
            marker = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI = graphicsElement.document.resolveIRI(str);
            if (svgObjectResolveIRI != null) {
                marker = (SVG.Marker) svgObjectResolveIRI;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
                marker = null;
            }
        }
        String str2 = this.state.style.markerMid;
        if (str2 == null) {
            marker2 = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI2 = graphicsElement.document.resolveIRI(str2);
            if (svgObjectResolveIRI2 != null) {
                marker2 = (SVG.Marker) svgObjectResolveIRI2;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerMid);
                marker2 = null;
            }
        }
        String str3 = this.state.style.markerEnd;
        if (str3 == null) {
            marker3 = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI3 = graphicsElement.document.resolveIRI(str3);
            if (svgObjectResolveIRI3 != null) {
                marker3 = (SVG.Marker) svgObjectResolveIRI3;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerEnd);
                marker3 = null;
            }
        }
        List<MarkerVector> markers = graphicsElement instanceof SVG.Path ? new MarkerPositionCalculator(((SVG.Path) graphicsElement).f19277d).getMarkers() : graphicsElement instanceof SVG.Line ? calculateMarkerPositions((SVG.Line) graphicsElement) : calculateMarkerPositions((SVG.PolyLine) graphicsElement);
        if (markers == null || (size = markers.size()) == 0) {
            return;
        }
        SVG.Style style2 = this.state.style;
        style2.markerEnd = null;
        style2.markerMid = null;
        style2.markerStart = null;
        if (marker != null) {
            renderMarker(marker, markers.get(0));
        }
        if (marker2 != null && markers.size() > 2) {
            MarkerVector markerVectorRealignMarkerMid = markers.get(0);
            MarkerVector markerVector = markers.get(1);
            int i10 = 1;
            while (i10 < size - 1) {
                i10++;
                MarkerVector markerVector2 = markers.get(i10);
                markerVectorRealignMarkerMid = markerVector.isAmbiguous ? realignMarkerMid(markerVectorRealignMarkerMid, markerVector, markerVector2) : markerVector;
                renderMarker(marker2, markerVectorRealignMarkerMid);
                markerVector = markerVector2;
            }
        }
        if (marker3 != null) {
            renderMarker(marker3, markers.get(size - 1));
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement, SVG.Box box) {
        float fFloatValueX;
        float fFloatValueY;
        debug("Mask render", new Object[0]);
        Boolean bool = mask.maskUnitsAreUser;
        if (bool == null || !bool.booleanValue()) {
            SVG.Length length = mask.width;
            float fFloatValue = length != null ? length.floatValue(this, 1.0f) : 1.2f;
            SVG.Length length2 = mask.height;
            float fFloatValue2 = length2 != null ? length2.floatValue(this, 1.0f) : 1.2f;
            fFloatValueX = fFloatValue * box.width;
            fFloatValueY = fFloatValue2 * box.height;
        } else {
            SVG.Length length3 = mask.width;
            fFloatValueX = length3 != null ? length3.floatValueX(this) : box.width;
            SVG.Length length4 = mask.height;
            fFloatValueY = length4 != null ? length4.floatValueY(this) : box.height;
        }
        if (fFloatValueX == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        statePush();
        RendererState rendererStateFindInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = rendererStateFindInheritFromAncestorState;
        rendererStateFindInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        boolean zPushLayer = pushLayer();
        this.canvas.save();
        Boolean bool2 = mask.maskContentUnitsAreUser;
        if (bool2 != null && !bool2.booleanValue()) {
            this.canvas.translate(box.minX, box.minY);
            this.canvas.scale(box.width, box.height);
        }
        renderChildren(mask, false);
        this.canvas.restore();
        if (zPushLayer) {
            popLayer(svgElement, box);
        }
        statePop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch r82) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = SVG.getFileResolver();
        for (SVG.SvgObject svgObject : r82.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (requiredFeatures.isEmpty() || !supportedFeatures.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        if (!requiredFormats.isEmpty() && fileResolver != null) {
                            Iterator<String> it = requiredFormats.iterator();
                            while (it.hasNext()) {
                                if (!fileResolver.isFormatSupported(it.next())) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> requiredFonts = svgConditional.getRequiredFonts();
                    if (requiredFonts != null) {
                        if (!requiredFonts.isEmpty() && fileResolver != null) {
                            Iterator<String> it2 = requiredFonts.iterator();
                            while (it2.hasNext()) {
                                if (fileResolver.resolveFont(it2.next(), this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    render(svgObject);
                    return;
                }
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            SVG.SvgObject svgObjectResolveIRI = textPath.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVG.Path path = (SVG.Path) svgObjectResolveIRI;
            Path path2 = new PathConverter(path.f19277d).getPath();
            Matrix matrix = path.transform;
            if (matrix != null) {
                path2.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(path2, false);
            SVG.Length length = textPath.startOffset;
            float fFloatValue = length != null ? length.floatValue(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValue -= fCalculateTextWidth;
            }
            checkForGradientsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, fFloatValue, 0.0f));
            if (zPushLayer) {
                popLayer(textPath);
            }
        }
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null;
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        RendererState rendererState = this.state;
        rendererState.viewPort = null;
        rendererState.spacePreserve = false;
        this.stateStack.push(new RendererState(rendererState));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    private void setClipRect(float f10, float f11, float f12, float f13) {
        float fFloatValueX = f12 + f10;
        float fFloatValueY = f13 + f11;
        SVG.CSSClipRect cSSClipRect = this.state.style.clip;
        if (cSSClipRect != null) {
            f10 += cSSClipRect.left.floatValueX(this);
            f11 += this.state.style.clip.top.floatValueY(this);
            fFloatValueX -= this.state.style.clip.right.floatValueX(this);
            fFloatValueY -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f10, f11, fFloatValueX, fFloatValueY);
    }

    private void setPaintColour(RendererState rendererState, boolean z10, SVG.SvgPaint svgPaint) {
        int i10;
        SVG.Style style = rendererState.style;
        float fFloatValue = (z10 ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i10 = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i10 = rendererState.style.color.colour;
        }
        int iColourWithOpacity = colourWithOpacity(i10, fFloatValue);
        if (z10) {
            rendererState.fillPaint.setColor(iColourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(iColourWithOpacity);
        }
    }

    private void setSolidColor(boolean z10, SVG.SolidColor solidColor) {
        if (z10) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                RendererState rendererState = this.state;
                SVG.Style style = rendererState.style;
                SVG.SvgPaint svgPaint = solidColor.baseStyle.solidColor;
                style.fill = svgPaint;
                rendererState.hasFill = svgPaint != null;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState2 = this.state;
                setPaintColour(rendererState2, z10, rendererState2.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            RendererState rendererState3 = this.state;
            SVG.Style style2 = rendererState3.style;
            SVG.SvgPaint svgPaint2 = solidColor.baseStyle.solidColor;
            style2.stroke = svgPaint2;
            rendererState3.hasStroke = svgPaint2 != null;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState4 = this.state;
            setPaintColour(rendererState4, z10, rendererState4.style.stroke);
        }
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private String textXMLSpaceTransform(String str, boolean z10, boolean z11) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String strReplaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z10) {
            strReplaceAll = strReplaceAll.replaceAll("^\\s+", "");
        }
        if (z11) {
            strReplaceAll = strReplaceAll.replaceAll("\\s+$", "");
        }
        return strReplaceAll.replaceAll("\\s{2,}", " ");
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            SVG.Box box = svgElement.boundingBox;
            float f10 = box.minX;
            float f11 = box.minY;
            float fMaxX = box.maxX();
            SVG.Box box2 = svgElement.boundingBox;
            float f12 = box2.minY;
            float fMaxX2 = box2.maxX();
            float fMaxY = svgElement.boundingBox.maxY();
            SVG.Box box3 = svgElement.boundingBox;
            float[] fArr = {f10, f11, fMaxX, f12, fMaxX2, fMaxY, box3.minX, box3.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f13 = fArr[0];
            float f14 = fArr[1];
            RectF rectF = new RectF(f13, f14, f13, f14);
            for (int i10 = 2; i10 <= 6; i10 += 2) {
                float f15 = fArr[i10];
                if (f15 < rectF.left) {
                    rectF.left = f15;
                }
                if (f15 > rectF.right) {
                    rectF.right = f15;
                }
                float f16 = fArr[i10 + 1];
                if (f16 < rectF.top) {
                    rectF.top = f16;
                }
                if (f16 > rectF.bottom) {
                    rectF.bottom = f16;
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
            SVG.Box box4 = svgElement2.boundingBox;
            if (box4 == null) {
                svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box4.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        if (isSpecified(style, 4096L)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            rendererState.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            rendererState.hasFill = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            rendererState.hasStroke = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            SVG.Style style2 = rendererState.style;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            rendererState.strokePaint.setStrokeWidth(length.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i10 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[style.strokeLineCap.ordinal()];
            if (i10 == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i10 == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i10 == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i11 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[style.strokeLineJoin.ordinal()];
            if (i11 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i11 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i11 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typefaceCheckGenericFont = null;
        if (isSpecified(style, 1536L)) {
            SVG.Length[] lengthArr = rendererState.style.strokeDashArray;
            if (lengthArr == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i12 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i12];
                float f10 = 0.0f;
                for (int i13 = 0; i13 < i12; i13++) {
                    float fFloatValue = rendererState.style.strokeDashArray[i13 % length2].floatValue(this);
                    fArr[i13] = fFloatValue;
                    f10 += fFloatValue;
                }
                if (f10 == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float fFloatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (fFloatValue2 < 0.0f) {
                        fFloatValue2 = (fFloatValue2 % f10) + f10;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, fFloatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, 8192L)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() != 1 || rendererState.style.fontWeight.intValue() >= 900) {
                rendererState.style.fontWeight = style.fontWeight;
            } else {
                SVG.Style style4 = rendererState.style;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            }
        }
        if (isSpecified(style, 65536L)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            if (rendererState.style.fontFamily != null && this.document != null) {
                SVGExternalFileResolver fileResolver = SVG.getFileResolver();
                for (String str : rendererState.style.fontFamily) {
                    SVG.Style style5 = rendererState.style;
                    Typeface typefaceCheckGenericFont2 = checkGenericFont(str, style5.fontWeight, style5.fontStyle);
                    typefaceCheckGenericFont = (typefaceCheckGenericFont2 != null || fileResolver == null) ? typefaceCheckGenericFont2 : fileResolver.resolveFont(str, rendererState.style.fontWeight.intValue(), String.valueOf(rendererState.style.fontStyle));
                    if (typefaceCheckGenericFont != null) {
                        break;
                    }
                }
            }
            if (typefaceCheckGenericFont == null) {
                SVG.Style style6 = rendererState.style;
                typefaceCheckGenericFont = checkGenericFont(DEFAULT_FONT_FAMILY, style6.fontWeight, style6.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typefaceCheckGenericFont);
            rendererState.strokePaint.setTypeface(typefaceCheckGenericFont);
        }
        if (isSpecified(style, 131072L)) {
            rendererState.style.textDecoration = style.textDecoration;
            Paint paint = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            rendererState.strokePaint.setStrikeThruText(style.textDecoration == textDecoration2);
            rendererState.strokePaint.setUnderlineText(style.textDecoration == textDecoration4);
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, a.MIN_USABLE_BYTES)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, PictureConfig.MB)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, e.NATIVE_HIGH_BYTES)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        SVG.Style style = svgElementBase.baseStyle;
        if (style != null) {
            updateStyle(rendererState, style);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        SVG.Style style2 = svgElementBase.style;
        if (style2 != null) {
            updateStyle(rendererState, style2);
        }
    }

    private void viewportFill() {
        int iColourWithOpacity;
        SVG.Style style = this.state.style;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            iColourWithOpacity = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            iColourWithOpacity = style.color.colour;
        }
        Float f10 = style.viewportFillOpacity;
        if (f10 != null) {
            iColourWithOpacity = colourWithOpacity(iColourWithOpacity, f10.floatValue());
        }
        this.canvas.drawColor(iColourWithOpacity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        Boolean bool = this.state.style.visibility;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    public float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    public float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    public SVG.Box getCurrentViewPortInUserUnits() {
        RendererState rendererState = this.state;
        SVG.Box box = rendererState.viewBox;
        return box != null ? box : rendererState.viewPort;
    }

    public float getDPI() {
        return this.dpi;
    }

    public void renderDocument(SVG svg, RenderOptions renderOptions) {
        SVG.Box box;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptions == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.document = svg;
        SVG.Svg rootElement = svg.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.hasView()) {
            SVG.SvgElementBase elementById = this.document.getElementById(renderOptions.viewId);
            if (elementById == null || !(elementById instanceof SVG.View)) {
                Log.w(TAG, String.format("View element with id \"%s\" not found.", renderOptions.viewId));
                return;
            }
            SVG.View view = (SVG.View) elementById;
            box = view.viewBox;
            if (box == null) {
                Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.viewId));
                return;
            }
            preserveAspectRatio = view.preserveAspectRatio;
        } else {
            box = renderOptions.hasViewBox() ? renderOptions.viewBox : rootElement.viewBox;
            preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.preserveAspectRatio : rootElement.preserveAspectRatio;
        }
        if (renderOptions.hasCss()) {
            svg.addCSSRules(renderOptions.css);
        }
        if (renderOptions.hasTarget()) {
            CSSParser.RuleMatchContext ruleMatchContext = new CSSParser.RuleMatchContext();
            this.ruleMatchContext = ruleMatchContext;
            ruleMatchContext.targetElement = svg.getElementById(renderOptions.targetId);
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        statePush();
        SVG.Box box2 = new SVG.Box(renderOptions.viewPort);
        SVG.Length length = rootElement.width;
        if (length != null) {
            box2.width = length.floatValue(this, box2.width);
        }
        SVG.Length length2 = rootElement.height;
        if (length2 != null) {
            box2.height = length2.floatValue(this, box2.height);
        }
        render(rootElement, box2, box, preserveAspectRatio);
        statePop();
        if (renderOptions.hasCss()) {
            svg.clearRenderCSSRules();
        }
    }

    public class TextWidthCalculator extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        float f19302x;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.f19302x = 0.0f;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            this.f19302x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }

        public /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathCalculateClipPath;
        if (this.state.style.clipPath == null || (pathCalculateClipPath = calculateClipPath(svgElement, box)) == null) {
            return;
        }
        this.canvas.clipPath(pathCalculateClipPath);
    }

    private void popLayer(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.mask != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            this.canvas.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.canvas.saveLayer(null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) this.document.resolveIRI(this.state.style.mask);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            this.canvas.saveLayer(null, paint3, 31);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            Object obj = svgObject.parent;
            if (obj == null) {
                break;
            }
            svgObject = (SVG.SvgObject) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVG.SvgElementBase) it.next());
        }
        RendererState rendererState2 = this.state;
        rendererState.viewBox = rendererState2.viewBox;
        rendererState.viewPort = rendererState2.viewPort;
        return rendererState;
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        int length = polyLine.points.length;
        int i10 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = polyLine.points;
        MarkerVector markerVector = new MarkerVector(fArr[0], fArr[1], 0.0f, 0.0f);
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (i10 < length) {
            float[] fArr2 = polyLine.points;
            float f12 = fArr2[i10];
            float f13 = fArr2[i10 + 1];
            markerVector.add(f12, f13);
            arrayList.add(markerVector);
            i10 += 2;
            markerVector = new MarkerVector(f12, f13, f12 - markerVector.f19294x, f13 - markerVector.f19295y);
            f10 = f12;
            f11 = f13;
        }
        if (polyLine instanceof SVG.Polygon) {
            float[] fArr3 = polyLine.points;
            float f14 = fArr3[0];
            if (f10 != f14) {
                float f15 = fArr3[1];
                if (f11 != f15) {
                    markerVector.add(f14, f15);
                    arrayList.add(markerVector);
                    MarkerVector markerVector2 = new MarkerVector(f14, f15, f14 - markerVector.f19294x, f15 - markerVector.f19295y);
                    markerVector2.add((MarkerVector) arrayList.get(0));
                    arrayList.add(markerVector2);
                    arrayList.set(0, markerVector2);
                }
            }
            return arrayList;
        }
        arrayList.add(markerVector);
        return arrayList;
    }

    public class MarkerVector {
        float dx;
        float dy;
        boolean isAmbiguous = false;

        /* renamed from: x, reason: collision with root package name */
        float f19294x;

        /* renamed from: y, reason: collision with root package name */
        float f19295y;

        public MarkerVector(float f10, float f11, float f12, float f13) {
            this.dx = 0.0f;
            this.dy = 0.0f;
            this.f19294x = f10;
            this.f19295y = f11;
            double dSqrt = Math.sqrt((f12 * f12) + (f13 * f13));
            if (dSqrt != 0.0d) {
                this.dx = (float) (f12 / dSqrt);
                this.dy = (float) (f13 / dSqrt);
            }
        }

        public void add(float f10, float f11) {
            float f12 = f10 - this.f19294x;
            float f13 = f11 - this.f19295y;
            double dSqrt = Math.sqrt((f12 * f12) + (f13 * f13));
            if (dSqrt != 0.0d) {
                f12 = (float) (f12 / dSqrt);
                f13 = (float) (f13 / dSqrt);
            }
            float f14 = this.dx;
            if (f12 != (-f14) || f13 != (-this.dy)) {
                this.dx = f14 + f12;
                this.dy += f13;
            } else {
                this.isAmbiguous = true;
                this.dx = -f13;
                this.dy = f12;
            }
        }

        public String toString() {
            return "(" + this.f19294x + Const.STR_MART_COMMA + this.f19295y + " " + this.dx + Const.STR_MART_COMMA + this.dy + ")";
        }

        public void add(MarkerVector markerVector) {
            float f10 = markerVector.dx;
            float f11 = this.dx;
            if (f10 == (-f11)) {
                float f12 = markerVector.dy;
                if (f12 == (-this.dy)) {
                    this.isAmbiguous = true;
                    this.dx = -f12;
                    this.dy = markerVector.dx;
                    return;
                }
            }
            this.dx = f11 + f10;
            this.dy += markerVector.dy;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Path makePathAndBoundingBox(com.caverock.androidsvg.SVG.Rect r20) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.makePathAndBoundingBox(com.caverock.androidsvg.SVG$Rect):android.graphics.Path");
    }

    public class RendererState {
        Paint fillPaint;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        Paint strokePaint;
        SVG.Style style;
        SVG.Box viewBox;
        SVG.Box viewPort;

        public RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            this.fillPaint.setHinting(0);
            this.fillPaint.setStyle(Paint.Style.FILL);
            Paint paint2 = this.fillPaint;
            Typeface typeface = Typeface.DEFAULT;
            paint2.setTypeface(typeface);
            Paint paint3 = new Paint();
            this.strokePaint = paint3;
            paint3.setFlags(193);
            this.strokePaint.setHinting(0);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(typeface);
            this.style = SVG.Style.getDefaultStyle();
        }

        public RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            SVG.Box box = rendererState.viewPort;
            if (box != null) {
                this.viewPort = new SVG.Box(box);
            }
            SVG.Box box2 = rendererState.viewBox;
            if (box2 != null) {
                this.viewBox = new SVG.Box(box2);
            }
            this.spacePreserve = rendererState.spacePreserve;
            try {
                this.style = (SVG.Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e10) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e10);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    private void addObjectToClip(SVG.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            Matrix matrix2 = path.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path path3 = new PathConverter(path.f19277d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.f19284x1 == null) {
            svgLinearGradient.f19284x1 = svgLinearGradient2.f19284x1;
        }
        if (svgLinearGradient.f19286y1 == null) {
            svgLinearGradient.f19286y1 = svgLinearGradient2.f19286y1;
        }
        if (svgLinearGradient.f19285x2 == null) {
            svgLinearGradient.f19285x2 = svgLinearGradient2.f19285x2;
        }
        if (svgLinearGradient.f19287y2 == null) {
            svgLinearGradient.f19287y2 = svgLinearGradient2.f19287y2;
        }
    }

    private void addObjectToClip(SVG.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path pathMakePathAndBoundingBox;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            Matrix matrix2 = graphicsElement.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (graphicsElement instanceof SVG.Rect) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVG.Circle) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVG.Ellipse) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Ellipse) graphicsElement);
            } else if (!(graphicsElement instanceof SVG.PolyLine)) {
                return;
            } else {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.PolyLine) graphicsElement);
            }
            checkForClipPath(graphicsElement);
            path.setFillType(getClipRuleFromState());
            path.addPath(pathMakePathAndBoundingBox, matrix);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.f19288r == null) {
            svgRadialGradient.f19288r = svgRadialGradient2.f19288r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
    }

    private void render(SVG.Svg svg) {
        render(svg, makeViewPort(svg.f19282x, svg.f19283y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box) {
        render(svg, box, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        debug("Svg render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = svg.preserveAspectRatio) == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, svg);
        if (display()) {
            RendererState rendererState = this.state;
            rendererState.viewPort = box;
            if (!rendererState.style.overflow.booleanValue()) {
                SVG.Box box3 = this.state.viewPort;
                setClipRect(box3.minX, box3.minY, box3.width, box3.height);
            }
            checkForClipPath(svg, this.state.viewPort);
            if (box2 != null) {
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                this.state.viewBox = svg.viewBox;
            } else {
                Canvas canvas = this.canvas;
                SVG.Box box4 = this.state.viewPort;
                canvas.translate(box4.minX, box4.minY);
            }
            boolean zPushLayer = pushLayer();
            viewportFill();
            renderChildren(svg, true);
            if (zPushLayer) {
                popLayer(svg);
            }
            updateParentBoundingBox(svg);
        }
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        SVG.Length length = circle.cx;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = circle.cy;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float fFloatValue = circle.f19268r.floatValue(this);
        float f10 = fFloatValueX - fFloatValue;
        float f11 = fFloatValueY - fFloatValue;
        float f12 = fFloatValueX + fFloatValue;
        float f13 = fFloatValueY + fFloatValue;
        if (circle.boundingBox == null) {
            float f14 = 2.0f * fFloatValue;
            circle.boundingBox = new SVG.Box(f10, f11, f14, f14);
        }
        float f15 = fFloatValue * BEZIER_ARC_FACTOR;
        Path path = new Path();
        path.moveTo(fFloatValueX, f11);
        float f16 = fFloatValueX + f15;
        float f17 = fFloatValueY - f15;
        path.cubicTo(f16, f11, f12, f17, f12, fFloatValueY);
        float f18 = fFloatValueY + f15;
        path.cubicTo(f12, f18, f16, f13, fFloatValueX, f13);
        float f19 = fFloatValueX - f15;
        path.cubicTo(f19, f13, f10, f18, f10, fFloatValueY);
        path.cubicTo(f10, f17, f19, f11, fFloatValueX, f11);
        path.close();
        return path;
    }

    private void addObjectToClip(SVG.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            Matrix matrix2 = use.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
            if (svgObjectResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
            } else {
                checkForClipPath(use);
                addObjectToClip(svgObjectResolveIRI, false, path, matrix);
            }
        }
    }

    private void addObjectToClip(SVG.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            Matrix matrix2 = text.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.Length> list = text.f19289x;
            float fFloatValueY = 0.0f;
            float fFloatValueX = (list == null || list.size() == 0) ? 0.0f : text.f19289x.get(0).floatValueX(this);
            List<SVG.Length> list2 = text.f19290y;
            float fFloatValueY2 = (list2 == null || list2.size() == 0) ? 0.0f : text.f19290y.get(0).floatValueY(this);
            List<SVG.Length> list3 = text.dx;
            float fFloatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            List<SVG.Length> list4 = text.dy;
            if (list4 != null && list4.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.bbox;
                text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            Matrix matrix = group.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(group);
            boolean zPushLayer = pushLayer();
            renderChildren(group, true);
            if (zPushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        SVG.Length length = ellipse.cx;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = ellipse.cy;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float fFloatValueX2 = ellipse.rx.floatValueX(this);
        float fFloatValueY2 = ellipse.ry.floatValueY(this);
        float f10 = fFloatValueX - fFloatValueX2;
        float f11 = fFloatValueY - fFloatValueY2;
        float f12 = fFloatValueX + fFloatValueX2;
        float f13 = fFloatValueY + fFloatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f10, f11, fFloatValueX2 * 2.0f, 2.0f * fFloatValueY2);
        }
        float f14 = fFloatValueX2 * BEZIER_ARC_FACTOR;
        float f15 = fFloatValueY2 * BEZIER_ARC_FACTOR;
        Path path = new Path();
        path.moveTo(fFloatValueX, f11);
        float f16 = fFloatValueX + f14;
        float f17 = fFloatValueY - f15;
        path.cubicTo(f16, f11, f12, f17, f12, fFloatValueY);
        float f18 = fFloatValueY + f15;
        path.cubicTo(f12, f18, f16, f13, fFloatValueX, f13);
        float f19 = fFloatValueX - f14;
        path.cubicTo(f19, f13, f10, f18, f10, fFloatValueY);
        path.cubicTo(f10, f17, f19, f11, fFloatValueX, f11);
        path.close();
        return path;
    }

    private void render(SVG.Switch r32) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r32);
        if (display()) {
            Matrix matrix = r32.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(r32);
            boolean zPushLayer = pushLayer();
            renderSwitchChild(r32);
            if (zPushLayer) {
                popLayer(r32);
            }
            updateParentBoundingBox(r32);
        }
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        float[] fArr = polyLine.points;
        path.moveTo(fArr[0], fArr[1]);
        int i10 = 2;
        while (true) {
            float[] fArr2 = polyLine.points;
            if (i10 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i10], fArr2[i10 + 1]);
            i10 += 2;
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        SVG.Length length = use.width;
        if (length == null || !length.isZero()) {
            SVG.Length length2 = use.height;
            if (length2 == null || !length2.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVG.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
                    if (svgObjectResolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    Matrix matrix = use.transform;
                    if (matrix != null) {
                        this.canvas.concat(matrix);
                    }
                    SVG.Length length3 = use.f19292x;
                    float fFloatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = use.f19293y;
                    this.canvas.translate(fFloatValueX, length4 != null ? length4.floatValueY(this) : 0.0f);
                    checkForClipPath(use);
                    boolean zPushLayer = pushLayer();
                    parentPush(use);
                    if (svgObjectResolveIRI instanceof SVG.Svg) {
                        SVG.Box boxMakeViewPort = makeViewPort(null, null, use.width, use.height);
                        statePush();
                        render((SVG.Svg) svgObjectResolveIRI, boxMakeViewPort);
                        statePop();
                    } else if (svgObjectResolveIRI instanceof SVG.Symbol) {
                        SVG.Length length5 = use.width;
                        if (length5 == null) {
                            length5 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length6 = use.height;
                        if (length6 == null) {
                            length6 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Box boxMakeViewPort2 = makeViewPort(null, null, length5, length6);
                        statePush();
                        render((SVG.Symbol) svgObjectResolveIRI, boxMakeViewPort2);
                        statePop();
                    } else {
                        render(svgObjectResolveIRI);
                    }
                    parentPop();
                    if (zPushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private Path makePathAndBoundingBox(SVG.Text text) {
        List<SVG.Length> list = text.f19289x;
        float fFloatValueY = 0.0f;
        float fFloatValueX = (list == null || list.size() == 0) ? 0.0f : text.f19289x.get(0).floatValueX(this);
        List<SVG.Length> list2 = text.f19290y;
        float fFloatValueY2 = (list2 == null || list2.size() == 0) ? 0.0f : text.f19290y.get(0).floatValueY(this);
        List<SVG.Length> list3 = text.dx;
        float fFloatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
        List<SVG.Length> list4 = text.dy;
        if (list4 != null && list4.size() != 0) {
            fFloatValueY = text.dy.get(0).floatValueY(this);
        }
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float fCalculateTextWidth = calculateTextWidth(text);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                fCalculateTextWidth /= 2.0f;
            }
            fFloatValueX -= fCalculateTextWidth;
        }
        if (text.boundingBox == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
            enumerateTextSpans(text, textBoundsCalculator);
            RectF rectF = textBoundsCalculator.bbox;
            text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
        }
        Path path = new Path();
        enumerateTextSpans(text, new PlainTextToPath(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path));
        return path;
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        if (path.f19277d == null) {
            return;
        }
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = path.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                Path path2 = new PathConverter(path.f19277d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradientsAndPatterns(path);
                checkForClipPath(path);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (zPushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        SVG.Length length = rect.width;
        if (length == null || rect.height == null || length.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            Matrix matrix = rect.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradientsAndPatterns(rect);
            checkForClipPath(rect);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        SVG.Length length = circle.f19268r;
        if (length == null || length.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            Matrix matrix = circle.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradientsAndPatterns(circle);
            checkForClipPath(circle);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        SVG.Length length = ellipse.rx;
        if (length == null || ellipse.ry == null || length.isZero() || ellipse.ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            Matrix matrix = ellipse.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradientsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            Matrix matrix = line.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradientsAndPatterns(line);
            checkForClipPath(line);
            boolean zPushLayer = pushLayer();
            doStroke(pathMakePathAndBoundingBox);
            renderMarkers(line);
            if (zPushLayer) {
                popLayer(line);
            }
        }
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polyLine.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polyLine.points.length < 2) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                pathMakePathAndBoundingBox.setFillType(getFillTypeFromState());
                checkForGradientsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (zPushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polygon.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polygon.points.length < 2) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradientsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (zPushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            Matrix matrix = text.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            List<SVG.Length> list = text.f19289x;
            float fFloatValueY = 0.0f;
            float fFloatValueX = (list == null || list.size() == 0) ? 0.0f : text.f19289x.get(0).floatValueX(this);
            List<SVG.Length> list2 = text.f19290y;
            float fFloatValueY2 = (list2 == null || list2.size() == 0) ? 0.0f : text.f19290y.get(0).floatValueY(this);
            List<SVG.Length> list3 = text.dx;
            float fFloatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            List<SVG.Length> list4 = text.dy;
            if (list4 != null && list4.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.bbox;
                text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradientsAndPatterns(text);
            checkForClipPath(text);
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY));
            if (zPushLayer) {
                popLayer(text);
            }
        }
    }

    private void render(SVG.Symbol symbol, SVG.Box box) {
        debug("Symbol render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, symbol);
        RendererState rendererState = this.state;
        rendererState.viewPort = box;
        if (!rendererState.style.overflow.booleanValue()) {
            SVG.Box box2 = this.state.viewPort;
            setClipRect(box2.minX, box2.minY, box2.width, box2.height);
        }
        SVG.Box box3 = symbol.viewBox;
        if (box3 != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box3, preserveAspectRatio));
            this.state.viewBox = symbol.viewBox;
        } else {
            Canvas canvas = this.canvas;
            SVG.Box box4 = this.state.viewPort;
            canvas.translate(box4.minX, box4.minY);
        }
        boolean zPushLayer = pushLayer();
        renderChildren(symbol, true);
        if (zPushLayer) {
            popLayer(symbol);
        }
        updateParentBoundingBox(symbol);
    }

    private void render(SVG.Image image) {
        SVG.Length length;
        String str;
        debug("Image render", new Object[0]);
        SVG.Length length2 = image.width;
        if (length2 == null || length2.isZero() || (length = image.height) == null || length.isZero() || (str = image.href) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        Bitmap bitmapCheckForImageDataURL = checkForImageDataURL(str);
        if (bitmapCheckForImageDataURL == null) {
            SVGExternalFileResolver fileResolver = SVG.getFileResolver();
            if (fileResolver == null) {
                return;
            } else {
                bitmapCheckForImageDataURL = fileResolver.resolveImage(image.href);
            }
        }
        if (bitmapCheckForImageDataURL == null) {
            error("Could not locate image '%s'", image.href);
            return;
        }
        SVG.Box box = new SVG.Box(0.0f, 0.0f, bitmapCheckForImageDataURL.getWidth(), bitmapCheckForImageDataURL.getHeight());
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            Matrix matrix = image.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            SVG.Length length3 = image.f19269x;
            float fFloatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = image.f19270y;
            this.state.viewPort = new SVG.Box(fFloatValueX, length4 != null ? length4.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                SVG.Box box2 = this.state.viewPort;
                setClipRect(box2.minX, box2.minY, box2.width, box2.height);
            }
            image.boundingBox = this.state.viewPort;
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean zPushLayer = pushLayer();
            viewportFill();
            this.canvas.save();
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
            this.canvas.drawBitmap(bitmapCheckForImageDataURL, 0.0f, 0.0f, new Paint(this.state.style.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.canvas.restore();
            if (zPushLayer) {
                popLayer(image);
            }
        }
    }
}
