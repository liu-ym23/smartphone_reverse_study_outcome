package com.stepos.core.data;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u0013¨\u0006&"}, d2 = {"Lcom/stepos/core/data/LlmToolCall;", "Landroid/os/Parcelable;", "", "id", "name", "arguments", "function", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/core/data/LlmToolCall;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "getArguments", "getFunction", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LlmToolCall implements Parcelable {
    private final String arguments;
    private final String function;
    private final String id;
    private final String name;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<LlmToolCall> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/core/data/LlmToolCall$Companion;", "", "<init>", "()V", "parseFromOutput", "", "Lcom/stepos/core/data/LlmToolCall;", "output", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final List<LlmToolCall> parseFromOutput(String output) {
            p.i(output, "output");
            return C1173v.m();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LlmToolCall> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmToolCall createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new LlmToolCall(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmToolCall[] newArray(int i10) {
            return new LlmToolCall[i10];
        }
    }

    public LlmToolCall(String id, String name, String arguments, String function) {
        p.i(id, "id");
        p.i(name, "name");
        p.i(arguments, "arguments");
        p.i(function, "function");
        this.id = id;
        this.name = name;
        this.arguments = arguments;
        this.function = function;
    }

    public static /* synthetic */ LlmToolCall copy$default(LlmToolCall llmToolCall, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = llmToolCall.id;
        }
        if ((i10 & 2) != 0) {
            str2 = llmToolCall.name;
        }
        if ((i10 & 4) != 0) {
            str3 = llmToolCall.arguments;
        }
        if ((i10 & 8) != 0) {
            str4 = llmToolCall.function;
        }
        return llmToolCall.copy(str, str2, str3, str4);
    }

    public static final List<LlmToolCall> parseFromOutput(String str) {
        return INSTANCE.parseFromOutput(str);
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
        p.i(id, "id");
        p.i(name, "name");
        p.i(arguments, "arguments");
        p.i(function, "function");
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
        return p.d(this.id, llmToolCall.id) && p.d(this.name, llmToolCall.name) && p.d(this.arguments, llmToolCall.arguments) && p.d(this.function, llmToolCall.function);
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
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.arguments.hashCode()) * 31) + this.function.hashCode();
    }

    public String toString() {
        return "LlmToolCall(id=" + this.id + ", name=" + this.name + ", arguments=" + this.arguments + ", function=" + this.function + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.arguments);
        dest.writeString(this.function);
    }

    public /* synthetic */ LlmToolCall(String str, String str2, String str3, String str4, int i10, i iVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? str2 : str4);
    }
}
