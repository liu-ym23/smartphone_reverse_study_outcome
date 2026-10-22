package stepos.support.v7.widget;

import android.content.Context;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.H;

/* loaded from: classes.dex */
public class StepOSMultiLinesCheckLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f21680b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f21681a;

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static boolean b() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a() {
        return this.f21681a;
    }

    public void setChecked(boolean z5) {
        this.f21681a = z5;
        if (!z5) {
            H.o0(this, getResources().getDrawable(X4.e.f5936j));
        } else if (f21680b) {
            H.o0(this, getResources().getDrawable(X4.e.f5938l));
        } else {
            H.o0(this, getResources().getDrawable(X4.e.f5937k));
        }
    }

    public StepOSMultiLinesCheckLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21681a = false;
        setBackgroundResource(H1.g.f2194j);
        f21680b = b();
    }
}
