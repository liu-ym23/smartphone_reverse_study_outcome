package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.preference.MultiSelectListPreferenceDialogFragmentCompat;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AlertController {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final boolean E;
    public final c F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f213a;

    /* renamed from: b, reason: collision with root package name */
    public final f f214b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f215c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f216d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f217e;

    /* renamed from: f, reason: collision with root package name */
    public RecycleListView f218f;

    /* renamed from: g, reason: collision with root package name */
    public View f219g;

    /* renamed from: i, reason: collision with root package name */
    public Button f220i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f221j;

    /* renamed from: k, reason: collision with root package name */
    public Message f222k;

    /* renamed from: l, reason: collision with root package name */
    public Button f223l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f224m;

    /* renamed from: n, reason: collision with root package name */
    public Message f225n;

    /* renamed from: o, reason: collision with root package name */
    public Button f226o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f227p;

    /* renamed from: q, reason: collision with root package name */
    public Message f228q;
    public NestedScrollView r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f229s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f230t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f231u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f232v;

    /* renamed from: w, reason: collision with root package name */
    public View f233w;

    /* renamed from: x, reason: collision with root package name */
    public ListAdapter f234x;
    public final int z;
    public boolean h = false;

    /* renamed from: y, reason: collision with root package name */
    public int f235y = -1;
    public final a G = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f236a;

        /* renamed from: b, reason: collision with root package name */
        public final int f237b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8938t);
            this.f237b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f236a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f220i || (message3 = alertController.f222k) == null) ? (view != alertController.f223l || (message2 = alertController.f225n) == null) ? (view != alertController.f226o || (message = alertController.f228q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            alertController.F.obtainMessage(1, alertController.f214b).sendToTarget();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ContextThemeWrapper f239a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f240b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f241c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f242d;

        /* renamed from: e, reason: collision with root package name */
        public View f243e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f244f;

        /* renamed from: g, reason: collision with root package name */
        public CharSequence f245g;
        public DialogInterface.OnClickListener h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f246i;

        /* renamed from: j, reason: collision with root package name */
        public PreferenceDialogFragmentCompat f247j;

        /* renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f248k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence[] f249l;

        /* renamed from: m, reason: collision with root package name */
        public Object f250m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f251n;

        /* renamed from: o, reason: collision with root package name */
        public View f252o;

        /* renamed from: p, reason: collision with root package name */
        public boolean[] f253p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f254q;
        public boolean r;

        /* renamed from: s, reason: collision with root package name */
        public int f255s = -1;

        /* renamed from: t, reason: collision with root package name */
        public MultiSelectListPreferenceDialogFragmentCompat.a f256t;

        public b(ContextThemeWrapper contextThemeWrapper) {
            this.f239a = contextThemeWrapper;
            this.f240b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f257a;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f257a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, f fVar, Window window) {
        this.f213a = context;
        this.f214b = fVar;
        this.f215c = window;
        c cVar = new c();
        cVar.f257a = new WeakReference<>(fVar);
        this.F = cVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, g.a.f8925e, R.attr.alertDialogStyle, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.D = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.E = typedArrayObtainStyledAttributes.getBoolean(10, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        fVar.c().n(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.F.obtainMessage(i10, onClickListener) : null;
        if (i10 == -3) {
            this.f227p = charSequence;
            this.f228q = messageObtainMessage;
        } else if (i10 == -2) {
            this.f224m = charSequence;
            this.f225n = messageObtainMessage;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f221j = charSequence;
            this.f222k = messageObtainMessage;
        }
    }
}
