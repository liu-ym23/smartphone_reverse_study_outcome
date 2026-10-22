package com.bytedance.android.ecom.arch.slice.render;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcTypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SlcTypeAdapterFactory.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR*\u0010 \u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0016\u0010$\u001a\u0004\u0018\u00010!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0011¨\u0006)"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/ISlcElement;", "Ljava/io/Serializable;", "", "getType", "()Ljava/lang/String;", "type", "Lcom/bytedance/android/ecom/arch/slice/render/q;", "getMeta", "()Lcom/bytedance/android/ecom/arch/slice/render/q;", "meta", "Lcom/bytedance/android/ecom/arch/slice/render/n;", "getConfig", "()Lcom/bytedance/android/ecom/arch/slice/render/n;", "config", "", "", "getProps", "()Ljava/util/Map;", SlcElement.KEY_PROPS, "getAttr", SlcElement.KEY_ATTR, "getStyle", "style", "getActiveStyle", "activeStyle", "", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getElements", "()Ljava/util/List;", SlcElement.KEY_ELEMENTS, "Lcom/bytedance/android/ecom/arch/slice/render/widget/animation/f;", "getAnimations", "animations", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getClickAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "clickAction", "getLongClickAction", "longClickAction", "getAction", "action", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public interface ISlcElement extends Serializable {
    Map<String, IAction> getAction();

    Map<String, Object> getActiveStyle();

    Map<String, List<com.bytedance.android.ecom.arch.slice.render.widget.animation.f>> getAnimations();

    Map<String, Object> getAttr();

    IAction getClickAction();

    n getConfig();

    List<SlcElement> getElements();

    IAction getLongClickAction();

    q getMeta();

    Map<String, Object> getProps();

    Map<String, Object> getStyle();

    String getType();
}
