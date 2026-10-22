package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.view.menu.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final p f12078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12079b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12080c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ContextThemeWrapper f12081a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f12082b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f12083c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f12084d;

        /* renamed from: e, reason: collision with root package name */
        public View f12085e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f12086f;

        /* renamed from: g, reason: collision with root package name */
        public DialogInterface.OnClickListener f12087g;
        public CharSequence h;

        /* renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f12088i;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnCancelListener f12090k;

        /* renamed from: l, reason: collision with root package name */
        public stepos.support.v7.view.menu.d f12091l;

        /* renamed from: m, reason: collision with root package name */
        public b.a f12092m;

        /* renamed from: n, reason: collision with root package name */
        public stepos.support.v7.view.menu.d f12093n;

        /* renamed from: o, reason: collision with root package name */
        public View f12094o;

        /* renamed from: p, reason: collision with root package name */
        public int f12095p;

        /* renamed from: q, reason: collision with root package name */
        public int f12096q = 1;

        /* renamed from: j, reason: collision with root package name */
        public boolean f12089j = true;

        public a(ContextThemeWrapper contextThemeWrapper) {
            this.f12081a = contextThemeWrapper;
            this.f12082b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f12097a;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f12097a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: stepos.support.v7.app.c$c, reason: collision with other inner class name */
    public static class C0142c extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends ListView {
    }

    public c(Context context, p pVar) {
        this.f12078a = pVar;
        new b().f12097a = new WeakReference<>(pVar);
        new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3413b, R.attr.alertDialogStyle, 0);
        typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f12079b = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.f12080c = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        typedArrayObtainStyledAttributes.recycle();
        pVar.supportRequestWindowFeature(1);
    }

    public void a(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        throw null;
    }

    public void b(int i10) {
        throw null;
    }

    public void c(Drawable drawable) {
        throw null;
    }
}
