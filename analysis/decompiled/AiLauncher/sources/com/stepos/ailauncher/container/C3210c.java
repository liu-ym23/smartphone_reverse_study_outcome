package com.stepos.ailauncher.container;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.api.IMemoryTrimmable;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageProvider;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageResumeReason;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010\u0014J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u0014J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/container/c;", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "Lcom/stepos/ailauncher/container/api/IMemoryTrimmable;", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", Const.JSON_KEY_PROVIDER, "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "LY8/t;", "onPageCreate", "(Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "reason", "onPageResume", "(Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;)V", "onPagePause", "()V", "onPageStop", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "onPageDestroy", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", "", "onBackPressed", "()Z", "onNavigateHome", "visible", "onAllTasksEntryVisibilityChanged", "(Z)V", "onEnterSystemRecents", "hideImeForHomeConsume", "", "level", "onTrimMemory", "(I)V", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "Landroid/view/View;", "realView", "Landroid/view/View;", "realPageView", "Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "pendingAllTasksEntryVisible", "Ljava/lang/Boolean;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.container.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3210c extends FrameLayout implements IOverlayPageView, IMemoryTrimmable {
    private final IOverlayPageHost host;
    private Boolean pendingAllTasksEntryVisible;
    private final IOverlayPageProvider provider;
    private IOverlayPageView realPageView;
    private View realView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3210c(Context context, IOverlayPageProvider provider, IOverlayPageHost host) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(provider, "provider");
        kotlin.jvm.internal.p.i(host, "host");
        this.provider = provider;
        this.host = host;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IOverlayPageView a() {
        if (this.realView != null) {
            return this.realPageView;
        }
        View viewCreateView = this.provider.createView(this);
        if (!(viewCreateView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            viewCreateView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        addView(viewCreateView);
        this.realView = viewCreateView;
        IOverlayPageView iOverlayPageView = viewCreateView instanceof IOverlayPageView ? (IOverlayPageView) viewCreateView : null;
        this.realPageView = iOverlayPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onPageCreate(this.host);
        }
        Boolean bool = this.pendingAllTasksEntryVisible;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (iOverlayPageView != null) {
                iOverlayPageView.onAllTasksEntryVisibilityChanged(zBooleanValue);
            }
        }
        return iOverlayPageView;
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void hideImeForHomeConsume() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.hideImeForHomeConsume();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onAllTasksEntryVisibilityChanged(boolean visible) {
        this.pendingAllTasksEntryVisible = Boolean.valueOf(visible);
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onAllTasksEntryVisibilityChanged(visible);
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public boolean onBackPressed() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        return iOverlayPageView != null && iOverlayPageView.onBackPressed();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onEnterSystemRecents() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onEnterSystemRecents();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onNavigateHome() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onNavigateHome();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageCreate(IOverlayPageHost host) {
        kotlin.jvm.internal.p.i(host, "host");
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageDestroy(OverlayPageDestroyReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onPageDestroy(reason);
        }
        this.realPageView = null;
        this.realView = null;
        this.pendingAllTasksEntryVisible = null;
        removeAllViews();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPagePause() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onPagePause();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageResume(OverlayPageResumeReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        IOverlayPageView iOverlayPageViewA = a();
        if (iOverlayPageViewA != null) {
            iOverlayPageViewA.onPageResume(reason);
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageStop() {
        IOverlayPageView iOverlayPageView = this.realPageView;
        if (iOverlayPageView != null) {
            iOverlayPageView.onPageStop();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IMemoryTrimmable
    public void onTrimMemory(int level) {
        IOverlayPageView iOverlayPageView = this.realPageView;
        IMemoryTrimmable iMemoryTrimmable = iOverlayPageView instanceof IMemoryTrimmable ? (IMemoryTrimmable) iOverlayPageView : null;
        if (iMemoryTrimmable != null) {
            iMemoryTrimmable.onTrimMemory(level);
            return;
        }
        KeyEvent.Callback callback = this.realView;
        IMemoryTrimmable iMemoryTrimmable2 = callback instanceof IMemoryTrimmable ? (IMemoryTrimmable) callback : null;
        if (iMemoryTrimmable2 != null) {
            iMemoryTrimmable2.onTrimMemory(level);
        }
    }
}
