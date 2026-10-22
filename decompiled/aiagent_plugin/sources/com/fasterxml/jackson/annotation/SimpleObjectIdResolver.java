package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleObjectIdResolver implements ObjectIdResolver {
    protected Map<ObjectIdGenerator.IdKey, Object> _items;

    public SimpleObjectIdResolver() {
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public void bindItem(ObjectIdGenerator.IdKey r2, Object r3) {
        Map<ObjectIdGenerator.IdKey, Object> r0 = this._items;
        if (r0 != null) goto L5;
        this._items = new HashMap();
    L11:
        this._items.put(r2, r3);
        return;
    L5:
        Object r1 = r0.get(r2);
        if (r1 == null) goto L11;
        if (r1 != r3) goto L10;
        return;
    L10:
        throw new IllegalStateException("Already had POJO for id (" + r2.key.getClass().getName() + ") [" + r2 + "]");
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public Object resolveId(ObjectIdGenerator.IdKey r1) {
        Map<ObjectIdGenerator.IdKey, Object> r0 = this._items;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(r1);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public boolean canUseFor(ObjectIdResolver r3) {
        if (((ObjectIdResolver) ZeusTransformUtils.wrapperContextForParams(r3, ObjectIdResolver.class, "com.obric.aiagent.plugin")).getClass() != getClass()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public ObjectIdResolver newForDeserialization(Object r1) {
        return new SimpleObjectIdResolver();
    }
}
