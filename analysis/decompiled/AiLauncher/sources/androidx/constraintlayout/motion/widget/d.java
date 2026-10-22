package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static int f12237f = -1;

    /* renamed from: a, reason: collision with root package name */
    public int f12238a;

    /* renamed from: b, reason: collision with root package name */
    public int f12239b;

    /* renamed from: c, reason: collision with root package name */
    public String f12240c;

    /* renamed from: d, reason: collision with root package name */
    public int f12241d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f12242e;

    public d() {
        int i10 = f12237f;
        this.f12238a = i10;
        this.f12239b = i10;
        this.f12240c = null;
    }

    public abstract void a(HashMap<String, AbstractC5140d> map);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract d clone();

    public d c(d dVar) {
        this.f12238a = dVar.f12238a;
        this.f12239b = dVar.f12239b;
        this.f12240c = dVar.f12240c;
        this.f12241d = dVar.f12241d;
        this.f12242e = dVar.f12242e;
        return this;
    }

    public abstract void d(HashSet<String> hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public boolean f(String str) {
        String str2 = this.f12240c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(HashMap<String, Integer> map) {
    }

    public d h(int i10) {
        this.f12239b = i10;
        return this;
    }
}
