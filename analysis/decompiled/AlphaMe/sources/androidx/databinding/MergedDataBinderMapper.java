package androidx.databinding;

import R.b;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public class MergedDataBinderMapper extends b {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f3384a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3385b = new CopyOnWriteArrayList();

    public MergedDataBinderMapper() {
        new CopyOnWriteArrayList();
    }

    public final void a(b bVar) {
        if (this.f3384a.add(bVar.getClass())) {
            this.f3385b.add(bVar);
            Iterator it = bVar.collectDependencies().iterator();
            while (it.hasNext()) {
                a((b) it.next());
            }
        }
    }
}
