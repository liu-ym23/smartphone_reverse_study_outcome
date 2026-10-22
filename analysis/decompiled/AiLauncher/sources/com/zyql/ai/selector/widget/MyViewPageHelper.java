package com.zyql.ai.selector.widget;

import android.content.res.Resources;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class MyViewPageHelper {
    MScroller scroller;
    ViewPager viewPager;

    public MyViewPageHelper(ViewPager viewPager) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.viewPager = viewPager;
        init();
    }

    private void init() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.scroller = new MScroller(this.viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.viewPager, this.scroller);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public MScroller getScroller() {
        return this.scroller;
    }

    public void setCurrentItem(int i10) throws Resources.NotFoundException {
        setCurrentItem(i10, true);
    }

    public void setCurrentItem(int i10, boolean z10) throws Resources.NotFoundException {
        if (Math.abs(this.viewPager.getCurrentItem() - i10) <= 1) {
            this.scroller.setNoDuration(false);
            this.viewPager.setCurrentItem(i10, z10);
        } else {
            this.scroller.setNoDuration(true);
            this.viewPager.setCurrentItem(i10, z10);
            this.scroller.setNoDuration(false);
        }
    }
}
