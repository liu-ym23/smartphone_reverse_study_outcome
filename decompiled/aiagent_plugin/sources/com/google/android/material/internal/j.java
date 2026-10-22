package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f13471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.g.f f13472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<a> f13475e;
    private com.google.android.material.g.d f;

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface a {
        int[] getState();

        boolean onStateChange(int[] r1);

        void onTextSizeChange();
    }

    static /* synthetic */ WeakReference a(j r0) {
        return r0.f13475e;
    }

    static /* synthetic */ boolean a(j r0, boolean r1) {
        r0.f13474d = r1;
        return r1;
    }

    public j(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.f13471a = new TextPaint(1);
        this.f13472b = new AnonymousClass1(this);
        this.f13474d = true;
        this.f13475e = new WeakReference(null);
        a(r4);
    }

    public void a(a r3) {
        this.f13475e = new WeakReference((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
    }

    public TextPaint a() {
        return this.f13471a;
    }

    public void a(boolean r1) {
        this.f13474d = r1;
    }

    public float a(String r2) {
        if (this.f13474d == false) goto L5;
        float r3 = a(r2);
        this.f13473c = r3;
        this.f13474d = false;
        return r3;
    L5:
        return this.f13473c;
    }

    private float a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return 0.0f;
    L7:
        return this.f13471a.measureText(r4, 0, r4.length());
    }

    public com.google.android.material.g.d b() {
        return this.f;
    }

    public void a(com.google.android.material.g.d r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (this.f == r4) goto L14;
        this.f = r4;
        if (r4 == null) goto L10;
        r4.c(r6, this.f13471a, this.f13472b);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f13475e.get(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        TextPaint r2 = this.f13471a;
        r2.drawableState = r0.getState();
    L9:
        r4.b(r6, this.f13471a, this.f13472b);
        this.f13474d = true;
    L10:
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.f13475e.get(), a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L15;
        r3.onTextSizeChange();
        r3.onStateChange(r3.getState());
        return;
    L15:
        return;
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f.b(r4, this.f13471a, this.f13472b);
    }
}
