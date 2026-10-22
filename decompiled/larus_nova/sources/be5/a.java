package be5;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends zd5.a {
    @Override // zd5.f
    public final List<q> x7() {
        return null;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r100 = new ArrayList();
        r100.add(FilterType.ALL);
        r100.add(FilterType.DOC);
        r100.add(FilterType.SHEET);
        return r100;
    }

    public a(boolean r100) {
        super(r100);
    }
}
