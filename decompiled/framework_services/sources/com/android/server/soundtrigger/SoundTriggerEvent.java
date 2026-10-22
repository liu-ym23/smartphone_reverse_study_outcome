package com.android.server.soundtrigger;

import android.util.Slog;
import com.android.server.utils.EventLogger;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SoundTriggerEvent extends EventLogger.Event {

    public static class ServiceEvent extends SoundTriggerEvent {
        private final String mErrorString;
        private final String mPackageName;
        private final Type mType;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type ATTACH = null;
            public static final Type DETACH = null;
            public static final Type LIST_MODULE = null;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{ATTACH, LIST_MODULE, DETACH};
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            public static Type valueOf(String name) {
                return (Type) Enum.valueOf(Type.class, name);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            static {
                ATTACH = new Type("ATTACH", 0);
                LIST_MODULE = new Type("LIST_MODULE", 1);
                DETACH = new Type("DETACH", 2);
                $VALUES = $values();
            }
        }

        public ServiceEvent(Type type) {
            this(type, null, null);
        }

        public ServiceEvent(Type type, String packageName) {
            this(type, packageName, null);
        }

        public ServiceEvent(Type type, String packageName, String errorString) {
            this.mType = type;
            this.mPackageName = packageName;
            this.mErrorString = errorString;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder res = new StringBuilder(String.format("%-12s", new Object[]{this.mType.name()}));
            if (this.mErrorString == null) goto L6;
            res.append(" ERROR: ");
            res.append(this.mErrorString);
        L6:
            if (this.mPackageName == null) goto L9;
            res.append(" for: ");
            res.append(this.mPackageName);
        L9:
            return res.toString();
        }
    }

    public static class SessionEvent extends SoundTriggerEvent {
        private final String mErrorString;
        private final UUID mModelUuid;
        private final Type mType;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type DELETE_MODEL = null;
            public static final Type DETACH = null;
            public static final Type GET_MODEL_STATE = null;
            public static final Type GET_MODULE_PROPERTIES = null;
            public static final Type LOAD_MODEL = null;
            public static final Type MODULE_DIED = null;
            public static final Type PAUSE = null;
            public static final Type PAUSE_FAILED = null;
            public static final Type RECOGNITION = null;
            public static final Type RESOURCES_AVAILABLE = null;
            public static final Type RESUME = null;
            public static final Type RESUME_FAILED = null;
            public static final Type SET_PARAMETER = null;
            public static final Type START_RECOGNITION = null;
            public static final Type START_RECOGNITION_SERVICE = null;
            public static final Type STOP_RECOGNITION = null;
            public static final Type STOP_RECOGNITION_SERVICE = null;
            public static final Type UNLOAD_MODEL = null;
            public static final Type UPDATE_MODEL = null;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{START_RECOGNITION, STOP_RECOGNITION, LOAD_MODEL, UNLOAD_MODEL, UPDATE_MODEL, DELETE_MODEL, START_RECOGNITION_SERVICE, STOP_RECOGNITION_SERVICE, GET_MODEL_STATE, SET_PARAMETER, GET_MODULE_PROPERTIES, DETACH, RECOGNITION, RESUME, RESUME_FAILED, PAUSE, PAUSE_FAILED, RESOURCES_AVAILABLE, MODULE_DIED};
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            public static Type valueOf(String name) {
                return (Type) Enum.valueOf(Type.class, name);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            static {
                START_RECOGNITION = new Type("START_RECOGNITION", 0);
                STOP_RECOGNITION = new Type("STOP_RECOGNITION", 1);
                LOAD_MODEL = new Type("LOAD_MODEL", 2);
                UNLOAD_MODEL = new Type("UNLOAD_MODEL", 3);
                UPDATE_MODEL = new Type("UPDATE_MODEL", 4);
                DELETE_MODEL = new Type("DELETE_MODEL", 5);
                START_RECOGNITION_SERVICE = new Type("START_RECOGNITION_SERVICE", 6);
                STOP_RECOGNITION_SERVICE = new Type("STOP_RECOGNITION_SERVICE", 7);
                GET_MODEL_STATE = new Type("GET_MODEL_STATE", 8);
                SET_PARAMETER = new Type("SET_PARAMETER", 9);
                GET_MODULE_PROPERTIES = new Type("GET_MODULE_PROPERTIES", 10);
                DETACH = new Type("DETACH", 11);
                RECOGNITION = new Type("RECOGNITION", 12);
                RESUME = new Type("RESUME", 13);
                RESUME_FAILED = new Type("RESUME_FAILED", 14);
                PAUSE = new Type("PAUSE", 15);
                PAUSE_FAILED = new Type("PAUSE_FAILED", 16);
                RESOURCES_AVAILABLE = new Type("RESOURCES_AVAILABLE", 17);
                MODULE_DIED = new Type("MODULE_DIED", 18);
                $VALUES = $values();
            }
        }

        public SessionEvent(Type type, UUID modelUuid, String errorString) {
            this.mType = type;
            this.mModelUuid = modelUuid;
            this.mErrorString = errorString;
        }

        public SessionEvent(Type type, UUID modelUuid) {
            this(type, modelUuid, null);
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder res = new StringBuilder(String.format("%-25s", new Object[]{this.mType.name()}));
            if (this.mErrorString == null) goto L6;
            res.append(" ERROR: ");
            res.append(this.mErrorString);
        L6:
            if (this.mModelUuid == null) goto L9;
            res.append(" for: ");
            res.append(this.mModelUuid);
        L9:
            return res.toString();
        }
    }

    public SoundTriggerEvent() {
    }

    @Override // com.android.server.utils.EventLogger.Event
    public EventLogger.Event printLog(int type, String tag) {
        switch(type) {
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L3;
        };
    L3:
        Slog.v(tag, eventToString());
    L7:
        return this;
    L4:
        Slog.w(tag, eventToString());
        goto L7
    L5:
        Slog.e(tag, eventToString());
        goto L7
    L6:
        Slog.i(tag, eventToString());
        goto L7
    }
}
