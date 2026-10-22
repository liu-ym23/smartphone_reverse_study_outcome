package com.stepos.stepclaw.provider.handlers;

import a.a;
import android.content.Context;
import c5.k;
import c5.q;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.d;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
import w5.e;
import w5.f;
import w5.g;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/MetaJsonMerge;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "mergeAllTopLevelJsonFiles", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "rootfs", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "relativeDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MetaJsonMerge {
    public static final MetaJsonMerge INSTANCE = new MetaJsonMerge();

    private MetaJsonMerge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mergeAllTopLevelJsonFiles$lambda$0(File file) {
        if (!file.isFile()) {
            return false;
        }
        String name = file.getName();
        p.d(name, "getName(...)");
        return u.V0(name, ".json", true);
    }

    public final JSONObject mergeAllTopLevelJsonFiles(Context context, IRootfsAccess rootfs, String relativeDir) {
        File[] fileArrListFiles;
        JSONObject jSONObject;
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(relativeDir, "relativeDir");
        JSONObject jSONObject2 = new JSONObject();
        File file = new File(context.getFilesDir() + "/" + rootfs.getRootfsSubdir() + "/" + relativeDir);
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            g gVar = new g(fileArrListFiles.length == 0 ? e.f6207a : new k(0, fileArrListFiles), new d(15), 0);
            Comparator comparator = new Comparator() { // from class: com.stepos.stepclaw.provider.handlers.MetaJsonMerge$mergeAllTopLevelJsonFiles$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    String name = ((File) t8).getName();
                    p.d(name, "getName(...)");
                    Locale ROOT = Locale.ROOT;
                    p.d(ROOT, "ROOT");
                    String lowerCase = name.toLowerCase(ROOT);
                    p.d(lowerCase, "toLowerCase(...)");
                    String name2 = ((File) t9).getName();
                    p.d(name2, "getName(...)");
                    p.d(ROOT, "ROOT");
                    String lowerCase2 = name2.toLowerCase(ROOT);
                    p.d(lowerCase2, "toLowerCase(...)");
                    return a.l(lowerCase, lowerCase2);
                }
            };
            ArrayList arrayList = new ArrayList();
            f fVar = new f(gVar);
            while (fVar.hasNext()) {
                arrayList.add(fVar.next());
            }
            q.o0(arrayList, comparator);
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                String rootfsFile = rootfs.readRootfsFile(relativeDir + "/" + ((File) obj).getName());
                if (rootfsFile != null && (jSONObject = InstallVersionResolver.INSTANCE.parseJSONObject(rootfsFile)) != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                }
            }
        }
        return jSONObject2;
    }
}
