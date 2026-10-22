package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeTopMoreDialog f112582a;

    public a7(LandscapeTopMoreDialog r100) {
        this.f112582a = r100;
    }

    public final void a() {
        CustomShaderRectView r100 = (CustomShaderRectView) this.f112582a.findViewById(R.id.divider);
        float r101 = 2;
        LinearGradient r110 = new LinearGradient(0.0f, ((CustomShaderRectView) this.f112582a.findViewById(R.id.divider)).getMeasuredHeight() / r101, ((CustomShaderRectView) this.f112582a.findViewById(R.id.divider)).getMeasuredWidth(), ((CustomShaderRectView) this.f112582a.findViewById(R.id.divider)).getMeasuredHeight() / r101, new int[]{16777215, 872415231, 872415231}, new float[]{0.0f, 0.15f, 1.0f}, Shader.TileMode.CLAMP);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "shader");
        Paint r102 = r100.f160807a;
        if (r102 == null) goto L5;
        r102.setShader(r110);
    L5:
        r100.invalidate();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
