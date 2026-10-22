package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.C0607p;
import com.stepos.familyguard.ui.usage.z;
import java.util.Comparator;
import org.libpag.BuildConfig;

/* renamed from: com.stepos.familyguard.ui.usage.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0607p extends AbstractC0598g<z.a> {
    public C0607p(Context context) {
        super(context);
    }

    public static /* synthetic */ int A(z.a aVar, z.a aVar2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(int i5, z.a aVar, View view) {
        this.f15042j.a(i5, aVar);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g, x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i5) throws Resources.NotFoundException {
        final z.a aVarS;
        super.onBindViewHolder(viewHolder, i5);
        if (!(viewHolder instanceof C0606o) || (aVarS = s(i5)) == null) {
            return;
        }
        ((C0606o) viewHolder).a(this.f15040h, aVarS);
        if (this.f15042j != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23656a.C(i5, aVarS, view);
                }
            });
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return i5 == 2 ? new C0606o(q(viewGroup, i5)) : super.onCreateViewHolder(viewGroup, i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g
    protected Comparator<z.a> p() {
        return new Comparator() { // from class: w2.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0607p.A((z.a) obj, (z.a) obj2);
            }
        };
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0598g
    protected View q(ViewGroup viewGroup, int i5) {
        return i5 == 2 ? LayoutInflater.from(this.f15040h).inflate(R.layout.us_category_limit_manager_item, viewGroup, false) : super.q(viewGroup, i5);
    }
}
