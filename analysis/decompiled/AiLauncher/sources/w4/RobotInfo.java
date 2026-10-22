package w4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\b\b\u0087\b\u0018\u0000 62\u00020\u0001:\u0001 Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u001bR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u001bR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u001bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u001bR*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lw4/h;", "", "", "taskId", "status", "sourceFrom", "errorMessage", "", "firstRunTime", "updateTime", "taskName", "taskDesc", "latestScreenshotPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setTaskId", "(Ljava/lang/String;)V", "f", "o", "e", "setSourceFrom", Const.INTENT_KEY_APIKEY, "k", "J", Const.INTENT_KEY_PKGNAME, "()J", "l", "(J)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "r", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "q", Const.INTENT_KEY_BACKGROUND_COMMAND, "p", Const.INTENT_KEY_UMID, "n", "", "imageList", "Ljava/util/List;", "c", "()Ljava/util/List;", "m", "(Ljava/util/List;)V", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.h, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class RobotInfo {
    public static final String STATUS_CANCELED = "canceled";
    public static final String STATUS_FAIL = "fail";
    public static final String STATUS_NONE = "none";
    public static final String STATUS_RUNNING = "running";
    public static final String STATUS_STARTED = "started";
    public static final String STATUS_SUCCESS = "complete";
    private String errorMessage;
    private long firstRunTime;
    private List<String> imageList;
    private String latestScreenshotPath;
    private String sourceFrom;
    private String status;
    private String taskDesc;
    private String taskId;
    private String taskName;
    private long updateTime;

    public RobotInfo(String taskId, String status, String sourceFrom, String str, long j10, long j11, String str2, String str3, String str4) {
        p.i(taskId, "taskId");
        p.i(status, "status");
        p.i(sourceFrom, "sourceFrom");
        this.taskId = taskId;
        this.status = status;
        this.sourceFrom = sourceFrom;
        this.errorMessage = str;
        this.firstRunTime = j10;
        this.updateTime = j11;
        this.taskName = str2;
        this.taskDesc = str3;
        this.latestScreenshotPath = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: b, reason: from getter */
    public final long getFirstRunTime() {
        return this.firstRunTime;
    }

    public final List<String> c() {
        return this.imageList;
    }

    /* renamed from: d, reason: from getter */
    public final String getLatestScreenshotPath() {
        return this.latestScreenshotPath;
    }

    /* renamed from: e, reason: from getter */
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotInfo)) {
            return false;
        }
        RobotInfo robotInfo = (RobotInfo) other;
        return p.d(this.taskId, robotInfo.taskId) && p.d(this.status, robotInfo.status) && p.d(this.sourceFrom, robotInfo.sourceFrom) && p.d(this.errorMessage, robotInfo.errorMessage) && this.firstRunTime == robotInfo.firstRunTime && this.updateTime == robotInfo.updateTime && p.d(this.taskName, robotInfo.taskName) && p.d(this.taskDesc, robotInfo.taskDesc) && p.d(this.latestScreenshotPath, robotInfo.latestScreenshotPath);
    }

    /* renamed from: f, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: g, reason: from getter */
    public final String getTaskDesc() {
        return this.taskDesc;
    }

    /* renamed from: h, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = ((((this.taskId.hashCode() * 31) + this.status.hashCode()) * 31) + this.sourceFrom.hashCode()) * 31;
        String str = this.errorMessage;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.firstRunTime)) * 31) + Long.hashCode(this.updateTime)) * 31;
        String str2 = this.taskName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.taskDesc;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.latestScreenshotPath;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* renamed from: j, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void k(String str) {
        this.errorMessage = str;
    }

    public final void l(long j10) {
        this.firstRunTime = j10;
    }

    public final void m(List<String> list) {
        this.imageList = list;
    }

    public final void n(String str) {
        this.latestScreenshotPath = str;
    }

    public final void o(String str) {
        p.i(str, "<set-?>");
        this.status = str;
    }

    public final void p(String str) {
        this.taskDesc = str;
    }

    public final void q(String str) {
        this.taskName = str;
    }

    public final void r(long j10) {
        this.updateTime = j10;
    }

    public String toString() {
        return "RobotInfo(taskId=" + this.taskId + ", status=" + this.status + ", sourceFrom=" + this.sourceFrom + ", errorMessage=" + this.errorMessage + ", firstRunTime=" + this.firstRunTime + ", updateTime=" + this.updateTime + ", taskName=" + this.taskName + ", taskDesc=" + this.taskDesc + ", latestScreenshotPath=" + this.latestScreenshotPath + ")";
    }

    public /* synthetic */ RobotInfo(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? "none" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? System.currentTimeMillis() : j10, (i10 & 32) != 0 ? 0L : j11, (i10 & 64) != 0 ? "" : str5, (i10 & 128) != 0 ? "" : str6, (i10 & 256) != 0 ? "" : str7);
    }
}
