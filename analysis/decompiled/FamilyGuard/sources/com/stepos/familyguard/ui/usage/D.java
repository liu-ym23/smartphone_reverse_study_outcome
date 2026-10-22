package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.z;
import java.util.Comparator;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class D extends AbstractC0598g<z.c> {

    /* renamed from: o, reason: collision with root package name */
    protected D2.r<String, Drawable> f14872o;

    public D(Context context, D2.r<String, Drawable> rVar) {
        super(context);
        this.f14872o = rVar;
    }

    public static /* synthetic */ int A(z.c cVar, z.c cVar2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(int i5, z.c cVar, View view) {
        this.f15042j.a(i5, cVar);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g
    public void n() {
        D2.r<String, Drawable> rVar = this.f14872o;
        if (rVar != null) {
            rVar.a();
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g, x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i5) throws Resources.NotFoundException {
        final z.c cVarS;
        super.onBindViewHolder(viewHolder, i5);
        if (!(viewHolder instanceof C) || (cVarS = s(i5)) == null) {
            return;
        }
        ((C) viewHolder).c(this.f15040h, cVarS, null);
        if (this.f15042j != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.B0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23529a.C(i5, cVarS, view);
                }
            });
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return i5 == 2 ? new C(q(viewGroup, i5), this.f14872o) : super.onCreateViewHolder(viewGroup, i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g
    protected Comparator<z.c> p() {
        return new Comparator() { // from class: w2.A0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return com.stepos.familyguard.ui.usage.D.A((z.c) obj, (z.c) obj2);
            }
        };
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g
    protected View q(ViewGroup viewGroup, int i5) {
        return i5 == 2 ? LayoutInflater.from(this.f15040h).inflate(R.layout.us_package_limit_manager_item, viewGroup, false) : super.q(viewGroup, i5);
    }
}
