package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractC0599h;
import com.stepos.familyguard.ui.usage.C0608q;
import com.stepos.familyguard.ui.usage.z;
import java.util.Comparator;
import org.libpag.BuildConfig;

/* renamed from: com.stepos.familyguard.ui.usage.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0608q extends AbstractC0599h<z.a> {
    public C0608q(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(AbstractC0599h.a aVar, int i5, z.a aVar2, View view) {
        if (t() != null) {
            aVar.a(i5, aVar2);
        }
    }

    public static /* synthetic */ int y(z.a aVar, z.a aVar2) {
        String strE = TextUtils.isEmpty(aVar.f15172c) ? null : Z0.b.e(aVar.f15172c, BuildConfig.FLAVOR);
        String strE2 = TextUtils.isEmpty(aVar2.f15172c) ? null : Z0.b.e(aVar2.f15172c, BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(strE)) {
            return 1;
        }
        if (TextUtils.isEmpty(strE2)) {
            return -1;
        }
        return strE.compareTo(strE2);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0599h
    protected Comparator<z.a> n() {
        return new Comparator() { // from class: w2.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0608q.y((z.a) obj, (z.a) obj2);
            }
        };
    }

    @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i5) throws Resources.NotFoundException {
        final z.a aVarQ;
        super.onBindViewHolder(viewHolder, i5);
        if (!(viewHolder instanceof C0606o) || (aVarQ = q(i5)) == null) {
            return;
        }
        ((C0606o) viewHolder).b(this.f15050c, aVarQ, this.f15054g);
        final AbstractC0599h.a<z.a> aVarT = t();
        if (aVarT != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23664a.A(aVarT, i5, aVarQ, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new C0606o(p(viewGroup, i5));
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0599h
    protected View p(ViewGroup viewGroup, int i5) {
        return i5 == 0 ? LayoutInflater.from(this.f15050c).inflate(R.layout.us_category_limit_manager_item, viewGroup, false) : super.p(viewGroup, i5);
    }
}
