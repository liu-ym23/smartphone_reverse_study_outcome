package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/UnionLiveAvatarImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "enable", "", "setEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveAvatarImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f118712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f118713b;

    public UnionLiveAvatarImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UnionLiveAvatarImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f118713b == false) goto L6;
        float r101 = 1;
        r100.drawCircle(getWidth() + UtilityKotlinExtentionsKt.h(r101), getHeight() / 2.0f, (getWidth() / 2.0f) + UtilityKotlinExtentionsKt.h(r101), this.f118712a);
        return;
    }

    public final void setEnable(boolean r100) {
        this.f118713b = r100;
        if (r100 == false) goto L5;
        int r101 = 2;
    L6:
        setLayerType(r101, null);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public UnionLiveAvatarImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        r103.setColor(-1);
        r103.setDither(true);
        Unit r104 = Unit.INSTANCE;
        this.f118712a = r103;
    }

    public /* synthetic */ UnionLiveAvatarImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
