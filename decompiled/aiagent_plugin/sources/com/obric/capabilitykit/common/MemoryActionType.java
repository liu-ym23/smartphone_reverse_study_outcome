package com.obric.capabilitykit.common;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryActionType {
    public static final MemoryActionType INSTANCE = null;
    public static final int MEMORY_ACTION_TYPE_ADD_CONTACT = 64;
    public static final int MEMORY_ACTION_TYPE_ADD_NOTE = 32;
    public static final int MEMORY_ACTION_TYPE_ADD_SCHEDULE = 2048;
    public static final int MEMORY_ACTION_TYPE_ADD_TODO = 1;
    public static final int MEMORY_ACTION_TYPE_CHOOSE_ADDRESS_OR_PHONE = 256;
    public static final int MEMORY_ACTION_TYPE_CHOOSE_CONTACT = 128;
    public static final int MEMORY_ACTION_TYPE_DELETE_TODO = 8;
    public static final int MEMORY_ACTION_TYPE_FINISH_TODO = 16;
    public static final int MEMORY_ACTION_TYPE_LIST_CONTACT = 2048;
    public static final int MEMORY_ACTION_TYPE_LIST_NOTE = 512;
    public static final int MEMORY_ACTION_TYPE_LIST_TODO = 2;
    public static final int MEMORY_ACTION_TYPE_UPDATE_CONTACT = 1024;
    public static final int MEMORY_ACTION_TYPE_UPDATE_TODO = 4;

    static {
        INSTANCE = new MemoryActionType();
    }

    private MemoryActionType() {
    }
}
