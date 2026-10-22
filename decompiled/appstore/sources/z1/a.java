package z1;

import com.bytedance.services.apm.api.IFileUploadService;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IFileUploadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f26273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f26274c;

    public static void a(String r10) {
        f26273b = "https://" + r10 + "/monitor/collect/c/code_coverage";
    }

    public static void b(String r10) {
        f26272a = "https://" + r10 + "/monitor/collect/c/logcollect";
        f26274c = r10;
    }
}
