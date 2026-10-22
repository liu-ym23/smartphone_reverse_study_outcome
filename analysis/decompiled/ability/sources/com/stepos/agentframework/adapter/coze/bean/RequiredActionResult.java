package com.stepos.agentframework.adapter.coze.bean;

import androidx.annotation.Keep;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "", "submit_tool_outputs", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs;", "type", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs;Ljava/lang/String;)V", "getSubmit_tool_outputs", "()Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SubmitToolOutputs", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RequiredActionResult {
    private final SubmitToolOutputs submit_tool_outputs;
    private final String type;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs;", "", "tool_calls", "", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getTool_calls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ToolCall", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubmitToolOutputs {
        private final List<ToolCall> tool_calls;

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall;", "", "function", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall$Function;", "id", "", "require_info", "type", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall$Function;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getFunction", "()Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall$Function;", "getId", "()Ljava/lang/String;", "getRequire_info", "()Ljava/lang/Object;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Function", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToolCall {
            private final Function function;
            private final String id;
            private final Object require_info;
            private final String type;

            @Keep
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult$SubmitToolOutputs$ToolCall$Function;", "", "arguments", "", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getArguments", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class Function {
                private final String arguments;
                private final String name;

                public Function(String arguments, String name) {
                    k.f(arguments, "arguments");
                    k.f(name, "name");
                    this.arguments = arguments;
                    this.name = name;
                }

                public static /* synthetic */ Function copy$default(Function function, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = function.arguments;
                    }
                    if ((i & 2) != 0) {
                        str2 = function.name;
                    }
                    return function.copy(str, str2);
                }

                /* renamed from: component1, reason: from getter */
                public final String getArguments() {
                    return this.arguments;
                }

                /* renamed from: component2, reason: from getter */
                public final String getName() {
                    return this.name;
                }

                public final Function copy(String arguments, String name) {
                    k.f(arguments, "arguments");
                    k.f(name, "name");
                    return new Function(arguments, name);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Function)) {
                        return false;
                    }
                    Function function = (Function) other;
                    return k.b(this.arguments, function.arguments) && k.b(this.name, function.name);
                }

                public final String getArguments() {
                    return this.arguments;
                }

                public final String getName() {
                    return this.name;
                }

                public int hashCode() {
                    return this.name.hashCode() + (this.arguments.hashCode() * 31);
                }

                public String toString() {
                    return a.m("Function(arguments=", this.arguments, ", name=", this.name, ")");
                }
            }

            public ToolCall(Function function, String id, Object require_info, String type) {
                k.f(function, "function");
                k.f(id, "id");
                k.f(require_info, "require_info");
                k.f(type, "type");
                this.function = function;
                this.id = id;
                this.require_info = require_info;
                this.type = type;
            }

            public static /* synthetic */ ToolCall copy$default(ToolCall toolCall, Function function, String str, Object obj, String str2, int i, Object obj2) {
                if ((i & 1) != 0) {
                    function = toolCall.function;
                }
                if ((i & 2) != 0) {
                    str = toolCall.id;
                }
                if ((i & 4) != 0) {
                    obj = toolCall.require_info;
                }
                if ((i & 8) != 0) {
                    str2 = toolCall.type;
                }
                return toolCall.copy(function, str, obj, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final Function getFunction() {
                return this.function;
            }

            /* renamed from: component2, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component3, reason: from getter */
            public final Object getRequire_info() {
                return this.require_info;
            }

            /* renamed from: component4, reason: from getter */
            public final String getType() {
                return this.type;
            }

            public final ToolCall copy(Function function, String id, Object require_info, String type) {
                k.f(function, "function");
                k.f(id, "id");
                k.f(require_info, "require_info");
                k.f(type, "type");
                return new ToolCall(function, id, require_info, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ToolCall)) {
                    return false;
                }
                ToolCall toolCall = (ToolCall) other;
                return k.b(this.function, toolCall.function) && k.b(this.id, toolCall.id) && k.b(this.require_info, toolCall.require_info) && k.b(this.type, toolCall.type);
            }

            public final Function getFunction() {
                return this.function;
            }

            public final String getId() {
                return this.id;
            }

            public final Object getRequire_info() {
                return this.require_info;
            }

            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode() + ((this.require_info.hashCode() + B7.a.c(this.function.hashCode() * 31, 31, this.id)) * 31);
            }

            public String toString() {
                return "ToolCall(function=" + this.function + ", id=" + this.id + ", require_info=" + this.require_info + ", type=" + this.type + ")";
            }
        }

        public SubmitToolOutputs(List<ToolCall> tool_calls) {
            k.f(tool_calls, "tool_calls");
            this.tool_calls = tool_calls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubmitToolOutputs copy$default(SubmitToolOutputs submitToolOutputs, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = submitToolOutputs.tool_calls;
            }
            return submitToolOutputs.copy(list);
        }

        public final List<ToolCall> component1() {
            return this.tool_calls;
        }

        public final SubmitToolOutputs copy(List<ToolCall> tool_calls) {
            k.f(tool_calls, "tool_calls");
            return new SubmitToolOutputs(tool_calls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SubmitToolOutputs) && k.b(this.tool_calls, ((SubmitToolOutputs) other).tool_calls);
        }

        public final List<ToolCall> getTool_calls() {
            return this.tool_calls;
        }

        public int hashCode() {
            return this.tool_calls.hashCode();
        }

        public String toString() {
            return "SubmitToolOutputs(tool_calls=" + this.tool_calls + ")";
        }
    }

    public RequiredActionResult(SubmitToolOutputs submit_tool_outputs, String type) {
        k.f(submit_tool_outputs, "submit_tool_outputs");
        k.f(type, "type");
        this.submit_tool_outputs = submit_tool_outputs;
        this.type = type;
    }

    public static /* synthetic */ RequiredActionResult copy$default(RequiredActionResult requiredActionResult, SubmitToolOutputs submitToolOutputs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            submitToolOutputs = requiredActionResult.submit_tool_outputs;
        }
        if ((i & 2) != 0) {
            str = requiredActionResult.type;
        }
        return requiredActionResult.copy(submitToolOutputs, str);
    }

    /* renamed from: component1, reason: from getter */
    public final SubmitToolOutputs getSubmit_tool_outputs() {
        return this.submit_tool_outputs;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final RequiredActionResult copy(SubmitToolOutputs submit_tool_outputs, String type) {
        k.f(submit_tool_outputs, "submit_tool_outputs");
        k.f(type, "type");
        return new RequiredActionResult(submit_tool_outputs, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequiredActionResult)) {
            return false;
        }
        RequiredActionResult requiredActionResult = (RequiredActionResult) other;
        return k.b(this.submit_tool_outputs, requiredActionResult.submit_tool_outputs) && k.b(this.type, requiredActionResult.type);
    }

    public final SubmitToolOutputs getSubmit_tool_outputs() {
        return this.submit_tool_outputs;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + (this.submit_tool_outputs.hashCode() * 31);
    }

    public String toString() {
        return "RequiredActionResult(submit_tool_outputs=" + this.submit_tool_outputs + ", type=" + this.type + ")";
    }
}
