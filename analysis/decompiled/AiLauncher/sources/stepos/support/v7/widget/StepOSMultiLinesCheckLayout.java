package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.N;
import stepos.support.v7.appcompat.R$drawable;

/* loaded from: classes5.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f41300b = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f41301a;

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean b() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a() {
        return this.f41301a;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z10) {
        this.f41301a = z10;
        if (!z10) {
            N.m0(this, getResources().getDrawable(R$drawable.stepos_alert_dialog_multi_lines_checked_radius_item_bg));
        } else if (f41300b) {
            N.m0(this, getResources().getDrawable(R$drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg_polestar));
        } else {
            N.m0(this, getResources().getDrawable(R$drawable.stepos_alert_dialog_multi_lines_normal_radius_item_bg));
        }
    }

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41301a = false;
        setBackgroundResource(com.stepos.common.R$drawable.stepos_alert_dialog_listview_item_bg_radius);
        f41300b = b();
    }
}
