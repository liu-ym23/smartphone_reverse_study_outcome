package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum LogLevel implements InterfaceC0974o1 {
    LOG_LEVEL_UNSPECIFIED(0),
    LOG_LEVEL_DEBUG(1),
    LOG_LEVEL_INFO(2),
    LOG_LEVEL_WARN(3),
    LOG_LEVEL_ERROR(4),
    LOG_LEVEL_OFF(5),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4264a;

    LogLevel(int i6) {
        this.f4264a = i6;
    }

    public static LogLevel a(int i6) {
        if (i6 == 0) {
            return LOG_LEVEL_UNSPECIFIED;
        }
        if (i6 == 1) {
            return LOG_LEVEL_DEBUG;
        }
        if (i6 == 2) {
            return LOG_LEVEL_INFO;
        }
        if (i6 == 3) {
            return LOG_LEVEL_WARN;
        }
        if (i6 == 4) {
            return LOG_LEVEL_ERROR;
        }
        if (i6 != 5) {
            return null;
        }
        return LOG_LEVEL_OFF;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4264a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
