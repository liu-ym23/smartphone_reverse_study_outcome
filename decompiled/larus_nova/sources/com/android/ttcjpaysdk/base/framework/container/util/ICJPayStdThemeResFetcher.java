package com.android.ttcjpaysdk.base.framework.container.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH'J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/util/ICJPayStdThemeResFetcher;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "getColor", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "resId", "theme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getThmeStyleId", "isLightTheme", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayStdThemeResFetcher extends ICJTag {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void d(ICJPayStdThemeResFetcher r100, String r101) {
            ICJTag.DefaultImpls.d(r100, r101);
        }

        public static void i(ICJPayStdThemeResFetcher r100, String r101) {
            ICJTag.DefaultImpls.i(r100, r101);
        }

        public static void w(ICJPayStdThemeResFetcher r100, String r101) {
            ICJTag.DefaultImpls.w(r100, r101);
        }

        public static void e(ICJPayStdThemeResFetcher r100, String r101, Throwable r102) {
            ICJTag.DefaultImpls.e(r100, r101, r102);
        }

        public static /* synthetic */ int getColor$default(ICJPayStdThemeResFetcher r100, Context r101, int r102, Theme r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.getColor(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor");
        }

        public static /* synthetic */ Drawable getDrawable$default(ICJPayStdThemeResFetcher r100, Context r101, int r102, Theme r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.getDrawable(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDrawable");
        }
    }

    int getColor(Context r100, int r101, Theme r102);

    Drawable getDrawable(Context r100, int r101, Theme r102);

    int getThmeStyleId(Theme r100);

    boolean isLightTheme(Theme r100);
}
