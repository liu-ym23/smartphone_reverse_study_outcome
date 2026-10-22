package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes5.dex */
public class ListContentItemCustomDark extends ListContentItemCustom {
    private static final String TAG = "ListContentItemCustomDark";
    private int mBackStyle;
    private boolean mDarkStype;

    public ListContentItemCustomDark(Context context) {
        this(context, null);
    }

    public ListContentItemCustomDark(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListContentItemCustomDark(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mDarkStype = false;
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItem, defStyleAttr, 0);
        this.mBackStyle = r3.getInt(R.styleable.ListContentItem_backgroundStyle, -1);
        r3.recycle();
    }

    public void setDarkStype(boolean dark) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setDarkStype " + dark);
        this.mDarkStype = dark;
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setBackgroundResource " + this.mDarkStype);
        if (this.mDarkStype == true) goto L5;
    L16:
        super.setBackgroundResource(resid);
        return;
    L5:
        if (resid != R.drawable.group_list_item_bg_top) goto L8;
        resid = R.drawable.group_list_item_bg_dark_top;
        goto L16
    L8:
        if (resid != R.drawable.group_list_item_bg_bottom) goto L11;
        resid = R.drawable.group_list_item_bg_dark_bottom;
        goto L16
    L11:
        if (resid != R.drawable.group_list_item_bg_mid) goto L14;
        resid = R.drawable.group_list_item_bg_dark_mid;
        goto L16
    L14:
        if (resid != R.drawable.group_list_item_bg_single) goto L16;
        resid = R.drawable.group_list_item_bg_dark_single;
        goto L16
    }
}
