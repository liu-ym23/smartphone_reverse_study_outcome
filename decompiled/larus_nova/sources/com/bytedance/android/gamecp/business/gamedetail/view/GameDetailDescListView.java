package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/GameDetailDescListView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailDescListView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f55660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f55661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f55662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f55663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f55664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<t> f55665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f55666g;

    public GameDetailDescListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailDescListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ((ArrayList) this.f55665f).clear();
        if ((!r100.isEmpty()) == false) goto L13;
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L6;
        ((ArrayList) this.f55665f).add(new t(r102, this.f55660a.measureText(r102)));
        goto L6
    L10:
        r103 = false;
    L13:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (((ArrayList) this.f55665f).size() <= 0) goto L16;
        int r100 = getWidth();
        int r101 = getHeight();
        float r102 = this.f55666g;
        float r103 = r101;
        float r104 = ((r103 - this.f55660a.getFontMetrics().top) - this.f55660a.getFontMetrics().bottom) / 2.0f;
        float r105 = this.f55666g;
        float r106 = r104 + r105;
        float r107 = this.f55663d;
        float r108 = ((r103 + r107) / 2.0f) + r105;
        float r109 = r108 - r107;
        int r111 = ((ArrayList) this.f55665f).size();
        int r112 = 0;
    L5:
        if (r112 >= r111) goto L23;
        t r113 = (t) ListProtector.get(this.f55665f, r112);
        if (r112 != 0) goto L11;
        float r114 = r100;
        if (r113.f55948b <= r114) goto L15;
        r110.drawText(TextUtils.ellipsize(r113.f55947a, this.f55660a, r114, TextUtils.TruncateAt.END).toString(), r102, r106, this.f55660a);
        return;
    L15:
        r110.drawText(r113.f55947a, r102, r106, this.f55660a);
        r102 = (r102 + r113.f55948b) + this.f55664e;
        r112 = r112 + 1;
        goto L5
    L11:
        float r115 = this.f55662c;
        if ((((r102 + r115) + this.f55664e) + r113.f55948b) > r100) goto L24;
        r110.drawRect(r102, r109, r102 + r115, r108, this.f55661b);
        r102 = (r102 + this.f55662c) + this.f55664e;
        goto L15
    L24:
        return;
    L23:
        return;
    }

    public GameDetailDescListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55665f = new ArrayList();
        float r103 = y0.a(1.0f);
        this.f55666g = r103;
        this.f55664e = 4 * r103;
        this.f55662c = r103;
        this.f55663d = UtilityKotlinExtentionsKt.d(10);
        TextPaint r104 = new TextPaint();
        this.f55660a = r104;
        r104.setStyle(Paint.Style.FILL);
        r104.setTextSize(UtilityKotlinExtentionsKt.d(11));
        r104.setTextAlign(Paint.Align.LEFT);
        r104.setAntiAlias(true);
        Paint r105 = new Paint();
        this.f55661b = r105;
        r105.setStyle(Paint.Style.FILL);
        r105.setAntiAlias(true);
    }

    public /* synthetic */ GameDetailDescListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
