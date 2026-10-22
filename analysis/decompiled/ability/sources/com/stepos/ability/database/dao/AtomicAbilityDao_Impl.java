package com.stepos.ability.database.dao;

import Ba.f;
import C7.r;
import H7.c;
import R3.d;
import R3.l;
import R3.m;
import androidx.compose.foundation.b;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0012J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u001a\u0010\u0012J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0096@¢\u0006\u0004\b \u0010\u000bJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0096@¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\"\u0010\u001eJ\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b#\u0010\u0012J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b$\u0010\u0012J&\u0010&\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0096@¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tH\u0096@¢\u0006\u0004\b(\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/stepos/ability/database/dao/AtomicAbilityDao_Impl;", "Lcom/stepos/ability/database/dao/AtomicAbilityDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "", "Lcom/stepos/ability/database/entity/AtomicAbilityEntity;", "entities", "LC7/r;", "insertOrReplaceAll", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "entity", "insertOrReplace", "(Lcom/stepos/ability/database/entity/AtomicAbilityEntity;LH7/c;)Ljava/lang/Object;", "", "toolName", "getByToolName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "functionName", "getByFunctionName", "", "abilityId", "getByAbilityId", "(ILH7/c;)Ljava/lang/Object;", "packageName", "getByPackageName", "getByPackageAndFunction", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getAll", "(LH7/c;)Ljava/lang/Object;", "appNames", "getByAppNames", "getAllPackageNames", "count", "deleteByToolName", "deleteByPackageName", "functionNames", "deleteByPackageNameExceptFunctionNames", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "deleteAll", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfAtomicAbilityEntity", "Landroidx/room/EntityInsertAdapter;", "Companion", "R3/m", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AtomicAbilityDao_Impl implements AtomicAbilityDao {
    public static final m Companion = new m();
    private final RoomDatabase __db;
    private final EntityInsertAdapter<AtomicAbilityEntity> __insertAdapterOfAtomicAbilityEntity;

    public AtomicAbilityDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAtomicAbilityEntity = new d(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int count$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteAll$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final r deleteByPackageName$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final r deleteByPackageNameExceptFunctionNames$lambda$0(String str, String str2, List list, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            Iterator it = list.iterator();
            int i = 2;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo7172bindText(i, (String) it.next());
                i++;
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteByToolName$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final List getAll$lambda$0(String str, SQLiteConnection _connection) {
        int i;
        Integer numValueOf;
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                int i6 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow9)) {
                    i = i12;
                    numValueOf = null;
                } else {
                    i = i12;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9));
                }
                String text7 = sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i13 = columnIndexOrThrow15;
                String text12 = sQLiteStatementPrepare.isNull(i13) ? null : sQLiteStatementPrepare.getText(i13);
                int i14 = columnIndexOrThrow16;
                String text13 = sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow17;
                String text14 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                columnIndexOrThrow17 = i16;
                int i17 = columnIndexOrThrow18;
                String text15 = sQLiteStatementPrepare.getText(i17);
                columnIndexOrThrow18 = i17;
                int i18 = columnIndexOrThrow19;
                String text16 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                columnIndexOrThrow19 = i18;
                int i19 = columnIndexOrThrow20;
                String text17 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                columnIndexOrThrow20 = i19;
                int i20 = columnIndexOrThrow21;
                String text18 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                columnIndexOrThrow21 = i20;
                int i21 = columnIndexOrThrow22;
                String text19 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                columnIndexOrThrow22 = i21;
                int i22 = columnIndexOrThrow23;
                long j5 = sQLiteStatementPrepare.getLong(i22);
                columnIndexOrThrow23 = i22;
                int i23 = columnIndexOrThrow24;
                columnIndexOrThrow24 = i23;
                arrayList.add(new AtomicAbilityEntity(text, text2, text3, i11, i, text4, text5, text6, numValueOf, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, j5, sQLiteStatementPrepare.isNull(i23) ? null : sQLiteStatementPrepare.getText(i23)));
                columnIndexOrThrow = i15;
                columnIndexOrThrow15 = i13;
                columnIndexOrThrow16 = i14;
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i10;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllPackageNames$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicAbilityEntity getByAbilityId$lambda$0(String str, int i, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, i);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            AtomicAbilityEntity atomicAbilityEntity = null;
            if (sQLiteStatementPrepare.step()) {
                atomicAbilityEntity = new AtomicAbilityEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow15), sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.getLong(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24));
            }
            return atomicAbilityEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getByAppNames$lambda$0(String str, List list, SQLiteConnection _connection) {
        int i;
        Integer numValueOf;
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i6 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo7172bindText(i6, (String) it.next());
                i6++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                int i10 = columnIndexOrThrow2;
                int i11 = columnIndexOrThrow3;
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow9)) {
                    i = i13;
                    numValueOf = null;
                } else {
                    i = i13;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9));
                }
                String text7 = sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i14 = columnIndexOrThrow15;
                String text12 = sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14);
                int i15 = columnIndexOrThrow16;
                String text13 = sQLiteStatementPrepare.isNull(i15) ? null : sQLiteStatementPrepare.getText(i15);
                int i16 = columnIndexOrThrow;
                int i17 = columnIndexOrThrow17;
                String text14 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                columnIndexOrThrow17 = i17;
                int i18 = columnIndexOrThrow18;
                String text15 = sQLiteStatementPrepare.getText(i18);
                columnIndexOrThrow18 = i18;
                int i19 = columnIndexOrThrow19;
                String text16 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                columnIndexOrThrow19 = i19;
                int i20 = columnIndexOrThrow20;
                String text17 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                columnIndexOrThrow20 = i20;
                int i21 = columnIndexOrThrow21;
                String text18 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                columnIndexOrThrow21 = i21;
                int i22 = columnIndexOrThrow22;
                String text19 = sQLiteStatementPrepare.isNull(i22) ? null : sQLiteStatementPrepare.getText(i22);
                columnIndexOrThrow22 = i22;
                int i23 = columnIndexOrThrow23;
                long j5 = sQLiteStatementPrepare.getLong(i23);
                columnIndexOrThrow23 = i23;
                int i24 = columnIndexOrThrow24;
                columnIndexOrThrow24 = i24;
                arrayList.add(new AtomicAbilityEntity(text, text2, text3, i12, i, text4, text5, text6, numValueOf, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, j5, sQLiteStatementPrepare.isNull(i24) ? null : sQLiteStatementPrepare.getText(i24)));
                columnIndexOrThrow = i16;
                columnIndexOrThrow15 = i14;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow2 = i10;
                columnIndexOrThrow3 = i11;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicAbilityEntity getByFunctionName$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            AtomicAbilityEntity atomicAbilityEntity = null;
            if (sQLiteStatementPrepare.step()) {
                atomicAbilityEntity = new AtomicAbilityEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow15), sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.getLong(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24));
            }
            return atomicAbilityEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicAbilityEntity getByPackageAndFunction$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7172bindText(2, str3);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            AtomicAbilityEntity atomicAbilityEntity = null;
            if (sQLiteStatementPrepare.step()) {
                atomicAbilityEntity = new AtomicAbilityEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow15), sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.getLong(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24));
            }
            return atomicAbilityEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getByPackageName$lambda$0(String str, String str2, SQLiteConnection _connection) {
        int i;
        Integer numValueOf;
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                int i6 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow9)) {
                    i = i12;
                    numValueOf = null;
                } else {
                    i = i12;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9));
                }
                String text7 = sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i13 = columnIndexOrThrow15;
                String text12 = sQLiteStatementPrepare.isNull(i13) ? null : sQLiteStatementPrepare.getText(i13);
                int i14 = columnIndexOrThrow16;
                String text13 = sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow17;
                String text14 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                columnIndexOrThrow17 = i16;
                int i17 = columnIndexOrThrow18;
                String text15 = sQLiteStatementPrepare.getText(i17);
                columnIndexOrThrow18 = i17;
                int i18 = columnIndexOrThrow19;
                String text16 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                columnIndexOrThrow19 = i18;
                int i19 = columnIndexOrThrow20;
                String text17 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                columnIndexOrThrow20 = i19;
                int i20 = columnIndexOrThrow21;
                String text18 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                columnIndexOrThrow21 = i20;
                int i21 = columnIndexOrThrow22;
                String text19 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                columnIndexOrThrow22 = i21;
                int i22 = columnIndexOrThrow23;
                long j5 = sQLiteStatementPrepare.getLong(i22);
                columnIndexOrThrow23 = i22;
                int i23 = columnIndexOrThrow24;
                columnIndexOrThrow24 = i23;
                arrayList.add(new AtomicAbilityEntity(text, text2, text3, i11, i, text4, text5, text6, numValueOf, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, j5, sQLiteStatementPrepare.isNull(i23) ? null : sQLiteStatementPrepare.getText(i23)));
                columnIndexOrThrow = i15;
                columnIndexOrThrow15 = i13;
                columnIndexOrThrow16 = i14;
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i10;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicAbilityEntity getByToolName$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "functionName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appId");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callType");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "callingMethod");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "capabilityType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permission");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "inputSchemaJson");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "outputSchemaJson");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extraJson");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "toolVersion");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appName");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appVersion");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "appSource");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "authType");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "signature");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SLAScene.SLA_SCENE);
            AtomicAbilityEntity atomicAbilityEntity = null;
            if (sQLiteStatementPrepare.step()) {
                atomicAbilityEntity = new AtomicAbilityEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14), sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow15), sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.getLong(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24));
            }
            return atomicAbilityEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertOrReplace$lambda$0(AtomicAbilityDao_Impl atomicAbilityDao_Impl, AtomicAbilityEntity atomicAbilityEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        atomicAbilityDao_Impl.__insertAdapterOfAtomicAbilityEntity.insert(_connection, (SQLiteConnection) atomicAbilityEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertOrReplaceAll$lambda$0(AtomicAbilityDao_Impl atomicAbilityDao_Impl, List list, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        atomicAbilityDao_Impl.__insertAdapterOfAtomicAbilityEntity.insert(_connection, list);
        return r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object count(c<? super Integer> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new f(24), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object deleteAll(c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new f(23), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object deleteByPackageName(String str, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new R3.c(str, 5), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object deleteByPackageNameExceptFunctionNames(String str, List<String> list, c<? super r> cVar) {
        StringBuilder sbV = b.v("DELETE FROM t_atomic_ability WHERE packageName = ? AND functionName NOT IN (");
        StringUtil.appendPlaceholders(sbV, list.size());
        sbV.append(")");
        String string = sbV.toString();
        k.e(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new R3.k(string, str, list, 0), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object deleteByToolName(String str, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new R3.c(str, 4), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getAll(c<? super List<AtomicAbilityEntity>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new f(25), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getAllPackageNames(c<? super List<String>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new f(26), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByAbilityId(int i, c<? super AtomicAbilityEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new D6.d(i, 4), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByAppNames(List<String> list, c<? super List<AtomicAbilityEntity>> cVar) {
        StringBuilder sbV = b.v("SELECT * FROM t_atomic_ability WHERE appName IN (");
        StringUtil.appendPlaceholders(sbV, list.size());
        sbV.append(")");
        String string = sbV.toString();
        k.e(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new R3.b(4, string, list), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByFunctionName(String str, c<? super AtomicAbilityEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new R3.c(str, 3), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByPackageAndFunction(String str, String str2, c<? super AtomicAbilityEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new l(0, str, str2), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByPackageName(String str, c<? super List<AtomicAbilityEntity>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new R3.c(str, 1), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object getByToolName(String str, c<? super AtomicAbilityEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new R3.c(str, 2), cVar);
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object insertOrReplace(AtomicAbilityEntity atomicAbilityEntity, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new R3.b(6, this, atomicAbilityEntity), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AtomicAbilityDao
    public Object insertOrReplaceAll(List<AtomicAbilityEntity> list, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new R3.b(5, this, list), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }
}
