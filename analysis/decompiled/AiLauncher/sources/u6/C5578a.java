package u6;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lu6/a;", "", "<init>", "()V", "", "fileId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "dstType", "", "page", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "DOWNLOAD_PREFIX", "Ljava/lang/String;", "PREVIEW_PREFIX", "DST_JPG", "DST_PDF", "DST_HTML", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5578a {
    private static final String DOWNLOAD_PREFIX = "dl:";
    public static final String DST_HTML = "html";
    public static final String DST_JPG = "jpg";
    public static final String DST_PDF = "pdf";
    public static final C5578a INSTANCE = new C5578a();
    private static final String PREVIEW_PREFIX = "pv:";

    public final String a(String fileId) {
        p.i(fileId, "fileId");
        return DOWNLOAD_PREFIX + fileId;
    }

    public final String b(String fileId, String dstType, Integer page) {
        p.i(fileId, "fileId");
        p.i(dstType, "dstType");
        return PREVIEW_PREFIX + fileId + ServerSentEventKt.COLON + dstType + ServerSentEventKt.COLON + (page != null ? page.intValue() : -1);
    }
}
