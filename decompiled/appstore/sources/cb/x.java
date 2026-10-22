package cb;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntitySupplier f6113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f6115c;

    public x(EntitySupplier r10) {
        this.f6113a = r10;
    }

    public final void a() {
        List r10 = this.f6115c;
        if (r10 == null) goto L8;
        LinkedHashMap r11 = new LinkedHashMap(bg.h.d(j0.e(kotlin.collections.u.r(r10, 10)), 16));
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        AppEntity r14 = (AppEntity) r13;
        r11.put(new EntityIdData(r14.getId(), r14.getType(), r14.getLastModifiedTime()), r13);
    L9:
        this.f6114b = r11;
        this.f6115c = null;
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List getWholeEntities(List r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "idList");
        ArrayList r12 = new ArrayList();
        if (this.f6115c == null) goto L6;
        a();
    L6:
        if (this.f6114b != null) goto L8;
        return r12;
    L8:
        Iterator r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L17;
        String r14 = (String) r13.next();
        Map r15 = this.f6114b;
        if (r15 == null) goto L10;
        AppEntity r16 = (AppEntity) r15.get(new EntityIdData(r14, r11, 0));
        if (r16 == null) goto L10;
        r12.add(r16);
        goto L10
    L17:
        return r12;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List provideSampleEntities() {
        EntitySupplier r10 = this.f6113a;
        if (r10 == null) goto L5;
        List<AppEntity> r11 = r10.provideAllEntities();
    L6:
        this.f6115c = r11;
        if (r11 == null) goto L13;
        ArrayList r12 = new ArrayList(kotlin.collections.u.r(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        AppEntity r14 = (AppEntity) r13.next();
        r12.add(new EntityIdData(r14.getId(), r14.getType(), r14.getLastModifiedTime()));
        goto L10
    L15:
        return r12;
    L13:
        return kotlin.collections.t.i();
    L5:
        r11 = null;
        goto L6
    }
}
