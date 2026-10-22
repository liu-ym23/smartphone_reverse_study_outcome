package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.view.VSGifDanmuTextView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class VSTextViewWapperBarrage extends com.ss.ugc.live.barrage.barrage.e implements com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Drawable> f108991v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f108992w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f108993x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f108994y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f108995z;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.live.barrage.barrage.e, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void j() {
        Bitmap r100 = this.f108993x;
        if (r100 == null) goto L5;
        this.f458065m.f458070d.a(r100);
    L5:
        ((ArrayList) this.f108991v).clear();
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void g(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        View r100 = this.f458090t;
        if (r100 == null) goto L5;
        s(r100);
    L5:
        float r101 = this.f458058f.left;
        View r102 = this.f458090t;
        if (r102 == null) goto L8;
        int r103 = r102.getWidth();
    L10:
        if (r101 > r103) goto L12;
        this.f458058f.offset(0.0f, 0.0f);
    L12:
        int r104 = r110.saveLayer(0.0f, 0.0f, r110.getWidth(), r110.getWidth(), null, 31);
        Bitmap r105 = this.f108993x;
        if (r105 != null) goto L15;
        return;
    L15:
        RectF r106 = this.f458058f;
        float r107 = r106.left;
        r110.drawBitmap(r105, r107, (r106.top + (r106.height() * 0.5f)) - (r105.getHeight() * 0.5f), (Paint) this.f108992w.getValue());
        r110.save();
        RectF r108 = this.f458058f;
        r110.translate(r107, r108.top + (r108.height() * 0.25f));
        r110.scale(1.0f, 1.0f);
        Iterator<T> r109 = this.f108991v.iterator();
    L17:
        if (r109.hasNext() == false) goto L24;
        Drawable r111 = (Drawable) r109.next();
        if (this.f108994y == false) goto L23;
        View r112 = this.f458090t;
        if (r112 == null) goto L23;
        r(r112);
    L23:
        this.f108994y = false;
        r111.draw(r110);
        goto L17
    L24:
        r110.restore();
        r110.restoreToCount(r104);
        return;
    L8:
        r103 = 0;
        goto L10
    }

    public final void r(View r110) {
        if ((r110 instanceof ViewGroup) == false) goto L27;
        Iterator<View> r111 = UtilityKotlinExtentionsKt.a((ViewGroup) r110).iterator();
    L6:
        if (r111.hasNext() == false) goto L42;
        View r100 = r111.next();
        if ((r100 instanceof VSGifDanmuTextView) == true) goto L9;
        if ((r100 instanceof ViewGroup) == false) goto L6;
        if (((ViewGroup) r100).getChildCount() <= 0) goto L6;
        r(r100);
        goto L6
    L9:
        VSGifDanmuTextView r101 = (VSGifDanmuTextView) r100;
        Iterator<Map.Entry<View, Drawable>> r102 = r101.getDanmuImageDrawable().entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<View, Drawable> r103 = r102.next();
        View r104 = r103.getKey();
        Drawable r105 = r103.getValue();
        if ((r104 instanceof HSImageView) == false) goto L11;
        if (this.f108995z > 0) goto L21;
        Bitmap r106 = this.f108993x;
        if (r106 == null) goto L19;
        int r107 = r106.getHeight();
    L20:
        this.f108995z = (int) ((r107 / 4) * 1.0f);
        goto L21
    L19:
        r107 = 0 - ((HSImageView) r104).getHeight();
    L21:
        HSImageView r108 = (HSImageView) r104;
        r105.setBounds((int) ((r108.getLeft() + r101.getLeft()) / 1.0f), (-this.f108995z) - 3, (int) ((r108.getRight() + r101.getLeft()) / 1.0f), r108.getHeight() - this.f108995z);
        goto L11
    L42:
        return;
    }

    public final void s(View r100) {
        if ((r100 instanceof ViewGroup) == true) goto L5;
    L22:
        View r101 = this.f458090t;
        if (r101 == null) goto L40;
        Function3<Bitmap, Integer, Integer, Unit> r102 = new VSTextViewWapperBarrage$generateBitmap$$inlined$apply$lambda$1(this);
        AbsBarrage.b r103 = this.f458065m;
        olc.a r104 = r103.f458070d;
        r103.f458071e.execute(new com.ss.ugc.live.barrage.util.f(r101, r104, r102));
        return;
    L40:
        return;
    L5:
        if (this.f108994y == false) goto L22;
        Iterator<View> r105 = UtilityKotlinExtentionsKt.a((ViewGroup) r100).iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        View r106 = r105.next();
        if ((r106 instanceof VSGifDanmuTextView) == true) goto L11;
        if ((r106 instanceof ViewGroup) == false) goto L8;
        if (((ViewGroup) r106).getChildCount() <= 0) goto L8;
        s(r106);
        goto L8
    L11:
        Iterator<Map.Entry<View, Drawable>> r107 = ((VSGifDanmuTextView) r106).getDanmuImageDrawable().entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L8;
        Map.Entry<View, Drawable> r108 = r107.next();
        View r109 = r108.getKey();
        Drawable r110 = r108.getValue();
        if ((r109 instanceof HSImageView) == false) goto L13;
        ((ArrayList) this.f108991v).add(r110);
        goto L13
    }

    public VSTextViewWapperBarrage(View r100, final AbsBarrage.b r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, r101);
        this.f108991v = new ArrayList();
        this.f108992w = LazyKt.lazy(LazyThreadSafetyMode.NONE, new VSTextViewWapperBarrage$mBitmapPaint$2(r101));
        this.f108994y = true;
    }
}
