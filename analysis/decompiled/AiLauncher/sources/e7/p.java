package e7;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.vector.BackendCapabilities;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.VectorEntry;
import com.stepos.datacenter.vector.VectorSearchRequest;
import com.stepos.datacenter.vector.VectorSearchResult;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u001b\u0010\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u001c\u0010\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0019\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u001d\u0010\u0016R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Le7/p;", "", "Lcom/stepos/datacenter/vector/VectorEntry;", "entry", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/datacenter/vector/VectorEntry;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/vector/VectorSearchRequest;", "request", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/datacenter/vector/VectorSearchRequest;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "descriptor", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "LY8/t;", "c", "(Lcom/stepos/datacenter/vector/CollectionDescriptor;Le9/c;)Ljava/lang/Object;", "", "id", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "collectionId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", Const.INTENT_KEY_UMID, "Lcom/stepos/datacenter/vector/BackendCapabilities;", "e", "()Lcom/stepos/datacenter/vector/BackendCapabilities;", "capabilities", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface p {
    Object a(InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c);

    Object b(VectorEntry vectorEntry, InterfaceC4014c<? super Long> interfaceC4014c);

    Object c(CollectionDescriptor collectionDescriptor, InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c);

    Object d(String str, InterfaceC4014c<? super List<String>> interfaceC4014c);

    BackendCapabilities e();

    Object f(String str, InterfaceC4014c<? super String> interfaceC4014c);

    Object g(String str, InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c);

    Object h(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object i(VectorSearchRequest vectorSearchRequest, InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c);
}
