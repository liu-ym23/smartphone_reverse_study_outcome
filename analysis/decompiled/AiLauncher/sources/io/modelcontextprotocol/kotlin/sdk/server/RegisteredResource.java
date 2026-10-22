package io.modelcontextprotocol.kotlin.sdk.server;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceRequest;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceResult;
import io.modelcontextprotocol.kotlin.sdk.Resource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR3\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredResource;", "", "Lio/modelcontextprotocol/kotlin/sdk/Resource;", "resource", "Lkotlin/Function2;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;", "Le9/c;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceResult;", "readHandler", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Resource;Lp9/p;)V", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Resource;", "component2", "()Lp9/p;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Resource;Lp9/p;)Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredResource;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Resource;", "getResource", "Lp9/p;", "getReadHandler", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegisteredResource {
    private final p9.p<ReadResourceRequest, InterfaceC4014c<? super ReadResourceResult>, Object> readHandler;
    private final Resource resource;

    /* JADX WARN: Multi-variable type inference failed */
    public RegisteredResource(Resource resource, p9.p<? super ReadResourceRequest, ? super InterfaceC4014c<? super ReadResourceResult>, ? extends Object> readHandler) {
        kotlin.jvm.internal.p.i(resource, "resource");
        kotlin.jvm.internal.p.i(readHandler, "readHandler");
        this.resource = resource;
        this.readHandler = readHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisteredResource copy$default(RegisteredResource registeredResource, Resource resource, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            resource = registeredResource.resource;
        }
        if ((i10 & 2) != 0) {
            pVar = registeredResource.readHandler;
        }
        return registeredResource.copy(resource, pVar);
    }

    /* renamed from: component1, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    public final p9.p<ReadResourceRequest, InterfaceC4014c<? super ReadResourceResult>, Object> component2() {
        return this.readHandler;
    }

    public final RegisteredResource copy(Resource resource, p9.p<? super ReadResourceRequest, ? super InterfaceC4014c<? super ReadResourceResult>, ? extends Object> readHandler) {
        kotlin.jvm.internal.p.i(resource, "resource");
        kotlin.jvm.internal.p.i(readHandler, "readHandler");
        return new RegisteredResource(resource, readHandler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisteredResource)) {
            return false;
        }
        RegisteredResource registeredResource = (RegisteredResource) other;
        return kotlin.jvm.internal.p.d(this.resource, registeredResource.resource) && kotlin.jvm.internal.p.d(this.readHandler, registeredResource.readHandler);
    }

    public final p9.p<ReadResourceRequest, InterfaceC4014c<? super ReadResourceResult>, Object> getReadHandler() {
        return this.readHandler;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public int hashCode() {
        return (this.resource.hashCode() * 31) + this.readHandler.hashCode();
    }

    public String toString() {
        return "RegisteredResource(resource=" + this.resource + ", readHandler=" + this.readHandler + ')';
    }
}
