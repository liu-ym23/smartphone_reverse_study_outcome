package com.bytedance.android.btm.api;

import com.bytedance.android.btm.api.inner.Logger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001,B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001d¨\u0006-"}, d2 = {"Lcom/bytedance/android/btm/api/PageProp;", "Ljava/io/Serializable;", "Lxc/a;", "", SVGRenderEngine.SAVE, "data", "parse", "component1", "", "component2", "component3", "component4", "component5", "btm", "auto", "singleton", "reuse", "sourceBtmToken", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getBtm", "()Ljava/lang/String;", "setBtm", "(Ljava/lang/String;)V", "Z", "getAuto", "()Z", "setAuto", "(Z)V", "getSingleton", "setSingleton", "getReuse", "setReuse", "getSourceBtmToken", "setSourceBtmToken", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class PageProp implements Serializable, xc.a<PageProp> {
    public static final a Companion = null;
    private static final long serialVersionUID = 20220104;
    private boolean auto;
    private String btm;
    private boolean reuse;
    private boolean singleton;
    private String sourceBtmToken;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PageProp() {
        this(null, false, false, false, null, 31, null);
    }

    public static /* synthetic */ PageProp copy$default(PageProp r100, String r101, boolean r102, boolean r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.btm;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.auto;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.singleton;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.reuse;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.sourceBtmToken;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.btm;
    }

    public final boolean component2() {
        return this.auto;
    }

    public final boolean component3() {
        return this.singleton;
    }

    public final boolean component4() {
        return this.reuse;
    }

    public final String component5() {
        return this.sourceBtmToken;
    }

    public final PageProp copy(String r100, boolean r101, boolean r110, boolean r111, String r112) {
        return new PageProp(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PageProp) == false) goto L16;
        PageProp r101 = (PageProp) r100;
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L8;
        return false;
    L8:
        if (this.auto == r101.auto) goto L10;
        return false;
    L10:
        if (this.singleton == r101.singleton) goto L12;
        return false;
    L12:
        if (this.reuse == r101.reuse) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sourceBtmToken, r101.sourceBtmToken) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.btm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.auto;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.singleton;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.reuse;
        if (r111 == true) goto L16;
        r105 = r111;
    L16:
        int r112 = (r110 + r105) * 31;
        String r113 = this.sourceBtmToken;
        if (r113 == null) goto L20;
        r101 = r113.hashCode();
    L20:
        return r112 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PageProp(btm=" + this.btm + ", auto=" + this.auto + ", singleton=" + this.singleton + ", reuse=" + this.reuse + ", sourceBtmToken=" + this.sourceBtmToken + ")";
    }

    @Override // xc.a
    public String save() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("btm", this.btm);     // Catch: Throwable -> L6
        r100.putOpt("auto", Boolean.valueOf(this.auto));     // Catch: Throwable -> L6
        r100.putOpt("singleton", Boolean.valueOf(this.singleton));     // Catch: Throwable -> L6
        r100.putOpt("reuse", Boolean.valueOf(this.reuse));     // Catch: Throwable -> L6
        r100.putOpt(PhotoEnterModel.SOURCE_BTM_TOKEN, this.sourceBtmToken);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    public final boolean getAuto() {
        return this.auto;
    }

    public final String getBtm() {
        return this.btm;
    }

    public final boolean getReuse() {
        return this.reuse;
    }

    public final boolean getSingleton() {
        return this.singleton;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    @Override // xc.a
    public PageProp parse(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L4
        this.btm = r101.optString("btm");     // Catch: Exception -> L4
        this.auto = r101.optBoolean("auto");     // Catch: Exception -> L4
        this.singleton = r101.optBoolean("singleton");     // Catch: Exception -> L4
        this.reuse = r101.optBoolean("reuse");     // Catch: Exception -> L4
        this.sourceBtmToken = r101.optString(PhotoEnterModel.SOURCE_BTM_TOKEN);     // Catch: Exception -> L4
    L8:
        return this;
    L4:
        e = move-exception;
        Logger r102 = Logger.f41999c;
        Function0<String> r103 = new AnonymousClass1(e);
        r102.getClass();
        com.bytedance.android.btm.api.inner.f r104 = (com.bytedance.android.btm.api.inner.f) Logger.f41998b.getValue(r102, Logger.f41997a[0]);
        if (r104 == null) goto L8;
        r104.a(r103);
        goto L8
    }

    public final void setAuto(boolean r100) {
        this.auto = r100;
    }

    public final void setBtm(String r100) {
        this.btm = r100;
    }

    public final void setReuse(boolean r100) {
        this.reuse = r100;
    }

    public final void setSingleton(boolean r100) {
        this.singleton = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    @Override // xc.a
    public /* bridge */ /* synthetic */ Object parse(String r100) {
        return parse(r100);
    }

    public PageProp(String r100, boolean r101, boolean r102, boolean r103, String r104) {
        this.btm = r100;
        this.auto = r101;
        this.singleton = r102;
        this.reuse = r103;
        this.sourceBtmToken = r104;
    }

    public /* synthetic */ PageProp(String r100, boolean r101, boolean r102, boolean r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L8;
        boolean r111 = true;
    L9:
        boolean r106 = false;
        if ((r105 & 4) == 0) goto L12;
        boolean r107 = false;
    L14:
        if ((r105 & 8) != 0) goto L18;
        r106 = r103;
    L18:
        if ((r105 & 16) == 0) goto L20;
        r104 = null;
    L20:
        String r108 = r104;
        this(r100, r111, r107, r106, r108);
        return;
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L9
    }
}
