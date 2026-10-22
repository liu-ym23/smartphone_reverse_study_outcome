package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.common.picker.WheelPicker;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17795a;

    /* renamed from: b, reason: collision with root package name */
    public final WheelPicker f17796b;

    private v(FrameLayout frameLayout, WheelPicker wheelPicker) {
        this.f17795a = frameLayout;
        this.f17796b = wheelPicker;
    }

    public static v a(View view) {
        WheelPicker wheelPicker = (WheelPicker) C0756a.a(view, R.id.picker);
        if (wheelPicker != null) {
            return new v((FrameLayout) view, wheelPicker);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.picker)));
    }

    public static v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.scroll_text_age, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.f17795a;
    }
}
