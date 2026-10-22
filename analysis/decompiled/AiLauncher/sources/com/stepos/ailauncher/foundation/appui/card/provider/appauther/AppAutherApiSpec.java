package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;", "", "", "method", "path", "", "body", "pathTemplate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppAutherApiSpec {

    @SerializedName("body")
    private final Map<String, Object> body;

    @SerializedName("method")
    private final String method;

    @SerializedName("path")
    private final String path;

    @SerializedName("pathTemplate")
    private final String pathTemplate;

    public AppAutherApiSpec() {
        this(null, null, null, null, 15, null);
    }

    public final Map<String, Object> a() {
        return this.body;
    }

    /* renamed from: b, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: c, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: d, reason: from getter */
    public final String getPathTemplate() {
        return this.pathTemplate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAutherApiSpec)) {
            return false;
        }
        AppAutherApiSpec appAutherApiSpec = (AppAutherApiSpec) other;
        return kotlin.jvm.internal.p.d(this.method, appAutherApiSpec.method) && kotlin.jvm.internal.p.d(this.path, appAutherApiSpec.path) && kotlin.jvm.internal.p.d(this.body, appAutherApiSpec.body) && kotlin.jvm.internal.p.d(this.pathTemplate, appAutherApiSpec.pathTemplate);
    }

    public int hashCode() {
        String str = this.method;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.path;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map = this.body;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.pathTemplate;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AppAutherApiSpec(method=" + this.method + ", path=" + this.path + ", body=" + this.body + ", pathTemplate=" + this.pathTemplate + ")";
    }

    public AppAutherApiSpec(String str, String str2, Map<String, ? extends Object> map, String str3) {
        this.method = str;
        this.path = str2;
        this.body = map;
        this.pathTemplate = str3;
    }

    public /* synthetic */ AppAutherApiSpec(String str, String str2, Map map, String str3, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : map, (i10 & 8) != 0 ? null : str3);
    }
}
