package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;
import java.util.WeakHashMap;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes2.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14910a = false;

    public StepOSMultiLinesCheckLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBackgroundResource(R.drawable.stepos_alert_dialog_listview_item_bg_radius);
        f14910a = a();
    }

    public static boolean a() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z4) throws Resources.NotFoundException {
        if (!z4) {
            Drawable drawable = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_checked_radius_item_bg);
            WeakHashMap weakHashMap = K.S.f939a;
            setBackground(drawable);
        } else if (f14910a) {
            Drawable drawable2 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg_polestar);
            WeakHashMap weakHashMap2 = K.S.f939a;
            setBackground(drawable2);
        } else {
            Drawable drawable3 = getResources().getDrawable(R.drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg);
            WeakHashMap weakHashMap3 = K.S.f939a;
            setBackground(drawable3);
        }
    }
}
