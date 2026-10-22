package com.bytedance.android.ecom.slice.ext.template.gecko;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ecom/slice/ext/template/gecko/SlcTemplateFetchType;", "", "Gecko", "Builtin", "CDN", "gecko_template_store_release"}, k = 1, mv = {1, 4, 0})
public final enum SlcTemplateFetchType extends Enum<SlcTemplateFetchType> {
    public static final SlcTemplateFetchType Builtin = null;
    public static final SlcTemplateFetchType CDN = null;
    public static final SlcTemplateFetchType Gecko = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlcTemplateFetchType[] f51249a = null;

    static {
        SlcTemplateFetchType r100 = new SlcTemplateFetchType("Gecko", 0);
        Gecko = r100;
        SlcTemplateFetchType r101 = new SlcTemplateFetchType("Builtin", 1);
        Builtin = r101;
        SlcTemplateFetchType r102 = new SlcTemplateFetchType("CDN", 2);
        CDN = r102;
        f51249a = new SlcTemplateFetchType[]{r100, r101, r102};
    }

    public static SlcTemplateFetchType valueOf(String r100) {
        return (SlcTemplateFetchType) r27.a.a(SlcTemplateFetchType.class, r100);
    }

    public static SlcTemplateFetchType[] values() {
        return (SlcTemplateFetchType[]) f51249a.clone();
    }

    public SlcTemplateFetchType(String r100, int r101) {
        super(r100, r101);
    }
}
