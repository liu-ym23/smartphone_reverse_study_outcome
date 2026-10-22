package u8;

import android.content.ContentResolver;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jb.v;
import kc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14193c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.f f14194f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List f14195g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(stepos.support.v7.app.f fVar, List list, nb.c cVar, int i) {
        super(2, cVar);
        this.f14193c = i;
        this.f14194f = fVar;
        this.f14195g = list;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14193c) {
            case 0:
                return new c(this.f14194f, this.f14195g, cVar, 0);
            default:
                return new c(this.f14194f, this.f14195g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t tVar = (t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f14193c) {
        }
        return ((c) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Object objL;
        Bundle bundleCall;
        Object objL2;
        Bundle bundleCall2;
        int i = this.f14193c;
        List list = this.f14195g;
        stepos.support.v7.app.f fVar = this.f14194f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                sa.c cVar = (sa.c) fVar.f12315f;
                ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    k0.a.A((String) it.next(), arrayList);
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (((String) obj2).length() > 0) {
                        arrayList2.add(obj2);
                    }
                }
                boolean zIsEmpty = arrayList2.isEmpty();
                kb.s sVar = kb.s.f7404c;
                if (zIsEmpty) {
                    return new v8.c("empty truth_id_list", sVar, false);
                }
                try {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("truth_id_list", new ArrayList<>(arrayList2));
                    bundleCall = ((ContentResolver) cVar.f12170f).call(v8.b.f14856a, "query_backup_contact_by_truth_id", (String) kb.l.w0(arrayList2), bundle);
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                if (bundleCall == null) {
                    return new v8.c("provider null", sVar, false);
                }
                objL = new v8.c(bundleCall.getString("error_message"), t0.a.g(bundleCall.getString("backup_contacts_json")), bundleCall.getBoolean("success", false));
                Throwable thB = jb.i.b(objL);
                if (thB != null) {
                    String message = thB.getMessage();
                    if (message == null) {
                        message = thB.getClass().getSimpleName();
                    }
                    objL = new v8.c(message, sVar, false);
                }
                return (v8.c) objL;
            default:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                sa.c cVar2 = (sa.c) fVar.f12315f;
                ArrayList arrayList3 = new ArrayList(kb.m.m0(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    k0.a.A((String) it2.next(), arrayList3);
                }
                ArrayList arrayList4 = new ArrayList();
                int size2 = arrayList3.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj3 = arrayList3.get(i10);
                    i10++;
                    if (((String) obj3).length() > 0) {
                        arrayList4.add(obj3);
                    }
                }
                if (arrayList4.isEmpty()) {
                    return new v8.d("empty truth_id_list", 0, 0, false);
                }
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putStringArrayList("truth_id_list", new ArrayList<>(arrayList4));
                    bundleCall2 = ((ContentResolver) cVar2.f12170f).call(v8.b.f14856a, "restore_contact_by_truth_id", (String) kb.l.w0(arrayList4), bundle2);
                } catch (Throwable th2) {
                    objL2 = id.c.l(th2);
                }
                if (bundleCall2 == null) {
                    return new v8.d("provider null", 0, arrayList4.size(), false);
                }
                objL2 = new v8.d(bundleCall2.getString("error_message"), bundleCall2.getInt("restored_count", 0), bundleCall2.getInt("failed_count", 0), bundleCall2.getBoolean("success", false));
                Throwable thB2 = jb.i.b(objL2);
                if (thB2 != null) {
                    int size3 = arrayList4.size();
                    String message2 = thB2.getMessage();
                    if (message2 == null) {
                        message2 = thB2.getClass().getSimpleName();
                    }
                    objL2 = new v8.d(message2, 0, size3, false);
                }
                return (v8.d) objL2;
        }
    }
}
