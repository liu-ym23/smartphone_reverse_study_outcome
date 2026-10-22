package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import java.lang.ref.SoftReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AppStatusViewCoordinates {
    public final int btnBaseline;
    public final int btnHeight;
    public final int btnTextColor;
    public final float btnTextSize;
    public final Typeface btnTypeface;
    public final int btnWidth;
    public final int btnX;
    public final int btnY;
    public final int mHeight;
    public final int mWidth;
    public final int progressHeight;
    public final int progressWidth;
    public final int progressX;
    public final int progressY;
    public final int sizeBaseline;
    public final int sizeHeight;
    public final int sizeTextColor;
    public final float sizeTextSize;
    public final Typeface sizeTypeface;
    public final int sizeWidth;
    public final int sizeX;
    public final int sizeY;

    public static class Cache {
        private static Cache mInstance;
        private SparseArray<SoftReference<Bitmap>> mBitmapCache;
        private SparseArray<AppStatusViewCoordinates> mCoordinatesCache;
        private SparseArray<String> mEllipsizeCache;
        private SparseArray<View> mViewCache;

        private Cache() {
            this.mViewCache = new SparseArray();
            this.mCoordinatesCache = new SparseArray();
            this.mEllipsizeCache = new SparseArray();
            this.mBitmapCache = new SparseArray();
        }

        public static Cache getInstance() {
            if (mInstance != null) goto L6;
            mInstance = new Cache();
        L6:
            return mInstance;
        }

        public void clear() {
            this.mViewCache.clear();
            this.mCoordinatesCache.clear();
            this.mEllipsizeCache.clear();
            this.mBitmapCache.clear();
        }

        public Bitmap getBitmap(int r10) {
            if (this.mBitmapCache.get(r10) != null) goto L5;
            return null;
        L5:
            return this.mBitmapCache.get(r10).get();
        }

        public AppStatusViewCoordinates getCoordinates(int r10) {
            return this.mCoordinatesCache.get(r10);
        }

        public String getEllipsize(String r10, float r11, float r12) {
            return this.mEllipsizeCache.get(EllipsizeKey.getKey(r10, r11, r12));
        }

        public View getView(int r10) {
            return this.mViewCache.get(r10);
        }

        public void putBitmap(int r10, Bitmap r11) {
            this.mBitmapCache.put(r10, new SoftReference(r11));
        }

        public void putCoordinates(int r10, AppStatusViewCoordinates r11) {
            this.mCoordinatesCache.put(r10, r11);
        }

        public void putEllipsize(String r10, float r11, float r12) {
            this.mEllipsizeCache.put(EllipsizeKey.getKey(r10, r11, r12), r10);
        }

        public void putView(int r10, View r11) {
            this.mViewCache.put(r10, r11);
        }
    }

    public static final class Config {
        private boolean hasProgress;
        private boolean hasSize;
        private int mHeight;
        private int mWidth;

        public Config() {
        }

        public int getCacheKey() {
            return hashCode();
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public boolean hasProgress() {
            return this.hasProgress;
        }

        public boolean hasSize() {
            return this.hasSize;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Boolean.valueOf(this.hasSize), Boolean.valueOf(this.hasProgress)});
        }

        public Config setHasProgress(boolean r10) {
            this.hasProgress = r10;
            return this;
        }

        public Config setHasSize(boolean r10) {
            this.hasSize = r10;
            return this;
        }

        public Config setHeight(int r10) {
            this.mHeight = r10;
            return this;
        }

        public Config setWidth(int r10) {
            this.mWidth = r10;
            return this;
        }
    }

    public static class EllipsizeKey {
        public EllipsizeKey() {
        }

        public static int getKey(String r10, float r11, float r12) {
            return Objects.hash(new Object[]{r10, Float.valueOf(r11), Float.valueOf(r12)});
        }
    }

    private AppStatusViewCoordinates(Context r10, Config r11, Cache r12) {
        int r13 = R$layout.appstatusview;
        View r14 = r12.getView(r13);
        if (r14 != null) goto L5;
        r14 = LayoutInflater.from(r10).inflate(r13, null, false);
        r12.putView(r13, r14);
    L5:
        TextView r15 = (TextView) r14.findViewById(R$id.appCategorySize);
        TextView r16 = (TextView) r14.findViewById(R$id.appStatusTextView);
        View r17 = r14.findViewById(R$id.appStatusDownloadView);
        r14.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r14.layout(0, 0, r14.getMeasuredWidth(), r14.getMeasuredHeight());
        this.mWidth = r14.getWidth();
        this.mHeight = r14.getHeight();
        this.btnX = getX(r16);
        this.btnY = getY(r16);
        this.btnBaseline = r16.getBaseline();
        this.btnWidth = r16.getWidth();
        this.btnHeight = r16.getHeight();
        this.btnTextColor = r16.getCurrentTextColor();
        this.btnTextSize = r16.getTextSize();
        this.btnTypeface = r16.getTypeface();
        this.sizeX = getX(r15);
        this.sizeY = getY(r15);
        this.sizeBaseline = r15.getBaseline();
        this.sizeWidth = r15.getWidth();
        this.sizeHeight = r15.getHeight();
        this.sizeTextColor = r15.getCurrentTextColor();
        this.sizeTextSize = r15.getTextSize();
        this.sizeTypeface = r15.getTypeface();
        this.progressX = getX(r17);
        this.progressY = getY(r17);
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17.getLayoutParams();
        int r19 = (r14.getMeasuredWidth() - r18.leftMargin) - r18.rightMargin;
        this.progressWidth = r19;
        this.progressHeight = r19;
    }

    public static AppStatusViewCoordinates forConfig(Context r10, Config r11, Cache r12) {
        int r13 = r11.getCacheKey();
        AppStatusViewCoordinates r14 = r12.getCoordinates(r13);
        if (r14 == null) goto L5;
        return r14;
    L5:
        AppStatusViewCoordinates r15 = new AppStatusViewCoordinates(r10.getApplicationContext(), r11, r12);
        r12.putCoordinates(r13, r15);
        return r15;
    }

    private static int getX(View r10) {
        int r11 = 0;
    L3:
        if (r10 == null) goto L5;
        r11 = r11 + ((int) r10.getX());
        r10 = (View) r10.getParent();
        goto L3
    L5:
        return r11;
    }

    private static int getY(View r10) {
        int r11 = 0;
    L3:
        if (r10 == null) goto L5;
        r11 = r11 + ((int) r10.getY());
        r10 = (View) r10.getParent();
        goto L3
    L5:
        return r11;
    }
}
