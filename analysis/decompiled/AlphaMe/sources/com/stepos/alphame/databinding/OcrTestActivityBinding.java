package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class OcrTestActivityBinding {

    @NonNull
    public final Button btnByte;

    @NonNull
    public final Button btnCut;

    @NonNull
    public final Button btnDetect;

    @NonNull
    public final Button btnPath;

    @NonNull
    public final Button btnPoint;

    @NonNull
    public final Button btnUri;

    @NonNull
    public final ImageView ivCut;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final TextView tvResult;

    private OcrTestActivityBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull Button button5, @NonNull Button button6, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.btnByte = button;
        this.btnCut = button2;
        this.btnDetect = button3;
        this.btnPath = button4;
        this.btnPoint = button5;
        this.btnUri = button6;
        this.ivCut = imageView;
        this.tvResult = textView;
    }

    @NonNull
    public static OcrTestActivityBinding bind(@NonNull View view) {
        int i4 = R.id.btn_byte;
        Button button = (Button) h.n(i4, view);
        if (button != null) {
            i4 = R.id.btn_cut;
            Button button2 = (Button) h.n(i4, view);
            if (button2 != null) {
                i4 = R.id.btn_detect;
                Button button3 = (Button) h.n(i4, view);
                if (button3 != null) {
                    i4 = R.id.btn_path;
                    Button button4 = (Button) h.n(i4, view);
                    if (button4 != null) {
                        i4 = R.id.btn_point;
                        Button button5 = (Button) h.n(i4, view);
                        if (button5 != null) {
                            i4 = R.id.btn_uri;
                            Button button6 = (Button) h.n(i4, view);
                            if (button6 != null) {
                                i4 = R.id.iv_cut;
                                ImageView imageView = (ImageView) h.n(i4, view);
                                if (imageView != null) {
                                    i4 = R.id.tv_result;
                                    TextView textView = (TextView) h.n(i4, view);
                                    if (textView != null) {
                                        return new OcrTestActivityBinding((RelativeLayout) view, button, button2, button3, button4, button5, button6, imageView, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static OcrTestActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OcrTestActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.ocr_test_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
