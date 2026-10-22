package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/R0;", "", "Lw4/h;", "robotInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/h;)V", "", "taskId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lw4/h;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface R0 {
    void a(RobotInfo robotInfo);

    RobotInfo b(String taskId);
}
