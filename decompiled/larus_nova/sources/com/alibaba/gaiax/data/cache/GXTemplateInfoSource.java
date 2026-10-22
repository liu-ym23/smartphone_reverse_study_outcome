package com.alibaba.gaiax.data.cache;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import com.obric.sva.sdk.controller.Global;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J$\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/alibaba/gaiax/data/cache/GXTemplateInfoSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "()V", "dataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", Global.RECORDING_TYPE_CLEAN, "", "clearByTemplateId", GXTemplateKey.GAIAX_TEMPLATE_BIZ, GXTemplateKey.GAIAX_TEMPLATE_ID, "collectionNestTemplate", "bizList", "info", POINativeModule.RESP_EXIST, "", "getTemplateInfo", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
    public static final Companion Companion = null;
    private static final Lazy<GXTemplateInfoSource> instance$delegate = null;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> dataCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/data/cache/GXTemplateInfoSource$Companion;", "", "()V", "instance", "Lcom/alibaba/gaiax/data/cache/GXTemplateInfoSource;", "getInstance", "()Lcom/alibaba/gaiax/data/cache/GXTemplateInfoSource;", "instance$delegate", "Lkotlin/Lazy;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXTemplateInfoSource getInstance() {
            return (GXTemplateInfoSource) GXTemplateInfoSource.access$getInstance$delegate$cp().getValue();
        }
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(GXTemplateInfoSource$Companion$instance$2.INSTANCE);
    }

    public final void clean() {
        this.dataCache.clear();
    }

    public GXTemplateInfoSource() {
        this.dataCache = new ConcurrentHashMap();
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
    public GXTemplateInfo getTemplateInfo(GXTemplateItem r100) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
        if (exist(r100.getBizId(), r100.getTemplateId()) == false) goto L11;
        ConcurrentHashMap<String, GXTemplateInfo> r101 = this.dataCache.get(r100.getBizId());
        if (r101 == null) goto L10;
        GXTemplateInfo r102 = r101.get(r100.getTemplateId());
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("Template exist but reference is null");
    L11:
        GXTemplateInfo r103 = GXTemplateInfo.Companion.createTemplate(r100);
        ConcurrentHashMap<String, GXTemplateInfo> r104 = this.dataCache.get(r100.getBizId());
        if (r104 != null) goto L14;
        r104 = new ConcurrentHashMap();
        this.dataCache.put(r100.getBizId(), r104);
    L14:
        r104.put(r100.getTemplateId(), r103);
        collectionNestTemplate(r104, r103);
        return r103;
    }

    private final void collectionNestTemplate(ConcurrentHashMap<String, GXTemplateInfo> r100, GXTemplateInfo r101) {
        List<GXTemplateInfo> r102 = r101.getChildren();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L20;
        GXTemplateInfo r104 = (GXTemplateInfo) r103.next();
        r100.put(r104.getLayer().getId(), r104);
        List<GXTemplateInfo> r105 = r104.getChildren();
        boolean r106 = false;
        if (r105 != null) goto L10;
    L12:
        if (r106 == false) goto L6;
        collectionNestTemplate(r100, r104);
        goto L6
    L10:
        if ((!r105.isEmpty()) != true) goto L12;
        r106 = true;
        goto L12
    L20:
        return;
    }

    private final boolean exist(String r100, String r101) {
        ConcurrentHashMap<String, GXTemplateInfo> r102 = this.dataCache.get(r100);
        if (r102 == null) goto L5;
        GXTemplateInfo r103 = r102.get(r101);
    L6:
        if (r103 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    public final void clearByTemplateId(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_BIZ);
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_TEMPLATE_ID);
        ConcurrentHashMap<String, GXTemplateInfo> r102 = this.dataCache.get(r100);
        if (r102 == null) goto L6;
        GXTemplateInfo r103 = r102.remove(r101);
        return;
    }
}
