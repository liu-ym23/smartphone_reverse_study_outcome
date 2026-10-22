package com.uxsense.file;

import S7.k;
import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class JsonFileOperatorKt$removeJsonItem$removed$1 implements k {
    final /* synthetic */ k $predicate;

    public JsonFileOperatorKt$removeJsonItem$removed$1(k kVar) {
        this.$predicate = kVar;
    }

    @Override // S7.k
    public final Boolean invoke(T t9) {
        return (Boolean) this.$predicate.invoke(t9);
    }

    @Override // S7.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((JsonFileOperatorKt$removeJsonItem$removed$1) obj);
    }
}
