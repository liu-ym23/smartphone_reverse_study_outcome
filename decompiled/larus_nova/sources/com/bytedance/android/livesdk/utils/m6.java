package com.bytedance.android.livesdk.utils;

import android.graphics.Color;
import android.util.Property;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes11.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f159081a = null;

    public static final class a extends Property<View, Integer> {
        public a(Class r100) {
            super(r100, "");
        }

        @Override // android.util.Property
        public final Integer get(View r100) {
            View r101 = r100;
            if ((r101 instanceof TextView) == true) goto L5;
            r101 = null;
        L5:
            TextView r102 = (TextView) r101;
            if (r102 == null) goto L9;
            return Integer.valueOf(Color.alpha(r102.getCurrentTextColor()));
        L9:
            return 255;
        }

        @Override // android.util.Property
        public final void set(View r100, Integer r101) {
            View r102 = r100;
            Integer r103 = r101;
            if ((r102 instanceof TextView) == true) goto L5;
            r102 = null;
        L5:
            TextView r104 = (TextView) r102;
            if (r104 == null) goto L10;
            if (r103 == null) goto L11;
            int r105 = r103.intValue();
            int r106 = r104.getCurrentTextColor();
            r104.setTextColor(Color.argb(r105, Color.red(r106), Color.green(r106), Color.blue(r106)));
            return;
        L11:
            return;
        }
    }

    static {
        f159081a = new a(Integer.TYPE);
    }
}
