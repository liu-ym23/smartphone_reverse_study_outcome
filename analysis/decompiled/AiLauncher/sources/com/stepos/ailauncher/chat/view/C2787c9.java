package com.stepos.ailauncher.chat.view;

import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$string;
import kotlin.Metadata;
import r9.C5227b;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/c9;", "", "<init>", "()V", "", "env", "", "c", "(Ljava/lang/String;)Z", "Landroid/widget/TextView;", "target", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;Ljava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.c9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2787c9 {
    public static final C2787c9 INSTANCE = new C2787c9();

    public static final int b(float f10, int i10) {
        return C5227b.b(i10 * f10);
    }

    public final void a(TextView target, String env) {
        kotlin.jvm.internal.p.i(target, "target");
        boolean zC = c(env);
        target.setText(zC ? R$string.test_space_env_prod : R$string.amoo_tag_testing);
        target.setTextColor(zC ? -13253553 : -1);
        target.setBackgroundResource(zC ? R$drawable.bg_test_space_env_prod : R$drawable.bg_test_space_env_test);
        float f10 = target.getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = target.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = b(f10, 16);
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(b(f10, 4));
        }
        target.setLayoutParams(layoutParams);
        target.setMinWidth(b(f10, 28));
        target.setPaddingRelative(b(f10, 3), 0, b(f10, 3), b(f10, 1));
        target.setGravity(17);
        target.setIncludeFontPadding(false);
        target.setMaxLines(1);
        target.setTextSize(2, 9.0f);
        target.setLineHeight(C5227b.b(TypedValue.applyDimension(2, 13.0f, target.getResources().getDisplayMetrics())));
        target.setTypeface(Typeface.create(target.getTypeface(), 500, false));
        target.setVisibility(0);
    }

    public final boolean c(String env) {
        return kotlin.jvm.internal.p.d(env, "prod");
    }
}
