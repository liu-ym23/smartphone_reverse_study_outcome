package b41;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b41.a f17498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f17499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRenderView f17500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f17501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c41.a f17502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f17503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<RectF, Unit> f17504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Float, Unit> f17505h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f17506a;

        public a(f r100) {
            this.f17506a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Unit r101 = (Unit) r100;
            this.f17506a.a();
        }
    }

    public final void a() {
        IRenderView r100 = this.f17500c;
        if (r100 == null) goto L15;
        View r101 = r100.getSelfView();
        if (r101 == null) goto L16;
        float r102 = r101.getScaleX();
        if (r102 == r101.getScaleY()) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r102, this.f17501d) == false) goto L13;
        return;
    L13:
        this.f17505h.invoke(Float.valueOf(r102));
        this.f17501d = Float.valueOf(r102);
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(c41.a r100, View r101, Function1<? super RectF, Unit> r102, Function1<? super Float, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "pkScaleCallback");
        this.f17502e = r100;
        this.f17503f = r101;
        this.f17504g = r102;
        this.f17505h = r103;
        this.f17498a = new b41.a(r101, r102);
        this.f17499b = new a(this);
    }
}
