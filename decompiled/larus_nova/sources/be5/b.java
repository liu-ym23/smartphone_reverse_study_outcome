package be5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends zd5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18741d;

    @Override // zd5.f
    public final List<q> x7() {
        return null;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r100 = new ArrayList();
        if (this.f18740c == false) goto L5;
        r100.add(FilterType.ALL);
        r100.add(FilterType.DOC);
        r100.add(FilterType.SHEET);
        r100.add(FilterType.MINDNOTE);
    L5:
        boolean r101 = true;
        if (c.a.f206237a.i("ccm.spacekit.template.bitable.enable", true) == true) goto L8;
    L10:
        r101 = false;
    L11:
        tt5.a.h("TemplateFilterModelFactory", "filterBitableEnable = " + r101);
        if (r101 == false) goto L14;
        r100.add(FilterType.BITABLE);
    L14:
        return r100;
    L8:
        if (this.f18741d == false) goto L10;
        goto L10
    }

    public b(boolean r100, BenefitStore r101) {
        super(r100);
        this.f18740c = true;
        this.f18741d = true;
        this.f18740c = r101.hasBenefit("ccm_create_doc");
        this.f18741d = r101.hasBenefit("ccm_create_base");
    }
}
