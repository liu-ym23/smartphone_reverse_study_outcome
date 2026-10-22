package androidx.webkit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class TracingConfig {
    public static final int CATEGORIES_ALL = 1;
    public static final int CATEGORIES_ANDROID_WEBVIEW = 2;
    public static final int CATEGORIES_FRAME_VIEWER = 64;
    public static final int CATEGORIES_INPUT_LATENCY = 8;
    public static final int CATEGORIES_JAVASCRIPT_AND_RENDERING = 32;
    public static final int CATEGORIES_NONE = 0;
    public static final int CATEGORIES_RENDERING = 16;
    public static final int CATEGORIES_WEB_DEVELOPER = 4;
    public static final int RECORD_CONTINUOUSLY = 1;
    public static final int RECORD_UNTIL_FULL = 0;
    private final List<String> mCustomIncludedCategories;
    private int mPredefinedCategories;
    private int mTracingMode;

    public static class Builder {
        private final List<String> mCustomIncludedCategories;
        private int mPredefinedCategories;
        private int mTracingMode;

        public TracingConfig build() {
            return new TracingConfig(this.mPredefinedCategories, this.mCustomIncludedCategories, this.mTracingMode);
        }

        public Builder() {
            this.mPredefinedCategories = 0;
            this.mCustomIncludedCategories = new ArrayList();
            this.mTracingMode = 1;
        }

        public Builder addCategories(int... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            this.mPredefinedCategories = r100[r102] | this.mPredefinedCategories;
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder setTracingMode(int r100) {
            this.mTracingMode = r100;
            return this;
        }

        public Builder addCategories(String... r100) {
            this.mCustomIncludedCategories.addAll(Arrays.asList(r100));
            return this;
        }

        public Builder addCategories(Collection<String> r100) {
            this.mCustomIncludedCategories.addAll(r100);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PredefinedCategories {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TracingMode {
    }

    public List<String> getCustomIncludedCategories() {
        return this.mCustomIncludedCategories;
    }

    public int getPredefinedCategories() {
        return this.mPredefinedCategories;
    }

    public int getTracingMode() {
        return this.mTracingMode;
    }

    public TracingConfig(int r100, List<String> r101, int r102) {
        ArrayList r103 = new ArrayList();
        this.mCustomIncludedCategories = r103;
        this.mPredefinedCategories = r100;
        r103.addAll(r101);
        this.mTracingMode = r102;
    }
}
