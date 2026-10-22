package w1;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import f1.AbstractC0557a;

/* renamed from: w1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0972c extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Context f15809i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextPaint f15810j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AbstractC0557a f15811k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0973d f15812l;

    public C0972c(C0973d c0973d, Context context, TextPaint textPaint, AbstractC0557a abstractC0557a) {
        this.f15812l = c0973d;
        this.f15809i = context;
        this.f15810j = textPaint;
        this.f15811k = abstractC0557a;
    }

    @Override // f1.AbstractC0557a
    public final void O(int i4) {
        this.f15811k.O(i4);
    }

    @Override // f1.AbstractC0557a
    public final void P(Typeface typeface, boolean z4) {
        this.f15812l.f(this.f15809i, this.f15810j, typeface);
        this.f15811k.P(typeface, z4);
    }
}
