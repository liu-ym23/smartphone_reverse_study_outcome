package stepai.aios.guiagent.tracer.remote;

import H7.c;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J<\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H¦@¢\u0006\u0004\b\b\u0010\tJ<\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H¦@¢\u0006\u0004\b\u000b\u0010\t¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/IUpload;", "", "", "content", AgentBusWakeContract.EXTRA_TRACE_ID, "", "headers", "Lstepai/aios/guiagent/tracer/remote/UploadResult;", "uploadString", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "filePath", "uploadFile", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IUpload {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object uploadFile$default(IUpload iUpload, String str, String str2, Map map, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        return iUpload.uploadFile(str, str2, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object uploadString$default(IUpload iUpload, String str, String str2, Map map, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadString");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        return iUpload.uploadString(str, str2, map, cVar);
    }

    Object uploadFile(String str, String str2, Map<String, String> map, c<? super UploadResult> cVar);

    Object uploadString(String str, String str2, Map<String, String> map, c<? super UploadResult> cVar);
}
