package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends com.bytedance.android.livesdk.common.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f143632b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.view.a$a, reason: collision with other inner class name */
    public static final class C2246a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f143633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f143634b;

        public final Context getContext() {
            return this.f143634b;
        }

        public C2246a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f143634b = r100;
            this.f143633a = new c(new ArrayList());
        }

        public final void a(Function2 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            c r101 = this.f143633a;
            r101.f143639c = new b(new SpannableString(s1.B(R.string.ttlive_cancel)), r100);
        }

        public final void b(int r100, Function2 r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
            String r102 = s1.B(r100);
            Intrinsics.checkNotNullParameter(r102, "itemText");
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f143633a.f143638b.add(new b(r102, r101));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f143635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<Dialog, View, Unit> f143636b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(CharSequence r100, Function2<? super Dialog, ? super View, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemText");
            this.f143635a = r100;
            this.f143636b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f143637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f143638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f143639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f143640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f143641e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f143642f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f143643g;

        public c(List r100) {
            int r101 = s1.h(R.color.ttlive_core_hs_s9);
            int r102 = s1.f(56.0f);
            int r103 = s1.h(R.color.ttlive_live_dialog_title);
            Intrinsics.checkNotNullParameter(r100, "itemList");
            this.f143637a = null;
            this.f143638b = r100;
            this.f143639c = null;
            this.f143640d = r101;
            this.f143641e = 15.0f;
            this.f143642f = r102;
            this.f143643g = r103;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f143644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f143645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f143646c;

        public d(TextView r100, a r101, b r102) {
            this.f143644a = r100;
            this.f143645b = r101;
            this.f143646c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function2<Dialog, View, Unit> r101 = this.f143646c.f143636b;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f143645b, this.f143644a);
            return;
        }
    }

    public final View b() {
        View r100 = new View(getContext());
        r100.setBackgroundResource(R.color.ttlive_core_hs_s9);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(1.0f)));
        return r100;
    }

    public final TextView a(b r100) {
        TextView r101 = new TextView(getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f143632b.f143642f));
        r101.setGravity(17);
        r101.setTextSize(1, this.f143632b.f143641e);
        r101.setTextColor(this.f143632b.f143643g);
        r101.setText(r100.f143635a);
        r101.setOnClickListener(new d(r101, this, r100));
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_bottom, null);
        if (r101 == null) goto L17;
        ViewGroup r102 = (ViewGroup) r101;
        b r103 = this.f143632b.f143637a;
        if (r103 == null) goto L7;
        TextView r104 = new TextView(getContext());
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f143632b.f143642f));
        r104.setGravity(17);
        r104.setTextSize(1, this.f143632b.f143641e);
        r104.setTextColor(this.f143632b.f143643g);
        r104.setText(r103.f143635a);
        r102.addView(r104);
        r102.addView(b());
    L7:
        Iterator<T> r105 = this.f143632b.f143638b.iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        r102.addView(a((b) r105.next()));
        r102.addView(b());
        goto L9
    L11:
        b r106 = this.f143632b.f143639c;
        if (r106 == null) goto L14;
        View r107 = new View(getContext());
        r107.setBackgroundColor(this.f143632b.f143640d);
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

    public a(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, true);
        this.f143632b = r101;
    }
}
