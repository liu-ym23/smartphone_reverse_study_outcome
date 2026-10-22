package aa6;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.bytedance.kmp.ec.yata.common.platform.l;
import com.bytedance.kmp.ec.yata.common.protocol.CopyConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.i;
import com.bytedance.kmp.ec.yata.common.protocol.data.m;
import com.bytedance.kmp.ec.yata.common.protocol.data.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR2\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u00061"}, d2 = {"Laa6/b;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/n;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "facade", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", ce.f26391f, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "o", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;)V", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/b;", KtvSubElement.CONTAINER, "Ljava/util/List;", "c", "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/p;", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "m", "(Ljava/util/Map;)V", "", "", "linkage", RXScreenCaptureService.KEY_INDEX, "q", "global", "h", "p", "endpoint", "e", OfficeSDKRequestTag.KEY_NEW_USER, "", "reload", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "r", "(Ljava/lang/Boolean;)V", "clear", "b", ce.f26396k, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class b implements n, m<b>, l {

    @SerializedName("clear")
    private Boolean clear;

    @SerializedName(KtvSubElement.CONTAINER)
    private List<com.bytedance.kmp.ec.yata.common.protocol.data.b> container;

    @SerializedName("data")
    private Map<String, p> data;

    @SerializedName("end_point")
    @JsonAdapter(YataFieldsAdapter.class)
    private Map<String, ? extends Object> endpoint;

    @SerializedName("facade")
    private i facade;

    @SerializedName("global")
    @JsonAdapter(YataFieldsAdapter.class)
    private Map<String, ? extends Object> global;

    @SerializedName("linkage")
    @JsonAdapter(YataFieldsAdapter.class)
    private Map<String, ? extends Object> linkage;

    @SerializedName("reload")
    private Boolean reload;

    public b() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.facade, r101.facade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.container, r101.container) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkage, r101.linkage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.global, r101.global) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.endpoint, r101.endpoint) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reload, r101.reload) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.clear, r101.clear) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        i r100 = this.facade;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r104 = this.container;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, p> r107 = this.data;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, ? extends Object> r110 = this.linkage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, ? extends Object> r113 = this.global;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, ? extends Object> r116 = this.endpoint;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.reload;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.clear;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "YataProtocol(facade=" + this.facade + ", container=" + this.container + ", data=" + this.data + ", linkage=" + this.linkage + ", global=" + this.global + ", endpoint=" + this.endpoint + ", reload=" + this.reload + ", clear=" + this.clear + ')';
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Pair[] r100 = new Pair[8];
        i r101 = g();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(r101);
    L6:
        r100[0] = TuplesKt.to("facade", r103);
        List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r104 = c();
        if (r104 == null) goto L9;
        Object r105 = com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(r104);
    L10:
        r100[1] = TuplesKt.to(KtvSubElement.CONTAINER, r105);
        Map<String, p> r106 = getData();
        if (r106 == null) goto L13;
        r102 = com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(r106);
    L13:
        r100[2] = TuplesKt.to("data", r102);
        r100[3] = TuplesKt.to("linkage", i());
        r100[4] = TuplesKt.to("global", h());
        r100[5] = TuplesKt.to("end_point", e());
        r100[6] = TuplesKt.to("reload", j());
        r100[7] = TuplesKt.to("clear", b());
        return MapsKt.mapOf(r100);
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final Boolean b() {
        return this.clear;
    }

    public final List<com.bytedance.kmp.ec.yata.common.protocol.data.b> c() {
        return this.container;
    }

    public final Map<String, Object> e() {
        return this.endpoint;
    }

    public final i g() {
        return this.facade;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.n
    public final Map<String, p> getData() {
        return this.data;
    }

    public final Map<String, Object> h() {
        return this.global;
    }

    public final Map<String, Object> i() {
        return this.linkage;
    }

    public final Boolean j() {
        return this.reload;
    }

    public final b a(@CopyConfig int r110) {
        i r100 = null;
        if (r110 != 1) goto L5;
    L7:
        Map<String, p> r101 = this.data;
        if (r101 == null) goto L10;
        Map<String, Object> r102 = com.bytedance.kmp.ec.yata.common.protocol.utils.b.b(r101, r110);
    L12:
        if (TypeIntrinsics.isMutableMap(r102) == false) goto L14;
    L13:
        Map<String, Object> r103 = r102;
    L15:
        if (r110 != 1) goto L24;
        List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r104 = this.container;
        if (r104 == null) goto L19;
        List<Object> r105 = com.bytedance.kmp.ec.yata.common.protocol.utils.b.a(r104, r110);
    L21:
        if (TypeIntrinsics.isMutableList(r105) == true) goto L25;
        List<Object> r106 = null;
    L26:
        if (r110 != 1) goto L30;
        i r111 = this.facade;
        if (r111 == null) goto L32;
        r100 = r111.b();
    L32:
        return new b(r100, r106, r103, this.linkage, this.global, this.endpoint, this.reload, this.clear);
    L30:
        r100 = this.facade;
    L25:
        r106 = r105;
        goto L26
    L19:
        r105 = null;
        goto L21
    L24:
        r105 = this.container;
        goto L25
    L14:
        r103 = null;
        goto L15
    L10:
        r102 = null;
        goto L12
    L5:
        if (r110 == 2) goto L7;
        r102 = this.data;
        goto L13
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final /* bridge */ /* synthetic */ b d(int r100) {
        return a(r100);
    }

    public final void k(Boolean r100) {
        this.clear = r100;
    }

    public final void l(List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r100) {
        this.container = r100;
    }

    public final void m(Map<String, p> r100) {
        this.data = r100;
    }

    public final void n(Map<String, ? extends Object> r100) {
        this.endpoint = r100;
    }

    public final void o(i r100) {
        this.facade = r100;
    }

    public final void p(Map<String, ? extends Object> r100) {
        this.global = r100;
    }

    public final void q(Map<String, ? extends Object> r100) {
        this.linkage = r100;
    }

    public final void r(Boolean r100) {
        this.reload = r100;
    }

    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "YataStoreWrapper.updateNodeDataFields", imports = {}))
    public final void s(String r100, p r101) {
        if (r101 == null) goto L15;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L17;
        Map<String, p> r103 = this.data;
        if (r103 == null) goto L16;
        HashMap r104 = new HashMap(r103);
        r104.put(r100, r101);
        this.data = r104;
        return;
    L16:
        return;
    L17:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public b(i r100, List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r101, Map<String, p> r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, Map<String, ? extends Object> r105, Boolean r106, Boolean r107) {
        this.facade = r100;
        this.container = r101;
        this.data = r102;
        this.linkage = r103;
        this.global = r104;
        this.endpoint = r105;
        this.reload = r106;
        this.clear = r107;
    }
}
