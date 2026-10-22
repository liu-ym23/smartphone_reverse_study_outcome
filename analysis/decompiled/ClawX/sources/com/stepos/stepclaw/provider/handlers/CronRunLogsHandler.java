package com.stepos.stepclaw.provider.handlers;

import a.a;
import a8.b;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import c5.m;
import c5.q;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.handlers.CronRunLogsHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.bouncycastle.asn1.x509.DisplayText;
import org.json.JSONObject;
import x5.f;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rootfs", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "<init>", "(Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;)V", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "parseLine", "Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler$ParsedLine;", "line", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ParsedLine", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CronRunLogsHandler {
    public static final String CRON_RUNS_DIR = "root/.openclaw/cron/runs";
    private final IRootfsAccess rootfs;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¦\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\rHÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006;"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler$ParsedLine;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tsMs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "jobId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", "summary", "error", "nextRunAtMs", "durationMs", "runAtMs", "delivered", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deliveryStatus", "deliveryError", "sessionKey", "jobName", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTsMs", "()J", "getJobId", "()Ljava/lang/String;", "getStatus", "getSummary", "getError", "getNextRunAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDurationMs", "getRunAtMs", "getDelivered", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeliveryStatus", "getDeliveryError", "getSessionKey", "getJobName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler$ParsedLine;", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParsedLine {
        private final Integer delivered;
        private final String deliveryError;
        private final String deliveryStatus;
        private final Long durationMs;
        private final String error;
        private final String jobId;
        private final String jobName;
        private final Long nextRunAtMs;
        private final Long runAtMs;
        private final String sessionKey;
        private final String status;
        private final String summary;
        private final long tsMs;

        public ParsedLine(long j4, String jobId, String str, String str2, String str3, Long l3, Long l6, Long l8, Integer num, String str4, String str5, String str6, String str7) {
            p.e(jobId, "jobId");
            this.tsMs = j4;
            this.jobId = jobId;
            this.status = str;
            this.summary = str2;
            this.error = str3;
            this.nextRunAtMs = l3;
            this.durationMs = l6;
            this.runAtMs = l8;
            this.delivered = num;
            this.deliveryStatus = str4;
            this.deliveryError = str5;
            this.sessionKey = str6;
            this.jobName = str7;
        }

        /* renamed from: component1, reason: from getter */
        public final long getTsMs() {
            return this.tsMs;
        }

        /* renamed from: component10, reason: from getter */
        public final String getDeliveryStatus() {
            return this.deliveryStatus;
        }

        /* renamed from: component11, reason: from getter */
        public final String getDeliveryError() {
            return this.deliveryError;
        }

        /* renamed from: component12, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: component13, reason: from getter */
        public final String getJobName() {
            return this.jobName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getJobId() {
            return this.jobId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        /* renamed from: component5, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getNextRunAtMs() {
            return this.nextRunAtMs;
        }

        /* renamed from: component7, reason: from getter */
        public final Long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getRunAtMs() {
            return this.runAtMs;
        }

        /* renamed from: component9, reason: from getter */
        public final Integer getDelivered() {
            return this.delivered;
        }

        public final ParsedLine copy(long tsMs, String jobId, String status, String summary, String error, Long nextRunAtMs, Long durationMs, Long runAtMs, Integer delivered, String deliveryStatus, String deliveryError, String sessionKey, String jobName) {
            p.e(jobId, "jobId");
            return new ParsedLine(tsMs, jobId, status, summary, error, nextRunAtMs, durationMs, runAtMs, delivered, deliveryStatus, deliveryError, sessionKey, jobName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedLine)) {
                return false;
            }
            ParsedLine parsedLine = (ParsedLine) other;
            return this.tsMs == parsedLine.tsMs && p.a(this.jobId, parsedLine.jobId) && p.a(this.status, parsedLine.status) && p.a(this.summary, parsedLine.summary) && p.a(this.error, parsedLine.error) && p.a(this.nextRunAtMs, parsedLine.nextRunAtMs) && p.a(this.durationMs, parsedLine.durationMs) && p.a(this.runAtMs, parsedLine.runAtMs) && p.a(this.delivered, parsedLine.delivered) && p.a(this.deliveryStatus, parsedLine.deliveryStatus) && p.a(this.deliveryError, parsedLine.deliveryError) && p.a(this.sessionKey, parsedLine.sessionKey) && p.a(this.jobName, parsedLine.jobName);
        }

        public final Integer getDelivered() {
            return this.delivered;
        }

        public final String getDeliveryError() {
            return this.deliveryError;
        }

        public final String getDeliveryStatus() {
            return this.deliveryStatus;
        }

        public final Long getDurationMs() {
            return this.durationMs;
        }

        public final String getError() {
            return this.error;
        }

        public final String getJobId() {
            return this.jobId;
        }

        public final String getJobName() {
            return this.jobName;
        }

        public final Long getNextRunAtMs() {
            return this.nextRunAtMs;
        }

        public final Long getRunAtMs() {
            return this.runAtMs;
        }

        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final long getTsMs() {
            return this.tsMs;
        }

        public int hashCode() {
            int iF = b.f(Long.hashCode(this.tsMs) * 31, 31, this.jobId);
            String str = this.status;
            int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.summary;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.error;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Long l3 = this.nextRunAtMs;
            int iHashCode4 = (iHashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l6 = this.durationMs;
            int iHashCode5 = (iHashCode4 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l8 = this.runAtMs;
            int iHashCode6 = (iHashCode5 + (l8 == null ? 0 : l8.hashCode())) * 31;
            Integer num = this.delivered;
            int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.deliveryStatus;
            int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.deliveryError;
            int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sessionKey;
            int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.jobName;
            return iHashCode10 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            long j4 = this.tsMs;
            String str = this.jobId;
            String str2 = this.status;
            String str3 = this.summary;
            String str4 = this.error;
            Long l3 = this.nextRunAtMs;
            Long l6 = this.durationMs;
            Long l8 = this.runAtMs;
            Integer num = this.delivered;
            String str5 = this.deliveryStatus;
            String str6 = this.deliveryError;
            String str7 = this.sessionKey;
            String str8 = this.jobName;
            StringBuilder sb = new StringBuilder("ParsedLine(tsMs=");
            sb.append(j4);
            sb.append(", jobId=");
            sb.append(str);
            b.A(sb, ", status=", str2, ", summary=", str3);
            sb.append(", error=");
            sb.append(str4);
            sb.append(", nextRunAtMs=");
            sb.append(l3);
            sb.append(", durationMs=");
            sb.append(l6);
            sb.append(", runAtMs=");
            sb.append(l8);
            sb.append(", delivered=");
            sb.append(num);
            sb.append(", deliveryStatus=");
            sb.append(str5);
            b.A(sb, ", deliveryError=", str6, ", sessionKey=", str7);
            sb.append(", jobName=");
            sb.append(str8);
            sb.append(")");
            return sb.toString();
        }
    }

    public CronRunLogsHandler(IRootfsAccess rootfs) {
        p.e(rootfs, "rootfs");
        this.rootfs = rootfs;
    }

    private final ParsedLine parseLine(String line) {
        Integer num;
        try {
            JSONObject jSONObject = new JSONObject(line);
            if (!p.a(jSONObject.optString("action", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), "finished")) {
                return null;
            }
            long jOptLong = jSONObject.optLong("ts", 0L);
            if (jOptLong <= 0) {
                return null;
            }
            String strOptString = jSONObject.optString("jobId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString, "optString(...)");
            String string = n.T1(strOptString).toString();
            if (string.length() == 0) {
                return null;
            }
            String strOptString2 = jSONObject.optString("status", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString2, "optString(...)");
            String string2 = n.T1(strOptString2).toString();
            String str = string2.length() > 0 ? string2 : null;
            if (jSONObject.isNull("delivered")) {
                num = null;
            } else {
                num = jSONObject.optBoolean("delivered", false) ? 1 : 0;
            }
            String strOptString3 = jSONObject.optString("summary", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString3, "optString(...)");
            String string3 = n.T1(strOptString3).toString();
            String str2 = string3.length() > 0 ? string3 : null;
            String strOptString4 = jSONObject.optString("error", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString4, "optString(...)");
            String string4 = n.T1(strOptString4).toString();
            String str3 = string4.length() > 0 ? string4 : null;
            Long lValueOf = jSONObject.has("nextRunAtMs") ? Long.valueOf(jSONObject.optLong("nextRunAtMs")) : null;
            Long lValueOf2 = jSONObject.has("durationMs") ? Long.valueOf(jSONObject.optLong("durationMs")) : null;
            Long lValueOf3 = jSONObject.has("runAtMs") ? Long.valueOf(jSONObject.optLong("runAtMs")) : null;
            String strOptString5 = jSONObject.optString("deliveryStatus", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString5, "optString(...)");
            String string5 = n.T1(strOptString5).toString();
            String str4 = string5.length() > 0 ? string5 : null;
            String strOptString6 = jSONObject.optString("deliveryError", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString6, "optString(...)");
            String string6 = n.T1(strOptString6).toString();
            String str5 = string6.length() > 0 ? string6 : null;
            String strOptString7 = jSONObject.optString("sessionKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString7, "optString(...)");
            String string7 = n.T1(strOptString7).toString();
            String str6 = string7.length() > 0 ? string7 : null;
            String strOptString8 = jSONObject.optString("jobName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString8, "optString(...)");
            String string8 = n.T1(strOptString8).toString();
            return new ParsedLine(jOptLong, string, str, str2, str3, lValueOf, lValueOf2, lValueOf3, num, str4, str5, str6, string8.length() > 0 ? string8 : null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Cursor query(Uri uri) {
        List<String> listListRootfsFilesInDirectory;
        ParsedLine line;
        String string;
        Integer numD1;
        p.e(uri, "uri");
        String queryParameter = uri.getQueryParameter("limit");
        int iN = (queryParameter == null || (numD1 = u.d1(queryParameter)) == null) ? DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE : v.n(numD1.intValue(), 1, 5000);
        String queryParameter2 = uri.getQueryParameter("job_id");
        String str = null;
        if (queryParameter2 != null && (string = n.T1(queryParameter2).toString()) != null && string.length() > 0) {
            str = string;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"ts_ms", "job_id", "status", "summary", "error", "next_run_at_ms", "duration_ms", "run_at_ms", "delivered", "delivery_status", "delivery_error", "session_key", "job_name"});
        ArrayList arrayList = new ArrayList();
        try {
            listListRootfsFilesInDirectory = this.rootfs.listRootfsFilesInDirectory(CRON_RUNS_DIR);
        } catch (Exception unused) {
            listListRootfsFilesInDirectory = s.f1092a;
        }
        for (String str2 : listListRootfsFilesInDirectory) {
            if (u.V0(str2, MemoryFile.EXTENSION, true)) {
                String strC1 = n.C1(n.C1(str2, MemoryFile.EXTENSION), ".JSONL");
                if (str == null || strC1.equals(str)) {
                    String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/cron/runs/".concat(str2));
                    if (rootfsFile != null) {
                        Iterator it = n.x1(rootfsFile).iterator();
                        while (true) {
                            f fVar = (f) it;
                            if (fVar.hasNext()) {
                                String string2 = n.T1((String) fVar.next()).toString();
                                if (string2.length() != 0 && (line = parseLine(string2)) != null && (str == null || p.a(line.getJobId(), str))) {
                                    arrayList.add(line);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            q.o0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.provider.handlers.CronRunLogsHandler$query$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    return a.l(Long.valueOf(((CronRunLogsHandler.ParsedLine) t9).getTsMs()), Long.valueOf(((CronRunLogsHandler.ParsedLine) t8).getTsMs()));
                }
            });
        }
        for (ParsedLine parsedLine : m.K0(iN, arrayList)) {
            matrixCursor.addRow(new Object[]{Long.valueOf(parsedLine.getTsMs()), parsedLine.getJobId(), parsedLine.getStatus(), parsedLine.getSummary(), parsedLine.getError(), parsedLine.getNextRunAtMs(), parsedLine.getDurationMs(), parsedLine.getRunAtMs(), parsedLine.getDelivered(), parsedLine.getDeliveryStatus(), parsedLine.getDeliveryError(), parsedLine.getSessionKey(), parsedLine.getJobName()});
        }
        return matrixCursor;
    }
}
