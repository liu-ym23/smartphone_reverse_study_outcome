package com.bytedance.android.live.uikit.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f102119J;
    public final c K;
    public final ViewOnClickListenerC1549a L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f102120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f102121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f102122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f102123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f102124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ListView f102125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f102126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f102127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f102128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f102129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f102130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f102131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f102132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Button f102133n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f102134o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Message f102135p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Button f102136q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f102137r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Message f102138s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f102139t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CharSequence f102140u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Message f102141v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ScrollView f102142w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f102143x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f102144y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f102145z;

    /* JADX INFO: renamed from: com.bytedance.android.live.uikit.dialog.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC1549a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f102146a;

        public ViewOnClickListenerC1549a(a r100) {
            this.f102146a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f102146a;
            if (r100 != r101.f102133n) goto L8;
            Message r102 = r101.f102135p;
            if (r102 == null) goto L8;
            Message r103 = Message.obtain(r102);
        L18:
            if (r103 == null) goto L20;
            r103.sendToTarget();
        L20:
            a r104 = this.f102146a;
            r104.K.obtainMessage(1, r104.f102121b).sendToTarget();
            return;
        L8:
            if (r100 != r101.f102136q) goto L13;
            Message r105 = r101.f102138s;
            if (r105 == null) goto L13;
            r103 = Message.obtain(r105);
        L13:
            if (r100 != r101.f102139t) goto L17;
            Message r106 = r101.f102141v;
            if (r106 == null) goto L17;
            r103 = Message.obtain(r106);
        L17:
            r103 = null;
            goto L18
        }
    }

    public static class b {
        public boolean A;
        public boolean[] B;
        public boolean C;
        public boolean D;
        public int E;
        public DialogInterface.OnMultiChoiceClickListener F;
        public Cursor G;
        public String H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f102147J;
        public AdapterView.OnItemSelectedListener K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f102148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f102149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f102150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f102151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f102152e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f102153f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f102154g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f102155h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f102156i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f102157j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f102158k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f102159l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public DialogInterface.OnClickListener f102160m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f102161n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public DialogInterface.OnCancelListener f102162o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public DialogInterface.OnDismissListener f102163p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnKeyListener f102164q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence[] f102165r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ListAdapter f102166s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnClickListener f102167t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f102168u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public View f102169v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f102170w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f102171x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f102172y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f102173z;

        public b(Context r100) {
            this.f102150c = 0;
            this.A = false;
            this.E = -1;
            this.f102148a = r100;
            this.f102161n = true;
            this.f102149b = (LayoutInflater) r100.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f102174a;

        public c(DialogInterface r100) {
            this.f102174a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.f102174a.get(), r100.what);
            return;
        L5:
            if (r101 == (-2)) goto L12;
            if (r101 == (-1)) goto L12;
            if (r101 != 1) goto L15;
            ((DialogInterface) r100.obj).dismiss();
            return;
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }

        public d(Context r100, int r101, CharSequence[] r102) {
            super(r100, r101, R.id.text1, r102);
        }
    }

    public static boolean b(View r100) {
        if (r100.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
    L9:
        if (r102 <= 0) goto L13;
        r102 = r102 - 1;
        if (b(r101.getChildAt(r102)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    public final void d(int r100) {
        this.f102144y = null;
        this.f102143x = r100;
        ImageView r101 = this.f102145z;
        if (r101 == null) goto L8;
        if (r100 == 0) goto L6;
        r101.setImageResource(r100);
        return;
    L6:
        r101.setVisibility(8);
        return;
    }

    public a(Context r100, DialogInterface r101, Window r102) {
        this.f102132m = false;
        this.f102143x = 0;
        this.E = -1;
        this.L = new ViewOnClickListenerC1549a(this);
        this.f102120a = r100;
        this.f102121b = r101;
        this.f102122c = r102;
        this.K = new c(r101);
        this.F = R.layout.liveuikit_ss_alert_dialog;
        this.G = R.layout.liveuikit_ss_select_dialog;
        this.H = R.layout.liveuikit_ss_select_dialog_multichoice;
        this.I = R.layout.liveuikit_ss_select_dialog_singlechoice;
        this.f102119J = R.layout.liveuikit_ss_select_dialog_item;
    }

    public static void a(View r100, View r101, View r102) {
        int r103 = 4;
        if (r101 != null) goto L5;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r100.canScrollVertically(1) == false) goto L13;
        r103 = 0;
    L13:
        r102.setVisibility(r103);
        return;
    L5:
        if (r100.canScrollVertically(-1) == false) goto L7;
        int r104 = 0;
    L8:
        r101.setVisibility(r104);
        goto L9
    L7:
        r104 = 4;
        goto L8
    }

    public final void c(int r100, CharSequence r101, DialogInterface.OnClickListener r102, Message r103) {
        if (r103 != null) goto L6;
        if (r102 == null) goto L6;
        r103 = this.K.obtainMessage(r100, r102);
    L6:
        if (r100 != (-3)) goto L8;
        this.f102140u = r101;
        this.f102141v = r103;
        return;
    L8:
        if (r100 != (-2)) goto L10;
        this.f102137r = r101;
        this.f102138s = r103;
        return;
    L10:
        if (r100 != (-1)) goto L13;
        this.f102134o = r101;
        this.f102135p = r103;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }
}
