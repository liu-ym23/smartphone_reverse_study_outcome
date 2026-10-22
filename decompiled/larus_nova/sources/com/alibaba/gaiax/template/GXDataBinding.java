package com.alibaba.gaiax.template;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/template/GXDataBinding;", "", "value", "Lcom/alibaba/gaiax/template/GXIExpression;", GXTemplateKey.GAIAX_ACCESSIBILITY_DESC, GXTemplateKey.GAIAX_ACCESSIBILITY_ENABLE, GXTemplateKey.GAIAX_PLACEHOLDER, GXTemplateKey.GAIAX_EXTEND, "", "", "(Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Ljava/util/Map;)V", "getAccessibilityDesc", "()Lcom/alibaba/gaiax/template/GXIExpression;", "getAccessibilityEnable", "getExtend", "()Ljava/util/Map;", "getPlaceholder", "getValue", "setValue", "(Lcom/alibaba/gaiax/template/GXIExpression;)V", "getData", "Lorg/json/JSONObject;", "templateData", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXDataBinding {
    private final GXIExpression accessibilityDesc;
    private final GXIExpression accessibilityEnable;
    private final Map<String, GXIExpression> extend;
    private final GXIExpression placeholder;
    private GXIExpression value;

    public GXDataBinding() {
        this(null, null, null, null, null, 31, null);
    }

    public final GXIExpression getAccessibilityDesc() {
        return this.accessibilityDesc;
    }

    public final GXIExpression getAccessibilityEnable() {
        return this.accessibilityEnable;
    }

    public final Map<String, GXIExpression> getExtend() {
        return this.extend;
    }

    public final GXIExpression getPlaceholder() {
        return this.placeholder;
    }

    public final GXIExpression getValue() {
        return this.value;
    }

    public JSONObject getData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        GXIExpression r101 = this.value;
        if (r101 == null) goto L7;
        Object r102 = r101.value(r100);
        if (r102 == null) goto L7;
        JSONObject r103 = new JSONObject();
        r103.put("value", r102);
    L8:
        GXIExpression r104 = this.placeholder;
        if (r104 == null) goto L15;
        Object r105 = r104.value(r100);
        if (r105 == null) goto L15;
        if (r103 != null) goto L14;
        r103 = new JSONObject();
    L14:
        r103.put(GXTemplateKey.GAIAX_PLACEHOLDER, r105);
    L15:
        GXIExpression r106 = this.accessibilityDesc;
        if (r106 == null) goto L22;
        Object r107 = r106.value(r100);
        if (r107 == null) goto L22;
        if (r103 != null) goto L21;
        r103 = new JSONObject();
    L21:
        r103.put(GXTemplateKey.GAIAX_ACCESSIBILITY_DESC, r107);
    L22:
        GXIExpression r108 = this.accessibilityEnable;
        if (r108 == null) goto L29;
        Object r109 = r108.value(r100);
        if (r109 == null) goto L29;
        if (r103 != null) goto L28;
        r103 = new JSONObject();
    L28:
        r103.put(GXTemplateKey.GAIAX_ACCESSIBILITY_ENABLE, r109);
    L29:
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    public JSONObject getExtend(Object r100) {
        Map<String, GXIExpression> r101 = this.extend;
        JSONObject r102 = null;
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, GXIExpression>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, GXIExpression> r104 = r103.next();
        if (r102 != null) goto L10;
        r102 = new JSONObject();
    L10:
        r102.put(r104.getKey(), r104.getValue().value(r100));
    L11:
        return r102;
    }

    public final void setValue(GXIExpression r100) {
        this.value = r100;
    }

    public GXDataBinding(GXIExpression r100, GXIExpression r101, GXIExpression r102, GXIExpression r103, Map<String, GXIExpression> r104) {
        this.value = r100;
        this.accessibilityDesc = r101;
        this.accessibilityEnable = r102;
        this.placeholder = r103;
        this.extend = r104;
    }

    public /* synthetic */ GXDataBinding(GXIExpression r100, GXIExpression r101, GXIExpression r102, GXIExpression r103, Map r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        GXIExpression r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        GXIExpression r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        GXIExpression r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        GXIExpression r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Map r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
