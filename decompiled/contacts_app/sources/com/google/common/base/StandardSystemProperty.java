package com.google.common.base;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
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

    public static StandardSystemProperty valueOf(String r1) {
        return (StandardSystemProperty) Enum.valueOf(StandardSystemProperty.class, r1);
    }

    public static StandardSystemProperty[] values() {
        return (StandardSystemProperty[]) $VALUES.clone();
    }

    static {
        StandardSystemProperty r0 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VERSION = r0;
        StandardSystemProperty r1 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR = r1;
        StandardSystemProperty r2 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_VENDOR_URL = r2;
        StandardSystemProperty r4 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_HOME = r4;
        StandardSystemProperty r6 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VERSION = r6;
        StandardSystemProperty r8 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VENDOR = r8;
        StandardSystemProperty r10 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_SPECIFICATION_NAME = r10;
        StandardSystemProperty r12 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VERSION = r12;
        StandardSystemProperty r14 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_VENDOR = r14;
        StandardSystemProperty r13 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_VM_NAME = r13;
        StandardSystemProperty r11 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VERSION = r11;
        StandardSystemProperty r9 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        JAVA_SPECIFICATION_VENDOR = r9;
        StandardSystemProperty r7 = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_SPECIFICATION_NAME = r7;
        StandardSystemProperty r5 = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        JAVA_CLASS_VERSION = r5;
        StandardSystemProperty r3 = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_CLASS_PATH = r3;
        StandardSystemProperty r15 = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        JAVA_LIBRARY_PATH = r15;
        StandardSystemProperty r16 = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_IO_TMPDIR = r16;
        StandardSystemProperty r17 = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        JAVA_COMPILER = r17;
        StandardSystemProperty r18 = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        JAVA_EXT_DIRS = r18;
        StandardSystemProperty r19 = new StandardSystemProperty("OS_NAME", 19, "os.name");
        OS_NAME = r19;
        StandardSystemProperty r20 = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_ARCH = r20;
        StandardSystemProperty r21 = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        OS_VERSION = r21;
        StandardSystemProperty r22 = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        FILE_SEPARATOR = r22;
        StandardSystemProperty r23 = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        PATH_SEPARATOR = r23;
        StandardSystemProperty r24 = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        LINE_SEPARATOR = r24;
        StandardSystemProperty r25 = new StandardSystemProperty("USER_NAME", 25, "user.name");
        USER_NAME = r25;
        StandardSystemProperty r26 = new StandardSystemProperty("USER_HOME", 26, "user.home");
        USER_HOME = r26;
        StandardSystemProperty r27 = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        USER_DIR = r27;
        $VALUES = new StandardSystemProperty[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    private StandardSystemProperty(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }

    public String key() {
        return this.key;
    }

    @Nullable
    public String value() {
        return System.getProperty(this.key);
    }

    @Override // java.lang.Enum
    public String toString() {
        return key() + "=" + value();
    }
}
