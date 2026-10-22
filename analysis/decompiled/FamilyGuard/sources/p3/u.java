package p3;

import W3.C0396g;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.dialog.StepOSCheckableLayout;
import java.util.List;
import l3.C0846d;

/* loaded from: classes.dex */
public final class u extends RecyclerView.Adapter<a> {

    /* renamed from: a, reason: collision with root package name */
    private final DialogInterface f19589a;

    /* renamed from: b, reason: collision with root package name */
    private final int f19590b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Pair<String, String>> f19591c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f19592d;

    /* renamed from: e, reason: collision with root package name */
    private int f19593e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean[] f19594f;

    /* renamed from: g, reason: collision with root package name */
    private final DialogInterface.OnClickListener f19595g;

    /* renamed from: h, reason: collision with root package name */
    private final DialogInterface.OnMultiChoiceClickListener f19596h;

    /* renamed from: i, reason: collision with root package name */
    private final LayoutInflater f19597i;

    /* renamed from: j, reason: collision with root package name */
    private final int f19598j;

    /* renamed from: k, reason: collision with root package name */
    private final int f19599k;

    /* renamed from: l, reason: collision with root package name */
    private final int f19600l;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final StepOSCheckableLayout f19601a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f19602b;

        /* renamed from: c, reason: collision with root package name */
        private final TextView f19603c;

        /* renamed from: d, reason: collision with root package name */
        private final CheckBox f19604d;

        /* renamed from: e, reason: collision with root package name */
        private final ImageView f19605e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ u f19606f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, StepOSCheckableLayout stepOSCheckableLayout) {
            super(stepOSCheckableLayout);
            j4.k.g(stepOSCheckableLayout, "itemView");
            this.f19606f = uVar;
            this.f19601a = stepOSCheckableLayout;
            View viewFindViewById = stepOSCheckableLayout.findViewById(l3.h.f18442q);
            j4.k.f(viewFindViewById, "findViewById(...)");
            this.f19602b = (TextView) viewFindViewById;
            View viewFindViewById2 = stepOSCheckableLayout.findViewById(l3.h.f18441p);
            j4.k.f(viewFindViewById2, "findViewById(...)");
            this.f19603c = (TextView) viewFindViewById2;
            this.f19604d = (CheckBox) stepOSCheckableLayout.findViewById(l3.h.f18439n);
            this.f19605e = (ImageView) stepOSCheckableLayout.findViewById(l3.h.f18440o);
        }

        public final void a(boolean z5) {
            TextView textView = this.f19602b;
            u uVar = this.f19606f;
            textView.setTextColor(z5 ? uVar.f19600l : uVar.f19598j);
            TextView textView2 = this.f19603c;
            u uVar2 = this.f19606f;
            textView2.setTextColor(z5 ? uVar2.f19600l : uVar2.f19599k);
        }

        public final void b(boolean z5) {
            this.f19601a.setChecked(z5);
            CheckBox checkBox = this.f19604d;
            if (checkBox != null) {
                checkBox.setChecked(z5);
            }
            ImageView imageView = this.f19605e;
            if (imageView != null) {
                imageView.setVisibility(z5 ? 0 : 4);
            }
            this.f19601a.setSelected(z5);
        }

        public final TextView c() {
            return this.f19603c;
        }

        public final TextView d() {
            return this.f19602b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private u(DialogInterface dialogInterface, Context context, int i5, List<? extends Pair<String, String>> list, boolean z5, int i6, boolean[] zArr, DialogInterface.OnClickListener onClickListener, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.f19589a = dialogInterface;
        this.f19590b = i5;
        this.f19591c = list;
        this.f19592d = z5;
        this.f19593e = i6;
        this.f19594f = zArr;
        this.f19595g = onClickListener;
        this.f19596h = onMultiChoiceClickListener;
        this.f19597i = LayoutInflater.from(context);
        this.f19598j = androidx.core.content.a.c(context, C0846d.f18305l);
        this.f19599k = androidx.core.content.a.c(context, C0846d.f18304k);
        this.f19600l = androidx.core.content.a.c(context, C0846d.f18306m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(a aVar, u uVar, View view) {
        Boolean boolP;
        int bindingAdapterPosition = aVar.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        if (!uVar.f19592d) {
            uVar.f19593e = bindingAdapterPosition;
            DialogInterface.OnClickListener onClickListener = uVar.f19595g;
            if (onClickListener != null) {
                onClickListener.onClick(uVar.f19589a, bindingAdapterPosition);
            }
            uVar.notifyDataSetChanged();
            return;
        }
        boolean[] zArr = uVar.f19594f;
        boolean z5 = !((zArr == null || (boolP = C0396g.p(zArr, bindingAdapterPosition)) == null) ? false : boolP.booleanValue());
        boolean[] zArr2 = uVar.f19594f;
        if (zArr2 != null) {
            zArr2[bindingAdapterPosition] = z5;
        }
        aVar.b(z5);
        aVar.a(z5);
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = uVar.f19596h;
        if (onMultiChoiceClickListener != null) {
            onMultiChoiceClickListener.onClick(uVar.f19589a, bindingAdapterPosition, z5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f19591c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, int i5) {
        j4.k.g(aVar, "holder");
        Pair<String, String> pair = this.f19591c.get(i5);
        aVar.d().setText((CharSequence) pair.first);
        aVar.c().setText((CharSequence) pair.second);
        boolean zB = false;
        if (this.f19592d) {
            boolean[] zArr = this.f19594f;
            if (zArr != null) {
                zB = j4.k.b(C0396g.p(zArr, i5), Boolean.TRUE);
            }
        } else if (i5 == this.f19593e) {
            zB = true;
        }
        aVar.b(zB);
        aVar.a(zB);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: p3.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.q(aVar, this, view);
            }
        });
        aVar.itemView.setContentDescription(pair.first + " " + pair.second);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        j4.k.g(viewGroup, "parent");
        View viewInflate = this.f19597i.inflate(this.f19590b, viewGroup, false);
        j4.k.e(viewInflate, "null cannot be cast to non-null type com.stepos.widget.dialog.StepOSCheckableLayout");
        return new a(this, (StepOSCheckableLayout) viewInflate);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(DialogInterface dialogInterface, Context context, int i5, List<? extends Pair<String, String>> list, int i6, DialogInterface.OnClickListener onClickListener) {
        this(dialogInterface, context, i5, list, false, i6, null, onClickListener, null);
        j4.k.g(dialogInterface, "dialog");
        j4.k.g(context, "context");
        j4.k.g(list, "entries");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(DialogInterface dialogInterface, Context context, int i5, List<? extends Pair<String, String>> list, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this(dialogInterface, context, i5, list, true, -1, zArr, null, onMultiChoiceClickListener);
        j4.k.g(dialogInterface, "dialog");
        j4.k.g(context, "context");
        j4.k.g(list, "entries");
        j4.k.g(zArr, "checkedItems");
    }
}
