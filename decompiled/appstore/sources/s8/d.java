package s8;

import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements AppFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24537a;

    public d(List r10) {
        this.f24537a = r10;
    }

    @Override // com.bytedanceos.common.data.AppFilter
    public boolean filter(AppInfo r10) {
        Iterator r11 = this.f24537a.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (((AppFilter) r11.next()).filter(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
