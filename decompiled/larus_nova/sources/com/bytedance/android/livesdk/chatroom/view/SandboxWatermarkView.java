package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/SandboxWatermarkView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SandboxWatermarkView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f114725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f114726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f114727c;

    public SandboxWatermarkView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SandboxWatermarkView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = getWidth();
        int r101 = getHeight();
        if (r100 <= 0) goto L12;
        if (r101 <= 0) goto L15;
        float r102 = 4;
        float r103 = r100 / r102;
        float r104 = (r103 / r102) * 5;
        int r105 = (int) ((r101 / r104) + 2);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L16;
        int r107 = 0;
    L9:
        if (r107 >= 4) goto L11;
        r110.save();
        r110.translate(r107 * r103, r106 * r104);
        r110.rotate(this.f114726b, 0.0f, 0.0f);
        r110.drawText(this.f114725a, 0.0f, 0.0f, this.f114727c);
        r110.restore();
        r107 = r107 + 1;
        goto L9
    L11:
        r106 = r106 + 1;
        goto L7
    L16:
        return;
    L15:
        return;
    }

    public SandboxWatermarkView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f114725a = "Sandbox 沙盒直播间";
        float r103 = s1.f(14.0f);
        this.f114726b = -25.0f;
        TextPaint r104 = new TextPaint();
        r104.setColor(-16777216);
        r104.setAlpha(20);
        r104.setTextSize(r103);
        Unit r105 = Unit.INSTANCE;
        this.f114727c = r104;
    }

    public /* synthetic */ SandboxWatermarkView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
