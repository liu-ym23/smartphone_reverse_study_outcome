package obric.widget.tabswitcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class EditTabBar extends FrameLayout {
    public EditTabBar(Context context) {
        this(context, null, 0);
    }

    public EditTabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditTabBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(getContext()).inflate(R.layout.sb_editable_tab_bar, this, true);
    }
}
