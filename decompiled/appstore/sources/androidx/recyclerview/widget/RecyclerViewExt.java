package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.base.EdgeEffectAdapter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class RecyclerViewExt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4257c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f4258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4259b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f4257c = new a(null);
    }

    public RecyclerViewExt(RecyclerView r10) {
        q.g(r10, "recyclerView");
        this.f4258a = r10;
    }

    public final void a(boolean r10) {
        this.f4259b = r10;
    }

    public final boolean b(MotionEvent r10, boolean r11) {
        q.g(r10, "event");
        if (this.f4259b == true) goto L6;
        return r11;
    L6:
        if (r10.getAction() == 0) goto L8;
        return r11;
    L8:
        RecyclerView r12 = this.f4258a;
        EdgeEffectAdapter r13 = r12.mHorizontalEdgeEffect;
        EdgeEffectAdapter r14 = r12.mVerticalEdgeEffect;
        if (r13 != null) goto L11;
    L16:
        if (r14 == null) goto L24;
        if (r14.c() == 0.0f) goto L24;
        if (Math.abs(r14.c()) >= 100.0f) goto L24;
        return true;
    L24:
        return r11;
    L11:
        if (r13.c() == 0.0f) goto L16;
        if (Math.abs(r13.c()) >= 100.0f) goto L16;
        r11 = true;
        goto L16
    }
}
