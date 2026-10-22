package com.stepos.ability.database.repository;

import S3.b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class RepositoryInit_Factory implements InterfaceC2137b {
    public static RepositoryInit_Factory create() {
        return b.f1174a;
    }

    public static RepositoryInit newInstance() {
        return new RepositoryInit();
    }

    @Override // javax.inject.Provider
    public RepositoryInit get() {
        return newInstance();
    }
}
