package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12572a = false;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        boolean zContains = false;
        setBackgroundResource(R.drawable.stepos_alert_dialog_listview_item_bg_radius);
        try {
            zContains = SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
        }
        f12572a = zContains;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z) throws Resources.NotFoundException {
        if (!z) {
            Drawable drawable = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_checked_radius_item_bg);
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            setBackground(drawable);
        } else if (f12572a) {
            Drawable drawable2 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg_polestar);
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            setBackground(drawable2);
        } else {
            Drawable drawable3 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg);
            WeakHashMap<View, h0> weakHashMap3 = v0.e0.f13274a;
            setBackground(drawable3);
        }
    }
}
