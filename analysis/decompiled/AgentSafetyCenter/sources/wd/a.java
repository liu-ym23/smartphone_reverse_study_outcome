package wd;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stepos.agentsafetycenter.R;
import h.b;
import h.c;
import h.d;
import h.e;
import h.e0;
import h.f0;
import h.g;
import h.h;
import h.q;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kb.l;
import l.m;
import o3.o;
import od.f;
import p.u;
import p0.j;
import s.g0;
import s.i;
import s.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15388c;

    /* renamed from: f, reason: collision with root package name */
    public int f15389f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15390g;

    public a(Context context) {
        this.f15388c = 3;
        int iF = h.f(context, 0);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, h.f(context, iF));
        d dVar = new d();
        dVar.f4765j = -1;
        dVar.f4757a = contextThemeWrapper;
        dVar.f4758b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        VarHandle.storeStoreFence();
        this.f15390g = dVar;
        this.f15389f = iF;
    }

    public void a(long j10) {
        if (e(j10)) {
            return;
        }
        int i = this.f15389f;
        long[] jArrCopyOf = (long[]) this.f15390g;
        if (i >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(i + 1, jArrCopyOf.length * 2));
            this.f15390g = jArrCopyOf;
        }
        jArrCopyOf[i] = j10;
        if (i >= this.f15389f) {
            this.f15389f = i + 1;
        }
    }

    public g0 b(int i, Float f5) {
        f fVar = w.f11153b;
        g0 g0Var = new g0();
        g0Var.f11013a = f5;
        g0Var.f11014b = fVar;
        ((u) this.f15390g).h(i, g0Var);
        return g0Var;
    }

    @Override // o3.o
    public boolean c(View view) {
        ((BottomSheetBehavior) this.f15390g).m(this.f15389f);
        return true;
    }

    public void d() {
        WeakReference weakReference;
        this.f15389f = 0;
        Iterator it = ((LinkedHashMap) this.f15390g).values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                c6.f fVar = (c6.f) l.x0(arrayList);
                if (((fVar == null || (weakReference = fVar.f2218b) == null) ? null : (Bitmap) weakReference.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int i10 = i3 - i;
                    if (((c6.f) arrayList.get(i10)).f2218b.get() == null) {
                        arrayList.remove(i10);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public boolean e(long j10) {
        int i = this.f15389f;
        for (int i3 = 0; i3 < i; i3++) {
            if (((long[]) this.f15390g)[i3] == j10) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    public h f() {
        int i;
        d dVar = (d) this.f15390g;
        ContextThemeWrapper contextThemeWrapper = dVar.f4757a;
        int iF = h.f(contextThemeWrapper, this.f15389f);
        if (iF == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        } else {
            i = iF;
        }
        h hVar = new h(contextThemeWrapper, i);
        f0 f0Var = new f0();
        f0Var.f4810c = hVar;
        VarHandle.storeStoreFence();
        hVar.i = f0Var;
        q qVarD = hVar.d();
        if (iF == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iF = typedValue2.resourceId;
        }
        ((e0) qVarD).V = iF;
        qVarD.c();
        Context context = hVar.getContext();
        Window window = hVar.getWindow();
        g gVar = new g();
        gVar.f4825p = -1;
        int i3 = 0;
        b bVar = new b(i3);
        bVar.f4749f = gVar;
        VarHandle.storeStoreFence();
        gVar.f4829t = bVar;
        gVar.f4811a = context;
        gVar.f4812b = hVar;
        gVar.f4813c = window;
        e eVar = new e(0);
        eVar.f4782b = new WeakReference(hVar);
        gVar.f4828s = eVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, g.a.f4102e, R.attr.alertDialogStyle, 0);
        gVar.f4826q = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        gVar.f4827r = typedArrayObtainStyledAttributes.getBoolean(10, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        hVar.d().g(1);
        VarHandle.storeStoreFence();
        hVar.f4835j = gVar;
        VarHandle.storeStoreFence();
        View view = dVar.f4761e;
        if (view != null) {
            gVar.f4823n = view;
        } else {
            CharSequence charSequence = dVar.f4760d;
            if (charSequence != null) {
                gVar.f4814d = charSequence;
                TextView textView = gVar.f4821l;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = dVar.f4759c;
            if (drawable != null) {
                gVar.f4819j = drawable;
                ImageView imageView = gVar.f4820k;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    gVar.f4820k.setImageDrawable(drawable);
                }
            }
        }
        if (dVar.f4763g != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) dVar.f4758b.inflate(resourceId, (ViewGroup) null);
            int i10 = dVar.i ? resourceId2 : resourceId3;
            Object obj = dVar.f4763g;
            ?? fVar = obj;
            if (obj == null) {
                fVar = new h.f(dVar.f4757a, i10, android.R.id.text1, null, 0);
            }
            gVar.f4824o = fVar;
            gVar.f4825p = dVar.f4765j;
            if (dVar.f4764h != null) {
                c cVar = new c(i3);
                cVar.f4754g = dVar;
                cVar.f4753f = gVar;
                VarHandle.storeStoreFence();
                alertController$RecycleListView.setOnItemClickListener(cVar);
            }
            if (dVar.i) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            gVar.f4815e = alertController$RecycleListView;
        }
        hVar.setCancelable(true);
        hVar.setCanceledOnTouchOutside(true);
        hVar.setOnCancelListener(null);
        hVar.setOnDismissListener(null);
        m mVar = dVar.f4762f;
        if (mVar != null) {
            hVar.setOnKeyListener(mVar);
        }
        return hVar;
    }

    public boolean g() {
        return this.f15389f < ((ArrayList) this.f15390g).size();
    }

    public void h(long j10) {
        int i = this.f15389f;
        int i3 = 0;
        while (i3 < i) {
            if (j10 == ((long[]) this.f15390g)[i3]) {
                int i10 = this.f15389f - 1;
                while (i3 < i10) {
                    long[] jArr = (long[]) this.f15390g;
                    int i11 = i3 + 1;
                    jArr[i3] = jArr[i11];
                    i3 = i11;
                }
                this.f15389f--;
                return;
            }
            i3++;
        }
    }

    public synchronized void i(c6.a aVar, Bitmap bitmap, Map map, int i) {
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.f15390g;
            Object arrayList = linkedHashMap.get(aVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(aVar, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            WeakReference weakReference = new WeakReference(bitmap);
            c6.f fVar = new c6.f();
            fVar.f2217a = iIdentityHashCode;
            fVar.f2218b = weakReference;
            fVar.f2219c = map;
            fVar.f2220d = i;
            VarHandle.storeStoreFence();
            int size = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    arrayList2.add(fVar);
                    break;
                }
                c6.f fVar2 = (c6.f) arrayList2.get(i3);
                if (i < fVar2.f2220d) {
                    i3++;
                } else if (fVar2.f2217a == iIdentityHashCode && fVar2.f2218b.get() == bitmap) {
                    arrayList2.set(i3, fVar);
                } else {
                    arrayList2.add(i3, fVar);
                }
            }
            int i10 = this.f15389f;
            this.f15389f = i10 + 1;
            if (i10 >= 10) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        switch (this.f15388c) {
            case 0:
                StringBuilder sb2 = new StringBuilder("<");
                sb2.append(a.class.getName());
                sb2.append(" (type=");
                sb2.append(w2.c.f(this.f15389f));
                sb2.append(", value=");
                return androidx.activity.b.n(sb2, (String) this.f15390g, ")>");
            case 7:
                StringBuilder sb3 = new StringBuilder("AnimationResult(endReason=");
                int i = this.f15389f;
                sb3.append(i != 1 ? i != 2 ? "null" : "Finished" : "BoundReached");
                sb3.append(", endState=");
                sb3.append((i) this.f15390g);
                sb3.append(')');
                return sb3.toString();
            default:
                return super.toString();
        }
    }

    public a(zd.d dVar) {
        this.f15388c = 0;
        yd.a aVar = dVar.f16587a;
        String str = dVar.f16582d;
        int i = dVar.f16581c;
        this.f15390g = str;
        this.f15389f = i;
    }

    public a(j jVar, int i) {
        this.f15388c = 5;
        this.f15390g = jVar;
        this.f15389f = i;
    }

    public /* synthetic */ a(int i) {
        this.f15388c = i;
    }
}
