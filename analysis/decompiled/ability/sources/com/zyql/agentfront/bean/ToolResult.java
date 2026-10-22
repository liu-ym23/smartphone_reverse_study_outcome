package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import k7.x;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0011¨\u0006!"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResult;", "Landroid/os/Parcelable;", "Lcom/zyql/agentfront/bean/ToolContent;", "result", AppAgent.CONSTRUCT, "(Lcom/zyql/agentfront/bean/ToolContent;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lcom/zyql/agentfront/bean/ToolContent;", "copy", "(Lcom/zyql/agentfront/bean/ToolContent;)Lcom/zyql/agentfront/bean/ToolResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/zyql/agentfront/bean/ToolContent;", "getResult", "CREATOR", "k7/x", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolResult implements Parcelable {
    public static final x CREATOR = new x();
    private final ToolContent result;

    public ToolResult(ToolContent result) {
        k.f(result, "result");
        this.result = result;
    }

    public static /* synthetic */ ToolResult copy$default(ToolResult toolResult, ToolContent toolContent, int i, Object obj) {
        if ((i & 1) != 0) {
            toolContent = toolResult.result;
        }
        return toolResult.copy(toolContent);
    }

    /* renamed from: component1, reason: from getter */
    public final ToolContent getResult() {
        return this.result;
    }

    public final ToolResult copy(ToolContent result) {
        k.f(result, "result");
        return new ToolResult(result);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ToolResult) && k.b(this.result, ((ToolResult) other).result);
    }

    public final ToolContent getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "ToolResult(result=" + this.result + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeParcelable(this.result, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolResult(Parcel parcel) {
        k.f(parcel, "parcel");
        ToolContent toolContent = (ToolContent) parcel.readParcelable(ToolContent.class.getClassLoader());
        this(toolContent == null ? new ToolContent(EmptyList.f4893a, false) : toolContent);
    }
}
