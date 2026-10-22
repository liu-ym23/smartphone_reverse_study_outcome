package za;

import com.obric.appstore.network.entity.TemplateResp;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.ui.adapter.ItemType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26319a;

    public f() {
        this.f26319a = "";
    }

    public abstract ItemType a();

    public abstract void b(ElementEntity r10);

    public void c(TemplateResp r10) {
        q.g(r10, "templateEntity");
        this.f26319a = r10.getTemplate();
        List<ElementEntity<?>> r11 = r10.getData();
        if (r11 == null) goto L8;
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        b((ElementEntity) r12.next());
        goto L6
    L10:
        return;
    }
}
