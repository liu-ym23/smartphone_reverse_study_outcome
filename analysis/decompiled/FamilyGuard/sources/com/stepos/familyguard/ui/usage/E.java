package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.ui.usage.AbstractC0599h;
import com.stepos.familyguard.ui.usage.z;
import java.util.Comparator;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class E extends AbstractC0599h<z.c> {

    /* renamed from: i, reason: collision with root package name */
    private final D2.r<String, Drawable> f14903i;

    public E(Context context, D2.r<String, Drawable> rVar) {
        super(context);
        this.f14903i = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(AbstractC0599h.a aVar, int i5, z.c cVar, View view) {
        if (t() != null) {
            aVar.a(i5, cVar);
        }
    }

    public static /* synthetic */ int z(z.c cVar, z.c cVar2) {
        String strE = TextUtils.isEmpty(cVar.f15175c) ? null : Z0.b.e(cVar.f15175c, BuildConfig.FLAVOR);
        String strE2 = TextUtils.isEmpty(cVar2.f15175c) ? null : Z0.b.e(cVar2.f15175c, BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(strE)) {
            return 1;
        }
        if (TextUtils.isEmpty(strE2)) {
            return -1;
        }
        return strE.compareTo(strE2);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0599h
    public void l() {
        D2.r<String, Drawable> rVar = this.f14903i;
        if (rVar != null) {
            rVar.a();
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0599h
    protected Comparator<z.c> n() {
        return new Comparator() { // from class: w2.D0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return com.stepos.familyguard.ui.usage.E.z((z.c) obj, (z.c) obj2);
            }
        };
    }

    @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i5) throws Resources.NotFoundException {
        final z.c cVarQ;
        super.onBindViewHolder(viewHolder, i5);
        if (!(viewHolder instanceof C) || (cVarQ = q(i5)) == null) {
            return;
        }
        ((C) viewHolder).c(this.f15050c, cVarQ, this.f15054g);
        final AbstractC0599h.a<z.c> aVarT = t();
        if (aVarT != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.E0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23546a.A(aVarT, i5, cVarQ, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new C(p(viewGroup, i5), this.f14903i);
    }
}
