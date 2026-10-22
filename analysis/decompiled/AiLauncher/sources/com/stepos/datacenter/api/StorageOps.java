package com.stepos.datacenter.api;

import Ua.C1056g;
import Ua.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.entity.BaseEntity;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/api/StorageOps;", "", "<init>", "()V", "Lcom/stepos/datacenter/entity/BaseEntity;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/datacenter/api/DataCenter;", "inst", "Ljava/lang/Class;", "entityClass", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/datacenter/api/DataCenter;Ljava/lang/Class;Le9/c;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StorageOps {

    /* renamed from: a, reason: collision with root package name */
    public static final StorageOps f29894a = new StorageOps();

    public final <T extends BaseEntity> Object a(DataCenter dataCenter, Class<T> cls, InterfaceC4014c<? super Long> interfaceC4014c) {
        return C1056g.j(Y.b(), new StorageOps$clearTable$2(cls, dataCenter, null), interfaceC4014c);
    }
}
