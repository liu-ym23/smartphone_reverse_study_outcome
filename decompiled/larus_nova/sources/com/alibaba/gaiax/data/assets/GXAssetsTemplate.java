package com.alibaba.gaiax.data.assets;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/data/assets/GXAssetsTemplate;", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "templateCache", "", "", "", "Lcom/alibaba/gaiax/template/GXTemplate;", "addToCache", "", "gxTemplate", "getFromCache", GXTemplateKey.GAIAX_TEMPLATE_BIZ, GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplate", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "readFileFromAssets", "path", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXAssetsTemplate implements GXRegisterCenterApi.GXIExtensionTemplateSource {
    private final Context context;
    private final Map<String, List<GXTemplate>> templateCache;

    public Context getContext() {
        return this.context;
    }

    public GXAssetsTemplate(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.templateCache = new LinkedHashMap();
    }

    private final void addToCache(GXTemplate r100) {
        List<GXTemplate> r101 = this.templateCache.get(r100.getBiz());
        if (r101 != null) goto L5;
        r101 = new ArrayList();
        this.templateCache.put(r100.getBiz(), r101);
    L5:
        r101.add(r100);
    }

    private final String readFileFromAssets(String r100) {
        Resources r101 = getContext().getResources();     // Catch: Exception -> L27
        if (r101 == null) goto L14;
        AssetManager r102 = r101.getAssets();     // Catch: Exception -> L27
        if (r102 == null) goto L14;
        InputStream r103 = r102.open(r100);     // Catch: Exception -> L27
        if (r103 == null) goto L14;
        Reader r104 = new InputStreamReader(r103, Charsets.UTF_8);     // Catch: Exception -> L27
        if ((r104 instanceof BufferedReader) == false) goto L13;
        BufferedReader r105 = (BufferedReader) r104;     // Catch: Exception -> L27
    L15:
        if (r105 != null) goto L28;
        String r106 = null;
    L24:
        CloseableKt.closeFinally(r105, null);     // Catch: Exception -> L27
        return r106;
    L28:
        r106 = TextStreamsKt.readText(r105);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Exception -> L27
        throw th;     // Catch: Exception -> L27
    L13:
        r105 = new BufferedReader(r104, 8192);     // Catch: Exception -> L27
    L14:
        r105 = null;
    L33:
        return null;
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionTemplateSource
    public GXTemplate getTemplate(GXTemplateItem r110) {
        Intrinsics.checkNotNullParameter(r110, "gxTemplateItem");
        GXTemplate r100 = getFromCache(r110.getBizId(), r110.getTemplateId());
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = r110.getBundle();
        if (r101.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r101 = r110.getBizId();
    L11:
        String r103 = r101 + '/' + r110.getTemplateId() + "/index.json";
        String r104 = r101 + '/' + r110.getTemplateId() + "/index.css";
        String r105 = r101 + '/' + r110.getTemplateId() + "/index.databinding";
        String r106 = r101 + '/' + r110.getTemplateId() + "/index.js";
        String r107 = readFileFromAssets(r103);
        String r108 = readFileFromAssets(r104);
        String r109 = readFileFromAssets(r105);
        String r111 = readFileFromAssets(r106);
        if (r107 == null) goto L25;
        String r112 = r110.getTemplateId();
        String r113 = r110.getBizId();
        if (r108 != null) goto L16;
        String r114 = "";
    L17:
        if (r109 != null) goto L19;
        String r115 = "";
    L20:
        if (r111 != null) goto L22;
        String r116 = "";
    L23:
        GXTemplate r117 = new GXTemplate(r112, r113, "-1", r107, r114, r115, r116);
        r117.setType(ChameleonAssertResManager.ASSET_FOLDER);
        addToCache(r117);
        return r117;
    L22:
        r116 = r111;
        goto L23
    L19:
        r115 = r109;
        goto L20
    L16:
        r114 = r108;
        goto L17
    L25:
        return null;
    L8:
        r102 = false;
        goto L9
    }

    private final GXTemplate getFromCache(String r100, String r101) {
        List<GXTemplate> r102 = this.templateCache.get(r100);
        Object r103 = null;
        if (r102 == null) goto L31;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((GXTemplate) r106).getId(), r101) == false) goto L6;
        r104.add(r106);
        goto L6
    L10:
        Iterator r107 = r104.iterator();
        if (r107.hasNext() == false) goto L23;
        r103 = r107.next();
        if (r107.hasNext() == false) goto L23;
        String r108 = ((GXTemplate) r103).getVersion();
    L17:
        Object r109 = r107.next();
        String r110 = ((GXTemplate) r109).getVersion();
        if (r108.compareTo(r110) >= 0) goto L21;
        r103 = r109;
        r108 = r110;
    L21:
        if (r107.hasNext() == true) goto L17;
    L23:
        return (GXTemplate) r103;
    L31:
        return null;
    }
}
