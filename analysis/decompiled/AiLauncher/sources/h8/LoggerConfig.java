package h8;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.logbox.LogStorageMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R \u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u0012\u0004\b$\u0010\u0018\u001a\u0004\b#\u0010 ¨\u0006%"}, d2 = {"Lh8/g;", "", "Lcom/zyql/logbox/LogStorageMode;", "storageMode", "", "retentionDays", "", "enableFileLog", "enableLogcat", "<init>", "(Lcom/zyql/logbox/LogStorageMode;IZZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/zyql/logbox/LogStorageMode;", "getStorageMode", "()Lcom/zyql/logbox/LogStorageMode;", "getStorageMode$annotations", "()V", Const.INTENT_KEY_PKGNAME, "I", "getRetentionDays", "getRetentionDays$annotations", "c", "Z", "getEnableFileLog", "()Z", "getEnableFileLog$annotations", Const.INTENT_KEY_UMID, "getEnableLogcat", "getEnableLogcat$annotations", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: h8.g, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class LoggerConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final LogStorageMode storageMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int retentionDays;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableFileLog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableLogcat;

    public LoggerConfig() {
        this(null, 0, false, false, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoggerConfig)) {
            return false;
        }
        LoggerConfig loggerConfig = (LoggerConfig) other;
        return this.storageMode == loggerConfig.storageMode && this.retentionDays == loggerConfig.retentionDays && this.enableFileLog == loggerConfig.enableFileLog && this.enableLogcat == loggerConfig.enableLogcat;
    }

    public int hashCode() {
        return (((((this.storageMode.hashCode() * 31) + Integer.hashCode(this.retentionDays)) * 31) + Boolean.hashCode(this.enableFileLog)) * 31) + Boolean.hashCode(this.enableLogcat);
    }

    public String toString() {
        return "LoggerConfig(storageMode=" + this.storageMode + ", retentionDays=" + this.retentionDays + ", enableFileLog=" + this.enableFileLog + ", enableLogcat=" + this.enableLogcat + ")";
    }

    public LoggerConfig(LogStorageMode storageMode, int i10, boolean z10, boolean z11) {
        p.i(storageMode, "storageMode");
        this.storageMode = storageMode;
        this.retentionDays = i10;
        this.enableFileLog = z10;
        this.enableLogcat = z11;
    }

    public /* synthetic */ LoggerConfig(LogStorageMode logStorageMode, int i10, boolean z10, boolean z11, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? LogStorageMode.SEPARATED : logStorageMode, (i11 & 2) != 0 ? 7 : i10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? true : z11);
    }
}
