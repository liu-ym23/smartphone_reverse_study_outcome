package com.google.android.material.datepicker;

import a.AbstractC0291a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Log;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import c3.AbstractC0873c;
import com.stepos.ability.mcpserver.monitor.McpServerMonitor$Outcome;
import e3.C1412a;
import i4.C1554b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import z7.AbstractC2188i;
import z7.InterfaceC2180a;
import z7.RunnableC2181b;

/* renamed from: com.google.android.material.datepicker.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0900c implements InterfaceC2180a {

    /* renamed from: a, reason: collision with root package name */
    public final int f2425a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public C0900c(int i, C1554b c1554b) {
        this.f2425a = i;
        this.b = c1554b;
        this.c = new Semaphore(i);
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        kotlin.jvm.internal.k.e(keySetViewNewKeySet, "newKeySet(...)");
        this.d = keySetViewNewKeySet;
        this.e = new AtomicLong(0L);
        this.f = new AtomicLong(0L);
    }

    public static C0900c c(int i, Context context) throws Resources.NotFoundException {
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, P2.a.f1077r);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListA = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListA2 = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListA3 = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        e3.p pVarA = e3.p.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C1412a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new C0900c(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, pVarA, rect);
    }

    @Override // z7.InterfaceC2180a
    public void a(RunnableC2181b runnableC2181b) {
        if (((ConcurrentHashMap.KeySetView) this.d).remove(runnableC2181b)) {
            ((Semaphore) this.c).release();
        }
    }

    @Override // z7.InterfaceC2180a
    public void b() {
        for (RunnableC2181b runnableC2181b : D7.v.f1((ConcurrentHashMap.KeySetView) this.d)) {
            AbstractC2188i.d(runnableC2181b.f6974a);
            AbstractC2188i.d(runnableC2181b.b);
        }
    }

    @Override // z7.InterfaceC2180a
    public void d(RunnableC2181b runnableC2181b) {
        if (((Semaphore) this.c).tryAcquire()) {
            ((ConcurrentHashMap.KeySetView) this.d).add(runnableC2181b);
            AbstractC0291a.H(androidx.compose.foundation.b.p(((AtomicLong) this.e).incrementAndGet(), "mcp-request-"), new D6.i(runnableC2181b, 28));
            return;
        }
        C1554b c1554b = (C1554b) this.b;
        if (c1554b != null) {
            c1554b.a(McpServerMonitor$Outcome.i);
        }
        long jIncrementAndGet = ((AtomicLong) this.f).incrementAndGet();
        if (jIncrementAndGet % 100 == 1) {
            Log.w("BoundedAsyncRunner", "connection limit " + this.f2425a + " reached, closing new connection (total=" + jIncrementAndGet + ")");
        }
        AbstractC2188i.d(runnableC2181b.f6974a);
        AbstractC2188i.d(runnableC2181b.b);
    }

    public void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        ColorStateList colorStateList3 = (ColorStateList) this.c;
        e3.k kVar = new e3.k();
        e3.k kVar2 = new e3.k();
        e3.p pVar = (e3.p) this.f;
        kVar.setShapeAppearanceModel(pVar);
        kVar2.setShapeAppearanceModel(pVar);
        if (colorStateList == null) {
            colorStateList = (ColorStateList) this.d;
        }
        kVar.q(colorStateList);
        float f = this.f2425a;
        ColorStateList colorStateList4 = (ColorStateList) this.e;
        kVar.b.k = f;
        kVar.invalidateSelf();
        kVar.v(colorStateList4);
        if (colorStateList2 == null) {
            colorStateList2 = colorStateList3;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3.withAlpha(30), kVar, kVar2);
        Rect rect = (Rect) this.b;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    public C0900c(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, e3.p pVar, Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.b = rect;
        this.c = colorStateList2;
        this.d = colorStateList;
        this.e = colorStateList3;
        this.f2425a = i;
        this.f = pVar;
    }
}
