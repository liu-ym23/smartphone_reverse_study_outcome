package t6;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.sqlite.SQLiteStatement;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;

/* loaded from: classes3.dex */
public final class c extends EntityDeleteOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6662a;

    public /* synthetic */ c(int i) {
        this.f6662a = i;
    }

    @Override // androidx.room.EntityDeleteOrUpdateAdapter
    public final void bind(SQLiteStatement statement, Object obj) {
        switch (this.f6662a) {
            case 0:
                TaskEntity entity = (TaskEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity, "entity");
                statement.mo7170bindLong(1, entity.f4065a);
                break;
            case 1:
                TaskEntity entity2 = (TaskEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity2, "entity");
                long j5 = entity2.f4065a;
                statement.mo7170bindLong(1, j5);
                statement.mo7172bindText(2, entity2.b);
                statement.mo7170bindLong(3, entity2.c);
                statement.mo7172bindText(4, entity2.d);
                statement.mo7172bindText(5, entity2.e);
                String str = entity2.f;
                if (str == null) {
                    statement.mo7171bindNull(6);
                } else {
                    statement.mo7172bindText(6, str);
                }
                String str2 = entity2.g;
                if (str2 == null) {
                    statement.mo7171bindNull(7);
                } else {
                    statement.mo7172bindText(7, str2);
                }
                statement.mo7170bindLong(8, entity2.h);
                Long l = entity2.i;
                if (l == null) {
                    statement.mo7171bindNull(9);
                } else {
                    statement.mo7170bindLong(9, l.longValue());
                }
                Long l5 = entity2.f4066j;
                if (l5 == null) {
                    statement.mo7171bindNull(10);
                } else {
                    statement.mo7170bindLong(10, l5.longValue());
                }
                String str3 = entity2.k;
                if (str3 == null) {
                    statement.mo7171bindNull(11);
                } else {
                    statement.mo7172bindText(11, str3);
                }
                statement.mo7170bindLong(12, j5);
                break;
            case 2:
                TaskDeviceInfoEntity entity3 = (TaskDeviceInfoEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity3, "entity");
                statement.mo7170bindLong(1, entity3.f4063a);
                break;
            case 3:
                TaskDeviceInfoEntity entity4 = (TaskDeviceInfoEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity4, "entity");
                long j6 = entity4.f4063a;
                statement.mo7170bindLong(1, j6);
                statement.mo7172bindText(2, entity4.b);
                statement.mo7172bindText(3, entity4.c);
                statement.mo7172bindText(4, entity4.d);
                statement.mo7172bindText(5, entity4.e);
                statement.mo7172bindText(6, entity4.f);
                statement.mo7172bindText(7, entity4.g);
                statement.mo7172bindText(8, entity4.h);
                statement.mo7169bindDouble(9, entity4.i);
                statement.mo7170bindLong(10, entity4.f4064j);
                statement.mo7170bindLong(11, j6);
                break;
            case 4:
                TaskStepEntity entity5 = (TaskStepEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity5, "entity");
                statement.mo7170bindLong(1, entity5.f4067a);
                break;
            default:
                TaskStepEntity entity6 = (TaskStepEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity6, "entity");
                statement.mo7170bindLong(1, entity6.f4067a);
                statement.mo7172bindText(2, entity6.b);
                statement.mo7172bindText(3, entity6.c);
                statement.mo7172bindText(4, entity6.d);
                String str4 = entity6.e;
                if (str4 == null) {
                    statement.mo7171bindNull(5);
                } else {
                    statement.mo7172bindText(5, str4);
                }
                String str5 = entity6.f;
                if (str5 == null) {
                    statement.mo7171bindNull(6);
                } else {
                    statement.mo7172bindText(6, str5);
                }
                String str6 = entity6.g;
                if (str6 == null) {
                    statement.mo7171bindNull(7);
                } else {
                    statement.mo7172bindText(7, str6);
                }
                String str7 = entity6.h;
                if (str7 == null) {
                    statement.mo7171bindNull(8);
                } else {
                    statement.mo7172bindText(8, str7);
                }
                String str8 = entity6.i;
                if (str8 == null) {
                    statement.mo7171bindNull(9);
                } else {
                    statement.mo7172bindText(9, str8);
                }
                String str9 = entity6.f4068j;
                if (str9 == null) {
                    statement.mo7171bindNull(10);
                } else {
                    statement.mo7172bindText(10, str9);
                }
                statement.mo7170bindLong(11, entity6.k);
                statement.mo7170bindLong(12, entity6.l);
                Long l9 = entity6.m;
                if (l9 == null) {
                    statement.mo7171bindNull(13);
                } else {
                    statement.mo7170bindLong(13, l9.longValue());
                }
                String str10 = entity6.n;
                if (str10 == null) {
                    statement.mo7171bindNull(14);
                } else {
                    statement.mo7172bindText(14, str10);
                }
                statement.mo7170bindLong(15, entity6.o);
                statement.mo7170bindLong(16, entity6.p);
                String str11 = entity6.f4069q;
                if (str11 == null) {
                    statement.mo7171bindNull(17);
                } else {
                    statement.mo7172bindText(17, str11);
                }
                statement.mo7170bindLong(18, entity6.f4067a);
                break;
        }
    }

    @Override // androidx.room.EntityDeleteOrUpdateAdapter
    public final String createQuery() {
        switch (this.f6662a) {
            case 0:
                return "DELETE FROM `task` WHERE `id` = ?";
            case 1:
                return "UPDATE OR ABORT `task` SET `id` = ?,`taskId` = ?,`deviceInfoId` = ?,`taskName` = ?,`taskDesc` = ?,`guiTree` = ?,`result` = ?,`createTime` = ?,`endTime` = ?,`durationTime` = ?,`coverImage` = ? WHERE `id` = ?";
            case 2:
                return "DELETE FROM `task_device_info` WHERE `id` = ?";
            case 3:
                return "UPDATE OR ABORT `task_device_info` SET `id` = ?,`brand` = ?,`userId` = ?,`deviceId` = ?,`model` = ?,`product` = ?,`osVersion` = ?,`resolution` = ?,`density` = ?,`createTime` = ? WHERE `id` = ?";
            case 4:
                return "DELETE FROM `task_step` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `task_step` SET `id` = ?,`actionId` = ?,`taskId` = ?,`actionType` = ?,`prompt` = ?,`screenshotPath` = ?,`actionContent` = ?,`appName` = ?,`appVersion` = ?,`currActivity` = ?,`orientation` = ?,`startTime` = ?,`endTime` = ?,`actionResult` = ?,`screenshotUploadDuration` = ?,`inferenceDuration` = ?,`durationData` = ? WHERE `id` = ?";
        }
    }
}
