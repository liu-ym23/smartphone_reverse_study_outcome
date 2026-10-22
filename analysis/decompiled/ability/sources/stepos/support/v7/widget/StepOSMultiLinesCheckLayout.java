package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import com.stepos.ability.R;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6511a = false;

    public StepOSMultiLinesCheckLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBackgroundResource(R.drawable.stepos_alert_dialog_listview_item_bg_radius);
        f6511a = a();
    }

    public static boolean a() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", EnvironmentCompat.MEDIA_UNKNOWN).contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z10) {
        if (!z10) {
            ViewCompat.setBackground(this, getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_checked_radius_item_bg));
        } else if (f6511a) {
            ViewCompat.setBackground(this, getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg_polestar));
        } else {
            ViewCompat.setBackground(this, getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg));
        }
    }
}
