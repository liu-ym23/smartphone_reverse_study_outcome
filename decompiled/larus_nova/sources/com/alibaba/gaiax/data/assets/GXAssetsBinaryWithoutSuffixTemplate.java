package com.alibaba.gaiax.data.assets;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/data/assets/GXAssetsBinaryWithoutSuffixTemplate;", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "templateCache", "", "", "", "Lcom/alibaba/gaiax/template/GXTemplate;", "addToCache", "", ThumbGlideUrl.SOURCE_TEMPLATE, "createTemplate", HTTP.CONTENT_RANGE_BYTES, "", GXTemplateKey.GAIAX_TEMPLATE_BIZ, GXTemplateKey.GAIAX_TEMPLATE_ID, "getFromCache", "getTemplate", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "getTemplateContents", "templateItem", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXAssetsBinaryWithoutSuffixTemplate implements GXRegisterCenterApi.GXIExtensionTemplateSource {
    private final Context context;
    private final Map<String, List<GXTemplate>> templateCache;

    public final Context getContext() {
        return this.context;
    }

    public GXAssetsBinaryWithoutSuffixTemplate(Context r100) {
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

    private final byte[] getTemplateContents(GXTemplateItem r100) {
        String r101 = r100.getBundle();     // Catch: Exception -> L24
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        r101 = r100.getBizId();     // Catch: Exception -> L24
    L9:
        Resources r103 = this.context.getResources();     // Catch: Exception -> L24
        if (r103 == null) goto L23;
        AssetManager r104 = r103.getAssets();     // Catch: Exception -> L24
        if (r104 == null) goto L32;
        InputStream r105 = r104.open(r101 + '/' + r100.getTemplateId());     // Catch: Exception -> L24
        if (r105 == null) goto L33;
        byte[] r106 = ByteStreamsKt.readBytes(r105);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r105, null);     // Catch: Exception -> L24
        return r106;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L33:
        return null;
    L32:
        return null;
    L23:
        return null;
    L6:
        r102 = false;
    L24:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionTemplateSource
    public GXTemplate getTemplate(GXTemplateItem r100) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
        GXTemplate r101 = getFromCache(r100.getBizId(), r100.getTemplateId());
        if (r101 == null) goto L5;
        return r101;
    L5:
        byte[] r102 = getTemplateContents(r100);
        if (r102 == null) goto L9;
        GXTemplate r103 = createTemplate(r102, r100.getBizId(), r100.getTemplateId());
        r103.setType("assets_binary");
        addToCache(r103);
        return getFromCache(r100.getBizId(), r100.getTemplateId());
    L9:
        return null;
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

    private final GXTemplate createTemplate(byte[] r110, String r111, String r112) {
        JSONObject r113 = GXBinParser.INSTANCE.parser(r110);
        String r100 = r113.optString(GXTemplateKey.GAIAX_LAYER, null);
        if (r100 == null) goto L7;
        return new GXTemplate(r112, r111, "-1", r100, r113.optString(GXTemplateKey.GAIAX_CSS, null), r113.optString(GXTemplateKey.GAIAX_DATABINDING, null), r113.optString(GXTemplateKey.GAIAX_JS, null));
    L7:
        throw new IllegalArgumentException("Layer mustn't empty, templateBiz = " + r111 + ", templateId = " + r112);
    }
}
