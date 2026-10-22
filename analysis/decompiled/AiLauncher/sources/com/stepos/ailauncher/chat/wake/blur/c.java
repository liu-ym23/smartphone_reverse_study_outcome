package com.stepos.ailauncher.chat.wake.blur;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/blur/c;", "", "<init>", "()V", "Landroid/view/View;", "view", "Lcom/stepos/ailauncher/chat/wake/blur/a;", "config", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/View;Lcom/stepos/ailauncher/chat/wake/blur/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/chat/wake/blur/a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "previousBackground", AuthSessionDto.STATUS_PENDING, "Lcom/stepos/ailauncher/chat/wake/blur/a;", "Landroid/view/View$OnAttachStateChangeListener;", "attachListener", "Landroid/view/View$OnAttachStateChangeListener;", "", "f", "()Z", "isSupported", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private View.OnAttachStateChangeListener attachListener;
    private Drawable drawable;
    private BlurConfig pending;
    private Drawable previousBackground;
    private View view;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/blur/c$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            c.this.attachListener = null;
            BlurConfig blurConfig = c.this.pending;
            if (blurConfig != null) {
                c.this.e(v10, blurConfig);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            p.i(v10, "v");
        }
    }

    public final void d(View view, BlurConfig config) {
        p.i(view, "view");
        p.i(config, "config");
        View view2 = this.view;
        if (view2 == view && this.drawable != null) {
            h(config);
            return;
        }
        if (view2 != null) {
            g();
        }
        this.view = view;
        this.pending = config;
        if (view.isAttachedToWindow()) {
            e(view, config);
            return;
        }
        a aVar = new a();
        this.attachListener = aVar;
        view.addOnAttachStateChangeListener(aVar);
    }

    public final void e(View view, BlurConfig config) {
        b bVar = b.INSTANCE;
        Drawable drawableA = bVar.a(view);
        if (drawableA == null) {
            return;
        }
        this.drawable = drawableA;
        this.previousBackground = view.getBackground();
        view.setBackground(drawableA);
        bVar.d(drawableA, config.getRadius());
        bVar.f(drawableA, config.getCornerRadius());
        bVar.e(drawableA, config.getTintColor());
        view.invalidate();
    }

    public final boolean f() {
        return b.INSTANCE.c();
    }

    public final void g() {
        View view;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachListener;
        if (onAttachStateChangeListener != null && (view = this.view) != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.attachListener = null;
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        View view2 = this.view;
        Drawable drawable2 = this.drawable;
        if (view2 != null && drawable2 != null && view2.getBackground() == drawable2) {
            view2.setBackground(this.previousBackground);
        }
        this.view = null;
        this.drawable = null;
        this.previousBackground = null;
        this.pending = null;
    }

    public final void h(BlurConfig config) {
        p.i(config, "config");
        this.pending = config;
        Drawable drawable = this.drawable;
        if (drawable == null) {
            return;
        }
        b bVar = b.INSTANCE;
        bVar.d(drawable, config.getRadius());
        bVar.f(drawable, config.getCornerRadius());
        bVar.e(drawable, config.getTintColor());
        View view = this.view;
        if (view != null) {
            view.invalidate();
        }
    }
}
