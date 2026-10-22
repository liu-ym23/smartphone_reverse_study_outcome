package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24295a = null;

    static {
        f24295a = new e();
    }

    private e() {
    }

    public final void a(TextView r12) {
        o.e(r12, "<this>");
        float r11 = r12.getPaint().measureText(r12.getText().toString());
        float r3 = (r12.getWidth() - r11) / 2.0f;
        r12.getPaint().setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(r3, 0.0f, r3 + r11, 0.0f, new int[]{((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6")), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_6, "color", "oui_ai_a_color3_6"))}, null, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        r12.invalidate();
    }
}
