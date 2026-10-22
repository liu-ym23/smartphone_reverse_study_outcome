package com.stepos.core.data;

import B7.a;
import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import d5.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u0013¨\u0006'"}, d2 = {"Lcom/stepos/core/data/LlmToolCall;", "Landroid/os/Parcelable;", "", "id", HintConstants.AUTOFILL_HINT_NAME, "arguments", "function", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/core/data/LlmToolCall;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "getArguments", "getFunction", "Companion", "d5/q", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LlmToolCall implements Parcelable {
    private final String arguments;
    private final String function;
    private final String id;
    private final String name;
    public static final q Companion = new q();
    public static final Parcelable.Creator<LlmToolCall> CREATOR = new g(16);

    public LlmToolCall(String id, String name, String arguments, String function) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(arguments, "arguments");
        k.f(function, "function");
        this.id = id;
        this.name = name;
        this.arguments = arguments;
        this.function = function;
    }

    public static /* synthetic */ LlmToolCall copy$default(LlmToolCall llmToolCall, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = llmToolCall.id;
        }
        if ((i & 2) != 0) {
            str2 = llmToolCall.name;
        }
        if ((i & 4) != 0) {
            str3 = llmToolCall.arguments;
        }
        if ((i & 8) != 0) {
            str4 = llmToolCall.function;
        }
        return llmToolCall.copy(str, str2, str3, str4);
    }

    public static final List<LlmToolCall> parseFromOutput(String output) {
        Companion.getClass();
        k.f(output, "output");
        return EmptyList.f4893a;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFunction() {
        return this.function;
    }

    public final LlmToolCall copy(String id, String name, String arguments, String function) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(arguments, "arguments");
        k.f(function, "function");
        return new LlmToolCall(id, name, arguments, function);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmToolCall)) {
            return false;
        }
        LlmToolCall llmToolCall = (LlmToolCall) other;
        return k.b(this.id, llmToolCall.id) && k.b(this.name, llmToolCall.name) && k.b(this.arguments, llmToolCall.arguments) && k.b(this.function, llmToolCall.function);
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getFunction() {
        return this.function;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.function.hashCode() + a.c(a.c(this.id.hashCode() * 31, 31, this.name), 31, this.arguments);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        return androidx.appfunctions.metadata.a.p(a.w("LlmToolCall(id=", str, ", name=", str2, ", arguments="), this.arguments, ", function=", this.function, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.arguments);
        dest.writeString(this.function);
    }

    public /* synthetic */ LlmToolCall(String str, String str2, String str3, String str4, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? str2 : str4);
    }
}
