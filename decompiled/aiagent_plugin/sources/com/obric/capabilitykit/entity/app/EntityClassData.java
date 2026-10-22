package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityClassData<T extends AppEntity> {
    private final Class<T> clazz;
    private final b<Parcel, T> parcelConstructor;
    private final int version;

    public EntityClassData(Class<T> r3, int r4, b<? super Parcel, ? extends T> r5) {
        b<Parcel, T> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "clazz");
        o.e(r6, "parcelConstructor");
        this.clazz = r3;
        this.version = r4;
        this.parcelConstructor = r6;
    }

    public final Class<T> getClazz() {
        return this.clazz;
    }

    public final b<Parcel, T> getParcelConstructor() {
        return this.parcelConstructor;
    }

    public final int getVersion() {
        return this.version;
    }
}
