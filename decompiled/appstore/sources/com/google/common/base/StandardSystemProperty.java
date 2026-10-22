package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final enum StandardSystemProperty extends Enum<StandardSystemProperty> {
    private static final /* synthetic */ StandardSystemProperty[] $VALUES = null;
    public static final StandardSystemProperty FILE_SEPARATOR = null;
    public static final StandardSystemProperty JAVA_CLASS_PATH = null;
    public static final StandardSystemProperty JAVA_CLASS_VERSION = null;
    public static final StandardSystemProperty JAVA_COMPILER = null;
    public static final StandardSystemProperty JAVA_EXT_DIRS = null;
    public static final StandardSystemProperty JAVA_HOME = null;
    public static final StandardSystemProperty JAVA_IO_TMPDIR = null;
    public static final StandardSystemProperty JAVA_LIBRARY_PATH = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VENDOR = null;
    public static final StandardSystemProperty JAVA_VENDOR_URL = null;
    public static final StandardSystemProperty JAVA_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_VERSION = null;
    public static final StandardSystemProperty LINE_SEPARATOR = null;
    public static final StandardSystemProperty OS_ARCH = null;
    public static final StandardSystemProperty OS_NAME = null;
    public static final StandardSystemProperty OS_VERSION = null;
    public static final StandardSystemProperty PATH_SEPARATOR = null;
    public static final StandardSystemProperty USER_DIR = null;
    public static final StandardSystemProperty USER_HOME = null;
    public static final StandardSystemProperty USER_NAME = null;
    private final String key;

    static {
        StandardSystemProperty r10 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VERSION = r10;
        StandardSystemProperty r11 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR = r11;
        StandardSystemProperty r12 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_VENDOR_URL = r12;
        StandardSystemProperty r13 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_HOME = r13;
        StandardSystemProperty r14 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VERSION = r14;
        StandardSystemProperty r15 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VENDOR = r15;
        StandardSystemProperty r16 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_SPECIFICATION_NAME = r16;
        StandardSystemProperty r17 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VERSION = r17;
        StandardSystemProperty r18 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_VENDOR = r18;
        StandardSystemProperty r19 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_VM_NAME = r19;
        StandardSystemProperty r110 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VERSION = r110;
        StandardSystemProperty r111 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        JAVA_SPECIFICATION_VENDOR = r111;
        StandardSystemProperty r112 = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_SPECIFICATION_NAME = r112;
        StandardSystemProperty r20 = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        JAVA_CLASS_VERSION = r20;
        StandardSystemProperty r21 = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_CLASS_PATH = r21;
        StandardSystemProperty r22 = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        JAVA_LIBRARY_PATH = r22;
        StandardSystemProperty r23 = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_IO_TMPDIR = r23;
        StandardSystemProperty r24 = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        JAVA_COMPILER = r24;
        StandardSystemProperty r25 = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        JAVA_EXT_DIRS = r25;
        StandardSystemProperty r26 = new StandardSystemProperty("OS_NAME", 19, "os.name");
        OS_NAME = r26;
        StandardSystemProperty r27 = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_ARCH = r27;
        StandardSystemProperty r28 = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        OS_VERSION = r28;
        StandardSystemProperty r29 = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        FILE_SEPARATOR = r29;
        StandardSystemProperty r30 = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        PATH_SEPARATOR = r30;
        StandardSystemProperty r31 = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        LINE_SEPARATOR = r31;
        StandardSystemProperty r32 = new StandardSystemProperty("USER_NAME", 25, "user.name");
        USER_NAME = r32;
        StandardSystemProperty r33 = new StandardSystemProperty("USER_HOME", 26, "user.home");
        USER_HOME = r33;
        StandardSystemProperty r34 = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        USER_DIR = r34;
        $VALUES = new StandardSystemProperty[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
    }

    private StandardSystemProperty(String r10, int r11, String r12) {
        super(r10, r11);
        this.key = r12;
    }

    public static StandardSystemProperty valueOf(String r10) {
        return (StandardSystemProperty) Enum.valueOf(StandardSystemProperty.class, r10);
    }

    public static StandardSystemProperty[] values() {
        return (StandardSystemProperty[]) $VALUES.clone();
    }

    public String key() {
        return this.key;
    }

    @Override // java.lang.Enum
    public String toString() {
        return key() + "=" + value();
    }

    @NullableDecl
    public String value() {
        return System.getProperty(this.key);
    }
}
