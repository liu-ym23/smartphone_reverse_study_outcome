package com.stepos.ailauncher.container;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.IOverlayAllTasksEntryListener;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u000fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001f¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRootLayout;", "Landroid/widget/FrameLayout;", "Lcom/stepos/launcher/assistant/slidepanel/IOverlayAllTasksEntryListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "visible", "LY8/t;", "onAllTasksEntryVisibilityChanged", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/Canvas;)Z", "Lkotlin/Function1;", "allTasksEntryListener", "Lp9/l;", "getAllTasksEntryListener", "()Lp9/l;", "setAllTasksEntryListener", "(Lp9/l;)V", "drawSuppressed", "Z", "getDrawSuppressed", "()Z", "setDrawSuppressed", "loggedSkip", "Companion", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayRootLayout extends FrameLayout implements IOverlayAllTasksEntryListener {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "OverlayRootLayout";
    private InterfaceC5074l<? super Boolean, Y8.t> allTasksEntryListener;
    private boolean drawSuppressed;
    private boolean loggedSkip;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/container/OverlayRootLayout$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayRootLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean a(Canvas canvas) {
        boolean zIsHardwareAccelerated = canvas.isHardwareAccelerated();
        boolean z10 = !zIsHardwareAccelerated;
        boolean z11 = this.drawSuppressed;
        if (!z11 && zIsHardwareAccelerated) {
            return false;
        }
        if (!this.loggedSkip) {
            this.loggedSkip = true;
            Log.w(TAG, "skip draw suppressed=" + z11 + " software=" + z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (a(canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (a(canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public final InterfaceC5074l<Boolean, Y8.t> getAllTasksEntryListener() {
        return this.allTasksEntryListener;
    }

    public final boolean getDrawSuppressed() {
        return this.drawSuppressed;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.IOverlayAllTasksEntryListener
    public void onAllTasksEntryVisibilityChanged(boolean visible) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.allTasksEntryListener;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(visible));
        }
    }

    public final void setAllTasksEntryListener(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.allTasksEntryListener = interfaceC5074l;
    }

    public final void setDrawSuppressed(boolean z10) {
        this.drawSuppressed = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayRootLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ OverlayRootLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
