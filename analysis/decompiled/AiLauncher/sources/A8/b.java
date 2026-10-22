package A8;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x8.j;

/* loaded from: classes4.dex */
public class b extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    public final A8.e f1251a;

    /* renamed from: b, reason: collision with root package name */
    public final List<d> f1252b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Layout> f1253c;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1255e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1256f;

    /* renamed from: i, reason: collision with root package name */
    public int f1259i;

    /* renamed from: j, reason: collision with root package name */
    public int f1260j;

    /* renamed from: k, reason: collision with root package name */
    public e f1261k;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f1257g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    public final Paint f1258h = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    public final TextPaint f1254d = new TextPaint();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1262a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1263b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f1264c;

        public a(int i10, int i11, d dVar) {
            this.f1262a = i10;
            this.f1263b = i11;
            this.f1264c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = b.this.f1261k;
            if (eVar != null) {
                b.this.f1253c.remove(this.f1262a);
                b.this.g(this.f1262a, this.f1263b, this.f1264c);
                eVar.invalidate();
            }
        }
    }

    /* renamed from: A8.b$b, reason: collision with other inner class name */
    public class C0004b extends c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f1266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0004b(Runnable runnable) {
            super(null);
            this.f1266a = runnable;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            this.f1266a.run();
        }
    }

    public static abstract class c implements Drawable.Callback {
        public c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f1268a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f1269b;

        public d(int i10, CharSequence charSequence) {
            this.f1268a = i10;
            this.f1269b = charSequence;
        }

        public String toString() {
            return "Cell{alignment=" + this.f1268a + ", text=" + ((Object) this.f1269b) + '}';
        }
    }

    public interface e {
        void invalidate();
    }

    public b(A8.e eVar, List<d> list, boolean z10, boolean z11) {
        this.f1251a = eVar;
        this.f1252b = list;
        this.f1253c = new ArrayList(list.size());
        this.f1255e = z10;
        this.f1256f = z11;
    }

    @SuppressLint({"SwitchIntDef"})
    public static Layout.Alignment d(int i10) {
        return i10 != 1 ? i10 != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015c  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r20, java.lang.CharSequence r21, int r22, int r23, float r24, int r25, int r26, int r27, android.graphics.Paint r28) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A8.b.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    public int e(int i10) {
        return (int) (((this.f1259i * 1.0f) / i10) + 0.5f);
    }

    public void f(e eVar) {
        this.f1261k = eVar;
    }

    public final void g(int i10, int i11, d dVar) {
        a aVar = new a(i10, i11, dVar);
        CharSequence charSequence = dVar.f1269b;
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(dVar.f1269b);
        StaticLayout staticLayout = new StaticLayout(spannableString, this.f1254d, i11, d(dVar.f1268a), 1.0f, 0.0f, false);
        j.a(spannableString, staticLayout);
        j(spannableString, aVar);
        this.f1253c.add(i10, staticLayout);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f1253c.size() > 0 && fontMetricsInt != null) {
            Iterator<Layout> it = this.f1253c.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i12) {
                    i12 = height;
                }
            }
            this.f1260j = i12;
            int i13 = -(i12 + (this.f1251a.j() * 2));
            fontMetricsInt.ascent = i13;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i13;
            fontMetricsInt.bottom = 0;
        }
        return this.f1259i;
    }

    public final void h() {
        this.f1254d.setFakeBoldText(this.f1255e);
        int size = this.f1252b.size();
        int iE = e(size) - (this.f1251a.j() * 2);
        this.f1253c.clear();
        int size2 = this.f1252b.size();
        for (int i10 = 0; i10 < size2; i10++) {
            g(i10, iE, this.f1252b.get(i10));
        }
    }

    public final boolean i(int i10) {
        return this.f1259i != i10;
    }

    public final void j(Spannable spannable, Runnable runnable) {
        io.noties.markwon.image.e[] eVarArr = (io.noties.markwon.image.e[]) spannable.getSpans(0, spannable.length(), io.noties.markwon.image.e.class);
        if (eVarArr == null || eVarArr.length <= 0) {
            return;
        }
        for (io.noties.markwon.image.e eVar : eVarArr) {
            io.noties.markwon.image.a aVarA = eVar.a();
            if (!aVarA.k()) {
                aVarA.n(new C0004b(runnable));
            }
        }
    }
}
