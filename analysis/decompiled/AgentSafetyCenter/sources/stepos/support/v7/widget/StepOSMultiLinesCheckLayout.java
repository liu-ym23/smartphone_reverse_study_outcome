package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.stepos.agentsafetycenter.R;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12636c = false;

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundResource(R.drawable.stepos_alert_dialog_listview_item_bg_radius);
        f12636c = a();
    }

    public static boolean a() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z10) throws Resources.NotFoundException {
        if (!z10) {
            Drawable drawable = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_checked_radius_item_bg);
            WeakHashMap weakHashMap = n3.k0.f8724a;
            setBackground(drawable);
        } else if (f12636c) {
            Drawable drawable2 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg_polestar);
            WeakHashMap weakHashMap2 = n3.k0.f8724a;
            setBackground(drawable2);
        } else {
            Drawable drawable3 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg);
            WeakHashMap weakHashMap3 = n3.k0.f8724a;
            setBackground(drawable3);
        }
    }

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StepOSMultiLinesCheckLayout(Context context) {
        this(context, null);
    }
}
