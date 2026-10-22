package com.obric.structure.omvvm.core.util;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.extension.QConfig;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncQuery.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 h2\u00020\u0001:\u0001hB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0001H\u0002J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u0017\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u000fJ\u0010\u0010 \u001a\u00020\u00002\b\b\u0001\u0010!\u001a\u00020\u000fJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013J\u0012\u0010'\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000fJ\u0010\u00103\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\u000fJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010#\u001a\u000206J\u0006\u00107\u001a\u00020\u0000J\u0010\u00108\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u00108\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u00108\u001a\u00020\u00002\b\b\u0001\u0010=\u001a\u00020\u000fJ\u0006\u0010>\u001a\u00020\u0000J\u0012\u0010?\u001a\u00020\u001b2\b\b\u0001\u0010=\u001a\u00020\u000fH\u0002J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020-J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0019J\u0010\u0010C\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0014\u0010H\u001a\u00020\u00002\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001b0JJ=\u0010H\u001a\u00020\u0000\"\b\b\u0000\u0010K*\u00020\u00032\b\b\u0001\u00104\u001a\u00020\u000f2!\u0010I\u001a\u001d\u0012\u0013\u0012\u0011HK¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001b0LJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u001dJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u001dJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010R\u001a\u00020-J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020UJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010=\u001a\u00020\u000fJ\u0010\u0010V\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u000fJ\u0010\u0010W\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\u000fJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010Y\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020[J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u001dJ\u0016\u0010\\\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u001dJ\u000e\u0010_\u001a\u00020\u00002\u0006\u0010#\u001a\u00020`J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020cJ\u0017\u0010\u0002\u001a\u0002HK\"\b\b\u0000\u0010K*\u00020\u0003H\u0007¢\u0006\u0002\u0010dJ\u0019\u0010e\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K*\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010dJ\u000e\u0010f\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\u000fJ\u0006\u0010g\u001a\u00020\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/obric/structure/omvvm/core/util/AsyncQuery;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "holder", "Landroid/util/SparseArray;", "lock", "getLock", "()Ljava/lang/Object;", "lock$delegate", "Lkotlin/Lazy;", "mainHandler", "Lcom/obric/structure/omvvm/core/performance/QVsyncFrameCaller;", "parent", "", SimContactsConstants.STR_TAG, "getTag", "text", "", "getText", "()Ljava/lang/CharSequence;", "acquireLock", "addView", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "addViewInner", "", "alpha", "", "backgroundColor", "color", "backgroundColorId", "colorResId", "clickListener", "listener", "Landroid/view/View$OnClickListener;", "colorFilter", "contentDescription", ContractKt.OBRIC_ACTION_CREATE, "ellipsize", "truncateAt", "Landroid/text/TextUtils$TruncateAt;", "enableInner", "enabled", "", "expandTouchSize", "left", "top", "right", "bottom", "find", "id", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "gone", SlardarSettingsConsts.SETTING_IMAGE, "bm", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "imageBitmapNull", "imageInner", "invisible", "isVisible", "params", "longClickListener", "Landroid/view/View$OnLongClickListener;", "padding", "rect", "Landroid/graphics/Rect;", "runOnUi", "updater", "Lkotlin/Function0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "scaleX", "value", "scaleY", "select", "startAnimator", "animator", "Landroid/animation/ValueAnimator;", "textColor", "textColorId", "textFuture", "textFutureOnExecutor", "executor", "Ljava/util/concurrent/Executor;", "textSize", PerfConsts.PERF_DISK_FILE_SIZE, "unit", "touchListener", "Landroid/view/View$OnTouchListener;", "typeface", "tf", "Landroid/graphics/Typeface;", "()Landroid/view/View;", "viewNullable", "visibility", "visible", "Companion", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncQuery {
    public static final Companion Companion = null;
    private static final Thread mainThread = null;
    private final SparseArray<View> holder;
    private final Lazy lock$delegate;
    private final QVsyncFrameCaller mainHandler;
    private final int parent;
    private final View view;

    /* JADX INFO: compiled from: AsyncQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/structure/omvvm/core/util/AsyncQuery$Companion;", "", "()V", "mainThread", "Ljava/lang/Thread;", "getMainThread", "()Ljava/lang/Thread;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Thread getMainThread() {
            return AsyncQuery.access$getMainThread$cp();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Sgbqjf-sT0Dvxy6fHYhEf4rmg5A, reason: not valid java name */
    public static /* synthetic */ void m774$r8$lambda$SgbqjfsT0Dvxy6fHYhEf4rmg5A(Runnable r0) {
        textFuture$lambda$7(r0);
    }

    public static /* synthetic */ void $r8$lambda$hHSFNEkRFXT4fb2MH0NHihHfFKE(Runnable r0) {
        textFuture$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$tRuxfEiRb5P2oQGQhYF6w7eMFwY(AsyncQuery r0, CharSequence r1) {
        textFutureOnExecutor$lambda$8(r0, r1);
    }

    public AsyncQuery(View r1) {
        this.view = r1;
        this.holder = new SparseArray();
        this.mainHandler = QVsyncFrameCaller.INSTANCE;
        this.parent = -99;
        this.lock$delegate = LazyKt.lazy(AsyncQuery$lock$2.INSTANCE);
    }

    public static final /* synthetic */ void access$addViewInner(AsyncQuery r0, View r1) {
        r0.addViewInner(r1);
    }

    public static final /* synthetic */ void access$addViewInner(AsyncQuery r0, View r1, ViewGroup.LayoutParams r2) {
        r0.addViewInner(r1, r2);
    }

    public static final /* synthetic */ void access$enableInner(AsyncQuery r0, boolean r1) {
        r0.enableInner(r1);
    }

    public static final /* synthetic */ void access$expandTouchSize$expand(AsyncQuery r0, int r1, int r2, int r3, int r4) {
        expandTouchSize$expand(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ Thread access$getMainThread$cp() {
        return mainThread;
    }

    public static final /* synthetic */ View access$getView$p(AsyncQuery r0) {
        return r0.view;
    }

    public static final /* synthetic */ void access$imageInner(AsyncQuery r0, int r1) {
        r0.imageInner(r1);
    }

    private final AsyncQuery create(View r1) {
        return new AsyncQuery(r1);
    }

    static {
        Companion = new Companion(null);
        Thread r0 = Looper.getMainLooper().getThread();
        Intrinsics.checkNotNullExpressionValue(r0, "getMainLooper().thread");
        mainThread = r0;
    }

    private final Object getLock() {
        return this.lock$delegate.getValue();
    }

    private final Object acquireLock() {
        QConfig r0 = Q.INSTANCE.getCig$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        if (r0.fixAsyncQuery() == false) goto L6;
        return getLock();
    L6:
        return new Object();
    }

    public final AsyncQuery find(int r4) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L10;
        View r0 = this.view;
        if (r0 == null) goto L7;
        View r5 = r0.findViewById(r4);
    L9:
        return create(r5);
    L7:
        r5 = null;
        goto L9
    L10:
        Object r1 = acquireLock();
        monitor-enter(r1);
        View r2 = this.holder.get(r4);     // Catch: Throwable -> L30
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r1);
        if (r2 == null) goto L35;
    L18:
        Object r6 = acquireLock();     // Catch: Exception -> L26
        monitor-enter(r6);     // Catch: Exception -> L26
        this.holder.put(r4, r2);     // Catch: Throwable -> L23
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r6);     // Catch: Exception -> L26
    L29:
        return create(r2);
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L35:
        View r8 = this.view;     // Catch: Exception -> L26
        if (r8 == null) goto L18;
        r2 = r8.findViewById(r4);     // Catch: Exception -> L26
    L30:
        th = move-exception;
        throw th;
    }

    public final AsyncQuery parent() {
        Object r0 = acquireLock();
        monitor-enter(r0);
        View r1 = this.holder.get(this.parent);     // Catch: Throwable -> L19
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        if (r1 != null) goto L10;
        View r3 = this.view;
        if (r3 == null) goto L10;
        r1 = (View) r3.getParent();
    L10:
        Object r4 = acquireLock();
        monitor-enter(r4);
        this.holder.put(this.parent, r1);     // Catch: Throwable -> L16
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r4);
        return create(r1);
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    public final AsyncQuery addView(final View r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        addViewInner(r3);
        return this;
    L6:
        this.mainHandler.post(new AnonymousClass1(this, r3));
        return this;
    }

    private final void addViewInner(View r2) {
        if (r2 == null) goto L7;
        View r1 = this.view;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r1).addView(r2);
        return;
    L8:
        return;
    }

    public final AsyncQuery addView(final View r3, final ViewGroup.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        addViewInner(r3, r4);
        return this;
    L6:
        this.mainHandler.post(new AnonymousClass2(this, r3, r4));
        return this;
    }

    private final void addViewInner(View r2, ViewGroup.LayoutParams r3) {
        if (r2 == null) goto L7;
        View r1 = this.view;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r1).addView(r2, r3);
        return;
    L8:
        return;
    }

    public final AsyncQuery contentDescription(final CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "contentDescription");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setContentDescription(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04161(this, r3));
        return this;
    }

    public final AsyncQuery padding(final Rect r5) {
        Intrinsics.checkNotNullParameter(r5, "rect");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setPadding(r5.left, r5.top, r5.right, r5.bottom);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04261(this, r5));
        return this;
    }

    @Deprecated(message = "view 可能为空", replaceWith = @ReplaceWith(expression = "this.viewNullable()", imports = {}))
    public final <T extends View> T view() {
        T r1 = (T) this.view;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.obric.structure.omvvm.core.util.AsyncQuery.view");
        return r1;
    }

    public final <T extends View> T viewNullable() {
        T r1 = (T) this.view;
        if ((r1 instanceof View) == true) goto L7;
        return null;
    L7:
        return r1;
    }

    public final AsyncQuery text(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setText(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04331(this, r3));
        return this;
    }

    public final AsyncQuery text(final CharSequence r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setText(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04342(this, r3));
        return this;
    }

    public final AsyncQuery textFuture(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return textFutureOnExecutor(r2, new AsyncQuery$$ExternalSyntheticLambda2());
    }

    private static final void textFuture$lambda$7(final Runnable r2) {
        QExecutor.INSTANCE.work().post(new AsyncQuery$$ExternalSyntheticLambda1(r2));
    }

    private static final void textFuture$lambda$7$lambda$6(Runnable r0) {
        r0.run();
    }

    public final AsyncQuery textFutureOnExecutor(final CharSequence r3, Executor r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "executor");
        View r0 = this.view;
        if ((r0 instanceof AppCompatTextView) == false) goto L10;
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == true) goto L8;
        final PrecomputedTextCompat r5 = PrecomputedTextCompat.create(r3, TextViewCompat.getTextMetricsParams((TextView) this.view));
        this.mainHandler.post(new C04371(this, r5));
        return this;
    L8:
        final Future<PrecomputedTextCompat> r6 = PrecomputedTextCompat.getTextFuture(r3, TextViewCompat.getTextMetricsParams((TextView) this.view), r4);
        this.mainHandler.post(new C04382(this, r6));
    L16:
        return this;
    L10:
        if ((r0 instanceof TextView) == false) goto L16;
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L15;
        ((TextView) this.view).setText(r3);
        return this;
    L15:
        ((TextView) this.view).post(new AsyncQuery$$ExternalSyntheticLambda0(this, r3));
        goto L16
    }

    private static final void textFutureOnExecutor$lambda$8(AsyncQuery r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$text");
        ((TextView) r1.view).setText(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final AsyncQuery ellipsize(final TextUtils.TruncateAt r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setEllipsize(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04171(this, r3));
        return this;
    }

    public final AsyncQuery textColor(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setTextColor(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04351(this, r3));
        return this;
    }

    public final AsyncQuery textColorId(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setTextColor(((TextView) r0).getResources().getColor(r3));
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04361(this, r3));
        return this;
    }

    public final AsyncQuery typeface(final Typeface r3) {
        Intrinsics.checkNotNullParameter(r3, "tf");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setTypeface(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04421(this, r3));
        return this;
    }

    public final AsyncQuery textSize(final float r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setTextSize(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04391(this, r3));
        return this;
    }

    public final AsyncQuery textSize(final int r3, final float r4) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L7;
        ((TextView) r0).setTextSize(r3, r4);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04402(this, r3, r4));
        return this;
    }

    public final AsyncQuery image(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        imageInner(r3);
        return this;
    L6:
        this.mainHandler.post(new C04211(this, r3));
        return this;
    }

    private final void imageInner(int r2) {
        View r1 = this.view;
        if ((r1 instanceof ImageView) == false) goto L8;
        if (r2 != 0) goto L6;
        ((ImageView) r1).setImageBitmap(null);
        return;
    L6:
        ((ImageView) r1).setImageResource(r2);
        return;
    }

    public final AsyncQuery image(final Drawable r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L7;
        ((ImageView) r0).setImageDrawable(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04222(this, r3));
        return this;
    }

    public final AsyncQuery image(final Bitmap r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L7;
        ((ImageView) r0).setImageBitmap(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new AnonymousClass3(this, r3));
        return this;
    }

    public final AsyncQuery imageBitmapNull() {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L7;
        ((ImageView) r0).setImageBitmap(null);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04231(this));
        return this;
    }

    public final AsyncQuery colorFilter(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L7;
        ((ImageView) r0).setColorFilter(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04151(this, r3));
        return this;
    }

    public final AsyncQuery enabled(final boolean r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        enableInner(r3);
        return this;
    L6:
        this.mainHandler.post(new C04181(this, r3));
        return this;
    }

    private final void enableInner(boolean r1) {
        View r0 = this.view;
        if (r0 == null) goto L6;
        r0.setEnabled(r1);
        return;
    }

    public final AsyncQuery select(final boolean r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setSelected(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04311(this, r3));
        return this;
    }

    public final AsyncQuery scaleX(final float r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setScaleX(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04291(this, r3));
        return this;
    }

    public final AsyncQuery scaleY(final float r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setScaleY(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04301(this, r3));
        return this;
    }

    public final AsyncQuery gone() {
        return visibility(8);
    }

    public final AsyncQuery invisible() {
        return visibility(4);
    }

    public final AsyncQuery visible() {
        return visibility(0);
    }

    public final AsyncQuery visibility(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L10;
        View r0 = this.view;
        if (r0 != null) goto L7;
    L9:
        return this;
    L7:
        if (r0.getVisibility() == r3) goto L9;
        this.view.setVisibility(r3);
        goto L9
    L10:
        this.mainHandler.post(new C04431(this, r3));
        return this;
    }

    public final AsyncQuery runOnUi(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "updater");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        r3.invoke();
        return this;
    L6:
        this.mainHandler.post(new C04271(r3));
        return this;
    }

    public final <T extends View> AsyncQuery runOnUi(int r3, final Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "updater");
        final View r5 = find(r3).view();
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        r4.invoke(r5);
        return this;
    L6:
        this.mainHandler.post(new C04282(r4, r5));
        return this;
    }

    public final AsyncQuery globalLayoutListener(final ViewTreeObserver.OnGlobalLayoutListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.getViewTreeObserver().addOnGlobalLayoutListener(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04201(this, r3));
        return this;
    }

    public final AsyncQuery layoutParams(final ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setLayoutParams(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04241(this, r3));
        return this;
    }

    public final AsyncQuery startAnimator(final ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        r3.start();
        return this;
    L6:
        this.mainHandler.post(new C04321(r3));
        return this;
    }

    public final boolean isVisible() {
        View r0 = this.view;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final AsyncQuery alpha(final float r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setAlpha(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04111(this, r3));
        return this;
    }

    public final AsyncQuery backgroundColor(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04121(this, r3));
        return this;
    }

    public final AsyncQuery backgroundColorId(final int r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r0.getContext().getResources().getColor(r3));
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04131(this, r3));
        return this;
    }

    public final Object getTag() {
        View r0 = this.view;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTag();
    }

    public final CharSequence getText() {
        View r1 = this.view;
        if ((r1 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return ((TextView) r1).getText();
    }

    public final AsyncQuery clickListener(final View.OnClickListener r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setOnClickListener(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04141(this, r3));
        return this;
    }

    public final AsyncQuery longClickListener(final View.OnLongClickListener r3) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L8;
        View r0 = this.view;
        if (r0 == null) goto L7;
        r0.setOnLongClickListener(r3);
    L7:
        return this;
    L8:
        this.mainHandler.post(new C04251(this, r3));
        return this;
    }

    public final AsyncQuery touchListener(final View.OnTouchListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.mainHandler.post(new C04411(this, r3));
        return this;
    }

    private static final void expandTouchSize$expand(final AsyncQuery r8, final int r9, final int r10, final int r11, final int r12) {
        View r0 = r8.view;
        if (r0 == null) goto L6;
        r0.post(new AsyncQuery$expandTouchSize$expand$1(r8, r9, r10, r11, r12));
        return;
    }

    public final AsyncQuery expandTouchSize(final int r9, final int r10, final int r11, final int r12) {
        if (Intrinsics.areEqual(mainThread, Thread.currentThread()) == false) goto L6;
        expandTouchSize$expand(this, r10, r12, r9, r11);
        return this;
    L6:
        this.mainHandler.post(new C04191(this, r10, r12, r9, r11));
        return this;
    }
}
