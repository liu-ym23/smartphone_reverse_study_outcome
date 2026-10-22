package com.stepos.ailauncher.task.common;

import La.H;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/common/a;", "", "<init>", "()V", "", "fileId", "", "notFoundFileIds", "Lcom/stepos/ailauncher/task/common/a$a;", "detail", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/Set;Lcom/stepos/ailauncher/task/common/a$a;)Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "TERMINAL_STATUSES", "Ljava/util/Set;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final Set<String> TERMINAL_STATUSES = Y.j("DELETED", "EXPIRED", "DESTROYED", "INVALID", "REMOVED", "ARCHIVED", "PURGED");

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/common/a$a;", "", "", "status", "", "detectPassed", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Boolean;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Boolean;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.common.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class DetailFields {
        private final Boolean detectPassed;
        private final String status;

        public DetailFields(String str, Boolean bool) {
            this.status = str;
            this.detectPassed = bool;
        }

        /* renamed from: a, reason: from getter */
        public final Boolean getDetectPassed() {
            return this.detectPassed;
        }

        /* renamed from: b, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailFields)) {
                return false;
            }
            DetailFields detailFields = (DetailFields) other;
            return p.d(this.status, detailFields.status) && p.d(this.detectPassed, detailFields.detectPassed);
        }

        public int hashCode() {
            String str = this.status;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.detectPassed;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "DetailFields(status=" + this.status + ", detectPassed=" + this.detectPassed + ")";
        }
    }

    public final ArtifactAvailability a(String fileId, Set<String> notFoundFileIds, DetailFields detail) {
        String upperCase;
        String string;
        p.i(fileId, "fileId");
        p.i(notFoundFileIds, "notFoundFileIds");
        if (notFoundFileIds.contains(fileId)) {
            return ArtifactAvailability.UNAVAILABLE;
        }
        if (detail == null) {
            return ArtifactAvailability.UNKNOWN;
        }
        if (p.d(detail.getDetectPassed(), Boolean.FALSE)) {
            return ArtifactAvailability.BLOCKED;
        }
        String status = detail.getStatus();
        if (status == null || (string = H.D1(status).toString()) == null) {
            upperCase = null;
        } else {
            upperCase = string.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
        }
        if (upperCase == null) {
            upperCase = "";
        }
        return TERMINAL_STATUSES.contains(upperCase) ? ArtifactAvailability.UNAVAILABLE : ArtifactAvailability.AVAILABLE;
    }
}
