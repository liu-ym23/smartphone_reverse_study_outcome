package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes17.dex */
final class ColorCutQuantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = null;
    final int[] mColors;
    final Palette.Filter[] mFilters;
    final int[] mHistogram;
    final List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl;
    final TimingLogger mTimingLogger;

    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;
        final /* synthetic */ ColorCutQuantizer this$0;

        public final void fitBox() {
            ColorCutQuantizer r100 = this.this$0;
            int[] r101 = r100.mColors;
            int[] r102 = r100.mHistogram;
            int r103 = this.mLowerIndex;
            int r104 = Integer.MAX_VALUE;
            int r105 = Integer.MAX_VALUE;
            int r106 = Integer.MAX_VALUE;
            int r107 = Integer.MIN_VALUE;
            int r108 = Integer.MIN_VALUE;
            int r109 = Integer.MIN_VALUE;
            int r110 = 0;
        L4:
            if (r103 > this.mUpperIndex) goto L19;
            int r111 = r101[r103];
            r110 = r110 + r102[r111];
            int r112 = ColorCutQuantizer.quantizedRed(r111);
            int r113 = ColorCutQuantizer.quantizedGreen(r111);
            int r114 = ColorCutQuantizer.quantizedBlue(r111);
            if (r112 <= r107) goto L8;
            r107 = r112;
        L8:
            if (r112 >= r104) goto L10;
            r104 = r112;
        L10:
            if (r113 <= r108) goto L12;
            r108 = r113;
        L12:
            if (r113 >= r105) goto L14;
            r105 = r113;
        L14:
            if (r114 <= r109) goto L16;
            r109 = r114;
        L16:
            if (r114 >= r106) goto L18;
            r106 = r114;
        L18:
            r103 = r103 + 1;
            goto L4
        L19:
            this.mMinRed = r104;
            this.mMaxRed = r107;
            this.mMinGreen = r105;
            this.mMaxGreen = r108;
            this.mMinBlue = r106;
            this.mMaxBlue = r109;
            this.mPopulation = r110;
        }

        public final Palette.Swatch getAverageColor() {
            ColorCutQuantizer r100 = this.this$0;
            int[] r101 = r100.mColors;
            int[] r102 = r100.mHistogram;
            int r103 = this.mLowerIndex;
            int r104 = 0;
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
        L4:
            if (r103 > this.mUpperIndex) goto L6;
            int r108 = r101[r103];
            int r109 = r102[r108];
            r105 = r105 + r109;
            r104 = r104 + (ColorCutQuantizer.quantizedRed(r108) * r109);
            r106 = r106 + (ColorCutQuantizer.quantizedGreen(r108) * r109);
            r107 = r107 + (r109 * ColorCutQuantizer.quantizedBlue(r108));
            r103 = r103 + 1;
            goto L4
        L6:
            float r110 = r105;
            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(r104 / r110), Math.round(r106 / r110), Math.round(r107 / r110)), r105);
        }

        public final int getColorCount() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        public final int getLongestColorDimension() {
            int r100 = this.mMaxRed - this.mMinRed;
            int r101 = this.mMaxGreen - this.mMinGreen;
            int r102 = this.mMaxBlue - this.mMinBlue;
            if (r100 < r101) goto L7;
            if (r100 < r102) goto L7;
            return -3;
        L7:
            if (r101 < r100) goto L11;
            if (r101 < r102) goto L13;
            return -2;
        L13:
            return -1;
        L11:
            return -1;
        }

        public final int getVolume() {
            return (((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1)) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        public final boolean canSplit() {
            if (getColorCount() > 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final int findSplitPoint() {
            int r100 = getLongestColorDimension();
            ColorCutQuantizer r101 = this.this$0;
            int[] r102 = r101.mColors;
            int[] r103 = r101.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(r102, r100, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(r102, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(r102, r100, this.mLowerIndex, this.mUpperIndex);
            int r104 = this.mPopulation / 2;
            int r105 = this.mLowerIndex;
            int r106 = 0;
        L3:
            int r107 = this.mUpperIndex;
            if (r105 > r107) goto L11;
            r106 = r106 + r103[r102[r105]];
            if (r106 >= r104) goto L8;
            r105 = r105 + 1;
            goto L3
        L8:
            return Math.min(r107 - 1, r105);
        L11:
            return this.mLowerIndex;
        }

        public final Vbox splitBox() {
            if (canSplit() == false) goto L7;
            int r100 = findSplitPoint();
            Vbox r101 = new Vbox(this.this$0, r100 + 1, this.mUpperIndex);
            this.mUpperIndex = r100;
            fitBox();
            return r101;
        L7:
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        public Vbox(ColorCutQuantizer r100, int r101, int r102) {
            this.this$0 = r100;
            this.mLowerIndex = r101;
            this.mUpperIndex = r102;
            fitBox();
        }
    }

    private static int modifyWordWidth(int r100, int r101, int r102) {
        if (r102 <= r101) goto L4;
        int r103 = r100 << (r102 - r101);
    L6:
        return r103 & ((1 << r102) - 1);
    L4:
        r103 = r100 >> (r101 - r102);
        goto L6
    }

    public static int quantizedBlue(int r100) {
        return r100 & 31;
    }

    public static int quantizedGreen(int r100) {
        return (r100 >> 5) & 31;
    }

    public static int quantizedRed(int r100) {
        return (r100 >> 10) & 31;
    }

    static {
        VBOX_COMPARATOR_VOLUME = new AnonymousClass1();
    }

    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private static int approximateToRgb888(int r100) {
        return approximateToRgb888(quantizedRed(r100), quantizedGreen(r100), quantizedBlue(r100));
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Vbox> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Palette.Swatch r103 = r102.next().getAverageColor();
        if (shouldIgnoreColor(r103) == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    private static int quantizeFromRgb888(int r100) {
        int r101 = modifyWordWidth(Color.red(r100), 8, 5);
        int r102 = modifyWordWidth(Color.green(r100), 8, 5);
        return modifyWordWidth(Color.blue(r100), 8, 5) | ((r101 << 10) | (r102 << 5));
    }

    private List<Palette.Swatch> quantizePixels(int r100) {
        PriorityQueue<Vbox> r101 = new PriorityQueue(r100, VBOX_COMPARATOR_VOLUME);
        r101.offer(new Vbox(this, 0, this.mColors.length - 1));
        splitBoxes(r101, r100);
        return generateAverageColors(r101);
    }

    private boolean shouldIgnoreColor(int r100) {
        int r101 = approximateToRgb888(r100);
        ColorUtils.colorToHSL(r101, this.mTempHsl);
        return shouldIgnoreColor(r101, this.mTempHsl);
    }

    private boolean shouldIgnoreColor(Palette.Swatch r100) {
        return shouldIgnoreColor(r100.getRgb(), r100.getHsl());
    }

    private boolean shouldIgnoreColor(int r100, float[] r101) {
        Palette.Filter[] r102 = this.mFilters;
        if (r102 != null) goto L5;
    L13:
        return false;
    L5:
        if (r102.length <= 0) goto L13;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        if (this.mFilters[r104].isAllowed(r100, r101) == false) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return true;
    }

    private void splitBoxes(PriorityQueue<Vbox> r100, int r101) {
    L3:
        if (r100.size() >= r101) goto L9;
        Vbox r102 = r100.poll();
        if (r102 == null) goto L13;
        if (r102.canSplit() == false) goto L14;
        r100.offer(r102.splitBox());
        r100.offer(r102);
        goto L3
    L14:
        return;
    L13:
        return;
    }

    public ColorCutQuantizer(int[] r100, int r101, Palette.Filter[] r102) {
        this.mTempHsl = new float[3];
        this.mTimingLogger = null;
        this.mFilters = r102;
        int[] r103 = new int[32768];
        this.mHistogram = r103;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L6;
        int r106 = quantizeFromRgb888(r100[r105]);
        r100[r105] = r106;
        r103[r106] = r103[r106] + 1;
        r105 = r105 + 1;
        goto L4
    L6:
        int r107 = 0;
        int r108 = 0;
    L7:
        if (r107 >= 32768) goto L17;
        if (r103[r107] <= 0) goto L14;
        if (shouldIgnoreColor(r107) == false) goto L14;
        r103[r107] = 0;
    L14:
        if (r103[r107] <= 0) goto L16;
        r108 = r108 + 1;
    L16:
        r107 = r107 + 1;
        goto L7
    L17:
        int[] r109 = new int[r108];
        this.mColors = r109;
        int r110 = 0;
        int r111 = 0;
    L18:
        if (r110 >= 32768) goto L23;
        if (r103[r110] <= 0) goto L22;
        r109[r111] = r110;
        r111 = r111 + 1;
    L22:
        r110 = r110 + 1;
        goto L18
    L23:
        if (r108 > r101) goto L27;
        this.mQuantizedColors = new ArrayList();
    L25:
        if (r104 >= r108) goto L37;
        int r112 = r109[r104];
        this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(r112), r103[r112]));
        r104 = r104 + 1;
        goto L25
    L37:
        return;
    L27:
        this.mQuantizedColors = quantizePixels(r101);
    }

    public static int approximateToRgb888(int r100, int r101, int r102) {
        return Color.rgb(modifyWordWidth(r100, 5, 8), modifyWordWidth(r101, 5, 8), modifyWordWidth(r102, 5, 8));
    }

    public static void modifySignificantOctet(int[] r100, int r101, int r102, int r103) {
        if (r101 != (-2)) goto L5;
    L9:
        if (r102 > r103) goto L15;
        int r104 = r100[r102];
        int r105 = (quantizedGreen(r104) << 10) | (quantizedRed(r104) << 5);
        r100[r102] = quantizedBlue(r104) | r105;
        r102 = r102 + 1;
        goto L9
    L15:
        return;
    L5:
        if (r101 != (-1)) goto L11;
    L7:
        if (r102 > r103) goto L14;
        int r106 = r100[r102];
        int r107 = (quantizedBlue(r106) << 10) | (quantizedGreen(r106) << 5);
        r100[r102] = quantizedRed(r106) | r107;
        r102 = r102 + 1;
        goto L7
    L14:
        return;
    }
}
