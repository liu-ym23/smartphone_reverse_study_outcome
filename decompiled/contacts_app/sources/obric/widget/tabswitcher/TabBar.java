package obric.widget.tabswitcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class TabBar extends FrameLayout {
    public TabBar(Context context) {
        this(context, null, 0);
    }

    public TabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(getContext()).inflate(R.layout.sb_tab_bar, this, true);
    }
}
