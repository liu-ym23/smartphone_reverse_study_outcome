package com.bytedance.android.gamecp.business.gamedetail.asyncinflate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class GameAsyncInflate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Context, WeakReference<IAsyncInflater>> f53467a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0017R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/asyncinflate/GameAsyncInflate$AsyncInflaterImpl;", "Lcom/bytedance/android/gamecp/business/gamedetail/asyncinflate/GameAsyncInflate$IAsyncInflater;", "", LiveCommonConstants.REASON_ON_DEDTROY, "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "InflateTransactionImpl", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AsyncInflaterImpl implements IAsyncInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, View> f53468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f53469b;

        public final class InflateTransactionImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LayoutInflater f53470a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final FrameLayout f53471b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List<Integer> f53472c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AsyncInflaterImpl f53473d;

            public final void b() {
                ThreadsKt.thread$default(false, false, null, null, 0, new GameAsyncInflate$AsyncInflaterImpl$InflateTransactionImpl$commit$1(this), 31, null);
            }

            public InflateTransactionImpl(AsyncInflaterImpl r100) {
                this.f53473d = r100;
                this.f53470a = LayoutInflater.from(r100.getContext()).cloneInContext(r100.getContext());
                this.f53471b = new FrameLayout(r100.getContext());
                this.f53472c = new ArrayList();
            }

            public final InflateTransactionImpl a(int r100) {
                List<Integer> r101 = this.f53472c;
                ArrayList r102 = (ArrayList) r101;
                r102.add(Integer.valueOf(r100));
                return this;
            }
        }

        @Override // com.bytedance.android.gamecp.business.gamedetail.asyncinflate.GameAsyncInflate.IAsyncInflater
        public final InflateTransactionImpl nP() {
            return new InflateTransactionImpl(this);
        }

        @Override // com.bytedance.android.gamecp.business.gamedetail.asyncinflate.GameAsyncInflate.IAsyncInflater
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f53468a.clear();
        }

        public final Context getContext() {
            return this.f53469b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AsyncInflaterImpl(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f53469b = r100;
            this.f53468a = new ConcurrentHashMap();
            if ((r100 instanceof LifecycleOwner) == false) goto L6;
            ((LifecycleOwner) r100).getLifecycle().addObserver(this);
            return;
        }

        @Override // com.bytedance.android.gamecp.business.gamedetail.asyncinflate.GameAsyncInflate.IAsyncInflater
        public final View aU(int r100, ViewGroup r101, boolean r102) {
            View r103 = this.f53468a.remove(Integer.valueOf(r100));
            if (r103 == null) goto L10;
            LocalTestManager.a(new Class[]{uv.a.class});
            if (r101 == null) goto L9;
            if (r102 == false) goto L9;
            r101.addView(r103);
            return r101;
        L9:
            return r103;
        L10:
            LocalTestManager.a(new Class[]{uv.a.class});
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/asyncinflate/GameAsyncInflate$IAsyncInflater;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IAsyncInflater extends LifecycleObserver {
        View aU(int r100, ViewGroup r101, boolean r102);

        AsyncInflaterImpl.InflateTransactionImpl nP();

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/asyncinflate/GameAsyncInflate$InflaterLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InflaterLifecycleObserver implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f53474a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            this.f53474a.invoke();
        }

        public InflaterLifecycleObserver(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onActivityDestroy");
            this.f53474a = r100;
        }
    }

    static {
        f53467a = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IAsyncInflater a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ConcurrentHashMap<Context, WeakReference<IAsyncInflater>> r101 = f53467a;
        WeakReference<IAsyncInflater> r102 = r101.get(r100);
        if (r102 == null) goto L5;
        IAsyncInflater r103 = r102.get();
    L6:
        if (r103 != null) goto L10;
        LocalTestManager.a(new Class[]{uv.a.class});
        r103 = new AsyncInflaterImpl(r100);
        r101.put(r100, new WeakReference(r103));
        if ((r100 instanceof LifecycleOwner) == false) goto L10;
        ((LifecycleOwner) r100).getLifecycle().addObserver(new InflaterLifecycleObserver(new GameAsyncInflate$asyncInflater$2(r100)));
    L10:
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
