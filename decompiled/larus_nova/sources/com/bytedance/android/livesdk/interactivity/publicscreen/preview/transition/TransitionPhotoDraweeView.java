package com.bytedance.android.livesdk.interactivity.publicscreen.preview.transition;

import android.content.Context;
import android.util.AttributeSet;
import ba2.e;
import ba2.f;
import ca2.a;
import ca2.b;
import ca2.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.PhotoDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0002B'\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/transition/TransitionPhotoDraweeView;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/PhotoDraweeView;", "", "", "isDragTransitionEnabled", "()Z", "setDragTransitionEnabled", "(Z)V", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionAnimationDuration", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionPhotoDraweeView extends PhotoDraweeView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashSet<a> f139353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f139354o;

    public TransitionPhotoDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public long getTransitionAnimationDuration() {
        return this.f139354o.E;
    }

    public void setDragTransitionEnabled(boolean r100) {
        this.f139354o.F = r100;
    }

    public void setSingleTagDismissEnabled(boolean r100) {
        this.f139354o.G = r100;
    }

    public void setTransitionAnimationDuration(long r100) {
        this.f139354o.E = r100;
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c r103 = new c(new e(), r100);
        super(r100, r101, r102);
        this.f139354o = r103;
        this.f139353n = new LinkedHashSet();
        b r104 = new b(this);
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.f22924w.add(r104);
        setZoomableControllerImp(r103);
        setGestureHandler(new f(r103));
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
