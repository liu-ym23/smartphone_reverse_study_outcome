package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.vcard.VCardBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextLayer extends BaseLayer {
    private final LongSparseArray<String> codePointCache;
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    private final List<TextSubLine> textSubLines;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;
    private BaseKeyframeAnimation<Typeface, Typeface> typefaceCallbackAnimation;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = null;

        static {
            int[] r0 = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = r0;
            r0[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class TextSubLine {
        private String text;
        private float width;

        private TextSubLine() {
            this.text = "";
            this.width = 0.0f;
        }

        /* synthetic */ TextSubLine(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ float access$000(TextSubLine r0) {
            return r0.width;
        }

        static /* synthetic */ String access$100(TextSubLine r0) {
            return r0.text;
        }

        void set(String r1, float r2) {
            this.text = r1;
            this.width = r2;
        }
    }

    TextLayer(LottieDrawable r3, Layer r4) {
        super(r3, r4);
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        final int r1 = 1;
        this.fillPaint = new AnonymousClass1(this, r1);
        this.strokePaint = new AnonymousClass2(this, r1);
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray();
        this.textSubLines = new ArrayList();
        this.lottieDrawable = r3;
        this.composition = r4.getComposition();
        TextKeyframeAnimation r5 = r4.getText().createAnimation();
        this.textAnimation = r5;
        r5.addUpdateListener(this);
        addAnimation(r5);
        AnimatableTextProperties r6 = r4.getTextProperties();
        if (r6 != null) goto L5;
    L7:
        if (r6 != null) goto L9;
    L11:
        if (r6 != null) goto L13;
    L15:
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.tracking == null) goto L21;
        BaseKeyframeAnimation<Float, Float> r7 = r6.tracking.createAnimation();
        this.trackingAnimation = r7;
        r7.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
        return;
    L21:
        return;
    L13:
        if (r6.strokeWidth == null) goto L15;
        BaseKeyframeAnimation<Float, Float> r8 = r6.strokeWidth.createAnimation();
        this.strokeWidthAnimation = r8;
        r8.addUpdateListener(this);
        addAnimation(this.strokeWidthAnimation);
        goto L15
    L9:
        if (r6.stroke == null) goto L11;
        BaseKeyframeAnimation<Integer, Integer> r9 = r6.stroke.createAnimation();
        this.strokeColorAnimation = r9;
        r9.addUpdateListener(this);
        addAnimation(this.strokeColorAnimation);
        goto L11
    L5:
        if (r6.color == null) goto L7;
        BaseKeyframeAnimation<Integer, Integer> r10 = r6.color.createAnimation();
        this.colorAnimation = r10;
        r10.addUpdateListener(this);
        addAnimation(this.colorAnimation);
        goto L7
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        super.getBounds(r1, r2, r3);
        r1.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r4, Matrix r5, int r6) {
        DocumentData r0 = this.textAnimation.getValue();
        Font r1 = this.composition.getFonts().get(r0.fontName);
        if (r1 != null) goto L5;
        return;
    L5:
        r4.save();
        r4.concat(r5);
        configurePaint(r0, r6);
        if (this.lottieDrawable.useTextGlyphs() == false) goto L8;
        drawTextWithGlyphs(r0, r5, r1, r4);
    L9:
        r4.restore();
        return;
    L8:
        drawTextWithFont(r0, r1, r4);
        goto L9
    }

    private void configurePaint(DocumentData r3, int r4) {
        BaseKeyframeAnimation<Integer, Integer> r0 = this.colorCallbackAnimation;
        if (r0 == null) goto L5;
        this.fillPaint.setColor(r0.getValue().intValue());
    L9:
        BaseKeyframeAnimation<Integer, Integer> r1 = this.strokeColorCallbackAnimation;
        if (r1 == null) goto L12;
        this.strokePaint.setColor(r1.getValue().intValue());
    L17:
        if (this.transform.getOpacity() != null) goto L19;
        int r2 = 100;
    L20:
        int r5 = (((r2 * 255) / 100) * r4) / 255;
        this.fillPaint.setAlpha(r5);
        this.strokePaint.setAlpha(r5);
        BaseKeyframeAnimation<Float, Float> r6 = this.strokeWidthCallbackAnimation;
        if (r6 == null) goto L23;
        this.strokePaint.setStrokeWidth(r6.getValue().floatValue());
        return;
    L23:
        BaseKeyframeAnimation<Float, Float> r7 = this.strokeWidthAnimation;
        if (r7 == null) goto L26;
        this.strokePaint.setStrokeWidth(r7.getValue().floatValue());
        return;
    L26:
        this.strokePaint.setStrokeWidth(r3.strokeWidth * Utils.dpScale());
        return;
    L19:
        r2 = this.transform.getOpacity().getValue().intValue();
        goto L20
    L12:
        BaseKeyframeAnimation<Integer, Integer> r8 = this.strokeColorAnimation;
        if (r8 == null) goto L15;
        this.strokePaint.setColor(r8.getValue().intValue());
        goto L17
    L15:
        this.strokePaint.setColor(r3.strokeColor);
        goto L17
    L5:
        BaseKeyframeAnimation<Integer, Integer> r9 = this.colorAnimation;
        if (r9 == null) goto L8;
        this.fillPaint.setColor(r9.getValue().intValue());
        goto L9
    L8:
        this.fillPaint.setColor(r3.color);
        goto L9
    }

    private void drawTextWithGlyphs(DocumentData r21, Matrix r22, Font r23, Canvas r24) {
        BaseKeyframeAnimation<Float, Float> r0 = this.textSizeCallbackAnimation;
        if (r0 == null) goto L5;
        float r1 = r0.getValue().floatValue();
    L6:
        float r10 = r1 / 100.0f;
        float r11 = Utils.getScale(r22);
        List<String> r12 = getTextLines(r21.text);
        int r13 = r12.size();
        float r2 = r21.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> r3 = this.trackingCallbackAnimation;
        if (r3 == null) goto L10;
        float r4 = r3.getValue().floatValue();
    L9:
        r2 = r2 + r4;
    L13:
        float r14 = r2;
        int r7 = -1;
        int r6 = 0;
    L14:
        if (r6 >= r13) goto L24;
        String r5 = r12.get(r6);
        if (r21.boxSize != null) goto L18;
        float r8 = 0.0f;
    L19:
        int r17 = r6;
        List<TextSubLine> r9 = splitGlyphTextIntoLines(r5, r8, r23, r10, r14, true);
        int r15 = 0;
    L21:
        if (r15 >= r9.size()) goto L23;
        TextSubLine r16 = r9.get(r15);
        int r18 = r7 + 1;
        r24.save();
        offsetCanvas(r24, r21, r18, TextSubLine.access$000(r16));
        drawGlyphTextLine(TextSubLine.access$100(r16), r21, r23, r24, r11, r10, r14);
        r24.restore();
        r15 = r15 + 1;
        r9 = r9;
        r7 = r18;
        goto L21
    L23:
        r6 = r17 + 1;
        goto L14
    L18:
        r8 = r21.boxSize.x;
        goto L19
    L24:
        return;
    L10:
        BaseKeyframeAnimation<Float, Float> r19 = this.trackingAnimation;
        if (r19 == null) goto L13;
        r4 = r19.getValue().floatValue();
        goto L9
    L5:
        r1 = r21.size;
        goto L6
    }

    private void drawGlyphTextLine(String r4, DocumentData r5, Font r6, Canvas r7, float r8, float r9, float r10) {
        int r11 = 0;
    L4:
        if (r11 >= r4.length()) goto L10;
        int r0 = FontCharacter.hashFor(r4.charAt(r11), r6.getFamily(), r6.getStyle());
        FontCharacter r1 = this.composition.getCharacters().get(r0);
        if (r1 == null) goto L9;
        drawCharacterAsGlyph(r1, r9, r5, r7);
        r7.translate(((((float) r1.getWidth()) * r9) * Utils.dpScale()) + r10, 0.0f);
    L9:
        r11 = r11 + 1;
        goto L4
    }

    private void drawTextWithFont(DocumentData r19, Font r20, Canvas r21) {
        Typeface r0 = getTypeface(r20);
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r19.text;
        TextDelegate r2 = this.lottieDrawable.getTextDelegate();
        if (r2 == null) goto L8;
        r1 = r2.getTextInternal(getName(), r1);
    L8:
        this.fillPaint.setTypeface(r0);
        BaseKeyframeAnimation<Float, Float> r3 = this.textSizeCallbackAnimation;
        if (r3 == null) goto L11;
        float r4 = r3.getValue().floatValue();
    L12:
        this.fillPaint.setTextSize(Utils.dpScale() * r4);
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        float r5 = r19.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> r6 = this.trackingCallbackAnimation;
        if (r6 == null) goto L16;
        float r7 = r6.getValue().floatValue();
    L15:
        r5 = r5 + r7;
    L19:
        float r11 = ((r5 * Utils.dpScale()) * r4) / 100.0f;
        List<String> r12 = getTextLines(r1);
        int r13 = r12.size();
        int r15 = -1;
        int r8 = 0;
    L20:
        if (r8 >= r13) goto L30;
        String r9 = r12.get(r8);
        if (r19.boxSize != null) goto L24;
        float r10 = 0.0f;
    L25:
        int r17 = r8;
        List<TextSubLine> r14 = splitGlyphTextIntoLines(r9, r10, r20, 0.0f, r11, false);
        int r16 = 0;
    L27:
        if (r16 >= r14.size()) goto L29;
        TextSubLine r18 = r14.get(r16);
        r15 = r15 + 1;
        r21.save();
        offsetCanvas(r21, r19, r15, TextSubLine.access$000(r18));
        drawFontTextLine(TextSubLine.access$100(r18), r19, r21, r11);
        r21.restore();
        r16 = r16 + 1;
        goto L27
    L29:
        r8 = r17 + 1;
        goto L20
    L24:
        r10 = r19.boxSize.x;
        goto L25
    L30:
        return;
    L16:
        BaseKeyframeAnimation<Float, Float> r22 = this.trackingAnimation;
        if (r22 == null) goto L19;
        r7 = r22.getValue().floatValue();
        goto L15
    L11:
        r4 = r19.size;
        goto L12
    }

    private void offsetCanvas(Canvas r6, DocumentData r7, int r8, float r9) {
        PointF r5 = r7.boxPosition;
        PointF r0 = r7.boxSize;
        float r1 = Utils.dpScale();
        float r2 = 0.0f;
        if (r5 != null) goto L5;
        float r3 = 0.0f;
    L6:
        float r10 = ((r8 * r7.lineHeight) * r1) + r3;
        if (r5 != null) goto L9;
        float r11 = 0.0f;
    L10:
        if (r0 == null) goto L13;
        r2 = r0.x;
    L13:
        int r12 = AnonymousClass3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[r7.justification.ordinal()];
        if (r12 != 1) goto L16;
        r6.translate(r11, r10);
        return;
    L16:
        if (r12 != 2) goto L18;
        r6.translate((r11 + r2) - r9, r10);
        return;
    L18:
        if (r12 != 3) goto L26;
        r6.translate((r11 + (r2 / 2.0f)) - (r9 / 2.0f), r10);
        return;
    L26:
        return;
    L9:
        r11 = r5.x;
        goto L10
    L5:
        r3 = (r7.lineHeight * r1) + r5.y;
        goto L6
    }

    private Typeface getTypeface(Font r2) {
        BaseKeyframeAnimation<Typeface, Typeface> r0 = this.typefaceCallbackAnimation;
        if (r0 == null) goto L7;
        Typeface r1 = r0.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        Typeface r3 = this.lottieDrawable.getTypeface(r2);
        if (r3 == null) goto L11;
        return r3;
    L11:
        return r2.getTypeface();
    }

    private List<String> getTextLines(String r2) {
        return Arrays.asList(r2.replaceAll(VCardBuilder.VCARD_END_OF_LINE, "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void drawFontTextLine(String r4, DocumentData r5, Canvas r6, float r7) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L6;
        String r1 = codePointToString(r4, r0);
        r0 = r0 + r1.length();
        drawCharacterFromFont(r1, r5, r6);
        r6.translate(this.fillPaint.measureText(r1) + r7, 0.0f);
        goto L4
    }

    private List<TextSubLine> splitGlyphTextIntoLines(String r17, float r18, Font r19, float r20, float r21, boolean r22) {
        int r4 = 0;
        int r6 = 0;
        int r7 = 0;
        boolean r8 = false;
        int r10 = 0;
        float r5 = 0.0f;
        float r9 = 0.0f;
        float r11 = 0.0f;
    L4:
        if (r4 >= r17.length()) goto L30;
        char r12 = r17.charAt(r4);
        if (r22 == false) goto L11;
        FontCharacter r13 = this.composition.getCharacters().get(FontCharacter.hashFor(r12, r19.getFamily(), r19.getStyle()));
        if (r13 == null) goto L28;
        float r14 = (((float) r13.getWidth()) * r20) * Utils.dpScale();
    L12:
        float r15 = r14 + r21;
        if (r12 != ' ') goto L15;
        r8 = true;
        r11 = r15;
    L18:
        r5 = r5 + r15;
        if (r18 <= 0.0f) goto L28;
        if (r5 < r18) goto L28;
        if (r12 == ' ') goto L28;
        r6 = r6 + 1;
        TextSubLine r16 = ensureEnoughSubLines(r6);
        if (r10 != r7) goto L27;
        String r23 = r17.substring(r7, r4);
        String r24 = r23.trim();
        r16.set(r24, (r5 - r15) - ((r24.length() - r23.length()) * r11));
        r7 = r4;
        r10 = r7;
        r5 = r15;
        r9 = r5;
        goto L28
    L27:
        String r25 = r17.substring(r7, r10 - 1);
        String r110 = r25.trim();
        r16.set(r110, ((r5 - r9) - ((r25.length() - r110.length()) * r11)) - r11);
        r5 = r9;
        r7 = r10;
        goto L28
    L15:
        if (r8 == false) goto L17;
        r8 = false;
        r10 = r4;
        r9 = r15;
        goto L18
    L17:
        r9 = r9 + r15;
    L28:
        r4 = r4 + 1;
        goto L4
    L11:
        r14 = this.fillPaint.measureText(r17.substring(r4, r4 + 1));
        goto L12
    L30:
        if (r5 <= 0.0f) goto L33;
        r6 = r6 + 1;
        ensureEnoughSubLines(r6).set(r17.substring(r7), r5);
    L33:
        return this.textSubLines.subList(0, r6);
    }

    private TextSubLine ensureEnoughSubLines(int r5) {
        int r0 = this.textSubLines.size();
    L3:
        if (r0 >= r5) goto L6;
        this.textSubLines.add(new TextSubLine(null));
        r0 = r0 + 1;
        goto L3
    L6:
        return this.textSubLines.get(r5 - 1);
    }

    private void drawCharacterAsGlyph(FontCharacter r7, float r8, DocumentData r9, Canvas r10) {
        List<ContentGroup> r11 = getContentsForCharacter(r7);
        int r1 = 0;
    L4:
        if (r1 >= r11.size()) goto L10;
        Path r2 = r11.get(r1).getPath();
        r2.computeBounds(this.rectF, false);
        this.matrix.reset();
        this.matrix.preTranslate(0.0f, (-r9.baselineShift) * Utils.dpScale());
        this.matrix.preScale(r8, r8);
        r2.transform(this.matrix);
        if (r9.strokeOverFill == false) goto L8;
        drawGlyph(r2, this.fillPaint, r10);
        drawGlyph(r2, this.strokePaint, r10);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        drawGlyph(r2, this.strokePaint, r10);
        drawGlyph(r2, this.fillPaint, r10);
        goto L9
    }

    private void drawGlyph(Path r2, Paint r3, Canvas r4) {
        if (r3.getColor() != 0) goto L6;
        return;
    L6:
        if (r3.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r4.drawPath(r2, r3);
        return;
    L8:
        if (r3.getStrokeWidth() != 0.0f) goto L10;
    }

    private void drawCharacterFromFont(String r1, DocumentData r2, Canvas r3) {
        if (r2.strokeOverFill == false) goto L5;
        drawCharacter(r1, this.fillPaint, r3);
        drawCharacter(r1, this.strokePaint, r3);
        return;
    L5:
        drawCharacter(r1, this.strokePaint, r3);
        drawCharacter(r1, this.fillPaint, r3);
    }

    private void drawCharacter(String r8, Paint r9, Canvas r10) {
        if (r9.getColor() != 0) goto L6;
        return;
    L6:
        if (r9.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r10.drawText(r8, 0, r8.length(), 0.0f, 0.0f, r9);
        return;
    L8:
        if (r9.getStrokeWidth() != 0.0f) goto L10;
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter r9) {
        if (this.contentsForCharacter.containsKey(r9) == true) goto L5;
        List<ShapeGroup> r0 = r9.getShapes();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(r1);
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        ShapeGroup r4 = r0.get(r3);
        r2.add(new ContentGroup(this.lottieDrawable, this, r4, this.composition));
        r3 = r3 + 1;
        goto L7
    L9:
        this.contentsForCharacter.put(r9, r2);
        return r2;
    L5:
        return this.contentsForCharacter.get(r9);
    }

    private String codePointToString(String r6, int r7) {
        int r0 = r6.codePointAt(r7);
        int r1 = Character.charCount(r0) + r7;
    L4:
        if (r1 >= r6.length()) goto L9;
        int r2 = r6.codePointAt(r1);
        if (isModifier(r2) == false) goto L9;
        r1 = r1 + Character.charCount(r2);
        r0 = (r0 * 31) + r2;
    L9:
        long r3 = r0;
        if (this.codePointCache.containsKey(r3) == true) goto L12;
        this.stringBuilder.setLength(0);
    L14:
        if (r7 >= r1) goto L16;
        int r4 = r6.codePointAt(r7);
        this.stringBuilder.appendCodePoint(r4);
        r7 = r7 + Character.charCount(r4);
        goto L14
    L16:
        String r8 = this.stringBuilder.toString();
        this.codePointCache.put(r3, r8);
        return r8;
    L12:
        return this.codePointCache.get(r3);
    }

    private boolean isModifier(int r2) {
        if (Character.getType(r2) != 16) goto L5;
    L16:
        return true;
    L5:
        if (Character.getType(r2) == 27) goto L16;
        if (Character.getType(r2) == 6) goto L16;
        if (Character.getType(r2) == 28) goto L16;
        if (Character.getType(r2) == 8) goto L16;
        if (Character.getType(r2) == 19) goto L16;
        return false;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r3, LottieValueCallback<T> r4) {
        super.addValueCallback(r3, r4);
        if (r3 != LottieProperty.COLOR) goto L11;
        BaseKeyframeAnimation<Integer, Integer> r5 = this.colorCallbackAnimation;
        if (r5 == null) goto L7;
        removeAnimation(r5);
    L7:
        if (r4 != null) goto L9;
        this.colorCallbackAnimation = null;
        return;
    L9:
        ValueCallbackKeyframeAnimation r6 = new ValueCallbackKeyframeAnimation(r4);
        this.colorCallbackAnimation = r6;
        r6.addUpdateListener(this);
        addAnimation(this.colorCallbackAnimation);
        return;
    L11:
        if (r3 != LottieProperty.STROKE_COLOR) goto L19;
        BaseKeyframeAnimation<Integer, Integer> r7 = this.strokeColorCallbackAnimation;
        if (r7 == null) goto L15;
        removeAnimation(r7);
    L15:
        if (r4 != null) goto L17;
        this.strokeColorCallbackAnimation = null;
        return;
    L17:
        ValueCallbackKeyframeAnimation r8 = new ValueCallbackKeyframeAnimation(r4);
        this.strokeColorCallbackAnimation = r8;
        r8.addUpdateListener(this);
        addAnimation(this.strokeColorCallbackAnimation);
        return;
    L19:
        if (r3 != LottieProperty.STROKE_WIDTH) goto L27;
        BaseKeyframeAnimation<Float, Float> r9 = this.strokeWidthCallbackAnimation;
        if (r9 == null) goto L23;
        removeAnimation(r9);
    L23:
        if (r4 != null) goto L25;
        this.strokeWidthCallbackAnimation = null;
        return;
    L25:
        ValueCallbackKeyframeAnimation r10 = new ValueCallbackKeyframeAnimation(r4);
        this.strokeWidthCallbackAnimation = r10;
        r10.addUpdateListener(this);
        addAnimation(this.strokeWidthCallbackAnimation);
        return;
    L27:
        if (r3 != LottieProperty.TEXT_TRACKING) goto L35;
        BaseKeyframeAnimation<Float, Float> r11 = this.trackingCallbackAnimation;
        if (r11 == null) goto L31;
        removeAnimation(r11);
    L31:
        if (r4 != null) goto L33;
        this.trackingCallbackAnimation = null;
        return;
    L33:
        ValueCallbackKeyframeAnimation r12 = new ValueCallbackKeyframeAnimation(r4);
        this.trackingCallbackAnimation = r12;
        r12.addUpdateListener(this);
        addAnimation(this.trackingCallbackAnimation);
        return;
    L35:
        if (r3 != LottieProperty.TEXT_SIZE) goto L43;
        BaseKeyframeAnimation<Float, Float> r13 = this.textSizeCallbackAnimation;
        if (r13 == null) goto L39;
        removeAnimation(r13);
    L39:
        if (r4 != null) goto L41;
        this.textSizeCallbackAnimation = null;
        return;
    L41:
        ValueCallbackKeyframeAnimation r14 = new ValueCallbackKeyframeAnimation(r4);
        this.textSizeCallbackAnimation = r14;
        r14.addUpdateListener(this);
        addAnimation(this.textSizeCallbackAnimation);
        return;
    L43:
        if (r3 != LottieProperty.TYPEFACE) goto L51;
        BaseKeyframeAnimation<Typeface, Typeface> r15 = this.typefaceCallbackAnimation;
        if (r15 == null) goto L47;
        removeAnimation(r15);
    L47:
        if (r4 != null) goto L49;
        this.typefaceCallbackAnimation = null;
        return;
    L49:
        ValueCallbackKeyframeAnimation r16 = new ValueCallbackKeyframeAnimation(r4);
        this.typefaceCallbackAnimation = r16;
        r16.addUpdateListener(this);
        addAnimation(this.typefaceCallbackAnimation);
        return;
    L51:
        if (r3 != LottieProperty.TEXT) goto L66;
        this.textAnimation.setStringValueCallback(r4);
        return;
    }
}
