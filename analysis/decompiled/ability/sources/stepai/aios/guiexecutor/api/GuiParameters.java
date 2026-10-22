package stepai.aios.guiexecutor.api;

import B7.a;
import android.graphics.Point;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters;", "", AppAgent.CONSTRUCT, "()V", "TouchParams", "InputParams", "GestureParams", "WaitParams", "QueryParams", "TakeoverParams", "AwakeParams", "TaskParams", "SystemNavigationParams", "ScrollParams", "KeyParams", "Lstepai/aios/guiexecutor/api/GuiParameters$AwakeParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$GestureParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$InputParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$KeyParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$QueryParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$ScrollParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$SystemNavigationParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$TakeoverParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$TaskParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$TouchParams;", "Lstepai/aios/guiexecutor/api/GuiParameters$WaitParams;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class GuiParameters {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$SystemNavigationParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiexecutor/api/SystemNavigationAction;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/SystemNavigationAction;)V", "getAction", "()Lstepai/aios/guiexecutor/api/SystemNavigationAction;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SystemNavigationParams extends GuiParameters {
        private final SystemNavigationAction action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemNavigationParams(SystemNavigationAction action) {
            super(null);
            k.f(action, "action");
            this.action = action;
        }

        public static /* synthetic */ SystemNavigationParams copy$default(SystemNavigationParams systemNavigationParams, SystemNavigationAction systemNavigationAction, int i, Object obj) {
            if ((i & 1) != 0) {
                systemNavigationAction = systemNavigationParams.action;
            }
            return systemNavigationParams.copy(systemNavigationAction);
        }

        /* renamed from: component1, reason: from getter */
        public final SystemNavigationAction getAction() {
            return this.action;
        }

        public final SystemNavigationParams copy(SystemNavigationAction action) {
            k.f(action, "action");
            return new SystemNavigationParams(action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SystemNavigationParams) && this.action == ((SystemNavigationParams) other).action;
        }

        public final SystemNavigationAction getAction() {
            return this.action;
        }

        public int hashCode() {
            return this.action.hashCode();
        }

        public String toString() {
            return "SystemNavigationParams(action=" + this.action + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$TakeoverParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "reason", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TakeoverParams extends GuiParameters {
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TakeoverParams(String reason) {
            super(null);
            k.f(reason, "reason");
            this.reason = reason;
        }

        public static /* synthetic */ TakeoverParams copy$default(TakeoverParams takeoverParams, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = takeoverParams.reason;
            }
            return takeoverParams.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final TakeoverParams copy(String reason) {
            k.f(reason, "reason");
            return new TakeoverParams(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TakeoverParams) && k.b(this.reason, ((TakeoverParams) other).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return a.m("TakeoverParams(reason=", this.reason, ")");
        }
    }

    public /* synthetic */ GuiParameters(e eVar) {
        this();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$QueryParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "queryType", "Lstepai/aios/guiexecutor/api/QueryType;", "attributes", "", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/QueryType;Ljava/util/Set;)V", "getQueryType", "()Lstepai/aios/guiexecutor/api/QueryType;", "getAttributes", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class QueryParams extends GuiParameters {
        private final Set<String> attributes;
        private final QueryType queryType;

        public QueryParams(QueryType queryType, Set set, int i, e eVar) {
            this(queryType, (i & 2) != 0 ? EmptySet.f4895a : set);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ QueryParams copy$default(QueryParams queryParams, QueryType queryType, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                queryType = queryParams.queryType;
            }
            if ((i & 2) != 0) {
                set = queryParams.attributes;
            }
            return queryParams.copy(queryType, set);
        }

        /* renamed from: component1, reason: from getter */
        public final QueryType getQueryType() {
            return this.queryType;
        }

        public final Set<String> component2() {
            return this.attributes;
        }

        public final QueryParams copy(QueryType queryType, Set<String> attributes) {
            k.f(queryType, "queryType");
            k.f(attributes, "attributes");
            return new QueryParams(queryType, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueryParams)) {
                return false;
            }
            QueryParams queryParams = (QueryParams) other;
            return this.queryType == queryParams.queryType && k.b(this.attributes, queryParams.attributes);
        }

        public final Set<String> getAttributes() {
            return this.attributes;
        }

        public final QueryType getQueryType() {
            return this.queryType;
        }

        public int hashCode() {
            return this.attributes.hashCode() + (this.queryType.hashCode() * 31);
        }

        public String toString() {
            return "QueryParams(queryType=" + this.queryType + ", attributes=" + this.attributes + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QueryParams(QueryType queryType, Set<String> attributes) {
            super(null);
            k.f(queryType, "queryType");
            k.f(attributes, "attributes");
            this.queryType = queryType;
            this.attributes = attributes;
        }
    }

    private GuiParameters() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$KeyParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "keyCode", "", "metaState", AppAgent.CONSTRUCT, "(II)V", "getKeyCode", "()I", "getMetaState", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class KeyParams extends GuiParameters {
        private final int keyCode;
        private final int metaState;

        public KeyParams(int i, int i6) {
            super(null);
            this.keyCode = i;
            this.metaState = i6;
        }

        public static /* synthetic */ KeyParams copy$default(KeyParams keyParams, int i, int i6, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i = keyParams.keyCode;
            }
            if ((i10 & 2) != 0) {
                i6 = keyParams.metaState;
            }
            return keyParams.copy(i, i6);
        }

        /* renamed from: component1, reason: from getter */
        public final int getKeyCode() {
            return this.keyCode;
        }

        /* renamed from: component2, reason: from getter */
        public final int getMetaState() {
            return this.metaState;
        }

        public final KeyParams copy(int keyCode, int metaState) {
            return new KeyParams(keyCode, metaState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KeyParams)) {
                return false;
            }
            KeyParams keyParams = (KeyParams) other;
            return this.keyCode == keyParams.keyCode && this.metaState == keyParams.metaState;
        }

        public final int getKeyCode() {
            return this.keyCode;
        }

        public final int getMetaState() {
            return this.metaState;
        }

        public int hashCode() {
            return Integer.hashCode(this.metaState) + (Integer.hashCode(this.keyCode) * 31);
        }

        public String toString() {
            return b.o(this.keyCode, "KeyParams(keyCode=", this.metaState, ", metaState=", ")");
        }

        public /* synthetic */ KeyParams(int i, int i6, int i10, e eVar) {
            this(i, (i10 & 2) != 0 ? 0 : i6);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$TouchParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiexecutor/api/TouchAction;", "tapCount", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/TouchAction;I)V", "getAction", "()Lstepai/aios/guiexecutor/api/TouchAction;", "getTapCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TouchParams extends GuiParameters {
        private final TouchAction action;
        private final int tapCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchParams(TouchAction action, int i) {
            super(null);
            k.f(action, "action");
            this.action = action;
            this.tapCount = i;
        }

        public static /* synthetic */ TouchParams copy$default(TouchParams touchParams, TouchAction touchAction, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                touchAction = touchParams.action;
            }
            if ((i6 & 2) != 0) {
                i = touchParams.tapCount;
            }
            return touchParams.copy(touchAction, i);
        }

        /* renamed from: component1, reason: from getter */
        public final TouchAction getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTapCount() {
            return this.tapCount;
        }

        public final TouchParams copy(TouchAction action, int tapCount) {
            k.f(action, "action");
            return new TouchParams(action, tapCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TouchParams)) {
                return false;
            }
            TouchParams touchParams = (TouchParams) other;
            return this.action == touchParams.action && this.tapCount == touchParams.tapCount;
        }

        public final TouchAction getAction() {
            return this.action;
        }

        public final int getTapCount() {
            return this.tapCount;
        }

        public int hashCode() {
            return Integer.hashCode(this.tapCount) + (this.action.hashCode() * 31);
        }

        public String toString() {
            return "TouchParams(action=" + this.action + ", tapCount=" + this.tapCount + ")";
        }

        public /* synthetic */ TouchParams(TouchAction touchAction, int i, int i6, e eVar) {
            this(touchAction, (i6 & 2) != 0 ? 1 : i);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$WaitParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", TypedValues.TransitionType.S_DURATION, "", "condition", "Lstepai/aios/guiexecutor/api/WaitCondition;", AppAgent.CONSTRUCT, "(JLstepai/aios/guiexecutor/api/WaitCondition;)V", "getDuration", "()J", "getCondition", "()Lstepai/aios/guiexecutor/api/WaitCondition;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class WaitParams extends GuiParameters {
        private final WaitCondition condition;
        private final long duration;

        public WaitParams(long j5, WaitCondition waitCondition) {
            super(null);
            this.duration = j5;
            this.condition = waitCondition;
        }

        public static /* synthetic */ WaitParams copy$default(WaitParams waitParams, long j5, WaitCondition waitCondition, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = waitParams.duration;
            }
            if ((i & 2) != 0) {
                waitCondition = waitParams.condition;
            }
            return waitParams.copy(j5, waitCondition);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component2, reason: from getter */
        public final WaitCondition getCondition() {
            return this.condition;
        }

        public final WaitParams copy(long duration, WaitCondition condition) {
            return new WaitParams(duration, condition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaitParams)) {
                return false;
            }
            WaitParams waitParams = (WaitParams) other;
            return this.duration == waitParams.duration && k.b(this.condition, waitParams.condition);
        }

        public final WaitCondition getCondition() {
            return this.condition;
        }

        public final long getDuration() {
            return this.duration;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.duration) * 31;
            WaitCondition waitCondition = this.condition;
            return iHashCode + (waitCondition == null ? 0 : waitCondition.hashCode());
        }

        public String toString() {
            return "WaitParams(duration=" + this.duration + ", condition=" + this.condition + ")";
        }

        public /* synthetic */ WaitParams(long j5, WaitCondition waitCondition, int i, e eVar) {
            this(j5, (i & 2) != 0 ? null : waitCondition);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$AwakeParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiexecutor/api/AwakeAction;", "packageName", "", "launchType", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/AwakeAction;Ljava/lang/String;I)V", "getAction", "()Lstepai/aios/guiexecutor/api/AwakeAction;", "getPackageName", "()Ljava/lang/String;", "getLaunchType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AwakeParams extends GuiParameters {
        private final AwakeAction action;
        private final int launchType;
        private final String packageName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AwakeParams(AwakeAction action, String packageName, int i) {
            super(null);
            k.f(action, "action");
            k.f(packageName, "packageName");
            this.action = action;
            this.packageName = packageName;
            this.launchType = i;
        }

        public static /* synthetic */ AwakeParams copy$default(AwakeParams awakeParams, AwakeAction awakeAction, String str, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                awakeAction = awakeParams.action;
            }
            if ((i6 & 2) != 0) {
                str = awakeParams.packageName;
            }
            if ((i6 & 4) != 0) {
                i = awakeParams.launchType;
            }
            return awakeParams.copy(awakeAction, str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final AwakeAction getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getLaunchType() {
            return this.launchType;
        }

        public final AwakeParams copy(AwakeAction action, String packageName, int launchType) {
            k.f(action, "action");
            k.f(packageName, "packageName");
            return new AwakeParams(action, packageName, launchType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AwakeParams)) {
                return false;
            }
            AwakeParams awakeParams = (AwakeParams) other;
            return this.action == awakeParams.action && k.b(this.packageName, awakeParams.packageName) && this.launchType == awakeParams.launchType;
        }

        public final AwakeAction getAction() {
            return this.action;
        }

        public final int getLaunchType() {
            return this.launchType;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public int hashCode() {
            return Integer.hashCode(this.launchType) + a.c(this.action.hashCode() * 31, 31, this.packageName);
        }

        public String toString() {
            AwakeAction awakeAction = this.action;
            String str = this.packageName;
            int i = this.launchType;
            StringBuilder sb = new StringBuilder("AwakeParams(action=");
            sb.append(awakeAction);
            sb.append(", packageName=");
            sb.append(str);
            sb.append(", launchType=");
            return androidx.appfunctions.metadata.a.o(sb, ")", i);
        }

        public /* synthetic */ AwakeParams(AwakeAction awakeAction, String str, int i, int i6, e eVar) {
            this((i6 & 1) != 0 ? AwakeAction.LAUNCH_APP : awakeAction, str, (i6 & 4) != 0 ? 0 : i);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$ScrollParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "direction", "Lstepai/aios/guiexecutor/api/ScrollDirection;", "distance", "", TypedValues.TransitionType.S_DURATION, "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/ScrollDirection;IJ)V", "getDirection", "()Lstepai/aios/guiexecutor/api/ScrollDirection;", "getDistance", "()I", "getDuration", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ScrollParams extends GuiParameters {
        private final ScrollDirection direction;
        private final int distance;
        private final long duration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollParams(ScrollDirection direction, int i, long j5) {
            super(null);
            k.f(direction, "direction");
            this.direction = direction;
            this.distance = i;
            this.duration = j5;
        }

        public static /* synthetic */ ScrollParams copy$default(ScrollParams scrollParams, ScrollDirection scrollDirection, int i, long j5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                scrollDirection = scrollParams.direction;
            }
            if ((i6 & 2) != 0) {
                i = scrollParams.distance;
            }
            if ((i6 & 4) != 0) {
                j5 = scrollParams.duration;
            }
            return scrollParams.copy(scrollDirection, i, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final ScrollDirection getDirection() {
            return this.direction;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDistance() {
            return this.distance;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public final ScrollParams copy(ScrollDirection direction, int distance, long duration) {
            k.f(direction, "direction");
            return new ScrollParams(direction, distance, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollParams)) {
                return false;
            }
            ScrollParams scrollParams = (ScrollParams) other;
            return this.direction == scrollParams.direction && this.distance == scrollParams.distance && this.duration == scrollParams.duration;
        }

        public final ScrollDirection getDirection() {
            return this.direction;
        }

        public final int getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public int hashCode() {
            return Long.hashCode(this.duration) + androidx.constraintlayout.core.dsl.a.a(this.distance, this.direction.hashCode() * 31, 31);
        }

        public String toString() {
            ScrollDirection scrollDirection = this.direction;
            int i = this.distance;
            long j5 = this.duration;
            StringBuilder sb = new StringBuilder("ScrollParams(direction=");
            sb.append(scrollDirection);
            sb.append(", distance=");
            sb.append(i);
            sb.append(", duration=");
            return androidx.constraintlayout.core.dsl.a.e(j5, ")", sb);
        }

        public /* synthetic */ ScrollParams(ScrollDirection scrollDirection, int i, long j5, int i6, e eVar) {
            this(scrollDirection, i, (i6 & 4) != 0 ? 300L : j5);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$TaskParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiexecutor/api/TaskAction;", "message", "", "result", "", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/TaskAction;Ljava/lang/String;Ljava/util/Map;)V", "getAction", "()Lstepai/aios/guiexecutor/api/TaskAction;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskParams extends GuiParameters {
        private final TaskAction action;
        private final String message;
        private final Map<String, Object> result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskParams(TaskAction action, String str, Map<String, ? extends Object> map) {
            super(null);
            k.f(action, "action");
            this.action = action;
            this.message = str;
            this.result = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TaskParams copy$default(TaskParams taskParams, TaskAction taskAction, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                taskAction = taskParams.action;
            }
            if ((i & 2) != 0) {
                str = taskParams.message;
            }
            if ((i & 4) != 0) {
                map = taskParams.result;
            }
            return taskParams.copy(taskAction, str, map);
        }

        /* renamed from: component1, reason: from getter */
        public final TaskAction getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> component3() {
            return this.result;
        }

        public final TaskParams copy(TaskAction action, String message, Map<String, ? extends Object> result) {
            k.f(action, "action");
            return new TaskParams(action, message, result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskParams)) {
                return false;
            }
            TaskParams taskParams = (TaskParams) other;
            return this.action == taskParams.action && k.b(this.message, taskParams.message) && k.b(this.result, taskParams.result);
        }

        public final TaskAction getAction() {
            return this.action;
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> getResult() {
            return this.result;
        }

        public int hashCode() {
            int iHashCode = this.action.hashCode() * 31;
            String str = this.message;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Map<String, Object> map = this.result;
            return iHashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "TaskParams(action=" + this.action + ", message=" + this.message + ", result=" + this.result + ")";
        }

        public /* synthetic */ TaskParams(TaskAction taskAction, String str, Map map, int i, e eVar) {
            this(taskAction, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$InputParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "text", "", "clearBefore", "", "inputMethod", "Lstepai/aios/guiexecutor/api/InputMethod;", "appendMode", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLstepai/aios/guiexecutor/api/InputMethod;Z)V", "getText", "()Ljava/lang/String;", "getClearBefore", "()Z", "getInputMethod", "()Lstepai/aios/guiexecutor/api/InputMethod;", "getAppendMode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InputParams extends GuiParameters {
        private final boolean appendMode;
        private final boolean clearBefore;
        private final InputMethod inputMethod;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputParams(String text, boolean z10, InputMethod inputMethod, boolean z11) {
            super(null);
            k.f(text, "text");
            k.f(inputMethod, "inputMethod");
            this.text = text;
            this.clearBefore = z10;
            this.inputMethod = inputMethod;
            this.appendMode = z11;
        }

        public static /* synthetic */ InputParams copy$default(InputParams inputParams, String str, boolean z10, InputMethod inputMethod, boolean z11, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputParams.text;
            }
            if ((i & 2) != 0) {
                z10 = inputParams.clearBefore;
            }
            if ((i & 4) != 0) {
                inputMethod = inputParams.inputMethod;
            }
            if ((i & 8) != 0) {
                z11 = inputParams.appendMode;
            }
            return inputParams.copy(str, z10, inputMethod, z11);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getClearBefore() {
            return this.clearBefore;
        }

        /* renamed from: component3, reason: from getter */
        public final InputMethod getInputMethod() {
            return this.inputMethod;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAppendMode() {
            return this.appendMode;
        }

        public final InputParams copy(String text, boolean clearBefore, InputMethod inputMethod, boolean appendMode) {
            k.f(text, "text");
            k.f(inputMethod, "inputMethod");
            return new InputParams(text, clearBefore, inputMethod, appendMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputParams)) {
                return false;
            }
            InputParams inputParams = (InputParams) other;
            return k.b(this.text, inputParams.text) && this.clearBefore == inputParams.clearBefore && this.inputMethod == inputParams.inputMethod && this.appendMode == inputParams.appendMode;
        }

        public final boolean getAppendMode() {
            return this.appendMode;
        }

        public final boolean getClearBefore() {
            return this.clearBefore;
        }

        public final InputMethod getInputMethod() {
            return this.inputMethod;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Boolean.hashCode(this.appendMode) + ((this.inputMethod.hashCode() + androidx.appfunctions.metadata.a.d(this.text.hashCode() * 31, 31, this.clearBefore)) * 31);
        }

        public String toString() {
            String str = this.text;
            boolean z10 = this.clearBefore;
            InputMethod inputMethod = this.inputMethod;
            boolean z11 = this.appendMode;
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("InputParams(text=", str, ", clearBefore=", ", inputMethod=", z10);
            sbL.append(inputMethod);
            sbL.append(", appendMode=");
            sbL.append(z11);
            sbL.append(")");
            return sbL.toString();
        }

        public /* synthetic */ InputParams(String str, boolean z10, InputMethod inputMethod, boolean z11, int i, e eVar) {
            this(str, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? InputMethod.ACCESSIBILITY : inputMethod, (i & 8) != 0 ? false : z11);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lstepai/aios/guiexecutor/api/GuiParameters$GestureParams;", "Lstepai/aios/guiexecutor/api/GuiParameters;", "gestureType", "Lstepai/aios/guiexecutor/api/GestureType;", "startPoint", "Landroid/graphics/Point;", "endPoint", TypedValues.TransitionType.S_DURATION, "", "steps", "", "velocity", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/GestureType;Landroid/graphics/Point;Landroid/graphics/Point;JIF)V", "getGestureType", "()Lstepai/aios/guiexecutor/api/GestureType;", "getStartPoint", "()Landroid/graphics/Point;", "getEndPoint", "getDuration", "()J", "getSteps", "()I", "getVelocity", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GestureParams extends GuiParameters {
        private final long duration;
        private final Point endPoint;
        private final GestureType gestureType;
        private final Point startPoint;
        private final int steps;
        private final float velocity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GestureParams(GestureType gestureType, Point startPoint, Point endPoint, long j5, int i, float f) {
            super(null);
            k.f(gestureType, "gestureType");
            k.f(startPoint, "startPoint");
            k.f(endPoint, "endPoint");
            this.gestureType = gestureType;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.duration = j5;
            this.steps = i;
            this.velocity = f;
        }

        public static /* synthetic */ GestureParams copy$default(GestureParams gestureParams, GestureType gestureType, Point point, Point point2, long j5, int i, float f, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                gestureType = gestureParams.gestureType;
            }
            if ((i6 & 2) != 0) {
                point = gestureParams.startPoint;
            }
            if ((i6 & 4) != 0) {
                point2 = gestureParams.endPoint;
            }
            if ((i6 & 8) != 0) {
                j5 = gestureParams.duration;
            }
            if ((i6 & 16) != 0) {
                i = gestureParams.steps;
            }
            if ((i6 & 32) != 0) {
                f = gestureParams.velocity;
            }
            long j6 = j5;
            Point point3 = point2;
            return gestureParams.copy(gestureType, point, point3, j6, i, f);
        }

        /* renamed from: component1, reason: from getter */
        public final GestureType getGestureType() {
            return this.gestureType;
        }

        /* renamed from: component2, reason: from getter */
        public final Point getStartPoint() {
            return this.startPoint;
        }

        /* renamed from: component3, reason: from getter */
        public final Point getEndPoint() {
            return this.endPoint;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component5, reason: from getter */
        public final int getSteps() {
            return this.steps;
        }

        /* renamed from: component6, reason: from getter */
        public final float getVelocity() {
            return this.velocity;
        }

        public final GestureParams copy(GestureType gestureType, Point startPoint, Point endPoint, long duration, int steps, float velocity) {
            k.f(gestureType, "gestureType");
            k.f(startPoint, "startPoint");
            k.f(endPoint, "endPoint");
            return new GestureParams(gestureType, startPoint, endPoint, duration, steps, velocity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GestureParams)) {
                return false;
            }
            GestureParams gestureParams = (GestureParams) other;
            return this.gestureType == gestureParams.gestureType && k.b(this.startPoint, gestureParams.startPoint) && k.b(this.endPoint, gestureParams.endPoint) && this.duration == gestureParams.duration && this.steps == gestureParams.steps && Float.compare(this.velocity, gestureParams.velocity) == 0;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final Point getEndPoint() {
            return this.endPoint;
        }

        public final GestureType getGestureType() {
            return this.gestureType;
        }

        public final Point getStartPoint() {
            return this.startPoint;
        }

        public final int getSteps() {
            return this.steps;
        }

        public final float getVelocity() {
            return this.velocity;
        }

        public int hashCode() {
            return Float.hashCode(this.velocity) + androidx.constraintlayout.core.dsl.a.a(this.steps, androidx.appfunctions.metadata.a.c((this.endPoint.hashCode() + ((this.startPoint.hashCode() + (this.gestureType.hashCode() * 31)) * 31)) * 31, 31, this.duration), 31);
        }

        public String toString() {
            return "GestureParams(gestureType=" + this.gestureType + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + ", duration=" + this.duration + ", steps=" + this.steps + ", velocity=" + this.velocity + ")";
        }

        public /* synthetic */ GestureParams(GestureType gestureType, Point point, Point point2, long j5, int i, float f, int i6, e eVar) {
            this(gestureType, point, point2, (i6 & 8) != 0 ? 300L : j5, (i6 & 16) != 0 ? 10 : i, (i6 & 32) != 0 ? 1.0f : f);
        }
    }
}
