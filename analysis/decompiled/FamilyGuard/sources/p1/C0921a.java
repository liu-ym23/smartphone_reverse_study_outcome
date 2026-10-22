package p1;

import a1.C0409b;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0451v;
import androidx.core.widget.c;
import com.google.android.material.internal.o;
import g.C0728a;
import j1.C0777a;
import q1.C0981c;
import x1.C1282a;

/* renamed from: p1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0921a extends C0451v {

    /* renamed from: g, reason: collision with root package name */
    private static final int f19351g = C0417j.f6928s;

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f19352h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f19353e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f19354f;

    public C0921a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16815L);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f19353e == null) {
            int iD = C0777a.d(this, C0728a.f16847x);
            int iD2 = C0777a.d(this, C0409b.f6717d);
            int iD3 = C0777a.d(this, C0409b.f6720g);
            int[][] iArr = f19352h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = C0777a.j(iD3, iD, 1.0f);
            iArr2[1] = C0777a.j(iD3, iD2, 0.54f);
            iArr2[2] = C0777a.j(iD3, iD2, 0.38f);
            iArr2[3] = C0777a.j(iD3, iD2, 0.38f);
            this.f19353e = new ColorStateList(iArr, iArr2);
        }
        return this.f19353e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19354f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.f19354f = z5;
        if (z5) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0921a(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f19351g;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        Context context2 = getContext();
        TypedArray typedArrayI = o.i(context2, attributeSet, C0418k.f7160k3, i5, i6, new int[0]);
        int i7 = C0418k.f7166l3;
        if (typedArrayI.hasValue(i7)) {
            c.d(this, C0981c.a(context2, typedArrayI, i7));
        }
        this.f19354f = typedArrayI.getBoolean(C0418k.f7172m3, false);
        typedArrayI.recycle();
    }
}
