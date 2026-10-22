package com.drakeet.multitype;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J1\u0010\b\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/drakeet/multitype/JavaClassLinker;", "T", "", "", "position", "item", "Ljava/lang/Class;", "Lcom/drakeet/multitype/c;", SlideCard.KEY_INDEX, "(ILjava/lang/Object;)Ljava/lang/Class;", "multitype"}, k = 1, mv = {1, 4, 0})
public interface JavaClassLinker<T> {
    @NotNull
    Class<? extends c> index(int r10, T r11);
}
