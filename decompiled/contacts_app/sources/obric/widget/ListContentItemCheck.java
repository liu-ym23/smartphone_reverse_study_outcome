package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class ListContentItemCheck extends ListContentItem {
    private final int DEFAULT_ICON_RES;
    private ImageView mSelectedIcon;
    private int mSelectedIconRes;

    public void setCheckedIconLight(boolean light) {
    }

    public ListContentItemCheck(Context context) {
        this(context, null);
    }

    public ListContentItemCheck(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListContentItemCheck(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int r0 = R.drawable.selector_radio_choice;
        this.DEFAULT_ICON_RES = r0;
        this.mSelectedIconRes = r0;
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItemCheck, defStyleAttr, 0);
        int r5 = r4.getResourceId(R.styleable.ListContentItemCheck_selectedIcon, r0);
        this.mSelectedIconRes = r5;
        setSelectedIconRes(r5);
        r4.recycle();
    }

    public void setSelectedIconRes(int res) {
        this.mSelectedIconRes = res;
        ImageView r0 = this.mSelectedIcon;
        if (r0 == null) goto L6;
        r0.setImageResource(res);
        return;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
        ImageView r0 = (ImageView) findViewById(R.id.imageview);
        this.mSelectedIcon = r0;
        r0.setImageResource(this.mSelectedIconRes);
        setChecked(false);
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.list_content_right_image_view;
    }

    public void setChecked(boolean checked) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        ImageView r1 = this.mSelectedIcon;
        if (checked == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        return;
    L8:
        r2 = 8;
        goto L9
    }

    public boolean isChecked() {
        if (this.mIsCustomRightView == false) goto L6;
        return false;
    L6:
        if (this.mSelectedIcon.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setSelected(isChecked());
    }
}
