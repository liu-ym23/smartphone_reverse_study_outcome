package com.bytedance.android.live.soloktv.floatwindow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.live.soloktv.floatwindow.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.floatwindow.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC1539b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f101103a;

        public ViewOnClickListenerC1539b(Function0 r100) {
            this.f101103a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f101103a.invoke();
        }
    }

    static {
    }

    public final void c() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.save_progress_float_view_v2, this);
        setProgressView((CircularProgressView) r100.findViewById(R.id.iv_loading));
        setProgressText((TextView) r100.findViewById(R.id.tv_progress));
        setProgressBgImage((HSImageView) r100.findViewById(R.id.progress_bg_image));
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final Bitmap b(Bitmap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Bitmap r101 = Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), (int) (r100.getWidth() * 1.3333334f));
        Canvas r102 = new Canvas(r101);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        Rect r104 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        r102.drawRoundRect(new RectF(r104), s1.e(30.0f), s1.e(30.0f), r103);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r102.drawBitmap(r100, r104, r104, r103);
        return r101;
    }

    @Override // com.bytedance.android.live.soloktv.floatwindow.a
    public void setCancelListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        setOnClickListener(new ViewOnClickListenerC1539b(r100));
    }
}
