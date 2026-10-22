package com.bytedance.android.live.network.impl.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f83928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f83929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f83930c;

    public f(boolean r100, View r101, Runnable r102) {
        this.f83928a = r100;
        this.f83929b = r101;
        this.f83930c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        int r102 = h.f83932a;
        Rect r103 = null;
        if (r101 == null) goto L5;
        byte[] r104 = r101.getNinePatchChunk();
    L6:
        if (r104 == null) goto L12;
        ByteBuffer r105 = ByteBuffer.wrap(r104).order(ByteOrder.nativeOrder());
        if (r105.get() == 0) goto L12;
        r105.get();
        r105.get();
        r105.get();
        r105.getInt();
        r105.getInt();
        r103 = new Rect();
        r103.left = r105.getInt();
        r103.right = r105.getInt();
        r103.top = r105.getInt();
        r103.bottom = r105.getInt();
    L12:
        if (r101 == null) goto L26;
        if (r101.getNinePatchChunk() == null) goto L26;
        if (r103 == null) goto L26;
        NinePatchDrawable r106 = new NinePatchDrawable(s1.getResources(), r101, r101.getNinePatchChunk(), r103, null);
        r106.setAutoMirrored(this.f83928a);
        this.f83929b.setBackgroundDrawable(r106);
        if (this.f83928a == true) goto L19;
    L21:
        this.f83929b.setPadding(r103.left, r103.top, r103.right, r103.bottom);
    L22:
        Runnable r107 = this.f83930c;
        if (r107 == null) goto L30;
        r107.run();
        return;
    L30:
        return;
    L19:
        if (RTLUtil.isAppRTL(s1.getContext()) == false) goto L21;
        this.f83929b.setPadding(r103.right, r103.top, r103.left, r103.bottom);
    L26:
        if (r101 == null) goto L28;
        ALogger.e("NinePatchUtil", "downloaded bitmap is null.");
        return;
    L28:
        ALogger.e("NinePatchUtil", "no ninepatch chunk found in bitmap.");
        return;
    L5:
        r104 = null;
        goto L6
    }
}
