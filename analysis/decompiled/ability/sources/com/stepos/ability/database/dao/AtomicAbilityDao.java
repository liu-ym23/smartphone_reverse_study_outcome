package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H§@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0010\u0010\u000eJ&\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H§@¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0014\u0010\u000eJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0016\u0010\u000eJ\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0017H§@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001b\u0010\u000eJ\"\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H§@¢\u0006\u0004\b!\u0010\u0007J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H§@¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0005H§@¢\u0006\u0004\b#\u0010\u001fJ\u0010\u0010$\u001a\u00020\u0017H§@¢\u0006\u0004\b$\u0010\u001f¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/database/dao/AtomicAbilityDao;", "", "", "Lcom/stepos/ability/database/entity/AtomicAbilityEntity;", "entities", "LC7/r;", "insertOrReplaceAll", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "entity", "insertOrReplace", "(Lcom/stepos/ability/database/entity/AtomicAbilityEntity;LH7/c;)Ljava/lang/Object;", "", "toolName", "deleteByToolName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "packageName", "deleteByPackageName", "functionNames", "deleteByPackageNameExceptFunctionNames", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "getByToolName", "functionName", "getByFunctionName", "", "abilityId", "getByAbilityId", "(ILH7/c;)Ljava/lang/Object;", "getByPackageName", "getByPackageAndFunction", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getAll", "(LH7/c;)Ljava/lang/Object;", "appNames", "getByAppNames", "getAllPackageNames", "deleteAll", "count", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AtomicAbilityDao {
    @Query("SELECT COUNT(*) FROM t_atomic_ability")
    Object count(c<? super Integer> cVar);

    @Query("DELETE FROM t_atomic_ability")
    Object deleteAll(c<? super r> cVar);

    @Query("DELETE FROM t_atomic_ability WHERE packageName = :packageName")
    Object deleteByPackageName(String str, c<? super r> cVar);

    @Query("DELETE FROM t_atomic_ability WHERE packageName = :packageName AND functionName NOT IN (:functionNames)")
    Object deleteByPackageNameExceptFunctionNames(String str, List<String> list, c<? super r> cVar);

    @Query("DELETE FROM t_atomic_ability WHERE toolName = :toolName")
    Object deleteByToolName(String str, c<? super r> cVar);

    @Query("SELECT * FROM t_atomic_ability")
    Object getAll(c<? super List<AtomicAbilityEntity>> cVar);

    @Query("SELECT DISTINCT packageName FROM t_atomic_ability")
    Object getAllPackageNames(c<? super List<String>> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE abilityId = :abilityId LIMIT 1")
    Object getByAbilityId(int i, c<? super AtomicAbilityEntity> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE appName IN (:appNames)")
    Object getByAppNames(List<String> list, c<? super List<AtomicAbilityEntity>> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE functionName = :functionName LIMIT 1")
    Object getByFunctionName(String str, c<? super AtomicAbilityEntity> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE packageName = :packageName AND functionName = :functionName LIMIT 1")
    Object getByPackageAndFunction(String str, String str2, c<? super AtomicAbilityEntity> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE packageName = :packageName")
    Object getByPackageName(String str, c<? super List<AtomicAbilityEntity>> cVar);

    @Query("SELECT * FROM t_atomic_ability WHERE toolName = :toolName LIMIT 1")
    Object getByToolName(String str, c<? super AtomicAbilityEntity> cVar);

    @Insert(onConflict = 1)
    Object insertOrReplace(AtomicAbilityEntity atomicAbilityEntity, c<? super r> cVar);

    @Insert(onConflict = 1)
    Object insertOrReplaceAll(List<AtomicAbilityEntity> list, c<? super r> cVar);
}
