package com.stepos.datacenter.core;

import W6.StorageResult;
import Z8.F;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.entity.BaseEntity;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000b\u0010\nJ\u001e\u0010\r\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/datacenter/core/a;", "LW6/a;", "Lcom/stepos/datacenter/core/StructuredDataRepository;", "structuredRepo", "<init>", "(Lcom/stepos/datacenter/core/StructuredDataRepository;)V", "Lcom/stepos/datacenter/entity/BaseEntity;", "data", "LW6/b;", Const.INTENT_KEY_UMID, "(Lcom/stepos/datacenter/entity/BaseEntity;Le9/c;)Ljava/lang/Object;", "c", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/core/StructuredDataRepository;", "getStructuredRepo", "()Lcom/stepos/datacenter/core/StructuredDataRepository;", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements W6.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final StructuredDataRepository structuredRepo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/datacenter/core/a$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/datacenter/core/a;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcom/stepos/datacenter/core/a;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final a a(Context context) {
            p.i(context, "context");
            S6.a.f5644a.b(context);
            return new a(StructuredDataRepository.INSTANCE.a());
        }

        public Companion() {
        }
    }

    public a(StructuredDataRepository structuredRepo) {
        p.i(structuredRepo, "structuredRepo");
        this.structuredRepo = structuredRepo;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // W6.a
    public Object b(List<? extends BaseEntity> list, InterfaceC4014c<? super StorageResult> interfaceC4014c) {
        String dataType = ((BaseEntity) F.q0(list)).getDataType();
        if (dataType != null) {
            switch (dataType.hashCode()) {
                case -1767058109:
                    if (dataType.equals("VECTOR")) {
                        return new StorageResult(true, "vector delete", null, 4, null);
                    }
                    break;
                case 2157948:
                    if (dataType.equals("FILE")) {
                        return new StorageResult(true, "file delete", null, 4, null);
                    }
                    break;
                case 68077870:
                    if (dataType.equals("GRAPH")) {
                        return new StorageResult(false, "graph delete", null, 4, null);
                    }
                    break;
                case 670199121:
                    if (dataType.equals("STRUCTURED")) {
                        return this.structuredRepo.c(list, interfaceC4014c);
                    }
                    break;
            }
        }
        return new StorageResult(false, "Invalid entity data type for delete", null, 4, null);
    }

    @Override // W6.a
    public Object c(BaseEntity baseEntity, InterfaceC4014c<? super StorageResult> interfaceC4014c) {
        return p.d(baseEntity.getDataType(), "STRUCTURED") ? this.structuredRepo.d(baseEntity, interfaceC4014c) : new StorageResult(true, "Delete operation completed", null, 4, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // W6.a
    public Object d(BaseEntity baseEntity, InterfaceC4014c<? super StorageResult> interfaceC4014c) {
        String dataType = baseEntity.getDataType();
        if (dataType != null) {
            switch (dataType.hashCode()) {
                case -1767058109:
                    if (dataType.equals("VECTOR")) {
                        return new StorageResult(true, "vector storage", null, 4, null);
                    }
                    break;
                case 2157948:
                    if (dataType.equals("FILE")) {
                        return new StorageResult(true, "file storage", null, 4, null);
                    }
                    break;
                case 68077870:
                    if (dataType.equals("GRAPH")) {
                        return new StorageResult(false, "Invalid data type for graph storage, expected GraphNode or GraphEdge", null, 4, null);
                    }
                    break;
                case 670199121:
                    if (dataType.equals("STRUCTURED")) {
                        return this.structuredRepo.e(baseEntity, interfaceC4014c);
                    }
                    break;
            }
        }
        return new StorageResult(false, "Invalid entity data type for storage", null, 4, null);
    }
}
