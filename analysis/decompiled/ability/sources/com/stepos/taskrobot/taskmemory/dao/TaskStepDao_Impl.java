package com.stepos.taskrobot.taskmemory.dao;

import C7.r;
import R3.d;
import R3.f;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import d4.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import t5.C2016a;
import t6.c;
import t6.g;
import t6.i;
import t6.j;
import t6.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\u00020\r2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u00150\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u000fJ\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b#\u0010\u001bJ\u0019\u0010$\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010+J/\u0010-\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0016H\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:¨\u0006>"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskStepDao_Impl;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskStepDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "step", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)J", "", "list", "LC7/r;", "insertList", "(Ljava/util/List;)V", "delete", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)V", "", "update", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)I", "Lkotlin/Pair;", "", AlgorithmUpdateBundle.KEY_UPDATES, "updateMultipleDurationData", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "getStepsByTaskId", "(Ljava/lang/String;)Ljava/util/List;", "id", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "getFirstStepByTaskId", "(Ljava/lang/String;)Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "getSteps", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getDurationDataByTaskId", "getDurationDataById", "(J)Ljava/lang/String;", "deleteByTaskId", "(Ljava/lang/String;)V", "actionResult", "endTime", "updatePartialById", "(JLjava/lang/String;J)V", "screenshotPath", "updatePartialFieldsById", "(JLjava/lang/String;JLjava/lang/String;)V", "deleteAllSteps", "()V", "durationData", "updateDurationDataById", "(JLjava/lang/String;)I", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfTaskStepEntity", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfTaskStepEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfTaskStepEntity", "Companion", "t6/l", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStepDao_Impl implements TaskStepDao {
    public static final l Companion = new l();
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<TaskStepEntity> __deleteAdapterOfTaskStepEntity;
    private final EntityInsertAdapter<TaskStepEntity> __insertAdapterOfTaskStepEntity;
    private final EntityDeleteOrUpdateAdapter<TaskStepEntity> __updateAdapterOfTaskStepEntity;

    public TaskStepDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskStepEntity = new d(7);
        this.__deleteAdapterOfTaskStepEntity = new c(4);
        this.__updateAdapterOfTaskStepEntity = new c(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r delete$lambda$0(TaskStepDao_Impl taskStepDao_Impl, TaskStepEntity taskStepEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskStepDao_Impl.__deleteAdapterOfTaskStepEntity.handle(_connection, taskStepEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteAllSteps$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskStepEntity getById$lambda$0(String str, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, j5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionType");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, HighlightArgsBundle.KEY_PROMPT);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotPath");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionContent");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currActivity");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "orientation");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTime");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionResult");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotUploadDuration");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inferenceDuration");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationData");
            TaskStepEntity taskStepEntity = null;
            if (sQLiteStatementPrepare.step()) {
                taskStepEntity = new TaskStepEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11), sQLiteStatementPrepare.getLong(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow13)), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.getLong(columnIndexOrThrow15), sQLiteStatementPrepare.getLong(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17));
            }
            return taskStepEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDurationDataById$lambda$0(String str, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, j5);
            String text = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                text = sQLiteStatementPrepare.getText(0);
            }
            return text;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getDurationDataByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskStepEntity getFirstStepByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionType");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, HighlightArgsBundle.KEY_PROMPT);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotPath");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionContent");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currActivity");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "orientation");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTime");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionResult");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotUploadDuration");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inferenceDuration");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationData");
            TaskStepEntity taskStepEntity = null;
            if (sQLiteStatementPrepare.step()) {
                taskStepEntity = new TaskStepEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11), sQLiteStatementPrepare.getLong(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow13)), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.getLong(columnIndexOrThrow15), sQLiteStatementPrepare.getLong(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17));
            }
            return taskStepEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getSteps$lambda$0(String str, String str2, SQLiteConnection _connection) {
        String text;
        int i;
        int i6;
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionType");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, HighlightArgsBundle.KEY_PROMPT);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotPath");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionContent");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currActivity");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "orientation");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTime");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionResult");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotUploadDuration");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inferenceDuration");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationData");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                long j5 = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow10)) {
                    text = null;
                    i6 = columnIndexOrThrow2;
                    i = columnIndexOrThrow3;
                } else {
                    text = sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                    i = columnIndexOrThrow3;
                    i6 = columnIndexOrThrow2;
                }
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11);
                long j6 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow13));
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i11 = columnIndexOrThrow15;
                long j10 = sQLiteStatementPrepare.getLong(i11);
                int i12 = columnIndexOrThrow;
                int i13 = columnIndexOrThrow16;
                long j11 = sQLiteStatementPrepare.getLong(i13);
                columnIndexOrThrow16 = i13;
                int i14 = columnIndexOrThrow17;
                arrayList.add(new TaskStepEntity(j5, text2, text3, text4, text5, text6, text7, text8, text9, text, i10, j6, lValueOf, text10, j10, j11, sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14)));
                columnIndexOrThrow17 = i14;
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow = i12;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow3 = i;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getStepsByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        String text;
        int i;
        int i6;
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionType");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, HighlightArgsBundle.KEY_PROMPT);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotPath");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionContent");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currActivity");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "orientation");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTime");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "actionResult");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "screenshotUploadDuration");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inferenceDuration");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationData");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                long j5 = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow10)) {
                    text = null;
                    i6 = columnIndexOrThrow2;
                    i = columnIndexOrThrow3;
                } else {
                    text = sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                    i = columnIndexOrThrow3;
                    i6 = columnIndexOrThrow2;
                }
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11);
                long j6 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow13));
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i11 = columnIndexOrThrow15;
                long j10 = sQLiteStatementPrepare.getLong(i11);
                int i12 = columnIndexOrThrow;
                int i13 = columnIndexOrThrow16;
                long j11 = sQLiteStatementPrepare.getLong(i13);
                columnIndexOrThrow16 = i13;
                int i14 = columnIndexOrThrow17;
                arrayList.add(new TaskStepEntity(j5, text2, text3, text4, text5, text6, text7, text8, text9, text, i10, j6, lValueOf, text10, j10, j11, sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14)));
                columnIndexOrThrow17 = i14;
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow = i12;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow3 = i;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(TaskStepDao_Impl taskStepDao_Impl, TaskStepEntity taskStepEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        return taskStepDao_Impl.__insertAdapterOfTaskStepEntity.insertAndReturnId(_connection, taskStepEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertList$lambda$0(TaskStepDao_Impl taskStepDao_Impl, List list, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskStepDao_Impl.__insertAdapterOfTaskStepEntity.insert(_connection, list);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int update$lambda$0(TaskStepDao_Impl taskStepDao_Impl, TaskStepEntity taskStepEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        return taskStepDao_Impl.__updateAdapterOfTaskStepEntity.handle(_connection, taskStepEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int updateDurationDataById$lambda$0(String str, String str2, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateMultipleDurationData$lambda$0(TaskStepDao_Impl taskStepDao_Impl, List list, SQLiteConnection sQLiteConnection) {
        k.f(sQLiteConnection, "<unused var>");
        super.updateMultipleDurationData(list);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updatePartialById$lambda$0(String str, String str2, long j5, long j6, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.mo7170bindLong(3, j6);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updatePartialFieldsById$lambda$0(String str, String str2, long j5, String str3, long j6, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.mo7172bindText(3, str3);
            sQLiteStatementPrepare.mo7170bindLong(4, j6);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void delete(TaskStepEntity step) {
        k.f(step, "step");
        DBUtil.performBlocking(this.__db, false, true, new g(this, step, 1));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void deleteAllSteps() {
        DBUtil.performBlocking(this.__db, false, true, new C2016a(19));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void deleteByTaskId(String taskId) {
        k.f(taskId, "taskId");
        DBUtil.performBlocking(this.__db, false, true, new i(taskId, 1));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public TaskStepEntity getById(long id) {
        return (TaskStepEntity) DBUtil.performBlocking(this.__db, true, false, new f(id, 12));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public String getDurationDataById(long id) {
        return (String) DBUtil.performBlocking(this.__db, true, false, new f(id, 11));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public List<String> getDurationDataByTaskId(String taskId) {
        k.f(taskId, "taskId");
        return (List) DBUtil.performBlocking(this.__db, true, false, new R3.c(taskId, 29));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public TaskStepEntity getFirstStepByTaskId(String taskId) {
        k.f(taskId, "taskId");
        return (TaskStepEntity) DBUtil.performBlocking(this.__db, true, false, new i(taskId, 0));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public Object getSteps(String str, H7.c<? super List<TaskStepEntity>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new R3.c(str, 27), cVar);
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public List<TaskStepEntity> getStepsByTaskId(String taskId) {
        k.f(taskId, "taskId");
        return (List) DBUtil.performBlocking(this.__db, true, false, new R3.c(taskId, 28));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public long insert(TaskStepEntity step) {
        k.f(step, "step");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new g(this, step, 2))).longValue();
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void insertList(List<TaskStepEntity> list) {
        k.f(list, "list");
        DBUtil.performBlocking(this.__db, false, true, new j(this, list, 0));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public int update(TaskStepEntity step) {
        k.f(step, "step");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new g(this, step, 0))).intValue();
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public int updateDurationDataById(long id, String durationData) {
        k.f(durationData, "durationData");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new b(durationData, id, 2))).intValue();
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void updateMultipleDurationData(List<Pair<Long, String>> updates) {
        k.f(updates, "updates");
        DBUtil.performBlocking(this.__db, false, true, new j(this, updates, 1));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void updatePartialById(final long id, final String actionResult, final long endTime) {
        k.f(actionResult, "actionResult");
        DBUtil.performBlocking(this.__db, false, true, new S7.k() { // from class: t6.h
            @Override // S7.k
            public final Object invoke(Object obj) {
                return TaskStepDao_Impl.updatePartialById$lambda$0("UPDATE task_step SET actionResult = ?, endTime = ? WHERE id = ?", actionResult, endTime, id, (SQLiteConnection) obj);
            }
        });
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskStepDao
    public void updatePartialFieldsById(final long id, final String actionResult, final long endTime, final String screenshotPath) {
        k.f(actionResult, "actionResult");
        k.f(screenshotPath, "screenshotPath");
        DBUtil.performBlocking(this.__db, false, true, new S7.k() { // from class: t6.k
            @Override // S7.k
            public final Object invoke(Object obj) {
                String str = actionResult;
                String str2 = screenshotPath;
                return TaskStepDao_Impl.updatePartialFieldsById$lambda$0("UPDATE task_step SET actionResult = ?, endTime = ?, screenshotPath = ? WHERE id = ?", str, endTime, str2, id, (SQLiteConnection) obj);
            }
        });
    }
}
