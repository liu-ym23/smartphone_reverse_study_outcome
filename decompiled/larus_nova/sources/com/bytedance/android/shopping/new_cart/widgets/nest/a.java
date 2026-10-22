package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f179559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GestureDetector f179560b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.widgets.nest.a$a, reason: collision with other inner class name */
    public static final class C2673a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f179561a;

        public C2673a(a r100) {
            this.f179561a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return this.f179561a.f179559a.get();
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f179559a = new AtomicBoolean(false);
        this.f179560b = new GestureDetector(r100, new C2673a(this));
    }
}
