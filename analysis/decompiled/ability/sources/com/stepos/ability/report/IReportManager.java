package com.stepos.ability.report;

import androidx.core.app.NotificationCompat;
import com.stepos.ability.report.event.AgentCacheTaskEvent;
import com.stepos.ability.report.event.LogEvent;
import com.stepos.ability.report.event.ToolCallRequestEvent;
import com.stepos.ability.report.event.ToolCallResponseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/report/IReportManager;", "", "reportToolCallRequestEvent", "", NotificationCompat.CATEGORY_EVENT, "Lcom/stepos/ability/report/event/ToolCallRequestEvent;", "reportToolCallResponseEvent", "Lcom/stepos/ability/report/event/ToolCallResponseEvent;", "reportLogEvent", "Lcom/stepos/ability/report/event/LogEvent;", "reportTaskEvent", "Lcom/stepos/ability/report/event/AgentCacheTaskEvent;", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IReportManager {
    boolean reportLogEvent(LogEvent event);

    boolean reportTaskEvent(AgentCacheTaskEvent event);

    boolean reportToolCallRequestEvent(ToolCallRequestEvent event);

    boolean reportToolCallResponseEvent(ToolCallResponseEvent event);
}
