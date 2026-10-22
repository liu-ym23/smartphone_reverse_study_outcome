package f8;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u0012R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u0012R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lf8/a;", "", "", "taskId", "taskName", "action", "bitmapId", "Landroid/graphics/Bitmap;", "bitmap", "bitmapUri", "", "status", "message", "Landroid/os/Bundle;", "bundle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getTaskId", Const.INTENT_KEY_PKGNAME, "getTaskName", "c", "getAction", Const.INTENT_KEY_UMID, "getBitmapId", "e", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "f", "getBitmapUri", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getMessage", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: f8.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes4.dex */
public final /* data */ class GuiTaskProgress {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String bitmapId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Bitmap bitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String bitmapUri;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final Bundle bundle;

    public GuiTaskProgress(String taskId, String taskName, String action, String str, Bitmap bitmap, String str2, Integer num, String str3, Bundle bundle) {
        p.i(taskId, "taskId");
        p.i(taskName, "taskName");
        p.i(action, "action");
        p.i(bundle, "bundle");
        this.taskId = taskId;
        this.taskName = taskName;
        this.action = action;
        this.bitmapId = str;
        this.bitmap = bitmap;
        this.bitmapUri = str2;
        this.status = num;
        this.message = str3;
        this.bundle = bundle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskProgress)) {
            return false;
        }
        GuiTaskProgress guiTaskProgress = (GuiTaskProgress) other;
        return p.d(this.taskId, guiTaskProgress.taskId) && p.d(this.taskName, guiTaskProgress.taskName) && p.d(this.action, guiTaskProgress.action) && p.d(this.bitmapId, guiTaskProgress.bitmapId) && p.d(this.bitmap, guiTaskProgress.bitmap) && p.d(this.bitmapUri, guiTaskProgress.bitmapUri) && p.d(this.status, guiTaskProgress.status) && p.d(this.message, guiTaskProgress.message) && p.d(this.bundle, guiTaskProgress.bundle);
    }

    public int hashCode() {
        int iHashCode = ((((this.taskId.hashCode() * 31) + this.taskName.hashCode()) * 31) + this.action.hashCode()) * 31;
        String str = this.bitmapId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Bitmap bitmap = this.bitmap;
        int iHashCode3 = (iHashCode2 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        String str2 = this.bitmapUri;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.status;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.message;
        return ((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.bundle.hashCode();
    }

    public String toString() {
        return "GuiTaskProgress(taskId=" + this.taskId + ", taskName=" + this.taskName + ", action=" + this.action + ", bitmapId=" + this.bitmapId + ", bitmap=" + this.bitmap + ", bitmapUri=" + this.bitmapUri + ", status=" + this.status + ", message=" + this.message + ", bundle=" + this.bundle + ")";
    }
}
