package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class SeparatorView extends LinearLayout {
    private TextView mSubTitle;
    private TextView mTitle;

    public SeparatorView(Context context) {
        this(context, null);
    }

    public SeparatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeparatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOrientation(0);
        setGravity(80);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        View r1 = LayoutInflater.from(context).inflate(R.layout.separator_view_layout, this, true);
        this.mTitle = (TextView) r1.findViewById(R.id.title);
        this.mSubTitle = (TextView) r1.findViewById(R.id.subtitle);
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setSubTitle(CharSequence subTitle) {
        if (subTitle == null) goto L4;
        setSubTitle(subTitle.toString());
        return;
    L4:
        setSubTitle(null);
    }

    public void setSubTitle(String subTitle) {
        this.mSubTitle.setText(subTitle);
    }

    public void setTitleColor(int colorValue) {
        this.mTitle.setTextColor(colorValue);
    }

    public void setSubTitleColor(int colorValue) {
        this.mSubTitle.setTextColor(colorValue);
    }

    public void setTitleSize(float size) {
        this.mTitle.setTextSize(0, size);
    }

    public void setSubTitleSize(float size) {
        this.mSubTitle.setTextSize(0, size);
    }
}
