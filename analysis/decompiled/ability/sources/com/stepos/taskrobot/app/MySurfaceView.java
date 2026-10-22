package com.stepos.taskrobot.app;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/taskrobot/app/MySurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Pair;", "", "getScreenWidthHeight", "()Lkotlin/Pair;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MySurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.f(context, "context");
        new Paint(1).setTextSize(48.0f);
        getHolder().addCallback(this);
        getHolder().setFormat(1);
        Pair<Integer, Integer> screenWidthHeight = getScreenWidthHeight();
        getHolder().setFixedSize(((Number) screenWidthHeight.f4886a).intValue(), ((Number) screenWidthHeight.b).intValue());
        setKeepScreenOn(true);
    }

    public final Pair<Integer, Integer> getScreenWidthHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = getContext().getSystemService("window");
        k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder holder, int i, int i6, int i10) {
        k.f(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder holder) {
        k.f(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder holder) {
        k.f(holder, "holder");
    }
}
