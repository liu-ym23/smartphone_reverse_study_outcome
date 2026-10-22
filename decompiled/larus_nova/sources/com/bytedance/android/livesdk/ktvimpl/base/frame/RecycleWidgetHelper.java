package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class RecycleWidgetHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f142499a = 0;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f142500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DataCenter f142501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f142502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f142503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function1<? super Boolean, Unit> f142504e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function0<Unit> f142505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LifecycleOwner f142506g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ViewGroup f142507h;

        public Builder(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            this.f142506g = null;
            this.f142507h = r100;
        }

        public final <T extends AbsRecycleViewKWidget<?>> T a(Function3<? super LifecycleOwner, ? super ViewGroup, ? super c, ? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "newInstanceFactory");
            String r101 = this.f142502c;
            final long r102 = System.currentTimeMillis();
            final Function1<T, Unit> r103 = new RecycleWidgetHelper$Builder$recycleOrCreate$notifyReLoadComplete$1(this, r102);
            if (r101 != null) goto L5;
        L20:
            T r104 = r100.invoke(this.f142506g, this.f142507h, this.f142500a);
            r104.g(null);
            r104.f142493g = this.f142503d;
            Function1<? super Boolean, Unit> r105 = this.f142504e;
            if (r105 == null) goto L23;
            Unit r106 = r105.invoke(Boolean.FALSE);
        L23:
            return r104;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r107 = true;
        L8:
            if (r107 == false) goto L20;
            DataCenter r108 = this.f142501b;
            if (r108 == null) goto L12;
            final T r109 = (T) r108.get(r101, null);
        L13:
            if (r109 == null) goto L20;
            if (r109.i() == true) goto L20;
            r109.k(this.f142506g, this.f142507h, this.f142500a, new RecycleWidgetHelper$Builder$recycleOrCreate$1(r103, r109));
            r109.f142493g = this.f142503d;
            Function1<? super Boolean, Unit> r110 = this.f142504e;
            if (r110 == null) goto L19;
            Unit r111 = r110.invoke(Boolean.TRUE);
        L19:
            return r109;
        L12:
            r109 = null;
            goto L13
        L7:
            r107 = false;
            goto L8
        }
    }

    public static final class a {
    }

    static {
    }
}
