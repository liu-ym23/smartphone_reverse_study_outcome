package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.interactivityshare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import g52.a;
import g52.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/interactivityshare/ItemShareLayout;", "Landroid/widget/RelativeLayout;", "Lg52/a;", "", "color", "", "setTouchBackgroundColor", "Lg52/b;", "d", "Lg52/b;", "getDispatchCallback", "()Lg52/b;", "setDispatchCallback", "(Lg52/b;)V", "dispatchCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemShareLayout extends RelativeLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f139192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f139193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f139194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f139195d;

    public ItemShareLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ItemShareLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public b getDispatchCallback() {
        return this.f139195d;
    }

    public final View a(int r100) {
        if (this.f139192a != null) goto L5;
        this.f139192a = new LinkedHashMap();
    L5:
        View r101 = this.f139192a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f139192a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        b r101 = getDispatchCallback();
        if (r101 == null) goto L6;
        r101.c(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        NoMoreSpaceTextView r101 = (NoMoreSpaceTextView) a(R.id.text);
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getWidth());
    L6:
        float r104 = r103.intValue();
        LinearLayout r105 = (LinearLayout) a(R.id.share_content_layout);
        if (r105 == null) goto L9;
        r102 = Integer.valueOf(r105.getWidth());
    L9:
        this.f139193b.set(0.0f, 0.0f, Math.max(r104, r102.intValue() + UtilityKotlinExtentionsKt.h(16)), getHeight());
        float r106 = 12;
        r100.drawRoundRect(this.f139193b, UtilityKotlinExtentionsKt.h(r106), UtilityKotlinExtentionsKt.h(r106), this.f139194c);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        NoMoreSpaceTextView r101 = (NoMoreSpaceTextView) a(R.id.text);
        Integer r102 = null;
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.getWidth());
    L9:
        float r104 = r103.intValue();
        LinearLayout r105 = (LinearLayout) a(R.id.share_content_layout);
        if (r105 == null) goto L13;
        r102 = Integer.valueOf(r105.getWidth());
    L13:
        if (r100.getX() <= Math.max(r104, r102.intValue() + UtilityKotlinExtentionsKt.h(16))) goto L16;
        return false;
    L16:
        return super.onTouchEvent(r100);
    L8:
        r103 = null;
        goto L9
    }

    @Override // g52.a
    public void setDispatchCallback(b r100) {
        this.f139195d = r100;
    }

    public final void setTouchBackgroundColor(int r100) {
        this.f139194c.setColor(r100);
        invalidate();
    }

    public ItemShareLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f139192a = new LinkedHashMap();
        this.f139193b = new RectF();
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setAntiAlias(true);
        int r104 = l.f133643a;
        r103.setColor(l.f133644b);
        Unit r105 = Unit.INSTANCE;
        this.f139194c = r103;
        setWillNotDraw(false);
    }

    public /* synthetic */ ItemShareLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
