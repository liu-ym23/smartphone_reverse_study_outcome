package com.tmall.wireless.tangram.core.resolver;

import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.TangramBuilder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ClassResolver<T> extends BaseResolver<Class<? extends T>, T> {
    private static final String TAG = "ClassResolver";

    public static final class TypeNotFoundException extends RuntimeException {
        public TypeNotFoundException(String r10) {
            super(r10);
        }
    }

    public ClassResolver() {
    }

    @Override // com.tmall.wireless.tangram.core.resolver.Resolver
    public T create(int r10) {
        Class r11 = (Class) this.mSparseArray.get(r10);
        if (r11 == null) goto L15;
        return (T) r11.newInstance();
    L6:
        e = move-exception;
        if (TangramBuilder.isPrintLog() == false) goto L16;
        i.c(TAG, e.getMessage(), e);
        return null;
    L16:
        return null;
    L10:
        e = move-exception;
        if (TangramBuilder.isPrintLog() == false) goto L23;
        i.c(TAG, e.getMessage(), e);
        return null;
    L23:
        return null;
    L15:
        if (TangramBuilder.isPrintLog() == true) goto L19;
        return null;
    L19:
        throw new TypeNotFoundException("Can not find type: " + r10 + " in ClassResolver");
    }
}
