package com.android.ttcjpaysdk.base.ui.component.money;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J0\u00109\u001a\u0002062\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u000201H\u0002J0\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u00122\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u000eH\u0002J\u0006\u0010C\u001a\u00020\u0018J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\bH\u0002J \u0010F\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u00122\u0006\u0010G\u001a\u00020\bH\u0002J\b\u0010H\u001a\u000206H\u0002J\b\u0010I\u001a\u000206H\u0002J\b\u0010J\u001a\u00020\u000eH\u0002J\b\u0010K\u001a\u00020\u000eH\u0002J\b\u0010L\u001a\u000206H\u0014J\u0010\u0010M\u001a\u0002062\u0006\u00107\u001a\u000208H\u0014J\u0018\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u0018H\u0002J\u0010\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\u0018H\u0016J\u0010\u0010S\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\u0018J\b\u0010@\u001a\u000206H\u0002J\b\u0010T\u001a\u000206H\u0002J\b\u0010U\u001a\u000206H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n 4*\u0004\u0018\u00010303X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/money/CJScrollAnimTextView;", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animating", "", "columnScrollArray", "Landroid/util/SparseArray;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "commaIndexs", "", "commaWidth", "", "currentDisplayedText", "", "disableAnim", "displayedDigits", "", "endFlags", "", "firstIn", "fontWidth", "lengthGap", "newText", "newTextArray", "newTextLength", "oldText", "oldTextArray", "oldTextLength", "pointIndex", "pointWidth", "progress", "scrollFlags", "scrollOrientation", "speedSum", "", "textBaseline", "textMeasuredHeight", "textPaint", "Landroid/graphics/Paint;", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "drawNumber", "", "canvas", "Landroid/graphics/Canvas;", "drawText", "mCanvas", "text", "x", "y", "p", "generateIntArray", "start", "end", "isPositive", "getCurrentDisplayedText", "getDrawX", ce.f26395j, "getScrollNumArray", "index", "initColumnScrollSet", "initSpeeds", "isCollectEnabled", "isScrollDown", "onDetachedFromWindow", "onDraw", "setScrollFlags", "old", "new", "setTextAnim", "str", "setTextWithoutAnim", "startAnimatorLoop", "stopAnimatorLoop", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJScrollAnimTextView extends TextView {
    public static final long ANIM_TIME = 750;
    public static final Companion Companion = null;
    public static final int PREFIX_NUM = 1;
    public static final double RATIO = 1.2d;
    private final ValueAnimator.AnimatorUpdateListener animUpdateListener;
    private boolean animating;
    private SparseArray<ArrayList<Integer>> columnScrollArray;
    private List<Integer> commaIndexs;
    private float commaWidth;
    private String currentDisplayedText;
    private boolean disableAnim;
    private char[] displayedDigits;
    private int[] endFlags;
    private boolean firstIn;
    private float fontWidth;
    private int lengthGap;
    private String newText;
    private char[] newTextArray;
    private int newTextLength;
    private String oldText;
    private char[] oldTextArray;
    private int oldTextLength;
    private int pointIndex;
    private float pointWidth;
    private float progress;
    private int[] scrollFlags;
    private int scrollOrientation;
    private float[] speedSum;
    private int textBaseline;
    private int textMeasuredHeight;
    private Paint textPaint;
    private final ValueAnimator valueAnimator;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/money/CJScrollAnimTextView$Companion;", "", "()V", "ANIM_TIME", "", "PREFIX_NUM", "", "RATIO", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void start() {
        this.disableAnim = false;
        this.animating = true;
        startAnimatorLoop();
    }

    private final void initColumnScrollSet() {
        this.columnScrollArray = new SparseArray();
        int r100 = this.newTextLength;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.columnScrollArray.put(r101, getScrollNumArray(r101));
        r101 = r101 + 1;
        goto L3
    }

    private final void initSpeeds() {
        int r100 = this.newTextLength;
        this.speedSum = new float[r100];
        this.endFlags = new int[r100];
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.speedSum[r101] = (this.columnScrollArray.get(r101).size() - 1) * getMeasuredHeight();
        r101 = r101 + 1;
        goto L3
    }

    private final boolean isScrollDown() {
        if (this.scrollOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void startAnimatorLoop() {
        this.valueAnimator.cancel();
        this.valueAnimator.setDuration(750);
        this.valueAnimator.addUpdateListener(this.animUpdateListener);
        this.valueAnimator.start();
    }

    private final void stopAnimatorLoop() {
        this.valueAnimator.removeAllUpdateListeners();
        this.valueAnimator.cancel();
    }

    private final boolean isCollectEnabled() {
        return !CJPaySettingsManager.getInstance().isDegradeReportClientDisplayAmount();
    L4:
        return false;
    }

    public final String getCurrentDisplayedText() {
        if (isCollectEnabled() == true) goto L7;
        return "";
    L7:
        return this.currentDisplayedText;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.animating = false;
        stopAnimatorLoop();
    }

    public CJScrollAnimTextView(Context r100) {
        super(r100);
        this.newText = "";
        this.oldText = "";
        this.newTextArray = new char[0];
        this.oldTextArray = new char[0];
        this.columnScrollArray = new SparseArray();
        this.speedSum = new float[0];
        this.endFlags = new int[0];
        this.scrollFlags = new int[0];
        this.firstIn = true;
        this.animating = true;
        this.textPaint = new Paint();
        this.pointIndex = -1;
        this.commaIndexs = new ArrayList();
        this.displayedDigits = new char[0];
        this.currentDisplayedText = "";
        this.valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animUpdateListener = new CJScrollAnimTextView$animUpdateListener$1(this);
    }

    public static final /* synthetic */ boolean access$getAnimating$p(CJScrollAnimTextView r100) {
        return r100.animating;
    }

    public static final /* synthetic */ void access$stopAnimatorLoop(CJScrollAnimTextView r100) {
        r100.stopAnimatorLoop();
    }

    private final void drawNumber(Canvas r110) {
        int r100 = this.newTextLength;
        boolean r101 = false;
        int r102 = 0;
    L3:
        boolean r111 = true;
        if (r102 >= r100) goto L73;
        double r103 = r102;
        if ((Math.pow(1.2d, r103) * ((double) this.progress)) <= 1.0d) goto L8;
        float r112 = 1.0f;
    L10:
        if (this.scrollFlags[r102] == (-1)) goto L12;
    L23:
        ArrayList<Integer> r113 = this.columnScrollArray.get(r102);
        int r114 = r113.size();
        int r104 = 1;
    L24:
        if (r104 >= r114) goto L71;
        if (r104 != (r113.size() - 1)) goto L43;
        int r105 = this.textBaseline;
        float r106 = ((1 - r104) * this.textMeasuredHeight) + r105;
        float r107 = this.speedSum[r102];
        float r108 = r106 + (r107 * r112);
        float r109 = (r105 * r104) - (r107 * r112);
        if (isScrollDown() == false) goto L33;
        if ((r108 - 1) >= this.textBaseline) goto L34;
    L35:
        boolean r115 = false;
    L36:
        if (r115 == false) goto L43;
        this.endFlags[r102] = 1;
        int r116 = this.newTextLength;
        int r117 = 0;
        int r118 = 0;
    L38:
        if (r117 >= r116) goto L41;
        r118 = r118 + this.endFlags[r117];
        r117 = r117 + 1;
        goto L38
    L41:
        if (r118 != ((this.newTextLength * 2) - 1)) goto L43;
        stopAnimatorLoop();
        this.animating = false;
    L34:
        r115 = true;
        goto L36
    L33:
        if ((r109 + 1) > this.textBaseline) goto L35;
    L43:
        int[] r119 = this.endFlags;
        if (r119[r102] != 0) goto L61;
        int r120 = ((Number) ListProtector.get(r113, r104)).intValue();
        if (isScrollDown() == false) goto L48;
        int r121 = this.textBaseline;
        int r122 = this.textMeasuredHeight;
        float r123 = ((r121 - (r104 * r122)) + r122) + (this.speedSum[r102] * r112);
    L49:
        float r124 = r123;
        if (isCollectEnabled() == true) goto L52;
    L60:
        int r125 = r104;
        drawText(r110, String.valueOf(r120), getDrawX(r102), r124, this.textPaint);
    L70:
        r104 = r125 + 1;
        goto L24
    L52:
        if (Math.abs(r124 - this.textBaseline) > 1.0f) goto L60;
        if (r102 >= 0) goto L55;
    L57:
        boolean r126 = false;
    L58:
        if (r126 == false) goto L60;
        this.displayedDigits[r102] = (char) (r120 + 48);
        goto L60
    L55:
        if (r102 >= this.displayedDigits.length) goto L57;
        r126 = true;
        goto L58
    L48:
        r123 = (this.textBaseline * r104) - (this.speedSum[r102] * r112);
        goto L49
    L61:
        r125 = r104;
        r119[r102] = 2;
        drawText(r110, String.valueOf(this.newTextArray[r102]), getDrawX(r102), this.textBaseline, this.textPaint);
        if (isCollectEnabled() == false) goto L70;
        if (r102 >= 0) goto L65;
    L67:
        boolean r127 = false;
    L68:
        if (r127 == false) goto L70;
        this.displayedDigits[r102] = this.newTextArray[r102];
        goto L70
    L65:
        if (r102 >= this.displayedDigits.length) goto L67;
        r127 = true;
    L71:
        r102 = r102 + 1;
        goto L3
    L12:
        if (this.endFlags[r102] != 0) goto L23;
        drawText(r110, String.valueOf(this.newTextArray[r102]), getDrawX(r102), this.textBaseline, this.textPaint);
        if (isCollectEnabled() == false) goto L22;
        if (r102 >= 0) goto L17;
    L19:
        r111 = false;
    L20:
        if (r111 == false) goto L22;
        this.displayedDigits[r102] = this.newTextArray[r102];
        goto L22
    L17:
        if (r102 >= this.displayedDigits.length) goto L19;
    L22:
        this.endFlags[r102] = 2;
        goto L71
    L8:
        r112 = (float) (Math.pow(1.2d, r103) * ((double) this.progress));
        goto L10
    L73:
        if (isCollectEnabled() == false) goto L89;
        char[] r128 = this.displayedDigits;
        if (r128.length != 0) goto L78;
        r101 = true;
    L78:
        if ((!r101) == false) goto L90;
        this.currentDisplayedText = new String(r128);
        return;
    L90:
        return;
    }

    private final float getDrawX(int r100) {
        int r101 = this.commaIndexs.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L13;
        if (((Number) ListProtector.get(this.commaIndexs, r102)).intValue() >= r100) goto L14;
        if (((Number) ListProtector.get(this.commaIndexs, r102)).intValue() >= r100) goto L12;
        if (r102 != (r101 - 1)) goto L12;
        r103 = r101;
    L12:
        r102 = r102 + 1;
    L14:
        float r104 = (this.textPaint.getLetterSpacing() * this.textPaint.getTextSize()) * r100;
        int r105 = this.pointIndex;
        if (r100 > r105) goto L17;
    L20:
        float r106 = this.fontWidth * (r100 - r102);
        float r107 = r102;
        float r108 = this.commaWidth;
    L22:
        return (r106 + (r107 * r108)) + r104;
    L17:
        if (r105 == (-1)) goto L20;
        r106 = (this.fontWidth * ((r100 - 1) - r102)) + this.pointWidth;
        r107 = r102;
        r108 = this.commaWidth;
        goto L22
    L13:
        r102 = r103;
        goto L14
    }

    private final ArrayList<Integer> getScrollNumArray(int r100) {
        int r101 = this.newTextArray[r100] - '0';
        if (isScrollDown() == true) goto L5;
        int r102 = this.lengthGap;
        if (r102 == 0) goto L11;
        if (r102 <= r100) goto L10;
        int r103 = 1;
    L14:
        return generateIntArray(r103, r101, true);
    L10:
        char r104 = this.oldTextArray[r100 - r102];
    L12:
        r103 = r104 - '0';
        goto L14
    L11:
        r104 = this.oldTextArray[r100];
        goto L12
    L5:
        return generateIntArray(this.oldTextArray[r100 + this.lengthGap] - '0', r101, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        String r101 = "";
        if (this.disableAnim == false) goto L15;
        super.onDraw(r100);
        if (isCollectEnabled() == false) goto L27;
        CharSequence r102 = getText();
        if (r102 == null) goto L12;
        String r103 = r102.toString();
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        this.currentDisplayedText = r101;
        this.displayedDigits = r101.toCharArray();
        return;
    L27:
        return;
    L15:
        if (this.firstIn == false) goto L25;
        this.firstIn = false;
        super.onDraw(r100);
        if (isCollectEnabled() == false) goto L25;
        CharSequence r104 = getText();
        if (r104 == null) goto L24;
        String r105 = r104.toString();
        if (r105 == null) goto L24;
        r101 = r105;
    L24:
        this.currentDisplayedText = r101;
        this.displayedDigits = r101.toCharArray();
    L25:
        TextPaint r106 = getPaint();
        this.textPaint = r106;
        r106.setAntiAlias(true);
        Paint.FontMetricsInt r107 = this.textPaint.getFontMetricsInt();
        int r108 = getMeasuredHeight();
        this.textMeasuredHeight = r108;
        int r109 = r108 - r107.bottom;
        int r110 = r107.top;
        this.textBaseline = ((r109 + r110) / 2) - r110;
        float[] r111 = new float[4];
        this.textPaint.getTextWidths("8888", r111);
        this.fontWidth = r111[0];
        this.pointWidth = this.textPaint.measureText(".");
        this.commaWidth = this.textPaint.measureText(",");
        drawNumber(r100);
    }

    public void setTextAnim(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Float r102 = StringsKt.toFloatOrNull(StringsKt.replace$default(r100, ",", "", false, 4, null));
        if (r102 == null) goto L20;
        r102.floatValue();
        String r103 = getText().toString();
        this.oldText = r103;
        this.oldTextArray = r103.toCharArray();
        this.oldTextLength = this.oldText.length();
        if (TextUtils.equals(r100, this.oldText) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return;
    L16:
        if (this.firstIn == false) goto L18;
        postDelayed(new AnonymousClass2(this, r100), 50);
        return;
    L18:
        setTextAnim$executeAnim(this, r100);
        return;
    L20:
        setTextWithoutAnim(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setTextWithoutAnim(String r100) {
        this.disableAnim = true;
        setText(r100);
        if (isCollectEnabled() == false) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        this.currentDisplayedText = r100;
        this.displayedDigits = r100.toCharArray();
        return;
    }

    public CJScrollAnimTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.newText = "";
        this.oldText = "";
        this.newTextArray = new char[0];
        this.oldTextArray = new char[0];
        this.columnScrollArray = new SparseArray();
        this.speedSum = new float[0];
        this.endFlags = new int[0];
        this.scrollFlags = new int[0];
        this.firstIn = true;
        this.animating = true;
        this.textPaint = new Paint();
        this.pointIndex = -1;
        this.commaIndexs = new ArrayList();
        this.displayedDigits = new char[0];
        this.currentDisplayedText = "";
        this.valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animUpdateListener = new CJScrollAnimTextView$animUpdateListener$1(this);
    }

    public static final /* synthetic */ void access$setProgress$p(CJScrollAnimTextView r100, float r101) {
        r100.progress = r101;
    }

    public static final /* synthetic */ void access$setTextAnim$executeAnim(CJScrollAnimTextView r100, String r101) {
        setTextAnim$executeAnim(r100, r101);
    }

    private final void setScrollFlags(String r100, String r101) {
        if (r100.length() == r101.length()) goto L5;
        return;
    L5:
        int r102 = r101.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L10;
        if (r100.charAt(r103) != r101.charAt(r103)) goto L13;
        this.scrollFlags[r103] = -1;
        r103 = r103 + 1;
        goto L6
    L13:
        return;
    }

    private static final void setTextAnim$executeAnim(CJScrollAnimTextView r110, String r111) {
        r110.scrollFlags = new int[r111.length()];
        int r100 = 0;
        r110.scrollOrientation = 0;
        int r101 = 1;
        if ((!StringsKt.isBlank(r110.oldText)) == true) goto L5;
    L22:
        r110.newText = r111;
        r110.newTextLength = r111.length();
        r110.newTextArray = r110.newText.toCharArray();
        if (r110.isCollectEnabled() == false) goto L25;
        r110.displayedDigits = new char[r110.newTextLength];
    L26:
        r110.pointIndex = ArraysKt.indexOf(r110.newTextArray, '.');
        r110.commaIndexs.clear();
        char[] r102 = r110.newTextArray;
        int r103 = r102.length;
        int r104 = 0;
    L27:
        if (r100 >= r103) goto L32;
        int r105 = r104 + 1;
        if (r102[r100] != ',') goto L31;
        r110.commaIndexs.add(Integer.valueOf(r104));
    L31:
        r100 = r100 + 1;
        r104 = r105;
        goto L27
    L32:
        int r106 = r110.pointIndex;
        if (r106 == (-1)) goto L35;
        r110.scrollFlags[r106] = -1;
    L35:
        Iterator<T> r107 = r110.commaIndexs.iterator();
    L37:
        if (r107.hasNext() == false) goto L39;
        r110.scrollFlags[((Number) r107.next()).intValue()] = -1;
        goto L37
    L39:
        r110.lengthGap = Math.abs(r110.oldTextLength - r110.newTextLength);
        r110.setText(r111);
        r110.initColumnScrollSet();
        r110.initSpeeds();
        r110.start();
        return;
    L25:
        r110.displayedDigits = new char[0];
        goto L26
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L22;
        BigDecimal r108 = new BigDecimal(StringsKt.replace$default(r110.oldText, ",", "", false, 4, null));     // Catch: Exception -> L20
        BigDecimal r109 = new BigDecimal(StringsKt.replace$default(r111, ",", "", false, 4, null));     // Catch: Exception -> L20
        if (Intrinsics.areEqual(r108, r109) == false) goto L11;
        r110.setTextWithoutAnim(r111);     // Catch: Exception -> L20
        return;
    L11:
        if (r108.compareTo(r109) > 0) goto L16;
        if (r109.toString().length() < r108.toString().length()) goto L18;
    L17:
        r101 = 0;
    L18:
        r110.scrollOrientation = r101;     // Catch: Exception -> L20
        r110.setScrollFlags(r110.oldText, r111);     // Catch: Exception -> L20
        goto L22
    L16:
        if (r109.toString().length() <= r108.toString().length()) goto L18;
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJScrollAnimTextView#executeAnim", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJScrollAnimTextView#executeAnim", e);
        e.printStackTrace();
        goto L22
    }

    public CJScrollAnimTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.newText = "";
        this.oldText = "";
        this.newTextArray = new char[0];
        this.oldTextArray = new char[0];
        this.columnScrollArray = new SparseArray();
        this.speedSum = new float[0];
        this.endFlags = new int[0];
        this.scrollFlags = new int[0];
        this.firstIn = true;
        this.animating = true;
        this.textPaint = new Paint();
        this.pointIndex = -1;
        this.commaIndexs = new ArrayList();
        this.displayedDigits = new char[0];
        this.currentDisplayedText = "";
        this.valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animUpdateListener = new CJScrollAnimTextView$animUpdateListener$1(this);
    }

    private final ArrayList<Integer> generateIntArray(int r100, int r101, boolean r102) {
        if (r102 == false) goto L9;
        if (r100 > r101) goto L8;
        if (r100 != r101) goto L7;
        List r103 = CollectionsKt.plus(CollectionsKt.toList(new IntRange(r100, 9)), CollectionsKt.toList(new IntRange(0, r101)));
    L12:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Int> }");
        ArrayList<Integer> r104 = (ArrayList) r103;
        ListProtector.add(r104, 0, Integer.valueOf(r100));
        return r104;
    L7:
        r103 = CollectionsKt.toList(new IntRange(r100, r101));
        goto L12
    L8:
        r103 = CollectionsKt.plus(CollectionsKt.toList(new IntRange(r100, 9)), CollectionsKt.toList(new IntRange(0, r101)));
        goto L12
    L9:
        if (r100 > r101) goto L11;
        r103 = CollectionsKt.plus(CollectionsKt.toList(RangesKt.downTo(r100, 0)), CollectionsKt.toList(RangesKt.downTo(9, r101)));
        goto L12
    L11:
        r103 = CollectionsKt.toList(RangesKt.downTo(r100, r101));
        goto L12
    }

    private final void drawText(Canvas r100, String r101, float r102, float r103, Paint r104) {
        int r105 = this.textMeasuredHeight;
        if (r103 >= (-r105)) goto L5;
        return;
    L5:
        if (r103 > (r105 * 2)) goto L9;
        r100.drawText(r101, r102, r103, r104);
        return;
    }
}
