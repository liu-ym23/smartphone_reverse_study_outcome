package com.bytedance.android.ec.core.widget.flow;

import android.view.View;
import ei.b;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f46101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f46102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TagFlowLayout f46103c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TagFlowLayout r101 = this.f46103c;
        b r102 = this.f46101a;
        int r103 = this.f46102b;
        int r104 = TagFlowLayout.f46096m;
        r101.getClass();
        if (r102.f472758a == false) goto L5;
        r102.setChecked(false);
        ei.a r105 = r101.f46097i;
        r102.getTagView();
        r105.getClass();
        Set<Integer> r106 = r101.f46099k;
        HashSet r107 = (HashSet) r106;
        r107.remove(Integer.valueOf(r103));
    L16:
        TagFlowLayout.b r108 = this.f46103c.f46100l;
        if (r108 == null) goto L20;
        r108.a(this.f46102b);
        return;
    L20:
        return;
    L5:
        if (r101.f46098j != 1) goto L10;
        if (((HashSet) r101.f46099k).size() != 1) goto L10;
        Integer r109 = (Integer) ((HashSet) r101.f46099k).iterator().next();
        b r110 = (b) r101.getChildAt(r109.intValue());
        r109.intValue();
        r110.setChecked(false);
        ei.a r111 = r101.f46097i;
        r110.getTagView();
        r111.getClass();
        r101.a(r102);
        ((HashSet) r101.f46099k).remove(r109);
        Set<Integer> r112 = r101.f46099k;
        HashSet r113 = (HashSet) r112;
        r113.add(Integer.valueOf(r103));
    L10:
        if (r101.f46098j > 0) goto L12;
    L14:
        r101.a(r102);
        Set<Integer> r114 = r101.f46099k;
        HashSet r115 = (HashSet) r114;
        r115.add(Integer.valueOf(r103));
        goto L16
    L12:
        if (((HashSet) r101.f46099k).size() < r101.f46098j) goto L14;
        goto L14
    }

    public a(TagFlowLayout r100, b r101, int r102) {
        this.f46103c = r100;
        this.f46101a = r101;
        this.f46102b = r102;
    }
}
