package stepai.aios.guiexecutor.api;

import android.graphics.Rect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lstepai/aios/guiexecutor/api/QueryResult;", "", AppAgent.CONSTRUCT, "()V", "ElementInfo", "ScreenInfo", "AccessibilityInfo", "LayoutHierarchy", "Lstepai/aios/guiexecutor/api/QueryResult$AccessibilityInfo;", "Lstepai/aios/guiexecutor/api/QueryResult$ElementInfo;", "Lstepai/aios/guiexecutor/api/QueryResult$LayoutHierarchy;", "Lstepai/aios/guiexecutor/api/QueryResult$ScreenInfo;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class QueryResult {
    public /* synthetic */ QueryResult(e eVar) {
        this();
    }

    private QueryResult() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiexecutor/api/QueryResult$AccessibilityInfo;", "Lstepai/aios/guiexecutor/api/QueryResult;", "serviceEnabled", "", "permissions", "", "", "capabilities", "attributes", "", "", AppAgent.CONSTRUCT, "(ZLjava/util/Set;Ljava/util/Set;Ljava/util/Map;)V", "getServiceEnabled", "()Z", "getPermissions", "()Ljava/util/Set;", "getCapabilities", "getAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AccessibilityInfo extends QueryResult {
        private final Map<String, Object> attributes;
        private final Set<String> capabilities;
        private final Set<String> permissions;
        private final boolean serviceEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessibilityInfo(boolean z10, Set<String> permissions, Set<String> capabilities, Map<String, ? extends Object> attributes) {
            super(null);
            k.f(permissions, "permissions");
            k.f(capabilities, "capabilities");
            k.f(attributes, "attributes");
            this.serviceEnabled = z10;
            this.permissions = permissions;
            this.capabilities = capabilities;
            this.attributes = attributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AccessibilityInfo copy$default(AccessibilityInfo accessibilityInfo, boolean z10, Set set, Set set2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = accessibilityInfo.serviceEnabled;
            }
            if ((i & 2) != 0) {
                set = accessibilityInfo.permissions;
            }
            if ((i & 4) != 0) {
                set2 = accessibilityInfo.capabilities;
            }
            if ((i & 8) != 0) {
                map = accessibilityInfo.attributes;
            }
            return accessibilityInfo.copy(z10, set, set2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getServiceEnabled() {
            return this.serviceEnabled;
        }

        public final Set<String> component2() {
            return this.permissions;
        }

        public final Set<String> component3() {
            return this.capabilities;
        }

        public final Map<String, Object> component4() {
            return this.attributes;
        }

        public final AccessibilityInfo copy(boolean serviceEnabled, Set<String> permissions, Set<String> capabilities, Map<String, ? extends Object> attributes) {
            k.f(permissions, "permissions");
            k.f(capabilities, "capabilities");
            k.f(attributes, "attributes");
            return new AccessibilityInfo(serviceEnabled, permissions, capabilities, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccessibilityInfo)) {
                return false;
            }
            AccessibilityInfo accessibilityInfo = (AccessibilityInfo) other;
            return this.serviceEnabled == accessibilityInfo.serviceEnabled && k.b(this.permissions, accessibilityInfo.permissions) && k.b(this.capabilities, accessibilityInfo.capabilities) && k.b(this.attributes, accessibilityInfo.attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final Set<String> getCapabilities() {
            return this.capabilities;
        }

        public final Set<String> getPermissions() {
            return this.permissions;
        }

        public final boolean getServiceEnabled() {
            return this.serviceEnabled;
        }

        public int hashCode() {
            return this.attributes.hashCode() + ((this.capabilities.hashCode() + ((this.permissions.hashCode() + (Boolean.hashCode(this.serviceEnabled) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "AccessibilityInfo(serviceEnabled=" + this.serviceEnabled + ", permissions=" + this.permissions + ", capabilities=" + this.capabilities + ", attributes=" + this.attributes + ")";
        }

        public /* synthetic */ AccessibilityInfo(boolean z10, Set set, Set set2, Map map, int i, e eVar) {
            this(z10, set, set2, (i & 8) != 0 ? a.M() : map);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiexecutor/api/QueryResult$LayoutHierarchy;", "Lstepai/aios/guiexecutor/api/QueryResult;", "rootNode", "Lstepai/aios/guiexecutor/api/AccessibilityNodeInfo;", "nodeCount", "", "depth", "attributes", "", "", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/AccessibilityNodeInfo;IILjava/util/Map;)V", "getRootNode", "()Lstepai/aios/guiexecutor/api/AccessibilityNodeInfo;", "getNodeCount", "()I", "getDepth", "getAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LayoutHierarchy extends QueryResult {
        private final Map<String, Object> attributes;
        private final int depth;
        private final int nodeCount;
        private final AccessibilityNodeInfo rootNode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutHierarchy(AccessibilityNodeInfo rootNode, int i, int i6, Map<String, ? extends Object> attributes) {
            super(null);
            k.f(rootNode, "rootNode");
            k.f(attributes, "attributes");
            this.rootNode = rootNode;
            this.nodeCount = i;
            this.depth = i6;
            this.attributes = attributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LayoutHierarchy copy$default(LayoutHierarchy layoutHierarchy, AccessibilityNodeInfo accessibilityNodeInfo, int i, int i6, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                accessibilityNodeInfo = layoutHierarchy.rootNode;
            }
            if ((i10 & 2) != 0) {
                i = layoutHierarchy.nodeCount;
            }
            if ((i10 & 4) != 0) {
                i6 = layoutHierarchy.depth;
            }
            if ((i10 & 8) != 0) {
                map = layoutHierarchy.attributes;
            }
            return layoutHierarchy.copy(accessibilityNodeInfo, i, i6, map);
        }

        /* renamed from: component1, reason: from getter */
        public final AccessibilityNodeInfo getRootNode() {
            return this.rootNode;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNodeCount() {
            return this.nodeCount;
        }

        /* renamed from: component3, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        public final Map<String, Object> component4() {
            return this.attributes;
        }

        public final LayoutHierarchy copy(AccessibilityNodeInfo rootNode, int nodeCount, int depth, Map<String, ? extends Object> attributes) {
            k.f(rootNode, "rootNode");
            k.f(attributes, "attributes");
            return new LayoutHierarchy(rootNode, nodeCount, depth, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LayoutHierarchy)) {
                return false;
            }
            LayoutHierarchy layoutHierarchy = (LayoutHierarchy) other;
            return k.b(this.rootNode, layoutHierarchy.rootNode) && this.nodeCount == layoutHierarchy.nodeCount && this.depth == layoutHierarchy.depth && k.b(this.attributes, layoutHierarchy.attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final int getDepth() {
            return this.depth;
        }

        public final int getNodeCount() {
            return this.nodeCount;
        }

        public final AccessibilityNodeInfo getRootNode() {
            return this.rootNode;
        }

        public int hashCode() {
            return this.attributes.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.depth, androidx.constraintlayout.core.dsl.a.a(this.nodeCount, this.rootNode.hashCode() * 31, 31), 31);
        }

        public String toString() {
            return "LayoutHierarchy(rootNode=" + this.rootNode + ", nodeCount=" + this.nodeCount + ", depth=" + this.depth + ", attributes=" + this.attributes + ")";
        }

        public /* synthetic */ LayoutHierarchy(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i6, Map map, int i10, e eVar) {
            this(accessibilityNodeInfo, i, i6, (i10 & 8) != 0 ? a.M() : map);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lstepai/aios/guiexecutor/api/QueryResult$ScreenInfo;", "Lstepai/aios/guiexecutor/api/QueryResult;", "width", "", "height", "density", "", "orientation", "isScreenOn", "", "attributes", "", "", "", AppAgent.CONSTRUCT, "(IIFIZLjava/util/Map;)V", "getWidth", "()I", "getHeight", "getDensity", "()F", "getOrientation", "()Z", "getAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ScreenInfo extends QueryResult {
        private final Map<String, Object> attributes;
        private final float density;
        private final int height;
        private final boolean isScreenOn;
        private final int orientation;
        private final int width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenInfo(int i, int i6, float f, int i10, boolean z10, Map<String, ? extends Object> attributes) {
            super(null);
            k.f(attributes, "attributes");
            this.width = i;
            this.height = i6;
            this.density = f;
            this.orientation = i10;
            this.isScreenOn = z10;
            this.attributes = attributes;
        }

        public static /* synthetic */ ScreenInfo copy$default(ScreenInfo screenInfo, int i, int i6, float f, int i10, boolean z10, Map map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i = screenInfo.width;
            }
            if ((i11 & 2) != 0) {
                i6 = screenInfo.height;
            }
            if ((i11 & 4) != 0) {
                f = screenInfo.density;
            }
            if ((i11 & 8) != 0) {
                i10 = screenInfo.orientation;
            }
            if ((i11 & 16) != 0) {
                z10 = screenInfo.isScreenOn;
            }
            if ((i11 & 32) != 0) {
                map = screenInfo.attributes;
            }
            boolean z11 = z10;
            Map map2 = map;
            return screenInfo.copy(i, i6, f, i10, z11, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component3, reason: from getter */
        public final float getDensity() {
            return this.density;
        }

        /* renamed from: component4, reason: from getter */
        public final int getOrientation() {
            return this.orientation;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsScreenOn() {
            return this.isScreenOn;
        }

        public final Map<String, Object> component6() {
            return this.attributes;
        }

        public final ScreenInfo copy(int width, int height, float density, int orientation, boolean isScreenOn, Map<String, ? extends Object> attributes) {
            k.f(attributes, "attributes");
            return new ScreenInfo(width, height, density, orientation, isScreenOn, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScreenInfo)) {
                return false;
            }
            ScreenInfo screenInfo = (ScreenInfo) other;
            return this.width == screenInfo.width && this.height == screenInfo.height && Float.compare(this.density, screenInfo.density) == 0 && this.orientation == screenInfo.orientation && this.isScreenOn == screenInfo.isScreenOn && k.b(this.attributes, screenInfo.attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final float getDensity() {
            return this.density;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getOrientation() {
            return this.orientation;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return this.attributes.hashCode() + androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.orientation, androidx.appfunctions.metadata.a.b(this.density, androidx.constraintlayout.core.dsl.a.a(this.height, Integer.hashCode(this.width) * 31, 31), 31), 31), 31, this.isScreenOn);
        }

        public final boolean isScreenOn() {
            return this.isScreenOn;
        }

        public String toString() {
            int i = this.width;
            int i6 = this.height;
            float f = this.density;
            int i10 = this.orientation;
            boolean z10 = this.isScreenOn;
            Map<String, Object> map = this.attributes;
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "ScreenInfo(width=", i6, ", height=", ", density=");
            sbS.append(f);
            sbS.append(", orientation=");
            sbS.append(i10);
            sbS.append(", isScreenOn=");
            sbS.append(z10);
            sbS.append(", attributes=");
            sbS.append(map);
            sbS.append(")");
            return sbS.toString();
        }

        public /* synthetic */ ScreenInfo(int i, int i6, float f, int i10, boolean z10, Map map, int i11, e eVar) {
            this(i, i6, f, i10, z10, (i11 & 32) != 0 ? a.M() : map);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Jk\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lstepai/aios/guiexecutor/api/QueryResult$ElementInfo;", "Lstepai/aios/guiexecutor/api/QueryResult;", "bounds", "Landroid/graphics/Rect;", "text", "", "className", "contentDescription", "isClickable", "", "isEnabled", "isVisible", "attributes", "", "", AppAgent.CONSTRUCT, "(Landroid/graphics/Rect;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/util/Map;)V", "getBounds", "()Landroid/graphics/Rect;", "getText", "()Ljava/lang/String;", "getClassName", "getContentDescription", "()Z", "getAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ElementInfo extends QueryResult {
        private final Map<String, Object> attributes;
        private final Rect bounds;
        private final String className;
        private final String contentDescription;
        private final boolean isClickable;
        private final boolean isEnabled;
        private final boolean isVisible;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElementInfo(Rect bounds, String str, String str2, String str3, boolean z10, boolean z11, boolean z12, Map<String, ? extends Object> attributes) {
            super(null);
            k.f(bounds, "bounds");
            k.f(attributes, "attributes");
            this.bounds = bounds;
            this.text = str;
            this.className = str2;
            this.contentDescription = str3;
            this.isClickable = z10;
            this.isEnabled = z11;
            this.isVisible = z12;
            this.attributes = attributes;
        }

        public static /* synthetic */ ElementInfo copy$default(ElementInfo elementInfo, Rect rect, String str, String str2, String str3, boolean z10, boolean z11, boolean z12, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                rect = elementInfo.bounds;
            }
            if ((i & 2) != 0) {
                str = elementInfo.text;
            }
            if ((i & 4) != 0) {
                str2 = elementInfo.className;
            }
            if ((i & 8) != 0) {
                str3 = elementInfo.contentDescription;
            }
            if ((i & 16) != 0) {
                z10 = elementInfo.isClickable;
            }
            if ((i & 32) != 0) {
                z11 = elementInfo.isEnabled;
            }
            if ((i & 64) != 0) {
                z12 = elementInfo.isVisible;
            }
            if ((i & 128) != 0) {
                map = elementInfo.attributes;
            }
            boolean z13 = z12;
            Map map2 = map;
            boolean z14 = z10;
            boolean z15 = z11;
            return elementInfo.copy(rect, str, str2, str3, z14, z15, z13, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final Rect getBounds() {
            return this.bounds;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        /* renamed from: component4, reason: from getter */
        public final String getContentDescription() {
            return this.contentDescription;
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

        public final Map<String, Object> component8() {
            return this.attributes;
        }

        public final ElementInfo copy(Rect bounds, String text, String className, String contentDescription, boolean isClickable, boolean isEnabled, boolean isVisible, Map<String, ? extends Object> attributes) {
            k.f(bounds, "bounds");
            k.f(attributes, "attributes");
            return new ElementInfo(bounds, text, className, contentDescription, isClickable, isEnabled, isVisible, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ElementInfo)) {
                return false;
            }
            ElementInfo elementInfo = (ElementInfo) other;
            return k.b(this.bounds, elementInfo.bounds) && k.b(this.text, elementInfo.text) && k.b(this.className, elementInfo.className) && k.b(this.contentDescription, elementInfo.contentDescription) && this.isClickable == elementInfo.isClickable && this.isEnabled == elementInfo.isEnabled && this.isVisible == elementInfo.isVisible && k.b(this.attributes, elementInfo.attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final Rect getBounds() {
            return this.bounds;
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
            int iHashCode = this.bounds.hashCode() * 31;
            String str = this.text;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.className;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.contentDescription;
            return this.attributes.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31, 31, this.isClickable), 31, this.isEnabled), 31, this.isVisible);
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
            Rect rect = this.bounds;
            String str = this.text;
            String str2 = this.className;
            String str3 = this.contentDescription;
            boolean z10 = this.isClickable;
            boolean z11 = this.isEnabled;
            boolean z12 = this.isVisible;
            Map<String, Object> map = this.attributes;
            StringBuilder sb = new StringBuilder("ElementInfo(bounds=");
            sb.append(rect);
            sb.append(", text=");
            sb.append(str);
            sb.append(", className=");
            androidx.constraintlayout.core.dsl.a.A(sb, str2, ", contentDescription=", str3, ", isClickable=");
            sb.append(z10);
            sb.append(", isEnabled=");
            sb.append(z11);
            sb.append(", isVisible=");
            sb.append(z12);
            sb.append(", attributes=");
            sb.append(map);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ ElementInfo(Rect rect, String str, String str2, String str3, boolean z10, boolean z11, boolean z12, Map map, int i, e eVar) {
            this(rect, str, str2, str3, z10, z11, z12, (i & 128) != 0 ? a.M() : map);
        }
    }
}
