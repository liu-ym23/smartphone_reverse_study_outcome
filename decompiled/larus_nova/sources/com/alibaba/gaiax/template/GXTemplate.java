package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/template/GXTemplate;", "", "id", "", "biz", "version", GXTemplateKey.GAIAX_LAYER, GXTemplateKey.GAIAX_CSS, "dataBind", GXTemplateKey.GAIAX_JS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "getCss", "getDataBind", "getId", "getJs", "getLayer", "type", "getType", "setType", "(Ljava/lang/String;)V", "getVersion", "equals", "", "other", "hashCode", "", "toString", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplate {
    private final String biz;
    private final String css;
    private final String dataBind;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f24980id;

    /* JADX INFO: renamed from: js, reason: collision with root package name */
    private final String f24981js;
    private final String layer;
    private String type;
    private final String version;

    public int hashCode() {
        return (((this.f24980id.hashCode() * 31) + this.biz.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "GXTemplate(id='" + this.f24980id + "', biz='" + this.biz + "', version=" + this.version + ')';
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getCss() {
        return this.css;
    }

    public final String getDataBind() {
        return this.dataBind;
    }

    public final String getId() {
        return this.f24980id;
    }

    public final String getJs() {
        return this.f24981js;
    }

    public final String getLayer() {
        return this.layer;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(GXTemplate.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.alibaba.gaiax.template.GXTemplate");
        GXTemplate r102 = (GXTemplate) r100;
        if (Intrinsics.areEqual(this.f24980id, r102.f24980id) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.biz, r102.biz) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.version, r102.version) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public GXTemplate(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "biz");
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r104, GXTemplateKey.GAIAX_CSS);
        Intrinsics.checkNotNullParameter(r105, "dataBind");
        Intrinsics.checkNotNullParameter(r106, GXTemplateKey.GAIAX_JS);
        this.f24980id = r100;
        this.biz = r101;
        this.version = r102;
        this.layer = r103;
        this.css = r104;
        this.dataBind = r105;
        this.f24981js = r106;
        this.type = "";
    }
}
