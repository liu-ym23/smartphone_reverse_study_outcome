package s8;

import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class c implements AppFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppFilter f24536a;

    public c(AppFilter r10) {
        this.f24536a = r10;
    }

    @Override // com.bytedanceos.common.data.AppFilter
    public boolean filter(AppInfo r10) {
        return !this.f24536a.filter(r10);
    }
}
