package stepai.aios.guiexecutor.api;

import android.graphics.Rect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\rHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0003J{\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lstepai/aios/guiexecutor/api/AccessibilityNodeInfo;", "", "className", "", "text", "contentDescription", "bounds", "Landroid/graphics/Rect;", "isClickable", "", "isEnabled", "isVisible", "children", "", "attributes", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;ZZZLjava/util/List;Ljava/util/Map;)V", "getClassName", "()Ljava/lang/String;", "getText", "getContentDescription", "getBounds", "()Landroid/graphics/Rect;", "()Z", "getChildren", "()Ljava/util/List;", "getAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AccessibilityNodeInfo {
    private final Map<String, Object> attributes;
    private final Rect bounds;
    private final List<AccessibilityNodeInfo> children;
    private final String className;
    private final String contentDescription;
    private final boolean isClickable;
    private final boolean isEnabled;
    private final boolean isVisible;
    private final String text;

    public AccessibilityNodeInfo(String str, String str2, String str3, Rect rect, boolean z10, boolean z11, boolean z12, List list, Map map, int i, e eVar) {
        this(str, str2, str3, rect, z10, z11, z12, (i & 128) != 0 ? EmptyList.f4893a : list, (i & 256) != 0 ? a.M() : map);
    }

    public static /* synthetic */ AccessibilityNodeInfo copy$default(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, Rect rect, boolean z10, boolean z11, boolean z12, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessibilityNodeInfo.className;
        }
        if ((i & 2) != 0) {
            str2 = accessibilityNodeInfo.text;
        }
        if ((i & 4) != 0) {
            str3 = accessibilityNodeInfo.contentDescription;
        }
        if ((i & 8) != 0) {
            rect = accessibilityNodeInfo.bounds;
        }
        if ((i & 16) != 0) {
            z10 = accessibilityNodeInfo.isClickable;
        }
        if ((i & 32) != 0) {
            z11 = accessibilityNodeInfo.isEnabled;
        }
        if ((i & 64) != 0) {
            z12 = accessibilityNodeInfo.isVisible;
        }
        if ((i & 128) != 0) {
            list = accessibilityNodeInfo.children;
        }
        if ((i & 256) != 0) {
            map = accessibilityNodeInfo.attributes;
        }
        List list2 = list;
        Map map2 = map;
        boolean z13 = z11;
        boolean z14 = z12;
        boolean z15 = z10;
        String str4 = str3;
        return accessibilityNodeInfo.copy(str, str2, str4, rect, z15, z13, z14, list2, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContentDescription() {
        return this.contentDescription;
    }

    /* renamed from: component4, reason: from getter */
    public final Rect getBounds() {
        return this.bounds;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsClickable() {
        return this.isClickable;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final List<AccessibilityNodeInfo> component8() {
        return this.children;
    }

    public final Map<String, Object> component9() {
        return this.attributes;
    }

    public final AccessibilityNodeInfo copy(String className, String text, String contentDescription, Rect bounds, boolean isClickable, boolean isEnabled, boolean isVisible, List<AccessibilityNodeInfo> children, Map<String, ? extends Object> attributes) {
        k.f(bounds, "bounds");
        k.f(children, "children");
        k.f(attributes, "attributes");
        return new AccessibilityNodeInfo(className, text, contentDescription, bounds, isClickable, isEnabled, isVisible, children, attributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccessibilityNodeInfo)) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) other;
        return k.b(this.className, accessibilityNodeInfo.className) && k.b(this.text, accessibilityNodeInfo.text) && k.b(this.contentDescription, accessibilityNodeInfo.contentDescription) && k.b(this.bounds, accessibilityNodeInfo.bounds) && this.isClickable == accessibilityNodeInfo.isClickable && this.isEnabled == accessibilityNodeInfo.isEnabled && this.isVisible == accessibilityNodeInfo.isVisible && k.b(this.children, accessibilityNodeInfo.children) && k.b(this.attributes, accessibilityNodeInfo.attributes);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final Rect getBounds() {
        return this.bounds;
    }

    public final List<AccessibilityNodeInfo> getChildren() {
        return this.children;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.className;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.contentDescription;
        return this.attributes.hashCode() + androidx.appfunctions.metadata.a.e(this.children, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((this.bounds.hashCode() + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31)) * 31, 31, this.isClickable), 31, this.isEnabled), 31, this.isVisible), 31);
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        String str = this.className;
        String str2 = this.text;
        String str3 = this.contentDescription;
        Rect rect = this.bounds;
        boolean z10 = this.isClickable;
        boolean z11 = this.isEnabled;
        boolean z12 = this.isVisible;
        List<AccessibilityNodeInfo> list = this.children;
        Map<String, Object> map = this.attributes;
        StringBuilder sbW = B7.a.w("AccessibilityNodeInfo(className=", str, ", text=", str2, ", contentDescription=");
        sbW.append(str3);
        sbW.append(", bounds=");
        sbW.append(rect);
        sbW.append(", isClickable=");
        sbW.append(z10);
        sbW.append(", isEnabled=");
        sbW.append(z11);
        sbW.append(", isVisible=");
        sbW.append(z12);
        sbW.append(", children=");
        sbW.append(list);
        sbW.append(", attributes=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public AccessibilityNodeInfo(String str, String str2, String str3, Rect bounds, boolean z10, boolean z11, boolean z12, List<AccessibilityNodeInfo> children, Map<String, ? extends Object> attributes) {
        k.f(bounds, "bounds");
        k.f(children, "children");
        k.f(attributes, "attributes");
        this.className = str;
        this.text = str2;
        this.contentDescription = str3;
        this.bounds = bounds;
        this.isClickable = z10;
        this.isEnabled = z11;
        this.isVisible = z12;
        this.children = children;
        this.attributes = attributes;
    }
}
