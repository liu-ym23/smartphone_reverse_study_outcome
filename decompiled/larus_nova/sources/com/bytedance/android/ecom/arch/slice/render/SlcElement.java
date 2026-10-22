package com.bytedance.android.ecom.arch.slice.render;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcTypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SlcTypeAdapterFactory.class)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u009d\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\u0018\b\u0002\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u000102\u0012\u0018\b\u0002\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\u0018\b\u0002\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\u0018\b\u0002\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\u001e\b\u0002\u0010>\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020=\u0018\u000102\u0018\u00010*\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010@\u0012\u0018\b\u0002\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010*\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I¢\u0006\u0004\bL\u0010MJ\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0010\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R*\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R*\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R*\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u0010/R*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010/R*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u0010/R0\u0010>\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020=\u0018\u000102\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b>\u0010-\u001a\u0004\b?\u0010/R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010@8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bE\u0010B\u001a\u0004\bF\u0010DR*\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bG\u0010-\u001a\u0004\bH\u0010/R\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "Lcom/bytedance/android/ecom/arch/slice/render/ISlcElement;", "", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcRenderContext;", "renderContext", "", "getRealFlatten$slice_render_release", "(Lcom/bytedance/android/ecom/arch/slice/render/context/SlcRenderContext;)Z", "getRealFlatten", "deepClone", "", "getItemKey", "Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/c;", "getBindForConfig", "", "toString", "itemKey", "J", "Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/a;", "forConfigValue", "Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/a;", "childrenHasFor", "Z", "textHasTail", "childHasIf", "canFlatten", "hasZIndex", "hasA11y", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lcom/bytedance/android/ecom/arch/slice/render/q;", "meta", "Lcom/bytedance/android/ecom/arch/slice/render/q;", "getMeta", "()Lcom/bytedance/android/ecom/arch/slice/render/q;", "Lcom/bytedance/android/ecom/arch/slice/render/n;", "config", "Lcom/bytedance/android/ecom/arch/slice/render/n;", "getConfig", "()Lcom/bytedance/android/ecom/arch/slice/render/n;", "", "", SlcElement.KEY_PROPS, "Ljava/util/Map;", "getProps", "()Ljava/util/Map;", SlcElement.KEY_ATTR, "getAttr", "", SlcElement.KEY_ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "style", "getStyle", "activeStyle", "getActiveStyle", "storage", "getStorage", "Lcom/bytedance/android/ecom/arch/slice/render/widget/animation/f;", "animations", "getAnimations", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "clickAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getClickAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "longClickAction", "getLongClickAction", "action", "getAction", "Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/d;", "bindInfo", "Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/d;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/render/q;Lcom/bytedance/android/ecom/arch/slice/render/n;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/d;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcElement implements ISlcElement, Cloneable {
    public static final a Companion = null;
    public static final String KEY_ACTION = "action";
    public static final String KEY_ACTIVE_STYLE = "active_style";
    public static final String KEY_ANIMATIONS = "animations";
    public static final String KEY_ATTR = "attr";
    public static final String KEY_CLICK_ACTION = "click_action";
    public static final String KEY_CONFIG = "config";
    public static final String KEY_ELEMENTS = "elements";
    public static final String KEY_FOR = "for";
    public static final String KEY_IF = "if";
    public static final String KEY_LONG_CLICK_ACTION = "long_click_action";
    public static final String KEY_META = "meta";
    public static final String KEY_ON_ANIMATION_END = "on_animationend";
    public static final String KEY_ON_ANIMATION_START = "on_animationstart";
    public static final String KEY_ON_EXPOSURE = "on_exposure";
    public static final String KEY_ON_SCROLL = "on_scroll";
    public static final String KEY_ON_TOUCH_DOWN = "on_touchdown";
    public static final String KEY_ON_TOUCH_UP = "on_touchup";
    public static final String KEY_ON_TRANSITION_END = "on_transitionend";
    public static final String KEY_ON_TRANSITION_START = "on_transitionstart";
    public static final String KEY_PROPS = "props";
    public static final String KEY_SLICE_KEY = "slice_key";
    public static final String KEY_STORAGE = "storage";
    public static final String KEY_STYLE = "style";
    public static final String KEY_TAP_PROPAGATE = "tap_propagate";
    public static final String KEY_TYPE = "type";

    @SerializedName("action")
    private final Map<String, IAction> action;

    @SerializedName(KEY_ACTIVE_STYLE)
    private final Map<String, Object> activeStyle;

    @SerializedName("animations")
    private final Map<String, List<com.bytedance.android.ecom.arch.slice.render.widget.animation.f>> animations;

    @SerializedName(KEY_ATTR)
    private final Map<String, Object> attr;
    public transient com.bytedance.android.ecom.arch.slice.render.bindinfo.d bindInfo;
    public transient boolean canFlatten;
    public transient boolean childHasIf;
    public transient boolean childrenHasFor;

    @SerializedName("click_action")
    private final IAction clickAction;

    @SerializedName("config")
    private final n config;

    @SerializedName(KEY_ELEMENTS)
    private final List<SlcElement> elements;
    public transient com.bytedance.android.ecom.arch.slice.render.bindinfo.a forConfigValue;
    public transient boolean hasA11y;
    public transient boolean hasZIndex;
    public transient long itemKey;

    @SerializedName("long_click_action")
    private final IAction longClickAction;

    @SerializedName("meta")
    private final q meta;

    @SerializedName(KEY_PROPS)
    private final Map<String, Object> props;

    @SerializedName("storage")
    private final Map<String, Object> storage;

    @SerializedName("style")
    private final Map<String, Object> style;
    public transient boolean textHasTail;

    @SerializedName("type")
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SlcElement() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public final com.bytedance.android.ecom.arch.slice.render.bindinfo.c getBindForConfig() {
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r100 = this.bindInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f50133d;
    }

    public Object clone() {
        return super.clone();
    }

    public final SlcElement deepClone() {
        Object r100 = clone();
        if (r100 == null) goto L7;
        SlcElement r101 = (SlcElement) r100;
        r101.itemKey = com.bytedance.android.ecom.arch.slice.render.util.d.f50735a.addAndGet(1);
        return r101;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.render.SlcElement");
    }

    public String toString() {
        String r100 = getType();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, IAction> getAction() {
        return this.action;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, Object> getActiveStyle() {
        return this.activeStyle;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, List<com.bytedance.android.ecom.arch.slice.render.widget.animation.f>> getAnimations() {
        return this.animations;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, Object> getAttr() {
        return this.attr;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public IAction getClickAction() {
        return this.clickAction;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public n getConfig() {
        return this.config;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public List<SlcElement> getElements() {
        return this.elements;
    }

    public final long getItemKey() {
        return this.itemKey;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public IAction getLongClickAction() {
        return this.longClickAction;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public q getMeta() {
        return this.meta;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, Object> getProps() {
        return this.props;
    }

    public final Map<String, Object> getStorage() {
        return this.storage;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public Map<String, Object> getStyle() {
        return this.style;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.ISlcElement
    public String getType() {
        return this.type;
    }

    public final boolean getRealFlatten$slice_render_release(SlcRenderContext r100) {
        if (this.hasA11y == false) goto L11;
        if (this.canFlatten == true) goto L7;
    L9:
        return false;
    L7:
        if (r100.j() == true) goto L9;
        return true;
    L11:
        return this.canFlatten;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcElement(String r100, q r101, n r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, List<SlcElement> r105, Map<String, ? extends Object> r106, Map<String, ? extends Object> r107, Map<String, ? extends Object> r108, Map<String, ? extends List<com.bytedance.android.ecom.arch.slice.render.widget.animation.f>> r110, IAction r111, IAction r112, Map<String, ? extends IAction> r113, com.bytedance.android.ecom.arch.slice.render.bindinfo.d r114) {
        this.type = r100;
        this.meta = r101;
        this.config = r102;
        this.props = r103;
        this.attr = r104;
        this.elements = r105;
        this.style = r106;
        this.activeStyle = r107;
        this.storage = r108;
        this.animations = r110;
        this.clickAction = r111;
        this.longClickAction = r112;
        this.action = r113;
        this.bindInfo = r114;
        this.itemKey = com.bytedance.android.ecom.arch.slice.render.util.d.f50735a.addAndGet(1);
    }

    public /* synthetic */ SlcElement(String r110, q r111, n r112, Map r113, Map r210, List r211, Map r212, Map r213, Map r214, Map r215, IAction r216, IAction r217, Map r218, com.bytedance.android.ecom.arch.slice.render.bindinfo.d r219, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r101 = null;
        if ((r310 & 2) == 0) goto L9;
        q r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        n r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Map r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Map r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Map r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Map r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        IAction r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        IAction r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Map r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r101 = r219;
    L58:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r101);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
