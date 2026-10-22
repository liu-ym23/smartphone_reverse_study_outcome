package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceLandTopToolbarMoreDialog f116305a;

    public g(AudienceLandTopToolbarMoreDialog r100) {
        this.f116305a = r100;
    }

    public final void a() {
        CustomShaderRectView r100 = this.f116305a.R;
        if (r100 == null) goto L9;
        float r101 = 2;
        LinearGradient r102 = new LinearGradient(0.0f, ((CustomShaderRectView) this.f116305a.findViewById(R.id.divider)).getMeasuredHeight() / r101, ((CustomShaderRectView) this.f116305a.findViewById(R.id.divider)).getMeasuredWidth(), ((CustomShaderRectView) this.f116305a.findViewById(R.id.divider)).getMeasuredHeight() / r101, new int[]{16777215, 872415231, 872415231}, new float[]{0.0f, 0.15f, 1.0f}, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullParameter(r102, "shader");
        Paint r103 = r100.f160807a;
        if (r103 == null) goto L7;
        r103.setShader(r102);
    L7:
        r100.invalidate();
        return;
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
