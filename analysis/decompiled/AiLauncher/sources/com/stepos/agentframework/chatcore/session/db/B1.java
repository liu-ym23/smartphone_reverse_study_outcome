package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/B1;", "", "Lw4/l;", "link", "LY8/t;", "c", "(Lw4/l;)V", "", "subSessionKey", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lw4/l;", "taskId", "e", Const.INTENT_KEY_UMID, "()Lw4/l;", Const.INTENT_KEY_APIKEY, "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface B1 {
    void a();

    TaskSessionLink b(String subSessionKey);

    void c(TaskSessionLink link);

    TaskSessionLink d();

    TaskSessionLink e(String taskId);
}
