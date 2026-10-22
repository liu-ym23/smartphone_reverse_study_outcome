package com.stepos.cloud.securedata;

import j7.a;
import kotlin.Metadata;
import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/SecureDataEnvironment;", "", "<init>", "(Ljava/lang/String;I)V", "TEST", "PROD", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecureDataEnvironment {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ SecureDataEnvironment[] $VALUES;
    public static final SecureDataEnvironment TEST = new SecureDataEnvironment("TEST", 0);
    public static final SecureDataEnvironment PROD = new SecureDataEnvironment("PROD", 1);

    private static final /* synthetic */ SecureDataEnvironment[] $values() {
        return new SecureDataEnvironment[]{TEST, PROD};
    }

    static {
        SecureDataEnvironment[] secureDataEnvironmentArr$values = $values();
        $VALUES = secureDataEnvironmentArr$values;
        $ENTRIES = e0.s(secureDataEnvironmentArr$values);
    }

    private SecureDataEnvironment(String str, int i2) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static SecureDataEnvironment valueOf(String str) {
        return (SecureDataEnvironment) Enum.valueOf(SecureDataEnvironment.class, str);
    }

    public static SecureDataEnvironment[] values() {
        return (SecureDataEnvironment[]) $VALUES.clone();
    }
}
