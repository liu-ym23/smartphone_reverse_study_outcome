package com.bytedance.android.live.core.utils;

import android.app.Activity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public class SlideFinishUtil {
    public static SettingKey<Boolean> enableSlideFinish;
    static Set<Class<? extends Activity>> list;

    public static class SlideFinishPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }
    }

    static {
        enableSlideFinish = new SettingKey("enable_slide_finish", Boolean.FALSE, "右滑退出页面");
        list = new HashSet();
    }

    private SlideFinishUtil() {
    }

    public static void disable(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Class<?> r101 = r100.getClass();
        list.add((Class<? extends Activity>) r101);
    }
}
