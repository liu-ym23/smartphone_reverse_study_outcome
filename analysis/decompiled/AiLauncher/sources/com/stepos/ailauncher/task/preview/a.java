package com.stepos.ailauncher.task.preview;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/task/preview/a;", "", "<init>", "()V", "Landroid/widget/TextView;", "tv", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;)V", "", "GREETING_COLORS", "[I", "getGREETING_COLORS", "()[I", "", "GREETING_POSITIONS", "[F", "getGREETING_POSITIONS", "()[F", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final int[] GREETING_COLORS = {-1020345, -855638017, TaskChipController.STATIC_TEXT_COLOR};
    private static final float[] GREETING_POSITIONS = {0.07f, 0.53f, 1.0f};

    public final void a(TextView tv) {
        p.i(tv, "tv");
        int width = tv.getWidth();
        int height = tv.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        tv.getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, height, GREETING_COLORS, GREETING_POSITIONS, Shader.TileMode.CLAMP));
        tv.invalidate();
    }
}
