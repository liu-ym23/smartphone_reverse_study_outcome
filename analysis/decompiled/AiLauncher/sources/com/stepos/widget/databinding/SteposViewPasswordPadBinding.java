package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.widget.R;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposViewPasswordPadBinding {
    private final View rootView;
    public final LinearLayout steposPasswordPadBottom;
    public final LinearLayout steposPasswordPadDisplay;
    public final LinearLayout steposPasswordPadDots;
    public final RelativeLayout steposPasswordPadDotsRow;
    public final EditText steposPasswordPadEdit;
    public final ImageView steposPasswordPadInputButton;
    public final StepOSCircleButton steposPasswordPadKeyLeft;
    public final StepOSCircleButton steposPasswordPadKeyRight;
    public final GridLayout steposPasswordPadKeypad;
    public final TextView steposPasswordPadTip;
    public final TextView steposPasswordPadTip2;

    private SteposViewPasswordPadBinding(View view, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, EditText editText, ImageView imageView, StepOSCircleButton stepOSCircleButton, StepOSCircleButton stepOSCircleButton2, GridLayout gridLayout, TextView textView, TextView textView2) {
        this.rootView = view;
        this.steposPasswordPadBottom = linearLayout;
        this.steposPasswordPadDisplay = linearLayout2;
        this.steposPasswordPadDots = linearLayout3;
        this.steposPasswordPadDotsRow = relativeLayout;
        this.steposPasswordPadEdit = editText;
        this.steposPasswordPadInputButton = imageView;
        this.steposPasswordPadKeyLeft = stepOSCircleButton;
        this.steposPasswordPadKeyRight = stepOSCircleButton2;
        this.steposPasswordPadKeypad = gridLayout;
        this.steposPasswordPadTip = textView;
        this.steposPasswordPadTip2 = textView2;
    }

    public static SteposViewPasswordPadBinding bind(View view) {
        int i10 = R.id.stepos_password_pad_bottom;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.stepos_password_pad_display;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.stepos_password_pad_dots;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R.id.stepos_password_pad_dots_row;
                    RelativeLayout relativeLayout = (RelativeLayout) C5437a.a(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.stepos_password_pad_edit;
                        EditText editText = (EditText) C5437a.a(view, i10);
                        if (editText != null) {
                            i10 = R.id.stepos_password_pad_input_button;
                            ImageView imageView = (ImageView) C5437a.a(view, i10);
                            if (imageView != null) {
                                i10 = R.id.stepos_password_pad_key_left;
                                StepOSCircleButton stepOSCircleButton = (StepOSCircleButton) C5437a.a(view, i10);
                                if (stepOSCircleButton != null) {
                                    i10 = R.id.stepos_password_pad_key_right;
                                    StepOSCircleButton stepOSCircleButton2 = (StepOSCircleButton) C5437a.a(view, i10);
                                    if (stepOSCircleButton2 != null) {
                                        i10 = R.id.stepos_password_pad_keypad;
                                        GridLayout gridLayout = (GridLayout) C5437a.a(view, i10);
                                        if (gridLayout != null) {
                                            i10 = R.id.stepos_password_pad_tip;
                                            TextView textView = (TextView) C5437a.a(view, i10);
                                            if (textView != null) {
                                                i10 = R.id.stepos_password_pad_tip2;
                                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                                if (textView2 != null) {
                                                    return new SteposViewPasswordPadBinding(view, linearLayout, linearLayout2, linearLayout3, relativeLayout, editText, imageView, stepOSCircleButton, stepOSCircleButton2, gridLayout, textView, textView2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposViewPasswordPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.stepos_view_password_pad, viewGroup);
        return bind(viewGroup);
    }

    public View getRoot() {
        return this.rootView;
    }
}
