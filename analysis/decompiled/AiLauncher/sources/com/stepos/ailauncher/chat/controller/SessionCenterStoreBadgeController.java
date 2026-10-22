package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.C1398p;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.manager.AmooStoreBadgeState;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0003R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionCenterStoreBadgeController;", "Landroidx/lifecycle/e;", "<init>", "()V", "Landroid/widget/ImageView;", "badge", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", "c", "(Landroid/widget/ImageView;Landroidx/lifecycle/LifecycleOwner;)V", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "onPause", "onDestroy", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;", "next", "e", "(Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;)V", "f", "Landroid/widget/ImageView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "", "resumed", "Z", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;", "Landroid/animation/ObjectAnimator;", "rotateAnimator", "Landroid/animation/ObjectAnimator;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionCenterStoreBadgeController implements InterfaceC1387e {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long ROTATE_DURATION_MS = 2000;
    private ImageView badge;
    private LifecycleOwner lifecycleOwner;
    private boolean resumed;
    private ObjectAnimator rotateAnimator;
    private AmooStoreBadgeState.State state = new AmooStoreBadgeState.State(false, false, false, false, false, 31, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionCenterStoreBadgeController$a;", "", "<init>", "()V", "", "ROTATE_DURATION_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    public final void c(ImageView badge, LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(badge, "badge");
        kotlin.jvm.internal.p.i(owner, "owner");
        this.badge = badge;
        this.lifecycleOwner = owner;
        owner.getLifecycle().a(this);
        AmooStoreBadgeState amooStoreBadgeState = AmooStoreBadgeState.INSTANCE;
        amooStoreBadgeState.d();
        e(amooStoreBadgeState.e().getValue());
        C1060i.d(C1398p.a(owner), null, null, new SessionCenterStoreBadgeController$bind$1(owner, this, null), 3, null);
    }

    public final void d() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        this.lifecycleOwner = null;
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.rotateAnimator = null;
        ImageView imageView = this.badge;
        if (imageView != null) {
            imageView.setRotation(0.0f);
        }
        this.badge = null;
        this.resumed = false;
    }

    public final void e(AmooStoreBadgeState.State next) {
        this.state = next;
        ImageView imageView = this.badge;
        if (imageView == null) {
            return;
        }
        if (next.getInstalling()) {
            imageView.setImageResource(R$drawable.ic_chat_task_running);
            imageView.setVisibility(0);
        } else if (next.getUnreadInstalled()) {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
        f();
    }

    public final void f() {
        ImageView imageView = this.badge;
        if (imageView == null) {
            return;
        }
        if (!this.state.getInstalling() || !this.resumed) {
            ObjectAnimator objectAnimator = this.rotateAnimator;
            if (objectAnimator != null) {
                if (!objectAnimator.isStarted()) {
                    objectAnimator = null;
                }
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
            }
            imageView.setRotation(0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = this.rotateAnimator;
        if (objectAnimatorOfFloat == null) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ROTATION, 0.0f, 360.0f);
            objectAnimatorOfFloat.setDuration(2000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            this.rotateAnimator = objectAnimatorOfFloat;
        }
        if (objectAnimatorOfFloat.isStarted()) {
            return;
        }
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        d();
    }

    @Override // android.view.InterfaceC1387e
    public void onPause(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.resumed = false;
        f();
    }

    @Override // android.view.InterfaceC1387e
    public void onResume(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.resumed = true;
        f();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }
}
