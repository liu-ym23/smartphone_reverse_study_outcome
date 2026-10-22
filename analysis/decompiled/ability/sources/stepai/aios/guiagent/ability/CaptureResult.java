package stepai.aios.guiagent.ability;

import B7.a;
import android.graphics.Bitmap;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lstepai/aios/guiagent/ability/CaptureResult;", "", "bitmap", "Landroid/graphics/Bitmap;", "imageUrl", "", "localPath", "mimeType", "traceKey", "errorContent", AppAgent.CONSTRUCT, "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getImageUrl", "()Ljava/lang/String;", "getLocalPath", "getMimeType", "getTraceKey", "getErrorContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CaptureResult {
    private final Bitmap bitmap;
    private final String errorContent;
    private final String imageUrl;
    private final String localPath;
    private final String mimeType;
    private final String traceKey;

    public CaptureResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CaptureResult copy$default(CaptureResult captureResult, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = captureResult.bitmap;
        }
        if ((i & 2) != 0) {
            str = captureResult.imageUrl;
        }
        if ((i & 4) != 0) {
            str2 = captureResult.localPath;
        }
        if ((i & 8) != 0) {
            str3 = captureResult.mimeType;
        }
        if ((i & 16) != 0) {
            str4 = captureResult.traceKey;
        }
        if ((i & 32) != 0) {
            str5 = captureResult.errorContent;
        }
        String str6 = str4;
        String str7 = str5;
        return captureResult.copy(bitmap, str, str2, str3, str6, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component2, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTraceKey() {
        return this.traceKey;
    }

    /* renamed from: component6, reason: from getter */
    public final String getErrorContent() {
        return this.errorContent;
    }

    public final CaptureResult copy(Bitmap bitmap, String imageUrl, String localPath, String mimeType, String traceKey, String errorContent) {
        k.f(mimeType, "mimeType");
        return new CaptureResult(bitmap, imageUrl, localPath, mimeType, traceKey, errorContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureResult)) {
            return false;
        }
        CaptureResult captureResult = (CaptureResult) other;
        return k.b(this.bitmap, captureResult.bitmap) && k.b(this.imageUrl, captureResult.imageUrl) && k.b(this.localPath, captureResult.localPath) && k.b(this.mimeType, captureResult.mimeType) && k.b(this.traceKey, captureResult.traceKey) && k.b(this.errorContent, captureResult.errorContent);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final String getErrorContent() {
        return this.errorContent;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getTraceKey() {
        return this.traceKey;
    }

    public int hashCode() {
        Bitmap bitmap = this.bitmap;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        String str = this.imageUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.localPath;
        int iC = a.c((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.mimeType);
        String str3 = this.traceKey;
        int iHashCode3 = (iC + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.errorContent;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        Bitmap bitmap = this.bitmap;
        String str = this.imageUrl;
        String str2 = this.localPath;
        String str3 = this.mimeType;
        String str4 = this.traceKey;
        String str5 = this.errorContent;
        StringBuilder sb = new StringBuilder("CaptureResult(bitmap=");
        sb.append(bitmap);
        sb.append(", imageUrl=");
        sb.append(str);
        sb.append(", localPath=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", mimeType=", str3, ", traceKey=");
        return androidx.appfunctions.metadata.a.p(sb, str4, ", errorContent=", str5, ")");
    }

    public CaptureResult(Bitmap bitmap, String str, String str2, String mimeType, String str3, String str4) {
        k.f(mimeType, "mimeType");
        this.bitmap = bitmap;
        this.imageUrl = str;
        this.localPath = str2;
        this.mimeType = mimeType;
        this.traceKey = str3;
        this.errorContent = str4;
    }

    public /* synthetic */ CaptureResult(Bitmap bitmap, String str, String str2, String str3, String str4, String str5, int i, e eVar) {
        this((i & 1) != 0 ? null : bitmap, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? "image/jpeg" : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }
}
