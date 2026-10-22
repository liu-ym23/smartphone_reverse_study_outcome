package stepai.aios.guiexecutor.core;

import J7.c;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.zyql.agentfront.bean.ToolContent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiResource;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lstepai/aios/guiexecutor/core/GuiResourceScheduler;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "", WindowStateInfo.KEY_DISPLAY_ID, "", "Lstepai/aios/guiexecutor/api/GuiResource;", "resources", "Lkotlin/Function1;", "LH7/c;", "block", "withResources", "(ILjava/util/Set;LS7/k;LH7/c;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lstepai/aios/guiexecutor/core/GuiResourceScheduler$ResourceKey;", "Lw9/a;", "locks", "Ljava/util/concurrent/ConcurrentHashMap;", "ResourceKey", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiResourceScheduler {
    private final ConcurrentHashMap<ResourceKey, InterfaceC2108a> locks = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lstepai/aios/guiexecutor/core/GuiResourceScheduler$ResourceKey;", "", WindowStateInfo.KEY_DISPLAY_ID, "", ToolContent.TYPE_RESOURCE, "Lstepai/aios/guiexecutor/api/GuiResource;", AppAgent.CONSTRUCT, "(ILstepai/aios/guiexecutor/api/GuiResource;)V", "getDisplayId", "()I", "getResource", "()Lstepai/aios/guiexecutor/api/GuiResource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ResourceKey {
        private final int displayId;
        private final GuiResource resource;

        public ResourceKey(int i, GuiResource resource) {
            k.f(resource, "resource");
            this.displayId = i;
            this.resource = resource;
        }

        public static /* synthetic */ ResourceKey copy$default(ResourceKey resourceKey, int i, GuiResource guiResource, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = resourceKey.displayId;
            }
            if ((i6 & 2) != 0) {
                guiResource = resourceKey.resource;
            }
            return resourceKey.copy(i, guiResource);
        }

        /* renamed from: component1, reason: from getter */
        public final int getDisplayId() {
            return this.displayId;
        }

        /* renamed from: component2, reason: from getter */
        public final GuiResource getResource() {
            return this.resource;
        }

        public final ResourceKey copy(int displayId, GuiResource resource) {
            k.f(resource, "resource");
            return new ResourceKey(displayId, resource);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceKey)) {
                return false;
            }
            ResourceKey resourceKey = (ResourceKey) other;
            return this.displayId == resourceKey.displayId && this.resource == resourceKey.resource;
        }

        public final int getDisplayId() {
            return this.displayId;
        }

        public final GuiResource getResource() {
            return this.resource;
        }

        public int hashCode() {
            return this.resource.hashCode() + (Integer.hashCode(this.displayId) * 31);
        }

        public String toString() {
            return "ResourceKey(displayId=" + this.displayId + ", resource=" + this.resource + ")";
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.GuiResourceScheduler", f = "GuiResourceScheduler.kt", l = {25, 34, 37}, m = "withResources", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.GuiResourceScheduler$withResources$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiResourceScheduler.this.withResources(0, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf A[Catch: all -> 0x00e0, TRY_LEAVE, TryCatch #0 {all -> 0x00e0, blocks: (B:52:0x0107, B:35:0x00b9, B:37:0x00bf, B:40:0x00d7, B:48:0x00e7, B:53:0x010c, B:34:0x00b2), top: B:67:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c A[Catch: all -> 0x00e0, TRY_LEAVE, TryCatch #0 {all -> 0x00e0, blocks: (B:52:0x0107, B:35:0x00b9, B:37:0x00bf, B:40:0x00d7, B:48:0x00e7, B:53:0x010c, B:34:0x00b2), top: B:67:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141 A[LOOP:0: B:58:0x0136->B:60:0x0141, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163 A[LOOP:1: B:63:0x0158->B:65:0x0163, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0105 -> B:52:0x0107). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object withResources(int r11, java.util.Set<? extends stepai.aios.guiexecutor.api.GuiResource> r12, S7.k r13, H7.c<? super T> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.GuiResourceScheduler.withResources(int, java.util.Set, S7.k, H7.c):java.lang.Object");
    }
}
