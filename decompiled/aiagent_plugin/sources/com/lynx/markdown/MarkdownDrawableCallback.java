package com.lynx.markdown;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MarkdownDrawableCallback implements Drawable.Callback {
    private WeakReference<f> mNode;
    private MarkdownView mView;

    public MarkdownDrawableCallback() {
        this.mView = null;
        this.mNode = null;
    }

    public void setView(MarkdownView r1) {
        this.mView = r1;
    }

    public void setNode(f r2) {
        this.mNode = new WeakReference(r2);
    }

    public void imageLoaded() {
        WeakReference<f> r2 = this.mNode;
        if (r2 == null) goto L8;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r2.get(), f.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.a();
        return;
    L9:
        return;
    }

    public static boolean isOnUiThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        MarkdownView r0 = this.mView;
        if (r0 == null) goto L6;
        r0.postInvalidate();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        com.lynx.markdown.b.b.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), r2, r4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r2, Runnable r3) {
        com.lynx.markdown.b.b.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), r2);
    }
}
