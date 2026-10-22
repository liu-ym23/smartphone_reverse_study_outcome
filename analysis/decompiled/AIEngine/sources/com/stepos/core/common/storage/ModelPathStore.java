package com.stepos.core.common.storage;

import a0.a;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelPathStore {
    private static final String MMKV_ID = "model_path_store";
    private static final String TAG = "ModelPathStore";
    private static volatile l<? super String, String> keyNormalizer;
    public static final ModelPathStore INSTANCE = new ModelPathStore();
    private static final d kv$delegate = b.b(new com.stepos.cpuset.b(18));
    private static final CopyOnWriteArrayList<OnPathChangedListener> listeners = new CopyOnWriteArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnPathChangedListener {
        void onPathChanged(String str, String str2);
    }

    private ModelPathStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    private final String norm(String str) {
        String strInvoke;
        l<? super String, String> lVar = keyNormalizer;
        return (lVar == null || (strInvoke = lVar.invoke(str)) == null) ? str : strInvoke;
    }

    public static /* synthetic */ void onDownloadComplete$default(ModelPathStore modelPathStore, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        modelPathStore.onDownloadComplete(str, str2, str3);
    }

    public final void clear(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        String strNorm = norm(algorithmId);
        getKv().p("path_" + strNorm);
        getKv().p("md5_" + strNorm);
        if (!g.b(strNorm, algorithmId)) {
            getKv().p("path_".concat(algorithmId));
            getKv().p("md5_".concat(algorithmId));
        }
        a.y("path cleared: ", strNorm, TAG);
    }

    public final l<String, String> getKeyNormalizer() {
        return keyNormalizer;
    }

    public final String getMd5(String algorithmId) {
        String strH;
        g.f(algorithmId, "algorithmId");
        String strNorm = norm(algorithmId);
        String strH2 = getKv().h("md5_" + strNorm, "");
        if (strH2 == null) {
            strH2 = "";
        }
        return strH2.length() > 0 ? strH2 : (g.b(strNorm, algorithmId) || (strH = getKv().h("md5_".concat(algorithmId), "")) == null) ? "" : strH;
    }

    public final String getPath(String algorithmId) {
        String strH;
        g.f(algorithmId, "algorithmId");
        String strNorm = norm(algorithmId);
        String strH2 = getKv().h("path_" + strNorm, "");
        if (strH2 == null) {
            strH2 = "";
        }
        return strH2.length() > 0 ? strH2 : (g.b(strNorm, algorithmId) || (strH = getKv().h("path_".concat(algorithmId), "")) == null) ? "" : strH;
    }

    public final void onDownloadComplete(String algorithmId, String path, String md5) {
        g.f(algorithmId, "algorithmId");
        g.f(path, "path");
        g.f(md5, "md5");
        String strNorm = norm(algorithmId);
        getKv().l("path_" + strNorm, path);
        getKv().l("md5_" + strNorm, md5);
        Log.i(TAG, "path updated: " + strNorm + " → " + path);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((OnPathChangedListener) it.next()).onPathChanged(strNorm, path);
        }
    }

    public final void registerListener(OnPathChangedListener listener) {
        g.f(listener, "listener");
        CopyOnWriteArrayList<OnPathChangedListener> copyOnWriteArrayList = listeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void setKeyNormalizer(l<? super String, String> lVar) {
        keyNormalizer = lVar;
    }

    public final void unregisterListener(OnPathChangedListener listener) {
        g.f(listener, "listener");
        listeners.remove(listener);
    }
}
