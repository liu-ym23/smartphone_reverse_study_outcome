package com.android.ttcjpaysdk.base.utils;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import com.bytedance.caijing.sdk.infra.base.event.CJBtmUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJBtmVirtualView;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroid/app/Activity;", "btm", "", "(Landroid/app/Activity;Ljava/lang/String;)V", "activityWeakRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "isResumed", "", "pageFinder", "Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJPageFinder;", "getPageFinder", "()Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJPageFinder;", "view", "Landroid/view/View;", "waitShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cleanup", "", "hide", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onPause", "onResume", "setupLifecycle", "show", MiPushClient.COMMAND_UNREGISTER, "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBtmVirtualView implements DefaultLifecycleObserver {
    public static final Companion Companion = null;
    private final WeakReference<Activity> activityWeakRef;
    private final String btm;
    private boolean isResumed;
    private final CJPageFinder pageFinder;
    private View view;
    private final AtomicBoolean waitShow;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJBtmVirtualView$Companion;", "", "()V", "create", "Lcom/android/ttcjpaysdk/base/utils/CJBtmVirtualView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "btm", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJBtmVirtualView create(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "btm");
            if ((r100 instanceof Activity) == true) goto L5;
            return null;
        L5:
            return new CJBtmVirtualView((Activity) r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    private final void cleanup() {
        View r100 = this.view;
        if (r100 == null) goto L5;
        Lazy r101 = CJBtmUtils.f202293a;
        CJBtmUtils.a(r100);
    L5:
        this.view = null;
    }

    public final void hide() {
        View r100 = this.view;
        if (r100 == null) goto L5;
        Lazy r101 = CJBtmUtils.f202293a;
        CJBtmUtils.a(r100);
    L5:
        this.waitShow.set(false);
    }

    public final void show() {
        View r100 = this.view;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.isResumed == false) goto L7;
        Lazy r101 = CJBtmUtils.f202293a;
        CJBtmUtils.c(r100);
        return;
    L7:
        this.waitShow.set(true);
    }

    public final void unregister() {
        ComponentCallbacks2 r100 = (Activity) this.activityWeakRef.get();
        if (r100 != null) goto L5;
    L7:
        cleanup();
        return;
    L5:
        if ((r100 instanceof LifecycleOwner) == false) goto L7;
        ((LifecycleOwner) r100).getLifecycle().removeObserver(this);
        goto L7
    }

    public final CJPageFinder getPageFinder() {
        return this.pageFinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupLifecycle(Activity r100) {
        if ((r100 instanceof LifecycleOwner) == false) goto L5;
        View r101 = new View(r100);
        Lazy r102 = CJBtmUtils.f202293a;
        CJBtmUtils.i(r101, this.btm);
        this.view = r101;
        ((LifecycleOwner) r100).getLifecycle().addObserver(this);
        return;
    L5:
        Lazy r103 = CJBtmUtils.f202293a;
        CJBtmUtils.g(r100, this.btm);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
        cleanup();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
        this.isResumed = false;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
        this.isResumed = true;
        View r101 = this.view;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.waitShow.compareAndSet(true, false) == false) goto L9;
        Lazy r102 = CJBtmUtils.f202293a;
        CJBtmUtils.c(r101);
        return;
    }

    public CJBtmVirtualView(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "btm");
        this.btm = r101;
        this.activityWeakRef = new WeakReference(r100);
        this.waitShow = new AtomicBoolean(false);
        this.pageFinder = new CJPageFinder().via(r101);
        setupLifecycle(r100);
    }
}
