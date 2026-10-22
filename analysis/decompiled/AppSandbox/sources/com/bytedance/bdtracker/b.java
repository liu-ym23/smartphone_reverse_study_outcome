package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    public static g a = new a();
    public static g b = new C0000b();
    public static g c = new c();
    public static g d = new d();
    public static g e = new e();

    public static class a implements g {
        @Override // com.bytedance.bdtracker.b.g
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.isBavEnabled();
        }
    }

    /* renamed from: com.bytedance.bdtracker.b$b, reason: collision with other inner class name */
    public static class C0000b implements g {
        @Override // com.bytedance.bdtracker.b.g
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.isH5BridgeEnable();
        }
    }

    public static class c implements g {
        @Override // com.bytedance.bdtracker.b.g
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.isH5CollectEnable();
        }
    }

    public static class d implements g {
        @Override // com.bytedance.bdtracker.b.g
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.getInitConfig() != null && dVar.getInitConfig().isHandleLifeCycle();
        }
    }

    public static class e implements g {
        @Override // com.bytedance.bdtracker.b.g
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return !(dVar.getInitConfig() != null && dVar.getInitConfig().isPageMetaAnnotationEnable());
        }
    }

    public interface f {
        void a(com.bytedance.bdtracker.d dVar);
    }

    public interface g {
        boolean a(com.bytedance.bdtracker.d dVar);
    }

    public interface h {
        e4 a();
    }

    public static List<com.bytedance.bdtracker.d> a(g gVar) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.K) {
            if (gVar.a(dVar)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public static IAppLogInstance b(String str) {
        com.bytedance.bdtracker.d dVarA = a(str);
        return dVarA != null ? dVarA : AppLog.getInstance();
    }

    public static boolean b(g gVar) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.K.iterator();
        while (it.hasNext()) {
            if (gVar.a(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.K.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().m)) {
                return true;
            }
        }
        return false;
    }

    public static com.bytedance.bdtracker.d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.K) {
            if (str.equals(dVar.m)) {
                return dVar;
            }
        }
        return null;
    }

    public static String a(IAppLogInstance iAppLogInstance, String str) {
        if (AppLog.getInstance() == iAppLogInstance) {
            return str;
        }
        return str + "_" + iAppLogInstance.getAppId();
    }

    public static void a(f fVar) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.K.iterator();
        while (it.hasNext()) {
            fVar.a(it.next());
        }
    }

    public static void a(String[] strArr) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.K.iterator();
        while (it.hasNext()) {
            it.next().receive((String[]) strArr.clone());
        }
    }

    public static void a(h hVar, g gVar) {
        e4 e4VarA = null;
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.K) {
            if (gVar.a(dVar)) {
                if (e4VarA == null) {
                    e4VarA = hVar.a();
                }
                dVar.receive(e4VarA.m321clone());
            }
        }
    }

    public static void a(e4 e4Var, g gVar) {
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.K) {
            if (gVar.a(dVar)) {
                dVar.receive(e4Var.m321clone());
            }
        }
    }
}
