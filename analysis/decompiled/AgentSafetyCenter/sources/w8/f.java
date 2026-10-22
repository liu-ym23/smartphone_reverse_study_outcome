package w8;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jb.i;
import kb.l;
import kb.m;
import kb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f15381a;

    @Override // w8.e
    public final h a(List list) {
        Object objL;
        Bundle bundleCall;
        String simpleName;
        ArrayList arrayList = new ArrayList(m.m0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k0.a.A((String) it.next(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listL0 = l.L0(l.N0(arrayList2));
        if (listL0.isEmpty()) {
            Log.i("NotePaperRepo", "[note-ipc] revoke skip: empty note_id");
            return new h("empty note_id", false);
        }
        Uri uri = d.f15379a;
        Log.i("NotePaperRepo", "[note-ipc] revoke start uri=" + uri + " method=agent_revoke note_id(" + listL0.size() + ")=" + listL0);
        try {
            Bundle bundle = new Bundle();
            bundle.putStringArray("note_id", (String[]) listL0.toArray(new String[0]));
            bundleCall = this.f15381a.call(uri, "agent_revoke", (String) l.w0(listL0), bundle);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (bundleCall == null) {
            Log.w("NotePaperRepo", "[note-ipc] revoke failed: provider null response");
            return new h("provider null", false);
        }
        boolean z10 = bundleCall.getBoolean("result_success", false);
        Set<String> setKeySet = bundleCall.keySet();
        Log.i("NotePaperRepo", "[note-ipc] revoke response success=" + z10 + " bundleKeys=[" + (setKeySet != null ? l.B0(setKeySet, ",", null, null, null, 62) : "") + "]");
        Set<String> setKeySet2 = bundleCall.keySet();
        if (setKeySet2 == null) {
            setKeySet2 = u.f7406c;
        }
        Iterator<String> it2 = setKeySet2.iterator();
        while (true) {
            simpleName = null;
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            Object obj2 = bundleCall.get(next);
            if (obj2 != null) {
                simpleName = obj2.getClass().getSimpleName();
            }
            Log.i("NotePaperRepo", "[note-ipc] revoke bundle[" + next + "]=" + obj2 + " (" + simpleName + ")");
        }
        if (!z10) {
            simpleName = "result_success=false";
        }
        objL = new h(simpleName, z10);
        Throwable thB = i.b(objL);
        if (thB != null) {
            Log.w("NotePaperRepo", "[note-ipc] revoke exception ids=" + listL0, thB);
            String message = thB.getMessage();
            if (message == null) {
                message = thB.getClass().getSimpleName();
            }
            objL = new h(message, false);
        }
        return (h) objL;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030c  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // w8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w8.g b(java.util.List r22) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.f.b(java.util.List):w8.g");
    }
}
