package com.android.server.selinux;

import android.provider.DeviceConfig;
import android.util.EventLog;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.time.Instant;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
class SelinuxAuditLogsCollector {
    static final String CONFIG_SELINUX_AUDIT_DOMAIN = "selinux_audit_domain";
    private static final boolean DEBUG = false;
    static final String DEFAULT_SELINUX_AUDIT_DOMAIN = "no_match^";
    static final Matcher SELINUX_MATCHER = null;
    private static final String SELINUX_PATTERN = "^.*\\bavc:\\s+(?<denial>.*)$";
    private static final String TAG = "SelinuxAuditLogs";
    private final Supplier<String> mAuditDomainSupplier;
    private EventLogCollection mEventCollection;
    Instant mLastWrite;
    private final QuotaLimiter mQuotaLimiter;
    private final RateLimiter mRateLimiter;
    AtomicBoolean mStopRequested;

    private static class DefaultDomainSupplier implements Supplier<String> {
        /* synthetic */ DefaultDomainSupplier(SelinuxAuditLogsCollectorIA r1) {
            this();
        }

        private DefaultDomainSupplier() {
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ String get() {
            return get2();
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public String get2() {
            if (SelinuxAuditLogsService.enabledForAllDomains() == false) goto L7;
            return "\\w+";
        L7:
            return DeviceConfig.getString("adservices", SelinuxAuditLogsCollector.CONFIG_SELINUX_AUDIT_DOMAIN, SelinuxAuditLogsCollector.DEFAULT_SELINUX_AUDIT_DOMAIN);
        }
    }

    class EventLogCollection extends AbstractCollection<EventLog.Event> {
        SelinuxAuditLogBuilder mAuditLogBuilder;
        int mAuditsWritten;
        Instant mLatestTimestamp;
        final /* synthetic */ SelinuxAuditLogsCollector this$0;

        EventLogCollection(SelinuxAuditLogsCollector this$0) {
            this.this$0 = this$0;
            this.mAuditsWritten = 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object r1) {
            return add((EventLog.Event) r1);
        }

        void reset() {
            this.mAuditsWritten = 0;
            this.mLatestTimestamp = this.this$0.mLastWrite;
            this.mAuditLogBuilder = new SelinuxAuditLogBuilder((String) SelinuxAuditLogsCollector.m8069$$Nest$fgetmAuditDomainSupplier(this.this$0).get());
        }

        int getAuditsWritten() {
            return this.mAuditsWritten;
        }

        Instant getLatestTimestamp() {
            return this.mLatestTimestamp;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<EventLog.Event> iterator() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            throw new UnsupportedOperationException();
        }

        public boolean add(EventLog.Event event) {
            if (this.this$0.mStopRequested.get() == true) goto L25;
            Instant eventTime = Instant.ofEpochSecond(0, event.getTimeNanos());
            if (eventTime.compareTo(this.this$0.mLastWrite) > 0) goto L7;
            return true;
        L7:
            Object eventData = event.getData();
            if ((eventData instanceof String) == true) goto L10;
            return true;
        L10:
            String logLine = (String) eventData;
            if (SelinuxAuditLogsCollector.SELINUX_MATCHER.reset(logLine).matches() == true) goto L13;
            return true;
        L13:
            this.mAuditLogBuilder.reset(SelinuxAuditLogsCollector.SELINUX_MATCHER.group("denial"));
            SelinuxAuditLogBuilder.SelinuxAuditLog auditLog = this.mAuditLogBuilder.build();
            if (auditLog != null) goto L17;
            return true;
        L17:
            if (SelinuxAuditLogsCollector.m8070$$Nest$fgetmQuotaLimiter(this.this$0).acquire() == false) goto L23;
            SelinuxAuditLogsCollector.m8071$$Nest$fgetmRateLimiter(this.this$0).acquire();
            FrameworkStatsLog.write(FrameworkStatsLog.SELINUX_AUDIT_LOG, auditLog.mGranted, auditLog.mPermissions, auditLog.mSType, auditLog.mSCategories, auditLog.mTType, auditLog.mTCategories, auditLog.mTClass, auditLog.mPath, auditLog.mPermissive);
            this.mAuditsWritten++;
            if (eventTime.isAfter(this.mLatestTimestamp) == false) goto L21;
            this.mLatestTimestamp = eventTime;
        L21:
            return true;
        L23:
            throw new IllegalStateException(new QuotaExceededException());
        L25:
            throw new IllegalStateException(new InterruptedException());
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuditDomainSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m8069$$Nest$fgetmAuditDomainSupplier(SelinuxAuditLogsCollector r0) {
        return r0.mAuditDomainSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQuotaLimiter, reason: not valid java name */
    static /* bridge */ /* synthetic */ QuotaLimiter m8070$$Nest$fgetmQuotaLimiter(SelinuxAuditLogsCollector r0) {
        return r0.mQuotaLimiter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRateLimiter, reason: not valid java name */
    static /* bridge */ /* synthetic */ RateLimiter m8071$$Nest$fgetmRateLimiter(SelinuxAuditLogsCollector r0) {
        return r0.mRateLimiter;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        SELINUX_MATCHER = Pattern.compile(SELINUX_PATTERN).matcher("");
    }

    SelinuxAuditLogsCollector(Supplier<String> auditDomainSupplier, RateLimiter rateLimiter, QuotaLimiter quotaLimiter) {
        this.mLastWrite = Instant.MIN;
        this.mStopRequested = new AtomicBoolean(false);
        this.mAuditDomainSupplier = auditDomainSupplier;
        this.mRateLimiter = rateLimiter;
        this.mQuotaLimiter = quotaLimiter;
        this.mEventCollection = new EventLogCollection(this);
    }

    SelinuxAuditLogsCollector(RateLimiter rateLimiter, QuotaLimiter quotaLimiter) {
        this(new DefaultDomainSupplier(null), rateLimiter, quotaLimiter);
    }

    public void setStopRequested(boolean stopRequested) {
        this.mStopRequested.set(stopRequested);
    }

    boolean collect(int tagCode) throws QuotaExceededException {
        this.mEventCollection.reset();
        EventLog.readEvents(new int[]{tagCode}, this.mEventCollection);     // Catch: IOException -> L9 IllegalStateException -> L11
        this.mLastWrite = this.mEventCollection.getLatestTimestamp();
        if (DEBUG == false) goto L29;
        Slogf.d(TAG, "Written %d logs", new Object[]{Integer.valueOf(this.mEventCollection.getAuditsWritten())});
        return true;
    L29:
        return true;
    L9:
        e = move-exception;
        Slog.e(TAG, "Error reading event logs", e);
        return false;
    L11:
        e = move-exception;
        if ((e.getCause() instanceof QuotaExceededException) == false) goto L23;
        if (DEBUG == false) goto L20;
        Slogf.d(TAG, "Running out of quota after %d logs.", new Object[]{Integer.valueOf(this.mEventCollection.getAuditsWritten())});
    L20:
        this.mLastWrite = this.mEventCollection.getLatestTimestamp();
        throw ((QuotaExceededException) e.getCause());
    L23:
        if ((e.getCause() instanceof InterruptedException) == false) goto L26;
        this.mLastWrite = this.mEventCollection.getLatestTimestamp();
        return false;
    L26:
        throw e;
    }
}
