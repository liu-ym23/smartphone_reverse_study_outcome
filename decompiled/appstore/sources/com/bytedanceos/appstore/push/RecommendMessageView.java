package com.bytedanceos.appstore.push;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import g8.a;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendMessageView extends RemoteViews {
    public RecommendMessageView(String r10) {
        super(r10, R.layout.notification_item_for_white);
    }

    public void setSubTitle(CharSequence r10) {
        setViewVisibility(R.id.subtitle, 0);
        setTextViewText(R.id.sub_title, r10);
    }

    public void setTitle(CharSequence r10) {
        setTextViewText(R.id.title, r10);
    }

    public boolean syncResource(a r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        setTitle(r10.j());
        setSubTitle(r10.i());
        Bitmap r11 = r10.e();
        if (r11 == null) goto L8;
        setImageViewBitmap(R.id.icon, r11);
        return true;
    L8:
        setImageViewResource(R.id.icon, R.drawable.push_icon);
        setInt(R.id.icon, "setColorFilter", BaseApplication.c().getResources().getColor(R.color.notification_color_filter));
        return true;
    }
}
