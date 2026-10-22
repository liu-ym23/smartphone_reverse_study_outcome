package s8;

import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AppFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24532a;

    public a(AppFilter... r10) {
        this.f24532a = Arrays.asList(r10);
    }

    @Override // com.bytedanceos.common.data.AppFilter
    public boolean filter(AppInfo r10) {
        Iterator r11 = this.f24532a.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (((AppFilter) r11.next()).filter(r10) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
