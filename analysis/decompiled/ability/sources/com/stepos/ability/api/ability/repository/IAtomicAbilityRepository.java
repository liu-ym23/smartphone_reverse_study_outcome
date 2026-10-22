package com.stepos.ability.api.ability.repository;

import H7.c;
import S7.a;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/ability/repository/IAtomicAbilityRepository;", "", "", "LJ3/a;", "getAll", "(LH7/c;)Ljava/lang/Object;", "", "toolName", "getByToolName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "abilityId", "getByAbilityId", "(ILH7/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "LC7/r;", "listener", "addOnDataChangedListener", "(LS7/a;)V", "removeOnDataChangedListener", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAtomicAbilityRepository {
    void addOnDataChangedListener(a listener);

    Object getAll(c<? super List<J3.a>> cVar);

    Object getByAbilityId(int i, c<? super J3.a> cVar);

    Object getByToolName(String str, c<? super J3.a> cVar);

    void removeOnDataChangedListener(a listener);
}
