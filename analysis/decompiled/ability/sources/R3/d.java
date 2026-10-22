package R3;

import androidx.room.EntityInsertAdapter;
import androidx.sqlite.SQLiteStatement;
import com.stepos.ability.database.entity.AbilityEntity;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;

/* loaded from: classes3.dex */
public final class d extends EntityInsertAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1145a;

    public /* synthetic */ d(int i) {
        this.f1145a = i;
    }

    @Override // androidx.room.EntityInsertAdapter
    public final void bind(SQLiteStatement statement, Object obj) {
        switch (this.f1145a) {
            case 0:
                AbilityEntity entity = (AbilityEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity, "entity");
                statement.mo7170bindLong(1, entity.f3080a);
                statement.mo7172bindText(2, entity.b);
                statement.mo7172bindText(3, entity.c);
                statement.mo7172bindText(4, entity.d);
                statement.mo7172bindText(5, entity.e);
                statement.mo7170bindLong(6, entity.f);
                statement.mo7172bindText(7, entity.g);
                statement.mo7170bindLong(8, entity.h);
                statement.mo7172bindText(9, entity.i);
                break;
            case 1:
                AbilityReportTaskEntity entity2 = (AbilityReportTaskEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity2, "entity");
                statement.mo7170bindLong(1, entity2.f3081a);
                statement.mo7170bindLong(2, entity2.b);
                statement.mo7172bindText(3, entity2.c);
                statement.mo7172bindText(4, entity2.d);
                statement.mo7172bindText(5, entity2.e);
                statement.mo7172bindText(6, entity2.f);
                statement.mo7170bindLong(7, entity2.g);
                statement.mo7170bindLong(8, entity2.h);
                break;
            case 2:
                AbilityTaskEntity entity3 = (AbilityTaskEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity3, "entity");
                statement.mo7170bindLong(1, entity3.f3082a);
                statement.mo7172bindText(2, entity3.b);
                Long l = entity3.c;
                if (l == null) {
                    statement.mo7171bindNull(3);
                } else {
                    statement.mo7170bindLong(3, l.longValue());
                }
                statement.mo7172bindText(4, entity3.d);
                statement.mo7172bindText(5, entity3.e);
                String str = entity3.f;
                if (str == null) {
                    statement.mo7171bindNull(6);
                } else {
                    statement.mo7172bindText(6, str);
                }
                String str2 = entity3.g;
                if (str2 == null) {
                    statement.mo7171bindNull(7);
                } else {
                    statement.mo7172bindText(7, str2);
                }
                statement.mo7172bindText(8, entity3.h);
                statement.mo7170bindLong(9, entity3.i);
                statement.mo7170bindLong(10, entity3.f3083j);
                statement.mo7170bindLong(11, entity3.k);
                statement.mo7170bindLong(12, entity3.l ? 1L : 0L);
                statement.mo7172bindText(13, entity3.m);
                statement.mo7172bindText(14, entity3.n);
                statement.mo7170bindLong(15, entity3.o);
                break;
            case 3:
                AtomicAbilityEntity entity4 = (AtomicAbilityEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity4, "entity");
                statement.mo7172bindText(1, entity4.f3084a);
                statement.mo7172bindText(2, entity4.b);
                statement.mo7172bindText(3, entity4.c);
                statement.mo7170bindLong(4, entity4.d);
                statement.mo7170bindLong(5, entity4.e);
                statement.mo7172bindText(6, entity4.f);
                statement.mo7172bindText(7, entity4.g);
                statement.mo7172bindText(8, entity4.h);
                if (entity4.i == null) {
                    statement.mo7171bindNull(9);
                } else {
                    statement.mo7170bindLong(9, r3.intValue());
                }
                statement.mo7172bindText(10, entity4.f3085j);
                String str3 = entity4.k;
                if (str3 == null) {
                    statement.mo7171bindNull(11);
                } else {
                    statement.mo7172bindText(11, str3);
                }
                String str4 = entity4.l;
                if (str4 == null) {
                    statement.mo7171bindNull(12);
                } else {
                    statement.mo7172bindText(12, str4);
                }
                String str5 = entity4.m;
                if (str5 == null) {
                    statement.mo7171bindNull(13);
                } else {
                    statement.mo7172bindText(13, str5);
                }
                String str6 = entity4.n;
                if (str6 == null) {
                    statement.mo7171bindNull(14);
                } else {
                    statement.mo7172bindText(14, str6);
                }
                String str7 = entity4.o;
                if (str7 == null) {
                    statement.mo7171bindNull(15);
                } else {
                    statement.mo7172bindText(15, str7);
                }
                String str8 = entity4.p;
                if (str8 == null) {
                    statement.mo7171bindNull(16);
                } else {
                    statement.mo7172bindText(16, str8);
                }
                String str9 = entity4.f3086q;
                if (str9 == null) {
                    statement.mo7171bindNull(17);
                } else {
                    statement.mo7172bindText(17, str9);
                }
                statement.mo7172bindText(18, entity4.f3087r);
                String str10 = entity4.f3088s;
                if (str10 == null) {
                    statement.mo7171bindNull(19);
                } else {
                    statement.mo7172bindText(19, str10);
                }
                String str11 = entity4.f3089t;
                if (str11 == null) {
                    statement.mo7171bindNull(20);
                } else {
                    statement.mo7172bindText(20, str11);
                }
                String str12 = entity4.u;
                if (str12 == null) {
                    statement.mo7171bindNull(21);
                } else {
                    statement.mo7172bindText(21, str12);
                }
                String str13 = entity4.f3090v;
                if (str13 == null) {
                    statement.mo7171bindNull(22);
                } else {
                    statement.mo7172bindText(22, str13);
                }
                statement.mo7170bindLong(23, entity4.f3091w);
                String str14 = entity4.f3092x;
                if (str14 != null) {
                    statement.mo7172bindText(24, str14);
                    break;
                } else {
                    statement.mo7171bindNull(24);
                    break;
                }
            case 4:
                SyncCacheMetaEntity entity5 = (SyncCacheMetaEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity5, "entity");
                statement.mo7170bindLong(1, entity5.f3093a);
                statement.mo7170bindLong(2, entity5.b);
                statement.mo7170bindLong(3, entity5.c);
                statement.mo7170bindLong(4, entity5.d);
                statement.mo7170bindLong(5, entity5.e);
                statement.mo7170bindLong(6, entity5.f);
                statement.mo7172bindText(7, entity5.g);
                break;
            case 5:
                TaskEntity entity6 = (TaskEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity6, "entity");
                statement.mo7170bindLong(1, entity6.f4065a);
                statement.mo7172bindText(2, entity6.b);
                statement.mo7170bindLong(3, entity6.c);
                statement.mo7172bindText(4, entity6.d);
                statement.mo7172bindText(5, entity6.e);
                String str15 = entity6.f;
                if (str15 == null) {
                    statement.mo7171bindNull(6);
                } else {
                    statement.mo7172bindText(6, str15);
                }
                String str16 = entity6.g;
                if (str16 == null) {
                    statement.mo7171bindNull(7);
                } else {
                    statement.mo7172bindText(7, str16);
                }
                statement.mo7170bindLong(8, entity6.h);
                Long l5 = entity6.i;
                if (l5 == null) {
                    statement.mo7171bindNull(9);
                } else {
                    statement.mo7170bindLong(9, l5.longValue());
                }
                Long l9 = entity6.f4066j;
                if (l9 == null) {
                    statement.mo7171bindNull(10);
                } else {
                    statement.mo7170bindLong(10, l9.longValue());
                }
                String str17 = entity6.k;
                if (str17 != null) {
                    statement.mo7172bindText(11, str17);
                    break;
                } else {
                    statement.mo7171bindNull(11);
                    break;
                }
            case 6:
                TaskDeviceInfoEntity entity7 = (TaskDeviceInfoEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity7, "entity");
                statement.mo7170bindLong(1, entity7.f4063a);
                statement.mo7172bindText(2, entity7.b);
                statement.mo7172bindText(3, entity7.c);
                statement.mo7172bindText(4, entity7.d);
                statement.mo7172bindText(5, entity7.e);
                statement.mo7172bindText(6, entity7.f);
                statement.mo7172bindText(7, entity7.g);
                statement.mo7172bindText(8, entity7.h);
                statement.mo7169bindDouble(9, entity7.i);
                statement.mo7170bindLong(10, entity7.f4064j);
                break;
            default:
                TaskStepEntity entity8 = (TaskStepEntity) obj;
                kotlin.jvm.internal.k.f(statement, "statement");
                kotlin.jvm.internal.k.f(entity8, "entity");
                statement.mo7170bindLong(1, entity8.f4067a);
                statement.mo7172bindText(2, entity8.b);
                statement.mo7172bindText(3, entity8.c);
                statement.mo7172bindText(4, entity8.d);
                String str18 = entity8.e;
                if (str18 == null) {
                    statement.mo7171bindNull(5);
                } else {
                    statement.mo7172bindText(5, str18);
                }
                String str19 = entity8.f;
                if (str19 == null) {
                    statement.mo7171bindNull(6);
                } else {
                    statement.mo7172bindText(6, str19);
                }
                String str20 = entity8.g;
                if (str20 == null) {
                    statement.mo7171bindNull(7);
                } else {
                    statement.mo7172bindText(7, str20);
                }
                String str21 = entity8.h;
                if (str21 == null) {
                    statement.mo7171bindNull(8);
                } else {
                    statement.mo7172bindText(8, str21);
                }
                String str22 = entity8.i;
                if (str22 == null) {
                    statement.mo7171bindNull(9);
                } else {
                    statement.mo7172bindText(9, str22);
                }
                String str23 = entity8.f4068j;
                if (str23 == null) {
                    statement.mo7171bindNull(10);
                } else {
                    statement.mo7172bindText(10, str23);
                }
                statement.mo7170bindLong(11, entity8.k);
                statement.mo7170bindLong(12, entity8.l);
                Long l10 = entity8.m;
                if (l10 == null) {
                    statement.mo7171bindNull(13);
                } else {
                    statement.mo7170bindLong(13, l10.longValue());
                }
                String str24 = entity8.n;
                if (str24 == null) {
                    statement.mo7171bindNull(14);
                } else {
                    statement.mo7172bindText(14, str24);
                }
                statement.mo7170bindLong(15, entity8.o);
                statement.mo7170bindLong(16, entity8.p);
                String str25 = entity8.f4069q;
                if (str25 != null) {
                    statement.mo7172bindText(17, str25);
                    break;
                } else {
                    statement.mo7171bindNull(17);
                    break;
                }
        }
    }

    @Override // androidx.room.EntityInsertAdapter
    public final String createQuery() {
        switch (this.f1145a) {
            case 0:
                return "INSERT OR REPLACE INTO `t_ability` (`id`,`packageName`,`version`,`status`,`icon`,`updateTime`,`syncStatus`,`syncTime`,`tools`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `t_ability_report_task` (`id`,`timestamp`,`taskCode`,`packageName`,`installType`,`payload`,`status`,`retryCount`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `t_ability_task` (`id`,`taskCode`,`abilityId`,`pkgName`,`method`,`paramsJson`,`extra`,`status`,`retryCount`,`priority`,`createTime`,`is_cloud_ability`,`trace_id`,`tool_call_id`,`timeout`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            case 3:
                return "INSERT OR REPLACE INTO `t_atomic_ability` (`packageName`,`toolName`,`functionName`,`abilityId`,`appId`,`description`,`callType`,`callingMethod`,`timeout`,`deviceType`,`type`,`capabilityType`,`permission`,`inputSchemaJson`,`outputSchemaJson`,`extraJson`,`toolVersion`,`appName`,`appVersion`,`appSource`,`authType`,`signature`,`updateTime`,`slaScene`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `t_sync_cache_meta` (`id`,`localScanGeneration`,`cloudSyncGeneration`,`localScanCompletedAt`,`cloudSyncCompletedAt`,`uploadLastSuccessAt`,`deviceId`) VALUES (?,?,?,?,?,?,?)";
            case 5:
                return "INSERT OR REPLACE INTO `task` (`id`,`taskId`,`deviceInfoId`,`taskName`,`taskDesc`,`guiTree`,`result`,`createTime`,`endTime`,`durationTime`,`coverImage`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            case 6:
                return "INSERT OR REPLACE INTO `task_device_info` (`id`,`brand`,`userId`,`deviceId`,`model`,`product`,`osVersion`,`resolution`,`density`,`createTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR REPLACE INTO `task_step` (`id`,`actionId`,`taskId`,`actionType`,`prompt`,`screenshotPath`,`actionContent`,`appName`,`appVersion`,`currActivity`,`orientation`,`startTime`,`endTime`,`actionResult`,`screenshotUploadDuration`,`inferenceDuration`,`durationData`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }
}
