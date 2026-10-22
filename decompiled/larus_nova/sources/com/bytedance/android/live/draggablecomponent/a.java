package com.bytedance.android.live.draggablecomponent;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends com.bytedance.android.livesdk.common.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f66646b;

    /* JADX INFO: renamed from: com.bytedance.android.live.draggablecomponent.a$a, reason: collision with other inner class name */
    public static final class C1103a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f66647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<Dialog, View, Unit> f66648b;

        /* JADX WARN: Multi-variable type inference failed */
        public C1103a(CharSequence r100, Function2<? super Dialog, ? super View, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemText");
            this.f66647a = r100;
            this.f66648b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1103a f66649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<C1103a> f66650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C1103a f66651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f66652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f66653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f66654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f66655g;

        public b(List r100) {
            int r101 = s1.h(R.color.ttlive_core_hs_s9);
            int r102 = s1.f(56.0f);
            int r103 = s1.h(R.color.ttlive_live_dialog_title);
            Intrinsics.checkNotNullParameter(r100, "itemList");
            this.f66649a = null;
            this.f66650b = r100;
            this.f66651c = null;
            this.f66652d = r101;
            this.f66653e = 15.0f;
            this.f66654f = r102;
            this.f66655g = r103;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f66656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f66657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C1103a f66658c;

        public c(TextView r100, a r101, C1103a r102) {
            this.f66656a = r100;
            this.f66657b = r101;
            this.f66658c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function2<Dialog, View, Unit> r101 = this.f66658c.f66648b;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f66657b, this.f66656a);
            return;
        }
    }

    public final View b() {
        View r100 = new View(getContext());
        r100.setBackgroundResource(R.color.ttlive_core_hs_s9);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(1.0f)));
        return r100;
    }

    public final TextView a(C1103a r100) {
        TextView r101 = new TextView(getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f66646b.f66654f));
        r101.setGravity(17);
        r101.setTextSize(1, this.f66646b.f66653e);
        r101.setTextColor(this.f66646b.f66655g);
        r101.setText(r100.f66647a);
        r101.setOnClickListener(new c(r101, this, r100));
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_bottom, null);
        if (r101 == null) goto L17;
        ViewGroup r102 = (ViewGroup) r101;
        C1103a r103 = this.f66646b.f66649a;
        if (r103 == null) goto L7;
        TextView r104 = new TextView(getContext());
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f66646b.f66654f));
        r104.setGravity(17);
        r104.setTextSize(1, this.f66646b.f66653e);
        r104.setTextColor(this.f66646b.f66655g);
        r104.setText(r103.f66647a);
        r102.addView(r104);
        r102.addView(b());
    L7:
        Iterator<T> r105 = this.f66646b.f66650b.iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        r102.addView(a((C1103a) r105.next()));
        r102.addView(b());
        goto L9
    L11:
        C1103a r106 = this.f66646b.f66651c;
        if (r106 == null) goto L14;
        View r107 = new View(getContext());
        r107.setBackgroundColor(this.f66646b.f66652d);
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(8.0f)));
        r102.addView(r107);
        r102.addView(a(r106));
    L14:
        Unit r108 = Unit.INSTANCE;
        setContentView(r102);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public a(Context r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, true);
        this.f66646b = r101;
    }
}
