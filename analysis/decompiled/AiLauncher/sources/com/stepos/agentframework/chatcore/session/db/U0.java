package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import f1.C4031a;
import f1.C4039i;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.RobotInfo;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/U0;", "Lcom/stepos/agentframework/chatcore/session/db/R0;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/h;", "robotInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/h;)V", "", "taskId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lw4/h;", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfRobotInfo", "Landroidx/room/f;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class U0 implements R0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final AbstractC1410f<RobotInfo> __insertAdapterOfRobotInfo;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/U0$a", "Landroidx/room/f;", "Lw4/h;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/h;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<RobotInfo> {
        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR REPLACE INTO `task_robot_info` (`task_id`,`status`,`source_from`,`error_msg`,`first_run_time`,`update_time`,`task_name`,`task_desc`,`latest_screenshot_path`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, RobotInfo entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getTaskId());
            statement.H(2, entity.getStatus());
            statement.H(3, entity.getSourceFrom());
            String errorMessage = entity.getErrorMessage();
            if (errorMessage == null) {
                statement.bindNull(4);
            } else {
                statement.H(4, errorMessage);
            }
            statement.bindLong(5, entity.getFirstRunTime());
            statement.bindLong(6, entity.getUpdateTime());
            String taskName = entity.getTaskName();
            if (taskName == null) {
                statement.bindNull(7);
            } else {
                statement.H(7, taskName);
            }
            String taskDesc = entity.getTaskDesc();
            if (taskDesc == null) {
                statement.bindNull(8);
            } else {
                statement.H(8, taskDesc);
            }
            String latestScreenshotPath = entity.getLatestScreenshotPath();
            if (latestScreenshotPath == null) {
                statement.bindNull(9);
            } else {
                statement.H(9, latestScreenshotPath);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/U0$b;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.U0$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<InterfaceC5745d<?>> a() {
            return C1173v.m();
        }

        public Companion() {
        }
    }

    public U0(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRobotInfo = new a();
    }

    public static final RobotInfo e(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, "task_id");
            int iC2 = C4039i.c(interfaceC4162dQ1, "status");
            int iC3 = C4039i.c(interfaceC4162dQ1, "source_from");
            int iC4 = C4039i.c(interfaceC4162dQ1, "error_msg");
            int iC5 = C4039i.c(interfaceC4162dQ1, "first_run_time");
            int iC6 = C4039i.c(interfaceC4162dQ1, "update_time");
            int iC7 = C4039i.c(interfaceC4162dQ1, "task_name");
            int iC8 = C4039i.c(interfaceC4162dQ1, "task_desc");
            int iC9 = C4039i.c(interfaceC4162dQ1, "latest_screenshot_path");
            RobotInfo robotInfo = null;
            if (interfaceC4162dQ1.n1()) {
                robotInfo = new RobotInfo(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.isNull(iC4) ? null : interfaceC4162dQ1.X0(iC4), interfaceC4162dQ1.getLong(iC5), interfaceC4162dQ1.getLong(iC6), interfaceC4162dQ1.isNull(iC7) ? null : interfaceC4162dQ1.X0(iC7), interfaceC4162dQ1.isNull(iC8) ? null : interfaceC4162dQ1.X0(iC8), interfaceC4162dQ1.isNull(iC9) ? null : interfaceC4162dQ1.X0(iC9));
            }
            return robotInfo;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t f(U0 u02, RobotInfo robotInfo, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        u02.__insertAdapterOfRobotInfo.d(_connection, robotInfo);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.session.db.R0
    public void a(final RobotInfo robotInfo) {
        kotlin.jvm.internal.p.i(robotInfo, "robotInfo");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.S0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return U0.f(this.f22534a, robotInfo, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.R0
    public RobotInfo b(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        final String str = "select * from task_robot_info where task_id = (?)";
        return (RobotInfo) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.T0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return U0.e(str, taskId, (InterfaceC4160b) obj);
            }
        });
    }
}
