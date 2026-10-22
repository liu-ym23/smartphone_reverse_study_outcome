package com.stepos.stepclaw.base.track;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JO\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawReporterDependencies;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "traceId", "nodeName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "commonFields", "bizData", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "statusCode", "Lb5/a0;", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;I)V", "generateTraceId", "()Ljava/lang/String;", "getUserId", "getAppVersion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ClawReporterDependencies {
    String generateTraceId();

    String getAppVersion();

    String getUserId();

    void reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, int statusCode);
}
