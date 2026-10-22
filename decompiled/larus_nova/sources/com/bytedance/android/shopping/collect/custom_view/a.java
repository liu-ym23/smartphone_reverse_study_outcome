package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f172206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC2583a f172207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetector f172208c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.custom_view.a$a, reason: collision with other inner class name */
    public interface InterfaceC2583a {
        void b();
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f172209a;

        public b(a r100) {
            this.f172209a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return this.f172209a.f172206a.get();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            InterfaceC2583a r104 = this.f172209a.f172207b;
            if (r104 == null) goto L6;
            r104.b();
        L6:
            return super.onScroll(r100, r101, r102, r103);
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f172206a = new AtomicBoolean(false);
        this.f172208c = new GestureDetector(r100, new b(this));
    }
}
