package com.bytedance.android.livesdk.authorize;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f104205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f104206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f104207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f104208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f104209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AuthorizeGuideViewModel f104210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f104211g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f104212a;

        public a(f r100) {
            this.f104212a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f104212a.h(((Boolean) r100).booleanValue());
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f104213a;

        public b(f r100) {
            this.f104213a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f104213a.a();
        }
    }

    public abstract void a();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public final void b(Observable<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "observable");
        ((ObservableSubscribeProxy) r100.as(AutoDispose.bind(this.f104211g))).subscribe(new a(this));
    }

    public final void h(boolean r100) {
        TextView r101 = this.f104208d;
        if (r101 == null) goto L10;
        r101.setEnabled(!r100);
        if (r100 == true) goto L7;
        int r102 = e();
    L8:
        r101.setText(s1.B(r102));
        return;
    L7:
        r102 = d();
        goto L8
    }

    public f(AuthorizeGuideViewModel r100, AuthorizeGuideService.AuthorizeGuideDialog r101) {
        this.f104210f = r100;
        this.f104211g = r101;
    }

    public final View c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r102 = r100.inflate(R.layout.ttlive_item_authorize_guide, r101, false);
        if (r102 == null) goto L7;
        this.f104205a = (ViewGroup) r102;
        TextView r103 = (TextView) r102.findViewById(R.id.title);
        r103.setText(s1.B(g()));
        Unit r104 = Unit.INSTANCE;
        this.f104206b = r103;
        TextView r105 = (TextView) r102.findViewById(R.id.content);
        r105.setText(s1.B(f()));
        this.f104207c = r105;
        TextView r106 = (TextView) r102.findViewById(R.id.button);
        r106.setText(s1.B(e()));
        r106.setOnClickListener(new b(this));
        this.f104208d = r106;
        this.f104209e = (TextView) r102.findViewById(R.id.unavailable_text);
        return r102;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
