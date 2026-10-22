package com.stepos.alphame.persona.data.config;

import b3.InterfaceC0379h;
import ch.qos.logback.core.joran.action.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H¦@¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/alphame/persona/data/config/IConfigRepository;", "", "Value", "", Action.KEY_ATTRIBUTE, "defaultValue", "getData", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "", "setData", "(Ljava/lang/String;Ljava/lang/Object;)V", "saveData", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lb3/h;", "readData", "(Ljava/lang/String;Ljava/lang/Object;)Lb3/h;", "clearData", "()V", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public interface IConfigRepository {
    void clearData();

    <Value> Value getData(@NotNull String key, Value defaultValue);

    @NotNull
    <Value> InterfaceC0379h readData(@NotNull String key, Value defaultValue);

    @Nullable
    <Value> Object saveData(@NotNull String str, Value value, @NotNull Continuation<? super Unit> continuation);

    <Value> void setData(@NotNull String key, Value value);
}
