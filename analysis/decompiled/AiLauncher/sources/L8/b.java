package L8;

import K8.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import io.noties.markwon.ext.tables.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends a.b<Rb.a, e> {

    /* renamed from: a, reason: collision with root package name */
    public final int f4313a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4314b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4315c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4316d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4317e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4318f;

    /* renamed from: g, reason: collision with root package name */
    public LayoutInflater f4319g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<Rb.a, Table> f4320h = new HashMap(3);

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4321a;

        static {
            int[] iArr = new int[Table.Alignment.values().length];
            f4321a = iArr;
            try {
                iArr[Table.Alignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4321a[Table.Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4321a[Table.Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: L8.b$b, reason: collision with other inner class name */
    public interface InterfaceC0074b {
        InterfaceC0074b a(int i10, int i11);

        InterfaceC0074b b(int i10);

        b build();
    }

    public interface c {
        void a(InterfaceC0074b interfaceC0074b);
    }

    public static class d implements InterfaceC0074b {

        /* renamed from: a, reason: collision with root package name */
        public int f4322a;

        /* renamed from: b, reason: collision with root package name */
        public int f4323b;

        /* renamed from: c, reason: collision with root package name */
        public int f4324c;

        /* renamed from: d, reason: collision with root package name */
        public int f4325d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4326e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4327f = true;

        @Override // L8.b.InterfaceC0074b
        public InterfaceC0074b a(int i10, int i11) {
            this.f4322a = i10;
            this.f4323b = i11;
            return this;
        }

        @Override // L8.b.InterfaceC0074b
        public InterfaceC0074b b(int i10) {
            this.f4324c = i10;
            this.f4325d = 0;
            return this;
        }

        @Override // L8.b.InterfaceC0074b
        public b build() {
            int i10 = this.f4322a;
            if (i10 == 0) {
                throw new IllegalStateException("`tableLayoutResId` argument is required");
            }
            int i11 = this.f4324c;
            if (i11 != 0) {
                return new b(i10, this.f4323b, i11, this.f4325d, this.f4327f, this.f4326e);
            }
            throw new IllegalStateException("`textLayoutResId` argument is required");
        }
    }

    public static class e extends a.c {

        /* renamed from: a, reason: collision with root package name */
        public final TableLayout f4328a;

        public e(boolean z10, int i10, View view) {
            TableLayout tableLayout;
            super(view);
            setIsRecyclable(z10);
            if (i10 != 0) {
                tableLayout = (TableLayout) a(i10);
            } else {
                if (!(view instanceof TableLayout)) {
                    throw new IllegalStateException("Root view is not TableLayout. Please provide TableLayout ID explicitly");
                }
                tableLayout = (TableLayout) view;
            }
            this.f4328a = tableLayout;
        }
    }

    public b(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        this.f4313a = i10;
        this.f4314b = i11;
        this.f4315c = i12;
        this.f4316d = i13;
        this.f4317e = z10;
        this.f4318f = z11;
    }

    public static InterfaceC0074b g() {
        return new d();
    }

    public static b h(c cVar) {
        InterfaceC0074b interfaceC0074bG = g();
        cVar.a(interfaceC0074bG);
        return interfaceC0074bG.build();
    }

    public static void n(TableLayout tableLayout, int i10, int i11) {
        int childCount = tableLayout.getChildCount();
        if (childCount > i10) {
            tableLayout.removeViews(i10, childCount - i10);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i12);
            int childCount2 = tableRow.getChildCount();
            if (childCount2 > i11) {
                tableRow.removeViews(i11, childCount2 - i11);
            }
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public static int o(Table.Alignment alignment, boolean z10) {
        int i10 = a.f4321a[alignment.ordinal()];
        int i11 = 3;
        if (i10 != 1) {
            if (i10 == 2) {
                i11 = 1;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unknown table alignment: " + alignment);
                }
                i11 = 5;
            }
        }
        return z10 ? i11 | 16 : i11;
    }

    @Override // K8.a.b
    public void b() {
        this.f4320h.clear();
    }

    @Override // K8.a.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(u8.e eVar, e eVar2, Rb.a aVar) {
        int i10;
        Table tableA = this.f4320h.get(aVar);
        if (tableA == null) {
            tableA = Table.a(eVar, aVar);
            this.f4320h.put(aVar, tableA);
        }
        TableLayout tableLayout = eVar2.f4328a;
        if (tableA == null || tableA == tableLayout.getTag(this.f4313a)) {
            return;
        }
        tableLayout.setTag(this.f4313a, tableA);
        L8.c cVar = (L8.c) eVar.c(L8.c.class);
        if (cVar == null) {
            throw new IllegalStateException("No TableEntryPlugin is found. Make sure that it is _used_ whilst configuring Markwon instance");
        }
        L8.d dVarM = cVar.m();
        int i11 = 0;
        TextView textViewM = m(tableLayout, 0, 0);
        int i12 = dVarM.i(textViewM.getPaint());
        int iL = dVarM.l(textViewM.getPaint());
        int iJ = dVarM.j();
        l(tableLayout, i12, iL);
        List<Table.c> listB = tableA.b();
        int size = listB.size();
        int size2 = size > 0 ? listB.get(0).a().size() : 0;
        int i13 = 0;
        while (i13 < size) {
            Table.c cVar2 = listB.get(i13);
            TableRow tableRowK = k(tableLayout, i13);
            int i14 = i11;
            while (i14 < size2) {
                Table.a aVar2 = cVar2.a().get(i14);
                TextView textViewM2 = m(tableLayout, i13, i14);
                List<Table.c> list = listB;
                Table.c cVar3 = cVar2;
                textViewM2.setGravity(o(aVar2.a(), this.f4318f));
                textViewM2.getPaint().setFakeBoldText(cVar3.b());
                if (iJ > 0) {
                    textViewM2.setPadding(iJ, iJ, iJ, iJ);
                }
                l(textViewM2, i12, iL);
                eVar.g(textViewM2, aVar2.b());
                i14++;
                listB = list;
                cVar2 = cVar3;
            }
            List<Table.c> list2 = listB;
            if (cVar2.b()) {
                tableRowK.setBackgroundColor(dVarM.n());
            } else if (i13 % 2 == 1) {
                tableRowK.setBackgroundColor(dVarM.m());
            } else {
                i10 = 0;
                tableRowK.setBackgroundColor(dVarM.o(m(tableLayout, i13, 0).getPaint()));
                i13++;
                i11 = i10;
                listB = list2;
            }
            i10 = 0;
            i13++;
            i11 = i10;
            listB = list2;
        }
        n(tableLayout, size, size2);
    }

    @Override // K8.a.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new e(this.f4317e, this.f4314b, layoutInflater.inflate(this.f4313a, viewGroup, false));
    }

    public final LayoutInflater j(Context context) {
        if (this.f4319g == null) {
            this.f4319g = LayoutInflater.from(context);
        }
        return this.f4319g;
    }

    public final TableRow k(TableLayout tableLayout, int i10) {
        int childCount = tableLayout.getChildCount();
        if (i10 >= childCount) {
            Context context = tableLayout.getContext();
            for (int i11 = (i10 - childCount) + 1; i11 > 0; i11--) {
                tableLayout.addView(new TableRow(context));
            }
        }
        return (TableRow) tableLayout.getChildAt(i10);
    }

    public final void l(View view, int i10, int i11) {
        if (i10 == 0) {
            view.setBackground(null);
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof L8.a) {
            ((L8.a) background).a(i10, i11);
            return;
        }
        L8.a aVar = new L8.a();
        aVar.a(i10, i11);
        view.setBackground(aVar);
    }

    public final TextView m(TableLayout tableLayout, int i10, int i11) {
        TextView textView;
        TableRow tableRowK = k(tableLayout, i10);
        int childCount = tableRowK.getChildCount();
        if (i11 >= childCount) {
            LayoutInflater layoutInflaterJ = j(tableLayout.getContext());
            boolean z10 = false;
            for (int i12 = (i11 - childCount) + 1; i12 > 0; i12--) {
                View viewInflate = layoutInflaterJ.inflate(this.f4315c, (ViewGroup) tableRowK, false);
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                if (layoutParams.height != -1) {
                    layoutParams.height = -1;
                }
                if (z10) {
                    int i13 = this.f4316d;
                    textView = i13 == 0 ? (TextView) viewInflate : (TextView) viewInflate.findViewById(i13);
                } else {
                    int i14 = this.f4316d;
                    if (i14 != 0) {
                        TextView textView2 = (TextView) viewInflate.findViewById(i14);
                        if (textView2 == null) {
                            Resources resources = tableLayout.getContext().getResources();
                            throw new NullPointerException(String.format("textLayoutResId(R.layout.%s) has no TextView found by id(R.id.%s): %s", resources.getResourceName(this.f4315c), resources.getResourceName(this.f4316d), viewInflate));
                        }
                        textView = textView2;
                    } else {
                        if (!(viewInflate instanceof TextView)) {
                            throw new IllegalStateException(String.format("textLayoutResId(R.layout.%s) has other than TextView root view. Specify TextView ID explicitly", tableLayout.getContext().getResources().getResourceName(this.f4315c)));
                        }
                        textView = (TextView) viewInflate;
                    }
                    z10 = true;
                }
                textView.setSpannableFactory(N8.d.a());
                tableRowK.addView(textView);
            }
        }
        View childAt = tableRowK.getChildAt(i11);
        int i15 = this.f4316d;
        return i15 == 0 ? (TextView) childAt : (TextView) childAt.findViewById(i15);
    }
}
