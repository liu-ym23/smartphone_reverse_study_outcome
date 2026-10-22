package ad5;

import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.pinview.PinFragment;
import com.bytedance.ee.bear.list.recent.RecentDocumentFragment;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements f {
    public d() {
    }

    @Override // ad5.f
    public final List<e> a(boolean r100) {
        ArrayList r101 = new ArrayList();
        r101.add(new e(HomeTabEnum.RECENT.f228344id, R.string.Doc_List_Recent, RecentDocumentFragment.class.getName()));
        r101.add(new e(HomeTabEnum.PIN.f228344id, R.string.Doc_List_Quick_Access, PinFragment.class.getName()));
        return r101;
    }
}
