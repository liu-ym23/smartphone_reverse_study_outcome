package com.bytedance.android.livesdk.interactivity.publicscreen.panel.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes9.dex */
public class PSGradientTextView extends AppCompatTextView {
    public PSGradientTextView(Context r100) {
        this(r100, null);
    }

    public PSGradientTextView(Context r110, AttributeSet r111) {
        super(r110, r111);
        int[] r112 = {-33881, -57461};
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), r112[0], r112[1], Shader.TileMode.CLAMP));
    }
}
