package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RadioGroup extends android.widget.RadioGroup {
    private List<RadioShadowButton> mRadioButtonList;
    private BytedanceRadioTabGroupCallback mRadioTabGroupCallback;
    private int mTextListReference;
    private int mWidth;

    public interface BytedanceRadioTabGroupCallback {
        void onRadioTabClick(int position);
    }

    static /* synthetic */ BytedanceRadioTabGroupCallback access$000(RadioGroup r0) {
        return r0.mRadioTabGroupCallback;
    }

    public void setBytedanceRadioGroupCallback(BytedanceRadioTabGroupCallback callback) {
        this.mRadioTabGroupCallback = callback;
    }

    public RadioGroup(Context context) {
        this(context, null);
    }

    public RadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.BytedanceRadioTabGroup);
        this.mTextListReference = r2.getResourceId(R.styleable.BytedanceRadioTabGroup_contentArray, -1);
        r2.recycle();
        setOrientation(0);
        setGravity(17);
        if (this.mTextListReference <= 0) goto L6;
        setRadioList(getContext().getResources().getStringArray(this.mTextListReference));
        setRadioCheckedPosition(0);
        return;
    }

    public void setmRadioTextList(int listStringRef) {
        if (listStringRef > 0) goto L9;
        return;
    L9:
        setRadioList(getContext().getResources().getStringArray(listStringRef));     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setRadioList(String... radioText) {
        if (radioText != null) goto L4;
        return;
    L4:
        if (radioText.length <= 0) goto L21;
        removeAllViews();
        this.mRadioButtonList = new ArrayList(radioText.length);
        int r0 = radioText.length;
        int r1 = getRadioButtonWidth(radioText) * r0;
        if (r0 != 2) goto L10;
        this.mWidth = Math.max(r1, getResources().getDimensionPixelOffset(R.dimen.radio_group_width_2tabs));
    L13:
        int r2 = 0;
    L15:
        if (r2 >= radioText.length) goto L17;
        RadioShadowButton r3 = new RadioShadowButton(getContext());
        this.mRadioButtonList.add(r3);
        initRadioButtonStyle(r3, r2, radioText);
        r2 = r2 + 1;
        goto L15
    L17:
        setGroupWidth();
        setRadioCheckedPosition(0);
        return;
    L10:
        if (r0 != 3) goto L12;
        this.mWidth = Math.max(r1, getResources().getDimensionPixelOffset(R.dimen.radio_group_width_3tabs));
        goto L13
    L12:
        this.mWidth = r1;
        goto L13
    }

    private void setGroupWidth() {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new RelativeLayout.LayoutParams(this.mWidth, -2);
    L6:
        setLayoutParams(r0);
        return;
    L5:
        r0.width = this.mWidth;
        goto L6
    }

    private void initRadioButtonStyle(RadioShadowButton radioButton, final int position, String... radioText) {
        if (radioText != null) goto L4;
        return;
    L4:
        if (radioText.length <= 0) goto L9;
        radioButton.setText(radioText[position]);
        radioButton.setGravity(17);
        radioButton.setButtonDrawable(0);
        radioButton.setSingleLine();
        radioButton.setEllipsize(TextUtils.TruncateAt.END);
        radioButton.setTypeface(Typeface.DEFAULT_BOLD);
        radioButton.setShadowColorState(getContext().getResources().getColorStateList(R.color.selector_obric_radio_btn_text_shadow_colorlist), 0.0f, -2.0f, 0.1f);
        radioButton.setTextColor(getContext().getResources().getColorStateList(R.color.selector_obric_radio_btn_text_colorlist));
        radioButton.setTextSize(0, getContext().getResources().getDimension(R.dimen.semi_small_text_size));
        radioButton.setBackgroundResource(getBackgroundRes(position, radioText));
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(this.mWidth / radioText.length, -2);
        r0.weight = 1.0f;
        addView(radioButton, position, r0);
        radioButton.setOnClickListener(new AnonymousClass1(this, position));
        return;
    }

    private int getBackgroundRes(int position, String... radioText) {
        if (radioText.length == 1) goto L5;
        if (position != 0) goto L10;
        return R.drawable.selector_obric_radio_group_left;
    L10:
        if (position != (radioText.length - 1)) goto L14;
        return R.drawable.selector_obric_radio_group_right;
    L14:
        return R.drawable.selector_obric_radio_group_middle;
    L5:
        return R.drawable.selector_obric_radio_group_middle;
    }

    private float getTextWidth(String str) {
        Paint r0 = new Paint();
        r0.setTextSize(getResources().getDimensionPixelSize(R.dimen.semi_small_text_size));
        return r0.measureText(str);
    }

    private int getRadioButtonWidth(String... radioText) {
        int r0 = 0;
        float r2 = 0.0f;
        int r1 = 0;
    L4:
        if (r0 >= radioText.length) goto L9;
        float r3 = getTextWidth(radioText[r0]);
        if (r3 <= r2) goto L8;
        r1 = r0;
        r2 = r3;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        StateListDrawable r5 = (StateListDrawable) getResources().getDrawable(getBackgroundRes(r1, radioText));
        Rect r6 = new Rect();
        r5.getPadding(r6);
        return Math.round((r2 + r6.left) + r6.right);
    }

    public void setRadioCheckedPosition(int position) {
        List<RadioShadowButton> r0 = this.mRadioButtonList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() < 0) goto L15;
        if (position >= 0) goto L9;
        return;
    L9:
        if (position > this.mRadioButtonList.size()) goto L16;
        this.mRadioButtonList.get(position).setChecked(true);
        return;
    L16:
        return;
    }

    public void setAvailWidth(int availWidth) {
        this.mWidth = availWidth;
        setGroupWidth();
    }
}
