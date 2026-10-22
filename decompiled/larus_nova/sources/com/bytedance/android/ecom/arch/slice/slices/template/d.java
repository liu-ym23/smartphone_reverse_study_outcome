package com.bytedance.android.ecom.arch.slice.slices.template;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.SliceUpdateMode;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.o;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R:\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR>\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/slices/template/d;", "Lcom/bytedance/android/ecom/arch/slice/BaseSlice;", "Lcom/bytedance/android/ecom/arch/slice/slices/template/c;", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/android/ecom/arch/slice/slices/template/c;", "b", "()Lcom/bytedance/android/ecom/arch/slice/slices/template/c;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "data", "Ljava/util/HashMap;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "actionMap", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashMap;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends BaseSlice {

    @SerializedName("action_map")
    private final HashMap<String, IAction> actionMap;

    @SerializedName("data")
    private HashMap<String, Object> data;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private final c template;

    public d() {
        Map r100 = null;
        super("", null, null, null, r100, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER, null);
        this.template = null;
        this.data = null;
        this.actionMap = null;
    }

    public final o c() {
        c r100 = this.template;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getType();
    L6:
        c r103 = this.template;
        if (r103 == null) goto L9;
        SlcElement r104 = r103.b();
    L10:
        c r105 = this.template;
        if (r105 == null) goto L13;
        String r106 = r105.c();
    L14:
        c r107 = this.template;
        if (r107 == null) goto L17;
        String r108 = r107.d();
    L19:
        if (r108 != null) goto L21;
        String r109 = "";
    L22:
        c r110 = this.template;
        if (r110 == null) goto L25;
        String r111 = r110.a();
    L26:
        if (r111 != null) goto L28;
        String r112 = "";
    L29:
        c r113 = this.template;
        if (r113 == null) goto L32;
        r101 = r113.e();
    L32:
        if (r101 != null) goto L34;
        String r114 = "";
    L36:
        return new o(r109, r112, r114, r102, r104, r106);
    L34:
        r114 = r101;
        goto L36
    L28:
        r112 = r111;
        goto L29
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = r108;
        goto L22
    L17:
        r108 = null;
        goto L19
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getViewType());
        r100.append(":");
        String r101 = getSliceId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        return r100.toString();
    }

    public final HashMap<String, IAction> a() {
        return this.actionMap;
    }

    public final c b() {
        return this.template;
    }

    @Override // com.bytedance.android.ecom.arch.slice.BaseSlice, com.bytedance.android.ecom.arch.slice.g
    public final Map<String, Object> getData() {
        return this.data;
    }

    @Override // com.bytedance.android.ecom.arch.slice.BaseSlice
    public final void onUpdateData(Map<String, ? extends Object> r100, @SliceUpdateMode int r101) {
        Intrinsics.checkNotNullParameter(r100, "patchData");
        super.onUpdateData(r100, r101);
        if (r101 != 1) goto L5;
        this.data = new HashMap(r100);
        return;
    L5:
        if (r101 == 0) goto L7;
        return;
    L7:
        if ((!r100.isEmpty()) == false) goto L23;
        HashMap<String, Object> r102 = this.data;
        Object r103 = null;
        if (r102 == null) goto L11;
        Object r104 = r102.clone();
    L13:
        if ((r104 instanceof HashMap) == false) goto L16;
        r103 = r104;
    L16:
        HashMap<String, Object> r105 = (HashMap) r103;
        if (r105 != null) goto L19;
        r105 = new HashMap();
    L19:
        r105.putAll(r100);
        this.data = r105;
        return;
    L11:
        r104 = null;
        goto L13
    }
}
