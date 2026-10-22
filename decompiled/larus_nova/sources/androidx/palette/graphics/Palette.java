package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import androidx.camera.video.AudioStats;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public final class Palette {
    static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    static final Filter DEFAULT_FILTER = null;
    static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    static final String LOG_TAG = "Palette";
    static final boolean LOG_TIMINGS = false;
    static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    private final Swatch mDominantSwatch;
    private final Map<Target, Swatch> mSelectedSwatches;
    private final List<Swatch> mSwatches;
    private final List<Target> mTargets;
    private final SparseBooleanArray mUsedColors;

    public static final class Builder {
        private final Bitmap mBitmap;
        private final List<Filter> mFilters;
        private int mMaxColors;
        private Rect mRegion;
        private int mResizeArea;
        private int mResizeMaxDimension;
        private final List<Swatch> mSwatches;
        private final List<Target> mTargets;

        public Builder clearRegion() {
            this.mRegion = null;
            return this;
        }

        public Builder clearFilters() {
            this.mFilters.clear();
            return this;
        }

        public Builder clearTargets() {
            List<Target> r100 = this.mTargets;
            if (r100 == null) goto L5;
            r100.clear();
        L5:
            return this;
        }

        public Palette generate() {
            Bitmap r100 = this.mBitmap;
            if (r100 == null) goto L16;
            Bitmap r101 = scaleBitmapDown(r100);
            Rect r102 = this.mRegion;
            if (r101 == this.mBitmap) goto L8;
            if (r102 == null) goto L8;
            double r103 = ((double) r101.getWidth()) / ((double) this.mBitmap.getWidth());
            r102.left = (int) Math.floor(((double) r102.left) * r103);
            r102.top = (int) Math.floor(((double) r102.top) * r103);
            r102.right = Math.min((int) Math.ceil(((double) r102.right) * r103), r101.getWidth());
            r102.bottom = Math.min((int) Math.ceil(((double) r102.bottom) * r103), r101.getHeight());
        L8:
            int[] r104 = getPixelsFromBitmap(r101);
            int r105 = this.mMaxColors;
            if (this.mFilters.isEmpty() == false) goto L11;
            Filter[] r106 = null;
        L12:
            ColorCutQuantizer r107 = new ColorCutQuantizer(r104, r105, r106);
            if (r101 == this.mBitmap) goto L15;
            r101.recycle();
        L15:
            List<Swatch> r108 = r107.getQuantizedColors();
        L18:
            Palette r109 = new Palette(r108, this.mTargets);
            r109.generate();
            return r109;
        L11:
            List<Filter> r110 = this.mFilters;
            r106 = (Filter[]) r110.toArray(new Filter[r110.size()]);
            goto L12
        L16:
            r108 = this.mSwatches;
            if (r108 != null) goto L18;
            throw new AssertionError();
        }

        public Builder(Bitmap r100) {
            ArrayList r101 = new ArrayList();
            this.mTargets = r101;
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            ArrayList r102 = new ArrayList();
            this.mFilters = r102;
            if (r100 == null) goto L9;
            if (r100.isRecycled() == true) goto L9;
            r102.add(Palette.DEFAULT_FILTER);
            this.mBitmap = r100;
            this.mSwatches = null;
            r101.add(Target.LIGHT_VIBRANT);
            r101.add(Target.VIBRANT);
            r101.add(Target.DARK_VIBRANT);
            r101.add(Target.LIGHT_MUTED);
            r101.add(Target.MUTED);
            r101.add(Target.DARK_MUTED);
            return;
        L9:
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private int[] getPixelsFromBitmap(Bitmap r110) {
            int r100 = r110.getWidth();
            int r101 = r110.getHeight();
            int[] r102 = new int[r100 * r101];
            r110.getPixels(r102, 0, r100, 0, 0, r100, r101);
            Rect r111 = this.mRegion;
            if (r111 != null) goto L5;
            return r102;
        L5:
            int r112 = r111.width();
            int r103 = this.mRegion.height();
            int[] r104 = new int[r112 * r103];
            int r105 = 0;
        L6:
            if (r105 >= r103) goto L8;
            Rect r106 = this.mRegion;
            System.arraycopy(r102, ((r106.top + r105) * r100) + r106.left, r104, r105 * r112, r112);
            r105 = r105 + 1;
            goto L6
        L8:
            return r104;
        }

        private Bitmap scaleBitmapDown(Bitmap r100) {
            double r101 = -1.0d;
            if (this.mResizeArea <= 0) goto L8;
            int r102 = r100.getWidth() * r100.getHeight();
            int r103 = this.mResizeArea;
            if (r102 <= r103) goto L13;
            r101 = Math.sqrt(((double) r103) / ((double) r102));
        L13:
            if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
            return r100;
        L16:
            return Bitmap.createScaledBitmap(r100, (int) Math.ceil(((double) r100.getWidth()) * r101), (int) Math.ceil(((double) r100.getHeight()) * r101), false);
        L8:
            if (this.mResizeMaxDimension <= 0) goto L13;
            int r104 = Math.max(r100.getWidth(), r100.getHeight());
            int r105 = this.mResizeMaxDimension;
            if (r104 <= r105) goto L13;
            r101 = ((double) r105) / ((double) r104);
            goto L13
        }

        public Builder addFilter(Filter r100) {
            if (r100 == null) goto L4;
            this.mFilters.add(r100);
        L4:
            return this;
        }

        public Builder addTarget(Target r100) {
            if (this.mTargets.contains(r100) == true) goto L5;
            this.mTargets.add(r100);
        L5:
            return this;
        }

        public AsyncTask<Bitmap, Void, Palette> generate(final PaletteAsyncListener r100) {
            if (r100 == null) goto L6;
            return new AnonymousClass1(this, r100).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.mBitmap});
        L6:
            throw new IllegalArgumentException("listener can not be null");
        }

        public Builder maximumColorCount(int r100) {
            this.mMaxColors = r100;
            return this;
        }

        public Builder resizeBitmapArea(int r100) {
            this.mResizeArea = r100;
            this.mResizeMaxDimension = -1;
            return this;
        }

        public Builder resizeBitmapSize(int r100) {
            this.mResizeMaxDimension = r100;
            this.mResizeArea = -1;
            return this;
        }

        public Builder(List<Swatch> r100) {
            this.mTargets = new ArrayList();
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            ArrayList r101 = new ArrayList();
            this.mFilters = r101;
            if (r100 == null) goto L9;
            if (r100.isEmpty() == true) goto L9;
            r101.add(Palette.DEFAULT_FILTER);
            this.mSwatches = r100;
            this.mBitmap = null;
            return;
        L9:
            throw new IllegalArgumentException("List of Swatches is not valid");
        }

        public Builder setRegion(int r100, int r101, int r102, int r103) {
            if (this.mBitmap != null) goto L5;
        L12:
            return this;
        L5:
            if (this.mRegion != null) goto L7;
            this.mRegion = new Rect();
        L7:
            this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
            if (this.mRegion.intersect(r100, r101, r102, r103) == true) goto L12;
            throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
        }
    }

    public interface Filter {
        boolean isAllowed(int r100, float[] r101);
    }

    public interface PaletteAsyncListener {
        void onGenerated(Palette r100);
    }

    public static final class Swatch {
        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        private float[] mHsl;
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        private void ensureTextColorsGenerated() {
            if (this.mGeneratedTextColors == true) goto L23;
            int r100 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, Palette.MIN_CONTRAST_BODY_TEXT);
            int r101 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
            if (r100 == (-1)) goto L9;
            if (r101 == (-1)) goto L9;
            this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, r100);
            this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, r101);
            this.mGeneratedTextColors = true;
            return;
        L9:
            int r102 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, Palette.MIN_CONTRAST_BODY_TEXT);
            int r103 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 3.0f);
            if (r102 == (-1)) goto L14;
            if (r103 == (-1)) goto L14;
            this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, r102);
            this.mTitleTextColor = ColorUtils.setAlphaComponent(-16777216, r103);
            this.mGeneratedTextColors = true;
            return;
        L14:
            if (r100 == (-1)) goto L16;
            int r104 = ColorUtils.setAlphaComponent(-1, r100);
        L17:
            this.mBodyTextColor = r104;
            if (r101 == (-1)) goto L20;
            int r105 = ColorUtils.setAlphaComponent(-1, r101);
        L21:
            this.mTitleTextColor = r105;
            this.mGeneratedTextColors = true;
            return;
        L20:
            r105 = ColorUtils.setAlphaComponent(-16777216, r103);
            goto L21
        L16:
            r104 = ColorUtils.setAlphaComponent(-16777216, r102);
            goto L17
        }

        public float[] getHsl() {
            if (this.mHsl != null) goto L5;
            this.mHsl = new float[3];
        L5:
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            return this.mHsl;
        }

        public int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }

        public int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        public int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        public int getPopulation() {
            return this.mPopulation;
        }

        public int getRgb() {
            return this.mRgb;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (Swatch.class != r100.getClass()) goto L17;
            Swatch r101 = (Swatch) r100;
            if (this.mPopulation == r101.mPopulation) goto L13;
        L15:
            return false;
        L13:
            if (this.mRgb != r101.mRgb) goto L15;
            return true;
        }

        public Swatch(int r100, int r101) {
            this.mRed = Color.red(r100);
            this.mGreen = Color.green(r100);
            this.mBlue = Color.blue(r100);
            this.mRgb = r100;
            this.mPopulation = r101;
        }

        public Swatch(float[] r100, int r101) {
            this(ColorUtils.HSLToColor(r100), r101);
            this.mHsl = r100;
        }

        public Swatch(int r100, int r101, int r102, int r103) {
            this.mRed = r100;
            this.mGreen = r101;
            this.mBlue = r102;
            this.mRgb = Color.rgb(r100, r101, r102);
            this.mPopulation = r103;
        }
    }

    static {
        DEFAULT_FILTER = new AnonymousClass1();
    }

    private Swatch findDominantSwatch() {
        int r100 = this.mSwatches.size();
        int r101 = Integer.MIN_VALUE;
        Swatch r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L8;
        Swatch r104 = (Swatch) ListProtector.get(this.mSwatches, r103);
        if (r104.getPopulation() <= r101) goto L7;
        r101 = r104.getPopulation();
        r102 = r104;
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r102;
    }

    public void generate() {
        int r100 = this.mTargets.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        Target r102 = (Target) ListProtector.get(this.mTargets, r101);
        r102.normalizeWeights();
        this.mSelectedSwatches.put(r102, generateScoredTarget(r102));
        r101 = r101 + 1;
        goto L3
    L5:
        this.mUsedColors.clear();
    }

    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.mTargets);
    }

    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }

    public Swatch getDominantSwatch() {
        return this.mDominantSwatch;
    }

    public static Palette from(List<Swatch> r100) {
        return new Builder(r100).generate();
    }

    public static Palette generate(Bitmap r100) {
        return from(r100).generate();
    }

    private Swatch generateScoredTarget(Target r100) {
        Swatch r101 = getMaxScoredSwatchForTarget(r100);
        if (r101 != null) goto L5;
    L7:
        return r101;
    L5:
        if (r100.isExclusive() == false) goto L7;
        this.mUsedColors.append(r101.getRgb(), true);
        goto L7
    }

    private Swatch getMaxScoredSwatchForTarget(Target r100) {
        int r101 = this.mSwatches.size();
        float r102 = 0.0f;
        Swatch r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L12;
        Swatch r105 = (Swatch) ListProtector.get(this.mSwatches, r104);
        if (shouldBeScoredForTarget(r105, r100) == false) goto L11;
        float r106 = generateScore(r105, r100);
        if (r103 != null) goto L9;
    L10:
        r103 = r105;
        r102 = r106;
        goto L11
    L9:
        if (r106 > r102) goto L10;
    L11:
        r104 = r104 + 1;
        goto L3
    L12:
        return r103;
    }

    public int getDarkMutedColor(int r100) {
        return getColorForTarget(Target.DARK_MUTED, r100);
    }

    public int getDarkVibrantColor(int r100) {
        return getColorForTarget(Target.DARK_VIBRANT, r100);
    }

    public int getDominantColor(int r100) {
        Swatch r101 = this.mDominantSwatch;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r101.getRgb();
    }

    public int getLightMutedColor(int r100) {
        return getColorForTarget(Target.LIGHT_MUTED, r100);
    }

    public int getLightVibrantColor(int r100) {
        return getColorForTarget(Target.LIGHT_VIBRANT, r100);
    }

    public int getMutedColor(int r100) {
        return getColorForTarget(Target.MUTED, r100);
    }

    public Swatch getSwatchForTarget(Target r100) {
        return this.mSelectedSwatches.get(r100);
    }

    public int getVibrantColor(int r100) {
        return getColorForTarget(Target.VIBRANT, r100);
    }

    public static Builder from(Bitmap r100) {
        return new Builder(r100);
    }

    public Palette(List<Swatch> r100, List<Target> r101) {
        this.mSwatches = r100;
        this.mTargets = r101;
        this.mUsedColors = new SparseBooleanArray();
        this.mSelectedSwatches = new ArrayMap();
        this.mDominantSwatch = findDominantSwatch();
    }

    public static Palette generate(Bitmap r100, int r101) {
        return from(r100).maximumColorCount(r101).generate();
    }

    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap r100, PaletteAsyncListener r101) {
        return from(r100).generate(r101);
    }

    private float generateScore(Swatch r100, Target r101) {
        float[] r102 = r100.getHsl();
        Swatch r103 = this.mDominantSwatch;
        if (r103 == null) goto L5;
        int r104 = r103.getPopulation();
    L6:
        float r105 = 0.0f;
        if (r101.getSaturationWeight() <= 0.0f) goto L9;
        float r106 = r101.getSaturationWeight() * (1.0f - Math.abs(r102[1] - r101.getTargetSaturation()));
    L11:
        if (r101.getLightnessWeight() <= 0.0f) goto L13;
        float r107 = r101.getLightnessWeight() * (1.0f - Math.abs(r102[2] - r101.getTargetLightness()));
    L15:
        if (r101.getPopulationWeight() <= 0.0f) goto L18;
        r105 = r101.getPopulationWeight() * (r100.getPopulation() / r104);
    L18:
        return (r106 + r107) + r105;
    L13:
        r107 = 0.0f;
        goto L15
    L9:
        r106 = 0.0f;
        goto L11
    L5:
        r104 = 1;
        goto L6
    }

    private boolean shouldBeScoredForTarget(Swatch r100, Target r101) {
        float[] r102 = r100.getHsl();
        if (r102[1] >= r101.getMinimumSaturation()) goto L5;
    L13:
        return false;
    L5:
        if (r102[1] > r101.getMaximumSaturation()) goto L13;
        if (r102[2] < r101.getMinimumLightness()) goto L13;
        if (r102[2] > r101.getMaximumLightness()) goto L13;
        if (this.mUsedColors.get(r100.getRgb()) == true) goto L13;
        return true;
    }

    public int getColorForTarget(Target r100, int r101) {
        Swatch r102 = getSwatchForTarget(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getRgb();
    }

    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap r100, int r101, PaletteAsyncListener r102) {
        return from(r100).maximumColorCount(r101).generate(r102);
    }
}
