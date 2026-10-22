package com.stepos.core.data;

import ai.onnxruntime.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LlmToolCall implements Parcelable {
    private final String arguments;
    private final String function;

    /* renamed from: id, reason: collision with root package name */
    private final String f7406id;
    private final String name;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<LlmToolCall> CREATOR = new Creator();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final List<LlmToolCall> parseFromOutput(String output) {
            g.f(output, "output");
            return EmptyList.f10001a;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<LlmToolCall> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmToolCall createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new LlmToolCall(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmToolCall[] newArray(int i10) {
            return new LlmToolCall[i10];
        }
    }

    public LlmToolCall(String id2, String name, String arguments, String function) {
        g.f(id2, "id");
        g.f(name, "name");
        g.f(arguments, "arguments");
        g.f(function, "function");
        this.f7406id = id2;
        this.name = name;
        this.arguments = arguments;
        this.function = function;
    }

    public static /* synthetic */ LlmToolCall copy$default(LlmToolCall llmToolCall, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = llmToolCall.f7406id;
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
        return Companion.parseFromOutput(str);
    }

    public final String component1() {
        return this.f7406id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.arguments;
    }

    public final String component4() {
        return this.function;
    }

    public final LlmToolCall copy(String id2, String name, String arguments, String function) {
        g.f(id2, "id");
        g.f(name, "name");
        g.f(arguments, "arguments");
        g.f(function, "function");
        return new LlmToolCall(id2, name, arguments, function);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LlmToolCall)) {
            return false;
        }
        LlmToolCall llmToolCall = (LlmToolCall) obj;
        return g.b(this.f7406id, llmToolCall.f7406id) && g.b(this.name, llmToolCall.name) && g.b(this.arguments, llmToolCall.arguments) && g.b(this.function, llmToolCall.function);
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getFunction() {
        return this.function;
    }

    public final String getId() {
        return this.f7406id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.function.hashCode() + d.a(d.a(this.f7406id.hashCode() * 31, 31, this.name), 31, this.arguments);
    }

    public String toString() {
        String str = this.f7406id;
        String str2 = this.name;
        return com.stepos.core.ota.d.j(a.s("LlmToolCall(id=", str, ", name=", str2, ", arguments="), this.arguments, ", function=", this.function, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.f7406id);
        dest.writeString(this.name);
        dest.writeString(this.arguments);
        dest.writeString(this.function);
    }

    public /* synthetic */ LlmToolCall(String str, String str2, String str3, String str4, int i10, e eVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? str2 : str4);
    }
}
