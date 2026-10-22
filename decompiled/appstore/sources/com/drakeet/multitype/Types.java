package com.drakeet.multitype;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH&¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\r2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH&¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/drakeet/multitype/Types;", "", "T", "Lcom/drakeet/multitype/d;", "type", "", "register", "(Lcom/drakeet/multitype/d;)V", "Ljava/lang/Class;", "clazz", "", "unregister", "(Ljava/lang/Class;)Z", "", SlideCard.KEY_INDEX, "getType", "(I)Lcom/drakeet/multitype/d;", "firstIndexOf", "(Ljava/lang/Class;)I", "getSize", "()I", "size", "multitype"}, k = 1, mv = {1, 4, 0})
public interface Types {
    int firstIndexOf(@NotNull Class<?> r10);

    int getSize();

    @NotNull
    <T> d getType(int r10);

    <T> void register(@NotNull d r10);

    boolean unregister(@NotNull Class<?> r10);
}
