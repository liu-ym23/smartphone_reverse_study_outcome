package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u000fJ\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lrb/a;", "getController", "()Lrb/a;", "", "b", "()V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "getStatus", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "onAttachedToWindow", "onDetachedFromWindow", "Landroidx/lifecycle/LifecycleOwner;", "a", "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "getListener", "()Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "setListener", "(Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;)V", "listener", "Lrb/a;", "playerController", "AlphaPlayerListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlphaPlayerListener f11751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rb.a f11752b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "", "onEnd", "", "onStart", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface AlphaPlayerListener {
        void onEnd();

        void onStart();

        void onVideoSizeChanged(int r10, int r11);
    }

    public static final class a implements IPlayerAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaView f11753a;

        public a(AlphaView r10) {
            this.f11753a = r10;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction
        public void endAction() {
            AlphaPlayerListener r10 = this.f11753a.getListener();
            if (r10 == null) goto L6;
            r10.onEnd();
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction
        public void onVideoSizeChanged(int r10, int r11, ScaleType r12) {
            q.g(r12, "scaleType");
            AlphaPlayerListener r13 = this.f11753a.getListener();
            if (r13 == null) goto L6;
            r13.onVideoSizeChanged(r10, r11);
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction
        public void startAction() {
            AlphaPlayerListener r10 = this.f11753a.getListener();
            if (r10 == null) goto L6;
            r10.onStart();
            return;
        }
    }

    @JvmOverloads
    public AlphaView(@NotNull Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final rb.a getController() {
        if (this.f11752b != null) goto L9;
        Context r10 = getContext();
        q.f(r10, "context");
        LifecycleOwner r11 = a(r10);
        if (r11 == null) goto L8;
        Context r12 = getContext();
        q.f(r12, "context");
        sb.a r13 = new sb.a(r12, r11);
        r13.d(AlphaVideoViewType.GL_TEXTURE_VIEW);
        rb.a r14 = new rb.a(r13, null, 2, null);
        r14.setPlayerAction(new a(this));
        Unit r15 = Unit.f21064a;
        this.f11752b = r14;
        goto L9
    L8:
        throw new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment).");
    L9:
        rb.a r16 = this.f11752b;
        q.d(r16);
        return r16;
    }

    public final LifecycleOwner a(Context r10) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof LifecycleOwner) == true) goto L7;
        Context r11 = ((ContextWrapper) r1).getBaseContext();
        q.f(r11, "currentContext.baseContext");
        Object r12 = r11;
        goto L3
    L7:
        return (LifecycleOwner) r12;
    L9:
        return null;
    }

    public final void b() {
        rb.a r10 = this.f11752b;
        if (r10 == null) goto L5;
        r10.release();
    L5:
        this.f11752b = null;
    }

    @Nullable
    public final AlphaPlayerListener getListener() {
        return this.f11751a;
    }

    @Nullable
    public final PlayerState getStatus() {
        rb.a r10 = this.f11752b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getController().attachAlphaView(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rb.a r10 = this.f11752b;
        if (r10 == null) goto L5;
        r10.detachAlphaView(this);
    L5:
        b();
    }

    public final void setListener(@Nullable AlphaPlayerListener r10) {
        this.f11751a = r10;
    }

    @JvmOverloads
    public AlphaView(@NotNull Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ AlphaView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public AlphaView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
