package b86;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f18182a;

    @Override // b86.d
    public final int getItemsCount() {
        return this.f18182a.size();
    }

    public a(List<String> r100) {
        this.f18182a = r100;
    }

    @Override // b86.d
    public final String getItem(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return "";
    L4:
        if (r100 >= this.f18182a.size()) goto L6;
        return (String) ListProtector.get(this.f18182a, r100);
    }
}
