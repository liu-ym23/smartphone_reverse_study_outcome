package com.jeffmony.async.future;

import androidx.appcompat.widget.p;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class Converter$Converters<F, T> extends Converter$EnsureHashMap<b, Converter$ConverterTransformers<F, T>> {
    public Converter$Converters() {
    }

    private static <F, T> void add(Converter$ConverterTransformers<F, T> r10, Converter$ConverterTransformers<F, T> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        r10.putAll(r11);
    }

    public Converter$ConverterTransformers<F, T> getAll(b r10) {
        Converter$ConverterTransformers<F, T> r11 = new Converter$ConverterTransformers();
        Iterator<b> r12 = keySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return r11;
    L5:
        p.a(r12.next());
        throw null;
    }

    @Override // com.jeffmony.async.future.Converter$EnsureHashMap
    public /* bridge */ /* synthetic */ Object makeDefault() {
        return makeDefault();
    }

    @Override // com.jeffmony.async.future.Converter$EnsureHashMap
    public Converter$ConverterTransformers makeDefault() {
        return new Converter$ConverterTransformers();
    }
}
