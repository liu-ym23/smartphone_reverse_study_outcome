package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.android.ecom.arch.slice.render.elements.SlcTypeAdapterFactory;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SlcTypeAdapterFactory.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006¢\u0006\u0004\b&\u0010'J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/action/SlcCommonAction;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "", "other", "", "equals", "", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "hasDynamicProp", "Z", "getHasDynamicProp", "()Z", "setHasDynamicProp", "(Z)V", "getType", "()Ljava/lang/String;", "type", "getParams", "params", "getDisable", "disable", "", "getExposureThreshold", "()F", "exposureThreshold", "", "getScrollCallbackThreshold", "()J", "scrollCallbackThreshold", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcCommonAction implements IAction {
    public static final a Companion = null;
    public static final String KEY_ACTIONS = "actions";
    public static final String KEY_ACTION_CHAIN_PATH = "action_chain_path";
    public static final String KEY_ACTION_MONITOR_ID = "action_monitor_id";
    public static final String KEY_DISABLE = "disable";
    public static final String KEY_EXPOSURE_THRESHOLD = "exposure_threshold";
    public static final String KEY_PARAMS = "fields";
    public static final String KEY_SCROLL_THRESHOLD = "scroll_threshold";
    public static final String KEY_TYPE = "type";
    public static final int TEMPLATE_DEPTH = 2;
    private final List<IAction> actions;
    private final Map<String, Object> data;
    private boolean hasDynamicProp;

    public static final class a {
        public a() {
        }

        public static SlcCommonAction a(List r100) {
            if (r100 == null) goto L15;
            ArrayList r101 = new ArrayList();
            Iterator r102 = r100.iterator();
        L6:
            if (r102.hasNext() == false) goto L11;
            IAction r103 = n.a(r102.next());
            if (r103 == null) goto L6;
            r101.add(r103);
            goto L6
        L11:
            if (r101.isEmpty() == false) goto L14;
            return null;
        L14:
            return new SlcCommonAction(null, r101, false, 5, null);
        L15:
            return null;
        }

        public static SlcCommonAction b(Map r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            return c(r100, false);
        }

        public static List d(Map r100) {
            ArrayList r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.get(SlcCommonAction.KEY_ACTIONS);
        L7:
            if ((r102 instanceof List) == true) goto L9;
            r102 = null;
        L9:
            List r103 = (List) r102;
            if (r103 == null) goto L17;
            r101 = new ArrayList();
            Iterator r104 = r103.iterator();
        L13:
            if (r104.hasNext() == false) goto L17;
            IAction r105 = n.a(r104.next());
            if (r105 == null) goto L13;
            r101.add(r105);
        L17:
            return r101;
        L5:
            r102 = null;
            goto L7
        }

        public static SlcCommonAction c(Map r100, boolean r101) {
            List r102 = d(r100);
            boolean r103 = false;
            if (r101 == true) goto L7;
            JsonTemplate.f51054c.getClass();
            r103 = JsonTemplate.a.d(r100, 0);
        L7:
            return new SlcCommonAction(r100, r102, r103, null);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public boolean getDisable() {
        return com.bytedance.android.ecom.arch.slice.render.util.b.a(this.data.get("disable"));
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public float getExposureThreshold() {
        return com.bytedance.android.ecom.arch.slice.render.util.b.c(this.data.get(KEY_EXPOSURE_THRESHOLD), 0.0f);
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public Map<String, Object> getParams() {
        Object r100 = this.data.get(KEY_PARAMS);
        if ((r100 instanceof Map) == true) goto L6;
        r100 = null;
    L6:
        return (Map) r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public long getScrollCallbackThreshold() {
        return com.bytedance.android.ecom.arch.slice.render.util.b.l(this.data.get(KEY_SCROLL_THRESHOLD), 200);
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public String getType() {
        Object r100 = this.data.get("type");
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r101 = (String) r100;
        if (r101 != null) goto L10;
        return "__SLC_UNKNOWN__";
    L10:
        return r101;
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public List<IAction> getActions() {
        return this.actions;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final boolean getHasDynamicProp() {
        return this.hasDynamicProp;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(SlcCommonAction.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        SlcCommonAction r102 = (SlcCommonAction) r100;
        if ((!Intrinsics.areEqual(this.data, r102.data)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(getActions(), r102.getActions())) == false) goto L20;
        return false;
    L20:
        if (this.hasDynamicProp == r102.hasDynamicProp) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.action.SlcCommonAction");
    L8:
        r101 = null;
        goto L10
    }

    public final void setHasDynamicProp(boolean r100) {
        this.hasDynamicProp = r100;
    }

    public SlcCommonAction(String r100, Map<String, ? extends Object> r101) {
        this(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("type", r100), TuplesKt.to(KEY_PARAMS, r101)}), null, false, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcCommonAction(Map<String, ? extends Object> r100, List<? extends IAction> r101, boolean r102) {
        this.data = r100;
        this.actions = r101;
        this.hasDynamicProp = r102;
    }

    public /* synthetic */ SlcCommonAction(String r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public /* synthetic */ SlcCommonAction(Map r100, List r101, boolean r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ SlcCommonAction(Map r100, List r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
